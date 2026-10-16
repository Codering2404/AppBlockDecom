package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class AppFeelLabelingScreenKt$SwipeCard$3$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f98698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f98699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f98701d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f98702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f98703g;

    AppFeelLabelingScreenKt$SwipeCard$3$1(boolean z2, CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0, Function0 function02, Function0 function03) {
        this.f98698a = z2;
        this.f98699b = coroutineScope;
        this.f98700c = swipeCardState;
        this.f98701d = function0;
        this.f98702f = function02;
        this.f98703g = function03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Offset offset) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$SwipeCard$3$1$1$1(swipeCardState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0, Function0 function02, Function0 function03) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$SwipeCard$3$1$2$1(swipeCardState, function0, function02, function03, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$SwipeCard$3$1$3$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(CoroutineScope coroutineScope, SwipeCardState swipeCardState, PointerInputChange pointerInputChange, float f3) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$SwipeCard$3$1$4$1(swipeCardState, f3, null), 3, null);
        return Unit.f139807a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        if (!this.f98698a) {
            return Unit.f139807a;
        }
        final CoroutineScope coroutineScope = this.f98699b;
        final SwipeCardState swipeCardState = this.f98700c;
        Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppFeelLabelingScreenKt$SwipeCard$3$1.e(coroutineScope, swipeCardState, (Offset) obj);
            }
        };
        final CoroutineScope coroutineScope2 = this.f98699b;
        final SwipeCardState swipeCardState2 = this.f98700c;
        final Function0 function0 = this.f98701d;
        final Function0 function02 = this.f98702f;
        final Function0 function03 = this.f98703g;
        Function0 function04 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppFeelLabelingScreenKt$SwipeCard$3$1.f(coroutineScope2, swipeCardState2, function0, function02, function03);
            }
        };
        final CoroutineScope coroutineScope3 = this.f98699b;
        final SwipeCardState swipeCardState3 = this.f98700c;
        final Function0 function05 = this.f98703g;
        Function0 function06 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppFeelLabelingScreenKt$SwipeCard$3$1.g(coroutineScope3, swipeCardState3, function05);
            }
        };
        final CoroutineScope coroutineScope4 = this.f98699b;
        final SwipeCardState swipeCardState4 = this.f98700c;
        Object objP = DragGestureDetectorKt.p(pointerInputScope, function1, function04, function06, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.t0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppFeelLabelingScreenKt$SwipeCard$3$1.h(coroutineScope4, swipeCardState4, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, continuation);
        return objP == IntrinsicsKt.f() ? objP : Unit.f139807a;
    }
}
