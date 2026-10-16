package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Striped<L> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CompactStriped<L> extends PowerOfTwoStriped<L> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PaddedLock extends ReentrantLock {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PaddedSemaphore extends Semaphore {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ArrayReference<L> extends WeakReference<L> {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class WeakSafeCondition extends ForwardingCondition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Condition f85955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakSafeReadWriteLock f85956b;

        WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.f85955a = condition;
            this.f85956b = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        Condition a() {
            return this.f85955a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class WeakSafeLock extends ForwardingLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lock f85957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakSafeReadWriteLock f85958b;

        WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.f85957a = lock;
            this.f85958b = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        Lock a() {
            return this.f85957a;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.f85957a.newCondition(), this.f85958b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class WeakSafeReadWriteLock implements ReadWriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReadWriteLock f85959a;

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.f85959a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.f85959a.writeLock(), this);
        }
    }
}
