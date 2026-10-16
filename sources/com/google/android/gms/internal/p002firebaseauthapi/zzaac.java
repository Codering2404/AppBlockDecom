package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaac implements zzsq {
    private final zzsq zza;
    private final zzsq zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsq
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i3) : this.zzb.zza(bArr, i3);
    }

    private zzaac(zzsq zzsqVar, zzsq zzsqVar2) {
        this.zza = zzsqVar;
        this.zzb = zzsqVar2;
    }
}
