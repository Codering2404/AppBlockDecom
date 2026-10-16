package com.bumptech.glide.manager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ApplicationLifecycle implements Lifecycle {
    ApplicationLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void c(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(LifecycleListener lifecycleListener) {
    }
}
