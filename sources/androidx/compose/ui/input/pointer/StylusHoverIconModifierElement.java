package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.DpTouchBoundsExpansion;
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
public final class StylusHoverIconModifierElement extends ModifierNodeElement<StylusHoverIconModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f26931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DpTouchBoundsExpansion f26933c;

    public StylusHoverIconModifierElement(PointerIcon pointerIcon, boolean z2, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.f26931a = pointerIcon;
        this.f26932b = z2;
        this.f26933c = dpTouchBoundsExpansion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public StylusHoverIconModifierNode create() {
        return new StylusHoverIconModifierNode(this.f26931a, this.f26932b, this.f26933c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(StylusHoverIconModifierNode stylusHoverIconModifierNode) {
        stylusHoverIconModifierNode.A2(this.f26931a);
        stylusHoverIconModifierNode.B2(this.f26932b);
        stylusHoverIconModifierNode.z2(this.f26933c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) obj;
        return Intrinsics.areEqual(this.f26931a, stylusHoverIconModifierElement.f26931a) && this.f26932b == stylusHoverIconModifierElement.f26932b && Intrinsics.areEqual(this.f26933c, stylusHoverIconModifierElement.f26933c);
    }

    public int hashCode() {
        int iHashCode = ((this.f26931a.hashCode() * 31) + Boolean.hashCode(this.f26932b)) * 31;
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.f26933c;
        return iHashCode + (dpTouchBoundsExpansion == null ? 0 : dpTouchBoundsExpansion.hashCode());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("stylusHoverIcon");
        inspectorInfo.b().c("icon", this.f26931a);
        inspectorInfo.b().c("overrideDescendants", Boolean.valueOf(this.f26932b));
        inspectorInfo.b().c("touchBoundsExpansion", this.f26933c);
    }

    public String toString() {
        return "StylusHoverIconModifierElement(icon=" + this.f26931a + ", overrideDescendants=" + this.f26932b + ", touchBoundsExpansion=" + this.f26933c + ')';
    }
}
