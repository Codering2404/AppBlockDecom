package cz.mobilesoft.coreblock.scene.strictmode3.options;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
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
public abstract class StrictModeOptionsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMissingPermissionsGranted extends StrictModeOptionsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeOption f122297a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMissingPermissionsGranted(StrictModeOption option) {
            super(null);
            Intrinsics.checkNotNullParameter(option, "option");
            this.f122297a = option;
        }

        public final StrictModeOption a() {
            return this.f122297a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMissingPermissionsGranted) && this.f122297a == ((OnMissingPermissionsGranted) obj).f122297a;
        }

        public int hashCode() {
            return this.f122297a.hashCode();
        }

        public String toString() {
            return "OnMissingPermissionsGranted(option=" + this.f122297a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOptionClicked extends StrictModeOptionsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeOption f122298a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnOptionClicked(StrictModeOption option) {
            super(null);
            Intrinsics.checkNotNullParameter(option, "option");
            this.f122298a = option;
        }

        public final StrictModeOption a() {
            return this.f122298a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOptionClicked) && this.f122298a == ((OnOptionClicked) obj).f122298a;
        }

        public int hashCode() {
            return this.f122298a.hashCode();
        }

        public String toString() {
            return "OnOptionClicked(option=" + this.f122298a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveClicked extends StrictModeOptionsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSaveClicked f122299a = new OnSaveClicked();

        private OnSaveClicked() {
            super(null);
        }
    }

    public /* synthetic */ StrictModeOptionsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeOptionsViewEvent() {
    }
}
