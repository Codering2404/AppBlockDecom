package androidx.compose.material3;

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
public final class NavigationItemIconPosition {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f18713b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f18714c = b(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f18715d = b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18716a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return NavigationItemIconPosition.f18714c;
        }

        private Companion() {
        }
    }

    public static boolean c(int i3, Object obj) {
        return (obj instanceof NavigationItemIconPosition) && i3 == ((NavigationItemIconPosition) obj).g();
    }

    public static final boolean d(int i3, int i4) {
        return i3 == i4;
    }

    public static int e(int i3) {
        return Integer.hashCode(i3);
    }

    public static String f(int i3) {
        return d(i3, f18714c) ? "Top" : d(i3, f18715d) ? "Start" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return c(this.f18716a, obj);
    }

    public final /* synthetic */ int g() {
        return this.f18716a;
    }

    public int hashCode() {
        return e(this.f18716a);
    }

    public String toString() {
        return f(this.f18716a);
    }

    private static int b(int i3) {
        return i3;
    }
}
