package androidx.compose.ui.node;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class TouchBoundsExpansion {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f27637b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f27638c = TouchBoundsExpansionKt.c(0, 0, 0, 0, 14, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27639a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final long d(int i3, int i4) {
            return ((long) (i3 & 32767)) << (i4 * 15);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int e(long j3, int i3) {
            return ((int) (j3 >> (i3 * 15))) & 32767;
        }

        public final long b() {
            return TouchBoundsExpansion.f27638c;
        }

        public final long c(int i3, int i4, int i5, int i6, boolean z2) {
            return d(i4, 1) | d(i3, 0) | d(i5, 2) | d(i6, 3) | (z2 ? Long.MIN_VALUE : 0L);
        }

        private Companion() {
        }
    }

    public static final int b(long j3, LayoutDirection layoutDirection) {
        return (!k(j3) || layoutDirection == LayoutDirection.f30001a) ? h(j3) : g(j3);
    }

    public static final int c(long j3, LayoutDirection layoutDirection) {
        return (!k(j3) || layoutDirection == LayoutDirection.f30001a) ? g(j3) : h(j3);
    }

    public static boolean e(long j3, Object obj) {
        return (obj instanceof TouchBoundsExpansion) && j3 == ((TouchBoundsExpansion) obj).m();
    }

    public static final int f(long j3) {
        return f27637b.e(j3, 3);
    }

    public static final int g(long j3) {
        return f27637b.e(j3, 2);
    }

    public static final int h(long j3) {
        return f27637b.e(j3, 0);
    }

    public static final int i(long j3) {
        return f27637b.e(j3, 1);
    }

    public static int j(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean k(long j3) {
        return (j3 & Long.MIN_VALUE) != 0;
    }

    public static String l(long j3) {
        return "TouchBoundsExpansion(packedValue=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f27639a, obj);
    }

    public int hashCode() {
        return j(this.f27639a);
    }

    public final /* synthetic */ long m() {
        return this.f27639a;
    }

    public String toString() {
        return l(this.f27639a);
    }

    public static long d(long j3) {
        return j3;
    }
}
