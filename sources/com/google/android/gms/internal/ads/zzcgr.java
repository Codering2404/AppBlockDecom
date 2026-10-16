package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcgr extends zzcgt implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final Map zzc;
    private final zzchn zzd;
    private final zzcho zze;
    private final boolean zzf;
    private final zzdzl zzg;
    private int zzh;
    private int zzi;
    private MediaPlayer zzj;
    private Uri zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzchl zzo;
    private final boolean zzp;
    private int zzq;
    private zzcgs zzr;
    private boolean zzs;
    private Integer zzt;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put(-1004, "MEDIA_ERROR_IO");
        map.put(-1007, "MEDIA_ERROR_MALFORMED");
        map.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        map.put(-110, "MEDIA_ERROR_TIMED_OUT");
        map.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        map.put(100, "MEDIA_ERROR_SERVER_DIED");
        map.put(1, "MEDIA_ERROR_UNKNOWN");
        map.put(1, "MEDIA_INFO_UNKNOWN");
        map.put(Integer.valueOf(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        map.put(701, "MEDIA_INFO_BUFFERING_START");
        map.put(702, "MEDIA_INFO_BUFFERING_END");
        map.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        map.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        map.put(802, "MEDIA_INFO_METADATA_UPDATE");
        map.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        map.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcgr(Context context, zzchn zzchnVar, boolean z2, boolean z3, zzchm zzchmVar, zzcho zzchoVar, zzdzl zzdzlVar) {
        super(context);
        this.zzh = 0;
        this.zzi = 0;
        this.zzs = false;
        this.zzt = null;
        this.zzd = zzchnVar;
        this.zze = zzchoVar;
        this.zzp = z2;
        this.zzf = z3;
        zzchoVar.zza(this);
        this.zzg = zzdzlVar;
    }

    private final void zzD() {
        zzdzl zzdzlVar;
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzk == null || surfaceTexture == null) {
            return;
        }
        zzE(false);
        try {
            com.google.android.gms.ads.internal.zzt.z();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.zzj = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.zzj.setOnCompletionListener(this);
            this.zzj.setOnErrorListener(this);
            this.zzj.setOnInfoListener(this);
            this.zzj.setOnPreparedListener(this);
            this.zzj.setOnVideoSizeChangedListener(this);
            this.zzn = 0;
            if (this.zzp) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoL)).booleanValue() && (zzdzlVar = this.zzg) != null) {
                    zzdzk zzdzkVarZza = zzdzlVar.zza();
                    zzdzkVarZza.zzc("action", "svp_ampv");
                    zzdzkVarZza.zzd();
                }
                zzchl zzchlVar = new zzchl(getContext());
                this.zzo = zzchlVar;
                zzchlVar.zzb(surfaceTexture, getWidth(), getHeight());
                zzchl zzchlVar2 = this.zzo;
                zzchlVar2.start();
                SurfaceTexture surfaceTextureZze = zzchlVar2.zze();
                if (surfaceTextureZze != null) {
                    surfaceTexture = surfaceTextureZze;
                } else {
                    this.zzo.zzd();
                    this.zzo = null;
                }
            }
            this.zzj.setDataSource(getContext(), this.zzk);
            com.google.android.gms.ads.internal.zzt.A();
            this.zzj.setSurface(new Surface(surfaceTexture));
            this.zzj.setAudioStreamType(3);
            this.zzj.setScreenOnWhilePlaying(true);
            this.zzj.prepareAsync();
            zzH(1);
        } catch (IOException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        } catch (IllegalArgumentException e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        } catch (IllegalStateException e5) {
            e = e5;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzk)), e);
            onError(this.zzj, 1, 0);
        }
    }

    private final void zzE(boolean z2) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView release");
        zzchl zzchlVar = this.zzo;
        if (zzchlVar != null) {
            zzchlVar.zzd();
            this.zzo = null;
        }
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzj.release();
            this.zzj = null;
            zzH(0);
            if (z2) {
                this.zzi = 0;
            }
        }
    }

    private final boolean zzF() {
        int i3;
        return (this.zzj == null || (i3 = this.zzh) == -1 || i3 == 0 || i3 == 1) ? false : true;
    }

    private final void zzG(float f3) {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f3, f3);
            } catch (IllegalStateException unused) {
            }
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzH(int i3) {
        if (i3 == 3) {
            this.zze.zze();
            this.zzb.zzd();
        } else if (this.zzh == 3) {
            this.zze.zzf();
            this.zzb.zze();
        }
        this.zzh = i3;
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        this.zzn = i3;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView completion");
        zzH(5);
        this.zzi = 5;
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgj(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i3, int i4) {
        Map map = zzc;
        String str = (String) map.get(Integer.valueOf(i3));
        String str2 = (String) map.get(Integer.valueOf(i4));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(str2);
        String string = sb.toString();
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string);
        zzH(-1);
        this.zzi = -1;
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgk(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i3, int i4) {
        Map map = zzc;
        String str = (String) map.get(Integer.valueOf(i3));
        String str2 = (String) map.get(Integer.valueOf(i4));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(str2);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzl
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.zzm
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.zzl
            if (r2 <= 0) goto L7a
            int r2 = r5.zzm
            if (r2 <= 0) goto L7a
            com.google.android.gms.internal.ads.zzchl r2 = r5.zzo
            if (r2 != 0) goto L7a
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L43
            if (r1 != r2) goto L42
            int r0 = r5.zzl
            int r1 = r0 * r7
            int r2 = r5.zzm
            int r3 = r6 * r2
            if (r1 >= r3) goto L3c
            int r0 = r1 / r2
        L3a:
            r1 = r7
            goto L7a
        L3c:
            if (r1 <= r3) goto L60
            int r1 = r3 / r0
        L40:
            r0 = r6
            goto L7a
        L42:
            r0 = r2
        L43:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L54
            int r0 = r5.zzm
            int r0 = r0 * r6
            int r2 = r5.zzl
            int r0 = r0 / r2
            if (r1 != r3) goto L52
            if (r0 <= r7) goto L52
            goto L60
        L52:
            r1 = r0
            goto L40
        L54:
            if (r1 != r2) goto L64
            int r1 = r5.zzl
            int r1 = r1 * r7
            int r2 = r5.zzm
            int r1 = r1 / r2
            if (r0 != r3) goto L62
            if (r1 <= r6) goto L62
        L60:
            r0 = r6
            goto L3a
        L62:
            r0 = r1
            goto L3a
        L64:
            int r2 = r5.zzl
            int r4 = r5.zzm
            if (r1 != r3) goto L70
            if (r4 <= r7) goto L70
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L72
        L70:
            r1 = r2
            r7 = r4
        L72:
            if (r0 != r3) goto L62
            if (r1 <= r6) goto L62
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L40
        L7a:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzchl r6 = r5.zzo
            if (r6 == 0) goto L84
            r6.zzc(r0, r1)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgr.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView prepared");
        zzH(2);
        this.zze.zzb();
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgi(this, mediaPlayer));
        this.zzl = mediaPlayer.getVideoWidth();
        this.zzm = mediaPlayer.getVideoHeight();
        int i3 = this.zzq;
        if (i3 != 0) {
            zzi(i3);
        }
        if (this.zzf && zzF() && this.zzj.getCurrentPosition() > 0 && this.zzi != 3) {
            com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView nudging MediaPlayer");
            zzG(0.0f);
            this.zzj.start();
            int currentPosition = this.zzj.getCurrentPosition();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            while (zzF() && this.zzj.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - jCurrentTimeMillis <= 250) {
            }
            this.zzj.pause();
            zzq();
        }
        int i4 = this.zzl;
        int i5 = this.zzm;
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 40 + String.valueOf(i5).length());
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i4);
        sb.append(" x ");
        sb.append(i5);
        com.google.android.gms.ads.internal.util.client.zzo.e(sb.toString());
        if (this.zzi == 3) {
            zze();
        }
        zzq();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface created");
        zzD();
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgl(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null && this.zzq == 0) {
            this.zzq = mediaPlayer.getCurrentPosition();
        }
        zzchl zzchlVar = this.zzo;
        if (zzchlVar != null) {
            zzchlVar.zzd();
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgn(this));
        zzE(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView surface changed");
        int i5 = this.zzi;
        boolean z2 = false;
        if (this.zzl == i3 && this.zzm == i4) {
            z2 = true;
        }
        if (this.zzj != null && i5 == 3 && z2) {
            int i6 = this.zzq;
            if (i6 != 0) {
                zzi(i6);
            }
            zze();
        }
        zzchl zzchlVar = this.zzo;
        if (zzchlVar != null) {
            zzchlVar.zzc(i3, i4);
        }
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgm(this, i3, i4));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzr);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i4) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 35 + String.valueOf(i4).length());
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i3);
        sb.append(" x ");
        sb.append(i4);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        this.zzl = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzm = videoHeight;
        if (this.zzl == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 47);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzr(i3);
            }
        });
        super.onWindowVisibilityChanged(i3);
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzcgr.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final String zza() {
        return "MediaPlayer".concat(true != this.zzp ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzb(zzcgs zzcgsVar) {
        this.zzr = zzcgsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzc(String str) {
        Uri uri = Uri.parse(str);
        zzbhb zzbhbVarZza = zzbhb.zza(uri);
        if (zzbhbVarZza == null || zzbhbVarZza.zza != null) {
            if (zzbhbVarZza != null) {
                uri = Uri.parse(zzbhbVarZza.zza);
            }
            this.zzk = uri;
            this.zzq = 0;
            zzD();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzd() {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzj.release();
            this.zzj = null;
            zzH(0);
            this.zzi = 0;
        }
        this.zze.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zze() {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView play");
        if (zzF()) {
            this.zzj.start();
            zzH(3);
            this.zza.zza();
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgo(this));
        }
        this.zzi = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzf() {
        com.google.android.gms.ads.internal.util.zze.k("AdMediaPlayerView pause");
        if (zzF() && this.zzj.isPlaying()) {
            this.zzj.pause();
            zzH(4);
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzcgp(this));
        }
        this.zzi = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzg() {
        if (zzF()) {
            return this.zzj.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzh() {
        if (zzF()) {
            return this.zzj.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzi(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 23);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (!zzF()) {
            this.zzq = i3;
        } else {
            this.zzj.seekTo(i3);
            this.zzq = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final void zzj(float f3, float f4) {
        zzchl zzchlVar = this.zzo;
        if (zzchlVar != null) {
            zzchlVar.zzf(f3, f4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzk() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzl() {
        MediaPlayer mediaPlayer = this.zzj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzm() {
        if (this.zzt != null) {
            return (zzo() * ((long) this.zzn)) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzn() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final long zzo() {
        if (this.zzt != null) {
            return ((long) zzg()) * ((long) this.zzt.intValue());
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt
    public final int zzp() {
        if (zzF()) {
            return this.zzj.getMetrics().getInt("android.media.mediaplayer.dropped");
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcgt, com.google.android.gms.internal.ads.zzchq
    public final void zzq() {
        zzG(this.zzb.zzc());
    }

    final /* synthetic */ void zzr(int i3) {
        zzcgs zzcgsVar = this.zzr;
        if (zzcgsVar != null) {
            zzcgsVar.onWindowVisibilityChanged(i3);
        }
    }

    final /* synthetic */ void zzs(MediaPlayer mediaPlayer) {
        MediaFormat format;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue() || this.zzd == null || mediaPlayer == null) {
            return;
        }
        try {
            MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
            if (trackInfo != null) {
                HashMap map = new HashMap();
                for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                    if (trackInfo2 != null) {
                        int trackType = trackInfo2.getTrackType();
                        if (trackType == 1) {
                            MediaFormat format2 = trackInfo2.getFormat();
                            if (format2 != null) {
                                if (format2.containsKey("frame-rate")) {
                                    try {
                                        map.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                    } catch (ClassCastException unused) {
                                        map.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                    }
                                }
                                if (format2.containsKey("bitrate")) {
                                    Integer numValueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                    this.zzt = numValueOf;
                                    map.put("bitRate", String.valueOf(numValueOf));
                                }
                                if (format2.containsKey(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) && format2.containsKey(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                                    int integer = format2.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                                    int integer2 = format2.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                                    StringBuilder sb = new StringBuilder(String.valueOf(integer).length() + 1 + String.valueOf(integer2).length());
                                    sb.append(integer);
                                    sb.append("x");
                                    sb.append(integer2);
                                    map.put("resolution", sb.toString());
                                }
                                if (format2.containsKey("mime")) {
                                    map.put("videoMime", format2.getString("mime"));
                                }
                                if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                    map.put("videoCodec", format2.getString("codecs-string"));
                                }
                            }
                        } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                            if (format.containsKey("mime")) {
                                map.put("audioMime", format.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                                map.put("audioCodec", format.getString("codecs-string"));
                            }
                        }
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                this.zzd.zze("onMetadataEvent", map);
            }
        } catch (RuntimeException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdMediaPlayerView.reportMetadata");
        }
    }

    final /* synthetic */ zzcgs zzt() {
        return this.zzr;
    }

    final /* synthetic */ boolean zzu() {
        return this.zzs;
    }

    final /* synthetic */ void zzv(boolean z2) {
        this.zzs = true;
    }
}
