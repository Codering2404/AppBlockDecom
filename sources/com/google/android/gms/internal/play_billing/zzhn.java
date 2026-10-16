package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzib zzb;

    static {
        int i3 = zzei.zza;
        zzb = new zzid();
    }

    public static void zzA(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzB(i3, list, z2);
    }

    public static void zzB(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzD(i3, list, z2);
    }

    public static void zzC(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzF(i3, list, z2);
    }

    public static void zzD(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzK(i3, list, z2);
    }

    public static void zzE(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzM(i3, list, z2);
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Deprecated
    static int zza(int i3, zzhb zzhbVar, zzhl zzhlVar) {
        int iZzy = zzfc.zzy(i3 << 3);
        return iZzy + iZzy + ((zzeg) zzhbVar).zzi(zzhlVar);
    }

    static int zzb(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzfc.zzz(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzz;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzc(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i3 << 3) + 4);
    }

    static int zzd(List list) {
        return list.size() * 4;
    }

    static int zze(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i3 << 3) + 8);
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
        if (!(list instanceof zzfv)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzfc.zzz(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzz;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzh(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzfc.zzz(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzz;
        }
        zzgp zzgpVar = (zzgp) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzfc.zzz(zzgpVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    static int zzi(int i3, Object obj, zzhl zzhlVar) {
        int iZzy;
        int iZzi;
        int iZzy2;
        int i4 = i3 << 3;
        if (obj instanceof zzgi) {
            iZzy = zzfc.zzy(i4);
            iZzi = ((zzgi) obj).zza();
            iZzy2 = zzfc.zzy(iZzi);
        } else {
            iZzy = zzfc.zzy(i4);
            iZzi = ((zzeg) obj).zzi(zzhlVar);
            iZzy2 = zzfc.zzy(iZzi);
        }
        return iZzy + iZzy2 + iZzi;
    }

    static int zzj(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzy = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iZzy += zzfc.zzy((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iZzy;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzy2 = 0;
        while (i3 < size) {
            int iZze = zzfvVar.zze(i3);
            iZzy2 += zzfc.zzy((iZze >> 31) ^ (iZze + iZze));
            i3++;
        }
        return iZzy2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int iZzz = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iZzz += zzfc.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iZzz;
        }
        zzgp zzgpVar = (zzgp) list;
        int iZzz2 = 0;
        while (i3 < size) {
            long jZze = zzgpVar.zze(i3);
            iZzz2 += zzfc.zzz((jZze >> 63) ^ (jZze + jZze));
            i3++;
        }
        return iZzz2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzy = 0;
            while (i3 < size) {
                iZzy += zzfc.zzy(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iZzy;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzy2 = 0;
        while (i3 < size) {
            iZzy2 += zzfc.zzy(zzfvVar.zze(i3));
            i3++;
        }
        return iZzy2;
    }

    static int zzm(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int iZzz = 0;
            while (i3 < size) {
                iZzz += zzfc.zzz(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iZzz;
        }
        zzgp zzgpVar = (zzgp) list;
        int iZzz2 = 0;
        while (i3 < size) {
            iZzz2 += zzfc.zzz(zzgpVar.zze(i3));
            i3++;
        }
        return iZzz2;
    }

    public static zzib zzn() {
        return zzb;
    }

    static Object zzo(Object obj, int i3, int i4, Object obj2, zzib zzibVar) {
        if (obj2 == null) {
            obj2 = zzibVar.zza(obj);
        }
        ((zzic) obj2).zzj(i3 << 3, Long.valueOf(i4));
        return obj2;
    }

    static void zzp(zzfi zzfiVar, Object obj, Object obj2) {
        if (((zzfr) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzq(zzib zzibVar, Object obj, Object obj2) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVarZze = zzfuVar.zzc;
        zzic zzicVar = ((zzfu) obj2).zzc;
        if (!zzic.zzc().equals(zzicVar)) {
            if (zzic.zzc().equals(zzicVarZze)) {
                zzicVarZze = zzic.zze(zzicVarZze, zzicVar);
            } else {
                zzicVarZze.zzd(zzicVar);
            }
        }
        zzfuVar.zzc = zzicVarZze;
    }

    public static void zzr(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzc(i3, list, z2);
    }

    public static void zzs(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzg(i3, list, z2);
    }

    public static void zzt(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzj(i3, list, z2);
    }

    public static void zzu(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzl(i3, list, z2);
    }

    public static void zzv(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzn(i3, list, z2);
    }

    public static void zzw(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzp(i3, list, z2);
    }

    public static void zzx(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzs(i3, list, z2);
    }

    public static void zzy(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzu(i3, list, z2);
    }

    public static void zzz(int i3, List list, zzit zzitVar, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzz(i3, list, z2);
    }
}
