package cz.mobilesoft.coreblock.scene.more.settings.notification;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class NotificationSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNewsletterChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnNewsletterChanged f109975a = new OnNewsletterChanged();

        private OnNewsletterChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnNewsletterChanged);
        }

        public int hashCode() {
            return -288133423;
        }

        public String toString() {
            return "OnNewsletterChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f109976a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return 244223085;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAfterQuickBlockEndBlockedNotificationsChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAfterQuickBlockEndBlockedNotificationsChanged f109977a = new OnShowAfterQuickBlockEndBlockedNotificationsChanged();

        private OnShowAfterQuickBlockEndBlockedNotificationsChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowAfterQuickBlockEndBlockedNotificationsChanged);
        }

        public int hashCode() {
            return -1555148110;
        }

        public String toString() {
            return "OnShowAfterQuickBlockEndBlockedNotificationsChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAfterQuickBlockEndChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAfterQuickBlockEndChanged f109978a = new OnShowAfterQuickBlockEndChanged();

        private OnShowAfterQuickBlockEndChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowAfterQuickBlockEndChanged);
        }

        public int hashCode() {
            return 504724910;
        }

        public String toString() {
            return "OnShowAfterQuickBlockEndChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAfterScheduleEndBlockedNotificationsChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAfterScheduleEndBlockedNotificationsChanged f109979a = new OnShowAfterScheduleEndBlockedNotificationsChanged();

        private OnShowAfterScheduleEndBlockedNotificationsChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowAfterScheduleEndBlockedNotificationsChanged);
        }

        public int hashCode() {
            return -1873755735;
        }

        public String toString() {
            return "OnShowAfterScheduleEndBlockedNotificationsChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAfterScheduleEndChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAfterScheduleEndChanged f109980a = new OnShowAfterScheduleEndChanged();

        private OnShowAfterScheduleEndChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowAfterScheduleEndChanged);
        }

        public int hashCode() {
            return -616182235;
        }

        public String toString() {
            return "OnShowAfterScheduleEndChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowBlockedAppsChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowBlockedAppsChanged f109981a = new OnShowBlockedAppsChanged();

        private OnShowBlockedAppsChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowBlockedAppsChanged);
        }

        public int hashCode() {
            return -1495520547;
        }

        public String toString() {
            return "OnShowBlockedAppsChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowDailyInsightsMotivationChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowDailyInsightsMotivationChanged f109982a = new OnShowDailyInsightsMotivationChanged();

        private OnShowDailyInsightsMotivationChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowDailyInsightsMotivationChanged);
        }

        public int hashCode() {
            return 1963314833;
        }

        public String toString() {
            return "OnShowDailyInsightsMotivationChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowPomodoroNotificationChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowPomodoroNotificationChanged f109983a = new OnShowPomodoroNotificationChanged();

        private OnShowPomodoroNotificationChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowPomodoroNotificationChanged);
        }

        public int hashCode() {
            return 1487411321;
        }

        public String toString() {
            return "OnShowPomodoroNotificationChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowStreakNudgeChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowStreakNudgeChanged f109984a = new OnShowStreakNudgeChanged();

        private OnShowStreakNudgeChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowStreakNudgeChanged);
        }

        public int hashCode() {
            return -1816771522;
        }

        public String toString() {
            return "OnShowStreakNudgeChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowUsageLimitChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowUsageLimitChanged f109985a = new OnShowUsageLimitChanged();

        private OnShowUsageLimitChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowUsageLimitChanged);
        }

        public int hashCode() {
            return 1445244243;
        }

        public String toString() {
            return "OnShowUsageLimitChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowUsageStatisticsNotificationChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowUsageStatisticsNotificationChanged f109986a = new OnShowUsageStatisticsNotificationChanged();

        private OnShowUsageStatisticsNotificationChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowUsageStatisticsNotificationChanged);
        }

        public int hashCode() {
            return -1082449524;
        }

        public String toString() {
            return "OnShowUsageStatisticsNotificationChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowWeeklyStatisticsReportNotificationChanged extends NotificationSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowWeeklyStatisticsReportNotificationChanged f109987a = new OnShowWeeklyStatisticsReportNotificationChanged();

        private OnShowWeeklyStatisticsReportNotificationChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnShowWeeklyStatisticsReportNotificationChanged);
        }

        public int hashCode() {
            return 1820840170;
        }

        public String toString() {
            return "OnShowWeeklyStatisticsReportNotificationChanged";
        }
    }

    public /* synthetic */ NotificationSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NotificationSettingsViewEvent() {
    }
}
