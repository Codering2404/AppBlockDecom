package com.google.android.libraries.places.internal;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzbnm {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f76484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f76485b;

    zzbnm(int i3) {
        this.f76484a = i3;
        this.f76485b = Integer.toString(i3).getBytes(StandardCharsets.US_ASCII);
    }

    public final zzbnp a() {
        return (zzbnp) zzbnp.f76487d.get(this.f76484a);
    }

    final /* synthetic */ byte[] b() {
        return this.f76485b;
    }

    public final int zza() {
        return this.f76484a;
    }
}
