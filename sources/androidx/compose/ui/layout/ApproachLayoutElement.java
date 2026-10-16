package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
final class ApproachLayoutElement extends ModifierNodeElement<ApproachLayoutModifierNodeImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3 f27021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f27022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f27023c;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ApproachLayoutModifierNodeImpl create() {
        return new ApproachLayoutModifierNodeImpl(this.f27021a, this.f27022b, this.f27023c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ApproachLayoutModifierNodeImpl approachLayoutModifierNodeImpl) {
        approachLayoutModifierNodeImpl.m2(this.f27021a);
        approachLayoutModifierNodeImpl.n2(this.f27022b);
        approachLayoutModifierNodeImpl.o2(this.f27023c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproachLayoutElement)) {
            return false;
        }
        ApproachLayoutElement approachLayoutElement = (ApproachLayoutElement) obj;
        return Intrinsics.areEqual(this.f27021a, approachLayoutElement.f27021a) && Intrinsics.areEqual(this.f27022b, approachLayoutElement.f27022b) && Intrinsics.areEqual(this.f27023c, approachLayoutElement.f27023c);
    }

    public int hashCode() {
        return (((this.f27021a.hashCode() * 31) + this.f27022b.hashCode()) * 31) + this.f27023c.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("approachLayout");
        inspectorInfo.b().c("approachMeasure", this.f27021a);
        inspectorInfo.b().c("isMeasurementApproachInProgress", this.f27022b);
        inspectorInfo.b().c("isPlacementApproachInProgress", this.f27023c);
    }

    public String toString() {
        return "ApproachLayoutElement(approachMeasure=" + this.f27021a + ", isMeasurementApproachInProgress=" + this.f27022b + ", isPlacementApproachInProgress=" + this.f27023c + ')';
    }
}
