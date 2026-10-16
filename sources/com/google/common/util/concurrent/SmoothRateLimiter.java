package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class SmoothRateLimiter extends RateLimiter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double f85954b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SmoothBursty extends SmoothRateLimiter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SmoothWarmingUp extends SmoothRateLimiter {
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double a() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f85954b;
    }
}
