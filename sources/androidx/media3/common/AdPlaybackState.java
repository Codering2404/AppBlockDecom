package androidx.media3.common;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdPlaybackState {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AdPlaybackState f40484g = new AdPlaybackState(null, new AdGroup[0], 0, -9223372036854775807L, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AdGroup f40485h = new AdGroup(0).h(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f40486i = Util.y0(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f40487j = Util.y0(2);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f40488k = Util.y0(3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f40489l = Util.y0(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f40490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f40492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f40493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AdGroup[] f40495f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AdGroup {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f40496l = Util.y0(0);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f40497m = Util.y0(1);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String f40498n = Util.y0(2);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f40499o = Util.y0(3);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final String f40500p = Util.y0(4);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final String f40501q = Util.y0(5);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final String f40502r = Util.y0(6);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final String f40503s = Util.y0(7);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        static final String f40504t = Util.y0(8);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        static final String f40505u = Util.y0(9);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        static final String f40506v = Util.y0(10);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f40507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f40508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f40509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri[] f40510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MediaItem[] f40511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f40512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long[] f40513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String[] f40514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f40515i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f40516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f40517k;

        public AdGroup(long j3) {
            this(j3, -1, -1, new int[0], new MediaItem[0], new long[0], 0L, false, new String[0], false);
        }

        private static long[] a(long[] jArr, int i3) {
            int length = jArr.length;
            int iMax = Math.max(i3, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        private static int[] b(int[] iArr, int i3) {
            int length = iArr.length;
            int iMax = Math.max(i3, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public int c() {
            return d(-1);
        }

        public int d(int i3) {
            int i4;
            int i5 = i3 + 1;
            while (true) {
                int[] iArr = this.f40512f;
                if (i5 >= iArr.length || this.f40516j || (i4 = iArr[i5]) == 0 || i4 == 1) {
                    break;
                }
                i5++;
            }
            return i5;
        }

        public boolean e() {
            if (this.f40508b == -1) {
                return true;
            }
            for (int i3 = 0; i3 < this.f40508b; i3++) {
                int i4 = this.f40512f[i3];
                if (i4 == 0 || i4 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AdGroup.class == obj.getClass()) {
                AdGroup adGroup = (AdGroup) obj;
                if (this.f40507a == adGroup.f40507a && this.f40508b == adGroup.f40508b && this.f40509c == adGroup.f40509c && Arrays.equals(this.f40511e, adGroup.f40511e) && Arrays.equals(this.f40512f, adGroup.f40512f) && Arrays.equals(this.f40513g, adGroup.f40513g) && this.f40515i == adGroup.f40515i && this.f40516j == adGroup.f40516j && Arrays.equals(this.f40514h, adGroup.f40514h) && this.f40517k == adGroup.f40517k) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            return this.f40517k && this.f40507a == Long.MIN_VALUE && this.f40508b == -1;
        }

        public boolean g() {
            return this.f40508b == -1 || c() < this.f40508b;
        }

        public AdGroup h(int i3) {
            int[] iArrB = b(this.f40512f, i3);
            long[] jArrA = a(this.f40513g, i3);
            return new AdGroup(this.f40507a, i3, this.f40509c, iArrB, (MediaItem[]) Arrays.copyOf(this.f40511e, i3), jArrA, this.f40515i, this.f40516j, (String[]) Arrays.copyOf(this.f40514h, i3), this.f40517k);
        }

        public int hashCode() {
            int i3 = ((this.f40508b * 31) + this.f40509c) * 31;
            long j3 = this.f40507a;
            int iHashCode = (((((((i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f40511e)) * 31) + Arrays.hashCode(this.f40512f)) * 31) + Arrays.hashCode(this.f40513g)) * 31;
            long j4 = this.f40515i;
            return ((((((iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f40516j ? 1 : 0)) * 31) + Arrays.hashCode(this.f40514h)) * 31) + (this.f40517k ? 1 : 0);
        }

        public AdGroup i(long[] jArr) {
            int length = jArr.length;
            MediaItem[] mediaItemArr = this.f40511e;
            if (length < mediaItemArr.length) {
                jArr = a(jArr, mediaItemArr.length);
            } else if (this.f40508b != -1 && jArr.length > mediaItemArr.length) {
                jArr = Arrays.copyOf(jArr, mediaItemArr.length);
            }
            return new AdGroup(this.f40507a, this.f40508b, this.f40509c, this.f40512f, this.f40511e, jArr, this.f40515i, this.f40516j, this.f40514h, this.f40517k);
        }

        private AdGroup(long j3, int i3, int i4, int[] iArr, MediaItem[] mediaItemArr, long[] jArr, long j4, boolean z2, String[] strArr, boolean z3) {
            int i5 = 0;
            Assertions.a(iArr.length == mediaItemArr.length);
            this.f40507a = j3;
            this.f40508b = i3;
            this.f40509c = i4;
            this.f40512f = iArr;
            this.f40511e = mediaItemArr;
            this.f40513g = jArr;
            this.f40515i = j4;
            this.f40516j = z2;
            this.f40510d = new Uri[mediaItemArr.length];
            while (true) {
                Uri[] uriArr = this.f40510d;
                if (i5 >= uriArr.length) {
                    this.f40514h = strArr;
                    this.f40517k = z3;
                    return;
                } else {
                    MediaItem mediaItem = mediaItemArr[i5];
                    uriArr[i5] = mediaItem == null ? null : ((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f40714b)).f40810a;
                    i5++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    private AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j3, long j4, int i3) {
        this.f40490a = obj;
        this.f40492c = j3;
        this.f40493d = j4;
        this.f40491b = adGroupArr.length + i3;
        this.f40495f = adGroupArr;
        this.f40494e = i3;
    }

    private boolean f(long j3, long j4, int i3) {
        if (j3 == Long.MIN_VALUE) {
            return false;
        }
        AdGroup adGroupB = b(i3);
        long j5 = adGroupB.f40507a;
        return j5 == Long.MIN_VALUE ? j4 == -9223372036854775807L || adGroupB.f() || j3 < j4 : j3 < j5;
    }

    public boolean a() {
        int i3 = this.f40491b - 1;
        return i3 >= 0 && e(i3);
    }

    public AdGroup b(int i3) {
        int i4 = this.f40494e;
        return i3 < i4 ? f40485h : this.f40495f[i3 - i4];
    }

    public int c(long j3, long j4) {
        if (j3 != Long.MIN_VALUE && (j4 == -9223372036854775807L || j3 < j4)) {
            int i3 = this.f40494e;
            while (i3 < this.f40491b && ((b(i3).f40507a != Long.MIN_VALUE && b(i3).f40507a <= j3) || !b(i3).g())) {
                i3++;
            }
            if (i3 < this.f40491b) {
                return i3;
            }
        }
        return -1;
    }

    public int d(long j3, long j4) {
        int i3 = this.f40491b - 1;
        int i4 = i3 - (e(i3) ? 1 : 0);
        while (i4 >= 0) {
            long j5 = j3;
            long j6 = j4;
            if (!f(j5, j6, i4)) {
                break;
            }
            i4--;
            j3 = j5;
            j4 = j6;
        }
        if (i4 < 0 || !b(i4).e()) {
            return -1;
        }
        return i4;
    }

    public boolean e(int i3) {
        return i3 == this.f40491b - 1 && b(i3).f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AdPlaybackState.class == obj.getClass()) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
            if (Objects.equals(this.f40490a, adPlaybackState.f40490a) && this.f40491b == adPlaybackState.f40491b && this.f40492c == adPlaybackState.f40492c && this.f40493d == adPlaybackState.f40493d && this.f40494e == adPlaybackState.f40494e && Arrays.equals(this.f40495f, adPlaybackState.f40495f)) {
                return true;
            }
        }
        return false;
    }

    public AdPlaybackState g(long[][] jArr) {
        int i3 = 0;
        Assertions.a(jArr.length == this.f40491b);
        AdGroup[] adGroupArr = this.f40495f;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.U0(adGroupArr, adGroupArr.length);
        while (true) {
            int i4 = this.f40491b;
            int i5 = this.f40494e;
            if (i3 >= i4 - i5) {
                return new AdPlaybackState(this.f40490a, adGroupArr2, this.f40492c, this.f40493d, i5);
            }
            adGroupArr2[i3] = adGroupArr2[i3].i(jArr[i5 + i3]);
            i3++;
        }
    }

    public int hashCode() {
        int i3 = this.f40491b * 31;
        Object obj = this.f40490a;
        return ((((((((i3 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f40492c)) * 31) + ((int) this.f40493d)) * 31) + this.f40494e) * 31) + Arrays.hashCode(this.f40495f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f40490a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f40492c);
        sb.append(", adGroups=[");
        for (int i3 = 0; i3 < this.f40495f.length; i3++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f40495f[i3].f40507a);
            sb.append(", ads=[");
            for (int i4 = 0; i4 < this.f40495f[i3].f40512f.length; i4++) {
                sb.append("ad(state=");
                int i5 = this.f40495f[i3].f40512f[i4];
                if (i5 == 0) {
                    sb.append('_');
                } else if (i5 == 1) {
                    sb.append('R');
                } else if (i5 == 2) {
                    sb.append('S');
                } else if (i5 == 3) {
                    sb.append('P');
                } else if (i5 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f40495f[i3].f40513g[i4]);
                sb.append(')');
                if (i4 < this.f40495f[i3].f40512f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i3 < this.f40495f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
