package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class ButtonComponent implements PaywallComponent {
    public static final Companion Companion = new Companion(null);
    private final Action action;
    private final String id;
    private final String name;
    private final StackComponent stack;
    private final PaywallTransition transition;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = ActionSerializer.class)
    public interface Action {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Action> serializer() {
                return ActionSerializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NavigateBack implements Action {
            public static final NavigateBack INSTANCE = new NavigateBack();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack", NavigateBack.INSTANCE, new Annotation[0]);
                }
            });

            private NavigateBack() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<NavigateBack> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NavigateTo implements Action {
            private final Destination destination;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", Reflection.b(Destination.class), new KClass[]{Reflection.b(Destination.CustomerCenter.class), Reflection.b(Destination.PrivacyPolicy.class), Reflection.b(Destination.Sheet.class), Reflection.b(Destination.Terms.class), Reflection.b(Destination.Unknown.class), Reflection.b(Destination.Url.class)}, new KSerializer[]{new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", Destination.CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Destination.Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0])};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<NavigateTo> serializer() {
                    return ButtonComponent$Action$NavigateTo$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ NavigateTo(int i3, Destination destination, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, ButtonComponent$Action$NavigateTo$$serializer.INSTANCE.getDescriptor());
                }
                this.destination = destination;
            }

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Destination destination, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    destination = navigateTo.destination;
                }
                return navigateTo.copy(destination);
            }

            public final Destination component1() {
                return this.destination;
            }

            public final NavigateTo copy(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                return new NavigateTo(destination);
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

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class RestorePurchases implements Action {
            public static final RestorePurchases INSTANCE = new RestorePurchases();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases", RestorePurchases.INSTANCE, new Annotation[0]);
                }
            });

            private RestorePurchases() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<RestorePurchases> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Unknown implements Action {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown", Unknown.INSTANCE, new Annotation[0]);
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
        public static final class WorkflowTrigger implements Action {
            public static final WorkflowTrigger INSTANCE = new WorkflowTrigger();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.WorkflowTrigger.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.WorkflowTrigger", WorkflowTrigger.INSTANCE, new Annotation[0]);
                }
            });

            private WorkflowTrigger() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<WorkflowTrigger> serializer() {
                return get$cachedSerializer();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ButtonComponent> serializer() {
            return ButtonComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public interface Destination {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Destination> serializer() {
                return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", Reflection.b(Destination.class), new KClass[]{Reflection.b(CustomerCenter.class), Reflection.b(PrivacyPolicy.class), Reflection.b(Sheet.class), Reflection.b(Terms.class), Reflection.b(Unknown.class), Reflection.b(Url.class)}, new KSerializer[]{new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class CustomerCenter implements Destination {
            public static final CustomerCenter INSTANCE = new CustomerCenter();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]);
                }
            });

            private CustomerCenter() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<CustomerCenter> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PrivacyPolicy implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<PrivacyPolicy> serializer() {
                    return ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ PrivacyPolicy(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, str, urlMethod, serializationConstructorMarker);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ PrivacyPolicy m574copy26kQY28$default(PrivacyPolicy privacyPolicy, String str, UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = privacyPolicy.urlLid;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = privacyPolicy.method;
                }
                return privacyPolicy.m576copy26kQY28(str, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PrivacyPolicy privacyPolicy, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(privacyPolicy.urlLid));
                compositeEncoder.C(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, privacyPolicy.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m575component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final PrivacyPolicy m576copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new PrivacyPolicy(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PrivacyPolicy)) {
                    return false;
                }
                PrivacyPolicy privacyPolicy = (PrivacyPolicy) obj;
                return LocalizationKey.m651equalsimpl0(this.urlLid, privacyPolicy.urlLid) && this.method == privacyPolicy.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m577getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m652hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "PrivacyPolicy(urlLid=" + ((Object) LocalizationKey.m653toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ PrivacyPolicy(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            private PrivacyPolicy(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private PrivacyPolicy(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Sheet implements Destination {
            public static final Companion Companion = new Companion(null);
            private final boolean backgroundBlur;
            private final String id;
            private final String name;
            private final Size size;
            private final StackComponent stack;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Sheet> serializer() {
                    return ButtonComponent$Destination$Sheet$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Sheet(int i3, String str, String str2, StackComponent stackComponent, @SerialName boolean z2, Size size, SerializationConstructorMarker serializationConstructorMarker) {
                if (31 != (i3 & 31)) {
                    PluginExceptionsKt.b(i3, 31, ButtonComponent$Destination$Sheet$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.stack = stackComponent;
                this.backgroundBlur = z2;
                this.size = size;
            }

            public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, StackComponent stackComponent, boolean z2, Size size, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = sheet.id;
                }
                if ((i3 & 2) != 0) {
                    str2 = sheet.name;
                }
                if ((i3 & 4) != 0) {
                    stackComponent = sheet.stack;
                }
                if ((i3 & 8) != 0) {
                    z2 = sheet.backgroundBlur;
                }
                if ((i3 & 16) != 0) {
                    size = sheet.size;
                }
                Size size2 = size;
                StackComponent stackComponent2 = stackComponent;
                return sheet.copy(str, str2, stackComponent2, z2, size2);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Sheet sheet, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.y(serialDescriptor, 0, sheet.id);
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, sheet.name);
                compositeEncoder.C(serialDescriptor, 2, StackComponent$$serializer.INSTANCE, sheet.stack);
                compositeEncoder.x(serialDescriptor, 3, sheet.backgroundBlur);
                compositeEncoder.i(serialDescriptor, 4, Size$$serializer.INSTANCE, sheet.size);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.name;
            }

            public final StackComponent component3() {
                return this.stack;
            }

            public final boolean component4() {
                return this.backgroundBlur;
            }

            public final Size component5() {
                return this.size;
            }

            public final Sheet copy(String id, String str, StackComponent stack, boolean z2, Size size) {
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

            public final /* synthetic */ StackComponent getStack() {
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

            public Sheet(String id, String str, StackComponent stack, boolean z2, Size size) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(stack, "stack");
                this.id = id;
                this.name = str;
                this.stack = stack;
                this.backgroundBlur = z2;
                this.size = size;
            }

            @SerialName
            public static /* synthetic */ void getBackgroundBlur$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Terms implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Terms> serializer() {
                    return ButtonComponent$Destination$Terms$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Terms(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, str, urlMethod, serializationConstructorMarker);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Terms m578copy26kQY28$default(Terms terms, String str, UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = terms.urlLid;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = terms.method;
                }
                return terms.m580copy26kQY28(str, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Terms terms, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(terms.urlLid));
                compositeEncoder.C(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, terms.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m579component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Terms m580copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new Terms(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Terms)) {
                    return false;
                }
                Terms terms = (Terms) obj;
                return LocalizationKey.m651equalsimpl0(this.urlLid, terms.urlLid) && this.method == terms.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m581getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m652hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Terms(urlLid=" + ((Object) LocalizationKey.m653toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Terms(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            private Terms(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ButtonComponent$Destination$Terms$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Terms(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Unknown implements Destination {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]);
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
        public static final class Url implements Destination {
            public static final Companion Companion = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Url> serializer() {
                    return ButtonComponent$Destination$Url$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Url(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, str, urlMethod, serializationConstructorMarker);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Url m582copy26kQY28$default(Url url, String str, UrlMethod urlMethod, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = url.urlLid;
                }
                if ((i3 & 2) != 0) {
                    urlMethod = url.method;
                }
                return url.m584copy26kQY28(str, urlMethod);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Url url, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m648boximpl(url.urlLid));
                compositeEncoder.C(serialDescriptor, 1, UrlMethodDeserializer.INSTANCE, url.method);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name */
            public final String m583component1z7Tp4o() {
                return this.urlLid;
            }

            public final UrlMethod component2() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Url m584copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new Url(urlLid, method, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Url)) {
                    return false;
                }
                Url url = (Url) obj;
                return LocalizationKey.m651equalsimpl0(this.urlLid, url.urlLid) && this.method == url.method;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m585getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public int hashCode() {
                return (LocalizationKey.m652hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Url(urlLid=" + ((Object) LocalizationKey.m653toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            public /* synthetic */ Url(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            private Url(int i3, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ButtonComponent$Destination$Url$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Url(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = UrlMethodDeserializer.class)
    public enum UrlMethod {
        IN_APP_BROWSER,
        EXTERNAL_BROWSER,
        DEEP_LINK,
        UNKNOWN;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<UrlMethod> serializer() {
                return UrlMethodDeserializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ ButtonComponent(int i3, Action action, StackComponent stackComponent, PaywallTransition paywallTransition, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, ButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.stack = stackComponent;
        if ((i3 & 4) == 0) {
            this.transition = null;
        } else {
            this.transition = paywallTransition;
        }
        if ((i3 & 8) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i3 & 16) == 0) {
            this.id = null;
        } else {
            this.id = str2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ButtonComponent buttonComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, ActionSerializer.INSTANCE, buttonComponent.action);
        compositeEncoder.C(serialDescriptor, 1, StackComponent$$serializer.INSTANCE, buttonComponent.stack);
        if (compositeEncoder.z(serialDescriptor, 2) || buttonComponent.transition != null) {
            compositeEncoder.i(serialDescriptor, 2, PaywallTransition$$serializer.INSTANCE, buttonComponent.transition);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || buttonComponent.name != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, buttonComponent.name);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && buttonComponent.id == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, buttonComponent.id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) obj;
        return Intrinsics.areEqual(this.action, buttonComponent.action) && Intrinsics.areEqual(this.stack, buttonComponent.stack) && Intrinsics.areEqual(this.transition, buttonComponent.transition) && Intrinsics.areEqual(this.name, buttonComponent.name) && Intrinsics.areEqual(this.id, buttonComponent.id);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ String getId() {
        return this.id;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ PaywallTransition getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int iHashCode = ((this.action.hashCode() * 31) + this.stack.hashCode()) * 31;
        PaywallTransition paywallTransition = this.transition;
        int iHashCode2 = (iHashCode + (paywallTransition == null ? 0 : paywallTransition.hashCode())) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ButtonComponent(action=" + this.action + ", stack=" + this.stack + ", transition=" + this.transition + ", name=" + this.name + ", id=" + this.id + ')';
    }

    public ButtonComponent(Action action, StackComponent stack, PaywallTransition paywallTransition, String str, String str2) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.action = action;
        this.stack = stack;
        this.transition = paywallTransition;
        this.name = str;
        this.id = str2;
    }

    public /* synthetic */ ButtonComponent(Action action, StackComponent stackComponent, PaywallTransition paywallTransition, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(action, stackComponent, (i3 & 4) != 0 ? null : paywallTransition, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2);
    }
}
