package com.squareup.okhttp.internal.framed;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Settings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f93297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f93298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f93299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f93300d = new int[10];

    void a() {
        this.f93299c = 0;
        this.f93298b = 0;
        this.f93297a = 0;
        Arrays.fill(this.f93300d, 0);
    }

    int b(int i3) {
        int i4 = h(i3) ? 2 : 0;
        return k(i3) ? i4 | 1 : i4;
    }

    int c(int i3) {
        return this.f93300d[i3];
    }

    int d() {
        if ((this.f93297a & 2) != 0) {
            return this.f93300d[1];
        }
        return -1;
    }

    int e(int i3) {
        return (this.f93297a & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? this.f93300d[7] : i3;
    }

    int f(int i3) {
        return (this.f93297a & 16) != 0 ? this.f93300d[4] : i3;
    }

    int g(int i3) {
        return (this.f93297a & 32) != 0 ? this.f93300d[5] : i3;
    }

    boolean h(int i3) {
        return ((1 << i3) & this.f93299c) != 0;
    }

    boolean i(int i3) {
        return ((1 << i3) & this.f93297a) != 0;
    }

    void j(Settings settings) {
        for (int i3 = 0; i3 < 10; i3++) {
            if (settings.i(i3)) {
                l(i3, settings.b(i3), settings.c(i3));
            }
        }
    }

    boolean k(int i3) {
        return ((1 << i3) & this.f93298b) != 0;
    }

    Settings l(int i3, int i4, int i5) {
        int[] iArr = this.f93300d;
        if (i3 >= iArr.length) {
            return this;
        }
        int i6 = 1 << i3;
        this.f93297a |= i6;
        if ((i4 & 1) != 0) {
            this.f93298b |= i6;
        } else {
            this.f93298b &= ~i6;
        }
        if ((i4 & 2) != 0) {
            this.f93299c |= i6;
        } else {
            this.f93299c &= ~i6;
        }
        iArr[i3] = i5;
        return this;
    }

    int m() {
        return Integer.bitCount(this.f93297a);
    }
}
