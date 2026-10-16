package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$onSendClicked$2", f = "BackdoorFeedbackViewModel.kt", l = {143, 146, 150}, m = "invokeSuspend", v = 1)
final class BackdoorFeedbackViewModel$onSendClicked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102240d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f102241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BackdoorFeedbackViewModel f102242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ FeedbackViewState f102243h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorFeedbackViewModel$onSendClicked$2(BackdoorFeedbackViewModel backdoorFeedbackViewModel, FeedbackViewState feedbackViewState, Continuation continuation) {
        super(2, continuation);
        this.f102242g = backdoorFeedbackViewModel;
        this.f102243h = feedbackViewState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState q(FeedbackViewState feedbackViewState) {
        return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorFeedbackViewModel$onSendClicked$2(this.f102242g, this.f102243h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00de, code lost:
    
        if (r2.P0(r4, r19) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$onSendClicked$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BackdoorFeedbackViewModel$onSendClicked$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
