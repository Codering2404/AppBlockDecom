package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
/* JADX INFO: loaded from: classes6.dex */
@SerialName
@Metadata
@Serializable
public final class PurchaseButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final Method method;
    private final String name;
    private final StackComponent stack;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = ActionDeserializer.class)
    public enum Action {
        IN_APP_CHECKOUT,
        WEB_CHECKOUT,
        WEB_PRODUCT_SELECTION;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Action> serializer() {
                return ActionDeserializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Action.values().length];
                try {
                    iArr[Action.IN_APP_CHECKOUT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Action.WEB_CHECKOUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Action.WEB_PRODUCT_SELECTION.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Method toMethod() {
            int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i3 == 1) {
                return Method.InAppCheckout.INSTANCE;
            }
            int i4 = 3;
            Boolean bool = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            if (i3 == 2) {
                return new Method.WebCheckout((Boolean) (objArr3 == true ? 1 : 0), (ButtonComponent.UrlMethod) (objArr2 == true ? 1 : 0), i4, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
            }
            if (i3 == 3) {
                return new Method.WebProductSelection(bool, (ButtonComponent.UrlMethod) (objArr5 == true ? 1 : 0), i4, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PurchaseButtonComponent> serializer() {
            return PurchaseButtonComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class CustomUrl {
        public static final Companion Companion = new Companion(null);
        private final String packageParam;
        private final String urlLid;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomUrl> serializer() {
                return PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ CustomUrl(int i3, @SerialName String str, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, str2, serializationConstructorMarker);
        }

        /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
        public static /* synthetic */ CustomUrl m600copy26kQY28$default(CustomUrl customUrl, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = customUrl.urlLid;
            }
            if ((i3 & 2) != 0) {
                str2 = customUrl.packageParam;
            }
            return customUrl.m603copy26kQY28(str, str2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomUrl customUrl, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(customUrl.urlLid));
            if (!compositeEncoder.z(serialDescriptor, 1) && customUrl.packageParam == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, customUrl.packageParam);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
        public final String m602component1z7Tp4o() {
            return this.urlLid;
        }

        public final String component2() {
            return this.packageParam;
        }

        /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
        public final CustomUrl m603copy26kQY28(String urlLid, String str) {
            Intrinsics.checkNotNullParameter(urlLid, "urlLid");
            return new CustomUrl(urlLid, str, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomUrl)) {
                return false;
            }
            CustomUrl customUrl = (CustomUrl) obj;
            return LocalizationKey.m651equalsimpl0(this.urlLid, customUrl.urlLid) && Intrinsics.areEqual(this.packageParam, customUrl.packageParam);
        }

        public final String getPackageParam() {
            return this.packageParam;
        }

        /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
        public final String m604getUrlLidz7Tp4o() {
            return this.urlLid;
        }

        public int hashCode() {
            int iM652hashCodeimpl = LocalizationKey.m652hashCodeimpl(this.urlLid) * 31;
            String str = this.packageParam;
            return iM652hashCodeimpl + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomUrl(urlLid=" + ((Object) LocalizationKey.m653toStringimpl(this.urlLid)) + ", packageParam=" + this.packageParam + ')';
        }

        public /* synthetic */ CustomUrl(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private CustomUrl(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE.getDescriptor());
            }
            this.urlLid = str;
            if ((i3 & 2) == 0) {
                this.packageParam = null;
            } else {
                this.packageParam = str2;
            }
        }

        private CustomUrl(String urlLid, String str) {
            Intrinsics.checkNotNullParameter(urlLid, "urlLid");
            this.urlLid = urlLid;
            this.packageParam = str;
        }

        public /* synthetic */ CustomUrl(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, null);
        }

        @SerialName
        public static /* synthetic */ void getPackageParam$annotations() {
        }

        @SerialName
        /* JADX INFO: renamed from: getUrlLid-z7Tp-4o$annotations, reason: not valid java name */
        public static /* synthetic */ void m601getUrlLidz7Tp4o$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = PurchaseButtonMethodDeserializer.class)
    public interface Method {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Method> serializer() {
                return PurchaseButtonMethodDeserializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class CustomWebCheckout implements Method {
            public static final Companion Companion = new Companion(null);
            private final Boolean autoDismiss;
            private final CustomUrl customUrl;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<CustomWebCheckout> serializer() {
                    return PurchaseButtonComponent$Method$CustomWebCheckout$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ CustomWebCheckout(int i3, @SerialName CustomUrl customUrl, @SerialName Boolean bool, @SerialName ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, PurchaseButtonComponent$Method$CustomWebCheckout$$serializer.INSTANCE.getDescriptor());
                }
                this.customUrl = customUrl;
                if ((i3 & 2) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i3 & 4) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public static /* synthetic */ CustomWebCheckout copy$default(CustomWebCheckout customWebCheckout, CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    customUrl = customWebCheckout.customUrl;
                }
                if ((i3 & 2) != 0) {
                    bool = customWebCheckout.autoDismiss;
                }
                if ((i3 & 4) != 0) {
                    urlMethod = customWebCheckout.openMethod;
                }
                return customWebCheckout.copy(customUrl, bool, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomWebCheckout customWebCheckout, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE, customWebCheckout.customUrl);
                if (compositeEncoder.z(serialDescriptor, 1) || customWebCheckout.autoDismiss != null) {
                    compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, customWebCheckout.autoDismiss);
                }
                if (!compositeEncoder.z(serialDescriptor, 2) && customWebCheckout.openMethod == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 2, UrlMethodDeserializer.INSTANCE, customWebCheckout.openMethod);
            }

            public final CustomUrl component1() {
                return this.customUrl;
            }

            public final Boolean component2() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component3() {
                return this.openMethod;
            }

            public final CustomWebCheckout copy(CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                Intrinsics.checkNotNullParameter(customUrl, "customUrl");
                return new CustomWebCheckout(customUrl, bool, urlMethod);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CustomWebCheckout)) {
                    return false;
                }
                CustomWebCheckout customWebCheckout = (CustomWebCheckout) obj;
                return Intrinsics.areEqual(this.customUrl, customWebCheckout.customUrl) && Intrinsics.areEqual(this.autoDismiss, customWebCheckout.autoDismiss) && this.openMethod == customWebCheckout.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ CustomUrl getCustomUrl() {
                return this.customUrl;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                int iHashCode = this.customUrl.hashCode() * 31;
                Boolean bool = this.autoDismiss;
                int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode2 + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "CustomWebCheckout(customUrl=" + this.customUrl + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }

            public CustomWebCheckout(CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                Intrinsics.checkNotNullParameter(customUrl, "customUrl");
                this.customUrl = customUrl;
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ CustomWebCheckout(CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(customUrl, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : urlMethod);
            }

            @SerialName
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getCustomUrl$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOpenMethod$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class InAppCheckout implements Method {
            public static final InAppCheckout INSTANCE = new InAppCheckout();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.InAppCheckout.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.InAppCheckout", InAppCheckout.INSTANCE, new Annotation[0]);
                }
            });

            private InAppCheckout() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<InAppCheckout> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Unknown implements Method {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            });

            private Unknown() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Unknown> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class WebCheckout implements Method {
            public static final Companion Companion = new Companion(null);
            private final Boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<WebCheckout> serializer() {
                    return PurchaseButtonComponent$Method$WebCheckout$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public WebCheckout() {
                this((Boolean) null, (ButtonComponent.UrlMethod) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            public static /* synthetic */ WebCheckout copy$default(WebCheckout webCheckout, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    bool = webCheckout.autoDismiss;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = webCheckout.openMethod;
                }
                return webCheckout.copy(bool, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebCheckout webCheckout, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                if (compositeEncoder.z(serialDescriptor, 0) || webCheckout.autoDismiss != null) {
                    compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, webCheckout.autoDismiss);
                }
                if (!compositeEncoder.z(serialDescriptor, 1) && webCheckout.openMethod == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, webCheckout.openMethod);
            }

            public final Boolean component1() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component2() {
                return this.openMethod;
            }

            public final WebCheckout copy(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                return new WebCheckout(bool, urlMethod);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WebCheckout)) {
                    return false;
                }
                WebCheckout webCheckout = (WebCheckout) obj;
                return Intrinsics.areEqual(this.autoDismiss, webCheckout.autoDismiss) && this.openMethod == webCheckout.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                Boolean bool = this.autoDismiss;
                int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "WebCheckout(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }

            @Deprecated
            public /* synthetic */ WebCheckout(int i3, @SerialName Boolean bool, @SerialName ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i3 & 1) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i3 & 2) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public WebCheckout(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ WebCheckout(Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : urlMethod);
            }

            @SerialName
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOpenMethod$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class WebProductSelection implements Method {
            public static final Companion Companion = new Companion(null);
            private final Boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<WebProductSelection> serializer() {
                    return PurchaseButtonComponent$Method$WebProductSelection$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public WebProductSelection() {
                this((Boolean) null, (ButtonComponent.UrlMethod) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            public static /* synthetic */ WebProductSelection copy$default(WebProductSelection webProductSelection, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    bool = webProductSelection.autoDismiss;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = webProductSelection.openMethod;
                }
                return webProductSelection.copy(bool, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebProductSelection webProductSelection, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                if (compositeEncoder.z(serialDescriptor, 0) || webProductSelection.autoDismiss != null) {
                    compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, webProductSelection.autoDismiss);
                }
                if (!compositeEncoder.z(serialDescriptor, 1) && webProductSelection.openMethod == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, webProductSelection.openMethod);
            }

            public final Boolean component1() {
                return this.autoDismiss;
            }

            public final ButtonComponent.UrlMethod component2() {
                return this.openMethod;
            }

            public final WebProductSelection copy(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                return new WebProductSelection(bool, urlMethod);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WebProductSelection)) {
                    return false;
                }
                WebProductSelection webProductSelection = (WebProductSelection) obj;
                return Intrinsics.areEqual(this.autoDismiss, webProductSelection.autoDismiss) && this.openMethod == webProductSelection.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                Boolean bool = this.autoDismiss;
                int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "WebProductSelection(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }

            @Deprecated
            public /* synthetic */ WebProductSelection(int i3, @SerialName Boolean bool, @SerialName ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i3 & 1) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i3 & 2) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public WebProductSelection(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ WebProductSelection(Boolean bool, ButtonComponent.UrlMethod urlMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : urlMethod);
            }

            @SerialName
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOpenMethod$annotations() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ PurchaseButtonComponent(int i3, StackComponent stackComponent, Action action, Method method, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, PurchaseButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        if ((i3 & 2) == 0) {
            this.action = null;
        } else {
            this.action = action;
        }
        if ((i3 & 4) == 0) {
            this.method = null;
        } else {
            this.method = method;
        }
        if ((i3 & 8) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PurchaseButtonComponent purchaseButtonComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, StackComponent$$serializer.INSTANCE, purchaseButtonComponent.stack);
        if (compositeEncoder.z(serialDescriptor, 1) || purchaseButtonComponent.action != null) {
            compositeEncoder.i(serialDescriptor, 1, ActionDeserializer.INSTANCE, purchaseButtonComponent.action);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || purchaseButtonComponent.method != null) {
            compositeEncoder.i(serialDescriptor, 2, PurchaseButtonMethodDeserializer.INSTANCE, purchaseButtonComponent.method);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && purchaseButtonComponent.name == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, purchaseButtonComponent.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseButtonComponent)) {
            return false;
        }
        PurchaseButtonComponent purchaseButtonComponent = (PurchaseButtonComponent) obj;
        return Intrinsics.areEqual(this.stack, purchaseButtonComponent.stack) && this.action == purchaseButtonComponent.action && Intrinsics.areEqual(this.method, purchaseButtonComponent.method) && Intrinsics.areEqual(this.name, purchaseButtonComponent.name);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ Method getMethod() {
        return this.method;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        int iHashCode = this.stack.hashCode() * 31;
        Action action = this.action;
        int iHashCode2 = (iHashCode + (action == null ? 0 : action.hashCode())) * 31;
        Method method = this.method;
        int iHashCode3 = (iHashCode2 + (method == null ? 0 : method.hashCode())) * 31;
        String str = this.name;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PurchaseButtonComponent(stack=" + this.stack + ", action=" + this.action + ", method=" + this.method + ", name=" + this.name + ')';
    }

    public PurchaseButtonComponent(StackComponent stack, Action action, Method method, String str) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.stack = stack;
        this.action = action;
        this.method = method;
        this.name = str;
    }

    public /* synthetic */ PurchaseButtonComponent(StackComponent stackComponent, Action action, Method method, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponent, (i3 & 2) != 0 ? null : action, (i3 & 4) != 0 ? null : method, (i3 & 8) != 0 ? null : str);
    }
}
