package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbln extends RelativeLayout {
    private static final float[] zza = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzb;

    public zzbln(Context context, zzblm zzblmVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.m(zzblmVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zza, null, null));
        shapeDrawable.getPaint().setColor(zzblmVar.zze());
        setLayoutParams(layoutParams);
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzblmVar.zzb())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzblmVar.zzb());
            textView.setTextColor(zzblmVar.zzf());
            textView.setTextSize(zzblmVar.zzg());
            com.google.android.gms.ads.internal.client.zzay.a();
            int iE = com.google.android.gms.ads.internal.util.client.zzf.e(context, 4);
            com.google.android.gms.ads.internal.client.zzay.a();
            textView.setPadding(iE, 0, com.google.android.gms.ads.internal.util.client.zzf.e(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List listZzd = zzblmVar.zzd();
        if (listZzd != null && listZzd.size() > 1) {
            this.zzb = new AnimationDrawable();
            Iterator it = listZzd.iterator();
            while (it.hasNext()) {
                try {
                    this.zzb.addFrame((Drawable) ObjectWrapper.h5(((zzblp) it.next()).zzb()), zzblmVar.zzh());
                } catch (Exception e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error while getting drawable.", e3);
                }
            }
            imageView.setBackground(this.zzb);
        } else if (listZzd.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.h5(((zzblp) listZzd.get(0)).zzb()));
            } catch (Exception e4) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error while getting drawable.", e4);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
