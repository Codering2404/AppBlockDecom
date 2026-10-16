package cz.mobilesoft.coreblock.scene.selection.base;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import java.util.ArrayList;
import java.util.List;
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
public abstract class BaseSelectionViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class BlockingSelectViewCommand extends BaseSelectionViewCommand {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShowBottomSheet extends BlockingSelectViewCommand {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ShowBottomSheet f118175a = new ShowBottomSheet();

            private ShowBottomSheet() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof ShowBottomSheet);
            }

            public int hashCode() {
                return -1141158647;
            }

            public String toString() {
                return "ShowBottomSheet";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShowContainsAppBlockErrorDialog extends BlockingSelectViewCommand {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ShowContainsAppBlockErrorDialog f118176a = new ShowContainsAppBlockErrorDialog();

            private ShowContainsAppBlockErrorDialog() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof ShowContainsAppBlockErrorDialog);
            }

            public int hashCode() {
                return 1310031706;
            }

            public String toString() {
                return "ShowContainsAppBlockErrorDialog";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShowStrictModeSnackBar extends BlockingSelectViewCommand {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f118177a;

            public ShowStrictModeSnackBar(int i3) {
                super(null);
                this.f118177a = i3;
            }

            public final int a() {
                return this.f118177a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ShowStrictModeSnackBar) && this.f118177a == ((ShowStrictModeSnackBar) obj).f118177a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f118177a);
            }

            public String toString() {
                return "ShowStrictModeSnackBar(text=" + this.f118177a + ")";
            }
        }

        public /* synthetic */ BlockingSelectViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private BlockingSelectViewCommand() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends BaseSelectionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Close f118178a = new Close();

        private Close() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Close);
        }

        public int hashCode() {
            return 1482271555;
        }

        public String toString() {
            return "Close";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CloseWithSelectedAppsAndWebsites extends BaseSelectionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f118179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f118180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f118181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ArrayList f118182d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CloseWithSelectedAppsAndWebsites(ArrayList applications, ArrayList websites, List categories, ArrayList selectedSubApps) {
            super(null);
            Intrinsics.checkNotNullParameter(applications, "applications");
            Intrinsics.checkNotNullParameter(websites, "websites");
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(selectedSubApps, "selectedSubApps");
            this.f118179a = applications;
            this.f118180b = websites;
            this.f118181c = categories;
            this.f118182d = selectedSubApps;
        }

        public final ArrayList a() {
            return this.f118179a;
        }

        public final List b() {
            return this.f118181c;
        }

        public final ArrayList c() {
            return this.f118182d;
        }

        public final ArrayList d() {
            return this.f118180b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloseWithSelectedAppsAndWebsites)) {
                return false;
            }
            CloseWithSelectedAppsAndWebsites closeWithSelectedAppsAndWebsites = (CloseWithSelectedAppsAndWebsites) obj;
            return Intrinsics.areEqual(this.f118179a, closeWithSelectedAppsAndWebsites.f118179a) && Intrinsics.areEqual(this.f118180b, closeWithSelectedAppsAndWebsites.f118180b) && Intrinsics.areEqual(this.f118181c, closeWithSelectedAppsAndWebsites.f118181c) && Intrinsics.areEqual(this.f118182d, closeWithSelectedAppsAndWebsites.f118182d);
        }

        public int hashCode() {
            return (((((this.f118179a.hashCode() * 31) + this.f118180b.hashCode()) * 31) + this.f118181c.hashCode()) * 31) + this.f118182d.hashCode();
        }

        public String toString() {
            return "CloseWithSelectedAppsAndWebsites(applications=" + this.f118179a + ", websites=" + this.f118180b + ", categories=" + this.f118181c + ", selectedSubApps=" + this.f118182d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToTab extends BlockingSelectViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TabItem f118183a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToTab(TabItem tab) {
            super(null);
            Intrinsics.checkNotNullParameter(tab, "tab");
            this.f118183a = tab;
        }

        public final TabItem a() {
            return this.f118183a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToTab) && this.f118183a == ((NavigateToTab) obj).f118183a;
        }

        public int hashCode() {
            return this.f118183a.hashCode();
        }

        public String toString() {
            return "NavigateToTab(tab=" + this.f118183a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScrollListToTop extends BaseSelectionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TabItem f118184a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollListToTop(TabItem tabItem) {
            super(null);
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            this.f118184a = tabItem;
        }

        public final TabItem a() {
            return this.f118184a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScrollListToTop) && this.f118184a == ((ScrollListToTop) obj).f118184a;
        }

        public int hashCode() {
            return this.f118184a.hashCode();
        }

        public String toString() {
            return "ScrollListToTop(tabItem=" + this.f118184a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowExitConfirmationDialog extends BaseSelectionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowExitConfirmationDialog f118185a = new ShowExitConfirmationDialog();

        private ShowExitConfirmationDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowExitConfirmationDialog);
        }

        public int hashCode() {
            return 59563661;
        }

        public String toString() {
            return "ShowExitConfirmationDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPremiumFeatureDialog extends BaseSelectionViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumFeature f118186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f118187b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPremiumFeatureDialog(PremiumFeature premiumFeature, String entrancesDetail) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
            Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
            this.f118186a = premiumFeature;
            this.f118187b = entrancesDetail;
        }

        public final String a() {
            return this.f118187b;
        }

        public final PremiumFeature b() {
            return this.f118186a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowPremiumFeatureDialog)) {
                return false;
            }
            ShowPremiumFeatureDialog showPremiumFeatureDialog = (ShowPremiumFeatureDialog) obj;
            return this.f118186a == showPremiumFeatureDialog.f118186a && Intrinsics.areEqual(this.f118187b, showPremiumFeatureDialog.f118187b);
        }

        public int hashCode() {
            return (this.f118186a.hashCode() * 31) + this.f118187b.hashCode();
        }

        public String toString() {
            return "ShowPremiumFeatureDialog(premiumFeature=" + this.f118186a + ", entrancesDetail=" + this.f118187b + ")";
        }
    }

    public /* synthetic */ BaseSelectionViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BaseSelectionViewCommand() {
    }
}
