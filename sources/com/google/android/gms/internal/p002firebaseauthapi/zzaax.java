package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaax implements zzafv<zzahl> {
    private final /* synthetic */ zzafs zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzahv zzc;
    private final /* synthetic */ zzail zzd;
    private final /* synthetic */ zzaar zze;

    zzaax(zzaar zzaarVar, zzafs zzafsVar, zzael zzaelVar, zzahv zzahvVar, zzail zzailVar) {
        this.zza = zzafsVar;
        this.zzb = zzaelVar;
        this.zzc = zzahvVar;
        this.zzd = zzailVar;
        Objects.requireNonNull(zzaarVar);
        this.zze = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahl zzahlVar) {
        List<zzahk> listZza = zzahlVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzaar.zza(this.zze, this.zzb, this.zzc, listZza.get(0), this.zzd, this.zza);
        }
    }
}
