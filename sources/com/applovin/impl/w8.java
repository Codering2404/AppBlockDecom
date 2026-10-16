package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.impl.z8;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class w8 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z8 f64614a;

        public a(z8 z8Var) {
            this.f64614a = z8Var;
        }
    }

    public static boolean a(k8 k8Var) {
        ah ahVar = new ah(4);
        k8Var.c(ahVar.c(), 0, 4);
        return ahVar.y() == 1716281667;
    }

    public static int b(k8 k8Var) throws ch {
        k8Var.b();
        ah ahVar = new ah(2);
        k8Var.c(ahVar.c(), 0, 2);
        int iC = ahVar.C();
        if ((iC >> 2) == 16382) {
            k8Var.b();
            return iC;
        }
        k8Var.b();
        throw ch.a("First frame does not start with sync code.", null);
    }

    private static z8 c(k8 k8Var) {
        byte[] bArr = new byte[38];
        k8Var.d(bArr, 0, 38);
        return new z8(bArr, 4);
    }

    public static void d(k8 k8Var) throws ch {
        ah ahVar = new ah(4);
        k8Var.d(ahVar.c(), 0, 4);
        if (ahVar.y() != 1716281667) {
            throw ch.a("Failed to read FLAC stream marker.", null);
        }
    }

    public static af a(k8 k8Var, boolean z2) throws Throwable {
        af afVarA = new ya().a(k8Var, z2 ? null : wa.f64616b);
        if (afVarA == null || afVarA.c() == 0) {
            return null;
        }
        return afVarA;
    }

    private static List c(k8 k8Var, int i3) {
        ah ahVar = new ah(i3);
        k8Var.d(ahVar.c(), 0, i3);
        ahVar.g(4);
        return Arrays.asList(fr.a(ahVar, false, false).f59808b);
    }

    public static boolean a(k8 k8Var, a aVar) {
        k8Var.b();
        zg zgVar = new zg(new byte[4]);
        k8Var.c(zgVar.f65436a, 0, 4);
        boolean zF = zgVar.f();
        int iA = zgVar.a(7);
        int iA2 = zgVar.a(24) + 4;
        if (iA == 0) {
            aVar.f64614a = c(k8Var);
            return zF;
        }
        z8 z8Var = aVar.f64614a;
        if (z8Var == null) {
            throw new IllegalArgumentException();
        }
        if (iA == 3) {
            aVar.f64614a = z8Var.a(b(k8Var, iA2));
            return zF;
        }
        if (iA == 4) {
            aVar.f64614a = z8Var.b(c(k8Var, iA2));
            return zF;
        }
        if (iA == 6) {
            aVar.f64614a = z8Var.a(Collections.singletonList(a(k8Var, iA2)));
            return zF;
        }
        k8Var.a(iA2);
        return zF;
    }

    public static af b(k8 k8Var, boolean z2) throws Throwable {
        k8Var.b();
        long jD = k8Var.d();
        af afVarA = a(k8Var, z2);
        k8Var.a((int) (k8Var.d() - jD));
        return afVarA;
    }

    private static z8.a b(k8 k8Var, int i3) {
        ah ahVar = new ah(i3);
        k8Var.d(ahVar.c(), 0, i3);
        return a(ahVar);
    }

    public static z8.a a(ah ahVar) {
        ahVar.g(1);
        int iZ = ahVar.z();
        long jD = ((long) ahVar.d()) + ((long) iZ);
        int i3 = iZ / 18;
        long[] jArrCopyOf = new long[i3];
        long[] jArrCopyOf2 = new long[i3];
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            long jS = ahVar.s();
            if (jS == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                break;
            }
            jArrCopyOf[i4] = jS;
            jArrCopyOf2[i4] = ahVar.s();
            ahVar.g(2);
            i4++;
        }
        ahVar.g((int) (jD - ((long) ahVar.d())));
        return new z8.a(jArrCopyOf, jArrCopyOf2);
    }

    private static lh a(k8 k8Var, int i3) {
        ah ahVar = new ah(i3);
        k8Var.d(ahVar.c(), 0, i3);
        ahVar.g(4);
        int iJ = ahVar.j();
        String strA = ahVar.a(ahVar.j(), Charsets.US_ASCII);
        String strC = ahVar.c(ahVar.j());
        int iJ2 = ahVar.j();
        int iJ3 = ahVar.j();
        int iJ4 = ahVar.j();
        int iJ5 = ahVar.j();
        int iJ6 = ahVar.j();
        byte[] bArr = new byte[iJ6];
        ahVar.a(bArr, 0, iJ6);
        return new lh(iJ, strA, strC, iJ2, iJ3, iJ4, iJ5, bArr);
    }
}
