package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class SelectOldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CancellableContinuation cancellableContinuation, Object obj) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.f140909a);
        if (coroutineDispatcher != null) {
            cancellableContinuation.I(coroutineDispatcher, obj);
        } else {
            cancellableContinuation.resumeWith(Result.b(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CancellableContinuation cancellableContinuation, Throwable th) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.f140909a);
        if (coroutineDispatcher != null) {
            cancellableContinuation.u(coroutineDispatcher, th);
        } else {
            Result.Companion companion = Result.f139772b;
            cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
        }
    }
}
