package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class AlignmentLineOffsetDpNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AlignmentLine f6554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f6555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f6556c;

    public /* synthetic */ AlignmentLineOffsetDpNode(AlignmentLine alignmentLine, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, f3, f4);
    }

    public final void m2(float f3) {
        this.f6556c = f3;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        return AlignmentLineKt.c(measureScope, this.f6554a, this.f6555b, this.f6556c, measurable, j3);
    }

    public final void n2(AlignmentLine alignmentLine) {
        this.f6554a = alignmentLine;
    }

    public final void o2(float f3) {
        this.f6555b = f3;
    }

    private AlignmentLineOffsetDpNode(AlignmentLine alignmentLine, float f3, float f4) {
        this.f6554a = alignmentLine;
        this.f6555b = f3;
        this.f6556c = f4;
    }
}
