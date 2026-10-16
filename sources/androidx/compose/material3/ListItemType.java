package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class ListItemType implements Comparable<ListItemType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f18104b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f18105c = f(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f18106d = f(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18107f = f(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18108a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ListItemType.f18105c;
        }

        public final int b() {
            return ListItemType.f18107f;
        }

        public final int c() {
            return ListItemType.f18106d;
        }

        public final int d(boolean z2, boolean z3, boolean z4) {
            return ((z2 && z3) || z4) ? b() : (z2 || z3) ? c() : a();
        }

        private Companion() {
        }
    }

    public static int e(int i3, int i4) {
        return Intrinsics.compare(i3, i4);
    }

    public static boolean g(int i3, Object obj) {
        return (obj instanceof ListItemType) && i3 == ((ListItemType) obj).k();
    }

    public static final boolean h(int i3, int i4) {
        return i3 == i4;
    }

    public static int i(int i3) {
        return Integer.hashCode(i3);
    }

    public static String j(int i3) {
        return "ListItemType(lines=" + i3 + ')';
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType listItemType) {
        return d(listItemType.k());
    }

    public int d(int i3) {
        return e(this.f18108a, i3);
    }

    public boolean equals(Object obj) {
        return g(this.f18108a, obj);
    }

    public int hashCode() {
        return i(this.f18108a);
    }

    public final /* synthetic */ int k() {
        return this.f18108a;
    }

    public String toString() {
        return j(this.f18108a);
    }

    private static int f(int i3) {
        return i3;
    }
}
