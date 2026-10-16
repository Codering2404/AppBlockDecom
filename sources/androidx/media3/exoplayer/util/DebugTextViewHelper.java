package androidx.media3.exoplayer.util;

import android.widget.TextView;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DebugTextViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExoPlayer f45637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f45638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Updater f45639c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Updater implements Player.Listener, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DebugTextViewHelper f45640a;

        @Override // androidx.media3.common.Player.Listener
        public void G(int i3) {
            this.f45640a.i();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45640a.i();
        }

        @Override // androidx.media3.common.Player.Listener
        public void s0(boolean z2, int i3) {
            this.f45640a.i();
        }

        @Override // androidx.media3.common.Player.Listener
        public void v0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
            this.f45640a.i();
        }
    }

    private static String b(ColorInfo colorInfo) {
        if (colorInfo == null || !colorInfo.m()) {
            return "";
        }
        return " colr:" + colorInfo.q();
    }

    private static String d(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.c();
        return " sib:" + decoderCounters.f42864d + " sb:" + decoderCounters.f42866f + " rb:" + decoderCounters.f42865e + " dib:" + decoderCounters.f42868h + " db:" + decoderCounters.f42867g + " mcdb:" + decoderCounters.f42869i + " dk:" + decoderCounters.f42870j;
    }

    private static String e(float f3) {
        if (f3 == -1.0f || f3 == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", Float.valueOf(f3));
    }

    private static String g(long j3, int i3) {
        return i3 == 0 ? "N/A" : String.valueOf((long) (j3 / ((double) i3)));
    }

    protected String a() {
        Format formatY = this.f45637a.Y();
        DecoderCounters decoderCountersK0 = this.f45637a.k0();
        if (formatY == null || decoderCountersK0 == null) {
            return "";
        }
        return "\n" + formatY.f40632o + "(id:" + formatY.f40618a + " hz:" + formatY.F + " ch:" + formatY.E + d(decoderCountersK0) + ")";
    }

    protected String c() {
        return f() + h() + a();
    }

    protected String f() {
        int iP = this.f45637a.p();
        return String.format("playWhenReady:%s playbackState:%s item:%s", Boolean.valueOf(this.f45637a.L()), iP != 1 ? iP != 2 ? iP != 3 ? iP != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.f45637a.f0()));
    }

    protected String h() {
        Format formatC = this.f45637a.c();
        VideoSize videoSizeO = this.f45637a.O();
        DecoderCounters decoderCountersW = this.f45637a.W();
        if (formatC == null || decoderCountersW == null) {
            return "";
        }
        return "\n" + formatC.f40632o + "(id:" + formatC.f40618a + " r:" + videoSizeO.f41258a + "x" + videoSizeO.f41259b + b(formatC.C) + e(videoSizeO.f41261d) + d(decoderCountersW) + " vfpo: " + g(decoderCountersW.f42871k, decoderCountersW.f42872l) + ")";
    }

    protected final void i() {
        this.f45638b.setText(c());
        this.f45638b.removeCallbacks(this.f45639c);
        this.f45638b.postDelayed(this.f45639c, 1000L);
    }
}
