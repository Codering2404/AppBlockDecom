package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SeekParameters {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SeekParameters f43296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SeekParameters f43297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SeekParameters f43298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SeekParameters f43299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SeekParameters f43300g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f43302b;

    static {
        SeekParameters seekParameters = new SeekParameters(0L, 0L);
        f43296c = seekParameters;
        f43297d = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
        f43298e = new SeekParameters(Long.MAX_VALUE, 0L);
        f43299f = new SeekParameters(0L, Long.MAX_VALUE);
        f43300g = seekParameters;
    }

    public SeekParameters(long j3, long j4) {
        Assertions.a(j3 >= 0);
        Assertions.a(j4 >= 0);
        this.f43301a = j3;
        this.f43302b = j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(long r9, long r11, long r13) {
        /*
            r8 = this;
            long r2 = r8.f43301a
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto Lf
            long r4 = r8.f43302b
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto Lf
            return r9
        Lf:
            r4 = -9223372036854775808
            r0 = r9
            long r9 = androidx.media3.common.util.Util.l1(r0, r2, r4)
            long r2 = r8.f43302b
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r2 = androidx.media3.common.util.Util.e(r0, r2, r4)
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 > 0) goto L2d
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 > 0) goto L2d
            r4 = r6
            goto L2e
        L2d:
            r4 = r5
        L2e:
            int r7 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r7 > 0) goto L37
            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r2 > 0) goto L37
            r5 = r6
        L37:
            if (r4 == 0) goto L4c
            if (r5 == 0) goto L4c
            long r9 = r11 - r0
            long r9 = java.lang.Math.abs(r9)
            long r0 = r13 - r0
            long r0 = java.lang.Math.abs(r0)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L51
            goto L4e
        L4c:
            if (r4 == 0) goto L4f
        L4e:
            return r11
        L4f:
            if (r5 == 0) goto L52
        L51:
            return r13
        L52:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.SeekParameters.a(long, long, long):long");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SeekParameters.class == obj.getClass()) {
            SeekParameters seekParameters = (SeekParameters) obj;
            if (this.f43301a == seekParameters.f43301a && this.f43302b == seekParameters.f43302b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f43301a) * 31) + ((int) this.f43302b);
    }
}
