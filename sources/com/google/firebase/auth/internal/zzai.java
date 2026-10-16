package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzai implements Continuation<GetTokenResult, Task<MultiFactorSession>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaj f87860a;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) {
        return !task.isSuccessful() ? Tasks.forException((Exception) Preconditions.m(task.getException())) : Tasks.forResult(zzam.M(task.getResult().c(), this.f87860a.f87861a));
    }
}
