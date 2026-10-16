package cz.mobilesoft.coreblock.rest.interceptor;

import cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor$intercept$1", f = "ErrorLogInterceptor.kt", l = {63}, m = "invokeSuspend", v = 1)
final class ErrorLogInterceptor$intercept$1 extends SuspendLambda implements Function3<List<? extends String>, List<? extends String>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f98526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f98527d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f98528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Request f98529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ErrorLogInterceptor.ApiErrorDetails f98530h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ErrorLogInterceptor$intercept$1(String str, int i3, Request request, ErrorLogInterceptor.ApiErrorDetails apiErrorDetails, Continuation continuation) {
        super(3, continuation);
        this.f98527d = str;
        this.f98528f = i3;
        this.f98529g = request;
        this.f98530h = apiErrorDetails;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List list, List list2, Continuation continuation) {
        ErrorLogInterceptor$intercept$1 errorLogInterceptor$intercept$1 = new ErrorLogInterceptor$intercept$1(this.f98527d, this.f98528f, this.f98529g, this.f98530h, continuation);
        errorLogInterceptor$intercept$1.f98525b = list;
        errorLogInterceptor$intercept$1.f98526c = list2;
        return errorLogInterceptor$intercept$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f98525b;
        List list2 = (List) this.f98526c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98524a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CrashHelper crashHelper = CrashHelper.f127788a;
            String str = this.f98527d;
            Integer numD = Boxing.d(this.f98528f);
            String strH = this.f98529g.h();
            ErrorLogInterceptor.ApiErrorDetails apiErrorDetails = this.f98530h;
            this.f98525b = SpillingKt.a(list);
            this.f98526c = SpillingKt.a(list2);
            this.f98524a = 1;
            if (CrashHelper.g(crashHelper, str, numD, strH, apiErrorDetails, list, list2, null, this, 64, null) == objF) {
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
