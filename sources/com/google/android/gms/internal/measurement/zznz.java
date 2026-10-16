package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznz {
    public static final /* synthetic */ int zza = 0;
    private static final zzoi zzb;

    static {
        int i3 = zznu.zza;
        zzb = new zzok();
    }

    public static zzoi zzA() {
        return zzb;
    }

    static boolean zzB(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzC(zzls zzlsVar, Object obj, Object obj2) {
        if (((zzmc) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzD(zzoi zzoiVar, Object obj, Object obj2) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVarZzc = zzmfVar.zzc;
        zzoj zzojVar = ((zzmf) obj2).zzc;
        if (!zzoj.zza().equals(zzojVar)) {
            if (zzoj.zza().equals(zzojVarZzc)) {
                zzojVarZzc = zzoj.zzc(zzojVarZzc, zzojVar);
            } else {
                zzojVarZzc.zzl(zzojVar);
            }
        }
        zzmfVar.zzc = zzojVarZzc;
    }

    static Object zzE(Object obj, int i3, int i4, Object obj2, zzoi zzoiVar) {
        if (obj2 == null) {
            obj2 = zzoiVar.zza(obj);
        }
        ((zzoj) obj2).zzk(i3 << 3, Long.valueOf(i4));
        return obj2;
    }

    public static void zza(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzC(i3, list, z2);
    }

    public static void zzb(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzB(i3, list, z2);
    }

    public static void zzc(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzy(i3, list, z2);
    }

    public static void zzd(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzz(i3, list, z2);
    }

    public static void zze(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzL(i3, list, z2);
    }

    public static void zzf(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzA(i3, list, z2);
    }

    public static void zzg(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzJ(i3, list, z2);
    }

    public static void zzh(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzw(i3, list, z2);
    }

    public static void zzi(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzH(i3, list, z2);
    }

    public static void zzj(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzK(i3, list, z2);
    }

    public static void zzk(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzx(i3, list, z2);
    }

    public static void zzl(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzI(i3, list, z2);
    }

    public static void zzm(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzD(i3, list, z2);
    }

    public static void zzn(int i3, List list, zzov zzovVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzE(i3, list, z2);
    }

    static int zzo(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i3 < size) {
                iZzA += zzlm.zzA(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i3 < size) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i3));
            i3++;
        }
        return iZzA2;
    }

    static int zzp(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i3 < size) {
                iZzA += zzlm.zzA(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i3 < size) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i3));
            i3++;
        }
        return iZzA2;
    }

    static int zzq(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int iZzA = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzA += zzlm.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzA;
        }
        zzna zznaVar = (zzna) list;
        int iZzA2 = 0;
        while (i3 < size) {
            long jZzc = zznaVar.zzc(i3);
            iZzA2 += zzlm.zzA((jZzc >> 63) ^ (jZzc + jZzc));
            i3++;
        }
        return iZzA2;
    }

    static int zzr(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzA = 0;
            while (i3 < size) {
                iZzA += zzlm.zzA(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzA;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzA2 = 0;
        while (i3 < size) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i3));
            i3++;
        }
        return iZzA2;
    }

    static int zzs(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzA = 0;
            while (i3 < size) {
                iZzA += zzlm.zzA(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzA;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzA2 = 0;
        while (i3 < size) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i3));
            i3++;
        }
        return iZzA2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzlm.zzz(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzz;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int iZzz = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzz += zzlm.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzz;
        }
        zzmg zzmgVar = (zzmg) list;
        int iZzz2 = 0;
        while (i3 < size) {
            int iZzf = zzmgVar.zzf(i3);
            iZzz2 += zzlm.zzz((iZzf >> 31) ^ (iZzf + iZzf));
            i3++;
        }
        return iZzz2;
    }

    static int zzv(List list) {
        return list.size() * 4;
    }

    static int zzw(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i3 << 3) + 4);
    }

    static int zzx(List list) {
        return list.size() * 8;
    }

    static int zzy(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i3 << 3) + 8);
    }

    static int zzz(int i3, Object obj, zznx zznxVar) {
        int i4 = i3 << 3;
        if (!(obj instanceof zzmw)) {
            return zzlm.zzz(i4) + zzlm.zzD((zznm) obj, zznxVar);
        }
        int iZzz = zzlm.zzz(i4);
        int iZzb = ((zzmw) obj).zzb();
        return iZzz + zzlm.zzz(iZzb) + iZzb;
    }
}
