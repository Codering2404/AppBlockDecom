package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import com.applovin.exoplayer2.common.base.Ascii;
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
public final class EncodeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Parcel f6520a = Parcel.obtain();

    public final void a(byte b3) {
        this.f6520a.writeByte(b3);
    }

    public final void b(float f3) {
        this.f6520a.writeFloat(f3);
    }

    public final void c(int i3) {
        this.f6520a.writeInt(i3);
    }

    public final void d(Shadow shadow) {
        m(shadow.c());
        b(Float.intBitsToFloat((int) (shadow.d() >> 32)));
        b(Float.intBitsToFloat((int) (shadow.d() & 4294967295L)));
        b(shadow.b());
    }

    public final void e(SpanStyle spanStyle) {
        long jG = spanStyle.g();
        Color.Companion companion = Color.f25715b;
        if (!Color.t(jG, companion.k())) {
            a((byte) 1);
            m(spanStyle.g());
        }
        long jK = spanStyle.k();
        TextUnit.Companion companion2 = TextUnit.f30006b;
        if (!TextUnit.e(jK, companion2.a())) {
            a((byte) 2);
            j(spanStyle.k());
        }
        FontWeight fontWeightN = spanStyle.n();
        if (fontWeightN != null) {
            a((byte) 3);
            f(fontWeightN);
        }
        FontStyle fontStyleL = spanStyle.l();
        if (fontStyleL != null) {
            int i3 = fontStyleL.i();
            a((byte) 4);
            o(i3);
        }
        FontSynthesis fontSynthesisM = spanStyle.m();
        if (fontSynthesisM != null) {
            int iM = fontSynthesisM.m();
            a((byte) 5);
            l(iM);
        }
        String strJ = spanStyle.j();
        if (strJ != null) {
            a((byte) 6);
            i(strJ);
        }
        if (!TextUnit.e(spanStyle.o(), companion2.a())) {
            a((byte) 7);
            j(spanStyle.o());
        }
        BaselineShift baselineShiftE = spanStyle.e();
        if (baselineShiftE != null) {
            float fJ = baselineShiftE.j();
            a((byte) 8);
            k(fJ);
        }
        TextGeometricTransform textGeometricTransformU = spanStyle.u();
        if (textGeometricTransformU != null) {
            a((byte) 9);
            h(textGeometricTransformU);
        }
        if (!Color.t(spanStyle.d(), companion.k())) {
            a((byte) 10);
            m(spanStyle.d());
        }
        TextDecoration textDecorationS = spanStyle.s();
        if (textDecorationS != null) {
            a(Ascii.VT);
            g(textDecorationS);
        }
        Shadow shadowR = spanStyle.r();
        if (shadowR != null) {
            a(Ascii.FF);
            d(shadowR);
        }
    }

    public final void f(FontWeight fontWeight) {
        c(fontWeight.n());
    }

    public final void g(TextDecoration textDecoration) {
        c(textDecoration.e());
    }

    public final void h(TextGeometricTransform textGeometricTransform) {
        b(textGeometricTransform.b());
        b(textGeometricTransform.c());
    }

    public final void i(String str) {
        this.f6520a.writeString(str);
    }

    public final void j(long j3) {
        long jG = TextUnit.g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        byte b3 = 0;
        if (!TextUnitType.g(jG, companion.c())) {
            if (TextUnitType.g(jG, companion.b())) {
                b3 = 1;
            } else if (TextUnitType.g(jG, companion.a())) {
                b3 = 2;
            }
        }
        a(b3);
        if (TextUnitType.g(TextUnit.g(j3), companion.c())) {
            return;
        }
        b(TextUnit.h(j3));
    }

    public final void k(float f3) {
        b(f3);
    }

    public final void l(int i3) {
        FontSynthesis.Companion companion = FontSynthesis.f29215b;
        byte b3 = 0;
        if (!FontSynthesis.h(i3, companion.b())) {
            if (FontSynthesis.h(i3, companion.a())) {
                b3 = 1;
            } else if (FontSynthesis.h(i3, companion.d())) {
                b3 = 2;
            } else if (FontSynthesis.h(i3, companion.c())) {
                b3 = 3;
            }
        }
        a(b3);
    }

    public final void m(long j3) {
        n(j3);
    }

    public final void n(long j3) {
        this.f6520a.writeLong(j3);
    }

    public final void o(int i3) {
        FontStyle.Companion companion = FontStyle.f29211b;
        byte b3 = 0;
        if (!FontStyle.f(i3, companion.b()) && FontStyle.f(i3, companion.a())) {
            b3 = 1;
        }
        a(b3);
    }

    public final String p() {
        return Base64.encodeToString(this.f6520a.marshall(), 0);
    }

    public final void q() {
        this.f6520a.recycle();
        this.f6520a = Parcel.obtain();
    }
}
