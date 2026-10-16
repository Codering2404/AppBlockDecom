package androidx.paging;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AccessorStateHolder<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReentrantLock f49528a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableStateFlow f49529b = StateFlowKt.a(LoadStates.f49897f.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AccessorState f49530c = new AccessorState();

    public final StateFlow a() {
        return this.f49529b;
    }

    public final Object b(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReentrantLock reentrantLock = this.f49528a;
        try {
            reentrantLock.lock();
            Object objInvoke = block.invoke(this.f49530c);
            this.f49529b.setValue(this.f49530c.e());
            return objInvoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
