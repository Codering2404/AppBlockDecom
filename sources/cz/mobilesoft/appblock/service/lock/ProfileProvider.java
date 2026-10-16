package cz.mobilesoft.appblock.service.lock;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.ScopedFlowProperty;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class ProfileProvider implements KoinComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f94837l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f94838m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f94842d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f94843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile List f94844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f94845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ScopedFlowProperty f94846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set f94847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Flow f94848k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ApplicationRelationKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f94849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f94850b;

        public ApplicationRelationKey(String packageName, int i3) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f94849a = packageName;
            this.f94850b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicationRelationKey)) {
                return false;
            }
            ApplicationRelationKey applicationRelationKey = (ApplicationRelationKey) obj;
            return Intrinsics.areEqual(this.f94849a, applicationRelationKey.f94849a) && this.f94850b == applicationRelationKey.f94850b;
        }

        public int hashCode() {
            return (this.f94849a.hashCode() * 31) + Integer.hashCode(this.f94850b);
        }

        public String toString() {
            return "ApplicationRelationKey(packageName=" + this.f94849a + ", flags=" + this.f94850b + ")";
        }
    }

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
    private static final class SubAppRelationKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f94851a;

        public SubAppRelationKey(String subAppId) {
            Intrinsics.checkNotNullParameter(subAppId, "subAppId");
            this.f94851a = subAppId;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SubAppRelationKey) && Intrinsics.areEqual(this.f94851a, ((SubAppRelationKey) obj).f94851a);
        }

        public int hashCode() {
            return this.f94851a.hashCode();
        }

        public String toString() {
            return "SubAppRelationKey(subAppId=" + this.f94851a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UsageLimitDefinitionKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f94852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f94853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f94854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f94855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f94856e;

        public UsageLimitDefinitionKey(long j3, int i3, int i4, long j4, long j5) {
            this.f94852a = j3;
            this.f94853b = i3;
            this.f94854c = i4;
            this.f94855d = j4;
            this.f94856e = j5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UsageLimitDefinitionKey)) {
                return false;
            }
            UsageLimitDefinitionKey usageLimitDefinitionKey = (UsageLimitDefinitionKey) obj;
            return this.f94852a == usageLimitDefinitionKey.f94852a && this.f94853b == usageLimitDefinitionKey.f94853b && this.f94854c == usageLimitDefinitionKey.f94854c && this.f94855d == usageLimitDefinitionKey.f94855d && this.f94856e == usageLimitDefinitionKey.f94856e;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.f94852a) * 31) + Integer.hashCode(this.f94853b)) * 31) + Integer.hashCode(this.f94854c)) * 31) + Long.hashCode(this.f94855d)) * 31) + Long.hashCode(this.f94856e);
        }

        public String toString() {
            return "UsageLimitDefinitionKey(id=" + this.f94852a + ", periodTypeId=" + this.f94853b + ", limitTypeId=" + this.f94854c + ", lastResetTime=" + this.f94855d + ", allowedCount=" + this.f94856e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UsageLimitReloadKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f94857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f94858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f94859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f94860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set f94861e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Set f94862f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set f94863g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Set f94864h;

        public UsageLimitReloadKey(long j3, int i3, boolean z2, boolean z3, Set applicationRelations, Set websiteRelations, Set subAppRelations, Set usageLimitDefinitions) {
            Intrinsics.checkNotNullParameter(applicationRelations, "applicationRelations");
            Intrinsics.checkNotNullParameter(websiteRelations, "websiteRelations");
            Intrinsics.checkNotNullParameter(subAppRelations, "subAppRelations");
            Intrinsics.checkNotNullParameter(usageLimitDefinitions, "usageLimitDefinitions");
            this.f94857a = j3;
            this.f94858b = i3;
            this.f94859c = z2;
            this.f94860d = z3;
            this.f94861e = applicationRelations;
            this.f94862f = websiteRelations;
            this.f94863g = subAppRelations;
            this.f94864h = usageLimitDefinitions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UsageLimitReloadKey)) {
                return false;
            }
            UsageLimitReloadKey usageLimitReloadKey = (UsageLimitReloadKey) obj;
            return this.f94857a == usageLimitReloadKey.f94857a && this.f94858b == usageLimitReloadKey.f94858b && this.f94859c == usageLimitReloadKey.f94859c && this.f94860d == usageLimitReloadKey.f94860d && Intrinsics.areEqual(this.f94861e, usageLimitReloadKey.f94861e) && Intrinsics.areEqual(this.f94862f, usageLimitReloadKey.f94862f) && Intrinsics.areEqual(this.f94863g, usageLimitReloadKey.f94863g) && Intrinsics.areEqual(this.f94864h, usageLimitReloadKey.f94864h);
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.f94857a) * 31) + Integer.hashCode(this.f94858b)) * 31) + Boolean.hashCode(this.f94859c)) * 31) + Boolean.hashCode(this.f94860d)) * 31) + this.f94861e.hashCode()) * 31) + this.f94862f.hashCode()) * 31) + this.f94863g.hashCode()) * 31) + this.f94864h.hashCode();
        }

        public String toString() {
            return "UsageLimitReloadKey(id=" + this.f94857a + ", blockingModeId=" + this.f94858b + jlWo.AdGtTrRLuAwG + this.f94859c + ", blockAdultContent=" + this.f94860d + ", applicationRelations=" + this.f94861e + ", websiteRelations=" + this.f94862f + ", subAppRelations=" + this.f94863g + ", usageLimitDefinitions=" + this.f94864h + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class WebsiteRelationKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f94865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f94866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f94867c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebsiteRelationKey)) {
                return false;
            }
            WebsiteRelationKey websiteRelationKey = (WebsiteRelationKey) obj;
            return Intrinsics.areEqual(this.f94865a, websiteRelationKey.f94865a) && this.f94866b == websiteRelationKey.f94866b && this.f94867c == websiteRelationKey.f94867c;
        }

        public int hashCode() {
            return (((this.f94865a.hashCode() * 31) + Integer.hashCode(this.f94866b)) * 31) + Boolean.hashCode(this.f94867c);
        }

        public String toString() {
            return "WebsiteRelationKey(name=" + this.f94865a + ", blockingTypeId=" + this.f94866b + ", isAnywhereInUrl=" + this.f94867c + ")";
        }

        public WebsiteRelationKey(String str, int i3, boolean z2) {
            Intrinsics.checkNotNullParameter(str, HcgZcEUYo.QabIcdQomBD);
            this.f94865a = str;
            this.f94866b = i3;
            this.f94867c = z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileProvider(CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.f94839a = ioScope;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94840b = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$special$$inlined$inject$default$1
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
        this.f94841c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$special$$inlined$inject$default$2
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
        this.f94842d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$special$$inlined$inject$default$3
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
        this.f94843f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr6, objArr7);
            }
        });
        this.f94844g = CollectionsKt.emptyList();
        this.f94847j = SetsKt.emptySet();
        this.f94848k = FlowKt.I(new ProfileProvider$profilesHeartbeat$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao i() {
        return (ApplicationDao) this.f94841c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore j() {
        return (CoreMultiProcessDataStore) this.f94842d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore k() {
        return (EventDataStore) this.f94843f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao l() {
        return (ProfileDao) this.f94840b.getValue();
    }

    private final UsageLimitReloadKey t(ProfileWithConfiguration profileWithConfiguration) {
        long jR = profileWithConfiguration.p().r();
        int id = profileWithConfiguration.p().o().getId();
        boolean zI = profileWithConfiguration.p().i();
        boolean zJ = profileWithConfiguration.p().j();
        List<ApplicationProfileRelation> listG = profileWithConfiguration.g();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ApplicationProfileRelation applicationProfileRelation : listG) {
            linkedHashSet.add(new ApplicationRelationKey(applicationProfileRelation.d(), applicationProfileRelation.b()));
        }
        List<WebsiteProfileRelation> listS = profileWithConfiguration.s();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (WebsiteProfileRelation websiteProfileRelation : listS) {
            linkedHashSet2.add(new WebsiteRelationKey(websiteProfileRelation.c(), websiteProfileRelation.a().getId(), websiteProfileRelation.e()));
        }
        List listQ = profileWithConfiguration.q();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        Iterator it = listQ.iterator();
        while (it.hasNext()) {
            linkedHashSet3.add(new SubAppRelationKey(((SubAppRelation) it.next()).c()));
        }
        List<UsageLimit> listR = profileWithConfiguration.r();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        for (UsageLimit usageLimit : listR) {
            linkedHashSet4.add(new UsageLimitDefinitionKey(usageLimit.g(), usageLimit.k().getId(), usageLimit.i().getId(), usageLimit.h(), usageLimit.f()));
        }
        return new UsageLimitReloadKey(jR, id, zI, zJ, linkedHashSet, linkedHashSet2, linkedHashSet3, linkedHashSet4);
    }

    public final List m() {
        return this.f94844g;
    }

    public final ScopedFlowProperty n() {
        ScopedFlowProperty scopedFlowProperty = this.f94846i;
        if (scopedFlowProperty != null) {
            return scopedFlowProperty;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemPackageNames");
        return null;
    }

    public final void o() {
        final Flow flowS0 = j().s0();
        this.f94846i = new ScopedFlowProperty(this.f94839a, new Flow<Set<? extends String>>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$initializeSystemPackages$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$initializeSystemPackages$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f94870a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ProfileProvider f94871b;

                /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$initializeSystemPackages$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$initializeSystemPackages$$inlined$map$1$2", f = "ProfileProvider.kt", l = {51, 50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f94872a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f94873b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f94874c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f94876f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f94877g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f94878h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    Object f94879i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    Object f94880j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    Object f94881k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    int f94882l;

                    /* JADX INFO: renamed from: m, reason: collision with root package name */
                    int f94883m;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f94872a = obj;
                        this.f94873b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ProfileProvider profileProvider) {
                    this.f94870a = flowCollector;
                    this.f94871b = profileProvider;
                }

                /* JADX WARN: Code restructure failed: missing block: B:31:0x011d, code lost:
                
                    if (r8.emit(r5, r3) == r4) goto L32;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 291
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.ProfileProvider$initializeSystemPackages$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowS0.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        });
    }

    public final boolean p() {
        return this.f94845h;
    }

    public final boolean q() {
        return this.f94846i != null;
    }

    public final boolean r(List currentProfiles) {
        Intrinsics.checkNotNullParameter(currentProfiles, "currentProfiles");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = currentProfiles.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(t((ProfileWithConfiguration) it.next()));
        }
        boolean z2 = !Intrinsics.areEqual(this.f94847j, linkedHashSet);
        this.f94847j = linkedHashSet;
        return z2;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final void s() {
        BuildersKt__Builders_commonKt.d(this.f94839a, null, null, new ProfileProvider$startCollecting$1(this, null), 3, null);
    }
}
