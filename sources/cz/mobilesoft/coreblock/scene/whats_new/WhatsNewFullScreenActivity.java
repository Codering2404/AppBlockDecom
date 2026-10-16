package cz.mobilesoft.coreblock.scene.whats_new;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.repository.AppVersionRepository;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFeature;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WhatsNewFullScreenActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f123056h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f123057i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f123058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f123059g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return WhatsNewFullScreenActivity.P0(this.f123064a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            return companion.a(context, str);
        }

        public final Intent a(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putString("FORCED_VERSION", str);
            Intent intent = new Intent(context, (Class<?>) WhatsNewFullScreenActivity.class);
            intent.putExtras(bundle);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A0(WhatsNewFullScreenViewState whatsNewFullScreenViewState) {
        return whatsNewFullScreenViewState.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B0(PagerState pagerState) {
        return pagerState.v() + 1 == pagerState.H();
    }

    private static final boolean C0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(MutableState mutableState, Density density, IntSize intSize) {
        mutableState.setValue(Dp.d(density.F((int) (intSize.j() >> 32))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(WhatsNewFullScreenActivity whatsNewFullScreenActivity) {
        whatsNewFullScreenActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(WhatsNewFullScreenActivity whatsNewFullScreenActivity, WhatsNewFullScreenViewState whatsNewFullScreenViewState, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(973088596, i4, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.Content.<anonymous>.<anonymous> (WhatsNewFullScreenActivity.kt:206)");
        }
        whatsNewFullScreenActivity.J0(SizeKt.f(Modifier.b8, 0.0f, 1, null), (ChangelogFeature) whatsNewFullScreenViewState.c().get(i3), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(PagerState pagerState, CoroutineScope coroutineScope, WhatsNewFullScreenActivity whatsNewFullScreenActivity) {
        if (pagerState.v() + 1 < pagerState.H()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new WhatsNewFullScreenActivity$Content$1$4$1$1(pagerState, null), 3, null);
        } else {
            whatsNewFullScreenActivity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(State state, RowScope ButtonFlat, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(ButtonFlat, "$this$ButtonFlat");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1199129522, i3, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.Content.<anonymous>.<anonymous> (WhatsNewFullScreenActivity.kt:244)");
            }
            if (C0(state)) {
                composer.a0(-1312233002);
                i4 = R.string.l8;
            } else {
                composer.a0(-1312231541);
                i4 = R.string.Gk;
            }
            String strB = StringResources_androidKt.b(i4, composer, 0);
            composer.U();
            TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).a(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(WhatsNewFullScreenActivity whatsNewFullScreenActivity, WhatsNewFullScreenViewState whatsNewFullScreenViewState, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        whatsNewFullScreenActivity.z0(whatsNewFullScreenViewState, paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void J0(final Modifier modifier, final ChangelogFeature changelogFeature, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1780670550);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(changelogFeature) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1780670550, i4, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.PageContent (WhatsNewFullScreenActivity.kt:257)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            float fG = Dp.g(8);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.q(fG, companion.i()), companion.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
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
            Integer numC = changelogFeature.c();
            if (numC == null) {
                composerK.a0(259091425);
            } else {
                composerK.a0(259091426);
                int iIntValue = numC.intValue();
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierM = PaddingKt.m(ColumnScope.b(columnScopeInstance, companion3, 1.0f, false, 2, null), 0.0f, Dp.g(32), 0.0f, Dp.g(16), 5, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A2 = companion2.a();
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
                Updater.e(composerA2, measurePolicyG, companion2.e());
                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                Function2 function2B2 = companion2.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ImageKt.a(PainterResources_androidKt.c(iIntValue, composerK, 0), null, SizeKt.d(companion3, 0.0f, 1, null), null, null, 0.0f, null, composerK, 432, 120);
                composerK.y();
            }
            composerK.U();
            String strB = StringResources_androidKt.b(changelogFeature.j(), composerK, 0);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).a(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(strB, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleE, composer2, 0, 0, 65018);
            TextKt.c(StringResources_androidKt.b(changelogFeature.h(), composer2, 0), null, ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, 0, 0, 65018);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.whats_new.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsNewFullScreenActivity.K0(this.f123073a, modifier, changelogFeature, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(WhatsNewFullScreenActivity whatsNewFullScreenActivity, Modifier modifier, ChangelogFeature changelogFeature, int i3, Composer composer, int i4) {
        whatsNewFullScreenActivity.J0(modifier, changelogFeature, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder L0(WhatsNewFullScreenActivity whatsNewFullScreenActivity) {
        return ParametersHolderKt.b(whatsNewFullScreenActivity.Q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(final WhatsNewFullScreenActivity whatsNewFullScreenActivity, final WhatsNewFullScreenViewState whatsNewFullScreenViewState, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-913649770, i3, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.RootCompose.<anonymous> (WhatsNewFullScreenActivity.kt:118)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, null, null, null, 0, Color.f25715b.j(), 0L, null, ComposableLambdaKt.e(-235322073, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.whats_new.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsNewFullScreenActivity.N0(this.f123083a, whatsNewFullScreenViewState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 806879232, 446);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(WhatsNewFullScreenActivity whatsNewFullScreenActivity, WhatsNewFullScreenViewState whatsNewFullScreenViewState, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-235322073, i3, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.RootCompose.<anonymous>.<anonymous> (WhatsNewFullScreenActivity.kt:123)");
            }
            whatsNewFullScreenActivity.z0(whatsNewFullScreenViewState, it, composer, (i3 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(WhatsNewFullScreenActivity whatsNewFullScreenActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        whatsNewFullScreenActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String P0(WhatsNewFullScreenActivity whatsNewFullScreenActivity) {
        Bundle extras = whatsNewFullScreenActivity.getIntent().getExtras();
        if (extras != null) {
            return extras.getString("FORCED_VERSION");
        }
        return null;
    }

    private final void z0(final WhatsNewFullScreenViewState whatsNewFullScreenViewState, final PaddingValues paddingValues, Composer composer, final int i3) {
        Composer composer2;
        long jS;
        Composer composerK = composer.k(-1151236117);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(whatsNewFullScreenViewState) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1151236117, i4, -1, "cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity.Content (WhatsNewFullScreenActivity.kt:137)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            boolean z2 = (i4 & 14) == 4;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(WhatsNewFullScreenActivity.A0(whatsNewFullScreenViewState));
                    }
                };
                composerK.w(objG2);
            }
            final PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG2, composerK, 54, 0);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(WhatsNewFullScreenActivity.B0(pagerStateL));
                    }
                });
                composerK.w(objG3);
            }
            final State state = (State) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(0)), null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState = (MutableState) objG4;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierI = PaddingKt.i(PaddingKt.h(BackgroundKt.d(SizeKt.f(companion2, 0.0f, 1, null), Color.f25715b.j(), null, 2, null), paddingValues), Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = arrangement.b();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, companion3.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Modifier modifierK = SizeKt.k(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(56), 0.0f, 2, null);
            float f3 = 8;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f3)), companion3.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (pagerStateL.H() <= 0 || C0(state)) {
                composerK.a0(-29022927);
            } else {
                composerK.a0(-22179181);
                SpacerKt.a(SizeKt.A(companion2, ((Dp) mutableState.getValue()).l()), composerK, 0);
            }
            composerK.U();
            TextKt.c(StringResources_androidKt.b(R.string.gH, composerK, 0), RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).a(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composerK, 0, 0, 65016);
            Composer composer3 = composerK;
            if (pagerStateL.H() <= 0 || C0(state)) {
                composer3.a0(-29022927);
            } else {
                composer3.a0(-21611416);
                boolean Z = composer3.Z(density);
                Object objG5 = composer3.G();
                if (Z || objG5 == companion.a()) {
                    objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.whats_new.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WhatsNewFullScreenActivity.D0(mutableState, density, (IntSize) obj);
                        }
                    };
                    composer3.w(objG5);
                }
                Modifier modifierA = OnRemeasuredModifierKt.a(companion2, (Function1) objG5);
                float fG = Dp.g(46);
                FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
                String strB = StringResources_androidKt.b(R.string.wx, composer3, 0);
                boolean zI = composer3.I(this);
                Object objG6 = composer3.G();
                if (zI || objG6 == companion.a()) {
                    objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WhatsNewFullScreenActivity.E0(this.f123089a);
                        }
                    };
                    composer3.w(objG6);
                }
                FlatButtonsKt.u(modifierA, fG, 0.0f, null, secondary, null, strB, null, 0L, null, null, false, false, (Function0) objG6, composer3, 24624, 390, 2988);
                composer3 = composer3;
            }
            composer3.U();
            composer3.y();
            Composer composer4 = composer3;
            PagerKt.a(pagerStateL, ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.e(973088596, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.whats_new.n
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return WhatsNewFullScreenActivity.F0(this.f123090a, whatsNewFullScreenViewState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer3, 54), composer4, 0, 24576, 16380);
            if (pagerStateL.H() > 1) {
                composer4.a0(-1360512698);
                Modifier modifierK2 = PaddingKt.k(companion2, 0.0f, Dp.g(32), 1, null);
                MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.b(), companion3.l(), composer4, 6);
                int iA3 = ComposablesKt.a(composer4, 0);
                CompositionLocalMap compositionLocalMapU3 = composer4.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer4, modifierK2);
                Function0 function0A3 = companion4.a();
                if (composer4.m() == null) {
                    ComposablesKt.c();
                }
                composer4.L();
                if (composer4.i()) {
                    composer4.P(function0A3);
                } else {
                    composer4.v();
                }
                Composer composerA3 = Updater.a(composer4);
                Updater.e(composerA3, measurePolicyB2, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                composer4.a0(1233014174);
                int iH = pagerStateL.H();
                for (int i5 = 0; i5 < iH; i5++) {
                    if (pagerStateL.v() == i5) {
                        composer4.a0(1163908498);
                        jS = ComposeColorsKt.j(composer4, 0).p();
                    } else {
                        composer4.a0(1163909299);
                        jS = ComposeColorsKt.j(composer4, 0).s();
                    }
                    composer4.U();
                    BoxKt.a(SizeKt.v(BackgroundKt.d(ClipKt.a(PaddingKt.i(Modifier.b8, Dp.g(4)), RoundedCornerShapeKt.g()), jS, null, 2, null), Dp.g(f3)), composer4, 0);
                }
                composer4.U();
                composer4.y();
                composer4.U();
            } else {
                composer4.a0(-1359759708);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(72)), composer4, 6);
                composer4.U();
            }
            boolean Z2 = composer4.Z(pagerStateL) | composer4.I(coroutineScope) | composer4.I(this);
            Object objG7 = composer4.G();
            if (Z2 || objG7 == Composer.f23746a.a()) {
                objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WhatsNewFullScreenActivity.G0(pagerStateL, coroutineScope, this);
                    }
                };
                composer4.w(objG7);
            }
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1199129522, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.whats_new.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsNewFullScreenActivity.H0(state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54);
            composer2 = composer4;
            FlatButtonsKt.r(null, 0.0f, null, null, false, false, (Function0) objG7, composableLambdaE, composer2, 12582912, 63);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.whats_new.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsNewFullScreenActivity.I0(this.f123069a, whatsNewFullScreenViewState, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final String Q0() {
        return (String) this.f123059g.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f123058f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotificationHelper.f128940a.a(this);
        AppVersionRepository.f97355a.H();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1228453240);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1228453240, i4, -1, qRMDmh.zHQG);
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.whats_new.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WhatsNewFullScreenActivity.L0(this.f123077a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(WhatsNewFullScreenViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            final WhatsNewFullScreenViewState whatsNewFullScreenViewState = (WhatsNewFullScreenViewState) FlowExtKt.m((WhatsNewFullScreenViewModel) viewModelA, composerK, 0);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-913649770, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.whats_new.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WhatsNewFullScreenActivity.M0(this.f123078a, whatsNewFullScreenViewState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.whats_new.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WhatsNewFullScreenActivity.O0(this.f123080a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
