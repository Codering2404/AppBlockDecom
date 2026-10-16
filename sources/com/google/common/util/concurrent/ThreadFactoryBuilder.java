package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ThreadFactoryBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f85960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f85961b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f85962c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f85963d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadFactory f85964e = null;

    private static ThreadFactory c(ThreadFactoryBuilder threadFactoryBuilder) {
        final String str = threadFactoryBuilder.f85960a;
        final Boolean bool = threadFactoryBuilder.f85961b;
        final Integer num = threadFactoryBuilder.f85962c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.f85963d;
        ThreadFactory threadFactoryDefaultThreadFactory = threadFactoryBuilder.f85964e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory = threadFactoryDefaultThreadFactory;
        final AtomicLong atomicLong = str != null ? new AtomicLong(0L) : null;
        return new ThreadFactory() { // from class: com.google.common.util.concurrent.ThreadFactoryBuilder.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = threadFactory.newThread(runnable);
                Objects.requireNonNull(threadNewThread);
                String str2 = str;
                if (str2 != null) {
                    AtomicLong atomicLong2 = atomicLong;
                    Objects.requireNonNull(atomicLong2);
                    threadNewThread.setName(ThreadFactoryBuilder.d(str2, Long.valueOf(atomicLong2.getAndIncrement())));
                }
                Boolean bool2 = bool;
                if (bool2 != null) {
                    threadNewThread.setDaemon(bool2.booleanValue());
                }
                Integer num2 = num;
                if (num2 != null) {
                    threadNewThread.setPriority(num2.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler2 != null) {
                    threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                }
                return threadNewThread;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public ThreadFactoryBuilder e(boolean z2) {
        this.f85961b = Boolean.valueOf(z2);
        return this;
    }

    public ThreadFactoryBuilder f(String str) {
        d(str, 0);
        this.f85960a = str;
        return this;
    }

    public ThreadFactoryBuilder g(int i3) {
        Preconditions.i(i3 >= 1, "Thread priority (%s) must be >= %s", i3, 1);
        Preconditions.i(i3 <= 10, "Thread priority (%s) must be <= %s", i3, 10);
        this.f85962c = Integer.valueOf(i3);
        return this;
    }
}
