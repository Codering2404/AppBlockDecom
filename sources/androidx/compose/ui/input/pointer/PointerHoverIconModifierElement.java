package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
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
public final class PointerHoverIconModifierElement extends ModifierNodeElement<PointerHoverIconModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f26844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26845b;

    public PointerHoverIconModifierElement(PointerIcon pointerIcon, boolean z2) {
        this.f26844a = pointerIcon;
        this.f26845b = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointerHoverIconModifierNode create() {
        return new PointerHoverIconModifierNode(this.f26844a, this.f26845b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
        pointerHoverIconModifierNode.A2(this.f26844a);
        pointerHoverIconModifierNode.B2(this.f26845b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerHoverIconModifierElement)) {
            return false;
        }
        PointerHoverIconModifierElement pointerHoverIconModifierElement = (PointerHoverIconModifierElement) obj;
        return Intrinsics.areEqual(this.f26844a, pointerHoverIconModifierElement.f26844a) && this.f26845b == pointerHoverIconModifierElement.f26845b;
    }

    public int hashCode() {
        return (this.f26844a.hashCode() * 31) + Boolean.hashCode(this.f26845b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("pointerHoverIcon");
        inspectorInfo.b().c("icon", this.f26844a);
        inspectorInfo.b().c("overrideDescendants", Boolean.valueOf(this.f26845b));
    }

    public String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.f26844a + ", overrideDescendants=" + this.f26845b + ')';
    }
}
