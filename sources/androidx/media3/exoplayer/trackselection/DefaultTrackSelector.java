package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.accessibility.CaptioningManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.audio.g0;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultTrackSelector extends MappingTrackSelector implements RendererCapabilities.Listener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Ordering f45349j = Ordering.b(new Comparator() { // from class: androidx.media3.exoplayer.trackselection.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return DefaultTrackSelector.u((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f45350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f45351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ExoTrackSelection.Factory f45352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Parameters f45353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SpatializerWrapperV32 f45354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AudioAttributes f45355i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f45356f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f45357g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f45358h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Parameters f45359i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f45360j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f45361k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f45362l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f45363m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final boolean f45364n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final boolean f45365o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f45366p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final int f45367q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f45368r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f45369s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final int f45370t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final int f45371u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f45372v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final boolean f45373w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final boolean f45374x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final boolean f45375y;

        /* JADX WARN: Multi-variable type inference failed */
        public AudioTrackInfo(int i3, TrackGroup trackGroup, int i4, Parameters parameters, int i5, boolean z2, Predicate predicate, int i6) {
            int i7;
            int iG;
            int iG2;
            super(i3, trackGroup, i4);
            this.f45359i = parameters;
            int i8 = parameters.f45390y0 ? 24 : 16;
            this.f45364n = parameters.f45386u0 && (i6 & i8) != 0;
            this.f45358h = DefaultTrackSelector.T(this.f45416d.f40621d);
            this.f45360j = RendererCapabilities.n(i5, false);
            int i9 = 0;
            while (true) {
                int size = parameters.f41192p.size();
                i7 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i9 >= size) {
                    iG = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    iG = DefaultTrackSelector.G(this.f45416d, (String) parameters.f41192p.get(i9), false);
                    if (iG > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.f45362l = i9;
            this.f45361k = iG;
            this.f45363m = DefaultTrackSelector.K(this.f45416d.f40623f, parameters.f41193q);
            Format format = this.f45416d;
            int i10 = format.f40623f;
            this.f45365o = i10 == 0 || (i10 & 1) != 0;
            this.f45368r = (format.f40622e & 1) != 0;
            this.f45375y = DefaultTrackSelector.O(format);
            Format format2 = this.f45416d;
            int i11 = format2.E;
            this.f45369s = i11;
            this.f45370t = format2.F;
            int i12 = format2.f40627j;
            this.f45371u = i12;
            this.f45357g = (i12 == -1 || i12 <= parameters.f41195s) && (i11 == -1 || i11 <= parameters.f41194r) && predicate.apply(format2);
            String[] strArrO0 = Util.o0();
            int i13 = 0;
            while (true) {
                if (i13 >= strArrO0.length) {
                    iG2 = 0;
                    i13 = Integer.MAX_VALUE;
                    break;
                } else {
                    iG2 = DefaultTrackSelector.G(this.f45416d, strArrO0[i13], false);
                    if (iG2 > 0) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            this.f45366p = i13;
            this.f45367q = iG2;
            int i14 = 0;
            while (true) {
                if (i14 < parameters.f41196t.size()) {
                    String str = this.f45416d.f40632o;
                    if (str != null && str.equals(parameters.f41196t.get(i14))) {
                        i7 = i14;
                        break;
                    }
                    i14++;
                } else {
                    break;
                }
            }
            this.f45372v = i7;
            this.f45373w = RendererCapabilities.l(i5) == 128;
            this.f45374x = RendererCapabilities.G(i5) == 64;
            this.f45356f = f(i5, z2, i8);
        }

        public static int c(List list, List list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }

        public static ImmutableList e(int i3, TrackGroup trackGroup, Parameters parameters, int[] iArr, boolean z2, Predicate predicate, int i4) {
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i5 = 0; i5 < trackGroup.f41153a; i5++) {
                builderO.a(new AudioTrackInfo(i3, trackGroup, i5, parameters, iArr[i5], z2, predicate, i4));
            }
            return builderO.m();
        }

        private int f(int i3, boolean z2, int i4) {
            if (!RendererCapabilities.n(i3, this.f45359i.A0)) {
                return 0;
            }
            if (!this.f45357g && !this.f45359i.f45385t0) {
                return 0;
            }
            Parameters parameters = this.f45359i;
            if (parameters.f41197u.f41207a == 2 && !DefaultTrackSelector.U(parameters, i3, this.f45416d)) {
                return 0;
            }
            if (!RendererCapabilities.n(i3, false) || !this.f45357g || this.f45416d.f40627j == -1) {
                return 1;
            }
            Parameters parameters2 = this.f45359i;
            if (parameters2.C || parameters2.B) {
                return 1;
            }
            return ((!parameters2.C0 && z2) || parameters2.f41197u.f41207a == 2 || (i3 & i4) == 0) ? 1 : 2;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.f45356f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering orderingK = (this.f45357g && this.f45360j) ? DefaultTrackSelector.f45349j : DefaultTrackSelector.f45349j.k();
            ComparisonChain comparisonChainG = ComparisonChain.k().h(this.f45360j, audioTrackInfo.f45360j).g(Integer.valueOf(this.f45362l), Integer.valueOf(audioTrackInfo.f45362l), Ordering.f().k()).d(this.f45361k, audioTrackInfo.f45361k).d(this.f45363m, audioTrackInfo.f45363m).h(this.f45368r, audioTrackInfo.f45368r).h(this.f45365o, audioTrackInfo.f45365o).g(Integer.valueOf(this.f45366p), Integer.valueOf(audioTrackInfo.f45366p), Ordering.f().k()).d(this.f45367q, audioTrackInfo.f45367q).h(this.f45357g, audioTrackInfo.f45357g).g(Integer.valueOf(this.f45372v), Integer.valueOf(audioTrackInfo.f45372v), Ordering.f().k());
            if (this.f45359i.B) {
                comparisonChainG = comparisonChainG.g(Integer.valueOf(this.f45371u), Integer.valueOf(audioTrackInfo.f45371u), DefaultTrackSelector.f45349j.k());
            }
            ComparisonChain comparisonChainG2 = comparisonChainG.h(this.f45373w, audioTrackInfo.f45373w).h(this.f45374x, audioTrackInfo.f45374x).h(this.f45375y, audioTrackInfo.f45375y).g(Integer.valueOf(this.f45369s), Integer.valueOf(audioTrackInfo.f45369s), orderingK).g(Integer.valueOf(this.f45370t), Integer.valueOf(audioTrackInfo.f45370t), orderingK);
            if (Objects.equals(this.f45358h, audioTrackInfo.f45358h)) {
                comparisonChainG2 = comparisonChainG2.g(Integer.valueOf(this.f45371u), Integer.valueOf(audioTrackInfo.f45371u), orderingK);
            }
            return comparisonChainG2.j();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(AudioTrackInfo audioTrackInfo) {
            int i3;
            String str;
            int i4;
            if (!this.f45359i.f45388w0 && ((i4 = this.f45416d.E) == -1 || i4 != audioTrackInfo.f45416d.E)) {
                return false;
            }
            if (!this.f45364n && ((str = this.f45416d.f40632o) == null || !TextUtils.equals(str, audioTrackInfo.f45416d.f40632o))) {
                return false;
            }
            Parameters parameters = this.f45359i;
            if (!parameters.f45387v0 && ((i3 = this.f45416d.F) == -1 || i3 != audioTrackInfo.f45416d.F)) {
                return false;
            }
            if (parameters.f45389x0) {
                return true;
            }
            return this.f45373w == audioTrackInfo.f45373w && this.f45374x == audioTrackInfo.f45374x;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImageTrackInfo extends TrackInfo<ImageTrackInfo> implements Comparable<ImageTrackInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f45376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f45377g;

        public ImageTrackInfo(int i3, TrackGroup trackGroup, int i4, Parameters parameters, int i5) {
            super(i3, trackGroup, i4);
            this.f45376f = RendererCapabilities.n(i5, parameters.A0) ? 1 : 0;
            this.f45377g = this.f45416d.e();
        }

        public static int c(List list, List list2) {
            return ((ImageTrackInfo) list.get(0)).compareTo((ImageTrackInfo) list2.get(0));
        }

        public static ImmutableList e(int i3, TrackGroup trackGroup, Parameters parameters, int[] iArr) {
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i4 = 0; i4 < trackGroup.f41153a; i4++) {
                builderO.a(new ImageTrackInfo(i3, trackGroup, i4, parameters, iArr[i4]));
            }
            return builderO.m();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.f45376f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(ImageTrackInfo imageTrackInfo) {
            return Integer.compare(this.f45377g, imageTrackInfo.f45377g);
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(ImageTrackInfo imageTrackInfo) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OtherTrackScore implements Comparable<OtherTrackScore> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f45378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f45379b;

        public OtherTrackScore(Format format, int i3) {
            this.f45378a = (format.f40622e & 1) != 0;
            this.f45379b = RendererCapabilities.n(i3, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.k().h(this.f45379b, otherTrackScore.f45379b).h(this.f45378a, otherTrackScore.f45378a).j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Parameters extends TrackSelectionParameters {
        public static final Parameters G0;
        public static final Parameters H0;
        private static final String I0;
        private static final String J0;
        private static final String K0;
        private static final String L0;
        private static final String M0;
        private static final String N0;
        private static final String O0;
        private static final String P0;
        private static final String Q0;
        private static final String R0;
        private static final String S0;
        private static final String T0;
        private static final String U0;
        private static final String V0;
        private static final String W0;
        private static final String X0;
        private static final String Y0;
        private static final String Z0;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        private static final String f45380a1;
        public final boolean A0;
        public final boolean B0;
        public final boolean C0;
        public final boolean D0;
        private final SparseArray E0;
        private final SparseBooleanArray F0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public final boolean f45381p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public final boolean f45382q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public final boolean f45383r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public final boolean f45384s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public final boolean f45385t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public final boolean f45386u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public final boolean f45387v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public final boolean f45388w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public final boolean f45389x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public final boolean f45390y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final boolean f45391z0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends TrackSelectionParameters.Builder {
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private boolean N;
            private boolean O;
            private boolean P;
            private boolean Q;
            private boolean R;
            private boolean S;
            private boolean T;
            private final SparseArray U;
            private final SparseBooleanArray V;

            private static SparseArray b0(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    sparseArray2.put(sparseArray.keyAt(i3), new HashMap((Map) sparseArray.valueAt(i3)));
                }
                return sparseArray2;
            }

            private void c0() {
                this.F = true;
                this.G = false;
                this.H = true;
                this.I = false;
                this.J = true;
                this.K = false;
                this.L = false;
                this.M = false;
                this.N = false;
                this.O = true;
                this.P = true;
                this.Q = true;
                this.R = false;
                this.S = true;
                this.T = false;
            }

            @Override // androidx.media3.common.TrackSelectionParameters.Builder
            /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
            public Parameters F() {
                return new Parameters(this);
            }

            protected Builder d0(TrackSelectionParameters trackSelectionParameters) {
                super.H(trackSelectionParameters);
                return this;
            }

            public Builder e0(boolean z2) {
                this.P = z2;
                return this;
            }

            public Builder f0(boolean z2) {
                super.I(z2);
                return this;
            }

            public Builder() {
                this.U = new SparseArray();
                this.V = new SparseBooleanArray();
                c0();
            }

            public Builder(Context context) {
                this();
            }

            private Builder(Parameters parameters) {
                super(parameters);
                this.F = parameters.f45381p0;
                this.G = parameters.f45382q0;
                this.H = parameters.f45383r0;
                this.I = parameters.f45384s0;
                this.J = parameters.f45385t0;
                this.K = parameters.f45386u0;
                this.L = parameters.f45387v0;
                this.M = parameters.f45388w0;
                this.N = parameters.f45389x0;
                this.O = parameters.f45390y0;
                this.P = parameters.f45391z0;
                this.Q = parameters.A0;
                this.R = parameters.B0;
                this.S = parameters.C0;
                this.T = parameters.D0;
                this.U = b0(parameters.E0);
                this.V = parameters.F0.clone();
            }
        }

        static {
            Parameters parametersF = new Builder().F();
            G0 = parametersF;
            H0 = parametersF;
            I0 = Util.y0(1000);
            J0 = Util.y0(AdError.NO_FILL_ERROR_CODE);
            K0 = Util.y0(1002);
            L0 = Util.y0(1003);
            M0 = Util.y0(1004);
            N0 = Util.y0(1005);
            O0 = Util.y0(CloseCodes.CLOSED_ABNORMALLY);
            P0 = Util.y0(1007);
            Q0 = Util.y0(1008);
            R0 = Util.y0(1009);
            S0 = Util.y0(1010);
            T0 = Util.y0(CloseCodes.UNEXPECTED_CONDITION);
            U0 = Util.y0(1012);
            V0 = Util.y0(1013);
            W0 = Util.y0(1014);
            X0 = Util.y0(1015);
            Y0 = Util.y0(1016);
            Z0 = Util.y0(1017);
            f45380a1 = Util.y0(1018);
        }

        private static boolean c(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i3)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean d(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                if (iIndexOfKey < 0 || !e((Map) sparseArray.valueAt(i3), (Map) sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean e(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                if (!map2.containsKey(trackGroupArray) || !Objects.equals(entry.getValue(), map2.get(trackGroupArray))) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Parameters.class == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (super.equals(parameters) && this.f45381p0 == parameters.f45381p0 && this.f45382q0 == parameters.f45382q0 && this.f45383r0 == parameters.f45383r0 && this.f45384s0 == parameters.f45384s0 && this.f45385t0 == parameters.f45385t0 && this.f45386u0 == parameters.f45386u0 && this.f45387v0 == parameters.f45387v0 && this.f45388w0 == parameters.f45388w0 && this.f45389x0 == parameters.f45389x0 && this.f45390y0 == parameters.f45390y0 && this.f45391z0 == parameters.f45391z0 && this.A0 == parameters.A0 && this.B0 == parameters.B0 && this.C0 == parameters.C0 && this.D0 == parameters.D0 && c(this.F0, parameters.F0) && d(this.E0, parameters.E0)) {
                    return true;
                }
            }
            return false;
        }

        public Builder f() {
            return new Builder();
        }

        public boolean g(int i3) {
            return this.F0.get(i3);
        }

        public SelectionOverride h(int i3, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.E0.get(i3);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Override // androidx.media3.common.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f45381p0 ? 1 : 0)) * 31) + (this.f45382q0 ? 1 : 0)) * 31) + (this.f45383r0 ? 1 : 0)) * 31) + (this.f45384s0 ? 1 : 0)) * 31) + (this.f45385t0 ? 1 : 0)) * 31) + (this.f45386u0 ? 1 : 0)) * 31) + (this.f45387v0 ? 1 : 0)) * 31) + (this.f45388w0 ? 1 : 0)) * 31) + (this.f45389x0 ? 1 : 0)) * 31) + (this.f45390y0 ? 1 : 0)) * 31) + (this.f45391z0 ? 1 : 0)) * 31) + (this.A0 ? 1 : 0)) * 31) + (this.B0 ? 1 : 0)) * 31) + (this.C0 ? 1 : 0)) * 31) + (this.D0 ? 1 : 0);
        }

        public boolean i(int i3, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.E0.get(i3);
            return map != null && map.containsKey(trackGroupArray);
        }

        private Parameters(Builder builder) {
            super(builder);
            this.f45381p0 = builder.F;
            this.f45382q0 = builder.G;
            this.f45383r0 = builder.H;
            this.f45384s0 = builder.I;
            this.f45385t0 = builder.J;
            this.f45386u0 = builder.K;
            this.f45387v0 = builder.L;
            this.f45388w0 = builder.M;
            this.f45389x0 = builder.N;
            this.f45390y0 = builder.O;
            this.f45391z0 = builder.P;
            this.A0 = builder.Q;
            this.B0 = builder.R;
            this.C0 = builder.S;
            this.D0 = builder.T;
            this.E0 = builder.U;
            this.F0 = builder.V;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private final Parameters.Builder F;

        @Override // androidx.media3.common.TrackSelectionParameters.Builder
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public Parameters F() {
            return this.F.F();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SelectionOverride {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f45392d = Util.y0(0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f45393e = Util.y0(1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f45394f = Util.y0(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f45396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f45397c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SelectionOverride.class == obj.getClass()) {
                SelectionOverride selectionOverride = (SelectionOverride) obj;
                if (this.f45395a == selectionOverride.f45395a && Arrays.equals(this.f45396b, selectionOverride.f45396b) && this.f45397c == selectionOverride.f45397c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f45395a * 31) + Arrays.hashCode(this.f45396b)) * 31) + this.f45397c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SpatializerWrapperV32 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Spatializer f45398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f45399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f45400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Spatializer$OnSpatializerStateChangedListener f45401d;

        public SpatializerWrapperV32(Context context, final DefaultTrackSelector defaultTrackSelector) {
            AudioManager audioManagerC = context == null ? null : AudioManagerCompat.c(context);
            if (audioManagerC == null || Util.H0((Context) Assertions.e(context))) {
                this.f45398a = null;
                this.f45399b = false;
                this.f45400c = null;
                this.f45401d = null;
                return;
            }
            Spatializer spatializer = audioManagerC.getSpatializer();
            this.f45398a = spatializer;
            this.f45399b = spatializer.getImmersiveAudioLevel() != 0;
            Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener = new Spatializer$OnSpatializerStateChangedListener() { // from class: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.SpatializerWrapperV32.1
                public void onSpatializerAvailableChanged(Spatializer spatializer2, boolean z2) {
                    defaultTrackSelector.R();
                }

                public void onSpatializerEnabledChanged(Spatializer spatializer2, boolean z2) {
                    defaultTrackSelector.R();
                }
            };
            this.f45401d = spatializer$OnSpatializerStateChangedListener;
            Handler handler = new Handler((Looper) Assertions.i(Looper.myLooper()));
            this.f45400c = handler;
            Objects.requireNonNull(handler);
            spatializer.addOnSpatializerStateChangedListener(new g0(handler), spatializer$OnSpatializerStateChangedListener);
        }

        public boolean a(AudioAttributes audioAttributes, Format format) {
            int i3;
            if (Objects.equals(format.f40632o, "audio/eac3-joc")) {
                i3 = format.E;
                if (i3 == 16) {
                    i3 = 12;
                }
            } else if (Objects.equals(format.f40632o, "audio/iamf")) {
                i3 = format.E;
                if (i3 == -1) {
                    i3 = 6;
                }
            } else if (Objects.equals(format.f40632o, "audio/ac4")) {
                i3 = format.E;
                if (i3 == 18 || i3 == 21) {
                    i3 = 24;
                }
            } else {
                i3 = format.E;
            }
            int iP = Util.P(i3);
            if (iP == 0) {
                return false;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iP);
            int i4 = format.F;
            if (i4 != -1) {
                channelMask.setSampleRate(i4);
            }
            return p.a(Assertions.e(this.f45398a)).canBeSpatialized(audioAttributes.a().f40530a, channelMask.build());
        }

        public boolean b() {
            return p.a(Assertions.e(this.f45398a)).isAvailable();
        }

        public boolean c() {
            return p.a(Assertions.e(this.f45398a)).isEnabled();
        }

        public boolean d() {
            return this.f45399b;
        }

        public void e() {
            Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
            Spatializer spatializer = this.f45398a;
            if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.f45401d) == null || this.f45400c == null) {
                return;
            }
            spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
            this.f45400c.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f45404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f45405g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f45406h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f45407i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f45408j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f45409k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f45410l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f45411m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final boolean f45412n;

        /* JADX WARN: Multi-variable type inference failed */
        public TextTrackInfo(int i3, TrackGroup trackGroup, int i4, Parameters parameters, int i5, String str, String str2) {
            int iG;
            super(i3, trackGroup, i4);
            int i6 = 0;
            this.f45405g = RendererCapabilities.n(i5, false);
            int i7 = this.f45416d.f40622e & (~parameters.f41201y);
            this.f45406h = (i7 & 1) != 0;
            this.f45407i = (i7 & 2) != 0;
            ImmutableList immutableListZ = str2 != null ? ImmutableList.z(str2) : parameters.f41198v.isEmpty() ? ImmutableList.z("") : parameters.f41198v;
            int i8 = 0;
            while (true) {
                if (i8 >= immutableListZ.size()) {
                    i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iG = 0;
                    break;
                } else {
                    iG = DefaultTrackSelector.G(this.f45416d, (String) immutableListZ.get(i8), parameters.f41202z);
                    if (iG > 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            this.f45408j = i8;
            this.f45409k = iG;
            int iK = DefaultTrackSelector.K(this.f45416d.f40623f, str2 != null ? 1088 : parameters.f41199w);
            this.f45410l = iK;
            this.f45412n = (1088 & this.f45416d.f40623f) != 0;
            int iG2 = DefaultTrackSelector.G(this.f45416d, str, DefaultTrackSelector.T(str) == null);
            this.f45411m = iG2;
            boolean z2 = iG > 0 || (parameters.f41198v.isEmpty() && iK > 0) || this.f45406h || (this.f45407i && iG2 > 0);
            if (RendererCapabilities.n(i5, parameters.A0) && z2) {
                i6 = 1;
            }
            this.f45404f = i6;
        }

        public static int c(List list, List list2) {
            return ((TextTrackInfo) list.get(0)).compareTo((TextTrackInfo) list2.get(0));
        }

        public static ImmutableList e(int i3, TrackGroup trackGroup, Parameters parameters, int[] iArr, String str, String str2) {
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i4 = 0; i4 < trackGroup.f41153a; i4++) {
                builderO.a(new TextTrackInfo(i3, trackGroup, i4, parameters, iArr[i4], str, str2));
            }
            return builderO.m();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.f45404f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain comparisonChainD = ComparisonChain.k().h(this.f45405g, textTrackInfo.f45405g).g(Integer.valueOf(this.f45408j), Integer.valueOf(textTrackInfo.f45408j), Ordering.f().k()).d(this.f45409k, textTrackInfo.f45409k).d(this.f45410l, textTrackInfo.f45410l).h(this.f45406h, textTrackInfo.f45406h).g(Boolean.valueOf(this.f45407i), Boolean.valueOf(textTrackInfo.f45407i), this.f45409k == 0 ? Ordering.f() : Ordering.f().k()).d(this.f45411m, textTrackInfo.f45411m);
            if (this.f45410l == 0) {
                comparisonChainD = comparisonChainD.i(this.f45412n, textTrackInfo.f45412n);
            }
            return comparisonChainD.j();
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean b(TextTrackInfo textTrackInfo) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class TrackInfo<T extends TrackInfo<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackGroup f45414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f45415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Format f45416d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Factory<T extends TrackInfo<T>> {
            List a(int i3, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i3, TrackGroup trackGroup, int i4) {
            this.f45413a = i3;
            this.f45414b = trackGroup;
            this.f45415c = i4;
            this.f45416d = trackGroup.a(i4);
        }

        public abstract int a();

        public abstract boolean b(TrackInfo trackInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f45417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Parameters f45418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f45419h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f45420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f45421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f45422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f45423l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f45424m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f45425n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f45426o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f45427p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final boolean f45428q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final int f45429r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final boolean f45430s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final int f45431t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f45432u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final boolean f45433v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final int f45434w;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public VideoTrackInfo(int r5, androidx.media3.common.TrackGroup r6, int r7, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters r8, int r9, java.lang.String r10, int r11, boolean r12) {
            /*
                Method dump skipped, instruction units count: 317
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, androidx.media3.common.TrackGroup, int, androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters, int, java.lang.String, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int e(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain comparisonChainH = ComparisonChain.k().h(videoTrackInfo.f45420i, videoTrackInfo2.f45420i).g(Integer.valueOf(videoTrackInfo.f45425n), Integer.valueOf(videoTrackInfo2.f45425n), Ordering.f().k()).d(videoTrackInfo.f45426o, videoTrackInfo2.f45426o).d(videoTrackInfo.f45427p, videoTrackInfo2.f45427p).h(videoTrackInfo.f45428q, videoTrackInfo2.f45428q).d(videoTrackInfo.f45429r, videoTrackInfo2.f45429r).h(videoTrackInfo.f45421j, videoTrackInfo2.f45421j).h(videoTrackInfo.f45417f, videoTrackInfo2.f45417f).h(videoTrackInfo.f45419h, videoTrackInfo2.f45419h).g(Integer.valueOf(videoTrackInfo.f45424m), Integer.valueOf(videoTrackInfo2.f45424m), Ordering.f().k()).h(videoTrackInfo.f45432u, videoTrackInfo2.f45432u).h(videoTrackInfo.f45433v, videoTrackInfo2.f45433v);
            if (videoTrackInfo.f45432u && videoTrackInfo.f45433v) {
                comparisonChainH = comparisonChainH.d(videoTrackInfo.f45434w, videoTrackInfo2.f45434w);
            }
            return comparisonChainH.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering orderingK = (videoTrackInfo.f45417f && videoTrackInfo.f45420i) ? DefaultTrackSelector.f45349j : DefaultTrackSelector.f45349j.k();
            ComparisonChain comparisonChainK = ComparisonChain.k();
            if (videoTrackInfo.f45418g.B) {
                comparisonChainK = comparisonChainK.g(Integer.valueOf(videoTrackInfo.f45422k), Integer.valueOf(videoTrackInfo2.f45422k), DefaultTrackSelector.f45349j.k());
            }
            return comparisonChainK.g(Integer.valueOf(videoTrackInfo.f45423l), Integer.valueOf(videoTrackInfo2.f45423l), orderingK).g(Integer.valueOf(videoTrackInfo.f45422k), Integer.valueOf(videoTrackInfo2.f45422k), orderingK).j();
        }

        public static int g(List list, List list2) {
            return ComparisonChain.k().g((VideoTrackInfo) Collections.max(list, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.e((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }), (VideoTrackInfo) Collections.max(list2, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.e((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }), new Comparator() { // from class: androidx.media3.exoplayer.trackselection.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.e((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }).d(list.size(), list2.size()).g((VideoTrackInfo) Collections.max(list, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.u
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.f((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }), (VideoTrackInfo) Collections.max(list2, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.u
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.f((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }), new Comparator() { // from class: androidx.media3.exoplayer.trackselection.u
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DefaultTrackSelector.VideoTrackInfo.f((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
                }
            }).j();
        }

        public static ImmutableList h(int i3, TrackGroup trackGroup, Parameters parameters, int[] iArr, String str, int i4, Point point) {
            int iH = DefaultTrackSelector.H(trackGroup, point != null ? point.x : parameters.f41185i, point != null ? point.y : parameters.f41186j, parameters.f41188l);
            ImmutableList.Builder builderO = ImmutableList.o();
            for (int i5 = 0; i5 < trackGroup.f41153a; i5++) {
                int iE = trackGroup.a(i5).e();
                builderO.a(new VideoTrackInfo(i3, trackGroup, i5, parameters, iArr[i5], str, i4, iH == Integer.MAX_VALUE || (iE != -1 && iE <= iH)));
            }
            return builderO.m();
        }

        private int i(int i3, int i4) {
            if ((this.f45416d.f40623f & 16384) != 0 || !RendererCapabilities.n(i3, this.f45418g.A0)) {
                return 0;
            }
            if (!this.f45417f && !this.f45418g.f45381p0) {
                return 0;
            }
            if (!RendererCapabilities.n(i3, false) || !this.f45419h || !this.f45417f || this.f45416d.f40627j == -1) {
                return 1;
            }
            Parameters parameters = this.f45418g;
            return (parameters.C || parameters.B || (i3 & i4) == 0) ? 1 : 2;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        public int a() {
            return this.f45431t;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean b(VideoTrackInfo videoTrackInfo) {
            if (!this.f45430s && !Objects.equals(this.f45416d.f40632o, videoTrackInfo.f45416d.f40632o)) {
                return false;
            }
            if (this.f45418g.f45384s0) {
                return true;
            }
            return this.f45432u == videoTrackInfo.f45432u && this.f45433v == videoTrackInfo.f45433v;
        }
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    private static void D(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        int iD = mappedTrackInfo.d();
        for (int i3 = 0; i3 < iD; i3++) {
            TrackGroupArray trackGroupArrayF = mappedTrackInfo.f(i3);
            if (parameters.i(i3, trackGroupArrayF)) {
                SelectionOverride selectionOverrideH = parameters.h(i3, trackGroupArrayF);
                definitionArr[i3] = (selectionOverrideH == null || selectionOverrideH.f45396b.length == 0) ? null : new ExoTrackSelection.Definition(trackGroupArrayF.b(selectionOverrideH.f45395a), selectionOverrideH.f45396b, selectionOverrideH.f45397c);
            }
        }
    }

    private static void E(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        int iD = mappedTrackInfo.d();
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < iD; i3++) {
            F(mappedTrackInfo.f(i3), trackSelectionParameters, map);
        }
        F(mappedTrackInfo.h(), trackSelectionParameters, map);
        for (int i4 = 0; i4 < iD; i4++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) map.get(Integer.valueOf(mappedTrackInfo.e(i4)));
            if (trackSelectionOverride != null) {
                definitionArr[i4] = (trackSelectionOverride.f41161b.isEmpty() || mappedTrackInfo.f(i4).d(trackSelectionOverride.f41160a) == -1) ? null : new ExoTrackSelection.Definition(trackSelectionOverride.f41160a, Ints.n(trackSelectionOverride.f41161b));
            }
        }
    }

    private static void F(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i3 = 0; i3 < trackGroupArray.f44987a; i3++) {
            TrackSelectionOverride trackSelectionOverride2 = (TrackSelectionOverride) trackSelectionParameters.D.get(trackGroupArray.b(i3));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = (TrackSelectionOverride) map.get(Integer.valueOf(trackSelectionOverride2.a()))) == null || (trackSelectionOverride.f41161b.isEmpty() && !trackSelectionOverride2.f41161b.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.a()), trackSelectionOverride2);
            }
        }
    }

    protected static int G(Format format, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f40621d)) {
            return 4;
        }
        String strT = T(str);
        String strT2 = T(format.f40621d);
        if (strT2 == null || strT == null) {
            return (z2 && strT2 == null) ? 1 : 0;
        }
        if (strT2.startsWith(strT) || strT.startsWith(strT2)) {
            return 3;
        }
        return Util.i1(strT2, "-")[0].equals(Util.i1(strT, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(TrackGroup trackGroup, int i3, int i4, boolean z2) {
        int i5;
        int i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 != Integer.MAX_VALUE && i4 != Integer.MAX_VALUE) {
            for (int i7 = 0; i7 < trackGroup.f41153a; i7++) {
                Format formatA = trackGroup.a(i7);
                int i8 = formatA.f40639v;
                if (i8 > 0 && (i5 = formatA.f40640w) > 0) {
                    Point pointD = TrackSelectionUtil.d(z2, i3, i4, i8, i5);
                    int i9 = formatA.f40639v;
                    int i10 = formatA.f40640w;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (pointD.x * 0.98f)) && i10 >= ((int) (pointD.y * 0.98f)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
        }
        return i6;
    }

    private static String J(Context context) {
        CaptioningManager captioningManager;
        Locale locale;
        if (context == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            return null;
        }
        return Util.d0(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int K(int i3, int i4) {
        return (i3 == 0 || i3 != i4) ? Integer.bitCount(i3 & i4) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int L(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(Format format, Parameters parameters) {
        int i3;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        if (!parameters.f45391z0 || (i3 = format.E) == -1 || i3 <= 2) {
            return true;
        }
        if (!N(format) || (Util.f41609a >= 32 && (spatializerWrapperV322 = this.f45354h) != null && spatializerWrapperV322.d())) {
            return Util.f41609a >= 32 && (spatializerWrapperV32 = this.f45354h) != null && spatializerWrapperV32.d() && this.f45354h.b() && this.f45354h.c() && this.f45354h.a(this.f45355i, format);
        }
        return true;
    }

    private static boolean N(Format format) {
        String str = format.f40632o;
        if (str == null) {
            return false;
        }
        str.getClass();
        switch (str) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(Format format) {
        String str = format.f40632o;
        if (str == null) {
            return false;
        }
        str.getClass();
        switch (str) {
        }
        return false;
    }

    private static void P(Parameters parameters, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i3 = -1;
        boolean z2 = false;
        int i4 = 0;
        for (int i5 = 0; i5 < mappedTrackInfo.d(); i5++) {
            int iE = mappedTrackInfo.e(i5);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i5];
            if (iE != 1 && exoTrackSelection != null) {
                return;
            }
            if (iE == 1 && exoTrackSelection != null && exoTrackSelection.length() == 1) {
                if (U(parameters, iArr[i5][mappedTrackInfo.f(i5).d(exoTrackSelection.h())][exoTrackSelection.d(0)], exoTrackSelection.l())) {
                    i4++;
                    i3 = i5;
                }
            }
        }
        if (i4 == 1) {
            int i6 = parameters.f41197u.f41208b ? 1 : 2;
            RendererConfiguration rendererConfiguration = rendererConfigurationArr[i3];
            if (rendererConfiguration != null && rendererConfiguration.f43289b) {
                z2 = true;
            }
            rendererConfigurationArr[i3] = new RendererConfiguration(i6, z2);
        }
    }

    private static void Q(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z2;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < mappedTrackInfo.d(); i5++) {
            int iE = mappedTrackInfo.e(i5);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i5];
            if ((iE == 1 || iE == 2) && exoTrackSelection != null && V(iArr[i5], mappedTrackInfo.f(i5), exoTrackSelection)) {
                if (iE == 1) {
                    if (i4 != -1) {
                        z2 = false;
                        break;
                    }
                    i4 = i5;
                } else {
                    if (i3 != -1) {
                        z2 = false;
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        z2 = true;
        if (z2 && ((i4 == -1 || i3 == -1) ? false : true)) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(0, true);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        boolean z2;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f45350d) {
            try {
                z2 = this.f45353g.f45391z0 && Util.f41609a >= 32 && (spatializerWrapperV32 = this.f45354h) != null && spatializerWrapperV32.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            f();
        }
    }

    private void S(Renderer renderer) {
        boolean z2;
        synchronized (this.f45350d) {
            z2 = this.f45353g.D0;
        }
        if (z2) {
            g(renderer);
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean U(Parameters parameters, int i3, Format format) {
        if (RendererCapabilities.z(i3) == 0) {
            return false;
        }
        if (parameters.f41197u.f41209c && (RendererCapabilities.z(i3) & 2048) == 0) {
            return false;
        }
        if (parameters.f41197u.f41208b) {
            boolean z2 = (format.H == 0 && format.I == 0) ? false : true;
            boolean z3 = (RendererCapabilities.z(i3) & 1024) != 0;
            if (z2 && !z3) {
                return false;
            }
        }
        return true;
    }

    private static boolean V(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int iD = trackGroupArray.d(exoTrackSelection.h());
        for (int i3 = 0; i3 < exoTrackSelection.length(); i3++) {
            if (RendererCapabilities.s(iArr[iD][exoTrackSelection.d(i3)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private Pair b0(int i3, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory factory, Comparator comparator) {
        int i4;
        RandomAccess randomAccessZ;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int iD = mappedTrackInfo2.d();
        int i5 = 0;
        while (i5 < iD) {
            if (i3 == mappedTrackInfo2.e(i5)) {
                TrackGroupArray trackGroupArrayF = mappedTrackInfo2.f(i5);
                for (int i6 = 0; i6 < trackGroupArrayF.f44987a; i6++) {
                    TrackGroup trackGroupB = trackGroupArrayF.b(i6);
                    List listA = factory.a(i5, trackGroupB, iArr[i5][i6]);
                    boolean[] zArr = new boolean[trackGroupB.f41153a];
                    int i7 = 0;
                    while (i7 < trackGroupB.f41153a) {
                        TrackInfo trackInfo = (TrackInfo) listA.get(i7);
                        int iA = trackInfo.a();
                        if (zArr[i7] || iA == 0) {
                            i4 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessZ = ImmutableList.z(trackInfo);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i8 = i7 + 1;
                                while (i8 < trackGroupB.f41153a) {
                                    TrackInfo trackInfo2 = (TrackInfo) listA.get(i8);
                                    int i9 = iD;
                                    if (trackInfo2.a() == 2 && trackInfo.b(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i8] = true;
                                    }
                                    i8++;
                                    iD = i9;
                                }
                                randomAccessZ = arrayList2;
                            }
                            i4 = iD;
                            arrayList.add(randomAccessZ);
                        }
                        i7++;
                        iD = i4;
                    }
                }
            }
            i5++;
            mappedTrackInfo2 = mappedTrackInfo;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((TrackInfo) list.get(i10)).f45415c;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.f45414b, iArr2), Integer.valueOf(trackInfo3.f45413a));
    }

    private void e0(Parameters parameters) {
        boolean zEquals;
        Assertions.e(parameters);
        synchronized (this.f45350d) {
            zEquals = this.f45353g.equals(parameters);
            this.f45353g = parameters;
        }
        if (zEquals) {
            return;
        }
        if (parameters.f45391z0 && this.f45351e == null) {
            Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        f();
    }

    public static /* synthetic */ List q(final DefaultTrackSelector defaultTrackSelector, final Parameters parameters, boolean z2, int[] iArr, int i3, TrackGroup trackGroup, int[] iArr2) {
        defaultTrackSelector.getClass();
        return AudioTrackInfo.e(i3, trackGroup, parameters, iArr2, z2, new Predicate() { // from class: androidx.media3.exoplayer.trackselection.k
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return this.f45472a.M((Format) obj, parameters);
            }
        }, iArr[i3]);
    }

    public static /* synthetic */ int u(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public Parameters c() {
        Parameters parameters;
        synchronized (this.f45350d) {
            parameters = this.f45353g;
        }
        return parameters;
    }

    protected ExoTrackSelection.Definition[] W(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) {
        String str;
        int iD = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[iD];
        Pair pairX = X(mappedTrackInfo, iArr, iArr2, parameters);
        if (pairX != null) {
            definitionArr[((Integer) pairX.second).intValue()] = (ExoTrackSelection.Definition) pairX.first;
        }
        if (pairX == null) {
            str = null;
        } else {
            Object obj = pairX.first;
            str = ((ExoTrackSelection.Definition) obj).f45435a.a(((ExoTrackSelection.Definition) obj).f45436b[0]).f40621d;
        }
        Pair pairC0 = c0(mappedTrackInfo, iArr, iArr2, parameters, str);
        String str2 = str;
        Pair pairY = (parameters.A || pairC0 == null) ? Y(mappedTrackInfo, iArr, parameters) : null;
        if (pairY != null) {
            definitionArr[((Integer) pairY.second).intValue()] = (ExoTrackSelection.Definition) pairY.first;
        } else if (pairC0 != null) {
            definitionArr[((Integer) pairC0.second).intValue()] = (ExoTrackSelection.Definition) pairC0.first;
        }
        Pair pairA0 = a0(mappedTrackInfo, iArr, parameters, str2);
        if (pairA0 != null) {
            definitionArr[((Integer) pairA0.second).intValue()] = (ExoTrackSelection.Definition) pairA0.first;
        }
        for (int i3 = 0; i3 < iD; i3++) {
            int iE = mappedTrackInfo.e(i3);
            if (iE != 2 && iE != 1 && iE != 3 && iE != 4) {
                definitionArr[i3] = Z(iE, mappedTrackInfo.f(i3), iArr[i3], parameters);
            }
        }
        return definitionArr;
    }

    protected Pair X(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final int[] iArr2, final Parameters parameters) {
        final boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 < mappedTrackInfo.d()) {
                if (2 == mappedTrackInfo.e(i3) && mappedTrackInfo.f(i3).f44987a > 0) {
                    z2 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        return b0(1, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: androidx.media3.exoplayer.trackselection.g
            @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i4, TrackGroup trackGroup, int[] iArr3) {
                return DefaultTrackSelector.q(this.f45465a, parameters, z2, iArr2, i4, trackGroup, iArr3);
            }
        }, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.AudioTrackInfo.c((List) obj, (List) obj2);
            }
        });
    }

    protected Pair Y(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final Parameters parameters) {
        if (parameters.f41197u.f41207a == 2) {
            return null;
        }
        return b0(4, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: androidx.media3.exoplayer.trackselection.c
            @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i3, TrackGroup trackGroup, int[] iArr2) {
                return DefaultTrackSelector.ImageTrackInfo.e(i3, trackGroup, parameters, iArr2);
            }
        }, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.ImageTrackInfo.c((List) obj, (List) obj2);
            }
        });
    }

    protected ExoTrackSelection.Definition Z(int i3, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        if (parameters.f41197u.f41207a == 2) {
            return null;
        }
        int i4 = 0;
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        for (int i5 = 0; i5 < trackGroupArray.f44987a; i5++) {
            TrackGroup trackGroupB = trackGroupArray.b(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < trackGroupB.f41153a; i6++) {
                if (RendererCapabilities.n(iArr2[i6], parameters.A0)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroupB.a(i6), iArr2[i6]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroupB;
                        i4 = i6;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i4);
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities.Listener
    public void a(Renderer renderer) {
        S(renderer);
    }

    protected Pair a0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final Parameters parameters, final String str) {
        if (parameters.f41197u.f41207a == 2) {
            return null;
        }
        final String strJ = parameters.f41200x ? J(this.f45351e) : null;
        return b0(3, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: androidx.media3.exoplayer.trackselection.i
            @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i3, TrackGroup trackGroup, int[] iArr2) {
                return DefaultTrackSelector.TextTrackInfo.e(i3, trackGroup, parameters, iArr2, str, strJ);
            }
        }, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.TextTrackInfo.c((List) obj, (List) obj2);
            }
        });
    }

    protected Pair c0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, final int[] iArr2, final Parameters parameters, final String str) {
        Context context;
        final Point pointW = null;
        if (parameters.f41197u.f41207a == 2) {
            return null;
        }
        if (parameters.f41187k && (context = this.f45351e) != null) {
            pointW = Util.W(context);
        }
        return b0(2, mappedTrackInfo, iArr, new TrackInfo.Factory() { // from class: androidx.media3.exoplayer.trackselection.e
            @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
            public final List a(int i3, TrackGroup trackGroup, int[] iArr3) {
                return DefaultTrackSelector.VideoTrackInfo.h(i3, trackGroup, parameters, iArr3, str, iArr2[i3], pointW);
            }
        }, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DefaultTrackSelector.VideoTrackInfo.g((List) obj, (List) obj2);
            }
        });
    }

    public void d0(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            e0((Parameters) trackSelectionParameters);
        }
        e0(new Parameters.Builder().d0(trackSelectionParameters).F());
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public boolean h() {
        return true;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public void j() {
        SpatializerWrapperV32 spatializerWrapperV32;
        if (Util.f41609a >= 32 && (spatializerWrapperV32 = this.f45354h) != null) {
            spatializerWrapperV32.e();
        }
        super.j();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public void l(AudioAttributes audioAttributes) {
        if (this.f45355i.equals(audioAttributes)) {
            return;
        }
        this.f45355i = audioAttributes;
        R();
    }

    @Override // androidx.media3.exoplayer.trackselection.MappingTrackSelector
    protected final Pair p(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        Parameters parameters;
        synchronized (this.f45350d) {
            parameters = this.f45353g;
        }
        if (parameters.f45391z0 && Util.f41609a >= 32 && this.f45354h == null) {
            this.f45354h = new SpatializerWrapperV32(this.f45351e, this);
        }
        int iD = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] definitionArrW = W(mappedTrackInfo, iArr, iArr2, parameters);
        E(mappedTrackInfo, parameters, definitionArrW);
        D(mappedTrackInfo, parameters, definitionArrW);
        for (int i3 = 0; i3 < iD; i3++) {
            int iE = mappedTrackInfo.e(i3);
            if (parameters.g(i3) || parameters.E.contains(Integer.valueOf(iE))) {
                definitionArrW[i3] = null;
            }
        }
        ExoTrackSelection[] exoTrackSelectionArrA = this.f45352f.a(definitionArrW, b(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[iD];
        for (int i4 = 0; i4 < iD; i4++) {
            rendererConfigurationArr[i4] = (parameters.g(i4) || parameters.E.contains(Integer.valueOf(mappedTrackInfo.e(i4))) || (mappedTrackInfo.e(i4) != -2 && exoTrackSelectionArrA[i4] == null)) ? null : RendererConfiguration.f43287c;
        }
        if (parameters.B0) {
            Q(mappedTrackInfo, iArr, rendererConfigurationArr, exoTrackSelectionArrA);
        }
        if (parameters.f41197u.f41207a != 0) {
            P(parameters, mappedTrackInfo, iArr, rendererConfigurationArr, exoTrackSelectionArrA);
        }
        return Pair.create(rendererConfigurationArr, exoTrackSelectionArrA);
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, Parameters.G0, factory);
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, Context context) {
        this.f45350d = new Object();
        this.f45351e = context != null ? context.getApplicationContext() : null;
        this.f45352f = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.f45353g = (Parameters) trackSelectionParameters;
        } else {
            this.f45353g = Parameters.G0.f().d0(trackSelectionParameters).F();
        }
        this.f45355i = AudioAttributes.f40518g;
        if (this.f45353g.f45391z0 && context == null) {
            Log.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public RendererCapabilities.Listener d() {
        return this;
    }
}
