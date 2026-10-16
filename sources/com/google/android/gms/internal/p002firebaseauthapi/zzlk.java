package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlk implements zzly {
    zzlk() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzly
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzly
    public final int zzb() {
        return 12;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzly
    public final byte[] zzc() {
        return zzmk.zzk;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzly
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzhv.zza()) {
            return zzhv.zza(bArr).zza(bArr2, bArr3, i3, bArr4);
        }
        return new zzht(bArr).zza(bArr2, Arrays.copyOfRange(bArr3, i3, bArr3.length), bArr4);
    }
}
