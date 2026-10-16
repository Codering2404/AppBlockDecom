package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class lk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f61236a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i3, boolean z2) {
        if ((i3 >>> 8) == 3368816) {
            return true;
        }
        if (i3 == 1751476579 && z2) {
            return true;
        }
        for (int i4 : f61236a) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(k8 k8Var) {
        return a(k8Var, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(k8 k8Var, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        int i3;
        int i4;
        long jA = k8Var.a();
        long j3 = -1;
        int i5 = (jA > (-1L) ? 1 : (jA == (-1L) ? 0 : -1));
        long j4 = 4096;
        if (i5 != 0 && jA <= 4096) {
            j4 = jA;
        }
        int i6 = (int) j4;
        ah ahVar = new ah(64);
        int i7 = 0;
        int i8 = 0;
        boolean z6 = false;
        while (i8 < i6) {
            ahVar.d(8);
            if (!k8Var.b(ahVar.c(), i7, 8, true)) {
                break;
            }
            long jY = ahVar.y();
            int iJ = ahVar.j();
            if (jY == 1) {
                k8Var.c(ahVar.c(), 8, 8);
                ahVar.e(16);
                z5 = i7;
                i3 = i8;
                i4 = 16;
                jY = ahVar.s();
            } else {
                if (jY == 0) {
                    long jA2 = k8Var.a();
                    if (jA2 != j3) {
                        jY = (jA2 - k8Var.d()) + ((long) 8);
                    }
                }
                z5 = i7;
                i3 = i8;
                i4 = 8;
            }
            long j5 = i4;
            if (jY < j5) {
                return z5;
            }
            int i9 = i3 + i4;
            boolean z7 = z5;
            if (iJ == 1836019574) {
                i6 += (int) jY;
                if (i5 != 0 && i6 > jA) {
                    i6 = (int) jA;
                }
                i8 = i9;
                i7 = z7 ? 1 : 0;
                j3 = -1;
            } else {
                if (iJ == 1836019558 || iJ == 1836475768) {
                    z4 = true;
                    break;
                }
                int i10 = i5;
                if ((((long) i9) + jY) - j5 >= i6) {
                    break;
                }
                int i11 = (int) (jY - j5);
                i8 = i9 + i11;
                if (iJ == 1718909296) {
                    if (i11 < 8) {
                        return z7;
                    }
                    ahVar.d(i11);
                    k8Var.c(ahVar.c(), z7 ? 1 : 0, i11);
                    int i12 = i11 / 4;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            break;
                        }
                        if (i13 == 1) {
                            ahVar.g(4);
                        } else if (a(ahVar.j(), z3)) {
                            z6 = true;
                            break;
                        }
                        i13++;
                    }
                    if (!z6) {
                        return false;
                    }
                } else if (i11 != 0) {
                    k8Var.c(i11);
                }
                i5 = i10;
                j3 = -1;
                i7 = 0;
            }
        }
        z4 = false;
        return z6 && z2 == z4;
    }

    public static boolean a(k8 k8Var, boolean z2) {
        return a(k8Var, false, z2);
    }
}
