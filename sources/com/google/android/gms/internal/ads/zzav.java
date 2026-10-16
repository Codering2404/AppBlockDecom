package com.google.android.gms.internal.ads;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzav {
    public static final zzav zza = new zzav(1.0f, 1.0f);
    public final float zzb;
    public final float zzc;
    private final int zzd;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzav(float f3, float f4) {
        zzgtj.zza(f3 > 0.0f);
        zzgtj.zza(f4 > 0.0f);
        this.zzb = f3;
        this.zzc = f4;
        this.zzd = Math.round(f3 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzav.class == obj.getClass()) {
            zzav zzavVar = (zzav) obj;
            if (this.zzb == zzavVar.zzb && this.zzc == zzavVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzb) + 527) * 31) + Float.floatToRawIntBits(this.zzc);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.zzb), Float.valueOf(this.zzc)};
        String str = zzfl.zza;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }

    public final long zza(long j3) {
        return j3 * ((long) this.zzd);
    }
}
