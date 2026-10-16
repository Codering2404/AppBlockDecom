package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.util.Log;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;
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
public final class NetworkStateChangedReceiver extends BroadcastReceiver implements KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f123659g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f123660h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f123661i = NetworkStateChangedReceiver.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f123662j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f123663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f123664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static NetworkStateChangedReceiver f123665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f123666n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f123667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f123668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f123669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123670d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f123671f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final StreakActivityTracker b() {
            return (StreakActivityTracker) KoinJavaComponent.c(StreakActivityTracker.class, null, null, 6, null);
        }

        public static /* synthetic */ Object e(Companion companion, WifiNetworkDao wifiNetworkDao, ProfileDao profileDao, String str, boolean z2, EventDataStore eventDataStore, Continuation continuation, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i3 & 8) != 0) {
                z2 = false;
            }
            return companion.d(wifiNetworkDao, profileDao, str2, z2, eventDataStore, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(android.content.Context r13, cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao r14, cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r15, cz.mobilesoft.coreblock.storage.datastore.EventDataStore r16, kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
            /*
                r12 = this;
                r0 = r17
                boolean r1 = r0 instanceof cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$Companion$checkLocationServicesAndDeactivate$1
                if (r1 == 0) goto L16
                r1 = r0
                cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$Companion$checkLocationServicesAndDeactivate$1 r1 = (cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$Companion$checkLocationServicesAndDeactivate$1) r1
                int r2 = r1.f123679i
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L16
                int r2 = r2 - r3
                r1.f123679i = r2
            L14:
                r8 = r1
                goto L1c
            L16:
                cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$Companion$checkLocationServicesAndDeactivate$1 r1 = new cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$Companion$checkLocationServicesAndDeactivate$1
                r1.<init>(r12, r0)
                goto L14
            L1c:
                java.lang.Object r0 = r8.f123677g
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r8.f123679i
                r11 = 1
                if (r2 == 0) goto L49
                if (r2 != r11) goto L41
                java.lang.Object r13 = r8.f123676f
                android.location.LocationManager r13 = (android.location.LocationManager) r13
                java.lang.Object r13 = r8.f123675d
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r13 = (cz.mobilesoft.coreblock.storage.datastore.EventDataStore) r13
                java.lang.Object r13 = r8.f123674c
                cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r13 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r13
                java.lang.Object r13 = r8.f123673b
                cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao r13 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao) r13
                java.lang.Object r13 = r8.f123672a
                android.content.Context r13 = (android.content.Context) r13
                kotlin.ResultKt.b(r0)
                goto L94
            L41:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L49:
                kotlin.ResultKt.b(r0)
                java.lang.String r0 = "location"
                java.lang.Object r0 = r13.getSystemService(r0)
                android.location.LocationManager r0 = (android.location.LocationManager) r0
                if (r0 == 0) goto L63
                boolean r2 = cz.mobilesoft.coreblock.util.permissions.PermissionHelperExtKt.b(r0, r13)
                if (r2 != 0) goto L5d
                goto L63
            L5d:
                r13 = 0
                java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r13)
                return r13
            L63:
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
                r8.f123672a = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
                r8.f123673b = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
                r8.f123674c = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r16)
                r8.f123675d = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                r8.f123676f = r13
                r8.f123679i = r11
                r5 = 0
                r6 = 0
                r9 = 12
                r10 = 0
                r2 = r12
                r3 = r14
                r4 = r15
                r7 = r16
                java.lang.Object r13 = e(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r13 != r1) goto L94
                return r1
            L94:
                java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r11)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.Companion.a(android.content.Context, cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao, cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao, cz.mobilesoft.coreblock.storage.datastore.EventDataStore, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (NetworkStateChangedReceiver.f123666n) {
                Log.d(NetworkStateChangedReceiver.f123661i, "NetworkStateChangedReceiver already registered, skipping…");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            NetworkStateChangedReceiver networkStateChangedReceiver = new NetworkStateChangedReceiver();
            networkStateChangedReceiver.f123667a = true;
            NetworkStateChangedReceiver.f123665m = networkStateChangedReceiver;
            context.registerReceiver(NetworkStateChangedReceiver.f123665m, intentFilter);
            NetworkStateChangedReceiver.f123666n = true;
            Log.d(NetworkStateChangedReceiver.f123661i, "NetworkStateChangedReceiver registered");
        }

        /* JADX WARN: Code restructure failed: missing block: B:103:0x03dd, code lost:
        
            if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.n(r1, 0, r3, 1, null) == r10) goto L104;
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0397  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x016f A[LOOP:3: B:33:0x0169->B:35:0x016f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01a4  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01c0 A[LOOP:2: B:41:0x01ba->B:43:0x01c0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x026a  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x027b  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x02b5  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0304  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0317  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0357  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x035b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object d(cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao r27, cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r28, java.lang.String r29, boolean r30, cz.mobilesoft.coreblock.storage.datastore.EventDataStore r31, kotlin.coroutines.Continuation r32) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1028
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.Companion.d(cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao, cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao, java.lang.String, boolean, cz.mobilesoft.coreblock.storage.datastore.EventDataStore, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!NetworkStateChangedReceiver.f123666n || NetworkStateChangedReceiver.f123665m == null) {
                return;
            }
            try {
                try {
                    context.unregisterReceiver(NetworkStateChangedReceiver.f123665m);
                } catch (IllegalArgumentException e3) {
                    Log.w(NetworkStateChangedReceiver.f123661i, "Receiver was not registered or already unregistered", e3);
                }
                Log.d(NetworkStateChangedReceiver.f123661i, "NetworkStateChangedReceiver unregistered");
            } finally {
                NetworkStateChangedReceiver.f123665m = null;
                NetworkStateChangedReceiver.f123666n = false;
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkStateChangedReceiver() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123668b = LazyKt.a(lazyThreadSafetyModeB, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123669c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123670d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr4, objArr5);
            }
        });
        this.f123671f = CoroutinesHelperExtKt.a(Dispatchers.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(Context context, Continuation continuation) throws Throwable {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return Unit.f139807a;
        }
        String ssid = wifiManager.getConnectionInfo().getSSID();
        if (!Intrinsics.areEqual(ssid, f123662j)) {
            Intrinsics.checkNotNull(ssid);
            f123662j = ssid;
            Object objD = f123659g.d(u(), t(), ssid, this.f123667a, s(), continuation);
            return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
        }
        Log.d(f123661i, "SSID " + ssid + " already registered, skipping...");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore s() {
        return (EventDataStore) this.f123670d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao t() {
        return (ProfileDao) this.f123669c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiNetworkDao u() {
        return (WifiNetworkDao) this.f123668b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(NetworkStateChangedReceiver networkStateChangedReceiver, Intent intent, Context context) {
        BuildersKt__Builders_commonKt.d(networkStateChangedReceiver.f123671f, null, null, new NetworkStateChangedReceiver$onReceive$1$1(intent, context, networkStateChangedReceiver, null), 3, null);
    }

    public static final void w(Context context) {
        f123659g.c(context);
    }

    public static final void x(Context context) {
        f123659g.f(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.service.receiver.c
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                NetworkStateChangedReceiver.v(this.f123783a, intent, context);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
