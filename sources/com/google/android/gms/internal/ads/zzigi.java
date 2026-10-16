package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigi {
    public static final /* synthetic */ int zza = 0;
    private static final zzigt zzb;

    static {
        int i3 = zzicn.zza;
        zzb = new zzigv();
    }

    static int zzA(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzidj.zzF(i3 << 3) + 4);
    }

    static int zzB(List list) {
        return list.size() * 8;
    }

    static int zzC(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzidj.zzF(i3 << 3) + 8);
    }

    static int zzD(int i3, Object obj, zzigh zzighVar) {
        int iZzF;
        int iZzaT;
        int iZzF2;
        int i4 = i3 << 3;
        if (obj instanceof zziez) {
            iZzF = zzidj.zzF(i4);
            iZzaT = ((zziez) obj).zzb();
            iZzF2 = zzidj.zzF(iZzaT);
        } else {
            iZzF = zzidj.zzF(i4);
            iZzaT = ((zzicj) obj).zzaT(zzighVar);
            iZzF2 = zzidj.zzF(iZzaT);
        }
        return iZzF + iZzF2 + iZzaT;
    }

    @Deprecated
    static int zzE(int i3, zzifp zzifpVar, zzigh zzighVar) {
        int iZzF = zzidj.zzF(i3 << 3);
        return iZzF + iZzF + ((zzicj) zzifpVar).zzaT(zzighVar);
    }

    public static zzigt zzF() {
        return zzb;
    }

    static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzH(zzidp zzidpVar, Object obj, Object obj2) {
        if (((zziea) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzI(zzigt zzigtVar, Object obj, Object obj2) {
        zziee zzieeVar = (zziee) obj;
        zzigu zziguVarZzc = zzieeVar.zzt;
        zzigu zziguVar = ((zziee) obj2).zzt;
        if (!zzigu.zza().equals(zziguVar)) {
            if (zzigu.zza().equals(zziguVarZzc)) {
                zziguVarZzc = zzigu.zzc(zziguVarZzc, zziguVar);
            } else {
                zziguVarZzc.zzm(zziguVar);
            }
        }
        zzieeVar.zzt = zziguVarZzc;
    }

    static Object zzJ(Object obj, int i3, List list, zziek zziekVar, Object obj2, zzigt zzigtVar) {
        if (zziekVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zziekVar.zza(iIntValue)) {
                    obj2 = zzK(obj, i3, iIntValue, obj2, zzigtVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Integer num = (Integer) list.get(i5);
            int iIntValue2 = num.intValue();
            if (zziekVar.zza(iIntValue2)) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = zzK(obj, i3, iIntValue2, obj2, zzigtVar);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }

    static Object zzK(Object obj, int i3, int i4, Object obj2, zzigt zzigtVar) {
        if (obj2 == null) {
            obj2 = zzigtVar.zzh(obj);
        }
        zzigtVar.zza(obj2, i3, i4);
        return obj2;
    }

    public static void zza(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzC(i3, list, z2);
    }

    public static void zzb(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzB(i3, list, z2);
    }

    public static void zzc(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzy(i3, list, z2);
    }

    public static void zzd(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzz(i3, list, z2);
    }

    public static void zze(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzL(i3, list, z2);
    }

    public static void zzf(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzA(i3, list, z2);
    }

    public static void zzg(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzJ(i3, list, z2);
    }

    public static void zzh(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzw(i3, list, z2);
    }

    public static void zzi(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzH(i3, list, z2);
    }

    public static void zzj(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzK(i3, list, z2);
    }

    public static void zzk(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzx(i3, list, z2);
    }

    public static void zzl(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzI(i3, list, z2);
    }

    public static void zzm(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzD(i3, list, z2);
    }

    public static void zzn(int i3, List list, zzihi zzihiVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzE(i3, list, z2);
    }

    public static void zzo(int i3, List list, zzihi zzihiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzF(i3, list);
    }

    public static void zzp(int i3, List list, zzihi zzihiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzihiVar.zzG(i3, list);
    }

    public static void zzq(int i3, List list, zzihi zzihiVar, zzigh zzighVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((zzidk) zzihiVar).zzr(i3, list.get(i4), zzighVar);
        }
    }

    public static void zzr(int i3, List list, zzihi zzihiVar, zzigh zzighVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((zzidk) zzihiVar).zzs(i3, list.get(i4), zzighVar);
        }
    }

    static int zzs(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i3 < size) {
                iZzG += zzidj.zzG(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i3 < size) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i3));
            i3++;
        }
        return iZzG2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i3 < size) {
                iZzG += zzidj.zzG(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i3 < size) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i3));
            i3++;
        }
        return iZzG2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzifd)) {
            int iZzG = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzG += zzidj.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzG;
        }
        zzifd zzifdVar = (zzifd) list;
        int iZzG2 = 0;
        while (i3 < size) {
            long jZzc = zzifdVar.zzc(i3);
            iZzG2 += zzidj.zzG((jZzc >> 63) ^ (jZzc + jZzc));
            i3++;
        }
        return iZzG2;
    }

    static int zzv(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzG = 0;
            while (i3 < size) {
                iZzG += zzidj.zzG(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzG;
        }
        zzief zziefVar = (zzief) list;
        int iZzG2 = 0;
        while (i3 < size) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i3));
            i3++;
        }
        return iZzG2;
    }

    static int zzw(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzG = 0;
            while (i3 < size) {
                iZzG += zzidj.zzG(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzG;
        }
        zzief zziefVar = (zzief) list;
        int iZzG2 = 0;
        while (i3 < size) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i3));
            i3++;
        }
        return iZzG2;
    }

    static int zzx(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzF = 0;
            while (i3 < size) {
                iZzF += zzidj.zzF(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzF;
        }
        zzief zziefVar = (zzief) list;
        int iZzF2 = 0;
        while (i3 < size) {
            iZzF2 += zzidj.zzF(zziefVar.zzf(i3));
            i3++;
        }
        return iZzF2;
    }

    static int zzy(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzief)) {
            int iZzF = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzF += zzidj.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzF;
        }
        zzief zziefVar = (zzief) list;
        int iZzF2 = 0;
        while (i3 < size) {
            int iZzf = zziefVar.zzf(i3);
            iZzF2 += zzidj.zzF((iZzf >> 31) ^ (iZzf + iZzf));
            i3++;
        }
        return iZzF2;
    }

    static int zzz(List list) {
        return list.size() * 4;
    }
}
