package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f67021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ConnectivityMonitor.ConnectivityListener f67022b;

    DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f67021a = context.getApplicationContext();
        this.f67022b = connectivityListener;
    }

    private void a() {
        SingletonConnectivityReceiver.a(this.f67021a).d(this.f67022b);
    }

    private void d() {
        SingletonConnectivityReceiver.a(this.f67021a).e(this.f67022b);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        d();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }
}
