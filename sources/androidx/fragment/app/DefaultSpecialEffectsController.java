package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    static final class AnimationInfo extends SpecialEffectsInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f37125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private FragmentAnim.AnimationOrAnimator f37127e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z2) {
            super(operation, signal);
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(signal, "signal");
            this.f37125c = z2;
        }

        public final FragmentAnim.AnimationOrAnimator e(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.f37126d) {
                return this.f37127e;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorB = FragmentAnim.b(context, b().h(), b().g() == SpecialEffectsController.Operation.State.VISIBLE, this.f37125c);
            this.f37127e = animationOrAnimatorB;
            this.f37126d = true;
            return animationOrAnimatorB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    static class SpecialEffectsInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SpecialEffectsController.Operation f37128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CancellationSignal f37129b;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal signal) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(signal, "signal");
            this.f37128a = operation;
            this.f37129b = signal;
        }

        public final void a() {
            this.f37128a.f(this.f37129b);
        }

        public final SpecialEffectsController.Operation b() {
            return this.f37128a;
        }

        public final CancellationSignal c() {
            return this.f37129b;
        }

        public final boolean d() {
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.f37449a;
            View view = this.f37128a.h().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateA = companion.a(view);
            SpecialEffectsController.Operation.State stateG = this.f37128a.g();
            if (stateA == stateG) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (stateA == state || stateG == state) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    static final class TransitionInfo extends SpecialEffectsInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f37130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f37131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f37132e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z2, boolean z3) {
            Object returnTransition;
            super(operation, signal);
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(signal, "signal");
            SpecialEffectsController.Operation.State stateG = operation.g();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateG == state) {
                Fragment fragmentH = operation.h();
                returnTransition = z2 ? fragmentH.getReenterTransition() : fragmentH.getEnterTransition();
            } else {
                Fragment fragmentH2 = operation.h();
                returnTransition = z2 ? fragmentH2.getReturnTransition() : fragmentH2.getExitTransition();
            }
            this.f37130c = returnTransition;
            this.f37131d = operation.g() == state ? z2 ? operation.h().getAllowReturnTransitionOverlap() : operation.h().getAllowEnterTransitionOverlap() : true;
            this.f37132e = z3 ? z2 ? operation.h().getSharedElementReturnTransition() : operation.h().getSharedElementEnterTransition() : null;
        }

        private final FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.f37363b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.f37364c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().h() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final FragmentTransitionImpl e() {
            FragmentTransitionImpl fragmentTransitionImplF = f(this.f37130c);
            FragmentTransitionImpl fragmentTransitionImplF2 = f(this.f37132e);
            if (fragmentTransitionImplF == null || fragmentTransitionImplF2 == null || fragmentTransitionImplF == fragmentTransitionImplF2) {
                return fragmentTransitionImplF == null ? fragmentTransitionImplF2 : fragmentTransitionImplF;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().h() + " returned Transition " + this.f37130c + " which uses a different Transition  type than its shared element transition " + this.f37132e).toString());
        }

        public final Object g() {
            return this.f37132e;
        }

        public final Object h() {
            return this.f37130c;
        }

        public final boolean i() {
            return this.f37132e != null;
        }

        public final boolean j() {
            return this.f37131d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
    }

    private final void D(SpecialEffectsController.Operation operation) {
        View view = operation.h().mView;
        SpecialEffectsController.Operation.State stateG = operation.g();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        stateG.b(view);
    }

    private final void E(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = viewGroup.getChildAt(i3);
            if (child.getVisibility() == 0) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                E(arrayList, child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(List awaitingContainerChanges, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController this$0) {
        Intrinsics.checkNotNullParameter(awaitingContainerChanges, "$awaitingContainerChanges");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (awaitingContainerChanges.contains(operation)) {
            awaitingContainerChanges.remove(operation);
            this$0.D(operation);
        }
    }

    private final void G(Map map, View view) {
        String strH = ViewCompat.H(view);
        if (strH != null) {
            map.put(strH, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    G(map, child);
                }
            }
        }
    }

    private final void H(ArrayMap arrayMap, final Collection collection) {
        Set entries = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entries, "entries");
        CollectionsKt.retainAll(entries, new Function1<Map.Entry<String, View>, Boolean>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Map.Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(CollectionsKt.contains(collection, ViewCompat.H((View) entry.getValue())));
            }
        });
    }

    private final void I(List list, List list2, boolean z2, Map map) {
        Context context = q().getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i3 = 0;
        boolean z3 = false;
        while (it.hasNext()) {
            final AnimationInfo animationInfo = (AnimationInfo) it.next();
            if (animationInfo.d()) {
                animationInfo.a();
            } else {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator animationOrAnimatorE = animationInfo.e(context);
                if (animationOrAnimatorE == null) {
                    animationInfo.a();
                } else {
                    final Animator animator = animationOrAnimatorE.f37192b;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operationB = animationInfo.b();
                        Fragment fragmentH = operationB.h();
                        if (Intrinsics.areEqual(map.get(operationB), Boolean.TRUE)) {
                            if (FragmentManager.R0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentH + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.a();
                        } else {
                            final boolean z4 = operationB.g() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(operationB);
                            }
                            final View view = fragmentH.mView;
                            q().startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$startAnimations$1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator anim) {
                                    Intrinsics.checkNotNullParameter(anim, "anim");
                                    this.f37134a.q().endViewTransition(view);
                                    if (z4) {
                                        SpecialEffectsController.Operation.State stateG = operationB.g();
                                        View viewToAnimate = view;
                                        Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                                        stateG.b(viewToAnimate);
                                    }
                                    animationInfo.a();
                                    if (FragmentManager.R0(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + operationB + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.R0(2)) {
                                Log.v("FragmentManager", "Animator from operation " + operationB + " has started.");
                            }
                            animationInfo.c().c(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.b
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public final void onCancel() {
                                    DefaultSpecialEffectsController.J(animator, operationB);
                                }
                            });
                            z3 = true;
                        }
                    }
                }
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            final AnimationInfo animationInfo2 = (AnimationInfo) obj;
            final SpecialEffectsController.Operation operationB2 = animationInfo2.b();
            Fragment fragmentH2 = operationB2.h();
            if (z2) {
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentH2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.a();
            } else if (z3) {
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentH2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.a();
            } else {
                final View view2 = fragmentH2.mView;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator animationOrAnimatorE2 = animationInfo2.e(context);
                if (animationOrAnimatorE2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Animation animation = animationOrAnimatorE2.f37191a;
                if (animation == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (operationB2.g() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    animationInfo2.a();
                } else {
                    q().startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, q(), view2);
                    endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$startAnimations$3(operationB2, this, view2, animationInfo2));
                    view2.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operationB2 + " has started.");
                    }
                }
                animationInfo2.c().c(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.c
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        DefaultSpecialEffectsController.K(view2, this, animationInfo2, operationB2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Animator animator, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "$operation");
        animator.end();
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Animator from operation " + operation + " has been canceled.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(View view, DefaultSpecialEffectsController this$0, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animationInfo, "$animationInfo");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        view.clearAnimation();
        this$0.q().endViewTransition(view);
        animationInfo.a();
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Animation from operation " + operation + " has been cancelled.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(FragmentTransitionImpl impl, View view, Rect lastInEpicenterRect) {
        Intrinsics.checkNotNullParameter(impl, "$impl");
        Intrinsics.checkNotNullParameter(lastInEpicenterRect, "$lastInEpicenterRect");
        impl.h(view, lastInEpicenterRect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ArrayList transitioningViews) {
        Intrinsics.checkNotNullParameter(transitioningViews, "$transitioningViews");
        FragmentTransition.e(transitioningViews, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(transitionInfo, "$transitionInfo");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        transitionInfo.a();
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z2, ArrayMap lastInViews) {
        Intrinsics.checkNotNullParameter(lastInViews, "$lastInViews");
        FragmentTransition.a(operation.h(), operation2.h(), z2, lastInViews, false);
    }

    private final void Q(List list) {
        Fragment fragmentH = ((SpecialEffectsController.Operation) CollectionsKt.last(list)).h();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.h().mAnimationInfo.f37169c = fragmentH.mAnimationInfo.f37169c;
            operation.h().mAnimationInfo.f37170d = fragmentH.mAnimationInfo.f37170d;
            operation.h().mAnimationInfo.f37171e = fragmentH.mAnimationInfo.f37171e;
            operation.h().mAnimationInfo.f37172f = fragmentH.mAnimationInfo.f37172f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(java.util.List r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.j(java.util.List, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.DefaultSpecialEffectsController, androidx.fragment.app.SpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.fragment.app.DefaultSpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.core.app.SharedElementCallback] */
    private final Map L(List list, List list2, final boolean z2, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        String str;
        Object obj;
        ArrayList arrayList;
        String str2;
        Object obj2;
        Object obj3;
        String str3;
        View view;
        ArrayList arrayList2;
        Object obj4;
        Object obj5;
        boolean z3;
        View view2;
        LinkedHashMap linkedHashMap;
        SpecialEffectsController.Operation operation3;
        ArrayMap arrayMap;
        LinkedHashMap linkedHashMap2;
        View view3;
        ArrayList arrayList3;
        int i3;
        View view4;
        final Rect rect;
        final View view5;
        int i4;
        int i5;
        ?? r02 = this;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj6 : list) {
            if (!((TransitionInfo) obj6).d()) {
                arrayList4.add(obj6);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList4.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj7 = arrayList4.get(i6);
            i6++;
            if (((TransitionInfo) obj7).e() != null) {
                arrayList5.add(obj7);
            }
        }
        int size2 = arrayList5.size();
        final FragmentTransitionImpl fragmentTransitionImpl = null;
        int i7 = 0;
        while (i7 < size2) {
            Object obj8 = arrayList5.get(i7);
            i7++;
            TransitionInfo transitionInfo = (TransitionInfo) obj8;
            FragmentTransitionImpl fragmentTransitionImplE = transitionInfo.e();
            if (fragmentTransitionImpl != null && fragmentTransitionImplE != fragmentTransitionImpl) {
                throw new IllegalArgumentException((MrGIhy.nKSGjnYYHZHbT + transitionInfo.b().h() + " returned Transition " + transitionInfo.h() + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl = fragmentTransitionImplE;
        }
        if (fragmentTransitionImpl == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TransitionInfo transitionInfo2 = (TransitionInfo) it.next();
                linkedHashMap3.put(transitionInfo2.b(), Boolean.FALSE);
                transitionInfo2.a();
            }
        } else {
            View view6 = new View(r02.q().getContext());
            Rect rect2 = new Rect();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayMap arrayMap2 = new ArrayMap();
            Iterator it2 = list.iterator();
            Object obj9 = null;
            View view7 = null;
            boolean z4 = false;
            while (true) {
                str = "FragmentManager";
                obj = obj9;
                if (!it2.hasNext()) {
                    break;
                }
                TransitionInfo transitionInfo3 = (TransitionInfo) it2.next();
                if (!transitionInfo3.i() || operation == null || operation2 == null) {
                    arrayMap = arrayMap2;
                    linkedHashMap2 = linkedHashMap3;
                    view3 = view6;
                    rect2 = rect2;
                    arrayList6 = arrayList6;
                    obj9 = obj;
                    view7 = view7;
                    arrayList7 = arrayList7;
                    view6 = view3;
                    linkedHashMap3 = linkedHashMap2;
                    arrayMap2 = arrayMap;
                } else {
                    Object objU = fragmentTransitionImpl.u(fragmentTransitionImpl.f(transitionInfo3.g()));
                    ArrayList<String> sharedElementSourceNames = operation2.h().getSharedElementSourceNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementSourceNames2 = operation.h().getSharedElementSourceNames();
                    View view8 = view7;
                    Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> sharedElementTargetNames = operation.h().getSharedElementTargetNames();
                    LinkedHashMap linkedHashMap4 = linkedHashMap3;
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                    int size3 = sharedElementTargetNames.size();
                    View view9 = view6;
                    Rect rect3 = rect2;
                    int i8 = 0;
                    while (i8 < size3) {
                        int i9 = size3;
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i8));
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i8));
                        }
                        i8++;
                        size3 = i9;
                    }
                    ArrayList<String> sharedElementTargetNames2 = operation2.h().getSharedElementTargetNames();
                    Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames2, "lastIn.fragment.sharedElementTargetNames");
                    Pair pairA = !z2 ? TuplesKt.a(operation.h().getExitTransitionCallback(), operation2.h().getEnterTransitionCallback()) : TuplesKt.a(operation.h().getEnterTransitionCallback(), operation2.h().getExitTransitionCallback());
                    SharedElementCallback sharedElementCallback = (SharedElementCallback) pairA.a();
                    ?? r5 = (SharedElementCallback) pairA.b();
                    int i10 = 0;
                    for (int size4 = sharedElementSourceNames.size(); i10 < size4; size4 = size4) {
                        arrayMap2.put(sharedElementSourceNames.get(i10), sharedElementTargetNames2.get(i10));
                        i10++;
                    }
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        arrayList3 = arrayList7;
                        int i11 = 0;
                        for (int size5 = sharedElementTargetNames2.size(); i11 < size5; size5 = size5) {
                            String str4 = sharedElementTargetNames2.get(i11);
                            Log.v("FragmentManager", "Name: " + str4);
                            i11++;
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        int i12 = 0;
                        for (int size6 = sharedElementSourceNames.size(); i12 < size6; size6 = size6) {
                            String str5 = sharedElementSourceNames.get(i12);
                            Log.v("FragmentManager", "Name: " + str5);
                            i12++;
                        }
                    } else {
                        arrayList3 = arrayList7;
                    }
                    ArrayMap arrayMap3 = new ArrayMap();
                    View view10 = operation.h().mView;
                    Intrinsics.checkNotNullExpressionValue(view10, "firstOut.fragment.mView");
                    r02.G(arrayMap3, view10);
                    arrayMap3.n(sharedElementSourceNames);
                    if (sharedElementCallback != null) {
                        if (FragmentManager.R0(2)) {
                            Log.v("FragmentManager", "Executing exit callback for operation " + operation);
                        }
                        sharedElementCallback.d(sharedElementSourceNames, arrayMap3);
                        int size7 = sharedElementSourceNames.size() - 1;
                        if (size7 >= 0) {
                            while (true) {
                                int i13 = size7 - 1;
                                String str6 = sharedElementSourceNames.get(size7);
                                View view11 = (View) arrayMap3.get(str6);
                                if (view11 == null) {
                                    arrayMap2.remove(str6);
                                    i5 = i13;
                                } else {
                                    i5 = i13;
                                    if (!Intrinsics.areEqual(str6, ViewCompat.H(view11))) {
                                        arrayMap2.put(ViewCompat.H(view11), (String) arrayMap2.remove(str6));
                                    }
                                }
                                if (i5 < 0) {
                                    break;
                                }
                                size7 = i5;
                            }
                        }
                    } else {
                        arrayMap2.n(arrayMap3.keySet());
                    }
                    final ArrayMap arrayMap4 = new ArrayMap();
                    View view12 = operation2.h().mView;
                    Intrinsics.checkNotNullExpressionValue(view12, "lastIn.fragment.mView");
                    r02.G(arrayMap4, view12);
                    arrayMap4.n(sharedElementTargetNames2);
                    arrayMap4.n(arrayMap2.values());
                    if (r5 != 0) {
                        if (FragmentManager.R0(2)) {
                            Log.v("FragmentManager", "Executing enter callback for operation " + operation2);
                        }
                        r5.d(sharedElementTargetNames2, arrayMap4);
                        int size8 = sharedElementTargetNames2.size() - 1;
                        if (size8 >= 0) {
                            while (true) {
                                int i14 = size8 - 1;
                                String name = sharedElementTargetNames2.get(size8);
                                View view13 = (View) arrayMap4.get(name);
                                if (view13 == null) {
                                    Intrinsics.checkNotNullExpressionValue(name, "name");
                                    String strB = FragmentTransition.b(arrayMap2, name);
                                    if (strB != null) {
                                        arrayMap2.remove(strB);
                                    }
                                    i4 = i14;
                                } else {
                                    i4 = i14;
                                    if (!Intrinsics.areEqual(name, ViewCompat.H(view13))) {
                                        Intrinsics.checkNotNullExpressionValue(name, "name");
                                        String strB2 = FragmentTransition.b(arrayMap2, name);
                                        if (strB2 != null) {
                                            arrayMap2.put(strB2, ViewCompat.H(view13));
                                        }
                                    }
                                }
                                if (i4 < 0) {
                                    break;
                                }
                                size8 = i4;
                            }
                        }
                    } else {
                        FragmentTransition.d(arrayMap2, arrayMap4);
                    }
                    Set setKeySet = arrayMap2.keySet();
                    Intrinsics.checkNotNullExpressionValue(setKeySet, "sharedElementNameMapping.keys");
                    r02.H(arrayMap3, setKeySet);
                    Collection collectionValues = arrayMap2.values();
                    Intrinsics.checkNotNullExpressionValue(collectionValues, "sharedElementNameMapping.values");
                    r02.H(arrayMap4, collectionValues);
                    if (arrayMap2.isEmpty()) {
                        arrayList6.clear();
                        arrayList3.clear();
                        view7 = view8;
                        linkedHashMap3 = linkedHashMap4;
                        view6 = view9;
                        rect2 = rect3;
                        arrayList7 = arrayList3;
                        obj9 = null;
                    } else {
                        FragmentTransition.a(operation2.h(), operation.h(), z2, arrayMap3, true);
                        OneShotPreDrawListener.a(r02.q(), new Runnable() { // from class: androidx.fragment.app.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.P(operation2, operation, z2, arrayMap4);
                            }
                        });
                        arrayList6.addAll(arrayMap3.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            i3 = 0;
                            view4 = view8;
                        } else {
                            i3 = 0;
                            view4 = (View) arrayMap3.get(sharedElementSourceNames.get(0));
                            fragmentTransitionImpl.p(objU, view4);
                        }
                        ArrayList arrayList8 = arrayList3;
                        arrayList8.addAll(arrayMap4.values());
                        if (sharedElementTargetNames2.isEmpty() || (view5 = (View) arrayMap4.get(sharedElementTargetNames2.get(i3))) == null) {
                            rect = rect3;
                        } else {
                            rect = rect3;
                            OneShotPreDrawListener.a(r02.q(), new Runnable() { // from class: androidx.fragment.app.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DefaultSpecialEffectsController.M(fragmentTransitionImpl, view5, rect);
                                }
                            });
                            z4 = true;
                        }
                        view3 = view9;
                        fragmentTransitionImpl.s(objU, view3, arrayList6);
                        Rect rect4 = rect;
                        arrayMap = arrayMap2;
                        fragmentTransitionImpl.n(objU, null, null, null, null, objU, arrayList8);
                        Boolean bool = Boolean.TRUE;
                        linkedHashMap2 = linkedHashMap4;
                        linkedHashMap2.put(operation, bool);
                        linkedHashMap2.put(operation2, bool);
                        view7 = view4;
                        obj9 = objU;
                        arrayList7 = arrayList8;
                        rect2 = rect4;
                        arrayList6 = arrayList6;
                        view6 = view3;
                        linkedHashMap3 = linkedHashMap2;
                        arrayMap2 = arrayMap;
                    }
                }
            }
            ArrayList arrayList9 = arrayList6;
            ArrayMap arrayMap5 = arrayMap2;
            ArrayList arrayList10 = arrayList7;
            View view14 = view7;
            boolean z5 = true;
            LinkedHashMap linkedHashMap5 = linkedHashMap3;
            View view15 = view6;
            Rect rect5 = rect2;
            ArrayList arrayList11 = new ArrayList();
            Iterator it3 = list.iterator();
            Object objK = null;
            Object objK2 = null;
            while (it3.hasNext()) {
                TransitionInfo transitionInfo4 = (TransitionInfo) it3.next();
                if (transitionInfo4.d()) {
                    linkedHashMap5.put(transitionInfo4.b(), Boolean.FALSE);
                    transitionInfo4.a();
                } else {
                    Object objF = fragmentTransitionImpl.f(transitionInfo4.h());
                    SpecialEffectsController.Operation operationB = transitionInfo4.b();
                    boolean z6 = (obj == null || !(operationB == operation || operationB == operation2)) ? false : z5;
                    if (objF != null) {
                        Object obj10 = objK2;
                        final ArrayList arrayList12 = new ArrayList();
                        View view16 = operationB.h().mView;
                        Iterator it4 = it3;
                        Intrinsics.checkNotNullExpressionValue(view16, "operation.fragment.mView");
                        r02.E(arrayList12, view16);
                        if (z6) {
                            if (operationB == operation) {
                                arrayList12.removeAll(CollectionsKt.toSet(arrayList9));
                            } else {
                                arrayList12.removeAll(CollectionsKt.toSet(arrayList10));
                            }
                        }
                        if (arrayList12.isEmpty()) {
                            fragmentTransitionImpl.a(objF, view15);
                            str3 = str;
                            obj3 = objK;
                            obj2 = objF;
                            operation3 = operationB;
                            view = view14;
                            obj5 = obj10;
                            z3 = true;
                            view2 = view15;
                            arrayList2 = arrayList9;
                            linkedHashMap = linkedHashMap5;
                            obj4 = obj;
                        } else {
                            fragmentTransitionImpl.b(objF, arrayList12);
                            Object obj11 = objK;
                            obj2 = objF;
                            obj3 = obj11;
                            str3 = str;
                            view = view14;
                            arrayList2 = arrayList9;
                            obj4 = obj;
                            obj5 = obj10;
                            z3 = true;
                            view2 = view15;
                            linkedHashMap = linkedHashMap5;
                            fragmentTransitionImpl.n(obj2, obj2, arrayList12, null, null, null, null);
                            if (operationB.g() == SpecialEffectsController.Operation.State.GONE) {
                                operation3 = operationB;
                                list2.remove(operation3);
                                ArrayList arrayList13 = new ArrayList(arrayList12);
                                arrayList13.remove(operation3.h().mView);
                                fragmentTransitionImpl.m(obj2, operation3.h().mView, arrayList13);
                                OneShotPreDrawListener.a(q(), new Runnable() { // from class: androidx.fragment.app.f
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        DefaultSpecialEffectsController.N(arrayList12);
                                    }
                                });
                            } else {
                                operation3 = operationB;
                            }
                        }
                        if (operation3.g() == SpecialEffectsController.Operation.State.VISIBLE) {
                            arrayList11.addAll(arrayList12);
                            if (z4) {
                                fragmentTransitionImpl.o(obj2, rect5);
                            }
                        } else {
                            fragmentTransitionImpl.p(obj2, view);
                        }
                        linkedHashMap.put(operation3, Boolean.TRUE);
                        if (transitionInfo4.j()) {
                            objK = fragmentTransitionImpl.k(obj3, obj2, null);
                            it3 = it4;
                            objK2 = obj5;
                            linkedHashMap5 = linkedHashMap;
                            obj = obj4;
                            arrayList9 = arrayList2;
                            view15 = view2;
                            z5 = z3;
                            r02 = this;
                        } else {
                            objK2 = fragmentTransitionImpl.k(obj5, obj2, null);
                            linkedHashMap5 = linkedHashMap;
                            objK = obj3;
                            obj = obj4;
                            arrayList9 = arrayList2;
                            view15 = view2;
                            z5 = z3;
                            r02 = this;
                            it3 = it4;
                        }
                        view14 = view;
                        str = str3;
                    } else if (!z6) {
                        linkedHashMap5.put(operationB, Boolean.FALSE);
                        transitionInfo4.a();
                    }
                }
            }
            String str7 = str;
            ArrayList arrayList14 = arrayList9;
            linkedHashMap3 = linkedHashMap5;
            boolean z7 = z5;
            Object obj12 = obj;
            Object objJ = fragmentTransitionImpl.j(objK, objK2, obj12);
            if (objJ != null) {
                ArrayList arrayList15 = new ArrayList();
                for (Object obj13 : list) {
                    if (!((TransitionInfo) obj13).d()) {
                        arrayList15.add(obj13);
                    }
                }
                int size9 = arrayList15.size();
                int i15 = 0;
                while (i15 < size9) {
                    Object obj14 = arrayList15.get(i15);
                    i15++;
                    final TransitionInfo transitionInfo5 = (TransitionInfo) obj14;
                    Object objH = transitionInfo5.h();
                    final SpecialEffectsController.Operation operationB2 = transitionInfo5.b();
                    boolean z8 = (obj12 == null || !(operationB2 == operation || operationB2 == operation2)) ? false : z7;
                    if (objH == null && !z8) {
                        str2 = str7;
                    } else if (ViewCompat.R(q())) {
                        str2 = str7;
                        fragmentTransitionImpl.q(transitionInfo5.b().h(), objJ, transitionInfo5.c(), new Runnable() { // from class: androidx.fragment.app.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                DefaultSpecialEffectsController.O(transitionInfo5, operationB2);
                            }
                        });
                    } else {
                        if (FragmentManager.R0(2)) {
                            str2 = str7;
                            Log.v(str2, "SpecialEffectsController: Container " + q() + " has not been laid out. Completing operation " + operationB2);
                        } else {
                            str2 = str7;
                        }
                        transitionInfo5.a();
                    }
                    str7 = str2;
                }
                String str8 = str7;
                if (ViewCompat.R(q())) {
                    FragmentTransition.e(arrayList11, 4);
                    ArrayList arrayListL = fragmentTransitionImpl.l(arrayList10);
                    if (FragmentManager.R0(2)) {
                        Log.v(str8, ">>>>> Beginning transition <<<<<");
                        Log.v(str8, ">>>>> SharedElementFirstOutViews <<<<<");
                        int size10 = arrayList14.size();
                        int i16 = 0;
                        while (i16 < size10) {
                            Object sharedElementFirstOutViews = arrayList14.get(i16);
                            i16++;
                            Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                            View view17 = (View) sharedElementFirstOutViews;
                            Log.v(str8, "View: " + view17 + " Name: " + ViewCompat.H(view17));
                        }
                        arrayList = arrayList14;
                        Log.v(str8, ">>>>> SharedElementLastInViews <<<<<");
                        int size11 = arrayList10.size();
                        int i17 = 0;
                        while (i17 < size11) {
                            Object sharedElementLastInViews = arrayList10.get(i17);
                            i17++;
                            Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                            View view18 = (View) sharedElementLastInViews;
                            Log.v(str8, "View: " + view18 + " Name: " + ViewCompat.H(view18));
                        }
                    } else {
                        arrayList = arrayList14;
                    }
                    fragmentTransitionImpl.c(q(), objJ);
                    fragmentTransitionImpl.r(q(), arrayList, arrayList10, arrayListL, arrayMap5);
                    FragmentTransition.e(arrayList11, 0);
                    fragmentTransitionImpl.t(obj12, arrayList, arrayList10);
                    return linkedHashMap3;
                }
            }
        }
        return linkedHashMap3;
    }
}
