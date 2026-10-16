package cz.mobilesoft.coreblock.scene.streaks.feedback;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$send$3", f = "StreakFeedbackViewModel.kt", l = {91, 94}, m = "invokeSuspend", v = 1)
final class StreakFeedbackViewModel$send$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StreakFeedbackViewModel f120858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FeedbackViewState f120859c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakFeedbackViewModel$send$3(StreakFeedbackViewModel streakFeedbackViewModel, FeedbackViewState feedbackViewState, Continuation continuation) {
        super(2, continuation);
        this.f120858b = streakFeedbackViewModel;
        this.f120859c = feedbackViewState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState q(FeedbackViewState feedbackViewState) {
        return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakFeedbackViewModel$send$3(this.f120858b, this.f120859c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        if (r2.P0(r4, r19) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120857a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L20
            if (r2 == r4) goto L1c
            if (r2 != r3) goto L14
            kotlin.ResultKt.b(r20)
            goto L71
        L14:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1c:
            kotlin.ResultKt.b(r20)
            goto L5a
        L20:
            kotlin.ResultKt.b(r20)
            cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel r2 = r0.f120858b
            cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase r2 = cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel.V0(r2)
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState r5 = r0.f120859c
            java.lang.String r7 = r5.i()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState r5 = r0.f120859c
            java.lang.String r11 = r5.f()
            cz.mobilesoft.coreblock.enums.HiddenContactReason r10 = cz.mobilesoft.coreblock.enums.HiddenContactReason.StreaksBetaFeedback
            cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$Params r6 = new cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$Params
            r17 = 932(0x3a4, float:1.306E-42)
            r18 = 0
            r9 = 0
            r12 = 0
            java.lang.String r13 = ""
            r14 = 0
            r15 = 0
            r16 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            kotlinx.coroutines.flow.Flow r2 = r2.t(r6)
            r0.f120857a = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.k(r2, r0)
            if (r2 != r1) goto L5a
            goto L70
        L5a:
            cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel r2 = r0.f120858b
            cz.mobilesoft.coreblock.scene.streaks.feedback.x r4 = new cz.mobilesoft.coreblock.scene.streaks.feedback.x
            r4.<init>()
            cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel.Y0(r2, r4)
            cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel r2 = r0.f120858b
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand$TicketSend r4 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand.TicketSend.f102071a
            r0.f120857a = r3
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel.X0(r2, r4, r0)
            if (r2 != r1) goto L71
        L70:
            return r1
        L71:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackViewModel$send$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakFeedbackViewModel$send$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
