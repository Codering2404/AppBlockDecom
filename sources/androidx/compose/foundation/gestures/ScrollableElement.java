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
final class ScrollableElement extends ModifierNodeElement<ScrollableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollableState f6074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Orientation f6075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OverscrollEffect f6076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6077d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f6078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FlingBehavior f6079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableInteractionSource f6080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BringIntoViewSpec f6081i;

    public ScrollableElement(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z2, boolean z3, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        this.f6074a = scrollableState;
        this.f6075b = orientation;
        this.f6076c = overscrollEffect;
        this.f6077d = z2;
        this.f6078f = z3;
        this.f6079g = flingBehavior;
        this.f6080h = mutableInteractionSource;
        this.f6081i = bringIntoViewSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollableNode create() {
        return new ScrollableNode(this.f6074a, this.f6076c, this.f6079g, this.f6075b, this.f6077d, this.f6078f, this.f6080h, this.f6081i);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ScrollableNode scrollableNode) {
        scrollableNode.W2(this.f6074a, this.f6075b, this.f6076c, this.f6077d, this.f6078f, this.f6079g, this.f6080h, this.f6081i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return Intrinsics.areEqual(this.f6074a, scrollableElement.f6074a) && this.f6075b == scrollableElement.f6075b && Intrinsics.areEqual(this.f6076c, scrollableElement.f6076c) && this.f6077d == scrollableElement.f6077d && this.f6078f == scrollableElement.f6078f && Intrinsics.areEqual(this.f6079g, scrollableElement.f6079g) && Intrinsics.areEqual(this.f6080h, scrollableElement.f6080h) && Intrinsics.areEqual(this.f6081i, scrollableElement.f6081i);
    }

    public int hashCode() {
        int iHashCode = ((this.f6074a.hashCode() * 31) + this.f6075b.hashCode()) * 31;
        OverscrollEffect overscrollEffect = this.f6076c;
        int iHashCode2 = (((((iHashCode + (overscrollEffect != null ? overscrollEffect.hashCode() : 0)) * 31) + Boolean.hashCode(this.f6077d)) * 31) + Boolean.hashCode(this.f6078f)) * 31;
        FlingBehavior flingBehavior = this.f6079g;
        int iHashCode3 = (iHashCode2 + (flingBehavior != null ? flingBehavior.hashCode() : 0)) * 31;
        MutableInteractionSource mutableInteractionSource = this.f6080h;
        int iHashCode4 = (iHashCode3 + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        BringIntoViewSpec bringIntoViewSpec = this.f6081i;
        return iHashCode4 + (bringIntoViewSpec != null ? bringIntoViewSpec.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("scrollable");
        inspectorInfo.b().c("orientation", this.f6075b);
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f6074a);
        inspectorInfo.b().c("overscrollEffect", this.f6076c);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f6077d));
        inspectorInfo.b().c("reverseDirection", Boolean.valueOf(this.f6078f));
        inspectorInfo.b().c("flingBehavior", this.f6079g);
        inspectorInfo.b().c("interactionSource", this.f6080h);
        inspectorInfo.b().c("bringIntoViewSpec", this.f6081i);
    }
}
