package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.Preconditions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class BaseMotionStrategy implements MotionStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f80971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f80972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f80973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimatorTracker f80974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MotionSpec f80975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MotionSpec f80976f;

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final List b() {
        return this.f80973c;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public MotionSpec c() {
        return this.f80976f;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void e() {
        this.f80974d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void g() {
        this.f80974d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void h(MotionSpec motionSpec) {
        this.f80976f = motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet i() {
        return l(m());
    }

    AnimatorSet l(MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.j("opacity")) {
            arrayList.add(motionSpec.f("opacity", this.f80972b, View.ALPHA));
        }
        if (motionSpec.j("scale")) {
            arrayList.add(motionSpec.f("scale", this.f80972b, View.SCALE_Y));
            arrayList.add(motionSpec.f("scale", this.f80972b, View.SCALE_X));
        }
        if (motionSpec.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
            arrayList.add(motionSpec.f(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f80972b, ExtendedFloatingActionButton.L));
        }
        if (motionSpec.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            arrayList.add(motionSpec.f(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f80972b, ExtendedFloatingActionButton.M));
        }
        if (motionSpec.j("paddingStart")) {
            arrayList.add(motionSpec.f("paddingStart", this.f80972b, ExtendedFloatingActionButton.N));
        }
        if (motionSpec.j("paddingEnd")) {
            arrayList.add(motionSpec.f("paddingEnd", this.f80972b, ExtendedFloatingActionButton.O));
        }
        if (motionSpec.j("labelOpacity")) {
            arrayList.add(motionSpec.f("labelOpacity", this.f80972b, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") { // from class: com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
                @Override // android.util.Property
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(AnimationUtils.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.H.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f80972b.H.getDefaultColor()))));
                }

                @Override // android.util.Property
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f3) {
                    int colorForState = extendedFloatingActionButton.H.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f80972b.H.getDefaultColor());
                    ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.a(0.0f, Color.alpha(colorForState) / 255.0f, f3.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f3.floatValue() == 1.0f) {
                        extendedFloatingActionButton.B(extendedFloatingActionButton.H);
                    } else {
                        extendedFloatingActionButton.B(colorStateListValueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec m() {
        MotionSpec motionSpec = this.f80976f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f80975e == null) {
            this.f80975e = MotionSpec.d(this.f80971a, f());
        }
        return (MotionSpec) Preconditions.h(this.f80975e);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(Animator animator) {
        this.f80974d.c(animator);
    }
}
