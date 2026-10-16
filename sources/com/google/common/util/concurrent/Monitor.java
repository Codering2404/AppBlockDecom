package com.google.common.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Monitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReentrantLock f85887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Guard f85888b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Guard {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Condition f85889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Guard f85890b;

        public abstract boolean a();
    }

    private boolean c(Guard guard) {
        try {
            return guard.a();
        } catch (Throwable th) {
            e();
            throw th;
        }
    }

    private void e() {
        for (Guard guard = this.f85888b; guard != null; guard = guard.f85890b) {
            guard.f85889a.signalAll();
        }
    }

    private void f() {
        for (Guard guard = this.f85888b; guard != null; guard = guard.f85890b) {
            if (c(guard)) {
                guard.f85889a.signal();
                return;
            }
        }
    }

    public void a() {
        this.f85887a.lock();
    }

    public boolean b() {
        return this.f85887a.isHeldByCurrentThread();
    }

    public void d() {
        ReentrantLock reentrantLock = this.f85887a;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                f();
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
