package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
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
public abstract class SharedWifiConditionEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CheckPermissionState extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CheckPermissionState f115990a = new CheckPermissionState();

        private CheckPermissionState() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLocationServicesEnabled extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLocationServicesEnabled f115991a = new OnLocationServicesEnabled();

        private OnLocationServicesEnabled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsDenied extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPermissionsDenied f115992a = new OnPermissionsDenied();

        private OnPermissionsDenied() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPermissionsGranted extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPermissionsGranted f115993a = new OnPermissionsGranted();

        private OnPermissionsGranted() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQueryChanged extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f115994a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnQueryChanged(String query) {
            super(null);
            Intrinsics.checkNotNullParameter(query, "query");
            this.f115994a = query;
        }

        public final String a() {
            return this.f115994a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnQueryChanged) && Intrinsics.areEqual(this.f115994a, ((OnQueryChanged) obj).f115994a);
        }

        public int hashCode() {
            return this.f115994a.hashCode();
        }

        public String toString() {
            return "OnQueryChanged(query=" + this.f115994a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSearchOpenStateChanged extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f115995a;

        public OnSearchOpenStateChanged(boolean z2) {
            super(null);
            this.f115995a = z2;
        }

        public final boolean a() {
            return this.f115995a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSearchOpenStateChanged) && this.f115995a == ((OnSearchOpenStateChanged) obj).f115995a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f115995a);
        }

        public String toString() {
            return "OnSearchOpenStateChanged(isOpen=" + this.f115995a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWifiCheckedChanged extends SharedWifiConditionEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Wifi f115996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f115997b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWifiCheckedChanged(Wifi wifi, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(wifi, "wifi");
            this.f115996a = wifi;
            this.f115997b = z2;
        }

        public final Wifi a() {
            return this.f115996a;
        }

        public final boolean b() {
            return this.f115997b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnWifiCheckedChanged)) {
                return false;
            }
            OnWifiCheckedChanged onWifiCheckedChanged = (OnWifiCheckedChanged) obj;
            return Intrinsics.areEqual(this.f115996a, onWifiCheckedChanged.f115996a) && this.f115997b == onWifiCheckedChanged.f115997b;
        }

        public int hashCode() {
            return (this.f115996a.hashCode() * 31) + Boolean.hashCode(this.f115997b);
        }

        public String toString() {
            return "OnWifiCheckedChanged(wifi=" + this.f115996a + ", isChecked=" + this.f115997b + ")";
        }
    }

    public /* synthetic */ SharedWifiConditionEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SharedWifiConditionEvent() {
    }
}
