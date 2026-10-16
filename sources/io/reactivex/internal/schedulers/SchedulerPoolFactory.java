package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.h;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SchedulerPoolFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f139067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f139068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final AtomicReference f139069c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map f139070d = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PurgeProperties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f139071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f139072b;

        PurgeProperties() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f139071a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f139071a = true;
            }
            if (!this.f139071a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f139072b = 1;
                return;
            }
            try {
                this.f139072b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f139072b = 1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList(SchedulerPoolFactory.f139070d.keySet());
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) obj;
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f139070d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        PurgeProperties purgeProperties = new PurgeProperties();
        purgeProperties.a(properties);
        f139067a = purgeProperties.f139071a;
        f139068b = purgeProperties.f139072b;
        b();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        c(f139067a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void b() {
        d(f139067a);
    }

    static void c(boolean z2, ScheduledExecutorService scheduledExecutorService) {
        if (z2 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f139070d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void d(boolean z2) {
        if (!z2) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = f139069c;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (h.a(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i3 = f139068b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i3, i3, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
