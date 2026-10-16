package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

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
final class ThreadState extends JobNode {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f141013h = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state$volatile");
    private volatile /* synthetic */ int _state$volatile;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Thread f141014f = Thread.currentThread();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DisposableHandle f141015g;

    private final Void z(int i3) {
        throw new IllegalStateException(("Illegal state " + i3).toString());
    }

    public final void A(Job job) {
        int i3;
        this.f141015g = JobKt__JobKt.o(job, false, this, 1, null);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f141013h;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 == 2 || i3 == 3) {
                    return;
                }
                z(i3);
                throw new KotlinNothingValueException();
            }
        } while (!f141013h.compareAndSet(this, i3, 0));
    }

    @Override // kotlinx.coroutines.JobNode
    public boolean u() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public void v(Throwable th) {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f141013h;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    return;
                }
                z(i3);
                throw new KotlinNothingValueException();
            }
        } while (!f141013h.compareAndSet(this, i3, 2));
        this.f141014f.interrupt();
        f141013h.set(this, 3);
    }

    public final void x() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f141013h;
        while (true) {
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        z(i3);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f141013h.compareAndSet(this, i3, 1)) {
                DisposableHandle disposableHandle = this.f141015g;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }
}
