package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class GroundOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzr f73147a;

    public GroundOverlay(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.f73147a = (com.google.android.gms.internal.maps.zzr) Preconditions.m(zzrVar);
    }

    public void a() {
        try {
            this.f73147a.zzn();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(float f3) {
        try {
            this.f73147a.zzo(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(boolean z2) {
        try {
            this.f73147a.zzp(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(float f3) {
        try {
            this.f73147a.zzq(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(float f3, float f4) {
        try {
            this.f73147a.zzr(f3, f4);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.f73147a.zzz(((GroundOverlay) obj).f73147a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(BitmapDescriptor bitmapDescriptor) {
        Preconditions.n(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.f73147a.zzs(bitmapDescriptor.a());
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(LatLng latLng) {
        try {
            this.f73147a.zzt(latLng);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(LatLngBounds latLngBounds) {
        try {
            this.f73147a.zzu(latLngBounds);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73147a.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(Object obj) {
        try {
            this.f73147a.zzv(ObjectWrapper.i5(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(float f3) {
        try {
            this.f73147a.zzw(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void k(boolean z2) {
        try {
            this.f73147a.zzx(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void l(float f3) {
        try {
            this.f73147a.zzy(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
