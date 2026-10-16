package androidx.media3.exoplayer.util;

import android.text.TextUtils;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class EventLogger implements AnalyticsListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final NumberFormat f45641e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f45642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeline.Window f45643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Timeline.Period f45644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f45645d;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f45641e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    private String B0(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.f43341c;
        if (eventTime.f43342d != null) {
            str = str + ", period=" + eventTime.f43340b.b(eventTime.f43342d.f44754a);
            if (eventTime.f43342d.c()) {
                str = (str + ", adGroup=" + eventTime.f43342d.f44755b) + ", ad=" + eventTime.f43342d.f44756c;
            }
        }
        return "eventTime=" + I0(eventTime.f43339a - this.f45645d) + ", mediaPos=" + I0(eventTime.f43343e) + ", " + str;
    }

    private static String D0(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    private static String E0(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    private static String F0(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 3 ? "?" : "UNSUITABLE_AUDIO_OUTPUT" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    private static String G0(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    private static String H0(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static String I0(long j3) {
        return j3 == -9223372036854775807L ? "?" : f45641e.format(j3 / 1000.0f);
    }

    private static String J0(int i3) {
        return i3 != 0 ? i3 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    private static String K0(boolean z2) {
        return z2 ? "[X]" : "[ ]";
    }

    private void L0(AnalyticsListener.EventTime eventTime, String str) {
        N0(y0(eventTime, str, null, null));
    }

    private void M0(AnalyticsListener.EventTime eventTime, String str, String str2) {
        N0(y0(eventTime, str, str2, null));
    }

    private void O0(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        Q0(y0(eventTime, str, str2, th));
    }

    private void P0(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        Q0(y0(eventTime, str, null, th));
    }

    private void R0(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        O0(eventTime, "internalError", str, exc);
    }

    private void S0(Metadata metadata, String str) {
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            N0(str + metadata.d(i3));
        }
    }

    private static String c(AudioSink.AudioTrackConfig audioTrackConfig) {
        return audioTrackConfig.f43702a + "," + audioTrackConfig.f43704c + "," + audioTrackConfig.f43703b + "," + audioTrackConfig.f43705d + "," + audioTrackConfig.f43706e + "," + audioTrackConfig.f43707f;
    }

    private static String m0(int i3) {
        switch (i3) {
            case 0:
                return "AUTO_TRANSITION";
            case 1:
                return "SEEK";
            case 2:
                return "SEEK_ADJUSTMENT";
            case 3:
                return "SKIP";
            case 4:
                return "REMOVE";
            case 5:
                return "INTERNAL";
            case 6:
                return "SILENCE_SKIP";
            default:
                return "?";
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void B(AnalyticsListener.EventTime eventTime, int i3, int i4) {
        M0(eventTime, "surfaceSize", i3 + ", " + i4);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void C(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(m0(i3));
        sb.append(", PositionInfo:old [");
        sb.append("mediaItem=");
        sb.append(positionInfo.f40971c);
        sb.append(", period=");
        sb.append(positionInfo.f40974f);
        sb.append(", pos=");
        sb.append(positionInfo.f40975g);
        if (positionInfo.f40977i != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.f40976h);
            sb.append(", adGroup=");
            sb.append(positionInfo.f40977i);
            sb.append(", ad=");
            sb.append(positionInfo.f40978j);
        }
        sb.append("], PositionInfo:new [");
        sb.append("mediaItem=");
        sb.append(positionInfo2.f40971c);
        sb.append(", period=");
        sb.append(positionInfo2.f40974f);
        sb.append(", pos=");
        sb.append(positionInfo2.f40975g);
        if (positionInfo2.f40977i != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.f40976h);
            sb.append(", adGroup=");
            sb.append(positionInfo2.f40977i);
            sb.append(", ad=");
            sb.append(positionInfo2.f40978j);
        }
        sb.append("]");
        M0(eventTime, "positionDiscontinuity", sb.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void C0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        M0(eventTime, "videoInputFormat", Format.h(format));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void E(AnalyticsListener.EventTime eventTime, int i3) {
        M0(eventTime, "drmSessionAcquired", "state=" + i3);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void H(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "videoEnabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void J(AnalyticsListener.EventTime eventTime, float f3) {
        M0(eventTime, "volume", Float.toString(f3));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void K(AnalyticsListener.EventTime eventTime, boolean z2) {
        M0(eventTime, "shuffleModeEnabled", Boolean.toString(z2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void L(AnalyticsListener.EventTime eventTime, int i3) {
        M0(eventTime, ServerProtocol.DIALOG_PARAM_STATE, H0(i3));
    }

    protected void N0(String str) {
        Log.b(this.f45642a, str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void O(AnalyticsListener.EventTime eventTime, int i3, long j3, long j4) {
        O0(eventTime, "audioTrackUnderrun", i3 + ", " + j3 + ", " + j4, null);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void P(AnalyticsListener.EventTime eventTime, int i3) {
        M0(eventTime, "audioSessionId", Integer.toString(i3));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void Q(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        M0(eventTime, "audioInputFormat", Format.h(format));
    }

    protected void Q0(String str) {
        Log.d(this.f45642a, str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void S(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        M0(eventTime, "audioTrackInit", c(audioTrackConfig));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void T(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        M0(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void U(AnalyticsListener.EventTime eventTime, String str) {
        M0(eventTime, "audioDecoderReleased", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void V(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        M0(eventTime, "audioTrackReleased", c(audioTrackConfig));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void W(AnalyticsListener.EventTime eventTime, String str) {
        M0(eventTime, "videoDecoderReleased", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void X(AnalyticsListener.EventTime eventTime, int i3) {
        M0(eventTime, "playbackSuppressionReason", F0(i3));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void Y(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        M0(eventTime, "upstreamDiscarded", Format.h(mediaLoadData.f44742c));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void Z(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysRemoved");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void a(AnalyticsListener.EventTime eventTime, Object obj, long j3) {
        M0(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void b(AnalyticsListener.EventTime eventTime, boolean z2) {
        M0(eventTime, "loading", Boolean.toString(z2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void c0(AnalyticsListener.EventTime eventTime, int i3, long j3) {
        M0(eventTime, "droppedFrames", Integer.toString(i3));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void d0(AnalyticsListener.EventTime eventTime, int i3, int i4, boolean z2) {
        M0(eventTime, "rendererReady", "rendererIndex=" + i3 + ", " + Util.s0(i4) + ", " + z2);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void e(AnalyticsListener.EventTime eventTime, boolean z2) {
        M0(eventTime, "isPlaying", Boolean.toString(z2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void f(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        N0("metadata [" + B0(eventTime));
        S0(metadata, "  ");
        N0("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void h(AnalyticsListener.EventTime eventTime, boolean z2) {
        M0(eventTime, "skipSilenceEnabled", Boolean.toString(z2));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void i(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        P0(eventTime, "playerFailed", playbackException);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void k0(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysRestored");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void l(AnalyticsListener.EventTime eventTime, boolean z2, int i3) {
        M0(eventTime, "playWhenReady", z2 + ", " + E0(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void l0(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        N0("tracks [" + B0(eventTime));
        ImmutableList immutableListA = tracks.a();
        for (int i3 = 0; i3 < immutableListA.size(); i3++) {
            Tracks.Group group = (Tracks.Group) immutableListA.get(i3);
            N0("  group [");
            for (int i4 = 0; i4 < group.f41246a; i4++) {
                N0("    " + K0(group.e(i4)) + " Track:" + i4 + ", " + Format.h(group.a(i4)) + ", supported=" + Util.c0(group.b(i4)));
            }
            N0("  ]");
        }
        boolean z2 = false;
        for (int i5 = 0; !z2 && i5 < immutableListA.size(); i5++) {
            Tracks.Group group2 = (Tracks.Group) immutableListA.get(i5);
            for (int i6 = 0; !z2 && i6 < group2.f41246a; i6++) {
                if (group2.e(i6) && (metadata = group2.a(i6).f40629l) != null && metadata.e() > 0) {
                    N0("  Metadata [");
                    S0(metadata, "    ");
                    N0("  ]");
                    z2 = true;
                }
            }
        }
        N0("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void m(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "videoDisabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void n(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmSessionReleased");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void o0(AnalyticsListener.EventTime eventTime, int i3) {
        M0(eventTime, "repeatMode", G0(i3));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void q0(AnalyticsListener.EventTime eventTime, String str, long j3, long j4) {
        M0(eventTime, "videoDecoderInitialized", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void r(AnalyticsListener.EventTime eventTime, String str, long j3, long j4) {
        M0(eventTime, "audioDecoderInitialized", str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void r0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        M0(eventTime, "videoSize", videoSize.f41258a + ", " + videoSize.f41259b);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void u(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        M0(eventTime, "audioAttributes", audioAttributes.f40524a + "," + audioAttributes.f40525b + "," + audioAttributes.f40526c + "," + audioAttributes.f40527d);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void u0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        M0(eventTime, "downstreamFormat", Format.h(mediaLoadData.f44742c));
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void v(AnalyticsListener.EventTime eventTime, int i3) {
        int i4 = eventTime.f43340b.i();
        int iP = eventTime.f43340b.p();
        N0("timeline [" + B0(eventTime) + ", periodCount=" + i4 + ", windowCount=" + iP + ", reason=" + J0(i3));
        for (int i5 = 0; i5 < Math.min(i4, 3); i5++) {
            eventTime.f43340b.f(i5, this.f45644c);
            N0("  period [" + I0(this.f45644c.j()) + "]");
        }
        if (i4 > 3) {
            N0("  ...");
        }
        for (int i6 = 0; i6 < Math.min(iP, 3); i6++) {
            eventTime.f43340b.n(i6, this.f45643b);
            N0("  window [" + I0(this.f45643b.d()) + ", seekable=" + this.f45643b.f41142h + ", dynamic=" + this.f45643b.f41143i + "]");
        }
        if (iP > 3) {
            N0("  ...");
        }
        N0("]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void w(AnalyticsListener.EventTime eventTime, Exception exc) {
        R0(eventTime, "drmSessionManagerError", exc);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void x(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "audioDisabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void y(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i3) {
        N0("mediaItem [" + B0(eventTime) + ", reason=" + D0(i3) + "]");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void z(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "audioEnabled");
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void z0(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysLoaded");
    }

    private String y0(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        String str3 = str + " [" + B0(eventTime);
        if (th instanceof PlaybackException) {
            str3 = str3 + pMpIcGE.kfjtgCful + ((PlaybackException) th).a();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String strF = Log.f(th);
        if (!TextUtils.isEmpty(strF)) {
            str3 = str3 + "\n  " + strF.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void M(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        R0(eventTime, oUcQRqOVfOC.FOlzNErqBfS, iOException);
    }
}
