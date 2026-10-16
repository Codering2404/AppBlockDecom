package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.Unit;
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
final class DragSourceNodeWithDefaultPainter extends DelegatingNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CacheDrawScopeDragShadowCallback f5349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DragAndDropSourceNode f5350d;

    public DragSourceNodeWithDefaultPainter(Function2 function2, Function1 function1) {
        CacheDrawScopeDragShadowCallback cacheDrawScopeDragShadowCallback = new CacheDrawScopeDragShadowCallback();
        m2(DrawModifierKt.a(new DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(cacheDrawScopeDragShadowCallback)));
        this.f5349c = cacheDrawScopeDragShadowCallback;
        this.f5350d = (DragAndDropSourceNode) m2(new DragAndDropSourceNode(new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$dragAndDropModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                this.f5351a.f5349c.c(drawScope);
            }
        }, function2, function1));
    }

    public final void t2(Function2 function2) {
        this.f5350d.x2(function2);
    }

    public final void u2(Function1 function1) {
        this.f5350d.z2(function1);
    }
}
