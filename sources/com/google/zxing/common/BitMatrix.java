package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BitMatrix implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f91785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f91787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f91788d;

    public BitMatrix(int i3) {
        this(i3, i3);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f91786b * (this.f91785a + 1));
        for (int i3 = 0; i3 < this.f91786b; i3++) {
            for (int i4 = 0; i4 < this.f91785a; i4++) {
                sb.append(e(i4, i3) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f91788d.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f91788d[i3] = 0;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitMatrix clone() {
        return new BitMatrix(this.f91785a, this.f91786b, this.f91787c, (int[]) this.f91788d.clone());
    }

    public boolean e(int i3, int i4) {
        return ((this.f91788d[(i4 * this.f91787c) + (i3 / 32)] >>> (i3 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.f91785a == bitMatrix.f91785a && this.f91786b == bitMatrix.f91786b && this.f91787c == bitMatrix.f91787c && Arrays.equals(this.f91788d, bitMatrix.f91788d);
    }

    public int g() {
        return this.f91786b;
    }

    public int h() {
        return this.f91785a;
    }

    public int hashCode() {
        int i3 = this.f91785a;
        return (((((((i3 * 31) + i3) * 31) + this.f91786b) * 31) + this.f91787c) * 31) + Arrays.hashCode(this.f91788d);
    }

    public void i(int i3, int i4) {
        int i5 = (i4 * this.f91787c) + (i3 / 32);
        int[] iArr = this.f91788d;
        iArr[i5] = (1 << (i3 & 31)) | iArr[i5];
    }

    public void j(int i3, int i4, int i5, int i6) {
        if (i4 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i6 <= 0 || i5 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i7 = i5 + i3;
        int i8 = i6 + i4;
        if (i8 > this.f91786b || i7 > this.f91785a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i4 < i8) {
            int i9 = this.f91787c * i4;
            for (int i10 = i3; i10 < i7; i10++) {
                int[] iArr = this.f91788d;
                int i11 = (i10 / 32) + i9;
                iArr[i11] = iArr[i11] | (1 << (i10 & 31));
            }
            i4++;
        }
    }

    public String k(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return k("X ", "  ");
    }

    public BitMatrix(int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f91785a = i3;
        this.f91786b = i4;
        int i5 = (i3 + 31) / 32;
        this.f91787c = i5;
        this.f91788d = new int[i5 * i4];
    }

    private BitMatrix(int i3, int i4, int i5, int[] iArr) {
        this.f91785a = i3;
        this.f91786b = i4;
        this.f91787c = i5;
        this.f91788d = iArr;
    }
}
