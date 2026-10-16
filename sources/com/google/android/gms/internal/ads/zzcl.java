package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcl {
    public static final zzcl zza = new zzcl(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzcl(int i3, int i4, int i5) {
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = zzfl.zzD(i5) ? zzfl.zzG(i5) * i4 : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzclVar = (zzcl) obj;
        return this.zzb == zzclVar.zzb && this.zzc == zzclVar.zzc && this.zzd == zzclVar.zzd;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i3 = this.zzb;
        int length = String.valueOf(i3).length();
        int i4 = this.zzc;
        int length2 = String.valueOf(i4).length();
        int i5 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 11 + String.valueOf(i5).length() + 1);
        sb.append("AudioFormat[sampleRate=");
        sb.append(i3);
        sb.append(", channelCount=");
        sb.append(i4);
        sb.append(", encoding=");
        sb.append(i5);
        sb.append("]");
        return sb.toString();
    }
}
