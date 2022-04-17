package com.example.myplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myplayer.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class MainActivity : AppCompatActivity() {
    companion object {
        const val URL_VIDEO_DICODING =
            "https://github.com/dicodingacademy/assets/releases/download/release-video/VideoDicoding.mp4"
        const val URL_AUDIO =
            "https://github.com/dicodingacademy/assets/raw/main/android_intermediate_academy/bensound_ukulele.mp3"
    }

    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val player = ExoPlayer.Builder(this).build()
        viewBinding.videoView.player = player

        val anotherMediaItem = MediaItem.fromUri(URL_AUDIO)
        val mediaItem = MediaItem.fromUri(URL_VIDEO_DICODING)
        player.setMediaItem(mediaItem)
        player.addMediaItem(anotherMediaItem)
        player.prepare()
    }
}