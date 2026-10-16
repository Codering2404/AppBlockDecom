package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.d;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class WorkQueue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142559b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142560c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142561d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142562e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray f142563a = new AtomicReferenceArray(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    private final Task b(Task task) {
        if (e() == 127) {
            return task;
        }
        if (task.f142550b) {
            f142562e.incrementAndGet(this);
        }
        int i3 = f142560c.get(this) & 127;
        while (this.f142563a.get(i3) != null) {
            Thread.yield();
        }
        this.f142563a.lazySet(i3, task);
        f142560c.incrementAndGet(this);
        return null;
    }

    private final void c(Task task) {
        if (task == null || !task.f142550b) {
            return;
        }
        f142562e.decrementAndGet(this);
    }

    private final int e() {
        return f142560c.get(this) - f142561d.get(this);
    }

    private final Task m() {
        Task task;
        while (true) {
            int i3 = f142561d.get(this);
            if (i3 - f142560c.get(this) == 0) {
                return null;
            }
            int i4 = i3 & 127;
            if (f142561d.compareAndSet(this, i3, i3 + 1) && (task = (Task) this.f142563a.getAndSet(i4, null)) != null) {
                c(task);
                return task;
            }
        }
    }

    private final boolean n(GlobalQueue globalQueue) {
        Task taskM = m();
        if (taskM == null) {
            return false;
        }
        globalQueue.a(taskM);
        return true;
    }

    private final Task o(boolean z2) {
        Task task;
        do {
            task = (Task) f142559b.get(this);
            if (task == null || task.f142550b != z2) {
                int i3 = f142561d.get(this);
                int i4 = f142560c.get(this);
                while (i3 != i4) {
                    if (z2 && f142562e.get(this) == 0) {
                        return null;
                    }
                    i4--;
                    Task taskQ = q(i4, z2);
                    if (taskQ != null) {
                        return taskQ;
                    }
                }
                return null;
            }
        } while (!a.a(f142559b, this, task, null));
        return task;
    }

    private final Task p(int i3) {
        int i4 = f142561d.get(this);
        int i5 = f142560c.get(this);
        boolean z2 = i3 == 1;
        while (i4 != i5) {
            if (z2 && f142562e.get(this) == 0) {
                return null;
            }
            int i6 = i4 + 1;
            Task taskQ = q(i4, z2);
            if (taskQ != null) {
                return taskQ;
            }
            i4 = i6;
        }
        return null;
    }

    private final Task q(int i3, boolean z2) {
        int i4 = i3 & 127;
        Task task = (Task) this.f142563a.get(i4);
        if (task == null || task.f142550b != z2 || !d.a(this.f142563a, i4, task, null)) {
            return null;
        }
        if (z2) {
            f142562e.decrementAndGet(this);
        }
        return task;
    }

    private final long s(int i3, Ref.ObjectRef objectRef) {
        Task task;
        do {
            task = (Task) f142559b.get(this);
            if (task == null) {
                return -2L;
            }
            if (((task.f142550b ? 1 : 2) & i3) == 0) {
                return -2L;
            }
            long jA = TasksKt.f142557f.a() - task.f142549a;
            long j3 = TasksKt.f142553b;
            if (jA < j3) {
                return j3 - jA;
            }
        } while (!a.a(f142559b, this, task, null));
        objectRef.f140144a = task;
        return -1L;
    }

    public final Task a(Task task, boolean z2) {
        if (z2) {
            return b(task);
        }
        Task task2 = (Task) f142559b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final int i() {
        return f142559b.get(this) != null ? e() + 1 : e();
    }

    public final void j(GlobalQueue globalQueue) {
        Task task = (Task) f142559b.getAndSet(this, null);
        if (task != null) {
            globalQueue.a(task);
        }
        while (n(globalQueue)) {
        }
    }

    public final Task k() {
        Task task = (Task) f142559b.getAndSet(this, null);
        return task == null ? m() : task;
    }

    public final Task l() {
        return o(true);
    }

    public final long r(int i3, Ref.ObjectRef objectRef) {
        Task taskM = i3 == 3 ? m() : p(i3);
        if (taskM == null) {
            return s(i3, objectRef);
        }
        objectRef.f140144a = taskM;
        return -1L;
    }
}
