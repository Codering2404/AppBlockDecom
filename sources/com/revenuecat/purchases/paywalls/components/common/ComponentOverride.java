package com.revenuecat.purchases.paywalls.components.common;

import com.facebook.share.HKJ.pnxuebdT;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

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
@Metadata
@Serializable
public final class ComponentOverride<T extends PartialComponent> {
    private static final SerialDescriptor $cachedDescriptor;
    private final List<Condition> conditions;
    private final T properties;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ConditionSerializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public enum ArrayOperator {
        IN,
        NOT_IN;

        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.ArrayOperator.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.ArrayOperator", ArrayOperator.values(), new String[]{"in", "not in"}, new Annotation[][]{null, null}, null);
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) ArrayOperator.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<ArrayOperator> serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T0> KSerializer<ComponentOverride<T0>> serializer(KSerializer<T0> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new ComponentOverride$$serializer(typeSerial0);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public enum EqualityOperator {
        EQUALS,
        NOT_EQUALS;

        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.EqualityOperator.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.EqualityOperator", EqualityOperator.values(), new String[]{"=", "!="}, new Annotation[][]{null, null}, null);
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) EqualityOperator.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<EqualityOperator> serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", null, 2);
        pluginGeneratedSerialDescriptor.p("conditions", false);
        pluginGeneratedSerialDescriptor.p(DiagnosticsEntry.PROPERTIES_KEY, false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public /* synthetic */ ComponentOverride(int i3, List list, PartialComponent partialComponent, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, $cachedDescriptor);
        }
        this.conditions = list;
        this.properties = partialComponent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ComponentOverride componentOverride, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], componentOverride.conditions);
        compositeEncoder.C(serialDescriptor, 1, kSerializer, componentOverride.properties);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComponentOverride)) {
            return false;
        }
        ComponentOverride componentOverride = (ComponentOverride) obj;
        return Intrinsics.areEqual(this.conditions, componentOverride.conditions) && Intrinsics.areEqual(this.properties, componentOverride.properties);
    }

    public final /* synthetic */ List getConditions() {
        return this.conditions;
    }

    public final /* synthetic */ PartialComponent getProperties() {
        return this.properties;
    }

    public int hashCode() {
        return (this.conditions.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "ComponentOverride(conditions=" + this.conditions + ", properties=" + this.properties + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentOverride(List<? extends Condition> conditions, T properties) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.conditions = conditions;
        this.properties = properties;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = ConditionSerializer.class)
    public interface Condition {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Compact implements Condition {
            public static final Compact INSTANCE = new Compact();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Compact.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Compact", Compact.INSTANCE, new Annotation[0]);
                }
            });

            private Compact() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Compact> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Condition> serializer() {
                return ConditionSerializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Expanded implements Condition {
            public static final Expanded INSTANCE = new Expanded();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Expanded.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Expanded", Expanded.INSTANCE, new Annotation[0]);
                }
            });

            private Expanded() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Expanded> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class IntroOffer implements Condition {
            public static final IntroOffer INSTANCE = new IntroOffer();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.IntroOffer.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.IntroOffer", IntroOffer.INSTANCE, new Annotation[0]);
                }
            });

            private IntroOffer() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<IntroOffer> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class IntroOfferRule implements Condition {
            private final EqualityOperator operator;
            private final boolean value;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {EqualityOperator.Companion.serializer(), null};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<IntroOfferRule> serializer() {
                    return ComponentOverride$Condition$IntroOfferRule$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ IntroOfferRule(int i3, EqualityOperator equalityOperator, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ComponentOverride$Condition$IntroOfferRule$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.value = z2;
            }

            public static /* synthetic */ IntroOfferRule copy$default(IntroOfferRule introOfferRule, EqualityOperator equalityOperator, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    equalityOperator = introOfferRule.operator;
                }
                if ((i3 & 2) != 0) {
                    z2 = introOfferRule.value;
                }
                return introOfferRule.copy(equalityOperator, z2);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(IntroOfferRule introOfferRule, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], introOfferRule.operator);
                compositeEncoder.x(serialDescriptor, 1, introOfferRule.value);
            }

            public final EqualityOperator component1() {
                return this.operator;
            }

            public final boolean component2() {
                return this.value;
            }

            public final IntroOfferRule copy(EqualityOperator operator, boolean z2) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                return new IntroOfferRule(operator, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof IntroOfferRule)) {
                    return false;
                }
                IntroOfferRule introOfferRule = (IntroOfferRule) obj;
                return this.operator == introOfferRule.operator && this.value == introOfferRule.value;
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final boolean getValue() {
                return this.value;
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + Boolean.hashCode(this.value);
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "IntroOfferRule(operator=" + this.operator + ", value=" + this.value + ')';
            }

            public IntroOfferRule(EqualityOperator operator, boolean z2) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                this.operator = operator;
                this.value = z2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Medium implements Condition {
            public static final Medium INSTANCE = new Medium();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Medium.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Medium", Medium.INSTANCE, new Annotation[0]);
                }
            });

            private Medium() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Medium> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class MultiplePhaseOffers implements Condition {
            public static final MultiplePhaseOffers INSTANCE = new MultiplePhaseOffers();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.MultiplePhaseOffers.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.MultiplePhaseOffers", MultiplePhaseOffers.INSTANCE, new Annotation[0]);
                }
            });

            private MultiplePhaseOffers() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<MultiplePhaseOffers> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PromoOffer implements Condition {
            public static final PromoOffer INSTANCE = new PromoOffer();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.PromoOffer.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.PromoOffer", PromoOffer.INSTANCE, new Annotation[0]);
                }
            });

            private PromoOffer() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<PromoOffer> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PromoOfferRule implements Condition {
            private final EqualityOperator operator;
            private final boolean value;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {EqualityOperator.Companion.serializer(), null};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<PromoOfferRule> serializer() {
                    return ComponentOverride$Condition$PromoOfferRule$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ PromoOfferRule(int i3, EqualityOperator equalityOperator, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ComponentOverride$Condition$PromoOfferRule$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.value = z2;
            }

            public static /* synthetic */ PromoOfferRule copy$default(PromoOfferRule promoOfferRule, EqualityOperator equalityOperator, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    equalityOperator = promoOfferRule.operator;
                }
                if ((i3 & 2) != 0) {
                    z2 = promoOfferRule.value;
                }
                return promoOfferRule.copy(equalityOperator, z2);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PromoOfferRule promoOfferRule, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], promoOfferRule.operator);
                compositeEncoder.x(serialDescriptor, 1, promoOfferRule.value);
            }

            public final EqualityOperator component1() {
                return this.operator;
            }

            public final boolean component2() {
                return this.value;
            }

            public final PromoOfferRule copy(EqualityOperator operator, boolean z2) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                return new PromoOfferRule(operator, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PromoOfferRule)) {
                    return false;
                }
                PromoOfferRule promoOfferRule = (PromoOfferRule) obj;
                return this.operator == promoOfferRule.operator && this.value == promoOfferRule.value;
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final boolean getValue() {
                return this.value;
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + Boolean.hashCode(this.value);
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "PromoOfferRule(operator=" + this.operator + ", value=" + this.value + ')';
            }

            public PromoOfferRule(EqualityOperator operator, boolean z2) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                this.operator = operator;
                this.value = z2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Selected implements Condition {
            public static final Selected INSTANCE = new Selected();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Selected.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Selected", Selected.INSTANCE, new Annotation[0]);
                }
            });

            private Selected() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Selected> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class SelectedPackage implements Condition {
            private final ArrayOperator operator;
            private final List<String> packages;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {ArrayOperator.Companion.serializer(), new ArrayListSerializer(StringSerializer.f142891a)};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<SelectedPackage> serializer() {
                    return ComponentOverride$Condition$SelectedPackage$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ SelectedPackage(int i3, ArrayOperator arrayOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, ComponentOverride$Condition$SelectedPackage$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = arrayOperator;
                this.packages = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectedPackage copy$default(SelectedPackage selectedPackage, ArrayOperator arrayOperator, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    arrayOperator = selectedPackage.operator;
                }
                if ((i3 & 2) != 0) {
                    list = selectedPackage.packages;
                }
                return selectedPackage.copy(arrayOperator, list);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SelectedPackage selectedPackage, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], selectedPackage.operator);
                compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], selectedPackage.packages);
            }

            public final ArrayOperator component1() {
                return this.operator;
            }

            public final List<String> component2() {
                return this.packages;
            }

            public final SelectedPackage copy(ArrayOperator operator, List<String> packages) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(packages, "packages");
                return new SelectedPackage(operator, packages);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SelectedPackage)) {
                    return false;
                }
                SelectedPackage selectedPackage = (SelectedPackage) obj;
                return this.operator == selectedPackage.operator && Intrinsics.areEqual(this.packages, selectedPackage.packages);
            }

            public final ArrayOperator getOperator() {
                return this.operator;
            }

            public final List<String> getPackages() {
                return this.packages;
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + this.packages.hashCode();
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "SelectedPackage(operator=" + this.operator + ", packages=" + this.packages + ')';
            }

            public SelectedPackage(ArrayOperator operator, List<String> packages) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(packages, "packages");
                this.operator = operator;
                this.packages = packages;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Unsupported implements Condition {
            public static final Unsupported INSTANCE = new Unsupported();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Unsupported.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Unsupported", Unsupported.INSTANCE, new Annotation[0]);
                }
            });

            private Unsupported() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Unsupported> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Variable implements Condition {
            private final EqualityOperator operator;
            private final JsonPrimitive value;
            private final String variable;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {EqualityOperator.Companion.serializer(), null, null};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Variable> serializer() {
                    return ComponentOverride$Condition$Variable$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Variable(int i3, EqualityOperator equalityOperator, String str, JsonPrimitive jsonPrimitive, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i3 & 7)) {
                    PluginExceptionsKt.b(i3, 7, ComponentOverride$Condition$Variable$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.variable = str;
                this.value = jsonPrimitive;
            }

            public static /* synthetic */ Variable copy$default(Variable variable, EqualityOperator equalityOperator, String str, JsonPrimitive jsonPrimitive, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    equalityOperator = variable.operator;
                }
                if ((i3 & 2) != 0) {
                    str = variable.variable;
                }
                if ((i3 & 4) != 0) {
                    jsonPrimitive = variable.value;
                }
                return variable.copy(equalityOperator, str, jsonPrimitive);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Variable variable, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], variable.operator);
                compositeEncoder.y(serialDescriptor, 1, variable.variable);
                compositeEncoder.C(serialDescriptor, 2, JsonPrimitiveSerializer.f143032a, variable.value);
            }

            public final EqualityOperator component1() {
                return this.operator;
            }

            public final String component2() {
                return this.variable;
            }

            public final JsonPrimitive component3() {
                return this.value;
            }

            public final Variable copy(EqualityOperator operator, String variable, JsonPrimitive value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(variable, "variable");
                Intrinsics.checkNotNullParameter(value, "value");
                return new Variable(operator, variable, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Variable)) {
                    return false;
                }
                Variable variable = (Variable) obj;
                return this.operator == variable.operator && Intrinsics.areEqual(this.variable, variable.variable) && Intrinsics.areEqual(this.value, variable.value);
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final JsonPrimitive getValue() {
                return this.value;
            }

            public final String getVariable() {
                return this.variable;
            }

            public int hashCode() {
                return (((this.operator.hashCode() * 31) + this.variable.hashCode()) * 31) + this.value.hashCode();
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "Variable(operator=" + this.operator + ", variable=" + this.variable + ", value=" + this.value + ')';
            }

            public Variable(EqualityOperator operator, String str, JsonPrimitive value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(str, pnxuebdT.UeszfgVMCyNOdOJ);
                Intrinsics.checkNotNullParameter(value, "value");
                this.operator = operator;
                this.variable = str;
                this.value = value;
            }
        }

        default boolean isRule() {
            return false;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            @Deprecated
            public static boolean isRule(Condition condition) {
                return Condition.super.isRule();
            }

            public static /* synthetic */ void isRule$annotations() {
            }
        }
    }
}
