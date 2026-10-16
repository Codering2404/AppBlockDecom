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
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzao implements StreetViewLifecycleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f73303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IStreetViewPanoramaFragmentDelegate f73304b;

    public zzao(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
        this.f73304b = (IStreetViewPanoramaFragmentDelegate) Preconditions.m(iStreetViewPanoramaFragmentDelegate);
        this.f73303a = (Fragment) Preconditions.m(fragment);
    }

    public final void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f73304b.B(new zzan(this, onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void d() {
        try {
            this.f73304b.d();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            Bundle bundle3 = new Bundle();
            zzcb.b(bundle2, bundle3);
            this.f73304b.u3(ObjectWrapper.i5(activity), null, bundle3);
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
            IObjectWrapper iObjectWrapperT = this.f73304b.t(ObjectWrapper.i5(layoutInflater), ObjectWrapper.i5(viewGroup), bundle2);
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
            Bundle arguments = this.f73303a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzcb.c(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f73304b.onCreate(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f73304b.onDestroy();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f73304b.onLowMemory();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f73304b.onPause();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f73304b.onResume();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73304b.onSaveInstanceState(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStart() {
        try {
            this.f73304b.onStart();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStop() {
        try {
            this.f73304b.onStop();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
