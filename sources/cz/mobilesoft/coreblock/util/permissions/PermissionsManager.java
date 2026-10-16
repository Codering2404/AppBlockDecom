package cz.mobilesoft.coreblock.util.permissions;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionsManager implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PermissionsManager f129021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CoroutineScope f129022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f129023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f129024d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f129025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f129026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f129027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f129028i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f129029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f129030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f129031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Lazy f129032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f129033n;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final PermissionsManager permissionsManager = new PermissionsManager();
        f129021a = permissionsManager;
        f129022b = CoroutinesHelperExtKt.a(Dispatchers.b());
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129023c = LazyKt.a(lazyThreadSafetyModeB, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f129024d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f129025f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f129026g = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        f129027h = LazyKt.a(lazyThreadSafetyModeB5, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        f129028i = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        f129029j = LazyKt.a(lazyThreadSafetyModeB7, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        f129030k = LazyKt.a(lazyThreadSafetyModeB8, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        f129031l = LazyKt.a(lazyThreadSafetyModeB9, new Function0<SubAppRelationDao>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRelationDao.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        f129032m = LazyKt.a(lazyThreadSafetyModeB10, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionsManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr18, objArr19);
            }
        });
        f129033n = 8;
    }

    private PermissionsManager() {
    }

    private final WebsiteProfileRelationDao A() {
        return (WebsiteProfileRelationDao) f129030k.getValue();
    }

    private final void E(Function1 function1) {
        BuildersKt__Builders_commonKt.d(f129022b, null, null, new PermissionsManager$launch$1(function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
    
        if (r0 == r3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[PHI: r4
      0x0125: PHI (r4v10 int) = (r4v7 int), (r4v11 int) binds: [B:39:0x00d1, B:55:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(boolean r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.g(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(boolean r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.h(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ApplicationProfileRelationDao i() {
        return (ApplicationProfileRelationDao) f129029j.getValue();
    }

    private final CoreDataStore j() {
        return (CoreDataStore) f129024d.getValue();
    }

    private final JobHelperKtx k() {
        return (JobHelperKtx) f129023c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao t() {
        return (ProfileDao) f129032m.getValue();
    }

    private final Object u(Profile profile, boolean z2, boolean z3, boolean z4, Continuation continuation) {
        return v(profile.l(), profile.m(), z2, z3, z4, profile.k(), profile.E(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, int r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.v(boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final StatisticsDataStore w() {
        return (StatisticsDataStore) f129025f.getValue();
    }

    private final StrictModeDataStore x() {
        return (StrictModeDataStore) f129026g.getValue();
    }

    private final StrictModeRepository y() {
        return (StrictModeRepository) f129028i.getValue();
    }

    private final SubAppRelationDao z() {
        return (SubAppRelationDao) f129031l.getValue();
    }

    public final boolean B() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public final boolean C(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!B()) {
            return true;
        }
        Object systemService = context.getSystemService("alarm");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        return ((AlarmManager) systemService).canScheduleExactAlarms();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.util.permissions.PermissionsManager$isAlarmExactPermissionNeeded$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$isAlarmExactPermissionNeeded$1 r0 = (cz.mobilesoft.coreblock.util.permissions.PermissionsManager$isAlarmExactPermissionNeeded$1) r0
            int r1 = r0.f129170f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129170f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$isAlarmExactPermissionNeeded$1 r0 = new cz.mobilesoft.coreblock.util.permissions.PermissionsManager$isAlarmExactPermissionNeeded$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f129168c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129170f
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L47
            if (r2 == r6) goto L43
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            boolean r1 = r0.f129167b
            int r0 = r0.f129166a
            kotlin.ResultKt.b(r13)
            goto La1
        L35:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L3d:
            int r2 = r0.f129166a
            kotlin.ResultKt.b(r13)
            goto L83
        L43:
            kotlin.ResultKt.b(r13)
            goto L62
        L47:
            kotlin.ResultKt.b(r13)
            boolean r13 = r12.B()
            if (r13 != 0) goto L55
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        L55:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r13 = r12.t()
            r0.f129170f = r6
            java.lang.Object r13 = r13.O(r0)
            if (r13 != r1) goto L62
            goto L9d
        L62:
            java.lang.Number r13 = (java.lang.Number) r13
            long r7 = r13.longValue()
            r9 = 0
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 <= 0) goto L70
            r13 = r6
            goto L71
        L70:
            r13 = r5
        L71:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = r12.t()
            r0.f129166a = r13
            r0.f129170f = r4
            java.lang.Object r2 = r2.h1(r0)
            if (r2 != r1) goto L80
            goto L9d
        L80:
            r11 = r2
            r2 = r13
            r13 = r11
        L83:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r4 = r12.x()
            kotlinx.coroutines.flow.Flow r4 = r4.t0()
            r0.f129166a = r2
            r0.f129167b = r13
            r0.f129170f = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r4, r0)
            if (r0 != r1) goto L9e
        L9d:
            return r1
        L9e:
            r1 = r13
            r13 = r0
            r0 = r2
        La1:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r0 != 0) goto Lad
            if (r1 != 0) goto Lad
            if (r13 != 0) goto Lae
        Lad:
            r5 = r6
        Lae:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.D(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (r6 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.permissions.PermissionsManager$onAlarmExactPermissionGranted$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$onAlarmExactPermissionGranted$1 r0 = (cz.mobilesoft.coreblock.util.permissions.PermissionsManager$onAlarmExactPermissionGranted$1) r0
            int r1 = r0.f129182c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129182c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$onAlarmExactPermissionGranted$1 r0 = new cz.mobilesoft.coreblock.util.permissions.PermissionsManager$onAlarmExactPermissionGranted$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f129180a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129182c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L69
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L4c
        L38:
            kotlin.ResultKt.b(r6)
            r6 = 0
            cz.mobilesoft.coreblock.util.runnability.JobHelper.M(r6)
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r6 = r5.k()
            r0.f129182c = r4
            java.lang.Object r6 = r6.p(r0)
            if (r6 != r1) goto L4c
            goto L68
        L4c:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.A()
            cz.mobilesoft.coreblock.util.runnability.JobHelper.m()
            cz.mobilesoft.coreblock.util.runnability.JobHelper.t()
            cz.mobilesoft.coreblock.util.runnability.JobHelper.C()
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r6 = r5.w()
            kotlinx.coroutines.flow.Flow r6 = r6.a0()
            r0.f129182c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L69
        L68:
            return r1
        L69:
            java.lang.String r6 = (java.lang.String) r6
            cz.mobilesoft.coreblock.util.runnability.JobHelper.u(r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.F(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void G(Context context, Function1 onShouldShow) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(onShouldShow, "onShouldShow");
        E(new PermissionsManager$shouldShowAccessibilityIssuesDialog$1(context, onShouldShow, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(cz.mobilesoft.coreblock.enums.Permission r5, boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldSkip$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldSkip$1 r0 = (cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldSkip$1) r0
            int r1 = r0.f129194f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129194f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldSkip$1 r0 = new cz.mobilesoft.coreblock.util.permissions.PermissionsManager$shouldSkip$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f129192c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129194f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f129190a
            cz.mobilesoft.coreblock.enums.Permission r5 = (cz.mobilesoft.coreblock.enums.Permission) r5
            kotlin.ResultKt.b(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f129190a = r7
            r0.f129191b = r6
            r0.f129194f = r3
            java.lang.Object r7 = r4.r(r5, r6, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO r7 = (cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO) r7
            boolean r5 = r7.a()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.H(cz.mobilesoft.coreblock.enums.Permission, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0504, code lost:
    
        if (r0 == r1) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x07dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x07f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0877 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x094d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x099a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x09c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x09d9  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x09e3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0a29  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0a36  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0a50  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0a5d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0a67  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a94  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0aa4  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0aba  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0ae3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0ae8  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0ba3  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0bde  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0c0f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0c1e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0c25 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0c27 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0c43 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0c51  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0c56 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0c5c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0d1a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0d1d  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0d84 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0d90  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0d95  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0e42  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0e44  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0e4b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:368:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x06db A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v62 */
    /* JADX WARN: Type inference failed for: r13v63 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r13v65 */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v67 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v13, types: [int] */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v17, types: [int] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v21, types: [int] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v62 */
    /* JADX WARN: Type inference failed for: r7v63 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v25, types: [int] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28, types: [int] */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v49 */
    /* JADX WARN: Type inference failed for: r9v51 */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v57 */
    /* JADX WARN: Type inference failed for: r9v58, types: [int] */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Type inference failed for: r9v68 */
    /* JADX WARN: Type inference failed for: r9v69 */
    /* JADX WARN: Type inference failed for: r9v70 */
    /* JADX WARN: Type inference failed for: r9v71 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(boolean r72, android.content.Context r73, boolean r74, boolean r75, kotlin.coroutines.Continuation r76) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.l(boolean, android.content.Context, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x014c -> B:14:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(int r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.m(int, boolean, boolean, boolean, boolean, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
    
        if (r3 == r1) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [int] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x01fc -> B:81:0x01fe). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.n(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(java.util.List r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r15 instanceof cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getMissingPermissionsForProfile$5
            if (r0 == 0) goto L14
            r0 = r15
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getMissingPermissionsForProfile$5 r0 = (cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getMissingPermissionsForProfile$5) r0
            int r1 = r0.f129123m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f129123m = r1
        L12:
            r15 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getMissingPermissionsForProfile$5 r0 = new cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getMissingPermissionsForProfile$5
            r0.<init>(r6, r15)
            goto L12
        L1a:
            java.lang.Object r0 = r15.f129121k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r15.f129123m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r15.f129113b
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r15.f129112a
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.b(r0)
            goto L90
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.b(r0)
            r0 = r7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            int r2 = kotlin.collections.MapsKt.mapCapacity(r2)
            r4 = 16
            int r2 = kotlin.ranges.RangesKt.f(r2, r4)
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L5a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r0.next()
            r5 = r2
            cz.mobilesoft.coreblock.util.permissions.PermissionDTO r5 = (cz.mobilesoft.coreblock.util.permissions.PermissionDTO) r5
            cz.mobilesoft.coreblock.enums.Permission r5 = r5.e()
            r4.put(r5, r2)
            goto L5a
        L6f:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r15.f129112a = r7
            r15.f129113b = r4
            r15.f129114c = r8
            r15.f129115d = r9
            r15.f129116f = r10
            r15.f129117g = r11
            r15.f129118h = r12
            r15.f129119i = r13
            r15.f129120j = r14
            r15.f129123m = r3
            r7 = r6
            java.lang.Object r0 = r7.v(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r0 != r1) goto L8f
            return r1
        L8f:
            r7 = r4
        L90:
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r9 = r0.iterator()
        L9d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lb1
            java.lang.Object r10 = r9.next()
            cz.mobilesoft.coreblock.enums.Permission r10 = (cz.mobilesoft.coreblock.enums.Permission) r10
            java.lang.Object r10 = r7.get(r10)
            r8.add(r10)
            goto L9d
        Lb1:
            java.util.List r7 = kotlin.collections.CollectionsKt.filterNotNull(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.o(java.util.List, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x014b, code lost:
    
        if (r15 == r0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r13, android.content.Context r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.p(cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b6, code lost:
    
        if (r0 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, android.content.Context r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.q(boolean, boolean, boolean, boolean, boolean, boolean, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object r(Permission permission, boolean z2, Continuation continuation) {
        return permission instanceof Permission.ACCESSIBILITY ? g(z2, continuation) : s(permission, z2, continuation);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0398, code lost:
    
        if (r1 == r4) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0293, code lost:
    
        if (r3 == r4) goto L146;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02dc A[PHI: r1
      0x02dc: PHI (r1v40 int) = (r1v5 int), (r1v41 int) binds: [B:113:0x02db, B:111:0x02d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0146 A[PHI: r1
      0x0146: PHI (r1v39 int) = (r1v18 int), (r1v27 int), (r1v29 int), (r1v35 int), (r1v37 int), (r1v40 int) binds: [B:36:0x0141, B:56:0x01b1, B:69:0x01f4, B:96:0x027c, B:101:0x029f, B:115:0x02e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027e  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(cz.mobilesoft.coreblock.enums.Permission r18, boolean r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager.s(cz.mobilesoft.coreblock.enums.Permission, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
