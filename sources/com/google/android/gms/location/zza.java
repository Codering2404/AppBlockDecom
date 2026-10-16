package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f72999a = Long.MIN_VALUE;

    public final zza a(long j3) {
        Preconditions.b(j3 >= 0, "intervalMillis can't be negative.");
        this.f72999a = j3;
        return this;
    }

    public final zzb b() {
        Preconditions.r(this.f72999a != Long.MIN_VALUE, "Must set intervalMillis.");
        return new zzb(this.f72999a, true, null, null, null, false, null, 0L, null);
    }
}
