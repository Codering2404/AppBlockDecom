package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzboo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f76558c = Logger.getLogger(zzboo.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f76559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicLong f76560b;

    public zzboo(String str, long j3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f76560b = atomicLong;
        Preconditions.e(true, "value must be positive");
        this.f76559a = "keepalive time nanos";
        atomicLong.set(Long.MAX_VALUE);
    }

    public final zzbon a() {
        return new zzbon(this, this.f76560b.get(), null);
    }

    final /* synthetic */ String c() {
        return this.f76559a;
    }

    final /* synthetic */ AtomicLong d() {
        return this.f76560b;
    }
}
