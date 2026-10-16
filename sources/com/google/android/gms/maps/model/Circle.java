package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Circle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzl f73133a;

    public Circle(com.google.android.gms.internal.maps.zzl zzlVar) {
        this.f73133a = (com.google.android.gms.internal.maps.zzl) Preconditions.m(zzlVar);
    }

    public void a() {
        try {
            this.f73133a.zzn();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(LatLng latLng) {
        try {
            Preconditions.n(latLng, "center must not be null.");
            this.f73133a.zzo(latLng);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(boolean z2) {
        try {
            this.f73133a.zzp(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(int i3) {
        try {
            this.f73133a.zzq(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(double d3) {
        try {
            this.f73133a.zzr(d3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f73133a.zzy(((Circle) obj).f73133a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(int i3) {
        try {
            this.f73133a.zzs(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(List list) {
        try {
            this.f73133a.zzt(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(float f3) {
        try {
            this.f73133a.zzu(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final int hashCode() {
        try {
            return this.f73133a.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(Object obj) {
        try {
            this.f73133a.zzv(ObjectWrapper.i5(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(boolean z2) {
        try {
            this.f73133a.zzw(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void k(float f3) {
        try {
            this.f73133a.zzx(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
