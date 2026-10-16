package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzhsh implements zziei {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);

    private final int zzh;

    zzhsh(int i3) {
        this.zzh = i3;
    }

    public static zzhsh zzb(int i3) {
        if (i3 == 0) {
            return UNKNOWN_HASH;
        }
        if (i3 == 1) {
            return SHA1;
        }
        if (i3 == 2) {
            return SHA384;
        }
        if (i3 == 3) {
            return SHA256;
        }
        if (i3 == 4) {
            return SHA512;
        }
        if (i3 != 5) {
            return null;
        }
        return SHA224;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zziei
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzh;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
