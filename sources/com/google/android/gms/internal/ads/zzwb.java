package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzwb implements zzwe {
    static final /* synthetic */ zzwb zza = new zzwb();

    private /* synthetic */ zzwb() {
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final /* synthetic */ int zza(Object obj) {
        int i3 = zzwf.zza;
        String str = ((zzvm) obj).zza;
        return (str.startsWith("OMX.google") || str.startsWith("c2.android")) ? 1 : 0;
    }
}
