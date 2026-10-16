package com.google.android.gms.internal.gtm;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaas extends zzaat {
    zzaas(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final double zza(Object obj, long j3) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final float zzb(Object obj, long j3) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final void zzc(Object obj, long j3, boolean z2) {
        if (zzaau.zzb) {
            zzaau.zzD(obj, j3, z2 ? (byte) 1 : (byte) 0);
        } else {
            zzaau.zzE(obj, j3, z2 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final void zzd(Object obj, long j3, byte b3) {
        if (zzaau.zzb) {
            zzaau.zzD(obj, j3, b3);
        } else {
            zzaau.zzE(obj, j3, b3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final void zze(Object obj, long j3, double d3) {
        this.zza.putLong(obj, j3, Double.doubleToLongBits(d3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final void zzf(Object obj, long j3, float f3) {
        this.zza.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.gtm.zzaat
    public final boolean zzg(Object obj, long j3) {
        return zzaau.zzb ? zzaau.zzt(obj, j3) : zzaau.zzu(obj, j3);
    }
}
