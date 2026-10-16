package androidx.window.embedding;

import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SafeActivityEmbeddingComponentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f54224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f54225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SafeWindowExtensionsProvider f54226c;

    /* JADX INFO: Access modifiers changed from: private */
    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54224a.loadClass("androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(ACTIVIT…MBEDDING_COMPONENT_CLASS)");
        return clsLoadClass;
    }
}
