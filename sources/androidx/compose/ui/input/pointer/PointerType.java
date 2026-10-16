package androidx.compose.ui.input.pointer;

import com.facebook.internal.AnalyticsEvents;
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
public final class PointerType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f26922b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26923c = f(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26924d = f(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f26925e = f(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26926f = f(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f26927g = f(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26928a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PointerType.f26927g;
        }

        public final int b() {
            return PointerType.f26925e;
        }

        public final int c() {
            return PointerType.f26926f;
        }

        public final int d() {
            return PointerType.f26924d;
        }

        public final int e() {
            return PointerType.f26923c;
        }

        private Companion() {
        }
    }

    public static boolean g(int i3, Object obj) {
        return (obj instanceof PointerType) && i3 == ((PointerType) obj).k();
    }

    public static final boolean h(int i3, int i4) {
        return i3 == i4;
    }

    public static int i(int i3) {
        return Integer.hashCode(i3);
    }

    public static String j(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    public boolean equals(Object obj) {
        return g(this.f26928a, obj);
    }

    public int hashCode() {
        return i(this.f26928a);
    }

    public final /* synthetic */ int k() {
        return this.f26928a;
    }

    public String toString() {
        return j(this.f26928a);
    }

    private static int f(int i3) {
        return i3;
    }
}
