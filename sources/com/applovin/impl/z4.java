package com.applovin.impl;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f65350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f65351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f65352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f65353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f65354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f65355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f65356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f65357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f65358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f65359j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f65360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f65361b;

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f65360a = cryptoInfo;
            this.f65361b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i3, int i4) {
            this.f65361b.set(i3, i4);
            this.f65360a.setPattern(this.f65361b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z4() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f65358i = cryptoInfo;
        this.f65359j = xp.f65027a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f65358i;
    }

    public void a(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.f65353d == null) {
            int[] iArr = new int[1];
            this.f65353d = iArr;
            this.f65358i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f65353d;
        iArr2[0] = iArr2[0] + i3;
    }

    public void a(int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i4, int i5, int i6) {
        this.f65355f = i3;
        this.f65353d = iArr;
        this.f65354e = iArr2;
        this.f65351b = bArr;
        this.f65350a = bArr2;
        this.f65352c = i4;
        this.f65356g = i5;
        this.f65357h = i6;
        MediaCodec.CryptoInfo cryptoInfo = this.f65358i;
        cryptoInfo.numSubSamples = i3;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i4;
        if (xp.f65027a >= 24) {
            ((b) b1.a(this.f65359j)).a(i5, i6);
        }
    }
}
