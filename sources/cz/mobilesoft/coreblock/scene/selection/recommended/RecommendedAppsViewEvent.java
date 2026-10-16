package cz.mobilesoft.coreblock.scene.selection.recommended;

import com.facebook.share.HKJ.pnxuebdT;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
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
public abstract class RecommendedAppsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishWithApplications extends RecommendedAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f119192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f119193b;

        public FinishWithApplications(boolean z2, boolean z3) {
            super(null);
            this.f119192a = z2;
            this.f119193b = z3;
        }

        public final boolean a() {
            return this.f119192a;
        }

        public final boolean b() {
            return this.f119193b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FinishWithApplications)) {
                return false;
            }
            FinishWithApplications finishWithApplications = (FinishWithApplications) obj;
            return this.f119192a == finishWithApplications.f119192a && this.f119193b == finishWithApplications.f119193b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f119192a) * 31) + Boolean.hashCode(this.f119193b);
        }

        public String toString() {
            return "FinishWithApplications(seeAll=" + this.f119192a + ", withRelatedWebsites=" + this.f119193b + ")";
        }

        public /* synthetic */ FinishWithApplications(boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppSelected extends RecommendedAppsViewEvent {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f119194b = ApplicationDTO.f96901j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ApplicationDTO f119195a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppSelected(ApplicationDTO app) {
            super(null);
            Intrinsics.checkNotNullParameter(app, "app");
            this.f119195a = app;
        }

        public final ApplicationDTO a() {
            return this.f119195a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppSelected) && Intrinsics.areEqual(this.f119195a, ((OnAppSelected) obj).f119195a);
        }

        public int hashCode() {
            return this.f119195a.hashCode();
        }

        public String toString() {
            return pnxuebdT.uvDTzXJpxQYJdp + this.f119195a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SearchWebsitesForSelectedApps extends RecommendedAppsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SearchWebsitesForSelectedApps f119196a = new SearchWebsitesForSelectedApps();

        private SearchWebsitesForSelectedApps() {
            super(null);
        }
    }

    public /* synthetic */ RecommendedAppsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RecommendedAppsViewEvent() {
    }
}
