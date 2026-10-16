package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbct extends zzbcq {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OutputStream f76030i;

    zzbct(OutputStream outputStream, int i3) {
        super(i3);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.f76030i = outputStream;
    }

    private final void I(int i3) throws IOException {
        if (this.f76024f - this.f76025g < i3) {
            J();
        }
    }

    private final void J() throws IOException {
        this.f76030i.write(this.f76023e, 0, this.f76025g);
        this.f76025g = 0;
    }

    public final void K(String str) throws IOException {
        int iA;
        try {
            int length = str.length() * 3;
            int iB = zzbcu.B(length);
            int i3 = iB + length;
            int i4 = this.f76024f;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int iB2 = zzbgi.b(str, bArr, 0, length);
                v(iB2);
                L(bArr, 0, iB2);
                return;
            }
            if (i3 > i4 - this.f76025g) {
                J();
            }
            int iB3 = zzbcu.B(str.length());
            int i5 = this.f76025g;
            try {
                if (iB3 == iB) {
                    int i6 = i5 + iB3;
                    this.f76025g = i6;
                    int iB4 = zzbgi.b(str, this.f76023e, i6, i4 - i6);
                    this.f76025g = i5;
                    iA = (iB4 - i5) - iB3;
                    E(iA);
                    this.f76025g = iB4;
                } else {
                    iA = zzbgi.a(str);
                    E(iA);
                    this.f76025g = zzbgi.b(str, this.f76023e, this.f76025g, iA);
                }
                this.f76026h += iA;
            } catch (zzbgh e3) {
                this.f76026h -= this.f76025g - i5;
                this.f76025g = i5;
                throw e3;
            } catch (ArrayIndexOutOfBoundsException e4) {
                throw new zzbcs(e4);
            }
        } catch (zzbgh e5) {
            f(str, e5);
        }
    }

    public final void L(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.f76024f;
        int i6 = this.f76025g;
        int i7 = i5 - i6;
        if (i7 >= i4) {
            System.arraycopy(bArr, i3, this.f76023e, i6, i4);
            this.f76025g += i4;
            this.f76026h += i4;
            return;
        }
        byte[] bArr2 = this.f76023e;
        System.arraycopy(bArr, i3, bArr2, i6, i7);
        int i8 = i3 + i7;
        this.f76025g = i5;
        this.f76026h += i7;
        J();
        int i9 = i4 - i7;
        if (i9 <= i5) {
            System.arraycopy(bArr, i8, bArr2, 0, i9);
            this.f76025g = i9;
        } else {
            this.f76030i.write(bArr, i8, i9);
        }
        this.f76026h += i9;
    }

    @Override // com.google.android.libraries.places.internal.zzbcu, com.google.android.libraries.places.internal.zzbce
    public final void a(byte[] bArr, int i3, int i4) throws IOException {
        L(bArr, i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void h(int i3, int i4) throws IOException {
        v((i3 << 3) | i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void i(int i3, int i4) throws IOException {
        I(20);
        E(i3 << 3);
        if (i4 >= 0) {
            E(i4);
        } else {
            F(i4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void j(int i3, int i4) throws IOException {
        I(20);
        E(i3 << 3);
        E(i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void k(int i3, int i4) throws IOException {
        I(14);
        E((i3 << 3) | 5);
        G(i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void l(int i3, long j3) throws IOException {
        I(20);
        E(i3 << 3);
        F(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void n(int i3, long j3) throws IOException {
        I(18);
        E((i3 << 3) | 1);
        H(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void o(int i3, boolean z2) throws IOException {
        I(11);
        E(i3 << 3);
        D(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void p(int i3, String str) throws IOException {
        v((i3 << 3) | 2);
        K(str);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void q(int i3, zzbcl zzbclVar) throws IOException {
        v((i3 << 3) | 2);
        v(zzbclVar.d());
        zzbclVar.f(this);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void r(int i3, zzbex zzbexVar) throws IOException {
        v(11);
        j(2, i3);
        v(26);
        v(zzbexVar.j());
        zzbexVar.k(this);
        v(12);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void s(int i3, zzbcl zzbclVar) throws IOException {
        v(11);
        j(2, i3);
        q(3, zzbclVar);
        v(12);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void t(byte b3) throws IOException {
        if (this.f76025g == this.f76024f) {
            J();
        }
        D(b3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void u(int i3) throws IOException {
        if (i3 >= 0) {
            v(i3);
        } else {
            x(i3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void v(int i3) throws IOException {
        I(5);
        E(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void w(int i3) throws IOException {
        I(4);
        G(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void x(long j3) throws IOException {
        I(10);
        F(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void y(long j3) throws IOException {
        I(8);
        H(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbcu
    public final void z() throws IOException {
        if (this.f76025g > 0) {
            J();
        }
    }
}
