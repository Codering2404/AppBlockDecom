package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzz implements zzsq {
    public static zzsq zza(zzso zzsoVar) throws GeneralSecurityException {
        zzsq zzsqVarZza = zzsv.zza(zzsoVar);
        try {
            return new zzaac(zzsqVarZza, zzsx.zza(zzsoVar));
        } catch (GeneralSecurityException unused) {
            return zzsqVarZza;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsq
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
