package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC1588fk {
    void A9d();

    boolean A9q();

    boolean A9r();

    boolean AAc();

    void AGr(boolean z2, int i3);

    void AK1(int i3);

    void AK6(EnumC1535et enumC1535et, int i3);

    void AKF(int i3);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    EnumC1535et getStartReason();

    EnumC1590fm getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i3);

    void setBackgroundPlaybackEnabled(boolean z2);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z2);

    void setRequestedVolume(float f3);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(InterfaceC1591fn interfaceC1591fn);

    void setup(Uri uri);
}
