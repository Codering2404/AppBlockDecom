package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$RootCompose$1$1", f = "RatingDialogActivity.kt", l = {295}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$RootCompose$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity f96019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f96020c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$RootCompose$1$1(RatingDialogActivity ratingDialogActivity, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f96019b = ratingDialogActivity;
        this.f96020c = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(RatingFlowEvent.OnReviewPreparationFailed.f96132a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1) {
        function1.invoke(RatingFlowEvent.OnReviewPreparationCancelled.f96131a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1, boolean z2) {
        function1.invoke(new RatingFlowEvent.OnReviewPreparationFinished(z2));
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RatingDialogActivity$RootCompose$1$1(this.f96019b, this.f96020c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96018a;
        if (i3 == 0) {
            ResultKt.b(obj);
            RatingDialogActivity ratingDialogActivity = this.f96019b;
            final Function1 function1 = this.f96020c;
            Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RatingDialogActivity$RootCompose$1$1.z(function1, ((Boolean) obj2).booleanValue());
                }
            };
            final Function1 function13 = this.f96020c;
            Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RatingDialogActivity$RootCompose$1$1.A(function13);
                }
            };
            final Function1 function14 = this.f96020c;
            Function0 function02 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RatingDialogActivity$RootCompose$1$1.G(function14);
                }
            };
            this.f96018a = 1;
            if (ratingDialogActivity.i1(function12, function0, function02, this) == objF) {
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
        return ((RatingDialogActivity$RootCompose$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
