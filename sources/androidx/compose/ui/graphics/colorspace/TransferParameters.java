package androidx.compose.ui.graphics.colorspace;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TransferParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f26058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f26059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f26060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f26061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f26062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f26063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double f26064g;

    public TransferParameters(double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f26058a = d3;
        this.f26059b = d4;
        this.f26060c = d5;
        this.f26061d = d6;
        this.f26062e = d7;
        this.f26063f = d8;
        this.f26064g = d9;
        if (Double.isNaN(d4) || Double.isNaN(d5) || Double.isNaN(d6) || Double.isNaN(d7) || Double.isNaN(d8) || Double.isNaN(d9) || Double.isNaN(d3)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (TransferParametersKt.b(d3)) {
            return;
        }
        if (d7 < 0.0d || d7 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d7);
        }
        if (d7 == 0.0d && (d4 == 0.0d || d3 == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d7 >= 1.0d && d6 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d4 == 0.0d || d3 == 0.0d) && d6 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d6 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d4 < 0.0d || d3 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    public final double a() {
        return this.f26059b;
    }

    public final double b() {
        return this.f26060c;
    }

    public final double c() {
        return this.f26061d;
    }

    public final double d() {
        return this.f26062e;
    }

    public final double e() {
        return this.f26063f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Double.compare(this.f26058a, transferParameters.f26058a) == 0 && Double.compare(this.f26059b, transferParameters.f26059b) == 0 && Double.compare(this.f26060c, transferParameters.f26060c) == 0 && Double.compare(this.f26061d, transferParameters.f26061d) == 0 && Double.compare(this.f26062e, transferParameters.f26062e) == 0 && Double.compare(this.f26063f, transferParameters.f26063f) == 0 && Double.compare(this.f26064g, transferParameters.f26064g) == 0;
    }

    public final double f() {
        return this.f26064g;
    }

    public final double g() {
        return this.f26058a;
    }

    public final boolean h() {
        return this.f26058a == -3.0d;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.f26058a) * 31) + Double.hashCode(this.f26059b)) * 31) + Double.hashCode(this.f26060c)) * 31) + Double.hashCode(this.f26061d)) * 31) + Double.hashCode(this.f26062e)) * 31) + Double.hashCode(this.f26063f)) * 31) + Double.hashCode(this.f26064g);
    }

    public final boolean i() {
        return this.f26058a == -2.0d;
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.f26058a + ", a=" + this.f26059b + ", b=" + this.f26060c + ", c=" + this.f26061d + ", d=" + this.f26062e + ", e=" + this.f26063f + ", f=" + this.f26064g + ')';
    }

    public /* synthetic */ TransferParameters(double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(d3, d4, d5, d6, d7, (i3 & 32) != 0 ? 0.0d : d8, (i3 & 64) != 0 ? 0.0d : d9);
    }
}
