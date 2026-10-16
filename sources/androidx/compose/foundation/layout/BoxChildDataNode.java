package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
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
final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Alignment f6617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6618b;

    public BoxChildDataNode(Alignment alignment, boolean z2) {
        this.f6617a = alignment;
        this.f6618b = z2;
    }

    public final Alignment m2() {
        return this.f6617a;
    }

    public final boolean n2() {
        return this.f6618b;
    }

    public final void p2(Alignment alignment) {
        this.f6617a = alignment;
    }

    public final void q2(boolean z2) {
        this.f6618b = z2;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    /* JADX INFO: renamed from: o2, reason: merged with bridge method [inline-methods] */
    public BoxChildDataNode H(Density density, Object obj) {
        return this;
    }
}
