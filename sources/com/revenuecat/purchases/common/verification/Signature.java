package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Signature {
    public static final Companion Companion = new Companion(null);
    private final byte[] intermediateKey;
    private final byte[] intermediateKeyExpiration;
    private final byte[] intermediateKeySignature;
    private final byte[] payload;
    private final byte[] salt;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Signature fromString$purchases_defaultsBc8Release(String signature) throws InvalidSignatureSizeException {
            Intrinsics.checkNotNullParameter(signature, "signature");
            byte[] signatureBytes = Base64.decode(signature, 0);
            int totalSize = Component.Companion.getTotalSize();
            if (signatureBytes.length == totalSize) {
                Intrinsics.checkNotNullExpressionValue(signatureBytes, "signatureBytes");
                return new Signature(SignatureKt.copyOf(signatureBytes, Component.INTERMEDIATE_KEY), SignatureKt.copyOf(signatureBytes, Component.INTERMEDIATE_KEY_EXPIRATION), SignatureKt.copyOf(signatureBytes, Component.INTERMEDIATE_KEY_SIGNATURE), SignatureKt.copyOf(signatureBytes, Component.SALT), SignatureKt.copyOf(signatureBytes, Component.PAYLOAD));
            }
            throw new InvalidSignatureSizeException("Invalid signature size. Expected " + totalSize + ", got " + signatureBytes.length + " bytes");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Component {
        INTERMEDIATE_KEY(32),
        INTERMEDIATE_KEY_EXPIRATION(4),
        INTERMEDIATE_KEY_SIGNATURE(64),
        SALT(16),
        PAYLOAD(64);

        public static final Companion Companion = new Companion(null);
        private final int size;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getTotalSize() {
                int size = 0;
                for (Component component : Component.values()) {
                    size += component.getSize();
                }
                return size;
            }

            private Companion() {
            }
        }

        Component(int i3) {
            this.size = i3;
        }

        public final int getEndByte() {
            return getStartByte() + this.size;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartByte() {
            int i3 = 0;
            for (Object obj : ArraysKt.copyOfRange(values(), 0, ordinal())) {
                i3 += ((Component) obj).size;
            }
            return i3;
        }
    }

    public Signature(byte[] intermediateKey, byte[] intermediateKeyExpiration, byte[] intermediateKeySignature, byte[] salt, byte[] payload) {
        Intrinsics.checkNotNullParameter(intermediateKey, "intermediateKey");
        Intrinsics.checkNotNullParameter(intermediateKeyExpiration, "intermediateKeyExpiration");
        Intrinsics.checkNotNullParameter(intermediateKeySignature, "intermediateKeySignature");
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.intermediateKey = intermediateKey;
        this.intermediateKeyExpiration = intermediateKeyExpiration;
        this.intermediateKeySignature = intermediateKeySignature;
        this.salt = salt;
        this.payload = payload;
    }

    public static /* synthetic */ Signature copy$default(Signature signature, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = signature.intermediateKey;
        }
        if ((i3 & 2) != 0) {
            bArr2 = signature.intermediateKeyExpiration;
        }
        if ((i3 & 4) != 0) {
            bArr3 = signature.intermediateKeySignature;
        }
        if ((i3 & 8) != 0) {
            bArr4 = signature.salt;
        }
        if ((i3 & 16) != 0) {
            bArr5 = signature.payload;
        }
        byte[] bArr6 = bArr5;
        byte[] bArr7 = bArr3;
        return signature.copy(bArr, bArr2, bArr7, bArr4, bArr6);
    }

    public final byte[] component1() {
        return this.intermediateKey;
    }

    public final byte[] component2() {
        return this.intermediateKeyExpiration;
    }

    public final byte[] component3() {
        return this.intermediateKeySignature;
    }

    public final byte[] component4() {
        return this.salt;
    }

    public final byte[] component5() {
        return this.payload;
    }

    public final Signature copy(byte[] intermediateKey, byte[] intermediateKeyExpiration, byte[] intermediateKeySignature, byte[] salt, byte[] payload) {
        Intrinsics.checkNotNullParameter(intermediateKey, "intermediateKey");
        Intrinsics.checkNotNullParameter(intermediateKeyExpiration, "intermediateKeyExpiration");
        Intrinsics.checkNotNullParameter(intermediateKeySignature, "intermediateKeySignature");
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new Signature(intermediateKey, intermediateKeyExpiration, intermediateKeySignature, salt, payload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Signature.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.verification.Signature");
        Signature signature = (Signature) obj;
        return Arrays.equals(this.intermediateKey, signature.intermediateKey) && Arrays.equals(this.intermediateKeyExpiration, signature.intermediateKeyExpiration) && Arrays.equals(this.intermediateKeySignature, signature.intermediateKeySignature) && Arrays.equals(this.salt, signature.salt) && Arrays.equals(this.payload, signature.payload);
    }

    public final byte[] getIntermediateKey() {
        return this.intermediateKey;
    }

    public final byte[] getIntermediateKeyExpiration() {
        return this.intermediateKeyExpiration;
    }

    public final byte[] getIntermediateKeySignature() {
        return this.intermediateKeySignature;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final byte[] getSalt() {
        return this.salt;
    }

    public int hashCode() {
        return (((((((Arrays.hashCode(this.intermediateKey) * 31) + Arrays.hashCode(this.intermediateKeyExpiration)) * 31) + Arrays.hashCode(this.intermediateKeySignature)) * 31) + Arrays.hashCode(this.salt)) * 31) + Arrays.hashCode(this.payload);
    }

    public String toString() {
        return "Signature(intermediateKey=" + Arrays.toString(this.intermediateKey) + ", intermediateKeyExpiration=" + Arrays.toString(this.intermediateKeyExpiration) + ", intermediateKeySignature=" + Arrays.toString(this.intermediateKeySignature) + ", salt=" + Arrays.toString(this.salt) + ", payload=" + Arrays.toString(this.payload) + ')';
    }
}
