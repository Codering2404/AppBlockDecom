package com.facebook.ads.redexgen.core;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.om, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SurfaceHolderCallbackC2115om implements GQ, InterfaceC05528p, ES, InterfaceC0605Bf, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"mdkndyL3N", "34XFwDl9WvKoMHQUixXhMeiNQCyC6vNP", "5uafIaN5", "lxzaK8fg5Pf0nzPouXyzPKk1aT8cB3T1", "DTIJ", "0UAV", "B5vkeIjqEzHsmqRbylQSobdgrKqNmXUo", "pkzfV8UoB1KOSL3E8gfET47OMeTC19My"};
    public final /* synthetic */ AA A00;

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final /* synthetic */ void AD4(C2208qI c2208qI, C6L c6l) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final /* synthetic */ void AD5(long j3) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final /* synthetic */ void AD6(Exception exc) {
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final /* synthetic */ void ADU(int i3, long j3) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final /* synthetic */ void AFy(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final /* synthetic */ void AGV(C2208qI c2208qI, C6L c6l) {
    }

    public SurfaceHolderCallbackC2115om(AA aa) {
        this.A00 = aa;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final void AD0(String str, long j3, long j4) {
        Iterator it = this.A00.A0H.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "1hpUDXdDopjYnxDN8fIPsNGSxN8OzRvU";
            if (zHasNext) {
                ((InterfaceC05528p) it.next()).AD0(str, j3, j4);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final void AD1(C6I c6i) {
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((InterfaceC05528p) it.next()).AD1(c6i);
        }
        this.A00.A07 = null;
        this.A00.A09 = null;
        this.A00.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final void AD2(C6I c6i) {
        this.A00.A09 = c6i;
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((InterfaceC05528p) it.next()).AD2(c6i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final void AD3(C2208qI c2208qI) {
        this.A00.A07 = c2208qI;
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((InterfaceC05528p) it.next()).AD3(c2208qI);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05528p
    public final void AD9(int i3, long j3, long j4) {
        Iterator it = this.A00.A0H.iterator();
        while (it.hasNext()) {
            ((InterfaceC05528p) it.next()).AD9(i3, j3, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.core.ES
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ADZ(C2156pR c2156pR) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((C3U) it.next()).ADZ(c2156pR);
        }
    }

    @Override // com.facebook.ads.redexgen.core.ES
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ADa(List<C2158pT> list) {
        Iterator it = this.A00.A0I.iterator();
        while (it.hasNext()) {
            ((C3U) it.next()).ADa(list);
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void ADl(int i3, long j3) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).ADl(i3, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0605Bf
    public final void AEt(Metadata metadata, long j3) {
        Iterator it = this.A00.A0J.iterator();
        while (it.hasNext()) {
            ((InterfaceC0605Bf) it.next()).AEt(metadata, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AFf(Object obj, long j3) {
        if (this.A00.A03 == obj) {
            Iterator it = this.A00.A0L.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = this.A00.A0K.iterator();
        while (it2.hasNext()) {
            ((GQ) it2.next()).AFf(obj, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AGN(String str, long j3, long j4) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).AGN(str, j3, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AGO(C6I c6i) {
        Iterator it = this.A00.A0K.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).AGO(c6i);
        }
        this.A00.A08 = null;
        this.A00.A0A = null;
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AGP(C6I c6i) {
        this.A00.A0A = c6i;
        Iterator it = this.A00.A0K.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[0].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "MKCckBbCZrSSu6G06Z7NkbaNocq2WvpN";
            strArr[6] = "V8qjKHPFdvtphjyj0wrcUTYdTARdRgua";
            if (zHasNext) {
                ((GQ) it.next()).AGP(c6i);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AGU(C2208qI c2208qI) {
        this.A00.A08 = c2208qI;
        Iterator it = this.A00.A0K.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "2z1T7IcDfmpzuxqypnwVKmOXmU8bKGPo";
            if (zHasNext) {
                ((GQ) it.next()).AGU(c2208qI);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.GQ
    public final void AGb(C2161pW c2161pW) {
        Iterator it = this.A00.A0L.iterator();
        while (it.hasNext()) {
            ((C5L) it.next()).AGa(c2161pW.A03, c2161pW.A01, c2161pW.A02, c2161pW.A00);
        }
        for (GQ gq : this.A00.A0K) {
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[1] = "q7eFcMKXm9CoB0iVpo1HKrbod3G9GfaY";
            gq.AGb(c2161pW);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
        this.A00.A0F(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0F(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0F(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0F(null, false);
    }
}
