package com.applovin.impl;

import com.applovin.impl.ci;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class di {
    private static int a(int i3) {
        return (-(i3 & 1)) ^ (i3 >> 1);
    }

    private static ci.a b(ah ahVar) {
        int iJ = ahVar.j();
        ci.a aVar = null;
        if (iJ > 10000) {
            return null;
        }
        float[] fArr = new float[iJ];
        for (int i3 = 0; i3 < iJ; i3++) {
            fArr[i3] = ahVar.i();
        }
        int iJ2 = ahVar.j();
        if (iJ2 > 32000) {
            return null;
        }
        double d3 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iJ) * 2.0d) / dLog);
        zg zgVar = new zg(ahVar.c());
        int i4 = 8;
        zgVar.c(ahVar.d() * 8);
        float[] fArr2 = new float[iJ2 * 5];
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < iJ2) {
            ci.a aVar2 = aVar;
            int i7 = 0;
            while (i7 < 5) {
                int iA = iArr[i7] + a(zgVar.a(iCeil));
                if (iA >= iJ || iA < 0) {
                    return aVar2;
                }
                fArr2[i6] = fArr[iA];
                iArr[i7] = iA;
                i7++;
                i6++;
            }
            i5++;
            aVar = aVar2;
        }
        ci.a aVar3 = aVar;
        zgVar.c((zgVar.e() + 7) & (-8));
        int i8 = 32;
        int iA2 = zgVar.a(32);
        ci.b[] bVarArr = new ci.b[iA2];
        int i9 = 0;
        while (i9 < iA2) {
            int iA3 = zgVar.a(i4);
            int iA4 = zgVar.a(i4);
            int iA5 = zgVar.a(i8);
            if (iA5 > 128000) {
                return aVar3;
            }
            int i10 = iA2;
            int iCeil2 = (int) Math.ceil(Math.log(((double) iJ2) * d3) / dLog);
            float[] fArr3 = new float[iA5 * 3];
            float[] fArr4 = new float[iA5 * 2];
            int i11 = 0;
            int i12 = 0;
            while (i11 < iA5) {
                int iA6 = i12 + a(zgVar.a(iCeil2));
                if (iA6 < 0 || iA6 >= iJ2) {
                    return aVar3;
                }
                int i13 = i11 * 3;
                int i14 = iA6 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i11 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
                i11++;
                i12 = iA6;
            }
            bVarArr[i9] = new ci.b(iA3, fArr3, fArr4, iA4);
            i9++;
            iA2 = i10;
            i8 = 32;
            d3 = 2.0d;
            i4 = 8;
        }
        return new ci.a(bVarArr);
    }

    private static ArrayList c(ah ahVar) {
        if (ahVar.w() != 0) {
            return null;
        }
        ahVar.g(7);
        int iJ = ahVar.j();
        if (iJ == 1684433976) {
            ah ahVar2 = new ah();
            Inflater inflater = new Inflater(true);
            try {
                if (!xp.a(ahVar, ahVar2, inflater)) {
                    return null;
                }
                inflater.end();
                ahVar = ahVar2;
            } finally {
                inflater.end();
            }
        } else if (iJ != 1918990112) {
            return null;
        }
        return e(ahVar);
    }

    private static ArrayList d(ah ahVar) {
        int iJ;
        ahVar.g(8);
        int iD = ahVar.d();
        int iE = ahVar.e();
        while (iD < iE && (iJ = ahVar.j() + iD) > iD && iJ <= iE) {
            int iJ2 = ahVar.j();
            if (iJ2 == 2037673328 || iJ2 == 1836279920) {
                ahVar.e(iJ);
                return c(ahVar);
            }
            ahVar.f(iJ);
            iD = iJ;
        }
        return null;
    }

    private static ArrayList e(ah ahVar) {
        ArrayList arrayList = new ArrayList();
        int iD = ahVar.d();
        int iE = ahVar.e();
        while (iD < iE) {
            int iJ = ahVar.j() + iD;
            if (iJ <= iD || iJ > iE) {
                return null;
            }
            if (ahVar.j() == 1835365224) {
                ci.a aVarB = b(ahVar);
                if (aVarB == null) {
                    return null;
                }
                arrayList.add(aVarB);
            }
            ahVar.f(iJ);
            iD = iJ;
        }
        return arrayList;
    }

    private static boolean a(ah ahVar) {
        ahVar.g(4);
        int iJ = ahVar.j();
        ahVar.f(0);
        return iJ == 1886547818;
    }

    public static ci a(byte[] bArr, int i3) {
        ArrayList arrayListD;
        ah ahVar = new ah(bArr);
        try {
            arrayListD = a(ahVar) ? d(ahVar) : c(ahVar);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListD = null;
        }
        if (arrayListD == null) {
            return null;
        }
        int size = arrayListD.size();
        if (size == 1) {
            return new ci((ci.a) arrayListD.get(0), i3);
        }
        if (size != 2) {
            return null;
        }
        return new ci((ci.a) arrayListD.get(0), (ci.a) arrayListD.get(1), i3);
    }
}
