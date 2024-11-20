package com.coopertec.subliprint.presentation.explore

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coopertec.subliprint.R
import com.coopertec.subliprint.databinding.FragmentExploreBinding
import com.coopertec.subliprint.presentation.explore.model.Post

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    private val examplePosts = listOf(
        Post(2, "Plantilla 2", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465429175_1128560878981963_2483007076064392050_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=833d8c&_nc_ohc=sEWSPs34HBgQ7kNvgHCZT-t&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOhp7xkeTbEkGyoICcNT_hd&oh=00_AYCRlBdqYsDc777XMi0hDtDy3BPKLJuJ4_EzgA6O9_gtAQ&oe=6742CCEB", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465574843_1128561722315212_3338858713394718500_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_ohc=7pvAg8o0o1QQ7kNvgGXJnpZ&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AuQJwLhrd7Dnt9sHzb4oDDq&oh=00_AYAJ80dnDFHATBVgwj42-3dVnXo-AeK71FpWrP_7afaSOA&oe=6742EB2A","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465263238_1128562398981811_6366592715746711456_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=833d8c&_nc_ohc=e56609ocuHIQ7kNvgFJVJYc&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ABfRmbG8h0OJron9M-jsZfN&oh=00_AYDXEjRLA4u46Asr4rM86drfk2145HOc2G9GuiGYVecyjQ&oe=6742FB3F")),
        Post(1, "Plantilla 1", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467735519_883279980639326_6038823214730773280_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WuvCl4f7e0QQ7kNvgF5-cqD&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=Atf7ixONub5e4TVkwRlkkpO&oh=00_AYAUgN5VkNBNwKIDd9IPMFOdXJqcGum92TsUhRXT0G6Hgg&oe=6742DC73", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467743646_883279993972658_8925666094232639973_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=VlApzwETC4MQ7kNvgEwUCI0&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOaF9CQQ4l4xJyF5qwvdea9&oh=00_AYB2KMhTfXSTXWsy0TftYIgo5tqSC_Hjxv2drb-u5p67ag&oe=6742C0EA", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467731787_883280003972657_5671449701817219769_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=3Stq5PzofZcQ7kNvgF95Aae&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AI-9TDz1iAyOgqIk8PWrp6M&oh=00_AYBMxOmb54PNbTHxg4jh-Ezn0O485bZ_toGjSCd4MuUmUQ&oe=6742F0D0")),
        Post(3, "Plantilla 3", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467638812_122145037310329926_3518321217262039393_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WyBO9daCXZ4Q7kNvgG6L8J3&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AZ-axbVaoABDA6OYR6m4t5C&oh=00_AYB-Hl7IV9kDNRzw96cHpht7tqeThUohAbTFSowebncb_g&oe=6742FA0F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467529892_122145037304329926_7384177822775145490_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=YD8_ySiFhQQQ7kNvgFWxnRn&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AfZyCghThNefc-25GKWxAWI&oh=00_AYD1lEVqCtJJnVXIyknu-v0RioeeI-YBPFThYAM9gDM8yQ&oe=6742E6AF", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467690860_122145037346329926_215410268604562917_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=G-FyeL8snxAQ7kNvgGvwkT-&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AyJzwtZn2Bqx-3rVPUJSokg&oh=00_AYDfkHBhJS0gsQjbeMoC5qflASV2FStm7eZG5HgYhH-asg&oe=6742D88F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467505999_122145037412329926_2065889912289654630_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=__SDVIlGQqcQ7kNvgFxNls8&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ANZrO15hgrNQHyAaa0nHsdI&oh=00_AYDcYr3gBWk6kmYHZc0BIWCUnSkT-onTha1GJVSQ-zQmaA&oe=6742C6CB","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467602159_122145037442329926_5038202566317185883_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=6bovXwpvt4sQ7kNvgGqdzNv&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=A6X3k35kbnMVHHfLfPuwKyk&oh=00_AYCSylfVf8UDTnKRLmqkQds_PNtyHmHV44EfZsvVRrSC_g&oe=6742FA7F")),
        Post(4, "Plantilla 2", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465429175_1128560878981963_2483007076064392050_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=833d8c&_nc_ohc=sEWSPs34HBgQ7kNvgHCZT-t&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOhp7xkeTbEkGyoICcNT_hd&oh=00_AYCRlBdqYsDc777XMi0hDtDy3BPKLJuJ4_EzgA6O9_gtAQ&oe=6742CCEB", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465574843_1128561722315212_3338858713394718500_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_ohc=7pvAg8o0o1QQ7kNvgGXJnpZ&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AuQJwLhrd7Dnt9sHzb4oDDq&oh=00_AYAJ80dnDFHATBVgwj42-3dVnXo-AeK71FpWrP_7afaSOA&oe=6742EB2A","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465263238_1128562398981811_6366592715746711456_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=833d8c&_nc_ohc=e56609ocuHIQ7kNvgFJVJYc&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ABfRmbG8h0OJron9M-jsZfN&oh=00_AYDXEjRLA4u46Asr4rM86drfk2145HOc2G9GuiGYVecyjQ&oe=6742FB3F")),
        Post(5, "Plantilla 1", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467735519_883279980639326_6038823214730773280_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WuvCl4f7e0QQ7kNvgF5-cqD&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=Atf7ixONub5e4TVkwRlkkpO&oh=00_AYAUgN5VkNBNwKIDd9IPMFOdXJqcGum92TsUhRXT0G6Hgg&oe=6742DC73", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467743646_883279993972658_8925666094232639973_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=VlApzwETC4MQ7kNvgEwUCI0&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOaF9CQQ4l4xJyF5qwvdea9&oh=00_AYB2KMhTfXSTXWsy0TftYIgo5tqSC_Hjxv2drb-u5p67ag&oe=6742C0EA", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467731787_883280003972657_5671449701817219769_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=3Stq5PzofZcQ7kNvgF95Aae&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AI-9TDz1iAyOgqIk8PWrp6M&oh=00_AYBMxOmb54PNbTHxg4jh-Ezn0O485bZ_toGjSCd4MuUmUQ&oe=6742F0D0")),
        Post(6, "Plantilla 3", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467638812_122145037310329926_3518321217262039393_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WyBO9daCXZ4Q7kNvgG6L8J3&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AZ-axbVaoABDA6OYR6m4t5C&oh=00_AYB-Hl7IV9kDNRzw96cHpht7tqeThUohAbTFSowebncb_g&oe=6742FA0F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467529892_122145037304329926_7384177822775145490_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=YD8_ySiFhQQQ7kNvgFWxnRn&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AfZyCghThNefc-25GKWxAWI&oh=00_AYD1lEVqCtJJnVXIyknu-v0RioeeI-YBPFThYAM9gDM8yQ&oe=6742E6AF", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467690860_122145037346329926_215410268604562917_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=G-FyeL8snxAQ7kNvgGvwkT-&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AyJzwtZn2Bqx-3rVPUJSokg&oh=00_AYDfkHBhJS0gsQjbeMoC5qflASV2FStm7eZG5HgYhH-asg&oe=6742D88F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467505999_122145037412329926_2065889912289654630_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=__SDVIlGQqcQ7kNvgFxNls8&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ANZrO15hgrNQHyAaa0nHsdI&oh=00_AYDcYr3gBWk6kmYHZc0BIWCUnSkT-onTha1GJVSQ-zQmaA&oe=6742C6CB","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467602159_122145037442329926_5038202566317185883_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=6bovXwpvt4sQ7kNvgGqdzNv&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=A6X3k35kbnMVHHfLfPuwKyk&oh=00_AYCSylfVf8UDTnKRLmqkQds_PNtyHmHV44EfZsvVRrSC_g&oe=6742FA7F")),
        Post(7, "Plantilla 2", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465429175_1128560878981963_2483007076064392050_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=833d8c&_nc_ohc=sEWSPs34HBgQ7kNvgHCZT-t&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOhp7xkeTbEkGyoICcNT_hd&oh=00_AYCRlBdqYsDc777XMi0hDtDy3BPKLJuJ4_EzgA6O9_gtAQ&oe=6742CCEB", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465574843_1128561722315212_3338858713394718500_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_ohc=7pvAg8o0o1QQ7kNvgGXJnpZ&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AuQJwLhrd7Dnt9sHzb4oDDq&oh=00_AYAJ80dnDFHATBVgwj42-3dVnXo-AeK71FpWrP_7afaSOA&oe=6742EB2A","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/465263238_1128562398981811_6366592715746711456_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=833d8c&_nc_ohc=e56609ocuHIQ7kNvgFJVJYc&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ABfRmbG8h0OJron9M-jsZfN&oh=00_AYDXEjRLA4u46Asr4rM86drfk2145HOc2G9GuiGYVecyjQ&oe=6742FB3F")),
        Post(8, "Plantilla 1", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467735519_883279980639326_6038823214730773280_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WuvCl4f7e0QQ7kNvgF5-cqD&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=Atf7ixONub5e4TVkwRlkkpO&oh=00_AYAUgN5VkNBNwKIDd9IPMFOdXJqcGum92TsUhRXT0G6Hgg&oe=6742DC73", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467743646_883279993972658_8925666094232639973_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=VlApzwETC4MQ7kNvgEwUCI0&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AOaF9CQQ4l4xJyF5qwvdea9&oh=00_AYB2KMhTfXSTXWsy0TftYIgo5tqSC_Hjxv2drb-u5p67ag&oe=6742C0EA", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467731787_883280003972657_5671449701817219769_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=3Stq5PzofZcQ7kNvgF95Aae&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AI-9TDz1iAyOgqIk8PWrp6M&oh=00_AYBMxOmb54PNbTHxg4jh-Ezn0O485bZ_toGjSCd4MuUmUQ&oe=6742F0D0")),
        Post(9, "Plantilla 3", listOf("https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467638812_122145037310329926_3518321217262039393_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=WyBO9daCXZ4Q7kNvgG6L8J3&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AZ-axbVaoABDA6OYR6m4t5C&oh=00_AYB-Hl7IV9kDNRzw96cHpht7tqeThUohAbTFSowebncb_g&oe=6742FA0F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467529892_122145037304329926_7384177822775145490_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=YD8_ySiFhQQQ7kNvgFWxnRn&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AfZyCghThNefc-25GKWxAWI&oh=00_AYD1lEVqCtJJnVXIyknu-v0RioeeI-YBPFThYAM9gDM8yQ&oe=6742E6AF", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467690860_122145037346329926_215410268604562917_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=G-FyeL8snxAQ7kNvgGvwkT-&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=AyJzwtZn2Bqx-3rVPUJSokg&oh=00_AYDfkHBhJS0gsQjbeMoC5qflASV2FStm7eZG5HgYhH-asg&oe=6742D88F", "https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467505999_122145037412329926_2065889912289654630_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=__SDVIlGQqcQ7kNvgFxNls8&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=ANZrO15hgrNQHyAaa0nHsdI&oh=00_AYDcYr3gBWk6kmYHZc0BIWCUnSkT-onTha1GJVSQ-zQmaA&oe=6742C6CB","https://scontent.fclq1-1.fna.fbcdn.net/v/t39.30808-6/467602159_122145037442329926_5038202566317185883_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=aa7b47&_nc_ohc=6bovXwpvt4sQ7kNvgGqdzNv&_nc_zt=23&_nc_ht=scontent.fclq1-1.fna&_nc_gid=A6X3k35kbnMVHHfLfPuwKyk&oh=00_AYCSylfVf8UDTnKRLmqkQds_PNtyHmHV44EfZsvVRrSC_g&oe=6742FA7F")),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        binding.recyclerPostsView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PostAdapter(examplePosts)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.title_text_view)
        val imagesContainer: LinearLayout = view.findViewById(R.id.images_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_card, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.titleTextView.text = post.title

        // Carga dinámica de imágenes
        holder.imagesContainer.removeAllViews()
        post.images.forEach { imageUrl ->
            val imageView = ImageView(holder.itemView.context).apply {
                layoutParams = LinearLayout.LayoutParams(140.dpToPx(), 140.dpToPx()).apply {
                    setMargins(8.dpToPx(), 0, 8.dpToPx(), 0)
                }
                scaleType = ImageView.ScaleType.CENTER_CROP
                Glide.with(this).load(imageUrl).into(this)
            }
            holder.imagesContainer.addView(imageView)
        }
    }

    override fun getItemCount(): Int = posts.size
}

// Extension para convertir dp a px
fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
