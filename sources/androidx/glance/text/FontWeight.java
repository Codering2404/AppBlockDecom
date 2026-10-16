package androidx.glance.text;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class FontWeight {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39746b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f39747c = e(RCHTTPStatusCodes.BAD_REQUEST);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f39748d = e(500);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f39749e = e(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39750a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return FontWeight.f39749e;
        }

        public final int b() {
            return FontWeight.f39748d;
        }

        public final int c() {
            return FontWeight.f39747c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FontWeight(int i3) {
        this.f39750a = i3;
    }

    public static final /* synthetic */ FontWeight d(int i3) {
        return new FontWeight(i3);
    }

    public static boolean f(int i3, Object obj) {
        return (obj instanceof FontWeight) && i3 == ((FontWeight) obj).j();
    }

    public static final boolean g(int i3, int i4) {
        return i3 == i4;
    }

    public static int h(int i3) {
        return Integer.hashCode(i3);
    }

    public static String i(int i3) {
        return "FontWeight(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f39750a, obj);
    }

    public int hashCode() {
        return h(this.f39750a);
    }

    public final /* synthetic */ int j() {
        return this.f39750a;
    }

    public String toString() {
        return i(this.f39750a);
    }

    private static int e(int i3) {
        return i3;
    }
}
