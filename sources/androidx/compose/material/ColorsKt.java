package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class ColorsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f12486a = CompositionLocalKt.g(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Colors invoke() {
            return ColorsKt.f(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4095, null);
        }
    });

    public static final long a(Colors colors, long j3) {
        return Color.t(j3, colors.j()) ? colors.g() : Color.t(j3, colors.k()) ? colors.g() : Color.t(j3, colors.l()) ? colors.h() : Color.t(j3, colors.m()) ? colors.h() : Color.t(j3, colors.c()) ? colors.e() : Color.t(j3, colors.n()) ? colors.i() : Color.t(j3, colors.d()) ? colors.f() : Color.f25715b.k();
    }

    public static final long b(long j3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(441849991, i3, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        composer.a0(-702395103);
        long jA = a(MaterialTheme.f13091a.a(composer, 6), j3);
        if (jA == 16) {
            jA = ((Color) composer.q(ContentColorKt.a())).B();
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jA;
    }

    public static final ProvidableCompositionLocal c() {
        return f12486a;
    }

    public static final long d(Colors colors) {
        return colors.o() ? colors.j() : colors.n();
    }

    public static final Colors e(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        return new Colors(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, true, null);
    }

    public static /* synthetic */ Colors f(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i3, Object obj) {
        long jD = (i3 & 1) != 0 ? ColorKt.d(4284612846L) : j3;
        long jD2 = (i3 & 2) != 0 ? ColorKt.d(4281794739L) : j4;
        long jD3 = (i3 & 4) != 0 ? ColorKt.d(4278442694L) : j5;
        long jD4 = (i3 & 8) != 0 ? ColorKt.d(4278290310L) : j6;
        long jL = (i3 & 16) != 0 ? Color.f25715b.l() : j7;
        long jL2 = (i3 & 32) != 0 ? Color.f25715b.l() : j8;
        long jD5 = (i3 & 64) != 0 ? ColorKt.d(4289724448L) : j9;
        long jL3 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Color.f25715b.l() : j10;
        long j15 = jD;
        long jA = (i3 & Function.MAX_NARGS) != 0 ? Color.f25715b.a() : j11;
        long jA2 = (i3 & 512) != 0 ? Color.f25715b.a() : j12;
        long jA3 = (i3 & 1024) != 0 ? Color.f25715b.a() : j13;
        if ((i3 & 2048) != 0) {
            j14 = Color.f25715b.l();
        }
        return e(j15, jD2, jD3, jD4, jL, jL2, jD5, jL3, jA, jA2, jA3, j14);
    }

    public static final void g(Colors colors, Colors colors2) {
        colors.x(colors2.j());
        colors.y(colors2.k());
        colors.z(colors2.l());
        colors.A(colors2.m());
        colors.p(colors2.c());
        colors.B(colors2.n());
        colors.q(colors2.d());
        colors.u(colors2.g());
        colors.v(colors2.h());
        colors.s(colors2.e());
        colors.w(colors2.i());
        colors.t(colors2.f());
        colors.r(colors2.o());
    }
}
