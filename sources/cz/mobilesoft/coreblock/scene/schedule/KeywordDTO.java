package cz.mobilesoft.coreblock.scene.schedule;

import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class KeywordDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f114374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f114375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f114376c;

    public KeywordDTO(Long l3, String keyword, boolean z2) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.f114374a = l3;
        this.f114375b = keyword;
        this.f114376c = z2;
    }

    public final String a() {
        return this.f114375b;
    }

    public final boolean b() {
        return this.f114376c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeywordDTO)) {
            return false;
        }
        KeywordDTO keywordDTO = (KeywordDTO) obj;
        return Intrinsics.areEqual(this.f114374a, keywordDTO.f114374a) && Intrinsics.areEqual(this.f114375b, keywordDTO.f114375b) && this.f114376c == keywordDTO.f114376c;
    }

    public int hashCode() {
        Long l3 = this.f114374a;
        return ((((l3 == null ? 0 : l3.hashCode()) * 31) + this.f114375b.hashCode()) * 31) + Boolean.hashCode(this.f114376c);
    }

    public String toString() {
        return "KeywordDTO(id=" + this.f114374a + ", keyword=" + this.f114375b + ", isAnywhereInUrl=" + this.f114376c + ")";
    }

    public /* synthetic */ KeywordDTO(Long l3, String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, str, z2);
    }
}
