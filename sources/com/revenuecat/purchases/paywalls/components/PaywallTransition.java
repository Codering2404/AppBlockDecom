package com.revenuecat.purchases.paywalls.components;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class PaywallTransition {
    public static final Companion Companion = new Companion(null);
    private final PaywallAnimation animation;
    private final DisplacementStrategy displacementStrategy;
    private final TransitionType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallTransition> serializer() {
            return PaywallTransition$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = DisplacementStrategyDeserializer.class)
    public enum DisplacementStrategy {
        GREEDY,
        LAZY;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<DisplacementStrategy> serializer() {
                return DisplacementStrategyDeserializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = TransitionTypeSerializer.class)
    public enum TransitionType {
        FADE,
        FADE_AND_SCALE,
        SCALE,
        SLIDE;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<TransitionType> serializer() {
                return TransitionTypeSerializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ PaywallTransition(int i3, TransitionType transitionType, @SerialName DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i3 & 2)) {
            PluginExceptionsKt.b(i3, 2, PaywallTransition$$serializer.INSTANCE.getDescriptor());
        }
        this.type = (i3 & 1) == 0 ? TransitionType.FADE : transitionType;
        this.displacementStrategy = displacementStrategy;
        if ((i3 & 4) == 0) {
            this.animation = null;
        } else {
            this.animation = paywallAnimation;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallTransition paywallTransition, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || paywallTransition.type != TransitionType.FADE) {
            compositeEncoder.C(serialDescriptor, 0, TransitionTypeSerializer.INSTANCE, paywallTransition.type);
        }
        compositeEncoder.C(serialDescriptor, 1, DisplacementStrategyDeserializer.INSTANCE, paywallTransition.displacementStrategy);
        if (!compositeEncoder.z(serialDescriptor, 2) && paywallTransition.animation == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 2, PaywallAnimation$$serializer.INSTANCE, paywallTransition.animation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallTransition)) {
            return false;
        }
        PaywallTransition paywallTransition = (PaywallTransition) obj;
        return this.type == paywallTransition.type && this.displacementStrategy == paywallTransition.displacementStrategy && Intrinsics.areEqual(this.animation, paywallTransition.animation);
    }

    public final /* synthetic */ PaywallAnimation getAnimation() {
        return this.animation;
    }

    public final /* synthetic */ DisplacementStrategy getDisplacementStrategy() {
        return this.displacementStrategy;
    }

    public final /* synthetic */ TransitionType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.displacementStrategy.hashCode()) * 31;
        PaywallAnimation paywallAnimation = this.animation;
        return iHashCode + (paywallAnimation == null ? 0 : paywallAnimation.hashCode());
    }

    public String toString() {
        return "PaywallTransition(type=" + this.type + ", displacementStrategy=" + this.displacementStrategy + ", animation=" + this.animation + ')';
    }

    public PaywallTransition(TransitionType type, DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(displacementStrategy, "displacementStrategy");
        this.type = type;
        this.displacementStrategy = displacementStrategy;
        this.animation = paywallAnimation;
    }

    public /* synthetic */ PaywallTransition(TransitionType transitionType, DisplacementStrategy displacementStrategy, PaywallAnimation paywallAnimation, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TransitionType.FADE : transitionType, displacementStrategy, (i3 & 4) != 0 ? null : paywallAnimation);
    }

    @SerialName
    public static /* synthetic */ void getDisplacementStrategy$annotations() {
    }
}
