package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public final class WifiAvailableCheckJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f123510n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f123511o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f123512p = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123515m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            JobRequest jobRequestW = new JobRequest.Builder("WIFI_AVAILABLE").H(true).I().w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
        }

        public final void b() {
            JobRequest jobRequestW = new JobRequest.Builder("WIFI_AVAILABLE").A(60000L, 60001L).H(true).E(JobRequest.NetworkType.UNMETERED).F(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to fire as soon as unmetered network is available after 60000 ms");
        }

        public final void c() {
            JobRequest jobRequestW = new JobRequest.Builder("WIFI_CHANGED").A(60000L, 60001L).H(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to fire for WiFi change after 60000 ms");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WifiAvailableCheckJob() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123513k = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123514l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123515m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob$special$$inlined$inject$default$3
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore D() {
        return (EventDataStore) this.f123515m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao E() {
        return (ProfileDao) this.f123513k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiNetworkDao F() {
        return (WifiNetworkDao) this.f123514l.getValue();
    }

    public static final void G() {
        f123510n.a();
    }

    public static final void H() {
        f123510n.b();
    }

    public static final void I() {
        f123510n.c();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt__BuildersKt.b(null, new WifiAvailableCheckJob$onRunJob$1(this, Intrinsics.areEqual(params.d(), "WIFI_CHANGED"), null), 1, null);
        return Job.Result.SUCCESS;
    }
}
