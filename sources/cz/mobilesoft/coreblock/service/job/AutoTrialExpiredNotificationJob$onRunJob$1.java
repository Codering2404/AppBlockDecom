package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import android.util.Log;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.AutoTrialExpiredNotificationJob$onRunJob$1", f = "AutoTrialExpiredNotificationJob.kt", l = {36}, m = "invokeSuspend", v = 1)
final class AutoTrialExpiredNotificationJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f123179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AutoTrialExpiredNotificationJob f123180c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoTrialExpiredNotificationJob$onRunJob$1(AutoTrialExpiredNotificationJob autoTrialExpiredNotificationJob, Continuation continuation) {
        super(2, continuation);
        this.f123180c = autoTrialExpiredNotificationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AutoTrialExpiredNotificationJob$onRunJob$1 autoTrialExpiredNotificationJob$onRunJob$1 = new AutoTrialExpiredNotificationJob$onRunJob$1(this.f123180c, continuation);
        autoTrialExpiredNotificationJob$onRunJob$1.f123179b = obj;
        return autoTrialExpiredNotificationJob$onRunJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutoTrialExpiredNotificationJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AutoTrialExpiredNotificationJob$onRunJob$1 autoTrialExpiredNotificationJob$onRunJob$1;
        List listA;
        CoroutineScope coroutineScope = (CoroutineScope) this.f123179b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123178a;
        if (i3 == 0) {
            ResultKt.b(obj);
            String simpleName = CoroutineScope.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.d(simpleName, "Job fired for auto-trial expired");
            PremiumRepositoryV2 premiumRepositoryV2Z = this.f123180c.z();
            CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.CACHED_OR_FETCHED;
            this.f123179b = SpillingKt.a(coroutineScope);
            this.f123178a = 1;
            autoTrialExpiredNotificationJob$onRunJob$1 = this;
            if (PremiumRepositoryV2.y(premiumRepositoryV2Z, cacheFetchPolicy, null, autoTrialExpiredNotificationJob$onRunJob$1, 2, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            autoTrialExpiredNotificationJob$onRunJob$1 = this;
        }
        CustomerInfo customerInfoB = autoTrialExpiredNotificationJob$onRunJob$1.f123180c.z().B();
        if (customerInfoB == null || (listA = RevenueCatExtKt.a(customerInfoB)) == null || !listA.contains(Entitlement.Premium)) {
            NotificationHelper notificationHelper = NotificationHelper.f128940a;
            Context contextC = autoTrialExpiredNotificationJob$onRunJob$1.f123180c.c();
            Intrinsics.checkNotNullExpressionValue(contextC, cJfnYMIyomoWf.kgnB);
            notificationHelper.v(contextC);
        }
        return Unit.f139807a;
    }
}
