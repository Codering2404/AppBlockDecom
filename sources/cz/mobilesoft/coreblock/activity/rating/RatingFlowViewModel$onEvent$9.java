package cz.mobilesoft.coreblock.activity.rating;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$onEvent$9", f = "RatingFlowViewModel.kt", l = {91, 103}, m = "invokeSuspend", v = 1)
final class RatingFlowViewModel$onEvent$9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingFlowEvent f96170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RatingFlowViewModel f96171d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingFlowViewModel$onEvent$9(RatingFlowEvent ratingFlowEvent, RatingFlowViewModel ratingFlowViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96170c = ratingFlowEvent;
        this.f96171d = ratingFlowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RatingFlowViewModel$onEvent$9(this.f96170c, this.f96171d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r9.P0(r1, r8) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r1.P0(r2, r8) != r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        return r0;
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
            int r1 = r8.f96169b
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            java.lang.Object r0 = r8.f96168a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            kotlin.ResultKt.b(r9)
            goto L6b
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            kotlin.ResultKt.b(r9)
            goto L3d
        L23:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent r9 = r8.f96170c
            cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent$OnReviewFlowFinished r9 = (cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent.OnReviewFlowFinished) r9
            boolean r9 = r9.a()
            if (r9 != 0) goto L42
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r9 = r8.f96171d
            cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$OpenGooglePlayStore r1 = cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand.OpenGooglePlayStore.f96121a
            r8.f96169b = r4
            java.lang.Object r9 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.c1(r9, r1, r8)
            if (r9 != r0) goto L3d
            goto L6a
        L3d:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            goto L43
        L42:
            r9 = r2
        L43:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent r1 = new cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent
            java.lang.String r5 = "confirm"
            r1.<init>(r9, r5)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r5 = r8.f96171d
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r5 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.Z0(r5)
            r6 = 0
            r7 = 4
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper.z4(r1, r5, r6, r7, r2)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r1 = r8.f96171d
            cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$Close r2 = new cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$Close
            r2.<init>(r4)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r8.f96168a = r9
            r8.f96169b = r3
            java.lang.Object r9 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.c1(r1, r2, r8)
            if (r9 != r0) goto L6b
        L6a:
            return r0
        L6b:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$onEvent$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RatingFlowViewModel$onEvent$9) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
