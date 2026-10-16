package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzwd implements zzxx {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    private static final zzxy zzd = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzwb
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzwd.zzb(i3);
        }
    };
    private final int zzf;

    zzwd(int i3) {
        this.zzf = i3;
    }

    public static zzwd zzb(int i3) {
        if (i3 == 0) {
            return STRING;
        }
        if (i3 == 1) {
            return CORD;
        }
        if (i3 != 2) {
            return null;
        }
        return STRING_PIECE;
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
