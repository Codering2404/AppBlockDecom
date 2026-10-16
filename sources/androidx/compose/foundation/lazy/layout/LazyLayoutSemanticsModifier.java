package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
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
final class LazyLayoutSemanticsModifier extends ModifierNodeElement<LazyLayoutSemanticsModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f8211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutSemanticState f8212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Orientation f8213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8214d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8215f;

    public LazyLayoutSemanticsModifier(Function0 function0, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z2, boolean z3) {
        this.f8211a = function0;
        this.f8212b = lazyLayoutSemanticState;
        this.f8213c = orientation;
        this.f8214d = z2;
        this.f8215f = z3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LazyLayoutSemanticsModifierNode create() {
        return new LazyLayoutSemanticsModifierNode(this.f8211a, this.f8212b, this.f8213c, this.f8214d, this.f8215f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode) {
        lazyLayoutSemanticsModifierNode.q2(this.f8211a, this.f8212b, this.f8213c, this.f8214d, this.f8215f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) obj;
        return this.f8211a == lazyLayoutSemanticsModifier.f8211a && Intrinsics.areEqual(this.f8212b, lazyLayoutSemanticsModifier.f8212b) && this.f8213c == lazyLayoutSemanticsModifier.f8213c && this.f8214d == lazyLayoutSemanticsModifier.f8214d && this.f8215f == lazyLayoutSemanticsModifier.f8215f;
    }

    public int hashCode() {
        return (((((((this.f8211a.hashCode() * 31) + this.f8212b.hashCode()) * 31) + this.f8213c.hashCode()) * 31) + Boolean.hashCode(this.f8214d)) * 31) + Boolean.hashCode(this.f8215f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
