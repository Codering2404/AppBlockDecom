package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgsx;
import com.google.android.gms.internal.ads.zzgty;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbs {
    public static boolean a(int i3) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeq)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzer)).booleanValue() || i3 <= 15299999;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: JSONException -> 0x014e, TRY_LEAVE, TryCatch #7 {JSONException -> 0x014e, blocks: (B:31:0x0130, B:40:0x014a, B:48:0x015e, B:47:0x015a), top: B:73:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(android.content.Context r17, android.view.View r18) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbs.b(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject c(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjd)).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzje)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.g();
                        jSONObject.put("contained_in_scroll_view", zzs.a(view) != 0);
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjf)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.g();
                        jSONObject.put("scroll_view_type", zzs.a(view));
                        return jSONObject;
                    }
                } else {
                    com.google.android.gms.ads.internal.zzt.g();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof AdapterView)) {
                        parent = parent.getParent();
                    }
                    jSONObject.put("contained_in_scroll_view", (parent == null ? -1 : ((AdapterView) parent).getPositionForView(view)) != -1);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject d(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                com.google.android.gms.ads.internal.zzt.g();
                jSONObject.put("can_show_on_lock_screen", zzs.Z(view));
                com.google.android.gms.ads.internal.zzt.g();
                jSONObject.put("is_keyguard_locked", zzs.g(context));
                return jSONObject;
            } catch (JSONException unused) {
                int i3 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        String str;
        String str2;
        Iterator it;
        JSONObject jSONObject;
        ViewGroup.LayoutParams layoutParams;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] iArrG = g(view);
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] iArrG2 = g(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    int[] iArr = iArrG;
                    try {
                        it = it2;
                        try {
                            jSONObject4.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, view2.getMeasuredWidth()));
                            jSONObject4.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, view2.getMeasuredHeight()));
                            jSONObject4.put("x", com.google.android.gms.ads.internal.client.zzay.a().l(context, iArrG2[0] - iArr[0]));
                            jSONObject4.put("y", com.google.android.gms.ads.internal.client.zzay.a().l(context, iArrG2[1] - iArr[1]));
                            jSONObject4.put(str4, str3);
                            jSONObject3.put("frame", jSONObject4);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject = l(context, rect);
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
                                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
                                jSONObject.put("x", com.google.android.gms.ads.internal.client.zzay.a().l(context, iArrG2[0] - iArr[0]));
                                jSONObject.put("y", com.google.android.gms.ads.internal.client.zzay.a().l(context, iArrG2[1] - iArr[1]));
                                jSONObject.put(str4, str3);
                            }
                            jSONObject3.put("visible_bounds", jSONObject);
                            if (((String) entry.getKey()).equals("3010")) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjg)).booleanValue()) {
                                    jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjh)).booleanValue() && (layoutParams = view2.getLayoutParams()) != null) {
                                    jSONObject3.put("view_width_layout_type", m(layoutParams.width) - 1);
                                    jSONObject3.put("view_height_layout_type", m(layoutParams.height) - 1);
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjk)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject3.put("view_path", TextUtils.join(pnxuebdT.nbkmZEo, arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject3.put("text_color", textView.getCurrentTextColor());
                                str = str3;
                                str2 = str4;
                                try {
                                    jSONObject3.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                                    jSONObject3.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    int i3 = zze.f70328b;
                                    com.google.android.gms.ads.internal.util.client.zzo.f("Unable to get asset views information");
                                }
                            } else {
                                str = str3;
                                str2 = str4;
                            }
                            jSONObject3.put("is_clickable", map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable());
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjl)).booleanValue()) {
                                jSONObject3.put("alpha", view2.getAlpha());
                            }
                            jSONObject2.put((String) entry.getKey(), jSONObject3);
                        } catch (JSONException unused2) {
                            str = str3;
                            str2 = str4;
                        }
                    } catch (JSONException unused3) {
                        str = str3;
                        str2 = str4;
                        it = it2;
                    }
                    it2 = it;
                    iArrG = iArr;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject f(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e3) {
            e = e3;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("x", com.google.android.gms.ads.internal.client.zzay.a().l(context, point2.x));
                jSONObject3.put("y", com.google.android.gms.ads.internal.client.zzay.a().l(context, point2.y));
                jSONObject3.put("start_x", com.google.android.gms.ads.internal.client.zzay.a().l(context, point.x));
                jSONObject3.put("start_y", com.google.android.gms.ads.internal.client.zzay.a().l(context, point.y));
                jSONObject2 = jSONObject3;
            } catch (JSONException e4) {
                int i3 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while putting signals into JSON object.", e4);
            }
            jSONObject.put("click_point", jSONObject2);
            jSONObject.put("asset_id", str);
            return jSONObject;
        } catch (Exception e5) {
            e = e5;
            jSONObject2 = jSONObject;
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while grabbing click signals.", e);
            return jSONObject2;
        }
    }

    public static int[] g(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static Point h(MotionEvent motionEvent, View view) {
        int[] iArrG = g(view);
        return new Point(((int) motionEvent.getRawX()) - iArrG[0], ((int) motionEvent.getRawY()) - iArrG[1]);
    }

    public static boolean i(Context context, zzfkf zzfkfVar) {
        if (!zzfkfVar.zzN) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjm)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjp)).booleanValue();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjn);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            Iterator it = zzgty.zza(zzgsx.zzc(';')).zzd(str).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        com.google.android.gms.ads.internal.zzt.g();
        DisplayMetrics displayMetricsG0 = zzs.g0((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, displayMetricsG0.widthPixels));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, displayMetricsG0.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static WindowManager.LayoutParams k() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjo)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    private static JSONObject l(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, rect.right - rect.left));
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, com.google.android.gms.ads.internal.client.zzay.a().l(context, rect.bottom - rect.top));
        jSONObject.put("x", com.google.android.gms.ads.internal.client.zzay.a().l(context, rect.left));
        jSONObject.put("y", com.google.android.gms.ads.internal.client.zzay.a().l(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int m(int i3) {
        if (i3 != -2) {
            return i3 != -1 ? 2 : 3;
        }
        return 4;
    }
}
