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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$launchRatingFlowOrFallback$1", f = "RatingFlowViewModel.kt", l = {148, 150, 158}, m = "invokeSuspend", v = 1)
final class RatingFlowViewModel$launchRatingFlowOrFallback$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RatingFlowViewModel f96153b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingFlowViewModel$launchRatingFlowOrFallback$1(RatingFlowViewModel ratingFlowViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96153b = ratingFlowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RatingFlowViewModel$launchRatingFlowOrFallback$1(this.f96153b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r8.P0(r1, r7) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r8.P0(r1, r7) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f96152a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1e
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.b(r8)
            goto L4b
        L1e:
            kotlin.ResultKt.b(r8)
            goto L72
        L22:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r8 = r7.f96153b
            cz.mobilesoft.coreblock.activity.rating.RatingFlowState r8 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.V0(r8)
            boolean r8 = r8.f()
            if (r8 == 0) goto L3e
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r8 = r7.f96153b
            cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$LaunchInAppReview r1 = cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand.LaunchInAppReview.f96120a
            r7.f96152a = r4
            java.lang.Object r8 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.c1(r8, r1, r7)
            if (r8 != r0) goto L72
            goto L71
        L3e:
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r8 = r7.f96153b
            cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$OpenGooglePlayStore r1 = cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand.OpenGooglePlayStore.f96121a
            r7.f96152a = r3
            java.lang.Object r8 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.c1(r8, r1, r7)
            if (r8 != r0) goto L4b
            goto L71
        L4b:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent r8 = new cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            java.lang.String r3 = "confirm"
            r8.<init>(r1, r3)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r1 = r7.f96153b
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r1 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.Z0(r1)
            r3 = 4
            r5 = 0
            r6 = 0
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper.z4(r8, r1, r6, r3, r5)
            cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel r8 = r7.f96153b
            cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$Close r1 = new cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand$Close
            r1.<init>(r4)
            r7.f96152a = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel.c1(r8, r1, r7)
            if (r8 != r0) goto L72
        L71:
            return r0
        L72:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$launchRatingFlowOrFallback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RatingFlowViewModel$launchRatingFlowOrFallback$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
