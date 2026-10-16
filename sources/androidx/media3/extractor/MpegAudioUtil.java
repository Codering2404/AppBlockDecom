package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MpegAudioUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f46196a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f46197b = {44100, 48000, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f46198c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f46199d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f46200e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f46201f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f46202g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Header {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f46203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f46204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f46205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f46206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f46207e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f46208f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f46209g;

        public Header() {
        }

        public boolean a(int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (!MpegAudioUtil.l(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
                return false;
            }
            this.f46203a = i4;
            this.f46204b = MpegAudioUtil.f46196a[3 - i5];
            int i8 = MpegAudioUtil.f46197b[i7];
            this.f46206d = i8;
            if (i4 == 2) {
                this.f46206d = i8 / 2;
            } else if (i4 == 0) {
                this.f46206d = i8 / 4;
            }
            int i9 = (i3 >>> 9) & 1;
            this.f46209g = MpegAudioUtil.k(i4, i5);
            if (i5 == 3) {
                int i10 = i4 == 3 ? MpegAudioUtil.f46198c[i6 - 1] : MpegAudioUtil.f46199d[i6 - 1];
                this.f46208f = i10;
                this.f46205c = (((i10 * 12) / this.f46206d) + i9) * 4;
            } else {
                if (i4 == 3) {
                    int i11 = i5 == 2 ? MpegAudioUtil.f46200e[i6 - 1] : MpegAudioUtil.f46201f[i6 - 1];
                    this.f46208f = i11;
                    this.f46205c = ((i11 * 144) / this.f46206d) + i9;
                } else {
                    int i12 = MpegAudioUtil.f46202g[i6 - 1];
                    this.f46208f = i12;
                    this.f46205c = (((i5 == 1 ? 72 : 144) * i12) / this.f46206d) + i9;
                }
            }
            this.f46207e = ((i3 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }

        public Header(Header header) {
            this.f46203a = header.f46203a;
            this.f46204b = header.f46204b;
            this.f46205c = header.f46205c;
            this.f46206d = header.f46206d;
            this.f46207e = header.f46207e;
            this.f46208f = header.f46208f;
            this.f46209g = header.f46209g;
        }
    }

    public static int j(int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (!l(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0 || (i6 = (i3 >>> 12) & 15) == 0 || i6 == 15 || (i7 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = f46197b[i7];
        if (i4 == 2) {
            i8 /= 2;
        } else if (i4 == 0) {
            i8 /= 4;
        }
        int i9 = (i3 >>> 9) & 1;
        if (i5 == 3) {
            return ((((i4 == 3 ? f46198c[i6 - 1] : f46199d[i6 - 1]) * 12) / i8) + i9) * 4;
        }
        int i10 = i4 == 3 ? i5 == 2 ? f46200e[i6 - 1] : f46201f[i6 - 1] : f46202g[i6 - 1];
        if (i4 == 3) {
            return ((i10 * 144) / i8) + i9;
        }
        return (((i5 == 1 ? 72 : 144) * i10) / i8) + i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i3, int i4) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(int i3) {
        return (i3 & (-2097152)) == -2097152;
    }

    public static int m(int i3) {
        int i4;
        int i5;
        if (!l(i3) || (i4 = (i3 >>> 19) & 3) == 1 || (i5 = (i3 >>> 17) & 3) == 0) {
            return -1;
        }
        int i6 = (i3 >>> 12) & 15;
        int i7 = (i3 >>> 10) & 3;
        if (i6 == 0 || i6 == 15 || i7 == 3) {
            return -1;
        }
        return k(i4, i5);
    }
}
