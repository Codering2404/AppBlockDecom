package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public interface FocusOwner extends FocusManager {
    static /* synthetic */ boolean f(FocusOwner focusOwner, KeyEvent keyEvent, Function0 function0, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i3 & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.k(keyEvent, function0);
    }

    Modifier a();

    MutableObjectList b();

    void c(FocusEventModifierNode focusEventModifierNode);

    FocusTransactionManager d();

    boolean g(KeyEvent keyEvent);

    FocusTargetNode h();

    void i(FocusTargetNode focusTargetNode);

    void j();

    boolean k(KeyEvent keyEvent, Function0 function0);

    boolean l(RotaryScrollEvent rotaryScrollEvent, Function0 function0);

    boolean n();

    boolean o(boolean z2, boolean z3, boolean z4, int i3);

    FocusState p();

    void q(FocusPropertiesModifierNode focusPropertiesModifierNode);

    Rect r();

    void s(FocusTargetNode focusTargetNode);

    void t();

    boolean u(FocusDirection focusDirection, Rect rect);

    Boolean w(int i3, Rect rect, Function1 function1);
}
