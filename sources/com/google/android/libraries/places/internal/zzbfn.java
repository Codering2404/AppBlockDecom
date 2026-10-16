package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzbfy f76154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f76155b = 0;

    static {
        int i3 = zzbcc.f75986a;
        f76154a = new zzbga();
    }

    static int A(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbdr)) {
            int iB = 0;
            while (i3 < size) {
                iB += zzbcu.B(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iB;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        int iB2 = 0;
        while (i3 < size) {
            iB2 += zzbcu.B(zzbdrVar.zzf(i3));
            i3++;
        }
        return iB2;
    }

    static int B(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbdr)) {
            int iB = 0;
            while (i3 < size) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                iB += zzbcu.B((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return iB;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        int iB2 = 0;
        while (i3 < size) {
            int iZzf = zzbdrVar.zzf(i3);
            iB2 += zzbcu.B((iZzf >> 31) ^ (iZzf + iZzf));
            i3++;
        }
        return iB2;
    }

    static int C(List list) {
        return list.size() * 4;
    }

    static int D(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbcu.B(i3 << 3) + 4);
    }

    static int E(List list) {
        return list.size() * 8;
    }

    static int F(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbcu.B(i3 << 3) + 8);
    }

    static int G(int i3, Object obj, zzbfl zzbflVar) {
        int iB;
        int iD;
        int iB2;
        int i4 = i3 << 3;
        if (obj instanceof zzbei) {
            iB = zzbcu.B(i4);
            iD = ((zzbei) obj).b();
            iB2 = zzbcu.B(iD);
        } else {
            iB = zzbcu.B(i4);
            iD = ((zzbby) obj).d(zzbflVar);
            iB2 = zzbcu.B(iD);
        }
        return iB + iB2 + iD;
    }

    static int a(int i3, zzbex zzbexVar, zzbfl zzbflVar) {
        int iB = zzbcu.B(i3 << 3);
        return iB + iB + ((zzbby) zzbexVar).d(zzbflVar);
    }

    public static zzbfy b() {
        return f76154a;
    }

    static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void d(zzbdc zzbdcVar, Object obj, Object obj2) {
        zzbdg zzbdgVar = ((zzbdn) obj2).zzb;
        if (zzbdgVar.f76045a.isEmpty()) {
            return;
        }
        zzbdcVar.a(obj).h(zzbdgVar);
    }

    static void e(zzbfy zzbfyVar, Object obj, Object obj2) {
        zzbdq zzbdqVar = (zzbdq) obj;
        zzbfz zzbfzVarC = zzbdqVar.zzc;
        zzbfz zzbfzVar = ((zzbdq) obj2).zzc;
        if (!zzbfz.a().equals(zzbfzVar)) {
            if (zzbfz.a().equals(zzbfzVarC)) {
                zzbfzVarC = zzbfz.c(zzbfzVarC, zzbfzVar);
            } else {
                zzbfzVarC.l(zzbfzVar);
            }
        }
        zzbdqVar.zzc = zzbfzVarC;
    }

    static Object f(Object obj, int i3, List list, zzbdw zzbdwVar, Object obj2, zzbfy zzbfyVar) {
        if (zzbdwVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzbdwVar.zza(iIntValue)) {
                    obj2 = g(obj, i3, iIntValue, obj2, zzbfyVar);
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
            if (zzbdwVar.zza(iIntValue2)) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = g(obj, i3, iIntValue2, obj2, zzbfyVar);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }

    static Object g(Object obj, int i3, int i4, Object obj2, zzbfy zzbfyVar) {
        if (obj2 == null) {
            obj2 = zzbfyVar.h(obj);
        }
        zzbfyVar.a(obj2, i3, i4);
        return obj2;
    }

    public static void h(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzC(i3, list, z2);
    }

    public static void i(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzB(i3, list, z2);
    }

    public static void j(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzy(i3, list, z2);
    }

    public static void k(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzz(i3, list, z2);
    }

    public static void l(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzL(i3, list, z2);
    }

    public static void m(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzA(i3, list, z2);
    }

    public static void n(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzJ(i3, list, z2);
    }

    public static void o(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzw(i3, list, z2);
    }

    public static void p(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzH(i3, list, z2);
    }

    public static void q(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzK(i3, list, z2);
    }

    public static void r(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzx(i3, list, z2);
    }

    public static void s(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzI(i3, list, z2);
    }

    public static void t(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzD(i3, list, z2);
    }

    public static void u(int i3, List list, zzbgl zzbglVar, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbglVar.zzE(i3, list, z2);
    }

    static int v(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iC = 0;
            while (i3 < size) {
                iC += zzbcu.C(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iC;
        }
        zzbem zzbemVar = (zzbem) list;
        int iC2 = 0;
        while (i3 < size) {
            iC2 += zzbcu.C(zzbemVar.d(i3));
            i3++;
        }
        return iC2;
    }

    static int w(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iC = 0;
            while (i3 < size) {
                iC += zzbcu.C(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iC;
        }
        zzbem zzbemVar = (zzbem) list;
        int iC2 = 0;
        while (i3 < size) {
            iC2 += zzbcu.C(zzbemVar.d(i3));
            i3++;
        }
        return iC2;
    }

    static int x(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iC = 0;
            while (i3 < size) {
                long jLongValue = ((Long) list.get(i3)).longValue();
                iC += zzbcu.C((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return iC;
        }
        zzbem zzbemVar = (zzbem) list;
        int iC2 = 0;
        while (i3 < size) {
            long jD = zzbemVar.d(i3);
            iC2 += zzbcu.C((jD >> 63) ^ (jD + jD));
            i3++;
        }
        return iC2;
    }

    static int y(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbdr)) {
            int iC = 0;
            while (i3 < size) {
                iC += zzbcu.C(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iC;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        int iC2 = 0;
        while (i3 < size) {
            iC2 += zzbcu.C(zzbdrVar.zzf(i3));
            i3++;
        }
        return iC2;
    }

    static int z(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbdr)) {
            int iC = 0;
            while (i3 < size) {
                iC += zzbcu.C(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iC;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        int iC2 = 0;
        while (i3 < size) {
            iC2 += zzbcu.C(zzbdrVar.zzf(i3));
            i3++;
        }
        return iC2;
    }
}
