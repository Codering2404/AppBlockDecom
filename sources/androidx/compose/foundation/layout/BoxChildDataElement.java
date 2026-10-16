package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class BoxChildDataElement extends ModifierNodeElement<BoxChildDataNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Alignment f6614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f6616c;

    public BoxChildDataElement(Alignment alignment, boolean z2, Function1 function1) {
        this.f6614a = alignment;
        this.f6615b = z2;
        this.f6616c = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BoxChildDataNode create() {
        return new BoxChildDataNode(this.f6614a, this.f6615b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(BoxChildDataNode boxChildDataNode) {
        boxChildDataNode.p2(this.f6614a);
        boxChildDataNode.q2(this.f6615b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && Intrinsics.areEqual(this.f6614a, boxChildDataElement.f6614a) && this.f6615b == boxChildDataElement.f6615b;
    }

    public int hashCode() {
        return (this.f6614a.hashCode() * 31) + Boolean.hashCode(this.f6615b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6616c.invoke(inspectorInfo);
    }
}
