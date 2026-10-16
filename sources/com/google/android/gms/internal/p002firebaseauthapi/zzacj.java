package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacj implements zzafv<zzahv> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzaar zzc;

    zzacj(zzaar zzaarVar, String str, zzael zzaelVar) {
        this.zza = str;
        this.zzb = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzc = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzb.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        zzahv zzahvVar2 = zzahvVar;
        zzail zzailVar = new zzail();
        zzailVar.zzd(zzahvVar2.zzc()).zzc(this.zza);
        zzaar.zza(this.zzc, this.zzb, zzahvVar2, zzailVar, this);
    }
}
