package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c3 {
    public static void a(long j3, ah ahVar, qo[] qoVarArr) {
        while (true) {
            if (ahVar.a() <= 1) {
                return;
            }
            int iA = a(ahVar);
            int iA2 = a(ahVar);
            int iD = ahVar.d() + iA2;
            if (iA2 == -1 || iA2 > ahVar.a()) {
                oc.d("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iD = ahVar.e();
            } else if (iA == 4 && iA2 >= 8) {
                int iW = ahVar.w();
                int iC = ahVar.C();
                int iJ = iC == 49 ? ahVar.j() : 0;
                int iW2 = ahVar.w();
                if (iC == 47) {
                    ahVar.g(1);
                }
                boolean z2 = iW == 181 && (iC == 49 || iC == 47) && iW2 == 3;
                if (iC == 49) {
                    z2 &= iJ == 1195456820;
                }
                if (z2) {
                    b(j3, ahVar, qoVarArr);
                }
            }
            ahVar.f(iD);
        }
    }

    public static void b(long j3, ah ahVar, qo[] qoVarArr) {
        long j4;
        int iW = ahVar.w();
        if ((iW & 64) != 0) {
            ahVar.g(1);
            int i3 = (iW & 31) * 3;
            int iD = ahVar.d();
            int length = qoVarArr.length;
            int i4 = 0;
            while (i4 < length) {
                qo qoVar = qoVarArr[i4];
                ahVar.f(iD);
                qoVar.a(ahVar, i3);
                if (j3 != -9223372036854775807L) {
                    j4 = j3;
                    qoVar.a(j4, 1, i3, 0, null);
                } else {
                    j4 = j3;
                }
                i4++;
                j3 = j4;
            }
        }
    }

    private static int a(ah ahVar) {
        int i3 = 0;
        while (ahVar.a() != 0) {
            int iW = ahVar.w();
            i3 += iW;
            if (iW != 255) {
                return i3;
            }
        }
        return -1;
    }
}
