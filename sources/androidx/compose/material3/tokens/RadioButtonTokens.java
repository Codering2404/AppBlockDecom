package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RadioButtonTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RadioButtonTokens f23285a = new RadioButtonTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f23297m;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        f23286b = colorSchemeKeyTokens;
        f23287c = colorSchemeKeyTokens;
        f23288d = Dp.g((float) 20.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        f23289e = colorSchemeKeyTokens2;
        f23290f = colorSchemeKeyTokens2;
        f23291g = colorSchemeKeyTokens2;
        f23292h = colorSchemeKeyTokens2;
        f23293i = Dp.g((float) 40.0d);
        f23294j = colorSchemeKeyTokens;
        f23295k = colorSchemeKeyTokens;
        f23296l = ColorSchemeKeyTokens.OnSurfaceVariant;
        f23297m = colorSchemeKeyTokens;
    }

    private RadioButtonTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f23286b;
    }

    public final ColorSchemeKeyTokens b() {
        return f23287c;
    }

    public final float c() {
        return f23288d;
    }

    public final ColorSchemeKeyTokens d() {
        return f23291g;
    }

    public final float e() {
        return f23293i;
    }

    public final ColorSchemeKeyTokens f() {
        return f23296l;
    }
}
