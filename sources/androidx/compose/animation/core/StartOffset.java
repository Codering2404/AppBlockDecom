package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class StartOffset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4148a;

    public static long a(int i3, int i4) {
        return b(i3 * i4);
    }

    public static /* synthetic */ long c(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i5 & 2) != 0) {
            i4 = StartOffsetType.f4149b.a();
        }
        return a(i3, i4);
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof StartOffset) && j3 == ((StartOffset) obj).j();
    }

    public static final boolean e(long j3, long j4) {
        return j3 == j4;
    }

    public static final int f(long j3) {
        return Math.abs((int) j3);
    }

    public static final int g(long j3) {
        boolean z2 = j3 > 0;
        if (z2) {
            return StartOffsetType.f4149b.b();
        }
        if (z2) {
            throw new NoWhenBranchMatchedException();
        }
        return StartOffsetType.f4149b.a();
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        return "StartOffset(value=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f4148a, obj);
    }

    public int hashCode() {
        return h(this.f4148a);
    }

    public final /* synthetic */ long j() {
        return this.f4148a;
    }

    public String toString() {
        return i(this.f4148a);
    }

    private static long b(long j3) {
        return j3;
    }
}
