package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdi extends zzcy {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzc zze;
    private final zza zzf;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza {
        public static final zza zza = new zza("SHA1");
        public static final zza zzb = new zza("SHA224");
        public static final zza zzc = new zza("SHA256");
        public static final zza zzd = new zza("SHA384");
        public static final zza zze = new zza("SHA512");
        private final String zzf;

        private zza(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zzb {

        @Nullable
        private Integer zza;

        @Nullable
        private Integer zzb;

        @Nullable
        private Integer zzc;

        @Nullable
        private Integer zzd;
        private zza zze;
        private zzc zzf;

        public final zzb zza(int i3) throws GeneralSecurityException {
            if (i3 != 16 && i3 != 24 && i3 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i3)));
            }
            this.zza = Integer.valueOf(i3);
            return this;
        }

        public final zzb zzb(int i3) throws GeneralSecurityException {
            if (i3 < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i3)));
            }
            this.zzb = Integer.valueOf(i3);
            return this;
        }

        public final zzb zzc(int i3) throws GeneralSecurityException {
            if (i3 < 12 || i3 > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i3)));
            }
            this.zzc = Integer.valueOf(i3);
            return this;
        }

        public final zzb zzd(int i3) throws GeneralSecurityException {
            if (i3 < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i3)));
            }
            this.zzd = Integer.valueOf(i3);
            return this;
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = zzc.zzc;
        }

        public final zzb zza(zza zzaVar) {
            this.zze = zzaVar;
            return this;
        }

        public final zzb zza(zzc zzcVar) {
            this.zzf = zzcVar;
            return this;
        }

        public final zzdi zza() throws GeneralSecurityException {
            if (this.zza != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        Integer num = this.zzd;
                        if (num != null) {
                            if (this.zze != null) {
                                if (this.zzf != null) {
                                    int iIntValue = num.intValue();
                                    zza zzaVar = this.zze;
                                    if (zzaVar == zza.zza) {
                                        if (iIntValue > 20) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
                                        }
                                    } else if (zzaVar == zza.zzb) {
                                        if (iIntValue > 28) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
                                        }
                                    } else if (zzaVar == zza.zzc) {
                                        if (iIntValue > 32) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
                                        }
                                    } else if (zzaVar == zza.zzd) {
                                        if (iIntValue > 48) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
                                        }
                                    } else {
                                        if (zzaVar != zza.zze) {
                                            throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                                        }
                                        if (iIntValue > 64) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
                                        }
                                    }
                                    return new zzdi(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze);
                                }
                                throw new GeneralSecurityException("variant is not set");
                            }
                            throw new GeneralSecurityException("hash type is not set");
                        }
                        throw new GeneralSecurityException("tag size is not set");
                    }
                    throw new GeneralSecurityException("iv size is not set");
                }
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            throw new GeneralSecurityException("AES key size is not set");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("NO_PREFIX");
        private final String zzd;

        private zzc(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static zzb zzf() {
        return new zzb();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdi)) {
            return false;
        }
        zzdi zzdiVar = (zzdi) obj;
        return zzdiVar.zza == this.zza && zzdiVar.zzb == this.zzb && zzdiVar.zzc == this.zzc && zzdiVar.zzd == this.zzd && zzdiVar.zze == this.zze && zzdiVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzdi.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(this.zzf) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final boolean zza() {
        return this.zze != zzc.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zza zzg() {
        return this.zzf;
    }

    public final zzc zzh() {
        return this.zze;
    }

    private zzdi(int i3, int i4, int i5, int i6, zzc zzcVar, zza zzaVar) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = zzcVar;
        this.zzf = zzaVar;
    }
}
