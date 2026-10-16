package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class DragAndDropTargetNode extends DelegatingNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f5345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DragAndDropTarget f5346d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DragAndDropTargetModifierNode f5347f;

    public DragAndDropTargetNode(Function1 function1, DragAndDropTarget dragAndDropTarget) {
        this.f5345c = function1;
        this.f5346d = dragAndDropTarget;
    }

    private final void t2() {
        this.f5347f = (DragAndDropTargetModifierNode) m2(DragAndDropNodeKt.c(new Function1<DragAndDropEvent, Boolean>() { // from class: androidx.compose.foundation.draganddrop.DragAndDropTargetNode$createAndAttachDragAndDropModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                return (Boolean) this.f5348a.f5345c.invoke(dragAndDropEvent);
            }
        }, this.f5346d));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        t2();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DragAndDropTargetModifierNode dragAndDropTargetModifierNode = this.f5347f;
        Intrinsics.checkNotNull(dragAndDropTargetModifierNode);
        p2(dragAndDropTargetModifierNode);
    }

    public final void u2(Function1 function1, DragAndDropTarget dragAndDropTarget) {
        this.f5345c = function1;
        if (Intrinsics.areEqual(dragAndDropTarget, this.f5346d)) {
            return;
        }
        DragAndDropTargetModifierNode dragAndDropTargetModifierNode = this.f5347f;
        if (dragAndDropTargetModifierNode != null) {
            p2(dragAndDropTargetModifierNode);
        }
        this.f5346d = dragAndDropTarget;
        t2();
    }
}
