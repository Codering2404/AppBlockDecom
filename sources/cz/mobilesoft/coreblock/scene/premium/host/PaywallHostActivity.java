package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.SheetState;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.components.HostedPaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt;
import cz.mobilesoft.coreblock.scene.premium.components.RcTrialOtherOptionsBottomSheetKt;
import cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContentKt;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallScreenKt;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallLayout;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity;
import cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity;
import cz.mobilesoft.coreblock.service.passlock.PassLockExempt;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceOverlayKt;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceStore;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import d.qFm.sECyKyO;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
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
public class PaywallHostActivity extends BaseComposeActivity implements PassLockExempt {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Companion f113184w = new Companion(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f113185x = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f113186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f113187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f113188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f113189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableStateFlow f113190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ActivityResultLauncher f113191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f113192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f113193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f113194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f113195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f113196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f113197q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f113198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f113199s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f113200t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ActivityResultLauncher f113201u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ActivityResultLauncher f113202v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class GateState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GateState[] $VALUES;
        public static final GateState Running = new GateState("Running", 0);
        public static final GateState AwaitingSuperwall = new GateState("AwaitingSuperwall", 1);
        public static final GateState ShowOwnPaywall = new GateState("ShowOwnPaywall", 2);
        public static final GateState Closing = new GateState("Closing", 3);

        private static final /* synthetic */ GateState[] $values() {
            return new GateState[]{Running, AwaitingSuperwall, ShowOwnPaywall, Closing};
        }

        static {
            GateState[] gateStateArr$values = $values();
            $VALUES = gateStateArr$values;
            $ENTRIES = EnumEntriesKt.a(gateStateArr$values);
        }

        private GateState(String str, int i3) {
        }

        public static EnumEntries<GateState> getEntries() {
            return $ENTRIES;
        }

        public static GateState valueOf(String str) {
            return (GateState) Enum.valueOf(GateState.class, str);
        }

        public static GateState[] values() {
            return (GateState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f113238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f113239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f113240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f113241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f113242f;

        static {
            int[] iArr = new int[PaywallOnOpen.values().length];
            try {
                iArr[PaywallOnOpen.Nothing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallOnOpen.CancelScheduledDiscountNotification.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallOnOpen.ClearExpiredSubOfferMarker.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallOnOpen.ClearCampaignRequest.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f113237a = iArr;
            int[] iArr2 = new int[OfferUsedMarker.values().length];
            try {
                iArr2[OfferUsedMarker.Nothing.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OfferUsedMarker.TrialRetentionOffer.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OfferUsedMarker.AutoTrialExpiredScreen.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f113238b = iArr2;
            int[] iArr3 = new int[CloseBehaviour.values().length];
            try {
                iArr3[CloseBehaviour.Finish.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[CloseBehaviour.OfferDiscount.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[CloseBehaviour.OfferDiscountUnlessFirstStart.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[CloseBehaviour.DashboardOnTopUnlessFirstStart.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[CloseBehaviour.DashboardWhenOpeningDashboard.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            f113239c = iArr3;
            int[] iArr4 = new int[PaywallViewModelKind.values().length];
            try {
                iArr4[PaywallViewModelKind.Plain.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[PaywallViewModelKind.Campaign.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[PaywallViewModelKind.MySubscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[PaywallViewModelKind.Discount.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            f113240d = iArr4;
            int[] iArr5 = new int[GateState.values().length];
            try {
                iArr5[GateState.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr5[GateState.AwaitingSuperwall.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr5[GateState.Closing.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr5[GateState.ShowOwnPaywall.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            f113241e = iArr5;
            int[] iArr6 = new int[OtherOptionsSheet.values().length];
            try {
                iArr6[OtherOptionsSheet.RcTrial.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr6[OtherOptionsSheet.Standard.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            f113242f = iArr6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallHostActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f113186f = LazyKt.a(lazyThreadSafetyMode, new Function0<PaywallDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PaywallDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f113187g = LazyKt.a(lazyThreadSafetyMode, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f113188h = LazyKt.a(lazyThreadSafetyMode, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DiscountDataStore.class), objArr4, objArr5);
            }
        });
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f113189i = LazyKt.a(lazyThreadSafetyMode, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DevDataStore.class), objArr6, objArr7);
            }
        });
        this.f113190j = StateFlowKt.a(GateState.Running);
        this.f113191k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.host.k
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaywallHostActivity.k2(this.f113414a, (ActivityResult) obj);
            }
        });
        this.f113192l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallHostActivity.l2(this.f113473a);
            }
        });
        this.f113193m = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallHostActivity.C1(this.f113397a);
            }
        });
        this.f113194n = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallHostActivity.i2(this.f113415a);
            }
        });
        this.f113195o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallHostActivity.X1(this.f113416a);
            }
        });
        this.f113196p = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PaywallHostActivity.W1(this.f113422a));
            }
        });
        this.f113197q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallHostActivity.E1(this.f113428a);
            }
        });
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        this.f113201u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.host.o0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaywallHostActivity.U1(this.f113432a, (ActivityResult) obj);
            }
        });
        this.f113202v = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.host.p0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaywallHostActivity.j2(this.f113436a, (ActivityResult) obj);
            }
        });
    }

    private final void A1() {
        if (this.f113190j.getValue() != GateState.Running) {
            return;
        }
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), null, null, new PaywallHostActivity$askSuperwallGate$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C1(PaywallHostActivity paywallHostActivity) {
        return paywallHostActivity.getIntent().getStringExtra("discount_message");
    }

    private final void D1() {
        if (L1()) {
            Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, this, J1(), null, 4, null);
            intentC.setFlags(268468224);
            startActivity(intentC);
        } else {
            if (V1()) {
                setResult(-1);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer E1(PaywallHostActivity paywallHostActivity) {
        Integer numValueOf = Integer.valueOf(paywallHostActivity.getIntent().getIntExtra("PROFILE_TYPE_COMBINATIONS", 0));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore F1() {
        return (CoreDataStore) this.f113187g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore G1() {
        return (DevDataStore) this.f113189i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore H1() {
        return (DiscountDataStore) this.f113188h.getValue();
    }

    private final String I1() {
        return (String) this.f113193m.getValue();
    }

    private final Integer J1() {
        return (Integer) this.f113197q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallHostViewModel.Launch K1() {
        return (PaywallHostViewModel.Launch) this.f113195o.getValue();
    }

    private final boolean L1() {
        if (N1().l()) {
            return true;
        }
        return N1().d() == CloseBehaviour.DashboardWhenOpeningDashboard && isTaskRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallDataStore M1() {
        return (PaywallDataStore) this.f113186f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallSpec N1() {
        return (PaywallSpec) this.f113194n.getValue();
    }

    private final PaywallTarget O1() {
        return (PaywallTarget) this.f113192l.getValue();
    }

    private final PaywallHostViewModel P1(Composer composer, int i3) {
        PaywallHostViewModel paywallHostViewModel;
        Bundle bundleB;
        Bundle bundleB2;
        Bundle bundleB3;
        Bundle bundleB4;
        if (ComposerKt.M()) {
            ComposerKt.U(1135353696, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.getViewModel (PaywallHostActivity.kt:397)");
        }
        int i4 = WhenMappings.f113240d[N1().s().ordinal()];
        CreationExtras creationExtrasA = null;
        if (i4 == 1) {
            composer.a0(153212126);
            boolean zI = composer.I(this);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.Q1(this.f113475a);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composer.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA2 = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composer, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(PlainPaywallViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA == null ? creationExtrasA2 : creationExtrasA, null, scopeD, function0);
            composer.Y();
            composer.Y();
            paywallHostViewModel = (PlainPaywallViewModel) viewModelA;
            composer.U();
        } else if (i4 == 2) {
            composer.a0(153216481);
            boolean zI2 = composer.I(this);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.R1(this.f113476a);
                    }
                };
                composer.w(objG2);
            }
            Function0 function02 = (Function0) objG2;
            composer.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC2 = LocalViewModelStoreOwner.f40240a.c(composer, 8);
            if (viewModelStoreOwnerC2 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA3 = ViewModelComposeExtKt.a(viewModelStoreOwnerC2, composer, 8);
            Scope scopeD2 = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            NavBackStackEntry navBackStackEntry2 = viewModelStoreOwnerC2 instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC2 : null;
            if (navBackStackEntry2 != null && (bundleB2 = navBackStackEntry2.b()) != null) {
                creationExtrasA = BundleExtKt.a(bundleB2, viewModelStoreOwnerC2);
            }
            KClass kClassB2 = Reflection.b(CampaignPaywallViewModel.class);
            ViewModelStore viewModelStore2 = viewModelStoreOwnerC2.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA2 = GetViewModelKt.a(kClassB2, viewModelStore2, null, creationExtrasA == null ? creationExtrasA3 : creationExtrasA, null, scopeD2, function02);
            composer.Y();
            composer.Y();
            paywallHostViewModel = (CampaignPaywallViewModel) viewModelA2;
            composer.U();
        } else if (i4 == 3) {
            composer.a0(153221127);
            boolean zI3 = composer.I(this);
            Object objG3 = composer.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.S1(this.f113478a);
                    }
                };
                composer.w(objG3);
            }
            Function0 function03 = (Function0) objG3;
            composer.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC3 = LocalViewModelStoreOwner.f40240a.c(composer, 8);
            if (viewModelStoreOwnerC3 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA4 = ViewModelComposeExtKt.a(viewModelStoreOwnerC3, composer, 8);
            Scope scopeD3 = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            NavBackStackEntry navBackStackEntry3 = viewModelStoreOwnerC3 instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC3 : null;
            if (navBackStackEntry3 != null && (bundleB3 = navBackStackEntry3.b()) != null) {
                creationExtrasA = BundleExtKt.a(bundleB3, viewModelStoreOwnerC3);
            }
            KClass kClassB3 = Reflection.b(MySubscriptionPaywallViewModel.class);
            ViewModelStore viewModelStore3 = viewModelStoreOwnerC3.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore3, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA3 = GetViewModelKt.a(kClassB3, viewModelStore3, null, creationExtrasA == null ? creationExtrasA4 : creationExtrasA, null, scopeD3, function03);
            composer.Y();
            composer.Y();
            paywallHostViewModel = (MySubscriptionPaywallViewModel) viewModelA3;
            composer.U();
        } else {
            if (i4 != 4) {
                composer.a0(153210639);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(153225761);
            boolean zI4 = composer.I(this);
            Object objG4 = composer.G();
            if (zI4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.T1(this.f113480a);
                    }
                };
                composer.w(objG4);
            }
            Function0 function04 = (Function0) objG4;
            composer.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC4 = LocalViewModelStoreOwner.f40240a.c(composer, 8);
            if (viewModelStoreOwnerC4 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA5 = ViewModelComposeExtKt.a(viewModelStoreOwnerC4, composer, 8);
            Scope scopeD4 = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            NavBackStackEntry navBackStackEntry4 = viewModelStoreOwnerC4 instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC4 : null;
            if (navBackStackEntry4 != null && (bundleB4 = navBackStackEntry4.b()) != null) {
                creationExtrasA = BundleExtKt.a(bundleB4, viewModelStoreOwnerC4);
            }
            KClass kClassB4 = Reflection.b(DiscountPaywallViewModel.class);
            ViewModelStore viewModelStore4 = viewModelStoreOwnerC4.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore4, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA4 = GetViewModelKt.a(kClassB4, viewModelStore4, null, creationExtrasA == null ? creationExtrasA5 : creationExtrasA, null, scopeD4, function04);
            composer.Y();
            composer.Y();
            paywallHostViewModel = (DiscountPaywallViewModel) viewModelA4;
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return paywallHostViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder Q1(PaywallHostActivity paywallHostActivity) {
        return ParametersHolderKt.b(paywallHostActivity.O1(), paywallHostActivity.N1(), paywallHostActivity.K1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder R1(PaywallHostActivity paywallHostActivity) {
        return ParametersHolderKt.b(paywallHostActivity.O1(), paywallHostActivity.N1(), paywallHostActivity.K1());
    }

    private final void S0(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final PremiumScreenViewModel premiumScreenViewModel, final ModalBottomSheetState modalBottomSheetState, final MutableState mutableState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-660970044);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(premiumScreenViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(mutableState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-660970044, i5, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.CommandProcessor (PaywallHostActivity.kt:990)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(coroutineScope) | ((i5 & 7168) == 2048 || ((i5 & 4096) != 0 && composerK.I(modalBottomSheetState))) | ((i5 & 112) == 32) | composerK.I(context) | ((57344 & i5) == 16384);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                PaywallHostActivity$CommandProcessor$1$1 paywallHostActivity$CommandProcessor$1$1 = new PaywallHostActivity$CommandProcessor$1$1(coroutineScope, modalBottomSheetState, scaffoldState, context, mutableState, null);
                composerK.w(paywallHostActivity$CommandProcessor$1$1);
                objG = paywallHostActivity$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(premiumScreenViewModel, null, (Function2) objG, composer2, (i5 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallHostActivity.T0(this.f113356a, coroutineScope, scaffoldState, premiumScreenViewModel, modalBottomSheetState, mutableState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder S1(PaywallHostActivity paywallHostActivity) {
        return ParametersHolderKt.b(paywallHostActivity.O1(), paywallHostActivity.N1(), paywallHostActivity.K1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(PaywallHostActivity paywallHostActivity, CoroutineScope coroutineScope, ScaffoldState scaffoldState, PremiumScreenViewModel premiumScreenViewModel, ModalBottomSheetState modalBottomSheetState, MutableState mutableState, int i3, Composer composer, int i4) {
        paywallHostActivity.S0(coroutineScope, scaffoldState, premiumScreenViewModel, modalBottomSheetState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder T1(PaywallHostActivity paywallHostActivity) {
        return ParametersHolderKt.b(paywallHostActivity.O1(), paywallHostActivity.N1(), paywallHostActivity.K1());
    }

    private final void U0(final ScaffoldState scaffoldState, final PaywallHostViewModel paywallHostViewModel, final PremiumScreenViewState premiumScreenViewState, final ModalBottomSheetState modalBottomSheetState, final Function1 function1, Composer composer, final int i3) {
        ScaffoldState scaffoldState2;
        int i4;
        PremiumScreenViewState premiumScreenViewState2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        String strE;
        Composer composerK = composer.k(778725066);
        if ((i3 & 6) == 0) {
            scaffoldState2 = scaffoldState;
            i4 = (composerK.Z(scaffoldState2) ? 4 : 2) | i3;
        } else {
            scaffoldState2 = scaffoldState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(paywallHostViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            premiumScreenViewState2 = premiumScreenViewState;
            i4 |= composerK.Z(premiumScreenViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            premiumScreenViewState2 = premiumScreenViewState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(778725066, i5, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent (PaywallHostActivity.kt:1030)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            if (!premiumScreenViewState2.E() && premiumScreenViewState2.S() && premiumScreenViewState2.s() != null) {
                composerK.a0(1880535831);
                boolean zM = premiumScreenViewState2.m();
                boolean zU = premiumScreenViewState2.U();
                Offering offeringS = premiumScreenViewState2.s();
                PremiumOptionDTO premiumOptionDTOH = premiumScreenViewState2.h();
                String strC = premiumOptionDTOH != null ? premiumOptionDTOH.c() : null;
                PremiumOptionDTO premiumOptionDTOH2 = premiumScreenViewState2.h();
                if (premiumOptionDTOH2 == null || (strE = premiumOptionDTOH2.e(context)) == null) {
                    strE = "";
                }
                String strA = premiumScreenViewState2.A();
                String strZ = premiumScreenViewState2.z();
                boolean zI = composerK.I(this);
                String str = strE;
                Object objG2 = composerK.G();
                if (zI || objG2 == companion.a()) {
                    objG2 = new PaywallHostActivity$PremiumScreenBaseContent$1$1(this);
                    composerK.w(objG2);
                }
                HostedPaywallContentKt.d(zM, zU, offeringS, strC, str, strA, strZ, paywallHostViewModel, (Function0) ((KFunction) objG2), composerK, (i5 << 18) & 29360128, 0);
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    final ScaffoldState scaffoldState3 = scaffoldState2;
                    final PremiumScreenViewState premiumScreenViewState3 = premiumScreenViewState2;
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.s
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PaywallHostActivity.V0(this.f113451a, scaffoldState3, paywallHostViewModel, premiumScreenViewState3, modalBottomSheetState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composerK.a0(1829874360);
            composerK.U();
            composer2 = composerK;
            ScaffoldKt.a(null, scaffoldState, null, null, ComposableSingletons$PaywallHostActivityKt.f113134a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1692751284, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.host.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PaywallHostActivity.W0(modalBottomSheetState, coroutineScope, this, premiumScreenViewState, function1, context, paywallHostViewModel, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 << 3) & 112) | 24576, 12582912, 131053);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallHostActivity.c1(this.f113466a, scaffoldState, paywallHostViewModel, premiumScreenViewState, modalBottomSheetState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(PaywallHostActivity paywallHostActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        paywallHostActivity.D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(PaywallHostActivity paywallHostActivity, ScaffoldState scaffoldState, PaywallHostViewModel paywallHostViewModel, PremiumScreenViewState premiumScreenViewState, ModalBottomSheetState modalBottomSheetState, Function1 function1, int i3, Composer composer, int i4) {
        paywallHostActivity.U0(scaffoldState, paywallHostViewModel, premiumScreenViewState, modalBottomSheetState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final boolean V1() {
        return ((Boolean) this.f113196p.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, final PaywallHostActivity paywallHostActivity, final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Context context, final PaywallHostViewModel paywallHostViewModel, final PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1692751284, i4, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent.<anonymous> (PaywallHostActivity.kt:1059)");
            }
            final Shimmer shimmerA = ShimmerThemeKt.a(null, composer, 0, 1);
            int i5 = R.dimen.f95480n;
            ComposeDialogsKt.n1(ComposableLambdaKt.e(555607108, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.host.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PaywallHostActivity.X0(modalBottomSheetState, coroutineScope, paywallHostActivity, premiumScreenViewState, function1, context, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), null, modalBottomSheetState, RoundedCornerShapeKt.f(PrimitiveResources_androidKt.a(i5, composer, 0), PrimitiveResources_androidKt.a(i5, composer, 0), 0.0f, 0.0f, 12, null), 0.0f, 0L, 0L, 0L, ComposableLambdaKt.e(-1794475332, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallHostActivity.a1(premiumScreenViewState, paywallHostActivity, paywallHostViewModel, paddingValues, function1, shimmerA, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (ModalBottomSheetState.f13222e << 6) | 100663302, 242);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W1(PaywallHostActivity paywallHostActivity) {
        return paywallHostActivity.getIntent().getBooleanExtra("IS_FIRST_START", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, final PaywallHostActivity paywallHostActivity, final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Context context, ColumnScope ThemedBottomSheetLayout, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ThemedBottomSheetLayout, "$this$ThemedBottomSheetLayout");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(555607108, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent.<anonymous>.<anonymous> (PaywallHostActivity.kt:1065)");
            }
            if (modalBottomSheetState.e() != ModalBottomSheetValue.Hidden) {
                composer.a0(-712430103);
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(1032793408, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.host.d0
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return PaywallHostActivity.Y0(this.f113382a, premiumScreenViewState, function1, context, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                boolean zI = composer.I(coroutineScope) | composer.I(modalBottomSheetState);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PaywallHostActivity.Z0(coroutineScope, modalBottomSheetState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composer, 3456, 19);
            } else {
                composer.a0(-764636738);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(PaywallHostActivity paywallHostActivity, PremiumScreenViewState premiumScreenViewState, Function1 function1, Context context, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1032793408, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent.<anonymous>.<anonymous>.<anonymous> (PaywallHostActivity.kt:1069)");
            }
            int i4 = WhenMappings.f113242f[paywallHostActivity.N1().m().ordinal()];
            if (i4 == 1) {
                composer.a0(377025175);
                RcTrialOtherOptionsBottomSheetKt.g(premiumScreenViewState, function1, composer, 0);
                composer.U();
            } else {
                if (i4 != 2) {
                    composer.a0(377022859);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(-1196768123);
                PremiumOffersLayoutKt.t(premiumScreenViewState.w(), premiumScreenViewState.D(), premiumScreenViewState.d(context), true ^ Intrinsics.areEqual(premiumScreenViewState.c(), Success.f128020a), premiumScreenViewState.M(), premiumScreenViewState.p(), premiumScreenViewState.N(), paywallHostActivity.V1(), function1, composer, 0);
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

    private final void Y1(boolean z2) {
        if (z2) {
            int i3 = WhenMappings.f113238b[N1().j().ordinal()];
            if (i3 == 1) {
                Unit unit = Unit.f139807a;
                return;
            }
            if (i3 == 2) {
                CoroutineScope applicationScope = LockieApplication.f95365k;
                Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
                BuildersKt__Builders_commonKt.d(applicationScope, null, null, new PaywallHostActivity$markOfferUsed$1(this, null), 3, null);
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                CoroutineScope applicationScope2 = LockieApplication.f95365k;
                Intrinsics.checkNotNullExpressionValue(applicationScope2, "applicationScope");
                BuildersKt__Builders_commonKt.d(applicationScope2, null, null, new PaywallHostActivity$markOfferUsed$2(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PaywallHostActivity$PremiumScreenBaseContent$3$1$2$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1() {
        int i3 = WhenMappings.f113239c[N1().d().ordinal()];
        if (i3 == 1) {
            finish();
            return;
        }
        if (i3 == 2) {
            B1();
            return;
        }
        if (i3 == 3) {
            if (V1()) {
                finish();
                return;
            } else {
                B1();
                return;
            }
        }
        if (i3 == 4) {
            if (V1()) {
                finish();
                return;
            } else {
                f2();
                return;
            }
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (L1()) {
            g2();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(final PremiumScreenViewState premiumScreenViewState, final PaywallHostActivity paywallHostActivity, final PaywallHostViewModel paywallHostViewModel, final PaddingValues paddingValues, final Function1 function1, final Shimmer shimmer, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1794475332, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent.<anonymous>.<anonymous> (PaywallHostActivity.kt:1097)");
            }
            Offering offeringS = premiumScreenViewState.s();
            if (premiumScreenViewState.E() || offeringS != null) {
                composer.a0(243502059);
                ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(596036710, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.host.f0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PaywallHostActivity.b1(this.f113391a, paywallHostViewModel, paddingValues, function1, premiumScreenViewState, shimmer, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 12582912, 127);
                composer.U();
            } else {
                composer.a0(244159941);
                Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
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
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ProgressIndicatorKt.b(null, 0L, 0.0f, 0L, 0, composer, 0, 31);
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
    public final void a2(boolean z2, boolean z3, boolean z4, boolean z5, int i3) {
        this.f113199s = z2;
        this.f113200t = z5;
        if (!z3 || z4) {
            D1();
        } else {
            this.f113202v.b(SubscriptionOnboardingActivity.f122709g.a(this, z2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(PaywallHostActivity paywallHostActivity, PaywallHostViewModel paywallHostViewModel, PaddingValues paddingValues, Function1 function1, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(596036710, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenBaseContent.<anonymous>.<anonymous>.<anonymous> (PaywallHostActivity.kt:1101)");
            }
            paywallHostActivity.b2(paywallHostViewModel, composer, 0);
            boolean zI = composer.I(paywallHostActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new PaywallHostActivity$PremiumScreenBaseContent$3$2$1$1$1(paywallHostActivity);
                composer.w(objG);
            }
            paywallHostActivity.d1(paddingValues, (Function0) ((KFunction) objG), function1, premiumScreenViewState, shimmer, composer, Shimmer.f93784d << 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private final void b2(final PaywallHostViewModel paywallHostViewModel, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(1644455541);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(paywallHostViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1644455541, i4, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.onViewModel (PaywallHostActivity.kt:418)");
            }
            String stringExtra = getIntent().getStringExtra("OFFERING_FROM_DEEPLINK");
            if (stringExtra == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.h0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PaywallHostActivity.c2(this.f113398a, paywallHostViewModel, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            boolean zI = composerK.I(paywallHostViewModel) | composerK.Z(stringExtra);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new PaywallHostActivity$onViewModel$1$1(paywallHostViewModel, stringExtra, null);
                composerK.w(objG);
            }
            EffectsKt.g(stringExtra, (Function2) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallHostActivity.d2(this.f113404a, paywallHostViewModel, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(PaywallHostActivity paywallHostActivity, ScaffoldState scaffoldState, PaywallHostViewModel paywallHostViewModel, PremiumScreenViewState premiumScreenViewState, ModalBottomSheetState modalBottomSheetState, Function1 function1, int i3, Composer composer, int i4) {
        paywallHostActivity.U0(scaffoldState, paywallHostViewModel, premiumScreenViewState, modalBottomSheetState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(PaywallHostActivity paywallHostActivity, PaywallHostViewModel paywallHostViewModel, int i3, Composer composer, int i4) {
        paywallHostActivity.b2(paywallHostViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void d1(final PaddingValues paddingValues, final Function0 function0, final Function1 function1, final PremiumScreenViewState premiumScreenViewState, final Shimmer shimmer, Composer composer, final int i3) {
        PaddingValues paddingValues2;
        int i4;
        Function0 function02;
        Function1 function12;
        PremiumScreenViewState premiumScreenViewState2;
        Composer composerK = composer.k(1818082268);
        if ((i3 & 6) == 0) {
            paddingValues2 = paddingValues;
            i4 = (composerK.Z(paddingValues2) ? 4 : 2) | i3;
        } else {
            paddingValues2 = paddingValues;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            function02 = function0;
            i4 |= composerK.I(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i3 & 384) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            premiumScreenViewState2 = premiumScreenViewState;
            i4 |= composerK.Z(premiumScreenViewState2) ? 2048 : 1024;
        } else {
            premiumScreenViewState2 = premiumScreenViewState;
        }
        if ((i3 & 24576) == 0) {
            i4 |= (32768 & i3) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1818082268, i4, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenContent (PaywallHostActivity.kt:433)");
            }
            PaywallLayout paywallLayoutI = N1().i();
            if (paywallLayoutI instanceof PaywallLayout.Standard) {
                composerK.a0(-874618610);
                int i5 = i4;
                int i6 = i5 >> 6;
                int i7 = (i5 & 14) | (i6 & 112) | (Shimmer.f93784d << 6) | (i6 & 896);
                int i8 = i5 << 9;
                PaddingValues paddingValues3 = paddingValues2;
                PremiumScreenViewState premiumScreenViewState3 = premiumScreenViewState2;
                StandardPaywallContentKt.h(paddingValues3, premiumScreenViewState3, shimmer, V1(), function02, function12, (PaywallLayout.Standard) paywallLayoutI, composerK, (i8 & 458752) | (57344 & i8) | i7);
                composerK = composerK;
                composerK.U();
            } else {
                int i9 = i4;
                if (paywallLayoutI instanceof PaywallLayout.Illustrated) {
                    composerK.a0(-874605344);
                    int i10 = i9 >> 6;
                    int i11 = (i9 & 14) | (i10 & 112) | (Shimmer.f93784d << 6) | (i10 & 896);
                    int i12 = i9 << 6;
                    IllustratedPaywallContentKt.g(paddingValues, premiumScreenViewState, shimmer, function0, function1, (PaywallLayout.Illustrated) paywallLayoutI, composerK, i11 | (i12 & 7168) | (i12 & 57344));
                    composerK = composerK;
                    composerK.U();
                } else if (Intrinsics.areEqual(paywallLayoutI, PaywallLayout.IntroTrialToggle.f113322a)) {
                    composerK.a0(-874593472);
                    int i13 = i9 >> 6;
                    int i14 = (i9 & 14) | (i13 & 112) | (Shimmer.f93784d << 6) | (i13 & 896);
                    int i15 = i9 << 6;
                    IntroTrialTogglePaywallContentKt.l(paddingValues, premiumScreenViewState, shimmer, function0, function1, composerK, i14 | (i15 & 7168) | (i15 & 57344));
                    composerK.U();
                } else if (Intrinsics.areEqual(paywallLayoutI, PaywallLayout.RcTrial.f113324a)) {
                    composerK.a0(-874582944);
                    int i16 = i9 << 3;
                    RcTrialPaywallContentKt.f(paddingValues, premiumScreenViewState, function0, function1, composerK, (i9 & 14) | ((i9 >> 6) & 112) | (i16 & 896) | (i16 & 7168));
                    composerK.U();
                } else {
                    if (!Intrinsics.areEqual(paywallLayoutI, PaywallLayout.MySubscription.f113323a)) {
                        composerK.a0(-874619612);
                        composerK.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerK.a0(-874574114);
                    int i17 = i9 >> 6;
                    int i18 = (i9 & 14) | (i17 & 112) | (Shimmer.f93784d << 6) | (i17 & 896);
                    int i19 = i9 << 6;
                    MySubscriptionPaywallContentKt.i(paddingValues, premiumScreenViewState, shimmer, function0, function1, composerK, i18 | (i19 & 7168) | (i19 & 57344));
                    composerK.U();
                }
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallHostActivity.e1(this.f113407a, paddingValues, function0, function1, premiumScreenViewState, shimmer, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d2(PaywallHostActivity paywallHostActivity, PaywallHostViewModel paywallHostViewModel, int i3, Composer composer, int i4) {
        paywallHostActivity.b2(paywallHostViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(PaywallHostActivity paywallHostActivity, PaddingValues paddingValues, Function0 function0, Function1 function1, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, int i3, Composer composer, int i4) {
        paywallHostActivity.d1(paddingValues, function0, function1, premiumScreenViewState, shimmer, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e2(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$onboardingExperimentEngine$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$onboardingExperimentEngine$1 r0 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$onboardingExperimentEngine$1) r0
            int r1 = r0.f113281c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f113281c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$onboardingExperimentEngine$1 r0 = new cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$onboardingExperimentEngine$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f113279a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f113281c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L55
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r5 = r4.N1()
            boolean r5 = r5.f()
            if (r5 == 0) goto L5c
            boolean r5 = r4.V1()
            if (r5 == 0) goto L5c
            cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r5 = r4.M1()
            kotlinx.coroutines.flow.Flow r5 = r5.y()
            r0.f113281c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L55
            return r1
        L55:
            cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant r5 = (cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant) r5
            cz.mobilesoft.coreblock.util.monetization.PaywallEngine r5 = cz.mobilesoft.coreblock.scene.premium.host.PaywallSpecKt.a(r5)
            return r5
        L5c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.e2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void f1(final ScaffoldState scaffoldState, final PremiumScreenViewModel premiumScreenViewModel, final PremiumScreenViewState premiumScreenViewState, final ModalBottomSheetState modalBottomSheetState, final Function1 function1, final MutableState mutableState, final MutableState mutableState2, Composer composer, final int i3) {
        int i4;
        MutableState mutableState3;
        final PremiumScreenViewState premiumScreenViewState2;
        Composer composer2;
        Object obj;
        int i5;
        int i6;
        ActivityResultContracts.StartActivityForResult startActivityForResult;
        final Context context;
        final PaywallHostActivity paywallHostActivity;
        PurchaseSuccessDTO purchaseSuccessDTO;
        int i7;
        int i8;
        int i9;
        final PaywallHostActivity paywallHostActivity2 = this;
        Composer composerK = composer.k(1456956229);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(premiumScreenViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(premiumScreenViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function1) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            mutableState3 = mutableState;
            i4 |= composerK.Z(mutableState3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            mutableState3 = mutableState;
        }
        if ((i3 & 1572864) == 0) {
            i4 |= composerK.Z(mutableState2) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i4 |= composerK.I(paywallHostActivity2) ? 8388608 : 4194304;
        }
        if (composerK.r((i4 & 4793491) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1456956229, i4, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.PremiumScreenInitialize (PaywallHostActivity.kt:839)");
            }
            final Context context2 = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState4 = (MutableState) objG2;
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            int i10 = 3670016 & i4;
            int i11 = i4 & 896;
            int i12 = i4;
            boolean zI = (i11 == 256) | (i10 == 1048576) | composerK.I(context2) | composerK.I(paywallHostActivity2);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.host.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PaywallHostActivity.g1(mutableState2, context2, paywallHostActivity2, premiumScreenViewState, (ActivityResult) obj2);
                    }
                };
                composerK.w(objG3);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG3, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult3 = new ActivityResultContracts.StartActivityForResult();
            int i13 = i12 & 458752;
            boolean zI2 = (i11 == 256) | (i13 == 131072) | composerK.I(managedActivityResultLauncherA) | composerK.I(context2) | composerK.I(paywallHostActivity2);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                final MutableState mutableState5 = mutableState3;
                i5 = i13;
                i6 = i12;
                startActivityForResult = startActivityForResult3;
                context = context2;
                obj = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.host.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PaywallHostActivity.h1(mutableState5, managedActivityResultLauncherA, context, premiumScreenViewState, paywallHostActivity2, (ActivityResult) obj2);
                    }
                };
                paywallHostActivity = paywallHostActivity2;
                composerK.w(obj);
            } else {
                obj = objG4;
                i5 = i13;
                paywallHostActivity = paywallHostActivity2;
                i6 = i12;
                startActivityForResult = startActivityForResult3;
                context = context2;
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult, (Function1) obj, composerK, 0);
            boolean zI3 = (i11 == 256) | composerK.I(paywallHostActivity);
            Object objG5 = composerK.G();
            if (zI3 || objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.i1(premiumScreenViewState, paywallHostActivity);
                    }
                };
                composerK.w(objG5);
            }
            BackHandlerKt.a(false, (Function0) objG5, composerK, 0, 1);
            Unit unit = Unit.f139807a;
            int i14 = i6 & 7168;
            boolean z2 = i14 == 2048 || ((i6 & 4096) != 0 && composerK.I(modalBottomSheetState));
            int i15 = i6 & 57344;
            boolean z3 = (i15 == 16384) | z2;
            Object objG6 = composerK.G();
            if (z3 || objG6 == companion.a()) {
                objG6 = new PaywallHostActivity$PremiumScreenInitialize$2$1(modalBottomSheetState, function1, null);
                composerK.w(objG6);
            }
            EffectsKt.g(unit, (Function2) objG6, composerK, 6);
            PurchaseSuccessDTO purchaseSuccessDTOY = premiumScreenViewState.y();
            boolean zI4 = (i5 == 131072) | (i11 == 256) | (i10 == 1048576) | composerK.I(context) | composerK.I(managedActivityResultLauncherA2) | composerK.I(managedActivityResultLauncherA) | composerK.I(paywallHostActivity);
            Object objG7 = composerK.G();
            if (zI4 || objG7 == companion.a()) {
                purchaseSuccessDTO = purchaseSuccessDTOY;
                i7 = i6;
                i8 = 0;
                i9 = 1;
                Context context3 = context;
                PaywallHostActivity$PremiumScreenInitialize$3$1 paywallHostActivity$PremiumScreenInitialize$3$1 = new PaywallHostActivity$PremiumScreenInitialize$3$1(premiumScreenViewState, mutableState, mutableState2, context3, managedActivityResultLauncherA2, managedActivityResultLauncherA, paywallHostActivity, null);
                premiumScreenViewState2 = premiumScreenViewState;
                context = context3;
                composerK.w(paywallHostActivity$PremiumScreenInitialize$3$1);
                objG7 = paywallHostActivity$PremiumScreenInitialize$3$1;
            } else {
                premiumScreenViewState2 = premiumScreenViewState;
                purchaseSuccessDTO = purchaseSuccessDTOY;
                i7 = i6;
                i8 = 0;
                i9 = 1;
            }
            EffectsKt.g(purchaseSuccessDTO, (Function2) objG7, composerK, i8);
            ViewModelState viewModelStateC = premiumScreenViewState2.c();
            ImmutableList immutableListU = premiumScreenViewState2.u();
            Boolean boolValueOf = Boolean.valueOf(premiumScreenViewState2.X());
            int i16 = (composerK.I(context) ? 1 : 0) | (i11 == 256 ? i9 : i8) | (i15 == 16384 ? i9 : i8);
            Object objG8 = composerK.G();
            if (i16 != 0 || objG8 == companion.a()) {
                objG8 = new PaywallHostActivity$PremiumScreenInitialize$4$1(premiumScreenViewState2, context, function1, null);
                composerK.w(objG8);
            }
            EffectsKt.e(viewModelStateC, immutableListU, boolValueOf, (Function2) objG8, composerK, 0);
            composer2 = composerK;
            int i17 = i7 << 3;
            S0(coroutineScopeI, scaffoldState, premiumScreenViewModel, modalBottomSheetState, mutableState4, composer2, (i17 & 896) | (i17 & 112) | 24576 | (ModalBottomSheetState.f13222e << 9) | i14 | ((i7 >> 6) & 458752));
            paywallHostActivity2 = this;
            int i18 = (i15 == 16384 ? i9 : i8) | (i11 == 256 ? i9 : i8) | (composer2.I(paywallHostActivity2) ? 1 : 0);
            Object objG9 = composer2.G();
            if (i18 != 0 || objG9 == companion.a()) {
                objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.j1(function1, premiumScreenViewState2, paywallHostActivity2);
                    }
                };
                composer2.w(objG9);
            }
            Function0 function0 = (Function0) objG9;
            if (i15 == 16384) {
                i8 = i9;
            }
            int i19 = (composer2.I(paywallHostActivity2) ? 1 : 0) | i8;
            Object objG10 = composer2.G();
            if (i19 != 0 || objG10 == companion.a()) {
                objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.host.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallHostActivity.k1(function1, paywallHostActivity2);
                    }
                };
                composer2.w(objG10);
            }
            ExitPaywallScreenKt.q(mutableState4, function0, (Function0) objG10, composer2, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            premiumScreenViewState2 = premiumScreenViewState;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final PaywallHostActivity paywallHostActivity3 = paywallHostActivity2;
            final PremiumScreenViewState premiumScreenViewState3 = premiumScreenViewState2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PaywallHostActivity.l1(this.f113441a, scaffoldState, premiumScreenViewModel, premiumScreenViewState3, modalBottomSheetState, function1, mutableState, mutableState2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private final void f2() {
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, this, J1(), null, 4, null);
        intentC.setFlags(603979776);
        startActivity(intentC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(MutableState mutableState, Context context, PaywallHostActivity paywallHostActivity, PremiumScreenViewState premiumScreenViewState, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            RatingDialogActivity.f95979p.i(context, true, RatingTriggerSource.TrialStarted, null);
        }
        paywallHostActivity.a2(true, premiumScreenViewState.R(), false, premiumScreenViewState.I(), premiumScreenViewState.Q());
        return Unit.f139807a;
    }

    private final void g2() {
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, this, J1(), null, 4, null);
        intentC.setFlags(268468224);
        startActivity(intentC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(MutableState mutableState, ManagedActivityResultLauncher managedActivityResultLauncher, Context context, PremiumScreenViewState premiumScreenViewState, PaywallHostActivity paywallHostActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            managedActivityResultLauncher.b(TrialRemindersActivity.Companion.b(TrialRemindersActivity.f113891h, context, premiumScreenViewState.Q(), false, 4, null));
        } else {
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            boolean zR = premiumScreenViewState.R();
            PurchaseSuccessDTO purchaseSuccessDTOY = premiumScreenViewState.y();
            paywallHostActivity.a2(zBooleanValue, zR, purchaseSuccessDTOY != null && purchaseSuccessDTOY.a(), premiumScreenViewState.I(), premiumScreenViewState.Q());
        }
        return Unit.f139807a;
    }

    private final void h2(boolean z2) {
        if (z2 || N1().k().getRunsOnEveryCreate()) {
            int i3 = WhenMappings.f113237a[N1().k().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    NotificationHelper.f128940a.g(this);
                } else if (i3 == 3) {
                    PrefManager.f126839a.J2(-1);
                } else {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    NotificationHelper.f128940a.c(this);
                    CoroutineScope applicationScope = LockieApplication.f95365k;
                    Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
                    BuildersKt__Builders_commonKt.d(applicationScope, null, null, new PaywallHostActivity$performOnOpen$1(this, null), 3, null);
                }
            }
            Y1(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(PremiumScreenViewState premiumScreenViewState, PaywallHostActivity paywallHostActivity) {
        if (premiumScreenViewState.U()) {
            paywallHostActivity.Z1();
            if (BuildConfig.f95357b.booleanValue()) {
                AnswersHelper.f128199a.x8(true);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallSpec i2(PaywallHostActivity paywallHostActivity) {
        return PaywallSpecTableKt.B(paywallHostActivity.O1(), paywallHostActivity.I1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(Function1 function1, PremiumScreenViewState premiumScreenViewState, PaywallHostActivity paywallHostActivity) {
        function1.invoke(PremiumScreenViewEvent.OnExitPaywallDialogDismissed.f112351a);
        if (!premiumScreenViewState.V()) {
            paywallHostActivity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(PaywallHostActivity paywallHostActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        if (!paywallHostActivity.f113199s || !paywallHostActivity.f113200t) {
            paywallHostActivity.D1();
        } else {
            paywallHostActivity.f113201u.b(GuestPassShareActivity.f107428g.a(paywallHostActivity, GuestPassShareFlowScenario.OnboardingShareOnly));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(Function1 function1, PaywallHostActivity paywallHostActivity) {
        function1.invoke(PremiumScreenViewEvent.OnExitPaywallDialogDismissed.f112351a);
        paywallHostActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(PaywallHostActivity paywallHostActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Object value = paywallHostActivity.f113190j.getValue();
        GateState gateState = GateState.Closing;
        if (value == gateState) {
            return;
        }
        if (result.d() == 1001) {
            paywallHostActivity.f113190j.setValue(GateState.ShowOwnPaywall);
            return;
        }
        paywallHostActivity.f113190j.setValue(gateState);
        if (result.d() == -1) {
            paywallHostActivity.D1();
            return;
        }
        paywallHostActivity.Z1();
        if (paywallHostActivity.N1().d() == CloseBehaviour.OfferDiscount || paywallHostActivity.N1().d() == CloseBehaviour.OfferDiscountUnlessFirstStart) {
            return;
        }
        paywallHostActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(PaywallHostActivity paywallHostActivity, ScaffoldState scaffoldState, PremiumScreenViewModel premiumScreenViewModel, PremiumScreenViewState premiumScreenViewState, ModalBottomSheetState modalBottomSheetState, Function1 function1, MutableState mutableState, MutableState mutableState2, int i3, Composer composer, int i4) {
        paywallHostActivity.f1(scaffoldState, premiumScreenViewModel, premiumScreenViewState, modalBottomSheetState, function1, mutableState, mutableState2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallTarget l2(PaywallHostActivity paywallHostActivity) {
        try {
            Serializable serializableExtra = paywallHostActivity.getIntent().getSerializableExtra("paywall_target");
            PaywallTarget paywallTarget = serializableExtra instanceof PaywallTarget ? (PaywallTarget) serializableExtra : null;
            if (paywallTarget != null) {
                return paywallTarget;
            }
            PaywallTarget.Generic generic = PaywallTarget.Generic.INSTANCE;
            CrashHelper.j(new IllegalStateException("PaywallHostActivity started without a target"));
            return generic;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return PaywallTarget.Generic.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(PaywallHostActivity paywallHostActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-662644456, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.RootCompose.<anonymous> (PaywallHostActivity.kt:774)");
            }
            int i4 = WhenMappings.f113241e[n1(SnapshotStateKt.b(paywallHostActivity.f113190j, null, composer, 0, 1)).ordinal()];
            if (i4 == 1 || i4 == 2) {
                composer.a0(-1170956766);
                Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
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
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ProgressIndicatorKt.b(null, 0L, 0.0f, 0L, 0, composer, 0, 31);
                composer.y();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                return Unit.f139807a;
            }
            if (i4 == 3) {
                composer.a0(-1170512970);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                return Unit.f139807a;
            }
            if (i4 != 4) {
                composer.a0(-1146153631);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(-1146135076);
            composer.U();
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            PaywallHostViewModel paywallHostViewModelP1 = paywallHostActivity.P1(composer, 0);
            PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) FlowExtKt.m(paywallHostViewModelP1, composer, 0);
            Function1 function1N = FlowExtKt.n(paywallHostViewModelP1, composer, 0);
            ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.host.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(PaywallHostActivity.o1((ModalBottomSheetValue) obj));
                    }
                };
                composer.w(objG);
            }
            ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(modalBottomSheetValue, null, (Function1) objG, true, composer, 3462, 2);
            Object objG2 = composer.G();
            if (objG2 == companion2.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG2);
            }
            MutableState mutableState = (MutableState) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion2.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG3);
            }
            int i5 = ModalBottomSheetState.f13222e;
            paywallHostActivity.f1(scaffoldStateG, paywallHostViewModelP1, premiumScreenViewState, modalBottomSheetStateJ, function1N, mutableState, (MutableState) objG3, composer, (i5 << 9) | 1769472);
            Modifier.Companion companion3 = Modifier.b8;
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion4.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion3);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A2 = companion5.a();
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
            Updater.e(composerA2, measurePolicyG2, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion5.f());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
            paywallHostActivity.U0(scaffoldStateG, paywallHostViewModelP1, premiumScreenViewState, modalBottomSheetStateJ, function1N, composer, i5 << 9);
            PaywallTraceOverlayKt.I(boxScopeInstance2.f(companion3, companion4.n()), composer, 0, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final GateState n1(State state) {
        return (GateState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o1(ModalBottomSheetValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != ModalBottomSheetValue.HalfExpanded;
    }

    protected final void B1() {
        CoroutinesHelperExtKt.e(this, new PaywallHostActivity$checkAndShowDiscount$1(this, null));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(PaddingValues paddingValues, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        composer.a0(2054160295);
        if (ComposerKt.M()) {
            ComposerKt.U(2054160295, i3, -1, "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.RootCompose (PaywallHostActivity.kt:770)");
        }
        ComposeThemesKt.b(null, ComposableLambdaKt.e(-662644456, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.host.q0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PaywallHostActivity.m1(this.f113440a, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 48, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f113198r;
    }

    @Override // android.app.Activity
    public void finish() {
        if (N1().p()) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
    }

    @Override // cz.mobilesoft.coreblock.service.passlock.PassLockExempt
    public boolean g() {
        return N1().g();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        GateState next;
        h2(bundle == null);
        if (bundle == null) {
            PaywallTraceStore.f128981a.a();
        }
        super.onCreate(bundle);
        if (bundle != null) {
            this.f113199s = bundle.getBoolean("state_trial_purchased", false);
            this.f113200t = bundle.getBoolean("state_show_guest_pass_share", false);
            MutableStateFlow mutableStateFlow = this.f113190j;
            Iterator<GateState> it = GateState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(next.name(), bundle.getString("paywall_host_gate_state"))) {
                        break;
                    }
                }
            }
            GateState gateState = next;
            if (gateState == null) {
                gateState = GateState.Running;
            }
            mutableStateFlow.setValue(gateState);
        }
        if (this.f113190j.getValue() == GateState.Closing) {
            finish();
        } else {
            getOnBackPressedDispatcher().i(this, new OnBackPressedCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.onCreate.2
                {
                    super(true);
                }

                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    Object value = PaywallHostActivity.this.f113190j.getValue();
                    GateState gateState2 = GateState.Closing;
                    if (value == gateState2) {
                        setEnabled(false);
                        PaywallHostActivity.this.getOnBackPressedDispatcher().l();
                        return;
                    }
                    if (PaywallHostActivity.this.f113190j.getValue() == GateState.AwaitingSuperwall) {
                        return;
                    }
                    if (PaywallHostActivity.this.K1().c() || PaywallHostActivity.this.K1().d()) {
                        PaywallHostActivity.this.f113190j.setValue(gateState2);
                        setEnabled(false);
                        PaywallHostActivity.this.Z1();
                        if (PaywallHostActivity.this.N1().d() == CloseBehaviour.OfferDiscount || PaywallHostActivity.this.N1().d() == CloseBehaviour.OfferDiscountUnlessFirstStart) {
                            return;
                        }
                        PaywallHostActivity.this.finish();
                    }
                }
            });
            A1();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("state_trial_purchased", this.f113199s);
        outState.putBoolean("state_show_guest_pass_share", this.f113200t);
        outState.putString("paywall_host_gate_state", ((GateState) this.f113190j.getValue()).name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallHostViewModel.Launch X1(PaywallHostActivity paywallHostActivity) {
        PaywallTarget.Discount discount;
        String stringExtra = paywallHostActivity.getIntent().getStringExtra("EVENT_ENTRANCES");
        if (stringExtra == null) {
            PaywallTarget paywallTargetO1 = paywallHostActivity.O1();
            if (paywallTargetO1 instanceof PaywallTarget.Discount) {
                discount = (PaywallTarget.Discount) paywallTargetO1;
            } else {
                discount = null;
            }
            if (discount != null && discount.isFromDeeplink()) {
                stringExtra = SDKConstants.PARAM_TOURNAMENTS_DEEPLINK;
            } else {
                stringExtra = null;
            }
            if (stringExtra == null) {
                stringExtra = "";
            }
        }
        return new PaywallHostViewModel.Launch(stringExtra, paywallHostActivity.getIntent().getStringExtra(sECyKyO.YckdMxNe), paywallHostActivity.getIntent().getBooleanExtra("WITH_CLOSE_BUTTON", true), paywallHostActivity.getIntent().getBooleanExtra("paywall_with_skip_text", false), paywallHostActivity.V1());
    }
}
