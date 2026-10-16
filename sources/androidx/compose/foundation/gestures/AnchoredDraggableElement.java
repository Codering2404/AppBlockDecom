package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
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
final class AnchoredDraggableElement<T> extends ModifierNodeElement<AnchoredDraggableNode<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f5376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Orientation f5377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Boolean f5379d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableInteractionSource f5380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Boolean f5381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OverscrollEffect f5382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FlingBehavior f5383i;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AnchoredDraggableNode create() {
        return new AnchoredDraggableNode(this.f5376a, this.f5377b, this.f5378c, this.f5379d, this.f5380f, this.f5382h, this.f5381g, this.f5383i);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(AnchoredDraggableNode anchoredDraggableNode) {
        anchoredDraggableNode.h3(this.f5376a, this.f5377b, this.f5378c, this.f5379d, this.f5380f, this.f5382h, this.f5381g, this.f5383i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnchoredDraggableElement)) {
            return false;
        }
        AnchoredDraggableElement anchoredDraggableElement = (AnchoredDraggableElement) obj;
        return Intrinsics.areEqual(this.f5376a, anchoredDraggableElement.f5376a) && this.f5377b == anchoredDraggableElement.f5377b && this.f5378c == anchoredDraggableElement.f5378c && Intrinsics.areEqual(this.f5379d, anchoredDraggableElement.f5379d) && Intrinsics.areEqual(this.f5380f, anchoredDraggableElement.f5380f) && Intrinsics.areEqual(this.f5381g, anchoredDraggableElement.f5381g) && Intrinsics.areEqual(this.f5382h, anchoredDraggableElement.f5382h) && Intrinsics.areEqual(this.f5383i, anchoredDraggableElement.f5383i);
    }

    public int hashCode() {
        int iHashCode = ((((this.f5376a.hashCode() * 31) + this.f5377b.hashCode()) * 31) + Boolean.hashCode(this.f5378c)) * 31;
        Boolean bool = this.f5379d;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        MutableInteractionSource mutableInteractionSource = this.f5380f;
        int iHashCode3 = (iHashCode2 + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        Boolean bool2 = this.f5381g;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        OverscrollEffect overscrollEffect = this.f5382h;
        int iHashCode5 = (iHashCode4 + (overscrollEffect != null ? overscrollEffect.hashCode() : 0)) * 31;
        FlingBehavior flingBehavior = this.f5383i;
        return iHashCode5 + (flingBehavior != null ? flingBehavior.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("anchoredDraggable");
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f5376a);
        inspectorInfo.b().c("orientation", this.f5377b);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f5378c));
        inspectorInfo.b().c("reverseDirection", this.f5379d);
        inspectorInfo.b().c("interactionSource", this.f5380f);
        inspectorInfo.b().c("startDragImmediately", this.f5381g);
        inspectorInfo.b().c("overscrollEffect", this.f5382h);
        inspectorInfo.b().c("flingBehavior", this.f5383i);
    }
}
