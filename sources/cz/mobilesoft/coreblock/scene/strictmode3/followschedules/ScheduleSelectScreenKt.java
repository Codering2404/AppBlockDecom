package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.CheckboxKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorMatrix;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;

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
public final class ScheduleSelectScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(ScaffoldState scaffoldState, ScheduleSelectViewModel scheduleSelectViewModel, Function2 function2, int i3, Composer composer, int i4) {
        z(scaffoldState, scheduleSelectViewModel, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(Modifier modifier, final String str, final boolean z2, final Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        Composer composerK = composer.k(1857813613);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i5 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1857813613, i5, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ConfirmButton (ScheduleSelectScreen.kt:412)");
            }
            Modifier modifierM = PaddingKt.m(modifier4, 0.0f, Dp.g(24), 0.0f, Dp.g(8), 5, null);
            modifier3 = modifier4;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            ButtonType.Big big = new ButtonType.Big(null, null, str, 0.0f, 11, null);
            boolean z4 = true;
            ButtonColor.Accent accent = new ButtonColor.Accent(z3, null, false, null, 10, null);
            if ((i5 & 7168) != 2048) {
                z4 = false;
            }
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleSelectScreenKt.C(function1);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(modifierH, big, accent, (Function0) objG, composerK, 6, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.D(modifier3, str, z2, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1) {
        function1.invoke(ScheduleSelectViewEvent.OnConfirmButtonClicked.f122058a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Modifier modifier, String str, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        B(modifier, str, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final ScaffoldState scaffoldState, final ScheduleSelectViewState scheduleSelectViewState, final boolean z2, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        final ScheduleSelectViewState scheduleSelectViewState2;
        final Function1 function12;
        Composer composer2;
        Composer composerK = composer.k(-467475486);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            scheduleSelectViewState2 = scheduleSelectViewState;
            i4 |= composerK.Z(scheduleSelectViewState2) ? 32 : 16;
        } else {
            scheduleSelectViewState2 = scheduleSelectViewState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-467475486, i5, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.Content (ScheduleSelectScreen.kt:158)");
            }
            final boolean zIsEmpty = scheduleSelectViewState2.h().isEmpty();
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), scaffoldState, ComposableLambdaKt.e(-220155097, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.F(z2, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableSingletons$ScheduleSelectScreenKt.f122015a.j(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-424356960, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.z
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ScheduleSelectScreenKt.H(zIsEmpty, scheduleSelectViewState2, z2, function12, coroutineScope, scaffoldState, context, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 << 3) & 112) | 24960, 12582912, 131048);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.J(scaffoldState, scheduleSelectViewState, z2, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(boolean z2, final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-220155097, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.Content.<anonymous> (ScheduleSelectScreen.kt:170)");
            }
            String strB = StringResources_androidKt.b(z2 ? R.string.Xv : R.string.j4, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleSelectScreenKt.G(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeCommonsKt.n(strB, (Function0) objG, null, composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function0 function0) {
        AnswersHelper.f128199a.C7();
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(boolean z2, ScheduleSelectViewState scheduleSelectViewState, boolean z3, Function1 function1, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final Context context, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-424356960, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.Content.<anonymous> (ScheduleSelectScreen.kt:179)");
            }
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(Modifier.b8, it), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2) {
                composer.a0(-1755009426);
                K(columnScopeInstance, composer, 6);
                composer.U();
            } else {
                composer.a0(-1754902910);
                ImmutableList immutableListH = scheduleSelectViewState.h();
                ImmutableList immutableListJ = scheduleSelectViewState.j();
                int iE = scheduleSelectViewState.e();
                boolean zI = composer.I(coroutineScope) | composer.Z(scaffoldState) | composer.I(context);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ScheduleSelectScreenKt.I(coroutineScope, scaffoldState, context);
                        }
                    };
                    composer.w(objG);
                }
                S(columnScopeInstance, immutableListH, z3, immutableListJ, iE, function1, (Function0) objG, composer, 6);
                u(coroutineScope, scaffoldState, scheduleSelectViewState, function1, composer, 0);
                composer.U();
            }
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(CoroutineScope coroutineScope, ScaffoldState scaffoldState, Context context) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ScheduleSelectScreenKt$Content$2$1$1$1$1(scaffoldState, context, StrictModeTitleAlternatives.Companion.a(), null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ScaffoldState scaffoldState, ScheduleSelectViewState scheduleSelectViewState, boolean z2, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        E(scaffoldState, scheduleSelectViewState, z2, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void K(final ColumnScope columnScope, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(2046538336);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2046538336, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.EmptyContent (ScheduleSelectScreen.kt:220)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(ColumnScope.b(columnScope, companion, 1.0f, false, 2, null), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.fl, composerK, 0), PaddingKt.k(BoxScopeInstance.f6642a.f(companion, companion2.e()), Dp.g(32), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, 0, 0, 65016);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.L(columnScope, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(ColumnScope columnScope, int i3, Composer composer, int i4) {
        K(columnScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(final ScheduleSelectViewState.ScheduleDto scheduleDto, final boolean z2, final Function0 function0, final boolean z3, final Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Object obj;
        int i5;
        Composer composerK = composer.k(868192202);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scheduleDto) ? 4 : 2) | i3;
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
            i4 |= composerK.b(z3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function02) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(868192202, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleItem (ScheduleSelectScreen.kt:341)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                ColorFilter.Companion companion = ColorFilter.f25730b;
                float[] fArrC = ColorMatrix.c(null, 1, null);
                ColorMatrix.f(fArrC, 0.0f);
                objG = companion.a(fArrC);
                composerK.w(objG);
            }
            final ColorFilter colorFilter = (ColorFilter) objG;
            if (z3) {
                composerK.a0(21216277);
                String strB = StringResources_androidKt.b(R.string.Ex, composerK, 0);
                TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
                Modifier.Companion companion2 = Modifier.b8;
                i5 = 0;
                obj = null;
                TextKt.c(strB, PaddingKt.k(companion2, Dp.g(16), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleG, composerK, 48, 0, 65532);
                composerK = composerK;
                SpacerKt.a(SizeKt.v(companion2, Dp.g(8)), composerK, 6);
            } else {
                obj = null;
                i5 = 0;
                composerK.a0(7778552);
            }
            composerK.U();
            CardsKt.j(SizeKt.h(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, i5), 0.0f, 2, obj), 0.0f, 1, obj), ComposeColorsKt.j(composerK, i5).v(), 0.0f, false, null, z2 ? function0 : function02, ComposableLambdaKt.e(-389209562, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ScheduleSelectScreenKt.N(scheduleDto, z2, colorFilter, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 1572864, 28);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ScheduleSelectScreenKt.O(scheduleDto, z2, function0, z3, function02, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ScheduleSelectViewState.ScheduleDto scheduleDto, boolean z2, ColorFilter colorFilter, ColumnScope BaseCard, Composer composer, int i3) {
        int i4;
        Unit unit;
        long jM;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-389209562, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleItem.<anonymous> (ScheduleSelectScreen.kt:361)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.j(companion, Dp.g(f3), Dp.g(12)), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ScheduleEmoji scheduleEmojiG = scheduleDto.g();
            Integer iconResId = scheduleEmojiG != null ? scheduleEmojiG.getIconResId() : null;
            if (iconResId == null) {
                composer2.a0(621377085);
                composer2.U();
                i4 = 32;
                unit = null;
            } else {
                composer2.a0(621377086);
                i4 = 32;
                ImageKt.a(PainterResources_androidKt.c(iconResId.intValue(), composer2, 0), null, SizeKt.v(companion, Dp.g(32)), null, null, 0.0f, z2 ? null : colorFilter, composer, 432, 56);
                composer2 = composer;
                composer2.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composer2.a0(621730424);
                BoxKt.a(SizeKt.v(companion, Dp.g(i4)), composer2, 6);
                composer2.U();
            } else {
                composer2.a0(2098253650);
                composer2.U();
            }
            Modifier modifierC = RowScope.c(rowScopeInstance, PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierC);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(scheduleDto.k(), null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 0, 0, 65530);
            String strB = StringResources_androidKt.b(scheduleDto.c() ? R.string.f95863z : R.string.wg, composer, 0);
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            if (scheduleDto.c()) {
                composer.a0(-59064398);
                jM = ComposeColorsKt.j(composer, 0).b();
            } else {
                composer.a0(-59063784);
                jM = ComposeColorsKt.j(composer, 0).M();
            }
            composer.U();
            TextKt.c(strB, null, jM, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composer, 0, 0, 65530);
            composer.y();
            CheckboxKt.a(scheduleDto.j(), null, null, z2, null, null, composer, 48, 52);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(ScheduleSelectViewState.ScheduleDto scheduleDto, boolean z2, Function0 function0, boolean z3, Function0 function02, int i3, Composer composer, int i4) {
        M(scheduleDto, z2, function0, z3, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void P(final cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r24, long[] r25, boolean r26, final kotlin.jvm.functions.Function2 r27, final kotlin.jvm.functions.Function0 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt.P(cz.mobilesoft.coreblock.enums.StrictModeAccessMethod, long[], boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder Q(StrictModeAccessMethod strictModeAccessMethod, long[] jArr, boolean z2) {
        return ParametersHolderKt.b(strictModeAccessMethod, jArr, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(StrictModeAccessMethod strictModeAccessMethod, long[] jArr, boolean z2, Function2 function2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        P(strictModeAccessMethod, jArr, z2, function2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void S(final ColumnScope columnScope, final List list, final boolean z2, final List list2, final int i3, final Function1 function1, final Function0 function0, Composer composer, final int i4) {
        int i5;
        boolean z3;
        Composer composer2;
        Composer composerK = composer.k(1088576353);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(columnScope) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(list) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            z3 = z2;
            i5 |= composerK.b(z3) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(list2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i5 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if (composerK.r((i5 & 599187) != 599186, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1088576353, i5, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.SchedulesContent (ScheduleSelectScreen.kt:308)");
            }
            Modifier modifierB = ColumnScope.b(columnScope, SizeKt.h(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), 0.0f, 1, null), 1.0f, false, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(16));
            boolean zI = composerK.I(list) | ((i5 & 896) == 256) | composerK.I(list2) | ((458752 & i5) == 131072) | ((57344 & i5) == 16384) | ((i5 & 3670016) == 1048576);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                final boolean z4 = z3;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleSelectScreenKt.T(list, z4, list2, function1, i3, function0, (LazyListScope) obj);
                    }
                };
                composerK.w(function12);
                objG = function12;
            }
            composer2 = composerK;
            LazyDslKt.b(modifierB, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composer2, 24576, 494);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.V(columnScope, list, z2, list2, i3, function1, function0, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(final List list, final boolean z2, final List list2, final Function1 function1, final int i3, final Function0 function0, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScheduleSelectScreenKt.U(((Integer) obj).intValue(), (ScheduleSelectViewState.ScheduleDto) obj2);
            }
        };
        LazyColumn.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$SchedulesContent$lambda$0$0$$inlined$itemsIndexed$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i4) {
                return function2.invoke(Integer.valueOf(i4), list.get(i4));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$SchedulesContent$lambda$0$0$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i4) {
                list.get(i4);
                return null;
            }
        }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$SchedulesContent$lambda$0$0$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i4, Composer composer, int i5) {
                int i6;
                if ((i5 & 6) == 0) {
                    i6 = i5 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i6 = i5;
                }
                if ((i5 & 48) == 0) {
                    i6 |= composer.e(i4) ? 32 : 16;
                }
                if (!composer.r((i6 & 147) != 146, i6 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1091073711, i6, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                final ScheduleSelectViewState.ScheduleDto scheduleDto = (ScheduleSelectViewState.ScheduleDto) list.get(i4);
                composer.a0(-515864477);
                Modifier modifierC = LazyItemScope.c(lazyItemScope, Modifier.b8, null, null, null, 7, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierC);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A);
                } else {
                    composer.v();
                }
                Composer composerA = Updater.a(composer);
                Updater.e(composerA, measurePolicyA, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                boolean z3 = z2 || !list2.contains(scheduleDto);
                boolean Z = composer.Z(function1) | composer.Z(scheduleDto);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final Function1 function12 = function1;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt$SchedulesContent$1$1$2$1$1$1
                        public final void c() {
                            function12.invoke(new ScheduleSelectViewEvent.OnScheduleClicked(scheduleDto.h()));
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                ScheduleSelectScreenKt.M(scheduleDto, z3, (Function0) objG, i3 == i4, function0, composer, 0);
                composer.y();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object U(int i3, ScheduleSelectViewState.ScheduleDto schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        return schedule.h() + "-" + schedule.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(ColumnScope columnScope, List list, boolean z2, List list2, int i3, Function1 function1, Function0 function0, int i4, Composer composer, int i5) {
        S(columnScope, list, z2, list2, i3, function1, function0, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    public static final void u(final CoroutineScope scope, final ScaffoldState scaffoldState, final ScheduleSelectViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-2073274923);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(scope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(viewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2073274923, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.BottomBar (ScheduleSelectScreen.kt:244)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            boolean z2 = true;
            TextKt.c(StringResources_androidKt.b(R.string.ky, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).h(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composerK, 0, 0, 65534);
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            EnumEntries<AccessMethodConfiguration.Schedules.SchedulesBlockingMode> entries = AccessMethodConfiguration.Schedules.SchedulesBlockingMode.getEntries();
            boolean zC = viewState.c();
            int iOrdinal = viewState.i().ordinal();
            int i6 = i5 & 7168;
            boolean z3 = i6 == 2048;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.b0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleSelectScreenKt.v(onEvent, ((Integer) obj).intValue(), (AccessMethodConfiguration.Schedules.SchedulesBlockingMode) obj2);
                    }
                };
                composerK.w(objG);
            }
            Function2 function2 = (Function2) objG;
            boolean zI = composerK.I(scope);
            if ((i5 & 112) != 32) {
                z2 = false;
            }
            boolean zI2 = zI | z2 | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.c0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleSelectScreenKt.w(scope, scaffoldState, context, ((Integer) obj).intValue(), (AccessMethodConfiguration.Schedules.SchedulesBlockingMode) obj2);
                    }
                };
                composerK.w(objG2);
            }
            ChipKt.o(null, zC, 0.0f, entries, iOrdinal, 0L, function2, (Function2) objG2, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ScheduleSelectScreenKt.x((AccessMethodConfiguration.Schedules.SchedulesBlockingMode) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 0, 37);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(viewState.i().getDescriptionRes(), composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65530);
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            if (viewState.g()) {
                composerK.a0(886709476);
                B(null, StringResources_androidKt.b(viewState.h().isEmpty() ? R.string.L8 : R.string.Lt, composerK, 0), viewState.d(), onEvent, composerK, i6, 1);
            } else {
                composerK.a0(875273731);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.y(scope, scaffoldState, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, int i3, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        function1.invoke(new ScheduleSelectViewEvent.BlockingModeSelected(blockingMode));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(CoroutineScope coroutineScope, ScaffoldState scaffoldState, Context context, int i3, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode) {
        Intrinsics.checkNotNullParameter(schedulesBlockingMode, "<unused var>");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ScheduleSelectScreenKt$BottomBar$1$2$1$1(scaffoldState, context, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x(AccessMethodConfiguration.Schedules.SchedulesBlockingMode SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(-15044275);
        if (ComposerKt.M()) {
            ComposerKt.U(-15044275, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.BottomBar.<anonymous>.<anonymous> (ScheduleSelectScreen.kt:277)");
        }
        String strB = StringResources_androidKt.b(SelectableChipRow.getTitleRes(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(CoroutineScope coroutineScope, ScaffoldState scaffoldState, ScheduleSelectViewState scheduleSelectViewState, Function1 function1, int i3, Composer composer, int i4) {
        u(coroutineScope, scaffoldState, scheduleSelectViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void z(final ScaffoldState scaffoldState, ScheduleSelectViewModel scheduleSelectViewModel, Function2 function2, Composer composer, final int i3) {
        int i4;
        final Function2 function22;
        Composer composer2;
        final ScheduleSelectViewModel scheduleSelectViewModel2;
        int i5;
        Composer composerK = composer.k(-1171108163);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(scheduleSelectViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1171108163, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.CommandProcessor (ScheduleSelectScreen.kt:106)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(TuplesKt.a("", ""), null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState2 = (MutableState) objG3;
            ComposeDialogsKt.R0(mutableState, (String) ((Pair) mutableState2.getValue()).e(), (String) ((Pair) mutableState2.getValue()).f(), null, null, null, composerK, 6, 56);
            boolean zI = ((i4 & 896) == 256) | composerK.I(context) | composerK.I(coroutineScope) | ((i4 & 14) == 4);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                i5 = i4;
                ScheduleSelectScreenKt$CommandProcessor$1$1 scheduleSelectScreenKt$CommandProcessor$1$1 = new ScheduleSelectScreenKt$CommandProcessor$1$1(function2, context, mutableState2, mutableState, coroutineScope, scaffoldState, null);
                function22 = function2;
                composerK.w(scheduleSelectScreenKt$CommandProcessor$1$1);
                objG4 = scheduleSelectScreenKt$CommandProcessor$1$1;
            } else {
                function22 = function2;
                i5 = i4;
            }
            scheduleSelectViewModel2 = scheduleSelectViewModel;
            FlowExtKt.g(scheduleSelectViewModel2, null, (Function2) objG4, composerK, (i5 >> 3) & 14, 2);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function22 = function2;
            composer2 = composerK;
            scheduleSelectViewModel2 = scheduleSelectViewModel;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectScreenKt.A(scaffoldState, scheduleSelectViewModel2, function22, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
