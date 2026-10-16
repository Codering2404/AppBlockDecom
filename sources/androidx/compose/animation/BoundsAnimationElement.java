package androidx.compose.animation;

import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
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
public final class BoundsAnimationElement extends ModifierNodeElement<BoundsAnimationModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LookaheadScope f3404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BoundsTransform f3405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f3406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3407d;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BoundsAnimationModifierNode create() {
        return new BoundsAnimationModifierNode(this.f3404a, this.f3405b, this.f3406c, this.f3407d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(BoundsAnimationModifierNode boundsAnimationModifierNode) {
        boundsAnimationModifierNode.r2(this.f3404a);
        boundsAnimationModifierNode.q2(this.f3405b);
        boundsAnimationModifierNode.s2(this.f3406c);
        boundsAnimationModifierNode.p2(this.f3407d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoundsAnimationElement)) {
            return false;
        }
        BoundsAnimationElement boundsAnimationElement = (BoundsAnimationElement) obj;
        return Intrinsics.areEqual(this.f3404a, boundsAnimationElement.f3404a) && Intrinsics.areEqual(this.f3405b, boundsAnimationElement.f3405b) && Intrinsics.areEqual(this.f3406c, boundsAnimationElement.f3406c) && this.f3407d == boundsAnimationElement.f3407d;
    }

    public int hashCode() {
        return (((((this.f3404a.hashCode() * 31) + this.f3405b.hashCode()) * 31) + this.f3406c.hashCode()) * 31) + Boolean.hashCode(this.f3407d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("boundsAnimation");
        inspectorInfo.b().c("lookaheadScope", this.f3404a);
        inspectorInfo.b().c("boundsTransform", this.f3405b);
        inspectorInfo.b().c("onChooseMeasureConstraints", this.f3406c);
        inspectorInfo.b().c("animateMotionFrameOfReference", Boolean.valueOf(this.f3407d));
    }

    public String toString() {
        return "BoundsAnimationElement(lookaheadScope=" + this.f3404a + ", boundsTransform=" + this.f3405b + ", resolveMeasureConstraints=" + this.f3406c + ", animateMotionFrameOfReference=" + this.f3407d + ')';
    }
}
