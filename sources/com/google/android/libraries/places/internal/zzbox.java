package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbox implements zzbzh {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f76570e = Logger.getLogger(zzbox.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f76571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbnx f76572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbnw f76573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbsh f76574d;

    zzbox(zzbsg zzbsgVar, ScheduledExecutorService scheduledExecutorService, zzbnx zzbnxVar) {
        this.f76571a = scheduledExecutorService;
        this.f76572b = zzbnxVar;
    }

    final /* synthetic */ void a() {
        zzbnw zzbnwVar = this.f76573c;
        if (zzbnwVar != null && zzbnwVar.b()) {
            this.f76573c.a();
        }
        this.f76574d = null;
    }

    @Override // com.google.android.libraries.places.internal.zzbzh
    public final void zza(Runnable runnable) {
        zzbnx zzbnxVar = this.f76572b;
        zzbnxVar.b();
        if (this.f76574d == null) {
            this.f76574d = new zzbsh();
        }
        zzbnw zzbnwVar = this.f76573c;
        if (zzbnwVar == null || !zzbnwVar.b()) {
            long jA = this.f76574d.a();
            this.f76573c = zzbnxVar.c(runnable, jA, TimeUnit.NANOSECONDS, this.f76571a);
            f76570e.logp(Level.FINE, "io.grpc.internal.BackoffPolicyRetryScheduler", "schedule", "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbzh
    public final void zzb() {
        zzbnx zzbnxVar = this.f76572b;
        zzbnxVar.b();
        zzbnxVar.a(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbow
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f76569a.a();
            }
        });
        zzbnxVar.zza();
    }
}
