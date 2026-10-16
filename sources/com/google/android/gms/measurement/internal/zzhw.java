package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhw implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzhz f73863b;

    public zzhw(zzhz zzhzVar, String str) {
        Objects.requireNonNull(zzhzVar);
        this.f73863b = zzhzVar;
        Preconditions.m(str);
        this.f73862a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f73863b.f73997a.a().o().b(this.f73862a, th);
    }
}
