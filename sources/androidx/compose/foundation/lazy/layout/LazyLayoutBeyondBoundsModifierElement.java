package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
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
final class LazyLayoutBeyondBoundsModifierElement extends ModifierNodeElement<LazyLayoutBeyondBoundsModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsState f8004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsInfo f8005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f8006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Orientation f8007d;

    public LazyLayoutBeyondBoundsModifierElement(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z2, Orientation orientation) {
        this.f8004a = lazyLayoutBeyondBoundsState;
        this.f8005b = lazyLayoutBeyondBoundsInfo;
        this.f8006c = z2;
        this.f8007d = orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LazyLayoutBeyondBoundsModifierNode create() {
        return new LazyLayoutBeyondBoundsModifierNode(this.f8004a, this.f8005b, this.f8006c, this.f8007d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LazyLayoutBeyondBoundsModifierNode lazyLayoutBeyondBoundsModifierNode) {
        lazyLayoutBeyondBoundsModifierNode.r2(this.f8004a, this.f8005b, this.f8006c, this.f8007d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutBeyondBoundsModifierElement)) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierElement lazyLayoutBeyondBoundsModifierElement = (LazyLayoutBeyondBoundsModifierElement) obj;
        return Intrinsics.areEqual(this.f8004a, lazyLayoutBeyondBoundsModifierElement.f8004a) && Intrinsics.areEqual(this.f8005b, lazyLayoutBeyondBoundsModifierElement.f8005b) && this.f8006c == lazyLayoutBeyondBoundsModifierElement.f8006c && this.f8007d == lazyLayoutBeyondBoundsModifierElement.f8007d;
    }

    public int hashCode() {
        return (((((this.f8004a.hashCode() * 31) + this.f8005b.hashCode()) * 31) + Boolean.hashCode(this.f8006c)) * 31) + this.f8007d.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
