package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MotionSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap f79862a = new SimpleArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap f79863b = new SimpleArrayMap();

    private static void a(MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.m(objectAnimator.getPropertyName(), MotionTiming.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    private PropertyValuesHolder[] b(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i3 = 0; i3 < propertyValuesHolderArr.length; i3++) {
            propertyValuesHolderArr2[i3] = propertyValuesHolderArr[i3].clone();
        }
        return propertyValuesHolderArr2;
    }

    public static MotionSpec c(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    public static MotionSpec d(Context context, int i3) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return e(arrayList);
        } catch (Exception e3) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e3);
            return null;
        }
    }

    private static MotionSpec e(List list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(motionSpec, (Animator) list.get(i3));
        }
        return motionSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MotionSpec) {
            return this.f79862a.equals(((MotionSpec) obj).f79862a);
        }
        return false;
    }

    public ObjectAnimator f(String str, Object obj, Property property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        h(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b((PropertyValuesHolder[]) this.f79863b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public MotionTiming h(String str) {
        if (k(str)) {
            return (MotionTiming) this.f79862a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f79862a.hashCode();
    }

    public long i() {
        int size = this.f79862a.size();
        long jMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            MotionTiming motionTiming = (MotionTiming) this.f79862a.j(i3);
            jMax = Math.max(jMax, motionTiming.c() + motionTiming.d());
        }
        return jMax;
    }

    public boolean j(String str) {
        return this.f79863b.get(str) != null;
    }

    public boolean k(String str) {
        return this.f79862a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f79863b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, MotionTiming motionTiming) {
        this.f79862a.put(str, motionTiming);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f79862a + "}\n";
    }
}
