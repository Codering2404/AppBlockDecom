package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class StyledSliderKt$sliderTapModifier$2$1$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f132130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f132131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f132132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ State f132133d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f132134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ DraggableState f132135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ State f132136h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$sliderTapModifier$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$sliderTapModifier$2$1$1$1", f = "StyledSlider.kt", l = {533}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f132137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f132138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f132139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ long f132140d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f132141f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f132142g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ MutableState f132143h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ State f132144i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, float f3, MutableState mutableState, State state, Continuation continuation) {
            super(3, continuation);
            this.f132141f = z2;
            this.f132142g = f3;
            this.f132143h = mutableState;
            this.f132144i = state;
        }

        public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f132141f, this.f132142g, this.f132143h, this.f132144i, continuation);
            anonymousClass1.f132139c = pressGestureScope;
            anonymousClass1.f132140d = j3;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PressGestureScope pressGestureScope = (PressGestureScope) this.f132139c;
            long j3 = this.f132140d;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f132138b;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    float fIntBitsToFloat = this.f132141f ? this.f132142g - Float.intBitsToFloat((int) (j3 >> 32)) : Float.intBitsToFloat((int) (j3 >> 32));
                    this.f132143h.setValue(Boxing.c(fIntBitsToFloat - ((Number) this.f132144i.getValue()).floatValue()));
                    this.f132139c = SpillingKt.a(pressGestureScope);
                    this.f132140d = j3;
                    this.f132137a = fIntBitsToFloat;
                    this.f132138b = 1;
                    if (pressGestureScope.m1(this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (GestureCancellationException unused) {
                this.f132143h.setValue(Boxing.c(0.0f));
            }
            return Unit.f139807a;
        }
    }

    StyledSliderKt$sliderTapModifier$2$1$1(boolean z2, float f3, MutableState mutableState, State state, CoroutineScope coroutineScope, DraggableState draggableState, State state2) {
        this.f132130a = z2;
        this.f132131b = f3;
        this.f132132c = mutableState;
        this.f132133d = state;
        this.f132134f = coroutineScope;
        this.f132135g = draggableState;
        this.f132136h = state2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(CoroutineScope coroutineScope, DraggableState draggableState, State state, Offset offset) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StyledSliderKt$sliderTapModifier$2$1$1$2$1(draggableState, state, null), 3, null);
        return Unit.f139807a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f132130a, this.f132131b, this.f132132c, this.f132133d, null);
        final CoroutineScope coroutineScope = this.f132134f;
        final DraggableState draggableState = this.f132135g;
        final State state = this.f132136h;
        Object objM = TapGestureDetectorKt.m(pointerInputScope, null, null, anonymousClass1, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyledSliderKt$sliderTapModifier$2$1$1.b(coroutineScope, draggableState, state, (Offset) obj);
            }
        }, continuation, 3, null);
        return objM == IntrinsicsKt.f() ? objM : Unit.f139807a;
    }
}
