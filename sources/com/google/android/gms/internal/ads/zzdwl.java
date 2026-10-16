package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwl extends FrameLayout {
    private final com.google.android.gms.ads.internal.util.zzat zza;

    public zzdwl(Context context, View view, com.google.android.gms.ads.internal.util.zzat zzatVar) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzatVar;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.a(motionEvent);
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof zzcku) {
                arrayList.add((zzcku) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((zzcku) arrayList.get(i4)).destroy();
        }
    }
}
