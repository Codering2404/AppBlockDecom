package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;

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
final class TraversablePrefetchStateNode extends Modifier.Node implements TraversableNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LazyLayoutPrefetchState f8293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8294b = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";

    public TraversablePrefetchStateNode(LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        this.f8293a = lazyLayoutPrefetchState;
    }

    public final LazyLayoutPrefetchState m2() {
        return this.f8293a;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    /* JADX INFO: renamed from: n2, reason: merged with bridge method [inline-methods] */
    public String U() {
        return this.f8294b;
    }

    public final void o2(LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        this.f8293a = lazyLayoutPrefetchState;
    }
}
