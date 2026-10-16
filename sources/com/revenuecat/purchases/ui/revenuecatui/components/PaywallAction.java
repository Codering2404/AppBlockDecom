package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
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
public interface PaywallAction {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Internal extends PaywallAction {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NavigateTo implements Internal {
            public static final int $stable = 8;
            private final Destination destination;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public interface Destination {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Sheet implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet;

                    public Sheet(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        this.sheet = sheet;
                    }

                    public static /* synthetic */ Sheet copy$default(Sheet sheet, ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet2, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            sheet2 = sheet.sheet;
                        }
                        return sheet.copy(sheet2);
                    }

                    public final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet component1() {
                        return this.sheet;
                    }

                    public final Sheet copy(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        return new Sheet(sheet);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof Sheet) && Intrinsics.areEqual(this.sheet, ((Sheet) obj).sheet);
                    }

                    public final /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet getSheet() {
                        return this.sheet;
                    }

                    public int hashCode() {
                        return this.sheet.hashCode();
                    }

                    public String toString() {
                        return "Sheet(sheet=" + this.sheet + ')';
                    }
                }
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) obj).destination);
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface External extends PaywallAction {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class LaunchWebCheckout implements External {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final String customUrl;
            private final ButtonComponent.UrlMethod openMethod;
            private final PackageParamBehavior packageParamBehavior;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public interface PackageParamBehavior {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Append implements PackageParamBehavior {
                    public static final int $stable = 8;
                    private final String packageParam;
                    private final Package rcPackage;

                    public Append(Package r12, String str) {
                        this.rcPackage = r12;
                        this.packageParam = str;
                    }

                    public static /* synthetic */ Append copy$default(Append append, Package r12, String str, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            r12 = append.rcPackage;
                        }
                        if ((i3 & 2) != 0) {
                            str = append.packageParam;
                        }
                        return append.copy(r12, str);
                    }

                    public final Package component1() {
                        return this.rcPackage;
                    }

                    public final String component2() {
                        return this.packageParam;
                    }

                    public final Append copy(Package r2, String str) {
                        return new Append(r2, str);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Append)) {
                            return false;
                        }
                        Append append = (Append) obj;
                        return Intrinsics.areEqual(this.rcPackage, append.rcPackage) && Intrinsics.areEqual(this.packageParam, append.packageParam);
                    }

                    public final String getPackageParam() {
                        return this.packageParam;
                    }

                    public final Package getRcPackage() {
                        return this.rcPackage;
                    }

                    public int hashCode() {
                        Package r02 = this.rcPackage;
                        int iHashCode = (r02 == null ? 0 : r02.hashCode()) * 31;
                        String str = this.packageParam;
                        return iHashCode + (str != null ? str.hashCode() : 0);
                    }

                    public String toString() {
                        return "Append(rcPackage=" + this.rcPackage + ", packageParam=" + this.packageParam + ')';
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class DoNotAppend implements PackageParamBehavior {
                    public static final int $stable = 0;
                    public static final DoNotAppend INSTANCE = new DoNotAppend();

                    private DoNotAppend() {
                    }
                }
            }

            public LaunchWebCheckout(String str, ButtonComponent.UrlMethod openMethod, boolean z2, PackageParamBehavior packageParamBehavior) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(packageParamBehavior, "packageParamBehavior");
                this.customUrl = str;
                this.openMethod = openMethod;
                this.autoDismiss = z2;
                this.packageParamBehavior = packageParamBehavior;
            }

            public static /* synthetic */ LaunchWebCheckout copy$default(LaunchWebCheckout launchWebCheckout, String str, ButtonComponent.UrlMethod urlMethod, boolean z2, PackageParamBehavior packageParamBehavior, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = launchWebCheckout.customUrl;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = launchWebCheckout.openMethod;
                }
                if ((i3 & 4) != 0) {
                    z2 = launchWebCheckout.autoDismiss;
                }
                if ((i3 & 8) != 0) {
                    packageParamBehavior = launchWebCheckout.packageParamBehavior;
                }
                return launchWebCheckout.copy(str, urlMethod, z2, packageParamBehavior);
            }

            public final String component1() {
                return this.customUrl;
            }

            public final ButtonComponent.UrlMethod component2() {
                return this.openMethod;
            }

            public final boolean component3() {
                return this.autoDismiss;
            }

            public final PackageParamBehavior component4() {
                return this.packageParamBehavior;
            }

            public final LaunchWebCheckout copy(String str, ButtonComponent.UrlMethod openMethod, boolean z2, PackageParamBehavior packageParamBehavior) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(packageParamBehavior, "packageParamBehavior");
                return new LaunchWebCheckout(str, openMethod, z2, packageParamBehavior);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LaunchWebCheckout)) {
                    return false;
                }
                LaunchWebCheckout launchWebCheckout = (LaunchWebCheckout) obj;
                return Intrinsics.areEqual(this.customUrl, launchWebCheckout.customUrl) && this.openMethod == launchWebCheckout.openMethod && this.autoDismiss == launchWebCheckout.autoDismiss && Intrinsics.areEqual(this.packageParamBehavior, launchWebCheckout.packageParamBehavior);
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final String getCustomUrl() {
                return this.customUrl;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final PackageParamBehavior getPackageParamBehavior() {
                return this.packageParamBehavior;
            }

            public int hashCode() {
                String str = this.customUrl;
                return ((((((str == null ? 0 : str.hashCode()) * 31) + this.openMethod.hashCode()) * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.packageParamBehavior.hashCode();
            }

            public String toString() {
                return "LaunchWebCheckout(customUrl=" + this.customUrl + ", openMethod=" + this.openMethod + ", autoDismiss=" + this.autoDismiss + ", packageParamBehavior=" + this.packageParamBehavior + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NavigateBack implements External {
            public static final int $stable = 0;
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NavigateTo implements External {
            public static final int $stable = 8;
            private final Destination destination;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public interface Destination {

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class CustomerCenter implements Destination {
                    public static final int $stable = 0;
                    public static final CustomerCenter INSTANCE = new CustomerCenter();

                    private CustomerCenter() {
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Url implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponent.UrlMethod method;
                    private final String url;

                    public Url(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        this.url = url;
                        this.method = method;
                    }

                    public static /* synthetic */ Url copy$default(Url url, String str, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            str = url.url;
                        }
                        if ((i3 & 2) != 0) {
                            urlMethod = url.method;
                        }
                        return url.copy(str, urlMethod);
                    }

                    public final String component1() {
                        return this.url;
                    }

                    public final ButtonComponent.UrlMethod component2() {
                        return this.method;
                    }

                    public final Url copy(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        return new Url(url, method);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Url)) {
                            return false;
                        }
                        Url url = (Url) obj;
                        return Intrinsics.areEqual(this.url, url.url) && this.method == url.method;
                    }

                    public final /* synthetic */ ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public int hashCode() {
                        return (this.url.hashCode() * 31) + this.method.hashCode();
                    }

                    public String toString() {
                        return "Url(url=" + this.url + ", method=" + this.method + ')';
                    }
                }
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) obj).destination);
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class RestorePurchases implements External {
            public static final int $stable = 0;
            public static final RestorePurchases INSTANCE = new RestorePurchases();

            private RestorePurchases() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WorkflowTrigger implements External {
            public static final int $stable = 0;
            private final String componentId;
            private final WorkflowTriggerType triggerType;

            public WorkflowTrigger(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                this.componentId = componentId;
                this.triggerType = triggerType;
            }

            public static /* synthetic */ WorkflowTrigger copy$default(WorkflowTrigger workflowTrigger, String str, WorkflowTriggerType workflowTriggerType, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = workflowTrigger.componentId;
                }
                if ((i3 & 2) != 0) {
                    workflowTriggerType = workflowTrigger.triggerType;
                }
                return workflowTrigger.copy(str, workflowTriggerType);
            }

            public final String component1() {
                return this.componentId;
            }

            public final WorkflowTriggerType component2() {
                return this.triggerType;
            }

            public final WorkflowTrigger copy(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                return new WorkflowTrigger(componentId, triggerType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WorkflowTrigger)) {
                    return false;
                }
                WorkflowTrigger workflowTrigger = (WorkflowTrigger) obj;
                return Intrinsics.areEqual(this.componentId, workflowTrigger.componentId) && this.triggerType == workflowTrigger.triggerType;
            }

            public final String getComponentId() {
                return this.componentId;
            }

            public final WorkflowTriggerType getTriggerType() {
                return this.triggerType;
            }

            public int hashCode() {
                return (this.componentId.hashCode() * 31) + this.triggerType.hashCode();
            }

            public String toString() {
                return "WorkflowTrigger(componentId=" + this.componentId + ", triggerType=" + this.triggerType + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PurchasePackage implements External {
            public static final int $stable = 8;
            private final Package rcPackage;
            private final ResolvedOffer resolvedOffer;

            public PurchasePackage(Package r12, ResolvedOffer resolvedOffer) {
                this.rcPackage = r12;
                this.resolvedOffer = resolvedOffer;
            }

            public static /* synthetic */ PurchasePackage copy$default(PurchasePackage purchasePackage, Package r12, ResolvedOffer resolvedOffer, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    r12 = purchasePackage.rcPackage;
                }
                if ((i3 & 2) != 0) {
                    resolvedOffer = purchasePackage.resolvedOffer;
                }
                return purchasePackage.copy(r12, resolvedOffer);
            }

            public final Package component1() {
                return this.rcPackage;
            }

            public final ResolvedOffer component2() {
                return this.resolvedOffer;
            }

            public final PurchasePackage copy(Package r2, ResolvedOffer resolvedOffer) {
                return new PurchasePackage(r2, resolvedOffer);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PurchasePackage)) {
                    return false;
                }
                PurchasePackage purchasePackage = (PurchasePackage) obj;
                return Intrinsics.areEqual(this.rcPackage, purchasePackage.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, purchasePackage.resolvedOffer);
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final ResolvedOffer getResolvedOffer() {
                return this.resolvedOffer;
            }

            public int hashCode() {
                Package r02 = this.rcPackage;
                int iHashCode = (r02 == null ? 0 : r02.hashCode()) * 31;
                ResolvedOffer resolvedOffer = this.resolvedOffer;
                return iHashCode + (resolvedOffer != null ? resolvedOffer.hashCode() : 0);
            }

            public String toString() {
                return "PurchasePackage(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ')';
            }

            public /* synthetic */ PurchasePackage(Package r12, ResolvedOffer resolvedOffer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(r12, (i3 & 2) != 0 ? null : resolvedOffer);
            }
        }
    }
}
