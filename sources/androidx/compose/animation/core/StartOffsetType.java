package androidx.compose.animation.core;

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
public final class StartOffsetType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f4149b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4150c = c(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4151d = c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4152a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return StartOffsetType.f4150c;
        }

        public final int b() {
            return StartOffsetType.f4151d;
        }

        private Companion() {
        }
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof StartOffsetType) && i3 == ((StartOffsetType) obj).h();
    }

    public static final boolean e(int i3, int i4) {
        return i3 == i4;
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        return "StartOffsetType(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f4152a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f4152a;
    }

    public int hashCode() {
        return f(this.f4152a);
    }

    public String toString() {
        return g(this.f4152a);
    }

    private static int c(int i3) {
        return i3;
    }
}
