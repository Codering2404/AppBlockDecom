package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafp<ResultT, CallbackT> implements zzafg<ResultT> {
    private final zzaff<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzafp(zzaff<ResultT, CallbackT> zzaffVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzaffVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafg
    public final void zza(ResultT resultt, Status status) {
        Preconditions.n(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
            return;
        }
        zzaff<ResultT, CallbackT> zzaffVar = this.zza;
        if (zzaffVar.zzq != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzaffVar.zzc);
            zzaff<ResultT, CallbackT> zzaffVar2 = this.zza;
            taskCompletionSource.setException(zzaen.zza(firebaseAuth, zzaffVar2.zzq, ("reauthenticateWithCredential".equals(zzaffVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zzd : null));
            return;
        }
        AuthCredential authCredential = zzaffVar.zzn;
        if (authCredential != null) {
            this.zzb.setException(zzaen.zza(status, authCredential, zzaffVar.zzo, zzaffVar.zzp));
        } else {
            this.zzb.setException(zzaen.zza(status));
        }
    }
}
