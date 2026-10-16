package cz.mobilesoft.coreblock.util.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.glance.session.ecY.lisODU;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.firebase.messaging.RemoteMessage;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.MainActivity;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity;
import cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryActivity;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailActivity;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneActivity;
import cz.mobilesoft.coreblock.scene.timenudge.TimeNudgeActivity;
import cz.mobilesoft.coreblock.storage.datastore.entity.DiscountNotificationSettings;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository;
import java.text.MessageFormat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationHelper f128940a = new NotificationHelper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128941a;

        static {
            int[] iArr = new int[RevenueCatPlacement.values().length];
            try {
                iArr[RevenueCatPlacement.Discount20.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RevenueCatPlacement.Discount50.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f128941a = iArr;
        }
    }

    private NotificationHelper() {
    }

    private final int O(int i3) {
        return i3 == 1 ? R.string.nB : (2 > i3 || i3 >= 7) ? i3 == 7 ? R.string.pB : i3 == 30 ? R.string.mB : R.string.lB : R.string.oB;
    }

    public static final NotificationCompat.Builder k(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent pendingIntentL = l(context, 952, true, str2 != null ? BundleKt.b(TuplesKt.a("NOTIFICATION_OPENED_EVENT_NAME", str2)) : null);
        Intent intent = new Intent("cz.mobilesoft.NOTIFICATION_DISMISSED");
        intent.setPackage(LockieApplication.f95360f);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 201326592);
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.ALERT;
        String string = (str == null || str.length() == 0) ? context.getResources().getString(R.string.rv, "") : context.getResources().getString(R.string.rv, str);
        Intrinsics.checkNotNull(string);
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, channel.getId()).l(pendingIntentL).n(string).w(true).f(true).p(broadcast).B(R.drawable.C0);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        return builderB;
    }

    public static final PendingIntent l(Context context, int i3, boolean z2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = MainActivity.H.a(context);
        intentA.putExtra("SHOW_OREO_NOTIFICATION_DIALOG", z2);
        if (bundle != null) {
            intentA.putExtras(bundle);
        }
        intentA.setFlags(603979776);
        return ContextExtKt.e(context, i3, intentA, f128940a.p());
    }

    public static final PendingIntent m(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentB = SettingsActivity.Companion.b(SettingsActivity.f108043h, context, SettingsScreenType.TIME_NUDGE, false, 4, null);
        intentB.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "time_poke_service_notif_opened");
        intentB.setFlags(603979776);
        return ContextExtKt.e(context, 973, intentB, f128940a.p());
    }

    public static /* synthetic */ PendingIntent o(NotificationHelper notificationHelper, Context context, Intent intent, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        return notificationHelper.n(context, intent, str, z2);
    }

    private final int p() {
        return 201326592;
    }

    static /* synthetic */ Intent t(NotificationHelper notificationHelper, Context context, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return notificationHelper.s(context, str);
    }

    public static /* synthetic */ void x(NotificationHelper notificationHelper, Context context, CurrentCampaignDTO currentCampaignDTO, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        notificationHelper.w(context, currentCampaignDTO, z2);
    }

    public final void A(Context context, int i3, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = InAppUpdateActivity.f102432h.a(context, "notification");
        intentA.setFlags(268468224);
        intentA.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "inapp_update_notif_opened");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 956, intentA, p());
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.APP_UPDATES;
        String string = context.getString(R.string.f95807j1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(InAppUpdatesRepository.f129855a.r(i3));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(string).m(string2).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).D(new NotificationCompat.BigTextStyle().h(string2)).l(pendingIntentE).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        notificationManagerCompatD.f(10009, notificationC);
        AnswersHelper.f128199a.g2(num);
    }

    public final void B(Context context, RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        RemoteMessage.Notification notificationN = remoteMessage.N();
        if (notificationN != null) {
            CoroutinesHelperExtKt.d(new NotificationHelper$showNotificationFromFCM$1$1(remoteMessage, context, notificationN, null));
        }
    }

    public final String C(Context context, RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Bundle extras = remoteMessage.O().getExtras();
        String string = extras != null ? extras.getString("target") : null;
        if (Intrinsics.areEqual(string, "strictModeUnlock")) {
            G(context, R.string.DB, R.string.CB);
        }
        return string;
    }

    public final void D(Context context, long j3, int i3, Pair pair) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = MainActivity.H.a(context);
        intentA.setFlags(268468224);
        intentA.putExtra("STATISTICS_INTERVAL", pair);
        intentA.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "stats_week_notif_opened");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 961, intentA, p());
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.DEFAULT;
        String strC = DateHelper.c(Long.valueOf(j3));
        if (i3 >= 0) {
            string = context.getResources().getString(R.string.oA, Integer.valueOf(Math.abs(i3)), strC);
            Intrinsics.checkNotNull(string);
        } else {
            string = context.getResources().getString(R.string.nA, Integer.valueOf(Math.abs(i3)), strC);
            Intrinsics.checkNotNull(string);
        }
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(context.getResources().getString(R.string.pA)).m(string).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).D(new NotificationCompat.BigTextStyle().h(string)).x(3).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        notificationManagerCompatD.f(10005, builderF.c());
        AnswersHelper.f128199a.W6();
    }

    public final void E(Context context, String modeTag, int i3, long j3) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modeTag, "modeTag");
        PomodoroSession.SessionMode.Companion companion = PomodoroSession.SessionMode.f126444b;
        if (Intrinsics.areEqual(modeTag, companion.b())) {
            string = context.getString(R.string.so, String.valueOf(i3));
        } else if (!Intrinsics.areEqual(modeTag, companion.a())) {
            return;
        } else {
            string = context.getString(R.string.ro, Long.valueOf(j3));
        }
        Intrinsics.checkNotNull(string);
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.POMODORO.getId()).l(l(context, 965, true, BundleKt.b(TuplesKt.a("NOTIFICATION_OPENED_EVENT_NAME", "pomodoro_notification_opened")))).n(context.getString(R.string.jo)).m(string).f(true).B(R.drawable.C0);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        if (PermissionHelper.o(context)) {
            notificationManagerCompatD.f(10003, builderB.c());
            AnswersHelper.f128199a.K3();
        }
    }

    public final void F(Context context, DiscountNotificationSettings settings, RevenueCatPlacement placement, boolean z2, boolean z3) {
        int i3;
        String title;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(placement, "placement");
        String formattedText = null;
        Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.Discount(placement, DiscountSource.SCHEDULED_NOTIFICATION, false, null), "notification", null, false, false, false, null, 248, null);
        intentC.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "discount_notification_opened");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 957, intentC, p());
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.OFFERS;
        int i4 = WhenMappings.f128941a[placement.ordinal()];
        if (i4 == 1) {
            i3 = 20;
        } else if (i4 != 2) {
            return;
        } else {
            i3 = 50;
        }
        boolean zF = ContextExtKt.f(context);
        if (z2) {
            int i5 = z3 ? 2 : 1;
            if (zF) {
                String title2 = settings.getTitle(i5);
                formattedText = settings.getFormattedText(i5, i3);
                title = title2;
            } else {
                title = null;
            }
            if (title == null) {
                title = MessageFormat.format("🎁 {0}", context.getString(R.string.ED));
                Intrinsics.checkNotNullExpressionValue(title, "format(...)");
            }
            if (formattedText == null) {
                string = context.getString(R.string.F9, context.getString(R.string.f95790f1), Integer.valueOf(i3));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                formattedText = string;
            }
        } else {
            if (zF) {
                title = settings.getTitle(0);
                formattedText = settings.getFormattedText(0, i3);
            } else {
                title = null;
            }
            if (title == null) {
                title = MessageFormat.format("🎁 {0}", context.getString(R.string.N4));
                Intrinsics.checkNotNullExpressionValue(title, "format(...)");
            }
            if (formattedText == null) {
                string = context.getString(R.string.G9, context.getString(R.string.f95790f1), Integer.valueOf(i3));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                formattedText = string;
            }
        }
        String str = formattedText;
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(title).m(str).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).D(new NotificationCompat.BigTextStyle().h(str)).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        notificationManagerCompatD.f(10010, notificationC);
        AnswersHelper.f128199a.D1(i3, placement.getId(), z2, z3);
    }

    public final void G(Context context, int i3, int i4) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.ALERT.getId()).n(context.getString(i3)).m(context.getText(i4)).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(l(context, 964, false, BundleKt.b(TuplesKt.a("NOTIFICATION_OPENED_EVENT_NAME", "fcm_target_notification_opened")))).x(1).H(1).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        if (PermissionHelper.o(context)) {
            NotificationManagerCompat.d(context).f(100016, builderF.c());
            AnswersHelper.f128199a.Q1();
        }
    }

    public final void H(Context context, int i3) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentB = StreakMilestoneActivity.f120940g.b(context, i3);
        intentB.setFlags(603979776);
        PendingIntent pendingIntentE = ContextExtKt.e(context, 971, intentB, p());
        if (i3 == 1) {
            string = context.getString(R.string.kB);
        } else {
            string = i3 + " " + context.getString(R.string.VA);
        }
        Intrinsics.checkNotNull(string);
        String string2 = context.getString(O(i3));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.DEFAULT.getId()).n(string).m(string2).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).D(new NotificationCompat.BigTextStyle().h(string2)).x(3).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        notificationManagerCompatD.f(100022, builderF.c());
    }

    public final void I(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = StreakDetailActivity.f120665g.a(context);
        intentA.setFlags(603979776);
        PendingIntent pendingIntentE = ContextExtKt.e(context, 970, intentA, p());
        String string = context.getString(R.string.qB, String.valueOf(i3));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.DEFAULT.getId()).n(context.getString(R.string.rB)).m(string).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).D(new NotificationCompat.BigTextStyle().h(string)).x(3).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        notificationManagerCompatD.f(100021, builderF.c());
    }

    public final void J(Context context, int i3) {
        String str;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentB = PremiumExpiringActivity.Companion.b(PremiumExpiringActivity.f113543g, context, "notification", "notification", null, 8, null);
        intentB.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "sub_expired_offer_notif_opened");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 950, intentB, p());
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.OFFERS;
        if (i3 == 2) {
            str = MessageFormat.format("🎁 {0}", context.getString(R.string.LD));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            string = context.getString(R.string.qC, 50);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            str = MessageFormat.format("❗ {0}", context.getString(R.string.RD));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            string = context.getString(R.string.pC);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(str).m(string).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        notificationManagerCompatD.f(10007, notificationC);
        AnswersHelper.f128199a.S7(i3);
    }

    public final void K(Context context, PickTimeNudgeNotificationMessageUseCase.Message message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        String strB = message.b();
        String strA = message.a();
        NotificationCompat.Builder builderK = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.TIME_NUDGE.getId()).l(ContextExtKt.e(context, 972, TimeNudgeActivity.f122848f.a(context, message.c()), p())).n(strB).m(strA).D(new NotificationCompat.BigTextStyle().h(strA)).f(true).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a));
        Intrinsics.checkNotNullExpressionValue(builderK, "setColor(...)");
        if (PermissionHelper.o(context)) {
            NotificationManagerCompat.d(context).f(100023, builderK.c());
            AnswersHelper.f128199a.b8(message.c());
        }
    }

    public final boolean L(Context context, String productId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(productId, "productId");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 969, s(context, productId), p());
        NotificationCompat.Builder builderN = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.ALERT.getId()).n(context.getString(R.string.gE));
        int i3 = R.string.fE;
        Notification notificationC = builderN.m(context.getString(i3)).D(new NotificationCompat.BigTextStyle().h(context.getString(i3))).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).f(true).c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        if (!PermissionHelper.o(context)) {
            AnswersHelper.f128199a.g8();
            return false;
        }
        NotificationManagerCompat.d(context).f(100020, notificationC);
        AnswersHelper.f128199a.e8();
        return true;
    }

    public final boolean M(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent pendingIntentE = ContextExtKt.e(context, 968, t(this, context, null, 2, null), p());
        NotificationCompat.Builder builderN = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.ALERT.getId()).n(context.getResources().getQuantityString(R.plurals.f95762w, 3, 3));
        int i3 = R.string.hE;
        Notification notificationC = builderN.m(context.getString(i3)).D(new NotificationCompat.BigTextStyle().h(context.getString(i3))).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentE).f(true).c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        if (!PermissionHelper.o(context)) {
            AnswersHelper.f128199a.g8();
            return false;
        }
        NotificationManagerCompat.d(context).f(100019, notificationC);
        AnswersHelper.f128199a.h8();
        return true;
    }

    public final void N(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentA = TrialSummaryActivity.f103592g.a(context);
        intentA.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "trial_reminder_opened");
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.OFFERS.getId()).l(ContextExtKt.e(context, 959, intentA, p())).n(context.getString(R.string.mE)).m(context.getString(R.string.lE)).f(true).B(R.drawable.C0);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        if (!PermissionHelper.o(context)) {
            AnswersHelper.f128199a.i8();
        } else {
            notificationManagerCompatD.f(10012, builderB.c());
            AnswersHelper.f128199a.j8();
        }
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10008);
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(100018);
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10011);
    }

    public final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10004);
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(100015);
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10009);
    }

    public final void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10010);
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10013);
    }

    public final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10007);
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.d(context).b(10012);
    }

    public final PendingIntent n(Context context, Intent intent, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("discount_message", str);
        intent.putExtra("discount_source", DiscountSource.NOTIFICATION);
        intent.putExtra("ITEM_AVAILABLE", z2);
        return ContextExtKt.e(context, 960, intent, p());
    }

    public final Notification q(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.STATE.getId());
        builder.g(0);
        builder.v(true);
        builder.B(R.drawable.C0);
        builder.x(-1);
        builder.z(false);
        builder.A(true);
        Notification notificationC = builder.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "with(...)");
        ((NotificationManager) systemService).notify(10013, notificationC);
        return notificationC;
    }

    public final void u(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent pendingIntentL = l(context, 954, false, BundleKt.b(TuplesKt.a("OPEN_CHANGELOG", Boolean.TRUE), TuplesKt.a("NOTIFICATION_OPENED_EVENT_NAME", "changelog_notification_opened")));
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.APP_UPDATES;
        String string = context.getString(R.string.f95832p1, context.getString(R.string.f95790f1));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.BH);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(string).m(string2).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(pendingIntentL).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        notificationManagerCompatD.f(10008, notificationC);
        AnswersHelper.f128199a.l1();
    }

    public final void v(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.AutoTrialPromo(true), "notification", "auto_trial_label", false, false, false, null, 240, null);
        intentC.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "auto_trial_expired_notif_opened");
        NotificationCompat.Builder builderB = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.OFFERS.getId()).l(ContextExtKt.e(context, 967, intentC, p())).n(context.getString(R.string.f95769a2)).o(-1).I(System.currentTimeMillis()).k(ContextCompat.getColor(context, R.color.f95446a)).f(true).B(R.drawable.C0);
        Intrinsics.checkNotNullExpressionValue(builderB, "setSmallIcon(...)");
        if (PermissionHelper.o(context)) {
            NotificationManagerCompat.d(context).f(100018, builderB.c());
        }
    }

    public final void w(Context context, CurrentCampaignDTO campaignDTO, boolean z2) {
        String str;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(campaignDTO, "campaignDTO");
        if (PrefManager.f126839a.r1()) {
            Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.Campaign(campaignDTO.b(), campaignDTO.c(), "server"), "notification", "notification", false, false, false, null, 240, null);
            intentC.putExtra("NOTIFICATION_OPENED_EVENT_NAME", z2 ? "campaign_exp_notif_opened" : "campaign_notification_opened");
            PendingIntent pendingIntentE = ContextExtKt.e(context, 958, intentC, p());
            NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.OFFERS;
            if (z2) {
                str = MessageFormat.format("🎁 {0}", context.getString(R.string.ED));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                string = context.getString(R.string.F9, context.getString(R.string.f95790f1), 50);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } else {
                str = MessageFormat.format("🎁 {0}", context.getString(R.string.nc));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                string = context.getString(R.string.D9, context.getString(R.string.f95790f1));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, channel.getId()).n(str).m(string).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).D(new NotificationCompat.BigTextStyle().h(string)).l(pendingIntentE).f(true);
            Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
            NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
            Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
            Notification notificationC = builderF.c();
            Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
            notificationManagerCompatD.f(10011, notificationC);
            if (z2) {
                AnswersHelper.f128199a.Y0(campaignDTO.b());
            } else {
                AnswersHelper.f128199a.Z0(campaignDTO.b());
            }
        }
    }

    public final void y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentC = Paywall.c(Paywall.f113165a, context, PaywallTarget.TrialRetention.INSTANCE, "notification", "notification", false, false, false, null, 240, null);
        intentC.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "cancelled_trial_notif_opened");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.OFFERS.getId()).n(context.getString(R.string.sE)).m(context.getString(R.string.rE)).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(ContextExtKt.e(context, 963, intentC, p())).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        if (!PermissionHelper.o(context)) {
            AnswersHelper.f128199a.d1();
        } else {
            notificationManagerCompatD.f(100015, notificationC);
            AnswersHelper.f128199a.e1();
        }
    }

    public final void z(Context context, String title, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intentA = MainActivity.H.a(context);
        intentA.setFlags(268468224);
        intentA.putExtra("DASHBOARD_TAB", DashboardActivity.NavBarItem.Insights.f99176i.c());
        intentA.putExtra("NOTIFICATION_ID", 100017);
        intentA.putExtra("NOTIFICATION_OPENED_EVENT_NAME", "insights_motiv_notif_opened");
        NotificationCompat.Builder builderF = new NotificationCompat.Builder(context, NotificationChannelHelper.Channel.DEFAULT.getId()).n(title).m(text).o(-1).I(System.currentTimeMillis()).B(R.drawable.C0).k(ContextCompat.getColor(context, R.color.f95446a)).l(ContextExtKt.e(context, 966, intentA, p())).D(new NotificationCompat.BigTextStyle().h(text)).x(3).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        notificationManagerCompatD.f(100017, builderF.c());
        AnswersHelper.f128199a.p2();
    }

    public static final void r(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 31) {
            context.sendBroadcast(new Intent(lisODU.NIHFgPt));
        }
    }

    private final Intent s(Context context, String str) {
        String str2;
        if (str != null) {
            str2 = "https://play.google.com/store/account/subscriptions?sku=" + str + pMpIcGE.YbOu + context.getPackageName();
        } else {
            str2 = "https://play.google.com/store/account/subscriptions";
        }
        return new Intent("android.intent.action.VIEW", Uri.parse(str2));
    }
}
