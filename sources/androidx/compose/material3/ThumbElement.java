package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.node.LayoutModifierNodeKt;
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
final class ThumbElement extends ModifierNodeElement<ThumbNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InteractionSource f21130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21131b;

    public ThumbElement(InteractionSource interactionSource, boolean z2) {
        this.f21130a = interactionSource;
        this.f21131b = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ThumbNode create() {
        return new ThumbNode(this.f21130a, this.f21131b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ThumbNode thumbNode) {
        thumbNode.setInteractionSource(this.f21130a);
        if (thumbNode.getChecked() != this.f21131b) {
            LayoutModifierNodeKt.b(thumbNode);
        }
        thumbNode.setChecked(this.f21131b);
        thumbNode.update();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) obj;
        return Intrinsics.areEqual(this.f21130a, thumbElement.f21130a) && this.f21131b == thumbElement.f21131b;
    }

    public int hashCode() {
        return (this.f21130a.hashCode() * 31) + Boolean.hashCode(this.f21131b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("switchThumb");
        inspectorInfo.b().c("interactionSource", this.f21130a);
        inspectorInfo.b().c("checked", Boolean.valueOf(this.f21131b));
    }

    public String toString() {
        return "ThumbElement(interactionSource=" + this.f21130a + ", checked=" + this.f21131b + ')';
    }
}
