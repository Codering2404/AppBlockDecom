package cz.mobilesoft.coreblock.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.entity.IntroPremiumScreenType;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.util.BaseRemoteConfig;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
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
public final class RemoteConfig extends BaseRemoteConfig implements KoinComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RemoteConfig f97054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97055d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f97058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f97059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f97060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f97061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f97062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Lazy f97063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Lazy f97064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Lazy f97065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Lazy f97066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f97067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Mutex f97068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Map f97069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f97070t;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RemoteConfigProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FirebaseRemoteConfig f97071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f97072b;

        public RemoteConfigProvider(FirebaseRemoteConfig remoteConfig) {
            Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
            this.f97071a = remoteConfig;
        }

        public final boolean a(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Boolean bool = BuildConfig.f95357b;
            if (bool != null) {
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null) {
                    String str = (String) c().get(key);
                    Boolean boolValueOf = str != null ? Boolean.valueOf(Boolean.parseBoolean(str)) : null;
                    if (boolValueOf != null) {
                        return boolValueOf.booleanValue();
                    }
                }
            }
            return this.f97071a.k(key);
        }

        public final long b(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Boolean bool = BuildConfig.f95357b;
            if (bool != null) {
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null) {
                    String str = (String) c().get(key);
                    Long lValueOf = str != null ? Long.valueOf(Long.parseLong(str)) : null;
                    if (lValueOf != null) {
                        return lValueOf.longValue();
                    }
                }
            }
            return this.f97071a.o(key);
        }

        public final Map c() {
            Map map = this.f97072b;
            if (map != null) {
                return map;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mockValues");
            return null;
        }

        public final String d(String key) {
            String str;
            Intrinsics.checkNotNullParameter(key, "key");
            Boolean bool = BuildConfig.f95357b;
            if (bool != null) {
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null && (str = (String) c().get(key)) != null) {
                    return str;
                }
            }
            String strQ = this.f97071a.q(key);
            Intrinsics.checkNotNullExpressionValue(strQ, "getString(...)");
            return strQ;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object e(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r5 instanceof cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider$initFromDevDataStore$1
                if (r0 == 0) goto L13
                r0 = r5
                cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider$initFromDevDataStore$1 r0 = (cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider$initFromDevDataStore$1) r0
                int r1 = r0.f97075c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f97075c = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider$initFromDevDataStore$1 r0 = new cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider$initFromDevDataStore$1
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.f97073a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f97075c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r5)
                goto L4f
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L31:
                kotlin.ResultKt.b(r5)
                java.lang.Boolean r5 = cz.mobilesoft.coreblock.BuildConfig.f95357b
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L5a
                cz.mobilesoft.coreblock.model.RemoteConfig r5 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c
                cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r5 = cz.mobilesoft.coreblock.model.RemoteConfig.c(r5)
                kotlinx.coroutines.flow.Flow r5 = r5.I0()
                r0.f97075c = r3
                java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
                if (r5 != r1) goto L4f
                return r1
            L4f:
                java.lang.String r5 = (java.lang.String) r5
                cz.mobilesoft.coreblock.model.RemoteConfig r0 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c
                java.util.Map r5 = r0.D(r5)
                r4.f(r5)
            L5a:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider.e(kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void f(Map map) {
            Intrinsics.checkNotNullParameter(map, MHoiDDglUlPJC.VGl);
            this.f97072b = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final RemoteConfig remoteConfig = new RemoteConfig();
        f97054c = remoteConfig;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = null == true ? 1 : 0;
        f97055d = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = null == true ? 1 : 0;
        final Object[] objArr3 = null == true ? 1 : 0;
        f97056f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = null == true ? 1 : 0;
        final Object[] objArr5 = null == true ? 1 : 0;
        f97057g = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = null == true ? 1 : 0;
        final Object[] objArr7 = null == true ? 1 : 0;
        f97058h = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = null == true ? 1 : 0;
        final Object[] objArr9 = null == true ? 1 : 0;
        f97059i = LazyKt.a(lazyThreadSafetyModeB5, new Function0<InAppUpdatesDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InAppUpdatesDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = null == true ? 1 : 0;
        final Object[] objArr11 = null == true ? 1 : 0;
        f97060j = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = null == true ? 1 : 0;
        final Object[] objArr13 = null == true ? 1 : 0;
        f97061k = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = null == true ? 1 : 0;
        final Object[] objArr15 = null == true ? 1 : 0;
        f97062l = LazyKt.a(lazyThreadSafetyModeB8, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = null == true ? 1 : 0;
        final Object[] objArr17 = null == true ? 1 : 0;
        f97063m = LazyKt.a(lazyThreadSafetyModeB9, new Function0<PaywallDataStore>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PaywallDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = null == true ? 1 : 0;
        final Object[] objArr19 = null == true ? 1 : 0;
        f97064n = LazyKt.a(lazyThreadSafetyModeB10, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BrowserViewIdDao.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = null == true ? 1 : 0;
        final Object[] objArr21 = null == true ? 1 : 0;
        f97065o = LazyKt.a(lazyThreadSafetyModeB11, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = null == true ? 1 : 0;
        final Object[] objArr23 = null == true ? 1 : 0;
        f97066p = LazyKt.a(lazyThreadSafetyModeB12, new Function0<AppWebsiteCategoryDao>() { // from class: cz.mobilesoft.coreblock.model.RemoteConfig$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = remoteConfig;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppWebsiteCategoryDao.class), objArr22, objArr23);
            }
        });
        f97068r = MutexKt.b(false, 1, null);
        f97069s = MapsKt.mapOf(TuplesKt.a("intro_premium_screen_type", IntroPremiumScreenType.TrialWithCloseButton.getId()), TuplesKt.a("rate_dialog_max_weekly_report_shows", 3), TuplesKt.a("rate_dialog_loved_it_retry_after_days", 7), TuplesKt.a("rate_dialog_loved_it_max_retries", 2), TuplesKt.a("android_time_nudge_default_enabled", Boolean.FALSE));
        f97070t = 8;
    }

    private RemoteConfig() {
    }

    public static /* synthetic */ void B(RemoteConfig remoteConfig, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        remoteConfig.A(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #1 {all -> 0x003f, Exception -> 0x0042, blocks: (B:13:0x003a, B:37:0x00d9, B:38:0x00db, B:40:0x00e1, B:43:0x00e9, B:47:0x00f7, B:44:0x00ec, B:26:0x007c, B:28:0x0080, B:30:0x008d, B:32:0x009e, B:33:0x00b4, B:31:0x0096), top: B:52:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #1 {all -> 0x003f, Exception -> 0x0042, blocks: (B:13:0x003a, B:37:0x00d9, B:38:0x00db, B:40:0x00e1, B:43:0x00e9, B:47:0x00f7, B:44:0x00ec, B:26:0x007c, B:28:0x0080, B:30:0x008d, B:32:0x009e, B:33:0x00b4, B:31:0x0096), top: B:52:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.C(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7428 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x2faa  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x2fe8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x3187  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x31db  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x3329  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x3444  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x3549  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x364d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x3751  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x385e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x3967  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x3a6a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x3b6d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x3c70  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x3d87  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x3dca  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x3f1e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x4046  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x4144  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x4240  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x433c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x4442  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x4541  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x4645  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x4749  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x4843  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x4937  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x4a2b  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x4b1f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x4c13  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x4d0f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x4e0d  */
    /* JADX WARN: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x27cf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x28d6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x29d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x2ac6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x2bbe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x2cb5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x2dab  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x2eaf  */
    /* JADX WARN: Type inference failed for: r0v1211, types: [cz.mobilesoft.coreblock.storage.datastore.CoreDataStore] */
    /* JADX WARN: Type inference failed for: r1v414, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r670, kotlin.coroutines.Continuation r671) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 20300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.E(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
    
        if (r4.D0(r8, r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.model.RemoteConfig$saveDailyInsightsNotificationTime$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.model.RemoteConfig$saveDailyInsightsNotificationTime$1 r0 = (cz.mobilesoft.coreblock.model.RemoteConfig$saveDailyInsightsNotificationTime$1) r0
            int r1 = r0.f97135g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97135g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.model.RemoteConfig$saveDailyInsightsNotificationTime$1 r0 = new cz.mobilesoft.coreblock.model.RemoteConfig$saveDailyInsightsNotificationTime$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f97133d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97135g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.f97132c
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.f97131b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r0.f97130a
            cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider r0 = (cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider) r0
            kotlin.ResultKt.b(r9)
            goto La3
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.f97131b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f97130a
            cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider r2 = (cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider) r2
            kotlin.ResultKt.b(r9)
            goto L7a
        L4c:
            kotlin.ResultKt.b(r9)
            java.lang.String r9 = "ios_insights_reminder_time"
            java.lang.String r9 = r8.d(r9)
            java.lang.CharSequence r9 = kotlin.text.StringsKt.t1(r9)
            java.lang.String r9 = r9.toString()
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r2 = r7.z()
            kotlinx.coroutines.flow.Flow r2 = r2.a0()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f97130a = r5
            r0.f97131b = r9
            r0.f97135g = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L76
            goto La2
        L76:
            r6 = r2
            r2 = r8
            r8 = r9
            r9 = r6
        L7a:
            java.lang.String r9 = (java.lang.String) r9
            boolean r4 = kotlin.text.StringsKt.p0(r8)
            if (r4 != 0) goto La6
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r8)
            if (r4 != 0) goto La6
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r4 = r7.z()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f97130a = r2
            r0.f97131b = r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f97132c = r9
            r0.f97135g = r3
            java.lang.Object r9 = r4.D0(r8, r0)
            if (r9 != r1) goto La3
        La2:
            return r1
        La3:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.u(r8)
        La6:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.F(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x07ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0862  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0953  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r32, kotlin.coroutines.Continuation r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.G(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0207, code lost:
    
        if (F(r5, r0) != r1) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00af A[PHI: r9
      0x00af: PHI (r9v16 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v13 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v23 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:40:0x0127, B:17:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7 A[PHI: r9
      0x00f7: PHI (r9v4 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v1 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v6 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:28:0x00f3, B:22:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104 A[PHI: r9
      0x0104: PHI (r9v7 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v4 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v9 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:31:0x0100, B:21:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111 A[PHI: r9
      0x0111: PHI (r9v10 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v7 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v12 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:34:0x010d, B:20:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e A[PHI: r9
      0x011e: PHI (r9v13 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v10 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v15 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:37:0x011a, B:19:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b5 A[PHI: r2 r3 r4 r5 r9
      0x01b5: PHI (r2v8 java.lang.String) = (r2v5 java.lang.String), (r2v10 java.lang.String) binds: [B:53:0x01b2, B:14:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r3v7 java.lang.String) = (r3v4 java.lang.String), (r3v9 java.lang.String) binds: [B:53:0x01b2, B:14:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r4v7 java.lang.String) = (r4v4 java.lang.String), (r4v9 java.lang.String) binds: [B:53:0x01b2, B:14:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r5v7 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r5v4 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r5v9 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:53:0x01b2, B:14:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x01b5: PHI (r9v30 java.lang.String) = (r9v27 java.lang.String), (r9v32 java.lang.String) binds: [B:53:0x01b2, B:14:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e1 A[PHI: r2 r3 r4 r5 r9
      0x01e1: PHI (r2v11 java.lang.String) = (r2v8 java.lang.String), (r2v13 java.lang.String) binds: [B:56:0x01de, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r3v10 java.lang.String) = (r3v7 java.lang.String), (r3v12 java.lang.String) binds: [B:56:0x01de, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r4v10 java.lang.String) = (r4v7 java.lang.String), (r4v12 java.lang.String) binds: [B:56:0x01de, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r5v10 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r5v7 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r5v12 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:56:0x01de, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r9v33 java.lang.String) = (r9v30 java.lang.String), (r9v38 java.lang.String) binds: [B:56:0x01de, B:13:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.H(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object I(RemoteConfigProvider remoteConfigProvider, Map map, Continuation continuation) {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"android_sw_paywall_for_onboarding", "discount_show_for_hours", "discount_1_again_after_days", "discount_3_after_interval", "discount_earliest_hours", "scheduled_discount_notification_settings", "discount_show_for_first_year_text", "show_discount_after_first_expire", "discount_enable_trial_retention", "android_discount_enable_exit_paywall", "android_discount_enable_exit_paywall_hard_paywall", "premium_trial_disabled", "android_trial_upsell_configuration", "android_offer_trial_end_calendar", "trial_conversion_guard_enabled", "android_auto_trial_variant", "android_intro_trial_toggle_screen_type", "android_referral_enabled", "android_referral_success_count", "referral_link", "intro_premium_screen_type", "premium_offer_selection_type", "show_yearly_payment_monthly", "android_show_yearly_upgrade_banner", "hide_purchase_disclaimer", "android_onboarding_meta_hard_paywall", "android_use_subscription_onboarding", "android_renewal_retention_screen_type", "premium_screen_button_text", "premium_screen_button_text_trial", "premium_discount_button_text", "premium_hint_button_text", "premium_button_color", "show_subscription_expired_notifications"});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(obj, remoteConfigProvider.d((String) obj));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap2.put(BaseRemoteConfig.a((String) entry.getKey()), entry.getValue());
        }
        Map mapPlus = MapsKt.plus(linkedHashMap, linkedHashMap2);
        PaywallDataStore paywallDataStoreX = x();
        Json.Default r2 = Json.f142959d;
        r2.a();
        StringSerializer stringSerializer = StringSerializer.f142891a;
        Object objE = paywallDataStoreX.E(r2.b(new LinkedHashMapSerializer(BuiltinSerializersKt.u(stringSerializer), stringSerializer), mapPlus), continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ec, code lost:
    
        if (r13.G0(r12, r2) == r4) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0173, code lost:
    
        if (r1.X0(r0, r2) != r4) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0152 A[PHI: r0 r5 r6 r8 r9
      0x0152: PHI (r0v4 boolean) = (r0v3 boolean), (r0v10 boolean) binds: [B:33:0x014f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r5v5 boolean) = (r5v4 boolean), (r5v9 boolean) binds: [B:33:0x014f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r6v7 java.lang.String) = (r6v6 java.lang.String), (r6v12 java.lang.String) binds: [B:33:0x014f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r8v6 java.lang.String) = (r8v5 java.lang.String), (r8v9 java.lang.String) binds: [B:33:0x014f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0152: PHI (r9v3 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider) = 
      (r9v2 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
      (r9v8 cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider)
     binds: [B:33:0x014f, B:17:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.J(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012f, code lost:
    
        if (I(r4, r12, r0) == r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object K(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.K(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r37, kotlin.coroutines.Continuation r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.L(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x082c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M(cz.mobilesoft.coreblock.model.RemoteConfig.RemoteConfigProvider r40, kotlin.coroutines.Continuation r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.M(cz.mobilesoft.coreblock.model.RemoteConfig$RemoteConfigProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01e2, code lost:
    
        if (r0.K4(r13, r1) != r3) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r4v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x020a -> B:65:0x020e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0215 -> B:67:0x0217). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(boolean r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig.n(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AppWebsiteCategoryDao o() {
        return (AppWebsiteCategoryDao) f97066p.getValue();
    }

    private final BrowserViewIdDao p() {
        return (BrowserViewIdDao) f97064n.getValue();
    }

    private final CoreDataStore q() {
        return (CoreDataStore) f97056f.getValue();
    }

    private final CoreMultiProcessDataStore r() {
        return (CoreMultiProcessDataStore) f97061k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore s() {
        return (DevDataStore) f97060j.getValue();
    }

    private final DiscountDataStore t() {
        return (DiscountDataStore) f97058h.getValue();
    }

    private final EventDataStore u() {
        return (EventDataStore) f97062l.getValue();
    }

    private final IgnoredStatisticsItemDao v() {
        return (IgnoredStatisticsItemDao) f97065o.getValue();
    }

    private final InAppUpdatesDataStore w() {
        return (InAppUpdatesDataStore) f97059i.getValue();
    }

    private final PaywallDataStore x() {
        return (PaywallDataStore) f97063m.getValue();
    }

    private final RatingDataStore y() {
        return (RatingDataStore) f97055d.getValue();
    }

    private final StatisticsDataStore z() {
        return (StatisticsDataStore) f97057g.getValue();
    }

    public final void A(boolean z2) {
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new RemoteConfig$initAndFetch$1(z2, null), 3, null);
    }

    public final Map D(String valuesString) {
        Intrinsics.checkNotNullParameter(valuesString, "valuesString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = StringsKt.V0(valuesString, new String[]{";"}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            List listV0 = StringsKt.V0((String) it.next(), new String[]{"="}, false, 2, 2, null);
            if (listV0.size() == 2) {
                linkedHashMap.put(StringsKt.t1((String) listV0.get(0)).toString(), StringsKt.t1((String) listV0.get(1)).toString());
            }
        }
        return linkedHashMap;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
