package androidx.compose.ui.text.style;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class TextOverflow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29661b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29662c = f(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29663d = f(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29664e = f(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29665f = f(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29666g = f(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29667a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TextOverflow.f29662c;
        }

        public final int b() {
            return TextOverflow.f29663d;
        }

        public final int c() {
            return TextOverflow.f29666g;
        }

        public final int d() {
            return TextOverflow.f29665f;
        }

        public final int e() {
            return TextOverflow.f29664e;
        }

        private Companion() {
        }
    }

    public static boolean g(int i3, Object obj) {
        return (obj instanceof TextOverflow) && i3 == ((TextOverflow) obj).k();
    }

    public static final boolean h(int i3, int i4) {
        return i3 == i4;
    }

    public static int i(int i3) {
        return Integer.hashCode(i3);
    }

    public static String j(int i3) {
        return h(i3, f29662c) ? "Clip" : h(i3, f29663d) ? "Ellipsis" : h(i3, f29666g) ? "MiddleEllipsis" : h(i3, f29664e) ? "Visible" : h(i3, f29665f) ? "StartEllipsis" : "Invalid";
    }

    public boolean equals(Object obj) {
        return g(this.f29667a, obj);
    }

    public int hashCode() {
        return i(this.f29667a);
    }

    public final /* synthetic */ int k() {
        return this.f29667a;
    }

    public String toString() {
        return j(this.f29667a);
    }

    public static int f(int i3) {
        return i3;
    }
}
