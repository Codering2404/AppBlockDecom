package com.applovin.impl;

import android.util.Pair;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class nr {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f62136b;

        private a(int i3, long j3) {
            this.f62135a = i3;
            this.f62136b = j3;
        }

        public static a a(k8 k8Var, ah ahVar) {
            k8Var.c(ahVar.c(), 0, 8);
            ahVar.f(0);
            return new a(ahVar.j(), ahVar.p());
        }
    }

    public static Pair b(k8 k8Var) throws ch {
        b1.a(k8Var);
        k8Var.b();
        ah ahVar = new ah(8);
        a aVarA = a.a(k8Var, ahVar);
        while (true) {
            int i3 = aVarA.f62135a;
            if (i3 == 1684108385) {
                k8Var.a(8);
                long jF = k8Var.f();
                long j3 = aVarA.f62136b + jF;
                long jA = k8Var.a();
                if (jA != -1 && j3 > jA) {
                    oc.d("WavHeaderReader", "Data exceeds input length: " + j3 + ", " + jA);
                    j3 = jA;
                }
                return Pair.create(Long.valueOf(jF), Long.valueOf(j3));
            }
            if (i3 != 1380533830 && i3 != 1718449184) {
                oc.d("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f62135a);
            }
            long j4 = aVarA.f62136b + 8;
            if (aVarA.f62135a == 1380533830) {
                j4 = 12;
            }
            if (j4 > 2147483647L) {
                throw ch.a("Chunk is too large (~2GB+) to skip; id: " + aVarA.f62135a);
            }
            k8Var.a((int) j4);
            aVarA = a.a(k8Var, ahVar);
        }
    }

    public static mr a(k8 k8Var) {
        boolean z2;
        byte[] bArr;
        b1.a(k8Var);
        ah ahVar = new ah(16);
        if (a.a(k8Var, ahVar).f62135a != 1380533830) {
            return null;
        }
        k8Var.c(ahVar.c(), 0, 4);
        ahVar.f(0);
        int iJ = ahVar.j();
        if (iJ != 1463899717) {
            oc.b("WavHeaderReader", QaXmqxvjHhxVy.aMuyqMNCidPAy + iJ);
            return null;
        }
        a aVarA = a.a(k8Var, ahVar);
        while (aVarA.f62135a != 1718449184) {
            k8Var.c((int) aVarA.f62136b);
            aVarA = a.a(k8Var, ahVar);
        }
        if (aVarA.f62136b >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        b1.b(z2);
        k8Var.c(ahVar.c(), 0, 16);
        ahVar.f(0);
        int iR = ahVar.r();
        int iR2 = ahVar.r();
        int iQ = ahVar.q();
        int iQ2 = ahVar.q();
        int iR3 = ahVar.r();
        int iR4 = ahVar.r();
        int i3 = ((int) aVarA.f62136b) - 16;
        if (i3 > 0) {
            bArr = new byte[i3];
            k8Var.c(bArr, 0, i3);
        } else {
            bArr = xp.f65032f;
        }
        return new mr(iR, iR2, iQ, iQ2, iR3, iR4, bArr);
    }
}
