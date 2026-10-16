package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import androidx.appcompat.app.jE.vxrlPPpdv;
import com.caverock.androidsvg.CSSParser;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SVG {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static SVGExternalFileResolver f67427g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f67428h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Svg f67429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f67430b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f67431c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f67432d = 96.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CSSParser.Ruleset f67433e = new CSSParser.Ruleset();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f67434f = new HashMap();

    /* JADX INFO: renamed from: com.caverock.androidsvg.SVG$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67435a;

        static {
            int[] iArr = new int[Unit.values().length];
            f67435a = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67435a[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67435a[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67435a[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67435a[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67435a[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f67435a[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f67435a[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f67435a[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CSSClipRect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Length f67440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Length f67441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Length f67442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Length f67443d;

        CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.f67440a = length;
            this.f67441b = length2;
            this.f67442c = length3;
            this.f67443d = length4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Circle extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67444o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67445p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67446q;

        Circle() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "circle";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ClipPath extends Group implements NotDirectlyRendered {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Boolean f67447p;

        ClipPath() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "clipPath";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Colour extends SvgPaint {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Colour f67448b = new Colour(-16777216);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Colour f67449c = new Colour(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f67450a;

        Colour(int i3) {
            this.f67450a = i3;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.f67450a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CurrentColor extends SvgPaint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static CurrentColor f67451a = new CurrentColor();

        private CurrentColor() {
        }

        static CurrentColor a() {
            return f67451a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Defs extends Group implements NotDirectlyRendered {
        Defs() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "defs";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Ellipse extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67452o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67453p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67454q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67455r;

        Ellipse() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "ellipse";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class GradientElement extends SvgElementBase implements SvgContainer {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        List f67456h = new ArrayList();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Boolean f67457i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Matrix f67458j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        GradientSpread f67459k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f67460l;

        GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List getChildren() {
            return this.f67456h;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void h(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof Stop) {
                this.f67456h.add(svgObject);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + svgObject + " elements.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Matrix f67465n;

        GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void k(Matrix matrix) {
            this.f67465n = matrix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Group extends SvgConditionalContainer implements HasTransform {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Matrix f67466o;

        Group() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void k(Matrix matrix) {
            this.f67466o = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "group";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface HasTransform {
        void k(Matrix matrix);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f67467p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67468q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67469r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67470s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67471t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Matrix f67472u;

        Image() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void k(Matrix matrix) {
            this.f67472u = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "image";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Line extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67475o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67476p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67477q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67478r;

        Line() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "line";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f67479q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67480r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67481s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67482t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Length f67483u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Float f67484v;

        Marker() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "marker";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f67485o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Boolean f67486p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67487q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67488r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67489s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67490t;

        Mask() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "mask";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface NotDirectlyRendered {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PaintReference extends SvgPaint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f67491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SvgPaint f67492b;

        PaintReference(String str, SvgPaint svgPaint) {
            this.f67491a = str;
            this.f67492b = svgPaint;
        }

        public String toString() {
            return this.f67491a + " " + this.f67492b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Path extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        PathDefinition f67493o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Float f67494p;

        Path() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "path";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PathDefinition implements PathInterface {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f67496b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f67498d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f67495a = new byte[8];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float[] f67497c = new float[16];

        PathDefinition() {
        }

        private void f(byte b3) {
            int i3 = this.f67496b;
            byte[] bArr = this.f67495a;
            if (i3 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f67495a = bArr2;
            }
            byte[] bArr3 = this.f67495a;
            int i4 = this.f67496b;
            this.f67496b = i4 + 1;
            bArr3[i4] = b3;
        }

        private void g(int i3) {
            float[] fArr = this.f67497c;
            if (fArr.length < this.f67498d + i3) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f67497c = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void a(float f3, float f4) {
            f((byte) 0);
            g(2);
            float[] fArr = this.f67497c;
            int i3 = this.f67498d;
            int i4 = i3 + 1;
            this.f67498d = i4;
            fArr[i3] = f3;
            this.f67498d = i3 + 2;
            fArr[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            f((byte) 2);
            g(6);
            float[] fArr = this.f67497c;
            int i3 = this.f67498d;
            int i4 = i3 + 1;
            this.f67498d = i4;
            fArr[i3] = f3;
            int i5 = i3 + 2;
            this.f67498d = i5;
            fArr[i4] = f4;
            int i6 = i3 + 3;
            this.f67498d = i6;
            fArr[i5] = f5;
            int i7 = i3 + 4;
            this.f67498d = i7;
            fArr[i6] = f6;
            int i8 = i3 + 5;
            this.f67498d = i8;
            fArr[i7] = f7;
            this.f67498d = i3 + 6;
            fArr[i8] = f8;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void c(float f3, float f4) {
            f((byte) 1);
            g(2);
            float[] fArr = this.f67497c;
            int i3 = this.f67498d;
            int i4 = i3 + 1;
            this.f67498d = i4;
            fArr[i3] = f3;
            this.f67498d = i3 + 2;
            fArr[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            f((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void d(float f3, float f4, float f5, float f6) {
            f((byte) 3);
            g(4);
            float[] fArr = this.f67497c;
            int i3 = this.f67498d;
            int i4 = i3 + 1;
            this.f67498d = i4;
            fArr[i3] = f3;
            int i5 = i3 + 2;
            this.f67498d = i5;
            fArr[i4] = f4;
            int i6 = i3 + 3;
            this.f67498d = i6;
            fArr[i5] = f5;
            this.f67498d = i3 + 4;
            fArr[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void e(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
            f((byte) ((z2 ? 2 : 0) | 4 | (z3 ? 1 : 0)));
            g(5);
            float[] fArr = this.f67497c;
            int i3 = this.f67498d;
            int i4 = i3 + 1;
            this.f67498d = i4;
            fArr[i3] = f3;
            int i5 = i3 + 2;
            this.f67498d = i5;
            fArr[i4] = f4;
            int i6 = i3 + 3;
            this.f67498d = i6;
            fArr[i5] = f5;
            int i7 = i3 + 4;
            this.f67498d = i7;
            fArr[i6] = f6;
            this.f67498d = i3 + 5;
            fArr[i7] = f7;
        }

        void h(PathInterface pathInterface) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f67496b; i4++) {
                byte b3 = this.f67495a[i4];
                if (b3 == 0) {
                    float[] fArr = this.f67497c;
                    int i5 = i3 + 1;
                    float f3 = fArr[i3];
                    i3 += 2;
                    pathInterface.a(f3, fArr[i5]);
                } else if (b3 == 1) {
                    float[] fArr2 = this.f67497c;
                    int i6 = i3 + 1;
                    float f4 = fArr2[i3];
                    i3 += 2;
                    pathInterface.c(f4, fArr2[i6]);
                } else if (b3 == 2) {
                    float[] fArr3 = this.f67497c;
                    pathInterface.b(fArr3[i3], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3], fArr3[i3 + 4], fArr3[i3 + 5]);
                    i3 += 6;
                } else if (b3 == 3) {
                    float[] fArr4 = this.f67497c;
                    float f5 = fArr4[i3];
                    float f6 = fArr4[i3 + 1];
                    int i7 = i3 + 3;
                    float f7 = fArr4[i3 + 2];
                    i3 += 4;
                    pathInterface.d(f5, f6, f7, fArr4[i7]);
                } else if (b3 != 8) {
                    boolean z2 = (b3 & 2) != 0;
                    boolean z3 = (b3 & 1) != 0;
                    float[] fArr5 = this.f67497c;
                    pathInterface.e(fArr5[i3], fArr5[i3 + 1], fArr5[i3 + 2], z2, z3, fArr5[i3 + 3], fArr5[i3 + 4]);
                    i3 += 5;
                } else {
                    pathInterface.close();
                }
            }
        }

        boolean i() {
            return this.f67496b == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface PathInterface {
        void a(float f3, float f4);

        void b(float f3, float f4, float f5, float f6, float f7, float f8);

        void c(float f3, float f4);

        void close();

        void d(float f3, float f4, float f5, float f6);

        void e(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Boolean f67499q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Boolean f67500r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Matrix f67501s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67502t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Length f67503u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Length f67504v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        Length f67505w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        String f67506x;

        Pattern() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "pattern";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PolyLine extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float[] f67507o;

        PolyLine() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "polyline";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Polygon extends PolyLine {
        Polygon() {
        }

        @Override // com.caverock.androidsvg.SVG.PolyLine, com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "polygon";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Rect extends GraphicsElement {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67508o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67509p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67510q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67511r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67512s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67513t;

        Rect() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "rect";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Style implements Cloneable {
        String A;
        Boolean B;
        Boolean C;
        SvgPaint D;
        Float E;
        String F;
        FillRule G;
        String H;
        SvgPaint I;
        Float J;
        SvgPaint K;
        Float L;
        VectorEffect M;
        RenderQuality N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f67515a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SvgPaint f67516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        FillRule f67517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Float f67518d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SvgPaint f67519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Float f67520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Length f67521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        LineCap f67522i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        LineJoin f67523j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Float f67524k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Length[] f67525l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Length f67526m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Float f67527n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Colour f67528o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        List f67529p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67530q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Integer f67531r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        FontStyle f67532s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        TextDecoration f67533t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        TextDirection f67534u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        TextAnchor f67535v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        Boolean f67536w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        CSSClipRect f67537x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f67538y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        String f67539z;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum LineCap {
            Butt,
            Round,
            Square
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum RenderQuality {
            f67555a,
            f67556b,
            optimizeSpeed
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        Style() {
        }

        static Style a() {
            Style style = new Style();
            style.f67515a = -1L;
            Colour colour = Colour.f67448b;
            style.f67516b = colour;
            FillRule fillRule = FillRule.NonZero;
            style.f67517c = fillRule;
            Float fValueOf = Float.valueOf(1.0f);
            style.f67518d = fValueOf;
            style.f67519f = null;
            style.f67520g = fValueOf;
            style.f67521h = new Length(1.0f);
            style.f67522i = LineCap.Butt;
            style.f67523j = LineJoin.Miter;
            style.f67524k = Float.valueOf(4.0f);
            style.f67525l = null;
            style.f67526m = new Length(0.0f);
            style.f67527n = fValueOf;
            style.f67528o = colour;
            style.f67529p = null;
            style.f67530q = new Length(12.0f, Unit.pt);
            style.f67531r = Integer.valueOf(RCHTTPStatusCodes.BAD_REQUEST);
            style.f67532s = FontStyle.Normal;
            style.f67533t = TextDecoration.None;
            style.f67534u = TextDirection.LTR;
            style.f67535v = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.f67536w = bool;
            style.f67537x = null;
            style.f67538y = null;
            style.f67539z = null;
            style.A = null;
            style.B = bool;
            style.C = bool;
            style.D = colour;
            style.E = fValueOf;
            style.F = null;
            style.G = fillRule;
            style.H = null;
            style.I = null;
            style.J = fValueOf;
            style.K = null;
            style.L = fValueOf;
            style.M = VectorEffect.None;
            style.N = RenderQuality.f67555a;
            return style;
        }

        void b(boolean z2) {
            Float fValueOf = Float.valueOf(1.0f);
            Boolean bool = Boolean.TRUE;
            this.B = bool;
            if (!z2) {
                bool = Boolean.FALSE;
            }
            this.f67536w = bool;
            this.f67537x = null;
            this.F = null;
            this.f67527n = fValueOf;
            this.D = Colour.f67448b;
            this.E = fValueOf;
            this.H = null;
            this.I = null;
            this.J = fValueOf;
            this.K = null;
            this.L = fValueOf;
            this.M = VectorEffect.None;
        }

        protected Object clone() {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.f67525l;
            if (lengthArr != null) {
                style.f67525l = (Length[]) lengthArr.clone();
            }
            return style;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Svg extends SvgViewBoxContainer {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67575q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67576r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67577s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67578t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f67579u;

        Svg() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "svg";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface SvgConditional {
        Set a();

        String b();

        void c(Set set);

        void e(Set set);

        Set f();

        void g(Set set);

        void i(Set set);

        void j(String str);

        Set l();

        Set m();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        List f67580i = new ArrayList();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Set f67581j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        String f67582k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Set f67583l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Set f67584m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Set f67585n = null;

        SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set a() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String b() {
            return this.f67582k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void c(Set set) {
            this.f67585n = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void e(Set set) {
            this.f67581j = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set f() {
            return this.f67581j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void g(Set set) {
            this.f67583l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List getChildren() {
            return this.f67580i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void h(SvgObject svgObject) {
            this.f67580i.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void i(Set set) {
            this.f67584m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void j(String str) {
            this.f67582k = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set l() {
            return this.f67584m;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set m() {
            return this.f67585n;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Set f67586i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f67587j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Set f67588k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Set f67589l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Set f67590m = null;

        SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set a() {
            return this.f67588k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String b() {
            return this.f67587j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void c(Set set) {
            this.f67590m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void e(Set set) {
            this.f67586i = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set f() {
            return this.f67586i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void g(Set set) {
            this.f67588k = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void i(Set set) {
            this.f67589l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void j(String str) {
            this.f67587j = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set l() {
            return this.f67589l;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set m() {
            return this.f67590m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface SvgContainer {
        List getChildren();

        void h(SvgObject svgObject);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgElement extends SvgElementBase {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Box f67591h = null;

        SvgElement() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgElementBase extends SvgObject {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f67592c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Boolean f67593d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Style f67594e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Style f67595f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List f67596g = null;

        SvgElementBase() {
        }

        public String toString() {
            return n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SvgLinearGradient extends GradientElement {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Length f67597m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Length f67598n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67599o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67600p;

        SvgLinearGradient() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "linearGradient";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SvgObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SVG f67601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SvgContainer f67602b;

        SvgObject() {
        }

        String n() {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        PreserveAspectRatio f67603o = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SvgRadialGradient extends GradientElement {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Length f67604m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Length f67605n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Length f67606o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67607p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67608q;

        SvgRadialGradient() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "radialGradient";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Box f67609p;

        SvgViewBoxContainer() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Switch extends Group {
        Switch() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "switch";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        Symbol() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "symbol";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TRef extends TextContainer implements TextChild {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f67610o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private TextRoot f67611p;

        TRef() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot d() {
            return this.f67611p;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "tref";
        }

        public void o(TextRoot textRoot) {
            this.f67611p = textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TSpan extends TextPositionedContainer implements TextChild {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private TextRoot f67612s;

        TSpan() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot d() {
            return this.f67612s;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "tspan";
        }

        public void o(TextRoot textRoot) {
            this.f67612s = textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Matrix f67613s;

        Text() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void k(Matrix matrix) {
            this.f67613s = matrix;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "text";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TextChild {
        TextRoot d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class TextContainer extends SvgConditionalContainer {
        TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void h(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof TextChild) {
                this.f67580i.add(svgObject);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TextPath extends TextContainer implements TextChild {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f67614o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Length f67615p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private TextRoot f67616q;

        TextPath() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot d() {
            return this.f67616q;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "textPath";
        }

        public void o(TextRoot textRoot) {
            this.f67616q = textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class TextPositionedContainer extends TextContainer {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        List f67617o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        List f67618p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        List f67619q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        List f67620r;

        TextPositionedContainer() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TextRoot {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TextSequence extends SvgObject implements TextChild {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f67621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextRoot f67622d;

        TextSequence(String str) {
            this.f67621c = str;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot d() {
            return this.f67622d;
        }

        public String toString() {
            return "TextChild: '" + this.f67621c + "'";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Use extends Group {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f67633p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Length f67634q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Length f67635r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Length f67636s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Length f67637t;

        Use() {
        }

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "use";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        View() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return ViewHierarchyConstants.VIEW_KEY;
        }
    }

    SVG() {
    }

    private Box e(float f3) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        float fB;
        Unit unit5;
        Svg svg = this.f67429a;
        Length length = svg.f67577s;
        Length length2 = svg.f67578t;
        if (length == null || length.j() || (unit = length.f67474b) == (unit2 = Unit.percent) || unit == (unit3 = Unit.em) || unit == (unit4 = Unit.ex)) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float fB2 = length.b(f3);
        if (length2 == null) {
            Box box = this.f67429a.f67609p;
            fB = box != null ? (box.f67439d * fB2) / box.f67438c : fB2;
        } else {
            if (length2.j() || (unit5 = length2.f67474b) == unit2 || unit5 == unit3 || unit5 == unit4) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            fB = length2.b(f3);
        }
        return new Box(0.0f, 0.0f, fB2, fB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase i(SvgContainer svgContainer, String str) {
        SvgElementBase svgElementBaseI;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.f67592c)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.f67592c)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (svgElementBaseI = i((SvgContainer) obj, str)) != null) {
                    return svgElementBaseI;
                }
            }
        }
        return null;
    }

    static SVGExternalFileResolver k() {
        return f67427g;
    }

    public static SVG l(InputStream inputStream) {
        return new SVGParser().z(inputStream, f67428h);
    }

    public static SVG m(Context context, int i3) {
        return n(context.getResources(), i3);
    }

    public static SVG n(Resources resources, int i3) {
        SVGParser sVGParser = new SVGParser();
        InputStream inputStreamOpenRawResource = resources.openRawResource(i3);
        try {
            return sVGParser.z(inputStreamOpenRawResource, f67428h);
        } finally {
            try {
                inputStreamOpenRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG o(String str) {
        return new SVGParser().z(new ByteArrayInputStream(str.getBytes()), f67428h);
    }

    public void A(float f3) {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.f67577s = new Length(f3);
    }

    public void B(String str) {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.f67577s = SVGParser.o0(str);
    }

    void C(Svg svg) {
        this.f67429a = svg;
    }

    void D(String str) {
        this.f67430b = str;
    }

    void a(CSSParser.Ruleset ruleset) {
        this.f67433e.b(ruleset);
    }

    void b() {
        this.f67433e.e(CSSParser.Source.RenderOptions);
    }

    List d() {
        return this.f67433e.c();
    }

    public float f() {
        if (this.f67429a != null) {
            return e(this.f67432d).f67439d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF g() {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        Box box = svg.f67609p;
        if (box == null) {
            return null;
        }
        return box.d();
    }

    public float h() {
        if (this.f67429a != null) {
            return e(this.f67432d).f67438c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    SvgElementBase j(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f67429a.f67592c)) {
            return this.f67429a;
        }
        if (this.f67434f.containsKey(str)) {
            return (SvgElementBase) this.f67434f.get(str);
        }
        SvgElementBase svgElementBaseI = i(this.f67429a, str);
        this.f67434f.put(str, svgElementBaseI);
        return svgElementBaseI;
    }

    Svg p() {
        return this.f67429a;
    }

    boolean q() {
        return !this.f67433e.d();
    }

    public void r(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.g()) {
            renderOptions.h(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.f67432d).G0(this, renderOptions);
    }

    public Picture s() {
        return u(null);
    }

    public Picture t(int i3, int i4, RenderOptions renderOptions) {
        Picture picture = new Picture();
        Canvas canvasBeginRecording = picture.beginRecording(i3, i4);
        if (renderOptions == null || renderOptions.f67426f == null) {
            renderOptions = renderOptions == null ? new RenderOptions() : new RenderOptions(renderOptions);
            renderOptions.h(0.0f, 0.0f, i3, i4);
        }
        new SVGAndroidRenderer(canvasBeginRecording, this.f67432d).G0(this, renderOptions);
        picture.endRecording();
        return picture;
    }

    public Picture u(RenderOptions renderOptions) {
        Length length;
        Box box = (renderOptions == null || !renderOptions.f()) ? this.f67429a.f67609p : renderOptions.f67424d;
        if (renderOptions != null && renderOptions.g()) {
            return t((int) Math.ceil(renderOptions.f67426f.b()), (int) Math.ceil(renderOptions.f67426f.c()), renderOptions);
        }
        Svg svg = this.f67429a;
        Length length2 = svg.f67577s;
        if (length2 != null) {
            Unit unit = length2.f67474b;
            Unit unit2 = Unit.percent;
            if (unit != unit2 && (length = svg.f67578t) != null && length.f67474b != unit2) {
                return t((int) Math.ceil(length2.b(this.f67432d)), (int) Math.ceil(this.f67429a.f67578t.b(this.f67432d)), renderOptions);
            }
        }
        if (length2 != null && box != null) {
            return t((int) Math.ceil(length2.b(this.f67432d)), (int) Math.ceil((box.f67439d * r1) / box.f67438c), renderOptions);
        }
        Length length3 = svg.f67578t;
        if (length3 == null || box == null) {
            return t(512, 512, renderOptions);
        }
        return t((int) Math.ceil((box.f67438c * r1) / box.f67439d), (int) Math.ceil(length3.b(this.f67432d)), renderOptions);
    }

    SvgObject v(String str) {
        if (str == null) {
            return null;
        }
        String strC = c(str);
        if (strC.length() <= 1 || !strC.startsWith("#")) {
            return null;
        }
        return j(strC.substring(1));
    }

    void w(String str) {
        this.f67431c = str;
    }

    public void x(float f3) {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.f67578t = new Length(f3);
    }

    public void y(String str) {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.f67578t = SVGParser.o0(str);
    }

    public void z(float f3, float f4, float f5, float f6) {
        Svg svg = this.f67429a;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.f67609p = new Box(f3, f4, f5, f6);
    }

    private String c(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", vxrlPPpdv.PXCpaepivCF);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Length implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f67473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Unit f67474b;

        Length(float f3, Unit unit) {
            this.f67473a = f3;
            this.f67474b = unit;
        }

        float a() {
            return this.f67473a;
        }

        float b(float f3) {
            int i3 = AnonymousClass1.f67435a[this.f67474b.ordinal()];
            if (i3 == 1) {
                return this.f67473a;
            }
            switch (i3) {
                case 4:
                    return this.f67473a * f3;
                case 5:
                    return (this.f67473a * f3) / 2.54f;
                case 6:
                    return (this.f67473a * f3) / 25.4f;
                case 7:
                    return (this.f67473a * f3) / 72.0f;
                case 8:
                    return (this.f67473a * f3) / 6.0f;
                default:
                    return this.f67473a;
            }
        }

        float c(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.f67474b != Unit.percent) {
                return g(sVGAndroidRenderer);
            }
            Box boxS = sVGAndroidRenderer.S();
            if (boxS == null) {
                return this.f67473a;
            }
            float f3 = boxS.f67438c;
            if (f3 == boxS.f67439d) {
                return (this.f67473a * f3) / 100.0f;
            }
            return (this.f67473a * ((float) (Math.sqrt((f3 * f3) + (r6 * r6)) / 1.414213562373095d))) / 100.0f;
        }

        float e(SVGAndroidRenderer sVGAndroidRenderer, float f3) {
            return this.f67474b == Unit.percent ? (this.f67473a * f3) / 100.0f : g(sVGAndroidRenderer);
        }

        float g(SVGAndroidRenderer sVGAndroidRenderer) {
            switch (AnonymousClass1.f67435a[this.f67474b.ordinal()]) {
                case 9:
                    Box boxS = sVGAndroidRenderer.S();
                    if (boxS != null) {
                    }
                    break;
            }
            return this.f67473a;
        }

        float h(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.f67474b != Unit.percent) {
                return g(sVGAndroidRenderer);
            }
            Box boxS = sVGAndroidRenderer.S();
            return boxS == null ? this.f67473a : (this.f67473a * boxS.f67439d) / 100.0f;
        }

        boolean i() {
            return this.f67473a < 0.0f;
        }

        boolean j() {
            return this.f67473a == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.f67473a) + this.f67474b;
        }

        Length(float f3) {
            this.f67473a = f3;
            this.f67474b = Unit.px;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Box {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f67436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f67439d;

        Box(float f3, float f4, float f5, float f6) {
            this.f67436a = f3;
            this.f67437b = f4;
            this.f67438c = f5;
            this.f67439d = f6;
        }

        static Box a(float f3, float f4, float f5, float f6) {
            return new Box(f3, f4, f5 - f3, f6 - f4);
        }

        float b() {
            return this.f67436a + this.f67438c;
        }

        float c() {
            return this.f67437b + this.f67439d;
        }

        RectF d() {
            return new RectF(this.f67436a, this.f67437b, b(), c());
        }

        void e(Box box) {
            float f3 = box.f67436a;
            if (f3 < this.f67436a) {
                this.f67436a = f3;
            }
            float f4 = box.f67437b;
            if (f4 < this.f67437b) {
                this.f67437b = f4;
            }
            if (box.b() > b()) {
                this.f67438c = box.b() - this.f67436a;
            }
            if (box.c() > c()) {
                this.f67439d = box.c() - this.f67437b;
            }
        }

        public String toString() {
            return "[" + this.f67436a + " " + this.f67437b + " " + this.f67438c + " " + this.f67439d + "]";
        }

        Box(Box box) {
            this.f67436a = box.f67436a;
            this.f67437b = box.f67437b;
            this.f67438c = box.f67438c;
            this.f67439d = box.f67439d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SolidColor extends SvgElementBase implements SvgContainer {
        SolidColor() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List getChildren() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void h(SvgObject svgObject) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Stop extends SvgElementBase implements SvgContainer {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Float f67514h;

        Stop() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List getChildren() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String n() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void h(SvgObject svgObject) {
        }
    }
}
