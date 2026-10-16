package cz.mobilesoft.coreblock.dto;

import android.graphics.drawable.Drawable;
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
public final class WebAllowlistBrowserItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f96957d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Drawable f96960c;

    public WebAllowlistBrowserItem(String packageName, String label, Drawable drawable) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(label, "label");
        this.f96958a = packageName;
        this.f96959b = label;
        this.f96960c = drawable;
    }

    public final Drawable a() {
        return this.f96960c;
    }

    public final String b() {
        return this.f96959b;
    }

    public final String c() {
        return this.f96958a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebAllowlistBrowserItem)) {
            return false;
        }
        WebAllowlistBrowserItem webAllowlistBrowserItem = (WebAllowlistBrowserItem) obj;
        return Intrinsics.areEqual(this.f96958a, webAllowlistBrowserItem.f96958a) && Intrinsics.areEqual(this.f96959b, webAllowlistBrowserItem.f96959b) && Intrinsics.areEqual(this.f96960c, webAllowlistBrowserItem.f96960c);
    }

    public int hashCode() {
        int iHashCode = ((this.f96958a.hashCode() * 31) + this.f96959b.hashCode()) * 31;
        Drawable drawable = this.f96960c;
        return iHashCode + (drawable == null ? 0 : drawable.hashCode());
    }

    public String toString() {
        return "WebAllowlistBrowserItem(packageName=" + this.f96958a + ", label=" + this.f96959b + ", icon=" + this.f96960c + ")";
    }

    public /* synthetic */ WebAllowlistBrowserItem(String str, String str2, Drawable drawable, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : drawable);
    }
}
