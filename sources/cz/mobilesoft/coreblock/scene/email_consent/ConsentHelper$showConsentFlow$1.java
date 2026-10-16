package cz.mobilesoft.coreblock.scene.email_consent;

import cz.mobilesoft.coreblock.enums.EmailConsentState;
import cz.mobilesoft.coreblock.enums.PendingEmailConsentState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper$showConsentFlow$1", f = "EmailConsentViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class ConsentHelper$showConsentFlow$1 extends SuspendLambda implements Function4<EmailConsentState, Boolean, PendingEmailConsentState, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f101698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ boolean f101699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f101700d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ConsentHelper f101701f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConsentHelper$showConsentFlow$1(ConsentHelper consentHelper, Continuation continuation) {
        super(4, continuation);
        this.f101701f = consentHelper;
    }

    public final Object h(EmailConsentState emailConsentState, boolean z2, PendingEmailConsentState pendingEmailConsentState, Continuation continuation) {
        ConsentHelper$showConsentFlow$1 consentHelper$showConsentFlow$1 = new ConsentHelper$showConsentFlow$1(this.f101701f, continuation);
        consentHelper$showConsentFlow$1.f101698b = emailConsentState;
        consentHelper$showConsentFlow$1.f101699c = z2;
        consentHelper$showConsentFlow$1.f101700d = pendingEmailConsentState;
        return consentHelper$showConsentFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h((EmailConsentState) obj, ((Boolean) obj2).booleanValue(), (PendingEmailConsentState) obj3, (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        EmailConsentState emailConsentState = (EmailConsentState) this.f101698b;
        boolean z2 = this.f101699c;
        PendingEmailConsentState pendingEmailConsentState = (PendingEmailConsentState) this.f101700d;
        IntrinsicsKt.f();
        if (this.f101697a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(this.f101701f.g(emailConsentState, pendingEmailConsentState, z2));
    }
}
