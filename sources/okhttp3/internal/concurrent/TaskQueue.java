package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class TaskQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskRunner f144386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f144387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f144388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Task f144389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f144390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f144391f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class AwaitIdleTask extends Task {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final CountDownLatch f144392e;

        public AwaitIdleTask() {
            super(Intrinsics.stringPlus(Util.f144282i, " awaitIdle"), false);
            this.f144392e = new CountDownLatch(1);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long f() {
            this.f144392e.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f144386a = taskRunner;
        this.f144387b = name;
        this.f144390e = new ArrayList();
    }

    public static /* synthetic */ void j(TaskQueue taskQueue, Task task, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        taskQueue.i(task, j3);
    }

    public final void a() {
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f144386a) {
            try {
                if (b()) {
                    h().h(this);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        Task task = this.f144389d;
        if (task != null) {
            Intrinsics.checkNotNull(task);
            if (task.a()) {
                this.f144391f = true;
            }
        }
        int size = this.f144390e.size() - 1;
        boolean z2 = false;
        if (size < 0) {
            return false;
        }
        while (true) {
            int i3 = size - 1;
            if (((Task) this.f144390e.get(size)).a()) {
                Task task2 = (Task) this.f144390e.get(size);
                if (TaskRunner.f144397h.a().isLoggable(Level.FINE)) {
                    TaskLoggerKt.c(task2, this, "canceled");
                }
                this.f144390e.remove(size);
                z2 = true;
            }
            if (i3 < 0) {
                return z2;
            }
            size = i3;
        }
    }

    public final Task c() {
        return this.f144389d;
    }

    public final boolean d() {
        return this.f144391f;
    }

    public final List e() {
        return this.f144390e;
    }

    public final String f() {
        return this.f144387b;
    }

    public final boolean g() {
        return this.f144388c;
    }

    public final TaskRunner h() {
        return this.f144386a;
    }

    public final void i(Task task, long j3) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.f144386a) {
            if (!g()) {
                if (k(task, j3, false)) {
                    h().h(this);
                }
                Unit unit = Unit.f139807a;
            } else if (task.a()) {
                if (TaskRunner.f144397h.a().isLoggable(Level.FINE)) {
                    TaskLoggerKt.c(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.f144397h.a().isLoggable(Level.FINE)) {
                    TaskLoggerKt.c(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(Task task, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(task, "task");
        task.e(this);
        long jB = this.f144386a.g().b();
        long j4 = jB + j3;
        int iIndexOf = this.f144390e.indexOf(task);
        if (iIndexOf != -1) {
            if (task.c() <= j4) {
                if (TaskRunner.f144397h.a().isLoggable(Level.FINE)) {
                    TaskLoggerKt.c(task, this, "already scheduled");
                }
                return false;
            }
            this.f144390e.remove(iIndexOf);
        }
        task.g(j4);
        if (TaskRunner.f144397h.a().isLoggable(Level.FINE)) {
            TaskLoggerKt.c(task, this, z2 ? Intrinsics.stringPlus("run again after ", TaskLoggerKt.b(j4 - jB)) : Intrinsics.stringPlus("scheduled after ", TaskLoggerKt.b(j4 - jB)));
        }
        Iterator it = this.f144390e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((Task) it.next()).c() - jB > j3) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f144390e.size();
        }
        this.f144390e.add(size, task);
        return size == 0;
    }

    public final void l(Task task) {
        this.f144389d = task;
    }

    public final void m(boolean z2) {
        this.f144391f = z2;
    }

    public final void n(boolean z2) {
        this.f144388c = z2;
    }

    public final void o() {
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f144386a) {
            try {
                n(true);
                if (b()) {
                    h().h(this);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.f144387b;
    }
}
