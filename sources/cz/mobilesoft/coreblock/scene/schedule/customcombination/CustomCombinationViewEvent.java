package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
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
public abstract class CustomCombinationViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomCombinationLaunchCountConditionViewEvent extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LaunchCountConditionViewEvent f116271a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomCombinationLaunchCountConditionViewEvent(LaunchCountConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116271a = event;
        }

        public final LaunchCountConditionViewEvent a() {
            return this.f116271a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCombinationLaunchCountConditionViewEvent) && Intrinsics.areEqual(this.f116271a, ((CustomCombinationLaunchCountConditionViewEvent) obj).f116271a);
        }

        public int hashCode() {
            return this.f116271a.hashCode();
        }

        public String toString() {
            return "CustomCombinationLaunchCountConditionViewEvent(event=" + this.f116271a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomCombinationLocationConditionViewEvent extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocationConditionViewEvent f116272a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomCombinationLocationConditionViewEvent(LocationConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116272a = event;
        }

        public final LocationConditionViewEvent a() {
            return this.f116272a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCombinationLocationConditionViewEvent) && Intrinsics.areEqual(this.f116272a, ((CustomCombinationLocationConditionViewEvent) obj).f116272a);
        }

        public int hashCode() {
            return this.f116272a.hashCode();
        }

        public String toString() {
            return "CustomCombinationLocationConditionViewEvent(event=" + this.f116272a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomCombinationTimeConditionViewEvent extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeConditionViewEvent f116273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomCombinationTimeConditionViewEvent(TimeConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116273a = event;
        }

        public final TimeConditionViewEvent a() {
            return this.f116273a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCombinationTimeConditionViewEvent) && Intrinsics.areEqual(this.f116273a, ((CustomCombinationTimeConditionViewEvent) obj).f116273a);
        }

        public int hashCode() {
            return this.f116273a.hashCode();
        }

        public String toString() {
            return "CustomCombinationTimeConditionViewEvent(event=" + this.f116273a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomCombinationUsageLimitConditionViewEvent extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UsageLimitConditionViewEvent f116274a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomCombinationUsageLimitConditionViewEvent(UsageLimitConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116274a = event;
        }

        public final UsageLimitConditionViewEvent a() {
            return this.f116274a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCombinationUsageLimitConditionViewEvent) && Intrinsics.areEqual(this.f116274a, ((CustomCombinationUsageLimitConditionViewEvent) obj).f116274a);
        }

        public int hashCode() {
            return this.f116274a.hashCode();
        }

        public String toString() {
            return "CustomCombinationUsageLimitConditionViewEvent(event=" + this.f116274a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomCombinationWifiConditionViewEvent extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WifiConditionViewEvent f116275a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomCombinationWifiConditionViewEvent(WifiConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116275a = event;
        }

        public final WifiConditionViewEvent a() {
            return this.f116275a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCombinationWifiConditionViewEvent) && Intrinsics.areEqual(this.f116275a, ((CustomCombinationWifiConditionViewEvent) obj).f116275a);
        }

        public int hashCode() {
            return this.f116275a.hashCode();
        }

        public String toString() {
            return "CustomCombinationWifiConditionViewEvent(event=" + this.f116275a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConditionChecked extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f116276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f116277b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConditionChecked(ProfileType profileType, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f116276a = profileType;
            this.f116277b = z2;
        }

        public final boolean a() {
            return this.f116277b;
        }

        public final ProfileType b() {
            return this.f116276a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnConditionChecked)) {
                return false;
            }
            OnConditionChecked onConditionChecked = (OnConditionChecked) obj;
            return this.f116276a == onConditionChecked.f116276a && this.f116277b == onConditionChecked.f116277b;
        }

        public int hashCode() {
            return (this.f116276a.hashCode() * 31) + Boolean.hashCode(this.f116277b);
        }

        public String toString() {
            return "OnConditionChecked(profileType=" + this.f116276a + ", checked=" + this.f116277b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsDenied extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPermissionsDenied f116278a = new OnPermissionsDenied();

        private OnPermissionsDenied() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPermissionsDenied);
        }

        public int hashCode() {
            return -199765181;
        }

        public String toString() {
            return "OnPermissionsDenied";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f116279a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSaveClicked);
        }

        public int hashCode() {
            return 1558637806;
        }

        public String toString() {
            return "OnSaveClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWifiPermissionDeclined extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnWifiPermissionDeclined f116280a = new OnWifiPermissionDeclined();

        private OnWifiPermissionDeclined() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnWifiPermissionDeclined);
        }

        public int hashCode() {
            return -1452060786;
        }

        public String toString() {
            return "OnWifiPermissionDeclined";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenCondition extends CustomCombinationViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileType f116281a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenCondition(ProfileType profileType) {
            super(null);
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            this.f116281a = profileType;
        }

        public final ProfileType a() {
            return this.f116281a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenCondition) && this.f116281a == ((OpenCondition) obj).f116281a;
        }

        public int hashCode() {
            return this.f116281a.hashCode();
        }

        public String toString() {
            return "OpenCondition(profileType=" + this.f116281a + ")";
        }
    }

    public /* synthetic */ CustomCombinationViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomCombinationViewEvent() {
    }
}
