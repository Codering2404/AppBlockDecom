package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BlockingModeSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockingModeClicked extends BlockingModeSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.BlockingMode f115059a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBlockingModeClicked(Profile.BlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f115059a = blockingMode;
        }

        public final Profile.BlockingMode a() {
            return this.f115059a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnBlockingModeClicked) && this.f115059a == ((OnBlockingModeClicked) obj).f115059a;
        }

        public int hashCode() {
            return this.f115059a.hashCode();
        }

        public String toString() {
            return "OnBlockingModeClicked(blockingMode=" + this.f115059a + HcgZcEUYo.TMQAffheNavJMj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnContinueClicked extends BlockingModeSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnContinueClicked f115060a = new OnContinueClicked();

        private OnContinueClicked() {
            super(null);
        }
    }

    public /* synthetic */ BlockingModeSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingModeSettingsViewEvent() {
    }
}
