package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f139059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f139060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f139061c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f139059a + '-' + incrementAndGet();
        Thread rxCustomThread = this.f139061c ? new RxCustomThread(runnable, str) : new Thread(runnable, str);
        rxCustomThread.setPriority(this.f139060b);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f139059a + "]";
    }

    public RxThreadFactory(String str, int i3) {
        this(str, i3, false);
    }

    public RxThreadFactory(String str, int i3, boolean z2) {
        this.f139059a = str;
        this.f139060b = i3;
        this.f139061c = z2;
    }
}
