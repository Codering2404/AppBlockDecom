package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f63695a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f63696b = {44100, 48000, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f63697c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f63698d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f63699e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f63700f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f63701g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f63702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f63703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f63704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f63705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f63706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f63707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f63708g;

        public boolean a(int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (!sf.c(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
                return false;
            }
            this.f63702a = i4;
            this.f63703b = sf.f63695a[3 - i5];
            int i8 = sf.f63696b[i7];
            this.f63705d = i8;
            if (i4 == 2) {
                this.f63705d = i8 / 2;
            } else if (i4 == 0) {
                this.f63705d = i8 / 4;
            }
            int i9 = (i3 >>> 9) & 1;
            this.f63708g = sf.b(i4, i5);
            if (i5 == 3) {
                int i10 = i4 == 3 ? sf.f63697c[i6 - 1] : sf.f63698d[i6 - 1];
                this.f63707f = i10;
                this.f63704c = (((i10 * 12) / this.f63705d) + i9) * 4;
            } else {
                if (i4 == 3) {
                    int i11 = i5 == 2 ? sf.f63699e[i6 - 1] : sf.f63700f[i6 - 1];
                    this.f63707f = i11;
                    this.f63704c = ((i11 * 144) / this.f63705d) + i9;
                } else {
                    int i12 = sf.f63701g[i6 - 1];
                    this.f63707f = i12;
                    this.f63704c = (((i5 == 1 ? 72 : 144) * i12) / this.f63705d) + i9;
                }
            }
            this.f63706e = ((i3 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int b(int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (!c(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = f63696b[i7];
        if (i4 == 2) {
            i8 /= 2;
        } else if (i4 == 0) {
            i8 /= 4;
        }
        int i9 = (i3 >>> 9) & 1;
        if (i5 == 3) {
            return ((((i4 == 3 ? f63697c[i6 - 1] : f63698d[i6 - 1]) * 12) / i8) + i9) * 4;
        }
        int i10 = i4 == 3 ? i5 == 2 ? f63699e[i6 - 1] : f63700f[i6 - 1] : f63701g[i6 - 1];
        if (i4 == 3) {
            return ((i10 * 144) / i8) + i9;
        }
        return (((i5 == 1 ? 72 : 144) * i10) / i8) + i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(int i3) {
        return (i3 & (-2097152)) == -2097152;
    }

    public static int d(int i3) {
        int i4;
        int i5;
        if (!c(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0) {
            return -1;
        }
        int i6 = (i3 >>> 12) & 15;
        int i7 = (i3 >>> 10) & 3;
        if (i6 == 0 || i6 == 15 || i7 == 3) {
            return -1;
        }
        return b(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i3, int i4) {
        if (i4 == 1) {
            return i3 == 3 ? 1152 : 576;
        }
        if (i4 == 2) {
            return 1152;
        }
        if (i4 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }
}
