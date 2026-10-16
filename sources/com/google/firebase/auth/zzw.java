package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import d.qFm.sECyKyO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzw implements Continuation<GetTokenResult, Task<Void>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f88079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88080b;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.m(task.getException()));
        }
        return this.f88080b.f87745e.zza(this.f88079a, (String) Preconditions.m(task.getResult().c()), sECyKyO.ffCAGgfgijTCcr, this.f88080b.f87751k);
    }
}
