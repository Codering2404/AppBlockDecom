package com.revenuecat.purchases.models;

import com.revenuecat.purchases.common.verification.SigningManager;
import java.lang.annotation.Annotation;
import java.security.MessageDigest;
import java.util.Locale;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
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
public final class Checksum {
    private final Algorithm algorithm;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {Algorithm.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public enum Algorithm {
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512"),
        MD5("MD5");

        private final String algorithmName;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.models.Checksum.Algorithm.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("com.revenuecat.purchases.models.Checksum.Algorithm", Algorithm.values(), new String[]{SigningManager.POST_PARAMS_ALGORITHM, "sha384", "sha512", "md5"}, new Annotation[][]{null, null, null, null}, null);
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Algorithm.$cachedSerializer$delegate.getValue();
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            public final Algorithm fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                switch (lowerCase.hashCode()) {
                    case -903629273:
                        if (lowerCase.equals(SigningManager.POST_PARAMS_ALGORITHM)) {
                            return Algorithm.SHA256;
                        }
                        return null;
                    case -903628221:
                        if (lowerCase.equals("sha384")) {
                            return Algorithm.SHA384;
                        }
                        return null;
                    case -903626518:
                        if (lowerCase.equals("sha512")) {
                            return Algorithm.SHA512;
                        }
                        return null;
                    case 107902:
                        if (lowerCase.equals("md5")) {
                            return Algorithm.MD5;
                        }
                        return null;
                    default:
                        return null;
                }
            }

            public final KSerializer<Algorithm> serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }

        Algorithm(String str) {
            this.algorithmName = str;
        }

        public final String getAlgorithmName() {
            return this.algorithmName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ChecksumValidationException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Checksum generate(byte[] data, Algorithm algorithm) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(algorithm, "algorithm");
            byte[] hash = MessageDigest.getInstance(algorithm.getAlgorithmName()).digest(data);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            return new Checksum(algorithm, ChecksumKt.toHexString(hash));
        }

        public final KSerializer<Checksum> serializer() {
            return Checksum$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ Checksum(int i3, @SerialName Algorithm algorithm, @SerialName String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, Checksum$$serializer.INSTANCE.getDescriptor());
        }
        this.algorithm = algorithm;
        this.value = str;
    }

    public static /* synthetic */ Checksum copy$default(Checksum checksum, Algorithm algorithm, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            algorithm = checksum.algorithm;
        }
        if ((i3 & 2) != 0) {
            str = checksum.value;
        }
        return checksum.copy(algorithm, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Checksum checksum, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], checksum.algorithm);
        compositeEncoder.y(serialDescriptor, 1, checksum.value);
    }

    public final Algorithm component1() {
        return this.algorithm;
    }

    public final String component2() {
        return this.value;
    }

    public final Checksum copy(Algorithm algorithm, String value) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Checksum(algorithm, value);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Checksum)) {
            return false;
        }
        String str = this.value;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Checksum checksum = (Checksum) obj;
        String lowerCase2 = checksum.value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase2) && this.algorithm == checksum.algorithm;
    }

    public final Algorithm getAlgorithm() {
        return this.algorithm;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.algorithm.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Checksum(algorithm=" + this.algorithm + ", value=" + this.value + ')';
    }

    public Checksum(Algorithm algorithm, String value) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(value, "value");
        this.algorithm = algorithm;
        this.value = value;
    }

    @SerialName
    public static /* synthetic */ void getAlgorithm$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getValue$annotations() {
    }
}
