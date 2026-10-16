package cz.mobilesoft.coreblock.scene.feedback;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$RootCompose$1$1", f = "FeedbackScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class FeedbackScreenKt$RootCompose$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FeedbackViewState f102064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f102065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BringIntoViewRequester f102066d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$RootCompose$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$RootCompose$1$1$1", f = "FeedbackScreen.kt", l = {265}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BringIntoViewRequester f102068b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BringIntoViewRequester bringIntoViewRequester, Continuation continuation) {
            super(2, continuation);
            this.f102068b = bringIntoViewRequester;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f102068b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102067a;
            if (i3 == 0) {
                ResultKt.b(obj);
                BringIntoViewRequester bringIntoViewRequester = this.f102068b;
                this.f102067a = 1;
                if (BringIntoViewRequester.a(bringIntoViewRequester, null, this, 1, null) == objF) {
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
    FeedbackScreenKt$RootCompose$1$1(FeedbackViewState feedbackViewState, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, Continuation continuation) {
        super(2, continuation);
        this.f102064b = feedbackViewState;
        this.f102065c = coroutineScope;
        this.f102066d = bringIntoViewRequester;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FeedbackScreenKt$RootCompose$1$1(this.f102064b, this.f102065c, this.f102066d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f102063a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f102064b.n().contains(FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch) || this.f102064b.n().contains(FeedbackViewState.FeedbackValidationError.EmailIsInvalid)) {
            BuildersKt__Builders_commonKt.d(this.f102065c, null, null, new AnonymousClass1(this.f102066d, null), 3, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FeedbackScreenKt$RootCompose$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
