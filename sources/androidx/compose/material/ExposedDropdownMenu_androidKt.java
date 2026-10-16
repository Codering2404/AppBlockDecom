package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ExposedDropdownMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final boolean r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.ui.Modifier r24, final kotlin.jvm.functions.Function3 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenu_androidKt.a(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    private static final Modifier k(Modifier modifier, final Function0 function0, final String str) {
        return SemanticsModifierKt.f(modifier.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new ExposedDropdownMenu_androidKt$expandable$1(function0, null)), 6, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str);
                final Function0 function02 = function0;
                SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        function02.invoke();
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view, LayoutCoordinates layoutCoordinates, int i3, Function1 function1) {
        if (layoutCoordinates == null) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.c(layoutCoordinates).r() - rect.top, (rect.bottom - r1) - LayoutCoordinatesKt.c(layoutCoordinates).i())) - i3));
    }
}
