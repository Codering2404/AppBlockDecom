package com.applovin.impl;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class v8 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f64409a;
    }

    private static boolean a(ah ahVar, z8 z8Var, int i3) {
        int iB = b(ahVar, i3);
        return iB != -1 && iB <= z8Var.f65389b;
    }

    private static boolean b(ah ahVar, z8 z8Var, int i3) {
        int i4 = z8Var.f65392e;
        if (i3 == 0) {
            return true;
        }
        if (i3 <= 11) {
            return i3 == z8Var.f65393f;
        }
        if (i3 == 12) {
            return ahVar.w() * 1000 == i4;
        }
        if (i3 <= 14) {
            int iC = ahVar.C();
            if (i3 == 14) {
                iC *= 10;
            }
            if (iC == i4) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(ah ahVar, int i3) {
        return ahVar.w() == xp.b(ahVar.c(), i3, ahVar.d() - 1, 0);
    }

    private static boolean b(int i3, z8 z8Var) {
        return i3 <= 7 ? i3 == z8Var.f65394g - 1 : i3 <= 10 && z8Var.f65394g == 2;
    }

    private static boolean a(ah ahVar, z8 z8Var, boolean z2, a aVar) {
        try {
            long jD = ahVar.D();
            if (!z2) {
                jD *= (long) z8Var.f65389b;
            }
            aVar.f64409a = jD;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static int b(ah ahVar, int i3) {
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i3 - 2);
            case 6:
                return ahVar.w() + 1;
            case 7:
                return ahVar.C() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return Function.MAX_NARGS << (i3 - 8);
            default:
                return -1;
        }
    }

    public static boolean a(ah ahVar, z8 z8Var, int i3, a aVar) {
        int iD = ahVar.d();
        long jY = ahVar.y();
        long j3 = jY >>> 16;
        if (j3 != i3) {
            return false;
        }
        return b((int) ((jY >> 4) & 15), z8Var) && a((int) ((jY >> 1) & 7), z8Var) && !(((jY & 1) > 1L ? 1 : ((jY & 1) == 1L ? 0 : -1)) == 0) && a(ahVar, z8Var, ((j3 & 1) > 1L ? 1 : ((j3 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(ahVar, z8Var, (int) ((jY >> 12) & 15)) && b(ahVar, z8Var, (int) ((jY >> 8) & 15)) && a(ahVar, iD);
    }

    private static boolean a(int i3, z8 z8Var) {
        return i3 == 0 || i3 == z8Var.f65396i;
    }

    public static boolean a(k8 k8Var, z8 z8Var, int i3, a aVar) {
        long jD = k8Var.d();
        byte[] bArr = new byte[2];
        k8Var.c(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i3) {
            k8Var.b();
            k8Var.c((int) (jD - k8Var.f()));
            return false;
        }
        ah ahVar = new ah(16);
        System.arraycopy(bArr, 0, ahVar.c(), 0, 2);
        ahVar.e(m8.a(k8Var, ahVar.c(), 2, 14));
        k8Var.b();
        k8Var.c((int) (jD - k8Var.f()));
        return a(ahVar, z8Var, i3, aVar);
    }

    public static long a(k8 k8Var, z8 z8Var) throws ch {
        k8Var.b();
        k8Var.c(1);
        byte[] bArr = new byte[1];
        k8Var.c(bArr, 0, 1);
        boolean z2 = (bArr[0] & 1) == 1;
        k8Var.c(2);
        int i3 = z2 ? 7 : 6;
        ah ahVar = new ah(i3);
        ahVar.e(m8.a(k8Var, ahVar.c(), 0, i3));
        k8Var.b();
        a aVar = new a();
        if (a(ahVar, z8Var, z2, aVar)) {
            return aVar.f64409a;
        }
        throw ch.a(null, null);
    }
}
