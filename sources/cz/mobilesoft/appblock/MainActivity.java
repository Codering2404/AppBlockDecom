package cz.mobilesoft.appblock;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import cz.mobilesoft.appblock.service.NotificationCollectorMonitorService;
import cz.mobilesoft.appblock.service.StartScreenReceiverService;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MainActivity extends cz.mobilesoft.coreblock.MainActivity {
    public static final int K = cz.mobilesoft.coreblock.MainActivity.I;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.MainActivity$onInitialized$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.MainActivity$onInitialized$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f93834a;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MainActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f93834a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Bundle extras = MainActivity.this.getIntent().getExtras();
            if (extras != null) {
                MainActivity mainActivity = MainActivity.this;
                String string = extras.getString("campaignId");
                PendingIntent pendingIntentN = null;
                Long lW = string != null ? StringsKt.w(string) : null;
                if (lW != null) {
                    Paywall paywall = Paywall.f113165a;
                    Context applicationContext = mainActivity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    Intent intentC = Paywall.c(paywall, applicationContext, new PaywallTarget.Campaign(lW.longValue(), CampaignSource.Notification, SDKConstants.PARAM_INTENT), "notification", "notification", false, false, false, null, 240, null);
                    intentC.setFlags(268468224);
                    pendingIntentN = NotificationHelper.o(NotificationHelper.f128940a, mainActivity, intentC, null, false, 12, null);
                } else if (Intrinsics.areEqual("APPBLOCK_DISCOUNT", extras.getString("click_action"))) {
                    Paywall paywall2 = Paywall.f113165a;
                    Context applicationContext2 = mainActivity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                    Intent intentC2 = Paywall.c(paywall2, applicationContext2, new PaywallTarget.Discount(RevenueCatPlacement.Campaign, DiscountSource.NOTIFICATION, false, null), "notification", null, false, false, false, null, 248, null);
                    intentC2.setFlags(268468224);
                    pendingIntentN = NotificationHelper.f128940a.n(mainActivity, intentC2, extras.getString("discount_message"), true);
                }
                if (pendingIntentN != null) {
                    try {
                        pendingIntentN.send();
                    } catch (PendingIntent.CanceledException unused) {
                    }
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    @Override // cz.mobilesoft.coreblock.MainActivity, cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
    public void onInitialized() {
        super.onInitialized();
        try {
            startService(new Intent(this, (Class<?>) StartScreenReceiverService.class));
        } catch (IllegalStateException unused) {
        }
        try {
            startService(new Intent(this, (Class<?>) NotificationCollectorMonitorService.class));
        } catch (IllegalStateException unused2) {
        }
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new AnonymousClass1(null), 3, null);
    }
}
