package androidx.media3.common.util;

import com.google.errorprone.annotations.CheckReturnValue;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public final class ParsableBitArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f41576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f41577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f41579d;

    public ParsableBitArray() {
        this.f41576a = Util.f41614f;
    }

    private void a() {
        int i3;
        int i4 = this.f41577b;
        Assertions.g(i4 >= 0 && (i4 < (i3 = this.f41579d) || (i4 == i3 && this.f41578c == 0)));
    }

    public int b() {
        return ((this.f41579d - this.f41577b) * 8) - this.f41578c;
    }

    public void c() {
        if (this.f41578c == 0) {
            return;
        }
        this.f41578c = 0;
        this.f41577b++;
        a();
    }

    public int d() {
        Assertions.g(this.f41578c == 0);
        return this.f41577b;
    }

    public int e() {
        return (this.f41577b * 8) + this.f41578c;
    }

    public void f(int i3, int i4) {
        if (i4 < 32) {
            i3 &= (1 << i4) - 1;
        }
        int iMin = Math.min(8 - this.f41578c, i4);
        int i5 = this.f41578c;
        int i6 = (8 - i5) - iMin;
        byte[] bArr = this.f41576a;
        int i7 = this.f41577b;
        byte b3 = (byte) (((65280 >> i5) | ((1 << i6) - 1)) & bArr[i7]);
        bArr[i7] = b3;
        int i8 = i4 - iMin;
        bArr[i7] = (byte) (b3 | ((i3 >>> i8) << i6));
        int i9 = i7 + 1;
        while (i8 > 8) {
            this.f41576a[i9] = (byte) (i3 >>> (i8 - 8));
            i8 -= 8;
            i9++;
        }
        int i10 = 8 - i8;
        byte[] bArr2 = this.f41576a;
        byte b4 = (byte) (bArr2[i9] & ((1 << i10) - 1));
        bArr2[i9] = b4;
        bArr2[i9] = (byte) (((i3 & ((1 << i8) - 1)) << i10) | b4);
        r(i4);
        a();
    }

    public boolean g() {
        boolean z2 = (this.f41576a[this.f41577b] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.f41578c)) != 0;
        q();
        return z2;
    }

    public int h(int i3) {
        int i4;
        if (i3 == 0) {
            return 0;
        }
        this.f41578c += i3;
        int i5 = 0;
        while (true) {
            i4 = this.f41578c;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.f41578c = i6;
            byte[] bArr = this.f41576a;
            int i7 = this.f41577b;
            this.f41577b = i7 + 1;
            i5 |= (bArr[i7] & 255) << i6;
        }
        byte[] bArr2 = this.f41576a;
        int i8 = this.f41577b;
        int i9 = ((-1) >>> (32 - i3)) & (i5 | ((bArr2[i8] & 255) >> (8 - i4)));
        if (i4 == 8) {
            this.f41578c = 0;
            this.f41577b = i8 + 1;
        }
        a();
        return i9;
    }

    public void i(byte[] bArr, int i3, int i4) {
        int i5 = (i4 >> 3) + i3;
        while (i3 < i5) {
            byte[] bArr2 = this.f41576a;
            int i6 = this.f41577b;
            int i7 = i6 + 1;
            this.f41577b = i7;
            byte b3 = bArr2[i6];
            int i8 = this.f41578c;
            byte b4 = (byte) (b3 << i8);
            bArr[i3] = b4;
            bArr[i3] = (byte) (((255 & bArr2[i7]) >> (8 - i8)) | b4);
            i3++;
        }
        int i9 = i4 & 7;
        if (i9 == 0) {
            return;
        }
        byte b5 = (byte) (bArr[i5] & (255 >> i9));
        bArr[i5] = b5;
        int i10 = this.f41578c;
        if (i10 + i9 > 8) {
            byte[] bArr3 = this.f41576a;
            int i11 = this.f41577b;
            this.f41577b = i11 + 1;
            bArr[i5] = (byte) (b5 | ((bArr3[i11] & 255) << i10));
            this.f41578c = i10 - 8;
        }
        int i12 = this.f41578c + i9;
        this.f41578c = i12;
        byte[] bArr4 = this.f41576a;
        int i13 = this.f41577b;
        bArr[i5] = (byte) (((byte) (((255 & bArr4[i13]) >> (8 - i12)) << (8 - i9))) | bArr[i5]);
        if (i12 == 8) {
            this.f41578c = 0;
            this.f41577b = i13 + 1;
        }
        a();
    }

    public long j(int i3) {
        return i3 <= 32 ? Util.q1(h(i3)) : Util.p1(h(i3 - 32), h(32));
    }

    public void k(byte[] bArr, int i3, int i4) {
        Assertions.g(this.f41578c == 0);
        System.arraycopy(this.f41576a, this.f41577b, bArr, i3, i4);
        this.f41577b += i4;
        a();
    }

    public String l(int i3, Charset charset) {
        byte[] bArr = new byte[i3];
        k(bArr, 0, i3);
        return new String(bArr, charset);
    }

    public void m(ParsableByteArray parsableByteArray) {
        o(parsableByteArray.e(), parsableByteArray.g());
        p(parsableByteArray.f() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i3) {
        this.f41576a = bArr;
        this.f41577b = 0;
        this.f41578c = 0;
        this.f41579d = i3;
    }

    public void p(int i3) {
        int i4 = i3 / 8;
        this.f41577b = i4;
        this.f41578c = i3 - (i4 * 8);
        a();
    }

    public void q() {
        int i3 = this.f41578c + 1;
        this.f41578c = i3;
        if (i3 == 8) {
            this.f41578c = 0;
            this.f41577b++;
        }
        a();
    }

    public void r(int i3) {
        int i4 = i3 / 8;
        int i5 = this.f41577b + i4;
        this.f41577b = i5;
        int i6 = this.f41578c + (i3 - (i4 * 8));
        this.f41578c = i6;
        if (i6 > 7) {
            this.f41577b = i5 + 1;
            this.f41578c = i6 - 8;
        }
        a();
    }

    public void s(int i3) {
        Assertions.g(this.f41578c == 0);
        this.f41577b += i3;
        a();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i3) {
        this.f41576a = bArr;
        this.f41579d = i3;
    }
}
