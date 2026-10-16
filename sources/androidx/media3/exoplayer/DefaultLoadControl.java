package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultLoadControl implements LoadControl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DefaultAllocator f42904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f42905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f42906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f42907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f42908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f42909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f42910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f42911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f42912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap f42913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f42914l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private DefaultAllocator f42915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f42916b = 50000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f42917c = 50000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f42918d = 1000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f42919e = AdError.SERVER_ERROR_CODE;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f42920f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f42921g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f42922h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f42923i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f42924j;

        public DefaultLoadControl a() {
            Assertions.g(!this.f42924j);
            this.f42924j = true;
            if (this.f42915a == null) {
                this.f42915a = new DefaultAllocator(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
            return new DefaultLoadControl(this.f42915a, this.f42916b, this.f42917c, this.f42918d, this.f42919e, this.f42920f, this.f42921g, this.f42922h, this.f42923i);
        }

        public Builder b(int i3, int i4, int i5, int i6) {
            Assertions.g(!this.f42924j);
            DefaultLoadControl.s(i5, 0, "bufferForPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            DefaultLoadControl.s(i6, 0, "bufferForPlaybackAfterRebufferMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            DefaultLoadControl.s(i3, i5, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.s(i3, i6, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.s(i4, i3, "maxBufferMs", "minBufferMs");
            this.f42916b = i3;
            this.f42917c = i4;
            this.f42918d = i5;
            this.f42919e = i6;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PlayerLoadingState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f42925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f42926b;

        private PlayerLoadingState() {
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), 50000, 50000, 1000, AdError.SERVER_ERROR_CODE, -1, false, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(int i3, int i4, String str, String str2) {
        Assertions.b(i3 >= i4, str + " cannot be less than " + str2);
    }

    private static int v(int i3) {
        switch (i3) {
            case -2:
                return 0;
            case -1:
                return 13107200;
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void w(PlayerId playerId) {
        if (this.f42913k.remove(playerId) != null) {
            y();
        }
    }

    private void x(PlayerId playerId) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.e((PlayerLoadingState) this.f42913k.get(playerId));
        int i3 = this.f42909g;
        if (i3 == -1) {
            i3 = 13107200;
        }
        playerLoadingState.f42926b = i3;
        playerLoadingState.f42925a = false;
    }

    private void y() {
        if (this.f42913k.isEmpty()) {
            this.f42904b.g();
        } else {
            this.f42904b.h(u());
        }
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean a(LoadControl.Parameters parameters) {
        long jL0 = Util.l0(parameters.f43115e, parameters.f43116f);
        long jMin = parameters.f43118h ? this.f42908f : this.f42907e;
        long j3 = parameters.f43119i;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(j3 / 2, jMin);
        }
        if (jMin <= 0 || jL0 >= jMin) {
            return true;
        }
        return !this.f42910h && this.f42904b.f() >= u();
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void d(PlayerId playerId) {
        long id = Thread.currentThread().getId();
        long j3 = this.f42914l;
        Assertions.h(j3 == -1 || j3 == id, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.f42914l = id;
        if (!this.f42913k.containsKey(playerId)) {
            this.f42913k.put(playerId, new PlayerLoadingState());
        }
        x(playerId);
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean f(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        Iterator it = this.f42913k.values().iterator();
        while (it.hasNext()) {
            if (((PlayerLoadingState) it.next()).f42925a) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void g(LoadControl.Parameters parameters, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.e((PlayerLoadingState) this.f42913k.get(parameters.f43111a));
        int iT = this.f42909g;
        if (iT == -1) {
            iT = t(exoTrackSelectionArr);
        }
        playerLoadingState.f42926b = iT;
        y();
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public Allocator h() {
        return this.f42904b;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void j(PlayerId playerId) {
        w(playerId);
        if (this.f42913k.isEmpty()) {
            this.f42914l = -1L;
        }
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean k(LoadControl.Parameters parameters) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.e((PlayerLoadingState) this.f42913k.get(parameters.f43111a));
        boolean z2 = true;
        boolean z3 = this.f42904b.f() >= u();
        long jMin = this.f42905c;
        float f3 = parameters.f43116f;
        if (f3 > 1.0f) {
            jMin = Math.min(Util.f0(jMin, f3), this.f42906d);
        }
        long jMax = Math.max(jMin, 500000L);
        long j3 = parameters.f43115e;
        if (j3 < jMax) {
            if (!this.f42910h && z3) {
                z2 = false;
            }
            playerLoadingState.f42925a = z2;
            if (!z2 && j3 < 500000) {
                Log.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.f42906d || z3) {
            playerLoadingState.f42925a = false;
        }
        return playerLoadingState.f42925a;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void l(PlayerId playerId) {
        w(playerId);
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean o(PlayerId playerId) {
        return this.f42912j;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public long q(PlayerId playerId) {
        return this.f42911i;
    }

    protected int t(ExoTrackSelection[] exoTrackSelectionArr) {
        int iV = 0;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                iV += v(exoTrackSelection.h().f41155c);
            }
        }
        return Math.max(13107200, iV);
    }

    int u() {
        Iterator it = this.f42913k.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((PlayerLoadingState) it.next()).f42926b;
        }
        return i3;
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8, boolean z3) {
        s(i5, 0, "bufferForPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        s(i6, 0, "bufferForPlaybackAfterRebufferMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        s(i3, i5, "minBufferMs", "bufferForPlaybackMs");
        s(i3, i6, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        s(i4, i3, "maxBufferMs", "minBufferMs");
        s(i8, 0, "backBufferDurationMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f42904b = defaultAllocator;
        this.f42905c = Util.P0(i3);
        this.f42906d = Util.P0(i4);
        this.f42907e = Util.P0(i5);
        this.f42908f = Util.P0(i6);
        this.f42909g = i7;
        this.f42910h = z2;
        this.f42911i = Util.P0(i8);
        this.f42912j = z3;
        this.f42913k = new HashMap();
        this.f42914l = -1L;
    }
}
