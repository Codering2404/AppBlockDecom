package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhg extends zzhi {
    zzhg(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final double zza(Object obj, long j3) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j3));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final float zzb(Object obj, long j3) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j3));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void zzc(Object obj, long j3, boolean z2) {
        if (zzhj.zza) {
            zzhj.zzi(obj, j3, z2);
        } else {
            zzhj.zzj(obj, j3, z2);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void zzd(Object obj, long j3, double d3) {
        this.zza.putLong(obj, j3, Double.doubleToLongBits(d3));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void zze(Object obj, long j3, float f3) {
        this.zza.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final boolean zzf(Object obj, long j3) {
        return zzhj.zza ? zzhj.zzq(obj, j3) : zzhj.zzr(obj, j3);
    }
}
