package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzh extends zzg {
    zzh(zzi zziVar, TaskCompletionSource taskCompletionSource, String str) {
        super(zziVar, new com.google.android.play.core.review.internal.zzi("OnRequestInstallCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.review.zzg, com.google.android.play.core.review.internal.zzh
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        this.f83151b.trySetResult(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
