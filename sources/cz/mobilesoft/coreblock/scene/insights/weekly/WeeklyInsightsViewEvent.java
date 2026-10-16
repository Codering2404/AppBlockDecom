package cz.mobilesoft.coreblock.scene.insights.weekly;

import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class WeeklyInsightsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddScheduleClicked extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAddScheduleClicked f103908a = new OnAddScheduleClicked();

        private OnAddScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAddScheduleClicked);
        }

        public int hashCode() {
            return 389676810;
        }

        public String toString() {
            return "OnAddScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppSelected extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f103909a;

        public final String a() {
            return this.f103909a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppSelected) && Intrinsics.areEqual(this.f103909a, ((OnAppSelected) obj).f103909a);
        }

        public int hashCode() {
            return this.f103909a.hashCode();
        }

        public String toString() {
            return "OnAppSelected(packageName=" + this.f103909a + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppSelected(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, wgbAZXYjrv.mlKSSya);
            this.f103909a = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnContinuousUseScheduleCreated extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnContinuousUseScheduleCreated f103910a = new OnContinuousUseScheduleCreated();

        private OnContinuousUseScheduleCreated() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnContinuousUseScheduleCreated);
        }

        public int hashCode() {
            return 1706855380;
        }

        public String toString() {
            return "OnContinuousUseScheduleCreated";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissBottomSheet extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissBottomSheet f103911a = new OnDismissBottomSheet();

        private OnDismissBottomSheet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissBottomSheet);
        }

        public int hashCode() {
            return -1762608795;
        }

        public String toString() {
            return "OnDismissBottomSheet";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLockedScheduleClicked extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLockedScheduleClicked f103912a = new OnLockedScheduleClicked();

        private OnLockedScheduleClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLockedScheduleClicked);
        }

        public int hashCode() {
            return -2131520789;
        }

        public String toString() {
            return "OnLockedScheduleClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleClicked extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f103913a;

        public OnScheduleClicked(int i3) {
            super(null);
            this.f103913a = i3;
        }

        public final int a() {
            return this.f103913a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleClicked) && this.f103913a == ((OnScheduleClicked) obj).f103913a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f103913a);
        }

        public String toString() {
            return "OnScheduleClicked(index=" + this.f103913a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScheduleSelectionConfirmed extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f103914a;

        public OnScheduleSelectionConfirmed(boolean z2) {
            super(null);
            this.f103914a = z2;
        }

        public final boolean a() {
            return this.f103914a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnScheduleSelectionConfirmed) && this.f103914a == ((OnScheduleSelectionConfirmed) obj).f103914a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f103914a);
        }

        public String toString() {
            return "OnScheduleSelectionConfirmed(overrideAppBlockWarning=" + this.f103914a + ")";
        }

        public /* synthetic */ OnScheduleSelectionConfirmed(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTypicalDayScheduleCreated extends WeeklyInsightsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTypicalDayScheduleCreated f103915a = new OnTypicalDayScheduleCreated();

        private OnTypicalDayScheduleCreated() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTypicalDayScheduleCreated);
        }

        public int hashCode() {
            return 223508554;
        }

        public String toString() {
            return "OnTypicalDayScheduleCreated";
        }
    }

    public /* synthetic */ WeeklyInsightsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WeeklyInsightsViewEvent() {
    }
}
