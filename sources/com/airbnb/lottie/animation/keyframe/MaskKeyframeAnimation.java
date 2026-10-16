package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaskKeyframeAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f56605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f56606c;

    public MaskKeyframeAnimation(List list) {
        this.f56606c = list;
        this.f56604a = new ArrayList(list.size());
        this.f56605b = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f56604a.add(((Mask) list.get(i3)).b().a());
            this.f56605b.add(((Mask) list.get(i3)).c().a());
        }
    }

    public List a() {
        return this.f56604a;
    }

    public List b() {
        return this.f56606c;
    }

    public List c() {
        return this.f56605b;
    }
}
