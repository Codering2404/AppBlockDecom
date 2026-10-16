package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator f80509b = new CircularRevealEvaluator();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RevealInfo f80510a = new RevealInfo();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RevealInfo evaluate(float f3, RevealInfo revealInfo, RevealInfo revealInfo2) {
            this.f80510a.b(MathUtils.d(revealInfo.f80513a, revealInfo2.f80513a, f3), MathUtils.d(revealInfo.f80514b, revealInfo2.f80514b, f3), MathUtils.d(revealInfo.f80515c, revealInfo2.f80515c, f3));
            return this.f80510a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property f80511a = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property f80512a = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RevealInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f80513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f80514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f80515c;

        public boolean a() {
            return this.f80515c == Float.MAX_VALUE;
        }

        public void b(float f3, float f4, float f5) {
            this.f80513a = f3;
            this.f80514b = f4;
            this.f80515c = f5;
        }

        public void c(RevealInfo revealInfo) {
            b(revealInfo.f80513a, revealInfo.f80514b, revealInfo.f80515c);
        }

        private RevealInfo() {
        }

        public RevealInfo(float f3, float f4, float f5) {
            this.f80513a = f3;
            this.f80514b = f4;
            this.f80515c = f5;
        }

        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.f80513a, revealInfo.f80514b, revealInfo.f80515c);
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i3);

    void setRevealInfo(RevealInfo revealInfo);
}
