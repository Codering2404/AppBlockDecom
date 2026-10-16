package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
public final class ProgressIndicatorDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProgressIndicatorDefaults f19139a = new ProgressIndicatorDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f19144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f19145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f19146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SpringSpec f19147i;

    static {
        ProgressIndicatorTokens progressIndicatorTokens = ProgressIndicatorTokens.f23273a;
        f19140b = progressIndicatorTokens.f();
        StrokeCap.Companion companion = StrokeCap.f25935b;
        f19141c = companion.b();
        f19142d = companion.b();
        f19143e = companion.b();
        f19144f = progressIndicatorTokens.d();
        f19145g = progressIndicatorTokens.b();
        f19146h = progressIndicatorTokens.b();
        f19147i = new SpringSpec(1.0f, 50.0f, Float.valueOf(0.001f));
    }

    private ProgressIndicatorDefaults() {
    }

    public final void a(DrawScope drawScope, float f3, long j3, int i3) {
        float fMin = Math.min(drawScope.M1(f3), Size.g(drawScope.b()));
        float fG = (Size.g(drawScope.b()) - fMin) / 2;
        if (!StrokeCap.g(i3, StrokeCap.f25935b.b())) {
            DrawScope.L1(drawScope, j3, OffsetKt.a((Size.i(drawScope.b()) - fMin) - fG, (Size.g(drawScope.b()) - fMin) / 2.0f), SizeKt.a(fMin, fMin), 0.0f, null, null, 0, 120, null);
        } else {
            float f4 = fMin / 2.0f;
            DrawScope.e2(drawScope, j3, f4, OffsetKt.a((Size.i(drawScope.b()) - f4) - fG, Size.g(drawScope.b()) / 2.0f), 0.0f, null, null, 0, 120, null);
        }
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1803349725, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:847)");
        }
        long jI = ColorSchemeKt.i(ProgressIndicatorTokens.f23273a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final int c() {
        return f19142d;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2143778381, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:864)");
        }
        long jI = ColorSchemeKt.i(ProgressIndicatorTokens.f23273a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final int e() {
        return f19143e;
    }

    public final long f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1947901123, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:868)");
        }
        long j3 = Color.f25715b.j();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return j3;
    }

    public final float g() {
        return f19146h;
    }

    public final float h() {
        return f19140b;
    }

    public final long i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-404222247, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:860)");
        }
        long j3 = Color.f25715b.j();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return j3;
    }

    public final long j(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-914312983, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:843)");
        }
        long jI = ColorSchemeKt.i(ProgressIndicatorTokens.f23273a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float k() {
        return f19145g;
    }

    public final int l() {
        return f19141c;
    }

    public final long m(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1677541593, i3, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:851)");
        }
        long jI = ColorSchemeKt.i(ProgressIndicatorTokens.f23273a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float n() {
        return f19144f;
    }
}
