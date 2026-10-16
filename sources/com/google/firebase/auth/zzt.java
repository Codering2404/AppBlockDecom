package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import com.google.android.gms.internal.p002firebaseauthapi.zzaix;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzcc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzt implements Continuation<zzair, Task<TotpSecret>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88074a;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<TotpSecret> then(Task<zzair> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.m(task.getException()));
        }
        zzair result = task.getResult();
        if (result instanceof zzaix) {
            zzaix zzaixVar = (zzaix) result;
            return Tasks.forResult(new zzcc(Preconditions.g(zzaixVar.zzf()), Preconditions.g(zzaixVar.zze()), zzaixVar.zzc(), zzaixVar.zzb(), zzaixVar.zzd(), Preconditions.g(zzaixVar.zza()), this.f88074a));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + result.getClass().getName() + ".");
    }
}
