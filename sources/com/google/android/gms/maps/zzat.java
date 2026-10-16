package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzat extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f73313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f73314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected OnDelegateCreatedListener f73315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StreetViewPanoramaOptions f73316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f73317i = new ArrayList();

    zzat(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        this.f73313e = viewGroup;
        this.f73314f = context;
        this.f73316h = streetViewPanoramaOptions;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73315g = onDelegateCreatedListener;
        w();
    }

    public final void v(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (b() != null) {
            ((zzas) b()).a(onStreetViewPanoramaReadyCallback);
        } else {
            this.f73317i.add(onStreetViewPanoramaReadyCallback);
        }
    }

    public final void w() {
        if (this.f73315g == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73314f);
            this.f73315g.a(new zzas(this.f73313e, zzcc.a(this.f73314f, null).m1(ObjectWrapper.i5(this.f73314f), this.f73316h)));
            Iterator it = this.f73317i.iterator();
            while (it.hasNext()) {
                ((zzas) b()).a((OnStreetViewPanoramaReadyCallback) it.next());
            }
            this.f73317i.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
