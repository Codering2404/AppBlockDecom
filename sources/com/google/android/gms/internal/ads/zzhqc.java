package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqc extends zzhqf {
    private final int zza;

    private zzhqc(int i3) {
        this.zza = i3;
    }

    public static zzhqc zzb(int i3) throws GeneralSecurityException {
        if (i3 == 16 || i3 == 32) {
            return new zzhqc(i3);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i3 * 8)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhqc) && ((zzhqc) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhqc.class, Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i3 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 34);
        sb.append("AesCmac PRF Parameters (");
        sb.append(i3);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return false;
    }

    public final int zzc() {
        return this.zza;
    }
}
