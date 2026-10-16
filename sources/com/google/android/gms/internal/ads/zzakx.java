package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakx implements zzahf {
    public final int zza;
    public final long zzb;
    public final int zzc;

    public zzakx(int i3, long j3, int i4) {
        this.zza = i3;
        this.zzb = j3;
        this.zzc = i4;
    }

    public final String toString() {
        String strZzz = zzfl.zzz(this.zza);
        int length = strZzz.length();
        long j3 = this.zzb;
        int length2 = String.valueOf(j3).length();
        int i3 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 29 + length2 + 16 + String.valueOf(i3).length() + 1);
        sb.append("AtomSizeTooSmall{type=");
        sb.append(strZzz);
        sb.append(", size=");
        sb.append(j3);
        sb.append(", minHeaderSize=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
