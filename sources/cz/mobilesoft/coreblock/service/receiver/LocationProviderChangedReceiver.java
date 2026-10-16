package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
public final class LocationProviderChangedReceiver extends BroadcastReceiver implements KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f123612g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f123613h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f123614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f123615j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f123616a = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f123617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f123618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123619d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123620f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return LocationProviderChangedReceiver.f123615j;
        }

        public final LocationProviderChangedReceiver b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            LocationProviderChangedReceiver locationProviderChangedReceiver = new LocationProviderChangedReceiver();
            context.registerReceiver(locationProviderChangedReceiver, intentFilter);
            return locationProviderChangedReceiver;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocationProviderChangedReceiver() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123617b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123618c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123619d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$special$$inlined$inject$default$3
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
        this.f123620f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr6, objArr7);
            }
        });
        f123615j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore k() {
        return (CoreMultiProcessDataStore) this.f123617b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore l() {
        return (EventDataStore) this.f123620f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeoAddressDao m() {
        return (GeoAddressDao) this.f123618c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao n() {
        return (ProfileDao) this.f123619d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Context context, LocationProviderChangedReceiver locationProviderChangedReceiver) {
        Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        BuildersKt__Builders_commonKt.d(locationProviderChangedReceiver.f123616a, null, null, new LocationProviderChangedReceiver$onReceive$1$1(locationProviderChangedReceiver, (LocationManager) systemService, applicationContext, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
    
        if (r7.t(r6, r2, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(android.content.Context r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$recreateGeofencesIfNecessary$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$recreateGeofencesIfNecessary$1 r0 = (cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$recreateGeofencesIfNecessary$1) r0
            int r1 = r0.f123630d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123630d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$recreateGeofencesIfNecessary$1 r0 = new cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$recreateGeofencesIfNecessary$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f123628b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123630d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f123627a
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.b(r7)
            goto L74
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f123627a
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.b(r7)
            goto L56
        L40:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = r5.k()
            kotlinx.coroutines.flow.Flow r7 = r7.k0()
            r0.f123627a = r6
            r0.f123630d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L56
            goto L73
        L56:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L77
            cz.mobilesoft.coreblock.util.location.GeofenceHelper r7 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.f128735a
            cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback r2 = new cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback
            r2.<init>()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f123627a = r4
            r0.f123630d = r3
            java.lang.Object r6 = r7.t(r6, r2, r0)
            if (r6 != r1) goto L74
        L73:
            return r1
        L74:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L77:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver.p(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Context context) {
        BuildersKt__Builders_commonKt.d(this.f123616a, null, null, new LocationProviderChangedReceiver$scheduleLocationCheckRetry$1(context, this, null), 3, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.location.PROVIDERS_CHANGED")) {
            InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.service.receiver.b
                @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
                public final void onInitialized() {
                    LocationProviderChangedReceiver.o(context, this);
                }
            });
        }
    }

    public final void r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.unregisterReceiver(this);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
