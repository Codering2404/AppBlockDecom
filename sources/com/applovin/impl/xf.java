package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f64971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f64972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f64973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f64974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f64975e;

    public xf(int i3, int i4) {
        this.f64971a = i3;
        byte[] bArr = new byte[i4 + 3];
        this.f64974d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i3, int i4) {
        if (this.f64972b) {
            int i5 = i4 - i3;
            byte[] bArr2 = this.f64974d;
            int length = bArr2.length;
            int i6 = this.f64975e + i5;
            if (length < i6) {
                this.f64974d = Arrays.copyOf(bArr2, i6 * 2);
            }
            System.arraycopy(bArr, i3, this.f64974d, this.f64975e, i5);
            this.f64975e += i5;
        }
    }

    public void b() {
        this.f64972b = false;
        this.f64973c = false;
    }

    public void b(int i3) {
        b1.b(!this.f64972b);
        boolean z2 = i3 == this.f64971a;
        this.f64972b = z2;
        if (z2) {
            this.f64975e = 3;
            this.f64973c = false;
        }
    }

    public boolean a(int i3) {
        if (!this.f64972b) {
            return false;
        }
        this.f64975e -= i3;
        this.f64972b = false;
        this.f64973c = true;
        return true;
    }

    public boolean a() {
        return this.f64973c;
    }
}
