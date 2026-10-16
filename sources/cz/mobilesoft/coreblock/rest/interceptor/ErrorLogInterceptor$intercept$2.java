package cz.mobilesoft.coreblock.rest.interceptor;

import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.Request;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor$intercept$2", f = "ErrorLogInterceptor.kt", l = {81}, m = "invokeSuspend", v = 1)
final class ErrorLogInterceptor$intercept$2 extends SuspendLambda implements Function3<List<? extends String>, List<? extends String>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f98533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Request f98534d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f98535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ IOException f98536g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ErrorLogInterceptor$intercept$2(Request request, String str, IOException iOException, Continuation continuation) {
        super(3, continuation);
        this.f98534d = request;
        this.f98535f = str;
        this.f98536g = iOException;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List list, List list2, Continuation continuation) {
        ErrorLogInterceptor$intercept$2 errorLogInterceptor$intercept$2 = new ErrorLogInterceptor$intercept$2(this.f98534d, this.f98535f, this.f98536g, continuation);
        errorLogInterceptor$intercept$2.f98532b = list;
        errorLogInterceptor$intercept$2.f98533c = list2;
        return errorLogInterceptor$intercept$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f98532b;
        List list2 = (List) this.f98533c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98531a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CrashHelper crashHelper = CrashHelper.f127788a;
            String strH = this.f98534d.h();
            String str = this.f98535f;
            IOException iOException = this.f98536g;
            this.f98532b = SpillingKt.a(list);
            this.f98533c = SpillingKt.a(list2);
            this.f98531a = 1;
            if (CrashHelper.g(crashHelper, str, null, strH, null, list, list2, iOException, this, 10, null) == objF) {
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
