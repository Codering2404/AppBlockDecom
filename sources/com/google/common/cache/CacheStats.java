package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CacheStats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f83491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f83492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f83493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f83494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f83495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f83496f;

    public CacheStats(long j3, long j4, long j5, long j6, long j7, long j8) {
        Preconditions.d(j3 >= 0);
        Preconditions.d(j4 >= 0);
        Preconditions.d(j5 >= 0);
        Preconditions.d(j6 >= 0);
        Preconditions.d(j7 >= 0);
        Preconditions.d(j8 >= 0);
        this.f83491a = j3;
        this.f83492b = j4;
        this.f83493c = j5;
        this.f83494d = j6;
        this.f83495e = j7;
        this.f83496f = j8;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CacheStats) {
            CacheStats cacheStats = (CacheStats) obj;
            if (this.f83491a == cacheStats.f83491a && this.f83492b == cacheStats.f83492b && this.f83493c == cacheStats.f83493c && this.f83494d == cacheStats.f83494d && this.f83495e == cacheStats.f83495e && this.f83496f == cacheStats.f83496f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f83491a), Long.valueOf(this.f83492b), Long.valueOf(this.f83493c), Long.valueOf(this.f83494d), Long.valueOf(this.f83495e), Long.valueOf(this.f83496f));
    }

    public String toString() {
        return MoreObjects.c(this).c("hitCount", this.f83491a).c("missCount", this.f83492b).c("loadSuccessCount", this.f83493c).c("loadExceptionCount", this.f83494d).c("totalLoadTime", this.f83495e).c("evictionCount", this.f83496f).toString();
    }
}
