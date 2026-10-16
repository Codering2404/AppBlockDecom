package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadx extends zzaff<Void, zzl> {
    private final boolean zzaa;
    private final String zzab;
    private final String zzac;
    private final String zzad;
    private final boolean zzae;
    private final String zzv;
    private final String zzw;
    private final String zzx;
    private final long zzy;
    private final boolean zzz;

    public zzadx(zzam zzamVar, String str, String str2, long j3, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4) {
        super(8);
        Preconditions.m(zzamVar);
        Preconditions.g(str);
        this.zzv = Preconditions.g(zzamVar.zzb());
        this.zzw = str;
        this.zzx = str2;
        this.zzy = j3;
        this.zzz = z2;
        this.zzaa = z3;
        this.zzab = str3;
        this.zzac = str4;
        this.zzad = str5;
        this.zzae = z4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zza(this.zzv, this.zzw, this.zzx, this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
    }
}
