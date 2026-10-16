package androidx.compose.ui.graphics;

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
public final class CompositingStrategy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25737b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25738c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25739d = e(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25740e = e(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25741a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return CompositingStrategy.f25738c;
        }

        public final int b() {
            return CompositingStrategy.f25740e;
        }

        public final int c() {
            return CompositingStrategy.f25739d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ CompositingStrategy(int i3) {
        this.f25741a = i3;
    }

    public static final /* synthetic */ CompositingStrategy d(int i3) {
        return new CompositingStrategy(i3);
    }

    public static boolean f(int i3, Object obj) {
        return (obj instanceof CompositingStrategy) && i3 == ((CompositingStrategy) obj).j();
    }

    public static final boolean g(int i3, int i4) {
        return i3 == i4;
    }

    public static int h(int i3) {
        return Integer.hashCode(i3);
    }

    public static String i(int i3) {
        return "CompositingStrategy(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f25741a, obj);
    }

    public int hashCode() {
        return h(this.f25741a);
    }

    public final /* synthetic */ int j() {
        return this.f25741a;
    }

    public String toString() {
        return i(this.f25741a);
    }

    public static int e(int i3) {
        return i3;
    }
}
