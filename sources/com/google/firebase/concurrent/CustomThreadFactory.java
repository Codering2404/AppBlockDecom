package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CustomThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f88167f = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f88168a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f88171d;

    CustomThreadFactory(String str, int i3, StrictMode.ThreadPolicy threadPolicy) {
        this.f88169b = str;
        this.f88170c = i3;
        this.f88171d = threadPolicy;
    }

    public static /* synthetic */ void a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        Process.setThreadPriority(customThreadFactory.f88170c);
        StrictMode.ThreadPolicy threadPolicy = customThreadFactory.f88171d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f88167f.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                CustomThreadFactory.a(this.f88209a, runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f88169b, Long.valueOf(this.f88168a.getAndIncrement())));
        return threadNewThread;
    }
}
