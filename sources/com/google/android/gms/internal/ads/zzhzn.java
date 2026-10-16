package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzn {
    private final byte[] zza;
    private final byte[] zzb;

    private zzhzn(byte[] bArr, byte[] bArr2) {
        this.zza = bArr;
        this.zzb = bArr2;
    }

    public static zzhzn zzc() throws GeneralSecurityException {
        byte[] bArrZza = zzhnp.zza(32);
        if (bArrZza.length == 32) {
            return new zzhzn(zzhlc.zza(zzhlc.zzb(bArrZza)), bArrZza);
        }
        throw new IllegalArgumentException(String.format("Given secret seed length is not %s", 32));
    }

    public final byte[] zza() {
        return Arrays.copyOf(this.zza, 32);
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzb;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
