package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcf extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConstraintLayout f79305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageView f79306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f79307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f79308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RatingStarsView f79309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f79310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextView f79311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f79312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f79313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TextView f79314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TextView f79315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final View f79316m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcf(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.f74723h);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79305b = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.f74727i);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79306c = (ImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.f74731j);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79307d = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.G1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f79308e = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.M1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f79309f = (RatingStarsView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.V1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.f79310g = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.t2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.f79311h = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.T1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.f79312i = (ImageView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.f74734j2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.f79313j = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.f74702b2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.f79314k = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.f74706c2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.f79315l = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.f74738k2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.f79316m = viewFindViewById12;
    }

    public final ConstraintLayout b() {
        return this.f79305b;
    }

    public final ImageView c() {
        return this.f79306c;
    }

    public final TextView d() {
        return this.f79307d;
    }

    public final TextView e() {
        return this.f79308e;
    }

    public final RatingStarsView f() {
        return this.f79309f;
    }

    public final TextView g() {
        return this.f79310g;
    }

    public final TextView h() {
        return this.f79311h;
    }

    public final ImageView i() {
        return this.f79312i;
    }

    public final TextView j() {
        return this.f79313j;
    }

    public final TextView k() {
        return this.f79314k;
    }

    public final TextView l() {
        return this.f79315l;
    }

    public final View m() {
        return this.f79316m;
    }
}
