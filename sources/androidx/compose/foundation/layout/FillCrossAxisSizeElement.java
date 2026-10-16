package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
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
public final class FillCrossAxisSizeElement extends ModifierNodeElement<FillCrossAxisSizeNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f6764a;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FillCrossAxisSizeNode create() {
        return new FillCrossAxisSizeNode(this.f6764a);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(FillCrossAxisSizeNode fillCrossAxisSizeNode) {
        fillCrossAxisSizeNode.o2(this.f6764a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        FillCrossAxisSizeNode fillCrossAxisSizeNode = obj instanceof FillCrossAxisSizeNode ? (FillCrossAxisSizeNode) obj : null;
        return fillCrossAxisSizeNode != null && this.f6764a == fillCrossAxisSizeNode.m2();
    }

    public int hashCode() {
        return Float.hashCode(this.f6764a) * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("fraction");
        inspectorInfo.e(Float.valueOf(this.f6764a));
        inspectorInfo.b().c("fraction", Float.valueOf(this.f6764a));
    }
}
