package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.ConnectorAggregation;
import com.google.android.libraries.places.api.model.EVConnectorType;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzt extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f79364j;

    public zzt(List items, int i3) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f79363i = items;
        this.f79364j = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79363i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int i4;
        zzs viewHolder2 = (zzs) viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "viewHolder");
        ConnectorAggregation connectorAggregation = (ConnectorAggregation) this.f79363i.get(i3);
        Context context = viewHolder2.itemView.getContext();
        TextView textViewB = viewHolder2.b();
        EVConnectorType eVConnectorTypeH = connectorAggregation.h();
        Intrinsics.checkNotNullExpressionValue(eVConnectorTypeH, "getType(...)");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullParameter(eVConnectorTypeH, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        EVConnectorType eVConnectorType = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
        switch (eVConnectorTypeH) {
            case EV_CONNECTOR_TYPE_UNSPECIFIED:
            case EV_CONNECTOR_TYPE_OTHER:
                i4 = R.string.f74854k1;
                break;
            case EV_CONNECTOR_TYPE_J1772:
                i4 = R.string.f74868r;
                break;
            case EV_CONNECTOR_TYPE_TYPE_2:
                i4 = R.string.f74851j1;
                break;
            case EV_CONNECTOR_TYPE_CHADEMO:
                i4 = R.string.f74837f;
                break;
            case EV_CONNECTOR_TYPE_CCS_COMBO_1:
                i4 = R.string.f74831d;
                break;
            case EV_CONNECTOR_TYPE_CCS_COMBO_2:
                i4 = R.string.f74834e;
                break;
            case EV_CONNECTOR_TYPE_TESLA:
                i4 = R.string.f74848i1;
                break;
            case EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T:
                i4 = R.string.f74864p;
                break;
            case EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET:
                i4 = R.string.f74857l1;
                break;
            case EV_CONNECTOR_TYPE_NACS:
                i4 = R.string.f74870s;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String string = context.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textViewB.setText(string);
        viewHolder2.c().setText(context.getString(R.string.f74846i, Integer.valueOf((int) connectorAggregation.f().doubleValue())));
        if (connectorAggregation.d() == null) {
            viewHolder2.d().setVisibility(8);
            return;
        }
        CardView cardViewD = viewHolder2.d();
        int i5 = this.f79364j;
        Intrinsics.checkNotNullParameter(connectorAggregation, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Integer numD = connectorAggregation.d();
        boolean z2 = (numD == null || numD.intValue() == 0) ? false : true;
        int color = context.getColor(R.color.f74668e);
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, PlacesMaterialThemeAttrs);
        int color2 = typedArrayObtainStyledAttributes.getColor(z2 ? R.styleable.f74898j : R.styleable.f74893e, color);
        typedArrayObtainStyledAttributes.recycle();
        cardViewD.setCardBackgroundColor(color2);
        viewHolder2.d().setVisibility(0);
        TextView textViewE = viewHolder2.e();
        Intrinsics.checkNotNullParameter(connectorAggregation, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Integer numD2 = connectorAggregation.d();
        boolean z3 = (numD2 == null || numD2.intValue() == 0) ? false : true;
        int color3 = context.getColor(R.color.f74669f);
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i5, PlacesMaterialThemeAttrs);
        int color4 = typedArrayObtainStyledAttributes2.getColor(z3 ? R.styleable.f74895g : R.styleable.f74894f, color3);
        typedArrayObtainStyledAttributes2.recycle();
        textViewE.setTextColor(color4);
        viewHolder2.e().setText(context.getString(R.string.f74840g, connectorAggregation.d(), connectorAggregation.e()));
        viewHolder2.d().setContentDescription(context.getString(R.string.f74843h, connectorAggregation.d(), connectorAggregation.e()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f74796g, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new zzs(viewInflate);
    }
}
