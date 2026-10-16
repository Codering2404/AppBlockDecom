package androidx.glance;

import androidx.glance.unit.ColorProvider;
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
public final class ButtonColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorProvider f37528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorProvider f37529b;

    public ButtonColors(ColorProvider colorProvider, ColorProvider colorProvider2) {
        this.f37528a = colorProvider;
        this.f37529b = colorProvider2;
    }

    public final ColorProvider a() {
        return this.f37528a;
    }

    public final ColorProvider b() {
        return this.f37529b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ButtonColors.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.glance.ButtonColors");
        ButtonColors buttonColors = (ButtonColors) obj;
        return Intrinsics.areEqual(this.f37528a, buttonColors.f37528a) && Intrinsics.areEqual(this.f37529b, buttonColors.f37529b);
    }

    public int hashCode() {
        return (this.f37528a.hashCode() * 31) + this.f37529b.hashCode();
    }
}
