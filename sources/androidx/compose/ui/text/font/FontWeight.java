package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FontWeight implements Comparable<FontWeight> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29233b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FontWeight f29234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FontWeight f29235d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final FontWeight f29236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final FontWeight f29237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final FontWeight f29238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final FontWeight f29239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final FontWeight f29240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final FontWeight f29241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final FontWeight f29242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final FontWeight f29243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final FontWeight f29244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final FontWeight f29245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final FontWeight f29246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final FontWeight f29247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final FontWeight f29248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final FontWeight f29249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final FontWeight f29250t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final FontWeight f29251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final List f29252v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29253a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FontWeight a() {
            return FontWeight.f29251u;
        }

        public final FontWeight b() {
            return FontWeight.f29249s;
        }

        public final FontWeight c() {
            return FontWeight.f29250t;
        }

        public final FontWeight d() {
            return FontWeight.f29244n;
        }

        public final FontWeight e() {
            return FontWeight.f29245o;
        }

        public final FontWeight f() {
            return FontWeight.f29247q;
        }

        public final FontWeight g() {
            return FontWeight.f29246p;
        }

        public final FontWeight h() {
            return FontWeight.f29248r;
        }

        public final FontWeight i() {
            return FontWeight.f29243m;
        }

        public final FontWeight j() {
            return FontWeight.f29237g;
        }

        public final FontWeight k() {
            return FontWeight.f29238h;
        }

        public final FontWeight l() {
            return FontWeight.f29239i;
        }

        private Companion() {
        }
    }

    static {
        FontWeight fontWeight = new FontWeight(100);
        f29234c = fontWeight;
        FontWeight fontWeight2 = new FontWeight(200);
        f29235d = fontWeight2;
        FontWeight fontWeight3 = new FontWeight(300);
        f29236f = fontWeight3;
        FontWeight fontWeight4 = new FontWeight(RCHTTPStatusCodes.BAD_REQUEST);
        f29237g = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(500);
        f29238h = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        f29239i = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD);
        f29240j = fontWeight7;
        FontWeight fontWeight8 = new FontWeight(800);
        f29241k = fontWeight8;
        FontWeight fontWeight9 = new FontWeight(900);
        f29242l = fontWeight9;
        f29243m = fontWeight;
        f29244n = fontWeight2;
        f29245o = fontWeight3;
        f29246p = fontWeight4;
        f29247q = fontWeight5;
        f29248r = fontWeight6;
        f29249s = fontWeight7;
        f29250t = fontWeight8;
        f29251u = fontWeight9;
        f29252v = CollectionsKt.listOf((Object[]) new FontWeight[]{fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9});
    }

    public FontWeight(int i3) {
        this.f29253a = i3;
        boolean z2 = false;
        if (1 <= i3 && i3 < 1001) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.a("Font weight can be in range [1, 1000]. Current value: " + i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontWeight) && this.f29253a == ((FontWeight) obj).f29253a;
    }

    public int hashCode() {
        return this.f29253a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public int compareTo(FontWeight fontWeight) {
        return Intrinsics.compare(this.f29253a, fontWeight.f29253a);
    }

    public final int n() {
        return this.f29253a;
    }

    public String toString() {
        return "FontWeight(weight=" + this.f29253a + ')';
    }
}
