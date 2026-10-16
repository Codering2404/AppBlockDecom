package com.google.android.libraries.places.internal;

import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f76644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f76645b = "CallOptions";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbqu f76646c;

    zzbqg(zzbqu zzbquVar, long j3, String str) {
        this.f76644a = j3;
        Objects.requireNonNull(zzbquVar);
        this.f76646c = zzbquVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j3 = this.f76644a;
        long jAbs = Math.abs(j3);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit.toNanos(1L);
        long jAbs2 = Math.abs(j3) % timeUnit.toNanos(1L);
        StringBuilder sb = new StringBuilder();
        if (j3 < 0) {
            sb.append("ClientCall started after ");
            sb.append(this.f76645b);
            sb.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb.append("Deadline ");
            sb.append(this.f76645b);
            sb.append(" was exceeded after ");
        }
        sb.append(nanos);
        sb.append(String.format(Locale.US, sKeKFMqmvNzY.NlrlJmtqBPOoUum, Long.valueOf(jAbs2)));
        sb.append("s");
        this.f76646c.h(zzbnp.f76491h.e(sb.toString()), true);
    }
}
