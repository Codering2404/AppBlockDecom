package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TimePickerSelectionMode;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
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
public final class TimePickerKt {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f21170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f21171e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f21173g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final IntList f21177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final IntList f21178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f21179m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f21167a = Dp.g(101);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f21168b = Dp.g(69);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f21169c = Dp.g(36);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f21172f = Dp.g(7);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f21174h = Dp.g(74);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f21175i = Dp.g(48);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final IntList f21176j = IntListKt.d(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    static {
        float f3 = 24;
        f21170d = Dp.g(f3);
        f21171e = Dp.g(f3);
        f21173g = Dp.g(f3);
        IntList intListD = IntListKt.d(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        f21177k = intListD;
        MutableIntList mutableIntList = new MutableIntList(intListD.f());
        int[] iArr = intListD.f2876a;
        int i3 = intListD.f2877b;
        for (int i4 = 0; i4 < i3; i4++) {
            mutableIntList.l((iArr[i4] % 12) + 12);
        }
        f21178l = mutableIntList;
        f21179m = Dp.g(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A(final androidx.compose.material3.AnalogTimePickerState r9, androidx.compose.ui.Modifier r10, androidx.compose.material3.TimePickerColors r11, final boolean r12, androidx.compose.runtime.Composer r13, final int r14, final int r15) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.A(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Modifier modifier, final float f3, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(1548175696);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1548175696, i5, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1870)");
            }
            boolean z2 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, final long j3) {
                        Object obj;
                        Object obj2;
                        final float fM1 = measureScope.M1(f3);
                        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int i7 = 0;
                        for (int i8 = 0; i8 < size; i8++) {
                            Object obj3 = list.get(i8);
                            Measurable measurable = (Measurable) obj3;
                            if (LayoutIdKt.a(measurable) != LayoutId.Selector && LayoutIdKt.a(measurable) != LayoutId.InnerCircle) {
                                arrayList.add(obj3);
                            }
                        }
                        final ArrayList arrayList2 = new ArrayList(arrayList.size());
                        int size2 = arrayList.size();
                        for (int i9 = 0; i9 < size2; i9++) {
                            arrayList2.add(((Measurable) arrayList.get(i9)).n0(jD));
                        }
                        int size3 = list.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size3) {
                                obj = null;
                                break;
                            }
                            obj = list.get(i10);
                            if (LayoutIdKt.a((Measurable) obj) == LayoutId.Selector) {
                                break;
                            }
                            i10++;
                        }
                        Measurable measurable2 = (Measurable) obj;
                        int size4 = list.size();
                        while (true) {
                            if (i7 >= size4) {
                                obj2 = null;
                                break;
                            }
                            obj2 = list.get(i7);
                            if (LayoutIdKt.a((Measurable) obj2) == LayoutId.InnerCircle) {
                                break;
                            }
                            i7++;
                        }
                        Measurable measurable3 = (Measurable) obj2;
                        final float size5 = 6.2831855f / arrayList2.size();
                        Placeable placeableN0 = measurable2 != null ? measurable2.n0(jD) : null;
                        final Placeable placeableN02 = measurable3 != null ? measurable3.n0(jD) : null;
                        final Placeable placeable = placeableN0;
                        return MeasureScope.B0(measureScope, Constraints.n(j3), Constraints.m(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                                invoke((Placeable.PlacementScope) obj4);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable placeable2 = placeable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.i(placementScope, placeable2, 0, 0, 0.0f, 4, null);
                                }
                                List list2 = arrayList2;
                                long j4 = j3;
                                float f4 = fM1;
                                float f5 = size5;
                                int size6 = list2.size();
                                int i11 = 0;
                                while (i11 < size6) {
                                    Placeable placeable3 = (Placeable) list2.get(i11);
                                    double d3 = f4;
                                    double d4 = ((double) (i11 * f5)) - 1.5707963267948966d;
                                    Placeable.PlacementScope.i(placementScope, placeable3, MathKt.c((Math.cos(d4) * d3) + ((double) ((Constraints.l(j4) / 2) - (placeable3.X0() / 2)))), MathKt.c((d3 * Math.sin(d4)) + ((double) ((Constraints.k(j4) / 2) - (placeable3.O0() / 2)))), 0.0f, 4, null);
                                    i11++;
                                    list2 = list2;
                                    j4 = j4;
                                }
                                Placeable placeable4 = placeableN02;
                                if (placeable4 != null) {
                                    Placeable.PlacementScope.i(placementScope, placeable4, (Constraints.n(j3) - placeableN02.X0()) / 2, (Constraints.m(j3) - placeableN02.O0()) / 2, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            int i7 = ((i5 >> 6) & 14) | ((i5 << 3) & 112);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            int i8 = ((i7 << 6) & 896) | 6;
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
            Updater.e(composerA, measurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            function2.invoke(composerK, Integer.valueOf((i8 >> 6) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    TimePickerKt.a(modifier2, f3, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-934561141);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-934561141, i4, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1126)");
            }
            CompositionLocalKt.c(new ProvidedValue[]{TextKt.f().d(TypographyKt.c(TimePickerTokens.f23541a.x(), composerK, 6)), CompositionLocalsKt.m().d(LayoutDirection.f30001a)}, ComposableLambdaKt.e(-477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$1
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
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-477913269, i5, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:1132)");
                    }
                    TimePickerState timePickerState2 = timePickerState;
                    TimePickerColors timePickerColors2 = timePickerColors;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, measurePolicyB, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
                    Modifier modifierX = SizeKt.x(companion, timePickerTokens.w(), timePickerTokens.u());
                    int iK0 = TimePickerKt.k0(timePickerState2);
                    TimePickerSelectionMode.Companion companion3 = TimePickerSelectionMode.f21378b;
                    TimePickerKt.w(modifierX, iK0, timePickerState2, companion3.a(), timePickerColors2, composer2, 3078);
                    TimePickerKt.i(SizeKt.x(companion, TimePickerKt.f21171e, timePickerTokens.s()), composer2, 6);
                    TimePickerKt.w(SizeKt.x(companion, timePickerTokens.w(), timePickerTokens.u()), timePickerState2.f(), timePickerState2, companion3.b(), timePickerColors2, composer2, 3078);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$2
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
                    TimePickerKt.b(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void c(final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1170157036);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(analogTimePickerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1170157036, i4, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1512)");
            }
            CrossfadeKt.b(analogTimePickerState.u(), j0(SizeKt.v(BackgroundKt.c(Modifier.b8, timePickerColors.b(), RoundedCornerShapeKt.g()).then(new ClockDialModifier(analogTimePickerState, z2, analogTimePickerState.c(), null)), TimePickerTokens.f23541a.b()), analogTimePickerState, timePickerColors), AnimationSpecKt.n(200, 0, null, 6, null), null, ComposableLambdaKt.e(-1022006568, true, new Function3<IntList, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final void c(final IntList intList, Composer composer2, int i5) {
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1022006568, i5, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1522)");
                    }
                    Modifier modifierF = SemanticsModifierKt.f(SizeKt.v(Modifier.b8, TimePickerTokens.f23541a.b()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.Z(semanticsPropertyReceiver);
                        }
                    }, 1, null);
                    float f3 = TimePickerKt.f21167a;
                    final TimePickerColors timePickerColors2 = timePickerColors;
                    final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                    final boolean z3 = z2;
                    TimePickerKt.a(modifierF, f3, ComposableLambdaKt.e(-320307952, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i6) {
                            if ((i6 & 3) == 2 && composer3.l()) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-320307952, i6, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1526)");
                            }
                            ProvidedValue providedValueD = ContentColorKt.a().d(Color.n(timePickerColors2.a(false)));
                            final IntList intList2 = intList;
                            final AnalogTimePickerState analogTimePickerState3 = analogTimePickerState2;
                            final boolean z4 = z3;
                            CompositionLocalKt.b(providedValueD, ComposableLambdaKt.e(1992872400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.f139807a;
                                }

                                public final void invoke(Composer composer4, int i7) {
                                    if ((i7 & 3) == 2 && composer4.l()) {
                                        composer4.Q();
                                        return;
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.U(1992872400, i7, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1529)");
                                    }
                                    composer4.a0(1547046870);
                                    int iF = intList2.f();
                                    AnalogTimePickerState analogTimePickerState4 = analogTimePickerState3;
                                    IntList intList3 = intList2;
                                    boolean z5 = z4;
                                    for (final int i8 = 0; i8 < iF; i8++) {
                                        int iE = (!analogTimePickerState4.g() || TimePickerSelectionMode.f(analogTimePickerState4.c(), TimePickerSelectionMode.f21378b.b())) ? intList3.e(i8) : intList3.e(i8) % 12;
                                        Modifier.Companion companion = Modifier.b8;
                                        boolean zE = composer4.e(i8);
                                        Object objG = composer4.G();
                                        if (zE || objG == Composer.f23746a.a()) {
                                            objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$1$1$1
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
                                                    SemanticsPropertiesKt.H0(semanticsPropertyReceiver, i8);
                                                }
                                            };
                                            composer4.w(objG);
                                        }
                                        boolean z6 = z5;
                                        TimePickerKt.d(SemanticsModifierKt.f(companion, false, (Function1) objG, 1, null), analogTimePickerState4, iE, z6, composer4, 0);
                                        z5 = z6;
                                    }
                                    composer4.U();
                                    if (TimePickerSelectionMode.f(analogTimePickerState3.c(), TimePickerSelectionMode.f21378b.a()) && analogTimePickerState3.g()) {
                                        Modifier modifierC = BackgroundKt.c(SizeKt.v(LayoutIdKt.b(Modifier.b8, LayoutId.InnerCircle), TimePickerTokens.f23541a.b()), Color.f25715b.j(), RoundedCornerShapeKt.g());
                                        float f4 = TimePickerKt.f21168b;
                                        final AnalogTimePickerState analogTimePickerState5 = analogTimePickerState3;
                                        final boolean z7 = z4;
                                        TimePickerKt.a(modifierC, f4, ComposableLambdaKt.e(-205464413, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Composer composer5, int i9) {
                                                if ((i9 & 3) == 2 && composer5.l()) {
                                                    composer5.Q();
                                                    return;
                                                }
                                                if (ComposerKt.M()) {
                                                    ComposerKt.U(-205464413, i9, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1552)");
                                                }
                                                int iF2 = TimePickerKt.f21178l.f();
                                                AnalogTimePickerState analogTimePickerState6 = analogTimePickerState5;
                                                boolean z8 = z7;
                                                for (final int i10 = 0; i10 < iF2; i10++) {
                                                    int iE2 = TimePickerKt.f21178l.e(i10);
                                                    Modifier.Companion companion2 = Modifier.b8;
                                                    boolean zE2 = composer5.e(i10);
                                                    Object objG2 = composer5.G();
                                                    if (zE2 || objG2 == Composer.f23746a.a()) {
                                                        objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2$1$1$1
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
                                                                SemanticsPropertiesKt.H0(semanticsPropertyReceiver, 12 + i10);
                                                            }
                                                        };
                                                        composer5.w(objG2);
                                                    }
                                                    TimePickerKt.d(SemanticsModifierKt.f(companion2, false, (Function1) objG2, 1, null), analogTimePickerState6, iE2, z8, composer5, 0);
                                                }
                                                if (ComposerKt.M()) {
                                                    ComposerKt.T();
                                                }
                                            }
                                        }, composer4, 54), composer4, 432, 0);
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.T();
                                    }
                                }
                            }, composer3, 54), composer3, ProvidedValue.f24012i | 48);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), composer2, 432, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    c((IntList) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composerK, 24960, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$2
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
                    TimePickerKt.c(analogTimePickerState, timePickerColors, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    public static final void d(final Modifier modifier, final AnalogTimePickerState analogTimePickerState, final int i3, final boolean z2, Composer composer, final int i4) {
        int i5;
        Modifier modifier2;
        boolean z3;
        ?? r15;
        Alignment alignment;
        Composer composer2;
        Composer composerK = composer.k(-206784607);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(analogTimePickerState) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-206784607, i5, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1638)");
            }
            TextStyle textStyleC = TypographyKt.c(TimePickerTokens.f23541a.c(), composerK, 6);
            final float fM1 = ((Density) composerK.q(CompositionLocalsKt.f())).M1(f21174h);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Offset.d(Offset.f25596b.c()), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(IntOffset.c(IntOffset.f29988b.b()), null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composerK));
                composerK.w(compositionScopedCoroutineScopeCanceller);
                objG3 = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG3).a();
            final String strN0 = n0(analogTimePickerState.c(), analogTimePickerState.g(), i3, composerK, i5 & 896);
            String strC = CalendarLocale_jvmKt.c(i3, 0, 0, false, 7, null);
            boolean zAreEqual = TimePickerSelectionMode.f(analogTimePickerState.c(), TimePickerSelectionMode.f21378b.b()) ? Intrinsics.areEqual(CalendarLocale_jvmKt.c(analogTimePickerState.f(), 0, 0, false, 7, null), strC) : Intrinsics.areEqual(CalendarLocale_jvmKt.c(analogTimePickerState.h(), 0, 0, false, 7, null), strC);
            Alignment alignmentE = Alignment.f25072a.e();
            Modifier modifierV = SizeKt.v(InteractiveComponentSizeKt.b(modifier), f21175i);
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((LayoutCoordinates) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                        MutableState mutableState3 = mutableState2;
                        LayoutCoordinates layoutCoordinatesT = layoutCoordinates.T();
                        TimePickerKt.h(mutableState3, layoutCoordinatesT != null ? IntSizeKt.b(layoutCoordinatesT.a()) : IntOffset.f29988b.b());
                        TimePickerKt.f(mutableState, LayoutCoordinatesKt.a(layoutCoordinates).m());
                    }
                };
                composerK.w(objG4);
            }
            Modifier modifierB = FocusableKt.b(OnGloballyPositionedModifierKt.a(modifierV, (Function1) objG4), false, null, 3, null);
            boolean zI = ((i5 & 7168) == 2048) | composerK.I(coroutineScopeA) | composerK.I(analogTimePickerState) | composerK.c(fM1) | composerK.b(zAreEqual);
            Object objG5 = composerK.G();
            if (zI || objG5 == companion.a()) {
                modifier2 = modifierB;
                final boolean z4 = zAreEqual;
                z3 = true;
                r15 = 0;
                alignment = alignmentE;
                Function1<SemanticsPropertyReceiver, Unit> function1 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1
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
                        final CoroutineScope coroutineScope = coroutineScopeA;
                        final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                        final float f3 = fM1;
                        final boolean z5 = z2;
                        final MutableState mutableState3 = mutableState;
                        final MutableState mutableState4 = mutableState2;
                        SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1.1

                            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1", f = "TimePicker.kt", l = {1674}, m = "invokeSuspend")
                            static final class C00641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                int f21231a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                final /* synthetic */ AnalogTimePickerState f21232b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ float f21233c;

                                /* JADX INFO: renamed from: d, reason: collision with root package name */
                                final /* synthetic */ boolean f21234d;

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                final /* synthetic */ MutableState f21235f;

                                /* JADX INFO: renamed from: g, reason: collision with root package name */
                                final /* synthetic */ MutableState f21236g;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00641(AnalogTimePickerState analogTimePickerState, float f3, boolean z2, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
                                    super(2, continuation);
                                    this.f21232b = analogTimePickerState;
                                    this.f21233c = f3;
                                    this.f21234d = z2;
                                    this.f21235f = mutableState;
                                    this.f21236g = mutableState2;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new C00641(this.f21232b, this.f21233c, this.f21234d, this.f21235f, this.f21236g, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f21231a;
                                    if (i3 == 0) {
                                        ResultKt.b(obj);
                                        AnalogTimePickerState analogTimePickerState = this.f21232b;
                                        float fM = Offset.m(TimePickerKt.e(this.f21235f));
                                        float fN = Offset.n(TimePickerKt.e(this.f21235f));
                                        float f3 = this.f21233c;
                                        boolean z2 = this.f21234d;
                                        long jG = TimePickerKt.g(this.f21236g);
                                        this.f21231a = 1;
                                        if (TimePickerKt.o0(analogTimePickerState, fM, fN, f3, z2, jG, this) == objF) {
                                            return objF;
                                        }
                                    } else {
                                        if (i3 != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.b(obj);
                                    }
                                    return Unit.f139807a;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((C00641) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C00641(analogTimePickerState2, f3, z5, mutableState3, mutableState4, null), 3, null);
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        SemanticsPropertiesKt.s0(semanticsPropertyReceiver, z4);
                    }
                };
                composerK.w(function1);
                objG5 = function1;
            } else {
                modifier2 = modifierB;
                r15 = 0;
                alignment = alignmentE;
                z3 = true;
            }
            Modifier modifierE = SemanticsModifierKt.e(modifier2, z3, (Function1) objG5);
            MeasurePolicy measurePolicyG = BoxKt.g(alignment, r15);
            int iA = ComposablesKt.a(composerK, r15);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierE);
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
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier.Companion companion3 = Modifier.b8;
            boolean Z = composerK.Z(strN0);
            Object objG6 = composerK.G();
            if (Z || objG6 == companion.a()) {
                objG6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
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
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strN0);
                    }
                };
                composerK.w(objG6);
            }
            composer2 = composerK;
            TextKt.c(strC, SemanticsModifierKt.c(companion3, (Function1) objG6), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleC, composer2, 0, 0, 65532);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    TimePickerKt.d(modifier, analogTimePickerState, i3, z2, composer3, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(MutableState mutableState) {
        return ((Offset) mutableState.getValue()).u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MutableState mutableState, long j3) {
        mutableState.setValue(Offset.d(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(MutableState mutableState) {
        return ((IntOffset) mutableState.getValue()).r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState mutableState, long j3) {
        mutableState.setValue(IntOffset.c(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h0(float f3, float f4) {
        float fAtan2 = ((float) Math.atan2(f3, f4)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + 6.2831855f : fAtan2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(2100674302);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2100674302, i4, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1324)");
            }
            TextStyle textStyleE = TextStyle.e((TextStyle) composerK.q(TextKt.f()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.f29616b.a(), 0, 0L, null, null, new LineHeightStyle(LineHeightStyle.Alignment.f29596b.a(), LineHeightStyle.Trim.f29606b.a(), (DefaultConstructorMarker) null), 0, 0, null, 15695871, null);
            Modifier modifierC = SemanticsModifierKt.c(modifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$DisplaySeparator$1
                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }
            });
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            composer2 = composerK;
            TextKt.c(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, ColorSchemeKt.i(TimeInputTokens.f23515a.g(), composerK, 6), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleE, composer2, 6, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$DisplaySeparator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    TimePickerKt.i(modifier, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final float i0(float f3, float f4, int i3, int i4) {
        return (float) Math.hypot(i3 - f3, i4 - f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(755539561);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(755539561, i4, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1086)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, companion2.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            b(timePickerState, timePickerColors, composerK, i4 & 126);
            composerK.a0(919638492);
            if (!timePickerState.g()) {
                Modifier modifierM = PaddingKt.m(companion, 0.0f, f21179m, 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A2 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
                int i5 = i4 << 3;
                k(SizeKt.x(companion, timePickerTokens.m(), timePickerTokens.l()), timePickerState, timePickerColors, composerK, (i5 & 896) | (i5 & 112) | 6);
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalClockDisplay$2
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
                    TimePickerKt.j(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final Modifier j0(Modifier modifier, final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.d(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$drawSelector$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                long jA = OffsetKt.a(contentDrawScope.M1(DpOffset.f(TimePickerKt.l0(analogTimePickerState))), contentDrawScope.M1(DpOffset.g(TimePickerKt.l0(analogTimePickerState))));
                TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
                float f3 = 2;
                float fM1 = contentDrawScope.M1(timePickerTokens.g()) / f3;
                long jD = timePickerColors.d();
                long jA2 = Color.f25715b.a();
                BlendMode.Companion companion = BlendMode.f25667b;
                DrawScope.e2(contentDrawScope, jA2, fM1, jA, 0.0f, null, null, companion.a(), 56, null);
                contentDrawScope.i2();
                DrawScope.e2(contentDrawScope, jD, fM1, jA, 0.0f, null, null, companion.C(), 56, null);
                DrawScope.L0(contentDrawScope, jD, androidx.compose.ui.geometry.SizeKt.b(contentDrawScope.b()), Offset.p(jA, OffsetKt.a(((float) Math.cos(analogTimePickerState.v())) * fM1, ((float) Math.sin(analogTimePickerState.v())) * fM1)), contentDrawScope.M1(timePickerTokens.h()), 0, null, 0.0f, null, companion.B(), 240, null);
                DrawScope.e2(contentDrawScope, jD, contentDrawScope.M1(timePickerTokens.e()) / f3, androidx.compose.ui.geometry.SizeKt.b(contentDrawScope.b()), 0.0f, null, null, 0, 120, null);
                DrawScope.e2(contentDrawScope, timePickerColors.a(true), fM1, jA, 0.0f, null, null, companion.k(), 56, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerK = composer.k(1261215927);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(timePickerColors) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1261215927, i4, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1159)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Measurable measurable = (Measurable) list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "Spacer")) {
                                final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, measureScope.z0(TimePickerTokens.f23541a.o()), 0, 0, 12, null));
                                ArrayList arrayList = new ArrayList(list.size());
                                int size2 = list.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Object obj = list.get(i6);
                                    if (!Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                final ArrayList arrayList2 = new ArrayList(arrayList.size());
                                int size3 = arrayList.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    arrayList2.add(((Measurable) arrayList.get(i7)).n0(Constraints.d(j3, 0, Constraints.l(j3) / 2, 0, 0, 12, null)));
                                }
                                return MeasureScope.B0(measureScope, Constraints.l(j3), Constraints.k(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((Placeable.PlacementScope) obj2);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.i(placementScope, (Placeable) arrayList2.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.i(placementScope, (Placeable) arrayList2.get(1), ((Placeable) arrayList2.get(0)).X0(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.i(placementScope, placeableN0, ((Placeable) arrayList2.get(0)).X0() - (placeableN0.X0() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            Shape shapeE = ShapesKt.e(TimePickerTokens.f23541a.k(), composerK, 6);
            Intrinsics.checkNotNull(shapeE, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shapeE;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            m(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.f(cornerBasedShape), ShapesKt.b(cornerBasedShape), composerK, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$1
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
                    TimePickerKt.k(modifier2, timePickerState2, timePickerColors2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final int k0(TimePickerState timePickerState) {
        if (timePickerState.g()) {
            return timePickerState.h() % 24;
        }
        if (timePickerState.h() % 12 == 0) {
            return 12;
        }
        return timePickerState.i() ? timePickerState.h() - 12 : timePickerState.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(final androidx.compose.material3.AnalogTimePickerState r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.TimePickerColors r20, final boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.l(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final long l0(AnalogTimePickerState analogTimePickerState) {
        TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
        float f3 = 2;
        float fG = Dp.g(timePickerTokens.g() / f3);
        float fG2 = Dp.g(Dp.g(((analogTimePickerState.g() && analogTimePickerState.i() && TimePickerSelectionMode.f(analogTimePickerState.c(), TimePickerSelectionMode.f21378b.a())) ? f21168b : f21167a) - fG) + fG);
        return DpKt.a(Dp.g(Dp.g(((float) Math.cos(analogTimePickerState.v())) * fG2) + Dp.g(timePickerTokens.b() / f3)), Dp.g(Dp.g(fG2 * ((float) Math.sin(analogTimePickerState.v()))) + Dp.g(timePickerTokens.b() / f3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i3) {
        int i4;
        Shape shape3;
        Composer composerK = composer.k(1374241901);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(timePickerColors) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(measurePolicy) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(shape) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            shape3 = shape2;
            i4 |= composerK.Z(shape3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            shape3 = shape2;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1374241901, i4, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1254)");
            }
            TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
            BorderStroke borderStrokeA = BorderStrokeKt.a(timePickerTokens.o(), timePickerColors.c());
            Shape shapeE = ShapesKt.e(timePickerTokens.k(), composerK, 6);
            Intrinsics.checkNotNull(shapeE, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shapeE;
            Strings.Companion companion = Strings.f22102b;
            final String strA = Strings_androidKt.a(Strings.a(R.string.f19298b0), composerK, 0);
            boolean Z = composerK.Z(strA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
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
                        SemanticsPropertiesKt.G0(semanticsPropertyReceiver, true);
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierE = BorderKt.e(SelectableGroupKt.a(SemanticsModifierKt.f(modifier, false, (Function1) objG, 1, null)), borderStrokeA, cornerBasedShape);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierE);
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            boolean z2 = !timePickerState.i();
            int i5 = i4 & 112;
            boolean z3 = i5 == 32 || ((i4 & 64) != 0 && composerK.I(timePickerState));
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m193invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m193invoke() {
                        timePickerState.a(false);
                    }
                };
                composerK.w(objG2);
            }
            ComposableSingletons$TimePickerKt composableSingletons$TimePickerKt = ComposableSingletons$TimePickerKt.f16786a;
            int i6 = (i4 << 3) & 7168;
            int i7 = i4;
            x(z2, shape, (Function0) objG2, timePickerColors, composableSingletons$TimePickerKt.a(), composerK, ((i4 >> 9) & 112) | 24576 | i6);
            SpacerKt.a(BackgroundKt.d(SizeKt.f(ZIndexModifierKt.a(LayoutIdKt.b(Modifier.b8, "Spacer"), 2.0f), 0.0f, 1, null), timePickerColors.c(), null, 2, null), composerK, 0);
            boolean z4 = false;
            boolean zI = timePickerState.i();
            if (i5 == 32 || ((i7 & 64) != 0 && composerK.I(timePickerState))) {
                z4 = true;
            }
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m194invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m194invoke() {
                        timePickerState.a(true);
                    }
                };
                composerK.w(objG3);
            }
            x(zI, shape3, (Function0) objG3, timePickerColors, composableSingletons$TimePickerKt.b(), composerK, ((i7 >> 12) & 112) | 24576 | i6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3
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
                    TimePickerKt.m(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(TimePickerState timePickerState, float f3, float f4, float f5, long j3) {
        if (TimePickerSelectionMode.f(timePickerState.c(), TimePickerSelectionMode.f21378b.a()) && timePickerState.g()) {
            timePickerState.a(i0(f3, f4, IntOffset.k(j3), IntOffset.l(j3)) < f5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final androidx.compose.material3.TimePickerState r7, androidx.compose.ui.Modifier r8, androidx.compose.material3.TimePickerColors r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            r0 = -760850373(0xffffffffd2a6583b, float:-3.5722242E11)
            androidx.compose.runtime.Composer r10 = r10.k(r0)
            r1 = r12 & 1
            if (r1 == 0) goto Le
            r1 = r11 | 6
            goto L27
        Le:
            r1 = r11 & 6
            if (r1 != 0) goto L26
            r1 = r11 & 8
            if (r1 != 0) goto L1b
            boolean r1 = r10.Z(r7)
            goto L1f
        L1b:
            boolean r1 = r10.I(r7)
        L1f:
            if (r1 == 0) goto L23
            r1 = 4
            goto L24
        L23:
            r1 = 2
        L24:
            r1 = r1 | r11
            goto L27
        L26:
            r1 = r11
        L27:
            r2 = r12 & 2
            if (r2 == 0) goto L2e
            r1 = r1 | 48
            goto L3e
        L2e:
            r3 = r11 & 48
            if (r3 != 0) goto L3e
            boolean r3 = r10.Z(r8)
            if (r3 == 0) goto L3b
            r3 = 32
            goto L3d
        L3b:
            r3 = 16
        L3d:
            r1 = r1 | r3
        L3e:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L52
            r3 = r12 & 4
            if (r3 != 0) goto L4f
            boolean r3 = r10.Z(r9)
            if (r3 == 0) goto L4f
            r3 = 256(0x100, float:3.59E-43)
            goto L51
        L4f:
            r3 = 128(0x80, float:1.8E-43)
        L51:
            r1 = r1 | r3
        L52:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L65
            boolean r3 = r10.l()
            if (r3 != 0) goto L5f
            goto L65
        L5f:
            r10.Q()
        L62:
            r3 = r8
            r4 = r9
            goto Lb1
        L65:
            r10.J()
            r3 = r11 & 1
            r4 = 6
            if (r3 == 0) goto L7e
            boolean r3 = r10.S()
            if (r3 == 0) goto L74
            goto L7e
        L74:
            r10.Q()
            r2 = r12 & 4
            if (r2 == 0) goto L8d
        L7b:
            r1 = r1 & (-897(0xfffffffffffffc7f, float:NaN))
            goto L8d
        L7e:
            if (r2 == 0) goto L82
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.b8
        L82:
            r2 = r12 & 4
            if (r2 == 0) goto L8d
            androidx.compose.material3.TimePickerDefaults r9 = androidx.compose.material3.TimePickerDefaults.f21166a
            androidx.compose.material3.TimePickerColors r9 = r9.a(r10, r4)
            goto L7b
        L8d:
            r10.z()
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L9c
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInput (TimePicker.kt:260)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r2, r3)
        L9c:
            int r0 = r1 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r1 << r4
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            o(r8, r9, r7, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto L62
            androidx.compose.runtime.ComposerKt.T()
            goto L62
        Lb1:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.n()
            if (r8 == 0) goto Lc2
            androidx.compose.material3.TimePickerKt$TimeInput$1 r1 = new androidx.compose.material3.TimePickerKt$TimeInput$1
            r2 = r7
            r5 = r11
            r6 = r12
            r1.<init>()
            r8.a(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.n(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final String n0(int i3, boolean z2, int i4, Composer composer, int i5) {
        int iA;
        if (ComposerKt.M()) {
            ComposerKt.U(194237364, i5, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1914)");
        }
        if (TimePickerSelectionMode.f(i3, TimePickerSelectionMode.f21378b.b())) {
            Strings.Companion companion = Strings.f22102b;
            iA = Strings.a(R.string.Z);
        } else if (z2) {
            Strings.Companion companion2 = Strings.f22102b;
            iA = Strings.a(R.string.T);
        } else {
            Strings.Companion companion3 = Strings.f22102b;
            iA = Strings.a(R.string.V);
        }
        String strB = Strings_androidKt.b(iA, new Object[]{Integer.valueOf(i4)}, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final Modifier modifier, final TimePickerColors timePickerColors, final TimePickerState timePickerState, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-475657989);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-475657989, i4, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:963)");
            }
            Object[] objArr = new Object[0];
            TextFieldValue.Companion companion = TextFieldValue.f29419d;
            Saver saverA = companion.a();
            int i5 = i4 & 896;
            boolean z2 = i5 == 256 || ((i4 & 512) != 0 && composerK.I(timePickerState));
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState invoke() {
                        return SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue(CalendarLocale_jvmKt.c(TimePickerKt.k0(timePickerState), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                composerK.w(objG);
            }
            final MutableState mutableStateD = RememberSaveableKt.d(objArr, saverA, null, (Function0) objG, composerK, 0, 4);
            Object[] objArr2 = new Object[0];
            Saver saverA2 = companion.a();
            boolean z3 = i5 == 256 || ((i4 & 512) != 0 && composerK.I(timePickerState));
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState invoke() {
                        return SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue(CalendarLocale_jvmKt.c(timePickerState.f(), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                composerK.w(objG2);
            }
            final MutableState mutableStateD2 = RememberSaveableKt.d(objArr2, saverA2, null, (Function0) objG2, composerK, 0, 4);
            int i6 = i4;
            Modifier modifierM = PaddingKt.m(modifier, 0.0f, 0.0f, 0.0f, f21173g, 7, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.l(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TimeInputTokens timeInputTokens = TimeInputTokens.f23515a;
            CompositionLocalKt.c(new ProvidedValue[]{TextKt.f().d(TextStyle.e(TypographyKt.c(timeInputTokens.f(), composerK, 6), timePickerColors.h(true), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.f29616b.a(), 0, 0L, null, null, null, 0, 0, null, 16744446, null)), CompositionLocalsKt.m().d(LayoutDirection.f30001a)}, ComposableLambdaKt.e(1306700887, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1306700887, i7, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:987)");
                    }
                    final MutableState mutableState = mutableStateD;
                    final TimePickerState timePickerState2 = timePickerState;
                    TimePickerColors timePickerColors2 = timePickerColors;
                    final MutableState mutableState2 = mutableStateD2;
                    Modifier.Companion companion4 = Modifier.b8;
                    MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer2, 0);
                    int iA2 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, companion4);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                    Function0 function0A2 = companion5.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A2);
                    } else {
                        composer2.v();
                    }
                    Composer composerA2 = Updater.a(composer2);
                    Updater.e(composerA2, measurePolicyB2, companion5.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                    Function2 function2B2 = companion5.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion5.f());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                    boolean Z = composer2.Z(mutableState) | composer2.I(timePickerState2);
                    Object objG3 = composer2.G();
                    if (Z || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final Boolean c(android.view.KeyEvent keyEvent) {
                                int iC = KeyEvent_androidKt.c(keyEvent);
                                if (48 <= iC && iC < 58 && TextRange.n(TimePickerKt.q(mutableState).h()) == 2 && TimePickerKt.q(mutableState).i().length() == 2) {
                                    timePickerState2.b(TimePickerSelectionMode.f21378b.b());
                                }
                                return Boolean.FALSE;
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return c(((KeyEvent) obj).f());
                            }
                        };
                        composer2.w(objG3);
                    }
                    Modifier modifierA = KeyInputModifierKt.a(companion4, (Function1) objG3);
                    TextFieldValue textFieldValueQ = TimePickerKt.q(mutableState);
                    boolean zI = composer2.I(timePickerState2) | composer2.Z(mutableState);
                    Object objG4 = composer2.G();
                    if (zI || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final void c(TextFieldValue textFieldValue) {
                                int iA3 = TimePickerSelectionMode.f21378b.a();
                                TimePickerState timePickerState3 = timePickerState2;
                                TextFieldValue textFieldValueQ2 = TimePickerKt.q(mutableState);
                                int i8 = timePickerState2.g() ? 23 : 12;
                                final MutableState mutableState3 = mutableState;
                                TimePickerKt.p0(iA3, timePickerState3, textFieldValue, textFieldValueQ2, i8, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1.1
                                    {
                                        super(1);
                                    }

                                    public final void c(TextFieldValue textFieldValue2) {
                                        TimePickerKt.r(mutableState3, textFieldValue2);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        c((TextFieldValue) obj);
                                        return Unit.f139807a;
                                    }
                                });
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c((TextFieldValue) obj);
                                return Unit.f139807a;
                            }
                        };
                        composer2.w(objG4);
                    }
                    Function1 function1 = (Function1) objG4;
                    TimePickerSelectionMode.Companion companion6 = TimePickerSelectionMode.f21378b;
                    int iA3 = companion6.a();
                    ImeAction.Companion companion7 = ImeAction.f29348b;
                    int iD = companion7.d();
                    KeyboardType.Companion companion8 = KeyboardType.f29379b;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, companion8.d(), iD, null, null, null, 115, null);
                    boolean zI2 = composer2.I(timePickerState2);
                    Object objG5 = composer2.G();
                    if (zI2 || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$3$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyboardActionScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(KeyboardActionScope keyboardActionScope) {
                                timePickerState2.b(TimePickerSelectionMode.f21378b.b());
                            }
                        };
                        composer2.w(objG5);
                    }
                    TimePickerKt.u(modifierA, textFieldValueQ, function1, timePickerState2, iA3, keyboardOptions, new KeyboardActions(null, null, (Function1) objG5, null, null, null, 59, null), timePickerColors2, composer2, 24576, 0);
                    TimePickerKt.i(SizeKt.x(companion4, TimePickerKt.f21171e, TimeInputTokens.f23515a.a()), composer2, 6);
                    boolean Z2 = composer2.Z(mutableState2) | composer2.I(timePickerState2);
                    Object objG6 = composer2.G();
                    if (Z2 || objG6 == Composer.f23746a.a()) {
                        objG6 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final Boolean c(android.view.KeyEvent keyEvent) {
                                boolean z4 = KeyEvent_androidKt.c(keyEvent) == 0 && TextRange.n(TimePickerKt.s(mutableState2).h()) == 0;
                                if (z4) {
                                    timePickerState2.b(TimePickerSelectionMode.f21378b.a());
                                }
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return c(((KeyEvent) obj).f());
                            }
                        };
                        composer2.w(objG6);
                    }
                    Modifier modifierB = KeyInputModifierKt.b(companion4, (Function1) objG6);
                    TextFieldValue textFieldValueS = TimePickerKt.s(mutableState2);
                    boolean zI3 = composer2.I(timePickerState2) | composer2.Z(mutableState2);
                    Object objG7 = composer2.G();
                    if (zI3 || objG7 == Composer.f23746a.a()) {
                        objG7 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final void c(TextFieldValue textFieldValue) {
                                int iB = TimePickerSelectionMode.f21378b.b();
                                TimePickerState timePickerState3 = timePickerState2;
                                TextFieldValue textFieldValueS2 = TimePickerKt.s(mutableState2);
                                final MutableState mutableState3 = mutableState2;
                                TimePickerKt.p0(iB, timePickerState3, textFieldValue, textFieldValueS2, 59, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1.1
                                    {
                                        super(1);
                                    }

                                    public final void c(TextFieldValue textFieldValue2) {
                                        TimePickerKt.p(mutableState3, textFieldValue2);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        c((TextFieldValue) obj);
                                        return Unit.f139807a;
                                    }
                                });
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c((TextFieldValue) obj);
                                return Unit.f139807a;
                            }
                        };
                        composer2.w(objG7);
                    }
                    Function1 function12 = (Function1) objG7;
                    int iB = companion6.b();
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, null, companion8.d(), companion7.b(), null, null, null, 115, null);
                    boolean zI4 = composer2.I(timePickerState2);
                    Object objG8 = composer2.G();
                    if (zI4 || objG8 == Composer.f23746a.a()) {
                        objG8 = new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$6$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyboardActionScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(KeyboardActionScope keyboardActionScope) {
                                timePickerState2.b(TimePickerSelectionMode.f21378b.b());
                            }
                        };
                        composer2.w(objG8);
                    }
                    TimePickerKt.u(modifierB, textFieldValueS, function12, timePickerState2, iB, keyboardOptions2, new KeyboardActions(null, null, (Function1) objG8, null, null, null, 59, null), timePickerColors2, composer2, 24576, 0);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            composerK.a0(511443242);
            if (!timePickerState.g()) {
                Modifier.Companion companion4 = Modifier.b8;
                Modifier modifierM2 = PaddingKt.m(companion4, f21179m, 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
                Function0 function0A2 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                z(SizeKt.x(companion4, timeInputTokens.b(), timeInputTokens.a()), timePickerState, timePickerColors, composerK, ((i6 >> 3) & 112) | 6 | ((i6 << 3) & 896));
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    TimePickerKt.o(modifier, timePickerColors, timePickerState, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object o0(androidx.compose.material3.AnalogTimePickerState r11, float r12, float r13, float r14, boolean r15, long r16, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.o0(androidx.compose.material3.AnalogTimePickerState, float, float, float, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(int i3, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i4, Function1 function1) {
        if (Intrinsics.areEqual(textFieldValue.i(), textFieldValue2.i())) {
            function1.invoke(textFieldValue);
            return;
        }
        if (textFieldValue.i().length() == 0) {
            if (TimePickerSelectionMode.f(i3, TimePickerSelectionMode.f21378b.a())) {
                timePickerState.d(0);
            } else {
                timePickerState.e(0);
            }
            function1.invoke(TextFieldValue.e(textFieldValue, "", 0L, null, 6, null));
            return;
        }
        try {
            int iF = (textFieldValue.i().length() == 3 && TextRange.n(textFieldValue.h()) == 1) ? CharsKt.f(textFieldValue.i().charAt(0)) : Integer.parseInt(textFieldValue.i());
            if (iF <= i4) {
                TimePickerSelectionMode.Companion companion = TimePickerSelectionMode.f21378b;
                if (TimePickerSelectionMode.f(i3, companion.a())) {
                    timePickerState.d(iF);
                    if (iF > 1 && !timePickerState.g()) {
                        timePickerState.b(companion.b());
                    }
                } else {
                    timePickerState.e(iF);
                }
                function1.invoke(textFieldValue.i().length() <= 2 ? textFieldValue : TextFieldValue.e(textFieldValue, String.valueOf(textFieldValue.i().charAt(0)), 0L, null, 6, null));
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue q(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    private static final Modifier q0(Modifier modifier, final boolean z2) {
        return modifier.then(new VisibleModifier(z2, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("visible");
                inspectorInfo.b().c("visible", Boolean.valueOf(z2));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue s(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final androidx.compose.material3.TimePickerState r13, androidx.compose.ui.Modifier r14, androidx.compose.material3.TimePickerColors r15, int r16, androidx.compose.runtime.Composer r17, final int r18, final int r19) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.t(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /* JADX WARN: Type inference failed for: r14v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r53v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u(final androidx.compose.ui.Modifier r112, final androidx.compose.ui.text.input.TextFieldValue r113, final kotlin.jvm.functions.Function1 r114, androidx.compose.material3.TimePickerState r115, final int r116, androidx.compose.foundation.text.KeyboardOptions r117, androidx.compose.foundation.text.KeyboardActions r118, final androidx.compose.material3.TimePickerColors r119, androidx.compose.runtime.Composer r120, final int r121, final int r122) {
        /*
            Method dump skipped, instruction units count: 1527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.u(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean v(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final Modifier modifier, final int i3, final TimePickerState timePickerState, final int i4, final TimePickerColors timePickerColors, Composer composer, final int i5) {
        int i6;
        int iA;
        Composer composer2;
        Composer composerK = composer.k(-1148055889);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.e(i4) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= composerK.Z(timePickerColors) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i6 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1148055889, i6, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1348)");
            }
            boolean zF = TimePickerSelectionMode.f(timePickerState.c(), i4);
            if (TimePickerSelectionMode.f(i4, TimePickerSelectionMode.f21378b.a())) {
                Strings.Companion companion = Strings.f22102b;
                iA = Strings.a(R.string.U);
            } else {
                Strings.Companion companion2 = Strings.f22102b;
                iA = Strings.a(R.string.Y);
            }
            final String strA = Strings_androidKt.a(iA, composerK, 0);
            long jG = timePickerColors.g(zF);
            final long jH = timePickerColors.h(zF);
            boolean Z = composerK.Z(strA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
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
                        SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.f());
                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strA);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierE = SemanticsModifierKt.e(modifier, true, (Function1) objG);
            Shape shapeE = ShapesKt.e(TimePickerTokens.f23541a.v(), composerK, 6);
            boolean z2 = ((i6 & 896) == 256 || ((i6 & 512) != 0 && composerK.I(timePickerState))) | ((i6 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m195invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m195invoke() {
                        if (TimePickerSelectionMode.f(i4, timePickerState.c())) {
                            return;
                        }
                        timePickerState.b(i4);
                    }
                };
                composerK.w(objG2);
            }
            composer2 = composerK;
            SurfaceKt.b(zF, (Function0) objG2, modifierE, false, shapeE, jG, 0L, 0.0f, 0.0f, null, null, ComposableLambdaKt.e(-1477282471, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i7) {
                    if ((i7 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1477282471, i7, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1376)");
                    }
                    final String strN0 = TimePickerKt.n0(i4, timePickerState.g(), i3, composer3, 0);
                    Alignment alignmentE = Alignment.f25072a.e();
                    int i8 = i3;
                    long j3 = jH;
                    Modifier.Companion companion3 = Modifier.b8;
                    MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
                    int iA2 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, companion3);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                    Function0 function0A = companion4.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A);
                    } else {
                        composer3.v();
                    }
                    Composer composerA = Updater.a(composer3);
                    Updater.e(composerA, measurePolicyG, companion4.e());
                    Updater.e(composerA, compositionLocalMapU, companion4.g());
                    Function2 function2B = companion4.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA2))) {
                        composerA.w(Integer.valueOf(iA2));
                        composerA.p(Integer.valueOf(iA2), function2B);
                    }
                    Updater.e(composerA, modifierF, companion4.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    boolean Z2 = composer3.Z(strN0);
                    Object objG3 = composer3.G();
                    if (Z2 || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
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
                                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, strN0);
                            }
                        };
                        composer3.w(objG3);
                    }
                    TextKt.c(CalendarLocale_jvmKt.c(i8, 2, 0, false, 6, null), SemanticsModifierKt.f(companion3, false, (Function1) objG3, 1, null), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131064);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, 0, 48, 1992);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i7) {
                    TimePickerKt.w(modifier, i3, timePickerState, i4, timePickerColors, composer3, RecomposeScopeImplKt.a(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final boolean z2, final Shape shape, final Function0 function0, final TimePickerColors timePickerColors, final Function3 function3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1937408098);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(shape) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1937408098, i4, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1304)");
            }
            long jF = timePickerColors.f(z2);
            long jE = timePickerColors.e(z2);
            Modifier modifierF = SizeKt.f(ZIndexModifierKt.a(Modifier.b8, z2 ? 0.0f : 1.0f), 0.0f, 1, null);
            boolean z3 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
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
                        SemanticsPropertiesKt.s0(semanticsPropertyReceiver, z2);
                    }
                };
                composerK.w(objG);
            }
            ButtonKt.e(function0, SemanticsModifierKt.f(modifierF, false, (Function1) objG, 1, null), false, shape, ButtonDefaults.f16077a.A(jE, jF, 0L, 0L, composerK, 24576, 12), null, null, PaddingKt.a(Dp.g(0)), null, function3, composerK, ((i4 >> 6) & 14) | 12582912 | ((i4 << 6) & 7168) | ((i4 << 15) & 1879048192), 356);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    TimePickerKt.x(z2, shape, function0, timePickerColors, function3, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2054675515);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerColors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2054675515, i4, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1106)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalB, companion2.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            b(timePickerState, timePickerColors, composerK, i4 & 126);
            composerK.a0(-709485014);
            if (!timePickerState.g()) {
                Modifier modifierM = PaddingKt.m(companion, f21179m, 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A2 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
                int i5 = i4 << 3;
                z(SizeKt.x(companion, timePickerTokens.t(), timePickerTokens.s()), timePickerState, timePickerColors, composerK, (i5 & 896) | (i5 & 112) | 6);
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalClockDisplay$2
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
                    TimePickerKt.y(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerK = composer.k(-1898918107);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(timePickerState) : composerK.I(timePickerState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(timePickerColors) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1898918107, i4, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1205)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Measurable measurable = (Measurable) list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "Spacer")) {
                                final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, 0, 0, measureScope.z0(TimePickerTokens.f23541a.o()), 3, null));
                                ArrayList arrayList = new ArrayList(list.size());
                                int size2 = list.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Object obj = list.get(i6);
                                    if (!Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                final ArrayList arrayList2 = new ArrayList(arrayList.size());
                                int size3 = arrayList.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    arrayList2.add(((Measurable) arrayList.get(i7)).n0(Constraints.d(j3, 0, 0, 0, Constraints.k(j3) / 2, 3, null)));
                                }
                                return MeasureScope.B0(measureScope, Constraints.l(j3), Constraints.k(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((Placeable.PlacementScope) obj2);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.i(placementScope, (Placeable) arrayList2.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.i(placementScope, (Placeable) arrayList2.get(1), 0, ((Placeable) arrayList2.get(0)).O0(), 0.0f, 4, null);
                                        Placeable.PlacementScope.i(placementScope, placeableN0, 0, ((Placeable) arrayList2.get(0)).O0() - (placeableN0.O0() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            Shape shapeE = ShapesKt.e(TimePickerTokens.f23541a.k(), composerK, 6);
            Intrinsics.checkNotNull(shapeE, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shapeE;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            m(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.g(cornerBasedShape), ShapesKt.a(cornerBasedShape), composerK, (i4 & 14) | 3072 | (i4 & 112) | (i4 & 896));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$1
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
                    TimePickerKt.z(modifier2, timePickerState2, timePickerColors2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
