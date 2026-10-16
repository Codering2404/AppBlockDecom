package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
public final class ButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ButtonDefaults f12323a = new ButtonDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f12324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PaddingValues f12326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f12327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f12328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f12329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f12330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f12331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f12332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final PaddingValues f12333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12334l = 0;

    static {
        float fG = Dp.g(16);
        f12324b = fG;
        float f3 = 8;
        float fG2 = Dp.g(f3);
        f12325c = fG2;
        PaddingValues paddingValuesD = PaddingKt.d(fG, fG2, fG, fG2);
        f12326d = paddingValuesD;
        f12327e = Dp.g(64);
        f12328f = Dp.g(36);
        f12329g = Dp.g(18);
        f12330h = Dp.g(f3);
        f12331i = Dp.g(1);
        float fG3 = Dp.g(f3);
        f12332j = fG3;
        f12333k = PaddingKt.d(fG3, paddingValuesD.d(), fG3, paddingValuesD.a());
    }

    private ButtonDefaults() {
    }

    public final ButtonColors a(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        long jH;
        long j7 = (i4 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).j() : j3;
        long jB = (i4 & 2) != 0 ? ColorsKt.b(j7, composer, i3 & 14) : j4;
        if ((i4 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            jH = ColorKt.h(Color.r(materialTheme.a(composer, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.a(composer, 6).n());
        } else {
            jH = j5;
        }
        long jR = (i4 & 8) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.M()) {
            ComposerKt.U(1870371134, i3, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:413)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j7, jB, jH, jR, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultButtonColors;
    }

    public final ButtonElevation b(float f3, float f4, float f5, float f6, float f7, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = Dp.g(2);
        }
        float f8 = f3;
        if ((i4 & 2) != 0) {
            f4 = Dp.g(8);
        }
        float f9 = f4;
        if ((i4 & 4) != 0) {
            f5 = Dp.g(0);
        }
        float f10 = f5;
        if ((i4 & 8) != 0) {
            f6 = Dp.g(4);
        }
        float f11 = f6;
        if ((i4 & 16) != 0) {
            f7 = Dp.g(4);
        }
        float f12 = f7;
        if (ComposerKt.M()) {
            ComposerKt.U(-737170518, i3, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:378)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.c(f8)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.c(f9)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.c(f10)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.c(f11)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.c(f12)) || (i3 & 24576) == 16384);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            DefaultButtonElevation defaultButtonElevation = new DefaultButtonElevation(f8, f9, f10, f11, f12, null);
            composer.w(defaultButtonElevation);
            objG = defaultButtonElevation;
        }
        DefaultButtonElevation defaultButtonElevation2 = (DefaultButtonElevation) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultButtonElevation2;
    }

    public final PaddingValues c() {
        return f12326d;
    }

    public final float d() {
        return f12328f;
    }

    public final float e() {
        return f12327e;
    }

    public final PaddingValues f() {
        return f12333k;
    }

    public final ButtonColors g(long j3, long j4, long j5, Composer composer, int i3, int i4) {
        long j6 = (i4 & 1) != 0 ? Color.f25715b.j() : j3;
        long j7 = (i4 & 2) != 0 ? MaterialTheme.f13091a.a(composer, 6).j() : j4;
        long jR = (i4 & 4) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.M()) {
            ComposerKt.U(182742216, i3, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:455)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j6, j7, j6, jR, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultButtonColors;
    }
}
