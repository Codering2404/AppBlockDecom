package com.facebook.ads.redexgen.core;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1548f6 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C04253r A00;

    public C1548f6(C04253r c04253r) {
        this.A00 = c04253r;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i3) {
        new Handler(Looper.getMainLooper()).post(new C0660Dl(this, i3));
    }
}
