package com.superwall.sdk.models.postback;

import com.superwall.sdk.models.SerializableEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class PostBackResponse implements SerializableEntity {
    public static final Companion Companion = new Companion(null);
    private final String status;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PostBackResponse> serializer() {
            return PostBackResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PostBackResponse(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, PostBackResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.status = str;
    }

    public static /* synthetic */ PostBackResponse copy$default(PostBackResponse postBackResponse, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = postBackResponse.status;
        }
        return postBackResponse.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final PostBackResponse copy(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new PostBackResponse(status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PostBackResponse) && Intrinsics.areEqual(this.status, ((PostBackResponse) obj).status);
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "PostBackResponse(status=" + this.status + ")";
    }

    public PostBackResponse(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }
}
