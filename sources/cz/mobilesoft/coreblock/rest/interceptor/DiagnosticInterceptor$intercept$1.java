package cz.mobilesoft.coreblock.rest.interceptor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.rest.interceptor.DiagnosticInterceptor$intercept$1", f = "DiagnosticInterceptor.kt", l = {32}, m = "invokeSuspend", v = 1)
final class DiagnosticInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DiagnosticInterceptor f98511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DiagnosticRequestData f98512c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticInterceptor$intercept$1(DiagnosticInterceptor diagnosticInterceptor, DiagnosticRequestData diagnosticRequestData, Continuation continuation) {
        super(2, continuation);
        this.f98511b = diagnosticInterceptor;
        this.f98512c = diagnosticRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DiagnosticInterceptor$intercept$1(this.f98511b, this.f98512c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98510a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Function2 function2 = this.f98511b.f98509b;
            DiagnosticRequestData diagnosticRequestData = this.f98512c;
            this.f98510a = 1;
            if (function2.invoke(diagnosticRequestData, this) == objF) {
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
        return ((DiagnosticInterceptor$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
