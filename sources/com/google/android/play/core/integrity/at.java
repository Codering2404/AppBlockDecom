package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82993b;

    at(com.google.android.play.integrity.internal.an anVar, com.google.android.play.integrity.internal.an anVar2) {
        this.f82992a = anVar;
        this.f82993b = anVar2;
    }

    final as a(Activity activity, TaskCompletionSource taskCompletionSource, com.google.android.play.integrity.internal.ae aeVar) {
        Object objA = this.f82992a.a();
        objA.getClass();
        k kVar = (k) this.f82993b.a();
        kVar.getClass();
        activity.getClass();
        aeVar.getClass();
        return new as((Context) objA, kVar, activity, taskCompletionSource, aeVar);
    }
}
