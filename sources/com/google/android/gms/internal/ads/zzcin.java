package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcin extends zzaul {
    static final zzcin zzb = new zzcin();

    zzcin() {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final zzaup zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzaur() : "mvhd".equals(str) ? new zzaus() : new zzaut(str);
    }
}
