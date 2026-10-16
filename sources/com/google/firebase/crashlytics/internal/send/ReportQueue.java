package com.google.firebase.crashlytics.internal.send;

import android.os.SystemClock;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.ForcedSender;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ReportQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f89027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f89028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f89029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f89030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f89031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue f89032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ThreadPoolExecutor f89033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Transport f89034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OnDemandCounter f89035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f89036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f89037k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ReportRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CrashlyticsReportWithSessionId f89038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskCompletionSource f89039b;

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.n(this.f89038a, this.f89039b);
            ReportQueue.this.f89035i.c();
            double dG = ReportQueue.this.g();
            Logger.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f89038a.d());
            ReportQueue.o(dG);
        }

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource taskCompletionSource) {
            this.f89038a = crashlyticsReportWithSessionId;
            this.f89039b = taskCompletionSource;
        }
    }

    ReportQueue(Transport transport, Settings settings, OnDemandCounter onDemandCounter) {
        this(settings.f89056f, settings.f89057g, ((long) settings.f89058h) * 1000, transport, onDemandCounter);
    }

    public static /* synthetic */ void a(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z2, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        reportQueue.getClass();
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z2) {
            reportQueue.j();
        }
        taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
    }

    public static /* synthetic */ void b(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        reportQueue.getClass();
        try {
            ForcedSender.a(reportQueue.f89034h, Priority.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f89027a) * Math.pow(this.f89028b, h()));
    }

    private int h() {
        if (this.f89037k == 0) {
            this.f89037k = m();
        }
        int iM = (int) ((m() - this.f89037k) / this.f89029c);
        int iMin = l() ? Math.min(100, this.f89036j + iM) : Math.max(0, this.f89036j - iM);
        if (this.f89036j != iMin) {
            this.f89036j = iMin;
            this.f89037k = m();
        }
        return iMin;
    }

    private boolean k() {
        return this.f89032f.size() < this.f89031e;
    }

    private boolean l() {
        return this.f89032f.size() == this.f89031e;
    }

    private long m() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource taskCompletionSource) {
        Logger.f().b("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.d());
        final boolean z2 = SystemClock.elapsedRealtime() - this.f89030d < 2000;
        this.f89034h.a(Event.h(crashlyticsReportWithSessionId.b()), new TransportScheduleCallback() { // from class: com.google.firebase.crashlytics.internal.send.b
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void a(Exception exc) {
                ReportQueue.a(this.f89041a, taskCompletionSource, z2, crashlyticsReportWithSessionId, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(double d3) {
        try {
            Thread.sleep((long) d3);
        } catch (InterruptedException unused) {
        }
    }

    TaskCompletionSource i(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z2) {
        synchronized (this.f89032f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z2) {
                    n(crashlyticsReportWithSessionId, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.f89035i.b();
                if (!k()) {
                    h();
                    Logger.f().b("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.d());
                    this.f89035i.a();
                    taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                Logger.f().b("Enqueueing report: " + crashlyticsReportWithSessionId.d());
                Logger.f().b("Queue size: " + this.f89032f.size());
                this.f89033g.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                Logger.f().b("Closing task for report: " + crashlyticsReportWithSessionId.d());
                taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.c
            @Override // java.lang.Runnable
            public final void run() {
                ReportQueue.b(this.f89045a, countDownLatch);
            }
        }).start();
        Utils.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    ReportQueue(double d3, double d4, long j3, Transport transport, OnDemandCounter onDemandCounter) {
        this.f89027a = d3;
        this.f89028b = d4;
        this.f89029c = j3;
        this.f89034h = transport;
        this.f89035i = onDemandCounter;
        this.f89030d = SystemClock.elapsedRealtime();
        int i3 = (int) d3;
        this.f89031e = i3;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i3);
        this.f89032f = arrayBlockingQueue;
        this.f89033g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f89036j = 0;
        this.f89037k = 0L;
    }
}
