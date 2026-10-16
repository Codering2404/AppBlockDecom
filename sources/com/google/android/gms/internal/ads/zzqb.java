package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.analytics.r2;
import androidx.media3.exoplayer.analytics.u2;
import androidx.media3.exoplayer.analytics.v1;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqb implements zznp, zzqc {
    private boolean zzA;
    private final Context zza;
    private final zzqd zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzau zzo;
    private zzqa zzp;
    private zzqa zzq;
    private zzqa zzr;
    private zzv zzs;
    private zzv zzt;
    private zzv zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzdh.zza();
    private final zzbe zzf = new zzbe();
    private final zzbd zzg = new zzbd();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzqb(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzpu zzpuVar = new zzpu(zzpu.zza);
        this.zzc = zzpuVar;
        zzpuVar.zza(this);
    }

    private final void zzA(int i3, long j3, zzv zzvVar, int i4) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = v1.a(i3).setTimeSinceCreatedMillis(j3 - this.zze);
        if (zzvVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i4 != 1 ? 1 : 2);
            String str = zzvVar.zzo;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzvVar.zzp;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzvVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i5 = zzvVar.zzj;
            if (i5 != -1) {
                timeSinceCreatedMillis.setBitrate(i5);
            }
            int i6 = zzvVar.zzw;
            if (i6 != -1) {
                timeSinceCreatedMillis.setWidth(i6);
            }
            int i7 = zzvVar.zzx;
            if (i7 != -1) {
                timeSinceCreatedMillis.setHeight(i7);
            }
            int i8 = zzvVar.zzH;
            if (i8 != -1) {
                timeSinceCreatedMillis.setChannelCount(i8);
            }
            int i9 = zzvVar.zzI;
            if (i9 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i9);
            }
            String str4 = zzvVar.zzd;
            if (str4 != null) {
                String str5 = zzfl.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f3 = zzvVar.zzA;
            if (f3 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f3);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzu(trackChangeEventBuild);
            }
        });
    }

    @RequiresNonNull
    private final void zzB(zzbf zzbfVar, zzxk zzxkVar) {
        int iZze;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzxkVar == null || (iZze = zzbfVar.zze(zzxkVar.zza)) == -1) {
            return;
        }
        zzbd zzbdVar = this.zzg;
        int i3 = 0;
        zzbfVar.zzd(iZze, zzbdVar, false);
        zzbe zzbeVar = this.zzf;
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzag zzagVar = zzbeVar.zzd.zzb;
        if (zzagVar != null) {
            int iZzI = zzfl.zzI(zzagVar.zza);
            i3 = iZzI != 0 ? iZzI != 1 ? iZzI != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i3);
        long j3 = zzbeVar.zzm;
        if (j3 != -9223372036854775807L && !zzbeVar.zzk && !zzbeVar.zzi && !zzbeVar.zzb()) {
            builder.setMediaDurationMillis(zzfl.zzr(j3));
        }
        builder.setPlaybackType(true != zzbeVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzC() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l3 = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l3 == null ? 0L : l3.longValue());
            Long l4 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l4 == null ? 0L : l4.longValue());
            this.zzk.setStreamSource((l4 == null || l4.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(playbackMetricsBuild);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private static int zzD(int i3) {
        switch (zzfl.zzH(i3)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    public static zzqb zza(Context context) {
        MediaMetricsManager mediaMetricsManagerA = u2.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new zzqb(context, mediaMetricsManagerA.createPlaybackSession());
    }

    @EnsuresNonNullIf
    private final boolean zzw(zzqa zzqaVar) {
        if (zzqaVar != null) {
            return zzqaVar.zzc.equals(this.zzc.zzf());
        }
        return false;
    }

    private final void zzx(long j3, zzv zzvVar, int i3) {
        if (Objects.equals(this.zzs, zzvVar)) {
            return;
        }
        int i4 = this.zzs == null ? 1 : 0;
        this.zzs = zzvVar;
        zzA(1, j3, zzvVar, i4);
    }

    private final void zzy(long j3, zzv zzvVar, int i3) {
        if (Objects.equals(this.zzt, zzvVar)) {
            return;
        }
        int i4 = this.zzt == null ? 1 : 0;
        this.zzt = zzvVar;
        zzA(0, j3, zzvVar, i4);
    }

    private final void zzz(long j3, zzv zzvVar, int i3) {
        if (Objects.equals(this.zzu, zzvVar)) {
            return;
        }
        int i4 = this.zzu == null ? 1 : 0;
        this.zzu = zzvVar;
        zzA(2, j3, zzvVar, i4);
    }

    public final LogSessionId zzb() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzqc
    public final void zzc(zznn zznnVar, String str) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null || !zzxkVar.zzb()) {
            zzC();
            this.zzj = str;
            this.zzk = r2.a().setPlayerName("AndroidXMedia3").setPlayerVersion("1.10.0-rc02");
            zzB(zznnVar.zzb, zzxkVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqc
    public final void zzd(zznn zznnVar, String str, boolean z2) {
        zzxk zzxkVar = zznnVar.zzd;
        if ((zzxkVar == null || !zzxkVar.zzb()) && str.equals(this.zzj)) {
            zzC();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzde(zznn zznnVar, zzba zzbaVar, zzba zzbaVar2, int i3) {
        if (i3 == 1) {
            this.zzv = true;
            i3 = 1;
        }
        this.zzl = i3;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdf(zznn zznnVar, zzxg zzxgVar) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar == null) {
            return;
        }
        zzv zzvVar = zzxgVar.zzb;
        zzvVar.getClass();
        zzqa zzqaVar = new zzqa(zzvVar, 0, this.zzc.zzb(zznnVar.zzb, zzxkVar));
        int i3 = zzxgVar.zza;
        if (i3 != 0) {
            if (i3 == 1) {
                this.zzq = zzqaVar;
                return;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                this.zzr = zzqaVar;
                return;
            }
        }
        this.zzp = zzqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdg(zznn zznnVar, int i3, long j3, long j4) {
        zzxk zzxkVar = zznnVar.zzd;
        if (zzxkVar != null) {
            String strZzb = this.zzc.zzb(zznnVar.zzb, zzxkVar);
            HashMap map = this.zzi;
            Long l3 = (Long) map.get(strZzb);
            HashMap map2 = this.zzh;
            Long l4 = (Long) map2.get(strZzb);
            map.put(strZzb, Long.valueOf((l3 == null ? 0L : l3.longValue()) + j3));
            map2.put(strZzb, Long.valueOf((l4 != null ? l4.longValue() : 0L) + ((long) i3)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzdh(zznn zznnVar, zzjb zzjbVar) {
        this.zzx += zzjbVar.zzg;
        this.zzy += zzjbVar.zze;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x029b  */
    @Override // com.google.android.gms.internal.ads.zznp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzdi(com.google.android.gms.internal.ads.zzbb r20, com.google.android.gms.internal.ads.zzno r21) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqb.zzdi(com.google.android.gms.internal.ads.zzbb, com.google.android.gms.internal.ads.zzno):void");
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzg(zznn zznnVar, zzau zzauVar) {
        this.zzo = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzp(zznn zznnVar, zzbv zzbvVar) {
        zzqa zzqaVar = this.zzp;
        if (zzqaVar != null) {
            zzv zzvVar = zzqaVar.zza;
            if (zzvVar.zzx == -1) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzv(zzbvVar.zzb);
                zztVarZza.zzw(zzbvVar.zzc);
                this.zzp = new zzqa(zztVarZza.zzO(), 0, zzqaVar.zzc);
            }
        }
    }

    final /* synthetic */ void zzr(PlaybackErrorEvent playbackErrorEvent) {
        this.zzd.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    final /* synthetic */ void zzs(NetworkEvent networkEvent) {
        this.zzd.reportNetworkEvent(networkEvent);
    }

    final /* synthetic */ void zzt(PlaybackStateEvent playbackStateEvent) {
        this.zzd.reportPlaybackStateEvent(playbackStateEvent);
    }

    final /* synthetic */ void zzu(TrackChangeEvent trackChangeEvent) {
        this.zzd.reportTrackChangeEvent(trackChangeEvent);
    }

    final /* synthetic */ void zzv(PlaybackMetrics playbackMetrics) {
        this.zzd.reportPlaybackMetrics(playbackMetrics);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzh(zznn zznnVar, zzxb zzxbVar, zzxg zzxgVar, IOException iOException, boolean z2) {
    }
}
