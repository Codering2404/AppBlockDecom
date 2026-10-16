package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class RequestLimiter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f89320d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f89321e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Utils f89322a = Utils.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f89323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f89324c;

    RequestLimiter() {
    }

    private synchronized long a(int i3) {
        if (c(i3)) {
            return (long) Math.min(Math.pow(2.0d, this.f89324c) + this.f89322a.e(), f89321e);
        }
        return f89320d;
    }

    private static boolean c(int i3) {
        if (i3 != 429) {
            return i3 >= 500 && i3 < 600;
        }
        return true;
    }

    private static boolean d(int i3) {
        return (i3 >= 200 && i3 < 300) || i3 == 401 || i3 == 404;
    }

    private synchronized void e() {
        this.f89324c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f89324c     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            com.google.firebase.installations.Utils r0 = r4.f89322a     // Catch: java.lang.Throwable -> L14
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L14
            long r2 = r4.f89323b     // Catch: java.lang.Throwable -> L14
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L12
            goto L16
        L12:
            r0 = 0
            goto L17
        L14:
            r0 = move-exception
            goto L19
        L16:
            r0 = 1
        L17:
            monitor-exit(r4)
            return r0
        L19:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.RequestLimiter.b():boolean");
    }

    public synchronized void f(int i3) {
        if (d(i3)) {
            e();
            return;
        }
        this.f89324c++;
        this.f89323b = this.f89322a.a() + a(i3);
    }
}
