package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class PagerStartGravitySnapHelper extends SnapHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f51834f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f51835g = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OrientationHelper f51836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OrientationHelper f51837e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final int m(View view, OrientationHelper orientationHelper) {
        int iE = orientationHelper.e(view) / 2;
        return (orientationHelper.g(view) + iE) - (orientationHelper.n() + iE);
    }

    private final View n(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int iP = layoutManager.P();
        View view = null;
        if (iP == 0) {
            return null;
        }
        int iN = orientationHelper.n() + (orientationHelper.o() / 2);
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i4 = 0; i4 < iP; i4++) {
            View viewO = layoutManager.O(i4);
            int iAbs = Math.abs((orientationHelper.g(viewO) + (orientationHelper.e(viewO) / 2)) - iN);
            if (iAbs < i3) {
                view = viewO;
                i3 = iAbs;
            }
        }
        return view;
    }

    private final OrientationHelper o(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51837e;
        if (orientationHelper != null) {
            if (!Intrinsics.areEqual(orientationHelper.k(), layoutManager)) {
                orientationHelper = null;
            }
            if (orientationHelper != null) {
                return orientationHelper;
            }
        }
        OrientationHelper orientationHelperA = OrientationHelper.a(layoutManager);
        this.f51837e = orientationHelperA;
        Intrinsics.checkNotNullExpressionValue(orientationHelperA, "run(...)");
        return orientationHelperA;
    }

    private final OrientationHelper p(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.r()) {
            return q(layoutManager);
        }
        if (layoutManager.q()) {
            return o(layoutManager);
        }
        return null;
    }

    private final OrientationHelper q(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f51836d;
        if (orientationHelper != null) {
            if (!Intrinsics.areEqual(orientationHelper.k(), layoutManager)) {
                orientationHelper = null;
            }
            if (orientationHelper != null) {
                return orientationHelper;
            }
        }
        OrientationHelper orientationHelperC = OrientationHelper.c(layoutManager);
        this.f51836d = orientationHelperC;
        Intrinsics.checkNotNullExpressionValue(orientationHelperC, "run(...)");
        return orientationHelperC;
    }

    private final boolean r(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        return layoutManager.q() ? i3 > 0 : i4 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean s(RecyclerView.LayoutManager layoutManager) {
        PointF pointFE;
        int iA = layoutManager.a();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (pointFE = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).e(iA - 1)) == null) {
            return false;
        }
        return pointFE.x < 0.0f || pointFE.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] c(RecyclerView.LayoutManager layoutManager, View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] iArr = new int[2];
        if (layoutManager.q()) {
            iArr[0] = m(targetView, o(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.r()) {
            iArr[1] = m(targetView, q(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected RecyclerView.SmoothScroller e(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        final Context context = this.f52001a.getContext();
        return new LinearSmoothScroller(context) { // from class: androidx.recyclerview.widget.PagerStartGravitySnapHelper$createScroller$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void o(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(action, "action");
                PagerStartGravitySnapHelper pagerStartGravitySnapHelper = this.f51838q;
                RecyclerView.LayoutManager layoutManager2 = pagerStartGravitySnapHelper.f52001a.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2);
                int[] iArrC = pagerStartGravitySnapHelper.c(layoutManager2, targetView);
                Intrinsics.checkNotNull(iArrC);
                int i3 = iArrC[0];
                int i4 = iArrC[1];
                int iW = w(RangesKt.f(Math.abs(i3), Math.abs(i4)));
                if (iW > 0) {
                    action.d(i3, i4, iW, this.f51785j);
                }
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float v(DisplayMetrics displayMetrics) {
                Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int x(int i3) {
                return RangesKt.k(100, super.x(i3));
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View h(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (layoutManager.r()) {
            return n(layoutManager, q(layoutManager));
        }
        if (layoutManager.q()) {
            return n(layoutManager, o(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int i(RecyclerView.LayoutManager layoutManager, int i3, int i4) {
        OrientationHelper orientationHelperP;
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        int iA = layoutManager.a();
        if (iA == 0 || (orientationHelperP = p(layoutManager)) == null) {
            return -1;
        }
        int iP = layoutManager.P();
        View view = null;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        View view2 = null;
        while (true) {
            if (i5 >= iP) {
                break;
            }
            View viewO = layoutManager.O(i5);
            if (viewO != null) {
                int iM = m(viewO, orientationHelperP);
                if (i7 + 1 <= iM && iM < 1) {
                    view2 = viewO;
                    i7 = iM;
                }
                if (iM >= 0 && iM < i6) {
                    view = viewO;
                    i6 = iM;
                }
            }
            i5++;
        }
        boolean zR = r(layoutManager, i3, i4);
        if (zR && view != null) {
            return layoutManager.m0(view);
        }
        if (!zR && view2 != null) {
            return layoutManager.m0(view2);
        }
        if (zR) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iM0 = layoutManager.m0(view) + (s(layoutManager) == zR ? -1 : 1);
        if (iM0 < 0 || iM0 >= iA) {
            return -1;
        }
        return iM0;
    }
}
