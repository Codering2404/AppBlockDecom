package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f61208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f61209b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f61211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f61212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f61213d;

        public a(String str, String str2, long j3, long j4) {
            this.f61210a = str;
            this.f61211b = str2;
            this.f61212c = j3;
            this.f61213d = j4;
        }
    }

    public lf(long j3, List list) {
        this.f61208a = j3;
        this.f61209b = list;
    }

    public mf a(long j3) {
        long j4;
        if (this.f61209b.size() < 2) {
            return null;
        }
        long j5 = j3;
        long j6 = -1;
        long j7 = -1;
        long j8 = -1;
        long j9 = -1;
        boolean z2 = false;
        for (int size = this.f61209b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f61209b.get(size);
            boolean zEquals = "video/mp4".equals(aVar.f61210a) | z2;
            if (size == 0) {
                j5 -= aVar.f61213d;
                j4 = 0;
            } else {
                j4 = j5 - aVar.f61212c;
            }
            long j10 = j4;
            long j11 = j5;
            j5 = j10;
            if (!zEquals || j5 == j11) {
                z2 = zEquals;
            } else {
                j9 = j11 - j5;
                j8 = j5;
                z2 = false;
            }
            if (size == 0) {
                j6 = j5;
                j7 = j11;
            }
        }
        if (j8 == -1 || j9 == -1 || j6 == -1 || j7 == -1) {
            return null;
        }
        return new mf(j6, j7, this.f61208a, j8, j9);
    }
}
