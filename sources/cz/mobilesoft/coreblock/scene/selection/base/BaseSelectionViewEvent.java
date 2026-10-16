package cz.mobilesoft.coreblock.scene.selection.base;

import android.net.Uri;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public abstract class BaseSelectionViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class BlockingSelectViewEvent extends BaseSelectionViewEvent {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnBlockWebsitesForSelectedAppsClicked extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f118188a;

            public OnBlockWebsitesForSelectedAppsClicked(boolean z2) {
                super(null);
                this.f118188a = z2;
            }

            public final boolean a() {
                return this.f118188a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OnBlockWebsitesForSelectedAppsClicked) && this.f118188a == ((OnBlockWebsitesForSelectedAppsClicked) obj).f118188a;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f118188a);
            }

            public String toString() {
                return "OnBlockWebsitesForSelectedAppsClicked(withRelatedWebsites=" + this.f118188a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnBrowsersForWebAllowlistClicked extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f118189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List f118190b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnBrowsersForWebAllowlistClicked(boolean z2, List packageNames) {
                super(null);
                Intrinsics.checkNotNullParameter(packageNames, "packageNames");
                this.f118189a = z2;
                this.f118190b = packageNames;
            }

            public final List a() {
                return this.f118190b;
            }

            public final boolean b() {
                return this.f118189a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OnBrowsersForWebAllowlistClicked)) {
                    return false;
                }
                OnBrowsersForWebAllowlistClicked onBrowsersForWebAllowlistClicked = (OnBrowsersForWebAllowlistClicked) obj;
                return this.f118189a == onBrowsersForWebAllowlistClicked.f118189a && Intrinsics.areEqual(this.f118190b, onBrowsersForWebAllowlistClicked.f118190b);
            }

            public int hashCode() {
                return (Boolean.hashCode(this.f118189a) * 31) + this.f118190b.hashCode();
            }

            public String toString() {
                return "OnBrowsersForWebAllowlistClicked(withBrowsers=" + this.f118189a + ", packageNames=" + this.f118190b + ")";
            }

            public /* synthetic */ OnBrowsersForWebAllowlistClicked(boolean z2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z2, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnCsvImportCancelled extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final OnCsvImportCancelled f118191a = new OnCsvImportCancelled();

            private OnCsvImportCancelled() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof OnCsvImportCancelled);
            }

            public int hashCode() {
                return -1489722923;
            }

            public String toString() {
                return "OnCsvImportCancelled";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnCsvImported extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Uri f118192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final WebsiteProfileRelation.BlockingType f118193b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnCsvImported(Uri uri, WebsiteProfileRelation.BlockingType blockingType) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                Intrinsics.checkNotNullParameter(blockingType, "blockingType");
                this.f118192a = uri;
                this.f118193b = blockingType;
            }

            public final WebsiteProfileRelation.BlockingType a() {
                return this.f118193b;
            }

            public final Uri b() {
                return this.f118192a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OnCsvImported)) {
                    return false;
                }
                OnCsvImported onCsvImported = (OnCsvImported) obj;
                return Intrinsics.areEqual(this.f118192a, onCsvImported.f118192a) && this.f118193b == onCsvImported.f118193b;
            }

            public int hashCode() {
                return (this.f118192a.hashCode() * 31) + this.f118193b.hashCode();
            }

            public String toString() {
                return "OnCsvImported(uri=" + this.f118192a + YznnJpHcAmeoW.fpjkbso + this.f118193b + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnForceBlockAppBlockClicked extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final OnForceBlockAppBlockClicked f118194a = new OnForceBlockAppBlockClicked();

            private OnForceBlockAppBlockClicked() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof OnForceBlockAppBlockClicked);
            }

            public int hashCode() {
                return -1579902358;
            }

            public String toString() {
                return "OnForceBlockAppBlockClicked";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnImportDefaultListClicked extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final OnImportDefaultListClicked f118195a = new OnImportDefaultListClicked();

            private OnImportDefaultListClicked() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof OnImportDefaultListClicked);
            }

            public int hashCode() {
                return -411870340;
            }

            public String toString() {
                return "OnImportDefaultListClicked";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnKeywordChanged extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f118196a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnKeywordChanged(String keyword) {
                super(null);
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                this.f118196a = keyword;
            }

            public final String a() {
                return this.f118196a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OnKeywordChanged) && Intrinsics.areEqual(this.f118196a, ((OnKeywordChanged) obj).f118196a);
            }

            public int hashCode() {
                return this.f118196a.hashCode();
            }

            public String toString() {
                return "OnKeywordChanged(keyword=" + this.f118196a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OnWebsiteChanged extends BlockingSelectViewEvent {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f118197a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnWebsiteChanged(String website) {
                super(null);
                Intrinsics.checkNotNullParameter(website, "website");
                this.f118197a = website;
            }

            public final String a() {
                return this.f118197a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OnWebsiteChanged) && Intrinsics.areEqual(this.f118197a, ((OnWebsiteChanged) obj).f118197a);
            }

            public int hashCode() {
                return this.f118197a.hashCode();
            }

            public String toString() {
                return "OnWebsiteChanged(website=" + this.f118197a + ")";
            }
        }

        public /* synthetic */ BlockingSelectViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private BlockingSelectViewEvent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppSearchStateChanged extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f118198a;

        public OnAppSearchStateChanged(boolean z2) {
            super(null);
            this.f118198a = z2;
        }

        public final boolean a() {
            return this.f118198a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppSearchStateChanged) && this.f118198a == ((OnAppSearchStateChanged) obj).f118198a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f118198a);
        }

        public String toString() {
            return "OnAppSearchStateChanged(searchOpened=" + this.f118198a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApplicationSearchTextChanged extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f118199a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnApplicationSearchTextChanged(String searchText) {
            super(null);
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            this.f118199a = searchText;
        }

        public final String a() {
            return this.f118199a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnApplicationSearchTextChanged) && Intrinsics.areEqual(this.f118199a, ((OnApplicationSearchTextChanged) obj).f118199a);
        }

        public int hashCode() {
            return this.f118199a.hashCode();
        }

        public String toString() {
            return "OnApplicationSearchTextChanged(searchText=" + this.f118199a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnApplicationsSelected extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f118200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f118201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Category f118202c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnApplicationsSelected(List applications, boolean z2, Category category) {
            super(null);
            Intrinsics.checkNotNullParameter(applications, "applications");
            this.f118200a = applications;
            this.f118201b = z2;
            this.f118202c = category;
        }

        public final List a() {
            return this.f118200a;
        }

        public final Category b() {
            return this.f118202c;
        }

        public final boolean c() {
            return this.f118201b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnApplicationsSelected)) {
                return false;
            }
            OnApplicationsSelected onApplicationsSelected = (OnApplicationsSelected) obj;
            return Intrinsics.areEqual(this.f118200a, onApplicationsSelected.f118200a) && this.f118201b == onApplicationsSelected.f118201b && this.f118202c == onApplicationsSelected.f118202c;
        }

        public int hashCode() {
            int iHashCode = ((this.f118200a.hashCode() * 31) + Boolean.hashCode(this.f118201b)) * 31;
            Category category = this.f118202c;
            return iHashCode + (category == null ? 0 : category.hashCode());
        }

        public String toString() {
            return "OnApplicationsSelected(applications=" + this.f118200a + ", isSelected=" + this.f118201b + ", category=" + this.f118202c + ")";
        }

        public /* synthetic */ OnApplicationsSelected(List list, boolean z2, Category category, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z2, (i3 & 4) != 0 ? null : category);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBackButtonClicked extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBackButtonClicked f118203a = new OnBackButtonClicked();

        private OnBackButtonClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBackButtonClicked);
        }

        public int hashCode() {
            return 1195199017;
        }

        public String toString() {
            return "OnBackButtonClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEditRelationClicked extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f118204c = ApplicationDTO.f96901j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ApplicationDTO f118205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f118206b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEditRelationClicked(ApplicationDTO application, String website) {
            super(null);
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(website, "website");
            this.f118205a = application;
            this.f118206b = website;
        }

        public final ApplicationDTO a() {
            return this.f118205a;
        }

        public final String b() {
            return this.f118206b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnEditRelationClicked)) {
                return false;
            }
            OnEditRelationClicked onEditRelationClicked = (OnEditRelationClicked) obj;
            return Intrinsics.areEqual(this.f118205a, onEditRelationClicked.f118205a) && Intrinsics.areEqual(this.f118206b, onEditRelationClicked.f118206b);
        }

        public int hashCode() {
            return (this.f118205a.hashCode() * 31) + this.f118206b.hashCode();
        }

        public String toString() {
            return "OnEditRelationClicked(application=" + this.f118205a + ", website=" + this.f118206b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnKeywordTypeChanged extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType f118207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnKeywordTypeChanged(BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType) {
            super(null);
            Intrinsics.checkNotNullParameter(keywordType, "keywordType");
            this.f118207a = keywordType;
        }

        public final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType a() {
            return this.f118207a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnKeywordTypeChanged) && this.f118207a == ((OnKeywordTypeChanged) obj).f118207a;
        }

        public int hashCode() {
            return this.f118207a.hashCode();
        }

        public String toString() {
            return "OnKeywordTypeChanged(keywordType=" + this.f118207a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSaveButtonClicked extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f118208a;

        public OnSaveButtonClicked(boolean z2) {
            super(null);
            this.f118208a = z2;
        }

        public final boolean a() {
            return this.f118208a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSaveButtonClicked) && this.f118208a == ((OnSaveButtonClicked) obj).f118208a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f118208a);
        }

        public String toString() {
            return "OnSaveButtonClicked(isFromOnboarding=" + this.f118208a + ")";
        }

        public /* synthetic */ OnSaveButtonClicked(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSubAppSelected extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f118209d = SubAppStateDTO.f118095d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SubAppStateDTO f118210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f118211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f118212c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSubAppSelected(SubAppStateDTO subApp, boolean z2, boolean z3) {
            super(null);
            Intrinsics.checkNotNullParameter(subApp, "subApp");
            this.f118210a = subApp;
            this.f118211b = z2;
            this.f118212c = z3;
        }

        public final SubAppStateDTO a() {
            return this.f118210a;
        }

        public final boolean b() {
            return this.f118212c;
        }

        public final boolean c() {
            return this.f118211b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSubAppSelected)) {
                return false;
            }
            OnSubAppSelected onSubAppSelected = (OnSubAppSelected) obj;
            return Intrinsics.areEqual(this.f118210a, onSubAppSelected.f118210a) && this.f118211b == onSubAppSelected.f118211b && this.f118212c == onSubAppSelected.f118212c;
        }

        public int hashCode() {
            return (((this.f118210a.hashCode() * 31) + Boolean.hashCode(this.f118211b)) * 31) + Boolean.hashCode(this.f118212c);
        }

        public String toString() {
            return "OnSubAppSelected(subApp=" + this.f118210a + ", isSelected=" + this.f118211b + ", isParentSelected=" + this.f118212c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebsiteOrKeywordAdded extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteProfileRelation.BlockingType f118213a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWebsiteOrKeywordAdded(WebsiteProfileRelation.BlockingType blockingType) {
            super(null);
            Intrinsics.checkNotNullParameter(blockingType, "blockingType");
            this.f118213a = blockingType;
        }

        public final WebsiteProfileRelation.BlockingType a() {
            return this.f118213a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWebsiteOrKeywordAdded) && this.f118213a == ((OnWebsiteOrKeywordAdded) obj).f118213a;
        }

        public int hashCode() {
            return this.f118213a.hashCode();
        }

        public String toString() {
            return "OnWebsiteOrKeywordAdded(blockingType=" + this.f118213a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebsiteOrKeywordChangeConfirmed extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteDTO f118214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f118215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f118216c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWebsiteOrKeywordChangeConfirmed(WebsiteDTO website, String newUrlOrKeyword, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(website, "website");
            Intrinsics.checkNotNullParameter(newUrlOrKeyword, "newUrlOrKeyword");
            this.f118214a = website;
            this.f118215b = newUrlOrKeyword;
            this.f118216c = z2;
        }

        public final boolean a() {
            return this.f118216c;
        }

        public final String b() {
            return this.f118215b;
        }

        public final WebsiteDTO c() {
            return this.f118214a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnWebsiteOrKeywordChangeConfirmed)) {
                return false;
            }
            OnWebsiteOrKeywordChangeConfirmed onWebsiteOrKeywordChangeConfirmed = (OnWebsiteOrKeywordChangeConfirmed) obj;
            return Intrinsics.areEqual(this.f118214a, onWebsiteOrKeywordChangeConfirmed.f118214a) && Intrinsics.areEqual(this.f118215b, onWebsiteOrKeywordChangeConfirmed.f118215b) && this.f118216c == onWebsiteOrKeywordChangeConfirmed.f118216c;
        }

        public int hashCode() {
            return (((this.f118214a.hashCode() * 31) + this.f118215b.hashCode()) * 31) + Boolean.hashCode(this.f118216c);
        }

        public String toString() {
            return "OnWebsiteOrKeywordChangeConfirmed(website=" + this.f118214a + ", newUrlOrKeyword=" + this.f118215b + ", anywhereInUrl=" + this.f118216c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebsiteOrKeywordDeleted extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteDTO f118217a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWebsiteOrKeywordDeleted(WebsiteDTO website) {
            super(null);
            Intrinsics.checkNotNullParameter(website, "website");
            this.f118217a = website;
        }

        public final WebsiteDTO a() {
            return this.f118217a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWebsiteOrKeywordDeleted) && Intrinsics.areEqual(this.f118217a, ((OnWebsiteOrKeywordDeleted) obj).f118217a);
        }

        public int hashCode() {
            return this.f118217a.hashCode();
        }

        public String toString() {
            return "OnWebsiteOrKeywordDeleted(website=" + this.f118217a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWebsiteOrKeywordSelected extends BaseSelectionViewEvent {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f118218c = WebsiteStateDTO.f118099e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebsiteStateDTO f118219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f118220b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWebsiteOrKeywordSelected(WebsiteStateDTO website, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(website, "website");
            this.f118219a = website;
            this.f118220b = z2;
        }

        public final WebsiteStateDTO a() {
            return this.f118219a;
        }

        public final boolean b() {
            return this.f118220b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnWebsiteOrKeywordSelected)) {
                return false;
            }
            OnWebsiteOrKeywordSelected onWebsiteOrKeywordSelected = (OnWebsiteOrKeywordSelected) obj;
            return Intrinsics.areEqual(this.f118219a, onWebsiteOrKeywordSelected.f118219a) && this.f118220b == onWebsiteOrKeywordSelected.f118220b;
        }

        public int hashCode() {
            return (this.f118219a.hashCode() * 31) + Boolean.hashCode(this.f118220b);
        }

        public String toString() {
            return "OnWebsiteOrKeywordSelected(website=" + this.f118219a + ", isSelected=" + this.f118220b + ")";
        }
    }

    public /* synthetic */ BaseSelectionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BaseSelectionViewEvent() {
    }
}
