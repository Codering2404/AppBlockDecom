package com.singular.sdk.internal.services;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class TimeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeProvider f92755a;

    public TimeService(TimeProvider timeProvider) {
        if (timeProvider == null) {
            this.f92755a = new SingularTimeProvider();
        } else {
            this.f92755a = timeProvider;
        }
    }

    public long a() {
        return this.f92755a.currentTimeMillis();
    }

    public double b(long j3) {
        return (a() - j3) * 0.001d;
    }
}
