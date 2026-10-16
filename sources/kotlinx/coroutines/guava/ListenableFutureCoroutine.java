package kotlinx.coroutines.guava;

import kotlin.Metadata;
import kotlinx.coroutines.AbstractCoroutine;

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
final class ListenableFutureCoroutine<T> extends AbstractCoroutine<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JobListenableFuture f142419d;

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void c1(Throwable th, boolean z2) {
        this.f142419d.b(th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void d1(Object obj) {
        this.f142419d.a(obj);
    }
}
