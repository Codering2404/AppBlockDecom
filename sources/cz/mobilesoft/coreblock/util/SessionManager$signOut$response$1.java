package cz.mobilesoft.coreblock.util;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.DeleteUserRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.SessionManager$signOut$response$1", f = "SessionManager.kt", l = {165}, m = "invokeSuspend", v = 1)
final class SessionManager$signOut$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<Unit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f127957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f127958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f127959d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f127960f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionManager$signOut$response$1(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f127959d = str;
        this.f127960f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SessionManager$signOut$response$1 sessionManager$signOut$response$1 = new SessionManager$signOut$response$1(this.f127959d, this.f127960f, continuation);
        sessionManager$signOut$response$1.f127958c = obj;
        return sessionManager$signOut$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((SessionManager$signOut$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f127958c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127957b;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest(this.f127959d, Intrinsics.areEqual(this.f127960f, "apple_authorization_code") ? "apple" : this.f127960f);
        this.f127958c = SpillingKt.a(apiInterface);
        this.f127956a = SpillingKt.a(deleteUserRequest);
        this.f127957b = 1;
        Object objD = apiInterface.d(deleteUserRequest, this);
        return objD == objF ? objF : objD;
    }
}
