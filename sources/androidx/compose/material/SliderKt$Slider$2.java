package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class SliderKt$Slider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ClosedFloatingPointRange f13869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f13870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f13871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f13872d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f13873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f13874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SliderColors f13875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ State f13876i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$2(ClosedFloatingPointRange closedFloatingPointRange, float f3, List list, Function0 function0, MutableInteractionSource mutableInteractionSource, boolean z2, SliderColors sliderColors, State state) {
        super(3);
        this.f13869a = closedFloatingPointRange;
        this.f13870b = f3;
        this.f13871c = list;
        this.f13872d = function0;
        this.f13873f = mutableInteractionSource;
        this.f13874g = z2;
        this.f13875h = sliderColors;
        this.f13876i = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f3) {
        return SliderKt.B(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), f3, floatRef.f140141a, floatRef2.f140141a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange closedFloatingPointRange, float f3) {
        return SliderKt.B(floatRef.f140141a, floatRef2.f140141a, f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.f139807a;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i3) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i4;
        MutableFloatState mutableFloatState;
        Ref.FloatRef floatRef;
        Ref.FloatRef floatRef2;
        final SliderDraggableState sliderDraggableState;
        Ref.FloatRef floatRef3;
        Ref.FloatRef floatRef4;
        if ((i3 & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i4 = i3 | (composer.Z(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i4 = i3;
        }
        if ((i4 & 19) == 18 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(2085116814, i4, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:181)");
        }
        boolean z2 = composer.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
        float fL = Constraints.l(boxWithConstraintsScope2.c());
        final Ref.FloatRef floatRef5 = new Ref.FloatRef();
        final Ref.FloatRef floatRef6 = new Ref.FloatRef();
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        floatRef5.f140141a = Math.max(fL - density.M1(SliderKt.z()), 0.0f);
        floatRef6.f140141a = Math.min(density.M1(SliderKt.z()), floatRef5.f140141a);
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer));
            composer.w(compositionScopedCoroutineScopeCanceller);
            objG = compositionScopedCoroutineScopeCanceller;
        }
        final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
        float f3 = this.f13870b;
        ClosedFloatingPointRange closedFloatingPointRange = this.f13869a;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = PrimitiveSnapshotStateKt.a(e(closedFloatingPointRange, floatRef6, floatRef5, f3));
            composer.w(objG2);
        }
        final MutableFloatState mutableFloatState2 = (MutableFloatState) objG2;
        Object objG3 = composer.G();
        if (objG3 == companion.a()) {
            objG3 = PrimitiveSnapshotStateKt.a(0.0f);
            composer.w(objG3);
        }
        final MutableFloatState mutableFloatState3 = (MutableFloatState) objG3;
        boolean zC = composer.c(floatRef6.f140141a) | composer.c(floatRef5.f140141a) | composer.Z(this.f13869a);
        final State state = this.f13876i;
        final ClosedFloatingPointRange closedFloatingPointRange2 = this.f13869a;
        Object objG4 = composer.G();
        if (zC || objG4 == companion.a()) {
            mutableFloatState = mutableFloatState3;
            floatRef = floatRef6;
            floatRef2 = floatRef5;
            objG4 = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$2$draggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(float f4) {
                    MutableFloatState mutableFloatState4 = mutableFloatState2;
                    mutableFloatState4.s(mutableFloatState4.c() + f4 + mutableFloatState3.c());
                    mutableFloatState3.s(0.0f);
                    ((Function1) state.getValue()).invoke(Float.valueOf(SliderKt$Slider$2.h(floatRef6, floatRef5, closedFloatingPointRange2, RangesKt.o(mutableFloatState2.c(), floatRef6.f140141a, floatRef5.f140141a))));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Number) obj).floatValue());
                    return Unit.f139807a;
                }
            });
            composer.w(objG4);
        } else {
            floatRef2 = floatRef5;
            floatRef = floatRef6;
            mutableFloatState = mutableFloatState3;
        }
        SliderDraggableState sliderDraggableState2 = (SliderDraggableState) objG4;
        boolean Z = composer.Z(this.f13869a) | composer.c(floatRef.f140141a) | composer.c(floatRef2.f140141a);
        ClosedFloatingPointRange closedFloatingPointRange3 = this.f13869a;
        Object objG5 = composer.G();
        if (Z || objG5 == companion.a()) {
            objG5 = new SliderKt$Slider$2$2$1(closedFloatingPointRange3, floatRef, floatRef2);
            composer.w(objG5);
        }
        SliderKt.a((Function1) ((KFunction) objG5), this.f13869a, RangesKt.b(floatRef.f140141a, floatRef2.f140141a), mutableFloatState2, this.f13870b, composer, 3072);
        boolean zI = composer.I(this.f13871c) | composer.c(floatRef.f140141a) | composer.c(floatRef2.f140141a) | composer.I(coroutineScopeA) | composer.I(sliderDraggableState2) | composer.Z(this.f13872d);
        final List list = this.f13871c;
        final Function0 function0 = this.f13872d;
        Object objG6 = composer.G();
        if (zI || objG6 == companion.a()) {
            sliderDraggableState = sliderDraggableState2;
            final Ref.FloatRef floatRef7 = floatRef2;
            final Ref.FloatRef floatRef8 = floatRef;
            Object obj = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$2$gestureEndAction$1$1$1", f = "Slider.kt", l = {218}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f13896a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ SliderDraggableState f13897b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ float f13898c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ float f13899d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ float f13900f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ Function0 f13901g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SliderDraggableState sliderDraggableState, float f3, float f4, float f5, Function0 function0, Continuation continuation) {
                        super(2, continuation);
                        this.f13897b = sliderDraggableState;
                        this.f13898c = f3;
                        this.f13899d = f4;
                        this.f13900f = f5;
                        this.f13901g = function0;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f13897b, this.f13898c, this.f13899d, this.f13900f, this.f13901g, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f13896a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            SliderDraggableState sliderDraggableState = this.f13897b;
                            float f3 = this.f13898c;
                            float f4 = this.f13899d;
                            float f5 = this.f13900f;
                            this.f13896a = 1;
                            if (SliderKt.w(sliderDraggableState, f3, f4, f5, this) == objF) {
                                return objF;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        Function0 function0 = this.f13901g;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(float f4) {
                    Function0 function02;
                    float fC = mutableFloatState2.c();
                    float F = SliderKt.F(fC, list, floatRef8.f140141a, floatRef7.f140141a);
                    if (fC != F) {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(sliderDraggableState, fC, F, f4, function0, null), 3, null);
                    } else {
                        if (sliderDraggableState.h() || (function02 = function0) == null) {
                            return;
                        }
                        function02.invoke();
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Number) obj2).floatValue());
                    return Unit.f139807a;
                }
            };
            floatRef3 = floatRef8;
            floatRef4 = floatRef7;
            composer.w(obj);
            objG6 = obj;
        } else {
            floatRef4 = floatRef2;
            floatRef3 = floatRef;
            sliderDraggableState = sliderDraggableState2;
        }
        State stateP = SnapshotStateKt.p((Function1) objG6, composer, 0);
        Modifier.Companion companion2 = Modifier.b8;
        Modifier modifierE = SliderKt.E(companion2, sliderDraggableState, this.f13873f, fL, z2, mutableFloatState2, stateP, mutableFloatState, this.f13874g);
        Orientation orientation = Orientation.f6032b;
        boolean zH = sliderDraggableState.h();
        boolean z3 = this.f13874g;
        boolean z4 = z2;
        MutableInteractionSource mutableInteractionSource = this.f13873f;
        boolean Z2 = composer.Z(stateP);
        Object objG7 = composer.G();
        if (Z2 || objG7 == companion.a()) {
            objG7 = new SliderKt$Slider$2$drag$1$1(stateP, null);
            composer.w(objG7);
        }
        SliderKt.e(this.f13874g, SliderKt.y(((Number) this.f13869a.a()).floatValue(), ((Number) this.f13869a.e()).floatValue(), RangesKt.o(this.f13870b, ((Number) this.f13869a.a()).floatValue(), ((Number) this.f13869a.e()).floatValue())), this.f13871c, this.f13875h, floatRef4.f140141a - floatRef3.f140141a, this.f13873f, modifierE.then(DraggableKt.h(companion2, sliderDraggableState, orientation, z3, mutableInteractionSource, zH, null, (Function3) objG7, z4, 32, null)), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
