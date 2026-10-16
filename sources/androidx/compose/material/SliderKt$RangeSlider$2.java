package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
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
import kotlin.coroutines.jvm.internal.Boxing;
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
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ClosedFloatingPointRange f13790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ClosedFloatingPointRange f13791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f13792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f13793d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ State f13794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f13795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f13796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f13797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ int f13798j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ SliderColors f13799k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, List list, Function0 function0, State state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z2, int i3, SliderColors sliderColors) {
        super(3);
        this.f13790a = closedFloatingPointRange;
        this.f13791b = closedFloatingPointRange2;
        this.f13792c = list;
        this.f13793d = function0;
        this.f13794f = state;
        this.f13795g = mutableInteractionSource;
        this.f13796h = mutableInteractionSource2;
        this.f13797i = z2;
        this.f13798j = i3;
        this.f13799k = sliderColors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f3) {
        return SliderKt.B(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), f3, floatRef.f140141a, floatRef2.f140141a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange h(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2) {
        return SliderKt.C(floatRef.f140141a, floatRef2.f140141a, closedFloatingPointRange2, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.f139807a;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i3) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i4;
        Ref.FloatRef floatRef;
        Ref.FloatRef floatRef2;
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
            ComposerKt.U(652589923, i4, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:320)");
        }
        boolean z2 = composer.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
        float fL = Constraints.l(boxWithConstraintsScope2.c());
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        floatRef3.f140141a = fL - density.M1(SliderKt.z());
        floatRef4.f140141a = density.M1(SliderKt.z());
        ClosedFloatingPointRange closedFloatingPointRange = this.f13791b;
        ClosedFloatingPointRange closedFloatingPointRange2 = this.f13790a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = PrimitiveSnapshotStateKt.a(e(closedFloatingPointRange2, floatRef4, floatRef3, ((Number) closedFloatingPointRange.a()).floatValue()));
            composer.w(objG);
        }
        final MutableFloatState mutableFloatState = (MutableFloatState) objG;
        ClosedFloatingPointRange closedFloatingPointRange3 = this.f13791b;
        ClosedFloatingPointRange closedFloatingPointRange4 = this.f13790a;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = PrimitiveSnapshotStateKt.a(e(closedFloatingPointRange4, floatRef4, floatRef3, ((Number) closedFloatingPointRange3.e()).floatValue()));
            composer.w(objG2);
        }
        final MutableFloatState mutableFloatState2 = (MutableFloatState) objG2;
        boolean Z = composer.Z(this.f13790a) | composer.c(floatRef4.f140141a) | composer.c(floatRef3.f140141a);
        ClosedFloatingPointRange closedFloatingPointRange5 = this.f13790a;
        Object objG3 = composer.G();
        if (Z || objG3 == companion.a()) {
            objG3 = new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange5, floatRef4, floatRef3);
            composer.w(objG3);
        }
        SliderKt.a((Function1) ((KFunction) objG3), this.f13790a, RangesKt.b(floatRef4.f140141a, floatRef3.f140141a), mutableFloatState, ((Number) this.f13791b.a()).floatValue(), composer, 3072);
        boolean Z2 = composer.Z(this.f13790a) | composer.c(floatRef4.f140141a) | composer.c(floatRef3.f140141a);
        ClosedFloatingPointRange closedFloatingPointRange6 = this.f13790a;
        Object objG4 = composer.G();
        if (Z2 || objG4 == companion.a()) {
            objG4 = new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange6, floatRef4, floatRef3);
            composer.w(objG4);
        }
        SliderKt.a((Function1) ((KFunction) objG4), this.f13790a, RangesKt.b(floatRef4.f140141a, floatRef3.f140141a), mutableFloatState2, ((Number) this.f13791b.e()).floatValue(), composer, 3072);
        Object objG5 = composer.G();
        if (objG5 == companion.a()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer));
            composer.w(compositionScopedCoroutineScopeCanceller);
            objG5 = compositionScopedCoroutineScopeCanceller;
        }
        final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG5).a();
        boolean zI = composer.I(this.f13792c) | composer.c(floatRef4.f140141a) | composer.c(floatRef3.f140141a) | composer.Z(this.f13793d) | composer.I(coroutineScopeA) | composer.Z(this.f13794f) | composer.Z(this.f13790a);
        final List list = this.f13792c;
        final Function0 function0 = this.f13793d;
        final State state = this.f13794f;
        final ClosedFloatingPointRange closedFloatingPointRange7 = this.f13790a;
        Object objG6 = composer.G();
        if (zI || objG6 == companion.a()) {
            objG6 = new Function1<Boolean, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1", f = "Slider.kt", l = {366}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f13817a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ float f13818b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ float f13819c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Function0 f13820d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f13821f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ MutableFloatState f13822g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    final /* synthetic */ MutableFloatState f13823h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    final /* synthetic */ State f13824i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    final /* synthetic */ Ref.FloatRef f13825j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    final /* synthetic */ Ref.FloatRef f13826k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    final /* synthetic */ ClosedFloatingPointRange f13827l;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(float f3, float f4, Function0 function0, boolean z2, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange closedFloatingPointRange, Continuation continuation) {
                        super(2, continuation);
                        this.f13818b = f3;
                        this.f13819c = f4;
                        this.f13820d = function0;
                        this.f13821f = z2;
                        this.f13822g = mutableFloatState;
                        this.f13823h = mutableFloatState2;
                        this.f13824i = state;
                        this.f13825j = floatRef;
                        this.f13826k = floatRef2;
                        this.f13827l = closedFloatingPointRange;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f13818b, this.f13819c, this.f13820d, this.f13821f, this.f13822g, this.f13823h, this.f13824i, this.f13825j, this.f13826k, this.f13827l, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f13817a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Animatable animatableB = AnimatableKt.b(this.f13818b, 0.0f, 2, null);
                            Float fC = Boxing.c(this.f13819c);
                            TweenSpec tweenSpec = SliderKt.f13778i;
                            Float fC2 = Boxing.c(0.0f);
                            final boolean z2 = this.f13821f;
                            final MutableFloatState mutableFloatState = this.f13822g;
                            final MutableFloatState mutableFloatState2 = this.f13823h;
                            final State state = this.f13824i;
                            final Ref.FloatRef floatRef = this.f13825j;
                            final Ref.FloatRef floatRef2 = this.f13826k;
                            final ClosedFloatingPointRange closedFloatingPointRange = this.f13827l;
                            Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt.RangeSlider.2.gestureEndAction.1.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final void c(Animatable animatable) {
                                    (z2 ? mutableFloatState : mutableFloatState2).s(((Number) animatable.n()).floatValue());
                                    ((Function1) state.getValue()).invoke(SliderKt$RangeSlider$2.h(floatRef, floatRef2, closedFloatingPointRange, RangesKt.b(mutableFloatState.c(), mutableFloatState2.c())));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    c((Animatable) obj2);
                                    return Unit.f139807a;
                                }
                            };
                            this.f13817a = 1;
                            if (animatableB.e(fC, tweenSpec, fC2, function1, this) == objF) {
                                return objF;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        Function0 function0 = this.f13820d;
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

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.f139807a;
                }

                public final void invoke(boolean z3) {
                    float fC = (z3 ? mutableFloatState : mutableFloatState2).c();
                    float F = SliderKt.F(fC, list, floatRef4.f140141a, floatRef3.f140141a);
                    if (fC != F) {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(fC, F, function0, z3, mutableFloatState, mutableFloatState2, state, floatRef4, floatRef3, closedFloatingPointRange7, null), 3, null);
                        return;
                    }
                    Function0 function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            };
            floatRef = floatRef4;
            floatRef2 = floatRef3;
            composer.w(objG6);
        } else {
            floatRef2 = floatRef3;
            floatRef = floatRef4;
        }
        State stateP = SnapshotStateKt.p((Function1) objG6, composer, 0);
        boolean Z3 = composer.Z(this.f13790a) | composer.c(floatRef.f140141a) | composer.c(floatRef2.f140141a) | composer.Z(this.f13791b) | composer.Z(this.f13794f);
        final ClosedFloatingPointRange closedFloatingPointRange8 = this.f13791b;
        final State state2 = this.f13794f;
        final ClosedFloatingPointRange closedFloatingPointRange9 = this.f13790a;
        Object objG7 = composer.G();
        if (Z3 || objG7 == companion.a()) {
            final Ref.FloatRef floatRef5 = floatRef2;
            final Ref.FloatRef floatRef6 = floatRef;
            objG7 = new Function2<Boolean, Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$onDrag$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void c(boolean z3, float f3) {
                    ClosedFloatingPointRange closedFloatingPointRangeB;
                    if (z3) {
                        MutableFloatState mutableFloatState3 = mutableFloatState;
                        mutableFloatState3.s(mutableFloatState3.c() + f3);
                        mutableFloatState2.s(SliderKt$RangeSlider$2.e(closedFloatingPointRange9, floatRef6, floatRef5, ((Number) closedFloatingPointRange8.e()).floatValue()));
                        float fC = mutableFloatState2.c();
                        closedFloatingPointRangeB = RangesKt.b(RangesKt.o(mutableFloatState.c(), floatRef6.f140141a, fC), fC);
                    } else {
                        MutableFloatState mutableFloatState4 = mutableFloatState2;
                        mutableFloatState4.s(mutableFloatState4.c() + f3);
                        mutableFloatState.s(SliderKt$RangeSlider$2.e(closedFloatingPointRange9, floatRef6, floatRef5, ((Number) closedFloatingPointRange8.a()).floatValue()));
                        float fC2 = mutableFloatState.c();
                        closedFloatingPointRangeB = RangesKt.b(fC2, RangesKt.o(mutableFloatState2.c(), fC2, floatRef5.f140141a));
                    }
                    ((Function1) state2.getValue()).invoke(SliderKt$RangeSlider$2.h(floatRef6, floatRef5, closedFloatingPointRange9, closedFloatingPointRangeB));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
                    return Unit.f139807a;
                }
            };
            composer.w(objG7);
        }
        State stateP2 = SnapshotStateKt.p((Function2) objG7, composer, 0);
        Modifier.Companion companion2 = Modifier.b8;
        Modifier modifierA = SliderKt.A(companion2, this.f13795g, this.f13796h, mutableFloatState, mutableFloatState2, this.f13797i, z2, fL, this.f13790a, stateP, stateP2);
        final float fO = RangesKt.o(((Number) this.f13791b.a()).floatValue(), ((Number) this.f13790a.a()).floatValue(), ((Number) this.f13791b.e()).floatValue());
        final float fO2 = RangesKt.o(((Number) this.f13791b.e()).floatValue(), ((Number) this.f13791b.a()).floatValue(), ((Number) this.f13790a.e()).floatValue());
        float fY = SliderKt.y(((Number) this.f13790a.a()).floatValue(), ((Number) this.f13790a.e()).floatValue(), fO);
        float fY2 = SliderKt.y(((Number) this.f13790a.a()).floatValue(), ((Number) this.f13790a.e()).floatValue(), fO2);
        int iFloor = (int) Math.floor(this.f13798j * fY2);
        int iFloor2 = (int) Math.floor(this.f13798j * (1.0f - fY));
        boolean z3 = this.f13797i;
        boolean Z4 = composer.Z(this.f13794f) | composer.c(fO2);
        final State state3 = this.f13794f;
        Object objG8 = composer.G();
        if (Z4 || objG8 == companion.a()) {
            objG8 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$startThumbSemantics$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(float f3) {
                    ((Function1) state3.getValue()).invoke(RangesKt.b(f3, fO2));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Number) obj).floatValue());
                    return Unit.f139807a;
                }
            };
            composer.w(objG8);
        }
        Modifier modifierD = SliderKt.D(companion2, fO, z3, (Function1) objG8, this.f13793d, RangesKt.b(((Number) this.f13790a.a()).floatValue(), fO2), iFloor);
        boolean z4 = this.f13797i;
        boolean Z5 = composer.Z(this.f13794f) | composer.c(fO);
        final State state4 = this.f13794f;
        Object objG9 = composer.G();
        if (Z5 || objG9 == companion.a()) {
            objG9 = new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSlider$2$endThumbSemantics$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(float f3) {
                    ((Function1) state4.getValue()).invoke(RangesKt.b(fO, f3));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Number) obj).floatValue());
                    return Unit.f139807a;
                }
            };
            composer.w(objG9);
        }
        SliderKt.c(this.f13797i, fY, fY2, this.f13792c, this.f13799k, floatRef2.f140141a - floatRef.f140141a, this.f13795g, this.f13796h, modifierA, modifierD, SliderKt.D(companion2, fO2, z4, (Function1) objG9, this.f13793d, RangesKt.b(fO, ((Number) this.f13790a.e()).floatValue()), iFloor2), composer, 14155776, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
