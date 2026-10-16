package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
final class EmbeddingBackend$Companion$reset$1 extends Lambda implements Function1<EmbeddingBackend, EmbeddingBackend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmbeddingBackend$Companion$reset$1 f54201a = new EmbeddingBackend$Companion$reset$1();

    EmbeddingBackend$Companion$reset$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final EmbeddingBackend invoke(EmbeddingBackend it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }
}
