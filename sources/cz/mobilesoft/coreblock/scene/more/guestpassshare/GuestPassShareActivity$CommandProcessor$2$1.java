package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity$CommandProcessor$2$1", f = "GuestPassShareActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class GuestPassShareActivity$CommandProcessor$2$1 extends SuspendLambda implements Function2<PremiumScreenViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f107432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f107433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f107434d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f107435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ GuestPassShareActivity f107436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 f107437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f107438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f107439j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestPassShareActivity$CommandProcessor$2$1(Function0 function0, Context context, MutableState mutableState, GuestPassShareActivity guestPassShareActivity, GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, ManagedActivityResultLauncher managedActivityResultLauncher, String str, Continuation continuation) {
        super(2, continuation);
        this.f107433c = function0;
        this.f107434d = context;
        this.f107435f = mutableState;
        this.f107436g = guestPassShareActivity;
        this.f107437h = guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1;
        this.f107438i = managedActivityResultLauncher;
        this.f107439j = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GuestPassShareActivity$CommandProcessor$2$1 guestPassShareActivity$CommandProcessor$2$1 = new GuestPassShareActivity$CommandProcessor$2$1(this.f107433c, this.f107434d, this.f107435f, this.f107436g, this.f107437h, this.f107438i, this.f107439j, continuation);
        guestPassShareActivity$CommandProcessor$2$1.f107432b = obj;
        return guestPassShareActivity$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PremiumScreenViewCommand premiumScreenViewCommand, Continuation continuation) {
        return ((GuestPassShareActivity$CommandProcessor$2$1) create(premiumScreenViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PremiumScreenViewCommand premiumScreenViewCommand = (PremiumScreenViewCommand) this.f107432b;
        IntrinsicsKt.f();
        if (this.f107431a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.FinishGuestPass.f112345a)) {
            this.f107433c.invoke();
        } else if (Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.OpenShare.f112346a)) {
            Intent intent = new Intent();
            String str = this.f107439j;
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("text/plain");
            String string = this.f107434d.getString(R.string.Zh);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str2 = LockieApplication.f95360f + ".SHARE_GUEST_PASS_ACTION";
            int i3 = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
            Context context = this.f107434d;
            Intent intent2 = new Intent(str2);
            intent2.setPackage(this.f107434d.getPackageName());
            Unit unit = Unit.f139807a;
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, i3 | 134217728);
            if (((Boolean) this.f107435f.getValue()).booleanValue()) {
                Context context2 = this.f107434d;
                GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 = this.f107437h;
                try {
                    Result.Companion companion = Result.f139772b;
                    context2.unregisterReceiver(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1);
                    Result.b(Unit.f139807a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    Result.b(ResultKt.a(th));
                }
                this.f107435f.setValue(Boxing.a(false));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.f107434d.registerReceiver(this.f107437h, new IntentFilter(str2), 2);
            } else {
                this.f107434d.registerReceiver(this.f107437h, new IntentFilter(str2));
            }
            this.f107435f.setValue(Boxing.a(true));
            Intent intentCreateChooser = Intent.createChooser(intent, string, broadcast.getIntentSender());
            ManagedActivityResultLauncher managedActivityResultLauncher = this.f107438i;
            Intrinsics.checkNotNull(intentCreateChooser);
            managedActivityResultLauncher.b(intentCreateChooser);
        }
        return Unit.f139807a;
    }
}
