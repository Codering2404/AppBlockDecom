package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzand {
    private static final zzanu<?, ?> zza = new zzanw();

    @Deprecated
    static int zza(int i3, zzamm zzammVar, zzanb zzanbVar) {
        return (zzakn.zzh(i3) << 1) + ((zzajm) zzammVar).zza(zzanbVar);
    }

    static int zzb(int i3, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzakn.zzh(i3));
    }

    static int zzc(int i3, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zzb(i3, 0);
    }

    static int zzd(int i3, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i3, 0L);
    }

    static int zze(int i3, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzakn.zzh(i3));
    }

    static int zzf(int i3, List<Long> list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzakn.zzh(i3));
    }

    static int zzg(int i3, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzakn.zzh(i3));
    }

    static int zzh(int i3, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzakn.zzh(i3));
    }

    static int zzi(int i3, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzakn.zzh(i3));
    }

    static int zzj(int i3, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzakn.zzh(i3));
    }

    public static void zzk(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzk(i3, list, z2);
    }

    public static void zzl(int i3, List<Long> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzl(i3, list, z2);
    }

    public static void zzm(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzm(i3, list, z2);
    }

    public static void zzn(int i3, List<Long> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzn(i3, list, z2);
    }

    private static int zza(zzajm zzajmVar, zzanb zzanbVar) {
        return zzakn.zzd(zzajmVar.zza(zzanbVar));
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zzb(List<Integer> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZza = 0;
            while (i3 < size) {
                iZza += zzakn.zza(list.get(i3).intValue());
                i3++;
            }
            return iZza;
        }
        zzali zzaliVar = (zzali) list;
        int iZza2 = 0;
        while (i3 < size) {
            iZza2 += zzakn.zza(zzaliVar.zzb(i3));
            i3++;
        }
        return iZza2;
    }

    public static void zzc(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzc(i3, list, z2);
    }

    public static void zzd(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzd(i3, list, z2);
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzc = 0;
            while (i3 < size) {
                iZzc += zzakn.zzc(list.get(i3).intValue());
                i3++;
            }
            return iZzc;
        }
        zzali zzaliVar = (zzali) list;
        int iZzc2 = 0;
        while (i3 < size) {
            iZzc2 += zzakn.zzc(zzaliVar.zzb(i3));
            i3++;
        }
        return iZzc2;
    }

    static int zzf(List<Long> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZzb = 0;
            while (i3 < size) {
                iZzb += zzakn.zzb(list.get(i3).longValue());
                i3++;
            }
            return iZzb;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZzb2 = 0;
        while (i3 < size) {
            iZzb2 += zzakn.zzb(zzalxVar.zzb(i3));
            i3++;
        }
        return iZzb2;
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzg = 0;
            while (i3 < size) {
                iZzg += zzakn.zzg(list.get(i3).intValue());
                i3++;
            }
            return iZzg;
        }
        zzali zzaliVar = (zzali) list;
        int iZzg2 = 0;
        while (i3 < size) {
            iZzg2 += zzakn.zzg(zzaliVar.zzb(i3));
            i3++;
        }
        return iZzg2;
    }

    static int zzh(List<Long> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZzd = 0;
            while (i3 < size) {
                iZzd += zzakn.zzd(list.get(i3).longValue());
                i3++;
            }
            return iZzd;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZzd2 = 0;
        while (i3 < size) {
            iZzd2 += zzakn.zzd(zzalxVar.zzb(i3));
            i3++;
        }
        return iZzd2;
    }

    static int zzi(List<Integer> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzali)) {
            int iZzi = 0;
            while (i3 < size) {
                iZzi += zzakn.zzi(list.get(i3).intValue());
                i3++;
            }
            return iZzi;
        }
        zzali zzaliVar = (zzali) list;
        int iZzi2 = 0;
        while (i3 < size) {
            iZzi2 += zzakn.zzi(zzaliVar.zzb(i3));
            i3++;
        }
        return iZzi2;
    }

    static int zzj(List<Long> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalx)) {
            int iZze = 0;
            while (i3 < size) {
                iZze += zzakn.zze(list.get(i3).longValue());
                i3++;
            }
            return iZze;
        }
        zzalx zzalxVar = (zzalx) list;
        int iZze2 = 0;
        while (i3 < size) {
            iZze2 += zzakn.zze(zzalxVar.zzb(i3));
            i3++;
        }
        return iZze2;
    }

    static int zza(int i3, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i3, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i3, List<zzajv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzh = size * zzakn.zzh(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzh += zzakn.zza(list.get(i4));
        }
        return iZzh;
    }

    static int zzb(int i3, List<?> list, zzanb<?> zzanbVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzh = zzakn.zzh(i3) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            if (obj instanceof zzalu) {
                iZza = zzakn.zza((zzalu) obj);
            } else {
                iZza = zza((zzajm) obj, (zzanb) zzanbVar);
            }
            iZzh += iZza;
        }
        return iZzh;
    }

    public static void zze(int i3, List<Long> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zze(i3, list, z2);
    }

    public static void zzf(int i3, List<Float> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzf(i3, list, z2);
    }

    public static void zzg(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzg(i3, list, z2);
    }

    public static void zzh(int i3, List<Long> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzh(i3, list, z2);
    }

    public static void zzi(int i3, List<Integer> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzi(i3, list, z2);
    }

    public static void zzj(int i3, List<Long> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzj(i3, list, z2);
    }

    static int zza(int i3, List<zzamm> list, zzanb<?> zzanbVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iZza += zza(i3, list.get(i4), (zzanb) zzanbVar);
        }
        return iZza;
    }

    static int zza(int i3, Object obj, zzanb<?> zzanbVar) {
        if (obj instanceof zzalu) {
            return zzakn.zzb(i3, (zzalu) obj);
        }
        return zzakn.zzh(i3) + zza((zzajm) obj, (zzanb) zzanbVar);
    }

    static int zzb(int i3, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzh = zzakn.zzh(i3) * size;
        if (!(list instanceof zzalt)) {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzajv) {
                    iZza = zzakn.zza((zzajv) obj);
                } else {
                    iZza = zzakn.zza((String) obj);
                }
                iZzh += iZza;
                i4++;
            }
            return iZzh;
        }
        zzalt zzaltVar = (zzalt) list;
        while (i4 < size) {
            Object objZza = zzaltVar.zza(i4);
            if (objZza instanceof zzajv) {
                iZza2 = zzakn.zza((zzajv) objZza);
            } else {
                iZza2 = zzakn.zza((String) objZza);
            }
            iZzh += iZza2;
            i4++;
        }
        return iZzh;
    }

    public static zzanu<?, ?> zza() {
        return zza;
    }

    static <UT, UB> UB zza(Object obj, int i3, List<Integer> list, zzalj zzaljVar, UB ub, zzanu<UT, UB> zzanuVar) {
        if (zzaljVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Integer num = list.get(i5);
                int iIntValue = num.intValue();
                if (zzaljVar.zza(iIntValue)) {
                    if (i5 != i4) {
                        list.set(i4, num);
                    }
                    i4++;
                } else {
                    ub = (UB) zza(obj, i3, iIntValue, ub, zzanuVar);
                }
            }
            if (i4 != size) {
                list.subList(i4, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzaljVar.zza(iIntValue2)) {
                ub = (UB) zza(obj, i3, iIntValue2, ub, zzanuVar);
                it.remove();
            }
        }
        return ub;
    }

    public static void zzb(int i3, List<Double> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i3, list, z2);
    }

    public static void zzb(int i3, List<?> list, zzaol zzaolVar, zzanb<?> zzanbVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i3, list, (zzanb) zzanbVar);
    }

    static <UT, UB> UB zza(Object obj, int i3, int i4, UB ub, zzanu<UT, UB> zzanuVar) {
        if (ub == null) {
            ub = zzanuVar.zzc(obj);
        }
        zzanuVar.zzb(ub, i3, i4);
        return ub;
    }

    public static void zzb(int i3, List<String> list, zzaol zzaolVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zzb(i3, list);
    }

    static <T, FT extends zzakz<FT>> void zza(zzakw<FT> zzakwVar, T t2, T t3) {
        zzakx<T> zzakxVarZza = zzakwVar.zza(t3);
        if (zzakxVarZza.zza.isEmpty()) {
            return;
        }
        zzakwVar.zzb(t2).zza((zzakx) zzakxVarZza);
    }

    static <T> void zza(zzamf zzamfVar, T t2, T t3, long j3) {
        zzanz.zza(t2, j3, zzamfVar.zza(zzanz.zze(t2, j3), zzanz.zze(t3, j3)));
    }

    static <T, UT, UB> void zza(zzanu<UT, UB> zzanuVar, T t2, T t3) {
        zzanuVar.zzc(t2, zzanuVar.zza(zzanuVar.zzd(t2), zzanuVar.zzd(t3)));
    }

    public static void zza(Class<?> cls) {
        zzalf.class.isAssignableFrom(cls);
    }

    public static void zza(int i3, List<Boolean> list, zzaol zzaolVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i3, list, z2);
    }

    public static void zza(int i3, List<zzajv> list, zzaol zzaolVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i3, list);
    }

    public static void zza(int i3, List<?> list, zzaol zzaolVar, zzanb<?> zzanbVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaolVar.zza(i3, list, (zzanb) zzanbVar);
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
