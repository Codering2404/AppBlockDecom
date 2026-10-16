package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamm implements zzahf {
    public final int zza;
    public final zzhaf zzb;

    public zzamm(int i3, int[] iArr) {
        this.zza = i3;
        this.zzb = iArr != null ? zzhaf.zzf(iArr) : zzhaf.zza();
    }

    public final String toString() {
        zzhaf zzhafVar = this.zzb;
        ArrayList arrayList = new ArrayList(zzhafVar.zzh());
        for (int i3 = 0; i3 < zzhafVar.zzh(); i3++) {
            arrayList.add(zzfl.zzz(zzhafVar.zzi(i3)));
        }
        String strZzz = zzfl.zzz(this.zza);
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder(strZzz.length() + 37 + string.length() + 1);
        sb.append("UnsupportedBrands{major=");
        sb.append(strZzz);
        sb.append(", compatible=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
