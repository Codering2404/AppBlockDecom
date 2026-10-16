package cz.mobilesoft.coreblock.scene.feedback;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.util.CompressionState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$handleVideoCompression$1", f = "FeedbackViewModel.kt", l = {435, 437}, m = "invokeSuspend", v = 1)
final class FeedbackViewModel$handleVideoCompression$1 extends SuspendLambda implements Function2<CompressionState, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f102126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FeedbackViewModel f102127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f102128d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedbackViewModel$handleVideoCompression$1(FeedbackViewModel feedbackViewModel, long j3, Continuation continuation) {
        super(2, continuation);
        this.f102127c = feedbackViewModel;
        this.f102128d = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState A(FeedbackViewState feedbackViewState) {
        Set mutableSet = CollectionsKt.toMutableSet(feedbackViewState.n());
        mutableSet.add(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        Unit unit = Unit.f139807a;
        return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : mutableSet, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState G(CompressionState compressionState, FeedbackViewState feedbackViewState) {
        return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : true, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : ((CompressionState.Loading) compressionState).a(), (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState J(FeedbackViewState feedbackViewState) {
        return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FeedbackViewModel$handleVideoCompression$1 feedbackViewModel$handleVideoCompression$1 = new FeedbackViewModel$handleVideoCompression$1(this.f102127c, this.f102128d, continuation);
        feedbackViewModel$handleVideoCompression$1.f102126b = obj;
        return feedbackViewModel$handleVideoCompression$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        if (r2.P0(r3, r7) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
    
        if (r8.P0(r2, r7) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008e, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$handleVideoCompression$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final Object invoke(CompressionState compressionState, Continuation continuation) {
        return ((FeedbackViewModel$handleVideoCompression$1) create(compressionState, continuation)).invokeSuspend(Unit.f139807a);
    }
}
