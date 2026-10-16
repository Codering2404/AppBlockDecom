package cz.mobilesoft.coreblock.util.helperextension;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class ModifierExtKt$clearFocusOnTap$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FocusManager f128644a;

    ModifierExtKt$clearFocusOnTap$1(FocusManager focusManager) {
        this.f128644a = focusManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(FocusManager focusManager, Offset offset) {
        focusManager.v(true);
        return Unit.f139807a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        final FocusManager focusManager = this.f128644a;
        Object objM = TapGestureDetectorKt.m(pointerInputScope, null, null, null, new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModifierExtKt$clearFocusOnTap$1.b(focusManager, (Offset) obj);
            }
        }, continuation, 7, null);
        return objM == IntrinsicsKt.f() ? objM : Unit.f139807a;
    }
}
