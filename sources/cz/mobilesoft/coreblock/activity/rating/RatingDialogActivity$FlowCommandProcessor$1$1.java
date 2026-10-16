package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$FlowCommandProcessor$1$1", f = "RatingDialogActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$FlowCommandProcessor$1$1 extends SuspendLambda implements Function2<RatingFlowCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f96015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity f96016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f96017d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$FlowCommandProcessor$1$1(RatingDialogActivity ratingDialogActivity, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f96016c = ratingDialogActivity;
        this.f96017d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RatingDialogActivity$FlowCommandProcessor$1$1 ratingDialogActivity$FlowCommandProcessor$1$1 = new RatingDialogActivity$FlowCommandProcessor$1$1(this.f96016c, this.f96017d, continuation);
        ratingDialogActivity$FlowCommandProcessor$1$1.f96015b = obj;
        return ratingDialogActivity$FlowCommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(RatingFlowCommand ratingFlowCommand, Continuation continuation) {
        return ((RatingDialogActivity$FlowCommandProcessor$1$1) create(ratingFlowCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RatingFlowCommand ratingFlowCommand = (RatingFlowCommand) this.f96015b;
        IntrinsicsKt.f();
        if (this.f96014a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(ratingFlowCommand, RatingFlowCommand.FinishActivity.f96119a)) {
            this.f96016c.finish();
        } else if (Intrinsics.areEqual(ratingFlowCommand, RatingFlowCommand.LaunchInAppReview.f96120a)) {
            RatingDialogActivity.g1(this.f96016c, null, this.f96017d, 1, null);
        } else if (Intrinsics.areEqual(ratingFlowCommand, RatingFlowCommand.OpenGooglePlayStore.f96121a)) {
            this.f96016c.k1();
        } else if (Intrinsics.areEqual(ratingFlowCommand, RatingFlowCommand.ShowFeedbackDialog.f96122a)) {
            RatingDialogActivity.o1(this.f96016c, null, this.f96017d, 1, null);
        } else if (Intrinsics.areEqual(ratingFlowCommand, RatingFlowCommand.StartSupportIntent.f96123a)) {
            this.f96016c.s1();
        } else {
            if (!(ratingFlowCommand instanceof RatingFlowCommand.Close)) {
                throw new NoWhenBranchMatchedException();
            }
            RatingDialogActivity ratingDialogActivity = this.f96016c;
            ratingDialogActivity.Y0(ratingDialogActivity.f95987j, ((RatingFlowCommand.Close) ratingFlowCommand).a());
        }
        return Unit.f139807a;
    }
}
