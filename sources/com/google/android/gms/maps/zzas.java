package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzas implements StreetViewLifecycleDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f73310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IStreetViewPanoramaViewDelegate f73311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f73312c;

    public zzas(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
        this.f73311b = (IStreetViewPanoramaViewDelegate) Preconditions.m(iStreetViewPanoramaViewDelegate);
        this.f73310a = (ViewGroup) Preconditions.m(viewGroup);
    }

    public final void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f73311b.B(new zzar(this, onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void d() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onCreate(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73311b.onCreate(bundle2);
            zzcb.b(bundle2, bundle);
            this.f73312c = (View) ObjectWrapper.h5(this.f73311b.a());
            this.f73310a.removeAllViews();
            this.f73310a.addView(this.f73312c);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f73311b.onDestroy();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f73311b.onLowMemory();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f73311b.onPause();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f73311b.onResume();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f73311b.onSaveInstanceState(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStart() {
        try {
            this.f73311b.onStart();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onStop() {
        try {
            this.f73311b.onStop();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
