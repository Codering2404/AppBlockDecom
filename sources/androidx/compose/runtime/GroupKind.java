package androidx.compose.runtime;

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
final class GroupKind {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f23894b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23895c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23896d = d(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23897e = d(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23898a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GroupKind.f23895c;
        }

        public final int b() {
            return GroupKind.f23896d;
        }

        public final int c() {
            return GroupKind.f23897e;
        }

        private Companion() {
        }
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof GroupKind) && i3 == ((GroupKind) obj).h();
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        return "GroupKind(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f23898a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f23898a;
    }

    public int hashCode() {
        return f(this.f23898a);
    }

    public String toString() {
        return g(this.f23898a);
    }

    private static int d(int i3) {
        return i3;
    }
}
