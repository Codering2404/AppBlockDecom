package com.google.android.gms.dynamic;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaa implements OnDelegateCreatedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f72379a;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f72379a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f72379a.f72372a = lifecycleDelegate;
        Iterator it = this.f72379a.f72374c.iterator();
        while (it.hasNext()) {
            ((zah) it.next()).b(this.f72379a.f72372a);
        }
        this.f72379a.f72374c.clear();
        this.f72379a.f72373b = null;
    }
}
