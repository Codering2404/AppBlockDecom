package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
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
public final class AndroidViewHolder_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 f30108a = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt$NoOpScrollConnection$1
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, LayoutNode layoutNode) {
        long jF = LayoutCoordinatesKt.f(layoutNode.x());
        int iRound = Math.round(Float.intBitsToFloat((int) (jF >> 32)));
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jF & 4294967295L)));
        view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(int i3) {
        return i3 * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(float f3) {
        return f3 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i3) {
        return i3 == 0 ? NestedScrollSource.f26772b.b() : NestedScrollSource.f26772b.a();
    }
}
