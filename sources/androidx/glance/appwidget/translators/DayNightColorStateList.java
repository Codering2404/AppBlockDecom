package androidx.glance.appwidget.translators;

import android.content.res.ColorStateList;
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
public final class DayNightColorStateList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorStateList f39373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f39374b;

    public DayNightColorStateList(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.f39373a = colorStateList;
        this.f39374b = colorStateList2;
    }

    public final ColorStateList a() {
        return this.f39373a;
    }

    public final ColorStateList b() {
        return this.f39374b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DayNightColorStateList)) {
            return false;
        }
        DayNightColorStateList dayNightColorStateList = (DayNightColorStateList) obj;
        return Intrinsics.areEqual(this.f39373a, dayNightColorStateList.f39373a) && Intrinsics.areEqual(this.f39374b, dayNightColorStateList.f39374b);
    }

    public int hashCode() {
        return (this.f39373a.hashCode() * 31) + this.f39374b.hashCode();
    }

    public String toString() {
        return "DayNightColorStateList(day=" + this.f39373a + ", night=" + this.f39374b + ')';
    }
}
