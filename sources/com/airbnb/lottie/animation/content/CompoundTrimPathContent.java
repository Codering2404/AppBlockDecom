package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CompoundTrimPathContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56450a = new ArrayList();

    void a(TrimPathContent trimPathContent) {
        this.f56450a.add(trimPathContent);
    }

    public void b(Path path) {
        for (int size = this.f56450a.size() - 1; size >= 0; size--) {
            Utils.b(path, (TrimPathContent) this.f56450a.get(size));
        }
    }
}
