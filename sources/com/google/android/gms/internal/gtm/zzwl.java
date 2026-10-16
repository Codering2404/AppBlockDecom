package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzwl implements zzxx {
    RETENTION_UNKNOWN(0),
    RETENTION_RUNTIME(1),
    RETENTION_SOURCE(2);

    private static final zzxy zzd = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzwj
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzwl.zzb(i3);
        }
    };
    private final int zzf;

    zzwl(int i3) {
        this.zzf = i3;
    }

    public static zzwl zzb(int i3) {
        if (i3 == 0) {
            return RETENTION_UNKNOWN;
        }
        if (i3 == 1) {
            return RETENTION_RUNTIME;
        }
        if (i3 != 2) {
            return null;
        }
        return RETENTION_SOURCE;
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
