package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class SubscriptionExpiredOffer2Job extends Job implements KoinComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f123483l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f123484m = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f123485k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Pair a() {
            Calendar calendar = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(11, 19);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.add(6, 10);
            long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
            calendar.add(11, 2);
            return TuplesKt.a(Long.valueOf(timeInMillis2), Long.valueOf(calendar.getTimeInMillis() - timeInMillis));
        }

        public final void b(boolean z2) {
            JobRequest.Builder builder = new JobRequest.Builder("TAG_SUBSCRIPTION_EXPIRED_OFFER_2");
            Pair pairA = z2 ? SubscriptionExpiredOffer1Job.f123477l.a() : a();
            if (BuildConfig.f95357b.booleanValue()) {
                builder.z(30000L);
            } else {
                builder.A(((Number) pairA.e()).longValue(), ((Number) pairA.f()).longValue());
            }
            JobRequest jobRequestW = builder.H(true).w();
            Intrinsics.checkNotNullExpressionValue(jobRequestW, "build(...)");
            JobExtKt.a(jobRequestW);
            Log.d(JobPlanner.class.getSimpleName(), "Job scheduled for sub expired offer 2 between " + pairA.e() + " to " + pairA.f() + " from now");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionExpiredOffer2Job() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123485k = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.job.SubscriptionExpiredOffer2Job$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
    }

    private final PremiumRepositoryV2 x() {
        return (PremiumRepositoryV2) this.f123485k.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (x().J().g()) {
            return Job.Result.SUCCESS;
        }
        PrefManager prefManager = PrefManager.f126839a;
        if (prefManager.i1()) {
            prefManager.J2(2);
            NotificationHelper notificationHelper = NotificationHelper.f128940a;
            Context contextC = c();
            Intrinsics.checkNotNullExpressionValue(contextC, "getContext(...)");
            notificationHelper.J(contextC, 2);
        }
        return Job.Result.SUCCESS;
    }
}
