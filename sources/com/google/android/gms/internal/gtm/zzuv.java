package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzuv implements zzxx {
    EDITION_UNKNOWN(0),
    EDITION_PROTO2(998),
    EDITION_PROTO3(999),
    EDITION_2023(1000),
    EDITION_1_TEST_ONLY(1),
    EDITION_2_TEST_ONLY(2),
    EDITION_99997_TEST_ONLY(99997),
    EDITION_99998_TEST_ONLY(99998),
    EDITION_99999_TEST_ONLY(99999);

    private static final zzxy zzj = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzut
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzuv.zzb(i3);
        }
    };
    private final int zzl;

    zzuv(int i3) {
        this.zzl = i3;
    }

    public static zzuv zzb(int i3) {
        if (i3 == 0) {
            return EDITION_UNKNOWN;
        }
        if (i3 == 1) {
            return EDITION_1_TEST_ONLY;
        }
        if (i3 == 2) {
            return EDITION_2_TEST_ONLY;
        }
        switch (i3) {
            case 998:
                return EDITION_PROTO2;
            case 999:
                return EDITION_PROTO3;
            case 1000:
                return EDITION_2023;
            default:
                switch (i3) {
                    case 99997:
                        return EDITION_99997_TEST_ONLY;
                    case 99998:
                        return EDITION_99998_TEST_ONLY;
                    case 99999:
                        return EDITION_99999_TEST_ONLY;
                    default:
                        return null;
                }
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzl);
    }

    @Override // com.google.android.gms.internal.gtm.zzxx
    public final int zza() {
        return this.zzl;
    }
}
