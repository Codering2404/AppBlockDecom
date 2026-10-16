package cz.mobilesoft.coreblock.scene.email_consent;

import cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivityKt$CommandProcessor$2$1", f = "EmailCommunicationConsentActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class EmailCommunicationConsentActivityKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<EmailConsentViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f101715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f101716c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmailCommunicationConsentActivityKt$CommandProcessor$2$1(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f101716c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        EmailCommunicationConsentActivityKt$CommandProcessor$2$1 emailCommunicationConsentActivityKt$CommandProcessor$2$1 = new EmailCommunicationConsentActivityKt$CommandProcessor$2$1(this.f101716c, continuation);
        emailCommunicationConsentActivityKt$CommandProcessor$2$1.f101715b = obj;
        return emailCommunicationConsentActivityKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(EmailConsentViewCommand emailConsentViewCommand, Continuation continuation) {
        return ((EmailCommunicationConsentActivityKt$CommandProcessor$2$1) create(emailConsentViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        EmailConsentViewCommand emailConsentViewCommand = (EmailConsentViewCommand) this.f101715b;
        IntrinsicsKt.f();
        if (this.f101714a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!Intrinsics.areEqual(emailConsentViewCommand, EmailConsentViewCommand.FinishActivity.f101719a)) {
            throw new NoWhenBranchMatchedException();
        }
        this.f101716c.invoke();
        return Unit.f139807a;
    }
}
