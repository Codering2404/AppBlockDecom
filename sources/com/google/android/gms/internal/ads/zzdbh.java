package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdbh implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzdbh(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzdbh zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzdbh(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzcoi) this.zzb).zza();
        final zzfky zzfkyVarZza = ((zzdci) this.zzc).zza();
        return new zzgta() { // from class: com.google.android.gms.internal.ads.zzdbg
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                zzfkf zzfkfVar = (zzfkf) obj;
                com.google.android.gms.ads.internal.util.zzat zzatVar = new com.google.android.gms.ads.internal.util.zzat(context);
                zzatVar.e(zzfkfVar.zzB);
                zzatVar.f(zzfkfVar.zzC.toString());
                zzatVar.d(versionInfoParcelZza.f70149a);
                zzatVar.c(zzfkyVarZza.zzg);
                return zzatVar;
            }
        };
    }
}
