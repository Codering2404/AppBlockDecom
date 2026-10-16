package kotlinx.coroutines.internal;

import com.facebook.internal.NativeProtocol;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.Segment;

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
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> implements NotCompleted {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142481d = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f142482c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public Segment(long j3, Segment segment, int i3) {
        super(segment);
        this.f142482c = j3;
        this.cleanedAndPointers$volatile = i3 << 16;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean k() {
        return f142481d.get(this) == r() && !l();
    }

    public final boolean p() {
        return f142481d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i3, Throwable th, CoroutineContext coroutineContext);

    public final void t() {
        if (f142481d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f142481d;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i3));
        return true;
    }
}
