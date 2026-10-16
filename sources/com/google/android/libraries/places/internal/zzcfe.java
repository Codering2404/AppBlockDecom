package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzcfe extends zzcfx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ReentrantLock f77739a;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f77739a = reentrantLock;
        Intrinsics.checkNotNullExpressionValue(reentrantLock.newCondition(), "newCondition(...)");
        TimeUnit.MILLISECONDS.toNanos(TimeUnit.SECONDS.toMillis(60L));
    }

    public static final boolean b() {
        ReentrantLock reentrantLock = f77739a;
        reentrantLock.lock();
        reentrantLock.unlock();
        return false;
    }
}
