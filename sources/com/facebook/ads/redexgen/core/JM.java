package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class JM {
    public static String[] A00 = {"FTgkNuEfB21sdffM4MB", "AHdMCcfHPrYhHZuJq7ar8kaDD0", "m1AQBHavwMcQPTMSh8yPHqRX8TIuxSKu", "w1PNvsr2QHXMQttzrVJcJFpvqWAZZ2ue", "3yahnNe", "CLySAaMkPHNUkUwJF2Q2hF0h64PJDpTx", "AMIcFao4vlNbyapwbaOz2OEX2RJAnqn2", "UMo3DITmDXTtEPejAH8oJ9deLVPgGECA"};
    public static final int[] A01 = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean A00(int i3, boolean z2) {
        if ((i3 >>> 8) == 3368816) {
            return true;
        }
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        A00[1] = "W7vtI7n9AGcg3kiZwr1R4Wd";
        if (i3 == 1751476579 && z2) {
            return true;
        }
        int[] iArr = A01;
        if (A00[1].length() == 5) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[6] = "p6Add4WRgBlZ7U9sigG7YhPBNKEcLx90";
        strArr[7] = "5Tff00eh7q1qfGppTlmWVovL6e7TawLb";
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean A01(InterfaceC1999ms interfaceC1999ms) throws IOException {
        return A03(interfaceC1999ms, true, false);
    }

    public static boolean A02(InterfaceC1999ms interfaceC1999ms, boolean z2) throws IOException {
        return A03(interfaceC1999ms, false, z2);
    }

    public static boolean A03(InterfaceC1999ms interfaceC1999ms, boolean z2, boolean z3) throws IOException {
        long jA8O = interfaceC1999ms.A8O();
        long inputLength = 4096;
        if (jA8O != -1 && jA8O <= 4096) {
            inputLength = jA8O;
        }
        int i3 = (int) inputLength;
        C04554v c04554v = new C04554v(64);
        int i4 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i4 < i3) {
            int i5 = 8;
            c04554v.A0d(8);
            if (!interfaceC1999ms.AGu(c04554v.A0l(), 0, 8, true)) {
                break;
            }
            long jA0Q = c04554v.A0Q();
            int headerSize = c04554v.A0C();
            if (jA0Q == 1) {
                i5 = 16;
                interfaceC1999ms.AGt(c04554v.A0l(), 8, 8);
                c04554v.A0e(16);
                jA0Q = c04554v.A0P();
            } else if (jA0Q == 0) {
                long jA8O2 = interfaceC1999ms.A8O();
                if (jA8O2 != -1) {
                    jA0Q = (jA8O2 - interfaceC1999ms.A8i()) + ((long) 8);
                }
            }
            if (jA0Q < i5) {
                return false;
            }
            i4 += i5;
            if (headerSize == 1836019574) {
                int i6 = (int) jA0Q;
                String[] strArr = A00;
                if (strArr[2].charAt(21) == strArr[5].charAt(21)) {
                    throw new RuntimeException();
                }
                A00[1] = "1NOCBl6uYr6a5zcz7K9cJi9";
                i3 += i6;
                if (jA8O != -1 && i3 > jA8O) {
                    i3 = (int) jA8O;
                }
            } else {
                if (headerSize == 1836019558 || headerSize == 1836475768) {
                    z5 = true;
                    break;
                }
                if ((((long) i4) + jA0Q) - ((long) i5) >= i3) {
                    break;
                }
                int atomDataSize = (int) (jA0Q - ((long) i5));
                i4 += atomDataSize;
                if (headerSize == 1718909296) {
                    if (atomDataSize >= 8) {
                        c04554v.A0d(atomDataSize);
                        interfaceC1999ms.AGt(c04554v.A0l(), 0, atomDataSize);
                        int atomDataSize2 = atomDataSize / 4;
                        int brandsCount = 0;
                        while (true) {
                            if (brandsCount >= atomDataSize2) {
                                break;
                            }
                            if (brandsCount == 1) {
                                c04554v.A0g(4);
                            } else if (A00(c04554v.A0C(), z3)) {
                                z4 = true;
                                break;
                            }
                            brandsCount++;
                        }
                        if (!z4) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (atomDataSize != 0) {
                    interfaceC1999ms.A47(atomDataSize);
                }
            }
        }
        return z4 && z2 == z5;
    }
}
