package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzn {
    public static final zzzn zza = new zzzn(new zzbg[0]);
    public final int zzb;
    private final zzgwm zzc;
    private int zzd;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
    }

    public zzzn(zzbg... zzbgVarArr) {
        this.zzc = zzgwm.zzr(zzbgVarArr);
        this.zzb = zzbgVarArr.length;
        int i3 = 0;
        while (i3 < this.zzc.size()) {
            int i4 = i3 + 1;
            for (int i5 = i4; i5 < this.zzc.size(); i5++) {
                if (((zzbg) this.zzc.get(i3)).equals(this.zzc.get(i5))) {
                    zzeg.zzf("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i3 = i4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzn.class == obj.getClass()) {
            zzzn zzznVar = (zzzn) obj;
            if (this.zzb == zzznVar.zzb && this.zzc.equals(zzznVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzd;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = this.zzc.hashCode();
        this.zzd = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzbg zza(int i3) {
        return (zzbg) this.zzc.get(i3);
    }

    public final int zzb(zzbg zzbgVar) {
        int iIndexOf = this.zzc.indexOf(zzbgVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final zzgwm zzc() {
        return zzgwm.zzq(zzgxm.zzc(this.zzc, zzzm.zza));
    }
}
