package androidx.compose.material;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Strings;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
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
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SliderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f13770a = Dp.g(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f13771b = Dp.g(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f13772c = Dp.g(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f13773d = Dp.g(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f13774e = Dp.g(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f13775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f13776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Modifier f13777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final TweenSpec f13778i;

    static {
        float fG = Dp.g(48);
        f13775f = fG;
        float fG2 = Dp.g(144);
        f13776g = fG2;
        f13777h = SizeKt.k(SizeKt.C(Modifier.b8, fG2, 0.0f, 2, null), 0.0f, fG, 1, null);
        f13778i = new TweenSpec(100, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier A(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State state, State state2, boolean z2, boolean z3, float f3, ClosedFloatingPointRange closedFloatingPointRange, State state3, State state4) {
        return z2 ? modifier.then(new SuspendPointerInputElement(null, null, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f3), Boolean.valueOf(z3), closedFloatingPointRange}, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new SliderKt$rangeSliderPressDragModifier$1(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z3, f3, state3, null)), 3, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float B(float f3, float f4, float f5, float f6, float f7) {
        return MathHelpersKt.b(f6, f7, y(f3, f4, f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange C(float f3, float f4, ClosedFloatingPointRange closedFloatingPointRange, float f5, float f6) {
        return RangesKt.b(B(f3, f4, ((Number) closedFloatingPointRange.a()).floatValue(), f5, f6), B(f3, f4, ((Number) closedFloatingPointRange.e()).floatValue(), f5, f6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier D(Modifier modifier, float f3, final boolean z2, final Function1 function1, final Function0 function0, final ClosedFloatingPointRange closedFloatingPointRange, final int i3) {
        final float fO = RangesKt.o(f3, ((Number) closedFloatingPointRange.a()).floatValue(), ((Number) closedFloatingPointRange.e()).floatValue());
        return ProgressSemanticsKt.b(SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1
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
                if (!z2) {
                    SemanticsPropertiesKt.l(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange closedFloatingPointRange2 = closedFloatingPointRange;
                final int i4 = i3;
                final float f4 = fO;
                final Function1 function12 = function1;
                final Function0 function02 = function0;
                SemanticsPropertiesKt.p0(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material.SliderKt$sliderSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean c(float f5) {
                        int i5;
                        float fO2 = RangesKt.o(f5, ((Number) closedFloatingPointRange2.a()).floatValue(), ((Number) closedFloatingPointRange2.e()).floatValue());
                        int i6 = i4;
                        boolean z3 = false;
                        if (i6 > 0 && (i5 = i6 + 1) >= 0) {
                            float fAbs = fO2;
                            float f6 = fAbs;
                            int i7 = 0;
                            while (true) {
                                float fB = MathHelpersKt.b(((Number) closedFloatingPointRange2.a()).floatValue(), ((Number) closedFloatingPointRange2.e()).floatValue(), i7 / (i4 + 1));
                                float f7 = fB - fO2;
                                if (Math.abs(f7) <= fAbs) {
                                    fAbs = Math.abs(f7);
                                    f6 = fB;
                                }
                                if (i7 == i5) {
                                    break;
                                }
                                i7++;
                            }
                            fO2 = f6;
                        }
                        if (fO2 != f4) {
                            function12.invoke(Float.valueOf(fO2));
                            Function0 function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                            z3 = true;
                        }
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return c(((Number) obj).floatValue());
                    }
                }, 1, null);
            }
        }, 1, null), f3, closedFloatingPointRange, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier E(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f3, final boolean z2, final State state, final State state2, final MutableState mutableState, final boolean z3) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(1945228890);
                if (ComposerKt.M()) {
                    ComposerKt.U(1945228890, i3, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:915)");
                }
                if (z3) {
                    composer.a0(-398958937);
                    Object objG = composer.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer));
                        composer.w(compositionScopedCoroutineScopeCanceller);
                        objG = compositionScopedCoroutineScopeCanceller;
                    }
                    CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
                    Object[] objArr = {draggableState, mutableInteractionSource, Float.valueOf(f3), Boolean.valueOf(z2)};
                    boolean zB = composer.b(z2) | composer.c(f3) | composer.Z(mutableState) | composer.Z(state) | composer.I(coroutineScopeA) | composer.I(draggableState) | composer.Z(state2);
                    boolean z4 = z2;
                    float f4 = f3;
                    MutableState mutableState2 = mutableState;
                    State state3 = state;
                    DraggableState draggableState2 = draggableState;
                    State state4 = state2;
                    Object objG2 = composer.G();
                    if (zB || objG2 == companion.a()) {
                        Object sliderKt$sliderTapModifier$2$1$1 = new SliderKt$sliderTapModifier$2$1$1(z4, f4, mutableState2, state3, coroutineScopeA, draggableState2, state4, null);
                        composer.w(sliderKt$sliderTapModifier$2$1$1);
                        objG2 = sliderKt$sliderTapModifier$2$1$1;
                    }
                    modifier2 = modifier2.then(new SuspendPointerInputElement(null, null, objArr, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) objG2), 3, null));
                    composer.U();
                } else {
                    composer.a0(-397959404);
                    composer.U();
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifier2;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float F(float f3, List list, float f4, float f5) {
        Object obj;
        if (list.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = list.get(0);
            float fAbs = Math.abs(MathHelpersKt.b(f4, f5, ((Number) obj2).floatValue()) - f3);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj3 = list.get(i3);
                    float fAbs2 = Math.abs(MathHelpersKt.b(f4, f5, ((Number) obj3).floatValue()) - f3);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        obj2 = obj3;
                        fAbs = fAbs2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            obj = obj2;
        }
        Float f6 = (Float) obj;
        return f6 != null ? MathHelpersKt.b(f4, f5, f6.floatValue()) : f3;
    }

    private static final List G(int i3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final Function1 function1, final ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final MutableState mutableState, final float f3, Composer composer, final int i3) {
        int i4;
        float f4;
        Composer composerK = composer.k(-743965752);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(closedFloatingPointRange2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
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
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-743965752, i4, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:847)");
            }
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4) | ((57344 & i4) == 16384) | ((i4 & 7168) == 2048) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                final float f5 = f4;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m133invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m133invoke() {
                        float fFloatValue = (((Number) closedFloatingPointRange.e()).floatValue() - ((Number) closedFloatingPointRange.a()).floatValue()) / 1000;
                        float fFloatValue2 = ((Number) function1.invoke(Float.valueOf(f5))).floatValue();
                        if (Math.abs(fFloatValue2 - ((Number) mutableState.getValue()).floatValue()) <= fFloatValue || !closedFloatingPointRange2.b((Comparable) mutableState.getValue())) {
                            return;
                        }
                        mutableState.setValue(Float.valueOf(fFloatValue2));
                    }
                };
                composerK.w(function0);
                objG = function0;
            }
            EffectsKt.j((Function0) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    SliderKt.a(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.ranges.ClosedFloatingPointRange r39, final kotlin.jvm.functions.Function1 r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.ranges.ClosedFloatingPointRange r43, int r44, kotlin.jvm.functions.Function0 r45, androidx.compose.material.SliderColors r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.b(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final boolean z2, final float f3, final float f4, final List list, final SliderColors sliderColors, final float f5, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, Modifier modifier3, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        List list2;
        SliderColors sliderColors2;
        int i6;
        final Modifier modifier4;
        Composer composerK = composer.k(-278895713);
        if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            list2 = list;
            i5 |= composerK.I(list2) ? 2048 : 1024;
        } else {
            list2 = list;
        }
        if ((i3 & 24576) == 0) {
            sliderColors2 = sliderColors;
            i5 |= composerK.Z(sliderColors2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i3 & 196608) == 0) {
            i5 |= composerK.c(f5) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.Z(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.Z(mutableInteractionSource2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.Z(modifier) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(modifier2) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(modifier3) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i5 & 306783379) == 306783378 && (i6 & 3) == 2 && composerK.l()) {
            composerK.Q();
            modifier4 = modifier3;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-278895713, i5, i6, "androidx.compose.material.RangeSliderImpl (Slider.kt:633)");
            }
            Strings.Companion companion = Strings.f14174b;
            final String strA = Strings_androidKt.a(companion.g(), composerK, 6);
            final String strA2 = Strings_androidKt.a(companion.f(), composerK, 6);
            Modifier modifierThen = modifier.then(f13777h);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            float fM1 = density.M1(f13774e);
            float f6 = f13770a;
            float fM12 = density.M1(f6);
            float fG = density.G(f5);
            float fG2 = Dp.g(f6 * 2);
            float fG3 = Dp.g(fG * f3);
            float fG4 = Dp.g(fG * f4);
            Modifier.Companion companion4 = Modifier.b8;
            Modifier modifierF2 = SizeKt.f(boxScopeInstance.f(companion4, companion2.h()), 0.0f, 1, null);
            int i7 = i5 >> 9;
            int i8 = i5 << 6;
            int i9 = i5;
            g(modifierF2, sliderColors2, z3, f3, f4, list2, fM12, fM1, composerK, (i8 & 896) | (i7 & 112) | (i8 & 7168) | (i8 & 57344) | (i8 & 458752));
            composerK = composerK;
            boolean Z = composerK.Z(strA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$2$1
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
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA);
                    }
                };
                composerK.w(objG);
            }
            int i10 = i9 & 57344;
            int i11 = (i9 << 15) & 458752;
            f(boxScopeInstance, FocusableKt.a(SemanticsModifierKt.e(companion4, true, (Function1) objG), true, mutableInteractionSource).then(modifier2), fG3, mutableInteractionSource, sliderColors, z2, fG2, composerK, (i7 & 7168) | 1572870 | i10 | i11);
            boolean Z2 = composerK.Z(strA2);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$1$3$1
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
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA2);
                    }
                };
                composerK.w(objG2);
            }
            modifier4 = modifier3;
            f(boxScopeInstance, FocusableKt.a(SemanticsModifierKt.e(companion4, true, (Function1) objG2), true, mutableInteractionSource2).then(modifier4), fG4, mutableInteractionSource2, sliderColors, z2, fG2, composerK, ((i9 >> 12) & 7168) | 1572870 | i10 | i11);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$RangeSliderImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i12) {
                    SliderKt.c(z2, f3, f4, list, sliderColors, f5, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier4, composer2, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final float r40, final kotlin.jvm.functions.Function1 r41, androidx.compose.ui.Modifier r42, boolean r43, kotlin.ranges.ClosedFloatingPointRange r44, int r45, kotlin.jvm.functions.Function0 r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.material.SliderColors r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.d(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final BoxScope boxScope, final Modifier modifier, final float f3, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z2, final float f4, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(428907178);
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
        if ((599187 & i4) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(428907178, i4, -1, "androidx.compose.material.SliderThumb (Slider.kt:696)");
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
                objG2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerK.w(objG2);
            }
            int i5 = i4 >> 9;
            EffectsKt.g(mutableInteractionSource, (Function2) objG2, composerK, i5 & 14);
            SpacerKt.a(BackgroundKt.c(ShadowKt.b(HoverableKt.b(IndicationKt.b(SizeKt.x(modifier, f4, f4), mutableInteractionSource, RippleKt.f(false, f13771b, 0L, composerK, 54, 4)), mutableInteractionSource, false, 2, null), z2 ? !snapshotStateList.isEmpty() ? f13773d : f13772c : Dp.g(0), RoundedCornerShapeKt.g(), false, 0L, 0L, 24, null), ((Color) sliderColors.c(z2, composerK, ((i4 >> 15) & 14) | (i5 & 112)).getValue()).B(), RoundedCornerShapeKt.g()), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    SliderKt.f(boxScope, modifier, f3, mutableInteractionSource, sliderColors, z2, f4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final Modifier modifier, final SliderColors sliderColors, final boolean z2, final float f3, final float f4, final List list, final float f5, final float f6, Composer composer, final int i3) {
        int i4;
        float f7;
        float f8;
        int i5;
        Composer composerK = composer.k(1833126050);
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
        if ((i4 & 4793491) == 4793490 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1833126050, i4, -1, "androidx.compose.material.Track (Slider.kt:747)");
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
                Object obj = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DrawScope) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        boolean z3 = drawScope.getLayoutDirection() == LayoutDirection.f30002b;
                        long jA = OffsetKt.a(f9, Offset.n(drawScope.V1()));
                        long jA2 = OffsetKt.a(Size.i(drawScope.b()) - f9, Offset.n(drawScope.V1()));
                        long j3 = z3 ? jA2 : jA;
                        long j4 = z3 ? jA : jA2;
                        long jB = ((Color) stateA.getValue()).B();
                        float f11 = f6;
                        StrokeCap.Companion companion = StrokeCap.f25935b;
                        DrawScope.L0(drawScope, jB, j3, j4, f11, companion.b(), null, 0.0f, null, 0, 480, null);
                        DrawScope.L0(drawScope, ((Color) stateA2.getValue()).B(), OffsetKt.a(Offset.m(j3) + ((Offset.m(j4) - Offset.m(j3)) * f3), Offset.n(drawScope.V1())), OffsetKt.a(Offset.m(j3) + ((Offset.m(j4) - Offset.m(j3)) * f10), Offset.n(drawScope.V1())), f6, companion.b(), null, 0.0f, null, 0, 480, null);
                        List list2 = list;
                        float f12 = f10;
                        float f13 = f3;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Object obj2 : list2) {
                            float fFloatValue = ((Number) obj2).floatValue();
                            Boolean boolValueOf = Boolean.valueOf(fFloatValue > f12 || fFloatValue < f13);
                            Object arrayList = linkedHashMap.get(boolValueOf);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                linkedHashMap.put(boolValueOf, arrayList);
                            }
                            ((List) arrayList).add(obj2);
                        }
                        State state = stateB;
                        State state2 = stateB2;
                        float f14 = f6;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                            List list3 = (List) entry.getValue();
                            ArrayList arrayList2 = new ArrayList(list3.size());
                            int size = list3.size();
                            for (int i7 = 0; i7 < size; i7++) {
                                arrayList2.add(Offset.d(OffsetKt.a(Offset.m(OffsetKt.b(j3, j4, ((Number) list3.get(i7)).floatValue())), Offset.n(drawScope.V1()))));
                            }
                            DrawScope.E1(drawScope, arrayList2, PointMode.f25867b.b(), ((Color) (zBooleanValue ? state : state2).getValue()).B(), f14, StrokeCap.f25935b.b(), null, 0.0f, null, 0, 480, null);
                        }
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
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Track$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SliderKt.g(modifier, sliderColors, z2, f3, f4, list, f5, f6, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object w(DraggableState draggableState, float f3, float f4, float f5, Continuation continuation) {
        Object objC = DraggableState.c(draggableState, null, new SliderKt$animateToTarget$2(f3, f4, f5, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object x(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.f13960c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f13960c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f13959b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f13960c
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.f13958a
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.b(r12)
            goto L55
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>()
            r6.f13958a = r12
            r6.f13960c = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material.DragGestureDetectorCopyKt.a(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L52
            return r0
        L52:
            r7 = r12
            r12 = r8
            r8 = r7
        L55:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L64
            float r8 = r8.f140141a
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.c(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.a(r12, r8)
            return r8
        L64:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.x(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float y(float f3, float f4, float f5) {
        float f6 = f4 - f3;
        float f7 = f6 == 0.0f ? 0.0f : (f5 - f3) / f6;
        float f8 = f7 >= 0.0f ? f7 : 0.0f;
        if (f8 > 1.0f) {
            return 1.0f;
        }
        return f8;
    }

    public static final float z() {
        return f13770a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final boolean z2, final float f3, final List list, final SliderColors sliderColors, final float f4, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        List list2;
        Composer composerK = composer.k(1679682785);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            list2 = list;
            i4 |= composerK.I(list2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            list2 = list;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(sliderColors) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(modifier) ? 1048576 : 524288;
        }
        int i5 = i4;
        if ((599187 & i5) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1679682785, i5, -1, vxrlPPpdv.fxemXOv);
            }
            Modifier modifierThen = modifier.then(f13777h);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
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
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            float fM1 = density.M1(f13774e);
            float f5 = f13770a;
            float fM12 = density.M1(f5);
            float fG = density.G(f4);
            float fG2 = Dp.g(f5 * 2);
            float fG3 = Dp.g(fG * f3);
            Modifier.Companion companion2 = Modifier.b8;
            int i6 = i5 >> 6;
            int i7 = i5 << 9;
            g(SizeKt.f(companion2, 0.0f, 1, null), sliderColors, z2, 0.0f, f3, list2, fM12, fM1, composerK, (i7 & 458752) | (i6 & 112) | 3078 | ((i5 << 6) & 896) | (i7 & 57344));
            f(boxScopeInstance, companion2, fG3, mutableInteractionSource, sliderColors, z2, fG2, composerK, (i6 & 7168) | 1572918 | ((i5 << 3) & 57344) | ((i5 << 15) & 458752));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    SliderKt.e(z2, f3, list, sliderColors, f4, mutableInteractionSource, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
