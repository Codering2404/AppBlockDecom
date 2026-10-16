package com.facebook.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class LoginConfiguration {
    public static final Companion Companion = new Companion(null);
    public static final String OPENID = "openid";
    private final String codeVerifier;
    private final String nonce;
    private final Set<String> permissions;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginConfiguration(Collection<String> collection) {
        this(collection, null, 2, 0 == true ? 1 : 0);
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginConfiguration(Collection collection, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
        this(collection, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginConfiguration(Collection<String> collection, String nonce) {
        this(collection, nonce, PKCEUtil.generateCodeVerifier());
        Intrinsics.checkNotNullParameter(nonce, "nonce");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginConfiguration(Collection collection, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        collection = (i3 & 1) != 0 ? null : collection;
        if ((i3 & 2) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
        this(collection, str, str2);
    }

    public LoginConfiguration(Collection<String> collection, String nonce, String codeVerifier) {
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        if (NonceUtil.isValidNonce(nonce) && PKCEUtil.isValidCodeVerifier(codeVerifier)) {
            HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
            hashSet.add(OPENID);
            Set<String> setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(permissions)");
            this.permissions = setUnmodifiableSet;
            this.nonce = nonce;
            this.codeVerifier = codeVerifier;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
