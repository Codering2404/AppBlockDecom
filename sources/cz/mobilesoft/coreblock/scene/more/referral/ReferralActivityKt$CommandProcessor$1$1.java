package cz.mobilesoft.coreblock.scene.more.referral;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.activity.compose.ManagedActivityResultLauncher;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralViewCommand;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.referral.ReferralActivityKt$CommandProcessor$1$1", f = "ReferralActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class ReferralActivityKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<ReferralViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f107964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f107965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ReferralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 f107966d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f107967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f107968g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReferralActivityKt$CommandProcessor$1$1(Context context, ReferralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 referralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, ManagedActivityResultLauncher managedActivityResultLauncher, ManagedActivityResultLauncher managedActivityResultLauncher2, Continuation continuation) {
        super(2, continuation);
        this.f107965c = context;
        this.f107966d = referralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1;
        this.f107967f = managedActivityResultLauncher;
        this.f107968g = managedActivityResultLauncher2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ReferralActivityKt$CommandProcessor$1$1 referralActivityKt$CommandProcessor$1$1 = new ReferralActivityKt$CommandProcessor$1$1(this.f107965c, this.f107966d, this.f107967f, this.f107968g, continuation);
        referralActivityKt$CommandProcessor$1$1.f107964b = obj;
        return referralActivityKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ReferralViewCommand referralViewCommand, Continuation continuation) {
        return ((ReferralActivityKt$CommandProcessor$1$1) create(referralViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReferralViewCommand referralViewCommand = (ReferralViewCommand) this.f107964b;
        IntrinsicsKt.f();
        if (this.f107963a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (referralViewCommand instanceof ReferralViewCommand.OpenSharing) {
            ReferralViewCommand.OpenSharing openSharing = (ReferralViewCommand.OpenSharing) referralViewCommand;
            String string = this.f107965c.getString(R.string.ms, StringHelperExtKt.x(openSharing.a()));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strQ = StringHelperExtKt.q(string, openSharing.b(), null, 2, null);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", strQ);
            intent.setType("text/plain");
            String string2 = this.f107965c.getString(R.string.Zh);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String str = LockieApplication.f95360f + ".SHARE_REFERRAL_ACTION";
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f107965c, 0, new Intent(str), 201326592);
            Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
            ContextExtKt.h(this.f107965c, this.f107966d, new IntentFilter(str), 2);
            Intent intentCreateChooser = Intent.createChooser(intent, string2, broadcast.getIntentSender());
            ManagedActivityResultLauncher managedActivityResultLauncher = this.f107967f;
            Intrinsics.checkNotNull(intentCreateChooser);
            managedActivityResultLauncher.b(intentCreateChooser);
        } else {
            if (!Intrinsics.areEqual(referralViewCommand, ReferralViewCommand.OpenDiscount.f107970a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f107968g.b(Paywall.c(Paywall.f113165a, this.f107965c, new PaywallTarget.Discount(RevenueCatPlacement.ReferralSent, DiscountSource.REFERRAL_SENDER, false, null), "profile_tab", null, false, false, false, null, 248, null));
        }
        return Unit.f139807a;
    }
}
