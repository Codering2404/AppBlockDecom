package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03851z {
    public final AudioAttributes A00;

    public C03851z(C2214qQ c2214qQ) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c2214qQ.A02).setFlags(c2214qQ.A03).setUsage(c2214qQ.A05);
        if (C5C.A02 >= 29) {
            C03831x.A00(usage, c2214qQ.A01);
        }
        if (C5C.A02 >= 32) {
            C03841y.A00(usage, c2214qQ.A04);
        }
        this.A00 = usage.build();
    }
}
