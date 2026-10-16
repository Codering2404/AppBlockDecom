package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmx implements zzmt {
    private zzmx() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmt
    public final zzms zza() throws GeneralSecurityException {
        byte[] bArrZza = zzaah.zza();
        return new zzms(bArrZza, zzaah.zza(bArrZza));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzaah.zza(bArr, bArr2);
    }
}
