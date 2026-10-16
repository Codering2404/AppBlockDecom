package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
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
final class zzap extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f73305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected OnDelegateCreatedListener f73306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f73307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f73308h = new ArrayList();

    zzap(Fragment fragment) {
        this.f73305e = fragment;
    }

    static /* synthetic */ void v(zzap zzapVar, Activity activity) {
        zzapVar.f73307g = activity;
        zzapVar.w();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73306f = onDelegateCreatedListener;
        w();
    }

    public final void w() {
        if (this.f73307g == null || this.f73306f == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73307g);
            this.f73306f.a(new zzao(this.f73305e, zzcc.a(this.f73307g, null).zzh(ObjectWrapper.i5(this.f73307g))));
            Iterator it = this.f73308h.iterator();
            while (it.hasNext()) {
                ((zzao) b()).a((OnStreetViewPanoramaReadyCallback) it.next());
            }
            this.f73308h.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
