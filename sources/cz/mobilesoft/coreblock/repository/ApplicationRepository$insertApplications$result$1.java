package cz.mobilesoft.coreblock.repository;

import android.content.pm.ResolveInfo;
import cz.mobilesoft.coreblock.dto.AppCategoriesResponse;
import cz.mobilesoft.coreblock.dto.AppPackages;
import cz.mobilesoft.coreblock.rest.ApiInterface;
import java.util.ArrayList;
import java.util.Iterator;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ApplicationRepository$insertApplications$result$1", f = "ApplicationRepository.kt", l = {91}, m = "invokeSuspend", v = 1)
final class ApplicationRepository$insertApplications$result$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<AppCategoriesResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f97501c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationRepository$insertApplications$result$1(List list, Continuation continuation) {
        super(2, continuation);
        this.f97501c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ApplicationRepository$insertApplications$result$1 applicationRepository$insertApplications$result$1 = new ApplicationRepository$insertApplications$result$1(this.f97501c, continuation);
        applicationRepository$insertApplications$result$1.f97500b = obj;
        return applicationRepository$insertApplications$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((ApplicationRepository$insertApplications$result$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f97500b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97499a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        List list = this.f97501c;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        AppPackages appPackages = new AppPackages(arrayList);
        this.f97500b = SpillingKt.a(apiInterface);
        this.f97499a = 1;
        Object objN = apiInterface.n(appPackages, this);
        return objN == objF ? objF : objN;
    }
}
