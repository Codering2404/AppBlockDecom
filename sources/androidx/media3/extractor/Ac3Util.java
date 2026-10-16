package androidx.media3.extractor;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac3Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f46027a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f46028b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f46029c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f46030d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f46031e = {32, 40, 48, 56, 64, 80, 96, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 160, 192, 224, Function.MAX_NARGS, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f46032f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SyncFrameInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f46038f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f46039g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(String str, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f46033a = str;
            this.f46034b = i3;
            this.f46036d = i4;
            this.f46035c = i5;
            this.f46037e = i6;
            this.f46038f = i7;
            this.f46039g = i8;
        }
    }

    private static int a(int i3, int i4, int i5) {
        return (i3 * i4) / (i5 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i3 = iPosition; i3 <= iLimit; i3++) {
            if ((Util.S(byteBuffer, i3 + 4) & (-2)) == -126718022) {
                return i3 - iPosition;
            }
        }
        return -1;
    }

    private static int c(int i3, int i4) {
        int i5 = i4 / 2;
        if (i3 < 0) {
            return -1;
        }
        int[] iArr = f46028b;
        if (i3 >= iArr.length || i4 < 0) {
            return -1;
        }
        int[] iArr2 = f46032f;
        if (i5 >= iArr2.length) {
            return -1;
        }
        int i6 = iArr[i3];
        if (i6 == 44100) {
            return (iArr2[i5] + (i4 % 2)) * 2;
        }
        int i7 = f46031e[i5];
        return i6 == 32000 ? i7 * 6 : i7 * 4;
    }

    public static Format d(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        int i3 = f46028b[parsableBitArray.h(2)];
        parsableBitArray.r(8);
        int i4 = f46030d[parsableBitArray.h(3)];
        if (parsableBitArray.h(1) != 0) {
            i4++;
        }
        int i5 = f46031e[parsableBitArray.h(5)] * 1000;
        parsableBitArray.c();
        parsableByteArray.W(parsableBitArray.d());
        return new Format.Builder().f0(str).u0("audio/ac3").R(i4).v0(i3).Y(drmInitData).j0(str2).Q(i5).p0(i5).N();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f46027a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * Function.MAX_NARGS;
        }
        return 1536;
    }

    public static SyncFrameInfo f(ParsableBitArray parsableBitArray) {
        int iC;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iE = parsableBitArray.e();
        parsableBitArray.r(40);
        boolean z2 = parsableBitArray.h(5) > 10;
        parsableBitArray.p(iE);
        int i12 = -1;
        if (z2) {
            parsableBitArray.r(16);
            int iH = parsableBitArray.h(2);
            if (iH == 0) {
                i12 = 0;
            } else if (iH == 1) {
                i12 = 1;
            } else if (iH == 2) {
                i12 = 2;
            }
            parsableBitArray.r(3);
            iC = (parsableBitArray.h(11) + 1) * 2;
            int iH2 = parsableBitArray.h(2);
            if (iH2 == 3) {
                i3 = f46029c[parsableBitArray.h(2)];
                i7 = 3;
                i8 = 6;
            } else {
                int iH3 = parsableBitArray.h(2);
                int i13 = f46027a[iH3];
                i7 = iH3;
                i3 = f46028b[iH2];
                i8 = i13;
            }
            i5 = i8 * Function.MAX_NARGS;
            int iA = a(iC, i3, i8);
            int iH4 = parsableBitArray.h(3);
            boolean zG = parsableBitArray.g();
            i4 = f46030d[iH4] + (zG ? 1 : 0);
            parsableBitArray.r(10);
            if (parsableBitArray.g()) {
                parsableBitArray.r(8);
            }
            if (iH4 == 0) {
                parsableBitArray.r(5);
                if (parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
            }
            if (i12 == 1 && parsableBitArray.g()) {
                parsableBitArray.r(16);
            }
            if (parsableBitArray.g()) {
                if (iH4 > 2) {
                    parsableBitArray.r(2);
                }
                if ((iH4 & 1) == 0 || iH4 <= 2) {
                    i10 = 6;
                } else {
                    i10 = 6;
                    parsableBitArray.r(6);
                }
                if ((iH4 & 4) != 0) {
                    parsableBitArray.r(i10);
                }
                if (zG && parsableBitArray.g()) {
                    parsableBitArray.r(5);
                }
                if (i12 == 0) {
                    if (parsableBitArray.g()) {
                        i11 = 6;
                        parsableBitArray.r(6);
                    } else {
                        i11 = 6;
                    }
                    if (iH4 == 0 && parsableBitArray.g()) {
                        parsableBitArray.r(i11);
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(i11);
                    }
                    int iH5 = parsableBitArray.h(2);
                    if (iH5 == 1) {
                        parsableBitArray.r(5);
                    } else if (iH5 == 2) {
                        parsableBitArray.r(12);
                    } else if (iH5 == 3) {
                        int iH6 = parsableBitArray.h(5);
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(4);
                                }
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(4);
                                }
                            }
                        }
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(7);
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(8);
                                }
                            }
                        }
                        parsableBitArray.r((iH6 + 2) * 8);
                        parsableBitArray.c();
                    }
                    if (iH4 < 2) {
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(14);
                        }
                        if (iH4 == 0 && parsableBitArray.g()) {
                            parsableBitArray.r(14);
                        }
                    }
                    if (parsableBitArray.g()) {
                        if (i7 == 0) {
                            parsableBitArray.r(5);
                        } else {
                            for (int i14 = 0; i14 < i8; i14++) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.g()) {
                parsableBitArray.r(5);
                if (iH4 == 2) {
                    parsableBitArray.r(4);
                }
                if (iH4 >= 6) {
                    parsableBitArray.r(2);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
                if (iH4 == 0 && parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
                if (iH2 < 3) {
                    parsableBitArray.q();
                }
            }
            if (i12 == 0 && i7 != 3) {
                parsableBitArray.q();
            }
            if (i12 == 2 && (i7 == 3 || parsableBitArray.g())) {
                i9 = 6;
                parsableBitArray.r(6);
            } else {
                i9 = 6;
            }
            str = (parsableBitArray.g() && parsableBitArray.h(i9) == 1 && parsableBitArray.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i6 = iA;
        } else {
            parsableBitArray.r(32);
            int iH7 = parsableBitArray.h(2);
            String str2 = iH7 == 3 ? null : "audio/ac3";
            int iH8 = parsableBitArray.h(6);
            int i15 = f46031e[iH8 / 2] * 1000;
            iC = c(iH7, iH8);
            parsableBitArray.r(8);
            int iH9 = parsableBitArray.h(3);
            if ((iH9 & 1) != 0 && iH9 != 1) {
                parsableBitArray.r(2);
            }
            if ((iH9 & 4) != 0) {
                parsableBitArray.r(2);
            }
            if (iH9 == 2) {
                parsableBitArray.r(2);
            }
            int[] iArr = f46028b;
            i3 = iH7 < iArr.length ? iArr[iH7] : -1;
            i4 = f46030d[iH9] + (parsableBitArray.g() ? 1 : 0);
            i5 = 1536;
            str = str2;
            i6 = i15;
        }
        return new SyncFrameInfo(str, i12, i4, i3, iC, i5, i6);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b3 = bArr[4];
        return c((b3 & 192) >> 6, b3 & 63);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.common.Format h(androidx.media3.common.util.ParsableByteArray r7, java.lang.String r8, java.lang.String r9, androidx.media3.common.DrmInitData r10) {
        /*
            androidx.media3.common.util.ParsableBitArray r0 = new androidx.media3.common.util.ParsableBitArray
            r0.<init>()
            r0.m(r7)
            r1 = 13
            int r1 = r0.h(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.r(r2)
            r3 = 2
            int r3 = r0.h(r3)
            int[] r4 = androidx.media3.extractor.Ac3Util.f46028b
            r3 = r4[r3]
            r4 = 10
            r0.r(r4)
            int[] r4 = androidx.media3.extractor.Ac3Util.f46030d
            int r5 = r0.h(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.h(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.r(r2)
            r2 = 4
            int r2 = r0.h(r2)
            r0.r(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.r(r2)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.r(r5)
        L4f:
            int r2 = r0.b()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.r(r6)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.c()
            int r0 = r0.d()
            r7.W(r0)
            androidx.media3.common.Format$Builder r7 = new androidx.media3.common.Format$Builder
            r7.<init>()
            androidx.media3.common.Format$Builder r7 = r7.f0(r8)
            androidx.media3.common.Format$Builder r7 = r7.u0(r2)
            androidx.media3.common.Format$Builder r7 = r7.R(r4)
            androidx.media3.common.Format$Builder r7 = r7.v0(r3)
            androidx.media3.common.Format$Builder r7 = r7.Y(r10)
            androidx.media3.common.Format$Builder r7 = r7.j0(r9)
            androidx.media3.common.Format$Builder r7 = r7.p0(r1)
            androidx.media3.common.Format r7 = r7.N()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.Ac3Util.h(androidx.media3.common.util.ParsableByteArray, java.lang.String, java.lang.String, androidx.media3.common.DrmInitData):androidx.media3.common.Format");
    }

    public static int i(ByteBuffer byteBuffer, int i3) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i3) + ((byteBuffer.get((byteBuffer.position() + i3) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b3 = bArr[7];
            if ((b3 & 254) == 186) {
                return 40 << ((bArr[(b3 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
