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
public final class PointerEventType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f26835b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26836c = h(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26837d = h(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f26838e = h(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26839f = h(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f26840g = h(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26841h = h(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f26842i = h(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26843a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return PointerEventType.f26840g;
        }

        public final int b() {
            return PointerEventType.f26841h;
        }

        public final int c() {
            return PointerEventType.f26839f;
        }

        public final int d() {
            return PointerEventType.f26837d;
        }

        public final int e() {
            return PointerEventType.f26838e;
        }

        public final int f() {
            return PointerEventType.f26842i;
        }

        public final int g() {
            return PointerEventType.f26836c;
        }

        private Companion() {
        }
    }

    public static boolean i(int i3, Object obj) {
        return (obj instanceof PointerEventType) && i3 == ((PointerEventType) obj).m();
    }

    public static final boolean j(int i3, int i4) {
        return i3 == i4;
    }

    public static int k(int i3) {
        return Integer.hashCode(i3);
    }

    public static String l(int i3) {
        return j(i3, f26837d) ? "Press" : j(i3, f26838e) ? "Release" : j(i3, f26839f) ? "Move" : j(i3, f26840g) ? "Enter" : j(i3, f26841h) ? "Exit" : j(i3, f26842i) ? "Scroll" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return i(this.f26843a, obj);
    }

    public int hashCode() {
        return k(this.f26843a);
    }

    public final /* synthetic */ int m() {
        return this.f26843a;
    }

    public String toString() {
        return l(this.f26843a);
    }

    private static int h(int i3) {
        return i3;
    }
}
