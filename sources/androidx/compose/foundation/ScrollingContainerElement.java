package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
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
final class ScrollingContainerElement extends ModifierNodeElement<ScrollingContainerNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollableState f5150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Orientation f5151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5153d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FlingBehavior f5154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableInteractionSource f5155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BringIntoViewSpec f5156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f5157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OverscrollEffect f5158j;

    public ScrollingContainerElement(ScrollableState scrollableState, Orientation orientation, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, boolean z4, OverscrollEffect overscrollEffect) {
        this.f5150a = scrollableState;
        this.f5151b = orientation;
        this.f5152c = z2;
        this.f5153d = z3;
        this.f5154f = flingBehavior;
        this.f5155g = mutableInteractionSource;
        this.f5156h = bringIntoViewSpec;
        this.f5157i = z4;
        this.f5158j = overscrollEffect;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollingContainerNode create() {
        return new ScrollingContainerNode(this.f5150a, this.f5151b, this.f5152c, this.f5153d, this.f5154f, this.f5155g, this.f5156h, this.f5157i, this.f5158j);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ScrollingContainerNode scrollingContainerNode) {
        scrollingContainerNode.y2(this.f5150a, this.f5151b, this.f5157i, this.f5158j, this.f5152c, this.f5153d, this.f5154f, this.f5155g, this.f5156h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScrollingContainerElement.class != obj.getClass()) {
            return false;
        }
        ScrollingContainerElement scrollingContainerElement = (ScrollingContainerElement) obj;
        return Intrinsics.areEqual(this.f5150a, scrollingContainerElement.f5150a) && this.f5151b == scrollingContainerElement.f5151b && this.f5152c == scrollingContainerElement.f5152c && this.f5153d == scrollingContainerElement.f5153d && Intrinsics.areEqual(this.f5154f, scrollingContainerElement.f5154f) && Intrinsics.areEqual(this.f5155g, scrollingContainerElement.f5155g) && Intrinsics.areEqual(this.f5156h, scrollingContainerElement.f5156h) && this.f5157i == scrollingContainerElement.f5157i && Intrinsics.areEqual(this.f5158j, scrollingContainerElement.f5158j);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f5150a.hashCode() * 31) + this.f5151b.hashCode()) * 31) + Boolean.hashCode(this.f5152c)) * 31) + Boolean.hashCode(this.f5153d)) * 31;
        FlingBehavior flingBehavior = this.f5154f;
        int iHashCode2 = (iHashCode + (flingBehavior != null ? flingBehavior.hashCode() : 0)) * 31;
        MutableInteractionSource mutableInteractionSource = this.f5155g;
        int iHashCode3 = (iHashCode2 + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        BringIntoViewSpec bringIntoViewSpec = this.f5156h;
        int iHashCode4 = (((iHashCode3 + (bringIntoViewSpec != null ? bringIntoViewSpec.hashCode() : 0)) * 31) + Boolean.hashCode(this.f5157i)) * 31;
        OverscrollEffect overscrollEffect = this.f5158j;
        return iHashCode4 + (overscrollEffect != null ? overscrollEffect.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("scrollingContainer");
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f5150a);
        inspectorInfo.b().c("orientation", this.f5151b);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f5152c));
        inspectorInfo.b().c("reverseScrolling", Boolean.valueOf(this.f5153d));
        inspectorInfo.b().c("flingBehavior", this.f5154f);
        inspectorInfo.b().c("interactionSource", this.f5155g);
        inspectorInfo.b().c("bringIntoViewSpec", this.f5156h);
        inspectorInfo.b().c("useLocalOverscrollFactory", Boolean.valueOf(this.f5157i));
        inspectorInfo.b().c("overscrollEffect", this.f5158j);
    }
}
