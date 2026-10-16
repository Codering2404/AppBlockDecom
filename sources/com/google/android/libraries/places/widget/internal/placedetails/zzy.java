package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.FuelPrice;
import java.time.Instant;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzy extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Instant f79370j;

    public zzy(List items, Instant instant) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f79369i = items;
        this.f79370j = instant;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79369i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        String string;
        String string2;
        zzx viewHolder2 = (zzx) viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "viewHolder");
        FuelPrice fuelPrice = (FuelPrice) this.f79369i.get(i3);
        Context context = viewHolder2.itemView.getContext();
        TextView textViewB = viewHolder2.b();
        FuelPrice.FuelType fuelTypeD = fuelPrice.d();
        Intrinsics.checkNotNullExpressionValue(fuelTypeD, "getType(...)");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullParameter(fuelTypeD, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        FuelPrice.FuelType fuelType = FuelPrice.FuelType.FUEL_TYPE_UNSPECIFIED;
        int iOrdinal = fuelTypeD.ordinal();
        if (iOrdinal == 1) {
            string = context.getString(R.string.f74855l);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else if (iOrdinal == 2) {
            string = context.getString(R.string.f74862o);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else if (iOrdinal == 3) {
            string = context.getString(R.string.f74858m);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else if (iOrdinal != 4) {
            string = "";
        } else {
            string = context.getString(R.string.f74860n);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        textViewB.setText(string);
        TextView textViewC = viewHolder2.c();
        Instant instant = this.f79370j;
        Intrinsics.checkNotNullParameter(fuelPrice, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        Currency currency = Currency.getInstance(fuelPrice.c().c());
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        String symbol = currency.getSymbol(locale);
        Intrinsics.checkNotNullExpressionValue(symbol, "getSymbol(...)");
        double dLongValue = fuelPrice.c().e().longValue();
        double dIntValue = fuelPrice.c().d().intValue();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(locale, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dLongValue + (dIntValue / 1.0E9d))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (zzz.b(fuelPrice, instant)) {
            string2 = context.getString(R.string.f74845h1, symbol, str);
            Intrinsics.checkNotNull(string2);
        } else {
            string2 = context.getString(R.string.f74849j, symbol, str);
            Intrinsics.checkNotNull(string2);
        }
        textViewC.setText(string2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f74798i, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new zzx(viewInflate);
    }
}
