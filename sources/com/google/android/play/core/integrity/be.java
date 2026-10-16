package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class be extends com.google.android.play.integrity.internal.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f83007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f83008b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    be(bn bnVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f83008b = bnVar;
        this.f83007a = context;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        this.f83008b.f83034d.trySetResult(Integer.valueOf(com.google.android.play.integrity.internal.ai.a(this.f83007a)));
    }
}
