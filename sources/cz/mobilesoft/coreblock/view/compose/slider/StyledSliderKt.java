package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SliderColors;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StyledSliderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f132047a = Dp.g(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f132048b = Dp.g(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f132049c = Dp.g(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f132050d = Dp.g(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f132051e = Dp.g(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f132052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f132053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Modifier f132054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final TweenSpec f132055i;

    static {
        float fG = Dp.g(48);
        f132052f = fG;
        float fG2 = Dp.g(144);
        f132053g = fG2;
        f132054h = SizeKt.k(SizeKt.C(Modifier.b8, fG2, 0.0f, 2, null), 0.0f, fG, 1, null);
        f132055i = new TweenSpec(100, 0, null, 6, null);
    }

    private static final float A(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange closedFloatingPointRange, float f3) {
        return N(floatRef.f140141a, floatRef2.f140141a, f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(float f3, Function1 function1, Modifier modifier, boolean z2, ClosedFloatingPointRange closedFloatingPointRange, int i3, Function0 function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, Dp dp, Dp dp2, int i4, int i5, int i6, Composer composer, int i7) {
        v(f3, function1, modifier, z2, closedFloatingPointRange, i3, function0, mutableInteractionSource, sliderColors, dp, dp2, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    private static final void C(final Modifier modifier, final SliderColors sliderColors, final boolean z2, final float f3, final float f4, final List list, final float f5, final float f6, Composer composer, final int i3) {
        int i4;
        float f7;
        float f8;
        int i5;
        Composer composerK = composer.k(-1564954788);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(sliderColors) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            f7 = f4;
            i4 |= composerK.c(f7) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            f7 = f4;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(list) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            f8 = f5;
            i4 |= composerK.c(f8) ? 1048576 : 524288;
        } else {
            f8 = f5;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.c(f6) ? 8388608 : 4194304;
        }
        if (composerK.r((i4 & 4793491) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1564954788, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.Track (StyledSlider.kt:356)");
            }
            int i6 = ((i4 >> 6) & 14) | 48 | ((i4 << 3) & 896);
            final State stateA = sliderColors.a(z2, false, composerK, i6);
            final State stateA2 = sliderColors.a(z2, true, composerK, i6);
            final State stateB = sliderColors.b(z2, false, composerK, i6);
            final State stateB2 = sliderColors.b(z2, true, composerK, i6);
            boolean Z = ((29360128 & i4) == 8388608) | ((i4 & 3670016) == 1048576) | composerK.Z(stateA) | ((57344 & i4) == 16384) | ((i4 & 7168) == 2048) | composerK.Z(stateA2) | composerK.I(list) | composerK.Z(stateB) | composerK.Z(stateB2);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                i5 = i4;
                final float f9 = f8;
                final float f10 = f7;
                Object obj = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return StyledSliderKt.D(f9, stateA, f6, f10, f3, stateA2, list, stateB, stateB2, (DrawScope) obj2);
                    }
                };
                composerK.w(obj);
                objG = obj;
            } else {
                i5 = i4;
            }
            CanvasKt.b(modifier, (Function1) objG, composerK, i5 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StyledSliderKt.E(modifier, sliderColors, z2, f3, f4, list, f5, f6, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(float f3, State state, float f4, float f5, float f6, State state2, List list, State state3, State state4, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        boolean z2 = Canvas.getLayoutDirection() == LayoutDirection.f30002b;
        long jE = Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.V1() & 4294967295L)))) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32)) - f3;
        long jE2 = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.V1() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        long j3 = jE2;
        if (!z2) {
            jE2 = jE;
        }
        if (z2) {
            j3 = jE;
        }
        long jB = ((Color) state.getValue()).B();
        StrokeCap.Companion companion = StrokeCap.f25935b;
        DrawScope.L0(Canvas, jB, jE2, j3, f4, companion.b(), null, 0.0f, null, 0, 480, null);
        int i3 = (int) (jE2 >> 32);
        int i4 = (int) (j3 >> 32);
        long j4 = j3;
        long j5 = jE2;
        DrawScope.L0(Canvas, ((Color) state2.getValue()).B(), Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3) + ((Float.intBitsToFloat(i4) - Float.intBitsToFloat(i3)) * f6))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.V1() & 4294967295L)))) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3) + ((Float.intBitsToFloat(i4) - Float.intBitsToFloat(i3)) * f5))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.V1() & 4294967295L)))) & 4294967295L)), f4, companion.b(), null, 0.0f, null, 0, 480, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            float fFloatValue = ((Number) obj).floatValue();
            Boolean boolValueOf = Boolean.valueOf(fFloatValue > f5 || fFloatValue < f6);
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list2 = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(Offset.d(Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (OffsetKt.b(j5, j4, ((Number) it.next()).floatValue()) >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.V1() & 4294967295L)))) & 4294967295L))));
            }
            long j6 = j5;
            j4 = j4;
            DrawScope.E1(Canvas, arrayList2, PointMode.f25867b.b(), ((Color) (zBooleanValue ? state3 : state4).getValue()).B(), f4, StrokeCap.f25935b.b(), null, 0.0f, null, 0, 480, null);
            j5 = j6;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Modifier modifier, SliderColors sliderColors, boolean z2, float f3, float f4, List list, float f5, float f6, int i3, Composer composer, int i4) {
        C(modifier, sliderColors, z2, f3, f4, list, f5, f6, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object J(DraggableState draggableState, float f3, float f4, float f5, Continuation continuation) {
        Object objC = DraggableState.c(draggableState, null, new StyledSliderKt$animateToTarget$2(f3, f4, f5, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object K(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$awaitSlop$1 r0 = (cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$awaitSlop$1) r0
            int r1 = r0.f132084h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f132084h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$awaitSlop$1 r0 = new cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$awaitSlop$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f132083g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f132084h
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r6.f132080c
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r8 = r6.f132079b
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            java.lang.Object r9 = r6.f132078a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.b(r12)
            goto L6d
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            cz.mobilesoft.coreblock.view.compose.slider.k r5 = new cz.mobilesoft.coreblock.view.compose.slider.k
            r5.<init>()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r6.f132078a = r1
            r6.f132079b = r12
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r6.f132080c = r1
            r6.f132081d = r9
            r6.f132082f = r11
            r6.f132084h = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = cz.mobilesoft.coreblock.view.compose.slider.DragGestureDetectorCopyOfCopyKt.a(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L6a
            return r0
        L6a:
            r7 = r12
            r12 = r8
            r8 = r7
        L6d:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L7c
            float r8 = r8.f140141a
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.c(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.a(r12, r8)
            return r8
        L7c:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt.K(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Ref.FloatRef floatRef, PointerInputChange pointerInput, float f3) {
        Intrinsics.checkNotNullParameter(pointerInput, "pointerInput");
        pointerInput.a();
        floatRef.f140141a = f3;
        return Unit.f139807a;
    }

    private static final float M(float f3, float f4, float f5) {
        float f6 = f4 - f3;
        return RangesKt.o(f6 == 0.0f ? 0.0f : (f5 - f3) / f6, 0.0f, 1.0f);
    }

    private static final float N(float f3, float f4, float f5, float f6, float f7) {
        return MathHelpersKt.b(f6, f7, M(f3, f4, f5));
    }

    private static final Modifier O(Modifier modifier, float f3, final boolean z2, final Function1 function1, final Function0 function0, final ClosedFloatingPointRange closedFloatingPointRange, final int i3) {
        final float fO = RangesKt.o(f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
        return ProgressSemanticsKt.b(SemanticsModifierKt.f(modifier, false, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyledSliderKt.P(z2, closedFloatingPointRange, i3, fO, function1, function0, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null), f3, closedFloatingPointRange, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(boolean z2, final ClosedFloatingPointRange closedFloatingPointRange, final int i3, final float f3, final Function1 function1, final Function0 function0, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (!z2) {
            SemanticsPropertiesKt.l(semantics);
        }
        SemanticsPropertiesKt.p0(semantics, null, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StyledSliderKt.Q(closedFloatingPointRange, i3, f3, function1, function0, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q(ClosedFloatingPointRange closedFloatingPointRange, int i3, float f3, Function1 function1, Function0 function0, float f4) {
        int i4;
        float fO = RangesKt.o(f4, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
        if (i3 > 0 && (i4 = i3 + 1) >= 0) {
            float fAbs = fO;
            float f5 = fAbs;
            int i5 = 0;
            while (true) {
                float fB = MathHelpersKt.b(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), i5 / i4);
                float f6 = fB - fO;
                if (Math.abs(f6) <= fAbs) {
                    fAbs = Math.abs(f6);
                    f5 = fB;
                }
                if (i5 == i4) {
                    break;
                }
                i5++;
            }
            fO = f5;
        }
        if (fO == f3) {
            return false;
        }
        function1.invoke(Float.valueOf(fO));
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    private static final Modifier R(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f3, final boolean z2, final State state, final State state2, final MutableState mutableState, final boolean z3) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("sliderTapModifier");
                inspectorInfo.b().c("draggableState", draggableState);
                inspectorInfo.b().c("interactionSource", mutableInteractionSource);
                inspectorInfo.b().c("maxPx", Float.valueOf(f3));
                inspectorInfo.b().c("isRtl", Boolean.valueOf(z2));
                inspectorInfo.b().c("rawOffset", state);
                inspectorInfo.b().c("gestureEndAction", state2);
                inspectorInfo.b().c("pressOffset", mutableState);
                inspectorInfo.b().c("enabled", Boolean.valueOf(z3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.slider.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StyledSliderKt.S(z3, draggableState, mutableInteractionSource, f3, z2, mutableState, state, state2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier S(boolean z2, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f3, boolean z3, MutableState mutableState, State state, State state2, Modifier composed, Composer composer, int i3) {
        Modifier modifierH;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(-1668836076);
        if (ComposerKt.M()) {
            ComposerKt.U(-1668836076, i3, -1, "cz.mobilesoft.coreblock.view.compose.slider.sliderTapModifier.<anonymous> (StyledSlider.kt:524)");
        }
        if (z2) {
            composer.a0(-2049024899);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object[] objArr = {draggableState, mutableInteractionSource, Float.valueOf(f3), Boolean.valueOf(z3)};
            boolean zB = composer.b(z3) | composer.c(f3) | composer.Z(mutableState) | composer.Z(state) | composer.I(coroutineScope) | composer.I(draggableState) | composer.Z(state2);
            Object objG2 = composer.G();
            if (zB || objG2 == companion.a()) {
                objG2 = new StyledSliderKt$sliderTapModifier$2$1$1(z3, f3, mutableState, state, coroutineScope, draggableState, state2);
                composer.w(objG2);
            }
            modifierH = SuspendingPointerInputFilterKt.h(composed, objArr, (PointerInputEventHandler) objG2);
            composer.U();
        } else {
            composer.a0(-2047863670);
            composer.U();
            modifierH = composed;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierH;
    }

    private static final float T(float f3, List list, float f4, float f5) {
        Object obj;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(MathHelpersKt.b(f4, f5, ((Number) next).floatValue()) - f3);
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(MathHelpersKt.b(f4, f5, ((Number) next2).floatValue()) - f3);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Float f6 = (Float) obj;
        return f6 != null ? MathHelpersKt.b(f4, f5, f6.floatValue()) : f3;
    }

    private static final List U(int i3) {
        if (i3 == 0) {
            return CollectionsKt.emptyList();
        }
        int i4 = i3 + 2;
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(Float.valueOf(i5 / (i3 + 1)));
        }
        return arrayList;
    }

    private static final void o(final Function1 function1, final ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final MutableState mutableState, final float f3, Composer composer, final int i3) {
        int i4;
        float f4;
        int i5;
        Composer composerK = composer.k(-2111844222);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(closedFloatingPointRange2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            f4 = f3;
            i4 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            f4 = f3;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2111844222, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.CorrectValueSideEffect (StyledSlider.kt:455)");
            }
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4) | ((57344 & i4) == 16384) | ((i4 & 7168) == 2048) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                i5 = 0;
                final float f5 = f4;
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.slider.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StyledSliderKt.p(closedFloatingPointRange, function1, f5, mutableState, closedFloatingPointRange2);
                    }
                };
                composerK.w(function0);
                objG = function0;
            } else {
                i5 = 0;
            }
            EffectsKt.j((Function0) objG, composerK, i5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StyledSliderKt.q(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, float f3, MutableState mutableState, ClosedFloatingPointRange closedFloatingPointRange2) {
        float fFloatValue = (((Number) closedFloatingPointRange.e()).floatValue() - ((Number) closedFloatingPointRange.a()).floatValue()) / 1000;
        float fFloatValue2 = ((Number) function1.invoke(Float.valueOf(f3))).floatValue();
        if (Math.abs(fFloatValue2 - ((Number) mutableState.getValue()).floatValue()) > fFloatValue && closedFloatingPointRange2.b((Comparable) mutableState.getValue())) {
            mutableState.setValue(Float.valueOf(fFloatValue2));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, MutableState mutableState, float f3, int i3, Composer composer, int i4) {
        o(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void r(final boolean z2, final float f3, final List list, final SliderColors sliderColors, final float f4, final Dp dp, final Dp dp2, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        SliderColors sliderColors2;
        Composer composerK = composer.k(-380119525);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            sliderColors2 = sliderColors;
            i4 |= composerK.Z(sliderColors2) ? 2048 : 1024;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(dp) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(dp2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.Z(modifier) ? 67108864 : 33554432;
        }
        if (composerK.r((38347923 & i4) != 38347922, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-380119525, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.SliderImpl (StyledSlider.kt:269)");
            }
            Modifier modifierThen = modifier.then(f132054h);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            int i5 = i4;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float fL = dp2 != null ? dp2.l() : f132047a;
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            float fM1 = density.M1(dp != null ? dp.l() : f132051e);
            float fM12 = density.M1(fL);
            float fG = density.G(f4);
            float fG2 = Dp.g(fL * 2);
            float fG3 = Dp.g(fG * f3);
            Modifier.Companion companion2 = Modifier.b8;
            int i6 = i5 << 9;
            C(SizeKt.f(companion2, 0.0f, 1, null), sliderColors2, z2, 0.0f, f3, list, fM12, fM1, composerK, ((i5 >> 6) & 112) | 3078 | ((i5 << 6) & 896) | (i6 & 57344) | (i6 & 458752));
            t(boxScopeInstance, companion2, fG3, mutableInteractionSource, sliderColors, z2, fG2, composerK, ((i5 >> 12) & 7168) | 54 | ((i5 << 3) & 57344) | ((i5 << 15) & 458752));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StyledSliderKt.s(z2, f3, list, sliderColors, f4, dp, dp2, mutableInteractionSource, modifier, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(boolean z2, float f3, List list, SliderColors sliderColors, float f4, Dp dp, Dp dp2, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i3, Composer composer, int i4) {
        r(z2, f3, list, sliderColors, f4, dp, dp2, mutableInteractionSource, modifier, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void t(final BoxScope boxScope, final Modifier modifier, final float f3, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z2, final float f4, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(305293668);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(sliderColors) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.b(z2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.c(f4) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(305293668, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.SliderThumb (StyledSlider.kt:307)");
            }
            Modifier modifierM = PaddingKt.m(Modifier.b8, f3, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion = Alignment.f25072a;
            Modifier modifierF = boxScope.f(modifierM, companion.h());
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Object objG = composerK.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = SnapshotStateKt.f();
                composerK.w(objG);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
            boolean z3 = (i4 & 7168) == 2048;
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion3.a()) {
                objG2 = new StyledSliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerK.w(objG2);
            }
            int i5 = i4 >> 9;
            EffectsKt.g(mutableInteractionSource, (Function2) objG2, composerK, i5 & 14);
            float fG = !snapshotStateList.isEmpty() ? f132050d : f132049c;
            Modifier modifierB = HoverableKt.b(IndicationKt.b(SizeKt.x(modifier, f4, f4), mutableInteractionSource, RippleKt.c(false, f132048b, 0L, 4, null)), mutableInteractionSource, false, 2, null);
            if (!z2) {
                fG = Dp.g(0);
            }
            SpacerKt.a(BackgroundKt.c(ShadowKt.b(modifierB, fG, RoundedCornerShapeKt.g(), false, 0L, 0L, 24, null), ((Color) sliderColors.c(z2, composerK, ((i4 >> 15) & 14) | (i5 & 112)).getValue()).B(), RoundedCornerShapeKt.g()), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StyledSliderKt.u(boxScope, modifier, f3, mutableInteractionSource, sliderColors, z2, f4, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(BoxScope boxScope, Modifier modifier, float f3, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z2, float f4, int i3, Composer composer, int i4) {
        t(boxScope, modifier, f3, mutableInteractionSource, sliderColors, z2, f4, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v(final float r44, final kotlin.jvm.functions.Function1 r45, androidx.compose.ui.Modifier r46, boolean r47, kotlin.ranges.ClosedFloatingPointRange r48, int r49, kotlin.jvm.functions.Function0 r50, androidx.compose.foundation.interaction.MutableInteractionSource r51, androidx.compose.material.SliderColors r52, androidx.compose.ui.unit.Dp r53, androidx.compose.ui.unit.Dp r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instruction units count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt.v(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.ui.unit.Dp, androidx.compose.ui.unit.Dp, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(final ClosedFloatingPointRange closedFloatingPointRange, float f3, final List list, final Function0 function0, MutableInteractionSource mutableInteractionSource, boolean z2, SliderColors sliderColors, Dp dp, Dp dp2, float f4, final State state, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        Object sliderDraggableState;
        MutableState mutableState;
        Ref.FloatRef floatRef;
        Ref.FloatRef floatRef2;
        MutableState mutableState2;
        final MutableState mutableState3;
        final SliderDraggableState sliderDraggableState2;
        Ref.FloatRef floatRef3;
        Ref.FloatRef floatRef4;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-475679365, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.StyledSlider.<anonymous> (StyledSlider.kt:177)");
            }
            boolean z3 = composer.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
            float fL = Constraints.l(BoxWithConstraints.c());
            final Ref.FloatRef floatRef5 = new Ref.FloatRef();
            final Ref.FloatRef floatRef6 = new Ref.FloatRef();
            Density density = (Density) composer.q(CompositionLocalsKt.f());
            floatRef5.f140141a = Math.max(fL - density.M1(f4), 0.0f);
            floatRef6.f140141a = Math.min(density.M1(f4), floatRef5.f140141a);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Float.valueOf(z(closedFloatingPointRange, floatRef6, floatRef5, f3)), null, 2, null);
                composer.w(objG2);
            }
            final MutableState mutableState4 = (MutableState) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Float.valueOf(0.0f), null, 2, null);
                composer.w(objG3);
            }
            final MutableState mutableState5 = (MutableState) objG3;
            boolean zC = composer.c(floatRef6.f140141a) | composer.c(floatRef5.f140141a) | composer.Z(closedFloatingPointRange);
            Object objG4 = composer.G();
            if (zC || objG4 == companion.a()) {
                mutableState = mutableState5;
                floatRef = floatRef6;
                floatRef2 = floatRef5;
                mutableState2 = mutableState4;
                sliderDraggableState = new SliderDraggableState(new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StyledSliderKt.x(mutableState4, mutableState5, floatRef6, floatRef5, state, closedFloatingPointRange, ((Float) obj).floatValue());
                    }
                });
                composer.w(sliderDraggableState);
            } else {
                floatRef = floatRef6;
                mutableState = mutableState5;
                sliderDraggableState = objG4;
                floatRef2 = floatRef5;
                mutableState2 = mutableState4;
            }
            SliderDraggableState sliderDraggableState3 = (SliderDraggableState) sliderDraggableState;
            boolean Z = composer.Z(closedFloatingPointRange) | composer.c(floatRef.f140141a) | composer.c(floatRef2.f140141a);
            Object objG5 = composer.G();
            if (Z || objG5 == companion.a()) {
                objG5 = new StyledSliderKt$StyledSlider$3$2$1(closedFloatingPointRange, floatRef, floatRef2);
                composer.w(objG5);
            }
            o((Function1) ((KFunction) objG5), closedFloatingPointRange, RangesKt.b(floatRef.f140141a, floatRef2.f140141a), mutableState2, f3, composer, 3072);
            boolean zI = composer.I(list) | composer.c(floatRef.f140141a) | composer.c(floatRef2.f140141a) | composer.I(coroutineScope) | composer.I(sliderDraggableState3) | composer.Z(function0);
            Object objG6 = composer.G();
            if (zI || objG6 == companion.a()) {
                mutableState3 = mutableState2;
                sliderDraggableState2 = sliderDraggableState3;
                final Ref.FloatRef floatRef7 = floatRef2;
                final Ref.FloatRef floatRef8 = floatRef;
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StyledSliderKt.y(mutableState3, list, floatRef8, floatRef7, coroutineScope, sliderDraggableState2, function0, ((Float) obj).floatValue());
                    }
                };
                floatRef3 = floatRef8;
                floatRef4 = floatRef7;
                composer.w(objG6);
            } else {
                mutableState3 = mutableState2;
                sliderDraggableState2 = sliderDraggableState3;
                floatRef4 = floatRef2;
                floatRef3 = floatRef;
            }
            State stateP = SnapshotStateKt.p((Function1) objG6, composer, 0);
            Modifier.Companion companion2 = Modifier.b8;
            boolean z4 = z3;
            Modifier modifierR = R(companion2, sliderDraggableState2, mutableInteractionSource, fL, z4, mutableState3, stateP, mutableState, z2);
            Orientation orientation = Orientation.f6032b;
            boolean zH = sliderDraggableState2.h();
            boolean Z2 = composer.Z(stateP);
            Object objG7 = composer.G();
            if (Z2 || objG7 == companion.a()) {
                objG7 = new StyledSliderKt$StyledSlider$3$drag$1$1(stateP, null);
                composer.w(objG7);
            }
            r(z2, M(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), RangesKt.o(f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue())), list, sliderColors, floatRef4.f140141a - floatRef3.f140141a, dp, dp2, mutableInteractionSource, modifierR.then(DraggableKt.h(companion2, sliderDraggableState2, orientation, z2, mutableInteractionSource, zH, null, (Function3) objG7, z4, 32, null)), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableState mutableState, MutableState mutableState2, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State state, ClosedFloatingPointRange closedFloatingPointRange, float f3) {
        mutableState.setValue(Float.valueOf(((Number) mutableState.getValue()).floatValue() + f3 + ((Number) mutableState2.getValue()).floatValue()));
        mutableState2.setValue(Float.valueOf(0.0f));
        ((Function1) state.getValue()).invoke(Float.valueOf(A(floatRef, floatRef2, closedFloatingPointRange, RangesKt.o(((Number) mutableState.getValue()).floatValue(), floatRef.f140141a, floatRef2.f140141a))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MutableState mutableState, List list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, CoroutineScope coroutineScope, SliderDraggableState sliderDraggableState, Function0 function0, float f3) {
        float fFloatValue = ((Number) mutableState.getValue()).floatValue();
        float fT = T(fFloatValue, list, floatRef.f140141a, floatRef2.f140141a);
        if (fFloatValue != fT) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1(sliderDraggableState, fFloatValue, fT, f3, function0, null), 3, null);
        } else if (!sliderDraggableState.h() && function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float z(ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f3) {
        return N(((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue(), f3, floatRef.f140141a, floatRef2.f140141a);
    }
}
