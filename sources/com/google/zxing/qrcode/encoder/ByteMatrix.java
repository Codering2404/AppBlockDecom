package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ByteMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f92090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f92091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f92092c;

    public ByteMatrix(int i3, int i4) {
        this.f92090a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i4, i3);
        this.f92091b = i3;
        this.f92092c = i4;
    }

    public void a(byte b3) {
        for (byte[] bArr : this.f92090a) {
            Arrays.fill(bArr, b3);
        }
    }

    public byte b(int i3, int i4) {
        return this.f92090a[i4][i3];
    }

    public byte[][] c() {
        return this.f92090a;
    }

    public int d() {
        return this.f92092c;
    }

    public int e() {
        return this.f92091b;
    }

    public void f(int i3, int i4, int i5) {
        this.f92090a[i4][i3] = (byte) i5;
    }

    public void g(int i3, int i4, boolean z2) {
        this.f92090a[i4][i3] = z2 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f92091b * 2 * this.f92092c) + 2);
        for (int i3 = 0; i3 < this.f92092c; i3++) {
            byte[] bArr = this.f92090a[i3];
            for (int i4 = 0; i4 < this.f92091b; i4++) {
                byte b3 = bArr[i4];
                if (b3 == 0) {
                    sb.append(" 0");
                } else if (b3 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
