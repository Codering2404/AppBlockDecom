package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

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
public abstract class EventLoop extends CoroutineDispatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f140942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayDeque f140944d;

    private final long O0(boolean z2) {
        return z2 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void h1(EventLoop eventLoop, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        eventLoop.a1(z2);
    }

    public static /* synthetic */ void z0(EventLoop eventLoop, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        eventLoop.w0(z2);
    }

    public final void R0(DispatchedTask dispatchedTask) {
        ArrayDeque arrayDeque = this.f140944d;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.f140944d = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    protected long X0() {
        ArrayDeque arrayDeque = this.f140944d;
        return (arrayDeque == null || arrayDeque.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void a1(boolean z2) {
        this.f140942b += O0(z2);
        if (z2) {
            return;
        }
        this.f140943c = true;
    }

    public final boolean i1() {
        return this.f140942b >= O0(true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher j0(int i3, String str) {
        LimitedDispatcherKt.a(i3);
        return LimitedDispatcherKt.b(this, str);
    }

    public final boolean o1() {
        ArrayDeque arrayDeque = this.f140944d;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    public long t1() {
        return !u1() ? Long.MAX_VALUE : 0L;
    }

    public final boolean u1() {
        DispatchedTask dispatchedTask;
        ArrayDeque arrayDeque = this.f140944d;
        if (arrayDeque == null || (dispatchedTask = (DispatchedTask) arrayDeque.removeFirstOrNull()) == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public final void w0(boolean z2) {
        long jO0 = this.f140942b - O0(z2);
        this.f140942b = jO0;
        if (jO0 <= 0 && this.f140943c) {
            shutdown();
        }
    }

    public boolean w1() {
        return false;
    }

    public void shutdown() {
    }
}
