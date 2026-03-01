package com.fengqingyang10.findyou.utils

import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri

class RingManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    fun playRingtone() {
        // Get the default ringtone URI
        val ringtoneUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)

        // Initialize MediaPlayer with the ringtone URI
        mediaPlayer = MediaPlayer.create(context, ringtoneUri)
        mediaPlayer?.setOnCompletionListener {
            // Release the MediaPlayer when playback is complete
            releaseMediaPlayer()
        }

        // Start playback
        mediaPlayer?.start()
    }

    fun stopRingtone() {
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}