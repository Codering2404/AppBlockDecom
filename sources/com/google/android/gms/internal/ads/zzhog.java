package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhog {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;
    private zzhoh zzc = zzhoh.zzd;

    private zzhog() {
    }

    public final zzhog zza(int i3) throws GeneralSecurityException {
        if (i3 != 16 && i3 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i3 * 8)));
        }
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhog zzb(int i3) throws GeneralSecurityException {
        if (i3 >= 10 && i3 <= 16) {
            this.zzb = Integer.valueOf(i3);
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 40);
        sb.append("Invalid tag size for AesCmacParameters: ");
        sb.append(i3);
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzhog zzc(zzhoh zzhohVar) {
        this.zzc = zzhohVar;
        return this;
    }

    public final zzhoi zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (this.zzc != null) {
            return new zzhoi(num.intValue(), this.zzb.intValue(), this.zzc, null);
        }
        throw new GeneralSecurityException("variant not set");
    }

    /* synthetic */ zzhog(byte[] bArr) {
    }
}
