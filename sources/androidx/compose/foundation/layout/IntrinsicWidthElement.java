package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class IntrinsicWidthElement extends ModifierNodeElement<IntrinsicWidthNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntrinsicSize f6991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f6993c;

    public IntrinsicWidthElement(IntrinsicSize intrinsicSize, boolean z2, Function1 function1) {
        this.f6991a = intrinsicSize;
        this.f6992b = z2;
        this.f6993c = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public IntrinsicWidthNode create() {
        return new IntrinsicWidthNode(this.f6991a, this.f6992b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(IntrinsicWidthNode intrinsicWidthNode) {
        intrinsicWidthNode.p2(this.f6991a);
        intrinsicWidthNode.o2(this.f6992b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        IntrinsicWidthElement intrinsicWidthElement = obj instanceof IntrinsicWidthElement ? (IntrinsicWidthElement) obj : null;
        return intrinsicWidthElement != null && this.f6991a == intrinsicWidthElement.f6991a && this.f6992b == intrinsicWidthElement.f6992b;
    }

    public int hashCode() {
        return (this.f6991a.hashCode() * 31) + Boolean.hashCode(this.f6992b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6993c.invoke(inspectorInfo);
    }
}
