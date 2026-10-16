package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zab implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f72380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f72381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bundle f72382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f72383d;

    zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f72383d = deferredLifecycleHelper;
        this.f72380a = activity;
        this.f72381b = bundle;
        this.f72382c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int a() {
        return 0;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void b(LifecycleDelegate lifecycleDelegate) {
        this.f72383d.f72372a.e(this.f72380a, this.f72381b, this.f72382c);
    }
}
