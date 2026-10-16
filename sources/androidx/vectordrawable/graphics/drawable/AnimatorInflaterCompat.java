package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.TypeEvaluator;
import android.content.Context;
import androidx.core.graphics.PathParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AnimatorInflaterCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PathParser.PathDataNode[] f53637a;

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathParser.PathDataNode[] evaluate(float f3, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.b(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!PathParser.b(this.f53637a, pathDataNodeArr)) {
                this.f53637a = PathParser.f(pathDataNodeArr);
            }
            for (int i3 = 0; i3 < pathDataNodeArr.length; i3++) {
                this.f53637a[i3].h(pathDataNodeArr[i3], pathDataNodeArr2[i3], f3);
            }
            return this.f53637a;
        }
    }

    public static Animator a(Context context, int i3) {
        return AnimatorInflater.loadAnimator(context, i3);
    }
}
