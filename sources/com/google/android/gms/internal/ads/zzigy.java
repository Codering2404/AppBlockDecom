package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigy extends zzigz {
    zzigy(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zza(Object obj, long j3, byte b3) {
        if (zziha.zzb) {
            zziha.zzE(obj, j3, b3);
        } else {
            zziha.zzF(obj, j3, b3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final boolean zzb(Object obj, long j3) {
        return zziha.zzb ? zziha.zzv(obj, j3) : zziha.zzw(obj, j3);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zziha.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zziha.zzy(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.ads.zziha.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.ads.zziha.zzy(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zzc(Object obj, long j3, boolean z2) {
        if (zziha.zzb) {
            zziha.zzx(obj, j3, z2);
        } else {
            zziha.zzy(obj, j3, z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final float zzd(Object obj, long j3) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j3));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zze(Object obj, long j3, float f3) {
        this.zza.putInt(obj, j3, Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final double zzf(Object obj, long j3) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j3));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zzg(Object obj, long j3, double d3) {
        this.zza.putLong(obj, j3, Double.doubleToLongBits(d3));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final byte zzh(long j3) {
        return Memory.peekByte(j3);
    }
}
