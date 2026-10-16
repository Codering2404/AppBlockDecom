package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

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
@JvmInline
public final class OrientationIndependentConstraints {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7037a;

    public static long a(int i3, int i4, int i5, int i6) {
        return b(ConstraintsKt.a(i3, i4, i5, i6));
    }

    public static long c(long j3, LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.f6996a;
        return a(layoutOrientation == layoutOrientation2 ? Constraints.n(j3) : Constraints.m(j3), layoutOrientation == layoutOrientation2 ? Constraints.l(j3) : Constraints.k(j3), layoutOrientation == layoutOrientation2 ? Constraints.m(j3) : Constraints.n(j3), layoutOrientation == layoutOrientation2 ? Constraints.k(j3) : Constraints.l(j3));
    }

    public static final long d(long j3, int i3, int i4, int i5, int i6) {
        return a(i3, i4, i5, i6);
    }

    public static /* synthetic */ long e(long j3, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = Constraints.n(j3);
        }
        int i8 = i3;
        if ((i7 & 2) != 0) {
            i4 = Constraints.l(j3);
        }
        int i9 = i4;
        if ((i7 & 4) != 0) {
            i5 = Constraints.m(j3);
        }
        int i10 = i5;
        if ((i7 & 8) != 0) {
            i6 = Constraints.k(j3);
        }
        return d(j3, i8, i9, i10, i6);
    }

    public static boolean f(long j3, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.f(j3, ((OrientationIndependentConstraints) obj).j());
    }

    public static int g(long j3) {
        return Constraints.o(j3);
    }

    public static final long h(long j3, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.f6996a ? ConstraintsKt.a(Constraints.n(j3), Constraints.l(j3), Constraints.m(j3), Constraints.k(j3)) : ConstraintsKt.a(Constraints.m(j3), Constraints.k(j3), Constraints.n(j3), Constraints.l(j3));
    }

    public static String i(long j3) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.q(j3)) + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f7037a, obj);
    }

    public int hashCode() {
        return g(this.f7037a);
    }

    public final /* synthetic */ long j() {
        return this.f7037a;
    }

    public String toString() {
        return i(this.f7037a);
    }

    private static long b(long j3) {
        return j3;
    }
}
