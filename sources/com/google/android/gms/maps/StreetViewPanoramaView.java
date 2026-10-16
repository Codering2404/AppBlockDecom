package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanoramaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzat f73112a;

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super((Context) Preconditions.n(context, "context must not be null"));
        this.f73112a = new zzat(this, context, streetViewPanoramaOptions);
    }

    public void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        Preconditions.n(onStreetViewPanoramaReadyCallback, "callback must not be null");
        Preconditions.f("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f73112a.v(onStreetViewPanoramaReadyCallback);
    }

    public final void b(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f73112a.d(bundle);
            if (this.f73112a.b() == null) {
                DeferredLifecycleHelper.o(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() {
        this.f73112a.f();
    }

    public final void d() {
        this.f73112a.i();
    }

    public final void e() {
        this.f73112a.j();
    }

    public void f() {
        this.f73112a.k();
    }

    public void g() {
        this.f73112a.m();
    }

    public void h() {
        this.f73112a.n();
    }
}
