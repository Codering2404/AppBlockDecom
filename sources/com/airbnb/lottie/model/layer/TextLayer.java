package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TextLayer extends BaseLayer {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map I;
    private final LongSparseArray J;
    private final List K;
    private final TextKeyframeAnimation L;
    private final LottieDrawable M;
    private final LottieComposition N;
    private BaseKeyframeAnimation O;
    private BaseKeyframeAnimation P;
    private BaseKeyframeAnimation Q;
    private BaseKeyframeAnimation R;
    private BaseKeyframeAnimation S;
    private BaseKeyframeAnimation T;
    private BaseKeyframeAnimation U;
    private BaseKeyframeAnimation V;
    private BaseKeyframeAnimation W;
    private BaseKeyframeAnimation X;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56929a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f56929a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56929a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56929a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TextSubLine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f56930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f56931b;

        private TextSubLine() {
            this.f56930a = "";
            this.f56931b = 0.0f;
        }

        void c(String str, float f3) {
            this.f56930a = str;
            this.f56931b = f3;
        }
    }

    TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        int i3 = 1;
        this.G = new Paint(i3) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.H = new Paint(i3) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.I = new HashMap();
        this.J = new LongSparseArray();
        this.K = new ArrayList();
        this.M = lottieDrawable;
        this.N = layer.b();
        TextKeyframeAnimation textKeyframeAnimationA = layer.s().a();
        this.L = textKeyframeAnimationA;
        textKeyframeAnimationA.a(this);
        j(textKeyframeAnimationA);
        AnimatableTextProperties animatableTextPropertiesT = layer.t();
        if (animatableTextPropertiesT != null && (animatableColorValue2 = animatableTextPropertiesT.f56721a) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA = animatableColorValue2.a();
            this.O = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            j(this.O);
        }
        if (animatableTextPropertiesT != null && (animatableColorValue = animatableTextPropertiesT.f56722b) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA2 = animatableColorValue.a();
            this.Q = baseKeyframeAnimationA2;
            baseKeyframeAnimationA2.a(this);
            j(this.Q);
        }
        if (animatableTextPropertiesT != null && (animatableFloatValue2 = animatableTextPropertiesT.f56723c) != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA3 = animatableFloatValue2.a();
            this.S = baseKeyframeAnimationA3;
            baseKeyframeAnimationA3.a(this);
            j(this.S);
        }
        if (animatableTextPropertiesT == null || (animatableFloatValue = animatableTextPropertiesT.f56724d) == null) {
            return;
        }
        BaseKeyframeAnimation baseKeyframeAnimationA4 = animatableFloatValue.a();
        this.U = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        j(this.U);
    }

    private String O(String str, int i3) {
        int iCodePointAt = str.codePointAt(i3);
        int iCharCount = Character.charCount(iCodePointAt) + i3;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!c0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j3 = iCodePointAt;
        if (this.J.e(j3)) {
            return (String) this.J.g(j3);
        }
        this.D.setLength(0);
        while (i3 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i3);
            this.D.appendCodePoint(iCodePointAt3);
            i3 += Character.charCount(iCodePointAt3);
        }
        String string = this.D.toString();
        this.J.m(j3, string);
        return string;
    }

    private void P(DocumentData documentData, Matrix matrix) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.P;
        if (baseKeyframeAnimation != null) {
            this.G.setColor(((Integer) baseKeyframeAnimation.h()).intValue());
        } else {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.O;
            if (baseKeyframeAnimation2 != null) {
                this.G.setColor(((Integer) baseKeyframeAnimation2.h()).intValue());
            } else {
                this.G.setColor(documentData.f56687h);
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.R;
        if (baseKeyframeAnimation3 != null) {
            this.H.setColor(((Integer) baseKeyframeAnimation3.h()).intValue());
        } else {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                this.H.setColor(((Integer) baseKeyframeAnimation4.h()).intValue());
            } else {
                this.H.setColor(documentData.f56688i);
            }
        }
        int iIntValue = ((this.f56882x.h() == null ? 100 : ((Integer) this.f56882x.h().h()).intValue()) * 255) / 100;
        this.G.setAlpha(iIntValue);
        this.H.setAlpha(iIntValue);
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.T;
        if (baseKeyframeAnimation5 != null) {
            this.H.setStrokeWidth(((Float) baseKeyframeAnimation5.h()).floatValue());
            return;
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.S;
        if (baseKeyframeAnimation6 != null) {
            this.H.setStrokeWidth(((Float) baseKeyframeAnimation6.h()).floatValue());
        } else {
            this.H.setStrokeWidth(documentData.f56689j * Utils.e());
        }
    }

    private void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void R(FontCharacter fontCharacter, float f3, DocumentData documentData, Canvas canvas) {
        List listZ = Z(fontCharacter);
        for (int i3 = 0; i3 < listZ.size(); i3++) {
            Path pathG = ((ContentGroup) listZ.get(i3)).g();
            pathG.computeBounds(this.E, false);
            this.F.reset();
            this.F.preTranslate(0.0f, (-documentData.f56686g) * Utils.e());
            this.F.preScale(f3, f3);
            pathG.transform(this.F);
            if (documentData.f56690k) {
                U(pathG, this.G, canvas);
                U(pathG, this.H, canvas);
            } else {
                U(pathG, this.H, canvas);
                U(pathG, this.G, canvas);
            }
        }
    }

    private void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f56690k) {
            Q(str, this.G, canvas);
            Q(str, this.H, canvas);
        } else {
            Q(str, this.H, canvas);
            Q(str, this.G, canvas);
        }
    }

    private void T(String str, DocumentData documentData, Canvas canvas, float f3) {
        int length = 0;
        while (length < str.length()) {
            String strO = O(str, length);
            length += strO.length();
            S(strO, documentData, canvas);
            canvas.translate(this.G.measureText(strO) + f3, 0.0f);
        }
    }

    private void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void V(String str, DocumentData documentData, Font font, Canvas canvas, float f3, float f4, float f5) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            FontCharacter fontCharacter = (FontCharacter) this.N.c().g(FontCharacter.c(str.charAt(i3), font.a(), font.c()));
            if (fontCharacter != null) {
                R(fontCharacter, f4, documentData, canvas);
                canvas.translate((((float) fontCharacter.b()) * f4 * Utils.e()) + f5, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void W(com.airbnb.lottie.model.DocumentData r13, com.airbnb.lottie.model.Font r14, android.graphics.Canvas r15) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.W(com.airbnb.lottie.model.DocumentData, com.airbnb.lottie.model.Font, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X(com.airbnb.lottie.model.DocumentData r17, android.graphics.Matrix r18, com.airbnb.lottie.model.Font r19, android.graphics.Canvas r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r1 = r0.W
            if (r1 == 0) goto L13
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L15
        L13:
            float r1 = r7.f56682c
        L15:
            r2 = 1120403456(0x42c80000, float:100.0)
            float r4 = r1 / r2
            float r8 = com.airbnb.lottie.utils.Utils.f(r18)
            java.lang.String r1 = r7.f56680a
            java.util.List r9 = r0.a0(r1)
            int r10 = r9.size()
            int r1 = r7.f56684e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r2 = r0.V
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L3b:
            float r1 = r1 + r2
        L3c:
            r5 = r1
            goto L4d
        L3e:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r2 = r0.U
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L3b
        L4d:
            r11 = 0
            r1 = -1
            r12 = r1
            r13 = r11
        L51:
            if (r13 >= r10) goto La7
            java.lang.Object r1 = r9.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r2 = r7.f56692m
            if (r2 != 0) goto L5f
            r2 = 0
            goto L61
        L5f:
            float r2 = r2.x
        L61:
            r6 = 1
            r3 = r19
            java.util.List r14 = r0.e0(r1, r2, r3, r4, r5, r6)
            r15 = r11
        L69:
            int r1 = r14.size()
            if (r15 >= r1) goto L9d
            java.lang.Object r1 = r14.get(r15)
            com.airbnb.lottie.model.layer.TextLayer$TextSubLine r1 = (com.airbnb.lottie.model.layer.TextLayer.TextSubLine) r1
            int r12 = r12 + 1
            r20.save()
            float r2 = com.airbnb.lottie.model.layer.TextLayer.TextSubLine.a(r1)
            r3 = r20
            r0.d0(r3, r7, r12, r2)
            java.lang.String r1 = com.airbnb.lottie.model.layer.TextLayer.TextSubLine.b(r1)
            r6 = r4
            r2 = r7
            r4 = r3
            r7 = r5
            r5 = r8
            r3 = r19
            r0.V(r1, r2, r3, r4, r5, r6, r7)
            r4 = r6
            r20.restore()
            int r15 = r15 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L69
        L9d:
            r7 = r5
            r5 = r8
            int r13 = r13 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L51
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.X(com.airbnb.lottie.model.DocumentData, android.graphics.Matrix, com.airbnb.lottie.model.Font, android.graphics.Canvas):void");
    }

    private TextSubLine Y(int i3) {
        for (int size = this.K.size(); size < i3; size++) {
            this.K.add(new TextSubLine());
        }
        return (TextSubLine) this.K.get(i3 - 1);
    }

    private List Z(FontCharacter fontCharacter) {
        if (this.I.containsKey(fontCharacter)) {
            return (List) this.I.get(fontCharacter);
        }
        List listA = fontCharacter.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new ContentGroup(this.M, this, (ShapeGroup) listA.get(i3), this.N));
        }
        this.I.put(fontCharacter, arrayList);
        return arrayList;
    }

    private List a0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface b0(Font font) {
        Typeface typeface;
        BaseKeyframeAnimation baseKeyframeAnimation = this.X;
        if (baseKeyframeAnimation != null && (typeface = (Typeface) baseKeyframeAnimation.h()) != null) {
            return typeface;
        }
        Typeface typefaceU = this.M.U(font);
        return typefaceU != null ? typefaceU : font.d();
    }

    private boolean c0(int i3) {
        return Character.getType(i3) == 16 || Character.getType(i3) == 27 || Character.getType(i3) == 6 || Character.getType(i3) == 28 || Character.getType(i3) == 8 || Character.getType(i3) == 19;
    }

    private void d0(Canvas canvas, DocumentData documentData, int i3, float f3) {
        PointF pointF = documentData.f56691l;
        PointF pointF2 = documentData.f56692m;
        float fE = Utils.e();
        float f4 = (i3 * documentData.f56685f * fE) + (pointF == null ? 0.0f : (documentData.f56685f * fE) + pointF.y);
        float f5 = pointF == null ? 0.0f : pointF.x;
        float f6 = pointF2 != null ? pointF2.x : 0.0f;
        int i4 = AnonymousClass3.f56929a[documentData.f56683d.ordinal()];
        if (i4 == 1) {
            canvas.translate(f5, f4);
        } else if (i4 == 2) {
            canvas.translate((f5 + f6) - f3, f4);
        } else {
            if (i4 != 3) {
                return;
            }
            canvas.translate((f5 + (f6 / 2.0f)) - (f3 / 2.0f), f4);
        }
    }

    private List e0(String str, float f3, Font font, float f4, float f5, boolean z2) {
        float fMeasureText;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            if (z2) {
                FontCharacter fontCharacter = (FontCharacter) this.N.c().g(FontCharacter.c(cCharAt, font.a(), font.c()));
                if (fontCharacter != null) {
                    fMeasureText = ((float) fontCharacter.b()) * f4 * Utils.e();
                }
            } else {
                fMeasureText = this.G.measureText(str.substring(i6, i6 + 1));
            }
            float f9 = fMeasureText + f5;
            if (cCharAt == ' ') {
                z3 = true;
                f8 = f9;
            } else if (z3) {
                z3 = false;
                i5 = i6;
                f7 = f9;
            } else {
                f7 += f9;
            }
            f6 += f9;
            if (f3 > 0.0f && f6 >= f3 && cCharAt != ' ') {
                i3++;
                TextSubLine textSubLineY = Y(i3);
                if (i5 == i4) {
                    textSubLineY.c(str.substring(i4, i6).trim(), (f6 - f9) - ((r9.length() - r7.length()) * f8));
                    i4 = i6;
                    i5 = i4;
                    f6 = f9;
                    f7 = f6;
                } else {
                    textSubLineY.c(str.substring(i4, i5 - 1).trim(), ((f6 - f7) - ((r7.length() - r13.length()) * f8)) - f8);
                    f6 = f7;
                    i4 = i5;
                }
            }
        }
        if (f6 > 0.0f) {
            i3++;
            Y(i3).c(str.substring(i4), f6);
        }
        return this.K.subList(0, i3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.f56357a) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.P;
            if (baseKeyframeAnimation != null) {
                G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.P = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.P = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            j(this.P);
            return;
        }
        if (obj == LottieProperty.f56358b) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.R;
            if (baseKeyframeAnimation2 != null) {
                G(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.R = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.R = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            j(this.R);
            return;
        }
        if (obj == LottieProperty.f56375s) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.T;
            if (baseKeyframeAnimation3 != null) {
                G(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.T = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.T = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            j(this.T);
            return;
        }
        if (obj == LottieProperty.f56376t) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.V;
            if (baseKeyframeAnimation4 != null) {
                G(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.V = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.V = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            j(this.V);
            return;
        }
        if (obj == LottieProperty.F) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.W;
            if (baseKeyframeAnimation5 != null) {
                G(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.W = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.W = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.a(this);
            j(this.W);
            return;
        }
        if (obj != LottieProperty.M) {
            if (obj == LottieProperty.O) {
                this.L.q(lottieValueCallback);
                return;
            }
            return;
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.X;
        if (baseKeyframeAnimation6 != null) {
            G(baseKeyframeAnimation6);
        }
        if (lottieValueCallback == null) {
            this.X = null;
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.X = valueCallbackKeyframeAnimation6;
        valueCallbackKeyframeAnimation6.a(this);
        j(this.X);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        super.f(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.N.b().width(), this.N.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void u(Canvas canvas, Matrix matrix, int i3) {
        DocumentData documentData = (DocumentData) this.L.h();
        Font font = (Font) this.N.g().get(documentData.f56681b);
        if (font == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        P(documentData, matrix);
        if (this.M.I0()) {
            X(documentData, matrix, font, canvas);
        } else {
            W(documentData, font, canvas);
        }
        canvas.restore();
    }
}
