package androidx.compose.ui.text;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ParagraphIntrinsicInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParagraphIntrinsics f28740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28742c;

    public ParagraphIntrinsicInfo(ParagraphIntrinsics paragraphIntrinsics, int i3, int i4) {
        this.f28740a = paragraphIntrinsics;
        this.f28741b = i3;
        this.f28742c = i4;
    }

    public final int a() {
        return this.f28742c;
    }

    public final ParagraphIntrinsics b() {
        return this.f28740a;
    }

    public final int c() {
        return this.f28741b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphIntrinsicInfo)) {
            return false;
        }
        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
        return Intrinsics.areEqual(this.f28740a, paragraphIntrinsicInfo.f28740a) && this.f28741b == paragraphIntrinsicInfo.f28741b && this.f28742c == paragraphIntrinsicInfo.f28742c;
    }

    public int hashCode() {
        return (((this.f28740a.hashCode() * 31) + Integer.hashCode(this.f28741b)) * 31) + Integer.hashCode(this.f28742c);
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.f28740a + ", startIndex=" + this.f28741b + ", endIndex=" + this.f28742c + ')';
    }
}
