package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsc {
    public static final /* synthetic */ int zza = 0;
    private static final zzsp zzb;

    static {
        int i3 = zzpc.zza;
        zzb = new zzsr();
    }

    public static void zzA(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzC(i3, list, z2);
    }

    public static void zzB(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzE(i3, list, z2);
    }

    public static void zzC(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzI(i3, list, z2);
    }

    public static void zzD(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzK(i3, list, z2);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Deprecated
    static int zza(int i3, zzrq zzrqVar, zzsa zzsaVar) {
        int iZzC = zzpv.zzC(i3 << 3);
        return iZzC + iZzC + ((zzpa) zzrqVar).zzj(zzsaVar);
    }

    static int zzb(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzqn)) {
            int iZzD = 0;
            while (i3 < size) {
                iZzD += zzpv.zzD(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzD;
        }
        zzqn zzqnVar = (zzqn) list;
        int iZzD2 = 0;
        while (i3 < size) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i3));
            i3++;
        }
        return iZzD2;
    }

    static int zzc(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzpv.zzC(i3 << 3) + 4);
    }

    static int zzd(List list) {
        return list.size() * 4;
    }

    static int zze(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzpv.zzC(i3 << 3) + 8);
    }

    static int zzf(List list) {
        return list.size() * 8;
    }

    static int zzg(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzqn)) {
            int iZzD = 0;
            while (i3 < size) {
                iZzD += zzpv.zzD(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzD;
        }
        zzqn zzqnVar = (zzqn) list;
        int iZzD2 = 0;
        while (i3 < size) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i3));
            i3++;
        }
        return iZzD2;
    }

    static int zzh(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzre)) {
            int iZzD = 0;
            while (i3 < size) {
                iZzD += zzpv.zzD(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzD;
        }
        zzre zzreVar = (zzre) list;
        int iZzD2 = 0;
        while (i3 < size) {
            iZzD2 += zzpv.zzD(zzreVar.zze(i3));
            i3++;
        }
        return iZzD2;
    }

    static int zzi(int i3, Object obj, zzsa zzsaVar) {
        int iZzC;
        int iZzj;
        int iZzC2;
        int i4 = i3 << 3;
        if (obj instanceof zzra) {
            iZzC = zzpv.zzC(i4);
            iZzj = ((zzra) obj).zza();
            iZzC2 = zzpv.zzC(iZzj);
        } else {
            iZzC = zzpv.zzC(i4);
            iZzj = ((zzpa) obj).zzj(zzsaVar);
            iZzC2 = zzpv.zzC(iZzj);
        }
        return iZzC + iZzC2 + iZzj;
    }

    static int zzj(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzqn)) {
            int iZzC = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzC += zzpv.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzC;
        }
        zzqn zzqnVar = (zzqn) list;
        int iZzC2 = 0;
        while (i3 < size) {
            int iZze = zzqnVar.zze(i3);
            iZzC2 += zzpv.zzC((iZze >> 31) ^ (iZze + iZze));
            i3++;
        }
        return iZzC2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzre)) {
            int iZzD = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzD += zzpv.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzD;
        }
        zzre zzreVar = (zzre) list;
        int iZzD2 = 0;
        while (i3 < size) {
            long jZze = zzreVar.zze(i3);
            iZzD2 += zzpv.zzD((jZze >> 63) ^ (jZze + jZze));
            i3++;
        }
        return iZzD2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzqn)) {
            int iZzC = 0;
            while (i3 < size) {
                iZzC += zzpv.zzC(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzC;
        }
        zzqn zzqnVar = (zzqn) list;
        int iZzC2 = 0;
        while (i3 < size) {
            iZzC2 += zzpv.zzC(zzqnVar.zze(i3));
            i3++;
        }
        return iZzC2;
    }

    static int zzm(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzre)) {
            int iZzD = 0;
            while (i3 < size) {
                iZzD += zzpv.zzD(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzD;
        }
        zzre zzreVar = (zzre) list;
        int iZzD2 = 0;
        while (i3 < size) {
            iZzD2 += zzpv.zzD(zzreVar.zze(i3));
            i3++;
        }
        return iZzD2;
    }

    public static zzsp zzn() {
        return zzb;
    }

    static void zzo(zzqb zzqbVar, Object obj, Object obj2) {
        if (((zzqk) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzsp zzspVar, Object obj, Object obj2) {
        zzqm zzqmVar = (zzqm) obj;
        zzsq zzsqVarZze = zzqmVar.zzc;
        zzsq zzsqVar = ((zzqm) obj2).zzc;
        if (!zzsq.zzc().equals(zzsqVar)) {
            if (zzsq.zzc().equals(zzsqVarZze)) {
                zzsqVarZze = zzsq.zze(zzsqVarZze, zzsqVar);
            } else {
                zzsqVarZze.zzd(zzsqVar);
            }
        }
        zzqmVar.zzc = zzsqVarZze;
    }

    public static void zzq(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzc(i3, list, z2);
    }

    public static void zzr(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzg(i3, list, z2);
    }

    public static void zzs(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzi(i3, list, z2);
    }

    public static void zzt(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzk(i3, list, z2);
    }

    public static void zzu(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzm(i3, list, z2);
    }

    public static void zzv(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzo(i3, list, z2);
    }

    public static void zzw(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzr(i3, list, z2);
    }

    public static void zzx(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzt(i3, list, z2);
    }

    public static void zzy(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzy(i3, list, z2);
    }

    public static void zzz(int i3, List list, zztb zztbVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zztbVar.zzA(i3, list, z2);
    }
}
