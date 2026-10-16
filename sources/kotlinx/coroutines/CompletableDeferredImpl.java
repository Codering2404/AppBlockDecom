package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;

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
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T> {
    public CompletableDeferredImpl(Job job) {
        super(true);
        v0(job);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean J(Object obj) {
        return B0(obj);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean a(Throwable th) {
        return B0(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation continuation) throws Throwable {
        Object objT = T(continuation);
        IntrinsicsKt.f();
        return objT;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return i0();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1 getOnAwait() {
        SelectClause1 selectClause1M0 = m0();
        Intrinsics.checkNotNull(selectClause1M0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return selectClause1M0;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean n0() {
        return true;
    }
}
