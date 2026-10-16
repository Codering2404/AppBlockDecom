package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1866kV implements C5V {
    public MP A02;
    public long A01 = 5242880;
    public int A00 = 20480;

    public final C1866kV A00(MP mp) {
        this.A02 = mp;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C5V
    public final C1865kU A5H() {
        return new C1865kU((MP) AbstractC04323y.A01(this.A02), this.A01, this.A00);
    }
}
