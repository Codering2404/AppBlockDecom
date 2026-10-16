package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhx extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f73864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f73865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f73866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzhz f73867d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhx(zzhz zzhzVar, Runnable runnable, boolean z2, String str) {
        super(runnable, null);
        Objects.requireNonNull(zzhzVar);
        this.f73867d = zzhzVar;
        Preconditions.m(str);
        long andIncrement = zzhz.f73872k.getAndIncrement();
        this.f73864a = andIncrement;
        this.f73866c = str;
        this.f73865b = z2;
        if (andIncrement == Long.MAX_VALUE) {
            zzhzVar.f73997a.a().o().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhx zzhxVar = (zzhx) obj;
        boolean z2 = zzhxVar.f73865b;
        boolean z3 = this.f73865b;
        if (z3 != z2) {
            return !z3 ? 1 : -1;
        }
        long j3 = this.f73864a;
        long j4 = zzhxVar.f73864a;
        if (j3 < j4) {
            return -1;
        }
        if (j3 > j4) {
            return 1;
        }
        this.f73867d.f73997a.a().p().b("Two tasks share the same index. index", Long.valueOf(j3));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.f73867d.f73997a.a().o().b(this.f73866c, th);
        if ((th instanceof zzhv) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhx(zzhz zzhzVar, Callable callable, boolean z2, String str) {
        super(callable);
        Objects.requireNonNull(zzhzVar);
        this.f73867d = zzhzVar;
        Preconditions.m("Task exception on worker thread");
        long andIncrement = zzhz.f73872k.getAndIncrement();
        this.f73864a = andIncrement;
        this.f73866c = "Task exception on worker thread";
        this.f73865b = z2;
        if (andIncrement == Long.MAX_VALUE) {
            zzhzVar.f73997a.a().o().a("Tasks index overflow");
        }
    }
}
