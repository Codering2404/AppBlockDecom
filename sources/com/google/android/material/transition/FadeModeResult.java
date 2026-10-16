package com.google.android.material.transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class FadeModeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f82573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f82574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f82575c;

    private FadeModeResult(int i3, int i4, boolean z2) {
        this.f82573a = i3;
        this.f82574b = i4;
        this.f82575c = z2;
    }

    static FadeModeResult a(int i3, int i4) {
        return new FadeModeResult(i3, i4, true);
    }

    static FadeModeResult b(int i3, int i4) {
        return new FadeModeResult(i3, i4, false);
    }
}
