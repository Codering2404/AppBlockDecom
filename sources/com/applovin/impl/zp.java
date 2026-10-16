package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f65480d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f65481a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f65482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65483c;

    public static long a(byte[] bArr, int i3, boolean z2) {
        long j3 = ((long) bArr[0]) & 255;
        if (z2) {
            j3 &= ~f65480d[i3 - 1];
        }
        for (int i4 = 1; i4 < i3; i4++) {
            j3 = (j3 << 8) | (((long) bArr[i4]) & 255);
        }
        return j3;
    }

    public void b() {
        this.f65482b = 0;
        this.f65483c = 0;
    }

    public int a() {
        return this.f65483c;
    }

    public static int a(int i3) {
        long j3;
        int i4 = 0;
        do {
            long[] jArr = f65480d;
            if (i4 >= jArr.length) {
                return -1;
            }
            j3 = jArr[i4] & ((long) i3);
            i4++;
        } while (j3 == 0);
        return i4;
    }

    public long a(k8 k8Var, boolean z2, boolean z3, int i3) {
        if (this.f65482b == 0) {
            if (!k8Var.a(this.f65481a, 0, 1, z2)) {
                return -1L;
            }
            int iA = a(this.f65481a[0] & 255);
            this.f65483c = iA;
            if (iA != -1) {
                this.f65482b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i4 = this.f65483c;
        if (i4 > i3) {
            this.f65482b = 0;
            return -2L;
        }
        if (i4 != 1) {
            k8Var.d(this.f65481a, 1, i4 - 1);
        }
        this.f65482b = 0;
        return a(this.f65481a, this.f65483c, z3);
    }
}
