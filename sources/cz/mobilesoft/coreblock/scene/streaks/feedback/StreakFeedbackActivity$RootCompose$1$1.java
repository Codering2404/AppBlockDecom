package cz.mobilesoft.coreblock.scene.streaks.feedback;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackActivity$RootCompose$1$1", f = "StreakFeedbackActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class StreakFeedbackActivity$RootCompose$1$1 extends SuspendLambda implements Function2<FeedbackViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f120844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f120845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f120846d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f120847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StreakFeedbackActivity f120848g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackActivity$RootCompose$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackActivity$RootCompose$1$1$1", f = "StreakFeedbackActivity.kt", l = {48}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f120850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f120851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ StreakFeedbackActivity f120852d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, String str, StreakFeedbackActivity streakFeedbackActivity, Continuation continuation) {
            super(2, continuation);
            this.f120850b = scaffoldState;
            this.f120851c = str;
            this.f120852d = streakFeedbackActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f120850b, this.f120851c, this.f120852d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f120849a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f120850b.b();
                String str = this.f120851c;
                this.f120849a = 1;
                anonymousClass1 = this;
                if (SnackbarHostState.e(snackbarHostStateB, str, null, null, anonymousClass1, 6, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass1 = this;
            }
            anonymousClass1.f120852d.finish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakFeedbackActivity$RootCompose$1$1(CoroutineScope coroutineScope, ScaffoldState scaffoldState, String str, StreakFeedbackActivity streakFeedbackActivity, Continuation continuation) {
        super(2, continuation);
        this.f120845c = coroutineScope;
        this.f120846d = scaffoldState;
        this.f120847f = str;
        this.f120848g = streakFeedbackActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreakFeedbackActivity$RootCompose$1$1 streakFeedbackActivity$RootCompose$1$1 = new StreakFeedbackActivity$RootCompose$1$1(this.f120845c, this.f120846d, this.f120847f, this.f120848g, continuation);
        streakFeedbackActivity$RootCompose$1$1.f120844b = obj;
        return streakFeedbackActivity$RootCompose$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FeedbackViewCommand feedbackViewCommand, Continuation continuation) {
        return ((StreakFeedbackActivity$RootCompose$1$1) create(feedbackViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FeedbackViewCommand feedbackViewCommand = (FeedbackViewCommand) this.f120844b;
        IntrinsicsKt.f();
        if (this.f120843a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (feedbackViewCommand instanceof FeedbackViewCommand.TicketSend) {
            BuildersKt__Builders_commonKt.d(this.f120845c, null, null, new AnonymousClass1(this.f120846d, this.f120847f, this.f120848g, null), 3, null);
        }
        return Unit.f139807a;
    }
}
