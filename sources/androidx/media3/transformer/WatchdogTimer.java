package androidx.media3.transformer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WatchdogTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f48647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f48648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f48649c = Util.R0("WatchdogTimer");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ScheduledFuture f48650d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a();
    }

    public WatchdogTimer(long j3, Listener listener) {
        this.f48647a = j3;
        this.f48648b = listener;
    }

    private void a() {
        ((ScheduledFuture) Assertions.e(this.f48650d)).cancel(false);
    }

    private void c() {
        ScheduledExecutorService scheduledExecutorService = this.f48649c;
        final Listener listener = this.f48648b;
        Objects.requireNonNull(listener);
        this.f48650d = scheduledExecutorService.schedule(new Runnable() { // from class: androidx.media3.transformer.m2
            @Override // java.lang.Runnable
            public final void run() {
                listener.a();
            }
        }, this.f48647a, TimeUnit.MILLISECONDS);
    }

    public void b() {
        a();
        c();
    }

    public void d() {
        c();
    }

    public void e() {
        a();
        this.f48649c.shutdownNow();
    }
}
