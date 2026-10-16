package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.dto.AppCategoriesResponse;
import cz.mobilesoft.coreblock.dto.AppPackages;
import cz.mobilesoft.coreblock.rest.ApiInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ApplicationRepository$insertApplications$result$2", f = "ApplicationRepository.kt", l = {173}, m = "invokeSuspend", v = 1)
final class ApplicationRepository$insertApplications$result$2 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<AppCategoriesResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f97504c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationRepository$insertApplications$result$2(List list, Continuation continuation) {
        super(2, continuation);
        this.f97504c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ApplicationRepository$insertApplications$result$2 applicationRepository$insertApplications$result$2 = new ApplicationRepository$insertApplications$result$2(this.f97504c, continuation);
        applicationRepository$insertApplications$result$2.f97503b = obj;
        return applicationRepository$insertApplications$result$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((ApplicationRepository$insertApplications$result$2) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f97503b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97502a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AppPackages appPackages = new AppPackages(CollectionsKt.toList(this.f97504c));
        this.f97503b = SpillingKt.a(apiInterface);
        this.f97502a = 1;
        Object objN = apiInterface.n(appPackages, this);
        return objN == objF ? objF : objN;
    }
}
