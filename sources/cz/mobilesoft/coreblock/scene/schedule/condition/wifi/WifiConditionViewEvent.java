package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

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
public abstract class WifiConditionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends WifiConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f116041a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends WifiConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f116042a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSharedWifiConditionEvent extends WifiConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedWifiConditionEvent f116043a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSharedWifiConditionEvent(SharedWifiConditionEvent sharedEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(sharedEvent, "sharedEvent");
            this.f116043a = sharedEvent;
        }

        public final SharedWifiConditionEvent a() {
            return this.f116043a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSharedWifiConditionEvent) && Intrinsics.areEqual(this.f116043a, ((OnSharedWifiConditionEvent) obj).f116043a);
        }

        public int hashCode() {
            return this.f116043a.hashCode();
        }

        public String toString() {
            return "OnSharedWifiConditionEvent(sharedEvent=" + this.f116043a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WifiTimeConditionViewEvent extends WifiConditionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeConditionViewEvent f116044a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WifiTimeConditionViewEvent(TimeConditionViewEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f116044a = event;
        }

        public final TimeConditionViewEvent a() {
            return this.f116044a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WifiTimeConditionViewEvent) && Intrinsics.areEqual(this.f116044a, ((WifiTimeConditionViewEvent) obj).f116044a);
        }

        public int hashCode() {
            return this.f116044a.hashCode();
        }

        public String toString() {
            return "WifiTimeConditionViewEvent(event=" + this.f116044a + ")";
        }
    }

    public /* synthetic */ WifiConditionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WifiConditionViewEvent() {
    }
}
