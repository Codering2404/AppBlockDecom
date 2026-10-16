package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

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
public final class CancellableContinuationKt {
    public static final void a(CancellableContinuation cancellableContinuation, DisposableHandle disposableHandle) {
        c(cancellableContinuation, new DisposeOnCancel(disposableHandle));
    }

    public static final CancellableContinuationImpl b(Continuation continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(continuation, 1);
        }
        CancellableContinuationImpl cancellableContinuationImplI = ((DispatchedContinuation) continuation).i();
        if (cancellableContinuationImplI != null) {
            if (!cancellableContinuationImplI.N()) {
                cancellableContinuationImplI = null;
            }
            if (cancellableContinuationImplI != null) {
                return cancellableContinuationImplI;
            }
        }
        return new CancellableContinuationImpl(continuation, 2);
    }

    public static final void c(CancellableContinuation cancellableContinuation, CancelHandler cancelHandler) {
        if (!(cancellableContinuation instanceof CancellableContinuationImpl)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((CancellableContinuationImpl) cancellableContinuation).F(cancelHandler);
    }
}
