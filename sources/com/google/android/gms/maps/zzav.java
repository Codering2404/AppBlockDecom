package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzav implements MapLifecycleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f73319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IMapFragmentDelegate f73320b;

    public zzav(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
        this.f73320b = (IMapFragmentDelegate) Preconditions.m(iMapFragmentDelegate);
        this.f73319a = (Fragment) Preconditions.m(fragment);
    }

    public final void a(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f73320b.s(new zzau(this, onMapReadyCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void d() {
        try {
            this.f73320b.d();
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
            this.f73320b.e3(ObjectWrapper.i5(activity), googleMapOptions, bundle3);
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
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
            try {
                IObjectWrapper iObjectWrapperT = this.f73320b.t(ObjectWrapper.i5(layoutInflater), ObjectWrapper.i5(viewGroup), bundle2);
                StrictMode.setThreadPolicy(threadPolicy);
                zzcb.b(bundle2, bundle);
                return (View) ObjectWrapper.h5(iObjectWrapperT);
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onCreate(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            Bundle arguments = this.f73319a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzcb.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f73320b.onCreate(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f73320b.onDestroy();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f73320b.onLowMemory();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f73320b.onPause();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f73320b.onResume();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73320b.onSaveInstanceState(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStart() {
        try {
            this.f73320b.onStart();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStop() {
        try {
            this.f73320b.onStop();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
