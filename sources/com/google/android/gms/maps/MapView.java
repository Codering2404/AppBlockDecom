package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class MapView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzai f73066a;

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f73066a = new zzai(this, context, googleMapOptions);
        setClickable(true);
    }

    public void a(OnMapReadyCallback onMapReadyCallback) {
        Preconditions.f("getMapAsync() must be called on the main thread");
        Preconditions.n(onMapReadyCallback, "callback must not be null.");
        this.f73066a.v(onMapReadyCallback);
    }

    public void b(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f73066a.d(bundle);
            if (this.f73066a.b() == null) {
                DeferredLifecycleHelper.o(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() {
        this.f73066a.f();
    }

    public void d() {
        this.f73066a.i();
    }

    public void e() {
        this.f73066a.j();
    }

    public void f() {
        this.f73066a.k();
    }

    public void g() {
        this.f73066a.m();
    }

    public void h() {
        this.f73066a.n();
    }
}
