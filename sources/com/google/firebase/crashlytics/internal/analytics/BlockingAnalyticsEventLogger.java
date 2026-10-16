package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CrashlyticsOriginAnalyticsEventLogger f88289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeUnit f88291c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f88293e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f88292d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f88294f = false;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i3, TimeUnit timeUnit) {
        this.f88289a = crashlyticsOriginAnalyticsEventLogger;
        this.f88290b = i3;
        this.f88291c = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void a(String str, Bundle bundle) {
        synchronized (this.f88292d) {
            try {
                Logger.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f88293e = new CountDownLatch(1);
                this.f88294f = false;
                this.f88289a.a(str, bundle);
                Logger.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f88293e.await(this.f88290b, this.f88291c)) {
                        this.f88294f = true;
                        Logger.f().i("App exception callback received from Analytics listener.");
                    } else {
                        Logger.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    Logger.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f88293e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f88293e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
