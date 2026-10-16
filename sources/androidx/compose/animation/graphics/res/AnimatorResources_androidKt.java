package androidx.compose.animation.graphics.res;

import android.R;
import android.animation.TimeInterpolator;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.graphics.vector.Animator;
import androidx.compose.animation.graphics.vector.compat.XmlAnimatorParser_androidKt;
import androidx.compose.animation.graphics.vector.compat.XmlPullParserUtils_androidKt;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class AnimatorResources_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Easing f4381a = new Easing() { // from class: androidx.compose.animation.graphics.res.d
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return AnimatorResources_androidKt.j(f3);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Easing f4382b = new Easing() { // from class: androidx.compose.animation.graphics.res.e
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return AnimatorResources_androidKt.l(f3);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Easing f4383c = D(new BounceInterpolator());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Easing f4384d = new Easing() { // from class: androidx.compose.animation.graphics.res.f
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return AnimatorResources_androidKt.t(f3);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap f4385e;

    static {
        Pair pairA = TuplesKt.a(Integer.valueOf(R.anim.linear_interpolator), EasingKt.e());
        Integer numValueOf = Integer.valueOf(R.interpolator.fast_out_linear_in);
        Pair pairA2 = TuplesKt.a(numValueOf, EasingKt.c());
        Integer numValueOf2 = Integer.valueOf(R.interpolator.fast_out_slow_in);
        Pair pairA3 = TuplesKt.a(numValueOf2, EasingKt.d());
        Pair pairA4 = TuplesKt.a(Integer.valueOf(R.interpolator.linear), EasingKt.e());
        Integer numValueOf3 = Integer.valueOf(R.interpolator.linear_out_slow_in);
        f4385e = MapsKt.hashMapOf(pairA, pairA2, pairA3, pairA4, TuplesKt.a(numValueOf3, EasingKt.f()), TuplesKt.a(numValueOf, EasingKt.c()), TuplesKt.a(numValueOf2, EasingKt.d()), TuplesKt.a(numValueOf3, EasingKt.f()));
    }

    public static final Easing A() {
        return f4384d;
    }

    public static final Animator B(Resources.Theme theme, Resources resources, int i3) throws XmlPullParserException, IOException {
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        XmlPullParserUtils_androidKt.b(xml);
        String name = xml.getName();
        if (Intrinsics.areEqual(name, "set")) {
            return XmlAnimatorParser_androidKt.i(xml, resources, theme, attributeSetAsAttributeSet);
        }
        if (Intrinsics.areEqual(name, "objectAnimator")) {
            return XmlAnimatorParser_androidKt.l(xml, resources, theme, attributeSetAsAttributeSet);
        }
        throw new XmlPullParserException("Unknown tag: " + xml.getName());
    }

    public static final Easing C(Resources.Theme theme, Resources resources, int i3) {
        Easing easing = (Easing) f4385e.get(Integer.valueOf(i3));
        if (easing != null) {
            return easing;
        }
        XmlResourceParser xml = resources.getXml(i3);
        return XmlAnimatorParser_androidKt.j(XmlPullParserUtils_androidKt.b(xml), resources, theme, Xml.asAttributeSet(xml));
    }

    public static final Easing D(final TimeInterpolator timeInterpolator) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.a
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f3) {
                return AnimatorResources_androidKt.E(timeInterpolator, f3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float E(TimeInterpolator timeInterpolator, float f3) {
        return timeInterpolator.getInterpolation(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(float f3) {
        return (float) ((Math.cos(((double) (f3 + 1)) * 3.141592653589793d) / ((double) 2.0f)) + ((double) 0.5f));
    }

    public static final Easing k(final float f3) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.c
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f4) {
                return AnimatorResources_androidKt.m(f3, f4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f3) {
        return f3 * f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float m(float f3, float f4) {
        return (float) Math.pow(f4, f3 * 2);
    }

    public static final Easing n(final float f3) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.b
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f4) {
                return AnimatorResources_androidKt.o(f3, f4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(float f3, float f4) {
        return f4 * f4 * (((1 + f3) * f4) - f3);
    }

    public static final Easing p(float f3, float f4) {
        return D(new AnticipateOvershootInterpolator(f3, f4));
    }

    public static final Easing q(final float f3) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.h
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f4) {
                return AnimatorResources_androidKt.r(f3, f4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float r(float f3, float f4) {
        return (float) Math.sin(((double) (2 * f3)) * 3.141592653589793d * ((double) f4));
    }

    public static final Easing s(final float f3) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.i
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f4) {
                return AnimatorResources_androidKt.u(f3, f4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float t(float f3) {
        float f4 = 1.0f - f3;
        return 1.0f - (f4 * f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float u(float f3, float f4) {
        return 1.0f - ((float) Math.pow(1.0f - f4, 2 * f3));
    }

    public static final Easing v(final float f3) {
        return new Easing() { // from class: androidx.compose.animation.graphics.res.g
            @Override // androidx.compose.animation.core.Easing
            public final float a(float f4) {
                return AnimatorResources_androidKt.w(f3, f4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float w(float f3, float f4) {
        float f5 = f4 - 1.0f;
        return (f5 * f5 * (((f3 + 1.0f) * f5) + f3)) + 1.0f;
    }

    public static final Easing x() {
        return f4381a;
    }

    public static final Easing y() {
        return f4382b;
    }

    public static final Easing z() {
        return f4383c;
    }
}
