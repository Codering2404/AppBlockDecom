package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

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
public final class CancellableKt {
    private static final void a(Continuation continuation, Throwable th) throws Throwable {
        Result.Companion companion = Result.f139772b;
        continuation.resumeWith(Result.b(ResultKt.a(th)));
        throw th;
    }

    public static final void b(Continuation continuation, Continuation continuation2) throws Throwable {
        try {
            Continuation continuationC = IntrinsicsKt.c(continuation);
            Result.Companion companion = Result.f139772b;
            DispatchedContinuationKt.b(continuationC, Result.b(Unit.f139807a));
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final void c(Function2 function2, Object obj, Continuation continuation) {
        try {
            Continuation continuationC = IntrinsicsKt.c(IntrinsicsKt.a(function2, obj, continuation));
            Result.Companion companion = Result.f139772b;
            DispatchedContinuationKt.b(continuationC, Result.b(Unit.f139807a));
        } catch (Throwable th) {
            a(continuation, th);
        }
    }
}
