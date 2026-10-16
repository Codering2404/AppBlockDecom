package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public final class ProfileDeactivationJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f123414o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f123415p = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f123417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f123418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f123419n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(long j3, long j4, long j5, boolean z2, boolean z3) {
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            persistableBundleCompat.j("PROFILE_ID", j3);
            persistableBundleCompat.j("WHEN", j5);
            persistableBundleCompat.h("CHECK_IF_PROFILE_WAS_ACTUALLY_DEACTIVATED", z2);
            persistableBundleCompat.h("LOG_QB_ANALYTICS", true);
            persistableBundleCompat.h("IS_POMODORO", z3);
            JobRequest jobRequestW = new JobRequest.Builder("PROFILE_DEACTIVATION_WITH_ID_" + j3).z(j4).B(persistableBundleCompat).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to fire for profile " + j3 + " deactivation in " + j4 + " ms");
        }

        private Companion() {
        }

        public final void a(long j3, long j4, boolean z2, boolean z3) {
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            persistableBundleCompat.j("PROFILE_ID", j3);
            persistableBundleCompat.j("WHEN", j4);
            persistableBundleCompat.h("SHOW_ONLY_IF_NOTIFICATIONS_BLOCKED", z2);
            persistableBundleCompat.h("CHECK_IF_PROFILE_WAS_ACTUALLY_DEACTIVATED", false);
            persistableBundleCompat.h(sKeKFMqmvNzY.bkPPZXiwJpkSA, z3);
            persistableBundleCompat.h("LOG_QB_ANALYTICS", false);
            JobRequest jobRequestW = new JobRequest.Builder("PROFILE_DEACTIVATION_WITH_ID_" + j3).H(true).I().B(persistableBundleCompat).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to fire right now for a deactivated profile fire for profile " + j3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileDeactivationJob() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123416k = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.job.ProfileDeactivationJob$special$$inlined$inject$default$1
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
        this.f123417l = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.service.job.ProfileDeactivationJob$special$$inlined$inject$default$2
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
        this.f123418m = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.ProfileDeactivationJob$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f123419n = LazyKt.a(lazyThreadSafetyModeB4, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.service.job.ProfileDeactivationJob$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr6, objArr7);
            }
        });
    }

    private final StrictModeRepository B() {
        return (StrictModeRepository) this.f123417l.getValue();
    }

    public static final void C(long j3, long j4, boolean z2, boolean z3) {
        f123414o.a(j3, j4, z2, z3);
    }

    public static final void D(long j3, long j4, long j5, boolean z2, boolean z3) {
        f123414o.b(j3, j4, j5, z2, z3);
    }

    public final QuickBlockRepository A() {
        return (QuickBlockRepository) this.f123419n.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        PersistableBundleCompat persistableBundleCompatA = params.a();
        Intrinsics.checkNotNullExpressionValue(persistableBundleCompatA, "getExtras(...)");
        boolean zC = persistableBundleCompatA.c("CHECK_IF_PROFILE_WAS_ACTUALLY_DEACTIVATED", false);
        long jE = persistableBundleCompatA.e("PROFILE_ID", -1L);
        boolean zC2 = persistableBundleCompatA.c("LOG_QB_ANALYTICS", false);
        if (jE != -1) {
            Profile profile = (Profile) BuildersKt__BuildersKt.b(null, new ProfileDeactivationJob$onRunJob$profile$1(this, jE, null), 1, null);
            if (profile != null && profile.R() && zC2) {
                AnswersHelper answersHelper = AnswersHelper.f128199a;
                QuickBlockProfileDTO quickBlockProfileDTOQ = A().q();
                boolean z2 = (quickBlockProfileDTOQ != null ? quickBlockProfileDTOQ.g() : null) != null;
                Long lValueOf = Long.valueOf(profile.w());
                boolean zN = B().n();
                List listA = A().A();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listA) {
                    if (((WebsiteProfileRelation) obj).a() == WebsiteProfileRelation.BlockingType.DOMAIN) {
                        arrayList.add(obj);
                    }
                }
                int size = arrayList.size();
                List listA2 = A().A();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listA2) {
                    if (((WebsiteProfileRelation) obj2).a() == WebsiteProfileRelation.BlockingType.KEYWORD) {
                        arrayList2.add(obj2);
                    }
                }
                int size2 = arrayList2.size();
                List listL = A().l();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listL, 10));
                Iterator it = listL.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((ProfileWithBlockedItems.ApplicationProfileRelationWithApplication) it.next()).c());
                }
                answersHelper.r4(profile, z2, lValueOf, zN, size, size2, arrayList3);
            }
            if (!zC || (profile != null && !ProfileHelper.f129250a.A(profile))) {
                if ((profile != null ? profile.B() : null) == ProfileType.QUICK_BLOCK) {
                    BuildersKt__BuildersKt.b(null, new ProfileDeactivationJob$onRunJob$4(this, null), 1, null);
                }
                JobPlanner.b().c().g(c(), persistableBundleCompatA);
            }
            CoroutinesHelperExtKt.d(new ProfileDeactivationJob$onRunJob$5(this, null));
        }
        return Job.Result.SUCCESS;
    }

    public final EventDataStore y() {
        return (EventDataStore) this.f123418m.getValue();
    }

    public final ProfileDao z() {
        return (ProfileDao) this.f123416k.getValue();
    }
}
