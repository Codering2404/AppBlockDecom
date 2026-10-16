package cz.mobilesoft.coreblock.scene.dashboard;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class DashboardViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InAppUpdateDialogClosed extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InAppUpdateDialogClosed f99243a = new InAppUpdateDialogClosed();

        private InAppUpdateDialogClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof InAppUpdateDialogClosed);
        }

        public int hashCode() {
            return -1872427341;
        }

        public String toString() {
            return "InAppUpdateDialogClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDashboardResumed extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDashboardResumed f99244a = new OnDashboardResumed();

        private OnDashboardResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDashboardResumed);
        }

        public int hashCode() {
            return -678225464;
        }

        public String toString() {
            return "OnDashboardResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNavPageRequested extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DashboardActivity.NavBarItem f99245a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnNavPageRequested(DashboardActivity.NavBarItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.f99245a = item;
        }

        public final DashboardActivity.NavBarItem a() {
            return this.f99245a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnNavPageRequested) && Intrinsics.areEqual(this.f99245a, ((OnNavPageRequested) obj).f99245a);
        }

        public int hashCode() {
            return this.f99245a.hashCode();
        }

        public String toString() {
            return "OnNavPageRequested(item=" + this.f99245a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfilePaused extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.PausedUntil f99246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f99247b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfilePaused(Profile.PausedUntil pausedUntil, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
            this.f99246a = pausedUntil;
            this.f99247b = l3;
        }

        public final Profile.PausedUntil a() {
            return this.f99246a;
        }

        public final Long b() {
            return this.f99247b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnProfilePaused)) {
                return false;
            }
            OnProfilePaused onProfilePaused = (OnProfilePaused) obj;
            return Intrinsics.areEqual(this.f99246a, onProfilePaused.f99246a) && Intrinsics.areEqual(this.f99247b, onProfilePaused.f99247b);
        }

        public int hashCode() {
            int iHashCode = this.f99246a.hashCode() * 31;
            Long l3 = this.f99247b;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "OnProfilePaused(pausedUntil=" + this.f99246a + ", profileId=" + this.f99247b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReferralDeeplinkRequested extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReferralDeeplinkRequested f99248a = new OnReferralDeeplinkRequested();

        private OnReferralDeeplinkRequested() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReferralDeeplinkRequested);
        }

        public int hashCode() {
            return -951119482;
        }

        public String toString() {
            return "OnReferralDeeplinkRequested";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRegistrationDialogClosed extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRegistrationDialogClosed f99249a = new OnRegistrationDialogClosed();

        private OnRegistrationDialogClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRegistrationDialogClosed);
        }

        public int hashCode() {
            return 111488082;
        }

        public String toString() {
            return "OnRegistrationDialogClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScreenOpened extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DashboardActivity.NavBarItem f99250a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnScreenOpened(DashboardActivity.NavBarItem navItem) {
            super(null);
            Intrinsics.checkNotNullParameter(navItem, "navItem");
            this.f99250a = navItem;
        }

        public final DashboardActivity.NavBarItem a() {
            return this.f99250a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScreenOpened) && Intrinsics.areEqual(this.f99250a, ((OnScreenOpened) obj).f99250a);
        }

        public int hashCode() {
            return this.f99250a.hashCode();
        }

        public String toString() {
            return "OnScreenOpened(navItem=" + this.f99250a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeOnboardingFinished extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeOnboardingFinished f99251a = new OnStrictModeOnboardingFinished();

        private OnStrictModeOnboardingFinished() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeOnboardingFinished);
        }

        public int hashCode() {
            return -1362702722;
        }

        public String toString() {
            return "OnStrictModeOnboardingFinished";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeSuggestionNeverShowAgainClicked extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeSuggestionNeverShowAgainClicked f99252a = new OnStrictModeSuggestionNeverShowAgainClicked();

        private OnStrictModeSuggestionNeverShowAgainClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeSuggestionNeverShowAgainClicked);
        }

        public int hashCode() {
            return -826947557;
        }

        public String toString() {
            return "OnStrictModeSuggestionNeverShowAgainClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWeeklyInsightsDialogClosed extends DashboardViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnWeeklyInsightsDialogClosed f99253a = new OnWeeklyInsightsDialogClosed();

        private OnWeeklyInsightsDialogClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnWeeklyInsightsDialogClosed);
        }

        public int hashCode() {
            return -1301361323;
        }

        public String toString() {
            return "OnWeeklyInsightsDialogClosed";
        }
    }

    public /* synthetic */ DashboardViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DashboardViewEvent() {
    }
}
