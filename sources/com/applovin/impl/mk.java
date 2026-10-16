package com.applovin.impl;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f61906a = new ah(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f61907b;

    private long a(k8 k8Var) {
        int i3 = 0;
        k8Var.c(this.f61906a.c(), 0, 1);
        int i4 = this.f61906a.c()[0] & 255;
        if (i4 == 0) {
            return Long.MIN_VALUE;
        }
        int i5 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i6 = 0;
        while ((i4 & i5) == 0) {
            i5 >>= 1;
            i6++;
        }
        int i7 = i4 & (~i5);
        k8Var.c(this.f61906a.c(), 1, i6);
        while (i3 < i6) {
            i3++;
            i7 = (this.f61906a.c()[i3] & 255) + (i7 << 8);
        }
        this.f61907b += i6 + 1;
        return i7;
    }

    public boolean b(k8 k8Var) {
        long jA = k8Var.a();
        long j3 = 1024;
        if (jA != -1 && jA <= 1024) {
            j3 = jA;
        }
        int i3 = (int) j3;
        k8Var.c(this.f61906a.c(), 0, 4);
        long jY = this.f61906a.y();
        this.f61907b = 4;
        while (jY != 440786851) {
            int i4 = this.f61907b + 1;
            this.f61907b = i4;
            if (i4 == i3) {
                return false;
            }
            k8Var.c(this.f61906a.c(), 0, 1);
            jY = ((jY << 8) & (-256)) | ((long) (this.f61906a.c()[0] & 255));
        }
        long jA2 = a(k8Var);
        long j4 = this.f61907b;
        if (jA2 != Long.MIN_VALUE && (jA == -1 || j4 + jA2 < jA)) {
            while (true) {
                long j5 = this.f61907b;
                long j6 = j4 + jA2;
                if (j5 < j6) {
                    if (a(k8Var) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jA3 = a(k8Var);
                    if (jA3 < 0 || jA3 > 2147483647L) {
                        break;
                    }
                    if (jA3 != 0) {
                        int i5 = (int) jA3;
                        k8Var.c(i5);
                        this.f61907b += i5;
                    }
                } else if (j5 == j6) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
