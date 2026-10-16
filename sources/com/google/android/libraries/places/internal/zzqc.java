package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqc extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f78447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzqd f78448c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqc(final zzqd zzqdVar, View itemview) {
        super(itemview);
        Intrinsics.checkNotNullParameter(itemview, "itemview");
        this.f78448c = zzqdVar;
        this.f78447b = itemview;
        View viewFindViewById = itemview.findViewById(R.id.A0);
        if (!zzqdVar.f78453m) {
            viewFindViewById.setClickable(false);
            viewFindViewById.setFocusable(false);
            return;
        }
        ViewCompat.m0(viewFindViewById, new zzpz(viewFindViewById));
        viewFindViewById.setClickable(true);
        viewFindViewById.setFocusable(true);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzqb
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                Integer numValueOf = Integer.valueOf(this.f78445a.getBindingAdapterPosition());
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    zzqdVar.f78458r.invoke(Integer.valueOf(numValueOf.intValue()));
                }
            }
        });
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.libraries.places.internal.zzqa
            @Override // android.view.View.OnTouchListener
            public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
                zzqc.d(this.f78444a, view, motionEvent);
                return false;
            }
        });
    }

    static /* synthetic */ boolean d(zzqc zzqcVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            zzqcVar.f78447b.findViewById(R.id.D0).setVisibility(0);
        } else if (action == 1 || action == 3) {
            zzqcVar.f78447b.findViewById(R.id.D0).setVisibility(8);
        }
        return false;
    }

    private final void e() {
        View view = this.f78447b;
        ((TextView) view.findViewById(R.id.f74785y0)).setVisibility(8);
        ((ImageView) view.findViewById(R.id.f74696a0)).setVisibility(8);
    }

    public final void b() {
        View view = this.f78447b;
        CardView cardView = (CardView) view.findViewById(R.id.f74788z0);
        cardView.setRadius(0.0f);
        cardView.getLayoutParams().width = -1;
        cardView.getLayoutParams().height = -2;
        ((ConstraintLayout) view.findViewById(R.id.A0)).setForeground(null);
        ImageView imageView = (ImageView) view.findViewById(R.id.E0);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        zzqd zzqdVar = this.f78448c;
        layoutParams.height = zzqdVar.f78452l;
        imageView.getLayoutParams().width = zzqdVar.f78452l;
        View viewFindViewById = view.findViewById(R.id.Z);
        viewFindViewById.getLayoutParams().height = zzqdVar.f78452l;
        viewFindViewById.getLayoutParams().width = zzqdVar.f78452l;
        e();
    }

    public final void c() {
        View view = this.f78447b;
        Context context = view.getContext();
        Intrinsics.checkNotNull(context);
        int i3 = this.f78448c.f78451k;
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, PlacesMaterialThemeAttrs);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.f74899k, context.getResources().getDimensionPixelSize(R.dimen.f74678d));
        CardView cardView = (CardView) view.findViewById(R.id.B0);
        cardView.getLayoutParams().width = context.getResources().getDimensionPixelSize(R.dimen.f74679e);
        cardView.setRadius(dimension);
        typedArrayObtainStyledAttributes.recycle();
        view.findViewById(R.id.A0).getLayoutParams().height = -1;
        ViewGroup.LayoutParams layoutParams = ((Button) view.findViewById(R.id.f74748n0)).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.f33128l = 0;
        layoutParams2.H = 1.0f;
        e();
    }
}
