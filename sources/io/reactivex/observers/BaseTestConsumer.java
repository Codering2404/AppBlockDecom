package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CountDownLatch f139226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List f139227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final List f139228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f139229d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Thread f139230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f139231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f139232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f139233i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1000);
            }
        };

        static void a(int i3) {
            try {
                Thread.sleep(i3);
            } catch (InterruptedException e3) {
                throw new RuntimeException(e3);
            }
        }
    }
}
