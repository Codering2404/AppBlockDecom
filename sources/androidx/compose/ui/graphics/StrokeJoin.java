package androidx.compose.ui.graphics;

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
public final class StrokeJoin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25940b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25941c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25942d = e(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25943e = e(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25944a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return StrokeJoin.f25943e;
        }

        public final int b() {
            return StrokeJoin.f25941c;
        }

        public final int c() {
            return StrokeJoin.f25942d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ StrokeJoin(int i3) {
        this.f25944a = i3;
    }

    public static final /* synthetic */ StrokeJoin d(int i3) {
        return new StrokeJoin(i3);
    }

    public static boolean f(int i3, Object obj) {
        return (obj instanceof StrokeJoin) && i3 == ((StrokeJoin) obj).j();
    }

    public static final boolean g(int i3, int i4) {
        return i3 == i4;
    }

    public static int h(int i3) {
        return Integer.hashCode(i3);
    }

    public static String i(int i3) {
        return g(i3, f25941c) ? "Miter" : g(i3, f25942d) ? "Round" : g(i3, f25943e) ? "Bevel" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return f(this.f25944a, obj);
    }

    public int hashCode() {
        return h(this.f25944a);
    }

    public final /* synthetic */ int j() {
        return this.f25944a;
    }

    public String toString() {
        return i(this.f25944a);
    }

    public static int e(int i3) {
        return i3;
    }
}
