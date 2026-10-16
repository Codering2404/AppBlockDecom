package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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
public final class XmlVectorParser_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f26610a = 0;

    public static final ImageVector.Builder a(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) throws XmlPullParserException {
        long jK;
        int iZ;
        ColorStateList colorStateListE;
        AndroidVectorResources androidVectorResources = AndroidVectorResources.f26584a;
        TypedArray typedArrayK = androidVectorParser.k(resources, theme, attributeSet, androidVectorResources.F());
        boolean zD = androidVectorParser.d(typedArrayK, "autoMirrored", androidVectorResources.a(), false);
        float fG = androidVectorParser.g(typedArrayK, "viewportWidth", androidVectorResources.H(), 0.0f);
        float fG2 = androidVectorParser.g(typedArrayK, "viewportHeight", androidVectorResources.G(), 0.0f);
        if (fG <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (fG2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float fA = androidVectorParser.a(typedArrayK, androidVectorResources.I(), 0.0f);
        float fA2 = androidVectorParser.a(typedArrayK, androidVectorResources.n(), 0.0f);
        if (typedArrayK.hasValue(androidVectorResources.D())) {
            TypedValue typedValue = new TypedValue();
            typedArrayK.getValue(androidVectorResources.D(), typedValue);
            jK = (typedValue.type == 2 || (colorStateListE = androidVectorParser.e(typedArrayK, theme, "tint", androidVectorResources.D())) == null) ? Color.f25715b.k() : ColorKt.b(colorStateListE.getDefaultColor());
        } else {
            jK = Color.f25715b.k();
        }
        long j3 = jK;
        int iC = androidVectorParser.c(typedArrayK, androidVectorResources.E(), -1);
        if (iC == -1) {
            iZ = BlendMode.f25667b.z();
        } else if (iC == 3) {
            iZ = BlendMode.f25667b.B();
        } else if (iC == 5) {
            iZ = BlendMode.f25667b.z();
        } else if (iC != 9) {
            switch (iC) {
                case 14:
                    iZ = BlendMode.f25667b.q();
                    break;
                case 15:
                    iZ = BlendMode.f25667b.v();
                    break;
                case 16:
                    iZ = BlendMode.f25667b.t();
                    break;
                default:
                    iZ = BlendMode.f25667b.z();
                    break;
            }
        } else {
            iZ = BlendMode.f25667b.y();
        }
        int i3 = iZ;
        float fG3 = Dp.g(fA / resources.getDisplayMetrics().density);
        float fG4 = Dp.g(fA2 / resources.getDisplayMetrics().density);
        typedArrayK.recycle();
        return new ImageVector.Builder(null, fG3, fG4, fG, fG2, j3, i3, zD, 1, null);
    }

    private static final int b(int i3, int i4) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i4 : StrokeCap.f25935b.c() : StrokeCap.f25935b.b() : StrokeCap.f25935b.a();
    }

    private static final int c(int i3, int i4) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i4 : StrokeJoin.f25940b.a() : StrokeJoin.f25940b.c() : StrokeJoin.f25940b.b();
    }

    public static final boolean d(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1 || (xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3);
    }

    private static final Brush e(ComplexColorCompat complexColorCompat) {
        if (!complexColorCompat.l()) {
            return null;
        }
        Shader shaderF = complexColorCompat.f();
        return shaderF != null ? BrushKt.a(shaderF) : new SolidColor(ColorKt.b(complexColorCompat.e()), null);
    }

    public static final void f(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorResources androidVectorResources = AndroidVectorResources.f26584a;
        TypedArray typedArrayK = androidVectorParser.k(resources, theme, attributeSet, androidVectorResources.b());
        String strI = androidVectorParser.i(typedArrayK, androidVectorResources.c());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = androidVectorParser.i(typedArrayK, androidVectorResources.d());
        List listE = strI2 == null ? VectorKt.e() : PathParser.c(androidVectorParser.f26583c, strI2, null, 2, null);
        typedArrayK.recycle();
        ImageVector.Builder.b(builder, str, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, listE, 254, null);
    }

    public static final int g(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i3) throws XmlPullParserException {
        int eventType = androidVectorParser.j().getEventType();
        if (eventType != 2) {
            if (eventType != 3 || !Intrinsics.areEqual("group", androidVectorParser.j().getName())) {
                return i3;
            }
            int i4 = i3 + 1;
            for (int i5 = 0; i5 < i4; i5++) {
                builder.g();
            }
            return 0;
        }
        String name = androidVectorParser.j().getName();
        if (name == null) {
            return i3;
        }
        int iHashCode = name.hashCode();
        if (iHashCode == -1649314686) {
            if (!name.equals("clip-path")) {
                return i3;
            }
            f(androidVectorParser, resources, theme, attributeSet, builder);
            return i3 + 1;
        }
        if (iHashCode == 3433509) {
            if (!name.equals("path")) {
                return i3;
            }
            i(androidVectorParser, resources, theme, attributeSet, builder);
            return i3;
        }
        if (iHashCode != 98629247 || !name.equals("group")) {
            return i3;
        }
        h(androidVectorParser, resources, theme, attributeSet, builder);
        return i3;
    }

    public static final void h(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorResources androidVectorResources = AndroidVectorResources.f26584a;
        TypedArray typedArrayK = androidVectorParser.k(resources, theme, attributeSet, androidVectorResources.e());
        float fG = androidVectorParser.g(typedArrayK, "rotation", androidVectorResources.i(), 0.0f);
        float fB = androidVectorParser.b(typedArrayK, androidVectorResources.g(), 0.0f);
        float fB2 = androidVectorParser.b(typedArrayK, androidVectorResources.h(), 0.0f);
        float fG2 = androidVectorParser.g(typedArrayK, "scaleX", androidVectorResources.j(), 1.0f);
        float fG3 = androidVectorParser.g(typedArrayK, "scaleY", androidVectorResources.k(), 1.0f);
        float fG4 = androidVectorParser.g(typedArrayK, "translateX", androidVectorResources.l(), 0.0f);
        float fG5 = androidVectorParser.g(typedArrayK, "translateY", androidVectorResources.m(), 0.0f);
        String strI = androidVectorParser.i(typedArrayK, androidVectorResources.f());
        if (strI == null) {
            strI = "";
        }
        typedArrayK.recycle();
        builder.a(strI, fG, fB, fB2, fG2, fG3, fG4, fG5, VectorKt.e());
    }

    public static final void i(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorResources androidVectorResources = AndroidVectorResources.f26584a;
        TypedArray typedArrayK = androidVectorParser.k(resources, theme, attributeSet, androidVectorResources.o());
        if (!TypedArrayUtils.p(androidVectorParser.j(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String strI = androidVectorParser.i(typedArrayK, androidVectorResources.r());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = androidVectorParser.i(typedArrayK, androidVectorResources.s());
        List listE = strI2 == null ? VectorKt.e() : PathParser.c(androidVectorParser.f26583c, strI2, null, 2, null);
        ComplexColorCompat complexColorCompatF = androidVectorParser.f(typedArrayK, theme, "fillColor", androidVectorResources.q(), 0);
        float fG = androidVectorParser.g(typedArrayK, "fillAlpha", androidVectorResources.p(), 1.0f);
        int iB = b(androidVectorParser.h(typedArrayK, "strokeLineCap", androidVectorResources.v(), -1), StrokeCap.f25935b.a());
        int iC = c(androidVectorParser.h(typedArrayK, "strokeLineJoin", androidVectorResources.w(), -1), StrokeJoin.f25940b.a());
        float fG2 = androidVectorParser.g(typedArrayK, "strokeMiterLimit", androidVectorResources.x(), 1.0f);
        ComplexColorCompat complexColorCompatF2 = androidVectorParser.f(typedArrayK, theme, "strokeColor", androidVectorResources.u(), 0);
        float fG3 = androidVectorParser.g(typedArrayK, "strokeAlpha", androidVectorResources.t(), 1.0f);
        float fG4 = androidVectorParser.g(typedArrayK, "strokeWidth", androidVectorResources.y(), 1.0f);
        float fG5 = androidVectorParser.g(typedArrayK, "trimPathEnd", androidVectorResources.z(), 1.0f);
        float fG6 = androidVectorParser.g(typedArrayK, "trimPathOffset", androidVectorResources.B(), 0.0f);
        float fG7 = androidVectorParser.g(typedArrayK, "trimPathStart", androidVectorResources.C(), 0.0f);
        int iH = androidVectorParser.h(typedArrayK, "fillType", androidVectorResources.A(), f26610a);
        typedArrayK.recycle();
        builder.c(listE, iH == 0 ? PathFillType.f25834b.b() : PathFillType.f25834b.a(), str, e(complexColorCompatF), fG, e(complexColorCompatF2), fG3, fG4, iB, iC, fG2, fG7, fG5, fG6);
    }

    public static final XmlPullParser j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
