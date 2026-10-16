package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcku;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup.LayoutParams f70092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f70093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f70094d;

    public zzj(zzcku zzckuVar) throws zzh {
        this.f70092b = zzckuVar.getLayoutParams();
        ViewParent parent = zzckuVar.getParent();
        this.f70094d = zzckuVar.zzK();
        if (!(parent instanceof ViewGroup)) {
            throw new zzh("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.f70093c = viewGroup;
        this.f70091a = viewGroup.indexOfChild(zzckuVar.zzE());
        viewGroup.removeView(zzckuVar.zzE());
        zzckuVar.zzag(true);
    }
}
