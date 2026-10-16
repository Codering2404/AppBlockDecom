package cz.mobilesoft.coreblock.scene.insights;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$setIgnoreStatisticsItem$1", f = "InsightsViewModel.kt", l = {1028, 1030, 1040}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$setIgnoreStatisticsItem$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f102812d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f102814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f102815h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$setIgnoreStatisticsItem$1(InsightsViewModel insightsViewModel, String str, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f102813f = insightsViewModel;
        this.f102814g = str;
        this.f102815h = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState q(boolean z2, InsightsViewState insightsViewState) {
        return InsightsViewState.d(insightsViewState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, z2, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -33554433, 32767, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$setIgnoreStatisticsItem$1(this.f102813f, this.f102814g, this.f102815h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r2.p(r14, r13) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        if (r14 == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f102812d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 == r4) goto L2e
            if (r1 == r3) goto L26
            if (r1 != r2) goto L1e
            java.lang.Object r0 = r13.f102810b
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
            java.lang.Object r0 = r13.f102809a
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r0 = (cz.mobilesoft.coreblock.scene.insights.InsightsViewModel) r0
            kotlin.ResultKt.b(r14)
            goto L96
        L1e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L26:
            java.lang.Object r0 = r13.f102809a
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
            kotlin.ResultKt.b(r14)
            goto L9f
        L2e:
            kotlin.ResultKt.b(r14)
            goto L46
        L32:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r14 = r13.f102813f
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r14 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.C1(r14)
            java.lang.String r1 = r13.f102814g
            r13.f102812d = r4
            java.lang.Object r14 = r14.T(r1, r13)
            if (r14 != r0) goto L46
            goto L95
        L46:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r14 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r14
            r1 = 0
            if (r14 == 0) goto L67
            boolean r2 = r13.f102815h
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r4 = r13.f102813f
            r14.g(r2)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r2 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.C1(r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r13.f102809a = r4
            r13.f102811c = r1
            r13.f102812d = r3
            java.lang.Object r14 = r2.p(r14, r13)
            if (r14 != r0) goto L9f
            goto L95
        L67:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r14 = r13.f102813f
            java.lang.String r6 = r13.f102814g
            boolean r9 = r13.f102815h
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r3 = new cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r7 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r8 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r11 = 1
            r12 = 0
            r4 = 0
            r10 = 1
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.C1(r14)
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r13.f102809a = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
            r13.f102810b = r14
            r13.f102811c = r1
            r13.f102812d = r2
            java.lang.Object r14 = r4.n(r3, r13)
            if (r14 != r0) goto L96
        L95:
            return r0
        L96:
            java.lang.Number r14 = (java.lang.Number) r14
            long r0 = r14.longValue()
            kotlin.coroutines.jvm.internal.Boxing.e(r0)
        L9f:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r14 = r13.f102813f
            boolean r0 = r13.f102815h
            cz.mobilesoft.coreblock.scene.insights.x7 r1 = new cz.mobilesoft.coreblock.scene.insights.x7
            r1.<init>()
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.S1(r14, r1)
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$setIgnoreStatisticsItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$setIgnoreStatisticsItem$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
