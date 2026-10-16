package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbn {
    public static final zzbn zza = new zzbn(zzgwm.zzi());
    private final zzgwm zzb;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
    }

    public zzbn(List list) {
        this.zzb = zzgwm.zzq(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbn.class != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzbn) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzgwm zza() {
        return this.zzb;
    }

    public final boolean zzb(int i3) {
        int i4 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zzb;
            if (i4 >= zzgwmVar.size()) {
                return false;
            }
            zzbm zzbmVar = (zzbm) zzgwmVar.get(i4);
            if (zzbmVar.zzb() && zzbmVar.zzd() == i3) {
                return true;
            }
            i4++;
        }
    }
}
