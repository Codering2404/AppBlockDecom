package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class QueueDrainHelper {
    public static boolean a(boolean z2, boolean z3, Observer observer, boolean z4, SimpleQueue simpleQueue, Disposable disposable, ObservableQueueDrain observableQueueDrain) {
        if (observableQueueDrain.d()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z4) {
            if (!z3) {
                return false;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            Throwable thP = observableQueueDrain.p();
            if (thP != null) {
                observer.onError(thP);
            } else {
                observer.onComplete();
            }
            return true;
        }
        Throwable thP2 = observableQueueDrain.p();
        if (thP2 != null) {
            simpleQueue.clear();
            if (disposable != null) {
                disposable.dispose();
            }
            observer.onError(thP2);
            return true;
        }
        if (!z3) {
            return false;
        }
        if (disposable != null) {
            disposable.dispose();
        }
        observer.onComplete();
        return true;
    }

    public static boolean b(boolean z2, boolean z3, Subscriber subscriber, boolean z4, SimpleQueue simpleQueue, QueueDrain queueDrain) {
        if (queueDrain.d()) {
            simpleQueue.clear();
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z4) {
            if (!z3) {
                return false;
            }
            Throwable thP = queueDrain.p();
            if (thP != null) {
                subscriber.onError(thP);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable thP2 = queueDrain.p();
        if (thP2 != null) {
            simpleQueue.clear();
            subscriber.onError(thP2);
            return true;
        }
        if (!z3) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    public static SimpleQueue c(int i3) {
        return i3 < 0 ? new SpscLinkedArrayQueue(-i3) : new SpscArrayQueue(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r1 = r8.b(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r1 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(io.reactivex.internal.fuseable.SimplePlainQueue r9, io.reactivex.Observer r10, boolean r11, io.reactivex.disposables.Disposable r12, io.reactivex.internal.util.ObservableQueueDrain r13) {
        /*
            r0 = 1
            r1 = r0
        L2:
            boolean r2 = r13.c()
            boolean r3 = r9.isEmpty()
            r6 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r8 = r13
            boolean r9 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r9 == 0) goto L16
            goto L35
        L16:
            boolean r2 = r8.c()
            java.lang.Object r9 = r6.poll()
            if (r9 != 0) goto L22
            r3 = r0
            goto L24
        L22:
            r10 = 0
            r3 = r10
        L24:
            boolean r10 = a(r2, r3, r4, r5, r6, r7, r8)
            r11 = r3
            if (r10 == 0) goto L2c
            goto L35
        L2c:
            if (r11 == 0) goto L3c
            int r9 = -r1
            int r1 = r8.b(r9)
            if (r1 != 0) goto L36
        L35:
            return
        L36:
            r10 = r4
            r11 = r5
            r9 = r6
            r12 = r7
            r13 = r8
            goto L2
        L3c:
            r8.f(r4, r9)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.QueueDrainHelper.d(io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.Observer, boolean, io.reactivex.disposables.Disposable, io.reactivex.internal.util.ObservableQueueDrain):void");
    }

    public static void e(SimplePlainQueue simplePlainQueue, Subscriber subscriber, boolean z2, Disposable disposable, QueueDrain queueDrain) {
        int iB = 1;
        while (true) {
            boolean zC = queueDrain.c();
            Object objPoll = simplePlainQueue.poll();
            boolean z3 = objPoll == null;
            SimplePlainQueue simplePlainQueue2 = simplePlainQueue;
            Subscriber subscriber2 = subscriber;
            boolean z4 = z2;
            QueueDrain queueDrain2 = queueDrain;
            if (b(zC, z3, subscriber2, z4, simplePlainQueue2, queueDrain2)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            }
            if (z3) {
                iB = queueDrain2.b(-iB);
                if (iB == 0) {
                    return;
                }
            } else {
                long jA = queueDrain2.a();
                if (jA == 0) {
                    simplePlainQueue2.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber2.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
                if (queueDrain2.f(subscriber2, objPoll) && jA != Long.MAX_VALUE) {
                    queueDrain2.i(1L);
                }
            }
            subscriber = subscriber2;
            z2 = z4;
            simplePlainQueue = simplePlainQueue2;
            queueDrain = queueDrain2;
        }
    }

    static boolean f(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.a();
        } catch (Throwable th) {
            Exceptions.b(th);
            return true;
        }
    }

    public static void g(Subscriber subscriber, Queue queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j3;
        long j4;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (h(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            return;
        }
        do {
            j3 = atomicLong.get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j4 = j3 | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        if (j3 != 0) {
            h(j4, subscriber, queue, atomicLong, booleanSupplier);
        }
    }

    static boolean h(long j3, Subscriber subscriber, Queue queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j4 = j3 & Long.MIN_VALUE;
        while (true) {
            if (j4 != j3) {
                if (f(booleanSupplier)) {
                    return true;
                }
                Object objPoll = queue.poll();
                if (objPoll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.h(objPoll);
                j4++;
            } else {
                if (f(booleanSupplier)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j3 = atomicLong.get();
                if (j3 == j4) {
                    long jAddAndGet = atomicLong.addAndGet(-(j4 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j4 = jAddAndGet & Long.MIN_VALUE;
                    j3 = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static boolean i(long j3, Subscriber subscriber, Queue queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j4;
        do {
            j4 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j4, BackpressureHelper.c(Long.MAX_VALUE & j4, j3) | (j4 & Long.MIN_VALUE)));
        if (j4 != Long.MIN_VALUE) {
            return false;
        }
        h(j3 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    public static void j(Subscription subscription, int i3) {
        subscription.y(i3 < 0 ? Long.MAX_VALUE : i3);
    }
}
