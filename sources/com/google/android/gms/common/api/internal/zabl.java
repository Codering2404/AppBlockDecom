package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabl implements BackgroundDetector.BackgroundStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f71745a;

    zabl(GoogleApiManager googleApiManager) {
        this.f71745a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z2) {
        GoogleApiManager googleApiManager = this.f71745a;
        googleApiManager.f71578o.sendMessage(googleApiManager.f71578o.obtainMessage(1, Boolean.valueOf(z2)));
    }
}
