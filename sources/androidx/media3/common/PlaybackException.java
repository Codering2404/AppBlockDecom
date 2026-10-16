package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PlaybackException extends Exception {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f40941d = Util.y0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f40942f = Util.y0(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f40943g = Util.y0(2);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f40944h = Util.y0(3);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f40945i = Util.y0(4);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f40946j = Util.y0(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f40948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f40949c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public PlaybackException(String str, Throwable th, int i3) {
        this(str, th, i3, Bundle.EMPTY, Clock.f41485a.a());
    }

    public static String b(int i3) {
        if (i3 == -100) {
            return "ERROR_CODE_DISCONNECTED";
        }
        if (i3 == -6) {
            return "ERROR_CODE_NOT_SUPPORTED";
        }
        if (i3 == -4) {
            return "ERROR_CODE_PERMISSION_DENIED";
        }
        if (i3 == -3) {
            return "ERROR_CODE_BAD_VALUE";
        }
        if (i3 == -2) {
            return "ERROR_CODE_INVALID_STATE";
        }
        if (i3 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i3 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i3) {
            case -110:
                return "ERROR_CODE_CONTENT_ALREADY_PLAYING";
            case -109:
                return "ERROR_CODE_END_OF_PLAYLIST";
            case -108:
                return "ERROR_CODE_SETUP_REQUIRED";
            case -107:
                return "ERROR_CODE_SKIP_LIMIT_REACHED";
            case -106:
                return "ERROR_CODE_NOT_AVAILABLE_IN_REGION";
            case -105:
                return "ERROR_CODE_PARENTAL_CONTROL_RESTRICTED";
            case -104:
                return "ERROR_CODE_CONCURRENT_STREAM_LIMIT";
            case -103:
                return "ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED";
            case -102:
                return "ERROR_CODE_AUTHENTICATION_EXPIRED";
            default:
                switch (i3) {
                    case 1000:
                        return "ERROR_CODE_UNSPECIFIED";
                    case AdError.NO_FILL_ERROR_CODE /* 1001 */:
                        return "ERROR_CODE_REMOTE_ERROR";
                    case 1002:
                        return "ERROR_CODE_BEHIND_LIVE_WINDOW";
                    case 1003:
                        return "ERROR_CODE_TIMEOUT";
                    case 1004:
                        return "ERROR_CODE_FAILED_RUNTIME_CHECK";
                    default:
                        switch (i3) {
                            case AdError.SERVER_ERROR_CODE /* 2000 */:
                                return "ERROR_CODE_IO_UNSPECIFIED";
                            case AdError.INTERNAL_ERROR_CODE /* 2001 */:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                            case AdError.CACHE_ERROR_CODE /* 2002 */:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                            case AdError.INTERNAL_ERROR_2003 /* 2003 */:
                                return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                            case AdError.INTERNAL_ERROR_2004 /* 2004 */:
                                return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                            case 2005:
                                return "ERROR_CODE_IO_FILE_NOT_FOUND";
                            case AdError.INTERNAL_ERROR_2006 /* 2006 */:
                                return "ERROR_CODE_IO_NO_PERMISSION";
                            case 2007:
                                return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                            case AdError.REMOTE_ADS_SERVICE_ERROR /* 2008 */:
                                return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                            default:
                                switch (i3) {
                                    case AdError.MEDIATION_ERROR_CODE /* 3001 */:
                                        return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                    case 3002:
                                        return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                    case 3003:
                                        return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                    case 3004:
                                        return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                    default:
                                        switch (i3) {
                                            case 4001:
                                                return "ERROR_CODE_DECODER_INIT_FAILED";
                                            case 4002:
                                                return "ERROR_CODE_DECODER_QUERY_FAILED";
                                            case 4003:
                                                return "ERROR_CODE_DECODING_FAILED";
                                            case 4004:
                                                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                            case 4005:
                                                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                            case 4006:
                                                return "ERROR_CODE_DECODING_RESOURCES_RECLAIMED";
                                            default:
                                                switch (i3) {
                                                    case 5001:
                                                        return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                    case 5002:
                                                        return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                    case 5003:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                    case 5004:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                    default:
                                                        switch (i3) {
                                                            case 6000:
                                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                                            case AdError.MEDIAVIEW_MISSING_ERROR_CODE /* 6001 */:
                                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                            case 6004:
                                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                            case 6005:
                                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                            case 6006:
                                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                            case 6007:
                                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                            case 6008:
                                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                            default:
                                                                return i3 >= 1000000 ? "custom error code" : "invalid error code";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public final String a() {
        return b(this.f40947a);
    }

    protected PlaybackException(String str, Throwable th, int i3, Bundle bundle, long j3) {
        super(str, th);
        this.f40947a = i3;
        this.f40949c = bundle;
        this.f40948b = j3;
    }
}
