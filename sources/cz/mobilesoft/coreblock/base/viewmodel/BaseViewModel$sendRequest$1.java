package cz.mobilesoft.coreblock.base.viewmodel;

import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.ApiResponse;
import cz.mobilesoft.coreblock.rest.RestClient;
import cz.mobilesoft.coreblock.util.Loading;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel$sendRequest$1", f = "BaseViewModel.kt", l = {94}, m = "invokeSuspend", v = 1)
final class BaseViewModel$sendRequest$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableLiveData f96443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApiInterface f96444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f96445d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseViewModel$sendRequest$1(MutableLiveData mutableLiveData, ApiInterface apiInterface, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.f96443b = mutableLiveData;
        this.f96444c = apiInterface;
        this.f96445d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseViewModel$sendRequest$1(this.f96443b, this.f96444c, this.f96445d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96442a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f96443b.n(Loading.f127895a);
            RestClient restClient = RestClient.f98457a;
            ApiInterface apiInterface = this.f96444c;
            Function2 function2 = this.f96445d;
            this.f96442a = 1;
            obj = restClient.H(apiInterface, function2, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f96443b.n(((ApiResponse) obj).b());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseViewModel$sendRequest$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
