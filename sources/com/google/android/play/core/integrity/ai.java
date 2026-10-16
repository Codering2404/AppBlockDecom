package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ai extends com.google.android.play.integrity.internal.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj f82965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f82966b = new com.google.android.play.integrity.internal.s("OnRequestIntegrityTokenCallback");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f82967c;

    ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.f82965a = ajVar;
        this.f82967c = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.p
    public final void b(Bundle bundle) {
        this.f82965a.f82968a.v(this.f82967c);
        this.f82966b.d("onRequestIntegrityToken", new Object[0]);
        ApiException apiExceptionA = this.f82965a.f82972e.a(bundle);
        if (apiExceptionA != null) {
            this.f82967c.trySetException(apiExceptionA);
            return;
        }
        String string = bundle.getString(AccessToken.TOKEN_KEY);
        if (string == null) {
            this.f82967c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        ah ahVar = new ah(this, this.f82965a.f82970c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.f82967c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
