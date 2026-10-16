package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzip implements zzba {
    private static final ThreadLocal<Cipher> zza = new zzir();

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher zzb() throws GeneralSecurityException {
        try {
            Cipher cipher = zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e3) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e3);
        }
    }

    public static zzba zza(zzdz zzdzVar) throws GeneralSecurityException {
        return zzgz.zza(zzdzVar, (zzhc<Cipher>) new zzhc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzis
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhc
            public final Object zza() {
                return zzip.zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzba
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzba
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
