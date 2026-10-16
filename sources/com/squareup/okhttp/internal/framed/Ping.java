package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Ping {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f93293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f93294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f93295c;

    void a() {
        if (this.f93295c == -1) {
            long j3 = this.f93294b;
            if (j3 != -1) {
                this.f93295c = j3 - 1;
                this.f93293a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    void b() {
        if (this.f93295c != -1 || this.f93294b == -1) {
            throw new IllegalStateException();
        }
        this.f93295c = System.nanoTime();
        this.f93293a.countDown();
    }

    void c() {
        if (this.f93294b != -1) {
            throw new IllegalStateException();
        }
        this.f93294b = System.nanoTime();
    }
}
