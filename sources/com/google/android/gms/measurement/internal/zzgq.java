package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgq {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static zzgq f73712d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzic f73713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TelemetryLoggingClient f73714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f73715c = new AtomicLong(-1);

    private zzgq(Context context, zzic zzicVar) {
        this.f73714b = TelemetryLogging.b(context, TelemetryLoggingOptions.a().b("measurement:api").a());
        this.f73713a = zzicVar;
    }

    static zzgq a(zzic zzicVar) {
        if (f73712d == null) {
            f73712d = new zzgq(zzicVar.d(), zzicVar);
        }
        return f73712d;
    }

    public final synchronized void b(int i3, int i4, long j3, long j4, int i5) {
        final long jA = this.f73713a.e().a();
        AtomicLong atomicLong = this.f73715c;
        if (atomicLong.get() != -1 && jA - atomicLong.get() <= 1800000) {
            return;
        }
        this.f73714b.b(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i4, 0, j3, j4, null, null, 0, i5)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgp
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.f73710a.c(jA, exc);
            }
        });
    }

    final /* synthetic */ void c(long j3, Exception exc) {
        this.f73715c.set(j3);
    }
}
