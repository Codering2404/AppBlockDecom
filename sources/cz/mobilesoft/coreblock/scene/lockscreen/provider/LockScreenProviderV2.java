package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.usecase.DeterminePremiumStateUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.LockScreenBannerUtils;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockScreenProviderV2 implements KoinComponent {
    private boolean A;
    private Job B;
    private boolean C;
    private boolean D;
    private long E;
    private CampaignSource F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LockProviderListener f105774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f105775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f105776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f105777d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f105778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f105779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableStateFlow f105780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f105781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f105782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f105783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f105784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f105785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f105786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f105787o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f105788p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f105789q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f105790r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f105791s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f105792t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f105793u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f105794v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Set f105795w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MutableStateFlow f105796x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final RevenueCatPlacement f105797y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f105798z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface LockProviderListener {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        static /* synthetic */ void g(LockProviderListener lockProviderListener, boolean z2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCloseSelected");
            }
            if ((i3 & 1) != 0) {
                z2 = false;
            }
            lockProviderListener.a(z2);
        }

        void a(boolean z2);

        void b();

        void c(String str);

        void d();

        void e(ProfileType profileType);

        void f(RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource);

        void h(long j3, CampaignSource campaignSource, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f105813a;

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
            f105813a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LockScreenProviderV2(final Context context, LockProviderListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f105774a = listener;
        this.f105775b = context;
        final Qualifier qualifier = null;
        this.f105776c = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f105777d = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f105778f = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f105779g = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        this.f105780h = StateFlowKt.a(new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, y0().J(), -1, 7, null));
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f105781i = LazyKt.a(lazyThreadSafetyModeB2, new Function0<BlockSessionDao>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockSessionDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f105782j = LazyKt.a(lazyThreadSafetyModeB3, new Function0<LaunchTimeDao>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LaunchTimeDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f105783k = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f105784l = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f105785m = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f105786n = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f105787o = LazyKt.a(lazyThreadSafetyModeB8, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f105788p = LazyKt.a(lazyThreadSafetyModeB9, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f105789q = LazyKt.a(lazyThreadSafetyModeB10, new Function0<CustomBlockingScreenConfigDao>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CustomBlockingScreenConfigDao.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f105790r = LazyKt.a(lazyThreadSafetyModeB11, new Function0<DeterminePremiumStateUseCase>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DeterminePremiumStateUseCase.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f105791s = LazyKt.a(lazyThreadSafetyModeB12, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr22, objArr23);
            }
        });
        this.f105792t = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProviderV2.S();
            }
        });
        this.f105793u = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(LockScreenProviderV2.b0(context));
            }
        });
        this.f105794v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenProviderV2.c0(this.f105957a);
            }
        });
        this.f105796x = StateFlowKt.a(null);
        this.f105797y = RevenueCatPlacement.Discount20;
        this.E = -1L;
        this.F = CampaignSource.None;
        this.I = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore A0() {
        return (RatingDataStore) this.f105787o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x043a, code lost:
    
        if (r1 == r2) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195 A[PHI: r3 r6
      0x0195: PHI (r3v20 cz.mobilesoft.coreblock.enums.RevenueCatOffering) = 
      (r3v7 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
      (r3v10 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
      (r3v23 cz.mobilesoft.coreblock.enums.RevenueCatOffering)
     binds: [B:31:0x011c, B:36:0x0141, B:45:0x018c] A[DONT_GENERATE, DONT_INLINE]
      0x0195: PHI (r6v12 cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO) = 
      (r6v2 cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO)
      (r6v4 cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO)
      (r6v13 cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO)
     binds: [B:31:0x011c, B:36:0x0141, B:45:0x018c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockScreenDTO r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.C0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(LockScreenProviderV2 lockScreenProviderV2, ProfileWithConfiguration profileWithConfiguration, UrlDto urlDto, String str, Long l3, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption, boolean z2, boolean z3, boolean z4) {
        BuildersKt__Builders_commonKt.d(lockScreenProviderV2.f105776c, null, null, new LockScreenProviderV2$init$2$1(profileWithConfiguration, lockScreenProviderV2, urlDto, str, l3, periodType, str2, strictModeOption, z2, z3, z4, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(LockScreenProviderV2 lockScreenProviderV2, String str, Long l3, String str2, ProfileType profileType, UsageLimit.PeriodType periodType) {
        BuildersKt__Builders_commonKt.d(lockScreenProviderV2.f105776c, null, null, new LockScreenProviderV2$init$3$1(lockScreenProviderV2, str, l3, str2, profileType, periodType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(LockScreenProviderV2 lockScreenProviderV2, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        lockScreenProviderV2.U();
        return Unit.f139807a;
    }

    private final void I0(long j3) {
        FlowKt.Q(FlowKt.V(TimeHelperExt.f128663a.a(j3, 500L), new LockScreenProviderV2$initCampaignCountDown$1(this, null)), this.f105778f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(long j3, double d3) {
        Job job = this.B;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.B = FlowKt.Q(FlowKt.V(TimeHelperExt.f128663a.a(j3, 1000L), new LockScreenProviderV2$initTimeoutCountDown$1(this, d3, null)), this.f105778f);
    }

    private final void K0(boolean z2) {
        if (!z2) {
            U();
            return;
        }
        this.f105798z = true;
        V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LockScreenProviderV2.L0((LockViewState) obj);
            }
        });
        if (this.A) {
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState L0(LockViewState updateViewState) {
        Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
        return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, updateViewState.m(), false, false, null, null, null, false, null, -268435457, 15, null);
    }

    private final void M0(LockScreenDTO lockScreenDTO, LockViewState lockViewState, Function1 function1) {
        String string;
        StrictModeOption strictModeOptionJ = lockScreenDTO.j();
        if (lockScreenDTO.n()) {
            string = this.f105775b.getString(R.string.ee);
        } else if (lockScreenDTO.m()) {
            string = this.f105775b.getString(R.string.tj);
        } else if (strictModeOptionJ != null) {
            Context context = this.f105775b;
            int i3 = R.string.ai;
            String strC = lockScreenDTO.c();
            if (strC == null) {
                strC = lockViewState.d();
            }
            string = context.getString(i3, strC);
        } else {
            string = null;
        }
        function1.invoke(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void N0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockScreenDTO r11, kotlin.jvm.functions.Function2 r12) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.N0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO, kotlin.jvm.functions.Function2):void");
    }

    private final void O0(LockScreenDTO lockScreenDTO, Function4 function4, Function0 function0) {
        int length;
        boolean z2;
        String strReplace;
        String strReplace2;
        String string;
        try {
            PackageManager packageManager = LockieApplication.g().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(lockScreenDTO.e(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (applicationInfo != null) {
                int iN0 = 0;
                if (lockScreenDTO.c() != null) {
                    string = String.valueOf(lockScreenDTO.c());
                    length = string.length();
                } else {
                    if (lockScreenDTO.k() != null) {
                        String domain = lockScreenDTO.k().getDomain();
                        String url = lockScreenDTO.k().getUrl();
                        String strB = lockScreenDTO.b();
                        if (strB != null && StringsKt.a0(domain, strB, false, 2, null)) {
                            int iN02 = StringsKt.n0(domain, strB, 0, false, 6, null);
                            length = strB.length();
                            z2 = false;
                            iN0 = iN02;
                        } else {
                            if (strB != null && StringsKt.a0(url, strB, false, 2, null)) {
                                try {
                                    int iN03 = StringsKt.n0(url, strB, 0, false, 6, null);
                                    strReplace = url.substring(domain.length(), iN03);
                                    Intrinsics.checkNotNullExpressionValue(strReplace, "substring(...)");
                                    strReplace2 = url.substring(iN03 + strB.length());
                                    Intrinsics.checkNotNullExpressionValue(strReplace2, "substring(...)");
                                    iN0 = 1;
                                } catch (StringIndexOutOfBoundsException e3) {
                                    e3.printStackTrace();
                                    CrashHelper.j(new IllegalArgumentException("Blocking for url with non-matching resolved domain. Keyword: " + strB + ", domain: " + domain + ", url: " + url, e3));
                                    List listS0 = StringsKt.S0(url, new String[]{strB}, true, 2);
                                    strReplace = (String) listS0.get(0);
                                    strReplace2 = listS0.size() > 1 ? (String) listS0.get(1) : "";
                                }
                                if (strReplace.length() > 10) {
                                    strReplace = new Regex("(.{4}).*(.{3})").replace(strReplace, "$1…$2");
                                }
                                if (strReplace2.length() > 6) {
                                    strReplace2 = new Regex("(.{3}).*").replace(strReplace2, "$1…");
                                }
                                String str = (iN0 != 0 ? domain : "") + strReplace + strB + strReplace2 + "\n";
                                iN0 = StringsKt.n0(str, strB, 0, false, 6, null);
                                length = strB.length();
                                z2 = true;
                                string = str;
                                String string2 = this.f105775b.getString(R.string.Kt, string);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                function4.invoke(string2, Integer.valueOf(iN0), Integer.valueOf(iN0 + length), Boolean.valueOf(z2));
                            }
                            length = domain.length();
                            z2 = false;
                        }
                        string = domain;
                        String string22 = this.f105775b.getString(R.string.Kt, string);
                        Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                        function4.invoke(string22, Integer.valueOf(iN0), Integer.valueOf(iN0 + length), Boolean.valueOf(z2));
                    }
                    string = packageManager.getApplicationLabel(applicationInfo).toString();
                    length = string.length();
                }
                z2 = false;
                String string222 = this.f105775b.getString(R.string.Kt, string);
                Intrinsics.checkNotNullExpressionValue(string222, "getString(...)");
                function4.invoke(string222, Integer.valueOf(iN0), Integer.valueOf(iN0 + length), Boolean.valueOf(z2));
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        Job job = this.B;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.B = null;
        V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LockScreenProviderV2.R0((LockViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState R0(LockViewState updateViewState) {
        Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
        return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -100663297, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconCache S() {
        return new AppIconCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object T(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$applyStoredLocale$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$applyStoredLocale$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$applyStoredLocale$1) r0
            int r1 = r0.f105816c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105816c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$applyStoredLocale$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$applyStoredLocale$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f105814a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105816c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L29
            goto L47
        L29:
            r5 = move-exception
            goto L73
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r5 = r4.q0()     // Catch: java.lang.Exception -> L29
            kotlinx.coroutines.flow.Flow r5 = r5.o0()     // Catch: java.lang.Exception -> L29
            r0.f105816c = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L47
            return r1
        L47:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L29
            int r0 = r5.length()     // Catch: java.lang.Exception -> L29
            if (r0 <= 0) goto L76
            java.util.Locale r5 = java.util.Locale.forLanguageTag(r5)     // Catch: java.lang.Exception -> L29
            android.content.res.Configuration r0 = new android.content.res.Configuration     // Catch: java.lang.Exception -> L29
            android.content.Context r1 = r4.f105775b     // Catch: java.lang.Exception -> L29
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L29
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Exception -> L29
            r0.<init>(r1)     // Catch: java.lang.Exception -> L29
            r0.setLocale(r5)     // Catch: java.lang.Exception -> L29
            android.content.Context r5 = r4.f105775b     // Catch: java.lang.Exception -> L29
            android.content.Context r5 = r5.createConfigurationContext(r0)     // Catch: java.lang.Exception -> L29
            java.lang.String r0 = "createConfigurationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch: java.lang.Exception -> L29
            r4.f105775b = r5     // Catch: java.lang.Exception -> L29
            goto L76
        L73:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r5)
        L76:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.T(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(boolean z2) {
        if (!z2) {
            if (this.H) {
                Z();
                return;
            } else {
                U();
                return;
            }
        }
        if (this.A) {
            this.f105774a.a(true);
            a0();
        } else {
            try {
                RatingDialogActivity.f95979p.i(this.f105775b, false, RatingTriggerSource.LockScreen, new RatingDialogActivity.OnRatingDialogClosedListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.b
                    @Override // cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.OnRatingDialogClosedListener
                    public final void a(boolean z3) {
                        LockScreenProviderV2.U0(this.f105955a, z3);
                    }
                });
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(LockScreenProviderV2 lockScreenProviderV2, boolean z2) {
        lockScreenProviderV2.K0(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(Function1 function1) {
        synchronized (this.f105780h) {
            MutableStateFlow mutableStateFlow = this.f105780h;
            mutableStateFlow.setValue(function1.invoke(mutableStateFlow.getValue()));
            String str = "State updated -> " + this.f105780h.getValue();
            String simpleName = LockScreenProviderV2.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, str);
        }
    }

    private final void W() {
        CoroutinesHelperExtKt.d(new LockScreenProviderV2$closeAndFinishBlockingTest$1(this, null));
    }

    private final void Y() {
        LockProviderListener.g(this.f105774a, false, 1, null);
        this.f105774a.f(this.f105797y, DiscountSource.AUTOMATIC);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        LockProviderListener.g(this.f105774a, false, 1, null);
        this.f105774a.b();
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        if (this.C) {
            try {
                LockScreenBannerUtils.f127896d.k(this.f105775b, y0().J());
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
        }
        CoroutineScopeKt.e(this.f105776c, null, 1, null);
        CoroutineScopeKt.e(this.f105778f, null, 1, null);
        CoroutineScopeKt.e(this.f105777d, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b0(Context context) {
        return ContextCompat.getColor(context, R.color.f95455j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c0(LockScreenProviderV2 lockScreenProviderV2) {
        return "#" + Integer.toHexString(lockScreenProviderV2.n0() & 16777215);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockScreenDTO r54, kotlin.coroutines.Continuation r55) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.d0(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Ref.ObjectRef objectRef, String name, int i3, int i4, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        objectRef.f140144a = LockViewState.b((LockViewState) objectRef.f140144a, null, name, i3, i4, z2, R.color.f95455j, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -63, 15, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(LockScreenProviderV2 lockScreenProviderV2) {
        lockScreenProviderV2.U();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(Ref.ObjectRef objectRef, LockScreenDTO lockScreenDTO, String profileTitle, String blockUntil) {
        Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
        Intrinsics.checkNotNullParameter(blockUntil, "blockUntil");
        objectRef.f140144a = LockViewState.b((LockViewState) objectRef.f140144a, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, profileTitle, blockUntil, String.valueOf(lockScreenDTO.d()), null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, (lockScreenDTO.g() == ProfileType.USAGE_LIMIT && lockScreenDTO.k() == null) ? lockScreenDTO.l() : null, false, null, -229377, 13, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Ref.ObjectRef objectRef, String str) {
        objectRef.f140144a = LockViewState.b((LockViewState) objectRef.f140144a, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, str, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -2097153, 15, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        BuildersKt__Builders_commonKt.d(this.f105778f, null, null, new LockScreenProviderV2$executeCampaignCountdown$1(this, null), 3, null);
    }

    private final AppIconCache k0() {
        return (AppIconCache) this.f105792t.getValue();
    }

    private final BlockSessionDao l0() {
        return (BlockSessionDao) this.f105781i.getValue();
    }

    private final int n0() {
        return ((Number) this.f105793u.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o0() {
        return (String) this.f105794v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore p0() {
        return (CoreDataStore) this.f105785m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore q0() {
        return (CoreMultiProcessDataStore) this.f105786n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomBlockingScreenConfigDao s0() {
        return (CustomBlockingScreenConfigDao) this.f105789q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeterminePremiumStateUseCase t0() {
        return (DeterminePremiumStateUseCase) this.f105790r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore u0() {
        return (DevDataStore) this.f105791s.getValue();
    }

    private final DiscountDataStore v0() {
        return (DiscountDataStore) this.f105788p.getValue();
    }

    private final DiscountRepository w0() {
        return (DiscountRepository) this.f105784l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaunchTimeDao x0() {
        return (LaunchTimeDao) this.f105782j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 y0() {
        return (PremiumRepositoryV2) this.f105779g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao z0() {
        return (ProfileDao) this.f105783k.getValue();
    }

    public final StateFlow B0() {
        return FlowKt.c(this.f105780h);
    }

    public final void D0(final String packageName, final UrlDto urlDto, final Long l3, final ProfileWithConfiguration profileWithConfiguration, final UsageLimit.PeriodType periodType, final String str, final StrictModeOption strictModeOption, final boolean z2, final boolean z3, final boolean z4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Log.d(LockScreenProviderV2.class.getName(), "LockScreenProvider init() invoked");
        BuildersKt__Builders_commonKt.d(this.f105776c, null, null, new LockScreenProviderV2$init$1(this, null), 3, null);
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.g
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                LockScreenProviderV2.F0(this.f105958a, profileWithConfiguration, urlDto, packageName, l3, periodType, str, strictModeOption, z2, z3, z4);
            }
        });
    }

    public final void E0(final String packageName, final Long l3, final ProfileType profileType, final String profileTitle, final UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.m
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                LockScreenProviderV2.G0(this.f105975a, packageName, l3, profileTitle, profileType, periodType);
            }
        });
    }

    public final boolean P0() {
        return this.f105798z;
    }

    public final void S0() {
        Log.d(LockScreenProviderV2.class.getName(), "tryToClose invoked");
        if (this.D) {
            W();
        } else if (this.G) {
            Y();
        } else {
            BuildersKt__Builders_commonKt.d(this.f105776c, null, null, new LockScreenProviderV2$tryToClose$1(this, null), 3, null);
        }
    }

    public final void U() {
        LockProviderListener.g(this.f105774a, false, 1, null);
        a0();
    }

    public final void V() {
        LockProviderListener.g(this.f105774a, false, 1, null);
        this.f105774a.c("lock_screen");
        a0();
    }

    public final void X() {
        LockProviderListener.g(this.f105774a, false, 1, null);
        this.f105774a.h(this.E, this.F, "lock_screen");
        a0();
    }

    public final Set j0() {
        return this.f105795w;
    }

    public final long m0() {
        return this.E;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f105799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UrlDto f105800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f105801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f105802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ProfileType f105803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final UsageLimit.PeriodType f105804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f105805g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f105806h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f105807i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f105808j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private StrictModeOption f105809k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f105810l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f105811m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f105812n;

        public LockScreenDTO(String packageName, UrlDto urlDto, Long l3, String profileTitle, ProfileType profileType, UsageLimit.PeriodType periodType, String str, String str2, boolean z2, String str3, StrictModeOption strictModeOption, boolean z3, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
            this.f105799a = packageName;
            this.f105800b = urlDto;
            this.f105801c = l3;
            this.f105802d = profileTitle;
            this.f105803e = profileType;
            this.f105804f = periodType;
            this.f105805g = str;
            this.f105806h = str2;
            this.f105807i = z2;
            this.f105808j = str3;
            this.f105809k = strictModeOption;
            this.f105810l = z3;
            this.f105811m = z4;
            this.f105812n = z5;
        }

        public final Long a() {
            return this.f105801c;
        }

        public final String b() {
            return this.f105805g;
        }

        public final String c() {
            return this.f105808j;
        }

        public final String d() {
            return this.f105806h;
        }

        public final String e() {
            return this.f105799a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LockScreenDTO)) {
                return false;
            }
            LockScreenDTO lockScreenDTO = (LockScreenDTO) obj;
            return Intrinsics.areEqual(this.f105799a, lockScreenDTO.f105799a) && Intrinsics.areEqual(this.f105800b, lockScreenDTO.f105800b) && Intrinsics.areEqual(this.f105801c, lockScreenDTO.f105801c) && Intrinsics.areEqual(this.f105802d, lockScreenDTO.f105802d) && this.f105803e == lockScreenDTO.f105803e && this.f105804f == lockScreenDTO.f105804f && Intrinsics.areEqual(this.f105805g, lockScreenDTO.f105805g) && Intrinsics.areEqual(this.f105806h, lockScreenDTO.f105806h) && this.f105807i == lockScreenDTO.f105807i && Intrinsics.areEqual(this.f105808j, lockScreenDTO.f105808j) && this.f105809k == lockScreenDTO.f105809k && this.f105810l == lockScreenDTO.f105810l && this.f105811m == lockScreenDTO.f105811m && this.f105812n == lockScreenDTO.f105812n;
        }

        public final String f() {
            return this.f105802d;
        }

        public final ProfileType g() {
            return this.f105803e;
        }

        public final boolean h() {
            return this.f105807i;
        }

        public int hashCode() {
            int iHashCode = this.f105799a.hashCode() * 31;
            UrlDto urlDto = this.f105800b;
            int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
            Long l3 = this.f105801c;
            int iHashCode3 = (((iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31) + this.f105802d.hashCode()) * 31;
            ProfileType profileType = this.f105803e;
            int iHashCode4 = (iHashCode3 + (profileType == null ? 0 : profileType.hashCode())) * 31;
            UsageLimit.PeriodType periodType = this.f105804f;
            int iHashCode5 = (iHashCode4 + (periodType == null ? 0 : periodType.hashCode())) * 31;
            String str = this.f105805g;
            int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f105806h;
            int iHashCode7 = (((iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.f105807i)) * 31;
            String str3 = this.f105808j;
            int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
            StrictModeOption strictModeOption = this.f105809k;
            return ((((((iHashCode8 + (strictModeOption != null ? strictModeOption.hashCode() : 0)) * 31) + Boolean.hashCode(this.f105810l)) * 31) + Boolean.hashCode(this.f105811m)) * 31) + Boolean.hashCode(this.f105812n);
        }

        public final boolean i() {
            return this.f105811m;
        }

        public final StrictModeOption j() {
            return this.f105809k;
        }

        public final UrlDto k() {
            return this.f105800b;
        }

        public final UsageLimit.PeriodType l() {
            return this.f105804f;
        }

        public final boolean m() {
            return this.f105812n;
        }

        public final boolean n() {
            return this.f105810l;
        }

        public final void o(String str) {
            this.f105806h = str;
        }

        public final void p(boolean z2) {
            this.f105807i = z2;
        }

        public String toString() {
            return "LockScreenDTO(packageName=" + this.f105799a + ", url=" + this.f105800b + ", blockUntil=" + this.f105801c + ", profileTitle=" + this.f105802d + ", profileType=" + this.f105803e + ", usageLimitPeriodType=" + this.f105804f + ", blockedKeyword=" + this.f105805g + ", explanationText=" + this.f105806h + ", showAvailableSettings=" + this.f105807i + ", customTitle=" + this.f105808j + ", strictModeOption=" + this.f105809k + ", isUnsupportedBrowser=" + this.f105810l + ", showUsageLimitRanOut=" + this.f105811m + ", isPopup=" + this.f105812n + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ LockScreenDTO(java.lang.String r19, cz.mobilesoft.coreblock.dto.UrlDto r20, java.lang.Long r21, java.lang.String r22, cz.mobilesoft.coreblock.enums.ProfileType r23, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType r24, java.lang.String r25, java.lang.String r26, boolean r27, java.lang.String r28, cz.mobilesoft.coreblock.enums.StrictModeOption r29, boolean r30, boolean r31, boolean r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
            /*
                r18 = this;
                r0 = r33
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L9
                r8 = r2
                goto Lb
            L9:
                r8 = r23
            Lb:
                r1 = r0 & 32
                if (r1 == 0) goto L11
                r9 = r2
                goto L13
            L11:
                r9 = r24
            L13:
                r1 = r0 & 64
                if (r1 == 0) goto L19
                r10 = r2
                goto L1b
            L19:
                r10 = r25
            L1b:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L21
                r11 = r2
                goto L23
            L21:
                r11 = r26
            L23:
                r1 = r0 & 256(0x100, float:3.59E-43)
                r3 = 0
                if (r1 == 0) goto L2a
                r12 = r3
                goto L2c
            L2a:
                r12 = r27
            L2c:
                r1 = r0 & 512(0x200, float:7.17E-43)
                if (r1 == 0) goto L32
                r13 = r2
                goto L34
            L32:
                r13 = r28
            L34:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L3a
                r14 = r2
                goto L3c
            L3a:
                r14 = r29
            L3c:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L42
                r15 = r3
                goto L44
            L42:
                r15 = r30
            L44:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L4b
                r16 = r3
                goto L4d
            L4b:
                r16 = r31
            L4d:
                r0 = r0 & 8192(0x2000, float:1.148E-41)
                if (r0 == 0) goto L5e
                r17 = r3
                r4 = r19
                r5 = r20
                r6 = r21
                r7 = r22
                r3 = r18
                goto L6a
            L5e:
                r17 = r32
                r3 = r18
                r4 = r19
                r5 = r20
                r6 = r21
                r7 = r22
            L6a:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.LockScreenDTO.<init>(java.lang.String, cz.mobilesoft.coreblock.dto.UrlDto, java.lang.Long, java.lang.String, cz.mobilesoft.coreblock.enums.ProfileType, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType, java.lang.String, java.lang.String, boolean, java.lang.String, cz.mobilesoft.coreblock.enums.StrictModeOption, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LockScreenProviderV2(Context context, boolean z2, LockProviderListener listener) {
        this(context, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.A = z2;
    }
}
