package cz.mobilesoft.coreblock.scene.feedback;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$CommandProcessor$1$1", f = "FeedbackScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class FeedbackScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<FeedbackViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f102053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f102054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f102055d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f102056f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$CommandProcessor$1$1$1", f = "FeedbackScreen.kt", l = {387}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f102058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedbackViewCommand f102059c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, FeedbackViewCommand feedbackViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f102058b = scaffoldState;
            this.f102059c = feedbackViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f102058b, this.f102059c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102057a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f102058b.b();
                String strA = ((FeedbackViewCommand.ShowSnackBar) this.f102059c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f102057a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedbackScreenKt$CommandProcessor$1$1(CoroutineScope coroutineScope, Function0 function0, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f102054c = coroutineScope;
        this.f102055d = function0;
        this.f102056f = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FeedbackScreenKt$CommandProcessor$1$1 feedbackScreenKt$CommandProcessor$1$1 = new FeedbackScreenKt$CommandProcessor$1$1(this.f102054c, this.f102055d, this.f102056f, continuation);
        feedbackScreenKt$CommandProcessor$1$1.f102053b = obj;
        return feedbackScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FeedbackViewCommand feedbackViewCommand, Continuation continuation) {
        return ((FeedbackScreenKt$CommandProcessor$1$1) create(feedbackViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FeedbackViewCommand feedbackViewCommand = (FeedbackViewCommand) this.f102053b;
        IntrinsicsKt.f();
        if (this.f102052a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (feedbackViewCommand instanceof FeedbackViewCommand.ShowSnackBar) {
            BuildersKt__Builders_commonKt.d(this.f102054c, null, null, new AnonymousClass1(this.f102056f, feedbackViewCommand, null), 3, null);
        } else {
            if (!(feedbackViewCommand instanceof FeedbackViewCommand.TicketSend)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f102055d.invoke();
        }
        return Unit.f139807a;
    }
}
