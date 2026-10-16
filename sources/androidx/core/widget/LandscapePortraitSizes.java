package androidx.core.widget;

import androidx.core.util.SizeFCompat;
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
public final class LandscapePortraitSizes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SizeFCompat f34659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SizeFCompat f34660b;

    public LandscapePortraitSizes(SizeFCompat landscape, SizeFCompat portrait) {
        Intrinsics.checkNotNullParameter(landscape, "landscape");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        this.f34659a = landscape;
        this.f34660b = portrait;
    }

    public final SizeFCompat a() {
        return this.f34659a;
    }

    public final SizeFCompat b() {
        return this.f34660b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LandscapePortraitSizes)) {
            return false;
        }
        LandscapePortraitSizes landscapePortraitSizes = (LandscapePortraitSizes) obj;
        return Intrinsics.areEqual(this.f34659a, landscapePortraitSizes.f34659a) && Intrinsics.areEqual(this.f34660b, landscapePortraitSizes.f34660b);
    }

    public int hashCode() {
        return (this.f34659a.hashCode() * 31) + this.f34660b.hashCode();
    }

    public String toString() {
        return "LandscapePortraitSizes(landscape=" + this.f34659a + ", portrait=" + this.f34660b + ')';
    }
}
