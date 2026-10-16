package com.evernote.android.job.util;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobCat implements JobLogger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile JobLogger[] f67962c = new JobLogger[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f67963d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f67964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f67965b;

    public JobCat(String str) {
        this(str, true);
    }

    @Override // com.evernote.android.job.util.JobLogger
    public void a(int i3, String str, String str2, Throwable th) {
        if (this.f67965b) {
            if (f67963d) {
                Log.println(i3, str, str2 + (th == null ? "" : '\n' + Log.getStackTraceString(th)));
            }
            JobLogger[] jobLoggerArr = f67962c;
            if (jobLoggerArr.length > 0) {
                for (JobLogger jobLogger : jobLoggerArr) {
                    if (jobLogger != null) {
                        jobLogger.a(i3, str, str2, th);
                    }
                }
            }
        }
    }

    public void b(String str) {
        a(3, this.f67964a, str, null);
    }

    public void c(String str, Object... objArr) {
        a(3, this.f67964a, String.format(str, objArr), null);
    }

    public void d(String str) {
        a(6, this.f67964a, str, null);
    }

    public void e(String str, Object... objArr) {
        a(6, this.f67964a, String.format(str, objArr), null);
    }

    public void f(Throwable th) {
        String message = th.getMessage();
        String str = this.f67964a;
        if (message == null) {
            message = "empty message";
        }
        a(6, str, message, th);
    }

    public void g(Throwable th, String str, Object... objArr) {
        a(6, this.f67964a, String.format(str, objArr), th);
    }

    public void h(String str) {
        a(4, this.f67964a, str, null);
    }

    public void i(String str, Object... objArr) {
        a(4, this.f67964a, String.format(str, objArr), null);
    }

    public void j(String str) {
        a(5, this.f67964a, str, null);
    }

    public void k(String str, Object... objArr) {
        a(5, this.f67964a, String.format(str, objArr), null);
    }

    public void l(Throwable th, String str, Object... objArr) {
        a(5, this.f67964a, String.format(str, objArr), th);
    }

    public JobCat(String str, boolean z2) {
        this.f67964a = str;
        this.f67965b = z2;
    }
}
