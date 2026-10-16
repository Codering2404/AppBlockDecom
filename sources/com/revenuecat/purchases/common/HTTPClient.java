package com.revenuecat.purchases.common;

import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.api.BuildConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class HTTPClient {
    public static final Companion Companion = new Companion(null);
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final boolean enableExtraRequestLogging;
    private final ForceServerErrorStrategy forceServerErrorStrategy;
    private final LocaleProvider localeProvider;
    private final MapConverter mapConverter;
    private final RequestResponseListener requestResponseListener;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;
    private final HTTPTimeoutManager timeoutManager;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager timeoutManager) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(eTagManager, "eTagManager");
        Intrinsics.checkNotNullParameter(signingManager, "signingManager");
        Intrinsics.checkNotNullParameter(storefrontProvider, "storefrontProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(mapConverter, "mapConverter");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(timeoutManager, "timeoutManager");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
        this.localeProvider = localeProvider;
        this.forceServerErrorStrategy = forceServerErrorStrategy;
        this.requestResponseListener = requestResponseListener;
        this.timeoutManager = timeoutManager;
        this.enableExtraRequestLogging = false;
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final HttpURLConnection getConnection(HTTPRequest hTTPRequest, long j3) throws IOException {
        URLConnection uRLConnectionOpenConnection = hTTPRequest.getFullURL().openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout((int) j3);
        for (Map.Entry<String, String> entry : hTTPRequest.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = hTTPRequest.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(os, "os");
            BufferedWriter bufferedWriterBuffer = buffer(os);
            String string = body.toString();
            Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
            writeFully(bufferedWriterBuffer, string);
        }
        return httpURLConnection;
    }

    private final String getETagHeader(URLConnection uRLConnection) {
        return uRLConnection.getHeaderField("X-RevenueCat-ETag");
    }

    private final InputStream getInputStream(HttpURLConnection httpURLConnection) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            return httpURLConnection.getInputStream();
        } catch (Exception e3) {
            if (!(e3 instanceof IllegalArgumentException ? true : e3 instanceof IOException)) {
                throw e3;
            }
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$getInputStream$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{e3.getMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            try {
                return httpURLConnection.getErrorStream();
            } catch (NullPointerException e4) {
                throw new NullPointerReadingErrorStreamException(e4.getMessage(), e4);
            }
        }
    }

    private final Date getRequestDateHeader(URLConnection uRLConnection) {
        String requestTimeHeader = getRequestTimeHeader(uRLConnection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }

    private final String getRequestTimeHeader(URLConnection uRLConnection) {
        String headerField = uRLConnection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || StringsKt.p0(headerField)) {
            return null;
        }
        return headerField;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : "android";
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.revenuecat.purchases.common.networking.HTTPResult performCall(java.net.URL r29, boolean r30, com.revenuecat.purchases.common.networking.Endpoint r31, java.util.Map<java.lang.String, ? extends java.lang.Object> r32, java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r33, java.util.Map<java.lang.String, java.lang.String> r34, boolean r35) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.HTTPClient.performCall(java.net.URL, boolean, com.revenuecat.purchases.common.networking.Endpoint, java.util.Map, java.util.List, java.util.Map, boolean):com.revenuecat.purchases.common.networking.HTTPResult");
    }

    private static final boolean performRequest$canUseFallback(Endpoint endpoint, int i3, List<URL> list) {
        return endpoint.getSupportsFallbackBaseURLs() && i3 >= 0 && i3 < list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z2, List list2, int i3, int i4, Object obj) throws JSONException, IOException {
        if ((i4 & 32) != 0) {
            z2 = false;
        }
        if ((i4 & 64) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i3 = 0;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z2, list2, i3);
    }

    private static final HTTPResult performRequest$performRequestToFallbackURL(List<URL> list, int i3, HTTPClient hTTPClient, final Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list2, Map<String, String> map2, boolean z2) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final URL url = list.get(i3);
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(NetworkStrings.RETRYING_CALL_WITH_FALLBACK_URL, Arrays.copyOf(new Object[]{endpoint.getPath(true), url}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                sb.append(str3);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
        return hTTPClient.performRequest(url, endpoint, map, list2, map2, z2, list, i3 + 1);
    }

    private final String readFully(InputStream inputStream) throws IOException {
        return TextStreamsKt.h(buffer(inputStream));
    }

    private final String toCurlRequest(HTTPRequest hTTPRequest) {
        StringBuilder sb = new StringBuilder("curl -v ");
        String str = hTTPRequest.getBody() == null ? "GET" : "POST";
        sb.append("-X ");
        sb.append(str);
        sb.append(" \\\n  ");
        for (Map.Entry<String, String> entry : hTTPRequest.getHeaders().entrySet()) {
            sb.append("-H \"");
            sb.append(entry.getKey());
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(entry.getValue());
            sb.append("\" \\\n  ");
        }
        if (hTTPRequest.getBody() != null) {
            sb.append("-d '");
            sb.append(hTTPRequest.getBody().toString());
            sb.append("' \\\n  ");
        }
        sb.append("\"");
        sb.append(hTTPRequest.getFullURL());
        sb.append("\"");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    private final void trackHttpRequestPerformedIfNeeded(URL url, Endpoint endpoint, Date date, boolean z2, HTTPResult hTTPResult, boolean z3, IOException iOException) {
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(Duration.f140631b, date, this.dateProvider.getNow());
            int responseCode = z2 ? hTTPResult != null ? hTTPResult.getResponseCode() : RCHTTPStatusCodes.NOT_MODIFIED : -1;
            HTTPResult.Origin origin = hTTPResult != null ? hTTPResult.getOrigin() : null;
            if (hTTPResult == null || (verificationResult = hTTPResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult2 = verificationResult;
            boolean z4 = z2 && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode);
            ConnectionErrorReason connectionErrorReasonFromIOException = iOException != null ? ConnectionErrorReason.Companion.fromIOException(iOException) : null;
            String host = url.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "baseURL.host");
            diagnosticsTracker.m539trackHttpRequestPerformedXzGXFE(host, endpoint, jBetween, z4, responseCode, hTTPResult != null ? hTTPResult.getBackendErrorCode() : null, origin, verificationResult2, z3, connectionErrorReasonFromIOException);
        }
    }

    private final VerificationResult verifyResponse(String str, URLConnection uRLConnection, String str2, String str3, String str4) {
        return this.signingManager.verifyResponse(str, uRLConnection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), str3, str2, getRequestTimeHeader(uRLConnection), getETagHeader(uRLConnection), str4);
    }

    private final void writeFully(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.flush();
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsBc8Release();
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list, Map<String, String> requestHeaders, boolean z2, List<URL> fallbackBaseURLs, int i3) throws Throwable {
        IOException iOException;
        boolean z3;
        Date date;
        HTTPResult hTTPResult;
        Endpoint endpoint2;
        IOException iOException2;
        boolean z4;
        HTTPResult hTTPResult2;
        IOException iOException3;
        boolean z5;
        HTTPResult hTTPResult3;
        Date date2;
        Endpoint endpoint3;
        URL url;
        LogHandler currentLogHandler;
        String str;
        String str2;
        IOException iOException4;
        HTTPResult hTTPResultPerformRequest$performRequestToFallbackURL;
        HTTPClient hTTPClient = this;
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(fallbackBaseURLs, "fallbackBaseURLs");
        boolean z6 = i3 == 0;
        Date now = hTTPClient.dateProvider.getNow();
        HTTPTimeoutManager.RequestResult requestResult = HTTPTimeoutManager.RequestResult.OTHER_RESULT;
        try {
            HTTPResult hTTPResultPerformCall = hTTPClient.performCall(baseURL, i3 > 0, endpoint, map, list, requestHeaders, z2);
            z3 = true;
            if (z6 && hTTPResultPerformCall != null) {
                try {
                    if (RCHTTPStatusCodes.INSTANCE.isSuccessful(hTTPResultPerformCall.getResponseCode())) {
                        requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                    }
                } catch (IOException e3) {
                    iOException2 = e3;
                    hTTPResult2 = hTTPResultPerformCall;
                    z4 = true;
                    endpoint2 = endpoint;
                    try {
                        try {
                            if ((iOException2 instanceof SocketTimeoutException) && z6) {
                                try {
                                    if (performRequest$canUseFallback(endpoint2, i3, fallbackBaseURLs)) {
                                        requestResult = HTTPTimeoutManager.RequestResult.TIMEOUT_ON_MAIN_BACKEND_FOR_FALLBACK_SUPPORTED_ENDPOINT;
                                        iOException4 = iOException2;
                                        try {
                                            hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, i3, this, endpoint2, map, list, requestHeaders, z2);
                                            hTTPClient = this;
                                        } catch (Throwable th) {
                                            th = th;
                                            hTTPClient = this;
                                            iOException = iOException4;
                                            hTTPResult = hTTPResult2;
                                            date = now;
                                            z3 = z4;
                                            hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                            hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z3, hTTPResult, z2, iOException);
                                            throw th;
                                        }
                                    }
                                    hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    url = baseURL;
                                    endpoint3 = endpoint;
                                    z5 = z2;
                                    iOException3 = iOException4;
                                    date2 = now;
                                    z3 = z4;
                                } catch (Throwable th2) {
                                    th = th2;
                                    iOException4 = iOException2;
                                }
                            }
                            if (!performRequest$canUseFallback(endpoint2, i3, fallbackBaseURLs)) {
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z3 = z4;
                                try {
                                    throw iOException;
                                } catch (Throwable th3) {
                                    th = th3;
                                    hTTPResult = hTTPResult2;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z3, hTTPResult, z2, iOException);
                                    throw th;
                                }
                            }
                            try {
                                hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, i3, this, endpoint2, map, list, requestHeaders, z2);
                                hTTPClient = this;
                                hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                url = baseURL;
                                endpoint3 = endpoint;
                                z5 = z2;
                                iOException3 = iOException4;
                                date2 = now;
                                z3 = z4;
                            } catch (Throwable th4) {
                                th = th4;
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z3 = z4;
                                hTTPResult = hTTPResult2;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z3, hTTPResult, z2, iOException);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            hTTPClient = this;
                        }
                        iOException4 = iOException2;
                    } catch (Throwable th6) {
                        th = th6;
                        iOException = iOException2;
                        date = now;
                        z3 = z4;
                        hTTPClient = this;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    hTTPResult = hTTPResultPerformCall;
                    date = now;
                    iOException = null;
                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z3, hTTPResult, z2, iOException);
                    throw th;
                }
            }
            hTTPClient.timeoutManager.recordRequestResult(requestResult);
            url = baseURL;
            z5 = z2;
            hTTPResult3 = hTTPResultPerformCall;
            date2 = now;
            iOException3 = null;
            endpoint3 = endpoint;
        } catch (IOException e4) {
            endpoint2 = endpoint;
            iOException2 = e4;
            z4 = false;
            hTTPResult2 = null;
        } catch (Throwable th8) {
            th = th8;
            iOException = null;
            hTTPClient = this;
            z3 = false;
            date = now;
            hTTPResult = null;
        }
        hTTPClient.trackHttpRequestPerformedIfNeeded(url, endpoint3, date2, z3, hTTPResult3, z5, iOException3);
        HTTPResult hTTPResult4 = hTTPResult3;
        if (hTTPResult4 != null) {
            return (RCHTTPStatusCodes.INSTANCE.isServerError(hTTPResult4.getResponseCode()) && performRequest$canUseFallback(endpoint, i3, fallbackBaseURLs)) ? performRequest$performRequestToFallbackURL(fallbackBaseURLs, i3, this, endpoint, map, list, requestHeaders, z2) : hTTPResult4;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + NetworkStrings.ETAG_RETRYING_CALL;
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
        return performRequest(baseURL, endpoint, map, list, requestHeaders, true, fallbackBaseURLs, i3);
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    private final Map<String, String> getHeaders(Map<String, String> map, URL url, boolean z2, String str, boolean z3, String str2) {
        Map mapPlus = MapsKt.plus(MapsKt.mapOf(TuplesKt.a("Content-Type", "application/json"), TuplesKt.a("X-Platform", getXPlatformHeader()), TuplesKt.a("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor()), TuplesKt.a("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion()), TuplesKt.a("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.a("X-Platform-Device", Build.MODEL), TuplesKt.a(MrGIhy.kgI, Build.BRAND), TuplesKt.a("X-Version", "10.3.1"), TuplesKt.a("X-Preferred-Locales", StringsKt.N(this.localeProvider.getCurrentLocalesLanguageTags(), '-', '_', false, 4, null)), TuplesKt.a("X-Client-Locale", this.appConfig.getLanguageTag()), TuplesKt.a("X-Client-Version", this.appConfig.getVersionName()), TuplesKt.a("X-Client-Bundle-ID", this.appConfig.getPackageName()), TuplesKt.a("X-Observer-Mode-Enabled", this.appConfig.getFinishTransactions() ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), TuplesKt.a("X-Nonce", str), TuplesKt.a(HTTPRequest.POST_PARAMS_HASH, str2), TuplesKt.a("X-Custom-Entitlements-Computation", this.appConfig.getCustomEntitlementComputation() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : null), TuplesKt.a("X-UI-Preview-Mode", this.appConfig.getUiPreviewMode() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : null), TuplesKt.a("X-Storefront", this.storefrontProvider.getStorefront()), TuplesKt.a("X-Is-Debug-Build", String.valueOf(this.appConfig.isDebugBuild())), TuplesKt.a("X-Kotlin-Version", KotlinVersion.f139754g.toString()), TuplesKt.a("X-Is-Backgrounded", String.valueOf(this.appConfig.isAppBackgrounded())), TuplesKt.a("X-Billing-Client-Sdk-Version", BuildConfig.BILLING_CLIENT_VERSION)), map);
        ETagManager eTagManager = this.eTagManager;
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "fullURL.toString()");
        return MapExtensionsKt.filterNotNullValues(MapsKt.plus(mapPlus, eTagManager.getETagHeaders$purchases_defaultsBc8Release(string, z3, z2)));
    }

    private final boolean getLoadShedderHeader(URLConnection uRLConnection) {
        String lowerCase;
        String headerField = uRLConnection.getHeaderField(HTTPResult.LOAD_SHEDDER_HEADER_NAME);
        if (headerField != null) {
            lowerCase = headerField.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, vfptEEmYY.aVZwvNR);
        } else {
            lowerCase = null;
        }
        return Intrinsics.areEqual(lowerCase, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager hTTPTimeoutManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i3 & 32) != 0 ? new DefaultDateProvider() : dateProvider;
        this(appConfig, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, defaultDateProvider, (i3 & 64) != 0 ? new MapConverter() : mapConverter, localeProvider, (i3 & Function.MAX_NARGS) != 0 ? null : forceServerErrorStrategy, (i3 & 512) != 0 ? null : requestResponseListener, (i3 & 1024) != 0 ? new HTTPTimeoutManager(appConfig, defaultDateProvider) : hTTPTimeoutManager);
    }
}
