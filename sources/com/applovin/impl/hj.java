package com.applovin.impl;

import com.applovin.impl.dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class hj implements dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gj f60208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f60209b = new ah(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f60210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f60213f;

    public hj(gj gjVar) {
        this.f60208a = gjVar;
    }

    @Override // com.applovin.impl.dp
    public void a(ah ahVar, int i3) {
        boolean z2 = (i3 & 1) != 0;
        int iD = z2 ? ahVar.d() + ahVar.w() : -1;
        if (this.f60213f) {
            if (!z2) {
                return;
            }
            this.f60213f = false;
            ahVar.f(iD);
            this.f60211d = 0;
        }
        while (ahVar.a() > 0) {
            int i4 = this.f60211d;
            if (i4 < 3) {
                if (i4 == 0) {
                    int iW = ahVar.w();
                    ahVar.f(ahVar.d() - 1);
                    if (iW == 255) {
                        this.f60213f = true;
                        return;
                    }
                }
                int iMin = Math.min(ahVar.a(), 3 - this.f60211d);
                ahVar.a(this.f60209b.c(), this.f60211d, iMin);
                int i5 = this.f60211d + iMin;
                this.f60211d = i5;
                if (i5 == 3) {
                    this.f60209b.f(0);
                    this.f60209b.e(3);
                    this.f60209b.g(1);
                    int iW2 = this.f60209b.w();
                    int iW3 = this.f60209b.w();
                    this.f60212e = (iW2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    this.f60210c = (((iW2 & 15) << 8) | iW3) + 3;
                    int iB = this.f60209b.b();
                    int i6 = this.f60210c;
                    if (iB < i6) {
                        this.f60209b.a(Math.min(4098, Math.max(i6, this.f60209b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(ahVar.a(), this.f60210c - this.f60211d);
                ahVar.a(this.f60209b.c(), this.f60211d, iMin2);
                int i7 = this.f60211d + iMin2;
                this.f60211d = i7;
                int i8 = this.f60210c;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.f60212e) {
                        this.f60209b.e(i8);
                    } else {
                        if (xp.a(this.f60209b.c(), 0, this.f60210c, -1) != 0) {
                            this.f60213f = true;
                            return;
                        }
                        this.f60209b.e(this.f60210c - 4);
                    }
                    this.f60209b.f(0);
                    this.f60208a.a(this.f60209b);
                    this.f60211d = 0;
                }
            }
        }
    }

    @Override // com.applovin.impl.dp
    public void a(ho hoVar, l8 l8Var, dp.d dVar) {
        this.f60208a.a(hoVar, l8Var, dVar);
        this.f60213f = true;
    }

    @Override // com.applovin.impl.dp
    public void a() {
        this.f60213f = true;
    }
}
