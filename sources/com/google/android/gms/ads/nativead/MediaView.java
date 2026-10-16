package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzbmv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MediaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaContent f70539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f70540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzblq f70541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView.ScaleType f70542d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f70543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbls f70544g;

    public MediaView(Context context) {
        super(context);
    }

    protected final synchronized void a(zzblq zzblqVar) {
        this.f70541c = zzblqVar;
        if (this.f70540b) {
            zzblqVar.zza(this.f70539a);
        }
    }

    protected final synchronized void b(zzbls zzblsVar) {
        this.f70544g = zzblsVar;
        if (this.f70543f) {
            zzblsVar.zza(this.f70542d);
        }
    }

    public MediaContent getMediaContent() {
        return this.f70539a;
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.f70543f = true;
        this.f70542d = scaleType;
        zzbls zzblsVar = this.f70544g;
        if (zzblsVar != null) {
            zzblsVar.zza(scaleType);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        boolean zZzt;
        this.f70540b = true;
        this.f70539a = mediaContent;
        zzblq zzblqVar = this.f70541c;
        if (zzblqVar != null) {
            zzblqVar.zza(mediaContent);
        }
        if (mediaContent == null) {
            return;
        }
        try {
            zzbmv zzbmvVarZzb = mediaContent.zzb();
            if (zzbmvVarZzb != null) {
                if (!mediaContent.a()) {
                    if (mediaContent.zza()) {
                        zZzt = zzbmvVarZzb.zzt(ObjectWrapper.i5(this));
                    }
                    removeAllViews();
                }
                zZzt = zzbmvVarZzb.zzn(ObjectWrapper.i5(this));
                if (zZzt) {
                    return;
                }
                removeAllViews();
            }
        } catch (RemoteException e3) {
            removeAllViews();
            zzo.d("", e3);
        }
    }
}
