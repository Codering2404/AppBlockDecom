package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
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
final class AlignmentLineOffsetTextUnitNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AlignmentLine f6561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6563c;

    public /* synthetic */ AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, j3, j4);
    }

    public final void m2(long j3) {
        this.f6563c = j3;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        return AlignmentLineKt.c(measureScope, this.f6561a, TextUnit.f(this.f6562b) == 0 ? Dp.f29970b.c() : measureScope.q(this.f6562b), TextUnit.f(this.f6563c) == 0 ? Dp.f29970b.c() : measureScope.q(this.f6563c), measurable, j3);
    }

    public final void n2(AlignmentLine alignmentLine) {
        this.f6561a = alignmentLine;
    }

    public final void o2(long j3) {
        this.f6562b = j3;
    }

    private AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long j3, long j4) {
        this.f6561a = alignmentLine;
        this.f6562b = j3;
        this.f6563c = j4;
    }
}
