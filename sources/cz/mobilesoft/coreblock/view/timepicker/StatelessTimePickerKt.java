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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.timepicker.ColumnType;
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
public final class StatelessTimePickerKt {
    private static final void A(final RowScope rowScope, final TimePickerConfiguration timePickerConfiguration, final boolean z2, final List list, final int i3, final ColumnType columnType, final Function1 function1, final Function1 function12, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        Composer composerK = composer.k(-813163861);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(rowScope) ? 4 : 2) | i4;
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
            i5 |= composerK.I(list) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.Z(columnType) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i5 |= composerK.I(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i5 |= composerK.I(function12) ? 8388608 : 4194304;
        }
        if (composerK.r((4793491 & i5) != 4793490, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-813163861, i5, -1, "cz.mobilesoft.coreblock.view.timepicker.StatelessTimeColumn (StatelessTimePicker.kt:233)");
            }
            int i6 = i5 & 1008;
            int i7 = i5 << 3;
            composer2 = composerK;
            C(RowScope.c(rowScope, SizeKt.I(Modifier.b8, null, false, 3, null), 1.0f, false, 2, null), timePickerConfiguration, z2, timePickerConfiguration.k(), list, i3, columnType, function1, function12, composer2, i6 | (57344 & i7) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (i7 & 234881024));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatelessTimePickerKt.B(rowScope, timePickerConfiguration, z2, list, i3, columnType, function1, function12, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(RowScope rowScope, TimePickerConfiguration timePickerConfiguration, boolean z2, List list, int i3, ColumnType columnType, Function1 function1, Function1 function12, int i4, Composer composer, int i5) {
        A(rowScope, timePickerConfiguration, z2, list, i3, columnType, function1, function12, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void C(final Modifier modifier, final TimePickerConfiguration timePickerConfiguration, final boolean z2, final float f3, final List list, final int i3, final ColumnType columnType, final Function1 function1, final Function1 function12, Composer composer, final int i4) {
        int i5;
        float f4;
        ColumnType columnType2;
        int i6;
        LazyListState lazyListState;
        Composer composerK = composer.k(-1486865004);
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
        if ((1572864 & i4) == 0) {
            columnType2 = columnType;
            i5 |= composerK.Z(columnType2) ? 1048576 : 524288;
        } else {
            columnType2 = columnType;
        }
        if ((i4 & 12582912) == 0) {
            i5 |= composerK.I(function1) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i5 |= composerK.I(function12) ? 67108864 : 33554432;
        }
        if (composerK.r((i5 & 38347923) != 38347922, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1486865004, i5, -1, "cz.mobilesoft.coreblock.view.timepicker.StatelessTimeColumnImpl (StatelessTimePicker.kt:260)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            int i7 = i5 >> 15;
            final LazyListState lazyListStateB = LazyListStateKt.b(i3, 0, composerK, i7 & 14, 2);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            boolean zD = D((MutableState) objG2);
            int iJ = timePickerConfiguration.j();
            int i8 = i5 & 7168;
            int i9 = i5;
            boolean zI = ((i5 & 896) == 256) | composerK.I(list) | ((i5 & 112) == 32) | (i8 == 2048) | ((458752 & i5) == 131072) | ((3670016 & i5) == 1048576) | composerK.I(coroutineScope) | ((i9 & 29360128) == 8388608) | composerK.Z(lazyListStateB);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                final float f5 = f4;
                final ColumnType columnType3 = columnType2;
                i6 = i8;
                Function1 function13 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatelessTimePickerKt.E(list, timePickerConfiguration, f5, i3, columnType3, z2, coroutineScope, function1, lazyListStateB, (LazyListScope) obj);
                    }
                };
                lazyListState = lazyListStateB;
                composerK.w(function13);
                objG3 = function13;
            } else {
                lazyListState = lazyListStateB;
                i6 = i8;
            }
            r(modifier, i3, function1, f3, zD, true, iJ, lazyListState, function12, (Function1) objG3, composerK, (i9 & 14) | 196608 | ((i9 >> 12) & 112) | (i7 & 896) | i6 | (i9 & 234881024), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatelessTimePickerKt.H(modifier, timePickerConfiguration, z2, f3, list, i3, columnType, function1, function12, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean D(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final List list, final TimePickerConfiguration timePickerConfiguration, final float f3, final int i3, final ColumnType columnType, final boolean z2, final CoroutineScope coroutineScope, final Function1 function1, final LazyListState lazyListState, LazyListScope StatelessSwipeLazyColumn) {
        Intrinsics.checkNotNullParameter(StatelessSwipeLazyColumn, "$this$StatelessSwipeLazyColumn");
        LazyListScope.b(StatelessSwipeLazyColumn, list.size() + (timePickerConfiguration.j() - 1), null, null, ComposableLambdaKt.c(-186807514, true, new Function4() { // from class: cz.mobilesoft.coreblock.view.timepicker.m0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StatelessTimePickerKt.F(f3, list, i3, columnType, timePickerConfiguration, z2, coroutineScope, function1, lazyListState, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(float f3, List list, int i3, ColumnType columnType, TimePickerConfiguration timePickerConfiguration, boolean z2, final CoroutineScope coroutineScope, final Function1 function1, final LazyListState lazyListState, LazyItemScope items, int i4, Composer composer, int i5) {
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        if ((i5 & 48) == 0) {
            i6 = i4;
            i7 = i5 | (composer.e(i6) ? 32 : 16);
        } else {
            i6 = i4;
            i7 = i5;
        }
        if (composer.r((i7 & 145) != 144, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-186807514, i7, -1, "cz.mobilesoft.coreblock.view.timepicker.StatelessTimeColumnImpl.<anonymous>.<anonymous>.<anonymous> (StatelessTimePicker.kt:278)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            boolean zI = composer.I(coroutineScope) | composer.Z(function1) | composer.Z(lazyListState);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.n0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatelessTimePickerKt.G(coroutineScope, function1, lazyListState, ((Integer) obj).intValue());
                    }
                };
                composer.w(objG);
            }
            I(modifierH, f3, list, i6, i3, columnType, timePickerConfiguration, z2, (Function1) objG, composer, ((i7 << 6) & 7168) | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(CoroutineScope coroutineScope, Function1 function1, LazyListState lazyListState, int i3) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StatelessTimePickerKt$StatelessTimeColumnImpl$1$1$1$1$1$1(function1, i3, lazyListState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Modifier modifier, TimePickerConfiguration timePickerConfiguration, boolean z2, float f3, List list, int i3, ColumnType columnType, Function1 function1, Function1 function12, int i4, Composer composer, int i5) {
        C(modifier, timePickerConfiguration, z2, f3, list, i3, columnType, function1, function12, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void I(final Modifier modifier, final float f3, final List list, final int i3, final int i4, final ColumnType columnType, final TimePickerConfiguration timePickerConfiguration, final boolean z2, final Function1 function1, Composer composer, final int i5) {
        int i6;
        TimePickerConfiguration timePickerConfiguration2;
        Composer composer2;
        State state;
        String strB;
        Composer composerK = composer.k(-1734568175);
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
            i6 |= composerK.Z(columnType) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
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
                ComposerKt.U(-1734568175, i6, -1, "cz.mobilesoft.coreblock.view.timepicker.StatelessTimeItem (StatelessTimePicker.kt:309)");
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
            if (Intrinsics.areEqual(columnType, ColumnType.Days.f132967a)) {
                composer2.a0(-1767753534);
                state = stateD2;
                strB = StringResources_androidKt.a(R.plurals.f95740a, (int) ((Number) list.get(i4)).longValue(), composer2, 0).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(strB, "toLowerCase(...)");
                composer2.U();
            } else {
                state = stateD2;
                if (Intrinsics.areEqual(columnType, ColumnType.Hours.f132968a)) {
                    composer2.a0(-1767615057);
                    if (z2) {
                        composer2.a0(-1767580339);
                        composer2.U();
                        strB = "";
                    } else {
                        composer2.a0(-472659460);
                        strB = StringResources_androidKt.b(R.string.Lf, composer2, 0).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(strB, "toLowerCase(...)");
                        composer2.U();
                    }
                    composer2.U();
                } else if (Intrinsics.areEqual(columnType, ColumnType.Minutes.f132969a)) {
                    composer2.a0(-1767487151);
                    if (z2) {
                        composer2.a0(-1767452371);
                        composer2.U();
                        strB = "";
                    } else {
                        composer2.a0(-472656295);
                        strB = StringResources_androidKt.b(R.string.WC, composer2, 0);
                        composer2.U();
                    }
                    composer2.U();
                } else {
                    if (!(columnType instanceof ColumnType.Custom)) {
                        composer2.a0(-472667400);
                        composer2.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer2.a0(-1767329609);
                    Integer numA = ((ColumnType.Custom) columnType).a();
                    if (numA == null) {
                        composer2.a0(-1767329610);
                        composer2.U();
                        strB = null;
                    } else {
                        composer2.a0(-1767329609);
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
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StatelessTimePickerKt.L(function1, i3, iJ, list);
                    }
                };
                composer2.w(objG);
            }
            Modifier modifierC0 = c0(modifierI, false, (Function0) objG, 1, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.e(), false);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierC0);
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
                composer2.a0(-2006784745);
            } else {
                composer2.a0(-1993025829);
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierA = AlphaKt.a(SizeKt.I(companion3, null, false, 3, null), K(state));
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
                TextKt.c(((columnType instanceof ColumnType.Custom) && ((ColumnType.Custom) columnType).b()) ? ((Number) list.get(i3 - iJ)).longValue() == 0 ? "AM" : "PM" : TimePickerHelperKt.c(((Number) list.get(i3 - iJ)).longValue(), z2), ScaleKt.a(companion3, J(stateD)), z3 ? timePickerConfiguration.r() : timePickerConfiguration.q(), 0L, null, z3 ? timePickerConfiguration.i() : timePickerConfiguration.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, timePickerConfiguration.s(), composer2, 0, 0, 65496);
                composer2 = composer2;
                if (strB != null) {
                    composer2.a0(-1061084259);
                    float f4 = 4;
                    SpacerKt.a(SizeKt.v(companion3, Dp.g(f4)), composer2, 6);
                    TextKt.c(strB, AlphaKt.a(ScaleKt.a(PaddingKt.m(companion3, Dp.g(f4), 0.0f, 0.0f, 0.0f, 14, null), J(stateD)), z3 ? 1.0f : 0.0f), z3 ? timePickerConfiguration.r() : timePickerConfiguration.q(), 0L, null, z3 ? timePickerConfiguration.i() : timePickerConfiguration.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, timePickerConfiguration.s(), composer2, 0, 0, 65496);
                    composer2 = composer2;
                } else {
                    composer2.a0(-1075775562);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatelessTimePickerKt.M(modifier, f3, list, i3, i4, columnType, timePickerConfiguration, z2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float J(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float K(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function1 function1, int i3, int i4, List list) {
        function1.invoke(Integer.valueOf(RangesKt.p(i3 - i4, 0, list.size() - 1)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Modifier modifier, float f3, List list, int i3, int i4, ColumnType columnType, TimePickerConfiguration timePickerConfiguration, boolean z2, Function1 function1, int i5, Composer composer, int i6) {
        I(modifier, f3, list, i3, i4, columnType, timePickerConfiguration, z2, function1, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void N(androidx.compose.ui.Modifier r23, final cz.mobilesoft.coreblock.view.timepicker.TimePickerState r24, cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration r25, final kotlin.jvm.functions.Function1 r26, final kotlin.jvm.functions.Function1 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt.N(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.view.timepicker.TimePickerState, cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1, TimePickerState timePickerState, int i3) {
        function1.invoke(TimePickerState.h(timePickerState, null, null, null, null, i3, 0, 0, 0, false, false, 1007, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, TimePickerState timePickerState, int i3) {
        function1.invoke(TimePickerState.h(timePickerState, null, null, null, null, 0, i3, 0, 0, false, false, 991, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function1 function1, TimePickerState timePickerState, int i3) {
        function1.invoke(TimePickerState.h(timePickerState, null, null, null, null, 0, 0, i3, 0, false, false, 959, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1, TimePickerState timePickerState, int i3) {
        function1.invoke(TimePickerState.h(timePickerState, null, null, null, null, 0, 0, 0, i3, false, false, 895, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Modifier modifier, TimePickerState timePickerState, TimePickerConfiguration timePickerConfiguration, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        N(modifier, timePickerState, timePickerConfiguration, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final TimePickerState Z(final TimePickerConfig config, final long j3, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(config, "config");
        if ((i4 & 2) != 0) {
            j3 = 0;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(631895016, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.rememberTimePickerState (StatelessTimePicker.kt:71)");
        }
        Object[] objArr = {config, Long.valueOf(j3)};
        Saver saverA = TimePickerState.f133049k.a();
        boolean zI = ((((i3 & 112) ^ 48) > 32 && composer.f(j3)) || (i3 & 48) == 32) | composer.I(config);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.r0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StatelessTimePickerKt.a0(config, j3);
                }
            };
            composer.w(objG);
        }
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return timePickerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerState a0(TimePickerConfig timePickerConfig, long j3) {
        return TimePickerHelperKt.b(timePickerConfig, j3);
    }

    private static final Modifier b0(Modifier modifier, final boolean z2, final Function0 function0) {
        return ComposedModifierKt.c(modifier, null, new Function3() { // from class: cz.mobilesoft.coreblock.view.timepicker.q0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatelessTimePickerKt.d0(z2, function0, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    static /* synthetic */ Modifier c0(Modifier modifier, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return b0(modifier, z2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier d0(boolean z2, final Function0 function0, Modifier composed, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(849043241);
        if (ComposerKt.M()) {
            ComposerKt.U(849043241, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.statelessNoRippleClickable.<anonymous> (StatelessTimePicker.kt:483)");
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
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.timepicker.j0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StatelessTimePickerKt.e0(function0);
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
    public static final Unit e0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static final void r(Modifier modifier, final int i3, final Function1 function1, final float f3, final boolean z2, boolean z3, final int i4, final LazyListState lazyListState, final Function1 function12, final Function1 function13, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        final boolean z4;
        final Modifier modifier3;
        MutableState mutableState;
        int i9;
        MutableState mutableState2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f4;
        ?? r7;
        LazyListState lazyListState2;
        int i15;
        Object statelessTimePickerKt$StatelessSwipeLazyColumn$2$1;
        Integer num;
        Composer composerK = composer.k(1196579505);
        int i16 = i6 & 1;
        if (i16 != 0) {
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
            i7 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i7 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i17 = i6 & 32;
        if (i17 != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= composerK.b(z3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= composerK.e(i4) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= composerK.Z(lazyListState) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= composerK.I(function12) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= composerK.I(function13) ? 536870912 : 268435456;
        }
        if (composerK.r((i7 & 306783379) != 306783378, i7 & 1)) {
            Modifier modifier4 = i16 != 0 ? Modifier.b8 : modifier2;
            boolean z5 = i17 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(1196579505, i7, -1, "cz.mobilesoft.coreblock.view.timepicker.StatelessSwipeLazyColumn (StatelessTimePicker.kt:410)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState3 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState4 = (MutableState) objG2;
            Unit unit = Unit.f139807a;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new StatelessTimePickerKt$StatelessSwipeLazyColumn$1$1(mutableState4, null);
                composerK.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composerK, 6);
            if (z5) {
                composerK.a0(-927763192);
                Integer numValueOf = Integer.valueOf(i8);
                i9 = 29360128;
                boolean z6 = ((i7 & 112) == 32) | ((i7 & 29360128) == 8388608);
                Object objG4 = composerK.G();
                if (z6 || objG4 == companion.a()) {
                    num = numValueOf;
                    i10 = i7;
                    mutableState = mutableState4;
                    i11 = 8388608;
                    statelessTimePickerKt$StatelessSwipeLazyColumn$2$1 = new StatelessTimePickerKt$StatelessSwipeLazyColumn$2$1(lazyListState, i8, mutableState, mutableState3, null);
                    mutableState2 = mutableState3;
                    composerK.w(statelessTimePickerKt$StatelessSwipeLazyColumn$2$1);
                } else {
                    statelessTimePickerKt$StatelessSwipeLazyColumn$2$1 = objG4;
                    num = numValueOf;
                    mutableState2 = mutableState3;
                    i10 = i7;
                    mutableState = mutableState4;
                    i11 = 8388608;
                }
                EffectsKt.g(num, (Function2) statelessTimePickerKt$StatelessSwipeLazyColumn$2$1, composerK, (i10 >> 3) & 14);
            } else {
                mutableState = mutableState4;
                i9 = 29360128;
                mutableState2 = mutableState3;
                i10 = i7;
                i11 = 8388608;
                composerK.a0(-943907279);
            }
            composerK.U();
            Integer numValueOf2 = Integer.valueOf(lazyListState.t());
            int i18 = i10 & i9;
            boolean z7 = ((57344 & i10) == 16384) | (i18 == i11) | ((i10 & 7168) == 2048) | ((3670016 & i10) == 1048576) | ((i10 & 896) == 256);
            Object objG5 = composerK.G();
            if (z7 || objG5 == companion.a()) {
                i12 = i18;
                i13 = i10;
                i14 = 0;
                StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1 statelessTimePickerKt$StatelessSwipeLazyColumn$3$1 = new StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1(z2, lazyListState, f3, i4, function1, mutableState2, mutableState, null);
                f4 = f3;
                composerK.w(statelessTimePickerKt$StatelessSwipeLazyColumn$3$1);
                objG5 = statelessTimePickerKt$StatelessSwipeLazyColumn$3$1;
            } else {
                i13 = i10;
                f4 = f3;
                i12 = i18;
                i14 = 0;
            }
            EffectsKt.g(numValueOf2, (Function2) objG5, composerK, i14);
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                r7 = 0;
                objG6 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG6);
            } else {
                r7 = 0;
            }
            MutableState mutableState5 = (MutableState) objG6;
            Boolean boolValueOf = Boolean.valueOf(lazyListState.c());
            int i19 = i12;
            int i20 = (i19 == 8388608 ? 1 : i14) | ((i13 & 112) == 32 ? 1 : i14) | ((i13 & 234881024) == 67108864 ? 1 : i14);
            Object objG7 = composerK.G();
            if (i20 != 0 || objG7 == companion.a()) {
                lazyListState2 = lazyListState;
                i15 = 8388608;
                StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1 statelessTimePickerKt$StatelessSwipeLazyColumn$4$1 = new StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1(lazyListState2, i3, function12, mutableState5, null);
                composerK.w(statelessTimePickerKt$StatelessSwipeLazyColumn$4$1);
                objG7 = statelessTimePickerKt$StatelessSwipeLazyColumn$4$1;
            } else {
                lazyListState2 = lazyListState;
                i15 = 8388608;
            }
            EffectsKt.g(boolValueOf, (Function2) objG7, composerK, i14);
            Flow flowC = lazyListState2.v().c();
            int i21 = i19 == i15 ? 1 : i14;
            Object objG8 = composerK.G();
            if (i21 != 0 || objG8 == companion.a()) {
                objG8 = new StatelessTimePickerKt$StatelessSwipeLazyColumn$5$1(lazyListState2, mutableState5, r7);
                composerK.w(objG8);
            }
            EffectsKt.g(flowC, (Function2) objG8, composerK, i14);
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                objG9 = new NestedScrollConnection() { // from class: cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt$StatelessSwipeLazyColumn$consumeAllScrollConnection$1$1
                    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
                    public /* bridge */ long J1(long j3, int i22) {
                        return super.J1(j3, i22);
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
                    public long H0(long j3, long j4, int i22) {
                        return j4;
                    }
                };
                composerK.w(objG9);
            }
            Modifier modifierB = NestedScrollModifierKt.b(SizeKt.i(modifier4, f4), (StatelessTimePickerKt$StatelessSwipeLazyColumn$consumeAllScrollConnection$1$1) objG9, r7, 2, r7);
            int i22 = (i13 & 1879048192) != 536870912 ? i14 : 1;
            Object objG10 = composerK.G();
            if (i22 != 0 || objG10 == companion.a()) {
                objG10 = new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatelessTimePickerKt.v(function13, (LazyListScope) obj);
                    }
                };
                composerK.w(objG10);
            }
            Modifier modifier5 = modifier4;
            LazyDslKt.b(modifierB, lazyListState2, null, false, null, null, null, false, null, (Function1) objG10, composerK, (i13 >> 18) & 112, 508);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
            z4 = z5;
        } else {
            composerK.Q();
            z4 = z3;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.timepicker.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatelessTimePickerKt.w(modifier3, i3, function1, f3, z2, z4, i4, lazyListState, function12, function13, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        function1.invoke(LazyColumn);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Modifier modifier, int i3, Function1 function1, float f3, boolean z2, boolean z3, int i4, LazyListState lazyListState, Function1 function12, Function1 function13, int i5, int i6, Composer composer, int i7) {
        r(modifier, i3, function1, f3, z2, z3, i4, lazyListState, function12, function13, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
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
