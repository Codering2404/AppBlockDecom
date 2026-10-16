package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzaj;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Polyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzaj f73213a;

    public Polyline(zzaj zzajVar) {
        this.f73213a = (zzaj) Preconditions.m(zzajVar);
    }

    public void a() {
        try {
            this.f73213a.zzp();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(boolean z2) {
        try {
            this.f73213a.zzq(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(int i3) {
        try {
            this.f73213a.zzr(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(Cap cap) {
        Preconditions.n(cap, "endCap must not be null");
        try {
            this.f73213a.zzs(cap);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(boolean z2) {
        try {
            this.f73213a.zzt(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f73213a.zzD(((Polyline) obj).f73213a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(int i3) {
        try {
            this.f73213a.zzu(i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(List list) {
        try {
            this.f73213a.zzv(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(List list) {
        Preconditions.n(list, "points must not be null");
        try {
            this.f73213a.zzw(list);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73213a.zzh();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(Cap cap) {
        Preconditions.n(cap, "startCap must not be null");
        try {
            this.f73213a.zzy(cap);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(Object obj) {
        try {
            this.f73213a.zzz(ObjectWrapper.i5(obj));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void k(boolean z2) {
        try {
            this.f73213a.zzA(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void l(float f3) {
        try {
            this.f73213a.zzB(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void m(float f3) {
        try {
            this.f73213a.zzC(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
