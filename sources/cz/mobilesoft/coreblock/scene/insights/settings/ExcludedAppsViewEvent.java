package cz.mobilesoft.coreblock.scene.insights.settings;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import kotlin.Metadata;
import kotlin.experimental.kJ.HcgZcEUYo;
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
public abstract class ExcludedAppsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRemoveClicked extends ExcludedAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IgnoredStatisticsItem f103446a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRemoveClicked(IgnoredStatisticsItem ignoredItem) {
            super(null);
            Intrinsics.checkNotNullParameter(ignoredItem, "ignoredItem");
            this.f103446a = ignoredItem;
        }

        public final IgnoredStatisticsItem a() {
            return this.f103446a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnRemoveClicked) && Intrinsics.areEqual(this.f103446a, ((OnRemoveClicked) obj).f103446a);
        }

        public int hashCode() {
            return this.f103446a.hashCode();
        }

        public String toString() {
            return "OnRemoveClicked(ignoredItem=" + this.f103446a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTabSelected extends ExcludedAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f103447a;

        public OnTabSelected(int i3) {
            super(null);
            this.f103447a = i3;
        }

        public final int a() {
            return this.f103447a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTabSelected) && this.f103447a == ((OnTabSelected) obj).f103447a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f103447a);
        }

        public String toString() {
            return HcgZcEUYo.maBQjuAZ + this.f103447a + ")";
        }
    }

    public /* synthetic */ ExcludedAppsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ExcludedAppsViewEvent() {
    }
}
