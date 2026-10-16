package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.AppBlockingSetting;
import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockType;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public abstract class ScheduleViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnActivityCreated extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnActivityCreated f114538a = new OnActivityCreated();

        private OnActivityCreated() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnActivityCreated);
        }

        public int hashCode() {
            return -1288529600;
        }

        public String toString() {
            return "OnActivityCreated";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddConditionClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAddConditionClicked f114539a = new OnAddConditionClicked();

        private OnAddConditionClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAddConditionClicked);
        }

        public int hashCode() {
            return -272770508;
        }

        public String toString() {
            return "OnAddConditionClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddToFollowSchedulesClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114540a;

        public OnAddToFollowSchedulesClicked(boolean z2) {
            super(null);
            this.f114540a = z2;
        }

        public final boolean a() {
            return this.f114540a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAddToFollowSchedulesClicked) && this.f114540a == ((OnAddToFollowSchedulesClicked) obj).f114540a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114540a);
        }

        public String toString() {
            return "OnAddToFollowSchedulesClicked(confirmed=" + this.f114540a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAdultContentTurnOnClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAdultContentTurnOnClicked f114541a = new OnAdultContentTurnOnClicked();

        private OnAdultContentTurnOnClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAdultContentTurnOnClicked);
        }

        public int hashCode() {
            return 1444710867;
        }

        public String toString() {
            return "OnAdultContentTurnOnClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppBlockingSettingCheckedChanged extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppBlockingSetting f114542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f114543b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppBlockingSettingCheckedChanged(AppBlockingSetting setting, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(setting, "setting");
            this.f114542a = setting;
            this.f114543b = z2;
        }

        public final AppBlockingSetting a() {
            return this.f114542a;
        }

        public final boolean b() {
            return this.f114543b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAppBlockingSettingCheckedChanged)) {
                return false;
            }
            OnAppBlockingSettingCheckedChanged onAppBlockingSettingCheckedChanged = (OnAppBlockingSettingCheckedChanged) obj;
            return this.f114542a == onAppBlockingSettingCheckedChanged.f114542a && this.f114543b == onAppBlockingSettingCheckedChanged.f114543b;
        }

        public int hashCode() {
            return (this.f114542a.hashCode() * 31) + Boolean.hashCode(this.f114543b);
        }

        public String toString() {
            return "OnAppBlockingSettingCheckedChanged(setting=" + this.f114542a + ", isChecked=" + this.f114543b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApplicationsWebsitesSelected extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f114544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f114545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f114546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f114547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f114548e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnApplicationsWebsitesSelected(List applications, List websites, List list, boolean z2, List categories) {
            super(null);
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(websites, "websites");
            Intrinsics.checkNotNullParameter(categories, "categories");
            this.f114544a = applications;
            this.f114545b = websites;
            this.f114546c = list;
            this.f114547d = z2;
            this.f114548e = categories;
        }

        public final List a() {
            return this.f114544a;
        }

        public final List b() {
            return this.f114548e;
        }

        public final boolean c() {
            return this.f114547d;
        }

        public final List d() {
            return this.f114546c;
        }

        public final List e() {
            return this.f114545b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnApplicationsWebsitesSelected)) {
                return false;
            }
            OnApplicationsWebsitesSelected onApplicationsWebsitesSelected = (OnApplicationsWebsitesSelected) obj;
            return Intrinsics.areEqual(this.f114544a, onApplicationsWebsitesSelected.f114544a) && Intrinsics.areEqual(this.f114545b, onApplicationsWebsitesSelected.f114545b) && Intrinsics.areEqual(this.f114546c, onApplicationsWebsitesSelected.f114546c) && this.f114547d == onApplicationsWebsitesSelected.f114547d && Intrinsics.areEqual(this.f114548e, onApplicationsWebsitesSelected.f114548e);
        }

        public int hashCode() {
            int iHashCode = ((this.f114544a.hashCode() * 31) + this.f114545b.hashCode()) * 31;
            List list = this.f114546c;
            return ((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.f114547d)) * 31) + this.f114548e.hashCode();
        }

        public String toString() {
            return "OnApplicationsWebsitesSelected(applications=" + this.f114544a + ", websites=" + this.f114545b + ", selectedSubApps=" + this.f114546c + ", seeAll=" + this.f114547d + ", categories=" + this.f114548e + ")";
        }

        public /* synthetic */ OnApplicationsWebsitesSelected(List list, List list2, List list3, boolean z2, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, list2, (i3 & 4) != 0 ? null : list3, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockingCardClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TabItem f114549a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBlockingCardClicked(TabItem tabItem) {
            super(null);
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            this.f114549a = tabItem;
        }

        public final TabItem a() {
            return this.f114549a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnBlockingCardClicked) && this.f114549a == ((OnBlockingCardClicked) obj).f114549a;
        }

        public int hashCode() {
            return this.f114549a.hashCode();
        }

        public String toString() {
            return "OnBlockingCardClicked(tabItem=" + this.f114549a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockingModeSelected extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.BlockingMode f114550a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBlockingModeSelected(Profile.BlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f114550a = blockingMode;
        }

        public final Profile.BlockingMode a() {
            return this.f114550a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnBlockingModeSelected) && this.f114550a == ((OnBlockingModeSelected) obj).f114550a;
        }

        public int hashCode() {
            return this.f114550a.hashCode();
        }

        public String toString() {
            return "OnBlockingModeSelected(blockingMode=" + this.f114550a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockingModeSettingsClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBlockingModeSettingsClicked f114551a = new OnBlockingModeSettingsClicked();

        private OnBlockingModeSettingsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBlockingModeSettingsClicked);
        }

        public int hashCode() {
            return 557695443;
        }

        public String toString() {
            return "OnBlockingModeSettingsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockingModeSettingsClosed extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBlockingModeSettingsClosed f114552a = new OnBlockingModeSettingsClosed();

        private OnBlockingModeSettingsClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBlockingModeSettingsClosed);
        }

        public int hashCode() {
            return 710920768;
        }

        public String toString() {
            return "OnBlockingModeSettingsClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBottomSheetHidden extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBottomSheetHidden f114553a = new OnBottomSheetHidden();

        private OnBottomSheetHidden() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBottomSheetHidden);
        }

        public int hashCode() {
            return -793809051;
        }

        public String toString() {
            return vgWWUoTKYyuC.qaRJ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCategoriesAllowed extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114554a;

        public OnCategoriesAllowed(boolean z2) {
            super(null);
            this.f114554a = z2;
        }

        public final boolean a() {
            return this.f114554a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCategoriesAllowed) && this.f114554a == ((OnCategoriesAllowed) obj).f114554a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114554a);
        }

        public String toString() {
            return "OnCategoriesAllowed(allowed=" + this.f114554a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114555a;

        public OnCloseClicked(boolean z2) {
            super(null);
            this.f114555a = z2;
        }

        public final boolean a() {
            return this.f114555a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCloseClicked) && this.f114555a == ((OnCloseClicked) obj).f114555a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114555a);
        }

        public String toString() {
            return "OnCloseClicked(isFromPreview=" + this.f114555a + ")";
        }

        public /* synthetic */ OnCloseClicked(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConditionSelectClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnConditionSelectClicked f114556a = new OnConditionSelectClicked();

        private OnConditionSelectClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnConditionSelectClicked);
        }

        public int hashCode() {
            return -960094231;
        }

        public String toString() {
            return "OnConditionSelectClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConditionSelected extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f114557a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConditionSelected(ProfileType profileType) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f114557a = profileType;
        }

        public final ProfileType a() {
            return this.f114557a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConditionSelected) && this.f114557a == ((OnConditionSelected) obj).f114557a;
        }

        public int hashCode() {
            return this.f114557a.hashCode();
        }

        public String toString() {
            return "OnConditionSelected(profileType=" + this.f114557a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConditionSet extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConditionDTO f114558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f114559b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConditionSet(ConditionDTO condition, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.f114558a = condition;
            this.f114559b = z2;
        }

        public final ConditionDTO a() {
            return this.f114558a;
        }

        public final boolean b() {
            return this.f114559b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnConditionSet)) {
                return false;
            }
            OnConditionSet onConditionSet = (OnConditionSet) obj;
            return Intrinsics.areEqual(this.f114558a, onConditionSet.f114558a) && this.f114559b == onConditionSet.f114559b;
        }

        public int hashCode() {
            return (this.f114558a.hashCode() * 31) + Boolean.hashCode(this.f114559b);
        }

        public String toString() {
            return "OnConditionSet(condition=" + this.f114558a + ", isStartScreen=" + this.f114559b + ")";
        }

        public /* synthetic */ OnConditionSet(ConditionDTO conditionDTO, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(conditionDTO, (i3 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConflictingSchedulesClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnConflictingSchedulesClicked f114560a = new OnConflictingSchedulesClicked();

        private OnConflictingSchedulesClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnConflictingSchedulesClicked);
        }

        public int hashCode() {
            return -625486686;
        }

        public String toString() {
            return "OnConflictingSchedulesClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCopyClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCopyClicked f114561a = new OnCopyClicked();

        private OnCopyClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCopyClicked);
        }

        public int hashCode() {
            return 2027461337;
        }

        public String toString() {
            return "OnCopyClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCopyProfileClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileWithConfiguration f114562a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCopyProfileClicked(ProfileWithConfiguration profile) {
            super(null);
            Intrinsics.checkNotNullParameter(profile, "profile");
            this.f114562a = profile;
        }

        public final ProfileWithConfiguration a() {
            return this.f114562a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCopyProfileClicked) && Intrinsics.areEqual(this.f114562a, ((OnCopyProfileClicked) obj).f114562a);
        }

        public int hashCode() {
            return this.f114562a.hashCode();
        }

        public String toString() {
            return "OnCopyProfileClicked(profile=" + this.f114562a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDisabledConditionClick extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f114563a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnDisabledConditionClick(ProfileType profileType) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f114563a = profileType;
        }

        public final ProfileType a() {
            return this.f114563a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnDisabledConditionClick) && this.f114563a == ((OnDisabledConditionClick) obj).f114563a;
        }

        public int hashCode() {
            return this.f114563a.hashCode();
        }

        public String toString() {
            return "OnDisabledConditionClick(profileType=" + this.f114563a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmojiEditClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEmojiEditClicked f114564a = new OnEmojiEditClicked();

        private OnEmojiEditClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEmojiEditClicked);
        }

        public int hashCode() {
            return -1672776944;
        }

        public String toString() {
            return "OnEmojiEditClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmojiSelected extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScheduleEmoji f114565a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmojiSelected(ScheduleEmoji emoji) {
            super(null);
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            this.f114565a = emoji;
        }

        public final ScheduleEmoji a() {
            return this.f114565a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmojiSelected) && this.f114565a == ((OnEmojiSelected) obj).f114565a;
        }

        public int hashCode() {
            return this.f114565a.hashCode();
        }

        public String toString() {
            return "OnEmojiSelected(emoji=" + this.f114565a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnExtraOptionClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtraOption f114566a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnExtraOptionClicked(ExtraOption extraOption) {
            super(null);
            Intrinsics.checkNotNullParameter(extraOption, "extraOption");
            this.f114566a = extraOption;
        }

        public final ExtraOption a() {
            return this.f114566a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnExtraOptionClicked) && Intrinsics.areEqual(this.f114566a, ((OnExtraOptionClicked) obj).f114566a);
        }

        public int hashCode() {
            return this.f114566a.hashCode();
        }

        public String toString() {
            return "OnExtraOptionClicked(extraOption=" + this.f114566a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockChargerDialogConfirmed extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114567a;

        public OnLockChargerDialogConfirmed(boolean z2) {
            super(null);
            this.f114567a = z2;
        }

        public final boolean a() {
            return this.f114567a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLockChargerDialogConfirmed) && this.f114567a == ((OnLockChargerDialogConfirmed) obj).f114567a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114567a);
        }

        public String toString() {
            return "OnLockChargerDialogConfirmed(dontShowConfirmDialog=" + this.f114567a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockTimeSelected extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114568a;

        public OnLockTimeSelected(long j3) {
            super(null);
            this.f114568a = j3;
        }

        public final long a() {
            return this.f114568a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLockTimeSelected) && this.f114568a == ((OnLockTimeSelected) obj).f114568a;
        }

        public int hashCode() {
            return Long.hashCode(this.f114568a);
        }

        public String toString() {
            return "OnLockTimeSelected(until=" + this.f114568a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockTypeClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LockType f114569a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnLockTypeClicked(LockType lockType) {
            super(null);
            Intrinsics.checkNotNullParameter(lockType, "lockType");
            this.f114569a = lockType;
        }

        public final LockType a() {
            return this.f114569a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLockTypeClicked) && this.f114569a == ((OnLockTypeClicked) obj).f114569a;
        }

        public int hashCode() {
            return this.f114569a.hashCode();
        }

        public String toString() {
            return "OnLockTypeClicked(lockType=" + this.f114569a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockUnsavedChangesDialogConfirmed extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LockType f114570a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnLockUnsavedChangesDialogConfirmed(LockType lockType) {
            super(null);
            Intrinsics.checkNotNullParameter(lockType, "lockType");
            this.f114570a = lockType;
        }

        public final LockType a() {
            return this.f114570a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLockUnsavedChangesDialogConfirmed) && this.f114570a == ((OnLockUnsavedChangesDialogConfirmed) obj).f114570a;
        }

        public int hashCode() {
            return this.f114570a.hashCode();
        }

        public String toString() {
            return "OnLockUnsavedChangesDialogConfirmed(lockType=" + this.f114570a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockedActionClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLockedActionClicked f114571a = new OnLockedActionClicked();

        private OnLockedActionClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLockedActionClicked);
        }

        public int hashCode() {
            return 119916302;
        }

        public String toString() {
            return "OnLockedActionClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMissingPermissionsChanged extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionRequestReason f114572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f114573b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMissingPermissionsChanged(PermissionRequestReason requestReason, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(requestReason, "requestReason");
            this.f114572a = requestReason;
            this.f114573b = z2;
        }

        public final boolean a() {
            return this.f114573b;
        }

        public final PermissionRequestReason b() {
            return this.f114572a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnMissingPermissionsChanged)) {
                return false;
            }
            OnMissingPermissionsChanged onMissingPermissionsChanged = (OnMissingPermissionsChanged) obj;
            return this.f114572a == onMissingPermissionsChanged.f114572a && this.f114573b == onMissingPermissionsChanged.f114573b;
        }

        public int hashCode() {
            return (this.f114572a.hashCode() * 31) + Boolean.hashCode(this.f114573b);
        }

        public String toString() {
            return "OnMissingPermissionsChanged(requestReason=" + this.f114572a + ", areRequestedPermissionsGranted=" + this.f114573b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNavigateBack extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnNavigateBack f114574a = new OnNavigateBack();

        private OnNavigateBack() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnNavigateBack);
        }

        public int hashCode() {
            return -1335797007;
        }

        public String toString() {
            return "OnNavigateBack";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOnboardingFinished extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOnboardingFinished f114575a = new OnOnboardingFinished();

        private OnOnboardingFinished() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOnboardingFinished);
        }

        public int hashCode() {
            return -1480839706;
        }

        public String toString() {
            return "OnOnboardingFinished";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRemoveConditionClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f114576a;

        public final ProfileType a() {
            return this.f114576a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnRemoveConditionClicked) && this.f114576a == ((OnRemoveConditionClicked) obj).f114576a;
        }

        public int hashCode() {
            return this.f114576a.hashCode();
        }

        public String toString() {
            return "OnRemoveConditionClicked(type=" + this.f114576a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveButtonClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f114577a;

        public OnSaveButtonClicked(boolean z2) {
            super(null);
            this.f114577a = z2;
        }

        public final boolean a() {
            return this.f114577a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSaveButtonClicked) && this.f114577a == ((OnSaveButtonClicked) obj).f114577a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f114577a);
        }

        public String toString() {
            return "OnSaveButtonClicked(skipConflicts=" + this.f114577a + ")";
        }

        public /* synthetic */ OnSaveButtonClicked(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleChangedInDB extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnScheduleChangedInDB f114578a = new OnScheduleChangedInDB();

        private OnScheduleChangedInDB() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnScheduleChangedInDB);
        }

        public int hashCode() {
            return 1399899911;
        }

        public String toString() {
            return "OnScheduleChangedInDB";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSetProfileLaunchCount extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UsageLimit.PeriodType f114580b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSetProfileLaunchCount(long j3, UsageLimit.PeriodType period) {
            super(null);
            Intrinsics.checkNotNullParameter(period, "period");
            this.f114579a = j3;
            this.f114580b = period;
        }

        public final long a() {
            return this.f114579a;
        }

        public final UsageLimit.PeriodType b() {
            return this.f114580b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSetProfileLaunchCount)) {
                return false;
            }
            OnSetProfileLaunchCount onSetProfileLaunchCount = (OnSetProfileLaunchCount) obj;
            return this.f114579a == onSetProfileLaunchCount.f114579a && this.f114580b == onSetProfileLaunchCount.f114580b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f114579a) * 31) + this.f114580b.hashCode();
        }

        public String toString() {
            return "OnSetProfileLaunchCount(launchCount=" + this.f114579a + ", period=" + this.f114580b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSetProfileUsageLimitTime extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f114581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UsageLimit.PeriodType f114582b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSetProfileUsageLimitTime(long j3, UsageLimit.PeriodType period) {
            super(null);
            Intrinsics.checkNotNullParameter(period, "period");
            this.f114581a = j3;
            this.f114582b = period;
        }

        public final UsageLimit.PeriodType a() {
            return this.f114582b;
        }

        public final long b() {
            return this.f114581a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSetProfileUsageLimitTime)) {
                return false;
            }
            OnSetProfileUsageLimitTime onSetProfileUsageLimitTime = (OnSetProfileUsageLimitTime) obj;
            return this.f114581a == onSetProfileUsageLimitTime.f114581a && this.f114582b == onSetProfileUsageLimitTime.f114582b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f114581a) * 31) + this.f114582b.hashCode();
        }

        public String toString() {
            return "OnSetProfileUsageLimitTime(timeInMillis=" + this.f114581a + ", period=" + this.f114582b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModeActionBlocked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModeActionBlocked f114583a = new OnStrictModeActionBlocked();

        private OnStrictModeActionBlocked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStrictModeActionBlocked);
        }

        public int hashCode() {
            return 1369617297;
        }

        public String toString() {
            return "OnStrictModeActionBlocked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSummaryBackClicked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSummaryBackClicked f114584a = new OnSummaryBackClicked();

        private OnSummaryBackClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSummaryBackClicked);
        }

        public int hashCode() {
            return 1276320755;
        }

        public String toString() {
            return "OnSummaryBackClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTitleChanged extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f114585a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTitleChanged(String title) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.f114585a = title;
        }

        public final String a() {
            return this.f114585a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTitleChanged) && Intrinsics.areEqual(this.f114585a, ((OnTitleChanged) obj).f114585a);
        }

        public int hashCode() {
            return this.f114585a.hashCode();
        }

        public String toString() {
            return "OnTitleChanged(title=" + this.f114585a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUnlocked extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUnlocked f114586a = new OnUnlocked();

        private OnUnlocked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnUnlocked);
        }

        public int hashCode() {
            return -174125988;
        }

        public String toString() {
            return "OnUnlocked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebBrowsingModeChanged extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.AllowlistWebBrowsingMode f114587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWebBrowsingModeChanged(Profile.AllowlistWebBrowsingMode mode) {
            super(null);
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.f114587a = mode;
        }

        public final Profile.AllowlistWebBrowsingMode a() {
            return this.f114587a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWebBrowsingModeChanged) && this.f114587a == ((OnWebBrowsingModeChanged) obj).f114587a;
        }

        public int hashCode() {
            return this.f114587a.hashCode();
        }

        public String toString() {
            return "OnWebBrowsingModeChanged(mode=" + this.f114587a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class QuickBlockTileHintClosed extends ScheduleViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final QuickBlockTileHintClosed f114588a = new QuickBlockTileHintClosed();

        private QuickBlockTileHintClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof QuickBlockTileHintClosed);
        }

        public int hashCode() {
            return 326797275;
        }

        public String toString() {
            return "QuickBlockTileHintClosed";
        }
    }

    public /* synthetic */ ScheduleViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ScheduleViewEvent() {
    }
}
