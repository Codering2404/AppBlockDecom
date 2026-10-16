package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DiskCacheWriteLocker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66585a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WriteLockPool f66586b = new WriteLockPool();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f66587a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f66588b;

        WriteLock() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WriteLockPool {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f66589a = new ArrayDeque();

        WriteLockPool() {
        }

        WriteLock a() {
            WriteLock writeLock;
            synchronized (this.f66589a) {
                writeLock = (WriteLock) this.f66589a.poll();
            }
            return writeLock == null ? new WriteLock() : writeLock;
        }

        void b(WriteLock writeLock) {
            synchronized (this.f66589a) {
                try {
                    if (this.f66589a.size() < 10) {
                        this.f66589a.offer(writeLock);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    DiskCacheWriteLocker() {
    }

    void a(String str) {
        WriteLock writeLockA;
        synchronized (this) {
            try {
                writeLockA = (WriteLock) this.f66585a.get(str);
                if (writeLockA == null) {
                    writeLockA = this.f66586b.a();
                    this.f66585a.put(str, writeLockA);
                }
                writeLockA.f66588b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLockA.f66587a.lock();
    }

    void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) Preconditions.e((WriteLock) this.f66585a.get(str));
                int i3 = writeLock.f66588b;
                if (i3 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.f66588b);
                }
                int i4 = i3 - 1;
                writeLock.f66588b = i4;
                if (i4 == 0) {
                    WriteLock writeLock2 = (WriteLock) this.f66585a.remove(str);
                    if (!writeLock2.equals(writeLock)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLock2 + ", safeKey: " + str);
                    }
                    this.f66586b.b(writeLock2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.f66587a.unlock();
    }
}
