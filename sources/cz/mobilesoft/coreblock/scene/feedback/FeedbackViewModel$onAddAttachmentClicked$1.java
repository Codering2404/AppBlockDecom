package cz.mobilesoft.coreblock.scene.feedback;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$onAddAttachmentClicked$1", f = "FeedbackViewModel.kt", l = {384}, m = "invokeSuspend", v = 1)
final class FeedbackViewModel$onAddAttachmentClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FeedbackViewModel f102130b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedbackViewModel$onAddAttachmentClicked$1(FeedbackViewModel feedbackViewModel, Continuation continuation) {
        super(2, continuation);
        this.f102130b = feedbackViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FeedbackViewModel$onAddAttachmentClicked$1(this.f102130b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102129a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FeedbackViewModel feedbackViewModel = this.f102130b;
            String string = this.f102130b.A0().getString(R.string.AH, Boxing.d(5));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            FeedbackViewCommand.ShowSnackBar showSnackBar = new FeedbackViewCommand.ShowSnackBar(string);
            this.f102129a = 1;
            if (feedbackViewModel.P0(showSnackBar, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FeedbackViewModel$onAddAttachmentClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
