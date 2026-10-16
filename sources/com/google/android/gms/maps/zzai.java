package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzai extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f73293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f73294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected OnDelegateCreatedListener f73295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GoogleMapOptions f73296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f73297i = new ArrayList();

    zzai(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.f73293e = viewGroup;
        this.f73294f = context;
        this.f73296h = googleMapOptions;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73295g = onDelegateCreatedListener;
        w();
    }

    public final void v(OnMapReadyCallback onMapReadyCallback) {
        if (b() != null) {
            ((zzah) b()).a(onMapReadyCallback);
        } else {
            this.f73297i.add(onMapReadyCallback);
        }
    }

    public final void w() {
        if (this.f73295g == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73294f);
            IMapViewDelegate iMapViewDelegateF4 = zzcc.a(this.f73294f, null).f4(ObjectWrapper.i5(this.f73294f), this.f73296h);
            if (iMapViewDelegateF4 == null) {
                return;
            }
            this.f73295g.a(new zzah(this.f73293e, iMapViewDelegateF4));
            Iterator it = this.f73297i.iterator();
            while (it.hasNext()) {
                ((zzah) b()).a((OnMapReadyCallback) it.next());
            }
            this.f73297i.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
