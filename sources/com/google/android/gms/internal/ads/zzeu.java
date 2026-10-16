package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeu {
    public static final zzeu zza = new zzeu(-1, -1);
    private final int zzb;
    private final int zzc;

    static {
        new zzeu(0, 0);
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzeu(int i3, int i4) {
        boolean z2 = false;
        if ((i3 == -1 || i3 >= 0) && (i4 == -1 || i4 >= 0)) {
            z2 = true;
        }
        zzgtj.zza(z2);
        this.zzb = i3;
        this.zzc = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeu) {
            zzeu zzeuVar = (zzeu) obj;
            if (this.zzb == zzeuVar.zzb && this.zzc == zzeuVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzb;
        return ((i3 >>> 16) | (i3 << 16)) ^ this.zzc;
    }

    public final String toString() {
        int i3 = this.zzb;
        int length = String.valueOf(i3).length();
        int i4 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i4).length());
        sb.append(i3);
        sb.append("x");
        sb.append(i4);
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }
}
