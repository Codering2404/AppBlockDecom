package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
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
@SerialName
@Metadata
@Serializable
public final class PaywallAnimation {
    public static final Companion Companion = new Companion(null);
    private final int msDelay;
    private final int msDuration;
    private final AnimationType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = AnimationTypeSerializer.class)
    public enum AnimationType {
        EASE_IN,
        EASE_OUT,
        EASE_IN_OUT,
        LINEAR;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AnimationType> serializer() {
                return AnimationTypeSerializer.INSTANCE;
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

        public final KSerializer<PaywallAnimation> serializer() {
            return PaywallAnimation$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallAnimation(int i3, AnimationType animationType, @SerialName int i4, @SerialName int i5, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, PaywallAnimation$$serializer.INSTANCE.getDescriptor());
        }
        this.type = animationType;
        this.msDelay = i4;
        this.msDuration = i5;
    }

    @SerialName
    public static /* synthetic */ void getMsDelay$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getMsDuration$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallAnimation paywallAnimation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, AnimationTypeSerializer.INSTANCE, paywallAnimation.type);
        compositeEncoder.w(serialDescriptor, 1, paywallAnimation.msDelay);
        compositeEncoder.w(serialDescriptor, 2, paywallAnimation.msDuration);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallAnimation)) {
            return false;
        }
        PaywallAnimation paywallAnimation = (PaywallAnimation) obj;
        return this.type == paywallAnimation.type && this.msDelay == paywallAnimation.msDelay && this.msDuration == paywallAnimation.msDuration;
    }

    public final /* synthetic */ int getMsDelay() {
        return this.msDelay;
    }

    public final /* synthetic */ int getMsDuration() {
        return this.msDuration;
    }

    public final /* synthetic */ AnimationType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.msDelay) * 31) + this.msDuration;
    }

    public PaywallAnimation(AnimationType type, int i3, int i4) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.msDelay = i3;
        this.msDuration = i4;
    }

    public String toString() {
        return "PaywallAnimation(type=" + this.type + jlWo.YYd + this.msDelay + ", msDuration=" + this.msDuration + ')';
    }
}
