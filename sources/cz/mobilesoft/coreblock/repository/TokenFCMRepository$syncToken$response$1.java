package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.RegisterDeviceRequest;
import cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity;
import cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import retrofit2.Response;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.TokenFCMRepository$syncToken$response$1", f = "TokenFCMRepository.kt", l = {79, 77}, m = "invokeSuspend", v = 1)
final class TokenFCMRepository$syncToken$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<Unit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f98411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f98413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f98414d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TokenFCMEntity f98415f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TokenFCMRepository$syncToken$response$1(TokenFCMEntity tokenFCMEntity, Continuation continuation) {
        super(2, continuation);
        this.f98415f = tokenFCMEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TokenFCMRepository$syncToken$response$1 tokenFCMRepository$syncToken$response$1 = new TokenFCMRepository$syncToken$response$1(this.f98415f, continuation);
        tokenFCMRepository$syncToken$response$1.f98414d = obj;
        return tokenFCMRepository$syncToken$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((TokenFCMRepository$syncToken$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        String str;
        ApiInterface apiInterface;
        ApiInterface apiInterface2 = (ApiInterface) this.f98414d;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98413c;
        if (i3 == 0) {
            ResultKt.b(obj);
            String strA = this.f98415f.a();
            DeviceIdUtils deviceIdUtils = DeviceIdUtils.f129470a;
            this.f98414d = SpillingKt.a(apiInterface2);
            this.f98411a = strA;
            this.f98412b = apiInterface2;
            this.f98413c = 1;
            objB = deviceIdUtils.b(this);
            if (objB != objF) {
                str = strA;
                apiInterface = apiInterface2;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        apiInterface = (ApiInterface) this.f98412b;
        String str2 = (String) this.f98411a;
        ResultKt.b(obj);
        str = str2;
        objB = obj;
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest(null, null, null, (String) objB, null, null, null, null, null, null, str, 1015, null);
        this.f98414d = SpillingKt.a(apiInterface2);
        this.f98411a = null;
        this.f98412b = null;
        this.f98413c = 2;
        Object objI = apiInterface.i(registerDeviceRequest, this);
        return objI == objF ? objF : objI;
    }
}
