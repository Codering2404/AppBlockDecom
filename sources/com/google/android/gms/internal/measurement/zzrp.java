package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrp implements zzro {
    public static final zzkm zza = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb().zzd("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzro
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzro
    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
