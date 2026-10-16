package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    public void a(Object obj, Throwable th) {
        Throwable cause;
        Continuation<? super T> continuation = this.cont;
        if (continuation == null) {
            return;
        }
        if (th == null) {
            continuation.resumeWith(Result.b(obj));
            return;
        }
        CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th = cause;
        }
        Result.Companion companion = Result.f139772b;
        continuation.resumeWith(Result.b(ResultKt.a(th)));
    }

    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        a(obj, th);
        return Unit.f139807a;
    }
}
