package com.evernote.android.job;

import com.evernote.android.job.util.Clock;
import com.evernote.android.job.util.JobCat;
import java.util.EnumMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final EnumMap f67844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JobCat f67845b = new JobCat("JobConfig");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExecutorService f67846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f67847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f67848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile long f67849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f67850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f67851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f67852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile Clock f67853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile ExecutorService f67854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f67855l;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.evernote.android.job.JobConfig.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AtomicInteger f67856a = new AtomicInteger();

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AndroidJob-" + this.f67856a.incrementAndGet());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                if (thread.getPriority() != 5) {
                    thread.setPriority(5);
                }
                return thread;
            }
        });
        f67846c = executorServiceNewCachedThreadPool;
        f67848e = false;
        f67849f = 3000L;
        f67850g = false;
        f67851h = 0;
        f67852i = false;
        f67853j = Clock.f67961a;
        f67854k = executorServiceNewCachedThreadPool;
        f67855l = false;
        f67844a = new EnumMap(JobApi.class);
        for (JobApi jobApi : JobApi.values()) {
            f67844a.put(jobApi, Boolean.TRUE);
        }
    }

    public static Clock a() {
        return f67853j;
    }

    public static ExecutorService b() {
        return f67854k;
    }

    public static int c() {
        return f67851h;
    }

    public static long d() {
        return f67849f;
    }

    public static boolean e() {
        return f67847d;
    }

    public static boolean f(JobApi jobApi) {
        return ((Boolean) f67844a.get(jobApi)).booleanValue();
    }

    public static boolean g() {
        return f67855l;
    }

    public static boolean h() {
        return f67848e;
    }

    public static boolean i() {
        return f67852i;
    }

    static boolean j() {
        return f67850g;
    }
}
