package cz.mobilesoft.coreblock.service.job;

import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.usecase.PickDailyInsightsMotivationMessageUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DailyInsightsNotificationJobPlanner implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DailyInsightsNotificationJobPlanner f123209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f123210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f123211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f123212d;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final DailyInsightsNotificationJobPlanner dailyInsightsNotificationJobPlanner = new DailyInsightsNotificationJobPlanner();
        f123209a = dailyInsightsNotificationJobPlanner;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f123210b = LazyKt.a(lazyThreadSafetyModeB, new Function0<PickDailyInsightsMotivationMessageUseCase>() { // from class: cz.mobilesoft.coreblock.service.job.DailyInsightsNotificationJobPlanner$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = dailyInsightsNotificationJobPlanner;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PickDailyInsightsMotivationMessageUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f123211c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.DailyInsightsNotificationJobPlanner$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = dailyInsightsNotificationJobPlanner;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), objArr2, objArr3);
            }
        });
        f123212d = 8;
    }

    private DailyInsightsNotificationJobPlanner() {
    }

    private final NotificationDataStore a() {
        return (NotificationDataStore) f123211c.getValue();
    }

    private final PickDailyInsightsMotivationMessageUseCase b() {
        return (PickDailyInsightsMotivationMessageUseCase) f123210b.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d6, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r4, r5, r0) != r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6 A[PHI: r9 r10
      0x00a6: PHI (r9v4 android.content.Context) = (r9v3 android.content.Context), (r9v15 android.content.Context) binds: [B:31:0x00a3, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r10v12 java.lang.Object) = (r10v11 java.lang.Object), (r10v1 java.lang.Object) binds: [B:31:0x00a3, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(android.content.Context r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.DailyInsightsNotificationJobPlanner.c(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
