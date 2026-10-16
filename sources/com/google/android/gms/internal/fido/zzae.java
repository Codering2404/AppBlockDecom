package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzae {
    private static final Object zza = new Object();
    private static final zzai zzb = new zzai();
    private static volatile zzae zzc = null;
    private static volatile zzae zzd = null;
    private static final zzbp zze = zzbt.zza(new zzbp() { // from class: com.google.android.gms.internal.fido.zzad
        @Override // com.google.android.gms.internal.fido.zzbp
        public final Object zza() {
            throw null;
        }
    });

    public static zzae zza() {
        zzah.zza();
        zzah.zzb();
        zzah.zzd();
        throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
    }

    public static boolean zzb() {
        zzah.zzd();
        zzah.zzc();
        return false;
    }
}
