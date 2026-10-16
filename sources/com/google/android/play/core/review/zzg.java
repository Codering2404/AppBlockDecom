package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzg extends com.google.android.play.core.review.internal.zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.play.core.review.internal.zzi f83150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskCompletionSource f83151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzi f83152c;

    zzg(zzi zziVar, com.google.android.play.core.review.internal.zzi zziVar2, TaskCompletionSource taskCompletionSource) {
        this.f83152c = zziVar;
        this.f83150a = zziVar2;
        this.f83151b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.review.internal.zzh
    public void zzb(Bundle bundle) {
        zzt zztVar = this.f83152c.f83154a;
        if (zztVar != null) {
            zztVar.u(this.f83151b);
        }
        this.f83150a.c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
