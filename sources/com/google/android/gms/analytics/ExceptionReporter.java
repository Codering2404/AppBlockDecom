package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.internal.gtm.zzfc;
import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f70861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Tracker f70862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f70863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExceptionParser f70864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GoogleAnalytics f70865e;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        String strA;
        if (this.f70864d != null) {
            strA = this.f70864d.a(thread != null ? thread.getName() : null, th);
        } else {
            strA = "UncaughtException";
        }
        zzfc.zzd("Reporting uncaught exception: ".concat(String.valueOf(strA)));
        Tracker tracker = this.f70862b;
        HitBuilders.ExceptionBuilder exceptionBuilder = new HitBuilders.ExceptionBuilder();
        exceptionBuilder.h(strA);
        exceptionBuilder.i(true);
        tracker.c(exceptionBuilder.d());
        if (this.f70865e == null) {
            this.f70865e = GoogleAnalytics.j(this.f70863c);
        }
        GoogleAnalytics googleAnalytics = this.f70865e;
        googleAnalytics.h();
        googleAnalytics.e().zzf().zzn();
        if (this.f70861a != null) {
            zzfc.zzd("Passing exception to the original handler");
            this.f70861a.uncaughtException(thread, th);
        }
    }
}
