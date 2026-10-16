package com.google.android.gms.dynamic;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zac implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f72384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f72385b;

    zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f72385b = deferredLifecycleHelper;
        this.f72384a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int a() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void b(LifecycleDelegate lifecycleDelegate) {
        this.f72385b.f72372a.onCreate(this.f72384a);
    }
}
