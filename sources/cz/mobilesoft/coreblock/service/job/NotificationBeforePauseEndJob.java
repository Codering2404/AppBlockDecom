package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
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
import org.koin.java.KoinJavaComponent;
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
public final class NotificationBeforePauseEndJob extends Job implements KoinComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f123353l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f123354m = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123355k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Profile profile) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
            persistableBundleCompat.j("PROFILE_ID", profile.r());
            JobManager.v().e("TAG_BEFORE_PAUSE_END_JOB_" + profile.r());
            if (((Number) new BlockingFlowProperty(((NotificationDataStore) KoinJavaComponent.c(NotificationDataStore.class, null, null, 6, null)).P()).b()).intValue() <= 0 || !profile.H() || profile.J()) {
                return;
            }
            long jMax = Math.max((profile.y().a() - TimeHelperExt.f128663a.f()) - TimeUnit.MINUTES.toMillis(((Number) r2.b()).intValue()), 1L);
            JobRequest jobRequestW = new JobRequest.Builder("TAG_BEFORE_PAUSE_END_JOB_" + profile.r()).H(true).B(persistableBundleCompat).z(jMax).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job for before profile pause end scheduled to fire in " + jMax + " for profile " + profile.r());
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationBeforePauseEndJob() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123355k = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.job.NotificationBeforePauseEndJob$special$$inlined$inject$default$1
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
        long jE = persistableBundleCompatA.e("PROFILE_ID", -1L);
        Log.d(JobPlanner.class.getSimpleName(), "Job fired for before profile pause end for profile " + jE);
        if (jE != -1) {
            JobPlanner.b().c().i(c(), jE);
        }
        return Job.Result.SUCCESS;
    }
}
