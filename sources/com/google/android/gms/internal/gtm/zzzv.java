package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzv {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzaak zzc;
    private static final zzaak zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzaak zzaakVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzaakVar = (zzaak) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzaakVar;
        zzd = new zzaam();
    }

    public static void zzA(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzp(i3, list, z2);
    }

    public static void zzB(int i3, List list, zzur zzurVar, zzzt zzztVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzurVar.zzq(i3, list.get(i4), zzztVar);
        }
    }

    public static void zzC(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzs(i3, list, z2);
    }

    public static void zzD(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzu(i3, list, z2);
    }

    public static void zzE(int i3, List list, zzur zzurVar, zzzt zzztVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzurVar.zzv(i3, list.get(i4), zzztVar);
        }
    }

    public static void zzF(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzy(i3, list, z2);
    }

    public static void zzG(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzA(i3, list, z2);
    }

    public static void zzH(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzC(i3, list, z2);
    }

    public static void zzI(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzE(i3, list, z2);
    }

    public static void zzJ(int i3, List list, zzur zzurVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzH(i3, list);
    }

    public static void zzK(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzJ(i3, list, z2);
    }

    public static void zzL(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzL(i3, list, z2);
    }

    static int zza(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzxw)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzuq.zzz(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzz;
        }
        zzxw zzxwVar = (zzxw) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzuq.zzz(zzxwVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzb(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzuq.zzD(i3 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzuq.zzD(i3 << 3) + 8);
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
        if (!(list instanceof zzxw)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzuq.zzz(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzz;
        }
        zzxw zzxwVar = (zzxw) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzuq.zzz(zzxwVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzg(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzyv)) {
            int iZzE = 0;
            while (i3 < size) {
                iZzE += zzuq.zzE(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzE;
        }
        zzyv zzyvVar = (zzyv) list;
        int iZzE2 = 0;
        while (i3 < size) {
            iZzE2 += zzuq.zzE(zzyvVar.zze(i3));
            i3++;
        }
        return iZzE2;
    }

    static int zzh(int i3, Object obj, zzzt zzztVar) {
        int i4 = i3 << 3;
        if (!(obj instanceof zzym)) {
            return zzuq.zzD(i4) + zzuq.zzB((zzzg) obj, zzztVar);
        }
        int i5 = zzuq.zzf;
        int iZza = ((zzym) obj).zza();
        return zzuq.zzD(i4) + zzuq.zzD(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzxw)) {
            int iZzD = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzD += zzuq.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzD;
        }
        zzxw zzxwVar = (zzxw) list;
        int iZzD2 = 0;
        while (i3 < size) {
            int iZze = zzxwVar.zze(i3);
            iZzD2 += zzuq.zzD((iZze >> 31) ^ (iZze + iZze));
            i3++;
        }
        return iZzD2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzyv)) {
            int iZzE = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzE += zzuq.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzE;
        }
        zzyv zzyvVar = (zzyv) list;
        int iZzE2 = 0;
        while (i3 < size) {
            long jZze = zzyvVar.zze(i3);
            iZzE2 += zzuq.zzE((jZze >> 63) ^ (jZze + jZze));
            i3++;
        }
        return iZzE2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzxw)) {
            int iZzD = 0;
            while (i3 < size) {
                iZzD += zzuq.zzD(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzD;
        }
        zzxw zzxwVar = (zzxw) list;
        int iZzD2 = 0;
        while (i3 < size) {
            iZzD2 += zzuq.zzD(zzxwVar.zze(i3));
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
        if (!(list instanceof zzyv)) {
            int iZzE = 0;
            while (i3 < size) {
                iZzE += zzuq.zzE(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzE;
        }
        zzyv zzyvVar = (zzyv) list;
        int iZzE2 = 0;
        while (i3 < size) {
            iZzE2 += zzuq.zzE(zzyvVar.zze(i3));
            i3++;
        }
        return iZzE2;
    }

    public static zzaak zzm() {
        return zzc;
    }

    public static zzaak zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i3, List list, zzxz zzxzVar, Object obj2, zzaak zzaakVar) {
        if (zzxzVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzxzVar.zza(iIntValue)) {
                    obj2 = zzp(obj, i3, iIntValue, obj2, zzaakVar);
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
            if (zzxzVar.zza(iIntValue2)) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = zzp(obj, i3, iIntValue2, obj2, zzaakVar);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }

    static Object zzp(Object obj, int i3, int i4, Object obj2, zzaak zzaakVar) {
        if (obj2 == null) {
            obj2 = zzaakVar.zzc(obj);
        }
        zzaakVar.zzl(obj2, i3, i4);
        return obj2;
    }

    static void zzq(zzxg zzxgVar, Object obj, Object obj2) {
        zzxk zzxkVarZzb = zzxgVar.zzb(obj2);
        if (zzxkVarZzb.zza.isEmpty()) {
            return;
        }
        zzxgVar.zzc(obj).zzj(zzxkVarZzb);
    }

    static void zzr(zzaak zzaakVar, Object obj, Object obj2) {
        zzaakVar.zzo(obj, zzaakVar.zze(zzaakVar.zzd(obj), zzaakVar.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzxv.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzt(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzu(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzc(i3, list, z2);
    }

    public static void zzv(int i3, List list, zzur zzurVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zze(i3, list);
    }

    public static void zzw(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzg(i3, list, z2);
    }

    public static void zzx(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzj(i3, list, z2);
    }

    public static void zzy(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzl(i3, list, z2);
    }

    public static void zzz(int i3, List list, zzur zzurVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzurVar.zzn(i3, list, z2);
    }
}
