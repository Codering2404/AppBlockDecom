package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class bm extends com.google.android.play.integrity.internal.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f83030f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f83030f = bnVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void a(Exception exc) {
        if (!(exc instanceof com.google.android.play.integrity.internal.af)) {
            super.a(exc);
        } else if (bn.k(this.f83030f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
