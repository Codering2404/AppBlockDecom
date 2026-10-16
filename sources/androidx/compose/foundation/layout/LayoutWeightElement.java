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
public final class LayoutWeightElement extends ModifierNodeElement<LayoutWeightNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7001b;

    public LayoutWeightElement(float f3, boolean z2) {
        this.f7000a = f3;
        this.f7001b = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutWeightNode create() {
        return new LayoutWeightNode(this.f7000a, this.f7001b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LayoutWeightNode layoutWeightNode) {
        layoutWeightNode.o2(this.f7000a);
        layoutWeightNode.n2(this.f7001b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.f7000a == layoutWeightElement.f7000a && this.f7001b == layoutWeightElement.f7001b;
    }

    public int hashCode() {
        return (Float.hashCode(this.f7000a) * 31) + Boolean.hashCode(this.f7001b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("weight");
        inspectorInfo.e(Float.valueOf(this.f7000a));
        inspectorInfo.b().c("weight", Float.valueOf(this.f7000a));
        inspectorInfo.b().c("fill", Boolean.valueOf(this.f7001b));
    }
}
