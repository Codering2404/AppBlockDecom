package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class IndoorBuilding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzu f73160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzh f73161b;

    public IndoorBuilding(com.google.android.gms.internal.maps.zzu zzuVar) {
        zzh zzhVar = zzh.f73278a;
        this.f73160a = (com.google.android.gms.internal.maps.zzu) Preconditions.n(zzuVar, "delegate");
        this.f73161b = (zzh) Preconditions.n(zzhVar, "shim");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.f73160a.zzh(((IndoorBuilding) obj).f73160a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73160a.zzf();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
