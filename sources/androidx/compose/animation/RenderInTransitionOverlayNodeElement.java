package androidx.compose.animation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class RenderInTransitionOverlayNodeElement extends ModifierNodeElement<RenderInTransitionOverlayNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedTransitionScopeImpl f3588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f3589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f3591d;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RenderInTransitionOverlayNode create() {
        return new RenderInTransitionOverlayNode(this.f3588a, this.f3589b, this.f3590c, this.f3591d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(RenderInTransitionOverlayNode renderInTransitionOverlayNode) {
        renderInTransitionOverlayNode.t2(this.f3588a);
        renderInTransitionOverlayNode.s2(this.f3589b);
        renderInTransitionOverlayNode.u2(this.f3590c);
        renderInTransitionOverlayNode.r2(this.f3591d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RenderInTransitionOverlayNodeElement) {
            RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement = (RenderInTransitionOverlayNodeElement) obj;
            if (Intrinsics.areEqual(this.f3588a, renderInTransitionOverlayNodeElement.f3588a) && this.f3589b == renderInTransitionOverlayNodeElement.f3589b && this.f3590c == renderInTransitionOverlayNodeElement.f3590c && this.f3591d == renderInTransitionOverlayNodeElement.f3591d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f3588a.hashCode() * 31) + this.f3589b.hashCode()) * 31) + Float.hashCode(this.f3590c)) * 31) + this.f3591d.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("renderInSharedTransitionOverlay");
        inspectorInfo.b().c("sharedTransitionScope", this.f3588a);
        inspectorInfo.b().c("renderInOverlay", this.f3589b);
        inspectorInfo.b().c("zIndexInOverlay", Float.valueOf(this.f3590c));
        inspectorInfo.b().c("clipInOverlayDuringTransition", this.f3591d);
    }

    public String toString() {
        return "RenderInTransitionOverlayNodeElement(sharedTransitionScope=" + this.f3588a + ", renderInOverlay=" + this.f3589b + ", zIndexInOverlay=" + this.f3590c + ", clipInOverlay=" + this.f3591d + ')';
    }
}
