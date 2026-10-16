package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzade extends zzaff<AuthResult, zzl> {
    private final PhoneAuthCredential zzv;

    public zzade(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        Preconditions.n(phoneAuthCredential, "credential cannot be null");
        this.zzv = phoneAuthCredential;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "linkPhoneAuthCredential";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
        zzaf zzafVarZza = zzacq.zza(this.zzc, this.zzk);
        ((zzl) this.zze).a(this.zzj, zzafVarZza);
        zzb(new zzz(zzafVarZza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zza(new zzahz(this.zzd.zze(), zzafw.zza(this.zzv)), this.zzb);
    }
}
