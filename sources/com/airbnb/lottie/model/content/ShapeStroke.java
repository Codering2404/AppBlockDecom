package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeStroke implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableFloatValue f56831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f56832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatableColorValue f56833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimatableIntegerValue f56834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimatableFloatValue f56835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LineCapType f56836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LineJoinType f56837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f56838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f56839j;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f56841b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f56841b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56841b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56841b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f56840a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56840a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56840a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap b() {
            int i3 = AnonymousClass1.f56840a[ordinal()];
            return i3 != 1 ? i3 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join b() {
            int i3 = AnonymousClass1.f56841b[ordinal()];
            if (i3 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i3 == 2) {
                return Paint.Join.MITER;
            }
            if (i3 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f3, boolean z2) {
        this.f56830a = str;
        this.f56831b = animatableFloatValue;
        this.f56832c = list;
        this.f56833d = animatableColorValue;
        this.f56834e = animatableIntegerValue;
        this.f56835f = animatableFloatValue2;
        this.f56836g = lineCapType;
        this.f56837h = lineJoinType;
        this.f56838i = f3;
        this.f56839j = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public LineCapType b() {
        return this.f56836g;
    }

    public AnimatableColorValue c() {
        return this.f56833d;
    }

    public AnimatableFloatValue d() {
        return this.f56831b;
    }

    public LineJoinType e() {
        return this.f56837h;
    }

    public List f() {
        return this.f56832c;
    }

    public float g() {
        return this.f56838i;
    }

    public String h() {
        return this.f56830a;
    }

    public AnimatableIntegerValue i() {
        return this.f56834e;
    }

    public AnimatableFloatValue j() {
        return this.f56835f;
    }

    public boolean k() {
        return this.f56839j;
    }
}
