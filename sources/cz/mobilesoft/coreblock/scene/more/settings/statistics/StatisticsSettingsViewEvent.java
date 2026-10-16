package cz.mobilesoft.coreblock.scene.more.settings.statistics;

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
public abstract class StatisticsSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppStatisticsClick extends StatisticsSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110199a;

        public OnAppStatisticsClick(boolean z2) {
            super(null);
            this.f110199a = z2;
        }

        public final boolean a() {
            return this.f110199a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppStatisticsClick) && this.f110199a == ((OnAppStatisticsClick) obj).f110199a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110199a);
        }

        public String toString() {
            return "OnAppStatisticsClick(enabled=" + this.f110199a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnIncognitoStatisticsClick extends StatisticsSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110200a;

        public OnIncognitoStatisticsClick(boolean z2) {
            super(null);
            this.f110200a = z2;
        }

        public final boolean a() {
            return this.f110200a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnIncognitoStatisticsClick) && this.f110200a == ((OnIncognitoStatisticsClick) obj).f110200a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110200a);
        }

        public String toString() {
            return "OnIncognitoStatisticsClick(enabled=" + this.f110200a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStatisticsDisabledClick extends StatisticsSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStatisticsDisabledClick f110201a = new OnStatisticsDisabledClick();

        private OnStatisticsDisabledClick() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStatisticsDisabledClick);
        }

        public int hashCode() {
            return -768739233;
        }

        public String toString() {
            return "OnStatisticsDisabledClick";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStatisticsEnabledClick extends StatisticsSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStatisticsEnabledClick f110202a = new OnStatisticsEnabledClick();

        private OnStatisticsEnabledClick() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStatisticsEnabledClick);
        }

        public int hashCode() {
            return -1119244172;
        }

        public String toString() {
            return "OnStatisticsEnabledClick";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebStatisticsClick extends StatisticsSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110203a;

        public OnWebStatisticsClick(boolean z2) {
            super(null);
            this.f110203a = z2;
        }

        public final boolean a() {
            return this.f110203a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWebStatisticsClick) && this.f110203a == ((OnWebStatisticsClick) obj).f110203a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110203a);
        }

        public String toString() {
            return "OnWebStatisticsClick(enabled=" + this.f110203a + ")";
        }
    }

    public /* synthetic */ StatisticsSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StatisticsSettingsViewEvent() {
    }
}
