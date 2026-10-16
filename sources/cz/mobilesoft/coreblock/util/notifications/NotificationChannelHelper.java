package cz.mobilesoft.coreblock.util.notifications;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class NotificationChannelHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationChannelHelper f128938a = new NotificationChannelHelper();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Channel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Channel[] $VALUES;
        private final boolean deprecated;
        private final String id;
        public static final Channel DEFAULT = new Channel("DEFAULT", 0, "DEFAULT_CHANNEL_ID", false, 2, null);
        public static final Channel STATE = new Channel("STATE", 1, "STATE_CHANNEL_ID", false, 2, null);
        public static final Channel USAGE_LIMIT = new Channel("USAGE_LIMIT", 2, "USAGE_LIMIT_CHANNEL_ID", false, 2, null);
        public static final Channel ALERT = new Channel("ALERT", 3, "ALERT_CHANNEL_ID_V2", false, 2, null);
        public static final Channel OFFERS = new Channel("OFFERS", 4, "OFFERS_CHANNEL_ID", false, 2, null);
        public static final Channel APP_UPDATES = new Channel("APP_UPDATES", 5, "APP_UPDATES_ID", false, 2, null);
        public static final Channel POMODORO = new Channel("POMODORO", 6, "POMODORO", false, 2, null);
        public static final Channel TIME_NUDGE = new Channel("TIME_NUDGE", 7, "TIME_NUDGE_CHANNEL_ID", false, 2, null);

        @Deprecated
        public static final Channel ALERT_V1 = new Channel("ALERT_V1", 8, "ALERT_CHANNEL_ID", true);

        private static final /* synthetic */ Channel[] $values() {
            return new Channel[]{DEFAULT, STATE, USAGE_LIMIT, ALERT, OFFERS, APP_UPDATES, POMODORO, TIME_NUDGE, ALERT_V1};
        }

        static {
            Channel[] channelArr$values = $values();
            $VALUES = channelArr$values;
            $ENTRIES = EnumEntriesKt.a(channelArr$values);
        }

        private Channel(String str, int i3, String str2, boolean z2) {
            this.id = str2;
            this.deprecated = z2;
        }

        public static EnumEntries<Channel> getEntries() {
            return $ENTRIES;
        }

        public static Channel valueOf(String str) {
            return (Channel) Enum.valueOf(Channel.class, str);
        }

        public static Channel[] values() {
            return (Channel[]) $VALUES.clone();
        }

        public final boolean getDeprecated() {
            return this.deprecated;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean isChannelEnabled(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel notificationChannel = ((NotificationManager) systemService).getNotificationChannel(this.id);
            return notificationChannel == null || notificationChannel.getImportance() != 0;
        }

        /* synthetic */ Channel(String str, int i3, String str2, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, str2, (i4 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128939a;

        static {
            int[] iArr = new int[Channel.values().length];
            try {
                iArr[Channel.STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Channel.USAGE_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Channel.ALERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Channel.OFFERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Channel.APP_UPDATES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Channel.POMODORO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Channel.TIME_NUDGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f128939a = iArr;
        }
    }

    private NotificationChannelHelper() {
    }

    private final void a(Context context, Channel channel) {
        String string;
        String string2;
        int[] iArr = WhenMappings.f128939a;
        switch (iArr[channel.ordinal()]) {
            case 1:
                string = context.getString(R.string.fA);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.eA);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 2:
                string = context.getString(R.string.JF);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.ix);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 3:
                string = context.getString(R.string.f95860y);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.f95857x);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 4:
                string = context.getString(R.string.Ml);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.Ll);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 5:
                string = context.getString(R.string.f95840r1);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.f95836q1);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 6:
                string = context.getString(R.string.jo);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.to);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            case 7:
                string = context.getString(R.string.pD);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.TC);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
            default:
                string = context.getString(R.string.p9);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                string2 = context.getString(R.string.o9);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                break;
        }
        int i3 = iArr[channel.ordinal()];
        int i4 = 4;
        if (i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6 && i3 != 7) {
            i4 = 2;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel = new NotificationChannel(channel.getId(), string, i4);
        notificationChannel.setDescription(string2);
        if (channel != Channel.POMODORO) {
            notificationChannel.setSound(null, null);
        } else {
            notificationChannel.enableVibration(true);
        }
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private final void b(Context context, Channel channel) {
        ((NotificationManager) context.getSystemService(NotificationManager.class)).deleteNotificationChannel(channel.getId());
    }

    public static final void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intentPutExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").addFlags(268435456).putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName()).putExtra("android.provider.extra.CHANNEL_ID", Channel.STATE.getId());
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        activity.startActivity(intentPutExtra);
    }

    public static final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (Channel channel : Channel.values()) {
            if (channel.getDeprecated()) {
                f128938a.b(context, channel);
            } else {
                f128938a.a(context, channel);
            }
        }
    }
}
