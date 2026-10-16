package com.revenuecat.purchases.common.caching;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class TokenCacheEntry {
    public static final Companion Companion = new Companion(null);
    private final Boolean isAutoRenewing;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TokenCacheEntry> serializer() {
            return TokenCacheEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TokenCacheEntry() {
        this((Boolean) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ TokenCacheEntry copy$default(TokenCacheEntry tokenCacheEntry, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bool = tokenCacheEntry.isAutoRenewing;
        }
        return tokenCacheEntry.copy(bool);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TokenCacheEntry tokenCacheEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (!compositeEncoder.z(serialDescriptor, 0) && tokenCacheEntry.isAutoRenewing == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, tokenCacheEntry.isAutoRenewing);
    }

    public final Boolean component1() {
        return this.isAutoRenewing;
    }

    public final TokenCacheEntry copy(Boolean bool) {
        return new TokenCacheEntry(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TokenCacheEntry) && Intrinsics.areEqual(this.isAutoRenewing, ((TokenCacheEntry) obj).isAutoRenewing);
    }

    public int hashCode() {
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public String toString() {
        return "TokenCacheEntry(isAutoRenewing=" + this.isAutoRenewing + ')';
    }

    @Deprecated
    public /* synthetic */ TokenCacheEntry(int i3, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.isAutoRenewing = null;
        } else {
            this.isAutoRenewing = bool;
        }
    }

    public TokenCacheEntry(Boolean bool) {
        this.isAutoRenewing = bool;
    }

    public /* synthetic */ TokenCacheEntry(Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool);
    }
}
