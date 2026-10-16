package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import androidx.work.ListenableWorker;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$doWork$2", f = "CampaignCheckWorker.kt", l = {204}, m = "invokeSuspend", v = 1)
final class CampaignCheckWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CampaignCheckWorker f123918b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CampaignCheckWorker$doWork$2(CampaignCheckWorker campaignCheckWorker, Continuation continuation) {
        super(2, continuation);
        this.f123918b = campaignCheckWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CampaignCheckWorker$doWork$2(this.f123918b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123917a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CampaignCheckWorker.Companion companion = CampaignCheckWorker.f123877g;
        Context applicationContext = this.f123918b.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DiscountDataStore discountDataStoreK = this.f123918b.k();
        PremiumState premiumStateJ = this.f123918b.l().J();
        this.f123917a = 1;
        Object objD = companion.d(applicationContext, discountDataStoreK, premiumStateJ, this);
        return objD == objF ? objF : objD;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CampaignCheckWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
