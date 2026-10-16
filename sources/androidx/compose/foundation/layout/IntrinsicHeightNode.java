package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

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
final class IntrinsicHeightNode extends IntrinsicSizeModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IntrinsicSize f6979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6980b;

    public IntrinsicHeightNode(IntrinsicSize intrinsicSize, boolean z2) {
        this.f6979a = intrinsicSize;
        this.f6980b = z2;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public long m2(MeasureScope measureScope, Measurable measurable, long j3) {
        int iD0 = this.f6979a == IntrinsicSize.f6986a ? measurable.d0(Constraints.l(j3)) : measurable.I(Constraints.l(j3));
        if (iD0 < 0) {
            iD0 = 0;
        }
        return Constraints.f29963b.d(iD0);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f6979a == IntrinsicSize.f6986a ? intrinsicMeasurable.d0(i3) : intrinsicMeasurable.I(i3);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f6979a == IntrinsicSize.f6986a ? intrinsicMeasurable.d0(i3) : intrinsicMeasurable.I(i3);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public boolean n2() {
        return this.f6980b;
    }

    public void o2(boolean z2) {
        this.f6980b = z2;
    }

    public final void p2(IntrinsicSize intrinsicSize) {
        this.f6979a = intrinsicSize;
    }
}
