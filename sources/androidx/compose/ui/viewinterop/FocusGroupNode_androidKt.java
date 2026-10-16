package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.node.DelegatableNodeKt;
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
public final class FocusGroupNode_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(View view, View view2) {
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view.getParent()) {
                return true;
            }
        }
        return false;
    }

    public static final Modifier e(Modifier modifier) {
        return FocusModifierKt.a(FocusModifierKt.a(modifier.then(FocusGroupPropertiesElement.f30140a)).then(FocusTargetPropertiesElement.f30147a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect f(FocusOwner focusOwner, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        androidx.compose.ui.geometry.Rect rectR = focusOwner.r();
        if (rectR == null) {
            return null;
        }
        return new Rect((((int) rectR.o()) + iArr[0]) - iArr2[0], (((int) rectR.r()) + iArr[1]) - iArr2[1], (((int) rectR.p()) + iArr[0]) - iArr2[0], (((int) rectR.i()) + iArr[1]) - iArr2[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View g(Modifier.Node node) {
        View viewB0 = DelegatableNodeKt.o(node.getNode()).b0();
        if (viewB0 != null) {
            return viewB0;
        }
        throw new IllegalStateException("Could not fetch interop view");
    }
}
