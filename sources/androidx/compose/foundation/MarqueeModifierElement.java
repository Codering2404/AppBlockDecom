package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
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
final class MarqueeModifierElement extends ModifierNodeElement<MarqueeModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5037d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MarqueeSpacing f5038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f5039g;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MarqueeModifierNode create() {
        return new MarqueeModifierNode(this.f5034a, this.f5035b, this.f5036c, this.f5037d, this.f5038f, this.f5039g, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(MarqueeModifierNode marqueeModifierNode) {
        marqueeModifierNode.K2(this.f5034a, this.f5035b, this.f5036c, this.f5037d, this.f5038f, this.f5039g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarqueeModifierElement)) {
            return false;
        }
        MarqueeModifierElement marqueeModifierElement = (MarqueeModifierElement) obj;
        return this.f5034a == marqueeModifierElement.f5034a && MarqueeAnimationMode.e(this.f5035b, marqueeModifierElement.f5035b) && this.f5036c == marqueeModifierElement.f5036c && this.f5037d == marqueeModifierElement.f5037d && Intrinsics.areEqual(this.f5038f, marqueeModifierElement.f5038f) && Dp.i(this.f5039g, marqueeModifierElement.f5039g);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f5034a) * 31) + MarqueeAnimationMode.f(this.f5035b)) * 31) + Integer.hashCode(this.f5036c)) * 31) + Integer.hashCode(this.f5037d)) * 31) + this.f5038f.hashCode()) * 31) + Dp.j(this.f5039g);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("basicMarquee");
        inspectorInfo.b().c("iterations", Integer.valueOf(this.f5034a));
        inspectorInfo.b().c("animationMode", MarqueeAnimationMode.b(this.f5035b));
        inspectorInfo.b().c("delayMillis", Integer.valueOf(this.f5036c));
        inspectorInfo.b().c("initialDelayMillis", Integer.valueOf(this.f5037d));
        inspectorInfo.b().c("spacing", this.f5038f);
        inspectorInfo.b().c("velocity", Dp.d(this.f5039g));
    }

    public String toString() {
        return "MarqueeModifierElement(iterations=" + this.f5034a + ", animationMode=" + ((Object) MarqueeAnimationMode.g(this.f5035b)) + ", delayMillis=" + this.f5036c + ", initialDelayMillis=" + this.f5037d + ", spacing=" + this.f5038f + ", velocity=" + ((Object) Dp.k(this.f5039g)) + ')';
    }
}
