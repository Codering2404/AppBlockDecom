package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import com.google.crypto.tink.subtle.Ed25519Verify;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
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
public final class DefaultSignatureVerifier implements SignatureVerifier {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_PUBLIC_KEY = "UC1upXWg5QVmyOSwozp755xLqquBKjjU+di6U8QhMlM=";
    private final Ed25519Verify verifier;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DefaultSignatureVerifier(byte[] publicKeyBytes) {
        Intrinsics.checkNotNullParameter(publicKeyBytes, "publicKeyBytes");
        this.verifier = new Ed25519Verify(publicKeyBytes);
    }

    @Override // com.revenuecat.purchases.common.verification.SignatureVerifier
    public boolean verify(byte[] signatureToVerify, byte[] messageToVerify) {
        Intrinsics.checkNotNullParameter(signatureToVerify, "signatureToVerify");
        Intrinsics.checkNotNullParameter(messageToVerify, "messageToVerify");
        try {
            this.verifier.a(signatureToVerify, messageToVerify);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultSignatureVerifier(String publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        byte[] bArrDecode = Base64.decode(publicKey, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(publicKey, Base64.DEFAULT)");
        this(bArrDecode);
    }

    public /* synthetic */ DefaultSignatureVerifier(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? DEFAULT_PUBLIC_KEY : str);
    }
}
