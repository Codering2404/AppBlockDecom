package com.bumptech.glide.load.engine.prefill;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class PreFillQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f66660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f66661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f66662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66663d;

    public boolean a() {
        return this.f66662c == 0;
    }

    public PreFillType b() {
        PreFillType preFillType = (PreFillType) this.f66661b.get(this.f66663d);
        Integer num = (Integer) this.f66660a.get(preFillType);
        if (num.intValue() == 1) {
            this.f66660a.remove(preFillType);
            this.f66661b.remove(this.f66663d);
        } else {
            this.f66660a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f66662c--;
        this.f66663d = this.f66661b.isEmpty() ? 0 : (this.f66663d + 1) % this.f66661b.size();
        return preFillType;
    }
}
