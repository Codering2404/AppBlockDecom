package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class Marker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.google.android.gms.internal.maps.zzad f73169a;

    public Marker(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.f73169a = (com.google.android.gms.internal.maps.zzad) Preconditions.m(zzadVar);
    }

    public LatLng a() {
        try {
            return this.f73169a.zzj();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean b() {
        try {
            return this.f73169a.zzH();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c() {
        try {
            this.f73169a.zzo();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(float f3) {
        try {
            this.f73169a.zzp(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(float f3, float f4) {
        try {
            this.f73169a.zzq(f3, f4);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f73169a.zzE(((Marker) obj).f73169a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(boolean z2) {
        try {
            this.f73169a.zzr(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(boolean z2) {
        try {
            this.f73169a.zzs(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(BitmapDescriptor bitmapDescriptor) {
        try {
            if (bitmapDescriptor == null) {
                this.f73169a.zzt(null);
            } else {
                this.f73169a.zzt(bitmapDescriptor.a());
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73169a.zzg();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(float f3, float f4) {
        try {
            this.f73169a.zzv(f3, f4);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        try {
            this.f73169a.zzw(latLng);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void k(float f3) {
        try {
            this.f73169a.zzx(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void l(String str) {
        try {
            this.f73169a.zzy(str);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void m(Object obj) {
        try {
            this.f73169a.zzz(ObjectWrapper.i5(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void n(String str) {
        try {
            this.f73169a.zzA(str);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void o(boolean z2) {
        try {
            this.f73169a.zzB(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void p(float f3) {
        try {
            this.f73169a.zzC(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void q() {
        try {
            this.f73169a.zzD();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
