package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class jj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final jj f60761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final jj f60762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final jj f60763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final jj f60764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final jj f60765g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f60766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f60767b;

    static {
        jj jjVar = new jj(0L, 0L);
        f60761c = jjVar;
        f60762d = new jj(Long.MAX_VALUE, Long.MAX_VALUE);
        f60763e = new jj(Long.MAX_VALUE, 0L);
        f60764f = new jj(0L, Long.MAX_VALUE);
        f60765g = jjVar;
    }

    public jj(long j3, long j4) {
        b1.a(j3 >= 0);
        b1.a(j4 >= 0);
        this.f60766a = j3;
        this.f60767b = j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(long r9, long r11, long r13) {
        /*
            r8 = this;
            long r2 = r8.f60766a
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto Lf
            long r4 = r8.f60767b
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto Lf
            return r9
        Lf:
            r4 = -9223372036854775808
            r0 = r9
            long r9 = com.applovin.impl.xp.d(r0, r2, r4)
            long r2 = r8.f60767b
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r2 = com.applovin.impl.xp.a(r0, r2, r4)
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
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.jj.a(long, long, long):long");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jj.class == obj.getClass()) {
            jj jjVar = (jj) obj;
            if (this.f60766a == jjVar.f60766a && this.f60767b == jjVar.f60767b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f60766a) * 31) + ((int) this.f60767b);
    }
}
