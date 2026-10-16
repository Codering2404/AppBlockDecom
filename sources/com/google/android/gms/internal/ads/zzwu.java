package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwu implements zzze {
    private final zzgwm zza;
    private long zzb;

    public zzwu(List list, List list2) {
        int i3 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        zzgtj.zza(list.size() == list2.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzgwjVar.zzf(new zzwt((zzze) list.get(i4), (List) list2.get(i4)));
        }
        this.zza = zzgwjVar.zzi();
        this.zzb = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        int i3 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                return;
            }
            ((zzwt) zzgwmVar.get(i3)).zzg(j3);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        int i3 = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                break;
            }
            zzwt zzwtVar = (zzwt) zzgwmVar.get(i3);
            long jZzi = zzwtVar.zzi();
            if ((zzwtVar.zza().contains(1) || zzwtVar.zza().contains(2) || zzwtVar.zza().contains(4)) && jZzi != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzi);
            }
            if (jZzi != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzi);
            }
            i3++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j3 = this.zzb;
        return j3 != -9223372036854775807L ? j3 : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        int i3 = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                break;
            }
            long jZzl = ((zzwt) zzgwmVar.get(i3)).zzl();
            if (jZzl != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzl);
            }
            i3++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        boolean zZzm;
        boolean z2 = false;
        do {
            long jZzl = zzl();
            if (jZzl == Long.MIN_VALUE) {
                break;
            }
            int i3 = 0;
            zZzm = false;
            while (true) {
                zzgwm zzgwmVar = this.zza;
                if (i3 >= zzgwmVar.size()) {
                    break;
                }
                long jZzl2 = ((zzwt) zzgwmVar.get(i3)).zzl();
                boolean z3 = jZzl2 != Long.MIN_VALUE && jZzl2 <= zzmaVar.zza;
                if (jZzl2 == jZzl || z3) {
                    zZzm |= ((zzwt) zzgwmVar.get(i3)).zzm(zzmaVar);
                }
                i3++;
            }
            z2 |= zZzm;
        } while (zZzm);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        int i3 = 0;
        while (true) {
            zzgwm zzgwmVar = this.zza;
            if (i3 >= zzgwmVar.size()) {
                return false;
            }
            if (((zzwt) zzgwmVar.get(i3)).zzn()) {
                return true;
            }
            i3++;
        }
    }
}
