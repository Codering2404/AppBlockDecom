package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WorkQueue {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final ReentrantLock workLock;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: assert, reason: not valid java name */
        public final void m369assert(boolean z2) {
            if (!z2) {
                throw new FacebookException("Validation failed");
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class WorkNode implements WorkItem {
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = workQueue;
            this.callback = callback;
        }

        public final WorkNode addToList(WorkNode workNode, boolean z2) {
            Companion companion = WorkQueue.Companion;
            companion.m369assert(this.next == null);
            companion.m369assert(this.prev == null);
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode2 = workNode.prev;
                this.prev = workNode2;
                if (workNode2 != null) {
                    workNode2.next = this;
                }
                WorkNode workNode3 = this.next;
                if (workNode3 != null) {
                    workNode3.prev = workNode2 != null ? workNode2.next : null;
                }
            }
            return z2 ? this : workNode;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (isRunning()) {
                    Unit unit = Unit.f139807a;
                    reentrantLock.unlock();
                    return false;
                }
                workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final Runnable getCallback() {
            return this.callback;
        }

        public final WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                Unit unit = Unit.f139807a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            Companion companion = WorkQueue.Companion;
            companion.m369assert(this.next != null);
            companion.m369assert(this.prev != null);
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            if (workNode2 != null) {
                workNode2.prev = this.prev;
            }
            WorkNode workNode3 = this.prev;
            if (workNode3 != null) {
                workNode3.next = workNode2;
            }
            this.prev = null;
            this.next = null;
            return workNode;
        }

        public void setRunning(boolean z2) {
            this.isRunning = z2;
        }

        public final void verify(boolean z2) {
            WorkNode workNode;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            companion.m369assert(workNode == this);
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            companion.m369assert(workNode2 == this);
            companion.m369assert(isRunning() == z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQueue() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return workQueue.addActiveWorkItem(runnable, z2);
    }

    private final void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.w
            @Override // java.lang.Runnable
            public final void run() {
                WorkQueue.execute$lambda$2(workNode, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$2(WorkNode node, WorkQueue this$0) {
        Intrinsics.checkNotNullParameter(node, "$node");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            node.getCallback().run();
        } finally {
            this$0.finishItemAndStartNew(node);
        }
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void startItem() {
        finishItemAndStartNew(null);
    }

    public final WorkItem addActiveWorkItem(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return addActiveWorkItem$default(this, callback, false, 2, null);
    }

    public final void validate() {
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            WorkNode next = this.runningJobs;
            int i3 = 0;
            if (next != null) {
                while (next != null) {
                    next.verify(true);
                    i3++;
                    next = next.getNext();
                    if (next == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.");
            }
            Companion.m369assert(this.runningCount == i3);
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQueue(int i3) {
        this(i3, null, 2, 0 == true ? 1 : 0);
    }

    public final WorkItem addActiveWorkItem(Runnable callback, boolean z2) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        WorkNode workNode = new WorkNode(this, callback);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z2);
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public WorkQueue(int i3, Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.maxConcurrent = i3;
        this.executor = executor;
        this.workLock = new ReentrantLock();
    }

    public /* synthetic */ WorkQueue(int i3, Executor executor, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 8 : i3, (i4 & 2) != 0 ? FacebookSdk.getExecutor() : executor);
    }
}
