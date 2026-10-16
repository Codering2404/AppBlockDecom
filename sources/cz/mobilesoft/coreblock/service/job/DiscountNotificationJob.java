package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
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
public final class DiscountNotificationJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f123237n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f123238o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Mutex f123239p = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123242m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(long r10, long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob.Companion.b(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void c() {
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, null, null, new DiscountNotificationJob$Companion$schedule$1(null), 3, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscountNotificationJob() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123240k = LazyKt.a(lazyThreadSafetyModeB, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123241l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123242m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr4, objArr5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore C() {
        return (DiscountDataStore) this.f123240k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountRepository D() {
        return (DiscountRepository) this.f123242m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 E() {
        return (PremiumRepositoryV2) this.f123241l.getValue();
    }

    public final void F(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (BuildConfig.f95357b.booleanValue()) {
            String simpleName = DiscountNotificationJob.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, message);
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt.e(CoroutinesHelperExtKt.b(), new DiscountNotificationJob$onRunJob$1(this, null));
        return Job.Result.SUCCESS;
    }
}
