package com.applovin.impl;

import com.applovin.impl.e9;
import com.facebook.ads.AdError;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f61946a = {AdError.CACHE_ERROR_CODE, AdError.SERVER_ERROR_CODE, 1920, 1601, 1600, AdError.NO_FILL_ERROR_CODE, 1000, 960, 800, 800, 480, RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST, 2048};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f61947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f61948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f61949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f61950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f61951e;

        private b(int i3, int i4, int i5, int i6, int i7) {
            this.f61947a = i3;
            this.f61949c = i4;
            this.f61948b = i5;
            this.f61950d = i6;
            this.f61951e = i7;
        }
    }

    public static void a(int i3, ah ahVar) {
        ahVar.d(7);
        byte[] bArrC = ahVar.c();
        bArrC[0] = -84;
        bArrC[1] = 64;
        bArrC[2] = -1;
        bArrC[3] = -1;
        bArrC[4] = (byte) ((i3 >> 16) & 255);
        bArrC[5] = (byte) ((i3 >> 8) & 255);
        bArrC[6] = (byte) (i3 & 255);
    }

    public static e9 a(ah ahVar, String str, String str2, x6 x6Var) {
        ahVar.g(1);
        return new e9.b().c(str).f("audio/ac4").c(2).n(((ahVar.w() & 32) >> 5) == 1 ? 48000 : 44100).a(x6Var).e(str2).a();
    }

    public static int a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return a(new zg(bArr)).f61951e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0087, code lost:
    
        if (r11 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008c, code lost:
    
        if (r11 != 8) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.applovin.impl.n.b a(com.applovin.impl.zg r11) {
        /*
            r0 = 16
            int r1 = r11.a(r0)
            int r0 = r11.a(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.a(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.a(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = a(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.a(r1)
            boolean r4 = r11.f()
            if (r4 == 0) goto L45
            int r4 = r11.a(r2)
            if (r4 <= 0) goto L45
            r11.d(r0)
        L45:
            boolean r4 = r11.f()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r4 = r7
            goto L55
        L53:
            r4 = r7
            r7 = r6
        L55:
            int r11 = r11.a(r3)
            if (r7 != r6) goto L65
            r6 = 13
            if (r11 != r6) goto L65
            int[] r0 = com.applovin.impl.n.f61946a
            r11 = r0[r11]
        L63:
            r9 = r11
            goto L96
        L65:
            if (r7 != r4) goto L94
            int[] r4 = com.applovin.impl.n.f61946a
            int r6 = r4.length
            if (r11 >= r6) goto L94
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 1
            r9 = 8
            if (r1 == r6) goto L8a
            r6 = 11
            if (r1 == r0) goto L85
            if (r1 == r2) goto L8a
            if (r1 == r3) goto L7e
            goto L8f
        L7e:
            if (r11 == r2) goto L91
            if (r11 == r9) goto L91
            if (r11 != r6) goto L8f
            goto L91
        L85:
            if (r11 == r9) goto L91
            if (r11 != r6) goto L8f
            goto L91
        L8a:
            if (r11 == r2) goto L91
            if (r11 != r9) goto L8f
            goto L91
        L8f:
            r9 = r4
            goto L96
        L91:
            int r11 = r4 + 1
            goto L63
        L94:
            r11 = 0
            goto L63
        L96:
            com.applovin.impl.n$b r4 = new com.applovin.impl.n$b
            r6 = 2
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.n.a(com.applovin.impl.zg):com.applovin.impl.n$b");
    }

    public static int a(byte[] bArr, int i3) {
        int i4 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i5 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i5 == 65535) {
            i5 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i4 = 4;
        }
        if (i3 == 44097) {
            i4 += 2;
        }
        return i5 + i4;
    }

    private static int a(zg zgVar, int i3) {
        int i4 = 0;
        while (true) {
            int iA = i4 + zgVar.a(i3);
            if (!zgVar.f()) {
                return iA;
            }
            i4 = (iA + 1) << i3;
        }
    }
}
