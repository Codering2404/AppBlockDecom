package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UsageLimitHostTracker implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile PackageAdditionalBlockingDTO f94999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PackageAdditionalBlockingDTO f95000d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class HostChangeResult {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NoChange extends HostChangeResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NoChange f95001a = new NoChange();

            private NoChange() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NoChange);
            }

            public int hashCode() {
                return 955890879;
            }

            public String toString() {
                return "NoChange";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SubAppDisappeared extends HostChangeResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SubAppDisappeared f95002a = new SubAppDisappeared();

            private SubAppDisappeared() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof SubAppDisappeared);
            }

            public int hashCode() {
                return -1239318317;
            }

            public String toString() {
                return "SubAppDisappeared";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class UrlDisappeared extends HostChangeResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final UrlDisappeared f95003a = new UrlDisappeared();

            private UrlDisappeared() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof UrlDisappeared);
            }

            public int hashCode() {
                return -863899647;
            }

            public String toString() {
                return "UrlDisappeared";
            }
        }

        public /* synthetic */ HostChangeResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private HostChangeResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HostInfo {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f95004d = SubApp.$stable | UrlDto.$stable;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f95005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UrlDto f95006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SubApp f95007c;

        public HostInfo(String str, UrlDto urlDto, SubApp subApp) {
            this.f95005a = str;
            this.f95006b = urlDto;
            this.f95007c = subApp;
        }

        public final String a() {
            return this.f95005a;
        }

        public final SubApp b() {
            return this.f95007c;
        }

        public final UrlDto c() {
            return this.f95006b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HostInfo)) {
                return false;
            }
            HostInfo hostInfo = (HostInfo) obj;
            return Intrinsics.areEqual(this.f95005a, hostInfo.f95005a) && Intrinsics.areEqual(this.f95006b, hostInfo.f95006b) && Intrinsics.areEqual(this.f95007c, hostInfo.f95007c);
        }

        public int hashCode() {
            String str = this.f95005a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            UrlDto urlDto = this.f95006b;
            int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
            SubApp subApp = this.f95007c;
            return iHashCode2 + (subApp != null ? subApp.hashCode() : 0);
        }

        public String toString() {
            return "HostInfo(hostPackageName=" + this.f95005a + ", url=" + this.f95006b + ", subApp=" + this.f95007c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PollResult {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f95008c = PackageAdditionalBlockingDTO.$stable;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PackageAdditionalBlockingDTO f95009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HostChangeResult f95010b;

        public PollResult(PackageAdditionalBlockingDTO snapshot, HostChangeResult changeResult) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            Intrinsics.checkNotNullParameter(changeResult, "changeResult");
            this.f95009a = snapshot;
            this.f95010b = changeResult;
        }

        public final PackageAdditionalBlockingDTO a() {
            return this.f95009a;
        }

        public final HostChangeResult b() {
            return this.f95010b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PollResult)) {
                return false;
            }
            PollResult pollResult = (PollResult) obj;
            return Intrinsics.areEqual(this.f95009a, pollResult.f95009a) && Intrinsics.areEqual(this.f95010b, pollResult.f95010b);
        }

        public int hashCode() {
            return (this.f95009a.hashCode() * 31) + this.f95010b.hashCode();
        }

        public String toString() {
            return "PollResult(snapshot=" + this.f95009a + ", changeResult=" + this.f95010b + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UsageLimitHostTracker(CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.f94997a = ioScope;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94998b = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        this.f94999c = new PackageAdditionalBlockingDTO(null, null, null);
        this.f95000d = this.f94999c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore d() {
        return (EventDataStore) this.f94998b.getValue();
    }

    public final void b(GetForegroundAppsUseCase.AppsDTO appsDTO, PackageAdditionalBlockingDTO snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (snapshot.getPackageName() != null) {
            if (Intrinsics.areEqual(appsDTO != null ? appsDTO.i() : null, snapshot.getPackageName())) {
                return;
            }
            if (Intrinsics.areEqual(appsDTO != null ? appsDTO.k() : null, snapshot.getPackageName())) {
                return;
            }
            CoroutinesHelperExtKt.d(new UsageLimitHostTracker$checkAndClearIfNotInForeground$1(this, null));
        }
    }

    public final PackageAdditionalBlockingDTO c() {
        return this.f94999c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$initialize$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$initialize$1 r0 = (cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$initialize$1) r0
            int r1 = r0.f95017f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f95017f = r1
            goto L18
        L13:
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$initialize$1 r0 = new cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$initialize$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f95015c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f95017f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f95014b
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker r5 = (cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker) r5
            java.lang.Object r0 = r0.f95013a
            cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r0 = (cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO) r0
            kotlin.ResultKt.b(r6)
            goto L54
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            if (r5 != 0) goto L57
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r6 = r4.d()
            kotlinx.coroutines.flow.Flow r6 = r6.l1()
            r0.f95013a = r5
            r0.f95014b = r4
            r0.f95017f = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            r5 = r4
        L54:
            cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r6 = (cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO) r6
            goto L59
        L57:
            r6 = r5
            r5 = r4
        L59:
            r5.f94999c = r6
            cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r5 = r4.f94999c
            r4.f95000d = r5
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker.e(cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PollResult f() {
        PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = this.f95000d;
        PackageAdditionalBlockingDTO packageAdditionalBlockingDTO2 = this.f94999c;
        this.f95000d = packageAdditionalBlockingDTO2;
        return new PollResult(packageAdditionalBlockingDTO2, (packageAdditionalBlockingDTO2.getUrlDto() != null || packageAdditionalBlockingDTO.getUrlDto() == null) ? (packageAdditionalBlockingDTO2.getSubApp() != null || packageAdditionalBlockingDTO.getSubApp() == null) ? HostChangeResult.NoChange.f95001a : HostChangeResult.SubAppDisappeared.f95002a : HostChangeResult.UrlDisappeared.f95003a);
    }

    public final HostInfo g(GetForegroundAppsUseCase.AppsDTO foregroundApps, PackageAdditionalBlockingDTO snapshot) {
        Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return (foregroundApps.c(snapshot.getPackageName()) || snapshot.getSubApp() != null) ? snapshot.getSubApp() != null ? new HostInfo(snapshot.getPackageName(), null, snapshot.getSubApp()) : new HostInfo(snapshot.getPackageName(), snapshot.getUrlDto(), null) : new HostInfo(null, null, null);
    }

    public final void h(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO) {
        Intrinsics.checkNotNullParameter(packageAdditionalBlockingDTO, "<set-?>");
        this.f94999c = packageAdditionalBlockingDTO;
    }

    public final void i() {
        BuildersKt__Builders_commonKt.d(this.f94997a, null, null, new UsageLimitHostTracker$startCollecting$1(this, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
