package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0610Bk {
    public final C6 A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final DownloadRequest A07;

    public C0610Bk(DownloadRequest downloadRequest, int i3, long j3, long j4, long j5, int i4, int i5) {
        this(downloadRequest, i3, j3, j4, j5, i4, i5, new C6());
    }

    public C0610Bk(DownloadRequest downloadRequest, int i3, long j3, long j4, long j5, int i4, int i5, C6 c6) {
        AbstractC04323y.A01(c6);
        AbstractC04323y.A07((i5 == 0) == (i3 != 4));
        if (i4 != 0) {
            AbstractC04323y.A07((i3 == 2 || i3 == 0) ? false : true);
        }
        this.A07 = downloadRequest;
        this.A02 = i3;
        this.A05 = j3;
        this.A06 = j4;
        this.A04 = j5;
        this.A03 = i4;
        this.A01 = i5;
        this.A00 = c6;
    }

    public final float A00() {
        return this.A00.A00;
    }

    public final long A01() {
        return this.A00.A01;
    }

    public final boolean A02() {
        return this.A02 == 3 || this.A02 == 4;
    }
}
