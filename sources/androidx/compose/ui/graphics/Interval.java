package androidx.compose.ui.graphics;

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
public class Interval<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f25791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f25793c;

    public Interval(float f3, float f4, Object obj) {
        this.f25791a = f3;
        this.f25792b = f4;
        this.f25793c = obj;
    }

    public final Object a() {
        return this.f25793c;
    }

    public final float b() {
        return this.f25792b;
    }

    public final float c() {
        return this.f25791a;
    }

    public final boolean d(float f3, float f4) {
        return this.f25791a <= f4 && this.f25792b >= f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Interval interval = (Interval) obj;
            return this.f25791a == interval.f25791a && this.f25792b == interval.f25792b && Intrinsics.areEqual(this.f25793c, interval.f25793c);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.f25791a) * 31) + Float.hashCode(this.f25792b)) * 31;
        Object obj = this.f25793c;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "Interval(start=" + this.f25791a + ", end=" + this.f25792b + ", data=" + this.f25793c + ')';
    }
}
