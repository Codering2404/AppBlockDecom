package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ThreadBoundProxy implements ThreadBound {
    private final ThreadBound mEnforcer;

    public ThreadBoundProxy(ThreadBound threadBound) {
        this.mEnforcer = (ThreadBound) Util.throwIfNull(threadBound);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final boolean checkThreadAccess() {
        return this.mEnforcer.checkThreadAccess();
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) this.mEnforcer.postAndWait(uncheckedCallable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void postDelayed(Runnable runnable, long j3) {
        this.mEnforcer.postDelayed(runnable, j3);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void removeCallbacks(Runnable runnable) {
        this.mEnforcer.removeCallbacks(runnable);
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void verifyThreadAccess() {
        this.mEnforcer.verifyThreadAccess();
    }

    @Override // com.facebook.stetho.common.ThreadBound
    public final void postAndWait(Runnable runnable) {
        this.mEnforcer.postAndWait(runnable);
    }
}
