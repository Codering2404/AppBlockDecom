package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfh f69940a;

    zzfg(zzfh zzfhVar) {
        Objects.requireNonNull(zzfhVar);
        this.f69940a = zzfhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfh zzfhVar = this.f69940a;
        if (zzfhVar.x3() != null) {
            try {
                zzfhVar.x3().zzc(1);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onAdFailedToLoad event.", e3);
            }
        }
    }
}
