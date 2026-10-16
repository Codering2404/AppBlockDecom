package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzwm implements zzalk {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);

    private final int zzh;

    zzwm(int i3) {
        this.zzh = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzwm.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zza());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalk
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzh;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzwm zza(int i3) {
        if (i3 == 0) {
            return KEM_UNKNOWN;
        }
        if (i3 == 1) {
            return DHKEM_X25519_HKDF_SHA256;
        }
        if (i3 == 2) {
            return DHKEM_P256_HKDF_SHA256;
        }
        if (i3 == 3) {
            return DHKEM_P384_HKDF_SHA384;
        }
        if (i3 != 4) {
            return null;
        }
        return DHKEM_P521_HKDF_SHA512;
    }
}
