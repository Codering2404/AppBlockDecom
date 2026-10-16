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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel$onEvent$13", f = "RatingDialogViewModel.kt", l = {91, 104}, m = "invokeSuspend", v = 1)
final class RatingDialogViewModel$onEvent$13 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingDialogEvent f96093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RatingDialogViewModel f96094d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogViewModel$onEvent$13(RatingDialogEvent ratingDialogEvent, RatingDialogViewModel ratingDialogViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96093c = ratingDialogEvent;
        this.f96094d = ratingDialogViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RatingDialogViewModel$onEvent$13(this.f96093c, this.f96094d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r7.P0(r1, r6) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
    
        if (r1.P0(r4, r6) != r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f96092b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.f96091a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            kotlin.ResultKt.b(r7)
            goto L6e
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L3c
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent r7 = r6.f96093c
            cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent$OnReviewFlowFinished r7 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent.OnReviewFlowFinished) r7
            boolean r7 = r7.a()
            if (r7 != 0) goto L41
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r7 = r6.f96094d
            cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand$OpenGooglePlayStore r1 = cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand.OpenGooglePlayStore.f96066a
            r6.f96092b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.a1(r7, r1, r6)
            if (r7 != r0) goto L3c
            goto L6d
        L3c:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            goto L42
        L41:
            r7 = 0
        L42:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent r1 = new cz.mobilesoft.coreblock.util.analytics.AnswersHelper$RatingShownEvent
            java.lang.String r4 = "confirm"
            r1.<init>(r7, r4)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r4 = r6.f96094d
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r4 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.Y0(r4)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r5 = r6.f96094d
            boolean r5 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.Z0(r5)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper.y4(r1, r4, r5)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r1 = r6.f96094d
            cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand$Close r4 = new cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand$Close
            r4.<init>(r3)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f96091a = r7
            r6.f96092b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.a1(r1, r4, r6)
            if (r7 != r0) goto L6e
        L6d:
            return r0
        L6e:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel$onEvent$13.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RatingDialogViewModel$onEvent$13) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
