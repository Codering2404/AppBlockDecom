package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzatj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f75837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f75838d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f75839e;

    private zzatj(int i3, int i4, int i5, int i6) {
        this.f75835a = i3;
        this.f75839e = i4;
        this.f75836b = i5;
        this.f75837c = i6;
    }

    static zzatj b(int i3) {
        return new zzatj(i3, 1, 0, 0);
    }

    final void a() {
        this.f75838d = true;
    }

    final zzatj c() {
        int i3 = this.f75839e;
        Preconditions.A(!(i3 == 4), "UNDERLYING_CALL_STARTED state is terminal, cannot transition");
        if (i3 == 3) {
            return new zzatj(this.f75835a, 4, this.f75836b, this.f75837c);
        }
        if (i3 == 1 && this.f75838d) {
            int i4 = this.f75835a;
            int i5 = this.f75836b;
            return new zzatj(i4, 2, i5, i5);
        }
        int i6 = this.f75836b;
        int i7 = i6 + 1;
        int i8 = this.f75835a;
        int i9 = i7 >= i8 ? 3 : 1;
        int i10 = this.f75837c;
        if (i7 < i8) {
            i6 = i7;
        }
        return new zzatj(i8, i9, i6, i10);
    }

    final /* synthetic */ int d() {
        return this.f75835a;
    }

    final /* synthetic */ int e() {
        return this.f75836b;
    }

    final /* synthetic */ int f() {
        return this.f75837c;
    }

    final /* synthetic */ int g() {
        return this.f75839e;
    }
}
