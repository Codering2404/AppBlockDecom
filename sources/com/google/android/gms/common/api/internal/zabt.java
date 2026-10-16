package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f71766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zabu f71767b;

    zabt(zabu zabuVar, ConnectionResult connectionResult) {
        this.f71767b = zabuVar;
        this.f71766a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabu zabuVar = this.f71767b;
        zabq zabqVar = (zabq) zabuVar.f71773f.f71574k.get(zabuVar.f71769b);
        if (zabqVar == null) {
            return;
        }
        if (!this.f71766a.w0()) {
            zabqVar.F(this.f71766a, null);
            return;
        }
        this.f71767b.f71772e = true;
        if (this.f71767b.f71768a.requiresSignIn()) {
            this.f71767b.i();
            return;
        }
        try {
            zabu zabuVar2 = this.f71767b;
            zabuVar2.f71768a.getRemoteService(null, zabuVar2.f71768a.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e3) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e3);
            this.f71767b.f71768a.disconnect("Failed to get service from broker.");
            zabqVar.F(new ConnectionResult(10), null);
        }
    }
}
