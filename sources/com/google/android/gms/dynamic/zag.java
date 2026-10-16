package com.google.android.gms.dynamic;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zag implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f72394a;

    zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f72394a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int a() {
        return 5;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void b(LifecycleDelegate lifecycleDelegate) {
        this.f72394a.f72372a.onResume();
    }
}
