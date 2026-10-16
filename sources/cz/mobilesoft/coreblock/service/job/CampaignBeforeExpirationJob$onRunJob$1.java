package cz.mobilesoft.coreblock.service.job;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob$onRunJob$1", f = "CampaignBeforeExpirationJob.kt", l = {31, 32, 34}, m = "invokeSuspend", v = 1)
final class CampaignBeforeExpirationJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f123188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f123189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f123190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CampaignBeforeExpirationJob f123191d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CampaignBeforeExpirationJob$onRunJob$1(CampaignBeforeExpirationJob campaignBeforeExpirationJob, Continuation continuation) {
        super(2, continuation);
        this.f123191d = campaignBeforeExpirationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CampaignBeforeExpirationJob$onRunJob$1(this.f123191d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CampaignBeforeExpirationJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f123190c
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L27
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            long r0 = r11.f123189b
            long r2 = r11.f123188a
            kotlin.ResultKt.b(r12)
            goto L82
        L19:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L21:
            long r5 = r11.f123188a
            kotlin.ResultKt.b(r12)
            goto L63
        L27:
            kotlin.ResultKt.b(r12)
            goto L48
        L2b:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob$Companion r12 = cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.f123184m
            java.lang.String r1 = "Job fired before campaign expiration"
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.Companion.a(r12, r1)
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob r12 = r11.f123191d
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r12 = r12.z()
            kotlinx.coroutines.flow.Flow r12 = r12.w0()
            r11.f123190c = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r11)
            if (r12 != r0) goto L48
            goto L7f
        L48:
            java.lang.Number r12 = (java.lang.Number) r12
            long r5 = r12.longValue()
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob r12 = r11.f123191d
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r12 = r12.z()
            kotlinx.coroutines.flow.Flow r12 = r12.v0()
            r11.f123188a = r5
            r11.f123190c = r3
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r11)
            if (r12 != r0) goto L63
            goto L7f
        L63:
            java.lang.Number r12 = (java.lang.Number) r12
            long r7 = r12.longValue()
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob r12 = r11.f123191d
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r12 = cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.y(r12)
            long r9 = java.lang.System.currentTimeMillis()
            r11.f123188a = r5
            r11.f123189b = r7
            r11.f123190c = r2
            java.lang.Object r12 = r12.a(r9, r11)
            if (r12 != r0) goto L80
        L7f:
            return r0
        L80:
            r2 = r5
            r0 = r7
        L82:
            cz.mobilesoft.coreblock.enums.RevenueCatOffering r12 = (cz.mobilesoft.coreblock.enums.RevenueCatOffering) r12
            cz.mobilesoft.coreblock.enums.RevenueCatOffering r5 = cz.mobilesoft.coreblock.enums.RevenueCatOffering.Campaign
            if (r12 != r5) goto Lb4
            long r5 = java.lang.System.currentTimeMillis()
            int r12 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r12 <= 0) goto Lb4
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob$Companion r12 = cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.f123184m
            java.lang.String r5 = "Showing notification"
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.Companion.a(r12, r5)
            cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO r12 = new cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO
            cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource r5 = cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource.Server
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.e(r0)
            r12.<init>(r2, r5, r0)
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r0 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob r1 = r11.f123191d
            android.content.Context r1 = cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.x(r1)
            r2 = 0
            java.lang.String r2 = androidx.media3.common.JBEE.bfIdKSjLOVjG.mEG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.w(r1, r12, r4)
            goto Lbb
        Lb4:
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob$Companion r12 = cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.f123184m
            java.lang.String r0 = "Campaign already expired, skipping"
            cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob.Companion.a(r12, r0)
        Lbb:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.CampaignBeforeExpirationJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
