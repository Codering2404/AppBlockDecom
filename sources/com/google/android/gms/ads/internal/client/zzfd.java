package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfe f69937a;

    zzfd(zzfe zzfeVar) {
        Objects.requireNonNull(zzfeVar);
        this.f69937a = zzfeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzff zzffVar = this.f69937a.f69938a;
        if (zzffVar.h5() != null) {
            try {
                zzffVar.h5().zzc(1);
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onAdFailedToLoad event.", e3);
            }
        }
    }
}
