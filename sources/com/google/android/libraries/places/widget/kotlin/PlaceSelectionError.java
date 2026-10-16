package com.google.android.libraries.places.widget.kotlin;

import com.google.android.gms.common.api.Status;
import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
@Metadata
public final class PlaceSelectionError extends PlaceSelectionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f79375a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaceSelectionError(Status status) {
        super(null);
        Intrinsics.checkNotNullParameter(status, "status");
        this.f79375a = status;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlaceSelectionError) && Intrinsics.areEqual(this.f79375a, ((PlaceSelectionError) obj).f79375a);
    }

    public int hashCode() {
        return this.f79375a.hashCode();
    }

    public String toString() {
        Status status = this.f79375a;
        StringBuilder sb = new StringBuilder(String.valueOf(status).length() + 28);
        sb.append("PlaceSelectionError(status=");
        sb.append(status);
        sb.append(")");
        return sb.toString();
    }
}
