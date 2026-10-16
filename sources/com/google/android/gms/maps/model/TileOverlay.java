package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzam;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class TileOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzam f73258a;

    public TileOverlay(zzam zzamVar) {
        this.f73258a = (zzam) Preconditions.m(zzamVar);
    }

    public void a() {
        try {
            this.f73258a.zzi();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(boolean z2) {
        try {
            this.f73258a.zzj(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(float f3) {
        try {
            this.f73258a.zzk(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(boolean z2) {
        try {
            this.f73258a.zzl(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(float f3) {
        try {
            this.f73258a.zzm(f3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.f73258a.zzn(((TileOverlay) obj).f73258a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73258a.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
