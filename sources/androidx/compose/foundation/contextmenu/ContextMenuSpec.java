package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ContextMenuSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContextMenuSpec f5269a = new ContextMenuSpec();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f5270b = Dp.g(112);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f5271c = Dp.g(280);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f5272d = Dp.g(48);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f5273e = Dp.g(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f5274f = Dp.g(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Alignment.Vertical f5275g = Alignment.f25072a.i();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f5276h = TextAlign.f29616b.f();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f5277i = Dp.g(12);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f5278j = Dp.g(8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f5279k = Dp.g(24);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f5280l = TextUnitKt.i(14);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final FontWeight f5281m = FontWeight.f29233b.f();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f5282n = TextUnitKt.i(20);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f5283o = TextUnitKt.h(0.1f);

    private ContextMenuSpec() {
    }

    public final float a() {
        return f5271c;
    }

    public final float b() {
        return f5270b;
    }

    public final float c() {
        return f5274f;
    }

    public final float d() {
        return f5277i;
    }

    public final float e() {
        return f5279k;
    }

    public final Alignment.Vertical f() {
        return f5275g;
    }

    public final float g() {
        return f5272d;
    }

    public final float h() {
        return f5273e;
    }

    public final float i() {
        return f5278j;
    }

    public final TextStyle j(long j3) {
        int i3 = f5276h;
        return new TextStyle(j3, f5280l, f5281m, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, f5283o, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, i3, 0, f5282n, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613240, (DefaultConstructorMarker) null);
    }
}
