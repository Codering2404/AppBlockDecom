package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
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
final class zzaw extends DeferredLifecycleHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Fragment f73321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected OnDelegateCreatedListener f73322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Activity f73323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f73324h = new ArrayList();

    zzaw(Fragment fragment) {
        this.f73321e = fragment;
    }

    static /* synthetic */ void v(zzaw zzawVar, Activity activity) {
        zzawVar.f73323g = activity;
        zzawVar.w();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f73322f = onDelegateCreatedListener;
        w();
    }

    public final void w() {
        if (this.f73323g == null || this.f73322f == null || b() != null) {
            return;
        }
        try {
            MapsInitializer.a(this.f73323g);
            IMapFragmentDelegate iMapFragmentDelegateZzf = zzcc.a(this.f73323g, null).zzf(ObjectWrapper.i5(this.f73323g));
            if (iMapFragmentDelegateZzf == null) {
                return;
            }
            this.f73322f.a(new zzav(this.f73321e, iMapFragmentDelegateZzf));
            Iterator it = this.f73324h.iterator();
            while (it.hasNext()) {
                ((zzav) b()).a((OnMapReadyCallback) it.next());
            }
            this.f73324h.clear();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
