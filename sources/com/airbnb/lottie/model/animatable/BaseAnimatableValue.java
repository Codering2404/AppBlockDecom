package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f56734a;

    BaseAnimatableValue(List list) {
        this.f56734a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List b() {
        return this.f56734a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        return this.f56734a.isEmpty() || (this.f56734a.size() == 1 && ((Keyframe) this.f56734a.get(0)).i());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f56734a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f56734a.toArray()));
        }
        return sb.toString();
    }
}
