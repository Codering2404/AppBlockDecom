package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzs extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f79359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f79360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CardView f79361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f79362e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.F);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79359b = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.f74724h0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79360c = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.f74787z);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79361d = (CardView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.f74784y);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f79362e = (TextView) viewFindViewById4;
    }

    public final TextView b() {
        return this.f79359b;
    }

    public final TextView c() {
        return this.f79360c;
    }

    public final CardView d() {
        return this.f79361d;
    }

    public final TextView e() {
        return this.f79362e;
    }
}
