package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f65192a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f65193b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f65194c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f65195d = new int[10];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f65198c;

        public a(int i3, int i4, boolean z2) {
            this.f65196a = i3;
            this.f65197b = i4;
            this.f65198c = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f65202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f65203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f65204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f65205g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f65206h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f65207i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f65208j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f65209k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f65210l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f65211m;

        public b(int i3, int i4, int i5, int i6, int i7, int i8, float f3, boolean z2, boolean z3, int i9, int i10, int i11, boolean z4) {
            this.f65199a = i3;
            this.f65200b = i4;
            this.f65201c = i5;
            this.f65202d = i6;
            this.f65203e = i7;
            this.f65204f = i8;
            this.f65205g = f3;
            this.f65206h = z2;
            this.f65207i = z3;
            this.f65208j = i9;
            this.f65209k = i10;
            this.f65210l = i11;
            this.f65211m = z4;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i3) {
        return bArr[i3 + 3] & Ascii.US;
    }

    public static int c(byte[] bArr, int i3) {
        int i4;
        synchronized (f65194c) {
            int iA = 0;
            int i5 = 0;
            while (iA < i3) {
                try {
                    iA = a(bArr, iA, i3);
                    if (iA < i3) {
                        int[] iArr = f65195d;
                        if (iArr.length <= i5) {
                            f65195d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f65195d[i5] = iA;
                        iA += 3;
                        i5++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i4 = i3 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f65195d[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i4 - i7);
        }
        return i4;
    }

    public static a b(byte[] bArr, int i3, int i4) {
        bh bhVar = new bh(bArr, i3, i4);
        bhVar.d(8);
        int iF = bhVar.f();
        int iF2 = bhVar.f();
        bhVar.g();
        return new a(iF, iF2, bhVar.c());
    }

    public static void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 1;
            if (i5 < iPosition) {
                int i6 = byteBuffer.get(i3) & 255;
                if (i4 == 3) {
                    if (i6 == 1 && (byteBuffer.get(i5) & Ascii.US) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        byteBufferDuplicate.position(i3 - 3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        return;
                    }
                } else if (i6 == 0) {
                    i4++;
                }
                if (i6 != 0) {
                    i4 = 0;
                }
                i3 = i5;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int a(byte[] bArr, int i3, int i4, boolean[] zArr) {
        int i5 = i4 - i3;
        b1.b(i5 >= 0);
        if (i5 == 0) {
            return i4;
        }
        if (zArr[0]) {
            a(zArr);
            return i3 - 3;
        }
        if (i5 > 1 && zArr[1] && bArr[i3] == 1) {
            a(zArr);
            return i3 - 2;
        }
        if (i5 > 2 && zArr[2] && bArr[i3] == 0 && bArr[i3 + 1] == 1) {
            a(zArr);
            return i3 - 1;
        }
        int i6 = i4 - 1;
        int i7 = i3 + 2;
        while (i7 < i6) {
            byte b3 = bArr[i7];
            if ((b3 & 254) == 0) {
                int i8 = i7 - 2;
                if (bArr[i8] == 0 && bArr[i7 - 1] == 0 && b3 == 1) {
                    a(zArr);
                    return i8;
                }
                i7 -= 2;
            }
            i7 += 3;
        }
        zArr[0] = i5 <= 2 ? !(i5 != 2 ? !(zArr[1] && bArr[i6] == 1) : !(zArr[2] && bArr[i4 + (-2)] == 0 && bArr[i6] == 1)) : bArr[i4 + (-3)] == 0 && bArr[i4 + (-2)] == 0 && bArr[i6] == 1;
        zArr[1] = i5 <= 1 ? zArr[2] && bArr[i6] == 0 : bArr[i4 + (-2)] == 0 && bArr[i6] == 0;
        zArr[2] = bArr[i6] == 0;
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.applovin.impl.yf.b c(byte[] r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.yf.c(byte[], int, int):com.applovin.impl.yf$b");
    }

    private static int a(byte[] bArr, int i3, int i4) {
        while (i3 < i4 - 2) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static int a(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 126) >> 1;
    }

    private static void a(bh bhVar, int i3) {
        int iE = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i3; i5++) {
            if (iE != 0) {
                iE = ((bhVar.e() + i4) + Function.MAX_NARGS) % Function.MAX_NARGS;
            }
            if (iE != 0) {
                i4 = iE;
            }
        }
    }

    public static boolean a(String str, byte b3) {
        return ("video/avc".equals(str) && (b3 & Ascii.US) == 6) || ("video/hevc".equals(str) && ((b3 & 126) >> 1) == 39);
    }
}
