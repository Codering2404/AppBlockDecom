package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import android.content.Context;
import cz.mobilesoft.coreblock.repository.BackupsRepository;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.SubAppRepository;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
public final class RestoreProfilesUseCase extends SuspendUseCase<Params, BackupsRepository.BackupRestoreSuccessDTO> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f106758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106761d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f106764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f106765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f106766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f106767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f106768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f106769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f106770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f106771o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f106772a;

        public Params(List list) {
            this.f106772a = list;
        }

        public final List a() {
            return this.f106772a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f106772a, ((Params) obj).f106772a);
        }

        public int hashCode() {
            List list = this.f106772a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "Params(profiles=" + this.f106772a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RestoreProfilesUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f106758a = context;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106759b = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$1
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
        this.f106760c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f106761d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f106762f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f106763g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f106764h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<BlockingDatabase>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockingDatabase.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f106765i = LazyKt.a(lazyThreadSafetyModeB7, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f106766j = LazyKt.a(lazyThreadSafetyModeB8, new Function0<SubAppRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRelationDao.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f106767k = LazyKt.a(lazyThreadSafetyModeB9, new Function0<SubAppRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRepository.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f106768l = LazyKt.a(lazyThreadSafetyModeB10, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f106769m = LazyKt.a(lazyThreadSafetyModeB11, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f106770n = LazyKt.a(lazyThreadSafetyModeB12, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.f106771o = LazyKt.a(lazyThreadSafetyModeB13, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr24, objArr25);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile A(cz.mobilesoft.coreblock.scene.more.backup.dto.ProfileDTO r32) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase.A(cz.mobilesoft.coreblock.scene.more.backup.dto.ProfileDTO):cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile");
    }

    private final ApplicationDao l() {
        return (ApplicationDao) this.f106760c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationProfileRelationDao m() {
        return (ApplicationProfileRelationDao) this.f106765i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(Continuation continuation) {
        return r().s0(false, true, continuation);
    }

    private final BlockingDatabase o() {
        return (BlockingDatabase) this.f106764h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GeoAddressDao p() {
        return (GeoAddressDao) this.f106761d.getValue();
    }

    private final JobHelperKtx q() {
        return (JobHelperKtx) this.f106771o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao r() {
        return (ProfileDao) this.f106759b.getValue();
    }

    private final QuickBlockDataStore s() {
        return (QuickBlockDataStore) this.f106769m.getValue();
    }

    private final QuickBlockRepository t() {
        return (QuickBlockRepository) this.f106770n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubAppRelationDao u() {
        return (SubAppRelationDao) this.f106766j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubAppRepository v() {
        return (SubAppRepository) this.f106767k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao w() {
        return (UsageLimitDao) this.f106763g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebsiteProfileRelationDao x() {
        return (WebsiteProfileRelationDao) this.f106768l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WifiNetworkDao y() {
        return (WifiNetworkDao) this.f106762f.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0386 A[PHI: r2 r3 r4 r5
      0x0386: PHI (r2v48 java.lang.Throwable) = (r2v45 java.lang.Throwable), (r2v50 java.lang.Throwable) binds: [B:101:0x0383, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x0386: PHI (r3v48 java.util.List) = (r3v45 java.util.List), (r3v52 java.util.List) binds: [B:101:0x0383, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x0386: PHI (r4v39 java.util.List) = (r4v36 java.util.List), (r4v42 java.util.List) binds: [B:101:0x0383, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x0386: PHI (r5v42 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params) = 
      (r5v39 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
      (r5v45 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
     binds: [B:101:0x0383, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f5 A[LOOP:0: B:63:0x01ef->B:65:0x01f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027c A[PHI: r2 r3 r4 r5
      0x027c: PHI (r2v26 java.lang.Object) = (r2v24 java.lang.Object), (r2v27 java.lang.Object) binds: [B:75:0x0278, B:22:0x00c5] A[DONT_GENERATE, DONT_INLINE]
      0x027c: PHI (r3v27 java.util.List) = (r3v24 java.util.List), (r3v31 java.util.List) binds: [B:75:0x0278, B:22:0x00c5] A[DONT_GENERATE, DONT_INLINE]
      0x027c: PHI (r4v25 java.util.List) = (r4v22 java.util.List), (r4v28 java.util.List) binds: [B:75:0x0278, B:22:0x00c5] A[DONT_GENERATE, DONT_INLINE]
      0x027c: PHI (r5v28 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params) = 
      (r5v25 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
      (r5v31 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
     binds: [B:75:0x0278, B:22:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0308 A[PHI: r2 r3 r4 r5
      0x0308: PHI (r2v32 java.lang.Throwable) = (r2v29 java.lang.Throwable), (r2v36 java.lang.Throwable) binds: [B:89:0x0304, B:18:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0308: PHI (r3v41 java.util.List) = (r3v38 java.util.List), (r3v44 java.util.List) binds: [B:89:0x0304, B:18:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0308: PHI (r4v32 java.util.List) = (r4v29 java.util.List), (r4v35 java.util.List) binds: [B:89:0x0304, B:18:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0308: PHI (r5v35 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params) = 
      (r5v32 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
      (r5v38 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params)
     binds: [B:89:0x0304, B:18:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0337 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object z(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase.Params r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instruction units count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase.z(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
