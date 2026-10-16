package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
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
public final class LayoutModifierNodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        LookaheadCapablePlaceable lookaheadCapablePlaceableT1 = lookaheadCapablePlaceable.t1();
        if (!(lookaheadCapablePlaceableT1 != null)) {
            InlineClassHelperKt.c("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.x1().z().containsKey(alignmentLine)) {
            Integer num = (Integer) lookaheadCapablePlaceable.x1().z().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int iP0 = lookaheadCapablePlaceableT1.p0(alignmentLine);
        if (iP0 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        lookaheadCapablePlaceableT1.l2(true);
        lookaheadCapablePlaceable.k2(true);
        lookaheadCapablePlaceable.d2();
        lookaheadCapablePlaceableT1.l2(false);
        lookaheadCapablePlaceable.k2(false);
        return iP0 + (alignmentLine instanceof HorizontalAlignmentLine ? IntOffset.l(lookaheadCapablePlaceableT1.C1()) : IntOffset.k(lookaheadCapablePlaceableT1.C1()));
    }
}
