package com.coopertec.subliprint.presentation.printHome.toolsBox.colorsTemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.coopertec.subliprint.databinding.ActivityColorsPlatillaPdfactivityBinding
import java.io.File
import java.io.FileOutputStream
import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class ColorsTemplatePDFActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColorsPlatillaPdfactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorsPlatillaPdfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.visibility = View.VISIBLE

        // Cargar el archivo PDF de `assets` en segundo plano
        lifecycleScope.launch {
            val pdfFile = withContext(Dispatchers.IO) { "template.pdf".copyPdfFromAssets() }
            pdfFile?.let {
                binding.pdfView.initWithFile(
                    file = it
                )
                delay(2000)
                binding.progressBar.visibility = View.GONE
                // Ocultar el indicador de carga cuando el PDF esté listo
            } ?: run {
                // Si no se puede cargar el archivo, también ocultar el ProgressBar
                binding.progressBar.visibility = View.GONE
                // Aquí podrías mostrar un mensaje de error si es necesario
            }
        }

        binding.tapTemplateBar.setNavigationOnClickListener {
            finish()
        }
    }


    private fun String.copyPdfFromAssets(): File? {
        return try {
            val file = File(filesDir, this)
            if (!file.exists()) {
                assets.open(this).use { inputStream ->
                    FileOutputStream(file).use { outputStream ->
                        inputStream.copyTo(outputStream)
                    }
                }
            }
            file
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
