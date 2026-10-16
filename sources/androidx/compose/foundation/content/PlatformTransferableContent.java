package androidx.compose.foundation.content;

import android.net.Uri;
import android.os.Bundle;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PlatformTransferableContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f5194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f5195b;

    public PlatformTransferableContent(Uri uri, Bundle bundle) {
        this.f5194a = uri;
        this.f5195b = bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformTransferableContent)) {
            return false;
        }
        PlatformTransferableContent platformTransferableContent = (PlatformTransferableContent) obj;
        return Intrinsics.areEqual(this.f5194a, platformTransferableContent.f5194a) && Intrinsics.areEqual(this.f5195b, platformTransferableContent.f5195b);
    }

    public int hashCode() {
        Uri uri = this.f5194a;
        return ((uri != null ? uri.hashCode() : 0) * 31) + this.f5195b.hashCode();
    }

    public String toString() {
        return "PlatformTransferableContent(linkUri=" + this.f5194a + ", extras=" + this.f5195b + ')';
    }
}
