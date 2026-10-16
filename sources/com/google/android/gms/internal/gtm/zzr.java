package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzr implements zzxx {
    NO_CACHE(1),
    PRIVATE(2),
    PUBLIC(3);

    private static final zzxy zzd = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzp
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzr.zzb(i3);
        }
    };
    private final int zzf;

    zzr(int i3) {
        this.zzf = i3;
    }

    public static zzr zzb(int i3) {
        if (i3 == 1) {
            return NO_CACHE;
        }
        if (i3 == 2) {
            return PRIVATE;
        }
        if (i3 != 3) {
            return null;
        }
        return PUBLIC;
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
