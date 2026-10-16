package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
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
public final class LookaheadAlignmentLines extends AlignmentLines {
    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected long d(NodeCoordinator nodeCoordinator, long j3) {
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinator.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        long jC1 = lookaheadDelegateS2.C1();
        return Offset.q(Offset.e((((long) Float.floatToRawIntBits(IntOffset.k(jC1))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.l(jC1))) & 4294967295L)), j3);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected Map e(NodeCoordinator nodeCoordinator) {
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinator.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.x1().z();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected int i(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinator.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.p0(alignmentLine);
    }
}
