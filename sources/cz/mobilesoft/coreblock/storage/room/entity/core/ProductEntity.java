package cz.mobilesoft.coreblock.storage.room.entity.core;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProductEntity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f126579q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f126580r = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f126582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f126583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f126584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f126585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f126586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Double f126587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f126588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Double f126589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f126590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f126591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f126592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f126593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f126594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f126595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Long f126596p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ProductEntity(String productId, String revenueCatId, String str, String str2, boolean z2, String str3, Double d3, String str4, Double d4, String str5, boolean z3, int i3, String str6, String str7, boolean z4, Long l3) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(revenueCatId, "revenueCatId");
        this.f126581a = productId;
        this.f126582b = revenueCatId;
        this.f126583c = str;
        this.f126584d = str2;
        this.f126585e = z2;
        this.f126586f = str3;
        this.f126587g = d3;
        this.f126588h = str4;
        this.f126589i = d4;
        this.f126590j = str5;
        this.f126591k = z3;
        this.f126592l = i3;
        this.f126593m = str6;
        this.f126594n = str7;
        this.f126595o = z4;
        this.f126596p = l3;
    }

    public final String a() {
        return this.f126586f;
    }

    public final Long b() {
        return this.f126596p;
    }

    public final String c() {
        return this.f126584d;
    }

    public final String d() {
        return this.f126590j;
    }

    public final Double e() {
        return this.f126589i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductEntity)) {
            return false;
        }
        ProductEntity productEntity = (ProductEntity) obj;
        return Intrinsics.areEqual(this.f126581a, productEntity.f126581a) && Intrinsics.areEqual(this.f126582b, productEntity.f126582b) && Intrinsics.areEqual(this.f126583c, productEntity.f126583c) && Intrinsics.areEqual(this.f126584d, productEntity.f126584d) && this.f126585e == productEntity.f126585e && Intrinsics.areEqual(this.f126586f, productEntity.f126586f) && Intrinsics.areEqual((Object) this.f126587g, (Object) productEntity.f126587g) && Intrinsics.areEqual(this.f126588h, productEntity.f126588h) && Intrinsics.areEqual((Object) this.f126589i, (Object) productEntity.f126589i) && Intrinsics.areEqual(this.f126590j, productEntity.f126590j) && this.f126591k == productEntity.f126591k && this.f126592l == productEntity.f126592l && Intrinsics.areEqual(this.f126593m, productEntity.f126593m) && Intrinsics.areEqual(this.f126594n, productEntity.f126594n) && this.f126595o == productEntity.f126595o && Intrinsics.areEqual(this.f126596p, productEntity.f126596p);
    }

    public final int f() {
        return this.f126592l;
    }

    public final String g() {
        return this.f126588h;
    }

    public final Double h() {
        return this.f126587g;
    }

    public int hashCode() {
        int iHashCode = ((this.f126581a.hashCode() * 31) + this.f126582b.hashCode()) * 31;
        String str = this.f126583c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f126584d;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.f126585e)) * 31;
        String str3 = this.f126586f;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d3 = this.f126587g;
        int iHashCode5 = (iHashCode4 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str4 = this.f126588h;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d4 = this.f126589i;
        int iHashCode7 = (iHashCode6 + (d4 == null ? 0 : d4.hashCode())) * 31;
        String str5 = this.f126590j;
        int iHashCode8 = (((((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.f126591k)) * 31) + Integer.hashCode(this.f126592l)) * 31;
        String str6 = this.f126593m;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f126594n;
        int iHashCode10 = (((iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31) + Boolean.hashCode(this.f126595o)) * 31;
        Long l3 = this.f126596p;
        return iHashCode10 + (l3 != null ? l3.hashCode() : 0);
    }

    public final String i() {
        return this.f126581a;
    }

    public final String j() {
        return this.f126593m;
    }

    public final String k() {
        return this.f126582b;
    }

    public final String l() {
        return this.f126583c;
    }

    public final String m() {
        return this.f126594n;
    }

    public final boolean n() {
        return this.f126591k;
    }

    public final boolean o() {
        return this.f126595o;
    }

    public final boolean p() {
        return this.f126585e;
    }

    public String toString() {
        return "ProductEntity(productId=" + this.f126581a + ", revenueCatId=" + this.f126582b + ", title=" + this.f126583c + ", description=" + this.f126584d + ", isSubscription=" + this.f126585e + ", currency=" + this.f126586f + ", priceValue=" + this.f126587g + ", priceText=" + this.f126588h + ", introductoryPriceValue=" + this.f126589i + ", introductoryPriceText=" + this.f126590j + ", isActive=" + this.f126591k + ", orderInList=" + this.f126592l + ", purchaseToken=" + this.f126593m + ", trialPeriod=" + this.f126594n + ", isLifeTime=" + this.f126595o + ", deactivationTimeInMillis=" + this.f126596p + ")";
    }

    public /* synthetic */ ProductEntity(String str, String str2, String str3, String str4, boolean z2, String str5, Double d3, String str6, Double d4, String str7, boolean z3, int i3, String str8, String str9, boolean z4, Long l3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? null : str5, (i4 & 64) != 0 ? null : d3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str6, (i4 & Function.MAX_NARGS) != 0 ? null : d4, (i4 & 512) != 0 ? null : str7, (i4 & 1024) != 0 ? false : z3, (i4 & 2048) != 0 ? 99 : i3, (i4 & 4096) != 0 ? null : str8, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str9, (i4 & 16384) != 0 ? false : z4, (i4 & 32768) != 0 ? null : l3);
    }
}
