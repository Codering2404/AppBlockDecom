package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzae implements MapLifecycleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f73283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IMapFragmentDelegate f73284b;

    public zzae(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
        this.f73284b = (IMapFragmentDelegate) Preconditions.m(iMapFragmentDelegate);
        this.f73283a = (Fragment) Preconditions.m(fragment);
    }

    public final void a(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f73284b.s(new zzad(this, onMapReadyCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void d() {
        try {
            this.f73284b.d();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
        try {
            Bundle bundle3 = new Bundle();
            zzcb.b(bundle2, bundle3);
            this.f73284b.e3(ObjectWrapper.i5(activity), googleMapOptions, bundle3);
            zzcb.b(bundle3, bundle2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            IObjectWrapper iObjectWrapperT = this.f73284b.t(ObjectWrapper.i5(layoutInflater), ObjectWrapper.i5(viewGroup), bundle2);
            zzcb.b(bundle2, bundle);
            return (View) ObjectWrapper.h5(iObjectWrapperT);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onCreate(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            Bundle arguments = this.f73283a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzcb.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f73284b.onCreate(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f73284b.onDestroy();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f73284b.onLowMemory();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f73284b.onPause();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f73284b.onResume();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73284b.onSaveInstanceState(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStart() {
        try {
            this.f73284b.onStart();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStop() {
        try {
            this.f73284b.onStop();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
