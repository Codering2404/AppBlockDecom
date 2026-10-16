package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznb implements zzba {
    private static final String zza = "zznb";
    private final zzba zzb;

    public zznb(String str) throws GeneralSecurityException, IOException {
        this.zzb = zzmz.zza(str);
    }

    private static void zza() {
        try {
            Thread.sleep((int) (Math.random() * 100.0d));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzba
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.zzb.zzb(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e3) {
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e3);
            zza();
            return this.zzb.zzb(bArr, bArr2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzba
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.zzb.zza(bArr, bArr2);
        } catch (GeneralSecurityException e3) {
            e = e3;
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return this.zzb.zza(bArr, bArr2);
        } catch (ProviderException e4) {
            e = e4;
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return this.zzb.zza(bArr, bArr2);
        } catch (BadPaddingException e5) {
            throw e5;
        }
    }
}
