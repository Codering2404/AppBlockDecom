package androidx.window.area.utils;

import android.util.DisplayMetrics;
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
public final class DeviceMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f54101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f54102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DisplayMetrics f54103c;

    public DeviceMetrics(String manufacturer, String model, DisplayMetrics rearDisplayMetrics) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(rearDisplayMetrics, "rearDisplayMetrics");
        this.f54101a = manufacturer;
        this.f54102b = model;
        this.f54103c = rearDisplayMetrics;
    }

    public final String a() {
        return this.f54101a;
    }

    public final String b() {
        return this.f54102b;
    }

    public final DisplayMetrics c() {
        return this.f54103c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeviceMetrics)) {
            return false;
        }
        DeviceMetrics deviceMetrics = (DeviceMetrics) obj;
        return Intrinsics.areEqual(this.f54101a, deviceMetrics.f54101a) && Intrinsics.areEqual(this.f54102b, deviceMetrics.f54102b) && this.f54103c.equals(deviceMetrics.f54103c);
    }

    public int hashCode() {
        return (((this.f54101a.hashCode() * 31) + this.f54102b.hashCode()) * 31) + this.f54103c.hashCode();
    }

    public String toString() {
        return "DeviceMetrics{ Manufacturer: " + this.f54101a + ", model: " + this.f54102b + ", Rear display metrics: " + this.f54103c + " }";
    }
}
