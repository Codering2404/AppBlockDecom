package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ThrottledCallbacksKt {
    public static final RelativeLayoutBounds a(DelegatableNode delegatableNode, long j3, long j4, long j5, long j6, float[] fArr) {
        NodeCoordinator nodeCoordinatorJ = DelegatableNodeKt.j(delegatableNode, NodeKind.a(2));
        LayoutNode layoutNodeO = DelegatableNodeKt.o(delegatableNode);
        if (!layoutNodeO.u()) {
            return null;
        }
        if (layoutNodeO.x0() == nodeCoordinatorJ) {
            return new RelativeLayoutBounds(j3, j4, j5, j6, fArr, delegatableNode, null);
        }
        long jF = IntOffset.f(j3);
        long jE = Offset.e((((long) Float.floatToRawIntBits(IntOffset.k(jF))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.l(jF))) & 4294967295L));
        long jA = nodeCoordinatorJ.u1().a();
        long jD = IntOffsetKt.d(layoutNodeO.x0().u1().S(nodeCoordinatorJ, jE));
        return new RelativeLayoutBounds(jD, IntOffset.f((((long) (IntOffset.k(jD) + ((int) (jA >> 32)))) << 32) | (((long) (IntOffset.l(jD) + ((int) (jA & 4294967295L)))) & 4294967295L)), j5, j6, fArr, delegatableNode, null);
    }
}
