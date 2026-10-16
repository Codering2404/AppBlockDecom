package cz.mobilesoft.coreblock.rest;

import cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.rest.RestClient$buildApiInterface$1", f = "RestClient.kt", l = {265}, m = "invokeSuspend", v = 1)
final class RestClient$buildApiInterface$1 extends SuspendLambda implements Function2<DiagnosticRequestData, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98480b;

    RestClient$buildApiInterface$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RestClient$buildApiInterface$1 restClient$buildApiInterface$1 = new RestClient$buildApiInterface$1(continuation);
        restClient$buildApiInterface$1.f98480b = obj;
        return restClient$buildApiInterface$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DiagnosticRequestData diagnosticRequestData, Continuation continuation) {
        return ((RestClient$buildApiInterface$1) create(diagnosticRequestData, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DiagnosticRequestData diagnosticRequestData = (DiagnosticRequestData) this.f98480b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98479a;
        if (i3 == 0) {
            ResultKt.b(obj);
            RestClient restClient = RestClient.f98457a;
            this.f98480b = SpillingKt.a(diagnosticRequestData);
            this.f98479a = 1;
            if (restClient.K(diagnosticRequestData, this) == objF) {
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
}
