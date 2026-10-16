package com.google.android.play.core.integrity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class as extends com.google.android.play.integrity.internal.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f82986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.google.android.play.integrity.internal.ae f82987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f82988c = new com.google.android.play.integrity.internal.s("RequestDialogCallbackImpl");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f82989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f82990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Activity f82991f;

    as(Context context, k kVar, Activity activity, TaskCompletionSource taskCompletionSource, com.google.android.play.integrity.internal.ae aeVar) {
        this.f82989d = context.getPackageName();
        this.f82990e = kVar;
        this.f82986a = taskCompletionSource;
        this.f82991f = activity;
        this.f82987b = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.r
    public final void b(Bundle bundle) {
        this.f82987b.v(this.f82986a);
        this.f82988c.d("onRequestDialog(%s)", this.f82989d);
        ApiException apiExceptionA = this.f82990e.a(bundle);
        if (apiExceptionA != null) {
            this.f82986a.trySetException(apiExceptionA);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        if (pendingIntent == null) {
            this.f82988c.b("onRequestDialog(%s): got null dialog intent", this.f82989d);
            this.f82986a.trySetResult(0);
            return;
        }
        Intent intent = new Intent(this.f82991f, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", pendingIntent);
        intent.setFlags(536870912);
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ar(this, this.f82987b.c()));
        this.f82988c.a("Starting dialog intent...", new Object[0]);
        this.f82991f.startActivityForResult(intent, 0);
    }
}
