package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbph implements zzgta {
    static final /* synthetic */ zzbph zza = new zzbph();

    private /* synthetic */ zzbph() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzbpq zzbpqVar = zzbpp.zza;
        if (!((Boolean) zzbkp.zzi.zze()).booleanValue()) {
            return "failure_click_attok";
        }
        com.google.android.gms.ads.internal.zzt.l().zzg(th, "prepareClickUrl.attestation1");
        return "failure_click_attok";
    }
}
