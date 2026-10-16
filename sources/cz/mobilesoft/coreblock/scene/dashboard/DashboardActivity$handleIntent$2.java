package cz.mobilesoft.coreblock.scene.dashboard;

import android.content.Intent;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity;
import cz.mobilesoft.coreblock.scene.whats_new.WhatsNewFullScreenActivity;
import cz.mobilesoft.coreblock.util.constants.WhatsNewData;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$handleIntent$2", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$handleIntent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f99202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99203c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$handleIntent$2(Intent intent, DashboardActivity dashboardActivity, Continuation continuation) {
        super(2, continuation);
        this.f99202b = intent;
        this.f99203c = dashboardActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$handleIntent$2(this.f99202b, this.f99203c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f99201a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String stringExtra = this.f99202b.getStringExtra("SHORTCUT_ACTION");
        if (stringExtra != null) {
            DashboardActivity dashboardActivity = this.f99203c;
            Intent intent = this.f99202b;
            dashboardActivity.f99142l.setValue(stringExtra);
            intent.removeExtra("SHORTCUT_ACTION");
        }
        if (this.f99202b.getBooleanExtra("OPEN_BLOCK_NOTIFICATIONS", false)) {
            DashboardActivity dashboardActivity2 = this.f99203c;
            dashboardActivity2.startActivity(BlockedNotificationsActivity.f107859o.a(dashboardActivity2));
        } else if (this.f99202b.getSerializableExtra("STATISTICS_INTERVAL") != null) {
            DashboardActivity dashboardActivity3 = this.f99203c;
            dashboardActivity3.startActivity(WeeklyInsightsActivity.f103883g.b(dashboardActivity3));
        } else if (this.f99202b.getBooleanExtra("OPEN_CHANGELOG", false) && this.f99203c.f99143m.compareAndSet(false, true)) {
            String strL = LockieApplication.l();
            Intrinsics.checkNotNullExpressionValue(strL, "getVersionName(...)");
            if (WhatsNewData.f128462a.a().containsKey(StringsKt.t1(strL).toString())) {
                DashboardActivity dashboardActivity4 = this.f99203c;
                dashboardActivity4.startActivity(WhatsNewFullScreenActivity.Companion.b(WhatsNewFullScreenActivity.f123056h, dashboardActivity4, null, 2, null));
            }
        }
        if (this.f99202b.getBooleanExtra("SHOW_QUICK_BLOCK_ERROR_DIALOG", false)) {
            DialogHelper.o(this.f99203c);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$handleIntent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
