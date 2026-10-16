package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzag implements Continuation<GetTokenResult, Task<Void>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ActionCodeSettings f88028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f88029b;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) {
        return FirebaseAuth.getInstance(this.f88029b.J2()).n(this.f88028a, (String) Preconditions.m(task.getResult().c()));
    }
}
