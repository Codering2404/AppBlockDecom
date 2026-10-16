package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PreloadMediaPeriod implements MediaPeriod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaPeriod f45218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f45219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaPeriod.Callback f45221d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PreloadTrackSelectionHolder f45222f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PreloadTrackSelectionHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExoTrackSelection[] f45224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f45225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SampleStream[] f45226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f45227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f45228e;

        public PreloadTrackSelectionHolder(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
            this.f45224a = exoTrackSelectionArr;
            this.f45225b = zArr;
            this.f45226c = sampleStreamArr;
            this.f45227d = zArr2;
            this.f45228e = j3;
        }
    }

    public PreloadMediaPeriod(MediaPeriod mediaPeriod) {
        this.f45218a = mediaPeriod;
    }

    private static boolean g(ExoTrackSelection exoTrackSelection, ExoTrackSelection exoTrackSelection2) {
        if (!Objects.equals(exoTrackSelection.h(), exoTrackSelection2.h()) || exoTrackSelection.length() != exoTrackSelection2.length()) {
            return false;
        }
        for (int i3 = 0; i3 < exoTrackSelection.length(); i3++) {
            if (exoTrackSelection.d(i3) != exoTrackSelection2.d(i3)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m(ExoTrackSelection[] exoTrackSelectionArr, PreloadTrackSelectionHolder preloadTrackSelectionHolder) {
        ExoTrackSelection[] exoTrackSelectionArr2 = ((PreloadTrackSelectionHolder) Assertions.e(preloadTrackSelectionHolder)).f45224a;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < exoTrackSelectionArr.length) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
            ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr2[i3];
            if (exoTrackSelection != null || exoTrackSelection2 != null) {
                preloadTrackSelectionHolder.f45225b[i3] = false;
                if (exoTrackSelection == null) {
                    preloadTrackSelectionHolder.f45224a[i3] = null;
                } else if (exoTrackSelection2 == null || !g(exoTrackSelection, exoTrackSelection2)) {
                    preloadTrackSelectionHolder.f45224a[i3] = exoTrackSelection;
                } else if (exoTrackSelection.h().f41155c == 2 || exoTrackSelection.h().f41155c == 1 || exoTrackSelection.k() == exoTrackSelection2.k()) {
                    preloadTrackSelectionHolder.f45225b[i3] = true;
                } else {
                    preloadTrackSelectionHolder.f45224a[i3] = exoTrackSelection;
                }
                z2 = true;
            }
            i3++;
        }
        return z2;
    }

    private void p(long j3) {
        this.f45220c = true;
        this.f45218a.r(new MediaPeriod.Callback() { // from class: androidx.media3.exoplayer.source.preload.PreloadMediaPeriod.1
            @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void h(MediaPeriod mediaPeriod) {
                ((MediaPeriod.Callback) Assertions.e(PreloadMediaPeriod.this.f45221d)).h(PreloadMediaPeriod.this);
            }

            @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
            public void g(MediaPeriod mediaPeriod) {
                PreloadMediaPeriod preloadMediaPeriod = PreloadMediaPeriod.this;
                preloadMediaPeriod.f45219b = true;
                ((MediaPeriod.Callback) Assertions.e(preloadMediaPeriod.f45221d)).g(PreloadMediaPeriod.this);
            }
        }, j3);
    }

    private long t(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        PreloadTrackSelectionHolder preloadTrackSelectionHolder = this.f45222f;
        if (preloadTrackSelectionHolder == null) {
            return this.f45218a.k(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
        }
        Assertions.g(sampleStreamArr.length == preloadTrackSelectionHolder.f45226c.length);
        PreloadTrackSelectionHolder preloadTrackSelectionHolder2 = this.f45222f;
        if (j3 == preloadTrackSelectionHolder2.f45228e) {
            PreloadTrackSelectionHolder preloadTrackSelectionHolder3 = (PreloadTrackSelectionHolder) Assertions.e(preloadTrackSelectionHolder2);
            long jK = preloadTrackSelectionHolder3.f45228e;
            boolean[] zArr3 = preloadTrackSelectionHolder3.f45227d;
            if (m(exoTrackSelectionArr, preloadTrackSelectionHolder3)) {
                boolean[] zArr4 = new boolean[zArr3.length];
                jK = this.f45218a.k(preloadTrackSelectionHolder3.f45224a, preloadTrackSelectionHolder3.f45225b, preloadTrackSelectionHolder3.f45226c, zArr4, preloadTrackSelectionHolder3.f45228e);
                int i3 = 0;
                while (true) {
                    boolean[] zArr5 = preloadTrackSelectionHolder3.f45225b;
                    if (i3 >= zArr5.length) {
                        break;
                    }
                    if (zArr5[i3]) {
                        zArr4[i3] = true;
                    }
                    i3++;
                }
                zArr3 = zArr4;
            }
            SampleStream[] sampleStreamArr2 = preloadTrackSelectionHolder3.f45226c;
            System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, sampleStreamArr2.length);
            System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            this.f45222f = null;
            return jK;
        }
        int i4 = 0;
        while (true) {
            SampleStream[] sampleStreamArr3 = this.f45222f.f45226c;
            if (i4 >= sampleStreamArr3.length) {
                this.f45222f = null;
                return this.f45218a.k(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
            }
            SampleStream sampleStream = sampleStreamArr3[i4];
            if (sampleStream != null) {
                sampleStreamArr[i4] = sampleStream;
                zArr[i4] = false;
            }
            i4++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f45218a.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        return this.f45218a.b(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return this.f45218a.c();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        return this.f45218a.e();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        this.f45218a.f(j3);
    }

    public void h() {
        Assertions.g(this.f45219b);
        PreloadTrackSelectionHolder preloadTrackSelectionHolder = this.f45222f;
        if (preloadTrackSelectionHolder != null) {
            for (SampleStream sampleStream : preloadTrackSelectionHolder.f45226c) {
                if (sampleStream != null) {
                    sampleStream.d();
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        return this.f45218a.i(j3, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        return this.f45218a.j(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        return t(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        return this.f45218a.l();
    }

    public void n(MediaPeriod.Callback callback, long j3) {
        this.f45221d = callback;
        if (this.f45219b) {
            callback.g(this);
        }
        if (this.f45220c) {
            return;
        }
        p(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
        this.f45218a.o();
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, long j3) {
        SampleStream[] sampleStreamArr = new SampleStream[exoTrackSelectionArr.length];
        boolean[] zArr = new boolean[exoTrackSelectionArr.length];
        boolean[] zArr2 = new boolean[exoTrackSelectionArr.length];
        long jT = t(exoTrackSelectionArr, zArr2, sampleStreamArr, zArr, j3);
        this.f45222f = new PreloadTrackSelectionHolder(exoTrackSelectionArr, zArr2, sampleStreamArr, zArr, jT);
        return jT;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f45221d = callback;
        if (this.f45219b) {
            callback.g(this);
        } else {
            if (this.f45220c) {
                return;
            }
            p(j3);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f45218a.s();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        this.f45218a.u(j3, z2);
    }
}
