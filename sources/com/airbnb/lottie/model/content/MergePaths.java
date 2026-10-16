package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MergePaths implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MergePathsMode f56779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f56780c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode b(int i3) {
            return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z2) {
        this.f56778a = str;
        this.f56779b = mergePathsMode;
        this.f56780c = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        if (lottieDrawable.x()) {
            return new MergePathsContent(this);
        }
        Logger.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f56779b;
    }

    public String c() {
        return this.f56778a;
    }

    public boolean d() {
        return this.f56780c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f56779b + '}';
    }
}
