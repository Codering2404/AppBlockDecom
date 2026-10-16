package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatorSet f82542b;

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean N(View view, View view2, boolean z2, boolean z3) {
        AnimatorSet animatorSet = this.f82542b;
        boolean z4 = animatorSet != null;
        if (z4) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetP = P(view, view2, z2, z4);
        this.f82542b = animatorSetP;
        animatorSetP.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.f82542b = null;
            }
        });
        this.f82542b.start();
        if (!z3) {
            this.f82542b.end();
        }
        return true;
    }

    protected abstract AnimatorSet P(View view, View view2, boolean z2, boolean z3);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
