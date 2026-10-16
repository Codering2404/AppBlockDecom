package cz.mobilesoft.coreblock.dto;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebsiteDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebsiteProfileRelation.BlockingType f96963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f96964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f96965d;

    public WebsiteDTO(String name, WebsiteProfileRelation.BlockingType type, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f96962a = name;
        this.f96963b = type;
        this.f96964c = z2;
        this.f96965d = z3;
    }

    public final String a() {
        return this.f96962a;
    }

    public final String b() {
        if (this.f96963b != WebsiteProfileRelation.BlockingType.KEYWORD || !this.f96964c) {
            return this.f96962a;
        }
        return "/" + this.f96962a + "/";
    }

    public final WebsiteProfileRelation.BlockingType c() {
        return this.f96963b;
    }

    public final boolean d() {
        return this.f96964c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebsiteDTO)) {
            return false;
        }
        WebsiteDTO websiteDTO = (WebsiteDTO) obj;
        return Intrinsics.areEqual(this.f96962a, websiteDTO.f96962a) && this.f96963b == websiteDTO.f96963b && this.f96964c == websiteDTO.f96964c && this.f96965d == websiteDTO.f96965d;
    }

    public int hashCode() {
        return (((((this.f96962a.hashCode() * 31) + this.f96963b.hashCode()) * 31) + Boolean.hashCode(this.f96964c)) * 31) + Boolean.hashCode(this.f96965d);
    }

    public String toString() {
        return "WebsiteDTO(name=" + this.f96962a + ", type=" + this.f96963b + ", isAnywhereInUrl=" + this.f96964c + ", isEnabled=" + this.f96965d + ")";
    }

    public /* synthetic */ WebsiteDTO(String str, WebsiteProfileRelation.BlockingType blockingType, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, blockingType, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? true : z3);
    }
}
