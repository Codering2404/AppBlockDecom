package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
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
public final class ReceiveContentDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode a(final ReceiveContentConfiguration receiveContentConfiguration, final Function1 function1) {
        return DragAndDropNodeKt.c(new Function1<DragAndDropEvent, Boolean>() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                return Boolean.TRUE;
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2
            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public boolean Q0(DragAndDropEvent dragAndDropEvent) {
                function1.invoke(dragAndDropEvent);
                TransferableContent transferableContentB = ReceiveContentDragAndDropNode_androidKt.b(dragAndDropEvent);
                return !Intrinsics.areEqual(transferableContentB, receiveContentConfiguration.a().e(transferableContentB));
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void S(DragAndDropEvent dragAndDropEvent) {
                receiveContentConfiguration.a().c();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void d0(DragAndDropEvent dragAndDropEvent) {
                receiveContentConfiguration.a().d();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void j2(DragAndDropEvent dragAndDropEvent) {
                receiveContentConfiguration.a().b();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void x0(DragAndDropEvent dragAndDropEvent) {
                receiveContentConfiguration.a().a();
            }
        });
    }

    public static final TransferableContent b(DragAndDropEvent dragAndDropEvent) {
        DragEvent dragEventB = DragAndDrop_androidKt.b(dragAndDropEvent);
        return new TransferableContent(AndroidClipboardManager_androidKt.a(dragEventB.getClipData()), AndroidClipboardManager_androidKt.b(dragEventB.getClipDescription()), TransferableContent.Source.f5205b.b(), null, 8, null);
    }
}
