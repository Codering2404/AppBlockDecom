package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzvo implements zzxx {
    JSON_FORMAT_UNKNOWN(0),
    ALLOW(1),
    LEGACY_BEST_EFFORT(2);

    private static final zzxy zzd = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzvm
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzvo.zzb(i3);
        }
    };
    private final int zzf;

    zzvo(int i3) {
        this.zzf = i3;
    }

    public static zzvo zzb(int i3) {
        if (i3 == 0) {
            return JSON_FORMAT_UNKNOWN;
        }
        if (i3 == 1) {
            return ALLOW;
        }
        if (i3 != 2) {
            return null;
        }
        return LEGACY_BEST_EFFORT;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzxx
    public final int zza() {
        return this.zzf;
    }
}
