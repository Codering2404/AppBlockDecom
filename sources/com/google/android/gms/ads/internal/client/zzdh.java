package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdh implements MuteThisAdReason {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdg f69850b;

    public zzdh(zzdg zzdgVar) {
        String strZze;
        this.f69850b = zzdgVar;
        try {
            strZze = zzdgVar.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            strZze = null;
        }
        this.f69849a = strZze;
    }

    public final zzdg a() {
        return this.f69850b;
    }

    public final String toString() {
        return this.f69849a;
    }
}
