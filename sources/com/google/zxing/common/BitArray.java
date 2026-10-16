package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BitArray implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f91783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f91784b;

    public BitArray() {
        this.f91784b = 0;
        this.f91783a = new int[1];
    }

    private void g(int i3) {
        if (i3 > (this.f91783a.length << 5)) {
            int[] iArrK = k(i3);
            int[] iArr = this.f91783a;
            System.arraycopy(iArr, 0, iArrK, 0, iArr.length);
            this.f91783a = iArrK;
        }
    }

    private static int[] k(int i3) {
        return new int[(i3 + 31) / 32];
    }

    public void a(boolean z2) {
        g(this.f91784b + 1);
        if (z2) {
            int[] iArr = this.f91783a;
            int i3 = this.f91784b;
            int i4 = i3 / 32;
            iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
        }
        this.f91784b++;
    }

    public void b(BitArray bitArray) {
        int i3 = bitArray.f91784b;
        g(this.f91784b + i3);
        for (int i4 = 0; i4 < i3; i4++) {
            a(bitArray.h(i4));
        }
    }

    public void c(int i3, int i4) {
        if (i4 < 0 || i4 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        g(this.f91784b + i4);
        while (i4 > 0) {
            boolean z2 = true;
            if (((i3 >> (i4 - 1)) & 1) != 1) {
                z2 = false;
            }
            a(z2);
            i4--;
        }
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitArray clone() {
        return new BitArray((int[]) this.f91783a.clone(), this.f91784b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.f91784b == bitArray.f91784b && Arrays.equals(this.f91783a, bitArray.f91783a);
    }

    public boolean h(int i3) {
        return ((1 << (i3 & 31)) & this.f91783a[i3 / 32]) != 0;
    }

    public int hashCode() {
        return (this.f91784b * 31) + Arrays.hashCode(this.f91783a);
    }

    public int i() {
        return this.f91784b;
    }

    public int j() {
        return (this.f91784b + 7) / 8;
    }

    public void m(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (h(i3)) {
                    i7 |= 1 << (7 - i8);
                }
                i3++;
            }
            bArr[i4 + i6] = (byte) i7;
        }
    }

    public void o(BitArray bitArray) {
        if (this.f91784b != bitArray.f91784b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f91783a;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = iArr[i3] ^ bitArray.f91783a[i3];
            i3++;
        }
    }

    public String toString() {
        int i3 = this.f91784b;
        StringBuilder sb = new StringBuilder(i3 + (i3 / 8) + 1);
        for (int i4 = 0; i4 < this.f91784b; i4++) {
            if ((i4 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(h(i4) ? 'X' : '.');
        }
        return sb.toString();
    }

    BitArray(int[] iArr, int i3) {
        this.f91783a = iArr;
        this.f91784b = i3;
    }
}
