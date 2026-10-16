package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zziw extends zzbf {
    private final int zzb;
    private final zzzf zzc;

    public zziw(boolean z2, zzzf zzzfVar) {
        this.zzc = zzzfVar;
        this.zzb = zzzfVar.zza();
    }

    private final int zzw(int i3, boolean z2) {
        if (z2) {
            return this.zzc.zzb(i3);
        }
        if (i3 >= this.zzb - 1) {
            return -1;
        }
        return i3 + 1;
    }

    private final int zzx(int i3, boolean z2) {
        if (z2) {
            return this.zzc.zzc(i3);
        }
        if (i3 <= 0) {
            return -1;
        }
        return i3 - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i3, zzbe zzbeVar, long j3) {
        int iZzq = zzq(i3);
        int iZzu = zzu(iZzq);
        int iZzt = zzt(iZzq);
        zzs(iZzq).zzb(i3 - iZzu, zzbeVar, j3);
        Object objZzv = zzv(iZzq);
        if (!zzbe.zza.equals(zzbeVar.zzb)) {
            objZzv = Pair.create(objZzv, zzbeVar.zzb);
        }
        zzbeVar.zzb = objZzv;
        zzbeVar.zzn += iZzt;
        zzbeVar.zzo += iZzt;
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i3, zzbd zzbdVar, boolean z2) {
        int iZzp = zzp(i3);
        int iZzu = zzu(iZzp);
        zzs(iZzp).zzd(i3 - zzt(iZzp), zzbdVar, z2);
        zzbdVar.zzc += iZzu;
        if (z2) {
            Object objZzv = zzv(iZzp);
            Object obj = zzbdVar.zzb;
            obj.getClass();
            zzbdVar.zzb = Pair.create(objZzv, obj);
        }
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zze(Object obj) {
        int iZze;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int iZzr = zzr(obj2);
            if (iZzr != -1 && (iZze = zzs(iZzr).zze(obj3)) != -1) {
                return zzt(iZzr) + iZze;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object zzf(int i3) {
        int iZzp = zzp(i3);
        return Pair.create(zzv(iZzp), zzs(iZzp).zzf(i3 - zzt(iZzp)));
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzh(int i3, int i4, boolean z2) {
        int iZzq = zzq(i3);
        int iZzu = zzu(iZzq);
        int iZzh = zzs(iZzq).zzh(i3 - iZzu, i4 == 2 ? 0 : i4, z2);
        if (iZzh != -1) {
            return iZzu + iZzh;
        }
        int iZzw = zzw(iZzq, z2);
        while (iZzw != -1 && zzs(iZzw).zzg()) {
            iZzw = zzw(iZzw, z2);
        }
        if (iZzw != -1) {
            return zzu(iZzw) + zzs(iZzw).zzk(z2);
        }
        if (i4 == 2) {
            return zzk(z2);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzi(int i3, int i4, boolean z2) {
        int iZzq = zzq(i3);
        int iZzu = zzu(iZzq);
        int iZzi = zzs(iZzq).zzi(i3 - iZzu, 0, false);
        if (iZzi != -1) {
            return iZzu + iZzi;
        }
        int iZzx = zzx(iZzq, false);
        while (iZzx != -1 && zzs(iZzx).zzg()) {
            iZzx = zzx(iZzx, false);
        }
        if (iZzx != -1) {
            return zzu(iZzx) + zzs(iZzx).zzj(false);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzj(boolean z2) {
        int i3 = this.zzb;
        if (i3 != 0) {
            int iZzd = z2 ? this.zzc.zzd() : i3 - 1;
            while (zzs(iZzd).zzg()) {
                iZzd = zzx(iZzd, z2);
                if (iZzd == -1) {
                }
            }
            return zzu(iZzd) + zzs(iZzd).zzj(z2);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzk(boolean z2) {
        if (this.zzb != 0) {
            int iZze = z2 ? this.zzc.zze() : 0;
            while (zzs(iZze).zzg()) {
                iZze = zzw(iZze, z2);
                if (iZze == -1) {
                }
            }
            return zzu(iZze) + zzs(iZze).zzk(z2);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd zzo(Object obj, zzbd zzbdVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzr = zzr(obj2);
        int iZzu = zzu(iZzr);
        zzs(iZzr).zzo(obj3, zzbdVar);
        zzbdVar.zzc += iZzu;
        zzbdVar.zzb = obj;
        return zzbdVar;
    }

    protected abstract int zzp(int i3);

    protected abstract int zzq(int i3);

    protected abstract int zzr(Object obj);

    protected abstract zzbf zzs(int i3);

    protected abstract int zzt(int i3);

    protected abstract int zzu(int i3);

    protected abstract Object zzv(int i3);
}
