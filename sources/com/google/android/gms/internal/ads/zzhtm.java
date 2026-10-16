package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzhtm implements zziei {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    WITH_ID_REQUIREMENT(5),
    UNRECOGNIZED(-1);

    private final int zzh;

    zzhtm(int i3) {
        this.zzh = i3;
    }

    public static zzhtm zzb(int i3) {
        if (i3 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i3 == 1) {
            return TINK;
        }
        if (i3 == 2) {
            return LEGACY;
        }
        if (i3 == 3) {
            return RAW;
        }
        if (i3 == 4) {
            return CRUNCHY;
        }
        if (i3 != 5) {
            return null;
        }
        return WITH_ID_REQUIREMENT;
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
