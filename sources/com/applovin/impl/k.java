package com.applovin.impl;

import com.applovin.impl.e9;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f60830a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f60831b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f60832c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f60833d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f60834e = {32, 40, 48, 56, 64, 80, 96, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 160, 192, 224, Function.MAX_NARGS, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f60835f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f60836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f60839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f60840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f60841f;

        private b(String str, int i3, int i4, int i5, int i6, int i7) {
            this.f60836a = str;
            this.f60837b = i3;
            this.f60839d = i4;
            this.f60838c = i5;
            this.f60840e = i6;
            this.f60841f = i7;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i3 = iPosition; i3 <= iLimit; i3++) {
            if ((xp.a(byteBuffer, i3 + 4) & (-2)) == -126718022) {
                return i3 - iPosition;
            }
        }
        return -1;
    }

    public static int b(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f60830a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * Function.MAX_NARGS;
        }
        return 1536;
    }

    private static int a(int i3, int i4) {
        int i5 = i4 / 2;
        if (i3 < 0) {
            return -1;
        }
        int[] iArr = f60831b;
        if (i3 >= iArr.length || i4 < 0) {
            return -1;
        }
        int[] iArr2 = f60835f;
        if (i5 >= iArr2.length) {
            return -1;
        }
        int i6 = iArr[i3];
        if (i6 == 44100) {
            return (iArr2[i5] + (i4 % 2)) * 2;
        }
        int i7 = f60834e[i5];
        return i6 == 32000 ? i7 * 6 : i7 * 4;
    }

    public static e9 b(ah ahVar, String str, String str2, x6 x6Var) {
        String str3;
        ahVar.g(2);
        int i3 = f60831b[(ahVar.w() & 192) >> 6];
        int iW = ahVar.w();
        int i4 = f60833d[(iW & 14) >> 1];
        if ((iW & 1) != 0) {
            i4++;
        }
        if (((ahVar.w() & 30) >> 1) > 0 && (2 & ahVar.w()) != 0) {
            i4 += 2;
        }
        if (ahVar.a() > 0 && (ahVar.w() & 1) != 0) {
            str3 = "audio/eac3-joc";
        } else {
            str3 = "audio/eac3";
        }
        return new e9.b().c(str).f(str3).c(i4).n(i3).a(x6Var).e(str2).a();
    }

    public static e9 a(ah ahVar, String str, String str2, x6 x6Var) {
        int i3 = f60831b[(ahVar.w() & 192) >> 6];
        int iW = ahVar.w();
        int i4 = f60833d[(iW & 56) >> 3];
        if ((iW & 4) != 0) {
            i4++;
        }
        return new e9.b().c(str).f("audio/ac3").c(i4).n(i3).a(x6Var).e(str2).a();
    }

    public static b a(zg zgVar) {
        int iA;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int iA2;
        int i7;
        int i8;
        String str2;
        int i9;
        int i10;
        int iE = zgVar.e();
        zgVar.d(40);
        boolean z2 = zgVar.a(5) > 10;
        zgVar.c(iE);
        int i11 = -1;
        if (z2) {
            zgVar.d(16);
            int iA3 = zgVar.a(2);
            if (iA3 == 0) {
                i11 = 0;
            } else if (iA3 == 1) {
                i11 = 1;
            } else if (iA3 == 2) {
                i11 = 2;
            }
            zgVar.d(3);
            iA = (zgVar.a(11) + 1) * 2;
            int iA4 = zgVar.a(2);
            if (iA4 == 3) {
                i3 = f60832c[zgVar.a(2)];
                i7 = 6;
                iA2 = 3;
            } else {
                iA2 = zgVar.a(2);
                i7 = f60830a[iA2];
                i3 = f60831b[iA4];
            }
            i5 = i7 * Function.MAX_NARGS;
            int iA5 = zgVar.a(3);
            boolean zF = zgVar.f();
            i4 = f60833d[iA5] + (zF ? 1 : 0);
            zgVar.d(10);
            if (zgVar.f()) {
                zgVar.d(8);
            }
            if (iA5 == 0) {
                zgVar.d(5);
                if (zgVar.f()) {
                    zgVar.d(8);
                }
            }
            if (i11 == 1 && zgVar.f()) {
                zgVar.d(16);
            }
            if (zgVar.f()) {
                if (iA5 > 2) {
                    zgVar.d(2);
                }
                if ((iA5 & 1) == 0 || iA5 <= 2) {
                    i9 = 6;
                } else {
                    i9 = 6;
                    zgVar.d(6);
                }
                if ((iA5 & 4) != 0) {
                    zgVar.d(i9);
                }
                if (zF && zgVar.f()) {
                    zgVar.d(5);
                }
                if (i11 == 0) {
                    if (zgVar.f()) {
                        i10 = 6;
                        zgVar.d(6);
                    } else {
                        i10 = 6;
                    }
                    if (iA5 == 0 && zgVar.f()) {
                        zgVar.d(i10);
                    }
                    if (zgVar.f()) {
                        zgVar.d(i10);
                    }
                    int iA6 = zgVar.a(2);
                    if (iA6 == 1) {
                        zgVar.d(5);
                    } else if (iA6 == 2) {
                        zgVar.d(12);
                    } else if (iA6 == 3) {
                        int iA7 = zgVar.a(5);
                        if (zgVar.f()) {
                            zgVar.d(5);
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                zgVar.d(4);
                            }
                            if (zgVar.f()) {
                                if (zgVar.f()) {
                                    zgVar.d(4);
                                }
                                if (zgVar.f()) {
                                    zgVar.d(4);
                                }
                            }
                        }
                        if (zgVar.f()) {
                            zgVar.d(5);
                            if (zgVar.f()) {
                                zgVar.d(7);
                                if (zgVar.f()) {
                                    zgVar.d(8);
                                }
                            }
                        }
                        zgVar.d((iA7 + 2) * 8);
                        zgVar.c();
                    }
                    if (iA5 < 2) {
                        if (zgVar.f()) {
                            zgVar.d(14);
                        }
                        if (iA5 == 0 && zgVar.f()) {
                            zgVar.d(14);
                        }
                    }
                    if (zgVar.f()) {
                        if (iA2 == 0) {
                            zgVar.d(5);
                        } else {
                            for (int i12 = 0; i12 < i7; i12++) {
                                if (zgVar.f()) {
                                    zgVar.d(5);
                                }
                            }
                        }
                    }
                }
            }
            if (zgVar.f()) {
                zgVar.d(5);
                if (iA5 == 2) {
                    zgVar.d(4);
                }
                if (iA5 >= 6) {
                    zgVar.d(2);
                }
                if (zgVar.f()) {
                    zgVar.d(8);
                }
                if (iA5 == 0 && zgVar.f()) {
                    zgVar.d(8);
                }
                if (iA4 < 3) {
                    zgVar.g();
                }
            }
            if (i11 == 0 && iA2 != 3) {
                zgVar.g();
            }
            if (i11 == 2 && (iA2 == 3 || zgVar.f())) {
                i8 = 6;
                zgVar.d(6);
            } else {
                i8 = 6;
            }
            if (zgVar.f() && zgVar.a(i8) == 1 && zgVar.a(8) == 1) {
                str2 = "audio/eac3-joc";
            } else {
                str2 = "audio/eac3";
            }
            str = str2;
            i6 = i11;
        } else {
            zgVar.d(32);
            int iA8 = zgVar.a(2);
            String str3 = iA8 == 3 ? null : "audio/ac3";
            iA = a(iA8, zgVar.a(6));
            zgVar.d(8);
            int iA9 = zgVar.a(3);
            if ((iA9 & 1) != 0 && iA9 != 1) {
                zgVar.d(2);
            }
            if ((iA9 & 4) != 0) {
                zgVar.d(2);
            }
            if (iA9 == 2) {
                zgVar.d(2);
            }
            int[] iArr = f60831b;
            i3 = iA8 < iArr.length ? iArr[iA8] : -1;
            i4 = f60833d[iA9] + (zgVar.f() ? 1 : 0);
            i5 = 1536;
            i6 = -1;
            str = str3;
        }
        return new b(str, i6, i4, i3, iA, i5);
    }

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b3 = bArr[7];
            if ((b3 & 254) == 186) {
                return 40 << ((bArr[(b3 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b3 = bArr[4];
        return a((b3 & 192) >> 6, b3 & 63);
    }

    public static int a(ByteBuffer byteBuffer, int i3) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i3) + ((byteBuffer.get((byteBuffer.position() + i3) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }
}
