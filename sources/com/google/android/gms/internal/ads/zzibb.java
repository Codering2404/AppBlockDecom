package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzibb {
    private final zziaz zza;

    private zzibb(zziaz zziazVar) {
        this.zza = zziazVar;
    }

    public static zzibb zza(byte[] bArr, zzhel zzhelVar) {
        return new zzibb(zziaz.zza(bArr));
    }

    public static zzibb zzb(int i3) {
        return new zzibb(zziaz.zza(zzhnp.zza(i3)));
    }

    public final byte[] zzc(zzhel zzhelVar) {
        return this.zza.zzc();
    }

    public final int zzd() {
        return this.zza.zzd();
    }
}
