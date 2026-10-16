package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class SubscriberAttributeError {
    private final String keyName;
    private final String message;

    public SubscriberAttributeError(String keyName, String message) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        this.keyName = keyName;
        this.message = message;
    }

    public static /* synthetic */ SubscriberAttributeError copy$default(SubscriberAttributeError subscriberAttributeError, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = subscriberAttributeError.keyName;
        }
        if ((i3 & 2) != 0) {
            str2 = subscriberAttributeError.message;
        }
        return subscriberAttributeError.copy(str, str2);
    }

    public final String component1() {
        return this.keyName;
    }

    public final String component2() {
        return this.message;
    }

    public final SubscriberAttributeError copy(String keyName, String message) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SubscriberAttributeError(keyName, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriberAttributeError)) {
            return false;
        }
        SubscriberAttributeError subscriberAttributeError = (SubscriberAttributeError) obj;
        return Intrinsics.areEqual(this.keyName, subscriberAttributeError.keyName) && Intrinsics.areEqual(this.message, subscriberAttributeError.message);
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.keyName.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SubscriberAttributeError(keyName=" + this.keyName + ", message=" + this.message + ')';
    }
}
