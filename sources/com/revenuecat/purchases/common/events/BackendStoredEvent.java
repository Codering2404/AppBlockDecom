package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public abstract class BackendStoredEvent implements Event {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.events.BackendStoredEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendStoredEvent", Reflection.b(BackendStoredEvent.class), new KClass[]{Reflection.b(Ad.class), Reflection.b(CustomPaywall.class), Reflection.b(CustomerCenter.class), Reflection.b(Paywalls.class)}, new KSerializer[]{BackendStoredEvent$Ad$$serializer.INSTANCE, BackendStoredEvent$CustomPaywall$$serializer.INSTANCE, BackendStoredEvent$CustomerCenter$$serializer.INSTANCE, BackendStoredEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Ad extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.Ad event;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Ad> serializer() {
                return BackendStoredEvent$Ad$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Ad(int i3, BackendEvent.Ad ad, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, BackendStoredEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.event = ad;
        }

        public static /* synthetic */ Ad copy$default(Ad ad, BackendEvent.Ad ad2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                ad2 = ad.event;
            }
            return ad.copy(ad2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Ad ad, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendStoredEvent.write$Self(ad, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, BackendEvent$Ad$$serializer.INSTANCE, ad.event);
        }

        public final BackendEvent.Ad component1() {
            return this.event;
        }

        public final Ad copy(BackendEvent.Ad event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new Ad(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ad) && Intrinsics.areEqual(this.event, ((Ad) obj).event);
        }

        public final BackendEvent.Ad getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Ad(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(BackendEvent.Ad event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendStoredEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<BackendStoredEvent> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class CustomPaywall extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.CustomPaywall event;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomPaywall> serializer() {
                return BackendStoredEvent$CustomPaywall$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomPaywall(int i3, BackendEvent.CustomPaywall customPaywall, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, BackendStoredEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.event = customPaywall;
        }

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, BackendEvent.CustomPaywall customPaywall2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customPaywall2 = customPaywall.event;
            }
            return customPaywall.copy(customPaywall2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomPaywall customPaywall, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendStoredEvent.write$Self(customPaywall, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, BackendEvent$CustomPaywall$$serializer.INSTANCE, customPaywall.event);
        }

        public final BackendEvent.CustomPaywall component1() {
            return this.event;
        }

        public final CustomPaywall copy(BackendEvent.CustomPaywall event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new CustomPaywall(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomPaywall) && Intrinsics.areEqual(this.event, ((CustomPaywall) obj).event);
        }

        public final BackendEvent.CustomPaywall getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(BackendEvent.CustomPaywall event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class CustomerCenter extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.CustomerCenter event;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomerCenter> serializer() {
                return BackendStoredEvent$CustomerCenter$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomerCenter(int i3, BackendEvent.CustomerCenter customerCenter, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, BackendStoredEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.event = customerCenter;
        }

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, BackendEvent.CustomerCenter customerCenter2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customerCenter2 = customerCenter.event;
            }
            return customerCenter.copy(customerCenter2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenter customerCenter, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendStoredEvent.write$Self(customerCenter, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, BackendEvent$CustomerCenter$$serializer.INSTANCE, customerCenter.event);
        }

        public final BackendEvent.CustomerCenter component1() {
            return this.event;
        }

        public final CustomerCenter copy(BackendEvent.CustomerCenter event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new CustomerCenter(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomerCenter) && Intrinsics.areEqual(this.event, ((CustomerCenter) obj).event);
        }

        public final BackendEvent.CustomerCenter getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomerCenter(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(BackendEvent.CustomerCenter event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Paywalls extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.Paywalls event;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Paywalls> serializer() {
                return BackendStoredEvent$Paywalls$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Paywalls(int i3, BackendEvent.Paywalls paywalls, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, BackendStoredEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.event = paywalls;
        }

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, BackendEvent.Paywalls paywalls2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywalls2 = paywalls.event;
            }
            return paywalls.copy(paywalls2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Paywalls paywalls, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendStoredEvent.write$Self(paywalls, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, BackendEvent$Paywalls$$serializer.INSTANCE, paywalls.event);
        }

        public final BackendEvent.Paywalls component1() {
            return this.event;
        }

        public final Paywalls copy(BackendEvent.Paywalls event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new Paywalls(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paywalls) && Intrinsics.areEqual(this.event, ((Paywalls) obj).event);
        }

        public final BackendEvent.Paywalls getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Paywalls(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(BackendEvent.Paywalls event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }
    }

    public /* synthetic */ BackendStoredEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BackendStoredEvent() {
    }

    @Deprecated
    public /* synthetic */ BackendStoredEvent(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(BackendStoredEvent backendStoredEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
