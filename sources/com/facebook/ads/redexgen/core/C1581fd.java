package com.facebook.ads.redexgen.core;

import android.widget.MediaController;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1581fd implements MediaController.MediaPlayerControl {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC0648Cz A00;

    public C1581fd(TextureViewSurfaceTextureListenerC0648Cz textureViewSurfaceTextureListenerC0648Cz) {
        this.A00 = textureViewSurfaceTextureListenerC0648Cz;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        if (this.A00.A0C != null) {
            return this.A00.A0C.A04();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.A00.A0C != null) {
            return this.A00.A0C.A05();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.A00.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.A00.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.A00.A0C != null && this.A00.A0C.A0J();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        if (this.A00.A0F != null) {
            this.A00.A0F.AEo();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i3) {
        this.A00.seekTo(i3);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (this.A00.A0F != null) {
            this.A00.A0F.AEp();
        }
    }
}
