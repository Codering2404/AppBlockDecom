package com.superwall.sdk.models.internal;

import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DeviceVendorId {
    private final UUID noPrefix;
    private final String value;

    public /* synthetic */ DeviceVendorId(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final UUID getNoPrefix() {
        return this.noPrefix;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }

    private DeviceVendorId(String vendorId) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Charset charset = Charsets.f140510b;
        byte[] bytes = vendorId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        this.value = "$SuperwallDevice:" + UUID.nameUUIDFromBytes(bytes);
        byte[] bytes2 = vendorId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        this.noPrefix = UUID.nameUUIDFromBytes(bytes2);
    }
}
