package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzx extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f79367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f79368c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.S);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79367b = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.R);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79368c = (TextView) viewFindViewById2;
    }

    public final TextView b() {
        return this.f79367b;
    }

    public final TextView c() {
        return this.f79368c;
    }
}
