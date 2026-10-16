package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhly extends zzheh {
    private final String zza;
    private final zzhtm zzb;

    /* synthetic */ zzhly(String str, zzhtm zzhtmVar, byte[] bArr) {
        this.zza = str;
        this.zzb = zzhtmVar;
    }

    public final String toString() {
        String str = this.zza;
        int iOrdinal = this.zzb.ordinal();
        return String.format("(typeUrl=%s, outputPrefixType=%s)", str, iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzb != zzhtm.RAW;
    }
}
