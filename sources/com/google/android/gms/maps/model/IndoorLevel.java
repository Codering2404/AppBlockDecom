package com.google.android.gms.maps.model;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class IndoorLevel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.zzx f73162a;

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.f73162a.zzh(((IndoorLevel) obj).f73162a);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public int hashCode() {
        try {
            return this.f73162a.zzd();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
