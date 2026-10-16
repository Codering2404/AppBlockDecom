package cz.mobilesoft.coreblock.scene.more.settings.notification;

import cz.mobilesoft.coreblock.enums.EventShowAsType;
import kotlin.Metadata;
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
public abstract class NotificationPreference {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotificationBeforeIntervalStart extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f109948a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationBeforeIntervalStart) && this.f109948a == ((NotificationBeforeIntervalStart) obj).f109948a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f109948a);
        }

        public String toString() {
            return "NotificationBeforeIntervalStart(interval=" + this.f109948a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotificationBeforePauseEnd extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f109949a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotificationBeforePauseEnd) && this.f109949a == ((NotificationBeforePauseEnd) obj).f109949a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f109949a);
        }

        public String toString() {
            return "NotificationBeforePauseEnd(interval=" + this.f109949a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotificationBeforeUsageLimitEnd extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f109950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EventShowAsType f109951b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotificationBeforeUsageLimitEnd(int i3, EventShowAsType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f109950a = i3;
            this.f109951b = type;
        }

        public final int a() {
            return this.f109950a;
        }

        public final EventShowAsType b() {
            return this.f109951b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NotificationBeforeUsageLimitEnd)) {
                return false;
            }
            NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd = (NotificationBeforeUsageLimitEnd) obj;
            return this.f109950a == notificationBeforeUsageLimitEnd.f109950a && this.f109951b == notificationBeforeUsageLimitEnd.f109951b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f109950a) * 31) + this.f109951b.hashCode();
        }

        public String toString() {
            return "NotificationBeforeUsageLimitEnd(interval=" + this.f109950a + ", type=" + this.f109951b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAfterQuickBlockEnd extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109952a;

        public ShowAfterQuickBlockEnd(boolean z2) {
            super(null);
            this.f109952a = z2;
        }

        public final boolean a() {
            return this.f109952a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowAfterQuickBlockEnd) && this.f109952a == ((ShowAfterQuickBlockEnd) obj).f109952a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109952a);
        }

        public String toString() {
            return "ShowAfterQuickBlockEnd(show=" + this.f109952a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAfterQuickBlockEndBlockedNotifications extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f109954b;

        public ShowAfterQuickBlockEndBlockedNotifications(boolean z2, boolean z3) {
            super(null);
            this.f109953a = z2;
            this.f109954b = z3;
        }

        public final boolean a() {
            return this.f109953a;
        }

        public final boolean b() {
            return this.f109954b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowAfterQuickBlockEndBlockedNotifications)) {
                return false;
            }
            ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotifications = (ShowAfterQuickBlockEndBlockedNotifications) obj;
            return this.f109953a == showAfterQuickBlockEndBlockedNotifications.f109953a && this.f109954b == showAfterQuickBlockEndBlockedNotifications.f109954b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f109953a) * 31) + Boolean.hashCode(this.f109954b);
        }

        public String toString() {
            return "ShowAfterQuickBlockEndBlockedNotifications(show=" + this.f109953a + ", isEnabled=" + this.f109954b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAfterScheduleEnd extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109955a;

        public ShowAfterScheduleEnd(boolean z2) {
            super(null);
            this.f109955a = z2;
        }

        public final boolean a() {
            return this.f109955a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowAfterScheduleEnd) && this.f109955a == ((ShowAfterScheduleEnd) obj).f109955a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109955a);
        }

        public String toString() {
            return "ShowAfterScheduleEnd(show=" + this.f109955a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAfterScheduleEndBlockedNotifications extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f109957b;

        public ShowAfterScheduleEndBlockedNotifications(boolean z2, boolean z3) {
            super(null);
            this.f109956a = z2;
            this.f109957b = z3;
        }

        public final boolean a() {
            return this.f109956a;
        }

        public final boolean b() {
            return this.f109957b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowAfterScheduleEndBlockedNotifications)) {
                return false;
            }
            ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotifications = (ShowAfterScheduleEndBlockedNotifications) obj;
            return this.f109956a == showAfterScheduleEndBlockedNotifications.f109956a && this.f109957b == showAfterScheduleEndBlockedNotifications.f109957b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f109956a) * 31) + Boolean.hashCode(this.f109957b);
        }

        public String toString() {
            return "ShowAfterScheduleEndBlockedNotifications(show=" + this.f109956a + ", isEnabled=" + this.f109957b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowBlockedApps extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109958a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowBlockedApps) && this.f109958a == ((ShowBlockedApps) obj).f109958a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109958a);
        }

        public String toString() {
            return "ShowBlockedApps(show=" + this.f109958a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPomodoroNotification extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109959a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPomodoroNotification) && this.f109959a == ((ShowPomodoroNotification) obj).f109959a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109959a);
        }

        public String toString() {
            return "ShowPomodoroNotification(show=" + this.f109959a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUsageLimit extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109960a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowUsageLimit) && this.f109960a == ((ShowUsageLimit) obj).f109960a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109960a);
        }

        public String toString() {
            return "ShowUsageLimit(show=" + this.f109960a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowUsageStatisticsNotification extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109961a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowUsageStatisticsNotification) && this.f109961a == ((ShowUsageStatisticsNotification) obj).f109961a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109961a);
        }

        public String toString() {
            return "ShowUsageStatisticsNotification(show=" + this.f109961a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowWeeklyStatisticsReportNotification extends NotificationPreference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109962a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowWeeklyStatisticsReportNotification) && this.f109962a == ((ShowWeeklyStatisticsReportNotification) obj).f109962a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109962a);
        }

        public String toString() {
            return "ShowWeeklyStatisticsReportNotification(show=" + this.f109962a + ")";
        }
    }

    public /* synthetic */ NotificationPreference(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NotificationPreference() {
    }
}
