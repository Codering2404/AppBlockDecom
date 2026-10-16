package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajx implements zzao {
    public final float zza;
    public final int zzb;

    public zzajx(float f3, int i3) {
        this.zza = f3;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajx.class == obj.getClass()) {
            zzajx zzajxVar = (zzajx) obj;
            if (this.zza == zzajxVar.zza && this.zzb == zzajxVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.hashCode(this.zza) + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f3 = this.zza;
        int length = String.valueOf(f3).length();
        int i3 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 47 + String.valueOf(i3).length());
        sb.append("smta: captureFrameRate=");
        sb.append(f3);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i3);
        return sb.toString();
    }
}
