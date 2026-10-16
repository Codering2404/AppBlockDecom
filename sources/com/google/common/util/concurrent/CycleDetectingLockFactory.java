package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class CycleDetectingLockFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap f85794b = new MapMaker().l().i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LazyLogger f85795c = new LazyLogger(CycleDetectingLockFactory.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f85796d = new ThreadLocal<ArrayList<LockGraphNode>>() { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return Lists.m(3);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Policy f85797a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface CycleDetectingLock {
        LockGraphNode a();

        boolean b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CycleDetectingReentrantReadLock f85802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CycleDetectingReentrantWriteLock f85803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LockGraphNode f85804c;

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode a() {
            return this.f85804c;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean b() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.f85802a;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.f85803b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExampleStackTrace extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final StackTraceElement[] f85807a = new StackTraceElement[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final ImmutableSet f85808b = ImmutableSet.C(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());

        ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.d() + " -> " + lockGraphNode2.d());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i3].getClassName())) {
                    setStackTrace(f85807a);
                    return;
                } else {
                    if (!f85808b.contains(stackTrace[i3].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3, length));
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LockGraphNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f85809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f85810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f85811c;

        private ExampleStackTrace c(LockGraphNode lockGraphNode, Set set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = (ExampleStackTrace) this.f85809a.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry entry : this.f85809a.entrySet()) {
                LockGraphNode lockGraphNode2 = (LockGraphNode) entry.getKey();
                ExampleStackTrace exampleStackTraceC = lockGraphNode2.c(lockGraphNode, set);
                if (exampleStackTraceC != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                    exampleStackTrace2.setStackTrace(((ExampleStackTrace) entry.getValue()).getStackTrace());
                    exampleStackTrace2.initCause(exampleStackTraceC);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        void a(Policy policy, LockGraphNode lockGraphNode) {
            Preconditions.D(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", lockGraphNode.d());
            if (this.f85809a.containsKey(lockGraphNode)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = (PotentialDeadlockException) this.f85810b.get(lockGraphNode);
            if (potentialDeadlockException != null) {
                policy.a(new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.a()));
                return;
            }
            ExampleStackTrace exampleStackTraceC = lockGraphNode.c(this, Sets.k());
            if (exampleStackTraceC == null) {
                this.f85809a.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                return;
            }
            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, exampleStackTraceC);
            this.f85810b.put(lockGraphNode, potentialDeadlockException2);
            policy.a(potentialDeadlockException2);
        }

        void b(Policy policy, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a(policy, (LockGraphNode) it.next());
            }
        }

        String d() {
            return this.f85811c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Policies implements Policy {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void a(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void a(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f85795c.a().log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void a(PotentialDeadlockException potentialDeadlockException) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Policy {
        void a(PotentialDeadlockException potentialDeadlockException);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PotentialDeadlockException extends ExampleStackTrace {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ExampleStackTrace f85816c;

        public ExampleStackTrace a() {
            return this.f85816c;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable cause = this.f85816c; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }

        private PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.f85816c = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.b()) {
            return;
        }
        ArrayList arrayList = (ArrayList) f85796d.get();
        Objects.requireNonNull(arrayList);
        LockGraphNode lockGraphNodeA = cycleDetectingLock.a();
        lockGraphNodeA.b(this.f85797a, arrayList);
        arrayList.add(lockGraphNodeA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(CycleDetectingLock cycleDetectingLock) {
        if (cycleDetectingLock.b()) {
            return;
        }
        ArrayList arrayList = (ArrayList) f85796d.get();
        Objects.requireNonNull(arrayList);
        LockGraphNode lockGraphNodeA = cycleDetectingLock.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNodeA) {
                arrayList.remove(size);
                return;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LockGraphNode f85798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CycleDetectingLockFactory f85799b;

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode a() {
            return this.f85798a;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean b() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            this.f85799b.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            this.f85799b.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            this.f85799b.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j3, TimeUnit timeUnit) {
            this.f85799b.a(this);
            try {
                return super.tryLock(j3, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CycleDetectingReentrantReadWriteLock f85800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CycleDetectingLockFactory f85801b;

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            this.f85801b.a(this.f85800a);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.f85800a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            this.f85801b.a(this.f85800a);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.f85800a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            this.f85801b.a(this.f85800a);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.f85800a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.f85800a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j3, TimeUnit timeUnit) {
            this.f85801b.a(this.f85800a);
            try {
                return super.tryLock(j3, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.f85800a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CycleDetectingReentrantReadWriteLock f85805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CycleDetectingLockFactory f85806b;

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            this.f85806b.a(this.f85805a);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.f85805a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
            this.f85806b.a(this.f85805a);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.f85805a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            this.f85806b.a(this.f85805a);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.f85805a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.f85805a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j3, TimeUnit timeUnit) {
            this.f85806b.a(this.f85805a);
            try {
                return super.tryLock(j3, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.f85805a);
            }
        }
    }
}
