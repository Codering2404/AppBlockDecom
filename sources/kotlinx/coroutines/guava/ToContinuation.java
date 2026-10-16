package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

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
final class ToContinuation<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListenableFuture f142423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CancellableContinuation f142424b;

    public ToContinuation(ListenableFuture listenableFuture, CancellableContinuation cancellableContinuation) {
        this.f142423a = listenableFuture;
        this.f142424b = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f142423a.isCancelled()) {
            CancellableContinuation.DefaultImpls.a(this.f142424b, null, 1, null);
            return;
        }
        try {
            CancellableContinuation cancellableContinuation = this.f142424b;
            Result.Companion companion = Result.f139772b;
            cancellableContinuation.resumeWith(Result.b(Uninterruptibles.a(this.f142423a)));
        } catch (ExecutionException e3) {
            CancellableContinuation cancellableContinuation2 = this.f142424b;
            Result.Companion companion2 = Result.f139772b;
            cancellableContinuation2.resumeWith(Result.b(ResultKt.a(ListenableFutureKt.c(e3))));
        }
    }
}
