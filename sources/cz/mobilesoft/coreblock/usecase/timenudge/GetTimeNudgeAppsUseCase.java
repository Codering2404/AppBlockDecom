package cz.mobilesoft.coreblock.usecase.timenudge;

import android.content.pm.PackageManager;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class GetTimeNudgeAppsUseCase extends SuspendUseCase<Params, Set<? extends String>> implements KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f127627g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f127628h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f127629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127632d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127633f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f127634a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return -1269041623;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetTimeNudgeAppsUseCase(Function1 isAppInstalled) {
        Intrinsics.checkNotNullParameter(isAppInstalled, "isAppInstalled");
        this.f127629a = isAppInstalled;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127630b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$special$$inlined$inject$default$1
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
        this.f127631c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$special$$inlined$inject$default$2
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
        this.f127632d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127633f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr6, objArr7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PackageManager packageManager = LockieApplication.g().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        return InitHelper.p(packageManager, packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b6, code lost:
    
        if (r10 == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ApplicationDao h() {
        return (ApplicationDao) this.f127632d.getValue();
    }

    private final CoreMultiProcessDataStore i() {
        return (CoreMultiProcessDataStore) this.f127630b.getValue();
    }

    private final IgnoredStatisticsItemDao j() {
        return (IgnoredStatisticsItemDao) this.f127633f.getValue();
    }

    private final ProfileDao k() {
        return (ProfileDao) this.f127631c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$1 r0 = (cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$1) r0
            int r1 = r0.f127648f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127648f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$1 r0 = new cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f127646c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127648f
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            long r1 = r0.f127644a
            java.lang.Object r0 = r0.f127645b
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.ResultKt.b(r10)
            r7 = r1
            goto L66
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L38:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r10 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r10.f()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r10 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r10 = r10.getTypeId()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            java.util.Set r10 = kotlin.collections.SetsKt.setOf(r10)
            java.util.Collection r10 = (java.util.Collection) r10
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r2 = r9.j()
            r0.f127645b = r10
            r0.f127644a = r4
            r0.f127648f = r3
            java.lang.Object r0 = r2.P(r0)
            if (r0 != r1) goto L62
            return r1
        L62:
            r7 = r0
            r0 = r10
            r10 = r7
            r7 = r4
        L66:
            r4 = r10
            java.util.List r4 = (java.util.List) r4
            r1 = 604800000(0x240c8400, double:2.988109026E-315)
            long r5 = r7 - r1
            r1 = 0
            r2 = 0
            r3 = 0
            java.util.List r10 = cz.mobilesoft.statistics.api.Statistics.i(r0, r1, r2, r3, r4, r5, r7)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$$inlined$sortedByDescending$1 r0 = new cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$mostUsedApps$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.List r10 = kotlin.collections.CollectionsKt.sortedWith(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            kotlin.sequences.Sequence r10 = kotlin.collections.CollectionsKt.asSequence(r10)
            cz.mobilesoft.coreblock.usecase.timenudge.b r0 = new cz.mobilesoft.coreblock.usecase.timenudge.b
            r0.<init>()
            kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.M(r10, r0)
            cz.mobilesoft.coreblock.usecase.timenudge.c r0 = new cz.mobilesoft.coreblock.usecase.timenudge.c
            r0.<init>()
            kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.A(r10, r0)
            r0 = 5
            kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.P(r10, r0)
            java.util.Set r10 = kotlin.sequences.SequencesKt.U(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.m(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String n(AggregatedItemRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(GetTimeNudgeAppsUseCase getTimeNudgeAppsUseCase, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((Boolean) getTimeNudgeAppsUseCase.f127629a.invoke(it)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object l(cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$invoke$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$invoke$1) r0
            int r1 = r0.f127643f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127643f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$invoke$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f127641c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127643f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.f127640b
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Object r7 = r0.f127639a
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params r7 = (cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params) r7
            kotlin.ResultKt.b(r8)
            return r8
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.f127639a
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params r7 = (cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params) r7
            kotlin.ResultKt.b(r8)
            goto L7d
        L47:
            java.lang.Object r7 = r0.f127639a
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params r7 = (cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params) r7
            kotlin.ResultKt.b(r8)
            goto L69
        L4f:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r8 = r6.i()
            kotlinx.coroutines.flow.Flow r8 = r8.w0()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f127639a = r2
            r0.f127643f = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L69
            goto L9d
        L69:
            java.util.Set r8 = (java.util.Set) r8
            if (r8 == 0) goto L6e
            return r8
        L6e:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f127639a = r8
            r0.f127643f = r4
            java.lang.Object r8 = r6.g(r0)
            if (r8 != r1) goto L7d
            goto L9d
        L7d:
            java.util.Set r8 = (java.util.Set) r8
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L89
            return r8
        L89:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f127639a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f127640b = r7
            r0.f127643f = r3
            java.lang.Object r7 = r6.m(r0)
            if (r7 != r1) goto L9e
        L9d:
            return r1
        L9e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.l(cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public /* synthetic */ GetTimeNudgeAppsUseCase(Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Function1() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GetTimeNudgeAppsUseCase.d((String) obj));
            }
        } : function1);
    }
}
