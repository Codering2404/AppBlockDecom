package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
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
public final class LookaheadLayoutCoordinatesKt {
    public static final LookaheadDelegate a(LookaheadDelegate lookaheadDelegate) {
        LayoutNode layoutNodeX1 = lookaheadDelegate.X1();
        while (true) {
            LayoutNode layoutNodeB0 = layoutNodeX1.B0();
            if ((layoutNodeB0 != null ? layoutNodeB0.l0() : null) == null) {
                LookaheadDelegate lookaheadDelegateS2 = layoutNodeX1.x0().S2();
                Intrinsics.checkNotNull(lookaheadDelegateS2);
                return lookaheadDelegateS2;
            }
            LayoutNode layoutNodeB02 = layoutNodeX1.B0();
            LayoutNode layoutNodeL0 = layoutNodeB02 != null ? layoutNodeB02.l0() : null;
            Intrinsics.checkNotNull(layoutNodeL0);
            if (layoutNodeL0.W0()) {
                layoutNodeX1 = layoutNodeX1.B0();
                Intrinsics.checkNotNull(layoutNodeX1);
            } else {
                LayoutNode layoutNodeB03 = layoutNodeX1.B0();
                Intrinsics.checkNotNull(layoutNodeB03);
                layoutNodeX1 = layoutNodeB03.l0();
                Intrinsics.checkNotNull(layoutNodeX1);
            }
        }
    }
}
