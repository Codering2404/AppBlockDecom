package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.AccessToken;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bk extends bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f83025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f83026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f83027e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bk(bn bnVar, TaskCompletionSource taskCompletionSource, long j3) {
        super(bnVar, taskCompletionSource);
        this.f83025c = bnVar;
        this.f83026d = new com.google.android.play.integrity.internal.s("OnRequestIntegrityTokenCallback");
        this.f83027e = j3;
    }

    @Override // com.google.android.play.core.integrity.bi, com.google.android.play.integrity.internal.k
    public final void c(Bundle bundle) throws RemoteException {
        super.c(bundle);
        this.f83026d.d("onRequestExpressIntegrityToken", new Object[0]);
        ApiException apiExceptionA = this.f83025c.f83036f.a(bundle);
        if (apiExceptionA != null) {
            this.f83022a.trySetException(apiExceptionA);
            return;
        }
        bj bjVar = new bj(this, this.f83025c.f83033c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f83022a;
        b bVar = new b();
        bVar.b(bundle.getString(AccessToken.TOKEN_KEY));
        bVar.a(bjVar);
        taskCompletionSource.trySetResult(bVar.c());
    }
}
