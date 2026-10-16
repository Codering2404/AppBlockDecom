package com.google.android.gms.internal.ads;

import com.sun.jna.Function;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhwv {
    private static final BigInteger zzg;
    private static final BigInteger zzh;

    @Nullable
    private Integer zza = null;

    @Nullable
    private BigInteger zzb = zzhwy.zza;

    @Nullable
    private zzhww zzc = null;

    @Nullable
    private zzhww zzd = null;

    @Nullable
    private Integer zze = null;
    private zzhwx zzf = zzhwx.zzd;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        zzg = bigIntegerValueOf;
        zzh = bigIntegerValueOf.pow(Function.MAX_NARGS);
    }

    private zzhwv() {
    }

    public final zzhwv zza(int i3) {
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhwv zzb(BigInteger bigInteger) {
        this.zzb = bigInteger;
        return this;
    }

    public final zzhwv zzc(zzhwx zzhwxVar) {
        this.zzf = zzhwxVar;
        return this;
    }

    public final zzhwv zzd(zzhww zzhwwVar) {
        this.zzc = zzhwwVar;
        return this;
    }

    public final zzhwv zze(zzhww zzhwwVar) {
        this.zzd = zzhwwVar;
        return this;
    }

    public final zzhwv zzf(int i3) throws GeneralSecurityException {
        if (i3 < 0) {
            throw new GeneralSecurityException(String.format("Invalid salt length in bytes %d; salt length must be positive", Integer.valueOf(i3)));
        }
        this.zze = Integer.valueOf(i3);
        return this;
    }

    public final zzhwy zzg() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("publicExponent is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("signature hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("mgf1 hash type is not set");
        }
        if (this.zzf == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (this.zze == null) {
            throw new GeneralSecurityException("salt length is not set");
        }
        if (num.intValue() < 2048) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least %d bits", this.zza, 2048));
        }
        if (this.zzc != this.zzd) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        }
        BigInteger bigInteger = this.zzb;
        int iCompareTo = bigInteger.compareTo(zzhwy.zza);
        if (iCompareTo != 0) {
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(zzg).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(zzh) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }
        return new zzhwy(this.zza.intValue(), this.zzb, this.zzf, this.zzc, this.zzd, this.zze.intValue(), null);
    }

    /* synthetic */ zzhwv(byte[] bArr) {
    }
}
