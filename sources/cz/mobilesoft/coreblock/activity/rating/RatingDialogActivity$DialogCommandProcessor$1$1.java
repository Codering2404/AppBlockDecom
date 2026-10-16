package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$DialogCommandProcessor$1$1", f = "RatingDialogActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$DialogCommandProcessor$1$1 extends SuspendLambda implements Function2<RatingDialogCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f96011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity f96012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f96013d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$DialogCommandProcessor$1$1(RatingDialogActivity ratingDialogActivity, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f96012c = ratingDialogActivity;
        this.f96013d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RatingDialogActivity$DialogCommandProcessor$1$1 ratingDialogActivity$DialogCommandProcessor$1$1 = new RatingDialogActivity$DialogCommandProcessor$1$1(this.f96012c, this.f96013d, continuation);
        ratingDialogActivity$DialogCommandProcessor$1$1.f96011b = obj;
        return ratingDialogActivity$DialogCommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(RatingDialogCommand ratingDialogCommand, Continuation continuation) {
        return ((RatingDialogActivity$DialogCommandProcessor$1$1) create(ratingDialogCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RatingDialogCommand ratingDialogCommand = (RatingDialogCommand) this.f96011b;
        IntrinsicsKt.f();
        if (this.f96010a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(ratingDialogCommand, RatingDialogCommand.FinishActivity.f96064a)) {
            this.f96012c.finish();
        } else if (Intrinsics.areEqual(ratingDialogCommand, RatingDialogCommand.LaunchInAppReview.f96065a)) {
            RatingDialogActivity.g1(this.f96012c, this.f96013d, null, 2, null);
        } else if (Intrinsics.areEqual(ratingDialogCommand, RatingDialogCommand.OpenGooglePlayStore.f96066a)) {
            this.f96012c.k1();
        } else if (Intrinsics.areEqual(ratingDialogCommand, RatingDialogCommand.ShowFeedbackDialog.f96067a)) {
            RatingDialogActivity.o1(this.f96012c, this.f96013d, null, 2, null);
        } else if (Intrinsics.areEqual(ratingDialogCommand, RatingDialogCommand.StartSupportIntent.f96068a)) {
            this.f96012c.s1();
        } else {
            if (!(ratingDialogCommand instanceof RatingDialogCommand.Close)) {
                throw new NoWhenBranchMatchedException();
            }
            RatingDialogActivity ratingDialogActivity = this.f96012c;
            ratingDialogActivity.Y0(ratingDialogActivity.f95987j, ((RatingDialogCommand.Close) ratingDialogCommand).a());
        }
        return Unit.f139807a;
    }
}
