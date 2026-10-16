package cz.mobilesoft.coreblock.dto;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ViewIdDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f96955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f96956c;

    public ViewIdDTO(String id, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f96954a = id;
        this.f96955b = z2;
        this.f96956c = z3;
    }

    public final boolean a() {
        return this.f96955b;
    }

    public final String b() {
        return this.f96954a;
    }

    public final boolean c() {
        return this.f96956c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewIdDTO)) {
            return false;
        }
        ViewIdDTO viewIdDTO = (ViewIdDTO) obj;
        return Intrinsics.areEqual(this.f96954a, viewIdDTO.f96954a) && this.f96955b == viewIdDTO.f96955b && this.f96956c == viewIdDTO.f96956c;
    }

    public int hashCode() {
        return (((this.f96954a.hashCode() * 31) + Boolean.hashCode(this.f96955b)) * 31) + Boolean.hashCode(this.f96956c);
    }

    public String toString() {
        return "ViewIdDTO(id=" + this.f96954a + ", clearUrl=" + this.f96955b + ", showLocalHtml=" + this.f96956c + ")";
    }

    public /* synthetic */ ViewIdDTO(String str, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z2, (i3 & 4) != 0 ? true : z3);
    }
}
