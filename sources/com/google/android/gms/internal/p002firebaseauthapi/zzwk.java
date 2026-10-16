package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzwk implements zzalk {
    AEAD_UNKNOWN(0),
    AES_128_GCM(1),
    AES_256_GCM(2),
    CHACHA20_POLY1305(3),
    UNRECOGNIZED(-1);

    private final int zzg;

    zzwk(int i3) {
        this.zzg = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzwk.class.getName());
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
            return this.zzg;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzwk zza(int i3) {
        if (i3 == 0) {
            return AEAD_UNKNOWN;
        }
        if (i3 == 1) {
            return AES_128_GCM;
        }
        if (i3 == 2) {
            return AES_256_GCM;
        }
        if (i3 != 3) {
            return null;
        }
        return CHACHA20_POLY1305;
    }
}
