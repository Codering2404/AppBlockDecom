package cz.mobilesoft.coreblock.usecase.lockservice;

import android.content.Context;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
public final class GetLockServiceRunReasonsUseCase extends SuspendUseCase<Params, Set<? extends LockServiceRunReason>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127539d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127540f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f127541a;

        public Params(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f127541a = context;
        }

        public final Context a() {
            return this.f127541a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f127541a, ((Params) obj).f127541a);
        }

        public int hashCode() {
            return this.f127541a.hashCode();
        }

        public String toString() {
            return "Params(context=" + this.f127541a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetLockServiceRunReasonsUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127536a = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$special$$inlined$inject$default$1
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
        this.f127537b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127538c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127539d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f127540f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<GetTimeNudgeAppsUseCase>() { // from class: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTimeNudgeAppsUseCase.class), objArr8, objArr9);
            }
        });
    }

    private final CoreMultiProcessDataStore c() {
        return (CoreMultiProcessDataStore) this.f127538c.getValue();
    }

    private final GetTimeNudgeAppsUseCase d() {
        return (GetTimeNudgeAppsUseCase) this.f127540f.getValue();
    }

    private final ProfileDao e() {
        return (ProfileDao) this.f127536a.getValue();
    }

    private final StatisticsDataStore f() {
        return (StatisticsDataStore) this.f127539d.getValue();
    }

    private final StrictModeRepository g() {
        return (StrictModeRepository) this.f127537b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r14 = this;
            boolean r0 = r15 instanceof cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$isBlockingNeeded$1
            if (r0 == 0) goto L14
            r0 = r15
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$isBlockingNeeded$1 r0 = (cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$isBlockingNeeded$1) r0
            int r1 = r0.f127549c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f127549c = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$isBlockingNeeded$1 r0 = new cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$isBlockingNeeded$1
            r0.<init>(r14, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r9.f127547a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f127549c
            r12 = 2
            r13 = 1
            if (r1 == 0) goto L3a
            if (r1 == r13) goto L36
            if (r1 != r12) goto L2e
            kotlin.ResultKt.b(r15)
            return r15
        L2e:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L36:
            kotlin.ResultKt.b(r15)
            goto L57
        L3a:
            kotlin.ResultKt.b(r15)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = r14.e()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r13)
            r9.f127549c = r13
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 126(0x7e, float:1.77E-43)
            r11 = 0
            java.lang.Object r15 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.M(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r15 != r0) goto L57
            goto L6f
        L57:
            java.lang.Number r15 = (java.lang.Number) r15
            long r1 = r15.longValue()
            r3 = 0
            int r15 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r15 > 0) goto L71
            cz.mobilesoft.coreblock.repository.StrictModeRepository r15 = r14.g()
            r9.f127549c = r12
            java.lang.Object r15 = r15.o(r9)
            if (r15 != r0) goto L70
        L6f:
            return r0
        L70:
            return r15
        L71:
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.a(r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fa, code lost:
    
        if (r10 == r1) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(android.content.Context r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.j(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h(cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.Params r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$invoke$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$invoke$1) r0
            int r1 = r0.f127546f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127546f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$invoke$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f127544c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127546f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f127543b
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r0 = r0.f127542a
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$Params r0 = (cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.Params) r0
            kotlin.ResultKt.b(r8)
            goto L83
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.f127543b
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r2 = r0.f127542a
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$Params r2 = (cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.Params) r2
            kotlin.ResultKt.b(r8)
            goto L61
        L48:
            kotlin.ResultKt.b(r8)
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r0.f127542a = r7
            r0.f127543b = r8
            r0.f127546f = r4
            java.lang.Object r2 = r6.i(r0)
            if (r2 != r1) goto L5d
            goto L82
        L5d:
            r5 = r2
            r2 = r7
            r7 = r8
            r8 = r5
        L61:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L6e
            cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason r8 = cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason.BLOCKING
            r7.add(r8)
        L6e:
            android.content.Context r8 = r2.a()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f127542a = r2
            r0.f127543b = r7
            r0.f127546f = r3
            java.lang.Object r8 = r6.j(r8, r0)
            if (r8 != r1) goto L83
        L82:
            return r1
        L83:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L90
            cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason r8 = cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason.TIME_NUDGE
            r7.add(r8)
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.h(cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
