package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaay implements zzafv<zzagw> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzaay(zzaar zzaarVar, zzael zzaelVar) {
        this.zza = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzb = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzagw zzagwVar) {
        zzagw zzagwVar2 = zzagwVar;
        if (zzagwVar2.zzf()) {
            this.zza.zza(new zzaas(zzagwVar2.zzc(), zzagwVar2.zze(), null));
        } else {
            this.zzb.zza(new zzahv(zzagwVar2.zzd(), zzagwVar2.zzb(), Long.valueOf(zzagwVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzagwVar2.zzg()), null, this.zza, this);
        }
    }
}
