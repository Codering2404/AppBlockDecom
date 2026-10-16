package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

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
final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CompletableFuture f142411d;

    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        f1(obj, th);
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void c1(Throwable th, boolean z2) {
        this.f142411d.completeExceptionally(th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void d1(Object obj) {
        this.f142411d.complete(obj);
    }

    public void f1(Object obj, Throwable th) {
        Job.DefaultImpls.b(this, null, 1, null);
    }
}
