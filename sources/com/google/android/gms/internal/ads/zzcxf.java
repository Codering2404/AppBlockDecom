package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import d.qFm.sECyKyO;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcxf extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcxf(Context context) {
        super(context);
        this.zza = context;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int i3) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzc = zzc(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzc, 0, iZzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzc(jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 15.0d)));
        layoutParams.addRule(i3);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzc(double d3) {
        com.google.android.gms.ads.internal.client.zzay.a();
        return com.google.android.gms.ads.internal.util.client.zzf.e(this.zza, (int) d3);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }

    public static zzcxf zza(Context context, View view, zzfkf zzfkfVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcxf zzcxfVar = new zzcxf(context);
        List list = zzfkfVar.zzu;
        if (!list.isEmpty() && (resources = zzcxfVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            float f3 = ((zzfkg) list.get(0)).zza;
            float f4 = displayMetrics.density;
            zzcxfVar.setLayoutParams(new FrameLayout.LayoutParams((int) (f3 * f4), (int) (r4.zzb * f4)));
        }
        zzcxfVar.zzb = view;
        zzcxfVar.addView(view);
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zzb(zzcxfVar, zzcxfVar);
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zza(zzcxfVar, zzcxfVar);
        JSONObject jSONObject = zzfkfVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcxfVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(sECyKyO.borpJEhly);
        if (jSONObjectOptJSONObject != null) {
            zzcxfVar.zzb(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcxfVar.zzb(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcxfVar.addView(relativeLayout);
        return zzcxfVar;
    }
}
