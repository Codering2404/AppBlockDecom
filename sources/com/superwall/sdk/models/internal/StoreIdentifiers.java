package com.superwall.sdk.models.internal;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.internal.StoreIdentifiers;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

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
@JsonClassDiscriminator(discriminator = ProductResponseJsonKeys.STORE)
@Metadata
@Serializable
public abstract class StoreIdentifiers {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: f0.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StoreIdentifiers._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) StoreIdentifiers.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<StoreIdentifiers> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Paddle extends StoreIdentifiers {
        private final String paddleCustomerId;
        private final List<String> paddleSubscriptionIds;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.f142891a)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Paddle> serializer() {
                return StoreIdentifiers$Paddle$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Paddle(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, StoreIdentifiers$Paddle$$serializer.INSTANCE.getDescriptor());
            }
            this.paddleCustomerId = str;
            this.paddleSubscriptionIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Paddle copy$default(Paddle paddle, String str, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paddle.paddleCustomerId;
            }
            if ((i3 & 2) != 0) {
                list = paddle.paddleSubscriptionIds;
            }
            return paddle.copy(str, list);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Paddle paddle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            StoreIdentifiers.write$Self(paddle, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, paddle.paddleCustomerId);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], paddle.paddleSubscriptionIds);
        }

        public final String component1() {
            return this.paddleCustomerId;
        }

        public final List<String> component2() {
            return this.paddleSubscriptionIds;
        }

        public final Paddle copy(String paddleCustomerId, List<String> paddleSubscriptionIds) {
            Intrinsics.checkNotNullParameter(paddleCustomerId, "paddleCustomerId");
            Intrinsics.checkNotNullParameter(paddleSubscriptionIds, "paddleSubscriptionIds");
            return new Paddle(paddleCustomerId, paddleSubscriptionIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Paddle)) {
                return false;
            }
            Paddle paddle = (Paddle) obj;
            return Intrinsics.areEqual(this.paddleCustomerId, paddle.paddleCustomerId) && Intrinsics.areEqual(this.paddleSubscriptionIds, paddle.paddleSubscriptionIds);
        }

        public final String getPaddleCustomerId() {
            return this.paddleCustomerId;
        }

        public final List<String> getPaddleSubscriptionIds() {
            return this.paddleSubscriptionIds;
        }

        public int hashCode() {
            return (this.paddleCustomerId.hashCode() * 31) + this.paddleSubscriptionIds.hashCode();
        }

        public String toString() {
            return "Paddle(paddleCustomerId=" + this.paddleCustomerId + ", paddleSubscriptionIds=" + this.paddleSubscriptionIds + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paddle(String paddleCustomerId, List<String> paddleSubscriptionIds) {
            super(null);
            Intrinsics.checkNotNullParameter(paddleCustomerId, "paddleCustomerId");
            Intrinsics.checkNotNullParameter(paddleSubscriptionIds, "paddleSubscriptionIds");
            this.paddleCustomerId = paddleCustomerId;
            this.paddleSubscriptionIds = paddleSubscriptionIds;
        }

        @SerialName
        public static /* synthetic */ void getPaddleCustomerId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaddleSubscriptionIds$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Stripe extends StoreIdentifiers {
        private final String stripeCustomerId;
        private final List<String> subscriptionIds;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.f142891a)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Stripe> serializer() {
                return StoreIdentifiers$Stripe$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Stripe(int i3, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, StoreIdentifiers$Stripe$$serializer.INSTANCE.getDescriptor());
            }
            this.stripeCustomerId = str;
            this.subscriptionIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Stripe copy$default(Stripe stripe, String str, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stripe.stripeCustomerId;
            }
            if ((i3 & 2) != 0) {
                list = stripe.subscriptionIds;
            }
            return stripe.copy(str, list);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Stripe stripe, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            StoreIdentifiers.write$Self(stripe, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, stripe.stripeCustomerId);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], stripe.subscriptionIds);
        }

        public final String component1() {
            return this.stripeCustomerId;
        }

        public final List<String> component2() {
            return this.subscriptionIds;
        }

        public final Stripe copy(String stripeCustomerId, List<String> subscriptionIds) {
            Intrinsics.checkNotNullParameter(stripeCustomerId, "stripeCustomerId");
            Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
            return new Stripe(stripeCustomerId, subscriptionIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Stripe)) {
                return false;
            }
            Stripe stripe = (Stripe) obj;
            return Intrinsics.areEqual(this.stripeCustomerId, stripe.stripeCustomerId) && Intrinsics.areEqual(this.subscriptionIds, stripe.subscriptionIds);
        }

        public final String getStripeCustomerId() {
            return this.stripeCustomerId;
        }

        public final List<String> getSubscriptionIds() {
            return this.subscriptionIds;
        }

        public int hashCode() {
            return (this.stripeCustomerId.hashCode() * 31) + this.subscriptionIds.hashCode();
        }

        public String toString() {
            return "Stripe(stripeCustomerId=" + this.stripeCustomerId + ", subscriptionIds=" + this.subscriptionIds + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Stripe(String stripeCustomerId, List<String> subscriptionIds) {
            super(null);
            Intrinsics.checkNotNullParameter(stripeCustomerId, "stripeCustomerId");
            Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
            this.stripeCustomerId = stripeCustomerId;
            this.subscriptionIds = subscriptionIds;
        }

        @SerialName
        public static /* synthetic */ void getStripeCustomerId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getSubscriptionIds$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Unknown extends StoreIdentifiers {
        private final Map<String, JsonElement> properties;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.f142891a, BuiltinSerializersKt.u(JsonElementSerializer.f143009a))};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Unknown> serializer() {
                return StoreIdentifiers$Unknown$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(int i3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, StoreIdentifiers$Unknown$$serializer.INSTANCE.getDescriptor());
            }
            this.properties = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Unknown copy$default(Unknown unknown, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = unknown.properties;
            }
            return unknown.copy(map);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Unknown unknown, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            StoreIdentifiers.write$Self(unknown, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], unknown.properties);
        }

        public final Map<String, JsonElement> component1() {
            return this.properties;
        }

        public final Unknown copy(Map<String, ? extends JsonElement> properties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            return new Unknown(properties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unknown) && Intrinsics.areEqual(this.properties, ((Unknown) obj).properties);
        }

        public final Map<String, JsonElement> getProperties() {
            return this.properties;
        }

        public int hashCode() {
            return this.properties.hashCode();
        }

        public String toString() {
            return "Unknown(properties=" + this.properties + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Unknown(Map<String, ? extends JsonElement> properties) {
            super(null);
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.properties = properties;
        }
    }

    public /* synthetic */ StoreIdentifiers(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.internal.StoreIdentifiers", Reflection.b(StoreIdentifiers.class), new KClass[]{Reflection.b(Paddle.class), Reflection.b(Stripe.class), Reflection.b(Unknown.class)}, new KSerializer[]{StoreIdentifiers$Paddle$$serializer.INSTANCE, StoreIdentifiers$Stripe$$serializer.INSTANCE, StoreIdentifiers$Unknown$$serializer.INSTANCE}, new Annotation[]{new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(ProductResponseJsonKeys.STORE)});
    }

    private StoreIdentifiers() {
    }

    public /* synthetic */ StoreIdentifiers(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(StoreIdentifiers storeIdentifiers, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
