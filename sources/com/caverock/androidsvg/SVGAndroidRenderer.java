package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class SVGAndroidRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static HashSet f67638i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Canvas f67639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f67640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SVG f67641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RendererState f67642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Stack f67643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Stack f67644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Stack f67645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CSSParser.RuleMatchContext f67646h = null;

    /* JADX INFO: renamed from: com.caverock.androidsvg.SVGAndroidRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f67648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f67649c;

        static {
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            f67649c = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67649c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67649c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            f67648b = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67648b[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67648b[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            f67647a = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f67647a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MarkerPositionCalculator implements SVG.PathInterface {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f67651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f67652c;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f67657h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f67650a = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MarkerVector f67653d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f67654e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f67655f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f67656g = -1;

        MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.h(this);
            if (this.f67657h) {
                this.f67653d.b((MarkerVector) this.f67650a.get(this.f67656g));
                this.f67650a.set(this.f67656g, this.f67653d);
                this.f67657h = false;
            }
            MarkerVector markerVector = this.f67653d;
            if (markerVector != null) {
                this.f67650a.add(markerVector);
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void a(float f3, float f4) {
            if (this.f67657h) {
                this.f67653d.b((MarkerVector) this.f67650a.get(this.f67656g));
                this.f67650a.set(this.f67656g, this.f67653d);
                this.f67657h = false;
            }
            MarkerVector markerVector = this.f67653d;
            if (markerVector != null) {
                this.f67650a.add(markerVector);
            }
            this.f67651b = f3;
            this.f67652c = f4;
            this.f67653d = SVGAndroidRenderer.this.new MarkerVector(f3, f4, 0.0f, 0.0f);
            this.f67656g = this.f67650a.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            if (this.f67655f || this.f67654e) {
                this.f67653d.a(f3, f4);
                this.f67650a.add(this.f67653d);
                this.f67654e = false;
            }
            this.f67653d = SVGAndroidRenderer.this.new MarkerVector(f7, f8, f7 - f5, f8 - f6);
            this.f67657h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void c(float f3, float f4) {
            this.f67653d.a(f3, f4);
            this.f67650a.add(this.f67653d);
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            MarkerVector markerVector = this.f67653d;
            this.f67653d = sVGAndroidRenderer.new MarkerVector(f3, f4, f3 - markerVector.f67659a, f4 - markerVector.f67660b);
            this.f67657h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.f67650a.add(this.f67653d);
            c(this.f67651b, this.f67652c);
            this.f67657h = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void d(float f3, float f4, float f5, float f6) {
            this.f67653d.a(f3, f4);
            this.f67650a.add(this.f67653d);
            this.f67653d = SVGAndroidRenderer.this.new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.f67657h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void e(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
            this.f67654e = true;
            this.f67655f = false;
            MarkerVector markerVector = this.f67653d;
            SVGAndroidRenderer.h(markerVector.f67659a, markerVector.f67660b, f3, f4, f5, z2, z3, f6, f7, this);
            this.f67655f = true;
            this.f67657h = false;
        }

        List f() {
            return this.f67650a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MarkerVector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f67659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f67662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f67663e = false;

        MarkerVector(float f3, float f4, float f5, float f6) {
            this.f67661c = 0.0f;
            this.f67662d = 0.0f;
            this.f67659a = f3;
            this.f67660b = f4;
            double dSqrt = Math.sqrt((f5 * f5) + (f6 * f6));
            if (dSqrt != 0.0d) {
                this.f67661c = (float) (((double) f5) / dSqrt);
                this.f67662d = (float) (((double) f6) / dSqrt);
            }
        }

        void a(float f3, float f4) {
            float f5 = f3 - this.f67659a;
            float f6 = f4 - this.f67660b;
            double dSqrt = Math.sqrt((f5 * f5) + (f6 * f6));
            if (dSqrt != 0.0d) {
                f5 = (float) (((double) f5) / dSqrt);
                f6 = (float) (((double) f6) / dSqrt);
            }
            float f7 = this.f67661c;
            if (f5 != (-f7) || f6 != (-this.f67662d)) {
                this.f67661c = f7 + f5;
                this.f67662d += f6;
            } else {
                this.f67663e = true;
                this.f67661c = -f6;
                this.f67662d = f5;
            }
        }

        void b(MarkerVector markerVector) {
            float f3 = markerVector.f67661c;
            float f4 = this.f67661c;
            if (f3 == (-f4)) {
                float f5 = markerVector.f67662d;
                if (f5 == (-this.f67662d)) {
                    this.f67663e = true;
                    this.f67661c = -f5;
                    this.f67662d = markerVector.f67661c;
                    return;
                }
            }
            this.f67661c = f4 + f3;
            this.f67662d += markerVector.f67662d;
        }

        public String toString() {
            return "(" + this.f67659a + "," + this.f67660b + " " + this.f67661c + "," + this.f67662d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PathConverter implements SVG.PathInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Path f67665a = new Path();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67667c;

        PathConverter(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void a(float f3, float f4) {
            this.f67665a.moveTo(f3, f4);
            this.f67666b = f3;
            this.f67667c = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void b(float f3, float f4, float f5, float f6, float f7, float f8) {
            this.f67665a.cubicTo(f3, f4, f5, f6, f7, f8);
            this.f67666b = f7;
            this.f67667c = f8;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void c(float f3, float f4) {
            this.f67665a.lineTo(f3, f4);
            this.f67666b = f3;
            this.f67667c = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.f67665a.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void d(float f3, float f4, float f5, float f6) {
            this.f67665a.quadTo(f3, f4, f5, f6);
            this.f67666b = f5;
            this.f67667c = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void e(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7) {
            SVGAndroidRenderer.h(this.f67666b, this.f67667c, f3, f4, f5, z2, z3, f6, f7, this);
            this.f67666b = f6;
            this.f67667c = f7;
        }

        Path f() {
            return this.f67665a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PathTextDrawer extends PlainTextDrawer {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Path f67669e;

        PathTextDrawer(Path path, float f3, float f4) {
            super(f3, f4);
            this.f67669e = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void b(String str) {
            String str2;
            if (SVGAndroidRenderer.this.Y0()) {
                if (SVGAndroidRenderer.this.f67642d.f67679b) {
                    str2 = str;
                    SVGAndroidRenderer.this.f67639a.drawTextOnPath(str2, this.f67669e, this.f67671b, this.f67672c, SVGAndroidRenderer.this.f67642d.f67681d);
                } else {
                    str2 = str;
                }
                if (SVGAndroidRenderer.this.f67642d.f67680c) {
                    SVGAndroidRenderer.this.f67639a.drawTextOnPath(str2, this.f67669e, this.f67671b, this.f67672c, SVGAndroidRenderer.this.f67642d.f67682e);
                }
            } else {
                str2 = str;
            }
            this.f67671b += SVGAndroidRenderer.this.f67642d.f67681d.measureText(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PlainTextDrawer extends TextProcessor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67672c;

        PlainTextDrawer(float f3, float f4) {
            super(SVGAndroidRenderer.this, null);
            this.f67671b = f3;
            this.f67672c = f4;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void b(String str) {
            SVGAndroidRenderer.y("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.Y0()) {
                if (SVGAndroidRenderer.this.f67642d.f67679b) {
                    SVGAndroidRenderer.this.f67639a.drawText(str, this.f67671b, this.f67672c, SVGAndroidRenderer.this.f67642d.f67681d);
                }
                if (SVGAndroidRenderer.this.f67642d.f67680c) {
                    SVGAndroidRenderer.this.f67639a.drawText(str, this.f67671b, this.f67672c, SVGAndroidRenderer.this.f67642d.f67682e);
                }
            }
            this.f67671b += SVGAndroidRenderer.this.f67642d.f67681d.measureText(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PlainTextToPath extends TextProcessor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Path f67676d;

        PlainTextToPath(float f3, float f4, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.f67674b = f3;
            this.f67675c = f4;
            this.f67676d = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean a(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void b(String str) {
            String str2;
            if (SVGAndroidRenderer.this.Y0()) {
                Path path = new Path();
                str2 = str;
                SVGAndroidRenderer.this.f67642d.f67681d.getTextPath(str2, 0, str.length(), this.f67674b, this.f67675c, path);
                this.f67676d.addPath(path);
            } else {
                str2 = str;
            }
            this.f67674b += SVGAndroidRenderer.this.f67642d.f67681d.measureText(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TextBoundsCalculator extends TextProcessor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f67688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RectF f67689d;

        TextBoundsCalculator(float f3, float f4) {
            super(SVGAndroidRenderer.this, null);
            this.f67689d = new RectF();
            this.f67687b = f3;
            this.f67688c = f4;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean a(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject svgObjectV = textContainer.f67601a.v(textPath.f67614o);
            if (svgObjectV == null) {
                SVGAndroidRenderer.F("TextPath path reference '%s' not found", textPath.f67614o);
                return false;
            }
            SVG.Path path = (SVG.Path) svgObjectV;
            Path pathF = SVGAndroidRenderer.this.new PathConverter(path.f67493o).f();
            Matrix matrix = path.f67465n;
            if (matrix != null) {
                pathF.transform(matrix);
            }
            RectF rectF = new RectF();
            pathF.computeBounds(rectF, true);
            this.f67689d.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void b(String str) {
            if (SVGAndroidRenderer.this.Y0()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.f67642d.f67681d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f67687b, this.f67688c);
                this.f67689d.union(rectF);
            }
            this.f67687b += SVGAndroidRenderer.this.f67642d.f67681d.measureText(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class TextProcessor {
        private TextProcessor() {
        }

        public boolean a(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void b(String str);

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    SVGAndroidRenderer(Canvas canvas, float f3) {
        this.f67639a = canvas;
        this.f67640b = f3;
    }

    private boolean A() {
        Boolean bool = this.f67642d.f67678a.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void A0(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        S0();
        u(svgObject);
        if (svgObject instanceof SVG.Svg) {
            x0((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            E0((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            B0((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            q0((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            r0((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            t0((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            w0((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            o0((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            p0((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            s0((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            v0((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            u0((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            D0((SVG.Text) svgObject);
        }
        R0();
    }

    private void B(SVG.SvgElement svgElement, Path path) {
        SVG.SvgPaint svgPaint = this.f67642d.f67678a.f67516b;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.SvgObject svgObjectV = this.f67641c.v(((SVG.PaintReference) svgPaint).f67491a);
            if (svgObjectV instanceof SVG.Pattern) {
                L(svgElement, path, (SVG.Pattern) svgObjectV);
                return;
            }
        }
        this.f67639a.drawPath(path, this.f67642d.f67681d);
    }

    private void B0(SVG.Switch r3) {
        y("Switch render", new Object[0]);
        W0(this.f67642d, r3);
        if (A()) {
            Matrix matrix = r3.f67466o;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            p(r3);
            boolean zM0 = m0();
            K0(r3);
            if (zM0) {
                j0(r3);
            }
            U0(r3);
        }
    }

    private void C(Path path) {
        RendererState rendererState = this.f67642d;
        if (rendererState.f67678a.M != SVG.Style.VectorEffect.NonScalingStroke) {
            this.f67639a.drawPath(path, rendererState.f67682e);
            return;
        }
        Matrix matrix = this.f67639a.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        this.f67639a.setMatrix(new Matrix());
        Shader shader = this.f67642d.f67682e.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        this.f67639a.drawPath(path2, this.f67642d.f67682e);
        this.f67639a.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    private void C0(SVG.Symbol symbol, SVG.Box box) {
        y("Symbol render", new Object[0]);
        if (box.f67438c == 0.0f || box.f67439d == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = symbol.f67603o;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f67395e;
        }
        W0(this.f67642d, symbol);
        RendererState rendererState = this.f67642d;
        rendererState.f67683f = box;
        if (!rendererState.f67678a.f67536w.booleanValue()) {
            SVG.Box box2 = this.f67642d.f67683f;
            O0(box2.f67436a, box2.f67437b, box2.f67438c, box2.f67439d);
        }
        SVG.Box box3 = symbol.f67609p;
        if (box3 != null) {
            this.f67639a.concat(o(this.f67642d.f67683f, box3, preserveAspectRatio));
            this.f67642d.f67684g = symbol.f67609p;
        } else {
            Canvas canvas = this.f67639a;
            SVG.Box box4 = this.f67642d.f67683f;
            canvas.translate(box4.f67436a, box4.f67437b);
        }
        boolean zM0 = m0();
        F0(symbol, true);
        if (zM0) {
            j0(symbol);
        }
        U0(symbol);
    }

    private float D(float f3, float f4, float f5, float f6) {
        return (f3 * f5) + (f4 * f6);
    }

    private void D0(SVG.Text text) {
        y("Text render", new Object[0]);
        W0(this.f67642d, text);
        if (A()) {
            Matrix matrix = text.f67613s;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            List list = text.f67617o;
            float fH = 0.0f;
            float fG = (list == null || list.size() == 0) ? 0.0f : ((SVG.Length) text.f67617o.get(0)).g(this);
            List list2 = text.f67618p;
            float fH2 = (list2 == null || list2.size() == 0) ? 0.0f : ((SVG.Length) text.f67618p.get(0)).h(this);
            List list3 = text.f67619q;
            float fG2 = (list3 == null || list3.size() == 0) ? 0.0f : ((SVG.Length) text.f67619q.get(0)).g(this);
            List list4 = text.f67620r;
            if (list4 != null && list4.size() != 0) {
                fH = ((SVG.Length) text.f67620r.get(0)).h(this);
            }
            SVG.Style.TextAnchor textAnchorO = O();
            if (textAnchorO != SVG.Style.TextAnchor.Start) {
                float fN = n(text);
                if (textAnchorO == SVG.Style.TextAnchor.Middle) {
                    fN /= 2.0f;
                }
                fG -= fN;
            }
            if (text.f67591h == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fG, fH2);
                E(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.f67689d;
                text.f67591h = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.f67689d.height());
            }
            U0(text);
            r(text);
            p(text);
            boolean zM0 = m0();
            E(text, new PlainTextDrawer(fG + fG2, fH2 + fH));
            if (zM0) {
                j0(text);
            }
        }
    }

    private void E(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (A()) {
            Iterator it = textContainer.f67580i.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
                if (svgObject instanceof SVG.TextSequence) {
                    textProcessor.b(T0(((SVG.TextSequence) svgObject).f67621c, z2, !it.hasNext()));
                } else {
                    l0(svgObject, textProcessor);
                }
                z2 = false;
            }
        }
    }

    private void E0(SVG.Use use) {
        y("Use render", new Object[0]);
        SVG.Length length = use.f67636s;
        if (length == null || !length.j()) {
            SVG.Length length2 = use.f67637t;
            if (length2 == null || !length2.j()) {
                W0(this.f67642d, use);
                if (A()) {
                    SVG.SvgObject svgObjectV = use.f67601a.v(use.f67633p);
                    if (svgObjectV == null) {
                        F("Use reference '%s' not found", use.f67633p);
                        return;
                    }
                    Matrix matrix = use.f67466o;
                    if (matrix != null) {
                        this.f67639a.concat(matrix);
                    }
                    SVG.Length length3 = use.f67634q;
                    float fG = length3 != null ? length3.g(this) : 0.0f;
                    SVG.Length length4 = use.f67635r;
                    this.f67639a.translate(fG, length4 != null ? length4.h(this) : 0.0f);
                    p(use);
                    boolean zM0 = m0();
                    i0(use);
                    if (svgObjectV instanceof SVG.Svg) {
                        SVG.Box boxF0 = f0(null, null, use.f67636s, use.f67637t);
                        S0();
                        y0((SVG.Svg) svgObjectV, boxF0);
                        R0();
                    } else if (svgObjectV instanceof SVG.Symbol) {
                        SVG.Length length5 = use.f67636s;
                        if (length5 == null) {
                            length5 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length6 = use.f67637t;
                        if (length6 == null) {
                            length6 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Box boxF02 = f0(null, null, length5, length6);
                        S0();
                        C0((SVG.Symbol) svgObjectV, boxF02);
                        R0();
                    } else {
                        A0(svgObjectV);
                    }
                    h0();
                    if (zM0) {
                        j0(use);
                    }
                    U0(use);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void F0(SVG.SvgContainer svgContainer, boolean z2) {
        if (z2) {
            i0(svgContainer);
        }
        Iterator it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            A0((SVG.SvgObject) it.next());
        }
        if (z2) {
            h0();
        }
    }

    private void G(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator it = textContainer.f67580i.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
            if (svgObject instanceof SVG.TextContainer) {
                G((SVG.TextContainer) svgObject, sb);
            } else if (svgObject instanceof SVG.TextSequence) {
                sb.append(T0(((SVG.TextSequence) svgObject).f67621c, z2, !it.hasNext()));
            }
            z2 = false;
        }
    }

    private void H(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject svgObjectV = gradientElement.f67601a.v(str);
        if (svgObjectV == null) {
            Z0("Gradient reference '%s' not found", str);
            return;
        }
        if (!(svgObjectV instanceof SVG.GradientElement)) {
            F("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (svgObjectV == gradientElement) {
            F("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) svgObjectV;
        if (gradientElement.f67457i == null) {
            gradientElement.f67457i = gradientElement2.f67457i;
        }
        if (gradientElement.f67458j == null) {
            gradientElement.f67458j = gradientElement2.f67458j;
        }
        if (gradientElement.f67459k == null) {
            gradientElement.f67459k = gradientElement2.f67459k;
        }
        if (gradientElement.f67456h.isEmpty()) {
            gradientElement.f67456h = gradientElement2.f67456h;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                I((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) svgObjectV);
            } else {
                J((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) svgObjectV);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = gradientElement2.f67460l;
        if (str2 != null) {
            H(gradientElement, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r7 != 8) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void H0(com.caverock.androidsvg.SVG.Marker r12, com.caverock.androidsvg.SVGAndroidRenderer.MarkerVector r13) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.H0(com.caverock.androidsvg.SVG$Marker, com.caverock.androidsvg.SVGAndroidRenderer$MarkerVector):void");
    }

    private void I(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.f67597m == null) {
            svgLinearGradient.f67597m = svgLinearGradient2.f67597m;
        }
        if (svgLinearGradient.f67598n == null) {
            svgLinearGradient.f67598n = svgLinearGradient2.f67598n;
        }
        if (svgLinearGradient.f67599o == null) {
            svgLinearGradient.f67599o = svgLinearGradient2.f67599o;
        }
        if (svgLinearGradient.f67600p == null) {
            svgLinearGradient.f67600p = svgLinearGradient2.f67600p;
        }
    }

    private void I0(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        SVG.Marker marker2;
        SVG.Marker marker3;
        int size;
        SVG.Style style = this.f67642d.f67678a;
        String str = style.f67538y;
        if (str == null && style.f67539z == null && style.A == null) {
            return;
        }
        if (str == null) {
            marker = null;
        } else {
            SVG.SvgObject svgObjectV = graphicsElement.f67601a.v(str);
            if (svgObjectV != null) {
                marker = (SVG.Marker) svgObjectV;
            } else {
                F("Marker reference '%s' not found", this.f67642d.f67678a.f67538y);
                marker = null;
            }
        }
        String str2 = this.f67642d.f67678a.f67539z;
        if (str2 == null) {
            marker2 = null;
        } else {
            SVG.SvgObject svgObjectV2 = graphicsElement.f67601a.v(str2);
            if (svgObjectV2 != null) {
                marker2 = (SVG.Marker) svgObjectV2;
            } else {
                F("Marker reference '%s' not found", this.f67642d.f67678a.f67539z);
                marker2 = null;
            }
        }
        String str3 = this.f67642d.f67678a.A;
        if (str3 == null) {
            marker3 = null;
        } else {
            SVG.SvgObject svgObjectV3 = graphicsElement.f67601a.v(str3);
            if (svgObjectV3 != null) {
                marker3 = (SVG.Marker) svgObjectV3;
            } else {
                F("Marker reference '%s' not found", this.f67642d.f67678a.A);
                marker3 = null;
            }
        }
        List listF = graphicsElement instanceof SVG.Path ? new MarkerPositionCalculator(((SVG.Path) graphicsElement).f67493o).f() : graphicsElement instanceof SVG.Line ? k((SVG.Line) graphicsElement) : l((SVG.PolyLine) graphicsElement);
        if (listF == null || (size = listF.size()) == 0) {
            return;
        }
        SVG.Style style2 = this.f67642d.f67678a;
        style2.A = null;
        style2.f67539z = null;
        style2.f67538y = null;
        if (marker != null) {
            H0(marker, (MarkerVector) listF.get(0));
        }
        if (marker2 != null && listF.size() > 2) {
            MarkerVector markerVectorN0 = (MarkerVector) listF.get(0);
            MarkerVector markerVector = (MarkerVector) listF.get(1);
            int i3 = 1;
            while (i3 < size - 1) {
                i3++;
                MarkerVector markerVector2 = (MarkerVector) listF.get(i3);
                markerVectorN0 = markerVector.f67663e ? n0(markerVectorN0, markerVector, markerVector2) : markerVector;
                H0(marker2, markerVectorN0);
                markerVector = markerVector2;
            }
        }
        if (marker3 != null) {
            H0(marker3, (MarkerVector) listF.get(size - 1));
        }
    }

    private void J(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.f67604m == null) {
            svgRadialGradient.f67604m = svgRadialGradient2.f67604m;
        }
        if (svgRadialGradient.f67605n == null) {
            svgRadialGradient.f67605n = svgRadialGradient2.f67605n;
        }
        if (svgRadialGradient.f67606o == null) {
            svgRadialGradient.f67606o = svgRadialGradient2.f67606o;
        }
        if (svgRadialGradient.f67607p == null) {
            svgRadialGradient.f67607p = svgRadialGradient2.f67607p;
        }
        if (svgRadialGradient.f67608q == null) {
            svgRadialGradient.f67608q = svgRadialGradient2.f67608q;
        }
    }

    private void J0(SVG.Mask mask, SVG.SvgElement svgElement, SVG.Box box) {
        float fG;
        float fH;
        y("Mask render", new Object[0]);
        Boolean bool = mask.f67485o;
        if (bool == null || !bool.booleanValue()) {
            SVG.Length length = mask.f67489s;
            float fE = length != null ? length.e(this, 1.0f) : 1.2f;
            SVG.Length length2 = mask.f67490t;
            float fE2 = length2 != null ? length2.e(this, 1.0f) : 1.2f;
            fG = fE * box.f67438c;
            fH = fE2 * box.f67439d;
        } else {
            SVG.Length length3 = mask.f67489s;
            fG = length3 != null ? length3.g(this) : box.f67438c;
            SVG.Length length4 = mask.f67490t;
            fH = length4 != null ? length4.h(this) : box.f67439d;
        }
        if (fG == 0.0f || fH == 0.0f) {
            return;
        }
        S0();
        RendererState rendererStateM = M(mask);
        this.f67642d = rendererStateM;
        rendererStateM.f67678a.f67527n = Float.valueOf(1.0f);
        boolean zM0 = m0();
        this.f67639a.save();
        Boolean bool2 = mask.f67486p;
        if (bool2 != null && !bool2.booleanValue()) {
            this.f67639a.translate(box.f67436a, box.f67437b);
            this.f67639a.scale(box.f67438c, box.f67439d);
        }
        F0(mask, false);
        this.f67639a.restore();
        if (zM0) {
            k0(svgElement, box);
        }
        R0();
    }

    private void K(SVG.Pattern pattern, String str) {
        SVG.SvgObject svgObjectV = pattern.f67601a.v(str);
        if (svgObjectV == null) {
            Z0("Pattern reference '%s' not found", str);
            return;
        }
        if (!(svgObjectV instanceof SVG.Pattern)) {
            F("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (svgObjectV == pattern) {
            F("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) svgObjectV;
        if (pattern.f67499q == null) {
            pattern.f67499q = pattern2.f67499q;
        }
        if (pattern.f67500r == null) {
            pattern.f67500r = pattern2.f67500r;
        }
        if (pattern.f67501s == null) {
            pattern.f67501s = pattern2.f67501s;
        }
        if (pattern.f67502t == null) {
            pattern.f67502t = pattern2.f67502t;
        }
        if (pattern.f67503u == null) {
            pattern.f67503u = pattern2.f67503u;
        }
        if (pattern.f67504v == null) {
            pattern.f67504v = pattern2.f67504v;
        }
        if (pattern.f67505w == null) {
            pattern.f67505w = pattern2.f67505w;
        }
        if (pattern.f67580i.isEmpty()) {
            pattern.f67580i = pattern2.f67580i;
        }
        if (pattern.f67609p == null) {
            pattern.f67609p = pattern2.f67609p;
        }
        if (pattern.f67603o == null) {
            pattern.f67603o = pattern2.f67603o;
        }
        String str2 = pattern2.f67506x;
        if (str2 != null) {
            K(pattern, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(SVG.Switch r8) {
        Set setA;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver sVGExternalFileResolverK = SVG.k();
        for (SVG.SvgObject svgObject : r8.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.b() == null && ((setA = svgConditional.a()) == null || (!setA.isEmpty() && setA.contains(language)))) {
                    Set setF = svgConditional.f();
                    if (setF != null) {
                        if (f67638i == null) {
                            V();
                        }
                        if (setF.isEmpty() || !f67638i.containsAll(setF)) {
                        }
                    }
                    Set setL = svgConditional.l();
                    if (setL != null) {
                        if (!setL.isEmpty() && sVGExternalFileResolverK != null) {
                            Iterator it = setL.iterator();
                            while (it.hasNext()) {
                                if (!sVGExternalFileResolverK.a((String) it.next())) {
                                    break;
                                }
                            }
                        }
                    }
                    Set setM = svgConditional.m();
                    if (setM != null) {
                        if (!setM.isEmpty() && sVGExternalFileResolverK != null) {
                            Iterator it2 = setM.iterator();
                            while (it2.hasNext()) {
                                if (sVGExternalFileResolverK.c((String) it2.next(), this.f67642d.f67678a.f67531r.intValue(), String.valueOf(this.f67642d.f67678a.f67532s)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    A0(svgObject);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L(com.caverock.androidsvg.SVG.SvgElement r21, android.graphics.Path r22, com.caverock.androidsvg.SVG.Pattern r23) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.L(com.caverock.androidsvg.SVG$SvgElement, android.graphics.Path, com.caverock.androidsvg.SVG$Pattern):void");
    }

    private void L0(SVG.TextPath textPath) {
        y(SbbqvQlxi.doAjjKIsUMFnln, new Object[0]);
        W0(this.f67642d, textPath);
        if (A() && Y0()) {
            SVG.SvgObject svgObjectV = textPath.f67601a.v(textPath.f67614o);
            if (svgObjectV == null) {
                F("TextPath reference '%s' not found", textPath.f67614o);
                return;
            }
            SVG.Path path = (SVG.Path) svgObjectV;
            Path pathF = new PathConverter(path.f67493o).f();
            Matrix matrix = path.f67465n;
            if (matrix != null) {
                pathF.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(pathF, false);
            SVG.Length length = textPath.f67615p;
            float fE = length != null ? length.e(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor textAnchorO = O();
            if (textAnchorO != SVG.Style.TextAnchor.Start) {
                float fN = n(textPath);
                if (textAnchorO == SVG.Style.TextAnchor.Middle) {
                    fN /= 2.0f;
                }
                fE -= fN;
            }
            r((SVG.SvgElement) textPath.d());
            boolean zM0 = m0();
            E(textPath, new PathTextDrawer(pathF, fE, 0.0f));
            if (zM0) {
                j0(textPath);
            }
        }
    }

    private RendererState M(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        V0(rendererState, SVG.Style.a());
        return N(svgObject, rendererState);
    }

    private boolean M0() {
        return this.f67642d.f67678a.f67527n.floatValue() < 1.0f || this.f67642d.f67678a.H != null;
    }

    private RendererState N(SVG.SvgObject svgObject, RendererState rendererState) {
        int i3;
        ArrayList arrayList = new ArrayList();
        while (true) {
            i3 = 0;
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            Object obj = svgObject.f67602b;
            if (obj == null) {
                break;
            }
            svgObject = (SVG.SvgObject) obj;
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            W0(rendererState, (SVG.SvgElementBase) obj2);
        }
        RendererState rendererState2 = this.f67642d;
        rendererState.f67684g = rendererState2.f67684g;
        rendererState.f67683f = rendererState2.f67683f;
        return rendererState;
    }

    private void N0() {
        this.f67642d = new RendererState();
        this.f67643e = new Stack();
        V0(this.f67642d, SVG.Style.a());
        RendererState rendererState = this.f67642d;
        rendererState.f67683f = null;
        rendererState.f67685h = false;
        this.f67643e.push(new RendererState(rendererState));
        this.f67645g = new Stack();
        this.f67644f = new Stack();
    }

    private SVG.Style.TextAnchor O() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.f67642d.f67678a;
        if (style.f67534u == SVG.Style.TextDirection.LTR || (textAnchor = style.f67535v) == SVG.Style.TextAnchor.Middle) {
            return style.f67535v;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
    }

    private void O0(float f3, float f4, float f5, float f6) {
        float fG = f5 + f3;
        float fH = f6 + f4;
        SVG.CSSClipRect cSSClipRect = this.f67642d.f67678a.f67537x;
        if (cSSClipRect != null) {
            f3 += cSSClipRect.f67443d.g(this);
            f4 += this.f67642d.f67678a.f67537x.f67440a.h(this);
            fG -= this.f67642d.f67678a.f67537x.f67441b.g(this);
            fH -= this.f67642d.f67678a.f67537x.f67442c.h(this);
        }
        this.f67639a.clipRect(f3, f4, fG, fH);
    }

    private Path.FillType P() {
        SVG.Style.FillRule fillRule = this.f67642d.f67678a.G;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void P0(RendererState rendererState, boolean z2, SVG.SvgPaint svgPaint) {
        int i3;
        SVG.Style style = rendererState.f67678a;
        float fFloatValue = (z2 ? style.f67518d : style.f67520g).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i3 = ((SVG.Colour) svgPaint).f67450a;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i3 = rendererState.f67678a.f67528o.f67450a;
        }
        int iX = x(i3, fFloatValue);
        if (z2) {
            rendererState.f67681d.setColor(iX);
        } else {
            rendererState.f67682e.setColor(iX);
        }
    }

    private void Q0(boolean z2, SVG.SolidColor solidColor) {
        if (z2) {
            if (W(solidColor.f67594e, 2147483648L)) {
                RendererState rendererState = this.f67642d;
                SVG.Style style = rendererState.f67678a;
                SVG.SvgPaint svgPaint = solidColor.f67594e.I;
                style.f67516b = svgPaint;
                rendererState.f67679b = svgPaint != null;
            }
            if (W(solidColor.f67594e, 4294967296L)) {
                this.f67642d.f67678a.f67518d = solidColor.f67594e.J;
            }
            if (W(solidColor.f67594e, 6442450944L)) {
                RendererState rendererState2 = this.f67642d;
                P0(rendererState2, z2, rendererState2.f67678a.f67516b);
                return;
            }
            return;
        }
        if (W(solidColor.f67594e, 2147483648L)) {
            RendererState rendererState3 = this.f67642d;
            SVG.Style style2 = rendererState3.f67678a;
            SVG.SvgPaint svgPaint2 = solidColor.f67594e.I;
            style2.f67519f = svgPaint2;
            rendererState3.f67680c = svgPaint2 != null;
        }
        if (W(solidColor.f67594e, 4294967296L)) {
            this.f67642d.f67678a.f67520g = solidColor.f67594e.J;
        }
        if (W(solidColor.f67594e, 6442450944L)) {
            RendererState rendererState4 = this.f67642d;
            P0(rendererState4, z2, rendererState4.f67678a.f67519f);
        }
    }

    private void R0() {
        this.f67639a.restore();
        this.f67642d = (RendererState) this.f67643e.pop();
    }

    private void S0() {
        this.f67639a.save();
        this.f67643e.push(this.f67642d);
        this.f67642d = new RendererState(this.f67642d);
    }

    private String T0(String str, boolean z2, boolean z3) {
        if (this.f67642d.f67685h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String strReplaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z2) {
            strReplaceAll = strReplaceAll.replaceAll("^\\s+", "");
        }
        if (z3) {
            strReplaceAll = strReplaceAll.replaceAll("\\s+$", "");
        }
        return strReplaceAll.replaceAll("\\s{2,}", " ");
    }

    private Path.FillType U() {
        SVG.Style.FillRule fillRule = this.f67642d.f67678a.f67517c;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void U0(SVG.SvgElement svgElement) {
        if (svgElement.f67602b == null || svgElement.f67591h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (((Matrix) this.f67645g.peek()).invert(matrix)) {
            SVG.Box box = svgElement.f67591h;
            float f3 = box.f67436a;
            float f4 = box.f67437b;
            float fB = box.b();
            SVG.Box box2 = svgElement.f67591h;
            float f5 = box2.f67437b;
            float fB2 = box2.b();
            float fC = svgElement.f67591h.c();
            SVG.Box box3 = svgElement.f67591h;
            float[] fArr = {f3, f4, fB, f5, fB2, fC, box3.f67436a, box3.c()};
            matrix.preConcat(this.f67639a.getMatrix());
            matrix.mapPoints(fArr);
            float f6 = fArr[0];
            float f7 = fArr[1];
            RectF rectF = new RectF(f6, f7, f6, f7);
            for (int i3 = 2; i3 <= 6; i3 += 2) {
                float f8 = fArr[i3];
                if (f8 < rectF.left) {
                    rectF.left = f8;
                }
                if (f8 > rectF.right) {
                    rectF.right = f8;
                }
                float f9 = fArr[i3 + 1];
                if (f9 < rectF.top) {
                    rectF.top = f9;
                }
                if (f9 > rectF.bottom) {
                    rectF.bottom = f9;
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.f67644f.peek();
            SVG.Box box4 = svgElement2.f67591h;
            if (box4 == null) {
                svgElement2.f67591h = SVG.Box.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box4.e(SVG.Box.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private static synchronized void V() {
        HashSet hashSet = new HashSet();
        f67638i = hashSet;
        hashSet.add("Structure");
        f67638i.add("BasicStructure");
        f67638i.add("ConditionalProcessing");
        f67638i.add("Image");
        f67638i.add("Style");
        f67638i.add("ViewportAttribute");
        f67638i.add("Shape");
        f67638i.add("BasicText");
        f67638i.add("PaintAttribute");
        f67638i.add("BasicPaintAttribute");
        f67638i.add("OpacityAttribute");
        f67638i.add("BasicGraphicsAttribute");
        f67638i.add("Marker");
        f67638i.add("Gradient");
        f67638i.add("Pattern");
        f67638i.add("Clip");
        f67638i.add("BasicClip");
        f67638i.add("Mask");
        f67638i.add("View");
    }

    private void V0(RendererState rendererState, SVG.Style style) {
        if (W(style, 4096L)) {
            rendererState.f67678a.f67528o = style.f67528o;
        }
        if (W(style, 2048L)) {
            rendererState.f67678a.f67527n = style.f67527n;
        }
        if (W(style, 1L)) {
            rendererState.f67678a.f67516b = style.f67516b;
            SVG.SvgPaint svgPaint = style.f67516b;
            rendererState.f67679b = (svgPaint == null || svgPaint == SVG.Colour.f67449c) ? false : true;
        }
        if (W(style, 4L)) {
            rendererState.f67678a.f67518d = style.f67518d;
        }
        if (W(style, 6149L)) {
            P0(rendererState, true, rendererState.f67678a.f67516b);
        }
        if (W(style, 2L)) {
            rendererState.f67678a.f67517c = style.f67517c;
        }
        if (W(style, 8L)) {
            rendererState.f67678a.f67519f = style.f67519f;
            SVG.SvgPaint svgPaint2 = style.f67519f;
            rendererState.f67680c = (svgPaint2 == null || svgPaint2 == SVG.Colour.f67449c) ? false : true;
        }
        if (W(style, 16L)) {
            rendererState.f67678a.f67520g = style.f67520g;
        }
        if (W(style, 6168L)) {
            P0(rendererState, false, rendererState.f67678a.f67519f);
        }
        if (W(style, 34359738368L)) {
            rendererState.f67678a.M = style.M;
        }
        if (W(style, 32L)) {
            SVG.Style style2 = rendererState.f67678a;
            SVG.Length length = style.f67521h;
            style2.f67521h = length;
            rendererState.f67682e.setStrokeWidth(length.c(this));
        }
        if (W(style, 64L)) {
            rendererState.f67678a.f67522i = style.f67522i;
            int i3 = AnonymousClass1.f67648b[style.f67522i.ordinal()];
            if (i3 == 1) {
                rendererState.f67682e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i3 == 2) {
                rendererState.f67682e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i3 == 3) {
                rendererState.f67682e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (W(style, 128L)) {
            rendererState.f67678a.f67523j = style.f67523j;
            int i4 = AnonymousClass1.f67649c[style.f67523j.ordinal()];
            if (i4 == 1) {
                rendererState.f67682e.setStrokeJoin(Paint.Join.MITER);
            } else if (i4 == 2) {
                rendererState.f67682e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i4 == 3) {
                rendererState.f67682e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (W(style, 256L)) {
            rendererState.f67678a.f67524k = style.f67524k;
            rendererState.f67682e.setStrokeMiter(style.f67524k.floatValue());
        }
        if (W(style, 512L)) {
            rendererState.f67678a.f67525l = style.f67525l;
        }
        if (W(style, 1024L)) {
            rendererState.f67678a.f67526m = style.f67526m;
        }
        Typeface typefaceT = null;
        if (W(style, 1536L)) {
            SVG.Length[] lengthArr = rendererState.f67678a.f67525l;
            if (lengthArr == null) {
                rendererState.f67682e.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i5 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i5];
                float f3 = 0.0f;
                for (int i6 = 0; i6 < i5; i6++) {
                    float fC = rendererState.f67678a.f67525l[i6 % length2].c(this);
                    fArr[i6] = fC;
                    f3 += fC;
                }
                if (f3 == 0.0f) {
                    rendererState.f67682e.setPathEffect(null);
                } else {
                    float fC2 = rendererState.f67678a.f67526m.c(this);
                    if (fC2 < 0.0f) {
                        fC2 = (fC2 % f3) + f3;
                    }
                    rendererState.f67682e.setPathEffect(new DashPathEffect(fArr, fC2));
                }
            }
        }
        if (W(style, 16384L)) {
            float fQ = Q();
            rendererState.f67678a.f67530q = style.f67530q;
            rendererState.f67681d.setTextSize(style.f67530q.e(this, fQ));
            rendererState.f67682e.setTextSize(style.f67530q.e(this, fQ));
        }
        if (W(style, 8192L)) {
            rendererState.f67678a.f67529p = style.f67529p;
        }
        if (W(style, 32768L)) {
            if (style.f67531r.intValue() == -1 && rendererState.f67678a.f67531r.intValue() > 100) {
                SVG.Style style3 = rendererState.f67678a;
                style3.f67531r = Integer.valueOf(style3.f67531r.intValue() - 100);
            } else if (style.f67531r.intValue() != 1 || rendererState.f67678a.f67531r.intValue() >= 900) {
                rendererState.f67678a.f67531r = style.f67531r;
            } else {
                SVG.Style style4 = rendererState.f67678a;
                style4.f67531r = Integer.valueOf(style4.f67531r.intValue() + 100);
            }
        }
        if (W(style, 65536L)) {
            rendererState.f67678a.f67532s = style.f67532s;
        }
        if (W(style, 106496L)) {
            if (rendererState.f67678a.f67529p != null && this.f67641c != null) {
                SVGExternalFileResolver sVGExternalFileResolverK = SVG.k();
                for (String str : rendererState.f67678a.f67529p) {
                    SVG.Style style5 = rendererState.f67678a;
                    Typeface typefaceT2 = t(str, style5.f67531r, style5.f67532s);
                    typefaceT = (typefaceT2 != null || sVGExternalFileResolverK == null) ? typefaceT2 : sVGExternalFileResolverK.c(str, rendererState.f67678a.f67531r.intValue(), String.valueOf(rendererState.f67678a.f67532s));
                    if (typefaceT != null) {
                        break;
                    }
                }
            }
            if (typefaceT == null) {
                SVG.Style style6 = rendererState.f67678a;
                typefaceT = t("serif", style6.f67531r, style6.f67532s);
            }
            rendererState.f67681d.setTypeface(typefaceT);
            rendererState.f67682e.setTypeface(typefaceT);
        }
        if (W(style, 131072L)) {
            rendererState.f67678a.f67533t = style.f67533t;
            Paint paint = rendererState.f67681d;
            SVG.Style.TextDecoration textDecoration = style.f67533t;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = rendererState.f67681d;
            SVG.Style.TextDecoration textDecoration3 = style.f67533t;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            rendererState.f67682e.setStrikeThruText(style.f67533t == textDecoration2);
            rendererState.f67682e.setUnderlineText(style.f67533t == textDecoration4);
        }
        if (W(style, 68719476736L)) {
            rendererState.f67678a.f67534u = style.f67534u;
        }
        if (W(style, 262144L)) {
            rendererState.f67678a.f67535v = style.f67535v;
        }
        if (W(style, 524288L)) {
            rendererState.f67678a.f67536w = style.f67536w;
        }
        if (W(style, 2097152L)) {
            rendererState.f67678a.f67538y = style.f67538y;
        }
        if (W(style, 4194304L)) {
            rendererState.f67678a.f67539z = style.f67539z;
        }
        if (W(style, 8388608L)) {
            rendererState.f67678a.A = style.A;
        }
        if (W(style, 16777216L)) {
            rendererState.f67678a.B = style.B;
        }
        if (W(style, 33554432L)) {
            rendererState.f67678a.C = style.C;
        }
        if (W(style, 1048576L)) {
            rendererState.f67678a.f67537x = style.f67537x;
        }
        if (W(style, 268435456L)) {
            rendererState.f67678a.F = style.F;
        }
        if (W(style, 536870912L)) {
            rendererState.f67678a.G = style.G;
        }
        if (W(style, 1073741824L)) {
            rendererState.f67678a.H = style.H;
        }
        if (W(style, 67108864L)) {
            rendererState.f67678a.D = style.D;
        }
        if (W(style, 134217728L)) {
            rendererState.f67678a.E = style.E;
        }
        if (W(style, 8589934592L)) {
            rendererState.f67678a.K = style.K;
        }
        if (W(style, 17179869184L)) {
            rendererState.f67678a.L = style.L;
        }
        if (W(style, 137438953472L)) {
            rendererState.f67678a.N = style.N;
        }
    }

    private boolean W(SVG.Style style, long j3) {
        return (style.f67515a & j3) != 0;
    }

    private void W0(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.f67678a.b(svgElementBase.f67602b == null);
        SVG.Style style = svgElementBase.f67594e;
        if (style != null) {
            V0(rendererState, style);
        }
        if (this.f67641c.q()) {
            for (CSSParser.Rule rule : this.f67641c.d()) {
                if (CSSParser.l(this.f67646h, rule.f67372a, svgElementBase)) {
                    V0(rendererState, rule.f67373b);
                }
            }
        }
        SVG.Style style2 = svgElementBase.f67595f;
        if (style2 != null) {
            V0(rendererState, style2);
        }
    }

    private void X(boolean z2, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float fE;
        float f3;
        float fE2;
        float f4;
        String str = svgLinearGradient.f67460l;
        if (str != null) {
            H(svgLinearGradient, str);
        }
        Boolean bool = svgLinearGradient.f67457i;
        int i3 = 0;
        boolean z3 = bool != null && bool.booleanValue();
        RendererState rendererState = this.f67642d;
        Paint paint = z2 ? rendererState.f67681d : rendererState.f67682e;
        if (z3) {
            SVG.Box boxS = S();
            SVG.Length length = svgLinearGradient.f67597m;
            float fG = length != null ? length.g(this) : 0.0f;
            SVG.Length length2 = svgLinearGradient.f67598n;
            fE = length2 != null ? length2.h(this) : 0.0f;
            SVG.Length length3 = svgLinearGradient.f67599o;
            float fG2 = length3 != null ? length3.g(this) : boxS.f67438c;
            SVG.Length length4 = svgLinearGradient.f67600p;
            f4 = fG2;
            f3 = fG;
            fE2 = length4 != null ? length4.h(this) : 0.0f;
        } else {
            SVG.Length length5 = svgLinearGradient.f67597m;
            float fE3 = length5 != null ? length5.e(this, 1.0f) : 0.0f;
            SVG.Length length6 = svgLinearGradient.f67598n;
            fE = length6 != null ? length6.e(this, 1.0f) : 0.0f;
            SVG.Length length7 = svgLinearGradient.f67599o;
            float fE4 = length7 != null ? length7.e(this, 1.0f) : 1.0f;
            SVG.Length length8 = svgLinearGradient.f67600p;
            f3 = fE3;
            fE2 = length8 != null ? length8.e(this, 1.0f) : 0.0f;
            f4 = fE4;
        }
        float f5 = fE;
        S0();
        this.f67642d = M(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z3) {
            matrix.preTranslate(box.f67436a, box.f67437b);
            matrix.preScale(box.f67438c, box.f67439d);
        }
        Matrix matrix2 = svgLinearGradient.f67458j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgLinearGradient.f67456h.size();
        if (size == 0) {
            R0();
            if (z2) {
                this.f67642d.f67679b = false;
                return;
            } else {
                this.f67642d.f67680c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = svgLinearGradient.f67456h.iterator();
        float f6 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) ((SVG.SvgObject) it.next());
            Float f7 = stop.f67514h;
            float fFloatValue = f7 != null ? f7.floatValue() : 0.0f;
            if (i3 == 0 || fFloatValue >= f6) {
                fArr[i3] = fFloatValue;
                f6 = fFloatValue;
            } else {
                fArr[i3] = f6;
            }
            S0();
            W0(this.f67642d, stop);
            SVG.Style style = this.f67642d.f67678a;
            SVG.Colour colour = (SVG.Colour) style.D;
            if (colour == null) {
                colour = SVG.Colour.f67448b;
            }
            iArr[i3] = x(colour.f67450a, style.E.floatValue());
            i3++;
            R0();
        }
        if ((f3 == f4 && f5 == fE2) || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgLinearGradient.f67459k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        R0();
        LinearGradient linearGradient = new LinearGradient(f3, f5, f4, fE2, iArr, fArr, tileMode2);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(w(this.f67642d.f67678a.f67518d.floatValue()));
    }

    private void X0() {
        int iX;
        SVG.Style style = this.f67642d.f67678a;
        SVG.SvgPaint svgPaint = style.K;
        if (svgPaint instanceof SVG.Colour) {
            iX = ((SVG.Colour) svgPaint).f67450a;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            iX = style.f67528o.f67450a;
        }
        Float f3 = style.L;
        if (f3 != null) {
            iX = x(iX, f3.floatValue());
        }
        this.f67639a.drawColor(iX);
    }

    private Path Y(SVG.Circle circle) {
        SVG.Length length = circle.f67444o;
        float fG = length != null ? length.g(this) : 0.0f;
        SVG.Length length2 = circle.f67445p;
        float fH = length2 != null ? length2.h(this) : 0.0f;
        float fC = circle.f67446q.c(this);
        float f3 = fG - fC;
        float f4 = fH - fC;
        float f5 = fG + fC;
        float f6 = fH + fC;
        if (circle.f67591h == null) {
            float f7 = 2.0f * fC;
            circle.f67591h = new SVG.Box(f3, f4, f7, f7);
        }
        float f8 = fC * 0.5522848f;
        Path path = new Path();
        path.moveTo(fG, f4);
        float f9 = fG + f8;
        float f10 = fH - f8;
        path.cubicTo(f9, f4, f5, f10, f5, fH);
        float f11 = fH + f8;
        path.cubicTo(f5, f11, f9, f6, fG, f6);
        float f12 = fG - f8;
        path.cubicTo(f12, f6, f3, f11, f3, fH);
        path.cubicTo(f3, f10, f12, f4, fG, f4);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y0() {
        Boolean bool = this.f67642d.f67678a.C;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private Path Z(SVG.Ellipse ellipse) {
        SVG.Length length = ellipse.f67452o;
        float fG = length != null ? length.g(this) : 0.0f;
        SVG.Length length2 = ellipse.f67453p;
        float fH = length2 != null ? length2.h(this) : 0.0f;
        float fG2 = ellipse.f67454q.g(this);
        float fH2 = ellipse.f67455r.h(this);
        float f3 = fG - fG2;
        float f4 = fH - fH2;
        float f5 = fG + fG2;
        float f6 = fH + fH2;
        if (ellipse.f67591h == null) {
            ellipse.f67591h = new SVG.Box(f3, f4, fG2 * 2.0f, 2.0f * fH2);
        }
        float f7 = fG2 * 0.5522848f;
        float f8 = fH2 * 0.5522848f;
        Path path = new Path();
        path.moveTo(fG, f4);
        float f9 = fG + f7;
        float f10 = fH - f8;
        path.cubicTo(f9, f4, f5, f10, f5, fH);
        float f11 = fH + f8;
        path.cubicTo(f5, f11, f9, f6, fG, f6);
        float f12 = fG - f7;
        path.cubicTo(f12, f6, f3, f11, f3, fH);
        path.cubicTo(f3, f10, f12, f4, fG, f4);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z0(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private Path a0(SVG.Line line) {
        SVG.Length length = line.f67475o;
        float fG = length == null ? 0.0f : length.g(this);
        SVG.Length length2 = line.f67476p;
        float fH = length2 == null ? 0.0f : length2.h(this);
        SVG.Length length3 = line.f67477q;
        float fG2 = length3 == null ? 0.0f : length3.g(this);
        SVG.Length length4 = line.f67478r;
        float fH2 = length4 != null ? length4.h(this) : 0.0f;
        if (line.f67591h == null) {
            line.f67591h = new SVG.Box(Math.min(fG, fG2), Math.min(fH, fH2), Math.abs(fG2 - fG), Math.abs(fH2 - fH));
        }
        Path path = new Path();
        path.moveTo(fG, fH);
        path.lineTo(fG2, fH2);
        return path;
    }

    private Path b0(SVG.PolyLine polyLine) {
        Path path = new Path();
        float[] fArr = polyLine.f67507o;
        path.moveTo(fArr[0], fArr[1]);
        int i3 = 2;
        while (true) {
            float[] fArr2 = polyLine.f67507o;
            if (i3 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i3], fArr2[i3 + 1]);
            i3 += 2;
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.f67591h == null) {
            polyLine.f67591h = m(path);
        }
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Path c0(com.caverock.androidsvg.SVG.Rect r20) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.c0(com.caverock.androidsvg.SVG$Rect):android.graphics.Path");
    }

    private Path d0(SVG.Text text) {
        List list = text.f67617o;
        float fH = 0.0f;
        float fG = (list == null || list.size() == 0) ? 0.0f : ((SVG.Length) text.f67617o.get(0)).g(this);
        List list2 = text.f67618p;
        float fH2 = (list2 == null || list2.size() == 0) ? 0.0f : ((SVG.Length) text.f67618p.get(0)).h(this);
        List list3 = text.f67619q;
        float fG2 = (list3 == null || list3.size() == 0) ? 0.0f : ((SVG.Length) text.f67619q.get(0)).g(this);
        List list4 = text.f67620r;
        if (list4 != null && list4.size() != 0) {
            fH = ((SVG.Length) text.f67620r.get(0)).h(this);
        }
        if (this.f67642d.f67678a.f67535v != SVG.Style.TextAnchor.Start) {
            float fN = n(text);
            if (this.f67642d.f67678a.f67535v == SVG.Style.TextAnchor.Middle) {
                fN /= 2.0f;
            }
            fG -= fN;
        }
        if (text.f67591h == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fG, fH2);
            E(text, textBoundsCalculator);
            RectF rectF = textBoundsCalculator.f67689d;
            text.f67591h = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.f67689d.height());
        }
        Path path = new Path();
        E(text, new PlainTextToPath(fG + fG2, fH2 + fH, path));
        return path;
    }

    private void e0(boolean z2, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f3;
        float fE;
        float f4;
        String str = svgRadialGradient.f67460l;
        if (str != null) {
            H(svgRadialGradient, str);
        }
        Boolean bool = svgRadialGradient.f67457i;
        int i3 = 0;
        boolean z3 = bool != null && bool.booleanValue();
        RendererState rendererState = this.f67642d;
        Paint paint = z2 ? rendererState.f67681d : rendererState.f67682e;
        if (z3) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = svgRadialGradient.f67604m;
            float fG = length2 != null ? length2.g(this) : length.g(this);
            SVG.Length length3 = svgRadialGradient.f67605n;
            float fH = length3 != null ? length3.h(this) : length.h(this);
            SVG.Length length4 = svgRadialGradient.f67606o;
            fE = length4 != null ? length4.c(this) : length.c(this);
            f3 = fG;
            f4 = fH;
        } else {
            SVG.Length length5 = svgRadialGradient.f67604m;
            float fE2 = length5 != null ? length5.e(this, 1.0f) : 0.5f;
            SVG.Length length6 = svgRadialGradient.f67605n;
            float fE3 = length6 != null ? length6.e(this, 1.0f) : 0.5f;
            SVG.Length length7 = svgRadialGradient.f67606o;
            f3 = fE2;
            fE = length7 != null ? length7.e(this, 1.0f) : 0.5f;
            f4 = fE3;
        }
        S0();
        this.f67642d = M(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z3) {
            matrix.preTranslate(box.f67436a, box.f67437b);
            matrix.preScale(box.f67438c, box.f67439d);
        }
        Matrix matrix2 = svgRadialGradient.f67458j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgRadialGradient.f67456h.size();
        if (size == 0) {
            R0();
            if (z2) {
                this.f67642d.f67679b = false;
                return;
            } else {
                this.f67642d.f67680c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = svgRadialGradient.f67456h.iterator();
        float f5 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) ((SVG.SvgObject) it.next());
            Float f6 = stop.f67514h;
            float fFloatValue = f6 != null ? f6.floatValue() : 0.0f;
            if (i3 == 0 || fFloatValue >= f5) {
                fArr[i3] = fFloatValue;
                f5 = fFloatValue;
            } else {
                fArr[i3] = f5;
            }
            S0();
            W0(this.f67642d, stop);
            SVG.Style style = this.f67642d.f67678a;
            SVG.Colour colour = (SVG.Colour) style.D;
            if (colour == null) {
                colour = SVG.Colour.f67448b;
            }
            iArr[i3] = x(colour.f67450a, style.E.floatValue());
            i3++;
            R0();
        }
        if (fE == 0.0f || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgRadialGradient.f67459k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        R0();
        RadialGradient radialGradient = new RadialGradient(f3, f4, fE, iArr, fArr, tileMode2);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(w(this.f67642d.f67678a.f67518d.floatValue()));
    }

    private SVG.Box f0(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float fG = length != null ? length.g(this) : 0.0f;
        float fH = length2 != null ? length2.h(this) : 0.0f;
        SVG.Box boxS = S();
        return new SVG.Box(fG, fH, length3 != null ? length3.g(this) : boxS.f67438c, length4 != null ? length4.h(this) : boxS.f67439d);
    }

    private Path g0(SVG.SvgElement svgElement, boolean z2) {
        Path pathD0;
        Path pathJ;
        this.f67643e.push(this.f67642d);
        RendererState rendererState = new RendererState(this.f67642d);
        this.f67642d = rendererState;
        W0(rendererState, svgElement);
        if (!A() || !Y0()) {
            this.f67642d = (RendererState) this.f67643e.pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z2) {
                F("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgObject svgObjectV = svgElement.f67601a.v(use.f67633p);
            if (svgObjectV == null) {
                F("Use reference '%s' not found", use.f67633p);
                this.f67642d = (RendererState) this.f67643e.pop();
                return null;
            }
            if (!(svgObjectV instanceof SVG.SvgElement)) {
                this.f67642d = (RendererState) this.f67643e.pop();
                return null;
            }
            pathD0 = g0((SVG.SvgElement) svgObjectV, false);
            if (pathD0 == null) {
                return null;
            }
            if (use.f67591h == null) {
                use.f67591h = m(pathD0);
            }
            Matrix matrix = use.f67466o;
            if (matrix != null) {
                pathD0.transform(matrix);
            }
        } else if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                pathD0 = new PathConverter(((SVG.Path) svgElement).f67493o).f();
                if (svgElement.f67591h == null) {
                    svgElement.f67591h = m(pathD0);
                }
            } else {
                pathD0 = svgElement instanceof SVG.Rect ? c0((SVG.Rect) svgElement) : svgElement instanceof SVG.Circle ? Y((SVG.Circle) svgElement) : svgElement instanceof SVG.Ellipse ? Z((SVG.Ellipse) svgElement) : svgElement instanceof SVG.PolyLine ? b0((SVG.PolyLine) svgElement) : null;
            }
            if (pathD0 == null) {
                return null;
            }
            if (graphicsElement.f67591h == null) {
                graphicsElement.f67591h = m(pathD0);
            }
            Matrix matrix2 = graphicsElement.f67465n;
            if (matrix2 != null) {
                pathD0.transform(matrix2);
            }
            pathD0.setFillType(P());
        } else {
            if (!(svgElement instanceof SVG.Text)) {
                F("Invalid %s element found in clipPath definition", svgElement.n());
                return null;
            }
            SVG.Text text = (SVG.Text) svgElement;
            pathD0 = d0(text);
            if (pathD0 == null) {
                return null;
            }
            Matrix matrix3 = text.f67613s;
            if (matrix3 != null) {
                pathD0.transform(matrix3);
            }
            pathD0.setFillType(P());
        }
        if (this.f67642d.f67678a.F != null && (pathJ = j(svgElement, svgElement.f67591h)) != null) {
            pathD0.op(pathJ, Path.Op.INTERSECT);
        }
        this.f67642d = (RendererState) this.f67643e.pop();
        return pathD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(float f3, float f4, float f5, float f6, float f7, boolean z2, boolean z3, float f8, float f9, SVG.PathInterface pathInterface) {
        if (f3 == f8 && f4 == f9) {
            return;
        }
        if (f5 == 0.0f || f6 == 0.0f) {
            pathInterface.c(f8, f9);
            return;
        }
        float fAbs = Math.abs(f5);
        float fAbs2 = Math.abs(f6);
        double radians = Math.toRadians(((double) f7) % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d3 = ((double) (f3 - f8)) / 2.0d;
        double d4 = ((double) (f4 - f9)) / 2.0d;
        double d5 = (dCos * d3) + (dSin * d4);
        double d6 = ((-dSin) * d3) + (dCos * d4);
        double d7 = fAbs * fAbs;
        double d8 = fAbs2 * fAbs2;
        double d9 = d5 * d5;
        double d10 = d6 * d6;
        double d11 = (d9 / d7) + (d10 / d8);
        if (d11 > 0.99999d) {
            double dSqrt = Math.sqrt(d11) * 1.00001d;
            fAbs = (float) (((double) fAbs) * dSqrt);
            fAbs2 = (float) (dSqrt * ((double) fAbs2));
            d7 = fAbs * fAbs;
            d8 = fAbs2 * fAbs2;
        }
        double d12 = z2 == z3 ? -1.0d : 1.0d;
        double d13 = d7 * d8;
        double d14 = d7 * d10;
        double d15 = d8 * d9;
        double d16 = ((d13 - d14) - d15) / (d14 + d15);
        if (d16 < 0.0d) {
            d16 = 0.0d;
        }
        double dSqrt2 = d12 * Math.sqrt(d16);
        double d17 = fAbs;
        double d18 = fAbs2;
        double d19 = ((d17 * d6) / d18) * dSqrt2;
        double d20 = (-((d18 * d5) / d17)) * dSqrt2;
        double d21 = (((double) (f3 + f8)) / 2.0d) + ((dCos * d19) - (dSin * d20));
        double d22 = (((double) (f4 + f9)) / 2.0d) + (dSin * d19) + (dCos * d20);
        double d23 = (d5 - d19) / d17;
        double d24 = (d6 - d20) / d18;
        double d25 = ((-d5) - d19) / d17;
        double d26 = ((-d6) - d20) / d18;
        double d27 = (d23 * d23) + (d24 * d24);
        double dAcos = (d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27));
        double dV = ((d23 * d26) - (d24 * d25) < 0.0d ? -1.0d : 1.0d) * v(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26))));
        if (!z3 && dV > 0.0d) {
            dV -= 6.283185307179586d;
        } else if (z3 && dV < 0.0d) {
            dV += 6.283185307179586d;
        }
        float[] fArrI = i(dAcos % 6.283185307179586d, dV % 6.283185307179586d);
        Matrix matrix = new Matrix();
        matrix.postScale(fAbs, fAbs2);
        matrix.postRotate(f7);
        matrix.postTranslate((float) d21, (float) d22);
        matrix.mapPoints(fArrI);
        fArrI[fArrI.length - 2] = f8;
        fArrI[fArrI.length - 1] = f9;
        for (int i3 = 0; i3 < fArrI.length; i3 += 6) {
            pathInterface.b(fArrI[i3], fArrI[i3 + 1], fArrI[i3 + 2], fArrI[i3 + 3], fArrI[i3 + 4], fArrI[i3 + 5]);
        }
    }

    private void h0() {
        this.f67644f.pop();
        this.f67645g.pop();
    }

    private static float[] i(double d3, double d4) {
        int iCeil = (int) Math.ceil((Math.abs(d4) * 2.0d) / 3.141592653589793d);
        double d5 = d4 / ((double) iCeil);
        double d6 = d5 / 2.0d;
        double dSin = (Math.sin(d6) * 1.3333333333333333d) / (Math.cos(d6) + 1.0d);
        float[] fArr = new float[iCeil * 6];
        int i3 = 0;
        int i4 = 0;
        while (i3 < iCeil) {
            double d7 = d3 + (((double) i3) * d5);
            double dCos = Math.cos(d7);
            double dSin2 = Math.sin(d7);
            float[] fArr2 = fArr;
            fArr2[i4] = (float) (dCos - (dSin * dSin2));
            fArr2[i4 + 1] = (float) (dSin2 + (dCos * dSin));
            double d8 = d7 + d5;
            double dCos2 = Math.cos(d8);
            double dSin3 = Math.sin(d8);
            fArr2[i4 + 2] = (float) ((dSin * dSin3) + dCos2);
            fArr2[i4 + 3] = (float) (dSin3 - (dSin * dCos2));
            int i5 = i4 + 5;
            fArr2[i4 + 4] = (float) dCos2;
            i4 += 6;
            fArr2[i5] = (float) dSin3;
            i3++;
            fArr = fArr2;
            iCeil = iCeil;
        }
        return fArr;
    }

    private void i0(SVG.SvgContainer svgContainer) {
        this.f67644f.push(svgContainer);
        this.f67645g.push(this.f67639a.getMatrix());
    }

    private Path j(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathG0;
        SVG.SvgObject svgObjectV = svgElement.f67601a.v(this.f67642d.f67678a.F);
        if (svgObjectV == null) {
            F("ClipPath reference '%s' not found", this.f67642d.f67678a.F);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) svgObjectV;
        this.f67643e.push(this.f67642d);
        this.f67642d = M(clipPath);
        Boolean bool = clipPath.f67447p;
        boolean z2 = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.f67436a, box.f67437b);
            matrix.preScale(box.f67438c, box.f67439d);
        }
        Matrix matrix2 = clipPath.f67466o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.f67580i) {
            if ((svgObject instanceof SVG.SvgElement) && (pathG0 = g0((SVG.SvgElement) svgObject, true)) != null) {
                path.op(pathG0, Path.Op.UNION);
            }
        }
        if (this.f67642d.f67678a.F != null) {
            if (clipPath.f67591h == null) {
                clipPath.f67591h = m(path);
            }
            Path pathJ = j(clipPath, clipPath.f67591h);
            if (pathJ != null) {
                path.op(pathJ, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f67642d = (RendererState) this.f67643e.pop();
        return path;
    }

    private void j0(SVG.SvgElement svgElement) {
        k0(svgElement, svgElement.f67591h);
    }

    private List k(SVG.Line line) {
        SVG.Length length = line.f67475o;
        float fG = length != null ? length.g(this) : 0.0f;
        SVG.Length length2 = line.f67476p;
        float fH = length2 != null ? length2.h(this) : 0.0f;
        SVG.Length length3 = line.f67477q;
        float fG2 = length3 != null ? length3.g(this) : 0.0f;
        SVG.Length length4 = line.f67478r;
        float fH2 = length4 != null ? length4.h(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f3 = fG2 - fG;
        float f4 = fH2 - fH;
        arrayList.add(new MarkerVector(fG, fH, f3, f4));
        arrayList.add(new MarkerVector(fG2, fH2, f3, f4));
        return arrayList;
    }

    private void k0(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.f67642d.f67678a.H != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            this.f67639a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.f67639a.saveLayer(null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) this.f67641c.v(this.f67642d.f67678a.H);
            J0(mask, svgElement, box);
            this.f67639a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            this.f67639a.saveLayer(null, paint3, 31);
            J0(mask, svgElement, box);
            this.f67639a.restore();
            this.f67639a.restore();
        }
        R0();
    }

    private List l(SVG.PolyLine polyLine) {
        int length = polyLine.f67507o.length;
        int i3 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = polyLine.f67507o;
        MarkerVector markerVector = new MarkerVector(fArr[0], fArr[1], 0.0f, 0.0f);
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < length) {
            float[] fArr2 = polyLine.f67507o;
            float f5 = fArr2[i3];
            float f6 = fArr2[i3 + 1];
            markerVector.a(f5, f6);
            arrayList.add(markerVector);
            i3 += 2;
            markerVector = new MarkerVector(f5, f6, f5 - markerVector.f67659a, f6 - markerVector.f67660b);
            f3 = f5;
            f4 = f6;
        }
        if (!(polyLine instanceof SVG.Polygon)) {
            arrayList.add(markerVector);
            return arrayList;
        }
        float[] fArr3 = polyLine.f67507o;
        float f7 = fArr3[0];
        if (f3 != f7) {
            float f8 = fArr3[1];
            if (f4 != f8) {
                markerVector.a(f7, f8);
                arrayList.add(markerVector);
                MarkerVector markerVector2 = new MarkerVector(f7, f8, f7 - markerVector.f67659a, f8 - markerVector.f67660b);
                markerVector2.b((MarkerVector) arrayList.get(0));
                arrayList.add(markerVector2);
                arrayList.set(0, markerVector2);
            }
        }
        return arrayList;
    }

    private void l0(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f3;
        float fH;
        float fG;
        SVG.Style.TextAnchor textAnchorO;
        if (textProcessor.a((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                S0();
                L0((SVG.TextPath) svgObject);
                R0();
                return;
            }
            if (!(svgObject instanceof SVG.TSpan)) {
                if (svgObject instanceof SVG.TRef) {
                    S0();
                    SVG.TRef tRef = (SVG.TRef) svgObject;
                    W0(this.f67642d, tRef);
                    if (A()) {
                        r((SVG.SvgElement) tRef.d());
                        SVG.SvgObject svgObjectV = svgObject.f67601a.v(tRef.f67610o);
                        if (svgObjectV == null || !(svgObjectV instanceof SVG.TextContainer)) {
                            F("Tref reference '%s' not found", tRef.f67610o);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            G((SVG.TextContainer) svgObjectV, sb);
                            if (sb.length() > 0) {
                                textProcessor.b(sb.toString());
                            }
                        }
                    }
                    R0();
                    return;
                }
                return;
            }
            y("TSpan render", new Object[0]);
            S0();
            SVG.TSpan tSpan = (SVG.TSpan) svgObject;
            W0(this.f67642d, tSpan);
            if (A()) {
                List list = tSpan.f67617o;
                boolean z2 = list != null && list.size() > 0;
                boolean z3 = textProcessor instanceof PlainTextDrawer;
                float fH2 = 0.0f;
                if (z3) {
                    float fG2 = !z2 ? ((PlainTextDrawer) textProcessor).f67671b : ((SVG.Length) tSpan.f67617o.get(0)).g(this);
                    List list2 = tSpan.f67618p;
                    fH = (list2 == null || list2.size() == 0) ? ((PlainTextDrawer) textProcessor).f67672c : ((SVG.Length) tSpan.f67618p.get(0)).h(this);
                    List list3 = tSpan.f67619q;
                    fG = (list3 == null || list3.size() == 0) ? 0.0f : ((SVG.Length) tSpan.f67619q.get(0)).g(this);
                    List list4 = tSpan.f67620r;
                    if (list4 != null && list4.size() != 0) {
                        fH2 = ((SVG.Length) tSpan.f67620r.get(0)).h(this);
                    }
                    f3 = fH2;
                    fH2 = fG2;
                } else {
                    f3 = 0.0f;
                    fH = 0.0f;
                    fG = 0.0f;
                }
                if (z2 && (textAnchorO = O()) != SVG.Style.TextAnchor.Start) {
                    float fN = n(tSpan);
                    if (textAnchorO == SVG.Style.TextAnchor.Middle) {
                        fN /= 2.0f;
                    }
                    fH2 -= fN;
                }
                r((SVG.SvgElement) tSpan.d());
                if (z3) {
                    PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                    plainTextDrawer.f67671b = fH2 + fG;
                    plainTextDrawer.f67672c = fH + f3;
                }
                boolean zM0 = m0();
                E(tSpan, textProcessor);
                if (zM0) {
                    j0(tSpan);
                }
            }
            R0();
        }
    }

    private SVG.Box m(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private boolean m0() {
        SVG.SvgObject svgObjectV;
        if (!M0()) {
            return false;
        }
        this.f67639a.saveLayerAlpha(null, w(this.f67642d.f67678a.f67527n.floatValue()), 31);
        this.f67643e.push(this.f67642d);
        RendererState rendererState = new RendererState(this.f67642d);
        this.f67642d = rendererState;
        String str = rendererState.f67678a.H;
        if (str != null && ((svgObjectV = this.f67641c.v(str)) == null || !(svgObjectV instanceof SVG.Mask))) {
            F("Mask reference '%s' not found", this.f67642d.f67678a.H);
            this.f67642d.f67678a.H = null;
        }
        return true;
    }

    private float n(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        E(textContainer, textWidthCalculator);
        return textWidthCalculator.f67692b;
    }

    private MarkerVector n0(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float fD = D(markerVector2.f67661c, markerVector2.f67662d, markerVector2.f67659a - markerVector.f67659a, markerVector2.f67660b - markerVector.f67660b);
        if (fD == 0.0f) {
            fD = D(markerVector2.f67661c, markerVector2.f67662d, markerVector3.f67659a - markerVector2.f67659a, markerVector3.f67660b - markerVector2.f67660b);
        }
        if (fD > 0.0f || (fD == 0.0f && (markerVector2.f67661c > 0.0f || markerVector2.f67662d >= 0.0f))) {
            return markerVector2;
        }
        markerVector2.f67661c = -markerVector2.f67661c;
        markerVector2.f67662d = -markerVector2.f67662d;
        return markerVector2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r12 != 8) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Matrix o(com.caverock.androidsvg.SVG.Box r10, com.caverock.androidsvg.SVG.Box r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L9d
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.a()
            if (r1 != 0) goto Lf
            goto L9d
        Lf:
            float r1 = r10.f67438c
            float r2 = r11.f67438c
            float r1 = r1 / r2
            float r2 = r10.f67439d
            float r3 = r11.f67439d
            float r2 = r2 / r3
            float r3 = r11.f67436a
            float r3 = -r3
            float r4 = r11.f67437b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.f67394d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.f67436a
            float r10 = r10.f67437b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.f67438c
            float r2 = r2 / r1
            float r5 = r10.f67439d
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.SVGAndroidRenderer.AnonymousClass1.f67647a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L63;
                case 2: goto L63;
                case 3: goto L63;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L68
        L5e:
            float r7 = r11.f67438c
            float r7 = r7 - r2
        L61:
            float r3 = r3 - r7
            goto L68
        L63:
            float r7 = r11.f67438c
            float r7 = r7 - r2
            float r7 = r7 / r8
            goto L61
        L68:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L8b
            r2 = 3
            if (r12 == r2) goto L86
            r2 = 5
            if (r12 == r2) goto L8b
            r2 = 6
            if (r12 == r2) goto L86
            r2 = 7
            if (r12 == r2) goto L8b
            r2 = 8
            if (r12 == r2) goto L86
            goto L90
        L86:
            float r11 = r11.f67439d
            float r11 = r11 - r5
        L89:
            float r4 = r4 - r11
            goto L90
        L8b:
            float r11 = r11.f67439d
            float r11 = r11 - r5
            float r11 = r11 / r8
            goto L89
        L90:
            float r11 = r10.f67436a
            float r10 = r10.f67437b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.o(com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void o0(SVG.Circle circle) {
        y("Circle render", new Object[0]);
        SVG.Length length = circle.f67446q;
        if (length == null || length.j()) {
            return;
        }
        W0(this.f67642d, circle);
        if (A() && Y0()) {
            Matrix matrix = circle.f67465n;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            Path pathY = Y(circle);
            U0(circle);
            r(circle);
            p(circle);
            boolean zM0 = m0();
            if (this.f67642d.f67679b) {
                B(circle, pathY);
            }
            if (this.f67642d.f67680c) {
                C(pathY);
            }
            if (zM0) {
                j0(circle);
            }
        }
    }

    private void p(SVG.SvgElement svgElement) {
        q(svgElement, svgElement.f67591h);
    }

    private void p0(SVG.Ellipse ellipse) {
        y("Ellipse render", new Object[0]);
        SVG.Length length = ellipse.f67454q;
        if (length == null || ellipse.f67455r == null || length.j() || ellipse.f67455r.j()) {
            return;
        }
        W0(this.f67642d, ellipse);
        if (A() && Y0()) {
            Matrix matrix = ellipse.f67465n;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            Path pathZ = Z(ellipse);
            U0(ellipse);
            r(ellipse);
            p(ellipse);
            boolean zM0 = m0();
            if (this.f67642d.f67679b) {
                B(ellipse, pathZ);
            }
            if (this.f67642d.f67680c) {
                C(pathZ);
            }
            if (zM0) {
                j0(ellipse);
            }
        }
    }

    private void q(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathJ;
        if (this.f67642d.f67678a.F == null || (pathJ = j(svgElement, box)) == null) {
            return;
        }
        this.f67639a.clipPath(pathJ);
    }

    private void q0(SVG.Group group) {
        y("Group render", new Object[0]);
        W0(this.f67642d, group);
        if (A()) {
            Matrix matrix = group.f67466o;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            p(group);
            boolean zM0 = m0();
            F0(group, true);
            if (zM0) {
                j0(group);
            }
            U0(group);
        }
    }

    private void r(SVG.SvgElement svgElement) {
        SVG.SvgPaint svgPaint = this.f67642d.f67678a.f67516b;
        if (svgPaint instanceof SVG.PaintReference) {
            z(true, svgElement.f67591h, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.f67642d.f67678a.f67519f;
        if (svgPaint2 instanceof SVG.PaintReference) {
            z(false, svgElement.f67591h, (SVG.PaintReference) svgPaint2);
        }
    }

    private void r0(SVG.Image image) {
        SVG.Length length;
        String str;
        y("Image render", new Object[0]);
        SVG.Length length2 = image.f67470s;
        if (length2 == null || length2.j() || (length = image.f67471t) == null || length.j() || (str = image.f67467p) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.f67603o;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f67395e;
        }
        Bitmap bitmapS = s(str);
        if (bitmapS == null) {
            SVGExternalFileResolver sVGExternalFileResolverK = SVG.k();
            if (sVGExternalFileResolverK == null) {
                return;
            } else {
                bitmapS = sVGExternalFileResolverK.d(image.f67467p);
            }
        }
        if (bitmapS == null) {
            F("Could not locate image '%s'", image.f67467p);
            return;
        }
        SVG.Box box = new SVG.Box(0.0f, 0.0f, bitmapS.getWidth(), bitmapS.getHeight());
        W0(this.f67642d, image);
        if (A() && Y0()) {
            Matrix matrix = image.f67472u;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            SVG.Length length3 = image.f67468q;
            float fG = length3 != null ? length3.g(this) : 0.0f;
            SVG.Length length4 = image.f67469r;
            this.f67642d.f67683f = new SVG.Box(fG, length4 != null ? length4.h(this) : 0.0f, image.f67470s.g(this), image.f67471t.g(this));
            if (!this.f67642d.f67678a.f67536w.booleanValue()) {
                SVG.Box box2 = this.f67642d.f67683f;
                O0(box2.f67436a, box2.f67437b, box2.f67438c, box2.f67439d);
            }
            image.f67591h = this.f67642d.f67683f;
            U0(image);
            p(image);
            boolean zM0 = m0();
            X0();
            this.f67639a.save();
            this.f67639a.concat(o(this.f67642d.f67683f, box, preserveAspectRatio));
            this.f67639a.drawBitmap(bitmapS, 0.0f, 0.0f, new Paint(this.f67642d.f67678a.N != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.f67639a.restore();
            if (zM0) {
                j0(image);
            }
        }
    }

    private Bitmap s(String str) {
        int iIndexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (iIndexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e3) {
            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e3);
            return null;
        }
    }

    private void s0(SVG.Line line) {
        y("Line render", new Object[0]);
        W0(this.f67642d, line);
        if (A() && Y0() && this.f67642d.f67680c) {
            Matrix matrix = line.f67465n;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            Path pathA0 = a0(line);
            U0(line);
            r(line);
            p(line);
            boolean zM0 = m0();
            C(pathA0);
            I0(line);
            if (zM0) {
                j0(line);
            }
        }
    }

    private Typeface t(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        int i3;
        boolean z2 = fontStyle == SVG.Style.FontStyle.Italic;
        i3 = num.intValue() > 500 ? z2 ? 3 : 1 : z2 ? 2 : 0;
        str.getClass();
        switch (str) {
            case "sans-serif":
                return Typeface.create(Typeface.SANS_SERIF, i3);
            case "monospace":
                return Typeface.create(Typeface.MONOSPACE, i3);
            case "fantasy":
                return Typeface.create(Typeface.SANS_SERIF, i3);
            case "serif":
                return Typeface.create(Typeface.SERIF, i3);
            case "cursive":
                return Typeface.create(Typeface.SANS_SERIF, i3);
            default:
                return null;
        }
    }

    private void t0(SVG.Path path) {
        y("Path render", new Object[0]);
        if (path.f67493o == null) {
            return;
        }
        W0(this.f67642d, path);
        if (A() && Y0()) {
            RendererState rendererState = this.f67642d;
            if (rendererState.f67680c || rendererState.f67679b) {
                Matrix matrix = path.f67465n;
                if (matrix != null) {
                    this.f67639a.concat(matrix);
                }
                Path pathF = new PathConverter(path.f67493o).f();
                if (path.f67591h == null) {
                    path.f67591h = m(pathF);
                }
                U0(path);
                r(path);
                p(path);
                boolean zM0 = m0();
                if (this.f67642d.f67679b) {
                    pathF.setFillType(U());
                    B(path, pathF);
                }
                if (this.f67642d.f67680c) {
                    C(pathF);
                }
                I0(path);
                if (zM0) {
                    j0(path);
                }
            }
        }
    }

    private void u(SVG.SvgObject svgObject) {
        Boolean bool;
        if ((svgObject instanceof SVG.SvgElementBase) && (bool = ((SVG.SvgElementBase) svgObject).f67593d) != null) {
            this.f67642d.f67685h = bool.booleanValue();
        }
    }

    private void u0(SVG.PolyLine polyLine) {
        y("PolyLine render", new Object[0]);
        W0(this.f67642d, polyLine);
        if (A() && Y0()) {
            RendererState rendererState = this.f67642d;
            if (rendererState.f67680c || rendererState.f67679b) {
                Matrix matrix = polyLine.f67465n;
                if (matrix != null) {
                    this.f67639a.concat(matrix);
                }
                if (polyLine.f67507o.length < 2) {
                    return;
                }
                Path pathB0 = b0(polyLine);
                U0(polyLine);
                pathB0.setFillType(U());
                r(polyLine);
                p(polyLine);
                boolean zM0 = m0();
                if (this.f67642d.f67679b) {
                    B(polyLine, pathB0);
                }
                if (this.f67642d.f67680c) {
                    C(pathB0);
                }
                I0(polyLine);
                if (zM0) {
                    j0(polyLine);
                }
            }
        }
    }

    private static double v(double d3) {
        if (d3 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d3 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d3);
    }

    private void v0(SVG.Polygon polygon) {
        y("Polygon render", new Object[0]);
        W0(this.f67642d, polygon);
        if (A() && Y0()) {
            RendererState rendererState = this.f67642d;
            if (rendererState.f67680c || rendererState.f67679b) {
                Matrix matrix = polygon.f67465n;
                if (matrix != null) {
                    this.f67639a.concat(matrix);
                }
                if (polygon.f67507o.length < 2) {
                    return;
                }
                Path pathB0 = b0(polygon);
                U0(polygon);
                r(polygon);
                p(polygon);
                boolean zM0 = m0();
                if (this.f67642d.f67679b) {
                    B(polygon, pathB0);
                }
                if (this.f67642d.f67680c) {
                    C(pathB0);
                }
                I0(polygon);
                if (zM0) {
                    j0(polygon);
                }
            }
        }
    }

    private static int w(float f3) {
        int i3 = (int) (f3 * 256.0f);
        if (i3 < 0) {
            return 0;
        }
        if (i3 > 255) {
            return 255;
        }
        return i3;
    }

    private void w0(SVG.Rect rect) {
        y("Rect render", new Object[0]);
        SVG.Length length = rect.f67510q;
        if (length == null || rect.f67511r == null || length.j() || rect.f67511r.j()) {
            return;
        }
        W0(this.f67642d, rect);
        if (A() && Y0()) {
            Matrix matrix = rect.f67465n;
            if (matrix != null) {
                this.f67639a.concat(matrix);
            }
            Path pathC0 = c0(rect);
            U0(rect);
            r(rect);
            p(rect);
            boolean zM0 = m0();
            if (this.f67642d.f67679b) {
                B(rect, pathC0);
            }
            if (this.f67642d.f67680c) {
                C(pathC0);
            }
            if (zM0) {
                j0(rect);
            }
        }
    }

    private static int x(int i3, float f3) {
        int i4 = 255;
        int iRound = Math.round(((i3 >> 24) & 255) * f3);
        if (iRound < 0) {
            i4 = 0;
        } else if (iRound <= 255) {
            i4 = iRound;
        }
        return (i3 & 16777215) | (i4 << 24);
    }

    private void x0(SVG.Svg svg) {
        z0(svg, f0(svg.f67575q, svg.f67576r, svg.f67577s, svg.f67578t), svg.f67609p, svg.f67603o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str, Object... objArr) {
    }

    private void y0(SVG.Svg svg, SVG.Box box) {
        z0(svg, box, svg.f67609p, svg.f67603o);
    }

    private void z(boolean z2, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject svgObjectV = this.f67641c.v(paintReference.f67491a);
        if (svgObjectV == null) {
            F("%s reference '%s' not found", z2 ? "Fill" : "Stroke", paintReference.f67491a);
            SVG.SvgPaint svgPaint = paintReference.f67492b;
            if (svgPaint != null) {
                P0(this.f67642d, z2, svgPaint);
                return;
            } else if (z2) {
                this.f67642d.f67679b = false;
                return;
            } else {
                this.f67642d.f67680c = false;
                return;
            }
        }
        if (svgObjectV instanceof SVG.SvgLinearGradient) {
            X(z2, box, (SVG.SvgLinearGradient) svgObjectV);
        } else if (svgObjectV instanceof SVG.SvgRadialGradient) {
            e0(z2, box, (SVG.SvgRadialGradient) svgObjectV);
        } else if (svgObjectV instanceof SVG.SolidColor) {
            Q0(z2, (SVG.SolidColor) svgObjectV);
        }
    }

    private void z0(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        y("Svg render", new Object[0]);
        if (box.f67438c == 0.0f || box.f67439d == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = svg.f67603o) == null) {
            preserveAspectRatio = PreserveAspectRatio.f67395e;
        }
        W0(this.f67642d, svg);
        if (A()) {
            RendererState rendererState = this.f67642d;
            rendererState.f67683f = box;
            if (!rendererState.f67678a.f67536w.booleanValue()) {
                SVG.Box box3 = this.f67642d.f67683f;
                O0(box3.f67436a, box3.f67437b, box3.f67438c, box3.f67439d);
            }
            q(svg, this.f67642d.f67683f);
            if (box2 != null) {
                this.f67639a.concat(o(this.f67642d.f67683f, box2, preserveAspectRatio));
                this.f67642d.f67684g = svg.f67609p;
            } else {
                Canvas canvas = this.f67639a;
                SVG.Box box4 = this.f67642d.f67683f;
                canvas.translate(box4.f67436a, box4.f67437b);
            }
            boolean zM0 = m0();
            X0();
            F0(svg, true);
            if (zM0) {
                j0(svg);
            }
            U0(svg);
        }
    }

    void G0(SVG svg, RenderOptions renderOptions) {
        SVG.Box box;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptions == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.f67641c = svg;
        SVG.Svg svgP = svg.p();
        if (svgP == null) {
            Z0("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.e()) {
            SVG.SvgElementBase svgElementBaseJ = this.f67641c.j(renderOptions.f67425e);
            if (svgElementBaseJ == null || !(svgElementBaseJ instanceof SVG.View)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", renderOptions.f67425e));
                return;
            }
            SVG.View view = (SVG.View) svgElementBaseJ;
            box = view.f67609p;
            if (box == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.f67425e));
                return;
            }
            preserveAspectRatio = view.f67603o;
        } else {
            box = renderOptions.f() ? renderOptions.f67424d : svgP.f67609p;
            preserveAspectRatio = renderOptions.c() ? renderOptions.f67422b : svgP.f67603o;
        }
        if (renderOptions.b()) {
            svg.a(renderOptions.f67421a);
        }
        if (renderOptions.d()) {
            CSSParser.RuleMatchContext ruleMatchContext = new CSSParser.RuleMatchContext();
            this.f67646h = ruleMatchContext;
            ruleMatchContext.f67375a = svg.j(renderOptions.f67423c);
        }
        N0();
        u(svgP);
        S0();
        SVG.Box box2 = new SVG.Box(renderOptions.f67426f);
        SVG.Length length = svgP.f67577s;
        if (length != null) {
            box2.f67438c = length.e(this, box2.f67438c);
        }
        SVG.Length length2 = svgP.f67578t;
        if (length2 != null) {
            box2.f67439d = length2.e(this, box2.f67439d);
        }
        z0(svgP, box2, box, preserveAspectRatio);
        R0();
        if (renderOptions.b()) {
            svg.b();
        }
    }

    float Q() {
        return this.f67642d.f67681d.getTextSize();
    }

    float R() {
        return this.f67642d.f67681d.getTextSize() / 2.0f;
    }

    SVG.Box S() {
        RendererState rendererState = this.f67642d;
        SVG.Box box = rendererState.f67684g;
        return box != null ? box : rendererState.f67683f;
    }

    float T() {
        return this.f67640b;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TextWidthCalculator extends TextProcessor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f67692b;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.f67692b = 0.0f;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void b(String str) {
            this.f67692b += SVGAndroidRenderer.this.f67642d.f67681d.measureText(str);
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RendererState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SVG.Style f67678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f67679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f67680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f67681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f67682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SVG.Box f67683f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        SVG.Box f67684g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f67685h;

        RendererState() {
            Paint paint = new Paint();
            this.f67681d = paint;
            paint.setFlags(193);
            this.f67681d.setHinting(0);
            this.f67681d.setStyle(Paint.Style.FILL);
            Paint paint2 = this.f67681d;
            Typeface typeface = Typeface.DEFAULT;
            paint2.setTypeface(typeface);
            Paint paint3 = new Paint();
            this.f67682e = paint3;
            paint3.setFlags(193);
            this.f67682e.setHinting(0);
            this.f67682e.setStyle(Paint.Style.STROKE);
            this.f67682e.setTypeface(typeface);
            this.f67678a = SVG.Style.a();
        }

        RendererState(RendererState rendererState) {
            this.f67679b = rendererState.f67679b;
            this.f67680c = rendererState.f67680c;
            this.f67681d = new Paint(rendererState.f67681d);
            this.f67682e = new Paint(rendererState.f67682e);
            SVG.Box box = rendererState.f67683f;
            if (box != null) {
                this.f67683f = new SVG.Box(box);
            }
            SVG.Box box2 = rendererState.f67684g;
            if (box2 != null) {
                this.f67684g = new SVG.Box(box2);
            }
            this.f67685h = rendererState.f67685h;
            try {
                this.f67678a = (SVG.Style) rendererState.f67678a.clone();
            } catch (CloneNotSupportedException e3) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e3);
                this.f67678a = SVG.Style.a();
            }
        }
    }
}
