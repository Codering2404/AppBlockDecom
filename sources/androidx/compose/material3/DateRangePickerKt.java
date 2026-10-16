package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
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
public final class DateRangePickerKt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaddingValues f17296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PaddingValues f17297c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PaddingValues f17295a = PaddingKt.e(Dp.g(24), Dp.g(20), 0.0f, Dp.g(8), 4, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f17298d = Dp.g(60);

    static {
        float f3 = 64;
        float f4 = 12;
        f17296b = PaddingKt.e(Dp.g(f3), 0.0f, Dp.g(f4), 0.0f, 10, null);
        f17297c = PaddingKt.e(Dp.g(f3), 0.0f, Dp.g(f4), Dp.g(f4), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.material3.DateRangePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, kotlin.jvm.functions.Function2 r28, kotlin.jvm.functions.Function2 r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.a(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Long l3, final Long l4, final long j3, final Function2 function2, final Function1 function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Long l5;
        Function2 function22;
        Function1 function12;
        SelectableDates selectableDates2;
        Object obj;
        Composer composerK = composer.k(-787063721);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(l3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            l5 = l4;
            i4 |= composerK.Z(l5) ? 32 : 16;
        } else {
            l5 = l4;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function22 = function2;
            i4 |= composerK.I(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(calendarModel) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= (16777216 & i3) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerK.Z(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i3 & 805306368) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-787063721, i4, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:719)");
            }
            int iF = RangesKt.f(calendarModel.g(j3).g(intRange), 0);
            LazyListState lazyListStateB = LazyListStateKt.b(iF, 0, composerK, 0, 2);
            Integer numValueOf = Integer.valueOf(iF);
            boolean Z = composerK.Z(lazyListStateB) | composerK.e(iF);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                obj = null;
                objG = new DateRangePickerKt$DateRangePickerContent$1$1(lazyListStateB, iF, null);
                composerK.w(objG);
            } else {
                obj = null;
            }
            EffectsKt.g(numValueOf, (Function2) objG, composerK, 0);
            Modifier modifierK = PaddingKt.k(Modifier.b8, DatePickerKt.G(), 0.0f, 2, obj);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            DatePickerKt.m(datePickerColors, calendarModel, composerK, ((i4 >> 27) & 14) | ((i4 >> 12) & 112));
            d(lazyListStateB, l3, l5, function22, function12, calendarModel, intRange, datePickerFormatter, selectableDates2, datePickerColors, composerK, ((i4 << 3) & 1008) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (1879048192 & i4));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    DateRangePickerKt.b(l3, l4, j3, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Long l3, final Long l4, final long j3, final int i3, final Function2 function2, final Function1 function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i4, final int i5) {
        int i6;
        Long l5;
        long j4;
        Function2 function22;
        Function1 function12;
        CalendarModel calendarModel2;
        IntRange intRange2;
        int i7;
        Composer composer2;
        Composer composerK = composer.k(-532789335);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(l3) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            l5 = l4;
            i6 |= composerK.Z(l5) ? 32 : 16;
        } else {
            l5 = l4;
        }
        if ((i4 & 384) == 0) {
            j4 = j3;
            i6 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            j4 = j3;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.e(i3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            function22 = function2;
            i6 |= composerK.I(function22) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function22 = function2;
        }
        if ((196608 & i4) == 0) {
            function12 = function1;
            i6 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function12 = function1;
        }
        if ((1572864 & i4) == 0) {
            calendarModel2 = calendarModel;
            i6 |= composerK.I(calendarModel2) ? 1048576 : 524288;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((12582912 & i4) == 0) {
            intRange2 = intRange;
            i6 |= composerK.I(intRange2) ? 8388608 : 4194304;
        } else {
            intRange2 = intRange;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= (i4 & 134217728) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerK.Z(selectableDates) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerK.Z(datePickerColors) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i6 & 306783379) == 306783378 && (i7 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-532789335, i6, i7, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:665)");
            }
            final Long l6 = l5;
            final Function2 function23 = function22;
            final IntRange intRange3 = intRange2;
            final long j5 = j4;
            final Function1 function13 = function12;
            final CalendarModel calendarModel3 = calendarModel2;
            composer2 = composerK;
            CrossfadeKt.b(DisplayMode.c(i3), SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.b0(semanticsPropertyReceiver, true);
                }
            }, 1, null), AnimationSpecKt.l(0.0f, 0.0f, null, 7, null), null, ComposableLambdaKt.e(-1026642619, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final void c(int i8, Composer composer3, int i9) {
                    int i10;
                    if ((i9 & 6) == 0) {
                        i10 = i9 | (composer3.e(i8) ? 4 : 2);
                    } else {
                        i10 = i9;
                    }
                    if ((i10 & 19) == 18 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1026642619, i10, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:677)");
                    }
                    DisplayMode.Companion companion = DisplayMode.f17460b;
                    if (DisplayMode.f(i8, companion.b())) {
                        composer3.a0(-1871299185);
                        DateRangePickerKt.b(l3, l6, j5, function23, function13, calendarModel3, intRange3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                        composer3.U();
                    } else if (DisplayMode.f(i8, companion.a())) {
                        composer3.a0(-1871277944);
                        DateRangeInputKt.a(l3, l6, function23, calendarModel3, intRange3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                        composer3.U();
                    } else {
                        composer3.a0(2120399965);
                        composer3.U();
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    c(((DisplayMode) obj).i(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composer2, ((i6 >> 9) & 14) | 24960, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    DateRangePickerKt.c(l3, l4, j3, i3, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LazyListState lazyListState, final Long l3, final Long l4, final Function2 function2, final Function1 function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Long l5;
        Long l6;
        Function2 function22;
        Object dateRangePickerKt$VerticalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerK = composer.k(1257365001);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(lazyListState2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            l5 = l3;
            i4 |= composerK.Z(l5) ? 32 : 16;
        } else {
            l5 = l3;
        }
        if ((i3 & 384) == 0) {
            l6 = l4;
            i4 |= composerK.Z(l6) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            l6 = l4;
        }
        if ((i3 & 3072) == 0) {
            function22 = function2;
            i4 |= composerK.I(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(calendarModel) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= (16777216 & i3) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.Z(selectableDates) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1257365001, i4, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:767)");
            }
            final CalendarDate calendarDateI = calendarModel.i();
            boolean Z = composerK.Z(intRange);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = calendarModel.f(intRange.g(), 1);
                composerK.w(objG);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) objG;
            final Long l7 = l5;
            final Function2 function23 = function22;
            int i5 = i4;
            final Long l8 = l6;
            TextKt.a(TypographyKt.c(DatePickerModalTokens.f22450a.f(), composerK, 6), ComposableLambdaKt.e(1090773432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1
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
                    if ((i6 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1090773432, i6, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:777)");
                    }
                    Object objG2 = composer2.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG2 == companion.a()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer2));
                        composer2.w(compositionScopedCoroutineScopeCanceller);
                        objG2 = compositionScopedCoroutineScopeCanceller;
                    }
                    CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG2).a();
                    Strings.Companion companion2 = Strings.f22102b;
                    String strA = Strings_androidKt.a(Strings.a(R.string.H), composer2, 0);
                    String strA2 = Strings_androidKt.a(Strings.a(R.string.G), composer2, 0);
                    boolean Z2 = composer2.Z(l7) | composer2.Z(l8) | composer2.Z(function23);
                    final Long l9 = l7;
                    final Long l10 = l8;
                    final Function2 function24 = function23;
                    Object objG3 = composer2.G();
                    if (Z2 || objG3 == companion.a()) {
                        objG3 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final void c(long j3) {
                                DateRangePickerKt.o(j3, l9, l10, function24);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c(((Number) obj).longValue());
                                return Unit.f139807a;
                            }
                        };
                        composer2.w(objG3);
                    }
                    final Function1 function12 = (Function1) objG3;
                    final List listL = DateRangePickerKt.l(lazyListState2, coroutineScopeA, strA, strA2);
                    Modifier modifierF = SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.I0(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    LazyListState lazyListState3 = lazyListState2;
                    boolean zI = composer2.I(intRange) | composer2.I(calendarModel) | composer2.Z(calendarMonth) | composer2.I(datePickerFormatter) | composer2.I(listL) | composer2.Z(datePickerColors) | composer2.Z(l7) | composer2.Z(l8) | composer2.Z(function12) | composer2.Z(calendarDateI) | composer2.Z(selectableDates);
                    final IntRange intRange2 = intRange;
                    final CalendarModel calendarModel2 = calendarModel;
                    final CalendarMonth calendarMonth2 = calendarMonth;
                    final Long l11 = l7;
                    final Long l12 = l8;
                    final CalendarDate calendarDate = calendarDateI;
                    final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    final SelectableDates selectableDates2 = selectableDates;
                    final DatePickerColors datePickerColors2 = datePickerColors;
                    Object objG4 = composer2.G();
                    if (zI || objG4 == companion.a()) {
                        Object obj = new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((LazyListScope) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(LazyListScope lazyListScope) {
                                int iJ = DatePickerKt.J(intRange2);
                                final CalendarModel calendarModel3 = calendarModel2;
                                final CalendarMonth calendarMonth3 = calendarMonth2;
                                final Long l13 = l11;
                                final Long l14 = l12;
                                final Function1 function13 = function12;
                                final CalendarDate calendarDate2 = calendarDate;
                                final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                final SelectableDates selectableDates3 = selectableDates2;
                                final DatePickerColors datePickerColors3 = datePickerColors2;
                                final List list = listL;
                                LazyListScope.b(lazyListScope, iJ, null, null, ComposableLambdaKt.c(-1413501381, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        invoke((LazyItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(LazyItemScope lazyItemScope, int i7, Composer composer3, int i8) {
                                        int i9;
                                        SelectedRangeInfo selectedRangeInfo;
                                        if ((i8 & 6) == 0) {
                                            i9 = i8 | (composer3.Z(lazyItemScope) ? 4 : 2);
                                        } else {
                                            i9 = i8;
                                        }
                                        if ((i8 & 48) == 0) {
                                            i9 |= composer3.e(i7) ? 32 : 16;
                                        }
                                        if ((i9 & 147) == 146 && composer3.l()) {
                                            composer3.Q();
                                            return;
                                        }
                                        if (ComposerKt.M()) {
                                            ComposerKt.U(-1413501381, i9, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:810)");
                                        }
                                        final CalendarMonth calendarMonthL = calendarModel3.l(calendarMonth3, i7);
                                        Modifier modifierA = LazyItemScope.a(lazyItemScope, Modifier.b8, 0.0f, 1, null);
                                        Long l15 = l13;
                                        Long l16 = l14;
                                        Function1 function14 = function13;
                                        CalendarDate calendarDate3 = calendarDate2;
                                        final DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                        SelectableDates selectableDates4 = selectableDates3;
                                        final DatePickerColors datePickerColors4 = datePickerColors3;
                                        final List list2 = list;
                                        CalendarModel calendarModel4 = calendarModel3;
                                        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer3, 0);
                                        int iA = ComposablesKt.a(composer3, 0);
                                        CompositionLocalMap compositionLocalMapU = composer3.u();
                                        Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierA);
                                        ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                                        Function0 function0A = companion3.a();
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
                                        Updater.e(composerA, measurePolicyA, companion3.e());
                                        Updater.e(composerA, compositionLocalMapU, companion3.g());
                                        Function2 function2B = companion3.b();
                                        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                            composerA.w(Integer.valueOf(iA));
                                            composerA.p(Integer.valueOf(iA), function2B);
                                        }
                                        Updater.e(composerA, modifierF2, companion3.f());
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                                        TextKt.a(TypographyKt.c(DatePickerModalTokens.f22450a.x(), composer3, 6), ComposableLambdaKt.e(1622100276, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Composer composer4, int i10) {
                                                if ((i10 & 3) == 2 && composer4.l()) {
                                                    composer4.Q();
                                                    return;
                                                }
                                                if (ComposerKt.M()) {
                                                    ComposerKt.U(1622100276, i10, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:813)");
                                                }
                                                String strB = datePickerFormatter4.b(Long.valueOf(calendarMonthL.e()), CalendarLocale_androidKt.a(composer4, 0));
                                                if (strB == null) {
                                                    strB = "-";
                                                }
                                                Modifier modifierH = PaddingKt.h(Modifier.b8, DateRangePickerKt.n());
                                                boolean zI2 = composer4.I(list2);
                                                final List list3 = list2;
                                                Object objG5 = composer4.G();
                                                if (zI2 || objG5 == Composer.f23746a.a()) {
                                                    objG5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                            invoke((SemanticsPropertyReceiver) obj2);
                                                            return Unit.f139807a;
                                                        }

                                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            SemanticsPropertiesKt.f0(semanticsPropertyReceiver, list3);
                                                        }
                                                    };
                                                    composer4.w(objG5);
                                                }
                                                TextKt.c(strB, SemanticsModifierKt.f(modifierH, false, (Function1) objG5, 1, null), datePickerColors4.k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 0, 0, 131064);
                                                if (ComposerKt.M()) {
                                                    ComposerKt.T();
                                                }
                                            }
                                        }, composer3, 54), composer3, 48);
                                        composer3.a0(2125334733);
                                        if (l15 == null || l16 == null) {
                                            selectedRangeInfo = null;
                                        } else {
                                            boolean Z3 = composer3.Z(l15) | composer3.Z(l16);
                                            Object objG5 = composer3.G();
                                            if (Z3 || objG5 == Composer.f23746a.a()) {
                                                objG5 = SelectedRangeInfo.f19825e.a(calendarMonthL, calendarModel4.b(l15.longValue()), calendarModel4.b(l16.longValue()));
                                                composer3.w(objG5);
                                            }
                                            selectedRangeInfo = (SelectedRangeInfo) objG5;
                                        }
                                        composer3.U();
                                        DatePickerKt.j(calendarMonthL, function14, calendarDate3.d(), l15, l16, selectedRangeInfo, datePickerFormatter4, selectableDates4, datePickerColors4, composer3, 0);
                                        composer3.y();
                                        if (ComposerKt.M()) {
                                            ComposerKt.T();
                                        }
                                    }
                                }), 6, null);
                            }
                        };
                        composer2.w(obj);
                        objG4 = obj;
                    }
                    LazyDslKt.c(modifierF, lazyListState3, null, false, null, null, null, false, (Function1) objG4, composer2, 0, 252);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            int i6 = i5 & 14;
            boolean zI = (i6 == 4) | ((57344 & i5) == 16384) | composerK.I(calendarModel) | composerK.I(intRange);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                lazyListState2 = lazyListState;
                dateRangePickerKt$VerticalMonthsList$2$1 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, function1, calendarModel, intRange, null);
                composerK.w(dateRangePickerKt$VerticalMonthsList$2$1);
            } else {
                dateRangePickerKt$VerticalMonthsList$2$1 = objG2;
                lazyListState2 = lazyListState;
            }
            EffectsKt.g(lazyListState2, (Function2) dateRangePickerKt$VerticalMonthsList$2$1, composerK, i6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3
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
                    DateRangePickerKt.d(lazyListState2, l3, l4, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l(final LazyListState lazyListState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", f = "DateRangePicker.kt", l = {1046}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f17422a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LazyListState f17423b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation continuation) {
                    super(2, continuation);
                    this.f17423b = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f17423b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f17422a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        LazyListState lazyListState = this.f17423b;
                        int iS = lazyListState.s() - 1;
                        this.f17422a = 1;
                        if (LazyListState.K(lazyListState, iS, 0, this, 2, null) == objF) {
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
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z2;
                if (lazyListState.d()) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", f = "DateRangePicker.kt", l = {1054}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f17418a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LazyListState f17419b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation continuation) {
                    super(2, continuation);
                    this.f17419b = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f17419b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f17418a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        LazyListState lazyListState = this.f17419b;
                        int iS = lazyListState.s() + 1;
                        this.f17418a = 1;
                        if (LazyListState.K(lazyListState, iS, 0, this, 2, null) == objF) {
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
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z2;
                if (lazyListState.f()) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        })});
    }

    public static final void m(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j3) {
        float fM1 = contentDrawScope.M1(DatePickerKt.I());
        float fM12 = contentDrawScope.M1(DatePickerKt.I());
        float fM13 = contentDrawScope.M1(DatePickerModalTokens.f22450a.i());
        float f3 = 2;
        float f4 = (fM12 - fM13) / f3;
        float f5 = 7;
        float fI = (Size.i(contentDrawScope.b()) - (f5 * fM1)) / f5;
        long jC = selectedRangeInfo.c();
        int iK = IntOffset.k(jC);
        int iL = IntOffset.l(jC);
        long jB = selectedRangeInfo.b();
        int iK2 = IntOffset.k(jB);
        int iL2 = IntOffset.l(jB);
        float f6 = iK;
        float f7 = fM1 + fI;
        float f8 = fI / f3;
        float fI2 = (f6 * f7) + (selectedRangeInfo.a() ? fM1 / f3 : 0.0f) + f8;
        float f9 = (iL * fM12) + f4;
        float f10 = iK2 * f7;
        if (selectedRangeInfo.d()) {
            fM1 /= f3;
        }
        float fI3 = f10 + fM1 + f8;
        float f11 = (iL2 * fM12) + f4;
        boolean z2 = contentDrawScope.getLayoutDirection() == LayoutDirection.f30002b;
        if (z2) {
            fI2 = Size.i(contentDrawScope.b()) - fI2;
            fI3 = Size.i(contentDrawScope.b()) - fI3;
        }
        float fI4 = fI3;
        DrawScope.L1(contentDrawScope, j3, OffsetKt.a(fI2, f9), SizeKt.a(iL == iL2 ? fI4 - fI2 : z2 ? -fI2 : Size.i(contentDrawScope.b()) - fI2, fM13), 0.0f, null, null, 0, 120, null);
        if (iL != iL2) {
            for (int i3 = (iL2 - iL) - 1; i3 > 0; i3--) {
                DrawScope.L1(contentDrawScope, j3, OffsetKt.a(0.0f, f9 + (i3 * fM12)), SizeKt.a(Size.i(contentDrawScope.b()), fM13), 0.0f, null, null, 0, 120, null);
            }
            long jA = OffsetKt.a(contentDrawScope.getLayoutDirection() == LayoutDirection.f30001a ? 0.0f : Size.i(contentDrawScope.b()), f11);
            if (z2) {
                fI4 -= Size.i(contentDrawScope.b());
            }
            DrawScope.L1(contentDrawScope, j3, jA, SizeKt.a(fI4, fM13), 0.0f, null, null, 0, 120, null);
        }
    }

    public static final PaddingValues n() {
        return f17295a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(long j3, Long l3, Long l4, Function2 function2) {
        if ((l3 == null && l4 == null) || (l3 != null && l4 != null)) {
            function2.invoke(Long.valueOf(j3), null);
        } else if (l3 == null || j3 < l3.longValue()) {
            function2.invoke(Long.valueOf(j3), null);
        } else {
            function2.invoke(l3, Long.valueOf(j3));
        }
    }
}
