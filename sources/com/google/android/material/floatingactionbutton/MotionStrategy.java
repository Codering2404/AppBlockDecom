package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
interface MotionStrategy {
    void a();

    List b();

    MotionSpec c();

    boolean d();

    void e();

    int f();

    void g();

    void h(MotionSpec motionSpec);

    AnimatorSet i();

    void j(ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
