package kotlinx.serialization.json;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JsonConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f142989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f142990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f142991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f142992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f142993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f142994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f142995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f142996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f142997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f142998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f142999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f143000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final JsonNamingStrategy f143001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f143002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f143003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f143004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ClassDiscriminatorMode f143005q;

    public JsonConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String prettyPrintIndent, boolean z8, boolean z9, String classDiscriminator, boolean z10, boolean z11, JsonNamingStrategy jsonNamingStrategy, boolean z12, boolean z13, boolean z14, ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(classDiscriminator, "classDiscriminator");
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "classDiscriminatorMode");
        this.f142989a = z2;
        this.f142990b = z3;
        this.f142991c = z4;
        this.f142992d = z5;
        this.f142993e = z6;
        this.f142994f = z7;
        this.f142995g = prettyPrintIndent;
        this.f142996h = z8;
        this.f142997i = z9;
        this.f142998j = classDiscriminator;
        this.f142999k = z10;
        this.f143000l = z11;
        this.f143001m = jsonNamingStrategy;
        this.f143002n = z12;
        this.f143003o = z13;
        this.f143004p = z14;
        this.f143005q = classDiscriminatorMode;
    }

    public final boolean a() {
        return this.f143004p;
    }

    public final boolean b() {
        return this.f142999k;
    }

    public final boolean c() {
        return this.f142992d;
    }

    public final boolean d() {
        return this.f143003o;
    }

    public final String e() {
        return this.f142998j;
    }

    public final ClassDiscriminatorMode f() {
        return this.f143005q;
    }

    public final boolean g() {
        return this.f142996h;
    }

    public final boolean h() {
        return this.f143002n;
    }

    public final boolean i() {
        return this.f142989a;
    }

    public final boolean j() {
        return this.f142994f;
    }

    public final boolean k() {
        return this.f142990b;
    }

    public final JsonNamingStrategy l() {
        return this.f143001m;
    }

    public final boolean m() {
        return this.f142993e;
    }

    public final String n() {
        return this.f142995g;
    }

    public final boolean o() {
        return this.f143000l;
    }

    public final boolean p() {
        return this.f142997i;
    }

    public final boolean q() {
        return this.f142991c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f142989a + ", ignoreUnknownKeys=" + this.f142990b + ", isLenient=" + this.f142991c + ", allowStructuredMapKeys=" + this.f142992d + ", prettyPrint=" + this.f142993e + ", explicitNulls=" + this.f142994f + ", prettyPrintIndent='" + this.f142995g + "', coerceInputValues=" + this.f142996h + ", useArrayPolymorphism=" + this.f142997i + ", classDiscriminator='" + this.f142998j + "', allowSpecialFloatingPointValues=" + this.f142999k + ", useAlternativeNames=" + this.f143000l + ", namingStrategy=" + this.f143001m + ", decodeEnumsCaseInsensitive=" + this.f143002n + ", allowTrailingComma=" + this.f143003o + ", allowComments=" + this.f143004p + sKeKFMqmvNzY.QHMbzfGPl + this.f143005q + ')';
    }

    public /* synthetic */ JsonConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, boolean z8, boolean z9, String str2, boolean z10, boolean z11, JsonNamingStrategy jsonNamingStrategy, boolean z12, boolean z13, boolean z14, ClassDiscriminatorMode classDiscriminatorMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6, (i3 & 32) != 0 ? true : z7, (i3 & 64) != 0 ? "    " : str, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z8, (i3 & Function.MAX_NARGS) != 0 ? false : z9, (i3 & 512) != 0 ? "type" : str2, (i3 & 1024) != 0 ? false : z10, (i3 & 2048) == 0 ? z11 : true, (i3 & 4096) != 0 ? null : jsonNamingStrategy, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z12, (i3 & 16384) != 0 ? false : z13, (i3 & 32768) != 0 ? false : z14, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? ClassDiscriminatorMode.f142951c : classDiscriminatorMode);
    }
}
