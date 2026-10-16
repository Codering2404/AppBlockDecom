package cz.mobilesoft.coreblock.util;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class AdultContentDownloadWorker extends CoroutineWorker implements KoinComponent {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f127702i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f127703j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f127704k = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AdultContentDownloadWorker.z();
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f127705l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AdultContentDownloadWorker.k();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127706d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f127708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f127709h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MutableStateFlow d() {
            return (MutableStateFlow) AdultContentDownloadWorker.f127705l.getValue();
        }

        public final Operation b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            Operation operationB = workManagerH.b("ADULT_CONTENT_SYNC");
            Intrinsics.checkNotNullExpressionValue(operationB, "cancelUniqueWork(...)");
            return operationB;
        }

        public final StateFlow c() {
            return (StateFlow) AdultContentDownloadWorker.f127704k.getValue();
        }

        public final LiveData e(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(AdultContentDownloadWorker.class).i(new Constraints.Builder().b(NetworkType.CONNECTED).a())).b();
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            workManagerH.f("ADULT_CONTENT_SYNC", ExistingWorkPolicy.KEEP, oneTimeWorkRequest);
            LiveData liveDataI = workManagerH.i(oneTimeWorkRequest.a());
            Intrinsics.checkNotNullExpressionValue(liveDataI, "getWorkInfoByIdLiveData(...)");
            return liveDataI;
        }

        public final LiveData f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Constraints constraintsA = new Constraints.Builder().b(NetworkType.CONNECTED).a();
            TimeUnit timeUnit = TimeUnit.DAYS;
            PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(AdultContentDownloadWorker.class, 1L, timeUnit).k(1L, timeUnit)).i(constraintsA)).b();
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            workManagerH.e("ADULT_CONTENT_PERIODIC_SYNC", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest);
            LiveData liveDataI = workManagerH.i(periodicWorkRequest.a());
            Intrinsics.checkNotNullExpressionValue(liveDataI, "getWorkInfoByIdLiveData(...)");
            return liveDataI;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static abstract class DownloadResult {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Failure extends DownloadResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Failure f127712a = new Failure();

            private Failure() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Failure);
            }

            public int hashCode() {
                return -1612452983;
            }

            public String toString() {
                return "Failure";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Success extends DownloadResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f127713a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List f127714b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final List f127715c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final long f127716d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(List websitesToInsert, List websitesToDelete, List whitelistedWebsites, long j3) {
                super(null);
                Intrinsics.checkNotNullParameter(websitesToInsert, "websitesToInsert");
                Intrinsics.checkNotNullParameter(websitesToDelete, "websitesToDelete");
                Intrinsics.checkNotNullParameter(whitelistedWebsites, "whitelistedWebsites");
                this.f127713a = websitesToInsert;
                this.f127714b = websitesToDelete;
                this.f127715c = whitelistedWebsites;
                this.f127716d = j3;
            }

            public final long a() {
                return this.f127716d;
            }

            public final List b() {
                return this.f127714b;
            }

            public final List c() {
                return this.f127713a;
            }

            public final List d() {
                return this.f127715c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.f127713a, success.f127713a) && Intrinsics.areEqual(this.f127714b, success.f127714b) && Intrinsics.areEqual(this.f127715c, success.f127715c) && this.f127716d == success.f127716d;
            }

            public int hashCode() {
                return (((((this.f127713a.hashCode() * 31) + this.f127714b.hashCode()) * 31) + this.f127715c.hashCode()) * 31) + Long.hashCode(this.f127716d);
            }

            public String toString() {
                return "Success(websitesToInsert=" + this.f127713a + ", websitesToDelete=" + this.f127714b + ", whitelistedWebsites=" + this.f127715c + ", newLastUpdateTime=" + this.f127716d + ")";
            }
        }

        public /* synthetic */ DownloadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DownloadResult() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdultContentDownloadWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127706d = LazyKt.a(lazyThreadSafetyModeB, new Function0<BlockingDatabase>() { // from class: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockingDatabase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127707f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<AdultContentWebsiteDao>() { // from class: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AdultContentWebsiteDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127708g = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127709h = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$special$$inlined$inject$default$4
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MutableStateFlow k() {
        return StateFlowKt.a(new AdultContentSyncState(null, 0.0f, 3, 0 == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01b6, code lost:
    
        if (r0 == r3) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d3 -> B:23:0x00d6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01b6 -> B:41:0x01b9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(long r20, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.s(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(long r28, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.t(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdultContentWebsiteDao u() {
        return (AdultContentWebsiteDao) this.f127707f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockingDatabase v() {
        return (BlockingDatabase) this.f127706d.getValue();
    }

    private final CoreDataStore w() {
        return (CoreDataStore) this.f127708g.getValue();
    }

    private final ProfileDao x() {
        return (ProfileDao) this.f127709h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(50, r1) == r2) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00bb -> B:26:0x00be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(java.util.List r15, java.util.List r16, java.util.List r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.y(java.util.List, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow z() {
        return FlowKt.c(f127702i.d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01be, code lost:
    
        if (r0.b0(r2) != r3) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7 A[Catch: CancellationException -> 0x005b, PHI: r0 r11
      0x00a7: PHI (r0v19 java.lang.Object) = (r0v18 java.lang.Object), (r0v1 java.lang.Object) binds: [B:32:0x00a3, B:24:0x006b] A[DONT_GENERATE, DONT_INLINE]
      0x00a7: PHI (r11v1 long) = (r11v0 long), (r11v2 long) binds: [B:32:0x00a3, B:24:0x006b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {CancellationException -> 0x005b, blocks: (B:16:0x0056, B:50:0x0145, B:21:0x0064, B:45:0x0124, B:47:0x012e, B:24:0x006b, B:34:0x00a7, B:36:0x00e5, B:38:0x00f9, B:40:0x0101, B:42:0x0109, B:25:0x006f, B:31:0x0095, B:28:0x0076), top: B:66:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5 A[Catch: CancellationException -> 0x005b, TryCatch #0 {CancellationException -> 0x005b, blocks: (B:16:0x0056, B:50:0x0145, B:21:0x0064, B:45:0x0124, B:47:0x012e, B:24:0x006b, B:34:0x00a7, B:36:0x00e5, B:38:0x00f9, B:40:0x0101, B:42:0x0109, B:25:0x006f, B:31:0x0095, B:28:0x0076), top: B:66:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f9 A[Catch: CancellationException -> 0x005b, TryCatch #0 {CancellationException -> 0x005b, blocks: (B:16:0x0056, B:50:0x0145, B:21:0x0064, B:45:0x0124, B:47:0x012e, B:24:0x006b, B:34:0x00a7, B:36:0x00e5, B:38:0x00f9, B:40:0x0101, B:42:0x0109, B:25:0x006f, B:31:0x0095, B:28:0x0076), top: B:66:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012e A[Catch: CancellationException -> 0x005b, TryCatch #0 {CancellationException -> 0x005b, blocks: (B:16:0x0056, B:50:0x0145, B:21:0x0064, B:45:0x0124, B:47:0x012e, B:24:0x006b, B:34:0x00a7, B:36:0x00e5, B:38:0x00f9, B:40:0x0101, B:42:0x0109, B:25:0x006f, B:31:0x0095, B:28:0x0076), top: B:66:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AdultContentSyncState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewModelState f127710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f127711b;

        public AdultContentSyncState(ViewModelState state, float f3) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.f127710a = state;
            this.f127711b = f3;
        }

        public static /* synthetic */ AdultContentSyncState b(AdultContentSyncState adultContentSyncState, ViewModelState viewModelState, float f3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                viewModelState = adultContentSyncState.f127710a;
            }
            if ((i3 & 2) != 0) {
                f3 = adultContentSyncState.f127711b;
            }
            return adultContentSyncState.a(viewModelState, f3);
        }

        public final AdultContentSyncState a(ViewModelState state, float f3) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new AdultContentSyncState(state, f3);
        }

        public final float c() {
            return this.f127711b;
        }

        public final ViewModelState d() {
            return this.f127710a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdultContentSyncState)) {
                return false;
            }
            AdultContentSyncState adultContentSyncState = (AdultContentSyncState) obj;
            return Intrinsics.areEqual(this.f127710a, adultContentSyncState.f127710a) && Float.compare(this.f127711b, adultContentSyncState.f127711b) == 0;
        }

        public int hashCode() {
            return (this.f127710a.hashCode() * 31) + Float.hashCode(this.f127711b);
        }

        public String toString() {
            return "AdultContentSyncState(state=" + this.f127710a + ", progress=" + this.f127711b + ")";
        }

        public /* synthetic */ AdultContentSyncState(ViewModelState viewModelState, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? Canceled.f127782a : viewModelState, (i3 & 2) != 0 ? 0.0f : f3);
        }
    }
}
