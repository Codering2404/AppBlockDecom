package androidx.media3.common;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleBasePlayer extends BasePlayer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListenerSet f40983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Looper f40984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HandlerWrapper f40985d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet f40986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Timeline.Period f40987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private State f40988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f40989i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class LivePositionSupplier implements PositionSupplier {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PositionSupplier f40990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f40991c = -9223372036854775807L;

        public LivePositionSupplier(PositionSupplier positionSupplier) {
            this.f40990b = positionSupplier;
        }

        public void e(long j3) {
            this.f40991c = j3;
        }

        @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
        public long get() {
            long j3 = this.f40991c;
            return j3 != -9223372036854775807L ? j3 : this.f40990b.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class MediaItemData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f40992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Tracks f40993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MediaItem f40994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaMetadata f40995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f40996e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MediaItem.LiveConfiguration f40997f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f40998g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f40999h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f41000i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f41001j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f41002k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f41003l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f41004m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f41005n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f41006o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ImmutableList f41007p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final long[] f41008q;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Object f41009a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Tracks f41010b = Tracks.f41239b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private MediaItem f41011c = MediaItem.f40706i;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private MediaMetadata f41012d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Object f41013e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private MediaItem.LiveConfiguration f41014f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private long f41015g = -9223372036854775807L;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private long f41016h = -9223372036854775807L;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private long f41017i = -9223372036854775807L;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f41018j = false;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private boolean f41019k = false;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private long f41020l = 0;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private long f41021m = -9223372036854775807L;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private long f41022n = 0;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private boolean f41023o = false;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private ImmutableList f41024p = ImmutableList.y();

            public Builder(Object obj) {
                this.f41009a = obj;
            }

            public MediaItemData q() {
                return new MediaItemData(this);
            }

            public Builder r(boolean z2) {
                this.f41019k = z2;
                return this;
            }

            public Builder s(boolean z2) {
                this.f41023o = z2;
                return this;
            }

            public Builder t(MediaItem mediaItem) {
                this.f41011c = mediaItem;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public Timeline.Period d(int i3, int i4, Timeline.Period period) {
            if (this.f41007p.isEmpty()) {
                Object obj = this.f40992a;
                period.u(obj, obj, i3, this.f41005n + this.f41004m, 0L, AdPlaybackState.f40484g, this.f41006o);
                return period;
            }
            PeriodData periodData = (PeriodData) this.f41007p.get(i4);
            Object obj2 = periodData.f41025a;
            period.u(obj2, Pair.create(this.f40992a, obj2), i3, periodData.f41026b, this.f41008q[i4], periodData.f41027c, periodData.f41028d);
            return period;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public Object e(int i3) {
            if (this.f41007p.isEmpty()) {
                return this.f40992a;
            }
            return Pair.create(this.f40992a, ((PeriodData) this.f41007p.get(i3)).f41025a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Timeline.Window f(int i3, Timeline.Window window) {
            int size;
            boolean z2;
            if (this.f41007p.isEmpty()) {
                size = 1;
                z2 = true;
            } else {
                size = this.f41007p.size();
                z2 = true;
            }
            window.g(this.f40992a, this.f40994c, this.f40996e, this.f40998g, this.f40999h, this.f41000i, this.f41001j, this.f41002k, this.f40997f, this.f41003l, this.f41004m, i3, (i3 + size) - 1, this.f41005n);
            window.f41145k = this.f41006o;
            return window;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemData)) {
                return false;
            }
            MediaItemData mediaItemData = (MediaItemData) obj;
            return this.f40992a.equals(mediaItemData.f40992a) && this.f40993b.equals(mediaItemData.f40993b) && this.f40994c.equals(mediaItemData.f40994c) && Objects.equals(this.f40995d, mediaItemData.f40995d) && Objects.equals(this.f40996e, mediaItemData.f40996e) && Objects.equals(this.f40997f, mediaItemData.f40997f) && this.f40998g == mediaItemData.f40998g && this.f40999h == mediaItemData.f40999h && this.f41000i == mediaItemData.f41000i && this.f41001j == mediaItemData.f41001j && this.f41002k == mediaItemData.f41002k && this.f41003l == mediaItemData.f41003l && this.f41004m == mediaItemData.f41004m && this.f41005n == mediaItemData.f41005n && this.f41006o == mediaItemData.f41006o && this.f41007p.equals(mediaItemData.f41007p);
        }

        public int hashCode() {
            int iHashCode = (((((217 + this.f40992a.hashCode()) * 31) + this.f40993b.hashCode()) * 31) + this.f40994c.hashCode()) * 31;
            MediaMetadata mediaMetadata = this.f40995d;
            int iHashCode2 = (iHashCode + (mediaMetadata == null ? 0 : mediaMetadata.hashCode())) * 31;
            Object obj = this.f40996e;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f40997f;
            int iHashCode4 = (iHashCode3 + (liveConfiguration != null ? liveConfiguration.hashCode() : 0)) * 31;
            long j3 = this.f40998g;
            int i3 = (iHashCode4 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f40999h;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f41000i;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.f41001j ? 1 : 0)) * 31) + (this.f41002k ? 1 : 0)) * 31;
            long j6 = this.f41003l;
            int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f41004m;
            int i7 = (i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f41005n;
            return ((((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f41006o ? 1 : 0)) * 31) + this.f41007p.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private MediaItemData(Builder builder) {
            int i3 = 0;
            if (builder.f41014f == null) {
                Assertions.b(builder.f41015g == -9223372036854775807L, "presentationStartTimeMs can only be set if liveConfiguration != null");
                Assertions.b(builder.f41016h == -9223372036854775807L, "windowStartTimeMs can only be set if liveConfiguration != null");
                Assertions.b(builder.f41017i == -9223372036854775807L, "elapsedRealtimeEpochOffsetMs can only be set if liveConfiguration != null");
            } else if (builder.f41015g != -9223372036854775807L && builder.f41016h != -9223372036854775807L) {
                Assertions.b(builder.f41016h >= builder.f41015g, "windowStartTimeMs can't be less than presentationStartTimeMs");
            }
            int size = builder.f41024p.size();
            if (builder.f41021m != -9223372036854775807L) {
                Assertions.b(builder.f41020l <= builder.f41021m, "defaultPositionUs can't be greater than durationUs");
            }
            this.f40992a = builder.f41009a;
            this.f40993b = builder.f41010b;
            this.f40994c = builder.f41011c;
            this.f40995d = builder.f41012d;
            this.f40996e = builder.f41013e;
            this.f40997f = builder.f41014f;
            this.f40998g = builder.f41015g;
            this.f40999h = builder.f41016h;
            this.f41000i = builder.f41017i;
            this.f41001j = builder.f41018j;
            this.f41002k = builder.f41019k;
            this.f41003l = builder.f41020l;
            this.f41004m = builder.f41021m;
            long j3 = builder.f41022n;
            this.f41005n = j3;
            this.f41006o = builder.f41023o;
            ImmutableList immutableList = builder.f41024p;
            this.f41007p = immutableList;
            long[] jArr = new long[immutableList.size()];
            this.f41008q = jArr;
            if (immutableList.isEmpty()) {
                return;
            }
            jArr[0] = -j3;
            while (i3 < size - 1) {
                long[] jArr2 = this.f41008q;
                int i4 = i3 + 1;
                jArr2[i4] = jArr2[i3] + ((PeriodData) this.f41007p.get(i3)).f41026b;
                i3 = i4;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class PeriodData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f41025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f41026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AdPlaybackState f41027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f41028d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeriodData)) {
                return false;
            }
            PeriodData periodData = (PeriodData) obj;
            return this.f41025a.equals(periodData.f41025a) && this.f41026b == periodData.f41026b && this.f41027c.equals(periodData.f41027c) && this.f41028d == periodData.f41028d;
        }

        public int hashCode() {
            int iHashCode = (217 + this.f41025a.hashCode()) * 31;
            long j3 = this.f41026b;
            return ((((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f41027c.hashCode()) * 31) + (this.f41028d ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PlaceholderUid {
        private PlaceholderUid() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PlaylistTimeline extends Timeline {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ImmutableList f41029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f41030f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f41031g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final HashMap f41032h;

        public PlaylistTimeline(List list) {
            int size = list.size();
            this.f41029e = ImmutableList.t(list);
            this.f41030f = new int[size];
            int iT = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MediaItemData mediaItemData = (MediaItemData) list.get(i3);
                this.f41030f[i3] = iT;
                iT += t(mediaItemData);
            }
            this.f41031g = new int[iT];
            this.f41032h = new HashMap();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                MediaItemData mediaItemData2 = (MediaItemData) list.get(i5);
                for (int i6 = 0; i6 < t(mediaItemData2); i6++) {
                    this.f41032h.put(mediaItemData2.e(i6), Integer.valueOf(i4));
                    this.f41031g[i4] = i5;
                    i4++;
                }
            }
        }

        private static int t(MediaItemData mediaItemData) {
            if (mediaItemData.f41007p.isEmpty()) {
                return 1;
            }
            return mediaItemData.f41007p.size();
        }

        @Override // androidx.media3.common.Timeline
        public int a(boolean z2) {
            return super.a(z2);
        }

        @Override // androidx.media3.common.Timeline
        public int b(Object obj) {
            Integer num = (Integer) this.f41032h.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.media3.common.Timeline
        public int c(boolean z2) {
            return super.c(z2);
        }

        @Override // androidx.media3.common.Timeline
        public int e(int i3, int i4, boolean z2) {
            return super.e(i3, i4, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            int i4 = this.f41031g[i3];
            return ((MediaItemData) this.f41029e.get(i4)).d(i4, i3 - this.f41030f[i4], period);
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period h(Object obj, Timeline.Period period) {
            return g(((Integer) Assertions.e((Integer) this.f41032h.get(obj))).intValue(), period, true);
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return this.f41031g.length;
        }

        @Override // androidx.media3.common.Timeline
        public int l(int i3, int i4, boolean z2) {
            return super.l(i3, i4, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Object m(int i3) {
            int i4 = this.f41031g[i3];
            return ((MediaItemData) this.f41029e.get(i4)).e(i3 - this.f41030f[i4]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            return ((MediaItemData) this.f41029e.get(i3)).f(this.f41030f[i3], window);
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return this.f41029e.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class State {
        public final MediaMetadata A;
        public final MediaMetadata B;
        public final int C;
        public final int D;
        public final int E;
        public final PositionSupplier F;
        public final PositionSupplier G;
        public final PositionSupplier H;
        public final PositionSupplier I;
        public final PositionSupplier J;
        public final boolean K;
        public final int L;
        public final long M;
        private final boolean N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Player.Commands f41034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f41035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f41038e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final PlaybackException f41039f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f41040g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f41041h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f41042i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f41043j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f41044k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f41045l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final PlaybackParameters f41046m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final TrackSelectionParameters f41047n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final AudioAttributes f41048o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f41049p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final VideoSize f41050q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final CueGroup f41051r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final DeviceInfo f41052s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f41053t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f41054u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Size f41055v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f41056w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final Metadata f41057x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final Timeline f41058y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final Tracks f41059z;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {
            private Tracks A;
            private MediaMetadata B;
            private MediaMetadata C;
            private int D;
            private int E;
            private int F;
            private Long G;
            private PositionSupplier H;
            private Long I;
            private PositionSupplier J;
            private PositionSupplier K;
            private PositionSupplier L;
            private PositionSupplier M;
            private boolean N;
            private int O;
            private long P;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Player.Commands f41060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f41061b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f41062c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f41063d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f41064e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private PlaybackException f41065f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f41066g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f41067h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f41068i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private long f41069j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private long f41070k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private long f41071l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private PlaybackParameters f41072m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private TrackSelectionParameters f41073n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private AudioAttributes f41074o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private float f41075p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private VideoSize f41076q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            private CueGroup f41077r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private DeviceInfo f41078s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private int f41079t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private boolean f41080u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private Size f41081v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            private boolean f41082w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            private Metadata f41083x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            private ImmutableList f41084y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            private Timeline f41085z;

            public Builder A0(float f3) {
                Assertions.a(f3 >= 0.0f && f3 <= 1.0f);
                this.f41075p = f3;
                return this;
            }

            public State Q() {
                return new State(this);
            }

            public Builder R() {
                this.N = false;
                return this;
            }

            public Builder S(PositionSupplier positionSupplier) {
                this.L = positionSupplier;
                return this;
            }

            public Builder T(PositionSupplier positionSupplier) {
                this.I = null;
                this.J = positionSupplier;
                return this;
            }

            public Builder U(AudioAttributes audioAttributes) {
                this.f41074o = audioAttributes;
                return this;
            }

            public Builder V(Player.Commands commands) {
                this.f41060a = commands;
                return this;
            }

            public Builder W(PositionSupplier positionSupplier) {
                this.K = positionSupplier;
                return this;
            }

            public Builder X(long j3) {
                this.G = Long.valueOf(j3);
                return this;
            }

            public Builder Y(PositionSupplier positionSupplier) {
                this.G = null;
                this.H = positionSupplier;
                return this;
            }

            public Builder Z(int i3, int i4) {
                Assertions.a((i3 == -1) == (i4 == -1));
                this.E = i3;
                this.F = i4;
                return this;
            }

            public Builder a0(CueGroup cueGroup) {
                this.f41077r = cueGroup;
                return this;
            }

            public Builder b0(int i3) {
                this.D = i3;
                return this;
            }

            public Builder c0(DeviceInfo deviceInfo) {
                this.f41078s = deviceInfo;
                return this;
            }

            public Builder d0(int i3) {
                Assertions.a(i3 >= 0);
                this.f41079t = i3;
                return this;
            }

            public Builder e0(boolean z2) {
                this.f41080u = z2;
                return this;
            }

            public Builder f0(boolean z2) {
                this.f41068i = z2;
                return this;
            }

            public Builder g0(long j3) {
                this.f41071l = j3;
                return this;
            }

            public Builder h0(boolean z2) {
                this.f41082w = z2;
                return this;
            }

            public Builder i0(boolean z2, int i3) {
                this.f41061b = z2;
                this.f41062c = i3;
                return this;
            }

            public Builder j0(PlaybackParameters playbackParameters) {
                this.f41072m = playbackParameters;
                return this;
            }

            public Builder k0(int i3) {
                this.f41063d = i3;
                return this;
            }

            public Builder l0(int i3) {
                this.f41064e = i3;
                return this;
            }

            public Builder m0(PlaybackException playbackException) {
                this.f41065f = playbackException;
                return this;
            }

            public Builder n0(Timeline timeline, Tracks tracks, MediaMetadata mediaMetadata) {
                this.f41084y = null;
                this.f41085z = timeline;
                this.A = tracks;
                this.B = mediaMetadata;
                return this;
            }

            public Builder o0(List list) {
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Assertions.b(hashSet.add(((MediaItemData) list.get(i3)).f40992a), "Duplicate MediaItemData UID in playlist");
                }
                this.f41084y = ImmutableList.t(list);
                this.f41085z = new PlaylistTimeline(this.f41084y);
                this.A = null;
                this.B = null;
                return this;
            }

            public Builder p0(MediaMetadata mediaMetadata) {
                this.C = mediaMetadata;
                return this;
            }

            public Builder q0(int i3, long j3) {
                this.N = true;
                this.O = i3;
                this.P = j3;
                return this;
            }

            public Builder r0(int i3) {
                this.f41066g = i3;
                return this;
            }

            public Builder s0(long j3) {
                this.f41069j = j3;
                return this;
            }

            public Builder t0(long j3) {
                this.f41070k = j3;
                return this;
            }

            public Builder u0(boolean z2) {
                this.f41067h = z2;
                return this;
            }

            public Builder v0(Size size) {
                this.f41081v = size;
                return this;
            }

            public Builder w0(Metadata metadata) {
                this.f41083x = metadata;
                return this;
            }

            public Builder x0(PositionSupplier positionSupplier) {
                this.M = positionSupplier;
                return this;
            }

            public Builder y0(TrackSelectionParameters trackSelectionParameters) {
                this.f41073n = trackSelectionParameters;
                return this;
            }

            public Builder z0(VideoSize videoSize) {
                this.f41076q = videoSize;
                return this;
            }

            public Builder() {
                this.f41060a = Player.Commands.f40956b;
                this.f41061b = false;
                this.f41062c = 1;
                this.f41063d = 1;
                this.f41064e = 0;
                this.f41065f = null;
                this.f41066g = 0;
                this.f41067h = false;
                this.f41068i = false;
                this.f41069j = 5000L;
                this.f41070k = 15000L;
                this.f41071l = 3000L;
                this.f41072m = PlaybackParameters.f40950d;
                this.f41073n = TrackSelectionParameters.F;
                this.f41074o = AudioAttributes.f40518g;
                this.f41075p = 1.0f;
                this.f41076q = VideoSize.f41254e;
                this.f41077r = CueGroup.f41450c;
                this.f41078s = DeviceInfo.f40568e;
                this.f41079t = 0;
                this.f41080u = false;
                this.f41081v = Size.f41593c;
                this.f41082w = false;
                this.f41083x = new Metadata(-9223372036854775807L, new Metadata.Entry[0]);
                this.f41084y = ImmutableList.y();
                this.f41085z = Timeline.f41105a;
                this.A = null;
                this.B = null;
                this.C = MediaMetadata.K;
                this.D = -1;
                this.E = -1;
                this.F = -1;
                this.G = null;
                this.H = PositionSupplier.b(-9223372036854775807L);
                this.I = null;
                PositionSupplier positionSupplier = PositionSupplier.f41033a;
                this.J = positionSupplier;
                this.K = PositionSupplier.b(-9223372036854775807L);
                this.L = positionSupplier;
                this.M = positionSupplier;
                this.N = false;
                this.O = 5;
                this.P = 0L;
            }

            private Builder(State state) {
                this.f41060a = state.f41034a;
                this.f41061b = state.f41035b;
                this.f41062c = state.f41036c;
                this.f41063d = state.f41037d;
                this.f41064e = state.f41038e;
                this.f41065f = state.f41039f;
                this.f41066g = state.f41040g;
                this.f41067h = state.f41041h;
                this.f41068i = state.f41042i;
                this.f41069j = state.f41043j;
                this.f41070k = state.f41044k;
                this.f41071l = state.f41045l;
                this.f41072m = state.f41046m;
                this.f41073n = state.f41047n;
                this.f41074o = state.f41048o;
                this.f41075p = state.f41049p;
                this.f41076q = state.f41050q;
                this.f41077r = state.f41051r;
                this.f41078s = state.f41052s;
                this.f41079t = state.f41053t;
                this.f41080u = state.f41054u;
                this.f41081v = state.f41055v;
                this.f41082w = state.f41056w;
                this.f41083x = state.f41057x;
                Timeline timeline = state.f41058y;
                this.f41085z = timeline;
                if (timeline instanceof PlaylistTimeline) {
                    this.f41084y = ((PlaylistTimeline) timeline).f41029e;
                } else {
                    this.A = state.f41059z;
                    this.B = state.N ? null : state.A;
                }
                this.C = state.B;
                this.D = state.C;
                this.E = state.D;
                this.F = state.E;
                this.G = null;
                this.H = state.F;
                this.I = null;
                this.J = state.G;
                this.K = state.H;
                this.L = state.I;
                this.M = state.J;
                this.N = state.K;
                this.O = state.L;
                this.P = state.M;
            }
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.f41035b == state.f41035b && this.f41036c == state.f41036c && this.f41034a.equals(state.f41034a) && this.f41037d == state.f41037d && this.f41038e == state.f41038e && Objects.equals(this.f41039f, state.f41039f) && this.f41040g == state.f41040g && this.f41041h == state.f41041h && this.f41042i == state.f41042i && this.f41043j == state.f41043j && this.f41044k == state.f41044k && this.f41045l == state.f41045l && this.f41046m.equals(state.f41046m) && this.f41047n.equals(state.f41047n) && this.f41048o.equals(state.f41048o) && this.f41049p == state.f41049p && this.f41050q.equals(state.f41050q) && this.f41051r.equals(state.f41051r) && this.f41052s.equals(state.f41052s) && this.f41053t == state.f41053t && this.f41054u == state.f41054u && this.f41055v.equals(state.f41055v) && this.f41056w == state.f41056w && this.f41057x.equals(state.f41057x) && this.f41058y.equals(state.f41058y) && this.f41059z.equals(state.f41059z) && this.A.equals(state.A) && this.B.equals(state.B) && this.C == state.C && this.D == state.D && this.E == state.E && this.F.equals(state.F) && this.G.equals(state.G) && this.H.equals(state.H) && this.I.equals(state.I) && this.J.equals(state.J) && this.K == state.K && this.L == state.L && this.M == state.M;
        }

        public int hashCode() {
            int iHashCode = (((((((((217 + this.f41034a.hashCode()) * 31) + (this.f41035b ? 1 : 0)) * 31) + this.f41036c) * 31) + this.f41037d) * 31) + this.f41038e) * 31;
            PlaybackException playbackException = this.f41039f;
            int iHashCode2 = (((((((iHashCode + (playbackException == null ? 0 : playbackException.hashCode())) * 31) + this.f41040g) * 31) + (this.f41041h ? 1 : 0)) * 31) + (this.f41042i ? 1 : 0)) * 31;
            long j3 = this.f41043j;
            int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f41044k;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f41045l;
            int iHashCode3 = (((((((((((((((((((((((((((((((((((((((((((((((((((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f41046m.hashCode()) * 31) + this.f41047n.hashCode()) * 31) + this.f41048o.hashCode()) * 31) + Float.floatToRawIntBits(this.f41049p)) * 31) + this.f41050q.hashCode()) * 31) + this.f41051r.hashCode()) * 31) + this.f41052s.hashCode()) * 31) + this.f41053t) * 31) + (this.f41054u ? 1 : 0)) * 31) + this.f41055v.hashCode()) * 31) + (this.f41056w ? 1 : 0)) * 31) + this.f41057x.hashCode()) * 31) + this.f41058y.hashCode()) * 31) + this.f41059z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F.hashCode()) * 31) + this.G.hashCode()) * 31) + this.H.hashCode()) * 31) + this.I.hashCode()) * 31) + this.J.hashCode()) * 31) + (this.K ? 1 : 0)) * 31) + this.L) * 31;
            long j6 = this.M;
            return iHashCode3 + ((int) (j6 ^ (j6 >>> 32)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x018a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private State(androidx.media3.common.SimpleBasePlayer.State.Builder r18) {
            /*
                Method dump skipped, instruction units count: 672
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.State.<init>(androidx.media3.common.SimpleBasePlayer$State$Builder):void");
        }
    }

    private static Player.PositionInfo A1(State state, boolean z2, Timeline.Window window, Timeline.Period period) {
        MediaItem mediaItem;
        Object obj;
        Object obj2;
        int i3;
        long jQ1;
        long j3;
        int iR1 = r1(state);
        if (state.f41058y.q()) {
            mediaItem = null;
            obj = null;
            obj2 = null;
            i3 = -1;
        } else {
            int iS1 = s1(state, window, period);
            Object obj3 = state.f41058y.g(iS1, period, true).f41115b;
            obj = state.f41058y.n(iR1, window).f41135a;
            obj2 = obj3;
            mediaItem = window.f41137c;
            i3 = iS1;
        }
        if (z2) {
            j3 = state.M;
            jQ1 = state.D == -1 ? j3 : q1(state, window);
        } else {
            jQ1 = q1(state, window);
            j3 = state.D != -1 ? state.G.get() : jQ1;
        }
        return new Player.PositionInfo(obj, iR1, mediaItem, obj2, i3, j3, jQ1, state.D, state.E);
    }

    private static long B1(long j3, State state, Timeline.Window window) {
        if (j3 != -9223372036854775807L) {
            return j3;
        }
        if (state.f41058y.q()) {
            return 0L;
        }
        return state.f41058y.n(r1(state), window).b();
    }

    public static /* synthetic */ State C0(SimpleBasePlayer simpleBasePlayer, List list, State state, int i3, long j3) {
        simpleBasePlayer.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            arrayList.add(simpleBasePlayer.x1((MediaItem) list.get(i4)));
        }
        return D1(state, arrayList, i3, j3, simpleBasePlayer.f40538a);
    }

    private static State D1(State state, List list, int i3, long j3, Timeline.Window window) {
        State.Builder builderB = state.b();
        Timeline playlistTimeline = list == null ? state.f41058y : new PlaylistTimeline(list);
        if (state.f41037d != 1) {
            if (playlistTimeline.q() || (i3 != -1 && i3 >= playlistTimeline.p())) {
                builderB.k0(4).f0(false);
            } else {
                builderB.k0(2);
            }
        }
        return n1(builderB, state, state.F.get(), playlistTimeline, i3, j3, false, window);
    }

    private static int E1(Timeline timeline, Timeline timeline2, Timeline.Window window) {
        if (timeline.p() != timeline2.p()) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= timeline.p()) {
                return 1;
            }
            Object obj = timeline.n(i3, window).f41135a;
            Object obj2 = timeline2.n(i3, window).f41135a;
            boolean z2 = (obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid);
            if (!obj.equals(obj2) && !z2) {
                return 0;
            }
            i3++;
        }
    }

    public static /* synthetic */ State F0(SimpleBasePlayer simpleBasePlayer, boolean z2, State state, int i3, long j3) {
        if (!z2) {
            return D1(state, null, i3, j3, simpleBasePlayer.f40538a);
        }
        simpleBasePlayer.getClass();
        return state;
    }

    private static boolean J1(State state) {
        return state.f41035b && state.f41037d == 3 && state.f41038e == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(Runnable runnable) {
        if (this.f40985d.g() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f40985d.j(runnable);
        }
    }

    public static /* synthetic */ void L0(SimpleBasePlayer simpleBasePlayer, ListenableFuture listenableFuture) {
        Util.k(simpleBasePlayer.f40988h);
        simpleBasePlayer.f40986f.remove(listenableFuture);
        if (!simpleBasePlayer.f40986f.isEmpty() || simpleBasePlayer.f40989i) {
            return;
        }
        simpleBasePlayer.N1(simpleBasePlayer.C1(), false, false);
    }

    private void L1(final List list, final int i3, final long j3) {
        Assertions.a(i3 == -1 || i3 >= 0);
        final State state = this.f40988h;
        if (M1(20) || (list.size() == 1 && M1(31))) {
            O1(G1(list, i3, j3), new Supplier() { // from class: androidx.media3.common.k0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return SimpleBasePlayer.C0(this.f41377a, list, state, i3, j3);
                }
            });
        }
    }

    private boolean M1(int i3) {
        return !this.f40989i && this.f40988h.f41034a.b(i3);
    }

    private void N1(final State state, boolean z2, boolean z3) {
        State state2 = this.f40988h;
        this.f40988h = state;
        if (state.K || state.f41056w) {
            this.f40988h = state.b().R().h0(false).Q();
        }
        boolean z4 = state2.f41035b != state.f41035b;
        boolean z5 = state2.f41037d != state.f41037d;
        final int iZ1 = z1(state2, state, z2, this.f40538a, this.f40987g);
        boolean zEquals = state2.f41058y.equals(state.f41058y);
        final int iU1 = u1(state2, state, iZ1, z3, this.f40538a);
        if (!zEquals) {
            final int iE1 = E1(state2.f41058y, state.f41058y, this.f40538a);
            this.f40983b.h(0, new ListenerSet.Event() { // from class: androidx.media3.common.l
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    Player.Listener listener = (Player.Listener) obj;
                    listener.j0(state.f41058y, iE1);
                }
            });
        }
        if (iZ1 != -1) {
            final Player.PositionInfo positionInfoA1 = A1(state2, false, this.f40538a, this.f40987g);
            final Player.PositionInfo positionInfoA12 = A1(state, state.K, this.f40538a, this.f40987g);
            this.f40983b.h(11, new ListenerSet.Event() { // from class: androidx.media3.common.n
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.T0(iZ1, positionInfoA1, positionInfoA12, (Player.Listener) obj);
                }
            });
        }
        if (iU1 != -1) {
            final MediaItem mediaItem = state.f41058y.q() ? null : state.f41058y.n(r1(state), this.f40538a).f41137c;
            this.f40983b.h(1, new ListenerSet.Event() { // from class: androidx.media3.common.a0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).Q(mediaItem, iU1);
                }
            });
        }
        if (!Objects.equals(state2.f41039f, state.f41039f)) {
            this.f40983b.h(10, new ListenerSet.Event() { // from class: androidx.media3.common.c0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).q0(state.f41039f);
                }
            });
            if (state.f41039f != null) {
                this.f40983b.h(10, new ListenerSet.Event() { // from class: androidx.media3.common.d0
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).T((PlaybackException) Util.k(state.f41039f));
                    }
                });
            }
        }
        if (!state2.f41047n.equals(state.f41047n)) {
            this.f40983b.h(19, new ListenerSet.Event() { // from class: androidx.media3.common.e0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).O(state.f41047n);
                }
            });
        }
        if (!state2.f41059z.equals(state.f41059z)) {
            this.f40983b.h(2, new ListenerSet.Event() { // from class: androidx.media3.common.f0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).o0(state.f41059z);
                }
            });
        }
        if (!state2.A.equals(state.A)) {
            this.f40983b.h(14, new ListenerSet.Event() { // from class: androidx.media3.common.g0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).M(state.A);
                }
            });
        }
        if (state2.f41042i != state.f41042i) {
            this.f40983b.h(3, new ListenerSet.Event() { // from class: androidx.media3.common.h0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.Q0(state, (Player.Listener) obj);
                }
            });
        }
        if (z4 || z5) {
            this.f40983b.h(-1, new ListenerSet.Event() { // from class: androidx.media3.common.j0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.State state3 = state;
                    ((Player.Listener) obj).l0(state3.f41035b, state3.f41037d);
                }
            });
        }
        if (z5) {
            this.f40983b.h(4, new ListenerSet.Event() { // from class: androidx.media3.common.x
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).G(state.f41037d);
                }
            });
        }
        if (z4 || state2.f41036c != state.f41036c) {
            this.f40983b.h(5, new ListenerSet.Event() { // from class: androidx.media3.common.i0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.State state3 = state;
                    ((Player.Listener) obj).s0(state3.f41035b, state3.f41036c);
                }
            });
        }
        if (state2.f41038e != state.f41038e) {
            this.f40983b.h(6, new ListenerSet.Event() { // from class: androidx.media3.common.p0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).B(state.f41038e);
                }
            });
        }
        if (J1(state2) != J1(state)) {
            this.f40983b.h(7, new ListenerSet.Event() { // from class: androidx.media3.common.q0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).w0(SimpleBasePlayer.J1(state));
                }
            });
        }
        if (!state2.f41046m.equals(state.f41046m)) {
            this.f40983b.h(12, new ListenerSet.Event() { // from class: androidx.media3.common.r0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).j(state.f41046m);
                }
            });
        }
        if (state2.f41040g != state.f41040g) {
            this.f40983b.h(8, new ListenerSet.Event() { // from class: androidx.media3.common.s0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).z(state.f41040g);
                }
            });
        }
        if (state2.f41041h != state.f41041h) {
            this.f40983b.h(9, new ListenerSet.Event() { // from class: androidx.media3.common.t0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).J(state.f41041h);
                }
            });
        }
        if (state2.f41043j != state.f41043j) {
            this.f40983b.h(16, new ListenerSet.Event() { // from class: androidx.media3.common.u0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).L(state.f41043j);
                }
            });
        }
        if (state2.f41044k != state.f41044k) {
            this.f40983b.h(17, new ListenerSet.Event() { // from class: androidx.media3.common.v0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).n0(state.f41044k);
                }
            });
        }
        if (state2.f41045l != state.f41045l) {
            this.f40983b.h(18, new ListenerSet.Event() { // from class: androidx.media3.common.m
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).r0(state.f41045l);
                }
            });
        }
        if (!state2.f41048o.equals(state.f41048o)) {
            this.f40983b.h(20, new ListenerSet.Event() { // from class: androidx.media3.common.o
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).f0(state.f41048o);
                }
            });
        }
        if (!state2.f41050q.equals(state.f41050q)) {
            this.f40983b.h(25, new ListenerSet.Event() { // from class: androidx.media3.common.p
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).b(state.f41050q);
                }
            });
        }
        if (!state2.f41052s.equals(state.f41052s)) {
            this.f40983b.h(29, new ListenerSet.Event() { // from class: androidx.media3.common.q
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).p0(state.f41052s);
                }
            });
        }
        if (!state2.B.equals(state.B)) {
            this.f40983b.h(15, new ListenerSet.Event() { // from class: androidx.media3.common.s
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).m0(state.B);
                }
            });
        }
        if (state.f41056w) {
            this.f40983b.h(26, new t());
        }
        if (!state2.f41055v.equals(state.f41055v)) {
            this.f40983b.h(24, new ListenerSet.Event() { // from class: androidx.media3.common.u
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.State state3 = state;
                    ((Player.Listener) obj).V(state3.f41055v.b(), state3.f41055v.a());
                }
            });
        }
        if (state2.f41049p != state.f41049p) {
            this.f40983b.h(22, new ListenerSet.Event() { // from class: androidx.media3.common.v
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).e0(state.f41049p);
                }
            });
        }
        if (state2.f41053t != state.f41053t || state2.f41054u != state.f41054u) {
            this.f40983b.h(30, new ListenerSet.Event() { // from class: androidx.media3.common.w
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.State state3 = state;
                    ((Player.Listener) obj).K(state3.f41053t, state3.f41054u);
                }
            });
        }
        if (!state2.f41051r.equals(state.f41051r)) {
            this.f40983b.h(27, new ListenerSet.Event() { // from class: androidx.media3.common.y
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    SimpleBasePlayer.Y0(state, (Player.Listener) obj);
                }
            });
        }
        if (!state2.f41057x.equals(state.f41057x) && state.f41057x.f40926b != -9223372036854775807L) {
            this.f40983b.h(28, new ListenerSet.Event() { // from class: androidx.media3.common.z
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).u(state.f41057x);
                }
            });
        }
        if (!state2.f41034a.equals(state.f41034a)) {
            this.f40983b.h(13, new ListenerSet.Event() { // from class: androidx.media3.common.b0
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).W(state.f41034a);
                }
            });
        }
        this.f40983b.f();
    }

    private void O1(ListenableFuture listenableFuture, Supplier supplier) {
        P1(listenableFuture, supplier, false, false);
    }

    private void P1(final ListenableFuture listenableFuture, Supplier supplier, boolean z2, boolean z3) {
        if (listenableFuture.isDone() && this.f40986f.isEmpty()) {
            N1(C1(), z2, z3);
            return;
        }
        this.f40986f.add(listenableFuture);
        N1(y1((State) supplier.get()), z2, z3);
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.common.n0
            @Override // java.lang.Runnable
            public final void run() {
                SimpleBasePlayer.L0(this.f41395a, listenableFuture);
            }
        }, new Executor() { // from class: androidx.media3.common.o0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f41398a.K1(runnable);
            }
        });
    }

    public static /* synthetic */ void Q0(State state, Player.Listener listener) {
        listener.C(state.f41042i);
        listener.b0(state.f41042i);
    }

    private void R1() {
        Q1();
        if (this.f40988h == null) {
            this.f40988h = C1();
        }
    }

    public static /* synthetic */ void T0(int i3, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.a0(i3);
        listener.v0(positionInfo, positionInfo2, i3);
    }

    public static /* synthetic */ void Y0(State state, Player.Listener listener) {
        listener.m(state.f41051r.f41453a);
        listener.t(state.f41051r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static State n1(State.Builder builder, State state, long j3, Timeline timeline, int i3, long j4, boolean z2, Timeline.Window window) {
        long jB;
        int i4 = i3;
        long jB1 = B1(j3, state, window);
        boolean z3 = false;
        if (timeline.q() || (i4 != -1 && i4 < timeline.p())) {
            jB = j4;
        } else {
            jB = -9223372036854775807L;
            i4 = 0;
        }
        if (!timeline.q() && jB == -9223372036854775807L) {
            jB = timeline.n(i4, window).b();
        }
        boolean z4 = state.f41058y.q() || timeline.q();
        boolean z5 = (z4 || state.f41058y.n(r1(state), window).f41135a.equals(timeline.n(i4, window).f41135a)) ? false : true;
        if (timeline.q()) {
            builder.n0(timeline, Tracks.f41239b, null);
        } else if (timeline instanceof PlaylistTimeline) {
            MediaItemData mediaItemData = (MediaItemData) ((PlaylistTimeline) timeline).f41029e.get(i4);
            builder.n0(timeline, mediaItemData.f40993b, mediaItemData.f40995d);
        } else {
            if (!z4 && !z5) {
                z3 = true;
            }
            builder.n0(timeline, z3 ? state.f41059z : Tracks.f41239b, z3 ? state.A : null);
        }
        if (z4 || z5 || jB < jB1) {
            builder.b0(i4).Z(-1, -1).X(jB).W(PositionSupplier.b(jB)).x0(PositionSupplier.f41033a);
        } else if (jB == jB1) {
            builder.b0(i4);
            if (state.D == -1 || !z2) {
                builder.Z(-1, -1).x0(PositionSupplier.b(p1(state, window) - jB1));
            } else {
                builder.x0(PositionSupplier.b(state.I.get() - state.G.get()));
            }
        } else {
            builder.b0(i4).Z(-1, -1).X(jB).W(PositionSupplier.b(Math.max(p1(state, window), jB))).x0(PositionSupplier.b(Math.max(0L, state.J.get() - (jB - jB1))));
        }
        return builder.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static MediaMetadata o1(MediaItem mediaItem, Tracks tracks) {
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        int size = tracks.a().size();
        for (int i3 = 0; i3 < size; i3++) {
            Tracks.Group group = (Tracks.Group) tracks.a().get(i3);
            for (int i4 = 0; i4 < group.f41246a; i4++) {
                if (group.e(i4)) {
                    Format formatA = group.a(i4);
                    if (formatA.f40629l != null) {
                        for (int i5 = 0; i5 < formatA.f40629l.e(); i5++) {
                            formatA.f40629l.d(i5).b(builder);
                        }
                    }
                }
            }
        }
        return builder.L(mediaItem.f40717e).J();
    }

    private static long p1(State state, Timeline.Window window) {
        return B1(state.H.get(), state, window);
    }

    private static long q1(State state, Timeline.Window window) {
        return B1(state.F.get(), state, window);
    }

    private static int r1(State state) {
        int i3 = state.C;
        if (i3 != -1) {
            return i3;
        }
        return 0;
    }

    private static int s1(State state, Timeline.Window window, Timeline.Period period) {
        int iR1 = r1(state);
        return state.f41058y.q() ? iR1 : v1(state.f41058y, iR1, q1(state, window), window, period);
    }

    private static long t1(State state, Object obj, Timeline.Period period, Timeline.Window window) {
        return state.D != -1 ? state.G.get() : q1(state, window) - state.f41058y.h(obj, period).n();
    }

    private static int u1(State state, State state2, int i3, boolean z2, Timeline.Window window) {
        Timeline timeline = state.f41058y;
        Timeline timeline2 = state2.f41058y;
        if (timeline2.q() && timeline.q()) {
            return -1;
        }
        if (timeline2.q() != timeline.q()) {
            return 3;
        }
        Object obj = state.f41058y.n(r1(state), window).f41135a;
        Object obj2 = state2.f41058y.n(r1(state2), window).f41135a;
        if ((obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (!obj.equals(obj2)) {
            if (i3 == 0) {
                return 1;
            }
            return i3 == 1 ? 2 : 3;
        }
        if (i3 != 0 || q1(state, window) <= q1(state2, window)) {
            return (i3 == 1 && z2) ? 2 : -1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int v1(Timeline timeline, int i3, long j3, Timeline.Window window, Timeline.Period period) {
        return timeline.b(timeline.j(window, period, i3, Util.P0(j3)).first);
    }

    private static long w1(State state, Object obj, Timeline.Period period) {
        state.f41058y.h(obj, period);
        int i3 = state.D;
        return Util.t1(i3 == -1 ? period.f41117d : period.b(i3, state.E));
    }

    private static int z1(State state, State state2, boolean z2, Timeline.Window window, Timeline.Period period) {
        if (state2.K) {
            return state2.L;
        }
        if (z2) {
            return 1;
        }
        if (state.f41058y.q()) {
            return -1;
        }
        if (state2.f41058y.q()) {
            return 4;
        }
        Object objM = state.f41058y.m(s1(state, window, period));
        Object objM2 = state2.f41058y.m(s1(state2, window, period));
        if ((objM instanceof PlaceholderUid) && !(objM2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (objM2.equals(objM) && state.D == state2.D && state.E == state2.E) {
            long jT1 = t1(state, objM, period, window);
            if (Math.abs(jT1 - t1(state2, objM2, period, window)) < 1000) {
                return -1;
            }
            long jW1 = w1(state, objM, period);
            return (jW1 == -9223372036854775807L || jT1 < jW1) ? 5 : 0;
        }
        if (state2.f41058y.b(objM) == -1) {
            return 4;
        }
        long jT12 = t1(state, objM, period, window);
        long jW12 = w1(state, objM, period);
        return (jW12 == -9223372036854775807L || jT12 < jW12) ? 3 : 0;
    }

    @Override // androidx.media3.common.Player
    public final int C() {
        R1();
        return this.f40988h.f41038e;
    }

    protected abstract State C1();

    @Override // androidx.media3.common.Player
    public final int D() {
        R1();
        return this.f40988h.f41040g;
    }

    @Override // androidx.media3.common.Player
    public final Timeline E() {
        R1();
        return this.f40988h.f41058y;
    }

    protected ListenableFuture F1(int i3, long j3, int i4) {
        throw new IllegalStateException("Missing implementation to handle one of the COMMAND_SEEK_*");
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters G() {
        R1();
        return this.f40988h.f41047n;
    }

    protected ListenableFuture G1(List list, int i3, long j3) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_MEDIA_ITEM(S)");
    }

    protected ListenableFuture H1(boolean z2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PLAY_PAUSE");
    }

    @Override // androidx.media3.common.Player
    public final int I() {
        R1();
        return this.f40988h.f41053t;
    }

    protected final void I1() {
        R1();
        if (!this.f40986f.isEmpty() || this.f40989i) {
            return;
        }
        N1(C1(), false, false);
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands K() {
        R1();
        return this.f40988h.f41034a;
    }

    @Override // androidx.media3.common.Player
    public final boolean L() {
        R1();
        return this.f40988h.f41035b;
    }

    @Override // androidx.media3.common.Player
    public final long M() {
        R1();
        return this.f40988h.f41045l;
    }

    @Override // androidx.media3.common.Player
    public final int N() {
        R1();
        return s1(this.f40988h, this.f40538a, this.f40987g);
    }

    @Override // androidx.media3.common.Player
    public final VideoSize O() {
        R1();
        return this.f40988h.f41050q;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes Q() {
        R1();
        return this.f40988h.f41048o;
    }

    protected final void Q1() {
        if (Thread.currentThread() != this.f40984c.getThread()) {
            throw new IllegalStateException(Util.J("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\n", Thread.currentThread().getName(), this.f40984c.getThread().getName()));
        }
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo R() {
        R1();
        return this.f40988h.f41052s;
    }

    @Override // androidx.media3.common.Player
    public final int T() {
        R1();
        return this.f40988h.E;
    }

    @Override // androidx.media3.common.Player
    public final void U(List list, int i3, long j3) {
        R1();
        if (i3 == -1) {
            State state = this.f40988h;
            int i4 = state.C;
            long j4 = state.F.get();
            i3 = i4;
            j3 = j4;
        }
        L1(list, i3, j3);
    }

    @Override // androidx.media3.common.Player
    public final long V() {
        R1();
        return this.f40988h.f41044k;
    }

    @Override // androidx.media3.common.Player
    public final long X() {
        R1();
        return q1(this.f40988h, this.f40538a);
    }

    @Override // androidx.media3.common.Player
    public final long Z() {
        R1();
        return f() ? Math.max(this.f40988h.I.get(), this.f40988h.G.get()) : i0();
    }

    @Override // androidx.media3.common.Player
    public final boolean a() {
        R1();
        return this.f40988h.f41042i;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException b() {
        R1();
        return this.f40988h.f41039f;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata c0() {
        R1();
        return this.f40988h.B;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters d() {
        R1();
        return this.f40988h.f41046m;
    }

    @Override // androidx.media3.common.Player
    public final boolean f() {
        R1();
        return this.f40988h.D != -1;
    }

    @Override // androidx.media3.common.Player
    public final int f0() {
        R1();
        return r1(this.f40988h);
    }

    @Override // androidx.media3.common.Player
    public final long g() {
        R1();
        return this.f40988h.J.get();
    }

    @Override // androidx.media3.common.Player
    public final boolean g0() {
        R1();
        return this.f40988h.f41054u;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        R1();
        return f() ? this.f40988h.G.get() : X();
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        R1();
        if (!f()) {
            return q0();
        }
        this.f40988h.f41058y.f(N(), this.f40987g);
        Timeline.Period period = this.f40987g;
        State state = this.f40988h;
        return Util.t1(period.b(state.D, state.E));
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        R1();
        return this.f40988h.f41049p;
    }

    @Override // androidx.media3.common.Player
    public final boolean h0() {
        R1();
        return this.f40988h.f41041h;
    }

    @Override // androidx.media3.common.Player
    public final long i0() {
        R1();
        return Math.max(p1(this.f40988h, this.f40538a), q1(this.f40988h, this.f40538a));
    }

    @Override // androidx.media3.common.Player
    public final void k(List list, boolean z2) {
        R1();
        L1(list, z2 ? -1 : this.f40988h.C, z2 ? -9223372036854775807L : this.f40988h.F.get());
    }

    @Override // androidx.media3.common.Player
    public final Size l() {
        R1();
        return this.f40988h.f41055v;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata m0() {
        R1();
        return this.f40988h.A;
    }

    @Override // androidx.media3.common.Player
    public final void n(final boolean z2) {
        R1();
        final State state = this.f40988h;
        if (M1(1)) {
            O1(H1(z2), new Supplier() { // from class: androidx.media3.common.m0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return state.b().i0(z2, 1).Q();
                }
            });
        }
    }

    @Override // androidx.media3.common.Player
    public final long o0() {
        R1();
        return this.f40988h.f41043j;
    }

    @Override // androidx.media3.common.Player
    public final int p() {
        R1();
        return this.f40988h.f41037d;
    }

    @Override // androidx.media3.common.Player
    public final Tracks s() {
        R1();
        return this.f40988h.f41059z;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup u() {
        R1();
        return this.f40988h.f41051r;
    }

    @Override // androidx.media3.common.BasePlayer
    protected final void w0(final int i3, final long j3, int i4, boolean z2) {
        R1();
        Assertions.a(i3 == -1 || i3 >= 0);
        final State state = this.f40988h;
        if (M1(i4)) {
            final boolean z3 = i3 == -1 || f() || (!state.f41058y.q() && i3 >= state.f41058y.p());
            P1(F1(i3, j3, i4), new Supplier() { // from class: androidx.media3.common.l0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return SimpleBasePlayer.F0(this.f41384a, z3, state, i3, j3);
                }
            }, !z3, z2);
        }
    }

    @Override // androidx.media3.common.Player
    public final int x() {
        R1();
        return this.f40988h.D;
    }

    protected MediaItemData x1(MediaItem mediaItem) {
        return new MediaItemData.Builder(new PlaceholderUid()).t(mediaItem).r(true).s(true).q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PositionSupplier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PositionSupplier f41033a = b(0);

        static PositionSupplier b(final long j3) {
            return new PositionSupplier() { // from class: androidx.media3.common.x0
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return SimpleBasePlayer.PositionSupplier.a(j3);
                }
            };
        }

        static PositionSupplier c(final long j3, final float f3) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            return new PositionSupplier() { // from class: androidx.media3.common.w0
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return SimpleBasePlayer.PositionSupplier.d(j3, jElapsedRealtime, f3);
                }
            };
        }

        static /* synthetic */ long d(long j3, long j4, float f3) {
            return j3 + ((long) ((SystemClock.elapsedRealtime() - j4) * f3));
        }

        long get();

        static /* synthetic */ long a(long j3) {
            return j3;
        }
    }

    protected State y1(State state) {
        return state;
    }
}
