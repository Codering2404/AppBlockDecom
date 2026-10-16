package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadc extends zzaff<AuthResult, zzl> {
    private final EmailAuthCredential zzv;
    private final String zzw;

    public zzadc(EmailAuthCredential emailAuthCredential, String str) {
        super(2);
        this.zzv = (EmailAuthCredential) Preconditions.n(emailAuthCredential, "credential cannot be null");
        Preconditions.h(emailAuthCredential.zzc(), "email cannot be null");
        Preconditions.h(emailAuthCredential.zzd(), "password cannot be null");
        this.zzw = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "linkEmailAuthCredential";
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
        zzaeoVar.zza(this.zzv.zzc(), Preconditions.g(this.zzv.zzd()), this.zzd.zze(), this.zzd.g0(), this.zzw, this.zzb);
    }
}
