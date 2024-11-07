package com.coopertec.subliprint

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.coopertec.subliprint.databinding.ActivityColorsPlatillaPdfactivityBinding
import com.rajat.pdfviewer.PdfViewerActivity

class ColorsTemplatePDFActivity : AppCompatActivity() {

    private lateinit var binding : ActivityColorsPlatillaPdfactivityBinding
    private var download_file_url = "http://www2.elo.utfsm.cl/~elo328/PDI13_Color.pdf"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorsPlatillaPdfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
////
//        PdfViewerActivity.launchPdfFromUrl(
//            context = this,
//            pdfUrl = "your_pdf_url_here",
//            pdfTitle = "PDF Title",
//            saveTo = PdfViewerActivity.saveTo.ASK_EVERYTIME,
//            enableDownload = true
//        )

        binding.pdfView.initWithUrl(
            url = download_file_url,
            lifecycleCoroutineScope = lifecycleScope,
            lifecycle = lifecycle
        )
    }
}