package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
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
public abstract class LocationConditionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LocationTimeConditionViewEvent extends LocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeConditionViewEvent f115449a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationTimeConditionViewEvent(TimeConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f115449a = event;
        }

        public final TimeConditionViewEvent a() {
            return this.f115449a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocationTimeConditionViewEvent) && Intrinsics.areEqual(this.f115449a, ((LocationTimeConditionViewEvent) obj).f115449a);
        }

        public int hashCode() {
            return this.f115449a.hashCode();
        }

        public String toString() {
            return "LocationTimeConditionViewEvent(event=" + this.f115449a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends LocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f115450a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCloseClicked);
        }

        public int hashCode() {
            return -1113645359;
        }

        public String toString() {
            return "OnCloseClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends LocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f115451a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSaveClicked);
        }

        public int hashCode() {
            return -270224408;
        }

        public String toString() {
            return "OnSaveClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSharedLocationConditionViewEvent extends LocationConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedLocationConditionViewEvent f115452a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent sharedEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(sharedEvent, "sharedEvent");
            this.f115452a = sharedEvent;
        }

        public final SharedLocationConditionViewEvent a() {
            return this.f115452a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSharedLocationConditionViewEvent) && Intrinsics.areEqual(this.f115452a, ((OnSharedLocationConditionViewEvent) obj).f115452a);
        }

        public int hashCode() {
            return this.f115452a.hashCode();
        }

        public String toString() {
            return "OnSharedLocationConditionViewEvent(sharedEvent=" + this.f115452a + ")";
        }
    }

    public /* synthetic */ LocationConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LocationConditionViewEvent() {
    }
}
