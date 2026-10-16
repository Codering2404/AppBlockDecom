package cz.mobilesoft.coreblock.scene.insights;

import androidx.activity.result.ActivityResult;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
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
public abstract class InsightsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddScheduleClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAddScheduleClicked f102671a = new OnAddScheduleClicked();

        private OnAddScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAddScheduleClicked);
        }

        public int hashCode() {
            return 1964278120;
        }

        public String toString() {
            return "OnAddScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppFeelBannerDismissed extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAppFeelBannerDismissed f102672a = new OnAppFeelBannerDismissed();

        private OnAppFeelBannerDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAppFeelBannerDismissed);
        }

        public int hashCode() {
            return 1921048239;
        }

        public String toString() {
            return "OnAppFeelBannerDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppFeelBannerSortAppsClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAppFeelBannerSortAppsClicked f102673a = new OnAppFeelBannerSortAppsClicked();

        private OnAppFeelBannerSortAppsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAppFeelBannerSortAppsClicked);
        }

        public int hashCode() {
            return -148227491;
        }

        public String toString() {
            return "OnAppFeelBannerSortAppsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppTypeSelected extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f102674a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppTypeSelected(String appTypeName) {
            super(null);
            Intrinsics.checkNotNullParameter(appTypeName, "appTypeName");
            this.f102674a = appTypeName;
        }

        public final String a() {
            return this.f102674a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppTypeSelected) && Intrinsics.areEqual(this.f102674a, ((OnAppTypeSelected) obj).f102674a);
        }

        public int hashCode() {
            return this.f102674a.hashCode();
        }

        public String toString() {
            return "OnAppTypeSelected(appTypeName=" + this.f102674a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppTypeUpdated extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppDistractionType f102675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppTypeUpdated(AppDistractionType appDistractionType) {
            super(null);
            Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
            this.f102675a = appDistractionType;
        }

        public final AppDistractionType a() {
            return this.f102675a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppTypeUpdated) && this.f102675a == ((OnAppTypeUpdated) obj).f102675a;
        }

        public int hashCode() {
            return this.f102675a.hashCode();
        }

        public String toString() {
            return "OnAppTypeUpdated(appDistractionType=" + this.f102675a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBarSelected extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f102676a;

        public OnBarSelected(Integer num) {
            super(null);
            this.f102676a = num;
        }

        public final Integer a() {
            return this.f102676a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnBarSelected) && Intrinsics.areEqual(this.f102676a, ((OnBarSelected) obj).f102676a);
        }

        public int hashCode() {
            Integer num = this.f102676a;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "OnBarSelected(index=" + this.f102676a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCategorySelected extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Category f102677a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCategorySelected(Category category) {
            super(null);
            Intrinsics.checkNotNullParameter(category, "category");
            this.f102677a = category;
        }

        public final Category a() {
            return this.f102677a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCategorySelected) && this.f102677a == ((OnCategorySelected) obj).f102677a;
        }

        public int hashCode() {
            return this.f102677a.hashCode();
        }

        public String toString() {
            return "OnCategorySelected(category=" + this.f102677a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissBottomSheet extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissBottomSheet f102678a = new OnDismissBottomSheet();

        private OnDismissBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissBottomSheet);
        }

        public int hashCode() {
            return -188007485;
        }

        public String toString() {
            return "OnDismissBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnExcludePremiumCardClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnExcludePremiumCardClicked f102679a = new OnExcludePremiumCardClicked();

        private OnExcludePremiumCardClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnExcludePremiumCardClicked);
        }

        public int hashCode() {
            return 1254834881;
        }

        public String toString() {
            return "OnExcludePremiumCardClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnInsightTypeSelected extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InsightsViewState.InsightsPeriodType f102680a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnInsightTypeSelected(InsightsViewState.InsightsPeriodType insightsPeriodType) {
            super(null);
            Intrinsics.checkNotNullParameter(insightsPeriodType, "insightsPeriodType");
            this.f102680a = insightsPeriodType;
        }

        public final InsightsViewState.InsightsPeriodType a() {
            return this.f102680a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnInsightTypeSelected) && this.f102680a == ((OnInsightTypeSelected) obj).f102680a;
        }

        public int hashCode() {
            return this.f102680a.hashCode();
        }

        public String toString() {
            return "OnInsightTypeSelected(insightsPeriodType=" + this.f102680a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnItemExcludedFromReports extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f102681a;

        public OnItemExcludedFromReports(boolean z2) {
            super(null);
            this.f102681a = z2;
        }

        public final boolean a() {
            return this.f102681a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnItemExcludedFromReports) && this.f102681a == ((OnItemExcludedFromReports) obj).f102681a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f102681a);
        }

        public String toString() {
            return "OnItemExcludedFromReports(ignored=" + this.f102681a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockedScheduleClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLockedScheduleClicked f102682a = new OnLockedScheduleClicked();

        private OnLockedScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLockedScheduleClicked);
        }

        public int hashCode() {
            return 1478265805;
        }

        public String toString() {
            return "OnLockedScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoodCheckInAutoDisableClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMoodCheckInAutoDisableClicked f102683a = new OnMoodCheckInAutoDisableClicked();

        private OnMoodCheckInAutoDisableClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMoodCheckInAutoDisableClicked);
        }

        public int hashCode() {
            return -437265589;
        }

        public String toString() {
            return "OnMoodCheckInAutoDisableClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoodCheckInSaved extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MoodType f102684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f102685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f102686c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMoodCheckInSaved(MoodType mood, int i3, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(mood, "mood");
            this.f102684a = mood;
            this.f102685b = i3;
            this.f102686c = str;
        }

        public final MoodType a() {
            return this.f102684a;
        }

        public final int b() {
            return this.f102685b;
        }

        public final String c() {
            return this.f102686c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnMoodCheckInSaved)) {
                return false;
            }
            OnMoodCheckInSaved onMoodCheckInSaved = (OnMoodCheckInSaved) obj;
            return this.f102684a == onMoodCheckInSaved.f102684a && this.f102685b == onMoodCheckInSaved.f102685b && Intrinsics.areEqual(this.f102686c, onMoodCheckInSaved.f102686c);
        }

        public int hashCode() {
            int iHashCode = ((this.f102684a.hashCode() * 31) + Integer.hashCode(this.f102685b)) * 31;
            String str = this.f102686c;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OnMoodCheckInSaved(mood=" + this.f102684a + ", moodRawValue=" + this.f102685b + ", note=" + this.f102686c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoodChekInClosed extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMoodChekInClosed f102687a = new OnMoodChekInClosed();

        private OnMoodChekInClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMoodChekInClosed);
        }

        public int hashCode() {
            return -1383218836;
        }

        public String toString() {
            return "OnMoodChekInClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoodChekInShowDate extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f102688a;

        public OnMoodChekInShowDate(long j3) {
            super(null);
            this.f102688a = j3;
        }

        public final long a() {
            return this.f102688a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMoodChekInShowDate) && this.f102688a == ((OnMoodChekInShowDate) obj).f102688a;
        }

        public int hashCode() {
            return Long.hashCode(this.f102688a);
        }

        public String toString() {
            return "OnMoodChekInShowDate(date=" + this.f102688a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoreAppsClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMoreAppsClicked f102689a = new OnMoreAppsClicked();

        private OnMoreAppsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMoreAppsClicked);
        }

        public int hashCode() {
            return 330122919;
        }

        public String toString() {
            return "OnMoreAppsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNextIntervalClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnNextIntervalClicked f102690a = new OnNextIntervalClicked();

        private OnNextIntervalClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnNextIntervalClicked);
        }

        public int hashCode() {
            return -1680916330;
        }

        public String toString() {
            return "OnNextIntervalClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionResult extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActivityResult f102691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPermissionResult(ActivityResult activityResult) {
            super(null);
            Intrinsics.checkNotNullParameter(activityResult, "activityResult");
            this.f102691a = activityResult;
        }

        public final ActivityResult a() {
            return this.f102691a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPermissionResult) && Intrinsics.areEqual(this.f102691a, ((OnPermissionResult) obj).f102691a);
        }

        public int hashCode() {
            return this.f102691a.hashCode();
        }

        public String toString() {
            return "OnPermissionResult(activityResult=" + this.f102691a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPreviousIntervalClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPreviousIntervalClicked f102692a = new OnPreviousIntervalClicked();

        private OnPreviousIntervalClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPreviousIntervalClicked);
        }

        public int hashCode() {
            return -857342830;
        }

        public String toString() {
            return "OnPreviousIntervalClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleClicked extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f102693a;

        public OnScheduleClicked(int i3) {
            super(null);
            this.f102693a = i3;
        }

        public final int a() {
            return this.f102693a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleClicked) && this.f102693a == ((OnScheduleClicked) obj).f102693a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f102693a);
        }

        public String toString() {
            return "OnScheduleClicked(index=" + this.f102693a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleSelectionConfirmed extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f102694a;

        public OnScheduleSelectionConfirmed(boolean z2) {
            super(null);
            this.f102694a = z2;
        }

        public final boolean a() {
            return this.f102694a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleSelectionConfirmed) && this.f102694a == ((OnScheduleSelectionConfirmed) obj).f102694a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f102694a);
        }

        public String toString() {
            return "OnScheduleSelectionConfirmed(overrideAppBlockWarning=" + this.f102694a + ")";
        }

        public /* synthetic */ OnScheduleSelectionConfirmed(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTrendIntervalSelected extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InsightsViewState.TrendInterval f102695a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTrendIntervalSelected(InsightsViewState.TrendInterval trendInterval) {
            super(null);
            Intrinsics.checkNotNullParameter(trendInterval, "trendInterval");
            this.f102695a = trendInterval;
        }

        public final InsightsViewState.TrendInterval a() {
            return this.f102695a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTrendIntervalSelected) && this.f102695a == ((OnTrendIntervalSelected) obj).f102695a;
        }

        public int hashCode() {
            return this.f102695a.hashCode();
        }

        public String toString() {
            return "OnTrendIntervalSelected(trendInterval=" + this.f102695a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowExcludedAppsBottomSheet extends InsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowExcludedAppsBottomSheet f102696a = new ShowExcludedAppsBottomSheet();

        private ShowExcludedAppsBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowExcludedAppsBottomSheet);
        }

        public int hashCode() {
            return -767435391;
        }

        public String toString() {
            return "ShowExcludedAppsBottomSheet";
        }
    }

    public /* synthetic */ InsightsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InsightsViewEvent() {
    }
}
