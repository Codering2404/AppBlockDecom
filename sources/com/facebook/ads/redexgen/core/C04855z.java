package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04855z {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public byte[] A04;
    public byte[] A05;
    public int[] A06;
    public int[] A07;
    public final MediaCodec.CryptoInfo A08 = new MediaCodec.CryptoInfo();
    public final C04845y A09;

    public C04855z() {
        this.A09 = C5C.A02 >= 24 ? new C04845y(this.A08) : null;
    }

    public final MediaCodec.CryptoInfo A00() {
        return this.A08;
    }

    public final void A01(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.A06 == null) {
            this.A06 = new int[1];
            this.A08.numBytesOfClearData = this.A06;
        }
        int[] iArr = this.A06;
        iArr[0] = iArr[0] + i3;
    }

    public final void A02(int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i4, int i5, int i6) {
        this.A03 = i3;
        this.A06 = iArr;
        this.A07 = iArr2;
        this.A05 = bArr;
        this.A04 = bArr2;
        this.A02 = i4;
        this.A01 = i5;
        this.A00 = i6;
        this.A08.numSubSamples = i3;
        this.A08.numBytesOfClearData = iArr;
        this.A08.numBytesOfEncryptedData = iArr2;
        this.A08.key = bArr;
        this.A08.iv = bArr2;
        this.A08.mode = i4;
        if (C5C.A02 >= 24) {
            ((C04845y) AbstractC04323y.A01(this.A09)).A00(i5, i6);
        }
    }
}
