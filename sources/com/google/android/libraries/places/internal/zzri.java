package com.google.android.libraries.places.internal;

import android.os.StrictMode;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzri {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzri f78509c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f78510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicLong f78511b;

    static {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            f78509c = new zzri(UUID.randomUUID(), new SecureRandom().nextLong());
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    zzri(UUID uuid, long j3) {
        this.f78510a = uuid;
        this.f78511b = new AtomicLong((j3 ^ 25214903917L) & 281474976710655L);
    }

    static zzri a() {
        return f78509c;
    }

    final long b() {
        AtomicLong atomicLong;
        long j3;
        long j4;
        long j5;
        do {
            atomicLong = this.f78511b;
            j3 = atomicLong.get();
            j4 = ((j3 * 25214903917L) + 11) & 281474976710655L;
            j5 = ((25214903917L * j4) + 11) & 281474976710655L;
        } while (!atomicLong.compareAndSet(j3, j5));
        return (((long) ((int) (j4 >>> 16))) << 32) + ((long) ((int) (j5 >>> 16)));
    }

    public final UUID c() {
        long jB = b() & (-61441);
        long jB2 = b() >>> 2;
        UUID uuid = this.f78510a;
        return new UUID(jB ^ uuid.getMostSignificantBits(), jB2 ^ uuid.getLeastSignificantBits());
    }
}
