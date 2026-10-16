package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.stetho.common.Utf8Charset;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
import org.json.JSONArray;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class GraphRequest {
    public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final String ATTACHED_FILES_PARAM = "attached_files";
    public static final String ATTACHMENT_FILENAME_PREFIX = "file";
    public static final String BATCH_APP_ID_PARAM = "batch_app_id";
    public static final String BATCH_BODY_PARAM = "body";
    public static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    public static final String BATCH_ENTRY_NAME_PARAM = "name";
    public static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    public static final String BATCH_METHOD_PARAM = "method";
    public static final String BATCH_PARAM = "batch";
    public static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    public static final String CAPTION_PARAM = "caption";
    public static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String DEBUG_KEY = "__debug__";
    public static final String DEBUG_MESSAGES_KEY = "messages";
    public static final String DEBUG_MESSAGE_KEY = "message";
    public static final String DEBUG_MESSAGE_LINK_KEY = "link";
    public static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    public static final String DEBUG_PARAM = "debug";
    public static final String DEBUG_SEVERITY_INFO = "info";
    public static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    public static final String FORMAT_JSON = "json";
    public static final String FORMAT_PARAM = "format";
    public static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    public static final String ME = "me";
    public static final String MIME_BOUNDARY;
    public static final String MY_FRIENDS = "me/friends";
    public static final String MY_PHOTOS = "me/photos";
    public static final String PICTURE_PARAM = "picture";
    public static final String SDK_ANDROID = "android";
    public static final String SDK_PARAM = "sdk";
    public static final String SEARCH = "search";
    public static final String USER_AGENT_BASE = "FBAndroidSDK";
    public static final String USER_AGENT_HEADER = "User-Agent";
    public static final String VIDEOS_SUFFIX = "/videos";
    public static String defaultBatchApplicationId;
    public static volatile String userAgent;
    public static final Pattern versionPattern;
    public AccessToken accessToken;
    public String batchEntryDependsOn;
    public String batchEntryName;
    public boolean batchEntryOmitResultOnSuccess;
    public Callback callback;
    public boolean forceApplicationRequest;
    public JSONObject graphObject;
    public String graphPath;
    public HttpMethod httpMethod;
    public String overriddenURL;
    public Bundle parameters;
    public Object tag;
    public String version;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = GraphRequest.class.getSimpleName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Attachment {
        public final GraphRequest request;
        public final Object value;

        public Attachment(GraphRequest request, Object obj) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.value = obj;
        }

        public final GraphRequest getRequest() {
            return this.request;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, getUserAgent());
            httpURLConnection.setRequestProperty(GraphRequest.ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
            httpURLConnection.setChunkedStreamingMode(0);
            return httpURLConnection;
        }

        private final String getBatchAppId(GraphRequestBatch graphRequestBatch) {
            String batchApplicationId = graphRequestBatch.getBatchApplicationId();
            if (batchApplicationId != null && !graphRequestBatch.isEmpty()) {
                return batchApplicationId;
            }
            Iterator<GraphRequest> it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = it.next().getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String str = GraphRequest.defaultBatchApplicationId;
            return (str == null || str.length() <= 0) ? FacebookSdk.getApplicationId() : str;
        }

        private final String getDefaultPhotoPathIfNull(String str) {
            return str == null ? GraphRequest.MY_PHOTOS : str;
        }

        private final String getMimeContentType() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }

        public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, FacebookSdkVersion.BUILD}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                GraphRequest.userAgent = str;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    String str2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
                    GraphRequest.userAgent = str2;
                }
            }
            return GraphRequest.userAgent;
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
            Iterator<GraphRequestBatch.Callback> it = graphRequestBatch.getCallbacks().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof GraphRequestBatch.OnProgressCallback) {
                    return true;
                }
            }
            Iterator<GraphRequest> it2 = graphRequestBatch.iterator();
            while (it2.hasNext()) {
                if (it2.next().getCallback() instanceof OnProgressCallback) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
            for (GraphRequest graphRequest : graphRequestBatch) {
                Iterator<String> it = graphRequest.getParameters().keySet().iterator();
                while (it.hasNext()) {
                    if (isSupportedAttachmentType(graphRequest.getParameters().get(it.next()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isMeRequest(String str) {
            Matcher matcher = GraphRequest.versionPattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(str, "matcher.group(1)");
            }
            return StringsKt.U(str, "me/", false, 2, null) || StringsKt.U(str, "/me/", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object obj) {
            return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        public static final void newMeRequest$lambda$0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(response.getJSONObject(), response);
            }
        }

        public static final void newPlacesSearchRequest$lambda$1(GraphJSONArrayCallback graphJSONArrayCallback, GraphResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (graphJSONArrayCallback != null) {
                JSONObject jSONObject = response.getJSONObject();
                graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, response);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String parameterToString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (!(obj instanceof Date)) {
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            String str = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
            Intrinsics.checkNotNullExpressionValue(str, "iso8601DateFormat.format(value)");
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void processGraphObject(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest.KeyValueSerializer r12) {
            /*
                r9 = this;
                boolean r0 = r9.isMeRequest(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L23
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r5 = 0
                r6 = 0
                r3 = r11
                int r11 = kotlin.text.StringsKt.n0(r3, r4, r5, r6, r7, r8)
                java.lang.String r4 = "?"
                int r0 = kotlin.text.StringsKt.n0(r3, r4, r5, r6, r7, r8)
                r3 = 3
                if (r11 <= r3) goto L23
                r3 = -1
                if (r0 == r3) goto L21
                if (r11 >= r0) goto L23
            L21:
                r11 = r1
                goto L24
            L23:
                r11 = r2
            L24:
                java.util.Iterator r0 = r10.keys()
            L28:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L53
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L44
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.StringsKt.F(r3, r5, r1)
                if (r5 == 0) goto L44
                r5 = r1
                goto L45
            L44:
                r5 = r2
            L45:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
                r9.processGraphObjectProperty(r3, r4, r12, r5)
                goto L28
            L53:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        private final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z2) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                if (z2) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                        String str2 = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                        Object objOpt = jSONObject.opt(next);
                        Intrinsics.checkNotNullExpressionValue(objOpt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(str2, objOpt, keyValueSerializer, z2);
                    }
                    return;
                }
                if (jSONObject.has("id")) {
                    String strOptString = jSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, strOptString, keyValueSerializer, z2);
                    return;
                } else if (jSONObject.has("url")) {
                    String strOptString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, strOptString2, keyValueSerializer, z2);
                    return;
                } else {
                    if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                        String string = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                        processGraphObjectProperty(str, string, keyValueSerializer, z2);
                        return;
                    }
                    return;
                }
            }
            if (JSONArray.class.isAssignableFrom(cls)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
                    String str3 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                    Object objOpt2 = jSONArray.opt(i3);
                    Intrinsics.checkNotNullExpressionValue(objOpt2, "jsonArray.opt(i)");
                    processGraphObjectProperty(str3, objOpt2, keyValueSerializer, z2);
                }
                return;
            }
            if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, obj.toString());
                return;
            }
            if (Date.class.isAssignableFrom(cls)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.Date");
                String str4 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                Intrinsics.checkNotNullExpressionValue(str4, "iso8601DateFormat.format(date)");
                keyValueSerializer.writeString(str, str4);
                return;
            }
            Utility.logd(GraphRequest.TAG, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i3, URL url, OutputStream outputStream, boolean z2) throws JSONException, IOException {
            Serializer serializer = new Serializer(outputStream, logger, z2);
            if (i3 != 1) {
                String batchAppId = getBatchAppId(graphRequestBatch);
                if (batchAppId.length() == 0) {
                    throw new FacebookException("App ID was not specified at the request or Settings.");
                }
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                HashMap map = new HashMap();
                serializeRequestsAsJSON(serializer, graphRequestBatch, map);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(map, serializer);
                return;
            }
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap map2 = new HashMap();
            for (String key : graphRequest.getParameters().keySet()) {
                Object obj = graphRequest.getParameters().get(key);
                if (isSupportedAttachmentType(obj)) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    map2.put(key, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(map2, serializer);
            JSONObject graphObject = graphRequest.getGraphObject();
            if (graphObject != null) {
                String path = url.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "url.path");
                processGraphObject(graphObject, path, serializer);
            }
        }

        public static final void runCallbacks$lambda$2(ArrayList callbacks, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(callbacks, "$callbacks");
            Intrinsics.checkNotNullParameter(requests, "$requests");
            int size = callbacks.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = callbacks.get(i3);
                i3++;
                Pair pair = (Pair) obj;
                Callback callback = (Callback) pair.first;
                Object obj2 = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "pair.second");
                callback.onCompleted((GraphResponse) obj2);
            }
            Iterator<GraphRequestBatch.Callback> it = requests.getCallbacks().iterator();
            while (it.hasNext()) {
                it.next().onBatchCompleted(requests);
            }
        }

        private final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) throws IOException {
            for (Map.Entry<String, Attachment> entry : map.entrySet()) {
                if (GraphRequest.Companion.isSupportedAttachmentType(entry.getValue().getValue())) {
                    serializer.writeObject(entry.getKey(), entry.getValue().getValue(), entry.getValue().getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) throws IOException {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (isSupportedParameterType(obj)) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    serializer.writeObject(key, obj, graphRequest);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) throws JSONException, IOException {
            JSONArray jSONArray = new JSONArray();
            Iterator<GraphRequest> it = collection.iterator();
            while (it.hasNext()) {
                it.next().serializeToBatch(jSONArray, map);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, jSONArray, collection);
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z2) {
            if (!z2) {
                httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
            }
        }

        @JvmStatic
        public final GraphResponse executeAndWait(GraphRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            List<GraphResponse> listExecuteBatchAndWait = executeBatchAndWait(request);
            if (listExecuteBatchAndWait.size() == 1) {
                return listExecuteBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(GraphRequest... requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAndWait(ArraysKt.toList(requests));
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(GraphRequest... requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAsync(ArraysKt.toList(requests));
        }

        @JvmStatic
        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection connection, Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeConnectionAndWait(connection, new GraphRequestBatch(requests));
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeConnectionAsync(null, connection, requests);
        }

        @JvmStatic
        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        @JvmStatic
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (str == null && accessToken != null) {
                str = accessToken.getApplicationId();
            }
            if (str == null) {
                str = Utility.getMetadataApplicationId(context);
            }
            if (str == null) {
                throw new FacebookException("Facebook App ID cannot be determined");
            }
            String str2 = str + "/custom_audience_third_party_id";
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
            Bundle bundle = new Bundle();
            if (accessToken == null) {
                if (attributionIdentifiers == null) {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
                String attributionId = attributionIdentifiers.getAttributionId() != null ? attributionIdentifiers.getAttributionId() : attributionIdentifiers.getAndroidAdvertiserId();
                if (attributionId != null) {
                    bundle.putString("udid", attributionId);
                }
            }
            if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                bundle.putString("limit_event_usage", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            return new GraphRequest(accessToken, str2, bundle, HttpMethod.GET, callback, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, null, HttpMethod.DELETE, callback, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, null, null, callback, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newMeRequest(AccessToken accessToken, final GraphJSONObjectCallback graphJSONObjectCallback) {
            return new GraphRequest(accessToken, "me", null, null, new Callback() { // from class: com.facebook.v
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.newMeRequest$lambda$0(graphJSONObjectCallback, graphResponse);
                }
            }, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newMyFriendsRequest(AccessToken accessToken, final GraphJSONArrayCallback graphJSONArrayCallback) {
            return new GraphRequest(accessToken, GraphRequest.MY_FRIENDS, null, null, new Callback() { // from class: com.facebook.GraphRequest$Companion$newMyFriendsRequest$wrapper$1
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (graphJSONArrayCallback != null) {
                        JSONObject jSONObject = response.getJSONObject();
                        graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, response);
                    }
                }
            }, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i3, int i4, String str, final GraphJSONArrayCallback graphJSONArrayCallback) {
            if (location == null && Utility.isNullOrEmpty(str)) {
                throw new FacebookException("Either location or searchText must be specified.");
            }
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", i4);
            if (location != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str2 = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
                bundle.putString("center", str2);
                bundle.putInt("distance", i3);
            }
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString("q", str);
            }
            return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new Callback() { // from class: com.facebook.u
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.newPlacesSearchRequest$lambda$1(graphJSONArrayCallback, graphResponse);
                }
            }, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback, null, 32, null);
            graphRequest.setGraphObject(jSONObject);
            return graphRequest;
        }

        @JvmStatic
        public final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String str, Bundle bundle, Callback callback) {
            return new GraphRequest(accessToken, str, bundle, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap image, String str2, Bundle bundle, Callback callback) {
            Intrinsics.checkNotNullParameter(image, "image");
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", image);
            if (str2 != null && str2.length() > 0) {
                bundle2.putString("caption", str2);
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        public final void runCallbacks$facebook_core_release(final GraphRequestBatch requests, List<GraphResponse> responses) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Intrinsics.checkNotNullParameter(responses, "responses");
            int size = requests.size();
            final ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                GraphRequest graphRequest = requests.get(i3);
                if (graphRequest.getCallback() != null) {
                    arrayList.add(new Pair(graphRequest.getCallback(), responses.get(i3)));
                }
            }
            if (arrayList.size() > 0) {
                Runnable runnable = new Runnable() { // from class: com.facebook.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphRequest.Companion.runCallbacks$lambda$2(arrayList, requests);
                    }
                };
                Handler callbackHandler = requests.getCallbackHandler();
                if (callbackHandler != null) {
                    callbackHandler.post(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch r12, java.net.HttpURLConnection r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        @JvmStatic
        public final void setDefaultBatchApplicationId(String str) {
            GraphRequest.defaultBatchApplicationId = str;
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(GraphRequest... requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return toHttpConnection(ArraysKt.toList(requests));
        }

        @JvmStatic
        public final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            for (GraphRequest graphRequest : requests) {
                if (HttpMethod.GET == graphRequest.getHttpMethod() && Utility.isNullOrEmpty(graphRequest.getParameters().getString("fields"))) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                    StringBuilder sb = new StringBuilder();
                    sb.append("GET requests for /");
                    String graphPath = graphRequest.getGraphPath();
                    if (graphPath == null) {
                        graphPath = "";
                    }
                    sb.append(graphPath);
                    sb.append(" should contain an explicit \"fields\" parameter.");
                    companion.log(loggingBehavior, 5, "Request", sb.toString());
                }
            }
        }

        public Companion() {
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAndWait(new GraphRequestBatch(requests));
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAsync(new GraphRequestBatch(requests));
        }

        @JvmStatic
        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            List<GraphResponse> listFromHttpConnection$facebook_core_release = GraphResponse.Companion.fromHttpConnection$facebook_core_release(connection, requests);
            Utility.disconnectQuietly(connection);
            int size = requests.size();
            if (size == listFromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(requests, listFromHttpConnection$facebook_core_release);
                AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
                return listFromHttpConnection$facebook_core_release;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(listFromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            throw new FacebookException(str);
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(connection, requests);
            requests.setCallbackHandler(handler);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmpty(requests, "requests");
            return toHttpConnection(new GraphRequestBatch(requests));
        }

        @JvmStatic
        public final List<GraphResponse> executeBatchAndWait(GraphRequestBatch requests) throws Throwable {
            Exception exc;
            HttpURLConnection httpConnection;
            List<GraphResponse> listExecuteConnectionAndWait;
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            HttpURLConnection httpURLConnection = null;
            try {
                httpConnection = toHttpConnection(requests);
                exc = null;
            } catch (Exception e3) {
                exc = e3;
                httpConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
            try {
                if (httpConnection != null) {
                    listExecuteConnectionAndWait = executeConnectionAndWait(httpConnection, requests);
                } else {
                    List<GraphResponse> listConstructErrorResponses = GraphResponse.Companion.constructErrorResponses(requests.getRequests(), null, new FacebookException(exc));
                    runCallbacks$facebook_core_release(requests, listConstructErrorResponses);
                    listExecuteConnectionAndWait = listConstructErrorResponses;
                }
                Utility.disconnectQuietly(httpConnection);
                return listExecuteConnectionAndWait;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpConnection;
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
        }

        @JvmStatic
        public final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(requests);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        @JvmStatic
        public final HttpURLConnection toHttpConnection(GraphRequestBatch requests) throws Throwable {
            URL url;
            Intrinsics.checkNotNullParameter(requests, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(requests);
            try {
                if (requests.size() == 1) {
                    url = new URL(requests.get(0).getUrlForSingleRequest());
                } else {
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnectionCreateConnection = null;
                try {
                    httpURLConnectionCreateConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(requests, httpURLConnectionCreateConnection);
                    return httpURLConnectionCreateConnection;
                } catch (IOException e3) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e3);
                } catch (JSONException e4) {
                    Utility.disconnectQuietly(httpURLConnectionCreateConnection);
                    throw new FacebookException("could not construct request body", e4);
                }
            } catch (MalformedURLException e5) {
                throw new FacebookException("could not construct URL for request", e5);
            }
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
            Intrinsics.checkNotNullParameter(file, "file");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", parcelFileDescriptorOpen);
            if (str2 != null && str2.length() > 0) {
                bundle2.putString("caption", str2);
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
        }

        @JvmStatic
        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
        }

        @JvmStatic
        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri photoUri, String str2, Bundle bundle, Callback callback) throws FacebookException, FileNotFoundException {
            Intrinsics.checkNotNullParameter(photoUri, "photoUri");
            if (Utility.isFileUri(photoUri)) {
                return newUploadPhotoRequest(accessToken, str, new File(photoUri.getPath()), str2, bundle, callback);
            }
            if (Utility.isContentUri(photoUri)) {
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                bundle2.putParcelable("picture", photoUri);
                if (str2 != null && str2.length() > 0) {
                    bundle2.putString("caption", str2);
                }
                return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, null, 32, null);
            }
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnProgressCallback extends Callback {
        void onProgress(long j3, long j4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public final String mimeType;
        public final RESOURCE resource;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType<?>>() { // from class: com.facebook.GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GraphRequest.ParcelableResourceWithMimeType<?> createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new GraphRequest.ParcelableResourceWithMimeType<>(source, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GraphRequest.ParcelableResourceWithMimeType<?>[] newArray(int i3) {
                return new GraphRequest.ParcelableResourceWithMimeType[i3];
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final RESOURCE getResource() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.mimeType);
            out.writeParcelable(this.resource, i3);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        public ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Serializer implements KeyValueSerializer {
        public boolean firstWrite;
        public final Logger logger;
        public final OutputStream outputStream;
        public final boolean useUrlEncode;

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(String format, Object... args) throws IOException {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (this.useUrlEncode) {
                OutputStream outputStream = this.outputStream;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                Locale locale = Locale.US;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                String strEncode = URLEncoder.encode(str, Utf8Charset.NAME);
                Intrinsics.checkNotNullExpressionValue(strEncode, "encode(String.format(Loc… format, *args), \"UTF-8\")");
                byte[] bytes = strEncode.getBytes(Charsets.f140510b);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            if (this.firstWrite) {
                OutputStream outputStream2 = this.outputStream;
                Charset charset = Charsets.f140510b;
                byte[] bytes2 = "--".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes2);
                OutputStream outputStream3 = this.outputStream;
                byte[] bytes3 = GraphRequest.MIME_BOUNDARY.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                outputStream3.write(bytes3);
                OutputStream outputStream4 = this.outputStream;
                byte[] bytes4 = "\r\n".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                this.firstWrite = false;
            }
            OutputStream outputStream5 = this.outputStream;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
            Object[] objArrCopyOf2 = Arrays.copyOf(args, args.length);
            String str2 = String.format(format, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            byte[] bytes5 = str2.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes5, "this as java.lang.String).getBytes(charset)");
            outputStream5.write(bytes5);
        }

        public final void writeBitmap(String key, Bitmap bitmap) throws IOException {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            writeContentDisposition(key, key, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                logger.appendKeyValue("    " + key, "<Image>");
            }
        }

        public final void writeBytes(String key, byte[] bytes) throws IOException {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            writeContentDisposition(key, key, "content/unknown");
            this.outputStream.write(bytes);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bytes.length)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                logger.appendKeyValue("    " + key, str);
            }
        }

        public final void writeContentDisposition(String str, String str2, String str3) throws IOException {
            if (this.useUrlEncode) {
                OutputStream outputStream = this.outputStream;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str4 = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                byte[] bytes = str4.getBytes(Charsets.f140510b);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", "Content-Type", str3);
            }
            writeLine("", new Object[0]);
        }

        public final void writeContentUri(String key, Uri contentUri, String str) throws IOException {
            int iCopyAndCloseInputStream;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(contentUri, "contentUri");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(contentUri));
                iCopyAndCloseInputStream = 0;
            } else {
                iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri), this.outputStream);
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
                logger.appendKeyValue("    " + key, str2);
            }
        }

        public final void writeLine(String format, Object... args) throws IOException {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            write(format, Arrays.copyOf(args, args.length));
            if (this.useUrlEncode) {
                return;
            }
            write("\r\n", new Object[0]);
        }

        public final void writeObject(String key, Object obj, GraphRequest graphRequest) throws IOException {
            Intrinsics.checkNotNullParameter(key, "key");
            Closeable closeable = this.outputStream;
            if (closeable instanceof RequestOutputStream) {
                Intrinsics.checkNotNull(closeable, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
                ((RequestOutputStream) closeable).setCurrentRequest(graphRequest);
            }
            Companion companion = GraphRequest.Companion;
            if (companion.isSupportedParameterType(obj)) {
                writeString(key, companion.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                writeBitmap(key, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                writeBytes(key, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                writeContentUri(key, (Uri) obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) obj, null);
                return;
            }
            if (!(obj instanceof ParcelableResourceWithMimeType)) {
                throw getInvalidTypeError();
            }
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
            Parcelable resource = parcelableResourceWithMimeType.getResource();
            String mimeType = parcelableResourceWithMimeType.getMimeType();
            if (resource instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) resource, mimeType);
            } else {
                if (!(resource instanceof Uri)) {
                    throw getInvalidTypeError();
                }
                writeContentUri(key, (Uri) resource, mimeType);
            }
        }

        public final void writeRecordBoundary() throws IOException {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream = this.outputStream;
            byte[] bytes = "&".getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeRequestsAsJson(String key, JSONArray requestJsonArray, Collection<GraphRequest> requests) throws JSONException, IOException {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(requestJsonArray, "requestJsonArray");
            Intrinsics.checkNotNullParameter(requests, "requests");
            Closeable closeable = this.outputStream;
            if (!(closeable instanceof RequestOutputStream)) {
                String string = requestJsonArray.toString();
                Intrinsics.checkNotNullExpressionValue(string, "requestJsonArray.toString()");
                writeString(key, string);
                return;
            }
            Intrinsics.checkNotNull(closeable, "null cannot be cast to non-null type com.facebook.RequestOutputStream");
            RequestOutputStream requestOutputStream = (RequestOutputStream) closeable;
            writeContentDisposition(key, null, null);
            write("[", new Object[0]);
            int i3 = 0;
            for (GraphRequest graphRequest : requests) {
                int i4 = i3 + 1;
                JSONObject jSONObject = requestJsonArray.getJSONObject(i3);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i3 > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i3 = i4;
            }
            write("]", new Object[0]);
            Logger logger = this.logger;
            if (logger != null) {
                String string2 = requestJsonArray.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "requestJsonArray.toString()");
                logger.appendKeyValue("    " + key, string2);
            }
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(String key, String value) throws IOException {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                logger.appendKeyValue("    " + key, value);
            }
        }

        public Serializer(OutputStream outputStream, Logger logger, boolean z2) {
            Intrinsics.checkNotNullParameter(outputStream, vfptEEmYY.ojjILcDTPEDNd);
            this.outputStream = outputStream;
            this.logger = logger;
            this.firstWrite = true;
            this.useUrlEncode = z2;
        }

        public final void writeFile(String str, ParcelFileDescriptor descriptor, String str2) throws IOException {
            int iCopyAndCloseInputStream;
            Intrinsics.checkNotNullParameter(str, rnFwbPAQmQTnL.ENNAwRYR);
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            OutputStream outputStream = this.outputStream;
            if (outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream).addProgress(descriptor.getStatSize());
                iCopyAndCloseInputStream = 0;
            } else {
                iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(descriptor), this.outputStream);
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str3 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                logger.appendKeyValue("    " + str, str3);
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt(11) + 30;
        for (int i3 = 0; i3 < iNextInt; i3++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        MIME_BOUNDARY = string;
        versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public GraphRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static final void _set_callback_$lambda$0(Callback callback, GraphResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        JSONObject jSONObject = response.getJSONObject();
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject(DEBUG_KEY) : null;
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray(DEBUG_MESSAGES_KEY) : null;
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i3);
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("message") : null;
                String strOptString2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("type") : null;
                String strOptString3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("link") : null;
                if (strOptString != null && strOptString2 != null) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if (Intrinsics.areEqual(strOptString2, DEBUG_SEVERITY_WARNING)) {
                        loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!Utility.isNullOrEmpty(strOptString3)) {
                        strOptString = strOptString + " Link: " + strOptString3;
                    }
                    Logger.Companion companion = Logger.Companion;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.log(loggingBehavior, TAG2, strOptString);
                }
            }
        }
        if (callback != null) {
            callback.onCompleted(response);
        }
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token") && Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
            Log.w(TAG, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
        }
        bundle.putString("sdk", "android");
        bundle.putString(FORMAT_PARAM, FORMAT_JSON);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_INFO);
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
    }

    private final String appendParametersToBaseUrl(String str, boolean z2) {
        if (!z2 && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            Companion companion = Companion;
            if (companion.isSupportedParameterType(obj)) {
                builderBuildUpon.appendQueryParameter(str2, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str3 = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                throw new IllegalArgumentException(str3);
            }
        }
        String string = builderBuildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uriBuilder.toString()");
        return string;
    }

    @JvmStatic
    public static final GraphResponse executeAndWait(GraphRequest graphRequest) {
        return Companion.executeAndWait(graphRequest);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAndWait(graphRequestBatch);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAsync(graphRequestBatch);
    }

    @JvmStatic
    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAndWait(httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(handler, httpURLConnection, graphRequestBatch);
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken.getToken();
                Logger.Companion.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        String applicationId = FacebookSdk.getApplicationId();
        String clientToken = FacebookSdk.getClientToken();
        if (applicationId.length() <= 0 || clientToken.length() <= 0) {
            Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            return null;
        }
        return applicationId + '|' + clientToken;
    }

    @JvmStatic
    public static final String getDefaultBatchApplicationId() {
        return Companion.getDefaultBatchApplicationId();
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    private final String getUrlWithGraphPath(String str) {
        if (!isValidGraphRequestForDomain()) {
            str = ServerProtocol.getFacebookGraphUrlBase();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("%s/%s", Arrays.copyOf(new Object[]{str, getGraphPathWithVersion()}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        return str2;
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("^/?");
        sb.append(FacebookSdk.getApplicationId());
        sb.append("/?.*");
        return this.forceApplicationRequest || Pattern.matches(sb.toString(), this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath);
    }

    private final boolean isValidGraphRequestForDomain() {
        if (Intrinsics.areEqual(FacebookSdk.getGraphDomain(), FacebookSdk.INSTAGRAM_COM)) {
            return !isApplicationRequest();
        }
        return true;
    }

    @JvmStatic
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken, context, callback);
    }

    @JvmStatic
    public static final GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
        return Companion.newDeleteObjectRequest(accessToken, str, callback);
    }

    @JvmStatic
    public static final GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
        return Companion.newGraphPathRequest(accessToken, str, callback);
    }

    @JvmStatic
    public static final GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
        return Companion.newMeRequest(accessToken, graphJSONObjectCallback);
    }

    @JvmStatic
    public static final GraphRequest newMyFriendsRequest(AccessToken accessToken, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newMyFriendsRequest(accessToken, graphJSONArrayCallback);
    }

    @JvmStatic
    public static final GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i3, int i4, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newPlacesSearchRequest(accessToken, location, i3, i4, str, graphJSONArrayCallback);
    }

    @JvmStatic
    public static final GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        return Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    public static final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String str, Bundle bundle, Callback callback) {
        return Companion.newPostRequestWithBundle(accessToken, str, bundle, callback);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
        return Companion.newUploadPhotoRequest(accessToken, str, bitmap, str2, bundle, callback);
    }

    @JvmStatic
    public static final void setDefaultBatchApplicationId(String str) {
        Companion.setDefaultBatchApplicationId(str);
    }

    private final boolean shouldForceClientTokenForRequest() {
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        boolean zA0 = accessTokenToUseForRequest != null ? StringsKt.a0(accessTokenToUseForRequest, "|", false, 2, null) : false;
        if (accessTokenToUseForRequest == null || !StringsKt.U(accessTokenToUseForRequest, "IG", false, 2, null) || zA0 || !isApplicationRequest()) {
            return (isValidGraphRequestForDomain() || zA0) ? false : true;
        }
        return true;
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        return Companion.toHttpConnection(graphRequestBatch);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return Companion.executeBatchAsync(this);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
        addCommonParameters();
        Uri uri = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format("%s?%s", Arrays.copyOf(new Object[]{uri.getPath(), uri.getQuery()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final String getUrlForSingleRequest() {
        String str = this.overriddenURL;
        if (str != null) {
            return String.valueOf(str);
        }
        String str2 = this.graphPath;
        String urlWithGraphPath = getUrlWithGraphPath((this.httpMethod == HttpMethod.POST && str2 != null && StringsKt.E(str2, VIDEOS_SUFFIX, false, 2, null)) ? ServerProtocol.getGraphVideoUrlBase() : ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain()));
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z2) {
        this.batchEntryOmitResultOnSuccess = z2;
    }

    public final void setCallback(final Callback callback) {
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback() { // from class: com.facebook.t
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest._set_callback_$lambda$0(callback, graphResponse);
                }
            };
        } else {
            this.callback = callback;
        }
    }

    public final void setForceApplicationRequest(boolean z2) {
        this.forceApplicationRequest = z2;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final void setParameters(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return string;
    }

    public GraphRequest(AccessToken accessToken) {
        this(accessToken, null, null, null, null, null, 62, null);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return Companion.executeBatchAndWait(collection);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return Companion.executeBatchAsync(collection);
    }

    @JvmStatic
    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return Companion.executeConnectionAndWait(httpURLConnection, collection);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(httpURLConnection, graphRequestBatch);
    }

    @JvmStatic
    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken, context, str, callback);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) throws FacebookException, FileNotFoundException {
        return Companion.newUploadPhotoRequest(accessToken, str, uri, str2, bundle, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            Logger.Companion.registerAccessToken(accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get(it.next());
            if (Companion.isSupportedAttachmentType(obj)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str3 = String.format(Locale.ROOT, vgWWUoTKYyuC.daSqtAMknTng, Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                arrayList.add(str3);
                map.put(str3, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.graphObject;
        if (jSONObject2 != null) {
            final ArrayList arrayList2 = new ArrayList();
            Companion.processGraphObject(jSONObject2, relativeUrlForBatchedRequest, new KeyValueSerializer() { // from class: com.facebook.GraphRequest.serializeToBatch.1
                @Override // com.facebook.GraphRequest.KeyValueSerializer
                public void writeString(String key, String value) throws IOException {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ArrayList<String> arrayList3 = arrayList2;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
                    String str4 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{key, URLEncoder.encode(value, Utf8Charset.NAME)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(locale, format, *args)");
                    arrayList3.add(str4);
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        return Companion.toHttpConnection(collection);
    }

    public final GraphResponse executeAndWait() {
        return Companion.executeAndWait(this);
    }

    public GraphRequest(AccessToken accessToken, String str) {
        this(accessToken, str, null, null, null, null, 60, null);
    }

    @JvmStatic
    public static final List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAndWait(graphRequestArr);
    }

    @JvmStatic
    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAsync(graphRequestArr);
    }

    @JvmStatic
    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
        return Companion.newUploadPhotoRequest(accessToken, str, file, str2, bundle, callback);
    }

    @JvmStatic
    public static final HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return Companion.toHttpConnection(graphRequestArr);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle) {
        this(accessToken, str, bundle, null, null, null, 56, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null, null, 48, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null, 32, null);
    }

    public /* synthetic */ GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : accessToken, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : bundle, (i3 & 8) != 0 ? null : httpMethod, (i3 & 16) != 0 ? null : callback, (i3 & 32) != 0 ? null : str2);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    public GraphRequest(AccessToken accessToken, URL overriddenURL) {
        Intrinsics.checkNotNullParameter(overriddenURL, "overriddenURL");
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.overriddenURL = overriddenURL.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }
}
