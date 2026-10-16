package cz.mobilesoft.coreblock.scene.app_feel;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AppFeelViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppTypeUpdated extends AppFeelViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f98569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppDistractionType f98570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppTypeUpdated(String packageName, AppDistractionType appDistractionType) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
            this.f98569a = packageName;
            this.f98570b = appDistractionType;
        }

        public final AppDistractionType a() {
            return this.f98570b;
        }

        public final String b() {
            return this.f98569a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAppTypeUpdated)) {
                return false;
            }
            OnAppTypeUpdated onAppTypeUpdated = (OnAppTypeUpdated) obj;
            return Intrinsics.areEqual(this.f98569a, onAppTypeUpdated.f98569a) && this.f98570b == onAppTypeUpdated.f98570b;
        }

        public int hashCode() {
            return (this.f98569a.hashCode() * 31) + this.f98570b.hashCode();
        }

        public String toString() {
            return "OnAppTypeUpdated(packageName=" + this.f98569a + ", appDistractionType=" + this.f98570b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnItemExcludedFromReports extends AppFeelViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f98571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f98572b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnItemExcludedFromReports(String packageName, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f98571a = packageName;
            this.f98572b = z2;
        }

        public final boolean a() {
            return this.f98572b;
        }

        public final String b() {
            return this.f98571a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnItemExcludedFromReports)) {
                return false;
            }
            OnItemExcludedFromReports onItemExcludedFromReports = (OnItemExcludedFromReports) obj;
            return Intrinsics.areEqual(this.f98571a, onItemExcludedFromReports.f98571a) && this.f98572b == onItemExcludedFromReports.f98572b;
        }

        public int hashCode() {
            return (this.f98571a.hashCode() * 31) + Boolean.hashCode(this.f98572b);
        }

        public String toString() {
            return "OnItemExcludedFromReports(packageName=" + this.f98571a + ", ignored=" + this.f98572b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLabelingFinished extends AppFeelViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLabelingFinished f98573a = new OnLabelingFinished();

        private OnLabelingFinished() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLabelingFinished);
        }

        public int hashCode() {
            return 1877600738;
        }

        public String toString() {
            return "OnLabelingFinished";
        }
    }

    public /* synthetic */ AppFeelViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AppFeelViewEvent() {
    }
}
