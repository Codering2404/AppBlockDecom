package com.superwall.sdk.store.abstractions.product;

import com.superwall.sdk.models.product.Offer;
import com.superwall.sdk.store.abstractions.product.OfferType;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public abstract class OfferType {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: k0.n0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return OfferType._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Auto extends OfferType {
        public static final Auto INSTANCE = new Auto();

        private Auto() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) OfferType.$cachedSerializer$delegate.getValue();
        }

        public final OfferType from(String str) {
            return (str == null || str.length() == 0 || Intrinsics.areEqual(str, "sw-auto")) ? Auto.INSTANCE : Intrinsics.areEqual(str, "sw-none") ? None.INSTANCE : new Specific(str);
        }

        public final KSerializer<OfferType> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class None extends OfferType {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Specific extends OfferType {
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Specific(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public static /* synthetic */ Specific copy$default(Specific specific, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = specific.id;
            }
            return specific.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Specific copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Specific(id);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Specific) && Intrinsics.areEqual(this.id, ((Specific) obj).id);
        }

        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Specific(id=" + this.id + ")";
        }
    }

    public /* synthetic */ OfferType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.store.abstractions.product.OfferType", Reflection.b(OfferType.class), new KClass[0], new KSerializer[0], new Annotation[0]);
    }

    public final String getSpecificId() {
        Specific specific = this instanceof Specific ? (Specific) this : null;
        if (specific != null) {
            return specific.getId();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Offer toOffer() {
        int i3 = 1;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (this instanceof Auto) {
            return new Offer.Automatic(str, i3, (DefaultConstructorMarker) (objArr3 == true ? 1 : 0));
        }
        if (this instanceof None) {
            return Offer.NoOffer.INSTANCE;
        }
        if (!(this instanceof Specific)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Offer.Specified((String) (objArr2 == true ? 1 : 0), ((Specific) this).getId(), i3, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
    }

    private OfferType() {
    }

    public /* synthetic */ OfferType(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(OfferType offerType, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
