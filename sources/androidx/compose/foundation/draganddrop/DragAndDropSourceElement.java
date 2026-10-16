package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
final class DragAndDropSourceElement extends ModifierNodeElement<DragAndDropSourceNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f5330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f5331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f5332c;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DragAndDropSourceNode create() {
        return new DragAndDropSourceNode(this.f5330a, this.f5331b, this.f5332c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(DragAndDropSourceNode dragAndDropSourceNode) {
        dragAndDropSourceNode.y2(this.f5330a);
        dragAndDropSourceNode.x2(this.f5331b);
        dragAndDropSourceNode.z2(this.f5332c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DragAndDropSourceElement)) {
            return false;
        }
        DragAndDropSourceElement dragAndDropSourceElement = (DragAndDropSourceElement) obj;
        return Intrinsics.areEqual(this.f5330a, dragAndDropSourceElement.f5330a) && Intrinsics.areEqual(this.f5331b, dragAndDropSourceElement.f5331b) && Intrinsics.areEqual(this.f5332c, dragAndDropSourceElement.f5332c);
    }

    public int hashCode() {
        return (((this.f5330a.hashCode() * 31) + this.f5331b.hashCode()) * 31) + this.f5332c.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("dragSource");
        inspectorInfo.b().c("drawDragDecoration", this.f5330a);
        inspectorInfo.b().c("detectDragStart", this.f5331b);
        inspectorInfo.b().c("transferData", this.f5332c);
    }

    public String toString() {
        return "DragAndDropSourceElement(drawDragDecoration=" + this.f5330a + ", detectDragStart=" + this.f5331b + ", transferData=" + this.f5332c + ')';
    }
}
