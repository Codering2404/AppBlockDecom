package com.applovin.impl;

import com.applovin.impl.e9;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f59373a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f59374b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f59375c = {64, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 192, 224, Function.MAX_NARGS, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static boolean a(int i3) {
        return i3 == 2147385345 || i3 == -25230976 || i3 == 536864768 || i3 == -14745368;
    }

    private static zg b(byte[] bArr) {
        if (bArr[0] == 127) {
            return new zg(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(bArrCopyOf)) {
            for (int i3 = 0; i3 < bArrCopyOf.length - 1; i3 += 2) {
                byte b3 = bArrCopyOf[i3];
                int i4 = i3 + 1;
                bArrCopyOf[i3] = bArrCopyOf[i4];
                bArrCopyOf[i4] = b3;
            }
        }
        zg zgVar = new zg(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            zg zgVar2 = new zg(bArrCopyOf);
            while (zgVar2.b() >= 16) {
                zgVar2.d(2);
                zgVar.a(zgVar2.a(14), 14);
            }
        }
        zgVar.a(bArrCopyOf);
        return zgVar;
    }

    private static boolean c(byte[] bArr) {
        byte b3 = bArr[0];
        return b3 == -2 || b3 == -1;
    }

    public static int d(byte[] bArr) {
        int i3;
        byte b3;
        int i4;
        byte b4;
        byte b5 = bArr[0];
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (bArr[4] & 7) << 4;
                b4 = bArr[7];
            } else if (b5 != 31) {
                i3 = (bArr[4] & 1) << 6;
                b3 = bArr[5];
            } else {
                i3 = (bArr[5] & 7) << 4;
                b4 = bArr[6];
            }
            i4 = b4 & 60;
            return (((i4 >> 2) | i3) + 1) * 32;
        }
        i3 = (bArr[5] & 1) << 6;
        b3 = bArr[4];
        i4 = b3 & 252;
        return (((i4 >> 2) | i3) + 1) * 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
        L36:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5e
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
            goto L36
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.e7.a(byte[]):int");
    }

    public static int a(ByteBuffer byteBuffer) {
        int i3;
        byte b3;
        int i4;
        byte b4;
        int iPosition = byteBuffer.position();
        byte b5 = byteBuffer.get(iPosition);
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b4 = byteBuffer.get(iPosition + 7);
            } else if (b5 != 31) {
                i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b3 = byteBuffer.get(iPosition + 5);
            } else {
                i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b4 = byteBuffer.get(iPosition + 6);
            }
            i4 = b4 & 60;
            return (((i4 >> 2) | i3) + 1) * 32;
        }
        i3 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b3 = byteBuffer.get(iPosition + 4);
        i4 = b3 & 252;
        return (((i4 >> 2) | i3) + 1) * 32;
    }

    public static e9 a(byte[] bArr, String str, String str2, x6 x6Var) {
        zg zgVarB = b(bArr);
        zgVarB.d(60);
        int i3 = f59373a[zgVarB.a(6)];
        int i4 = f59374b[zgVarB.a(4)];
        int iA = zgVarB.a(5);
        int[] iArr = f59375c;
        int i5 = iA >= iArr.length ? -1 : (iArr[iA] * 1000) / 2;
        zgVarB.d(10);
        return new e9.b().c(str).f("audio/vnd.dts").b(i5).c(i3 + (zgVarB.a(2) > 0 ? 1 : 0)).n(i4).a(x6Var).e(str2).a();
    }
}
