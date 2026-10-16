package com.applovin.impl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.impl.o2;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class nh extends Exception implements o2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o2.a f62048c = new o2.a() { // from class: com.applovin.impl.wz
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return new nh(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f62050b;

    protected nh(Bundle bundle) {
        this(bundle.getString(b(2)), a(bundle), bundle.getInt(b(0), 1000), bundle.getLong(b(1), SystemClock.elapsedRealtime()));
    }

    private static Throwable a(Class cls, String str) {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    protected static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    private static Throwable a(Bundle bundle) {
        String string = bundle.getString(b(3));
        String string2 = bundle.getString(b(4));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, nh.class.getClassLoader());
            Throwable thA = Throwable.class.isAssignableFrom(cls) ? a(cls, string2) : null;
            if (thA != null) {
                return thA;
            }
        } catch (Throwable unused) {
        }
        return a(string2);
    }

    protected nh(String str, Throwable th, int i3, long j3) {
        super(str, th);
        this.f62049a = i3;
        this.f62050b = j3;
    }

    public final String a() {
        return a(this.f62049a);
    }

    public static String a(int i3) {
        if (i3 == 5001) {
            return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
        }
        if (i3 != 5002) {
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
                                                    if (i3 >= 1000000) {
                                                        return "custom error code";
                                                    }
                                                    return "invalid error code";
                                            }
                                    }
                            }
                    }
            }
        }
        return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
    }

    private static RemoteException a(String str) {
        return new RemoteException(str);
    }
}
