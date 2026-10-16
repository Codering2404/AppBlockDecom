package com.appsflyer.internal;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AFc1aSDK {
    public final String AFInAppEventParameterName;
    public final AFd1zSDK AFInAppEventType;
    public final String valueOf;

    public AFc1aSDK(String str, String str2, AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.AFInAppEventParameterName = str;
        this.valueOf = str2;
        this.AFInAppEventType = aFd1zSDK;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1aSDK)) {
            return false;
        }
        AFc1aSDK aFc1aSDK = (AFc1aSDK) obj;
        return Intrinsics.areEqual(this.AFInAppEventParameterName, aFc1aSDK.AFInAppEventParameterName) && Intrinsics.areEqual(this.valueOf, aFc1aSDK.valueOf) && this.AFInAppEventType == aFc1aSDK.AFInAppEventType;
    }

    public final int hashCode() {
        int iHashCode = this.AFInAppEventParameterName.hashCode() * 31;
        String str = this.valueOf;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.AFInAppEventType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AFc1aSDK(valueOf=");
        sb.append(this.AFInAppEventParameterName);
        sb.append(", AFInAppEventParameterName=");
        sb.append(this.valueOf);
        sb.append(", AFKeystoreWrapper=");
        sb.append(this.AFInAppEventType);
        sb.append(')');
        return sb.toString();
    }
}
