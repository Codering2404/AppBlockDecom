package androidx.media3.transformer;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Clock;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableBiMap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExportException extends Exception {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ImmutableBiMap f48192d = new ImmutableBiMap.Builder().g("ERROR_CODE_FAILED_RUNTIME_CHECK", Integer.valueOf(AdError.NO_FILL_ERROR_CODE)).g("ERROR_CODE_IO_UNSPECIFIED", Integer.valueOf(AdError.SERVER_ERROR_CODE)).g("ERROR_CODE_IO_NETWORK_CONNECTION_FAILED", Integer.valueOf(AdError.INTERNAL_ERROR_CODE)).g("ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT", Integer.valueOf(AdError.CACHE_ERROR_CODE)).g("ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE", Integer.valueOf(AdError.INTERNAL_ERROR_2003)).g("ERROR_CODE_IO_BAD_HTTP_STATUS", Integer.valueOf(AdError.INTERNAL_ERROR_2004)).g("ERROR_CODE_IO_FILE_NOT_FOUND", 2005).g("ERROR_CODE_IO_NO_PERMISSION", Integer.valueOf(AdError.INTERNAL_ERROR_2006)).g("ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED", 2007).g("ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE", Integer.valueOf(AdError.REMOTE_ADS_SERVICE_ERROR)).g("ERROR_CODE_DECODER_INIT_FAILED", Integer.valueOf(AdError.MEDIATION_ERROR_CODE)).g("ERROR_CODE_DECODING_FAILED", 3002).g("ERROR_CODE_DECODING_FORMAT_UNSUPPORTED", 3003).g("ERROR_CODE_ENCODER_INIT_FAILED", 4001).g("ERROR_CODE_ENCODING_FAILED", 4002).g("ERROR_CODE_ENCODING_FORMAT_UNSUPPORTED", 4003).g("ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED", 5001).g("ERROR_CODE_AUDIO_PROCESSING_FAILED", Integer.valueOf(AdError.MEDIAVIEW_MISSING_ERROR_CODE)).g("ERROR_CODE_MUXING_FAILED", Integer.valueOf(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE)).g("ERROR_CODE_MUXING_TIMEOUT", Integer.valueOf(AdError.LOAD_CALLED_WHILE_SHOWING_AD)).g("ERROR_CODE_MUXING_APPEND", Integer.valueOf(AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED)).d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f48194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CodecInfo f48195c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CodecInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f48197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f48198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f48199d;

        public CodecInfo(String str, boolean z2, boolean z3, String str2) {
            this.f48196a = str;
            this.f48197b = z2;
            this.f48198c = z3;
            this.f48199d = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f48197b ? "Video" : "Audio");
            sb.append(this.f48198c ? "Decoder" : "Encoder");
            return "CodecInfo{type=" + sb.toString() + ", configurationFormat=" + this.f48196a + ", name=" + this.f48199d + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    private ExportException(String str, Throwable th, int i3) {
        this(str, th, i3, null);
    }

    public static ExportException a(Throwable th, int i3) {
        return new ExportException("Asset loader error", th, i3);
    }

    public static ExportException b(AudioProcessor.UnhandledAudioFormatException unhandledAudioFormatException, String str) {
        return new ExportException("Audio error: " + str + ", audioFormat=" + unhandledAudioFormatException.f41291a, unhandledAudioFormatException, AdError.MEDIAVIEW_MISSING_ERROR_CODE);
    }

    public static ExportException c(Throwable th, int i3, CodecInfo codecInfo) {
        return new ExportException("Codec exception: " + codecInfo, th, i3, codecInfo);
    }

    static ExportException d(Throwable th, int i3) {
        return new ExportException("Muxer error", th, i3);
    }

    public static ExportException e(Exception exc) {
        return exc instanceof RuntimeException ? new ExportException("Unexpected runtime error", exc, AdError.NO_FILL_ERROR_CODE) : new ExportException("Unexpected error", exc, 1000);
    }

    static ExportException f(VideoFrameProcessingException videoFrameProcessingException) {
        return new ExportException("Video frame processing error", videoFrameProcessingException, 5001);
    }

    private ExportException(String str, Throwable th, int i3, CodecInfo codecInfo) {
        super(str, th);
        this.f48193a = i3;
        this.f48194b = Clock.f41485a.a();
        this.f48195c = codecInfo;
    }
}
