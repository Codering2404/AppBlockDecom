package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MediaPeriodHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaPeriod f43143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f43144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SampleStream[] f43145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f43146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f43147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f43148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaPeriodInfo f43150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f43151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean[] f43152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RendererCapabilities[] f43153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TrackSelector f43154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MediaSourceList f43155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MediaPeriodHolder f43156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TrackGroupArray f43157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TrackSelectorResult f43158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f43159q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Factory {
        MediaPeriodHolder a(MediaPeriodInfo mediaPeriodInfo, long j3);
    }

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j3, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult, long j4) {
        this.f43153k = rendererCapabilitiesArr;
        this.f43159q = j3;
        this.f43154l = trackSelector;
        this.f43155m = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f43160a;
        this.f43144b = mediaPeriodId.f44754a;
        this.f43150h = mediaPeriodInfo;
        this.f43146d = j4;
        this.f43157o = TrackGroupArray.f44985d;
        this.f43158p = trackSelectorResult;
        this.f43145c = new SampleStream[rendererCapabilitiesArr.length];
        this.f43152j = new boolean[rendererCapabilitiesArr.length];
        this.f43143a = f(mediaPeriodId, mediaSourceList, allocator, mediaPeriodInfo.f43161b, mediaPeriodInfo.f43163d, mediaPeriodInfo.f43165f);
    }

    private void c(SampleStream[] sampleStreamArr) {
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f43153k;
            if (i3 >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i3].g() == -2 && this.f43158p.c(i3)) {
                sampleStreamArr[i3] = new EmptySampleStream();
            }
            i3++;
        }
    }

    private static MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList, Allocator allocator, long j3, long j4, boolean z2) {
        MediaPeriod mediaPeriodH = mediaSourceList.h(mediaPeriodId, allocator, j3);
        return j4 != -9223372036854775807L ? new ClippingMediaPeriod(mediaPeriodH, !z2, 0L, j4) : mediaPeriodH;
    }

    private void g() {
        if (!u()) {
            return;
        }
        int i3 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f43158p;
            if (i3 >= trackSelectorResult.f45455a) {
                return;
            }
            boolean zC = trackSelectorResult.c(i3);
            ExoTrackSelection exoTrackSelection = this.f43158p.f45457c[i3];
            if (zC && exoTrackSelection != null) {
                exoTrackSelection.c();
            }
            i3++;
        }
    }

    private void h(SampleStream[] sampleStreamArr) {
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f43153k;
            if (i3 >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i3].g() == -2) {
                sampleStreamArr[i3] = null;
            }
            i3++;
        }
    }

    private void i() {
        if (!u()) {
            return;
        }
        int i3 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f43158p;
            if (i3 >= trackSelectorResult.f45455a) {
                return;
            }
            boolean zC = trackSelectorResult.c(i3);
            ExoTrackSelection exoTrackSelection = this.f43158p.f45457c[i3];
            if (zC && exoTrackSelection != null) {
                exoTrackSelection.j();
            }
            i3++;
        }
    }

    private boolean u() {
        return this.f43156n == null;
    }

    private static void y(MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaSourceList.z(((ClippingMediaPeriod) mediaPeriod).f44553a);
            } else {
                mediaSourceList.z(mediaPeriod);
            }
        } catch (RuntimeException e3) {
            Log.e("MediaPeriodHolder", "Period release failed.", e3);
        }
    }

    public void A(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == this.f43156n) {
            return;
        }
        g();
        this.f43156n = mediaPeriodHolder;
        i();
    }

    public void B(long j3) {
        this.f43159q = j3;
    }

    public long C(long j3) {
        return j3 - m();
    }

    public long D(long j3) {
        return j3 + m();
    }

    public void E() {
        MediaPeriod mediaPeriod = this.f43143a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j3 = this.f43150h.f43163d;
            if (j3 == -9223372036854775807L) {
                j3 = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) mediaPeriod).v(0L, j3);
        }
    }

    public long a(TrackSelectorResult trackSelectorResult, long j3, boolean z2) {
        return b(trackSelectorResult, j3, z2, new boolean[this.f43153k.length]);
    }

    public long b(TrackSelectorResult trackSelectorResult, long j3, boolean z2, boolean[] zArr) {
        int i3 = 0;
        while (true) {
            boolean z3 = true;
            if (i3 >= trackSelectorResult.f45455a) {
                break;
            }
            boolean[] zArr2 = this.f43152j;
            if (z2 || !trackSelectorResult.b(this.f43158p, i3)) {
                z3 = false;
            }
            zArr2[i3] = z3;
            i3++;
        }
        h(this.f43145c);
        g();
        this.f43158p = trackSelectorResult;
        i();
        long jK = this.f43143a.k(trackSelectorResult.f45457c, this.f43152j, this.f43145c, zArr, j3);
        c(this.f43145c);
        this.f43149g = false;
        int i4 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f43145c;
            if (i4 >= sampleStreamArr.length) {
                return jK;
            }
            if (sampleStreamArr[i4] != null) {
                Assertions.g(trackSelectorResult.c(i4));
                if (this.f43153k[i4].g() != -2) {
                    this.f43149g = true;
                }
            } else {
                Assertions.g(trackSelectorResult.f45457c[i4] == null);
            }
            i4++;
        }
    }

    public boolean d(MediaPeriodInfo mediaPeriodInfo) {
        if (!MediaPeriodQueue.e(this.f43150h.f43164e, mediaPeriodInfo.f43164e)) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo2 = this.f43150h;
        return mediaPeriodInfo2.f43161b == mediaPeriodInfo.f43161b && mediaPeriodInfo2.f43160a.equals(mediaPeriodInfo.f43160a);
    }

    public void e(LoadingInfo loadingInfo) {
        Assertions.g(u());
        this.f43143a.b(loadingInfo);
    }

    public long j() {
        if (!this.f43148f) {
            return this.f43150h.f43161b;
        }
        long jE = this.f43149g ? this.f43143a.e() : Long.MIN_VALUE;
        return jE == Long.MIN_VALUE ? this.f43150h.f43164e : jE;
    }

    public MediaPeriodHolder k() {
        return this.f43156n;
    }

    public long l() {
        if (this.f43148f) {
            return this.f43143a.c();
        }
        return 0L;
    }

    public long m() {
        return this.f43159q;
    }

    public long n() {
        return this.f43150h.f43161b + this.f43159q;
    }

    public TrackGroupArray o() {
        return this.f43157o;
    }

    public TrackSelectorResult p() {
        return this.f43158p;
    }

    public void q(float f3, Timeline timeline, boolean z2) {
        this.f43148f = true;
        this.f43157o = this.f43143a.s();
        TrackSelectorResult trackSelectorResultZ = z(f3, timeline, z2);
        MediaPeriodInfo mediaPeriodInfo = this.f43150h;
        long jMax = mediaPeriodInfo.f43161b;
        long j3 = mediaPeriodInfo.f43164e;
        if (j3 != -9223372036854775807L && jMax >= j3) {
            jMax = Math.max(0L, j3 - 1);
        }
        long jA = a(trackSelectorResultZ, jMax, false);
        long j4 = this.f43159q;
        MediaPeriodInfo mediaPeriodInfo2 = this.f43150h;
        this.f43159q = j4 + (mediaPeriodInfo2.f43161b - jA);
        this.f43150h = mediaPeriodInfo2.b(jA);
    }

    public boolean r() {
        try {
            if (this.f43148f) {
                for (SampleStream sampleStream : this.f43145c) {
                    if (sampleStream != null) {
                        sampleStream.d();
                    }
                }
            } else {
                this.f43143a.o();
            }
            return false;
        } catch (IOException unused) {
            return true;
        }
    }

    public boolean s() {
        if (this.f43148f) {
            return !this.f43149g || this.f43143a.e() == Long.MIN_VALUE;
        }
        return false;
    }

    public boolean t() {
        if (this.f43148f) {
            return s() || j() - this.f43150h.f43161b >= this.f43146d;
        }
        return false;
    }

    public void v(MediaPeriod.Callback callback, long j3) {
        this.f43147e = true;
        this.f43143a.r(callback, j3);
    }

    public void w(long j3) {
        Assertions.g(u());
        if (this.f43148f) {
            this.f43143a.f(C(j3));
        }
    }

    public void x() {
        g();
        y(this.f43155m, this.f43143a);
    }

    public TrackSelectorResult z(float f3, Timeline timeline, boolean z2) {
        TrackSelectorResult trackSelectorResultK = this.f43154l.k(this.f43153k, o(), this.f43150h.f43160a, timeline);
        for (int i3 = 0; i3 < trackSelectorResultK.f45455a; i3++) {
            if (trackSelectorResultK.c(i3)) {
                if (trackSelectorResultK.f45457c[i3] == null && this.f43153k[i3].g() != -2) {
                    z = false;
                }
                Assertions.g(z);
            } else {
                Assertions.g(trackSelectorResultK.f45457c[i3] == null);
            }
        }
        for (ExoTrackSelection exoTrackSelection : trackSelectorResultK.f45457c) {
            if (exoTrackSelection != null) {
                exoTrackSelection.e(f3);
                exoTrackSelection.i(z2);
            }
        }
        return trackSelectorResultK;
    }
}
