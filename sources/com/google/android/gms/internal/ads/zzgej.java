package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgej implements zzged {
    private final int zza;
    private final byte[] zzb;

    zzgej(int i3, byte[] bArr) {
        this.zza = i3;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final String zzb() throws IOException {
        return new String(this.zzb);
    }
}
