package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

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
public abstract class TimeNudgeSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppsClick extends TimeNudgeSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAppsClick f110280a = new OnAppsClick();

        private OnAppsClick() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAppsClick);
        }

        public int hashCode() {
            return 1303956748;
        }

        public String toString() {
            return "OnAppsClick";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEnabledClick extends TimeNudgeSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEnabledClick f110281a = new OnEnabledClick();

        private OnEnabledClick() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEnabledClick);
        }

        public int hashCode() {
            return -2028132303;
        }

        public String toString() {
            return "OnEnabledClick";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends TimeNudgeSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f110282a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return 975767085;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    public /* synthetic */ TimeNudgeSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TimeNudgeSettingsViewEvent() {
    }
}
