package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
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
final class zzaz extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f73328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected OnDelegateCreatedListener f73329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f73330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f73331h = new ArrayList();

    zzaz(Fragment fragment) {
        this.f73328e = fragment;
    }

    static /* synthetic */ void v(zzaz zzazVar, Activity activity) {
        zzazVar.f73330g = activity;
        zzazVar.w();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73329f = onDelegateCreatedListener;
        w();
    }

    public final void w() {
        if (this.f73330g == null || this.f73329f == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73330g);
            this.f73329f.a(new zzay(this.f73328e, zzcc.a(this.f73330g, null).zzh(ObjectWrapper.i5(this.f73330g))));
            Iterator it = this.f73331h.iterator();
            while (it.hasNext()) {
                ((zzay) b()).a((OnStreetViewPanoramaReadyCallback) it.next());
            }
            this.f73331h.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
