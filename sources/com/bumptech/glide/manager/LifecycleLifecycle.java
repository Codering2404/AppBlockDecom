package com.bumptech.glide.manager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class LifecycleLifecycle implements Lifecycle, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f67029a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.Lifecycle f67030b;

    LifecycleLifecycle(androidx.lifecycle.Lifecycle lifecycle) {
        this.f67030b = lifecycle;
        lifecycle.addObserver(this);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void a(LifecycleListener lifecycleListener) {
        this.f67029a.remove(lifecycleListener);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void c(LifecycleListener lifecycleListener) {
        this.f67029a.add(lifecycleListener);
        if (this.f67030b.getCurrentState() == Lifecycle.State.f39947a) {
            lifecycleListener.onDestroy();
        } else if (this.f67030b.getCurrentState().b(Lifecycle.State.f39950d)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.k(this.f67029a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.k(this.f67029a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.k(this.f67029a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }
}
