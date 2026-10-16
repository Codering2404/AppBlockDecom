package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TransitionFactory f66130a = NoTransition.c();

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final TransitionOptions clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    final TransitionFactory b() {
        return this.f66130a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionOptions) {
            return Util.e(this.f66130a, ((TransitionOptions) obj).f66130a);
        }
        return false;
    }

    public int hashCode() {
        TransitionFactory transitionFactory = this.f66130a;
        if (transitionFactory != null) {
            return transitionFactory.hashCode();
        }
        return 0;
    }
}
