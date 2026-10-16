package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdvu implements zzimu {
    private final zzind zza;

    private zzdvu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdvu zza(zzind zzindVar) {
        return new zzdvu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbhv.zza.EnumC0141zza enumC0141zza = ((zzdci) this.zza).zza().zzp.zza == 3 ? zzbhv.zza.EnumC0141zza.REWARDED_INTERSTITIAL : zzbhv.zza.EnumC0141zza.REWARD_BASED_VIDEO_AD;
        zzinc.zzb(enumC0141zza);
        return enumC0141zza;
    }
}
