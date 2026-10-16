package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb;

    static {
        int i3 = zzos.zza;
        zzb = new zzpn();
    }

    public static void zzA(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzA(i3, list, z2);
    }

    public static void zzB(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzC(i3, list, z2);
    }

    public static void zzC(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzE(i3, list, z2);
    }

    public static void zzD(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzJ(i3, list, z2);
    }

    public static void zzE(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzL(i3, list, z2);
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i3 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i3 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i3));
            i3++;
        }
        return iZzB2;
    }

    static int zzb(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i3 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i3 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzB = 0;
            while (i3 < size) {
                iZzB += zzln.zzB(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzB;
        }
        zzne zzneVar = (zzne) list;
        int iZzB2 = 0;
        while (i3 < size) {
            iZzB2 += zzln.zzB(zzneVar.zze(i3));
            i3++;
        }
        return iZzB2;
    }

    static int zzg(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i3 < size) {
                iZzB += zzln.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i3 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i3));
            i3++;
        }
        return iZzB2;
    }

    static int zzh(int i3, Object obj, zzow zzowVar) {
        int i4 = i3 << 3;
        if (!(obj instanceof zznt)) {
            return zzln.zzA(i4) + zzln.zzy((zzoi) obj, zzowVar);
        }
        int iZzA = zzln.zzA(i4);
        int iZza = ((zznt) obj).zza();
        return iZzA + zzln.zzA(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzA += zzln.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i3 < size) {
            int iZze = zzneVar.zze(i3);
            iZzA2 += zzln.zzA((iZze >> 31) ^ (iZze + iZze));
            i3++;
        }
        return iZzA2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzB += zzln.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i3 < size) {
            long jZze = zznxVar.zze(i3);
            iZzB2 += zzln.zzB((jZze >> 63) ^ (jZze + jZze));
            i3++;
        }
        return iZzB2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzne)) {
            int iZzA = 0;
            while (i3 < size) {
                iZzA += zzln.zzA(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzA;
        }
        zzne zzneVar = (zzne) list;
        int iZzA2 = 0;
        while (i3 < size) {
            iZzA2 += zzln.zzA(zzneVar.zze(i3));
            i3++;
        }
        return iZzA2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zznx)) {
            int iZzB = 0;
            while (i3 < size) {
                iZzB += zzln.zzB(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzB;
        }
        zznx zznxVar = (zznx) list;
        int iZzB2 = 0;
        while (i3 < size) {
            iZzB2 += zzln.zzB(zznxVar.zze(i3));
            i3++;
        }
        return iZzB2;
    }

    public static zzpl zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i3, List list, zznh zznhVar, Object obj2, zzpl zzplVar) {
        if (zznhVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zznhVar.zza(iIntValue)) {
                    obj2 = zzo(obj, i3, iIntValue, obj2, zzplVar);
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
            if (zznhVar.zza(iIntValue2)) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = zzo(obj, i3, iIntValue2, obj2, zzplVar);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }

    static Object zzo(Object obj, int i3, int i4, Object obj2, zzpl zzplVar) {
        if (obj2 == null) {
            obj2 = zzplVar.zza(obj);
        }
        zzplVar.zzh(obj2, i3, i4);
        return obj2;
    }

    static void zzp(zzmp zzmpVar, Object obj, Object obj2) {
        zzmt zzmtVar = ((zzna) obj2).zzb;
        if (zzmtVar.zza.isEmpty()) {
            return;
        }
        ((zzna) obj).zzi().zzh(zzmtVar);
    }

    static void zzq(zzpl zzplVar, Object obj, Object obj2) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVarZze = zzndVar.zzc;
        zzpm zzpmVar = ((zznd) obj2).zzc;
        if (!zzpm.zzc().equals(zzpmVar)) {
            if (zzpm.zzc().equals(zzpmVarZze)) {
                zzpmVarZze = zzpm.zze(zzpmVarZze, zzpmVar);
            } else {
                zzpmVarZze.zzd(zzpmVar);
            }
        }
        zzndVar.zzc = zzpmVarZze;
    }

    public static void zzr(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzc(i3, list, z2);
    }

    public static void zzs(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzg(i3, list, z2);
    }

    public static void zzt(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzj(i3, list, z2);
    }

    public static void zzu(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzl(i3, list, z2);
    }

    public static void zzv(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzn(i3, list, z2);
    }

    public static void zzw(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzp(i3, list, z2);
    }

    public static void zzx(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzs(i3, list, z2);
    }

    public static void zzy(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzu(i3, list, z2);
    }

    public static void zzz(int i3, List list, zzpy zzpyVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzy(i3, list, z2);
    }
}
