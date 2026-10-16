package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

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
public abstract class GeneralSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAllowCategoriesClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAllowCategoriesClicked f109714a = new OnAllowCategoriesClicked();

        private OnAllowCategoriesClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAllowCategoriesClicked);
        }

        public int hashCode() {
            return -136794589;
        }

        public String toString() {
            return "OnAllowCategoriesClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCategoriesAllowed extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f109715a;

        public OnCategoriesAllowed(boolean z2) {
            super(null);
            this.f109715a = z2;
        }

        public final boolean a() {
            return this.f109715a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCategoriesAllowed) && this.f109715a == ((OnCategoriesAllowed) obj).f109715a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f109715a);
        }

        public String toString() {
            return "OnCategoriesAllowed(allowed=" + this.f109715a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDailyTrendBadgeClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDailyTrendBadgeClicked f109716a = new OnDailyTrendBadgeClicked();

        private OnDailyTrendBadgeClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDailyTrendBadgeClicked);
        }

        public int hashCode() {
            return 416609321;
        }

        public String toString() {
            return "OnDailyTrendBadgeClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnInAppsUpdateClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnInAppsUpdateClicked f109717a = new OnInAppsUpdateClicked();

        private OnInAppsUpdateClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnInAppsUpdateClicked);
        }

        public int hashCode() {
            return -1911204154;
        }

        public String toString() {
            return "OnInAppsUpdateClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMoodCheckInAutoShowClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMoodCheckInAutoShowClicked f109718a = new OnMoodCheckInAutoShowClicked();

        private OnMoodCheckInAutoShowClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMoodCheckInAutoShowClicked);
        }

        public int hashCode() {
            return 512674950;
        }

        public String toString() {
            return "OnMoodCheckInAutoShowClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuickBlockSwitchClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnQuickBlockSwitchClicked f109719a = new OnQuickBlockSwitchClicked();

        private OnQuickBlockSwitchClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnQuickBlockSwitchClicked);
        }

        public int hashCode() {
            return -2037113934;
        }

        public String toString() {
            return "OnQuickBlockSwitchClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreaksEnabledClicked extends GeneralSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreaksEnabledClicked f109720a = new OnStreaksEnabledClicked();

        private OnStreaksEnabledClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreaksEnabledClicked);
        }

        public int hashCode() {
            return 877985178;
        }

        public String toString() {
            return "OnStreaksEnabledClicked";
        }
    }

    public /* synthetic */ GeneralSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GeneralSettingsViewEvent() {
    }
}
