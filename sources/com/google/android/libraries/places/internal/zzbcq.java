package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbcq extends zzbcu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final byte[] f76023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f76024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f76025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f76026h;

    zzbcq(int i3) {
        super(null);
        if (i3 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i3, 20)];
        this.f76023e = bArr;
        this.f76024f = bArr.length;
    }

    final void D(byte b3) {
        byte[] bArr = this.f76023e;
        int i3 = this.f76025g;
        bArr[i3] = b3;
        this.f76025g = i3 + 1;
        this.f76026h++;
    }

    final void E(int i3) {
        if (!zzbcu.f76032c) {
            while ((i3 & (-128)) != 0) {
                byte[] bArr = this.f76023e;
                int i4 = this.f76025g;
                this.f76025g = i4 + 1;
                bArr[i4] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.f76026h++;
                i3 >>>= 7;
            }
            byte[] bArr2 = this.f76023e;
            int i5 = this.f76025g;
            this.f76025g = i5 + 1;
            bArr2[i5] = (byte) i3;
            this.f76026h++;
            return;
        }
        long j3 = this.f76025g;
        while ((i3 & (-128)) != 0) {
            byte[] bArr3 = this.f76023e;
            int i6 = this.f76025g;
            this.f76025g = i6 + 1;
            zzbgf.u(bArr3, i6, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            i3 >>>= 7;
        }
        byte[] bArr4 = this.f76023e;
        int i7 = this.f76025g;
        this.f76025g = i7 + 1;
        zzbgf.u(bArr4, i7, (byte) i3);
        this.f76026h += (int) (((long) this.f76025g) - j3);
    }

    final void F(long j3) {
        if (zzbcu.f76032c) {
            long j4 = this.f76025g;
            while (true) {
                int i3 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr = this.f76023e;
                    int i4 = this.f76025g;
                    this.f76025g = i4 + 1;
                    zzbgf.u(bArr, i4, (byte) i3);
                    this.f76026h += (int) (((long) this.f76025g) - j4);
                    return;
                }
                byte[] bArr2 = this.f76023e;
                int i5 = this.f76025g;
                this.f76025g = i5 + 1;
                zzbgf.u(bArr2, i5, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
        } else {
            while (true) {
                int i6 = (int) j3;
                if ((j3 & (-128)) == 0) {
                    byte[] bArr3 = this.f76023e;
                    int i7 = this.f76025g;
                    this.f76025g = i7 + 1;
                    bArr3[i7] = (byte) i6;
                    this.f76026h++;
                    return;
                }
                byte[] bArr4 = this.f76023e;
                int i8 = this.f76025g;
                this.f76025g = i8 + 1;
                bArr4[i8] = (byte) (i6 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                this.f76026h++;
                j3 >>>= 7;
            }
        }
    }

    final void G(int i3) {
        int i4 = this.f76025g;
        byte[] bArr = this.f76023e;
        bArr[i4] = (byte) i3;
        bArr[i4 + 1] = (byte) (i3 >> 8);
        bArr[i4 + 2] = (byte) (i3 >> 16);
        bArr[i4 + 3] = (byte) (i3 >> 24);
        this.f76025g = i4 + 4;
        this.f76026h += 4;
    }

    final void H(long j3) {
        int i3 = this.f76025g;
        byte[] bArr = this.f76023e;
        bArr[i3] = (byte) j3;
        bArr[i3 + 1] = (byte) (j3 >> 8);
        bArr[i3 + 2] = (byte) (j3 >> 16);
        bArr[i3 + 3] = (byte) (j3 >> 24);
        bArr[i3 + 4] = (byte) (j3 >> 32);
        bArr[i3 + 5] = (byte) (j3 >> 40);
        bArr[i3 + 6] = (byte) (j3 >> 48);
        bArr[i3 + 7] = (byte) (j3 >> 56);
        this.f76025g = i3 + 8;
        this.f76026h += 8;
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final int m() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
}
