package androidx.compose.runtime.snapshots;

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
public final class ReaderKind {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f24910b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24911a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static boolean b(int i3, Object obj) {
        return (obj instanceof ReaderKind) && i3 == ((ReaderKind) obj).e();
    }

    public static int c(int i3) {
        return Integer.hashCode(i3);
    }

    public static String d(int i3) {
        return "ReaderKind(mask=" + i3 + ')';
    }

    public final /* synthetic */ int e() {
        return this.f24911a;
    }

    public boolean equals(Object obj) {
        return b(this.f24911a, obj);
    }

    public int hashCode() {
        return c(this.f24911a);
    }

    public String toString() {
        return d(this.f24911a);
    }

    public static int a(int i3) {
        return i3;
    }
}
