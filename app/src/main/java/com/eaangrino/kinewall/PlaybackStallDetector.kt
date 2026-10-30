package com.eaangrino.kinewall

/**
 * Determines whether the wallpaper has produced output while a visible,
 * prepared, actively playing MediaPlayer was being observed.
 *
 * MediaPlayer.currentPosition cannot reliably detect stalls for very short
 * looping videos: after one complete loop the clock can have the same value.
 * Rendered frame counts do not have that ambiguity.
 */
internal object PlaybackStallDetector {
    fun isStalled(startFramesPresented: Long, endFramesPresented: Long): Boolean =
        endFramesPresented <= startFramesPresented
}
