package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
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
public final class PremiumExpiringActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f113543g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f113544h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f113545f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, String str, String str2, PremiumExpiringTrialType premiumExpiringTrialType, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                premiumExpiringTrialType = PremiumExpiringTrialType.Weekly;
            }
            return companion.a(context, str, str2, premiumExpiringTrialType);
        }

        public final Intent a(Context context, String entrances, String entrancesDetail, PremiumExpiringTrialType trialType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entrances, "entrances");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            Intrinsics.checkNotNullParameter(trialType, "trialType");
            Intent intent = new Intent(context, (Class<?>) PremiumExpiringActivity.class);
            intent.putExtra("EVENT_ENTRANCES", entrances);
            intent.putExtra("EVENT_ENTRANCES_DETAIL", entrancesDetail);
            intent.putExtra("auto_trial_type", trialType.name());
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PremiumExpiringScreen {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PremiumExpiringScreen[] $VALUES;
        public static final Companion Companion;
        private final String route;
        public static final PremiumExpiringScreen Intro = new PremiumExpiringScreen("Intro", 0, "intro");
        public static final PremiumExpiringScreen Summary = new PremiumExpiringScreen("Summary", 1, "summary");
        public static final PremiumExpiringScreen BlockSessions = new PremiumExpiringScreen("BlockSessions", 2, "block_sessions");
        public static final PremiumExpiringScreen Features = new PremiumExpiringScreen("Features", 3, "features");
        public static final PremiumExpiringScreen Blocking = new PremiumExpiringScreen("Blocking", 4, "blocking");
        public static final PremiumExpiringScreen Savings = new PremiumExpiringScreen("Savings", 5, "savings");
        public static final PremiumExpiringScreen Purchase = new PremiumExpiringScreen("Purchase", 6, "purchase");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PremiumExpiringScreen a(String str) {
                PremiumExpiringScreen next;
                Iterator<PremiumExpiringScreen> it = PremiumExpiringScreen.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getRoute(), str)) {
                        break;
                    }
                }
                PremiumExpiringScreen premiumExpiringScreen = next;
                return premiumExpiringScreen == null ? PremiumExpiringScreen.Intro : premiumExpiringScreen;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PremiumExpiringScreen[] $values() {
            return new PremiumExpiringScreen[]{Intro, Summary, BlockSessions, Features, Blocking, Savings, Purchase};
        }

        static {
            PremiumExpiringScreen[] premiumExpiringScreenArr$values = $values();
            $VALUES = premiumExpiringScreenArr$values;
            $ENTRIES = EnumEntriesKt.a(premiumExpiringScreenArr$values);
            Companion = new Companion(null);
        }

        private PremiumExpiringScreen(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<PremiumExpiringScreen> getEntries() {
            return $ENTRIES;
        }

        public static PremiumExpiringScreen valueOf(String str) {
            return (PremiumExpiringScreen) Enum.valueOf(PremiumExpiringScreen.class, str);
        }

        public static PremiumExpiringScreen[] values() {
            return (PremiumExpiringScreen[]) $VALUES.clone();
        }

        public final float getProgress() {
            return (ordinal() + 1.0f) / getEntries().size();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PremiumExpiringTrialType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PremiumExpiringTrialType[] $VALUES;
        public static final PremiumExpiringTrialType Weekly = new PremiumExpiringTrialType("Weekly", 0);
        public static final PremiumExpiringTrialType Monthly = new PremiumExpiringTrialType("Monthly", 1);

        private static final /* synthetic */ PremiumExpiringTrialType[] $values() {
            return new PremiumExpiringTrialType[]{Weekly, Monthly};
        }

        static {
            PremiumExpiringTrialType[] premiumExpiringTrialTypeArr$values = $values();
            $VALUES = premiumExpiringTrialTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(premiumExpiringTrialTypeArr$values);
        }

        private PremiumExpiringTrialType(String str, int i3) {
        }

        public static EnumEntries<PremiumExpiringTrialType> getEntries() {
            return $ENTRIES;
        }

        public static PremiumExpiringTrialType valueOf(String str) {
            return (PremiumExpiringTrialType) Enum.valueOf(PremiumExpiringTrialType.class, str);
        }

        public static PremiumExpiringTrialType[] values() {
            return (PremiumExpiringTrialType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113549a;

        static {
            int[] iArr = new int[PremiumExpiringViewState.ScreenType.values().length];
            try {
                iArr[PremiumExpiringViewState.ScreenType.SinglePage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumExpiringViewState.ScreenType.Flow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f113549a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder p0(PremiumExpiringActivity premiumExpiringActivity) {
        return ParametersHolderKt.b(premiumExpiringActivity.x0(), premiumExpiringActivity.y0(), premiumExpiringActivity.z0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(final PremiumExpiringViewState premiumExpiringViewState, PremiumScreenViewState premiumScreenViewState, Function1 function1, final PremiumExpiringActivity premiumExpiringActivity, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-403421617, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity.RootCompose.<anonymous> (PremiumExpiringActivity.kt:87)");
            }
            PremiumExpiringViewState.ScreenType screenTypeF = premiumExpiringViewState.f();
            int i4 = screenTypeF != null ? WhenMappings.f113549a[screenTypeF.ordinal()] : -1;
            if (i4 == 1) {
                composer.a0(-1014753284);
                boolean zI = composer.I(premiumExpiringActivity) | composer.Z(premiumExpiringViewState);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PremiumExpiringActivity.s0(this.f113708a, premiumExpiringViewState);
                        }
                    };
                    composer.w(objG);
                }
                PremiumExpiringScreenKt.a0(it, premiumExpiringViewState, premiumScreenViewState, function1, (Function0) objG, composer, i3 & 14);
                composer.U();
            } else if (i4 != 2) {
                composer.a0(-1013427631);
                composer.U();
            } else {
                composer.a0(-1014059132);
                boolean zI2 = composer.I(premiumExpiringActivity) | composer.Z(premiumExpiringViewState);
                Object objG2 = composer.G();
                if (zI2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.o0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PremiumExpiringActivity.t0(this.f113716a, premiumExpiringViewState);
                        }
                    };
                    composer.w(objG2);
                }
                PremiumExpiringScreenKt.Y(it, premiumExpiringViewState, premiumScreenViewState, function1, (Function0) objG2, composer, i3 & 14);
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
    public static final Unit s0(PremiumExpiringActivity premiumExpiringActivity, PremiumExpiringViewState premiumExpiringViewState) {
        AnswersHelper.f128199a.W3();
        premiumExpiringActivity.w0(premiumExpiringViewState.c() == null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(PremiumExpiringActivity premiumExpiringActivity, PremiumExpiringViewState premiumExpiringViewState) {
        AnswersHelper.f128199a.S3();
        premiumExpiringActivity.w0(premiumExpiringViewState.c() == null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(PremiumExpiringActivity premiumExpiringActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        premiumExpiringActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(boolean z2) {
        if (z2) {
            startActivity(Paywall.c(Paywall.f113165a, this, new PaywallTarget.ExpiredSubDiscount(true), "renewal_screen", "renewal_screen", false, false, false, null, 240, null));
            finish();
            return;
        }
        DashboardActivity.Companion companion = DashboardActivity.f99133o;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Intent intentC = DashboardActivity.Companion.c(companion, applicationContext, null, null, 6, null);
        intentC.setFlags(268468224);
        startActivity(intentC);
    }

    private final String x0() {
        return getIntent().getStringExtra("EVENT_ENTRANCES");
    }

    private final String y0() {
        return getIntent().getStringExtra("EVENT_ENTRANCES_DETAIL");
    }

    private final PremiumExpiringTrialType z0() {
        Object objB;
        String stringExtra = getIntent().getStringExtra("auto_trial_type");
        if (stringExtra != null) {
            try {
                Result.Companion companion = Result.f139772b;
                objB = Result.b(PremiumExpiringTrialType.valueOf(stringExtra));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            PremiumExpiringTrialType premiumExpiringTrialType = (PremiumExpiringTrialType) objB;
            if (premiumExpiringTrialType != null) {
                return premiumExpiringTrialType;
            }
        }
        return PremiumExpiringTrialType.Weekly;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Bundle bundleB2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-880065775);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-880065775, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity.RootCompose (PremiumExpiringActivity.kt:58)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            composerK.F(-101221098);
            LocalViewModelStoreOwner localViewModelStoreOwner = LocalViewModelStoreOwner.f40240a;
            ViewModelStoreOwner viewModelStoreOwnerC = localViewModelStoreOwner.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            GlobalContext globalContext = GlobalContext.f145907a;
            Scope scopeD = globalContext.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB2 = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB2, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(PremiumExpiringViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            final PremiumExpiringViewState premiumExpiringViewState = (PremiumExpiringViewState) FlowExtKt.m((PremiumExpiringViewModel) viewModelA, composerK, 0);
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumExpiringActivity.p0(this.f113677a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC2 = localViewModelStoreOwner.c(composerK, 8);
            if (viewModelStoreOwnerC2 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA3 = ViewModelComposeExtKt.a(viewModelStoreOwnerC2, composerK, 8);
            Scope scopeD2 = globalContext.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry2 = viewModelStoreOwnerC2 instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC2 : null;
            CreationExtras creationExtrasA4 = (navBackStackEntry2 == null || (bundleB = navBackStackEntry2.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC2);
            KClass kClassB2 = Reflection.b(PremiumExpiringPurchaseViewModel.class);
            ViewModelStore viewModelStore2 = viewModelStoreOwnerC2.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA2 = GetViewModelKt.a(kClassB2, viewModelStore2, null, creationExtrasA4 == null ? creationExtrasA3 : creationExtrasA4, null, scopeD2, function0);
            composerK.Y();
            composerK.Y();
            PremiumExpiringPurchaseViewModel premiumExpiringPurchaseViewModel = (PremiumExpiringPurchaseViewModel) viewModelA2;
            final PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) FlowExtKt.m(premiumExpiringPurchaseViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(premiumExpiringPurchaseViewModel, composerK, 0);
            PurchaseSuccessDTO purchaseSuccessDTOY = premiumScreenViewState.y();
            boolean Z = composerK.Z(premiumScreenViewState) | composerK.I(this);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new PremiumExpiringActivity$RootCompose$1$1(premiumScreenViewState, this, null);
                composerK.w(objG2);
            }
            EffectsKt.g(purchaseSuccessDTOY, (Function2) objG2, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), scaffoldStateG, null, null, ComposableSingletons$PremiumExpiringActivityKt.f113524a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-403421617, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.l0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumExpiringActivity.q0(premiumExpiringViewState, premiumScreenViewState, function1N, this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 24576, 12582912, 131052);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringActivity.u0(this.f113697a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f113545f;
    }
}
