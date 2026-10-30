package com.eaangrino.kinewall

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PlaybackStallDetectorTest {
    @Test
    fun detectsAStallEvenForShortLoopingVideos() {
        assertTrue(PlaybackStallDetector.isStalled(20L, 20L))
    }

    @Test
    fun doesNotRecoverWhenOutputFramesContinueAdvancing() {
        // A loop may wrap to an identical MediaPlayer.currentPosition,
        // but the frames rendered between two samples still advanced.
        assertFalse(PlaybackStallDetector.isStalled(20L, 110L))
    }

    @Test
    fun detectsMissingInitialFrames() {
        assertTrue(PlaybackStallDetector.isStalled(0L, 0L))
    }

    @Test
    fun detectsAResetCounterAsNoProgress() {
        assertTrue(PlaybackStallDetector.isStalled(45L, 3L))
    }
}
