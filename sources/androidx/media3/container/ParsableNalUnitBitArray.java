package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ParsableNalUnitBitArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f41763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f41764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f41766d;

    public ParsableNalUnitBitArray(byte[] bArr, int i3, int i4) {
        j(bArr, i3, i4);
    }

    private void a() {
        int i3;
        int i4 = this.f41765c;
        Assertions.g(i4 >= 0 && (i4 < (i3 = this.f41764b) || (i4 == i3 && this.f41766d == 0)));
    }

    private int g() {
        int i3 = 0;
        while (!e()) {
            i3++;
        }
        return ((1 << i3) - 1) + (i3 > 0 ? f(i3) : 0);
    }

    private boolean k(int i3) {
        if (2 > i3 || i3 >= this.f41764b) {
            return false;
        }
        byte[] bArr = this.f41763a;
        return bArr[i3] == 3 && bArr[i3 + (-2)] == 0 && bArr[i3 - 1] == 0;
    }

    public void b() {
        int i3 = this.f41766d;
        if (i3 > 0) {
            m(8 - i3);
        }
    }

    public boolean c(int i3) {
        int i4 = this.f41765c;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        int i7 = (this.f41766d + i3) - (i5 * 8);
        if (i7 > 7) {
            i6++;
            i7 -= 8;
        }
        while (true) {
            i4++;
            if (i4 > i6 || i6 >= this.f41764b) {
                break;
            }
            if (k(i4)) {
                i6++;
                i4 += 2;
            }
        }
        int i8 = this.f41764b;
        if (i6 >= i8) {
            return i6 == i8 && i7 == 0;
        }
        return true;
    }

    public boolean d() {
        int i3 = this.f41765c;
        int i4 = this.f41766d;
        int i5 = 0;
        while (this.f41765c < this.f41764b && !e()) {
            i5++;
        }
        boolean z2 = this.f41765c == this.f41764b;
        this.f41765c = i3;
        this.f41766d = i4;
        return !z2 && c((i5 * 2) + 1);
    }

    public boolean e() {
        boolean z2 = (this.f41763a[this.f41765c] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.f41766d)) != 0;
        l();
        return z2;
    }

    public int f(int i3) {
        int i4;
        this.f41766d += i3;
        int i5 = 0;
        while (true) {
            i4 = this.f41766d;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.f41766d = i6;
            byte[] bArr = this.f41763a;
            int i7 = this.f41765c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!k(i7 + 1)) {
                i = 1;
            }
            this.f41765c = i7 + i;
        }
        byte[] bArr2 = this.f41763a;
        int i8 = this.f41765c;
        int i9 = ((-1) >>> (32 - i3)) & (i5 | ((bArr2[i8] & 255) >> (8 - i4)));
        if (i4 == 8) {
            this.f41766d = 0;
            this.f41765c = i8 + (k(i8 + 1) ? 2 : 1);
        }
        a();
        return i9;
    }

    public int h() {
        int iG = g();
        return (iG % 2 == 0 ? -1 : 1) * ((iG + 1) / 2);
    }

    public int i() {
        return g();
    }

    public void j(byte[] bArr, int i3, int i4) {
        this.f41763a = bArr;
        this.f41765c = i3;
        this.f41764b = i4;
        this.f41766d = 0;
        a();
    }

    public void l() {
        int i3 = this.f41766d + 1;
        this.f41766d = i3;
        if (i3 == 8) {
            this.f41766d = 0;
            int i4 = this.f41765c;
            this.f41765c = i4 + (k(i4 + 1) ? 2 : 1);
        }
        a();
    }

    public void m(int i3) {
        int i4 = this.f41765c;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        this.f41765c = i6;
        int i7 = this.f41766d + (i3 - (i5 * 8));
        this.f41766d = i7;
        if (i7 > 7) {
            this.f41765c = i6 + 1;
            this.f41766d = i7 - 8;
        }
        while (true) {
            i4++;
            if (i4 > this.f41765c) {
                a();
                return;
            } else if (k(i4)) {
                this.f41765c++;
                i4 += 2;
            }
        }
    }
}
