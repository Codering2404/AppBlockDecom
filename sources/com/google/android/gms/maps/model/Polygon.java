package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Polygon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzag f73201a;

    public Polygon(com.google.android.gms.internal.maps.zzag zzagVar) {
        this.f73201a = (com.google.android.gms.internal.maps.zzag) Preconditions.m(zzagVar);
    }

    public void a() {
        try {
            this.f73201a.zzo();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(boolean z2) {
        try {
            this.f73201a.zzp(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(int i3) {
        try {
            this.f73201a.zzq(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(boolean z2) {
        try {
            this.f73201a.zzr(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(List list) {
        try {
            this.f73201a.zzs(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.f73201a.zzB(((Polygon) obj).f73201a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(List list) {
        try {
            Preconditions.n(list, "points must not be null.");
            this.f73201a.zzt(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(int i3) {
        try {
            this.f73201a.zzu(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(int i3) {
        try {
            this.f73201a.zzv(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73201a.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(List list) {
        try {
            this.f73201a.zzw(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(float f3) {
        try {
            this.f73201a.zzx(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void k(Object obj) {
        try {
            this.f73201a.zzy(ObjectWrapper.i5(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void l(boolean z2) {
        try {
            this.f73201a.zzz(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void m(float f3) {
        try {
            this.f73201a.zzA(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
