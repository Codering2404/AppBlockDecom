package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.FutureCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

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
public final class ListenableFutureKt$asDeferred$4 implements FutureCallback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CompletableDeferred f142420a;

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
        Object objB;
        CompletableDeferred completableDeferred = this.f142420a;
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(Boolean.valueOf(completableDeferred.a(th)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.f139889a, thE);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(Object obj) {
        Object objB;
        CompletableDeferred completableDeferred = this.f142420a;
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(Boolean.valueOf(completableDeferred.J(obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.f139889a, thE);
        }
    }
}
