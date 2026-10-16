package cz.mobilesoft.appblock.view;

import android.content.Context;
import android.content.Intent;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.AdView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.activity.InterstitialAdActivity;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.LockScreenBannerUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class LockScreenProvider implements KoinComponent {
    private boolean A;
    private boolean B;
    private long C;
    private int D;
    private int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentLockBinding f95144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OnCloseSelectedListener f95145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f95146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f95147d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f95148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f95149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f95150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f95151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f95152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f95153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f95154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f95155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f95156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f95157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableStateFlow f95158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RevenueCatPlacement f95159q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f95160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f95161s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f95162t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f95163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f95164v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f95165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f95166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f95167y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CampaignSource f95168z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnCloseSelectedListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f95180a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.STRICT_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProfileType.TIME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProfileType.QUICK_BLOCK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f95180a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockScreenProvider(FragmentLockBinding binding, OnCloseSelectedListener listener) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f95144a = binding;
        this.f95145b = listener;
        final Qualifier qualifier = null;
        this.f95146c = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f95147d = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f95148f = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f95149g = LazyKt.a(lazyThreadSafetyModeB, new Function0<BlockSessionDao>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockSessionDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f95150h = LazyKt.a(lazyThreadSafetyModeB2, new Function0<LaunchTimeDao>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LaunchTimeDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f95151i = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f95152j = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f95153k = LazyKt.a(lazyThreadSafetyModeB5, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f95154l = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f95155m = LazyKt.a(lazyThreadSafetyModeB7, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr12, objArr13);
            }
        });
        this.f95156n = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.view.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(LockScreenProvider.V(this.f95347a));
            }
        });
        this.f95157o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.view.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProvider.W(this.f95348a);
            }
        });
        this.f95158p = StateFlowKt.a(null);
        this.f95159q = RevenueCatPlacement.Discount20;
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.f95160r = context;
        this.f95167y = -1L;
        this.f95168z = CampaignSource.None;
        this.E = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(LockScreenProvider lockScreenProvider, View view) {
        AnswersHelper.f128199a.a1(lockScreenProvider.f95167y);
        lockScreenProvider.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, AdView adView) {
        lockScreenProvider.f95165w = true;
        FrameLayout advertisementFrameLayout = fragmentLockBinding.f93997b;
        Intrinsics.checkNotNullExpressionValue(advertisementFrameLayout, "advertisementFrameLayout");
        advertisementFrameLayout.setVisibility(0);
        fragmentLockBinding.f93997b.addView(adView);
        return Unit.f139807a;
    }

    private final void C0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.C > 1000) {
            this.D = 1;
        } else {
            int i3 = this.D;
            if (i3 < 4) {
                this.D = i3 + 1;
            } else {
                this.D = 0;
                BackdoorCodeDialog.M(new BackdoorCodeDialog(this.f95160r, null, 2, null), new Function0() { // from class: cz.mobilesoft.appblock.view.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LockScreenProvider.D0(this.f95338a);
                    }
                }, null, 2, null);
            }
        }
        this.C = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(LockScreenProvider lockScreenProvider) {
        lockScreenProvider.O();
        Intent intent = new Intent(lockScreenProvider.f95160r, (Class<?>) BackdoorFeedbackActivity.class);
        intent.addFlags(268435456);
        lockScreenProvider.f95160r.startActivity(intent);
        return Unit.f139807a;
    }

    private final void E0(boolean z2) {
        if (!z2) {
            O();
            return;
        }
        this.f95163u = true;
        if (this.f95164v) {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(Spanned spanned) {
        AnswersHelper.f128199a.D6();
        DialogHelperExtKt.p(this.f95160r, false, spanned, new Function0() { // from class: cz.mobilesoft.appblock.view.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProvider.G0(this.f95323a);
            }
        }, new Function0() { // from class: cz.mobilesoft.appblock.view.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProvider.H0();
            }
        }, new Function0() { // from class: cz.mobilesoft.appblock.view.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProvider.I0();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(LockScreenProvider lockScreenProvider) {
        AnswersHelper.f128199a.i7();
        lockScreenProvider.X(ContactReason.EmergencyUnblocking);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0() {
        return Unit.f139807a;
    }

    private final void J0() {
        PopupMenu popupMenu = new PopupMenu(this.f95160r, this.f95144a.f94014s);
        popupMenu.getMenuInflater().inflate(R.menu.menu_lock_screen, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: cz.mobilesoft.appblock.view.q
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LockScreenProvider.K0(this.f95346a, menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K0(LockScreenProvider lockScreenProvider, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.action_contact_support) {
            Y(lockScreenProvider, null, 1, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(boolean z2) {
        if (!z2) {
            if (this.B) {
                R();
                return;
            } else {
                O();
                return;
            }
        }
        if (!this.f95164v) {
            try {
                RatingDialogActivity.f95979p.i(this.f95160r, false, RatingTriggerSource.LockScreen, new RatingDialogActivity.OnRatingDialogClosedListener() { // from class: cz.mobilesoft.appblock.view.o
                    @Override // cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.OnRatingDialogClosedListener
                    public final void a(boolean z3) {
                        LockScreenProvider.O0(this.f95344a, z3);
                    }
                });
                return;
            } catch (Exception e3) {
                CrashHelper.j(e3);
                return;
            }
        }
        this.f95145b.a();
        try {
            RatingDialogActivity.f95979p.i(this.f95160r, false, RatingTriggerSource.LockScreen, null);
        } catch (Exception e4) {
            CrashHelper.j(e4);
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        this.f95145b.a();
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(LockScreenProvider lockScreenProvider, boolean z2) {
        lockScreenProvider.E0(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        this.f95145b.a();
        try {
            Intent intentA = InAppUpdateActivity.f102432h.a(this.f95160r, "lock_screen");
            intentA.setFlags(268468224);
            this.f95160r.startActivity(intentA);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        U();
    }

    private final void Q() {
        CoroutinesHelperExtKt.d(new LockScreenProvider$closeAndFinishBlockingTest$1(this, null));
    }

    private final void R() {
        this.f95145b.a();
        try {
            Intent intent = new Intent(this.f95160r, (Class<?>) InterstitialAdActivity.class);
            intent.setFlags(268468224);
            this.f95160r.startActivity(intent);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        U();
    }

    private final void S() {
        this.f95145b.a();
        try {
            Intent intentC = Paywall.c(Paywall.f113165a, this.f95160r, new PaywallTarget.Campaign(this.f95167y, this.f95168z, "lock_screen"), "lock_screen", "lock_screen", false, false, false, null, 240, null);
            intentC.setFlags(268468224);
            this.f95160r.startActivity(intentC);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        U();
    }

    private final void T() {
        this.f95145b.a();
        try {
            this.f95160r.startActivity(Paywall.c(Paywall.f113165a, this.f95160r, new PaywallTarget.Discount(this.f95159q, DiscountSource.AUTOMATIC, false, null), "lock_screen", null, false, false, false, null, 248, null));
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        if (this.f95165w) {
            try {
                LockScreenBannerUtils.f127896d.k(this.f95160r, PremiumState.Subscription.Yearly.INSTANCE);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
        }
        CoroutineScopeKt.e(this.f95146c, null, 1, null);
        CoroutineScopeKt.e(this.f95148f, null, 1, null);
        CoroutineScopeKt.e(this.f95147d, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int V(LockScreenProvider lockScreenProvider) {
        return ContextCompat.getColor(lockScreenProvider.f95160r, R.color.critical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String W(LockScreenProvider lockScreenProvider) {
        return "#" + Integer.toHexString(lockScreenProvider.a0() & 16777215);
    }

    private final void X(ContactReason contactReason) {
        this.f95145b.a();
        try {
            RunnabilityHelper.V(this.f95160r, 0, 268468224, false, contactReason, false, "lock_screen", 42, null);
        } catch (Exception e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
        }
        U();
    }

    static /* synthetic */ void Y(LockScreenProvider lockScreenProvider, ContactReason contactReason, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            contactReason = null;
        }
        lockScreenProvider.X(contactReason);
    }

    private final BlockSessionDao Z() {
        return (BlockSessionDao) this.f95149g.getValue();
    }

    private final int a0() {
        return ((Number) this.f95156n.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b0() {
        return (String) this.f95157o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore c0() {
        return (CoreDataStore) this.f95152j.getValue();
    }

    private final DiscountDataStore d0() {
        return (DiscountDataStore) this.f95154l.getValue();
    }

    private final DiscountRepository e0() {
        return (DiscountRepository) this.f95155m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaunchTimeDao f0() {
        return (LaunchTimeDao) this.f95150h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao g0() {
        return (ProfileDao) this.f95151i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore h0() {
        return (RatingDataStore) this.f95153k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03a9, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r4, r7) != r2) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0171 A[PHI: r3 r6
      0x0171: PHI (r3v16 cz.mobilesoft.coreblock.enums.RevenueCatOffering) = 
      (r3v3 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
      (r3v7 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
      (r3v19 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
     binds: [B:42:0x016f, B:32:0x0122, B:41:0x0165] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r6v14 cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO) = 
      (r6v1 cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO)
      (r6v6 cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO)
      (r6v15 cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO)
     binds: [B:42:0x016f, B:32:0x0122, B:41:0x0165] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i0(cz.mobilesoft.appblock.view.LockScreenProvider.LockScreenDTO r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider.i0(cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LockScreenProvider lockScreenProvider, ProfileWithConfiguration profileWithConfiguration, UrlDto urlDto, String str, Long l3, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption) {
        BuildersKt__Builders_commonKt.d(lockScreenProvider.f95146c, null, null, new LockScreenProvider$init$1$1(profileWithConfiguration, lockScreenProvider, urlDto, str, l3, periodType, str2, strictModeOption, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(LockScreenProvider lockScreenProvider, String str, Long l3, String str2, ProfileType profileType, UsageLimit.PeriodType periodType) {
        BuildersKt__Builders_commonKt.d(lockScreenProvider.f95146c, null, null, new LockScreenProvider$init$2$1(lockScreenProvider, str, l3, str2, profileType, periodType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(LockScreenProvider lockScreenProvider, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        lockScreenProvider.O();
        return Unit.f139807a;
    }

    private final void o0(FragmentLockBinding fragmentLockBinding) {
        BuildersKt__Builders_commonKt.d(this.f95146c, null, null, new LockScreenProvider$initAvailableSettings$1(this, fragmentLockBinding, null), 3, null);
    }

    private final void p0(ProfileType profileType) {
        final FragmentLockBinding fragmentLockBinding = this.f95144a;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LockScreenProvider.q0(this.f95317a, fragmentLockBinding, view);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LockScreenProvider.s0(this.f95319a, fragmentLockBinding, view);
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LockScreenProvider.t0(this.f95321a, fragmentLockBinding, view);
            }
        };
        switch (Calendar.getInstance().get(2) + 1) {
            case 1:
            case 7:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener2);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener3);
                break;
            case 2:
            case 8:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener2);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener3);
                break;
            case 3:
            case 9:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener3);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener2);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener);
                break;
            case 4:
            case 10:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener2);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener3);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener);
                break;
            case 5:
            case 11:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener3);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener2);
                break;
            case 6:
            default:
                fragmentLockBinding.f94016u.setOnClickListener(onClickListener);
                fragmentLockBinding.f93998c.setOnClickListener(onClickListener3);
                fragmentLockBinding.f94006k.setOnClickListener(onClickListener2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, View view) {
        lockScreenProvider.f95161s = BackdoorUtils.f105650a.a(0, lockScreenProvider.f95161s, lockScreenProvider.f95162t);
        lockScreenProvider.f95162t = System.currentTimeMillis();
        if (Intrinsics.areEqual(view, fragmentLockBinding.f94016u)) {
            lockScreenProvider.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, View view) {
        lockScreenProvider.f95161s = BackdoorUtils.f105650a.a(1, lockScreenProvider.f95161s, lockScreenProvider.f95162t);
        lockScreenProvider.f95162t = System.currentTimeMillis();
        if (Intrinsics.areEqual(view, fragmentLockBinding.f94016u)) {
            lockScreenProvider.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, View view) {
        lockScreenProvider.f95161s = BackdoorUtils.f105650a.a(2, lockScreenProvider.f95161s, lockScreenProvider.f95162t);
        lockScreenProvider.f95162t = System.currentTimeMillis();
        if (Intrinsics.areEqual(view, fragmentLockBinding.f94016u)) {
            lockScreenProvider.C0();
        }
    }

    private final void u0(long j3) {
        FlowKt.Q(FlowKt.V(TimeHelperExt.f128663a.a(j3, 500L), new LockScreenProvider$initCampaignCountDown$1(this, null)), this.f95148f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(long j3, double d3) {
        FlowKt.Q(FlowKt.V(TimeHelperExt.f128663a.a(j3, 500L), new LockScreenProvider$initTimeoutCountDown$1(this, d3, null)), this.f95148f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:69:0x0239. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ff A[Catch: NameNotFoundException -> 0x00af, TryCatch #1 {NameNotFoundException -> 0x00af, blocks: (B:16:0x007a, B:19:0x0090, B:21:0x009f, B:57:0x01e0, B:59:0x01ff, B:60:0x021a, B:25:0x00b2, B:27:0x00b8, B:28:0x00c5, B:30:0x00dd, B:32:0x00e3, B:35:0x00fa, B:38:0x010b, B:46:0x0178, B:48:0x0180, B:49:0x018d, B:51:0x0194, B:55:0x01a5, B:41:0x012c, B:43:0x016e, B:56:0x01d8), top: B:129:0x007a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w0(final cz.mobilesoft.appblock.databinding.FragmentLockBinding r23, cz.mobilesoft.appblock.view.LockScreenProvider.LockScreenDTO r24) {
        /*
            Method dump skipped, instruction units count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider.w0(cz.mobilesoft.appblock.databinding.FragmentLockBinding, cz.mobilesoft.appblock.view.LockScreenProvider$LockScreenDTO):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(LockScreenProvider lockScreenProvider, View view) {
        lockScreenProvider.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(LockScreenProvider lockScreenProvider, View view) {
        lockScreenProvider.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LockScreenProvider lockScreenProvider, View view) {
        lockScreenProvider.J0();
    }

    public final boolean L0() {
        return this.f95163u;
    }

    public final void M0() {
        if (this.f95166x) {
            Q();
            return;
        }
        if (this.A) {
            T();
            return;
        }
        if (PrefManager.f126839a.p0() >= this.E) {
            BuildersKt__Builders_commonKt.d(this.f95146c, null, null, new LockScreenProvider$tryToClose$1(this, null), 3, null);
        } else if (this.B) {
            R();
        } else {
            O();
        }
    }

    public final void j0(final String packageName, final UrlDto urlDto, final Long l3, final ProfileWithConfiguration profileWithConfiguration, final UsageLimit.PeriodType periodType, final String str, final StrictModeOption strictModeOption) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.view.i
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                LockScreenProvider.l0(this.f95330a, profileWithConfiguration, urlDto, packageName, l3, periodType, str, strictModeOption);
            }
        });
    }

    public final void k0(final String packageName, final Long l3, final ProfileType profileType, final String profileTitle, final UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.view.h
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                LockScreenProvider.m0(this.f95324a, packageName, l3, profileTitle, profileType, periodType);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f95169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UrlDto f95170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f95171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f95172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ProfileType f95173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final UsageLimit.PeriodType f95174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f95175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Spanned f95176h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f95177i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f95178j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private StrictModeOption f95179k;

        public LockScreenDTO(String packageName, UrlDto urlDto, Long l3, String profileTitle, ProfileType profileType, UsageLimit.PeriodType periodType, String str, Spanned spanned, boolean z2, String str2, StrictModeOption strictModeOption) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
            this.f95169a = packageName;
            this.f95170b = urlDto;
            this.f95171c = l3;
            this.f95172d = profileTitle;
            this.f95173e = profileType;
            this.f95174f = periodType;
            this.f95175g = str;
            this.f95176h = spanned;
            this.f95177i = z2;
            this.f95178j = str2;
            this.f95179k = strictModeOption;
        }

        public final Long a() {
            return this.f95171c;
        }

        public final String b() {
            return this.f95175g;
        }

        public final String c() {
            return this.f95178j;
        }

        public final Spanned d() {
            return this.f95176h;
        }

        public final String e() {
            return this.f95169a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LockScreenDTO)) {
                return false;
            }
            LockScreenDTO lockScreenDTO = (LockScreenDTO) obj;
            return Intrinsics.areEqual(this.f95169a, lockScreenDTO.f95169a) && Intrinsics.areEqual(this.f95170b, lockScreenDTO.f95170b) && Intrinsics.areEqual(this.f95171c, lockScreenDTO.f95171c) && Intrinsics.areEqual(this.f95172d, lockScreenDTO.f95172d) && this.f95173e == lockScreenDTO.f95173e && this.f95174f == lockScreenDTO.f95174f && Intrinsics.areEqual(this.f95175g, lockScreenDTO.f95175g) && Intrinsics.areEqual(this.f95176h, lockScreenDTO.f95176h) && this.f95177i == lockScreenDTO.f95177i && Intrinsics.areEqual(this.f95178j, lockScreenDTO.f95178j) && this.f95179k == lockScreenDTO.f95179k;
        }

        public final String f() {
            return this.f95172d;
        }

        public final ProfileType g() {
            return this.f95173e;
        }

        public final boolean h() {
            return this.f95177i;
        }

        public int hashCode() {
            int iHashCode = this.f95169a.hashCode() * 31;
            UrlDto urlDto = this.f95170b;
            int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
            Long l3 = this.f95171c;
            int iHashCode3 = (((iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31) + this.f95172d.hashCode()) * 31;
            ProfileType profileType = this.f95173e;
            int iHashCode4 = (iHashCode3 + (profileType == null ? 0 : profileType.hashCode())) * 31;
            UsageLimit.PeriodType periodType = this.f95174f;
            int iHashCode5 = (iHashCode4 + (periodType == null ? 0 : periodType.hashCode())) * 31;
            String str = this.f95175g;
            int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
            Spanned spanned = this.f95176h;
            int iHashCode7 = (((iHashCode6 + (spanned == null ? 0 : spanned.hashCode())) * 31) + Boolean.hashCode(this.f95177i)) * 31;
            String str2 = this.f95178j;
            int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
            StrictModeOption strictModeOption = this.f95179k;
            return iHashCode8 + (strictModeOption != null ? strictModeOption.hashCode() : 0);
        }

        public final StrictModeOption i() {
            return this.f95179k;
        }

        public final UrlDto j() {
            return this.f95170b;
        }

        public final UsageLimit.PeriodType k() {
            return this.f95174f;
        }

        public final void l(Spanned spanned) {
            this.f95176h = spanned;
        }

        public final void m(boolean z2) {
            this.f95177i = z2;
        }

        public String toString() {
            String str = this.f95169a;
            UrlDto urlDto = this.f95170b;
            Long l3 = this.f95171c;
            String str2 = this.f95172d;
            ProfileType profileType = this.f95173e;
            UsageLimit.PeriodType periodType = this.f95174f;
            String str3 = this.f95175g;
            Spanned spanned = this.f95176h;
            return "LockScreenDTO(packageName=" + str + ", url=" + urlDto + ", blockUntil=" + l3 + ", profileTitle=" + str2 + ", profileType=" + profileType + ", usageLimitPeriodType=" + periodType + ", blockedKeyword=" + str3 + ", explanationText=" + ((Object) spanned) + ", showAvailableSettings=" + this.f95177i + ", customTitle=" + this.f95178j + ", strictModeOption=" + this.f95179k + ")";
        }

        public /* synthetic */ LockScreenDTO(String str, UrlDto urlDto, Long l3, String str2, ProfileType profileType, UsageLimit.PeriodType periodType, String str3, Spanned spanned, boolean z2, String str4, StrictModeOption strictModeOption, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, urlDto, l3, str2, (i3 & 16) != 0 ? null : profileType, (i3 & 32) != 0 ? null : periodType, (i3 & 64) != 0 ? null : str3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : spanned, (i3 & Function.MAX_NARGS) != 0 ? false : z2, (i3 & 512) != 0 ? null : str4, (i3 & 1024) != 0 ? null : strictModeOption);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LockScreenProvider(FragmentLockBinding binding, OnCloseSelectedListener listener, boolean z2) {
        this(binding, listener);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f95164v = z2;
    }
}
