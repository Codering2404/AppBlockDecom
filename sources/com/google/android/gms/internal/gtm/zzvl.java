package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzvl implements zzxx {
    FIELD_PRESENCE_UNKNOWN(0),
    EXPLICIT(1),
    IMPLICIT(2),
    LEGACY_REQUIRED(3);

    private static final zzxy zze = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzvj
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzvl.zzb(i3);
        }
    };
    private final int zzg;

    zzvl(int i3) {
        this.zzg = i3;
    }

    public static zzvl zzb(int i3) {
        if (i3 == 0) {
            return FIELD_PRESENCE_UNKNOWN;
        }
        if (i3 == 1) {
            return EXPLICIT;
        }
        if (i3 == 2) {
            return IMPLICIT;
        }
        if (i3 != 3) {
            return null;
        }
        return LEGACY_REQUIRED;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    @Override // com.google.android.gms.internal.gtm.zzxx
    public final int zza() {
        return this.zzg;
    }
}
