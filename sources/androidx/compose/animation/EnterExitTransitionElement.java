package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class EnterExitTransitionElement extends ModifierNodeElement<EnterExitTransitionModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transition f3480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Transition.DeferredAnimation f3481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Transition.DeferredAnimation f3482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Transition.DeferredAnimation f3483d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EnterTransition f3484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExitTransition f3485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function0 f3486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GraphicsLayerBlockForEnterExit f3487i;

    public EnterExitTransitionElement(Transition transition, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0 function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.f3480a = transition;
        this.f3481b = deferredAnimation;
        this.f3482c = deferredAnimation2;
        this.f3483d = deferredAnimation3;
        this.f3484f = enterTransition;
        this.f3485g = exitTransition;
        this.f3486h = function0;
        this.f3487i = graphicsLayerBlockForEnterExit;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnterExitTransitionModifierNode create() {
        return new EnterExitTransitionModifierNode(this.f3480a, this.f3481b, this.f3482c, this.f3483d, this.f3484f, this.f3485g, this.f3486h, this.f3487i);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(EnterExitTransitionModifierNode enterExitTransitionModifierNode) {
        enterExitTransitionModifierNode.x2(this.f3480a);
        enterExitTransitionModifierNode.v2(this.f3481b);
        enterExitTransitionModifierNode.u2(this.f3482c);
        enterExitTransitionModifierNode.w2(this.f3483d);
        enterExitTransitionModifierNode.q2(this.f3484f);
        enterExitTransitionModifierNode.r2(this.f3485g);
        enterExitTransitionModifierNode.p2(this.f3486h);
        enterExitTransitionModifierNode.s2(this.f3487i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return Intrinsics.areEqual(this.f3480a, enterExitTransitionElement.f3480a) && Intrinsics.areEqual(this.f3481b, enterExitTransitionElement.f3481b) && Intrinsics.areEqual(this.f3482c, enterExitTransitionElement.f3482c) && Intrinsics.areEqual(this.f3483d, enterExitTransitionElement.f3483d) && Intrinsics.areEqual(this.f3484f, enterExitTransitionElement.f3484f) && Intrinsics.areEqual(this.f3485g, enterExitTransitionElement.f3485g) && Intrinsics.areEqual(this.f3486h, enterExitTransitionElement.f3486h) && Intrinsics.areEqual(this.f3487i, enterExitTransitionElement.f3487i);
    }

    public int hashCode() {
        int iHashCode = this.f3480a.hashCode() * 31;
        Transition.DeferredAnimation deferredAnimation = this.f3481b;
        int iHashCode2 = (iHashCode + (deferredAnimation == null ? 0 : deferredAnimation.hashCode())) * 31;
        Transition.DeferredAnimation deferredAnimation2 = this.f3482c;
        int iHashCode3 = (iHashCode2 + (deferredAnimation2 == null ? 0 : deferredAnimation2.hashCode())) * 31;
        Transition.DeferredAnimation deferredAnimation3 = this.f3483d;
        return ((((((((iHashCode3 + (deferredAnimation3 != null ? deferredAnimation3.hashCode() : 0)) * 31) + this.f3484f.hashCode()) * 31) + this.f3485g.hashCode()) * 31) + this.f3486h.hashCode()) * 31) + this.f3487i.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("enterExitTransition");
        inspectorInfo.b().c("transition", this.f3480a);
        inspectorInfo.b().c("sizeAnimation", this.f3481b);
        inspectorInfo.b().c("offsetAnimation", this.f3482c);
        inspectorInfo.b().c("slideAnimation", this.f3483d);
        inspectorInfo.b().c("enter", this.f3484f);
        inspectorInfo.b().c("exit", this.f3485g);
        inspectorInfo.b().c("graphicsLayerBlock", this.f3487i);
    }

    public String toString() {
        return "EnterExitTransitionElement(transition=" + this.f3480a + ", sizeAnimation=" + this.f3481b + ", offsetAnimation=" + this.f3482c + ", slideAnimation=" + this.f3483d + ", enter=" + this.f3484f + ", exit=" + this.f3485g + ", isEnabled=" + this.f3486h + ", graphicsLayerBlock=" + this.f3487i + ')';
    }
}
