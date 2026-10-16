package androidx.constraintlayout.compose;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

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
public final class MotionDragHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object b(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function2 function2, Continuation continuation) {
        Object objE = ForEachGestureKt.e(pointerInputScope, new MotionDragHandlerKt$detectDragGesturesWhenNeeded$2(function1, function12, function2, function02, function0, null), continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public static final Modifier c(Modifier modifier, final Object obj, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("motionPointerInput");
                inspectorInfo.b().c("key", obj);
                inspectorInfo.b().c("motionProgress", mutableFloatState);
                inspectorInfo.b().c("measurer", motionMeasurer);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c((InspectorInfo) obj2);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(146198586);
                if (ComposerKt.M()) {
                    ComposerKt.U(146198586, i3, -1, "androidx.constraintlayout.compose.motionPointerInput.<anonymous> (MotionDragHandler.kt:61)");
                }
                if (!motionMeasurer.G().E()) {
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer.U();
                    return modifier2;
                }
                boolean Z = composer.Z(obj);
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                MutableFloatState mutableFloatState2 = mutableFloatState;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new TransitionHandler(motionMeasurer2, mutableFloatState2);
                    composer.w(objG);
                }
                TransitionHandler transitionHandler = (TransitionHandler) objG;
                boolean Z2 = composer.Z(obj);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = ChannelKt.b(-1, null, null, 6, null);
                    composer.w(objG2);
                }
                Channel channel = (Channel) objG2;
                Object obj2 = obj;
                boolean zI = composer.I(transitionHandler) | composer.I(channel);
                Object objG3 = composer.G();
                if (zI || objG3 == Composer.f23746a.a()) {
                    objG3 = new MotionDragHandlerKt$motionPointerInput$2$1$1(transitionHandler, channel, null);
                    composer.w(objG3);
                }
                EffectsKt.g(obj2, (Function2) objG3, composer, 0);
                Object obj3 = obj;
                boolean zI2 = composer.I(transitionHandler) | composer.I(channel);
                Object objG4 = composer.G();
                if (zI2 || objG4 == Composer.f23746a.a()) {
                    objG4 = new MotionDragHandlerKt$motionPointerInput$2$2$1(transitionHandler, channel, null);
                    composer.w(objG4);
                }
                Modifier modifierThen = modifier2.then(new SuspendPointerInputElement(obj3, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG4), 6, null));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierThen;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                return c((Modifier) obj2, (Composer) obj3, ((Number) obj4).intValue());
            }
        });
    }
}
