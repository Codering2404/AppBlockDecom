package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyu implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzeyu(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzeyu zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzeyu(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Object objZzb = ((zzfaz) this.zza).zzb();
        zzewy zzewyVar = (zzewy) this.zzb.zzb();
        if (true == ((List) this.zzc.zzb()).contains("29")) {
            objZzb = zzewyVar;
        }
        zzinc.zzb(objZzb);
        return objZzb;
    }
}
