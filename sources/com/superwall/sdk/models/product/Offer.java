package com.superwall.sdk.models.product;

import com.superwall.sdk.models.product.Offer;
import java.lang.annotation.Annotation;
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
public abstract class Offer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Automatic extends Offer {
        public static final Companion Companion = new Companion(null);
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Automatic> serializer() {
                return Offer$Automatic$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Automatic() {
            this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Automatic copy$default(Automatic automatic, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = automatic.type;
            }
            return automatic.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Automatic automatic, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (!compositeEncoder.z(serialDescriptor, 0) && Intrinsics.areEqual(automatic.type, "AUTOMATIC")) {
                return;
            }
            compositeEncoder.y(serialDescriptor, 0, automatic.type);
        }

        public final String component1() {
            return this.type;
        }

        public final Automatic copy(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Automatic(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Automatic) && Intrinsics.areEqual(this.type, ((Automatic) obj).type);
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "Automatic(type=" + this.type + ")";
        }

        public /* synthetic */ Automatic(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if ((i3 & 1) == 0) {
                this.type = "AUTOMATIC";
            } else {
                this.type = str;
            }
        }

        public /* synthetic */ Automatic(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "AUTOMATIC" : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Automatic(String type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class NoOffer extends Offer {
        public static final String TYPE = "NO_OFFER";
        public static final NoOffer INSTANCE = new NoOffer();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: h0.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Offer.NoOffer._init_$_anonymous_();
            }
        });

        private NoOffer() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.superwall.sdk.models.product.Offer.NoOffer", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NoOffer> serializer() {
            return get$cachedSerializer();
        }
    }

    public /* synthetic */ Offer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Offer() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Specified extends Offer {
        public static final Companion Companion = new Companion(null);
        private final String offerIdentifier;
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Specified> serializer() {
                return Offer$Specified$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Specified(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (2 != (i3 & 2)) {
                PluginExceptionsKt.b(i3, 2, Offer$Specified$$serializer.INSTANCE.getDescriptor());
            }
            if ((i3 & 1) == 0) {
                this.type = "SPECIFIED";
            } else {
                this.type = str;
            }
            this.offerIdentifier = str2;
        }

        public static /* synthetic */ Specified copy$default(Specified specified, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = specified.type;
            }
            if ((i3 & 2) != 0) {
                str2 = specified.offerIdentifier;
            }
            return specified.copy(str, str2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Specified specified, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(specified.type, "SPECIFIED")) {
                compositeEncoder.y(serialDescriptor, 0, specified.type);
            }
            compositeEncoder.y(serialDescriptor, 1, specified.offerIdentifier);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.offerIdentifier;
        }

        public final Specified copy(String type, String offerIdentifier) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(offerIdentifier, "offerIdentifier");
            return new Specified(type, offerIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Specified)) {
                return false;
            }
            Specified specified = (Specified) obj;
            return Intrinsics.areEqual(this.type, specified.type) && Intrinsics.areEqual(this.offerIdentifier, specified.offerIdentifier);
        }

        public final String getOfferIdentifier() {
            return this.offerIdentifier;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.offerIdentifier.hashCode();
        }

        public String toString() {
            return "Specified(type=" + this.type + ", offerIdentifier=" + this.offerIdentifier + ")";
        }

        public /* synthetic */ Specified(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "SPECIFIED" : str, str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Specified(String type, String offerIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(offerIdentifier, "offerIdentifier");
            this.type = type;
            this.offerIdentifier = offerIdentifier;
        }
    }
}
