package cz.mobilesoft.coreblock.scene.schedule.preview;

import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
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
public interface BlockingListItem {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class App implements BlockingListItem {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f117327b = ApplicationDTO.f96901j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ApplicationDTO f117328a;

        public App(ApplicationDTO app) {
            Intrinsics.checkNotNullParameter(app, "app");
            this.f117328a = app;
        }

        public final ApplicationDTO a() {
            return this.f117328a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof App) && Intrinsics.areEqual(this.f117328a, ((App) obj).f117328a);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.preview.BlockingListItem
        public String getKey() {
            return "app_" + this.f117328a.f();
        }

        public int hashCode() {
            return this.f117328a.hashCode();
        }

        public String toString() {
            return "App(app=" + this.f117328a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Domain implements BlockingListItem {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f117329b = WebsiteProfileRelation.f126515i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteProfileRelation f117330a;

        public Domain(WebsiteProfileRelation website) {
            Intrinsics.checkNotNullParameter(website, "website");
            this.f117330a = website;
        }

        public final WebsiteProfileRelation a() {
            return this.f117330a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Domain) && Intrinsics.areEqual(this.f117330a, ((Domain) obj).f117330a);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.preview.BlockingListItem
        public String getKey() {
            return "domain_" + this.f117330a.b();
        }

        public int hashCode() {
            return this.f117330a.hashCode();
        }

        public String toString() {
            return "Domain(website=" + this.f117330a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Keyword implements BlockingListItem {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f117331b = WebsiteProfileRelation.f126515i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteProfileRelation f117332a;

        public Keyword(WebsiteProfileRelation website) {
            Intrinsics.checkNotNullParameter(website, "website");
            this.f117332a = website;
        }

        public final WebsiteProfileRelation a() {
            return this.f117332a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Keyword) && Intrinsics.areEqual(this.f117332a, ((Keyword) obj).f117332a);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.preview.BlockingListItem
        public String getKey() {
            return "keyword_" + this.f117332a.b();
        }

        public int hashCode() {
            return this.f117332a.hashCode();
        }

        public String toString() {
            return "Keyword(website=" + this.f117332a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Option implements BlockingListItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SchedulePreviewViewState.BlockingOption f117333a;

        public Option(SchedulePreviewViewState.BlockingOption option) {
            Intrinsics.checkNotNullParameter(option, "option");
            this.f117333a = option;
        }

        public final SchedulePreviewViewState.BlockingOption a() {
            return this.f117333a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Option) && Intrinsics.areEqual(this.f117333a, ((Option) obj).f117333a);
        }

        @Override // cz.mobilesoft.coreblock.scene.schedule.preview.BlockingListItem
        public String getKey() {
            return "option_" + this.f117333a.b();
        }

        public int hashCode() {
            return this.f117333a.hashCode();
        }

        public String toString() {
            return "Option(option=" + this.f117333a + ")";
        }
    }

    String getKey();
}
