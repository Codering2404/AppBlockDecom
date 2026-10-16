package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
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
final class SizeAnimationModifierElement extends ModifierNodeElement<SizeAnimationModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FiniteAnimationSpec f3714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Alignment f3715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f3716c;

    public SizeAnimationModifierElement(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, Function2 function2) {
        this.f3714a = finiteAnimationSpec;
        this.f3715b = alignment;
        this.f3716c = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SizeAnimationModifierNode create() {
        return new SizeAnimationModifierNode(this.f3714a, this.f3715b, this.f3716c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SizeAnimationModifierNode sizeAnimationModifierNode) {
        sizeAnimationModifierNode.t2(this.f3714a);
        sizeAnimationModifierNode.u2(this.f3716c);
        sizeAnimationModifierNode.r2(this.f3715b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeAnimationModifierElement)) {
            return false;
        }
        SizeAnimationModifierElement sizeAnimationModifierElement = (SizeAnimationModifierElement) obj;
        return Intrinsics.areEqual(this.f3714a, sizeAnimationModifierElement.f3714a) && Intrinsics.areEqual(this.f3715b, sizeAnimationModifierElement.f3715b) && Intrinsics.areEqual(this.f3716c, sizeAnimationModifierElement.f3716c);
    }

    public int hashCode() {
        int iHashCode = ((this.f3714a.hashCode() * 31) + this.f3715b.hashCode()) * 31;
        Function2 function2 = this.f3716c;
        return iHashCode + (function2 == null ? 0 : function2.hashCode());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("animateContentSize");
        inspectorInfo.b().c("animationSpec", this.f3714a);
        inspectorInfo.b().c("alignment", this.f3715b);
        inspectorInfo.b().c("finishedListener", this.f3716c);
    }

    public String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.f3714a + ", alignment=" + this.f3715b + ", finishedListener=" + this.f3716c + ')';
    }
}
