package com.superwall.sdk.models.entitlements;

import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import java.lang.annotation.Annotation;
import java.util.Set;
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
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public abstract class SubscriptionStatus {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: e0.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SubscriptionStatus._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Active extends SubscriptionStatus {
        private final Set<Entitlement> entitlements;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new LinkedHashSetSerializer(Entitlement$$serializer.INSTANCE)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Active> serializer() {
                return SubscriptionStatus$Active$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Active(int i3, Set set, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, SubscriptionStatus$Active$$serializer.INSTANCE.getDescriptor());
            }
            this.entitlements = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Active copy$default(Active active, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = active.entitlements;
            }
            return active.copy(set);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Active active, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            SubscriptionStatus.write$Self(active, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], active.entitlements);
        }

        public final Set<Entitlement> component1() {
            return this.entitlements;
        }

        public final Active copy(Set<Entitlement> entitlements) {
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            return new Active(entitlements);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Active) && Intrinsics.areEqual(this.entitlements, ((Active) obj).entitlements);
        }

        public final Set<Entitlement> getEntitlements() {
            return this.entitlements;
        }

        public int hashCode() {
            return this.entitlements.hashCode();
        }

        public String toString() {
            return "Active(entitlements=" + this.entitlements + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Active(Set<Entitlement> entitlements) {
            super(null);
            Intrinsics.checkNotNullParameter(entitlements, "entitlements");
            this.entitlements = entitlements;
        }

        @SerialName
        public static /* synthetic */ void getEntitlements$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SubscriptionStatus.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SubscriptionStatus> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Inactive extends SubscriptionStatus {
        public static final Inactive INSTANCE = new Inactive();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: e0.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SubscriptionStatus.Inactive._init_$_anonymous_();
            }
        });

        private Inactive() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.superwall.sdk.models.entitlements.SubscriptionStatus.Inactive", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Inactive> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Unknown extends SubscriptionStatus {
        public static final Unknown INSTANCE = new Unknown();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: e0.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SubscriptionStatus.Unknown._init_$_anonymous_();
            }
        });

        private Unknown() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.superwall.sdk.models.entitlements.SubscriptionStatus.Unknown", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Unknown> serializer() {
            return get$cachedSerializer();
        }
    }

    public /* synthetic */ SubscriptionStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.entitlements.SubscriptionStatus", Reflection.b(SubscriptionStatus.class), new KClass[]{Reflection.b(Active.class), Reflection.b(Inactive.class), Reflection.b(Unknown.class)}, new KSerializer[]{SubscriptionStatus$Active$$serializer.INSTANCE, new ObjectSerializer("com.superwall.sdk.models.entitlements.SubscriptionStatus.Inactive", Inactive.INSTANCE, new Annotation[0]), new ObjectSerializer("com.superwall.sdk.models.entitlements.SubscriptionStatus.Unknown", Unknown.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    public final boolean isActive() {
        return this instanceof Active;
    }

    private SubscriptionStatus() {
    }

    public /* synthetic */ SubscriptionStatus(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(SubscriptionStatus subscriptionStatus, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
