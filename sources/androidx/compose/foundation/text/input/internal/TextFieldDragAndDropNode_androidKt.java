package androidx.compose.foundation.text.input.internal;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class TextFieldDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode a(final Function0 function0, final Function2 function2, final Function1 function1, final Function1 function12, final Function1 function13, final Function1 function14, final Function1 function15, final Function1 function16, final Function1 function17) {
        return DragAndDropNodeKt.c(new Function1<DragAndDropEvent, Boolean>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                ClipDescription clipDescription = DragAndDrop_androidKt.b(dragAndDropEvent).getClipDescription();
                Iterable<MediaType> iterable = (Iterable) function0.invoke();
                boolean z2 = false;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    for (MediaType mediaType : iterable) {
                        if (Intrinsics.areEqual(mediaType, MediaType.f5187b.a()) || clipDescription.hasMimeType(mediaType.c())) {
                            z2 = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z2);
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDragAndDropNode_androidKt$textFieldDragAndDropNode$2
            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public boolean Q0(DragAndDropEvent dragAndDropEvent) {
                function1.invoke(dragAndDropEvent);
                return ((Boolean) function2.invoke(AndroidClipboardManager_androidKt.a(DragAndDrop_androidKt.b(dragAndDropEvent).getClipData()), AndroidClipboardManager_androidKt.b(DragAndDrop_androidKt.b(dragAndDropEvent).getClipDescription()))).booleanValue();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void S(DragAndDropEvent dragAndDropEvent) {
                Function1 function18 = function12;
                if (function18 != null) {
                    function18.invoke(dragAndDropEvent);
                    Unit unit = Unit.f139807a;
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void T(DragAndDropEvent dragAndDropEvent) {
                DragEvent dragEventB = DragAndDrop_androidKt.b(dragAndDropEvent);
                Function1 function18 = function14;
                if (function18 != null) {
                    float x2 = dragEventB.getX();
                    float y2 = dragEventB.getY();
                    function18.invoke(Offset.d(Offset.e((((long) Float.floatToRawIntBits(x2)) << 32) | (((long) Float.floatToRawIntBits(y2)) & 4294967295L))));
                    Unit unit = Unit.f139807a;
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void d0(DragAndDropEvent dragAndDropEvent) {
                Function1 function18 = function16;
                if (function18 != null) {
                    function18.invoke(dragAndDropEvent);
                    Unit unit = Unit.f139807a;
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void j2(DragAndDropEvent dragAndDropEvent) {
                Function1 function18 = function17;
                if (function18 != null) {
                    function18.invoke(dragAndDropEvent);
                    Unit unit = Unit.f139807a;
                }
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void x0(DragAndDropEvent dragAndDropEvent) {
                Function1 function18 = function13;
                if (function18 != null) {
                    function18.invoke(dragAndDropEvent);
                    Unit unit = Unit.f139807a;
                }
            }
        });
    }

    public static /* synthetic */ DragAndDropTargetModifierNode b(Function0 function0, Function2 function2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        if ((i3 & 16) != 0) {
            function13 = null;
        }
        if ((i3 & 32) != 0) {
            function14 = null;
        }
        if ((i3 & 64) != 0) {
            function15 = null;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            function16 = null;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            function17 = null;
        }
        return a(function0, function2, function1, function12, function13, function14, function15, function16, function17);
    }
}
