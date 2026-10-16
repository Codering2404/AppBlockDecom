package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.o9;
import com.applovin.impl.sb;
import com.applovin.impl.sdk.j;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f57870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f57871b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o9 f57872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private sb f57873d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, sb sbVar, j jVar) {
        this.f57873d = sbVar;
        this.f57870a = jVar;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        sb sbVar = this.f57873d;
        if (sbVar != null) {
            sbVar.a();
            this.f57873d = null;
        }
        o9 o9Var = this.f57872c;
        if (o9Var != null) {
            o9Var.f();
            this.f57872c.t();
            this.f57872c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        o9 o9Var = this.f57872c;
        if (o9Var != null) {
            o9Var.u();
            this.f57872c.x();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        o9 o9Var;
        if (this.f57871b.getAndSet(false) || (o9Var = this.f57872c) == null) {
            return;
        }
        o9Var.v();
        this.f57872c.a(0L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        o9 o9Var = this.f57872c;
        if (o9Var != null) {
            o9Var.w();
        }
    }

    public void setPresenter(o9 o9Var) {
        this.f57872c = o9Var;
    }
}
