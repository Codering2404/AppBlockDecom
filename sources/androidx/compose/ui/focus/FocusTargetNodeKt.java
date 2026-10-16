package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
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
public final class FocusTargetNodeKt {
    public static final FocusTransactionManager a(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNodeX1;
        Owner ownerA0;
        FocusOwner focusOwner;
        NodeCoordinator coordinator$ui_release = focusTargetNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release == null || (layoutNodeX1 = coordinator$ui_release.X1()) == null || (ownerA0 = layoutNodeX1.A0()) == null || (focusOwner = ownerA0.getFocusOwner()) == null) {
            return null;
        }
        return focusOwner.d();
    }

    public static final void b(FocusTargetNode focusTargetNode) {
        DelegatableNodeKt.p(focusTargetNode).getFocusOwner().i(focusTargetNode);
    }

    public static final FocusTransactionManager c(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.p(focusTargetNode).getFocusOwner().d();
    }
}
