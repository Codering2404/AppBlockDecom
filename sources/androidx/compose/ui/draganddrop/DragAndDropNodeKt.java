package androidx.compose.ui.draganddrop;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class DragAndDropNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropModifierNode a() {
        return new DragAndDropNode(null, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropSourceModifierNode b(Function2 function2) {
        return new DragAndDropNode(function2, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropTargetModifierNode c(final Function1 function1, final DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(null, new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt$DragAndDropTargetModifierNode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
                if (((Boolean) function1.invoke(dragAndDropEvent)).booleanValue()) {
                    return dragAndDropTarget;
                }
                return null;
            }
        }, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(DragAndDropNode dragAndDropNode, long j3) {
        if (!dragAndDropNode.getNode().isAttached()) {
            return false;
        }
        LayoutCoordinates layoutCoordinatesX = DelegatableNodeKt.o(dragAndDropNode).x();
        if (!layoutCoordinatesX.m()) {
            return false;
        }
        long jF = LayoutCoordinatesKt.f(layoutCoordinatesX);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jF >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jF & 4294967295L));
        float fU2 = ((int) (dragAndDropNode.u2() >> 32)) + fIntBitsToFloat;
        float fU22 = ((int) (dragAndDropNode.u2() & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j3 >> 32));
        if (fIntBitsToFloat <= fIntBitsToFloat3 && fIntBitsToFloat3 <= fU2) {
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j3 & 4294967295L));
            if (fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= fU22) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.x0(dragAndDropEvent);
        dragAndDropTarget.T(dragAndDropEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TraversableNode traversableNode, Function1 function1) {
        if (function1.invoke(traversableNode) != TraversableNode.Companion.TraverseDescendantsAction.f27641a) {
            return;
        }
        TraversableNodeKt.f(traversableNode, function1);
    }
}
