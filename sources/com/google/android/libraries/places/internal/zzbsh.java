package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbsh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Random f76787a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f76788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f76789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f76790d;

    public zzbsh() {
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        this.f76788b = nanos;
        this.f76789c = TimeUnit.MINUTES.toNanos(2L);
        this.f76790d = nanos;
    }

    public final long a() {
        long j3 = this.f76790d;
        double d3 = j3;
        this.f76790d = Math.min((long) (1.6d * d3), this.f76789c);
        double d4 = 0.2d * d3;
        double d5 = d3 * (-0.2d);
        Preconditions.d(d4 >= d5);
        return j3 + ((long) ((this.f76787a.nextDouble() * (d4 - d5)) + d5));
    }
}
