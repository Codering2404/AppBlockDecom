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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$updateAppType$1", f = "InsightsViewModel.kt", l = {565, 567, 577}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$updateAppType$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f102876d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f102877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f102878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102879h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$updateAppType$1(String str, InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102878g = str;
        this.f102879h = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$updateAppType$1(this.f102878g, this.f102879h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
    
        if (cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H2(r3, r4, r5, r6, r7, null, r9, null, r14, 80, null) == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.f102877f
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L37
            if (r1 == r4) goto L33
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            java.lang.Object r0 = r14.f102875c
            kotlinx.collections.immutable.ImmutableList r0 = (kotlinx.collections.immutable.ImmutableList) r0
            java.lang.Object r0 = r14.f102874b
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r0 = (cz.mobilesoft.coreblock.scene.insights.InsightsViewState) r0
            java.lang.Object r0 = r14.f102873a
            cz.mobilesoft.coreblock.enums.AppDistractionType r0 = (cz.mobilesoft.coreblock.enums.AppDistractionType) r0
            kotlin.ResultKt.b(r15)
            goto Lbf
        L22:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L2a:
            java.lang.Object r1 = r14.f102873a
            cz.mobilesoft.coreblock.enums.AppDistractionType r1 = (cz.mobilesoft.coreblock.enums.AppDistractionType) r1
            kotlin.ResultKt.b(r15)
        L31:
            r9 = r1
            goto L69
        L33:
            kotlin.ResultKt.b(r15)
            goto L46
        L37:
            kotlin.ResultKt.b(r15)
            r14.f102877f = r4
            r4 = 100
            java.lang.Object r15 = kotlinx.coroutines.DelayKt.b(r4, r14)
            if (r15 != r0) goto L46
            goto Lbe
        L46:
            cz.mobilesoft.coreblock.enums.AppDistractionType$Companion r15 = cz.mobilesoft.coreblock.enums.AppDistractionType.Companion
            java.lang.String r1 = r14.f102878g
            cz.mobilesoft.coreblock.enums.AppDistractionType r1 = r15.a(r1)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r15 = r14.f102879h
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r15 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r15)
            if (r1 == 0) goto L5c
            java.lang.String r4 = r1.name()
            if (r4 != 0) goto L5e
        L5c:
            java.lang.String r4 = ""
        L5e:
            r14.f102873a = r1
            r14.f102877f = r3
            java.lang.Object r15 = r15.F0(r4, r14)
            if (r15 != r0) goto L31
            goto Lbe
        L69:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r15 = r14.f102879h
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r15 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.x1(r15)
            kotlinx.collections.immutable.ImmutableList r4 = r15.K()
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L7c
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        L7c:
            int r5 = r15.v()
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            java.lang.String r3 = r14.f102878g
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r6)
            java.lang.String r6 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r1.n2(r3)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r3 = r14.f102879h
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType r6 = r15.a0()
            int r7 = r15.b0()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r14.f102873a = r1
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
            r14.f102874b = r15
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r14.f102875c = r15
            r14.f102876d = r5
            r14.f102877f = r2
            r8 = 0
            r10 = 0
            r12 = 80
            r13 = 0
            r11 = r14
            java.lang.Object r15 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H2(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto Lbf
        Lbe:
            return r0
        Lbf:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$updateAppType$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$updateAppType$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
