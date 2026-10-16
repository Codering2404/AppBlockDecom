package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaf extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f73285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected OnDelegateCreatedListener f73286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f73287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f73288h = new ArrayList();

    zzaf(Fragment fragment) {
        this.f73285e = fragment;
    }

    static /* synthetic */ void v(zzaf zzafVar, Activity activity) {
        zzafVar.f73287g = activity;
        zzafVar.w();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73286f = onDelegateCreatedListener;
        w();
    }

    public final void w() {
        if (this.f73287g == null || this.f73286f == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73287g);
            IMapFragmentDelegate iMapFragmentDelegateZzf = zzcc.a(this.f73287g, null).zzf(ObjectWrapper.i5(this.f73287g));
            if (iMapFragmentDelegateZzf == null) {
                return;
            }
            this.f73286f.a(new zzae(this.f73285e, iMapFragmentDelegateZzf));
            Iterator it = this.f73288h.iterator();
            while (it.hasNext()) {
                ((zzae) b()).a((OnMapReadyCallback) it.next());
            }
            this.f73288h.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
