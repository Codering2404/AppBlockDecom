package cz.mobilesoft.appblock.util;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class NotificationHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationHelper f95109a = new NotificationHelper();

    private NotificationHelper() {
    }

    public static final void c(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__BuildersKt.b(null, new NotificationHelper$showProfileEndNotification$1(j3, context, null), 1, null);
    }

    public static final void d(Context context, long j3, long j4, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__BuildersKt.b(null, new NotificationHelper$showProfileEndNotification$2(j3, context, j4, z2, z3, z4, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Context context, Profile profile, long j3, boolean z2, boolean z3, boolean z4) {
        CoroutinesHelperExtKt.d(new NotificationHelper$showProfileEndNotification$3(profile, j3, z2, z3, context, z4, null));
    }

    static /* synthetic */ void f(NotificationHelper notificationHelper, Context context, Profile profile, long j3, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            z4 = false;
        }
        notificationHelper.e(context, profile, j3, z2, z3, z4);
    }

    public final void b(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("NOTIFICATION_OPENED_EVENT_NAME", "usage_limit_end_notif_opened");
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.ALERT.getId()).l(cz.mobilesoft.coreblock.util.notifications.NotificationHelper.l(context, 953, true, bundle)).n(str).m(context.getString(R.string.notification_before_usage_limit_end_text)).f(true).B(R.drawable.ic_appblock_notification);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        notificationManagerCompatD.f(10003, builderB.c());
        AnswersHelper.f128199a.p8();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
