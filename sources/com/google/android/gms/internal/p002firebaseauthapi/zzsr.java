package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsr extends zzss {
    private final int zza;

    private zzsr(int i3) {
        this.zza = i3;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzsr) && ((zzsr) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzsr.class, Integer.valueOf(this.zza));
    }

    public final String toString() {
        return "AesCmac PRF Parameters (" + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final boolean zza() {
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public static zzsr zza(int i3) throws GeneralSecurityException {
        if (i3 == 16 || i3 == 32) {
            return new zzsr(i3);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i3 << 3)));
    }
}
