package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzak implements Continuation<AuthResult, Task<AuthResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzal f87862a;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<AuthResult> then(Task<AuthResult> task) {
        if (this.f87862a.f87866d == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult result = task.getResult();
            return Tasks.forResult(new zzz((zzaf) result.U0(), (zzx) result.b2(), this.f87862a.f87866d));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            ((FirebaseAuthUserCollisionException) exception).b(this.f87862a.f87866d);
        }
        return Tasks.forException(exception);
    }
}
