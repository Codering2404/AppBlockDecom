package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Result f71816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zada f71817b;

    zacy(zada zadaVar, Result result) {
        this.f71817b = zadaVar;
        this.f71816a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                PendingResult pendingResultB = ((ResultTransform) Preconditions.m(this.f71817b.f71820a)).b(this.f71816a);
                zada zadaVar = this.f71817b;
                zadaVar.f71827i.sendMessage(zadaVar.f71827i.obtainMessage(0, pendingResultB));
                threadLocal.set(Boolean.FALSE);
                zada zadaVar2 = this.f71817b;
                zada.p(this.f71816a);
                googleApiClient = (GoogleApiClient) this.f71817b.f71826h.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e3) {
                zada zadaVar3 = this.f71817b;
                zadaVar3.f71827i.sendMessage(zadaVar3.f71827i.obtainMessage(1, e3));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zada zadaVar4 = this.f71817b;
                zada.p(this.f71816a);
                googleApiClient = (GoogleApiClient) this.f71817b.f71826h.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.r(this.f71817b);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada zadaVar5 = this.f71817b;
            zada.p(this.f71816a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f71817b.f71826h.get();
            if (googleApiClient2 != null) {
                googleApiClient2.r(this.f71817b);
            }
            throw th;
        }
    }
}
