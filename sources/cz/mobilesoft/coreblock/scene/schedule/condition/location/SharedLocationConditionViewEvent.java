package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import com.google.android.gms.maps.model.LatLng;
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
public abstract class SharedLocationConditionViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCurrentPositionClicked extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCurrentPositionClicked f115490a = new OnCurrentPositionClicked();

        private OnCurrentPositionClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCurrentPositionClicked);
        }

        public int hashCode() {
            return -1265534558;
        }

        public String toString() {
            return "OnCurrentPositionClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMapClicked extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LatLng f115491a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMapClicked(LatLng latLng) {
            super(null);
            Intrinsics.checkNotNullParameter(latLng, "latLng");
            this.f115491a = latLng;
        }

        public final LatLng a() {
            return this.f115491a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMapClicked) && Intrinsics.areEqual(this.f115491a, ((OnMapClicked) obj).f115491a);
        }

        public int hashCode() {
            return this.f115491a.hashCode();
        }

        public String toString() {
            return "OnMapClicked(latLng=" + this.f115491a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMissingPermissionsChanged extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMissingPermissionsChanged f115492a = new OnMissingPermissionsChanged();

        private OnMissingPermissionsChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMissingPermissionsChanged);
        }

        public int hashCode() {
            return -1671907623;
        }

        public String toString() {
            return "OnMissingPermissionsChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPaused extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPaused f115493a = new OnPaused();

        private OnPaused() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPaused);
        }

        public int hashCode() {
            return -1240656693;
        }

        public String toString() {
            return "OnPaused";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPlaceByAddressSelected extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LatLng f115494a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPlaceByAddressSelected(LatLng latLng) {
            super(null);
            Intrinsics.checkNotNullParameter(latLng, "latLng");
            this.f115494a = latLng;
        }

        public final LatLng a() {
            return this.f115494a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPlaceByAddressSelected) && Intrinsics.areEqual(this.f115494a, ((OnPlaceByAddressSelected) obj).f115494a);
        }

        public int hashCode() {
            return this.f115494a.hashCode();
        }

        public String toString() {
            return "OnPlaceByAddressSelected(latLng=" + this.f115494a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends SharedLocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f115495a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return 2082092506;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class OnSettingsChanged extends SharedLocationConditionViewEvent {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Inverted extends OnSettingsChanged {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f115496a;

            public Inverted(boolean z2) {
                super(null);
                this.f115496a = z2;
            }

            public final boolean a() {
                return this.f115496a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Inverted) && this.f115496a == ((Inverted) obj).f115496a;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f115496a);
            }

            public String toString() {
                return "Inverted(isInverted=" + this.f115496a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Radius extends OnSettingsChanged {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f115497a;

            public Radius(int i3) {
                super(null);
                this.f115497a = i3;
            }

            public final int a() {
                return this.f115497a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Radius) && this.f115497a == ((Radius) obj).f115497a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f115497a);
            }

            public String toString() {
                return "Radius(radius=" + this.f115497a + ")";
            }
        }

        public /* synthetic */ OnSettingsChanged(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private OnSettingsChanged() {
            super(null);
        }
    }

    public /* synthetic */ SharedLocationConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SharedLocationConditionViewEvent() {
    }
}
