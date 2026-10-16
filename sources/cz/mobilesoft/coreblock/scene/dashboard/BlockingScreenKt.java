package cz.mobilesoft.coreblock.scene.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.text.BidiFormatter;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.AnnouncementCardState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.DiscountState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.dashboard.card.AnnouncementCardKt;
import cz.mobilesoft.coreblock.scene.dashboard.card.PermissionsCardKt;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockTimePickerBottomSheetKt;
import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
import cz.mobilesoft.coreblock.scene.streaks.banner.StreakTopBannerKt;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailActivity;
import cz.mobilesoft.coreblock.scene.streaks.entry.StreakToolbarButtonKt;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ModifierExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import cz.mobilesoft.coreblock.view.graph.DonutChartData;
import cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection;
import cz.mobilesoft.coreblock.view.graph.DonutChartKt;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BlockingScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f99124a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f99124a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(BlockingScreenViewState blockingScreenViewState, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1068399781, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:661)");
            }
            a1(blockingScreenViewState, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Context context) {
        AnswersHelper.f128199a.Z6();
        context.startActivity(StreakDetailActivity.f120665g.a(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(BlockingScreenViewState blockingScreenViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-454973824, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:666)");
            }
            E1(blockingScreenViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(BlockingScreenViewState blockingScreenViewState, Function1 function1, int i3, Composer composer, int i4) {
        w1(blockingScreenViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(BlockingScreenViewState blockingScreenViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1501110622, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:812)");
            }
            ScheduleTemplatesSectionKt.t(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), blockingScreenViewState.v(), function1, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void C1(final int i3, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(240949079);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(240949079, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.TroubleshootingInfoRow (BlockingScreen.kt:1149)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95523i1, composerK, 6), StringResources_androidKt.b(R.string.Yf, composerK, 0), SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composerK, 0).b(), composerK, 384, 0);
            TextKt.c(StringResources_androidKt.b(i3, composerK, i5 & 14), PaddingKt.m(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 48, 0, 65528);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.D1(i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(BlockingScreenViewState blockingScreenViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(81786591, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:820)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (blockingScreenViewState.v()) {
                composer.a0(693107516);
                Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
                ScheduleTemplate scheduleTemplateS = blockingScreenViewState.s();
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.v0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingScreenKt.E0(function1, (ScheduleTemplate) obj);
                        }
                    };
                    composer.w(objG);
                }
                Function1 function12 = (Function1) objG;
                boolean Z2 = composer.Z(function1);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.w0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingScreenKt.F0(function1, (ScheduleTemplate) obj);
                        }
                    };
                    composer.w(objG2);
                }
                composer2 = composer;
                ScheduleTemplatesSectionKt.w(modifierK, scheduleTemplateS, function12, (Function1) objG2, composer2, 0, 0);
            } else {
                composer2 = composer;
                composer2.a0(653430957);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(int i3, int i4, Composer composer, int i5) {
        C1(i3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(Function1 function1, ScheduleTemplate template) {
        Intrinsics.checkNotNullParameter(template, "template");
        function1.invoke(new BlockingScreenViewEvent.OnProfileItemEvent(new ProfileItemEvent.OnProfileTemplateSelected(template)));
        AnswersHelper.f128199a.h5(template.getAnalyticsKey());
        return Unit.f139807a;
    }

    private static final void E1(final BlockingScreenViewState blockingScreenViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(181064750);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(blockingScreenViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(181064750, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.TroubleshootingRow (BlockingScreen.kt:1082)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            CardType.Custom custom = new CardType.Custom(Color.r(ComposeColorsKt.j(composerK, 0).b(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, 14, null);
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.F1(function1);
                    }
                };
                composerK.w(objG);
            }
            ComposeCardsKt.m(modifierK, custom, (Function0) objG, ComposableLambdaKt.e(-1540458989, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.G1(function1, blockingScreenViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3072, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.J1(blockingScreenViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Function1 function1, ScheduleTemplate seasonalTemplate) {
        Intrinsics.checkNotNullParameter(seasonalTemplate, "seasonalTemplate");
        function1.invoke(new BlockingScreenViewEvent.OnProfileItemEvent(new ProfileItemEvent.OnProfileSeasonalTemplateDismissed(seasonalTemplate)));
        AnswersHelper.f128199a.f5(seasonalTemplate.getAnalyticsKey());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnTroubleshootingCardClicked.f99556a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(BlockingScreenViewState blockingScreenViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(44791388, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:674)");
            }
            l0(blockingScreenViewState.c(), function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(final Function1 function1, BlockingScreenViewState blockingScreenViewState, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1540458989, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.TroubleshootingRow.<anonymous> (BlockingScreen.kt:1092)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion, companion2.n()), 0.0f, Dp.g(6), 0.0f, 0.0f, 13, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.c1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.H1(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierM, imageVectorB, null, false, 0.0f, 0.0f, jQ, strB, (Function0) objG, composer, 0, 60);
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.Rm, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65534);
            SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer, 6);
            TextKt.c(StringResources_androidKt.c(R.string.Sm, new Object[]{blockingScreenViewState.l()}, composer, 0), null, ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            composer.a0(1301517432);
            Iterator it = blockingScreenViewState.n().iterator();
            while (it.hasNext()) {
                C1(((HelpItem) it.next()).getTitleResId(), composer, 0);
            }
            composer.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer, 6);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.aw, composer, 0), null, false, 27, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.e1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.I1(function1);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, smallRound, accent, (Function0) objG2, composer, 0, 1);
            composer.y();
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
    public static final Unit H0(BlockingScreenViewState blockingScreenViewState, final boolean z2, final Context context, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(666604919, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:682)");
            }
            Long lH = blockingScreenViewState.h();
            String strC = null;
            if (lH == null || !z2) {
                lH = null;
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            Integer numValueOf = lH != null ? Integer.valueOf((int) TimeUnit.MILLISECONDS.toDays(lH.longValue())) : null;
            String strM1 = lH != null ? M1(lH.longValue()) : null;
            if (lH == null) {
                composer.a0(-1101024725);
            } else {
                composer.a0(-1101024724);
                strC = StringResources_androidKt.c(R.string.f95808j2, new Object[]{""}, composer, 0);
            }
            composer.U();
            String strB = StringResources_androidKt.b(R.string.X1, composer, 0);
            boolean zB = composer.b(z2) | composer.I(context);
            Object objG = composer.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.x0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.I0(z2, context);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean Z = composer.Z(function1) | composer.b(z2);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.y0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.J0(function1, z2);
                    }
                };
                composer.w(objG2);
            }
            PremiumExpiringCardKt.r(modifierK, numValueOf, function0, (Function0) objG2, strM1, strC, strB, composer, 0, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnTroubleshootingCardClosed.f99557a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(boolean z2, Context context) {
        AnswersHelper.f128199a.P3("home_screen");
        context.startActivity(PremiumExpiringActivity.f113543g.a(context, "blocking_tab", z2 ? "auto_trial_active_card" : "auto_trial_expired_card", PremiumExpiringActivity.PremiumExpiringTrialType.Monthly));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnTroubleshootingCardClicked.f99556a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Function1 function1, boolean z2) {
        function1.invoke(z2 ? BlockingScreenViewEvent.OnAutoTrialCardClosed.f99545a : BlockingScreenViewEvent.OnAutoTrialExpiredCardClosed.f99546a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(BlockingScreenViewState blockingScreenViewState, Function1 function1, int i3, Composer composer, int i4) {
        E1(blockingScreenViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(BlockingScreenViewState blockingScreenViewState, final Context context, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-937798048, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:705)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            Integer numK = blockingScreenViewState.k();
            boolean zI = composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.L0(context);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.r0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.M0(function1);
                    }
                };
                composer.w(objG2);
            }
            PremiumExpiringCardKt.r(modifierK, numK, function0, (Function0) objG2, null, null, null, composer, 0, 112);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(Context context) {
        AnswersHelper.f128199a.P3("home_screen");
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.ExpiredSubDiscount(false), "renewal_screen", "blocking_tab", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    public static final String L1(long j3, Composer composer, int i3) {
        String strC;
        if (ComposerKt.M()) {
            ComposerKt.U(-1368380158, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.autoTrialCountdownText (BlockingScreen.kt:1034)");
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long days = timeUnit.toDays(j3);
        if (days >= 1) {
            composer.a0(-1878531282);
            int i4 = (int) days;
            strC = ComposableExtKt.t(R.plurals.f95748i, i4, new Object[]{Integer.valueOf(i4)}, composer, 0);
            composer.U();
        } else {
            composer.a0(-753331611);
            composer.U();
            strC = DateHelper.c(Long.valueOf(timeUnit.toSeconds(j3)));
            Intrinsics.checkNotNull(strC);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnPremiumExpiringCardClosed.f99549a);
        return Unit.f139807a;
    }

    public static final String M1(long j3) {
        long jG = RangesKt.g(TimeUnit.MILLISECONDS.toSeconds(j3), 0L);
        long j4 = jG / 86400;
        long j5 = (jG % 86400) / 3600;
        long j6 = (jG % 3600) / 60;
        String strC0 = StringsKt.C0(String.valueOf(jG % 60), 2, '0');
        if (j4 > 0) {
            return j4 + "d " + j5 + "h " + j6 + "m " + strC0 + "s";
        }
        if (j5 > 0) {
            return j5 + "h " + j6 + "m " + strC0 + "s";
        }
        if (j6 <= 0) {
            return strC0 + "s";
        }
        return j6 + "m " + strC0 + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ScaffoldState scaffoldState, MutableState mutableState, LazyItemScope item, Composer composer, int i3) throws ClosedScopeException, NoBeanDefFoundException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-752719112, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:733)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            QuickBlockCardKt.M0(scaffoldState, mutableState, composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
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
    public static final Unit O0(boolean z2, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2122924153, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:748)");
            }
            if (z2) {
                composer.a0(640060133);
                SchedulesSectionKt.z(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), composer, 0, 0);
                composer.U();
            } else {
                composer.a0(640298244);
                Modifier modifierK = PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.m0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlockingScreenKt.P0(function1, (ProfileItemEvent) obj);
                        }
                    };
                    composer.w(objG);
                }
                SchedulesSectionKt.B(modifierK, (Function1) objG, composer, 0, 0);
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
    public static final Unit P0(Function1 function1, ProfileItemEvent profileEvent) {
        Intrinsics.checkNotNullParameter(profileEvent, "profileEvent");
        function1.invoke(new BlockingScreenViewEvent.OnProfileItemEvent(profileEvent));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-825527930, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlockingScreen.kt:769)");
            }
            Modifier modifierM = PaddingKt.m(Modifier.b8, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null);
            List listY = ProfileHelper.f129250a.y();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenKt.R0(function1, (ProfileItemEvent) obj);
                    }
                };
                composer.w(objG);
            }
            SchedulesSectionKt.t(modifierM, listY, (Function1) objG, composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(Function1 function1, ProfileItemEvent profileEvent) {
        Intrinsics.checkNotNullParameter(profileEvent, "profileEvent");
        function1.invoke(new BlockingScreenViewEvent.OnProfileItemEvent(profileEvent));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object S0(int i3, ProfileViewDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return "profile_" + dto.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(PaddingValues paddingValues, ScaffoldState scaffoldState, BlockingScreenViewState blockingScreenViewState, AppIconCache appIconCache, Function1 function1, MutableState mutableState, int i3, Composer composer, int i4) {
        y0(paddingValues, scaffoldState, blockingScreenViewState, appIconCache, function1, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(Composer composer, final int i3) {
        Composer composerK = composer.k(-187685881);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-187685881, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.ElevationColumnSpacer (BlockingScreen.kt:853)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95479m, composerK, 0)), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.V0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(int i3, Composer composer, int i4) {
        U0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void W0(androidx.compose.ui.Modifier r21, final cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection r22, kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt.W0(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.view.graph.DonutChartDataCollection, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(boolean z2, DonutChartDataCollection donutChartDataCollection, Composer composer, int i3) {
        DonutChartDataCollection donutChartDataCollection2;
        long jQ;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1043095804, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.InsightsTodayScreenTimeBadge.<anonymous> (BlockingScreen.kt:874)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, Dp.g(8), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(4)), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierV = SizeKt.v(companion, Dp.g(24));
            if (z2) {
                composer.a0(409602089);
                composer.U();
                donutChartDataCollection2 = donutChartDataCollection;
            } else {
                composer.a0(409675776);
                donutChartDataCollection2 = new DonutChartDataCollection(CollectionsKt.listOf(new DonutChartData(1.0f, ComposeColorsKt.j(composer, 0).q(), null)));
                composer.U();
            }
            DonutChartKt.c(donutChartDataCollection2, modifierV, 0.0f, 0.0f, composer, 48, 12);
            String strF = z2 ? DateHelperExtKt.f((long) donutChartDataCollection.b(), false, false, false, 14, null) : "0h 0m";
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            if (z2) {
                composer.a0(-1649331380);
                jQ = ComposeColorsKt.j(composer, 0).p();
            } else {
                composer.a0(-1649330579);
                jQ = ComposeColorsKt.j(composer, 0).q();
            }
            composer.U();
            TextKt.c(strF, null, jQ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleI, composer, 0, 0, 65530);
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
    public static final Unit Z0(Modifier modifier, DonutChartDataCollection donutChartDataCollection, Function0 function0, int i3, int i4, Composer composer, int i5) {
        W0(modifier, donutChartDataCollection, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void a1(final BlockingScreenViewState blockingScreenViewState, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composerK = composer.k(1476710007);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(blockingScreenViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1476710007, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.PermissionsRow (BlockingScreen.kt:1062)");
            }
            List listD = blockingScreenViewState.o().d();
            boolean zC = blockingScreenViewState.o().c();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            List list = listD;
            PermissionsCardKt.d(StringResources_androidKt.b(R.string.W8, composerK, 0), list, zC, null, 0, null, composerK, 0, 56);
            composerK.y();
            if (zC || !list.isEmpty()) {
                composerK.a0(-681562702);
                SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composerK, 6);
            } else {
                composerK.a0(-730429397);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.b1(blockingScreenViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(BlockingScreenViewState blockingScreenViewState, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        a1(blockingScreenViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void c1(final String str, TextStyle textStyle, final Function0 function0, Composer composer, final int i3) {
        int i4;
        final TextStyle textStyle2 = textStyle;
        Composer composerK = composer.k(-167291986);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(textStyle2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-167291986, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.PremiumBottomBar (BlockingScreen.kt:987)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = ClickableKt.f(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).l0(), null, 2, null), false, null, null, function0, 7, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Alignment.Vertical verticalI = companion2.i();
            Modifier modifierF3 = boxScopeInstance.f(SizeKt.h(companion, 0.0f, 1, null), companion2.e());
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalB, verticalI, composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f3 = 8;
            IconKt.a(PainterResources_androidKt.c(R.drawable.p4, composerK, 0), null, PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), ComposeColorsKt.j(composerK, 0).Y(), composerK, 432, 0);
            TextKt.c(str, PaddingKt.i(companion, Dp.g(f3)), ComposeColorsKt.j(composerK, 0).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composerK, (i5 & 14) | 48, (i5 << 15) & 3670016, 65528);
            textStyle2 = textStyle;
            composerK = composerK;
            composerK.y();
            t0(boxScopeInstance, composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.d1(str, textStyle2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(String str, TextStyle textStyle, Function0 function0, int i3, Composer composer, int i4) {
        c1(str, textStyle, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void e1(final long r32, kotlin.jvm.functions.Function0 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 978
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt.e1(long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(long j3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        e1(j3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void g1(final androidx.compose.material.ScaffoldState r25, final cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState r26, final cz.mobilesoft.coreblock.util.view.AppIconCache r27, final kotlin.jvm.functions.Function1 r28, final kotlin.jvm.functions.Function1 r29, final kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt.g1(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewState, cz.mobilesoft.coreblock.util.view.AppIconCache, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(final ScaffoldState scaffoldState, final BlockingScreenViewState blockingScreenViewState, boolean z2, final Function1 function1, final Function1 function12, final boolean z3, final DiscountState discountState, final AppIconCache appIconCache, final MutableState mutableState, final Function1 function13, BoxScope GradientBox, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1330267355, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.RootCompose.<anonymous> (BlockingScreen.kt:396)");
            }
            Modifier.Companion companion = Modifier.b8;
            WindowInsets.Companion companion2 = WindowInsets.f7172a;
            Modifier.Companion companion3 = companion;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.e(companion2, composer, 6)), scaffoldState, ComposableLambdaKt.e(1470468736, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.i1(blockingScreenViewState, function12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(90683423, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.j1(blockingScreenViewState, z3, discountState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableSingletons$BlockingScreenKt.f99125a.i(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1002113241, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.n1(scaffoldState, blockingScreenViewState, appIconCache, function1, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 28032, 12779520, 98272);
            if (blockingScreenViewState.C()) {
                composer.a0(-325413211);
                float f3 = 10;
                float fG = Dp.g(f3);
                if (z2) {
                    f3 = 48;
                }
                Modifier modifierM = PaddingKt.m(companion3, 0.0f, 0.0f, fG, Dp.g(f3), 3, null);
                Alignment.Companion companion4 = Alignment.f25072a;
                Modifier modifierF = GradientBox.f(modifierM, companion4.c());
                MeasurePolicy measurePolicyG = BoxKt.g(companion4.e(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A = companion5.a();
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
                Updater.e(composerA, measurePolicyG, companion5.e());
                Updater.e(composerA, compositionLocalMapU, companion5.g());
                Function2 function2B = companion5.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion5.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                StrictModeState strictModeState = StrictModeState.Active;
                float fG2 = Dp.g(38);
                float fG3 = Dp.g(64);
                Modifier modifierA = ClipKt.a(companion3, RoundedCornerShapeKt.g());
                boolean Z = composer.Z(function13);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.o1(function13);
                        }
                    };
                    composer.w(objG);
                }
                Modifier modifierF3 = ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null);
                Dp dpD = Dp.d(fG3);
                composer2 = composer;
                companion3 = companion3;
                StrictModeBallKt.r(strictModeState, modifierF3, dpD, fG2, true, composer2, 28038, 0);
                composer2.y();
            } else {
                composer2 = composer;
                composer2.a0(-350798243);
            }
            composer2.U();
            StreakDailyPresenter.Presentation.Banner bannerW = blockingScreenViewState.w();
            boolean Z2 = composer2.Z(function1);
            Object objG2 = composer2.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.p1(function1);
                    }
                };
                composer2.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            boolean Z3 = composer2.Z(function1);
            Object objG3 = composer2.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.q1(function1);
                    }
                };
                composer2.w(objG3);
            }
            StreakTopBannerKt.g(bannerW, function0, (Function0) objG3, WindowInsetsPaddingKt.d(GradientBox.f(companion3, Alignment.f25072a.m()), WindowInsets_androidKt.e(companion2, composer2, 6)), composer2, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(BlockingScreenViewState blockingScreenViewState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1470468736, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.RootCompose.<anonymous>.<anonymous> (BlockingScreen.kt:404)");
            }
            w1(blockingScreenViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(BlockingScreenViewState blockingScreenViewState, boolean z2, final DiscountState discountState, Composer composer, int i3) {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(90683423, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.RootCompose.<anonymous>.<anonymous> (BlockingScreen.kt:421)");
            }
            final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            if (blockingScreenViewState.h() != null && blockingScreenViewState.i().getShowsLabel()) {
                composer.a0(15623656);
                String strJ = BidiFormatter.c().j(StringResources_androidKt.c(R.string.f95808j2, new Object[]{L1(blockingScreenViewState.h().longValue(), composer, 0)}, composer, 0));
                Intrinsics.checkNotNullExpressionValue(strJ, "unicodeWrap(...)");
                TextStyle textStyleD = cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).i());
                boolean zI = composer.I(context);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.k1(context);
                        }
                    };
                    composer.w(objG);
                }
                c1(strJ, textStyleD, (Function0) objG, composer, 0);
                composer.U();
            } else if (!blockingScreenViewState.D() || z2) {
                if (z2) {
                    composer.a0(18409161);
                    Long lE = discountState != null ? discountState.e() : null;
                    if (discountState == null || lE == null) {
                        composer2 = composer;
                        composer2.a0(-4848093);
                    } else {
                        composer.a0(18660261);
                        long jLongValue = lE.longValue();
                        boolean Z = composer.Z(discountState) | composer.I(context);
                        Object objG2 = composer.G();
                        if (Z || objG2 == Composer.f23746a.a()) {
                            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.k
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BlockingScreenKt.m1(discountState, context);
                                }
                            };
                            composer.w(objG2);
                        }
                        composer2 = composer;
                        e1(jLongValue, (Function0) objG2, composer2, 0, 0);
                    }
                    composer2.U();
                } else {
                    composer2 = composer;
                    composer2.a0(-4848093);
                }
                composer2.U();
            } else {
                composer.a0(16742911);
                AnswersHelper.f128199a.b0();
                String strJ2 = BidiFormatter.c().j(StringResources_androidKt.b(R.string.Ce, composer, 0));
                Intrinsics.checkNotNullExpressionValue(strJ2, "unicodeWrap(...)");
                TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
                boolean zI2 = composer.I(context);
                Object objG3 = composer.G();
                if (zI2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.l1(context);
                        }
                    };
                    composer.w(objG3);
                }
                c1(strJ2, textStyleI, (Function0) objG3, composer, 0);
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
    public static final Unit k1(Context context) {
        AnswersHelper.f128199a.P3("home_screen");
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.AutoTrialPromo(false), "blocking_tab", "auto_trial_label", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    private static final void l0(final AnnouncementCardState announcementCardState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-225646540);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(announcementCardState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-225646540, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.AnnouncementRow (BlockingScreen.kt:1175)");
            }
            boolean zA = announcementCardState.a();
            final QuestionnaireConfig questionnaireConfigB = announcementCardState.b();
            if (zA) {
                composerK.a0(-611987678);
                final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
                if (questionnaireConfigB != null) {
                    AnswersHelper.f128199a.o4(questionnaireConfigB.b());
                } else {
                    AnswersHelper.f128199a.i1();
                }
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierK = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
                int i5 = i4 & 112;
                boolean zI = composerK.I(context) | composerK.Z(questionnaireConfigB) | (i5 == 32);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.m0(context, function1, questionnaireConfigB);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean Z = composerK.Z(questionnaireConfigB) | (i5 == 32);
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.o0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.n0(questionnaireConfigB, function1);
                        }
                    };
                    composerK.w(objG2);
                }
                AnnouncementCardKt.e(modifierK, questionnaireConfigB, function0, (Function0) objG2, composerK, 0, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composerK, 6);
            } else {
                composerK.a0(-664469810);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.o0(announcementCardState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(Context context) {
        AnswersHelper.f128199a.a0();
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.IntroTrial(false, 1, null), "blocking_tab", "trial_bar", false, true, false, null, 144, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Context context, Function1 function1, QuestionnaireConfig questionnaireConfig) {
        if (questionnaireConfig != null) {
            AnswersHelper.f128199a.m4(questionnaireConfig.b());
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(questionnaireConfig.e())));
        } else {
            context.startActivity(ChangelogActivity.f106918t.a(context));
            AnswersHelper.f128199a.g1();
        }
        function1.invoke(new BlockingScreenViewEvent.OnAnnouncementCardRemoved(questionnaireConfig));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(DiscountState discountState, Context context) {
        if (discountState.c() != -1) {
            context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.Campaign(discountState.c(), discountState.d(), "unknown"), "blocking_tab", "discount_badge", false, false, false, null, 240, null));
        } else {
            context.startActivity(Paywall.c(Paywall.f113165a, context, PaywallTarget.Generic.INSTANCE, "blocking_tab", "discount_badge", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(QuestionnaireConfig questionnaireConfig, Function1 function1) {
        if (questionnaireConfig != null) {
            AnswersHelper.f128199a.n4(questionnaireConfig.b());
        } else {
            AnswersHelper.f128199a.h1();
        }
        function1.invoke(new BlockingScreenViewEvent.OnAnnouncementCardRemoved(questionnaireConfig));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(ScaffoldState scaffoldState, BlockingScreenViewState blockingScreenViewState, AppIconCache appIconCache, Function1 function1, MutableState mutableState, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1002113241, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.RootCompose.<anonymous>.<anonymous> (BlockingScreen.kt:411)");
            }
            y0(paddingValues, scaffoldState, blockingScreenViewState, appIconCache, function1, mutableState, composer, (i4 & 14) | 196608);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(AnnouncementCardState announcementCardState, Function1 function1, int i3, Composer composer, int i4) {
        l0(announcementCardState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(Function1 function1) {
        AnswersHelper.f128199a.T0();
        function1.invoke(new DashboardViewEvent.OnNavPageRequested(DashboardActivity.NavBarItem.StrictMode.f99179i));
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void p0(final ManagedActivityResultLauncher pauseProfileLauncher, final Function1 dashboardOnEvent, final Function1 onNavigateByRoute, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(pauseProfileLauncher, "pauseProfileLauncher");
        Intrinsics.checkNotNullParameter(dashboardOnEvent, "dashboardOnEvent");
        Intrinsics.checkNotNullParameter(onNavigateByRoute, "onNavigateByRoute");
        Composer composerK = composer.k(1638515388);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(pauseProfileLauncher) : composerK.I(pauseProfileLauncher) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(dashboardOnEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onNavigateByRoute) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1638515388, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.BlockingScreen (BlockingScreen.kt:197)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.q0(context);
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
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(BlockingScreenViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            final BlockingScreenViewModel blockingScreenViewModel = (BlockingScreenViewModel) viewModelA;
            BlockingScreenViewState blockingScreenViewState = (BlockingScreenViewState) FlowExtKt.m(blockingScreenViewModel, composerK, 0);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            final CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG2, CoroutinesHelperExtKt.b());
            final Function1 function1N = FlowExtKt.n(blockingScreenViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            g1(scaffoldStateG, blockingScreenViewState, blockingScreenViewModel.T1(), dashboardOnEvent, function1N, onNavigateByRoute, composerK, ((i4 << 6) & 7168) | ((i4 << 9) & 458752));
            v0(coroutineScopeI, scaffoldStateG, blockingScreenViewModel, function1N, pauseProfileLauncher, composerK, (ManagedActivityResultLauncher.f461c << 12) | ((i4 << 12) & 57344));
            boolean zI2 = composerK.I(coroutineScopeI) | composerK.I(blockingScreenViewModel) | composerK.I(context) | composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == companion.a()) {
                objG3 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BlockingScreenKt.r0(coroutineScopeI, context, function1N, blockingScreenViewModel, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG3);
            }
            ComposableExtKt.j(null, (Function2) objG3, composerK, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.s0(pauseProfileLauncher, dashboardOnEvent, onNavigateByRoute, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnStreakBannerClicked.f99553a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder q0(Context context) {
        Intent intent;
        Activity activityB = ContextExtKt.b(context);
        boolean z2 = false;
        if (activityB != null && (intent = activityB.getIntent()) != null && intent.getBooleanExtra("SHOW_STRICT_MODE_SNACK", false)) {
            z2 = true;
        }
        return ParametersHolderKt.b(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnStreakBannerDismissed.f99554a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(CoroutineScope coroutineScope, Context context, Function1 function1, BlockingScreenViewModel blockingScreenViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.f99124a[event.ordinal()];
        if (i3 == 1) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BlockingScreenKt$BlockingScreen$1$1$1(blockingScreenViewModel, null), 3, null);
        } else if (i3 == 2) {
            Activity activityB = ContextExtKt.b(context);
            Intrinsics.checkNotNull(activityB, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity = (FragmentActivity) activityB;
            int intExtra = fragmentActivity.getIntent().getIntExtra("PROFILE_TYPE_COMBINATIONS", 0);
            if (intExtra != 0) {
                fragmentActivity.getIntent().removeExtra("PROFILE_TYPE_COMBINATIONS");
                function1.invoke(new BlockingScreenViewEvent.OnNewProfileCreated(intExtra, false, 2, null));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(final Function1 function1, final CoroutineScope coroutineScope, final MutableState mutableState, ColumnScope AppBottomSheet, final SheetState sheetState, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        if ((i3 & 48) == 0) {
            i4 = (composer.Z(sheetState) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 145) != 144, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1251505691, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.RootCompose.<anonymous> (BlockingScreen.kt:534)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenKt.s1(function1, ((Long) obj).longValue());
                    }
                };
                composer.w(objG);
            }
            Function1 function12 = (Function1) objG;
            boolean zI = composer.I(coroutineScope) | ((i4 & 112) == 32);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.t1(coroutineScope, sheetState, mutableState);
                    }
                };
                composer.w(objG2);
            }
            QuickBlockTimePickerBottomSheetKt.d(function12, 0L, (Function0) objG2, composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(ManagedActivityResultLauncher managedActivityResultLauncher, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        p0(managedActivityResultLauncher, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(Function1 function1, long j3) {
        function1.invoke(new BlockingScreenViewEvent.OnQuickBlockCustomTimeSet(j3));
        return Unit.f139807a;
    }

    private static final void t0(final BoxScope boxScope, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(725558254);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(725558254, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.BottomBarChevron (BlockingScreen.kt:1019)");
            }
            IconKt.a(PainterResources_androidKt.c(R.drawable.f95580y1, composerK, 0), null, boxScope.f(PaddingKt.k(Modifier.b8, Dp.g(8), 0.0f, 2, null), Alignment.f25072a.f()), ComposeColorsKt.j(composerK, 0).s(), composerK, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.u0(boxScope, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(CoroutineScope coroutineScope, SheetState sheetState, MutableState mutableState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BlockingScreenKt$RootCompose$2$2$1$1(sheetState, mutableState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(BoxScope boxScope, int i3, Composer composer, int i4) {
        t0(boxScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    private static final void v0(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final BlockingScreenViewModel blockingScreenViewModel, final Function1 function1, final ManagedActivityResultLauncher managedActivityResultLauncher, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-18283791);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(blockingScreenViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= (i3 & 32768) == 0 ? composerK.Z(managedActivityResultLauncher) : composerK.I(managedActivityResultLauncher) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        boolean z2 = false;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-18283791, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.CommandProcessor (BlockingScreen.kt:251)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z3 = (i5 & 7168) == 2048;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenKt.w0(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            Object objQ = composerK.q(AndroidCompositionLocals_androidKt.g());
            AppCompatActivity appCompatActivity = objQ instanceof AppCompatActivity ? (AppCompatActivity) objQ : null;
            boolean zI = ((i5 & 112) == 32) | composerK.I(context) | composerK.I(managedActivityResultLauncherA) | composerK.I(coroutineScope) | composerK.I(appCompatActivity);
            if ((57344 & i5) == 16384 || ((i5 & 32768) != 0 && composerK.I(managedActivityResultLauncher))) {
                z2 = true;
            }
            boolean z4 = zI | z2;
            Object objG2 = composerK.G();
            if (z4 || objG2 == Composer.f23746a.a()) {
                BlockingScreenKt$CommandProcessor$1$1 blockingScreenKt$CommandProcessor$1$1 = new BlockingScreenKt$CommandProcessor$1$1(context, managedActivityResultLauncherA, coroutineScope, appCompatActivity, managedActivityResultLauncher, scaffoldState, null);
                composerK.w(blockingScreenKt$CommandProcessor$1$1);
                objG2 = blockingScreenKt$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(blockingScreenViewModel, null, (Function2) objG2, composer2, (i5 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.x0(coroutineScope, scaffoldState, blockingScreenViewModel, function1, managedActivityResultLauncher, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(ScaffoldState scaffoldState, BlockingScreenViewState blockingScreenViewState, AppIconCache appIconCache, Function1 function1, Function1 function12, Function1 function13, int i3, Composer composer, int i4) {
        g1(scaffoldState, blockingScreenViewState, appIconCache, function1, function12, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            Integer numValueOf = intentC != null ? Integer.valueOf(intentC.getIntExtra("PROFILE_TYPE_COMBINATIONS", -1)) : null;
            Intent intentC2 = it.c();
            boolean booleanExtra = intentC2 != null ? intentC2.getBooleanExtra("ADD_TO_FOLLOW_SCHEDULES", false) : false;
            if (numValueOf != null && numValueOf.intValue() != -1) {
                function1.invoke(new BlockingScreenViewEvent.OnNewProfileCreated(numValueOf.intValue(), booleanExtra));
            }
        }
        return Unit.f139807a;
    }

    private static final void w1(final BlockingScreenViewState blockingScreenViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-22408659);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(blockingScreenViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-22408659, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.Toolbar (BlockingScreen.kt:559)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Color.Companion companion = Color.f25715b;
            AppBarKt.d(PaddingKt.k(BackgroundKt.d(SizeKt.h(Modifier.b8, 0.0f, 1, null), companion.j(), null, 2, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), companion.j(), 0L, Dp.g(0), null, ComposableLambdaKt.e(-2139914916, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.x1(blockingScreenViewState, context, function1, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 199728, 20);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.B1(blockingScreenViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(CoroutineScope coroutineScope, ScaffoldState scaffoldState, BlockingScreenViewModel blockingScreenViewModel, Function1 function1, ManagedActivityResultLauncher managedActivityResultLauncher, int i3, Composer composer, int i4) {
        v0(coroutineScope, scaffoldState, blockingScreenViewModel, function1, managedActivityResultLauncher, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(final BlockingScreenViewState blockingScreenViewState, final Context context, final Function1 function1, RowScope TopAppBar, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Composer composer3;
        ComposableLambda composableLambda;
        Integer num;
        int i5;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(TopAppBar) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2139914916, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.Toolbar.<anonymous> (BlockingScreen.kt:570)");
            }
            boolean z2 = blockingScreenViewState.j() && PermissionHelper.k(context);
            boolean z3 = z2 && blockingScreenViewState.B();
            if (z3) {
                composer2 = composer;
                composer2.a0(-33984826);
            } else {
                composer.a0(-5237069);
                composer2 = composer;
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95513g, composer, 6), StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.i(Modifier.b8, Dp.g(32)), ComposeColorsKt.j(composer, 0).p(), composer2, 384, 0);
            }
            composer2.U();
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1107737876, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.y1(blockingScreenViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54);
            if (z3) {
                composer2.a0(-4356545);
                composableLambdaE.invoke(composer2, 6);
            } else {
                composer2.a0(-33984826);
            }
            composer2.U();
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(RowScope.c(TopAppBar, companion, 1.0f, false, 2, null), composer2, 0);
            if (blockingScreenViewState.d() != null) {
                composer2.a0(-4191749);
                Context context2 = (Context) composer2.q(AndroidCompositionLocals_androidKt.g());
                Object objG = composer2.G();
                if (objG == Composer.f23746a.a()) {
                    objG = DateHelperExtKt.i(context2, false, true);
                    composer2.w(objG);
                }
                String str = ((DateFormat) objG).format(blockingScreenViewState.d());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                num = 6;
                composableLambda = composableLambdaE;
                i5 = -33984826;
                TextKt.c(str, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 48, 0, 65532);
                composer3 = composer;
            } else {
                composer3 = composer2;
                composableLambda = composableLambdaE;
                num = 6;
                i5 = -33984826;
                composer3.a0(-33984826);
            }
            composer3.U();
            if (!z2 || z3) {
                composer3.a0(i5);
            } else {
                composer3.a0(-3728609);
                composableLambda.invoke(composer3, num);
            }
            composer3.U();
            if (blockingScreenViewState.B()) {
                composer3.a0(-3640569);
                int iX = blockingScreenViewState.x();
                boolean zI = composer3.I(context);
                Object objG2 = composer3.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingScreenKt.A1(context);
                        }
                    };
                    composer3.w(objG2);
                }
                StreakToolbarButtonKt.c(iX, (Function0) objG2, null, composer3, 0, 4);
            } else {
                composer3.a0(i5);
            }
            composer3.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void y0(final PaddingValues paddingValues, final ScaffoldState scaffoldState, final BlockingScreenViewState blockingScreenViewState, final AppIconCache appIconCache, final Function1 function1, final MutableState mutableState, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        BlockingScreenViewState blockingScreenViewState2;
        Composer composerK = composer.k(-1810627126);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 32 : 16;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 384) == 0) {
            blockingScreenViewState2 = blockingScreenViewState;
            i4 |= composerK.Z(blockingScreenViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            blockingScreenViewState2 = blockingScreenViewState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(appIconCache) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(mutableState) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1810627126, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.Content (BlockingScreen.kt:644)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierL = ModifierExtKt.l(BackgroundKt.d(PaddingKt.h(companion, paddingValues), Color.f25715b.j(), null, 2, null), Dp.g(f3), Dp.g(0), composerK, 432, 0);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierL);
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
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, Dp.g(f3), 1, null);
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(companion, 0.0f, 1, null), WindowInsets_androidKt.d(WindowInsets.f7172a, composerK, 6));
            boolean zI = ((i4 & 896) == 256) | ((57344 & i4) == 16384) | composerK.I(context) | ((i4 & 112) == 32) | ((458752 & i4) == 131072) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                final ScaffoldState scaffoldState3 = scaffoldState2;
                final BlockingScreenViewState blockingScreenViewState3 = blockingScreenViewState2;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingScreenKt.z0(blockingScreenViewState3, function1, context, scaffoldState3, mutableState, appIconCache, (LazyListScope) obj);
                    }
                };
                composerK.w(function12);
                objG = function12;
            }
            LazyDslKt.b(modifierD, null, paddingValuesC, false, null, null, null, false, null, (Function1) objG, composerK, 384, 506);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.T0(paddingValues, scaffoldState, blockingScreenViewState, appIconCache, function1, mutableState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(BlockingScreenViewState blockingScreenViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1107737876, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.Toolbar.<anonymous>.<anonymous> (BlockingScreen.kt:589)");
            }
            DonutChartDataCollection donutChartDataCollectionY = blockingScreenViewState.y();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingScreenKt.z1(function1);
                    }
                };
                composer.w(objG);
            }
            W0(null, donutChartDataCollectionY, (Function0) objG, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final BlockingScreenViewState blockingScreenViewState, final Function1 function1, final Context context, ScaffoldState scaffoldState, final MutableState mutableState, final AppIconCache appIconCache, LazyListScope LazyColumn) {
        final ScaffoldState scaffoldState2;
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(1068399781, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.t
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BlockingScreenKt.A0(blockingScreenViewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (blockingScreenViewState.t()) {
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-454973824, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.B0(blockingScreenViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(44791388, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.x
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BlockingScreenKt.G0(blockingScreenViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        boolean z2 = false;
        final boolean z3 = (blockingScreenViewState.h() == null || !blockingScreenViewState.i().getShowsCard() || blockingScreenViewState.e()) ? false : true;
        if (blockingScreenViewState.f() && !blockingScreenViewState.g() && blockingScreenViewState.i().getShowsCard()) {
            z2 = true;
        }
        if (z3 || z2) {
            LazyListScope.c(LazyColumn, "autoTrial", null, ComposableLambdaKt.c(666604919, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.H0(blockingScreenViewState, z3, context, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        } else if (blockingScreenViewState.u() && blockingScreenViewState.h() == null) {
            LazyListScope.c(LazyColumn, "premiumExpiring", null, ComposableLambdaKt.c(-937798048, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.z
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.K0(blockingScreenViewState, context, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        final List listC = blockingScreenViewState.r().c();
        final boolean zIsEmpty = listC.isEmpty();
        if (blockingScreenViewState.A()) {
            scaffoldState2 = scaffoldState;
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-752719112, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.N0(scaffoldState2, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        } else {
            scaffoldState2 = scaffoldState;
        }
        if (!blockingScreenViewState.r().d()) {
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(2122924153, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.O0(zIsEmpty, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (blockingScreenViewState.r().d()) {
            lazyListScope = LazyColumn;
            LazyListScope.c(lazyListScope, null, null, ComposableSingletons$BlockingScreenKt.f99125a.j(), 3, null);
        } else if (zIsEmpty) {
            lazyListScope = LazyColumn;
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-825527930, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingScreenKt.Q0(function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        } else {
            lazyListScope = LazyColumn;
            final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingScreenKt.S0(((Integer) obj).intValue(), (ProfileViewDTO) obj2);
                }
            };
            lazyListScope.h(listC.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$Content$lambda$0$0$0$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return function2.invoke(Integer.valueOf(i3), listC.get(i3));
                }
            }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$Content$lambda$0$0$0$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    listC.get(i3);
                    return null;
                }
            }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$Content$lambda$0$0$0$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                    int i5;
                    if ((i4 & 6) == 0) {
                        i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                    } else {
                        i5 = i4;
                    }
                    if ((i4 & 48) == 0) {
                        i5 |= composer.e(i3) ? 32 : 16;
                    }
                    if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1091073711, i5, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    ProfileViewDTO profileViewDTO = (ProfileViewDTO) listC.get(i3);
                    composer.a0(-1571725771);
                    boolean z4 = i3 == listC.size() - 1;
                    Modifier modifierC = LazyItemScope.c(lazyItemScope, Modifier.b8, null, null, null, 7, null);
                    float fG = Dp.g(z4 ? 0 : 16);
                    int i6 = R.dimen.f95467a;
                    Modifier modifierM = PaddingKt.m(modifierC, PrimitiveResources_androidKt.a(i6, composer, 0), 0.0f, PrimitiveResources_androidKt.a(i6, composer, 0), fG, 2, null);
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
                    int iA = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU = composer.u();
                    Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
                    ScaffoldState scaffoldState3 = scaffoldState2;
                    AppIconCache appIconCache2 = appIconCache;
                    boolean z5 = blockingScreenViewState.z();
                    boolean Z = composer.Z(function1);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        final Function1 function12 = function1;
                        objG = new Function1<ProfileItemEvent, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt$Content$1$1$1$10$1$1$1
                            public final void c(ProfileItemEvent profileEvent) {
                                Intrinsics.checkNotNullParameter(profileEvent, "profileEvent");
                                function12.invoke(new BlockingScreenViewEvent.OnProfileItemEvent(profileEvent));
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                c((ProfileItemEvent) obj);
                                return Unit.f139807a;
                            }
                        };
                        composer.w(objG);
                    }
                    ProfileItemKt.I0(scaffoldState3, profileViewDTO, appIconCache2, null, z5, null, (Function1) objG, composer, 0, 40);
                    composer.y();
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
        }
        ComposableSingletons$BlockingScreenKt composableSingletons$BlockingScreenKt = ComposableSingletons$BlockingScreenKt.f99125a;
        LazyListScope.c(lazyListScope, null, null, composableSingletons$BlockingScreenKt.g(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(1501110622, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.e0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BlockingScreenKt.C0(blockingScreenViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(81786591, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BlockingScreenKt.D0(blockingScreenViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$BlockingScreenKt.f(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$BlockingScreenKt.h(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(Function1 function1) {
        AnswersHelper.f128199a.V0();
        function1.invoke(DashboardActivity.NavBarItem.Insights.f99176i);
        return Unit.f139807a;
    }
}
