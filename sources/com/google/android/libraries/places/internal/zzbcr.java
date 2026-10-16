package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcr extends zzbcu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f76027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f76028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f76029g;

    zzbcr(byte[] bArr, int i3, int i4) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int i5 = i3 + i4;
        int length = bArr.length;
        if ((i3 | i4 | (length - i5)) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        this.f76027e = bArr;
        this.f76029g = i3;
        this.f76028f = i5;
    }

    public final void D(byte[] bArr, int i3, int i4) throws zzbcs {
        try {
            System.arraycopy(bArr, i3, this.f76027e, this.f76029g, i4);
            this.f76029g += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzbcs(this.f76029g, this.f76028f, i4, e3);
        }
    }

    public final void E(String str) throws zzbcs {
        int i3 = this.f76029g;
        try {
            int iB = zzbcu.B(str.length() * 3);
            int iB2 = zzbcu.B(str.length());
            if (iB2 != iB) {
                v(zzbgi.a(str));
                byte[] bArr = this.f76027e;
                int i4 = this.f76029g;
                this.f76029g = zzbgi.b(str, bArr, i4, this.f76028f - i4);
                return;
            }
            int i5 = i3 + iB2;
            this.f76029g = i5;
            int iB3 = zzbgi.b(str, this.f76027e, i5, this.f76028f - i5);
            this.f76029g = i3;
            v((iB3 - i3) - iB2);
            this.f76029g = iB3;
        } catch (zzbgh e3) {
            this.f76029g = i3;
            f(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbcs(e4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu, com.google.android.libraries.places.internal.zzbce
    public final void a(byte[] bArr, int i3, int i4) throws zzbcs {
        D(bArr, i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void h(int i3, int i4) throws zzbcs {
        v((i3 << 3) | i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void i(int i3, int i4) throws zzbcs {
        v(i3 << 3);
        u(i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void j(int i3, int i4) throws zzbcs {
        v(i3 << 3);
        v(i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void k(int i3, int i4) throws zzbcs {
        v((i3 << 3) | 5);
        w(i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void l(int i3, long j3) throws zzbcs {
        v(i3 << 3);
        x(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final int m() {
        return this.f76028f - this.f76029g;
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void n(int i3, long j3) throws zzbcs {
        v((i3 << 3) | 1);
        y(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void o(int i3, boolean z2) throws zzbcs {
        v(i3 << 3);
        t(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void p(int i3, String str) throws zzbcs {
        v((i3 << 3) | 2);
        E(str);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void q(int i3, zzbcl zzbclVar) throws zzbcs {
        v((i3 << 3) | 2);
        v(zzbclVar.d());
        zzbclVar.f(this);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void r(int i3, zzbex zzbexVar) throws zzbcs {
        v(11);
        j(2, i3);
        v(26);
        v(zzbexVar.j());
        zzbexVar.k(this);
        v(12);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void s(int i3, zzbcl zzbclVar) throws zzbcs {
        v(11);
        j(2, i3);
        q(3, zzbclVar);
        v(12);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void t(byte b3) throws zzbcs {
        int i3 = this.f76029g;
        try {
            int i4 = i3 + 1;
            try {
                this.f76027e[i3] = b3;
                this.f76029g = i4;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i3 = i4;
                throw new zzbcs(i3, this.f76028f, 1, e);
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void u(int i3) throws zzbcs {
        if (i3 >= 0) {
            v(i3);
        } else {
            x(i3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void v(int i3) throws zzbcs {
        int i4;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i5 = this.f76029g;
        while ((i3 & (-128)) != 0) {
            try {
                i4 = i5 + 1;
                try {
                    this.f76027e[i5] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i3 >>>= 7;
                    i5 = i4;
                } catch (IndexOutOfBoundsException e3) {
                    indexOutOfBoundsException = e3;
                    i5 = i4;
                    throw new zzbcs(i5, this.f76028f, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                throw new zzbcs(i5, this.f76028f, 1, indexOutOfBoundsException);
            }
        }
        i4 = i5 + 1;
        this.f76027e[i5] = (byte) i3;
        this.f76029g = i4;
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void w(int i3) throws zzbcs {
        int i4 = this.f76029g;
        try {
            byte[] bArr = this.f76027e;
            bArr[i4] = (byte) i3;
            bArr[i4 + 1] = (byte) (i3 >> 8);
            bArr[i4 + 2] = (byte) (i3 >> 16);
            bArr[i4 + 3] = (byte) (i3 >> 24);
            this.f76029g = i4 + 4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzbcs(i4, this.f76028f, 4, e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void x(long j3) throws zzbcs {
        int i3;
        IndexOutOfBoundsException indexOutOfBoundsException;
        boolean z2 = zzbcu.f76032c;
        int i4 = this.f76029g;
        if (!z2 || this.f76028f - i4 < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    int i5 = i4 + 1;
                    try {
                        this.f76027e[i4] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        j3 >>>= 7;
                        i4 = i5;
                    } catch (IndexOutOfBoundsException e3) {
                        indexOutOfBoundsException = e3;
                        i4 = i5;
                        throw new zzbcs(i4, this.f76028f, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                }
            }
            i3 = i4 + 1;
            try {
                this.f76027e[i4] = (byte) j3;
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                i4 = i3;
                throw new zzbcs(i4, this.f76028f, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j3 & (-128)) != 0) {
                zzbgf.u(this.f76027e, i4, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
                i4++;
            }
            i3 = i4 + 1;
            zzbgf.u(this.f76027e, i4, (byte) j3);
        }
        this.f76029g = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void y(long j3) throws zzbcs {
        int i3 = this.f76029g;
        try {
            byte[] bArr = this.f76027e;
            bArr[i3] = (byte) j3;
            bArr[i3 + 1] = (byte) (j3 >> 8);
            bArr[i3 + 2] = (byte) (j3 >> 16);
            bArr[i3 + 3] = (byte) (j3 >> 24);
            bArr[i3 + 4] = (byte) (j3 >> 32);
            bArr[i3 + 5] = (byte) (j3 >> 40);
            bArr[i3 + 6] = (byte) (j3 >> 48);
            bArr[i3 + 7] = (byte) (j3 >> 56);
            this.f76029g = i3 + 8;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzbcs(i3, this.f76028f, 8, e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void z() {
    }
}
