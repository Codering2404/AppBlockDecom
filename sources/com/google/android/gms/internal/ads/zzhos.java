package com.google.android.gms.internal.ads;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhos {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;
    private zzhot zzc = null;
    private zzhou zzd = zzhou.zzd;

    private zzhos() {
    }

    public final zzhos zza(int i3) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhos zzb(int i3) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i3);
        return this;
    }

    public final zzhos zzc(zzhou zzhouVar) {
        this.zzd = zzhouVar;
        return this;
    }

    public final zzhos zzd(zzhot zzhotVar) {
        this.zzc = zzhotVar;
        return this;
    }

    /* synthetic */ zzhos(byte[] bArr) {
    }

    public final zzhov zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        Integer num2 = this.zzb;
        int iIntValue = num2.intValue();
        zzhot zzhotVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (zzhotVar == zzhot.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (zzhotVar == zzhot.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (zzhotVar == zzhot.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (zzhotVar == zzhot.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (zzhotVar != zzhot.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format(KLAQHFCRAUejH.xPMljZE, num2));
            }
        }
        return new zzhov(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }
}
