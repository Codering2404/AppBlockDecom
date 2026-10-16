package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class FetchTrialSummaryUseCase extends SuspendUseCase<Params, TrialSummaryData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IgnoredStatisticsItemDao f103751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockSessionDao f103752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DevDataStore f103753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PremiumRepositoryV2 f103754d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Calendar f103755f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f103756a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return 1059614218;
        }

        public String toString() {
            return "Params";
        }
    }

    public FetchTrialSummaryUseCase(IgnoredStatisticsItemDao ignoredStatisticsItemDao, BlockSessionDao blockSessionDao, DevDataStore devDataStore, PremiumRepositoryV2 premiumRepository) {
        Intrinsics.checkNotNullParameter(ignoredStatisticsItemDao, "ignoredStatisticsItemDao");
        Intrinsics.checkNotNullParameter(blockSessionDao, "blockSessionDao");
        Intrinsics.checkNotNullParameter(devDataStore, "devDataStore");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f103751a = ignoredStatisticsItemDao;
        this.f103752b = blockSessionDao;
        this.f103753c = devDataStore;
        this.f103754d = premiumRepository;
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        this.f103755f = calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(long r19, long r21, java.util.List r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r21
            r5 = r24
            boolean r6 = r5 instanceof cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$fetchData$1
            if (r6 == 0) goto L1b
            r6 = r5
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$fetchData$1 r6 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$fetchData$1) r6
            int r7 = r6.f103765j
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r7 & r8
            if (r9 == 0) goto L1b
            int r7 = r7 - r8
            r6.f103765j = r7
            goto L20
        L1b:
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$fetchData$1 r6 = new cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$fetchData$1
            r6.<init>(r0, r5)
        L20:
            java.lang.Object r5 = r6.f103763h
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r8 = r6.f103765j
            r9 = 1
            if (r8 == 0) goto L40
            if (r8 != r9) goto L38
            long r1 = r6.f103761f
            java.lang.Object r3 = r6.f103762g
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.b(r5)
            goto La6
        L38:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L40:
            kotlin.ResultKt.b(r5)
            java.util.Calendar r5 = r0.f103755f
            r5.setTimeInMillis(r1)
            java.util.Calendar r5 = r0.f103755f
            cz.mobilesoft.coreblock.util.helperextension.CalendarExtKt.a(r5)
            java.util.Calendar r5 = r0.f103755f
            long r12 = r5.getTimeInMillis()
            java.util.Calendar r5 = r0.f103755f
            r5.setTimeInMillis(r3)
            java.util.Calendar r5 = r0.f103755f
            cz.mobilesoft.coreblock.util.helperextension.CalendarExtKt.a(r5)
            java.util.Calendar r5 = r0.f103755f
            long r14 = r5.getTimeInMillis()
            long r10 = r14 - r12
            r5 = 86400000(0x5265c00, float:7.82218E-36)
            r16 = r10
            long r9 = (long) r5
            long r8 = r16 / r9
            cz.mobilesoft.statistics.api.Statistics r5 = cz.mobilesoft.statistics.api.Statistics.f133571a
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r5 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r5 = r5.getTypeId()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r5)
            java.util.Set r5 = kotlin.collections.SetsKt.setOf(r5)
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r23)
            r6.f103762g = r10
            r6.f103757a = r1
            r6.f103758b = r3
            r6.f103759c = r12
            r6.f103760d = r14
            r6.f103761f = r8
            r1 = 1
            r6.f103765j = r1
            r10 = r8
            r9 = 0
            r1 = r10
            r10 = 0
            r11 = 0
            r8 = r23
            r2 = r1
            r16 = r6
            r1 = r7
            r7 = r5
            java.lang.Object r5 = cz.mobilesoft.statistics.api.Statistics.D(r7, r8, r9, r10, r11, r12, r14, r16)
            if (r5 != r1) goto La5
            return r1
        La5:
            r1 = r2
        La6:
            java.lang.Double r5 = (java.lang.Double) r5
            int r1 = (int) r1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            kotlin.Pair r1 = kotlin.TuplesKt.a(r1, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase.b(long, long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0186 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0222 A[LOOP:0: B:69:0x021c->B:71:0x0222, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase.Params r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase.c(cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
