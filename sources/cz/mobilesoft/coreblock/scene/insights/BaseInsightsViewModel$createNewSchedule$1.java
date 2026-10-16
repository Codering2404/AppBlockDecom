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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$createNewSchedule$1", f = "BaseInsightsViewModel.kt", l = {176, 187}, m = "invokeSuspend", v = 1)
final class BaseInsightsViewModel$createNewSchedule$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f102479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f102481d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseInsightsViewModel f102482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f102483g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInsightsViewModel$createNewSchedule$1(String str, BaseInsightsViewModel baseInsightsViewModel, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f102481d = str;
        this.f102482f = baseInsightsViewModel;
        this.f102483g = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseInsightsViewModel$createNewSchedule$1(this.f102481d, this.f102482f, this.f102483g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
    
        if (r9.P0(r1, r8) == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f102480c
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L29
            if (r1 == r5) goto L21
            if (r1 != r3) goto L19
            java.lang.Object r0 = r8.f102478a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r9)
            goto Laf
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            java.lang.Object r1 = r8.f102478a
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.b(r9)
            goto L6a
        L29:
            kotlin.ResultKt.b(r9)
            java.lang.String r9 = r8.f102481d
            boolean r1 = r8.f102483g
            cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel r6 = r8.f102482f
            java.lang.String r7 = cz.mobilesoft.coreblock.LockieApplication.f95360f
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r7)
            if (r7 == 0) goto L4a
            if (r1 != 0) goto L4a
            r6.m1(r5)
            cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$createNewSchedule$1$applicationList$1$1 r9 = new cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$createNewSchedule$1$applicationList$1$1
            r9.<init>(r6, r4)
            cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel.W0(r6, r9)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        L4a:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r1.h0(r9)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r1 = cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel.S0(r6)
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r9)
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r8.f102478a = r9
            r8.f102479b = r2
            r8.f102480c = r5
            java.lang.Object r9 = r1.a0(r6, r8)
            if (r9 != r0) goto L6a
            goto Lae
        L6a:
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Application r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) r9
            if (r9 == 0) goto L92
            cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO r1 = new cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO
            java.lang.String r5 = r9.d()
            java.lang.String r6 = r9.b()
            cz.mobilesoft.coreblock.dto.Category$Companion r7 = cz.mobilesoft.coreblock.dto.Category.Companion
            java.lang.Integer r9 = r9.a()
            if (r9 == 0) goto L8a
            int r2 = r9.intValue()
        L8a:
            java.util.List r9 = r7.c(r2)
            r1.<init>(r5, r6, r9)
            goto L93
        L92:
            r1 = r4
        L93:
            if (r1 == 0) goto L99
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r1)
        L99:
            cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel r9 = r8.f102482f
            cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand$CreateNewSchedule r1 = new cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand$CreateNewSchedule
            r1.<init>(r4)
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r8.f102478a = r2
            r8.f102480c = r3
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel.X0(r9, r1, r8)
            if (r9 != r0) goto Laf
        Lae:
            return r0
        Laf:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$createNewSchedule$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseInsightsViewModel$createNewSchedule$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
