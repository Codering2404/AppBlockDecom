package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakAvailability;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.usecase.SyncEmailConsentUseCase;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.coreblock.util.trialconversion.TrialConversionCoordinator;
import cz.mobilesoft.nativecore.NativeLib;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class AppInitWorker extends CoroutineWorker implements KoinComponent {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f123793t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f123794u = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123795d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f123797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f123798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f123799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f123800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f123804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f123805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f123806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f123807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f123808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f123809s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(AppInitWorker.class).i(new Constraints.Builder().a())).b();
            WorkManager workManagerH = WorkManager.h(context);
            Intrinsics.checkNotNullExpressionValue(workManagerH, "getInstance(...)");
            workManagerH.f("INIT_APPLICATION", ExistingWorkPolicy.KEEP, oneTimeWorkRequest);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppWebsiteCategoryDao A() {
        return (AppWebsiteCategoryDao) this.f123801k.getValue();
    }

    private final Profile B() {
        Profile profile = new Profile(0L, null, 0, 0, 0, 0, false, false, false, false, false, 0L, 0L, 0L, 0L, null, null, null, false, false, false, 0, null, 8388607, null);
        profile.c0(DayFlags.Companion.a());
        profile.Y(true);
        profile.Z(true);
        profile.s0(ProfileType.QUICK_BLOCK);
        profile.d0(ScheduleEmoji.NoIcon);
        return profile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrowserViewIdDao C() {
        return (BrowserViewIdDao) this.f123795d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobHelperKtx D() {
        return (JobHelperKtx) this.f123802l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 E() {
        return (PremiumRepositoryV2) this.f123805o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao F() {
        return (ProfileDao) this.f123798h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockDataStore G() {
        return (QuickBlockDataStore) this.f123797g.getValue();
    }

    private final QuickBlockRepository H() {
        return (QuickBlockRepository) this.f123803m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String I(Context context) {
        try {
            NativeLib nativeLib = (NativeLib) (this instanceof KoinScopeComponent ? ((KoinScopeComponent) this).getScope() : r0().j().d()).e(Reflection.b(NativeLib.class), null, null);
            String[] strArrK = InitHelper.f129486a.k(context);
            if (strArrK != null) {
                return nativeLib.getRevenueCatApiKey(strArrK);
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore J() {
        return (StatisticsDataStore) this.f123799i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakActivityTracker K() {
        return (StreakActivityTracker) this.f123808r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakAvailability L() {
        return (StreakAvailability) this.f123809s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore M() {
        return (StreakStore) this.f123807q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore N() {
        return (StrictModeDataStore) this.f123796f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository O() {
        return (StrictModeRepository) this.f123800j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SyncEmailConsentUseCase P() {
        return (SyncEmailConsentUseCase) this.f123804n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialConversionCoordinator Q() {
        return (TrialConversionCoordinator) this.f123806p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        if (r9.n(r1, r4) == r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object R(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r9, android.content.Context r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.service.worker.AppInitWorker$initQuickBlockProfile$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$initQuickBlockProfile$1 r0 = (cz.mobilesoft.coreblock.service.worker.AppInitWorker$initQuickBlockProfile$1) r0
            int r1 = r0.f123826h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f123826h = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$initQuickBlockProfile$1 r0 = new cz.mobilesoft.coreblock.service.worker.AppInitWorker$initQuickBlockProfile$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.f123824f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f123826h
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L53
            if (r1 == r2) goto L46
            if (r1 != r7) goto L3e
            java.lang.Object r9 = r4.f123823d
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r9
            java.lang.Object r9 = r4.f123822c
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r4.f123821b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r9 = r4.f123820a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r9
            kotlin.ResultKt.b(r11)
            goto Lac
        L3e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L46:
            java.lang.Object r9 = r4.f123821b
            r10 = r9
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r9 = r4.f123820a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r9 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r9
            kotlin.ResultKt.b(r11)
            goto L6b
        L53:
            kotlin.ResultKt.b(r11)
            r11 = r2
            cz.mobilesoft.coreblock.enums.ProfileType r2 = cz.mobilesoft.coreblock.enums.ProfileType.QUICK_BLOCK
            r4.f123820a = r9
            r4.f123821b = r10
            r4.f123826h = r11
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            java.lang.Object r11 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.u0(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L6a
            goto Lab
        L6a:
            r9 = r1
        L6b:
            java.util.List r11 = (java.util.List) r11
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L79
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L79:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = r8.B()
            int r2 = cz.mobilesoft.coreblock.R.string.zD
            java.lang.String r2 = r10.getString(r2)
            java.lang.String r3 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.r0(r2)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r4.f123820a = r2
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r4.f123821b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r4.f123822c = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r4.f123823d = r10
            r4.f123826h = r7
            java.lang.Object r9 = r9.n(r1, r4)
            if (r9 != r0) goto Lac
        Lab:
            return r0
        Lac:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.AppInitWorker.R(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        if (r10.a(r9, r2, r0) != r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(android.content.Context r8, cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.service.worker.AppInitWorker$updateQuickBlockSetupFinishedState$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$updateQuickBlockSetupFinishedState$1 r0 = (cz.mobilesoft.coreblock.service.worker.AppInitWorker$updateQuickBlockSetupFinishedState$1) r0
            int r1 = r0.f123876f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123876f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$updateQuickBlockSetupFinishedState$1 r0 = new cz.mobilesoft.coreblock.service.worker.AppInitWorker$updateQuickBlockSetupFinishedState$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f123874c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123876f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L59
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.f123873b
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r8 = (cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore) r8
            java.lang.Object r8 = r0.f123872a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.b(r10)
            goto Lb5
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.f123873b
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r8 = (cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore) r8
            java.lang.Object r9 = r0.f123872a
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.b(r10)
            goto L99
        L4c:
            java.lang.Object r8 = r0.f123873b
            r9 = r8
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r9 = (cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore) r9
            java.lang.Object r8 = r0.f123872a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.b(r10)
            goto L6d
        L59:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.flow.Flow r10 = r9.F()
            r0.f123872a = r8
            r0.f123873b = r9
            r0.f123876f = r5
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r0)
            if (r10 != r1) goto L6d
            goto Lb4
        L6d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto Lb8
            cz.mobilesoft.coreblock.repository.QuickBlockRepository r10 = r7.H()
            java.util.ArrayList r10 = r10.u()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto Lb8
            r0.f123872a = r8
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f123873b = r10
            r0.f123876f = r4
            r10 = 0
            r2 = 0
            java.lang.Object r10 = cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore.K(r9, r10, r0, r5, r2)
            if (r10 != r1) goto L96
            goto Lb4
        L96:
            r6 = r9
            r9 = r8
            r8 = r6
        L99:
            cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver$Companion r10 = cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver.f134085h
            cz.mobilesoft.coreblock.service.worker.a r2 = new cz.mobilesoft.coreblock.service.worker.a
            r2.<init>()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f123872a = r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f123873b = r8
            r0.f123876f = r3
            java.lang.Object r8 = r10.a(r9, r2, r0)
            if (r8 != r1) goto Lb5
        Lb4:
            return r1
        Lb5:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        Lb8:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.AppInitWorker.S(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState T(AppBlockWidgetState updateWidget) {
        Intrinsics.checkNotNullParameter(updateWidget, "$this$updateWidget");
        return AppBlockWidgetState.e(updateWidget, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
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
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$1 r0 = (cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$1) r0
            int r1 = r0.f123812c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123812c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$1 r0 = new cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f123810a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123812c
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
            cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2 r2 = new cz.mobilesoft.coreblock.service.worker.AppInitWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.f123812c = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r2, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.work.ListenableWorker$Result r6 = (androidx.work.ListenableWorker.Result) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.AppInitWorker.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppInitWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, KqqtdetwHMIO.tHdFElKSSAZ);
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123795d = LazyKt.a(lazyThreadSafetyModeB, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BrowserViewIdDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123796f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123797g = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f123798h = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$4
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
        this.f123799i = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f123800j = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f123801k = LazyKt.a(lazyThreadSafetyModeB7, new Function0<AppWebsiteCategoryDao>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppWebsiteCategoryDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f123802l = LazyKt.a(lazyThreadSafetyModeB8, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f123803m = LazyKt.a(lazyThreadSafetyModeB9, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f123804n = LazyKt.a(lazyThreadSafetyModeB10, new Function0<SyncEmailConsentUseCase>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SyncEmailConsentUseCase.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f123805o = LazyKt.a(lazyThreadSafetyModeB11, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f123806p = LazyKt.a(lazyThreadSafetyModeB12, new Function0<TrialConversionCoordinator>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialConversionCoordinator.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.f123807q = LazyKt.a(lazyThreadSafetyModeB13, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.f123808r = LazyKt.a(lazyThreadSafetyModeB14, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        this.f123809s = LazyKt.a(lazyThreadSafetyModeB15, new Function0<StreakAvailability>() { // from class: cz.mobilesoft.coreblock.service.worker.AppInitWorker$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakAvailability.class), objArr28, objArr29);
            }
        });
    }
}
