package com.google.android.libraries.places.widget.internal.placedetails;

import android.view.View;
import android.widget.TextView;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzj extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f79343b;

    public final TextView b() {
        return this.f79343b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzj(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.O);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, bfIdKSjLOVjG.YMlzt);
        this.f79343b = (TextView) viewFindViewById;
    }
}
