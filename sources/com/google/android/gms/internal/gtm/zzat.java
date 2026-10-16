package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzat implements zzxx {
    STRING(1),
    LIST(2),
    MAP(3),
    MACRO_REFERENCE(4),
    FUNCTION_ID(5),
    INTEGER(6),
    TEMPLATE(7),
    BOOLEAN(8);

    private static final zzxy zzi = new zzxy() { // from class: com.google.android.gms.internal.gtm.zzar
        @Override // com.google.android.gms.internal.gtm.zzxy
        public final /* synthetic */ zzxx zza(int i3) {
            return zzat.zzb(i3);
        }
    };
    private final int zzk;

    zzat(int i3) {
        this.zzk = i3;
    }

    public static zzat zzb(int i3) {
        switch (i3) {
            case 1:
                return STRING;
            case 2:
                return LIST;
            case 3:
                return MAP;
            case 4:
                return MACRO_REFERENCE;
            case 5:
                return FUNCTION_ID;
            case 6:
                return INTEGER;
            case 7:
                return TEMPLATE;
            case 8:
                return BOOLEAN;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzk);
    }

    @Override // com.google.android.gms.internal.gtm.zzxx
    public final int zza() {
        return this.zzk;
    }
}
