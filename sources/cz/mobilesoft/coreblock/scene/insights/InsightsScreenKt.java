package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.MoodCheckInOpenTrigger;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonPresets;
import cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.coreblock.view.graph.TrendGraphKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsScreenKt {
    private static final void F(final InsightsViewModel insightsViewModel, final MutableState mutableState, final MutableState mutableState2, final SnackbarHostState snackbarHostState, final CoroutineScope coroutineScope, final Function1 function1, final MutableState mutableState3, Function0 function0, final MutableState mutableState4, final MutableState mutableState5, Composer composer, final int i3, final int i4) {
        int i5;
        MutableState mutableState6;
        final Function0 function02;
        Composer composer2;
        Function0 function03;
        int i6;
        Composer composerK = composer.k(1242419879);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(insightsViewModel) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            mutableState6 = mutableState;
            i5 |= composerK.Z(mutableState6) ? 32 : 16;
        } else {
            mutableState6 = mutableState;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(mutableState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(snackbarHostState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(coroutineScope) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.Z(mutableState3) ? 1048576 : 524288;
        }
        int i7 = i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i7 != 0) {
            i5 |= 12582912;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i3 & 12582912) == 0) {
                i5 |= composerK.I(function02) ? 8388608 : 4194304;
            }
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.Z(mutableState4) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(mutableState5) ? 536870912 : 268435456;
        }
        if (composerK.r((i5 & 306783379) != 306783378, i5 & 1)) {
            if (i7 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.l6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenKt.G();
                        }
                    };
                    composerK.w(objG);
                }
                function03 = (Function0) objG;
            } else {
                function03 = function02;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1242419879, i5, -1, "cz.mobilesoft.coreblock.scene.insights.CommandProcessor (InsightsScreen.kt:138)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = ((i5 & 112) == 32) | ((i5 & 896) == 256) | ((3670016 & i5) == 1048576) | composerK.I(context) | composerK.I(coroutineScope) | ((i5 & 7168) == 2048) | ((458752 & i5) == 131072) | ((29360128 & i5) == 8388608) | ((234881024 & i5) == 67108864) | ((1879048192 & i5) == 536870912);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                i6 = i5;
                InsightsScreenKt$CommandProcessor$2$1 insightsScreenKt$CommandProcessor$2$1 = new InsightsScreenKt$CommandProcessor$2$1(mutableState6, mutableState2, mutableState3, context, coroutineScope, function1, function03, mutableState4, mutableState5, snackbarHostState, null);
                composerK.w(insightsScreenKt$CommandProcessor$2$1);
                objG2 = insightsScreenKt$CommandProcessor$2$1;
            } else {
                i6 = i5;
            }
            composer2 = composerK;
            FlowExtKt.g(insightsViewModel, null, (Function2) objG2, composer2, i6 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function02 = function03;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.i5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenKt.H(insightsViewModel, mutableState, mutableState2, snackbarHostState, coroutineScope, function1, mutableState3, function02, mutableState4, mutableState5, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(InsightsViewModel insightsViewModel, MutableState mutableState, MutableState mutableState2, SnackbarHostState snackbarHostState, CoroutineScope coroutineScope, Function1 function1, MutableState mutableState3, Function0 function0, MutableState mutableState4, MutableState mutableState5, int i3, int i4, Composer composer, int i5) {
        F(insightsViewModel, mutableState, mutableState2, snackbarHostState, coroutineScope, function1, mutableState3, function0, mutableState4, mutableState5, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void I(final PackageManager packageManager, final InsightsViewState insightsViewState, final Function1 function1, final ScaffoldState scaffoldState, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final SnackbarHostState snackbarHostState, final MutableState mutableState6, Composer composer, final int i3, final int i4) {
        int i5;
        Function1 function12;
        MutableState mutableState7;
        MutableState mutableState8;
        MutableState mutableState9;
        MutableState mutableState10;
        MutableState mutableState11;
        int i6;
        Composer composer2;
        Composer composerK = composer.k(430096918);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(packageManager) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(insightsViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function12 = function1;
            i5 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(scaffoldState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            mutableState7 = mutableState;
            i5 |= composerK.Z(mutableState7) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            mutableState7 = mutableState;
        }
        if ((196608 & i3) == 0) {
            mutableState8 = mutableState2;
            i5 |= composerK.Z(mutableState8) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            mutableState8 = mutableState2;
        }
        if ((1572864 & i3) == 0) {
            mutableState9 = mutableState3;
            i5 |= composerK.Z(mutableState9) ? 1048576 : 524288;
        } else {
            mutableState9 = mutableState3;
        }
        if ((12582912 & i3) == 0) {
            mutableState10 = mutableState4;
            i5 |= composerK.Z(mutableState10) ? 8388608 : 4194304;
        } else {
            mutableState10 = mutableState4;
        }
        if ((100663296 & i3) == 0) {
            mutableState11 = mutableState5;
            i5 |= composerK.Z(mutableState11) ? 67108864 : 33554432;
        } else {
            mutableState11 = mutableState5;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.Z(snackbarHostState) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(mutableState6) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if (composerK.r(((i5 & 306783379) == 306783378 && (i6 & 3) == 2) ? false : true, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(430096918, i5, i6, "cz.mobilesoft.coreblock.scene.insights.Content (InsightsScreen.kt:213)");
            }
            final Function1 function13 = function12;
            final MutableState mutableState12 = mutableState7;
            final MutableState mutableState13 = mutableState8;
            final MutableState mutableState14 = mutableState9;
            final MutableState mutableState15 = mutableState10;
            final MutableState mutableState16 = mutableState11;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(1631770824, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.j5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenKt.J(scaffoldState, packageManager, insightsViewState, function13, snackbarHostState, mutableState12, mutableState13, mutableState14, mutableState15, mutableState16, mutableState6, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54);
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, composableLambdaE, composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.k5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenKt.O(packageManager, insightsViewState, function1, scaffoldState, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, snackbarHostState, mutableState6, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ScaffoldState scaffoldState, final PackageManager packageManager, final InsightsViewState insightsViewState, final Function1 function1, final SnackbarHostState snackbarHostState, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1631770824, i3, -1, "cz.mobilesoft.coreblock.scene.insights.Content.<anonymous> (InsightsScreen.kt:215)");
            }
            ScaffoldKt.a(null, scaffoldState, ComposableLambdaKt.e(-1845471347, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.l5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenKt.K(packageManager, insightsViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.e(-167393663, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.m5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenKt.L(snackbarHostState, (androidx.compose.material.SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1733694854, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.n5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenKt.M(insightsViewState, function1, packageManager, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24960, 12779520, 98281);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(PackageManager packageManager, InsightsViewState insightsViewState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1845471347, i3, -1, "cz.mobilesoft.coreblock.scene.insights.Content.<anonymous>.<anonymous> (InsightsScreen.kt:220)");
            }
            InsightsScreenToolbarsKt.w(packageManager, insightsViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final InsightsViewState insightsViewState, final Function1 function1, final PackageManager packageManager, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final SnackbarHostState snackbarHostState, final PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1733694854, i4, -1, "cz.mobilesoft.coreblock.scene.insights.Content.<anonymous>.<anonymous> (InsightsScreen.kt:227)");
            }
            if (insightsViewState.R()) {
                composer.a0(-366552741);
                InsightsScreenComponentsKt.P1(paddingValues, insightsViewState, function1, composer, i4 & 14);
                composer.U();
            } else if ((insightsViewState.g0() instanceof Loading) || (insightsViewState.g0() instanceof Success)) {
                composer.a0(1522130983);
                StructuredSkeletonKt.E(insightsViewState.g0() instanceof Loading, SkeletonPresets.f131964a.d(), PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), false, null, ComposableLambdaKt.e(407767021, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.o5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InsightsScreenKt.N(packageManager, insightsViewState, function1, paddingValues, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 196992, 24);
                composer.U();
            } else {
                composer.a0(1523439586);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
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
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                TextKt.c(StringResources_androidKt.b(R.string.sA, composer, 0), BoxScopeInstance.f6642a.f(SizeKt.h(PaddingKt.m(PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null), 0.0f, 1, null), companion2.e()), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65016);
                composer.y();
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(PackageManager packageManager, InsightsViewState insightsViewState, Function1 function1, PaddingValues paddingValues, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, SnackbarHostState snackbarHostState, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(407767021, i3, -1, "cz.mobilesoft.coreblock.scene.insights.Content.<anonymous>.<anonymous>.<anonymous> (InsightsScreen.kt:240)");
            }
            P(packageManager, insightsViewState, function1, paddingValues, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, snackbarHostState, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(PackageManager packageManager, InsightsViewState insightsViewState, Function1 function1, ScaffoldState scaffoldState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, SnackbarHostState snackbarHostState, MutableState mutableState6, int i3, int i4, Composer composer, int i5) {
        I(packageManager, insightsViewState, function1, scaffoldState, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, snackbarHostState, mutableState6, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0628  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void P(final android.content.pm.PackageManager r38, final cz.mobilesoft.coreblock.scene.insights.InsightsViewState r39, final kotlin.jvm.functions.Function1 r40, final androidx.compose.foundation.layout.PaddingValues r41, final androidx.compose.runtime.MutableState r42, final androidx.compose.runtime.MutableState r43, final androidx.compose.runtime.MutableState r44, final androidx.compose.runtime.MutableState r45, final androidx.compose.runtime.MutableState r46, androidx.compose.runtime.MutableState r47, final androidx.compose.material3.SnackbarHostState r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt.P(android.content.pm.PackageManager, cz.mobilesoft.coreblock.scene.insights.InsightsViewState, kotlin.jvm.functions.Function1, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.material3.SnackbarHostState, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(MutableState mutableState, Density density, IntSize intSize) {
        mutableState.setValue(Dp.d(density.F((int) (intSize.j() & 4294967295L))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(MutableState mutableState, IntSize intSize) {
        mutableState.setValue(Dp.d(Dp.g((int) (intSize.j() & 4294967295L))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnLockedScheduleClicked.f102682a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1) {
        function1.invoke(new InsightsViewEvent.OnScheduleSelectionConfirmed(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnMoodCheckInAutoDisableClicked.f102683a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(final InsightsViewState insightsViewState, final Function1 function1, MutableState mutableState, PackageManager packageManager, Context context, MutableState mutableState2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(329081022, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.h5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenKt.W(insightsViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        final GraphData graphDataL = insightsViewState.l();
        if (graphDataL != null) {
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-1863518735, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.s5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenKt.X(insightsViewState, graphDataL, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (insightsViewState.a0() == InsightsViewState.InsightsPeriodType.Trend) {
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-1211738279, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.d6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenKt.Z(insightsViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (insightsViewState.p0()) {
            InsightsScreenComponentsKt.M2(LazyColumn, insightsViewState, function1, mutableState);
        } else {
            InsightsScreenComponentsKt.Z2(LazyColumn, packageManager, context, insightsViewState, function1, mutableState2);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(InsightsViewState insightsViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(329081022, i3, -1, "cz.mobilesoft.coreblock.scene.insights.InsightsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InsightsScreen.kt:361)");
            }
            InsightsScreenComponentsKt.p1(insightsViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(InsightsViewState insightsViewState, GraphData graphData, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1863518735, i3, -1, "cz.mobilesoft.coreblock.scene.insights.InsightsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InsightsScreen.kt:370)");
            }
            if (insightsViewState.a0() != InsightsViewState.InsightsPeriodType.Trend) {
                composer.a0(660747917);
                boolean z2 = insightsViewState.a0() == InsightsViewState.InsightsPeriodType.Day;
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.f6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return InsightsScreenKt.Y(function1, (Integer) obj);
                        }
                    };
                    composer.w(objG);
                }
                BarGraphKt.i(graphData, z2, (Function1) objG, composer, GraphData.f132767h, 0);
                composer.U();
            } else {
                composer.a0(661165239);
                TrendGraphKt.c(SizeKt.i(SizeKt.h(PaddingKt.m(Modifier.b8, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null), Dp.g(240)), graphData, insightsViewState.f(), 0L, 0.0f, composer, (GraphData.f132767h << 3) | 6, 24);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, Integer num) {
        function1.invoke(new InsightsViewEvent.OnBarSelected(num));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(InsightsViewState insightsViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1211738279, i3, -1, "cz.mobilesoft.coreblock.scene.insights.InsightsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InsightsScreen.kt:393)");
            }
            InsightsScreenComponentsKt.z2(insightsViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, MoodType mood, int i3, String str) {
        Intrinsics.checkNotNullParameter(mood, "mood");
        function1.invoke(new InsightsViewEvent.OnMoodCheckInSaved(mood, i3, str));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(MutableState mutableState, Function1 function1) {
        if (Intrinsics.areEqual(mutableState.getValue(), MoodCheckInOpenTrigger.Automatic.f102953a)) {
            function1.invoke(InsightsViewEvent.OnMoodChekInClosed.f102687a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Function1 function1, int i3) {
        function1.invoke(new InsightsViewEvent.OnScheduleClicked(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnAddScheduleClicked.f102671a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Function1 function1) {
        function1.invoke(new InsightsViewEvent.OnScheduleSelectionConfirmed(false, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnDismissBottomSheet.f102678a);
        AnswersHelper.f128199a.z1();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(Context context, boolean z2) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(z2 ? PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED : PremiumFeature.PROFILES_APPS_UNLIMITED), "insights_detail", "unlimited_apps", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(PackageManager packageManager, InsightsViewState insightsViewState, Function1 function1, PaddingValues paddingValues, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, SnackbarHostState snackbarHostState, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        P(packageManager, insightsViewState, function1, paddingValues, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, snackbarHostState, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i0(java.lang.String r24, cz.mobilesoft.coreblock.scene.insights.InsightsViewState.InsightsPeriodType r25, kotlin.jvm.functions.Function1 r26, kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt.i0(java.lang.String, cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(List list) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(InsightsViewModel insightsViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        insightsViewModel.y2(event);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(String str, InsightsViewState.InsightsPeriodType insightsPeriodType, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        i0(str, insightsPeriodType, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder n0(String str, InsightsViewState.InsightsPeriodType insightsPeriodType) {
        return ParametersHolderKt.b(str, insightsPeriodType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(SnackbarHostState snackbarHostState, androidx.compose.material.SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-167393663, i3, -1, HcgZcEUYo.hBGc);
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, 0, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
