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
public final class TimePickerLayoutType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f21374b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f21375c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f21376d = c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21377a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return TimePickerLayoutType.f21375c;
        }

        public final int b() {
            return TimePickerLayoutType.f21376d;
        }

        private Companion() {
        }
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof TimePickerLayoutType) && i3 == ((TimePickerLayoutType) obj).h();
    }

    public static final boolean e(int i3, int i4) {
        return i3 == i4;
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        return e(i3, f21375c) ? "Horizontal" : e(i3, f21376d) ? "Vertical" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return d(this.f21377a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f21377a;
    }

    public int hashCode() {
        return f(this.f21377a);
    }

    public String toString() {
        return g(this.f21377a);
    }

    public static int c(int i3) {
        return i3;
    }
}
