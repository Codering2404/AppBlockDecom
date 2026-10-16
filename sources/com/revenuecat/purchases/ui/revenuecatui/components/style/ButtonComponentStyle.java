package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
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
public final class ButtonComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Action action;
    private final String componentId;
    private final String componentName;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final PaywallTransition transition;
    private final boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Action {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CustomWebCheckout implements Action {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;
            private final String packageParam;
            private final Package rcPackage;
            private final NonEmptyMap<LocaleId, String> urls;

            public CustomWebCheckout(NonEmptyMap<LocaleId, String> urls, boolean z2, ButtonComponent.UrlMethod openMethod, Package r5, String str) {
                Intrinsics.checkNotNullParameter(urls, "urls");
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.urls = urls;
                this.autoDismiss = z2;
                this.openMethod = openMethod;
                this.rcPackage = r5;
                this.packageParam = str;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CustomWebCheckout copy$default(CustomWebCheckout customWebCheckout, NonEmptyMap nonEmptyMap, boolean z2, ButtonComponent.UrlMethod urlMethod, Package r4, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    nonEmptyMap = customWebCheckout.urls;
                }
                if ((i3 & 2) != 0) {
                    z2 = customWebCheckout.autoDismiss;
                }
                if ((i3 & 4) != 0) {
                    urlMethod = customWebCheckout.openMethod;
                }
                if ((i3 & 8) != 0) {
                    r4 = customWebCheckout.rcPackage;
                }
                if ((i3 & 16) != 0) {
                    str = customWebCheckout.packageParam;
                }
                String str2 = str;
                ButtonComponent.UrlMethod urlMethod2 = urlMethod;
                return customWebCheckout.copy(nonEmptyMap, z2, urlMethod2, r4, str2);
            }

            public final NonEmptyMap<LocaleId, String> component1() {
                return this.urls;
            }

            public final boolean component2() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component3() {
                return this.openMethod;
            }

            public final Package component4() {
                return this.rcPackage;
            }

            public final String component5() {
                return this.packageParam;
            }

            public final CustomWebCheckout copy(NonEmptyMap<LocaleId, String> urls, boolean z2, ButtonComponent.UrlMethod openMethod, Package r11, String str) {
                Intrinsics.checkNotNullParameter(urls, "urls");
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new CustomWebCheckout(urls, z2, openMethod, r11, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CustomWebCheckout)) {
                    return false;
                }
                CustomWebCheckout customWebCheckout = (CustomWebCheckout) obj;
                return Intrinsics.areEqual(this.urls, customWebCheckout.urls) && this.autoDismiss == customWebCheckout.autoDismiss && this.openMethod == customWebCheckout.openMethod && Intrinsics.areEqual(this.rcPackage, customWebCheckout.rcPackage) && Intrinsics.areEqual(this.packageParam, customWebCheckout.packageParam);
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "custom_web_checkout";
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final String getPackageParam() {
                return this.packageParam;
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final NonEmptyMap<LocaleId, String> getUrls() {
                return this.urls;
            }

            public int hashCode() {
                int iHashCode = ((((this.urls.hashCode() * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.openMethod.hashCode()) * 31;
                Package r12 = this.rcPackage;
                int iHashCode2 = (iHashCode + (r12 == null ? 0 : r12.hashCode())) * 31;
                String str = this.packageParam;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "CustomWebCheckout(urls=" + this.urls + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ", rcPackage=" + this.rcPackage + ", packageParam=" + this.packageParam + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            public static /* synthetic */ String getDescription(Action action) {
                return "unknown";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NavigateBack implements Action {
            public static final int $stable = 0;
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class RestorePurchases implements Action {
            public static final int $stable = 0;
            public static final RestorePurchases INSTANCE = new RestorePurchases();

            private RestorePurchases() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebCheckout implements Action {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;
            private final Package rcPackage;

            public WebCheckout(Package r2, boolean z2, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.rcPackage = r2;
                this.autoDismiss = z2;
                this.openMethod = openMethod;
            }

            public static /* synthetic */ WebCheckout copy$default(WebCheckout webCheckout, Package r12, boolean z2, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    r12 = webCheckout.rcPackage;
                }
                if ((i3 & 2) != 0) {
                    z2 = webCheckout.autoDismiss;
                }
                if ((i3 & 4) != 0) {
                    urlMethod = webCheckout.openMethod;
                }
                return webCheckout.copy(r12, z2, urlMethod);
            }

            public final Package component1() {
                return this.rcPackage;
            }

            public final boolean component2() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component3() {
                return this.openMethod;
            }

            public final WebCheckout copy(Package r2, boolean z2, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new WebCheckout(r2, z2, openMethod);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WebCheckout)) {
                    return false;
                }
                WebCheckout webCheckout = (WebCheckout) obj;
                return Intrinsics.areEqual(this.rcPackage, webCheckout.rcPackage) && this.autoDismiss == webCheckout.autoDismiss && this.openMethod == webCheckout.openMethod;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "web_checkout";
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public int hashCode() {
                Package r02 = this.rcPackage;
                return ((((r02 == null ? 0 : r02.hashCode()) * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.openMethod.hashCode();
            }

            public String toString() {
                return "WebCheckout(rcPackage=" + this.rcPackage + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebProductSelection implements Action {
            public static final int $stable = 0;
            private final boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            public WebProductSelection(boolean z2, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                this.autoDismiss = z2;
                this.openMethod = openMethod;
            }

            public static /* synthetic */ WebProductSelection copy$default(WebProductSelection webProductSelection, boolean z2, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = webProductSelection.autoDismiss;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = webProductSelection.openMethod;
                }
                return webProductSelection.copy(z2, urlMethod);
            }

            public final boolean component1() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component2() {
                return this.openMethod;
            }

            public final WebProductSelection copy(boolean z2, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                return new WebProductSelection(z2, openMethod);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WebProductSelection)) {
                    return false;
                }
                WebProductSelection webProductSelection = (WebProductSelection) obj;
                return this.autoDismiss == webProductSelection.autoDismiss && this.openMethod == webProductSelection.openMethod;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return "web_product_selection";
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                return (Boolean.hashCode(this.autoDismiss) * 31) + this.openMethod.hashCode();
            }

            public String toString() {
                return "WebProductSelection(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WorkflowTrigger implements Action {
            public static final int $stable = 0;
            public static final WorkflowTrigger INSTANCE = new WorkflowTrigger();

            private WorkflowTrigger() {
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
            }
        }

        /* synthetic */ String getDescription();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NavigateTo implements Action {
            public static final int $stable = 8;
            private final Destination destination;

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

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public /* synthetic */ String getDescription() {
                return DefaultImpls.getDescription(this);
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
                public static final class Sheet implements Destination {
                    public static final int $stable = 0;
                    private final boolean backgroundBlur;
                    private final String id;
                    private final String name;
                    private final Size size;
                    private final ComponentStyle stack;

                    public Sheet(String id, String str, ComponentStyle stack, boolean z2, Size size) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(stack, "stack");
                        this.id = id;
                        this.name = str;
                        this.stack = stack;
                        this.backgroundBlur = z2;
                        this.size = size;
                    }

                    public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, ComponentStyle componentStyle, boolean z2, Size size, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            str = sheet.id;
                        }
                        if ((i3 & 2) != 0) {
                            str2 = sheet.name;
                        }
                        if ((i3 & 4) != 0) {
                            componentStyle = sheet.stack;
                        }
                        if ((i3 & 8) != 0) {
                            z2 = sheet.backgroundBlur;
                        }
                        if ((i3 & 16) != 0) {
                            size = sheet.size;
                        }
                        Size size2 = size;
                        ComponentStyle componentStyle2 = componentStyle;
                        return sheet.copy(str, str2, componentStyle2, z2, size2);
                    }

                    public final String component1() {
                        return this.id;
                    }

                    public final String component2() {
                        return this.name;
                    }

                    public final ComponentStyle component3() {
                        return this.stack;
                    }

                    public final boolean component4() {
                        return this.backgroundBlur;
                    }

                    public final Size component5() {
                        return this.size;
                    }

                    public final Sheet copy(String id, String str, ComponentStyle stack, boolean z2, Size size) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(stack, "stack");
                        return new Sheet(id, str, stack, z2, size);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Sheet)) {
                            return false;
                        }
                        Sheet sheet = (Sheet) obj;
                        return Intrinsics.areEqual(this.id, sheet.id) && Intrinsics.areEqual(this.name, sheet.name) && Intrinsics.areEqual(this.stack, sheet.stack) && this.backgroundBlur == sheet.backgroundBlur && Intrinsics.areEqual(this.size, sheet.size);
                    }

                    public final /* synthetic */ boolean getBackgroundBlur() {
                        return this.backgroundBlur;
                    }

                    public final /* synthetic */ String getId() {
                        return this.id;
                    }

                    public final /* synthetic */ String getName() {
                        return this.name;
                    }

                    public final /* synthetic */ Size getSize() {
                        return this.size;
                    }

                    public final /* synthetic */ ComponentStyle getStack() {
                        return this.stack;
                    }

                    public int hashCode() {
                        int iHashCode = this.id.hashCode() * 31;
                        String str = this.name;
                        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.backgroundBlur)) * 31;
                        Size size = this.size;
                        return iHashCode2 + (size != null ? size.hashCode() : 0);
                    }

                    public String toString() {
                        return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Url implements Destination {
                    public static final int $stable = 8;
                    private final String componentInteractionValue;
                    private final ButtonComponent.UrlMethod method;
                    private final NonEmptyMap<LocaleId, String> urls;

                    public Url(NonEmptyMap<LocaleId, String> urls, ButtonComponent.UrlMethod method, String componentInteractionValue) {
                        Intrinsics.checkNotNullParameter(urls, "urls");
                        Intrinsics.checkNotNullParameter(method, "method");
                        Intrinsics.checkNotNullParameter(componentInteractionValue, "componentInteractionValue");
                        this.urls = urls;
                        this.method = method;
                        this.componentInteractionValue = componentInteractionValue;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Url copy$default(Url url, NonEmptyMap nonEmptyMap, ButtonComponent.UrlMethod urlMethod, String str, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            nonEmptyMap = url.urls;
                        }
                        if ((i3 & 2) != 0) {
                            urlMethod = url.method;
                        }
                        if ((i3 & 4) != 0) {
                            str = url.componentInteractionValue;
                        }
                        return url.copy(nonEmptyMap, urlMethod, str);
                    }

                    public final NonEmptyMap<LocaleId, String> component1() {
                        return this.urls;
                    }

                    public final ButtonComponent.UrlMethod component2() {
                        return this.method;
                    }

                    public final String component3() {
                        return this.componentInteractionValue;
                    }

                    public final Url copy(NonEmptyMap<LocaleId, String> urls, ButtonComponent.UrlMethod method, String componentInteractionValue) {
                        Intrinsics.checkNotNullParameter(urls, "urls");
                        Intrinsics.checkNotNullParameter(method, "method");
                        Intrinsics.checkNotNullParameter(componentInteractionValue, "componentInteractionValue");
                        return new Url(urls, method, componentInteractionValue);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Url)) {
                            return false;
                        }
                        Url url = (Url) obj;
                        return Intrinsics.areEqual(this.urls, url.urls) && this.method == url.method && Intrinsics.areEqual(this.componentInteractionValue, url.componentInteractionValue);
                    }

                    public final /* synthetic */ String getComponentInteractionValue() {
                        return this.componentInteractionValue;
                    }

                    public final /* synthetic */ ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    public final /* synthetic */ NonEmptyMap getUrls() {
                        return this.urls;
                    }

                    public int hashCode() {
                        return (((this.urls.hashCode() * 31) + this.method.hashCode()) * 31) + this.componentInteractionValue.hashCode();
                    }

                    public String toString() {
                        return "Url(urls=" + this.urls + ", method=" + this.method + ", componentInteractionValue=" + this.componentInteractionValue + ')';
                    }

                    public /* synthetic */ Url(NonEmptyMap nonEmptyMap, ButtonComponent.UrlMethod urlMethod, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                        this(nonEmptyMap, urlMethod, (i3 & 4) != 0 ? "navigate_to_url" : str);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PurchasePackage implements Action {
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

            @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle.Action
            public String getDescription() {
                return PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT;
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

    public ButtonComponentStyle(StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(action, "action");
        this.stackComponentStyle = stackComponentStyle;
        this.action = action;
        this.transition = paywallTransition;
        this.componentName = str;
        this.componentId = str2;
        this.visible = stackComponentStyle.getVisible();
        this.size = stackComponentStyle.getSize();
    }

    public static /* synthetic */ ButtonComponentStyle copy$default(ButtonComponentStyle buttonComponentStyle, StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            stackComponentStyle = buttonComponentStyle.stackComponentStyle;
        }
        if ((i3 & 2) != 0) {
            action = buttonComponentStyle.action;
        }
        if ((i3 & 4) != 0) {
            paywallTransition = buttonComponentStyle.transition;
        }
        if ((i3 & 8) != 0) {
            str = buttonComponentStyle.componentName;
        }
        if ((i3 & 16) != 0) {
            str2 = buttonComponentStyle.componentId;
        }
        String str3 = str2;
        PaywallTransition paywallTransition2 = paywallTransition;
        return buttonComponentStyle.copy(stackComponentStyle, action, paywallTransition2, str, str3);
    }

    public final StackComponentStyle component1() {
        return this.stackComponentStyle;
    }

    public final Action component2() {
        return this.action;
    }

    public final PaywallTransition component3() {
        return this.transition;
    }

    public final String component4() {
        return this.componentName;
    }

    public final String component5() {
        return this.componentId;
    }

    public final ButtonComponentStyle copy(StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ButtonComponentStyle(stackComponentStyle, action, paywallTransition, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponentStyle)) {
            return false;
        }
        ButtonComponentStyle buttonComponentStyle = (ButtonComponentStyle) obj;
        return Intrinsics.areEqual(this.stackComponentStyle, buttonComponentStyle.stackComponentStyle) && Intrinsics.areEqual(this.action, buttonComponentStyle.action) && Intrinsics.areEqual(this.transition, buttonComponentStyle.transition) && Intrinsics.areEqual(this.componentName, buttonComponentStyle.componentName) && Intrinsics.areEqual(this.componentId, buttonComponentStyle.componentId);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ String getComponentId() {
        return this.componentId;
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    public final /* synthetic */ PaywallTransition getTransition() {
        return this.transition;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((this.stackComponentStyle.hashCode() * 31) + this.action.hashCode()) * 31;
        PaywallTransition paywallTransition = this.transition;
        int iHashCode2 = (iHashCode + (paywallTransition == null ? 0 : paywallTransition.hashCode())) * 31;
        String str = this.componentName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.componentId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ButtonComponentStyle(stackComponentStyle=" + this.stackComponentStyle + ", action=" + this.action + ", transition=" + this.transition + ", componentName=" + this.componentName + ", componentId=" + this.componentId + ')';
    }

    public /* synthetic */ ButtonComponentStyle(StackComponentStyle stackComponentStyle, Action action, PaywallTransition paywallTransition, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponentStyle, action, (i3 & 4) != 0 ? null : paywallTransition, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2);
    }
}
