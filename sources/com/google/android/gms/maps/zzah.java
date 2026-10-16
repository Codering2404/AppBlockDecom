package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzah implements MapLifecycleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f73290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IMapViewDelegate f73291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f73292c;

    public zzah(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
        this.f73291b = (IMapViewDelegate) Preconditions.m(iMapViewDelegate);
        this.f73290a = (ViewGroup) Preconditions.m(viewGroup);
    }

    public final void a(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f73291b.s(new zzag(this, onMapReadyCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void d() {
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onCreate(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73291b.onCreate(bundle2);
            zzcb.b(bundle2, bundle);
            this.f73292c = (View) ObjectWrapper.h5(this.f73291b.a());
            this.f73290a.removeAllViews();
            this.f73290a.addView(this.f73292c);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f73291b.onDestroy();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f73291b.onLowMemory();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f73291b.onPause();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f73291b.onResume();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73291b.onSaveInstanceState(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStart() {
        try {
            this.f73291b.onStart();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStop() {
        try {
            this.f73291b.onStop();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
