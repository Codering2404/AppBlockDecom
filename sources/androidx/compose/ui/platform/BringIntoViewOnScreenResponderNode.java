package androidx.compose.ui.platform;

import android.view.ViewGroup;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

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
final class BringIntoViewOnScreenResponderNode extends Modifier.Node implements BringIntoViewModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f27927a;

    public BringIntoViewOnScreenResponderNode(ViewGroup viewGroup) {
        this.f27927a = viewGroup;
    }

    @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
    public Object E0(LayoutCoordinates layoutCoordinates, Function0 function0, Continuation continuation) {
        long jF = LayoutCoordinatesKt.f(layoutCoordinates);
        Rect rect = (Rect) function0.invoke();
        Rect rectB = rect != null ? rect.B(jF) : null;
        if (rectB != null) {
            this.f27927a.requestRectangleOnScreen(RectHelper_androidKt.a(rectB), false);
        }
        return Unit.f139807a;
    }

    public final void m2(ViewGroup viewGroup) {
        this.f27927a = viewGroup;
    }
}
