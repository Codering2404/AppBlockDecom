package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.google.android.gms.tasks.Task;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
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
public final class ServerSyncWorker extends CoroutineWorker implements KoinComponent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f123944h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f123945i = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123946d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f123948g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ServerSyncWorker.class).i(new Constraints.Builder().b(NetworkType.CONNECTED).a())).b();
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            workManagerH.f("SERVER_SYNC", ExistingWorkPolicy.KEEP, oneTimeWorkRequest);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServerSyncWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123946d = LazyKt.a(lazyThreadSafetyModeB, new Function0<TokenFCMRepository>() { // from class: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TokenFCMRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123947f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$special$$inlined$inject$default$2
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
        this.f123948g = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr4, objArr5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 n() {
        return (PremiumRepositoryV2) this.f123947f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TokenFCMRepository o() {
        return (TokenFCMRepository) this.f123946d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$initFCMToken$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$initFCMToken$1 r0 = (cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$initFCMToken$1) r0
            int r1 = r0.f123956c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123956c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$initFCMToken$1 r0 = new cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$initFCMToken$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f123954a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123956c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.repository.TokenFCMRepository r5 = r4.o()
            r0.f123956c = r3
            java.lang.Object r5 = r5.f(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            com.google.firebase.messaging.FirebaseMessaging r5 = com.google.firebase.messaging.FirebaseMessaging.n()
            com.google.android.gms.tasks.Task r5 = r5.q()
            cz.mobilesoft.coreblock.service.worker.c r0 = new cz.mobilesoft.coreblock.service.worker.c
            r0.<init>()
            r5.addOnCompleteListener(r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ServerSyncWorker serverSyncWorker, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            String simpleName = ServerSyncWorker.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.w(simpleName, "Fetching FCM registration token failed", task.getException());
        } else {
            String str = (String) task.getResult();
            if (str != null) {
                CoroutineScope applicationScope = LockieApplication.f95365k;
                Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
                BuildersKt__Builders_commonKt.d(applicationScope, null, null, new ServerSyncWorker$initFCMToken$2$1$1(serverSyncWorker, str, null), 3, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$1 r0 = (cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$1) r0
            int r1 = r0.f123951c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123951c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$1 r0 = new cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f123949a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123951c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L57
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            java.lang.Boolean r6 = cz.mobilesoft.coreblock.BuildConfig.f95356a
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L44
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.c()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            return r6
        L44:
            kotlinx.coroutines.CoroutineExceptionHandler r6 = cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.b()
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$2 r2 = new cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.f123951c = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r2, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.work.ListenableWorker$Result r6 = (androidx.work.ListenableWorker.Result) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DiscountDataStore m() {
        return (DiscountDataStore) this.f123948g.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
