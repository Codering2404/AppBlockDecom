package androidx.glance.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PaddingInDp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f39483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f39484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f39485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f39486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f39487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f39488f;

    public /* synthetic */ PaddingInDp(float f3, float f4, float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8);
    }

    public final float a() {
        return this.f39488f;
    }

    public final float b() {
        return this.f39483a;
    }

    public final float c() {
        return this.f39486d;
    }

    public final float d() {
        return this.f39485c;
    }

    public final PaddingInDp e(boolean z2) {
        return new PaddingInDp(Dp.g(this.f39483a + (z2 ? this.f39487e : this.f39484b)), 0.0f, this.f39485c, Dp.g(this.f39486d + (z2 ? this.f39484b : this.f39487e)), 0.0f, this.f39488f, 18, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingInDp)) {
            return false;
        }
        PaddingInDp paddingInDp = (PaddingInDp) obj;
        return Dp.i(this.f39483a, paddingInDp.f39483a) && Dp.i(this.f39484b, paddingInDp.f39484b) && Dp.i(this.f39485c, paddingInDp.f39485c) && Dp.i(this.f39486d, paddingInDp.f39486d) && Dp.i(this.f39487e, paddingInDp.f39487e) && Dp.i(this.f39488f, paddingInDp.f39488f);
    }

    public int hashCode() {
        return (((((((((Dp.j(this.f39483a) * 31) + Dp.j(this.f39484b)) * 31) + Dp.j(this.f39485c)) * 31) + Dp.j(this.f39486d)) * 31) + Dp.j(this.f39487e)) * 31) + Dp.j(this.f39488f);
    }

    public String toString() {
        return "PaddingInDp(left=" + ((Object) Dp.k(this.f39483a)) + ", start=" + ((Object) Dp.k(this.f39484b)) + ", top=" + ((Object) Dp.k(this.f39485c)) + ", right=" + ((Object) Dp.k(this.f39486d)) + ", end=" + ((Object) Dp.k(this.f39487e)) + ", bottom=" + ((Object) Dp.k(this.f39488f)) + ')';
    }

    private PaddingInDp(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f39483a = f3;
        this.f39484b = f4;
        this.f39485c = f5;
        this.f39486d = f6;
        this.f39487e = f7;
        this.f39488f = f8;
    }

    public /* synthetic */ PaddingInDp(float f3, float f4, float f5, float f6, float f7, float f8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dp.g(0) : f3, (i3 & 2) != 0 ? Dp.g(0) : f4, (i3 & 4) != 0 ? Dp.g(0) : f5, (i3 & 8) != 0 ? Dp.g(0) : f6, (i3 & 16) != 0 ? Dp.g(0) : f7, (i3 & 32) != 0 ? Dp.g(0) : f8, null);
    }
}
