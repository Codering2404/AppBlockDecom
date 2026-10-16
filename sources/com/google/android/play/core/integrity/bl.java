package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bl extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f83028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f83029d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bl(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(bnVar, taskCompletionSource);
        this.f83028c = bnVar;
        this.f83029d = new com.google.android.play.integrity.internal.s("OnWarmUpIntegrityTokenCallback");
    }

    @Override // com.google.android.play.core.integrity.bi, com.google.android.play.integrity.internal.k
    public final void e(Bundle bundle) throws RemoteException {
        super.e(bundle);
        this.f83029d.d("onWarmUpExpressIntegrityToken", new Object[0]);
        ApiException apiExceptionA = this.f83028c.f83036f.a(bundle);
        if (apiExceptionA != null) {
            this.f83022a.trySetException(apiExceptionA);
        } else {
            this.f83022a.trySetResult(Long.valueOf(bundle.getLong("warm.up.sid")));
        }
    }
}
