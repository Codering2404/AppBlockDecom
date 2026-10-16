package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionTokens;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class DatePickerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f16922a = Dp.g(48);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f16923b = Dp.g(56);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f16924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PaddingValues f16925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final PaddingValues f16926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PaddingValues f16927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f16928g;

    static {
        float f3 = 12;
        f16924c = Dp.g(f3);
        f16925d = PaddingKt.e(0.0f, 0.0f, Dp.g(f3), Dp.g(f3), 3, null);
        float f4 = 24;
        float f5 = 16;
        f16926e = PaddingKt.e(Dp.g(f4), Dp.g(f5), Dp.g(f3), 0.0f, 8, null);
        f16927f = PaddingKt.e(Dp.g(f4), 0.0f, Dp.g(f3), Dp.g(f3), 2, null);
        f16928g = Dp.g(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E(final LazyGridState lazyGridState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1

            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1", f = "DatePicker.kt", l = {2242}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f17219a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LazyGridState f17220b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation continuation) {
                    super(2, continuation);
                    this.f17220b = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f17220b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f17219a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        LazyGridState lazyGridState = this.f17220b;
                        int iR = lazyGridState.r() - 3;
                        this.f17219a = 1;
                        if (LazyGridState.K(lazyGridState, iR, 0, this, 2, null) == objF) {
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
                if (lazyGridState.d()) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(lazyGridState, null), 3, null);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1

            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1", f = "DatePicker.kt", l = {2250}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f17215a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LazyGridState f17216b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation continuation) {
                    super(2, continuation);
                    this.f17216b = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f17216b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f17215a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        LazyGridState lazyGridState = this.f17216b;
                        int iR = lazyGridState.r() + 3;
                        this.f17215a = 1;
                        if (LazyGridState.K(lazyGridState, iR, 0, this, 2, null) == objF) {
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
                if (lazyGridState.f()) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(lazyGridState, null), 3, null);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        })});
    }

    private static final String F(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(502032503, i3, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1909)");
        }
        StringBuilder sb = new StringBuilder();
        composer.a0(-647730741);
        if (z2) {
            if (z4) {
                composer.a0(-647727716);
                Strings.Companion companion = Strings.f22102b;
                sb.append(Strings_androidKt.a(Strings.a(R.string.I), composer, 0));
                composer.U();
            } else if (z5) {
                composer.a0(-647723718);
                Strings.Companion companion2 = Strings.f22102b;
                sb.append(Strings_androidKt.a(Strings.a(R.string.F), composer, 0));
                composer.U();
            } else if (z6) {
                composer.a0(-647719783);
                Strings.Companion companion3 = Strings.f22102b;
                sb.append(Strings_androidKt.a(Strings.a(R.string.E), composer, 0));
                composer.U();
            } else {
                composer.a0(1395591750);
                composer.U();
            }
        }
        composer.U();
        composer.a0(-647717033);
        if (z3) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.f22102b;
            sb.append(Strings_androidKt.a(Strings.a(R.string.A), composer, 0));
        }
        composer.U();
        String string = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return string;
    }

    public static final float G() {
        return f16924c;
    }

    public static final PaddingValues H() {
        return f16925d;
    }

    public static final float I() {
        return f16922a;
    }

    public static final int J(IntRange intRange) {
        return ((intRange.h() - intRange.g()) + 1) * 12;
    }

    public static final DatePickerState K(Long l3, Long l4, IntRange intRange, int i3, SelectableDates selectableDates, Composer composer, int i4, int i5) {
        if ((i5 & 1) != 0) {
            l3 = null;
        }
        final Long l5 = l3;
        final Long l6 = (i5 & 2) != 0 ? l5 : l4;
        if ((i5 & 4) != 0) {
            intRange = DatePickerDefaults.f16873a.j();
        }
        final IntRange intRange2 = intRange;
        if ((i5 & 8) != 0) {
            i3 = DisplayMode.f17460b.b();
        }
        final int i6 = i3;
        if ((i5 & 16) != 0) {
            selectableDates = DatePickerDefaults.f16873a.f();
        }
        final SelectableDates selectableDates2 = selectableDates;
        if (ComposerKt.M()) {
            ComposerKt.U(2065763010, i4, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:364)");
        }
        final Locale localeA = CalendarLocale_androidKt.a(composer, 0);
        Object[] objArr = new Object[0];
        Saver saverA = DatePickerStateImpl.f17232g.a(selectableDates2, localeA);
        boolean zI = ((((57344 & i4) ^ 24576) > 16384 && composer.Z(selectableDates2)) || (i4 & 24576) == 16384) | ((((i4 & 14) ^ 6) > 4 && composer.Z(l5)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.Z(l6)) || (i4 & 48) == 32) | composer.I(intRange2) | ((((i4 & 7168) ^ 3072) > 2048 && composer.e(i6)) || (i4 & 3072) == 2048) | composer.I(localeA);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Object obj = new Function0<DatePickerStateImpl>() { // from class: androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DatePickerStateImpl invoke() {
                    return new DatePickerStateImpl(l5, l6, intRange2, i6, selectableDates2, localeA, null);
                }
            };
            composer.w(obj);
            objG = obj;
        }
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        datePickerStateImpl.m(selectableDates2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return datePickerStateImpl;
    }

    public static final Object L(final LazyListState lazyListState, final Function1 function1, final CalendarModel calendarModel, final IntRange intRange, Continuation continuation) {
        Object objCollect = SnapshotStateKt.q(new Function0<Integer>() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(lazyListState.s());
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$3
            public final Object a(int i3, Continuation continuation2) {
                int iS = lazyListState.s() / 12;
                function1.invoke(Boxing.e(calendarModel.f(intRange.g() + iS, (lazyListState.s() % 12) + 1).e()));
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return a(((Number) obj).intValue(), continuation2);
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public static final void a(final Modifier modifier, final Function2 function2, final Function2 function22, final Function2 function23, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f3, final Function2 function24, Composer composer, final int i3) {
        int i4;
        Function2 function25;
        Function2 function26;
        Function2 function27;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Composer composerK = composer.k(1507356255);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            function25 = function2;
            i4 |= composerK.I(function25) ? 32 : 16;
        } else {
            function25 = function2;
        }
        if ((i3 & 384) == 0) {
            function26 = function22;
            i4 |= composerK.I(function26) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function26 = function22;
        }
        if ((i3 & 3072) == 0) {
            function27 = function23;
            i4 |= composerK.I(function27) ? 2048 : 1024;
        } else {
            function27 = function23;
        }
        if ((i3 & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i4 |= composerK.Z(datePickerColors2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i3) == 0) {
            textStyle2 = textStyle;
            i4 |= composerK.Z(textStyle2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.c(f3) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function24) ? 8388608 : 4194304;
        }
        if ((4793491 & i4) == 4793490 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1507356255, i4, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1308)");
            }
            Modifier modifierD = BackgroundKt.d(SemanticsModifierKt.f(SizeKt.z(modifier, DatePickerModalTokens.f22450a.d(), 0.0f, 0.0f, 0.0f, 14, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.b0(semanticsPropertyReceiver, true);
                }
            }, 1, null), datePickerColors2.e(), null, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            final Function2 function28 = function25;
            final Function2 function29 = function26;
            final Function2 function210 = function27;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final TextStyle textStyle3 = textStyle2;
            f(Modifier.b8, function2, datePickerColors2.l(), datePickerColors2.i(), f3, ComposableLambdaKt.e(-229007058, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
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
                    if ((i5 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-229007058, i5, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1326)");
                    }
                    Modifier.Companion companion2 = Modifier.b8;
                    Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
                    final Function2 function211 = function29;
                    Function2 function212 = function210;
                    Function2 function213 = function28;
                    DatePickerColors datePickerColors4 = datePickerColors3;
                    TextStyle textStyle4 = textStyle3;
                    Arrangement arrangement = Arrangement.f6574a;
                    Arrangement.Vertical verticalH = arrangement.h();
                    Alignment.Companion companion3 = Alignment.f25072a;
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(verticalH, companion3.k(), composer3, 0);
                    int iA2 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer3.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierH);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                    Function0 function0A2 = companion4.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A2);
                    } else {
                        composer3.v();
                    }
                    Composer composerA2 = Updater.a(composer3);
                    Updater.e(composerA2, measurePolicyA2, companion4.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                    Function2 function2B2 = companion4.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion4.f());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                    Arrangement.Horizontal horizontalG = (function211 == null || function212 == null) ? function211 != null ? arrangement.g() : arrangement.c() : arrangement.e();
                    Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
                    MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion3.i(), composer3, 48);
                    int iA3 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU3 = composer3.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composer3, modifierH2);
                    Function0 function0A3 = companion4.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A3);
                    } else {
                        composer3.v();
                    }
                    Composer composerA3 = Updater.a(composer3);
                    Updater.e(composerA3, measurePolicyB, companion4.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                    Function2 function2B3 = companion4.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion4.f());
                    final RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    composer3.a0(-1287344744);
                    if (function211 != null) {
                        TextKt.a(textStyle4, ComposableLambdaKt.e(-962031352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer4, int i6) {
                                if ((i6 & 3) == 2 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-962031352, i6, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1340)");
                                }
                                Modifier modifierC = RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null);
                                Function2 function214 = function211;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA4 = ComposablesKt.a(composer4, 0);
                                CompositionLocalMap compositionLocalMapU4 = composer4.u();
                                Modifier modifierF4 = ComposedModifierKt.f(composer4, modifierC);
                                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                                Function0 function0A4 = companion5.a();
                                if (composer4.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer4.L();
                                if (composer4.i()) {
                                    composer4.P(function0A4);
                                } else {
                                    composer4.v();
                                }
                                Composer composerA4 = Updater.a(composer4);
                                Updater.e(composerA4, measurePolicyG, companion5.e());
                                Updater.e(composerA4, compositionLocalMapU4, companion5.g());
                                Function2 function2B4 = companion5.b();
                                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                                    composerA4.w(Integer.valueOf(iA4));
                                    composerA4.p(Integer.valueOf(iA4), function2B4);
                                }
                                Updater.e(composerA4, modifierF4, companion5.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                function214.invoke(composer4, 0);
                                composer4.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54), composer3, 48);
                    }
                    composer3.U();
                    composer3.a0(-1287336668);
                    if (function212 != null) {
                        function212.invoke(composer3, 0);
                    }
                    composer3.U();
                    composer3.y();
                    composer3.a0(1995137078);
                    if (function213 != null || function211 != null || function212 != null) {
                        DividerKt.b(null, 0.0f, datePickerColors4.h(), composer3, 0, 3);
                    }
                    composer3.U();
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, (i4 & 112) | 196614 | (57344 & (i4 >> 6)));
            composer2 = composerK;
            function24.invoke(composer2, Integer.valueOf((i4 >> 21) & 14));
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$3
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
                    DatePickerKt.a(modifier, function2, function22, function23, datePickerColors, textStyle, f3, function24, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
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
    /* JADX WARN: Removed duplicated region for block: B:133:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0216  */
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
    public static final void b(final androidx.compose.material3.DatePickerState r25, androidx.compose.ui.Modifier r26, androidx.compose.material3.DatePickerFormatter r27, kotlin.jvm.functions.Function2 r28, kotlin.jvm.functions.Function2 r29, boolean r30, androidx.compose.material3.DatePickerColors r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.b(androidx.compose.material3.DatePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Long l3, final long j3, final Function1 function1, final Function1 function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Object obj;
        Composer composerK = composer.k(-434467002);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(l3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function12) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(calendarModel) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(intRange) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= (2097152 & i3) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.Z(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-434467002, i4, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1491)");
            }
            final CalendarMonth calendarMonthG = calendarModel.g(j3);
            int iF = RangesKt.f(calendarMonthG.g(intRange), 0);
            final LazyListState lazyListStateB = LazyListStateKt.b(iF, 0, composerK, 0, 2);
            Integer numValueOf = Integer.valueOf(iF);
            boolean Z = composerK.Z(lazyListStateB) | composerK.e(iF);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                obj = null;
                objG = new DatePickerKt$DatePickerContent$1$1(lazyListStateB, iF, null);
                composerK.w(objG);
            } else {
                obj = null;
            }
            EffectsKt.g(numValueOf, (Function2) objG, composerK, 0);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composerK));
                composerK.w(compositionScopedCoroutineScopeCanceller);
                objG2 = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG2).a();
            final MutableState mutableState = (MutableState) RememberSaveableKt.e(new Object[0], null, null, new Function0<MutableState<Boolean>>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2
                @Override // kotlin.jvm.functions.Function0
                public final MutableState invoke() {
                    return SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                }
            }, composerK, 3072, 6);
            Locale localeA = CalendarLocale_androidKt.a(composerK, 0);
            Modifier.Companion companion2 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = f16924c;
            int i5 = i4;
            Modifier modifierK = PaddingKt.k(companion2, f3, 0.0f, 2, null);
            boolean zF = lazyListStateB.f();
            boolean zD = lazyListStateB.d();
            boolean zD2 = d(mutableState);
            String strB = datePickerFormatter.b(Long.valueOf(j3), localeA);
            if (strB == null) {
                strB = "-";
            }
            boolean zI = composerK.I(coroutineScopeA) | composerK.Z(lazyListStateB);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$1$1

                    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$2$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$2$1$1$1", f = "DatePicker.kt", l = {1527}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f16971a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ LazyListState f16972b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(LazyListState lazyListState, Continuation continuation) {
                            super(2, continuation);
                            this.f16972b = lazyListState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f16972b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f16971a;
                            try {
                                if (i3 == 0) {
                                    ResultKt.b(obj);
                                    LazyListState lazyListState = this.f16972b;
                                    int iS = lazyListState.s() + 1;
                                    this.f16971a = 1;
                                    if (LazyListState.l(lazyListState, iS, 0, this, 2, null) == objF) {
                                        return objF;
                                    }
                                } else {
                                    if (i3 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                }
                            } catch (IllegalArgumentException unused) {
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
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m151invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m151invoke() {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(lazyListStateB, null), 3, null);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
            boolean zI2 = composerK.I(coroutineScopeA) | composerK.Z(lazyListStateB);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$2$1

                    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$2$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$2$2$1$1", f = "DatePicker.kt", l = {1539}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f16975a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ LazyListState f16976b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(LazyListState lazyListState, Continuation continuation) {
                            super(2, continuation);
                            this.f16976b = lazyListState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f16976b, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f16975a;
                            try {
                                if (i3 == 0) {
                                    ResultKt.b(obj);
                                    LazyListState lazyListState = this.f16976b;
                                    int iS = lazyListState.s() - 1;
                                    this.f16975a = 1;
                                    if (LazyListState.l(lazyListState, iS, 0, this, 2, null) == objF) {
                                        return objF;
                                    }
                                } else {
                                    if (i3 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                }
                            } catch (IllegalArgumentException unused) {
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
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m152invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m152invoke() {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(lazyListStateB, null), 3, null);
                    }
                };
                composerK.w(objG4);
            }
            Function0 function02 = (Function0) objG4;
            boolean Z2 = composerK.Z(mutableState);
            Object objG5 = composerK.G();
            if (Z2 || objG5 == companion.a()) {
                objG5 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$3$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m153invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m153invoke() {
                        DatePickerKt.e(mutableState, !DatePickerKt.d(r0));
                    }
                };
                composerK.w(objG5);
            }
            Function0 function03 = (Function0) objG5;
            int i6 = 234881024 & i5;
            k(modifierK, zF, zD, zD2, strB, function0, function02, function03, datePickerColors, composerK, i6 | 6);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyG, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierK2 = PaddingKt.k(companion2, f3, 0.0f, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierK2);
            Function0 function0A3 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyA2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            m(datePickerColors, calendarModel, composerK, ((i5 >> 24) & 14) | ((i5 >> 9) & 112));
            i(lazyListStateB, l3, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composerK, ((i5 << 3) & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | i6);
            composerK.y();
            AnimatedVisibilityKt.j(d(mutableState), ClipKt.b(companion2), EnterExitTransitionKt.m(null, null, false, null, 15, null).c(EnterExitTransitionKt.o(null, 0.6f, 1, null)), EnterExitTransitionKt.A(null, null, false, null, 15, null).c(EnterExitTransitionKt.q(null, 0.0f, 3, null)), null, ComposableLambdaKt.e(1193716082, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    invoke((AnimatedVisibilityScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, int i7) {
                    if (ComposerKt.M()) {
                        ComposerKt.U(1193716082, i7, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1576)");
                    }
                    Strings.Companion companion5 = Strings.f22102b;
                    final String strA = Strings_androidKt.a(Strings.a(R.string.B), composer2, 0);
                    Modifier.Companion companion6 = Modifier.b8;
                    boolean Z3 = composer2.Z(strA);
                    Object objG6 = composer2.G();
                    if (Z3 || objG6 == Composer.f23746a.a()) {
                        objG6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$1$1
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
                                SemanticsPropertiesKt.n0(semanticsPropertyReceiver, strA);
                            }
                        };
                        composer2.w(objG6);
                    }
                    Modifier modifierF4 = SemanticsModifierKt.f(companion6, false, (Function1) objG6, 1, null);
                    long j4 = j3;
                    final MutableState mutableState2 = mutableState;
                    final CoroutineScope coroutineScope = coroutineScopeA;
                    final LazyListState lazyListState = lazyListStateB;
                    final IntRange intRange2 = intRange;
                    final CalendarMonth calendarMonth = calendarMonthG;
                    SelectableDates selectableDates2 = selectableDates;
                    CalendarModel calendarModel2 = calendarModel;
                    DatePickerColors datePickerColors2 = datePickerColors;
                    MeasurePolicy measurePolicyA3 = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA4 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU4 = composer2.u();
                    Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierF4);
                    ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                    Function0 function0A4 = companion7.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A4);
                    } else {
                        composer2.v();
                    }
                    Composer composerA4 = Updater.a(composer2);
                    Updater.e(composerA4, measurePolicyA3, companion7.e());
                    Updater.e(composerA4, compositionLocalMapU4, companion7.g());
                    Function2 function2B4 = companion7.b();
                    if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                        composerA4.w(Integer.valueOf(iA4));
                        composerA4.p(Integer.valueOf(iA4), function2B4);
                    }
                    Updater.e(composerA4, modifierF5, companion7.f());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                    Modifier modifierK3 = PaddingKt.k(SizeKt.l(companion6, Dp.g(Dp.g(DatePickerKt.I() * 7) - DividerDefaults.f17464a.b())), DatePickerKt.G(), 0.0f, 2, null);
                    boolean Z4 = composer2.Z(mutableState2) | composer2.I(coroutineScope) | composer2.Z(lazyListState) | composer2.I(intRange2) | composer2.Z(calendarMonth);
                    Object objG7 = composer2.G();
                    if (Z4 || objG7 == Composer.f23746a.a()) {
                        Object obj2 = new Function1<Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$2$1$1

                            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$2$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$2$1$1$1", f = "DatePicker.kt", l = {1597}, m = "invokeSuspend")
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                int f16993a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                final /* synthetic */ LazyListState f16994b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ int f16995c;

                                /* JADX INFO: renamed from: d, reason: collision with root package name */
                                final /* synthetic */ IntRange f16996d;

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                final /* synthetic */ CalendarMonth f16997f;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(LazyListState lazyListState, int i3, IntRange intRange, CalendarMonth calendarMonth, Continuation continuation) {
                                    super(2, continuation);
                                    this.f16994b = lazyListState;
                                    this.f16995c = i3;
                                    this.f16996d = intRange;
                                    this.f16997f = calendarMonth;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new AnonymousClass1(this.f16994b, this.f16995c, this.f16996d, this.f16997f, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f16993a;
                                    if (i3 == 0) {
                                        ResultKt.b(obj);
                                        LazyListState lazyListState = this.f16994b;
                                        int iG = (((this.f16995c - this.f16996d.g()) * 12) + this.f16997f.c()) - 1;
                                        this.f16993a = 1;
                                        if (LazyListState.K(lazyListState, iG, 0, this, 2, null) == objF) {
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
                                super(1);
                            }

                            public final void c(int i8) {
                                DatePickerKt.e(mutableState2, !DatePickerKt.d(r0));
                                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(lazyListState, i8, intRange2, calendarMonth, null), 3, null);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                c(((Number) obj3).intValue());
                                return Unit.f139807a;
                            }
                        };
                        composer2.w(obj2);
                        objG7 = obj2;
                    }
                    DatePickerKt.o(modifierK3, j4, (Function1) objG7, selectableDates2, calendarModel2, intRange2, datePickerColors2, composer2, 6);
                    DividerKt.b(null, 0.0f, datePickerColors2.h(), composer2, 0, 3);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 200112, 16);
            composerK = composerK;
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$3
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
                    DatePickerKt.c(l3, j3, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    public static final void f(final Modifier modifier, final Function2 function2, final long j3, final long j4, final float f3, final Function2 function22, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-996037719);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function22) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-996037719, i4, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1621)");
            }
            Modifier modifierThen = SizeKt.h(modifier, 0.0f, 1, null).then(function2 != null ? SizeKt.b(Modifier.b8, 0.0f, f3, 1, null) : Modifier.b8);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.e(), Alignment.f25072a.k(), composerK, 6);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(594325590);
            if (function2 != null) {
                ProvideContentColorTextStyleKt.a(j3, TypographyKt.c(DatePickerModalTokens.f22450a.s(), composerK, 6), ComposableLambdaKt.e(1936268514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1
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
                            ComposerKt.U(1936268514, i5, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1636)");
                        }
                        Alignment alignmentD = Alignment.f25072a.d();
                        Function2 function23 = function2;
                        Modifier.Companion companion2 = Modifier.b8;
                        MeasurePolicy measurePolicyG = BoxKt.g(alignmentD, false);
                        int iA2 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU2 = composer2.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer2, companion2);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                        Function0 function0A2 = companion3.a();
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
                        Updater.e(composerA2, measurePolicyG, companion3.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                        Function2 function2B2 = companion3.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion3.f());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                        function23.invoke(composer2, 0);
                        composer2.y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384);
            }
            composerK.U();
            CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j4)), function22, composerK, ProvidedValue.f24012i | ((i4 >> 12) & 112));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$2
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
                    DatePickerKt.f(modifier, function2, j3, j4, f3, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final Modifier modifier, final boolean z2, final Function0 function0, final boolean z3, final boolean z4, final boolean z5, final boolean z6, final String str, final DatePickerColors datePickerColors, final Function2 function2, Composer composer, final int i3) {
        int i4;
        boolean z7;
        boolean z8;
        boolean z9;
        DatePickerColors datePickerColors2;
        Composer composerK = composer.k(-1434777861);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            z7 = z3;
            i4 |= composerK.b(z7) ? 2048 : 1024;
        } else {
            z7 = z3;
        }
        if ((i3 & 24576) == 0) {
            z8 = z4;
            i4 |= composerK.b(z8) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z8 = z4;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.b(z5) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            z9 = z6;
            i4 |= composerK.b(z9) ? 1048576 : 524288;
        } else {
            z9 = z6;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.Z(str) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i4 |= composerK.Z(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((805306368 & i3) == 0) {
            i4 |= composerK.I(function2) ? 536870912 : 268435456;
        }
        int i5 = i4;
        if ((306783379 & i5) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1434777861, i5, -1, "androidx.compose.material3.Day (DatePicker.kt:1941)");
            }
            boolean z10 = (29360128 & i5) == 8388608;
            Object objG = composerK.G();
            if (z10 || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$1$1
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
                        SemanticsPropertiesKt.y0(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.a());
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierE = SemanticsModifierKt.e(modifier, true, (Function1) objG);
            DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.f22450a;
            Shape shapeE = ShapesKt.e(datePickerModalTokens.e(), composerK, 6);
            int i6 = i5 >> 3;
            int i7 = i5 >> 15;
            long jB = ((Color) datePickerColors2.c(z2, z8, z7, composerK, (i7 & 7168) | (i6 & 14) | ((i5 >> 9) & 112) | (i6 & 896)).getValue()).B();
            int i8 = i5 >> 12;
            SurfaceKt.b(z2, function0, modifierE, z4, shapeE, jB, ((Color) datePickerColors.d(z5, z2, z9, z4, composerK, (i7 & 14) | (i5 & 112) | (i8 & 896) | (i6 & 7168) | (i8 & 57344)).getValue()).B(), 0.0f, 0.0f, (!z5 || z2) ? null : BorderStrokeKt.a(datePickerModalTokens.l(), datePickerColors.m()), null, ComposableLambdaKt.e(-2031780827, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    if ((i9 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-2031780827, i9, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:1980)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    DatePickerModalTokens datePickerModalTokens2 = DatePickerModalTokens.f22450a;
                    Modifier modifierP = SizeKt.p(companion, datePickerModalTokens2.j(), datePickerModalTokens2.i());
                    Alignment alignmentE = Alignment.f25072a.e();
                    Function2 function22 = function2;
                    MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierP);
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
                    Updater.e(composerA, measurePolicyG, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    function22.invoke(composer2, 0);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, i6 & 7294, 48, 1408);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$3
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
                    DatePickerKt.g(modifier, z2, function0, z3, z4, z5, z6, str, datePickerColors, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void h(Modifier modifier, final int i3, final Function1 function1, Composer composer, final int i4) {
        int i5;
        boolean z2;
        final Modifier modifier2;
        Composer composerK = composer.k(1393846115);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1393846115, i5, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1361)");
            }
            if (DisplayMode.f(i3, DisplayMode.f17460b.b())) {
                composerK.a0(-411219388);
                z2 = (i5 & 896) == 256;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m154invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m154invoke() {
                            function1.invoke(DisplayMode.c(DisplayMode.f17460b.a()));
                        }
                    };
                    composerK.w(objG);
                }
                modifier2 = modifier;
                IconButtonKt.e((Function0) objG, modifier2, false, null, null, ComposableSingletons$DatePickerKt.f16717a.a(), composerK, ((i5 << 3) & 112) | 196608, 28);
                composerK.U();
            } else {
                composerK.a0(-410937381);
                z2 = (i5 & 896) == 256;
                Object objG2 = composerK.G();
                if (z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$2$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m155invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m155invoke() {
                            function1.invoke(DisplayMode.c(DisplayMode.f17460b.b()));
                        }
                    };
                    composerK.w(objG2);
                }
                modifier2 = modifier;
                IconButtonKt.e((Function0) objG2, modifier2, false, null, null, ComposableSingletons$DatePickerKt.f16717a.b(), composerK, ((i5 << 3) & 112) | 196608, 28);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$3
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
                    DatePickerKt.h(modifier2, i3, function1, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LazyListState lazyListState, final Long l3, final Function1 function1, final Function1 function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Long l4;
        final Function1 function13;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Object datePickerKt$HorizontalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerK = composer.k(-1994757941);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(lazyListState2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            l4 = l3;
            i4 |= composerK.Z(l4) ? 32 : 16;
        } else {
            l4 = l3;
        }
        if ((i3 & 384) == 0) {
            function13 = function1;
            i4 |= composerK.I(function13) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function13 = function1;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function12) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(calendarModel) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(intRange) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= (2097152 & i3) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerK.Z(selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i4 |= composerK.Z(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1994757941, i4, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1656)");
            }
            final CalendarDate calendarDateI = calendarModel.i();
            boolean Z = composerK.Z(intRange);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = calendarModel.f(intRange.g(), 1);
                composerK.w(objG);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) objG;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final SelectableDates selectableDates3 = selectableDates2;
            final Long l5 = l4;
            int i5 = i4;
            TextKt.a(TypographyKt.c(DatePickerModalTokens.f22450a.f(), composerK, 6), ComposableLambdaKt.e(1504086906, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1
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
                        ComposerKt.U(1504086906, i6, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1666)");
                    }
                    Modifier modifierF = SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.j0(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    LazyListState lazyListState3 = lazyListState2;
                    FlingBehavior flingBehaviorK = DatePickerDefaults.f16873a.k(lazyListState3, null, composer2, 384, 2);
                    boolean zI = composer2.I(intRange) | composer2.I(calendarModel) | composer2.Z(calendarMonth) | composer2.Z(function13) | composer2.Z(calendarDateI) | composer2.Z(l5) | composer2.I(datePickerFormatter) | composer2.Z(selectableDates3) | composer2.Z(datePickerColors3);
                    final IntRange intRange2 = intRange;
                    final CalendarModel calendarModel2 = calendarModel;
                    final CalendarMonth calendarMonth2 = calendarMonth;
                    final Function1 function14 = function13;
                    final CalendarDate calendarDate = calendarDateI;
                    final Long l6 = l5;
                    final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                    final SelectableDates selectableDates4 = selectableDates3;
                    final DatePickerColors datePickerColors4 = datePickerColors3;
                    Object objG2 = composer2.G();
                    if (zI || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((LazyListScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(LazyListScope lazyListScope) {
                                int iJ = DatePickerKt.J(intRange2);
                                final CalendarModel calendarModel3 = calendarModel2;
                                final CalendarMonth calendarMonth3 = calendarMonth2;
                                final Function1 function15 = function14;
                                final CalendarDate calendarDate2 = calendarDate;
                                final Long l7 = l6;
                                final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                final SelectableDates selectableDates5 = selectableDates4;
                                final DatePickerColors datePickerColors5 = datePickerColors4;
                                LazyListScope.b(lazyListScope, iJ, null, null, ComposableLambdaKt.c(1137566309, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(LazyItemScope lazyItemScope, int i7, Composer composer3, int i8) {
                                        int i9;
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
                                            ComposerKt.U(1137566309, i9, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1678)");
                                        }
                                        CalendarMonth calendarMonthL = calendarModel3.l(calendarMonth3, i7);
                                        Modifier modifierA = LazyItemScope.a(lazyItemScope, Modifier.b8, 0.0f, 1, null);
                                        Function1 function16 = function15;
                                        CalendarDate calendarDate3 = calendarDate2;
                                        Long l8 = l7;
                                        DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                        SelectableDates selectableDates6 = selectableDates5;
                                        DatePickerColors datePickerColors6 = datePickerColors5;
                                        MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                        int iA = ComposablesKt.a(composer3, 0);
                                        CompositionLocalMap compositionLocalMapU = composer3.u();
                                        Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierA);
                                        ComposeUiNode.Companion companion = ComposeUiNode.f8;
                                        Function0 function0A = companion.a();
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
                                        Updater.e(composerA, measurePolicyG, companion.e());
                                        Updater.e(composerA, compositionLocalMapU, companion.g());
                                        Function2 function2B = companion.b();
                                        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                            composerA.w(Integer.valueOf(iA));
                                            composerA.p(Integer.valueOf(iA), function2B);
                                        }
                                        Updater.e(composerA, modifierF2, companion.f());
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                        DatePickerKt.j(calendarMonthL, function16, calendarDate3.d(), l8, null, null, datePickerFormatter4, selectableDates6, datePickerColors6, composer3, 221184);
                                        composer3.y();
                                        if (ComposerKt.M()) {
                                            ComposerKt.T();
                                        }
                                    }
                                }), 6, null);
                            }
                        };
                        composer2.w(objG2);
                    }
                    LazyDslKt.f(modifierF, lazyListState3, null, false, null, null, flingBehaviorK, false, (Function1) objG2, composer2, 0, 188);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            int i6 = i5 & 14;
            boolean zI = (i6 == 4) | ((i5 & 7168) == 2048) | composerK.I(calendarModel) | composerK.I(intRange);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                lazyListState2 = lazyListState;
                datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, function12, calendarModel, intRange, null);
                composerK.w(datePickerKt$HorizontalMonthsList$2$1);
            } else {
                datePickerKt$HorizontalMonthsList$2$1 = objG2;
                lazyListState2 = lazyListState;
            }
            EffectsKt.g(lazyListState2, (Function2) datePickerKt$HorizontalMonthsList$2$1, composerK, i6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3
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
                    DatePickerKt.i(lazyListState2, l3, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(final androidx.compose.material3.internal.CalendarMonth r30, final kotlin.jvm.functions.Function1 r31, final long r32, final java.lang.Long r34, final java.lang.Long r35, final androidx.compose.material3.SelectedRangeInfo r36, final androidx.compose.material3.DatePickerFormatter r37, final androidx.compose.material3.SelectableDates r38, final androidx.compose.material3.DatePickerColors r39, androidx.compose.runtime.Composer r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.j(androidx.compose.material3.internal.CalendarMonth, kotlin.jvm.functions.Function1, long, java.lang.Long, java.lang.Long, androidx.compose.material3.SelectedRangeInfo, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.SelectableDates, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final Modifier modifier, final boolean z2, final boolean z3, final boolean z4, final String str, final Function0 function0, final Function0 function02, final Function0 function03, DatePickerColors datePickerColors, Composer composer, final int i3) {
        int i4;
        Function0 function04;
        Function0 function05;
        DatePickerColors datePickerColors2;
        Composer composerK = composer.k(-773929258);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(str) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            function04 = function02;
            i4 |= composerK.I(function04) ? 1048576 : 524288;
        } else {
            function04 = function02;
        }
        if ((12582912 & i3) == 0) {
            function05 = function03;
            i4 |= composerK.I(function05) ? 8388608 : 4194304;
        } else {
            function05 = function03;
        }
        if ((100663296 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i4 |= composerK.Z(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-773929258, i4, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2150)");
            }
            Modifier modifierL = SizeKt.l(SizeKt.h(modifier, 0.0f, 1, null), f16923b);
            MeasurePolicy measurePolicyB = RowKt.b(z4 ? Arrangement.f6574a.g() : Arrangement.f6574a.e(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierL);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            final Function0 function06 = function04;
            final Function0 function07 = function05;
            CompositionLocalKt.b(ContentColorKt.a().d(Color.n(datePickerColors2.j())), ComposableLambdaKt.e(-962805198, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1
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
                        ComposerKt.U(-962805198, i5, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2163)");
                    }
                    Function0 function08 = function07;
                    boolean z5 = z4;
                    final String str2 = str;
                    DatePickerKt.p(function08, z5, null, ComposableLambdaKt.e(1377272806, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1.1
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
                                ComposerKt.U(1377272806, i6, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2167)");
                            }
                            String str3 = str2;
                            Modifier.Companion companion2 = Modifier.b8;
                            boolean Z = composer3.Z(str3);
                            final String str4 = str2;
                            Object objG = composer3.G();
                            if (Z || objG == Composer.f23746a.a()) {
                                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1$1$1
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
                                        SemanticsPropertiesKt.l0(semanticsPropertyReceiver, LiveRegionMode.f28448b.b());
                                        SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str4);
                                    }
                                };
                                composer3.w(objG);
                            }
                            TextKt.c(str3, SemanticsModifierKt.f(companion2, false, (Function1) objG, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131068);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 4);
                    if (!z4) {
                        Function0 function09 = function06;
                        boolean z6 = z3;
                        Function0 function010 = function0;
                        boolean z7 = z2;
                        Modifier.Companion companion2 = Modifier.b8;
                        MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer2, 0);
                        int iA2 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU2 = composer2.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer2, companion2);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                        Function0 function0A2 = companion3.a();
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
                        Updater.e(composerA2, measurePolicyB2, companion3.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                        Function2 function2B2 = companion3.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion3.f());
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                        ComposableSingletons$DatePickerKt composableSingletons$DatePickerKt = ComposableSingletons$DatePickerKt.f16717a;
                        IconButtonKt.e(function09, null, z6, null, null, composableSingletons$DatePickerKt.c(), composer2, 196608, 26);
                        IconButtonKt.e(function010, null, z7, null, null, composableSingletons$DatePickerKt.d(), composer2, 196608, 26);
                        composer2.y();
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final DatePickerColors datePickerColors3 = datePickerColors2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$2
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
                    DatePickerKt.k(modifier, z2, z3, z4, str, function0, function02, function03, datePickerColors3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final Long l3, final long j3, final int i3, final Function1 function1, final Function1 function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i4) {
        int i5;
        Function1 function13;
        Function1 function14;
        CalendarModel calendarModel2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Composer composer2;
        Composer composerK = composer.k(-895379221);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(l3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            function13 = function1;
            i5 |= composerK.I(function13) ? 2048 : 1024;
        } else {
            function13 = function1;
        }
        if ((i4 & 24576) == 0) {
            function14 = function12;
            i5 |= composerK.I(function14) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function14 = function12;
        }
        if ((196608 & i4) == 0) {
            calendarModel2 = calendarModel;
            i5 |= composerK.I(calendarModel2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((1572864 & i4) == 0) {
            intRange2 = intRange;
            i5 |= composerK.I(intRange2) ? 1048576 : 524288;
        } else {
            intRange2 = intRange;
        }
        if ((12582912 & i4) == 0) {
            i5 |= (16777216 & i4) == 0 ? composerK.Z(datePickerFormatter) : composerK.I(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            selectableDates2 = selectableDates;
            i5 |= composerK.Z(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((805306368 & i4) == 0) {
            datePickerColors2 = datePickerColors;
            i5 |= composerK.Z(datePickerColors2) ? 536870912 : 268435456;
        } else {
            datePickerColors2 = datePickerColors;
        }
        int i6 = i5;
        if ((306783379 & i6) == 306783378 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-895379221, i6, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1396)");
            }
            final int i7 = -((Density) composerK.q(CompositionLocalsKt.f())).z0(Dp.g(48));
            DisplayMode displayModeC = DisplayMode.c(i3);
            Modifier modifierF = SemanticsModifierKt.f(Modifier.b8, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.b0(semanticsPropertyReceiver, true);
                }
            }, 1, null);
            boolean zE = composerK.e(i7);
            Object objG = composerK.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function1<AnimatedContentTransitionScope<DisplayMode>, ContentTransform>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope animatedContentTransitionScope) {
                        ContentTransform contentTransformF;
                        if (DisplayMode.f(((DisplayMode) animatedContentTransitionScope.a()).i(), DisplayMode.f17460b.a())) {
                            EnterTransition enterTransitionC = EnterExitTransitionKt.F(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.1
                                public final Integer invoke(int i8) {
                                    return Integer.valueOf(i8);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).c(EnterExitTransitionKt.o(AnimationSpecKt.n(100, 100, null, 4, null), 0.0f, 2, null));
                            ExitTransition exitTransitionQ = EnterExitTransitionKt.q(AnimationSpecKt.n(100, 0, null, 6, null), 0.0f, 2, null);
                            final int i8 = i7;
                            contentTransformF = AnimatedContentKt.f(enterTransitionC, exitTransitionQ.c(EnterExitTransitionKt.K(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Integer invoke(int i9) {
                                    return Integer.valueOf(i8);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null)));
                        } else {
                            TweenSpec tweenSpecN = AnimationSpecKt.n(0, 50, null, 5, null);
                            final int i9 = i7;
                            contentTransformF = AnimatedContentKt.f(EnterExitTransitionKt.E(tweenSpecN, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }

                                public final Integer invoke(int i10) {
                                    return Integer.valueOf(i9);
                                }
                            }).c(EnterExitTransitionKt.o(AnimationSpecKt.n(100, 100, null, 4, null), 0.0f, 2, null)), EnterExitTransitionKt.K(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.4
                                public final Integer invoke(int i10) {
                                    return Integer.valueOf(i10);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke(((Number) obj).intValue());
                                }
                            }, 1, null).c(EnterExitTransitionKt.q(AnimationSpecKt.n(100, 0, null, 6, null), 0.0f, 2, null)));
                        }
                        return animatedContentTransitionScope.b(contentTransformF, AnimatedContentKt.c(true, new Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.5
                            public final FiniteAnimationSpec c(long j4, long j5) {
                                return AnimationSpecKt.n(500, 0, MotionTokens.f22946a.b(), 2, null);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return c(((IntSize) obj).j(), ((IntSize) obj2).j());
                            }
                        }));
                    }
                };
                composerK.w(objG);
            }
            final Function1 function15 = function13;
            final Function1 function16 = function14;
            final CalendarModel calendarModel3 = calendarModel2;
            final IntRange intRange3 = intRange2;
            final SelectableDates selectableDates3 = selectableDates2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            composer2 = composerK;
            AnimatedContentKt.b(displayModeC, modifierF, (Function1) objG, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.e(-459778869, true, new Function4<AnimatedContentScope, DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                public final void c(AnimatedContentScope animatedContentScope, int i8, Composer composer3, int i9) {
                    if (ComposerKt.M()) {
                        ComposerKt.U(-459778869, i9, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1452)");
                    }
                    DisplayMode.Companion companion = DisplayMode.f17460b;
                    if (DisplayMode.f(i8, companion.b())) {
                        composer3.a0(-1870116901);
                        DatePickerKt.c(l3, j3, function15, function16, calendarModel3, intRange3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.U();
                    } else if (DisplayMode.f(i8, companion.a())) {
                        composer3.a0(-1870098348);
                        DateInputKt.a(l3, function15, calendarModel3, intRange3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.U();
                    } else {
                        composer3.a0(-2138080579);
                        composer3.U();
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((AnimatedContentScope) obj, ((DisplayMode) obj2).i(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composer2, ((i6 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
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
                    DatePickerKt.l(l3, j3, i3, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void m(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-1849465391);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(datePickerColors) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(calendarModel) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1849465391, i4, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1728)");
            }
            int iD = calendarModel.d();
            List listJ = calendarModel.j();
            ArrayList arrayList = new ArrayList();
            int i5 = iD - 1;
            int size = listJ.size();
            for (int i6 = i5; i6 < size; i6++) {
                arrayList.add(listJ.get(i6));
            }
            ?? r8 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                arrayList.add(listJ.get(i7));
            }
            TextStyle textStyleC = TypographyKt.c(DatePickerModalTokens.f22450a.H(), composerK, 6);
            Modifier modifierH = SizeKt.h(SizeKt.b(Modifier.b8, 0.0f, f16922a, 1, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.f(), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(396197267);
            int size2 = arrayList.size();
            int i8 = 0;
            while (i8 < size2) {
                final Pair pair = (Pair) arrayList.get(i8);
                Modifier.Companion companion2 = Modifier.b8;
                boolean Z = composerK.Z(pair);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.d0(semanticsPropertyReceiver, (String) pair.e());
                        }
                    };
                    composerK.w(objG);
                }
                Modifier modifierC = SemanticsModifierKt.c(companion2, (Function1) objG);
                float f3 = f16922a;
                Modifier modifierX = SizeKt.x(modifierC, f3, f3);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), r8);
                int iA2 = ComposablesKt.a(composerK, r8);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierX);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
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
                Composer composer3 = composerK;
                TextKt.c((String) pair.f(), SizeKt.G(companion2, null, false, 3, null), datePickerColors.n(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, textStyleC, composer3, 48, 0, 65016);
                composer3.y();
                i8++;
                composerK = composer3;
                arrayList = arrayList;
                r8 = 0;
            }
            composer2 = composerK;
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer4, int i9) {
                    DatePickerKt.m(datePickerColors, calendarModel, composer4, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final Modifier modifier, final boolean z2, final boolean z3, final Function0 function0, final boolean z4, final String str, final DatePickerColors datePickerColors, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Object objA;
        Composer composerK = composer.k(238547184);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(str) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(datePickerColors) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & i4) == 4793490 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(238547184, i4, -1, "androidx.compose.material3.Year (DatePicker.kt:2097)");
            }
            int i5 = i4 & 112;
            boolean z5 = ((i4 & 896) == 256) | (i5 == 32);
            Object objG = composerK.G();
            if (z5 || objG == Composer.f23746a.a()) {
                objA = (!z3 || z2) ? null : BorderStrokeKt.a(DatePickerModalTokens.f22450a.l(), datePickerColors.m());
                composerK.w(objA);
            } else {
                objA = objG;
            }
            BorderStroke borderStroke = (BorderStroke) objA;
            boolean z6 = (458752 & i4) == 131072;
            Object objG2 = composerK.G();
            if (z6 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$1$1
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
                        SemanticsPropertiesKt.y0(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.a());
                    }
                };
                composerK.w(objG2);
            }
            int i6 = i4 >> 3;
            int i7 = i6 & 14;
            int i8 = i4 >> 9;
            int i9 = i4 >> 6;
            SurfaceKt.b(z2, function0, SemanticsModifierKt.e(modifier, true, (Function1) objG2), z4, ShapesKt.e(DatePickerModalTokens.f22450a.E(), composerK, 6), ((Color) datePickerColors.p(z2, z4, composerK, i7 | (i8 & 112) | ((i4 >> 12) & 896)).getValue()).B(), ((Color) datePickerColors.q(z3, z2, z4, composerK, (i9 & 14) | i5 | (i9 & 896) | (i8 & 7168)).getValue()).B(), 0.0f, 0.0f, borderStroke, null, ComposableLambdaKt.e(-1573188346, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1573188346, i10, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2130)");
                    }
                    Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                    Alignment alignmentE = Alignment.f25072a.e();
                    Function2 function22 = function2;
                    MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    function22.invoke(composer2, 0);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, i7 | (i9 & 112) | (i6 & 7168), 48, 1408);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    DatePickerKt.n(modifier, z2, z3, function0, z4, str, datePickerColors, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final Modifier modifier, final long j3, final Function1 function1, final SelectableDates selectableDates, final CalendarModel calendarModel, final IntRange intRange, final DatePickerColors datePickerColors, Composer composer, final int i3) {
        Modifier modifier2;
        int i4;
        Function1 function12;
        SelectableDates selectableDates2;
        CalendarModel calendarModel2;
        IntRange intRange2;
        DatePickerColors datePickerColors2;
        Composer composerK = composer.k(-1286899812);
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerK.Z(selectableDates2) ? 2048 : 1024;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i3 & 24576) == 0) {
            calendarModel2 = calendarModel;
            i4 |= composerK.I(calendarModel2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((196608 & i3) == 0) {
            intRange2 = intRange;
            i4 |= composerK.I(intRange2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            intRange2 = intRange;
        }
        if ((1572864 & i3) == 0) {
            datePickerColors2 = datePickerColors;
            i4 |= composerK.Z(datePickerColors2) ? 1048576 : 524288;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((599187 & i4) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1286899812, i4, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:2003)");
            }
            final Modifier modifier3 = modifier2;
            final Function1 function13 = function12;
            final SelectableDates selectableDates3 = selectableDates2;
            final CalendarModel calendarModel3 = calendarModel2;
            final IntRange intRange3 = intRange2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            TextKt.a(TypographyKt.c(DatePickerModalTokens.f22450a.B(), composerK, 6), ComposableLambdaKt.e(1301915789, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1
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
                        ComposerKt.U(1301915789, i5, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:2005)");
                    }
                    CalendarModel calendarModel4 = calendarModel3;
                    final int iF = calendarModel4.h(calendarModel4.i()).f();
                    final int iF2 = calendarModel3.g(j3).f();
                    final LazyGridState lazyGridStateB = LazyGridStateKt.b(Math.max(0, (iF2 - intRange3.g()) - 3), 0, composer2, 0, 2);
                    long jE = datePickerColors3.e();
                    Object objG = composer2.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer2));
                        composer2.w(compositionScopedCoroutineScopeCanceller);
                        objG = compositionScopedCoroutineScopeCanceller;
                    }
                    final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
                    Strings.Companion companion2 = Strings.f22102b;
                    final String strA = Strings_androidKt.a(Strings.a(R.string.f19315r), composer2, 0);
                    final String strA2 = Strings_androidKt.a(Strings.a(R.string.f19316s), composer2, 0);
                    GridCells.Fixed fixed = new GridCells.Fixed(3);
                    Modifier modifierF = SemanticsModifierKt.f(BackgroundKt.d(modifier3, jE, null, 2, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.I0(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f);
                                }
                            }, false, 4, null));
                        }
                    }, 1, null);
                    Arrangement arrangement = Arrangement.f6574a;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalF = arrangement.f();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(DatePickerKt.f16928g);
                    boolean zI = composer2.I(intRange3) | composer2.Z(lazyGridStateB) | composer2.I(coroutineScopeA) | composer2.Z(strA) | composer2.Z(strA2) | composer2.e(iF2) | composer2.e(iF) | composer2.Z(function13) | composer2.Z(selectableDates3) | composer2.Z(datePickerColors3);
                    final IntRange intRange4 = intRange3;
                    final Function1 function14 = function13;
                    final SelectableDates selectableDates4 = selectableDates3;
                    final DatePickerColors datePickerColors4 = datePickerColors3;
                    Object objG2 = composer2.G();
                    if (zI || objG2 == companion.a()) {
                        Object obj = new Function1<LazyGridScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((LazyGridScope) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(LazyGridScope lazyGridScope) {
                                int iCount = CollectionsKt.count(intRange4);
                                final IntRange intRange5 = intRange4;
                                final LazyGridState lazyGridState = lazyGridStateB;
                                final CoroutineScope coroutineScope = coroutineScopeA;
                                final String str = strA;
                                final String str2 = strA2;
                                final int i6 = iF2;
                                final int i7 = iF;
                                final Function1 function15 = function14;
                                final SelectableDates selectableDates5 = selectableDates4;
                                final DatePickerColors datePickerColors5 = datePickerColors4;
                                LazyGridScope.d(lazyGridScope, iCount, null, null, null, ComposableLambdaKt.c(1040623618, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        invoke((LazyGridItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(LazyGridItemScope lazyGridItemScope, final int i8, Composer composer3, int i9) {
                                        int i10;
                                        if ((i9 & 48) == 0) {
                                            i10 = i9 | (composer3.e(i8) ? 32 : 16);
                                        } else {
                                            i10 = i9;
                                        }
                                        if ((i10 & 145) == 144 && composer3.l()) {
                                            composer3.Q();
                                            return;
                                        }
                                        if (ComposerKt.M()) {
                                            ComposerKt.U(1040623618, i10, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2034)");
                                        }
                                        final int iG = i8 + intRange5.g();
                                        final String strC = CalendarLocale_jvmKt.c(iG, 0, 0, false, 7, null);
                                        Modifier.Companion companion3 = Modifier.b8;
                                        DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.f22450a;
                                        Modifier modifierP = SizeKt.p(companion3, datePickerModalTokens.A(), datePickerModalTokens.z());
                                        boolean Z = ((i10 & 112) == 32) | composer3.Z(lazyGridState) | composer3.I(coroutineScope) | composer3.Z(str) | composer3.Z(str2);
                                        final LazyGridState lazyGridState2 = lazyGridState;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final String str3 = str;
                                        final String str4 = str2;
                                        Object objG3 = composer3.G();
                                        if (Z || objG3 == Composer.f23746a.a()) {
                                            Function1<SemanticsPropertyReceiver, Unit> function16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1
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
                                                    LazyGridItemInfo lazyGridItemInfo;
                                                    SemanticsPropertiesKt.f0(semanticsPropertyReceiver, (lazyGridState2.r() == i8 || ((lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(lazyGridState2.w().h())) != null && lazyGridItemInfo.getIndex() == i8)) ? DatePickerKt.E(lazyGridState2, coroutineScope2, str3, str4) : CollectionsKt.emptyList());
                                                }
                                            };
                                            composer3.w(function16);
                                            objG3 = function16;
                                        }
                                        Modifier modifierF2 = SemanticsModifierKt.f(modifierP, false, (Function1) objG3, 1, null);
                                        boolean z2 = iG == i6;
                                        boolean z3 = iG == i7;
                                        boolean Z2 = composer3.Z(function15) | composer3.e(iG);
                                        final Function1 function17 = function15;
                                        Object objG4 = composer3.G();
                                        if (Z2 || objG4 == Composer.f23746a.a()) {
                                            objG4 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m157invoke();
                                                    return Unit.f139807a;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                                public final void m157invoke() {
                                                    function17.invoke(Integer.valueOf(iG));
                                                }
                                            };
                                            composer3.w(objG4);
                                        }
                                        Function0 function0 = (Function0) objG4;
                                        boolean zA = selectableDates5.a(iG);
                                        Strings.Companion companion4 = Strings.f22102b;
                                        String str5 = String.format(Strings_androidKt.a(Strings.a(R.string.f19313p), composer3, 0), Arrays.copyOf(new Object[]{strC}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str5, "format(this, *args)");
                                        DatePickerKt.n(modifierF2, z2, z3, function0, zA, str5, datePickerColors5, ComposableLambdaKt.e(882189459, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Composer composer4, int i11) {
                                                if ((i11 & 3) == 2 && composer4.l()) {
                                                    composer4.Q();
                                                    return;
                                                }
                                                if (ComposerKt.M()) {
                                                    ComposerKt.U(882189459, i11, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2074)");
                                                }
                                                TextKt.c(strC, SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3.1
                                                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                        invoke((SemanticsPropertyReceiver) obj2);
                                                        return Unit.f139807a;
                                                    }
                                                }), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, composer4, 0, 0, 130556);
                                                if (ComposerKt.M()) {
                                                    ComposerKt.T();
                                                }
                                            }
                                        }, composer3, 54), composer3, 12582912);
                                        if (ComposerKt.M()) {
                                            ComposerKt.T();
                                        }
                                    }
                                }), 14, null);
                            }
                        };
                        composer2.w(obj);
                        objG2 = obj;
                    }
                    LazyGridDslKt.d(fixed, modifierF, lazyGridStateB, null, false, horizontalOrVerticalO, horizontalOrVerticalF, null, false, (Function1) objG2, composer2, 1769472, 408);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$2
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
                    DatePickerKt.o(modifier, j3, function1, selectableDates, calendarModel, intRange, datePickerColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p(final kotlin.jvm.functions.Function0 r19, final boolean r20, androidx.compose.ui.Modifier r21, final kotlin.jvm.functions.Function2 r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.p(kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
