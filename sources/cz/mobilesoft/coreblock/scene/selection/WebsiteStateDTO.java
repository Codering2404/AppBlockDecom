package cz.mobilesoft.coreblock.scene.selection;

import cz.mobilesoft.coreblock.dto.WebsiteDTO;
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
public final class WebsiteStateDTO {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f118099e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebsiteDTO f118100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f118101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f118102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f118103d;

    public WebsiteStateDTO(WebsiteDTO website, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(website, "website");
        this.f118100a = website;
        this.f118101b = z2;
        this.f118102c = z3;
        this.f118103d = z4;
    }

    public static /* synthetic */ WebsiteStateDTO b(WebsiteStateDTO websiteStateDTO, WebsiteDTO websiteDTO, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            websiteDTO = websiteStateDTO.f118100a;
        }
        if ((i3 & 2) != 0) {
            z2 = websiteStateDTO.f118101b;
        }
        if ((i3 & 4) != 0) {
            z3 = websiteStateDTO.f118102c;
        }
        if ((i3 & 8) != 0) {
            z4 = websiteStateDTO.f118103d;
        }
        return websiteStateDTO.a(websiteDTO, z2, z3, z4);
    }

    public final WebsiteStateDTO a(WebsiteDTO website, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(website, "website");
        return new WebsiteStateDTO(website, z2, z3, z4);
    }

    public final WebsiteDTO c() {
        return this.f118100a;
    }

    public final boolean d() {
        return this.f118102c;
    }

    public final boolean e() {
        return this.f118101b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebsiteStateDTO)) {
            return false;
        }
        WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) obj;
        return Intrinsics.areEqual(this.f118100a, websiteStateDTO.f118100a) && this.f118101b == websiteStateDTO.f118101b && this.f118102c == websiteStateDTO.f118102c && this.f118103d == websiteStateDTO.f118103d;
    }

    public final void f(boolean z2) {
        this.f118102c = z2;
    }

    public final void g(boolean z2) {
        this.f118101b = z2;
    }

    public int hashCode() {
        return (((((this.f118100a.hashCode() * 31) + Boolean.hashCode(this.f118101b)) * 31) + Boolean.hashCode(this.f118102c)) * 31) + Boolean.hashCode(this.f118103d);
    }

    public String toString() {
        return "WebsiteStateDTO(website=" + this.f118100a + ", isSelected=" + this.f118101b + ", isEnabled=" + this.f118102c + ", isPreset=" + this.f118103d + ")";
    }

    public /* synthetic */ WebsiteStateDTO(WebsiteDTO websiteDTO, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(websiteDTO, z2, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? false : z4);
    }
}
