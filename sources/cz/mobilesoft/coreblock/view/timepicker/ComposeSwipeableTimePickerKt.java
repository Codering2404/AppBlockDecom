package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.Velocity;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewEvent;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

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
public final class ComposeSwipeableTimePickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        function1.invoke(LazyColumn);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Modifier modifier, int i3, Function1 function1, float f3, boolean z2, boolean z3, int i4, LazyListState lazyListState, Function0 function0, Function1 function12, int i5, int i6, Composer composer, int i7) {
        w(modifier, i3, function1, f3, z2, z3, i4, lazyListState, function0, function12, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void F(final androidx.compose.foundation.layout.RowScope r21, final cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration r22, boolean r23, final java.util.List r24, final int r25, final cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState.TimePickerColumnType r26, final kotlin.jvm.functions.Function1 r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt.F(androidx.compose.foundation.layout.RowScope, cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration, boolean, java.util.List, int, cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState$TimePickerColumnType, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, int i3) {
        function1.invoke(Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1) {
        function1.invoke(TimePickerViewEvent.OnUpdateSelectedTimeEvent.f133068a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(RowScope rowScope, TimePickerConfiguration timePickerConfiguration, boolean z2, List list, int i3, TimePickerViewState.TimePickerColumnType timePickerColumnType, Function1 function1, Function1 function12, int i4, int i5, Composer composer, int i6) {
        F(rowScope, timePickerConfiguration, z2, list, i3, timePickerColumnType, function1, function12, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final void J(final Modifier modifier, final TimePickerConfiguration timePickerConfiguration, final boolean z2, final float f3, final List list, final int i3, final TimePickerViewState.TimePickerColumnType timePickerColumnType, final Function1 function1, final Function0 function0, Composer composer, final int i4) {
        int i5;
        float f4;
        Composer composer2;
        int i6;
        int i7;
        LazyListState lazyListState;
        Composer composerK = composer.k(-344909566);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(timePickerConfiguration) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            f4 = f3;
            i5 |= composerK.c(f4) ? 2048 : 1024;
        } else {
            f4 = f3;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.I(list) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 196608) == 0) {
            i5 |= composerK.e(i3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i4 & 1572864) == 0) {
            i5 |= composerK.Z(timePickerColumnType) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i5 |= composerK.I(function1) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i5 |= composerK.I(function0) ? 67108864 : 33554432;
        }
        if (composerK.r((i5 & 38347923) != 38347922, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-344909566, i5, -1, "cz.mobilesoft.coreblock.view.timepicker.SwipeTimeColumn (ComposeSwipeableTimePicker.kt:198)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            int i8 = i5 >> 15;
            final LazyListState lazyListStateB = LazyListStateKt.b(i3, 0, composerK, i8 & 14, 2);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            boolean zK = K(mutableState);
            int iJ = timePickerConfiguration.j();
            int i9 = 234881024 & i5;
            boolean z3 = i9 == 67108864;
            Object objG3 = composerK.G();
            if (z3 || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeSwipeableTimePickerKt.M(function0, mutableState);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function02 = (Function0) objG3;
            int i10 = i5 & 7168;
            int i11 = i5;
            boolean zI = ((i5 & 896) == 256) | ((i5 & 112) == 32) | composerK.I(list) | (i10 == 2048) | ((458752 & i5) == 131072) | ((3670016 & i5) == 1048576) | composerK.I(coroutineScope) | ((i11 & 29360128) == 8388608) | composerK.Z(lazyListStateB) | (i9 == 67108864);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                final float f5 = f4;
                i6 = i10;
                i7 = i8;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeSwipeableTimePickerKt.N(list, timePickerConfiguration, f5, i3, timePickerColumnType, z2, coroutineScope, function1, lazyListStateB, function0, mutableState, (LazyListScope) obj);
                    }
                };
                lazyListState = lazyListStateB;
                composerK.w(function12);
                objG4 = function12;
            } else {
                lazyListState = lazyListStateB;
                i6 = i10;
                i7 = i8;
            }
            composer2 = composerK;
            w(modifier, i3, function1, f3, zK, true, iJ, lazyListState, function02, (Function1) objG4, composer2, (i11 & 14) | 196608 | ((i11 >> 12) & 112) | (i7 & 896) | i6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeSwipeableTimePickerKt.Q(modifier, timePickerConfiguration, z2, f3, list, i3, timePickerColumnType, function1, function0, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean K(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function0 function0, MutableState mutableState) {
        L(mutableState, false);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(final List list, final TimePickerConfiguration timePickerConfiguration, final float f3, final int i3, final TimePickerViewState.TimePickerColumnType timePickerColumnType, final boolean z2, final CoroutineScope coroutineScope, final Function1 function1, final LazyListState lazyListState, final Function0 function0, final MutableState mutableState, LazyListScope SwipeLazyColumn) {
        Intrinsics.checkNotNullParameter(SwipeLazyColumn, "$this$SwipeLazyColumn");
        LazyListScope.b(SwipeLazyColumn, list.size() + (timePickerConfiguration.j() - 1), null, null, ComposableLambdaKt.c(-1536871084, true, new Function4() { // from class: cz.mobilesoft.coreblock.view.timepicker.x
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ComposeSwipeableTimePickerKt.O(f3, list, i3, timePickerColumnType, timePickerConfiguration, z2, coroutineScope, function1, lazyListState, function0, mutableState, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(float f3, List list, int i3, TimePickerViewState.TimePickerColumnType timePickerColumnType, TimePickerConfiguration timePickerConfiguration, boolean z2, final CoroutineScope coroutineScope, final Function1 function1, final LazyListState lazyListState, final Function0 function0, final MutableState mutableState, LazyItemScope items, int i4, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        if ((i5 & 48) == 0) {
            i6 = i5 | (composer.e(i4) ? 32 : 16);
        } else {
            i6 = i5;
        }
        if (composer.r((i6 & 145) != 144, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1536871084, i6, -1, "cz.mobilesoft.coreblock.view.timepicker.SwipeTimeColumn.<anonymous>.<anonymous>.<anonymous> (ComposeSwipeableTimePicker.kt:221)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            boolean zI = composer.I(coroutineScope) | composer.Z(function1) | composer.Z(lazyListState) | composer.Z(function0);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeSwipeableTimePickerKt.P(coroutineScope, function1, lazyListState, function0, mutableState, ((Integer) obj).intValue());
                    }
                };
                composer.w(function12);
                objG = function12;
            }
            R(modifierH, f3, list, i4, i3, timePickerColumnType, timePickerConfiguration, z2, (Function1) objG, composer, ((i6 << 6) & 7168) | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(CoroutineScope coroutineScope, Function1 function1, LazyListState lazyListState, Function0 function0, MutableState mutableState, int i3) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1(function1, i3, lazyListState, function0, mutableState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Modifier modifier, TimePickerConfiguration timePickerConfiguration, boolean z2, float f3, List list, int i3, TimePickerViewState.TimePickerColumnType timePickerColumnType, Function1 function1, Function0 function0, int i4, Composer composer, int i5) {
        J(modifier, timePickerConfiguration, z2, f3, list, i3, timePickerColumnType, function1, function0, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void R(final Modifier modifier, final float f3, final List list, final int i3, final int i4, final TimePickerViewState.TimePickerColumnType timePickerColumnType, final TimePickerConfiguration timePickerConfiguration, final boolean z2, final Function1 function1, Composer composer, final int i5) {
        int i6;
        TimePickerConfiguration timePickerConfiguration2;
        Composer composer2;
        State state;
        String strB;
        Composer composerK = composer.k(-1240148826);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.e(i3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= composerK.e(i4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i5) == 0) {
            i6 |= composerK.Z(timePickerColumnType) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i5) == 0) {
            timePickerConfiguration2 = timePickerConfiguration;
            i6 |= composerK.Z(timePickerConfiguration2) ? 1048576 : 524288;
        } else {
            timePickerConfiguration2 = timePickerConfiguration;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= composerK.b(z2) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i6 |= composerK.I(function1) ? 67108864 : 33554432;
        }
        if (composerK.r((i6 & 38347923) != 38347922, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1240148826, i6, -1, "cz.mobilesoft.coreblock.view.timepicker.SwipeTimeItem (ComposeSwipeableTimePicker.kt:255)");
            }
            final int iJ = timePickerConfiguration2.j() / 2;
            int i7 = i4 + iJ;
            boolean z3 = i3 == i7;
            int i8 = i7 - i3;
            float fE = RangesKt.e(1.0f - (Math.abs(i8) * 0.1f), 0.6f);
            float fE2 = RangesKt.e(1.0f - (Math.abs(i8) * 0.25f), 0.3f);
            if (z3) {
                fE = timePickerConfiguration2.o();
            }
            int i9 = i6;
            State stateD = AnimateAsStateKt.d(fE, null, 0.0f, "time_item_scale_anim", null, composerK, 3072, 22);
            State stateD2 = AnimateAsStateKt.d(z3 ? 1.0f : fE2, null, 0.0f, "time_item_alpha_anim", null, composerK, 3072, 22);
            composer2 = composerK;
            if (Intrinsics.areEqual(timePickerColumnType, TimePickerViewState.TimePickerColumnType.Days.f133116a)) {
                composer2.a0(36335565);
                state = stateD2;
                strB = StringResources_androidKt.a(R.plurals.f95740a, (int) ((Number) list.get(i4)).longValue(), composer2, 0).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(strB, "toLowerCase(...)");
                composer2.U();
            } else {
                state = stateD2;
                if (Intrinsics.areEqual(timePickerColumnType, TimePickerViewState.TimePickerColumnType.Hours.f133117a)) {
                    composer2.a0(36505786);
                    if (z2) {
                        composer2.a0(36539514);
                        composer2.U();
                        strB = "";
                    } else {
                        composer2.a0(36580434);
                        strB = StringResources_androidKt.b(R.string.Lf, composer2, 0).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(strB, "toLowerCase(...)");
                        composer2.U();
                    }
                    composer2.U();
                } else if (Intrinsics.areEqual(timePickerColumnType, TimePickerViewState.TimePickerColumnType.Minutes.f133118a)) {
                    composer2.a0(36726940);
                    if (z2) {
                        composer2.a0(36760730);
                        composer2.U();
                        strB = "";
                    } else {
                        composer2.a0(36801588);
                        strB = StringResources_androidKt.b(R.string.WC, composer2, 0);
                        composer2.U();
                    }
                    composer2.U();
                } else {
                    if (!(timePickerColumnType instanceof TimePickerViewState.TimePickerColumnType.Custom)) {
                        composer2.a0(-2077039675);
                        composer2.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer2.a0(36975746);
                    Integer numA = ((TimePickerViewState.TimePickerColumnType.Custom) timePickerColumnType).a();
                    if (numA == null) {
                        composer2.a0(36975745);
                        composer2.U();
                        strB = null;
                    } else {
                        composer2.a0(36975746);
                        strB = StringResources_androidKt.b(numA.intValue(), composer2, 0);
                        composer2.U();
                    }
                    composer2.U();
                }
            }
            Modifier modifierI = SizeKt.i(SizeKt.I(modifier, null, false, 3, null), Dp.g(f3 / timePickerConfiguration.j()));
            boolean zE = ((i9 & 7168) == 2048) | ((234881024 & i9) == 67108864) | composer2.e(iJ) | composer2.I(list);
            Object objG = composer2.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeSwipeableTimePickerKt.U(function1, i3, iJ, list);
                    }
                };
                composer2.w(objG);
            }
            Modifier modifierK0 = k0(modifierI, false, (Function0) objG, 1, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.e(), false);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK0);
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
            if (i3 < iJ || i3 >= list.size() + iJ) {
                composer2.a0(-810401290);
            } else {
                composer2.a0(-798268603);
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierA = AlphaKt.a(SizeKt.I(companion3, null, false, 3, null), T(state));
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion.l(), composer2, 0);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierA);
                Function0 function0A2 = companion2.a();
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
                Updater.e(composerA2, measurePolicyB, companion2.e());
                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                Function2 function2B2 = companion2.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion2.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                TextKt.c(String.valueOf(((Number) list.get(i3 - iJ)).longValue()), ScaleKt.a(rowScopeInstance.b(companion3), S(stateD)), z3 ? timePickerConfiguration.r() : timePickerConfiguration.q(), 0L, null, z3 ? timePickerConfiguration.i() : timePickerConfiguration.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, timePickerConfiguration.s(), composer2, 0, 0, 65496);
                composer2 = composer2;
                if (strB != null) {
                    composer2.a0(-316772741);
                    float f4 = 4;
                    SpacerKt.a(SizeKt.v(companion3, Dp.g(f4)), composer2, 6);
                    TextKt.c(strB, AlphaKt.a(ScaleKt.a(rowScopeInstance.b(PaddingKt.m(companion3, Dp.g(f4), 0.0f, 0.0f, 0.0f, 14, null)), S(stateD)), z3 ? 1.0f : 0.0f), z3 ? timePickerConfiguration.r() : timePickerConfiguration.q(), 0L, null, z3 ? timePickerConfiguration.i() : timePickerConfiguration.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, timePickerConfiguration.p(), composer2, 0, 0, 65496);
                    composer2 = composer2;
                } else {
                    composer2.a0(-329577353);
                }
                composer2.U();
                composer2.y();
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeSwipeableTimePickerKt.V(modifier, f3, list, i3, i4, timePickerColumnType, timePickerConfiguration, z2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float S(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float T(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1, int i3, int i4, List list) {
        function1.invoke(Integer.valueOf(RangesKt.p(i3 - i4, 0, list.size() - 1)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Modifier modifier, float f3, List list, int i3, int i4, TimePickerViewState.TimePickerColumnType timePickerColumnType, TimePickerConfiguration timePickerConfiguration, boolean z2, Function1 function1, int i5, Composer composer, int i6) {
        R(modifier, f3, list, i3, i4, timePickerColumnType, timePickerConfiguration, z2, function1, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x027a  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Integer, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void W(final cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState r21, cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 919
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt.W(cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState, cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function1 function1, int i3) {
        function1.invoke(new TimePickerViewEvent.OnUpdateDayIndexEvent(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, int i3) {
        function1.invoke(new TimePickerViewEvent.OnUpdateHourIndexEvent(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1, int i3) {
        function1.invoke(new TimePickerViewEvent.OnUpdateMinuteIndexEvent(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, int i3) {
        function1.invoke(new TimePickerViewEvent.OnUpdateCustomIndexEvent(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(TimePickerViewState timePickerViewState, TimePickerConfiguration timePickerConfiguration, Function1 function1, int i3, int i4, Composer composer, int i5) {
        W(timePickerViewState, timePickerConfiguration, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final Modifier j0(Modifier modifier, final boolean z2, final Function0 onClick) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.c(modifier, null, new Function3() { // from class: cz.mobilesoft.coreblock.view.timepicker.c0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ComposeSwipeableTimePickerKt.l0(z2, onClick, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    public static /* synthetic */ Modifier k0(Modifier modifier, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return j0(modifier, z2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier l0(boolean z2, final Function0 function0, Modifier composed, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(-393291701);
        if (ComposerKt.M()) {
            ComposerKt.U(-393291701, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.noRippleClickable.<anonymous> (ComposeSwipeableTimePicker.kt:437)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = InteractionSourceKt.a();
            composer.w(objG);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
        boolean Z = composer.Z(function0);
        Object objG2 = composer.G();
        if (Z || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.d0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ComposeSwipeableTimePickerKt.m0(function0);
                }
            };
            composer.w(objG2);
        }
        Modifier modifierD = ClickableKt.d(composed, mutableInteractionSource, null, z2, null, null, (Function0) objG2, 24, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    public static final void u(final String endsAtTimeString, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(endsAtTimeString, "endsAtTimeString");
        Composer composerK = composer.k(-868479647);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(endsAtTimeString) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-868479647, i4, -1, "cz.mobilesoft.coreblock.view.timepicker.EndsAtTimesText (ComposeSwipeableTimePicker.kt:449)");
            }
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.c(R.string.sD, new Object[]{endsAtTimeString}, composerK, 0), SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).M(), TextUnitKt.i(13), null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 3120, 0, 65008);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeSwipeableTimePickerKt.v(endsAtTimeString, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, int i3, Composer composer, int i4) {
        u(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v15 */
    public static final void w(Modifier modifier, final int i3, final Function1 onSelectedIndexChange, final float f3, final boolean z2, boolean z3, final int i4, final LazyListState listState, final Function0 onScrollingStopped, final Function1 content, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        Composer composer2;
        final boolean z4;
        final Modifier modifier3;
        int i9;
        MutableState mutableState;
        int i10;
        int i11;
        int i12;
        MutableState mutableState2;
        int i13;
        Modifier modifier4;
        float f4;
        ?? r8;
        Object composeSwipeableTimePickerKt$SwipeLazyColumn$4$1;
        LazyListState lazyListState;
        Object composeSwipeableTimePickerKt$SwipeLazyColumn$2$1;
        Integer num;
        Intrinsics.checkNotNullParameter(onSelectedIndexChange, "onSelectedIndexChange");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(onScrollingStopped, "onScrollingStopped");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(-1229900920);
        int i14 = i6 & 1;
        if (i14 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (composerK.Z(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i8 = i3;
            i7 |= composerK.e(i8) ? 32 : 16;
        } else {
            i8 = i3;
        }
        if ((i5 & 384) == 0) {
            i7 |= composerK.I(onSelectedIndexChange) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i7 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i15 = i6 & 32;
        if (i15 != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= composerK.b(z3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= composerK.e(i4) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= composerK.Z(listState) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= composerK.I(onScrollingStopped) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= composerK.I(content) ? 536870912 : 268435456;
        }
        if (composerK.r((i7 & 306783379) != 306783378, i7 & 1)) {
            Modifier modifier5 = i14 != 0 ? Modifier.b8 : modifier2;
            boolean z5 = i15 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-1229900920, i7, -1, "cz.mobilesoft.coreblock.view.timepicker.SwipeLazyColumn (ComposeSwipeableTimePicker.kt:362)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                i9 = 2;
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            } else {
                i9 = 2;
            }
            MutableState mutableState3 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, i9, null);
                composerK.w(objG2);
            }
            MutableState mutableState4 = (MutableState) objG2;
            Unit unit = Unit.f139807a;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new ComposeSwipeableTimePickerKt$SwipeLazyColumn$1$1(mutableState4, null);
                composerK.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composerK, 6);
            if (z5) {
                composerK.a0(388494723);
                Integer numValueOf = Integer.valueOf(i8);
                i10 = 29360128;
                boolean z6 = ((i7 & 29360128) == 8388608) | ((i7 & 112) == 32);
                Object objG4 = composerK.G();
                if (z6 || objG4 == companion.a()) {
                    mutableState = mutableState4;
                    num = numValueOf;
                    i12 = i7;
                    i11 = 16384;
                    composeSwipeableTimePickerKt$SwipeLazyColumn$2$1 = new ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1(listState, i8, mutableState, mutableState3, null);
                    mutableState2 = mutableState3;
                    composerK.w(composeSwipeableTimePickerKt$SwipeLazyColumn$2$1);
                } else {
                    num = numValueOf;
                    mutableState = mutableState4;
                    composeSwipeableTimePickerKt$SwipeLazyColumn$2$1 = objG4;
                    i11 = 16384;
                    i12 = i7;
                    mutableState2 = mutableState3;
                }
                EffectsKt.g(num, (Function2) composeSwipeableTimePickerKt$SwipeLazyColumn$2$1, composerK, (i12 >> 3) & 14);
            } else {
                mutableState = mutableState4;
                i10 = 29360128;
                i11 = 16384;
                i12 = i7;
                mutableState2 = mutableState3;
                composerK.a0(374139770);
            }
            composerK.U();
            Integer numValueOf2 = Integer.valueOf(listState.t());
            int i16 = i12 & i10;
            boolean z7 = ((57344 & i12) == i11) | (i16 == 8388608) | ((i12 & 7168) == 2048) | ((3670016 & i12) == 1048576) | ((i12 & 896) == 256);
            Object objG5 = composerK.G();
            if (z7 || objG5 == companion.a()) {
                i13 = 8388608;
                modifier4 = modifier5;
                ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1 composeSwipeableTimePickerKt$SwipeLazyColumn$3$1 = new ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1(z2, listState, f3, i4, onSelectedIndexChange, mutableState2, mutableState, null);
                f4 = f3;
                composerK.w(composeSwipeableTimePickerKt$SwipeLazyColumn$3$1);
                objG5 = composeSwipeableTimePickerKt$SwipeLazyColumn$3$1;
            } else {
                i13 = 8388608;
                modifier4 = modifier5;
                f4 = f3;
            }
            EffectsKt.g(numValueOf2, (Function2) objG5, composerK, 0);
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                r8 = 0;
                objG6 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG6);
            } else {
                r8 = 0;
            }
            MutableState mutableState5 = (MutableState) objG6;
            Boolean boolValueOf = Boolean.valueOf(listState.c());
            boolean z8 = (i16 == i13) | ((i12 & 112) == 32) | ((234881024 & i12) == 67108864);
            Object objG7 = composerK.G();
            if (z8 || objG7 == companion.a()) {
                lazyListState = listState;
                composeSwipeableTimePickerKt$SwipeLazyColumn$4$1 = new ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1(lazyListState, i3, onScrollingStopped, mutableState5, null);
                composerK.w(composeSwipeableTimePickerKt$SwipeLazyColumn$4$1);
            } else {
                composeSwipeableTimePickerKt$SwipeLazyColumn$4$1 = objG7;
                lazyListState = listState;
            }
            EffectsKt.g(boolValueOf, (Function2) composeSwipeableTimePickerKt$SwipeLazyColumn$4$1, composerK, 0);
            Flow flowC = lazyListState.v().c();
            boolean z9 = i16 == i13;
            Object objG8 = composerK.G();
            if (z9 || objG8 == companion.a()) {
                objG8 = new ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1(lazyListState, mutableState5, r8);
                composerK.w(objG8);
            }
            EffectsKt.g(flowC, (Function2) objG8, composerK, 0);
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                objG9 = new NestedScrollConnection() { // from class: cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$consumeAllScrollConnection$1$1
                    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
                    public /* bridge */ long J1(long j3, int i17) {
                        return super.J1(j3, i17);
                    }

                    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
                    public /* bridge */ Object R1(long j3, Continuation continuation) {
                        return super.R1(j3, continuation);
                    }

                    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
                    public Object Y(long j3, long j4, Continuation continuation) {
                        return Velocity.b(j4);
                    }

                    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
                    public long H0(long j3, long j4, int i17) {
                        return j4;
                    }
                };
                composerK.w(objG9);
            }
            Modifier modifierB = NestedScrollModifierKt.b(SizeKt.i(modifier4, f4), (ComposeSwipeableTimePickerKt$SwipeLazyColumn$consumeAllScrollConnection$1$1) objG9, r8, 2, r8);
            boolean z10 = (1879048192 & i12) == 536870912;
            Object objG10 = composerK.G();
            if (z10 || objG10 == companion.a()) {
                objG10 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeSwipeableTimePickerKt.A(content, (LazyListScope) obj);
                    }
                };
                composerK.w(objG10);
            }
            composer2 = composerK;
            LazyDslKt.b(modifierB, lazyListState, null, false, null, null, null, false, null, (Function1) objG10, composer2, (i12 >> 18) & 112, 508);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
            z4 = z5;
        } else {
            composer2 = composerK;
            composer2.Q();
            z4 = z3;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeSwipeableTimePickerKt.B(modifier3, i3, onSelectedIndexChange, f3, z2, z4, i4, listState, onScrollingStopped, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }
}
