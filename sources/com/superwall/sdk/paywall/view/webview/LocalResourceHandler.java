package com.superwall.sdk.paywall.view.webview;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.paywall.view.webview.PaywallResource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalResourceHandler {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    private static final String SCHEME = "swlocal";
    private final Context context;
    private final Function0<Map<String, PaywallResource>> localResources;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalResourceHandler(Context context, Function0<? extends Map<String, ? extends PaywallResource>> localResources) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localResources, "localResources");
        this.context = context;
        this.localResources = localResources;
    }

    private final Map<String, String> corsHeaders() {
        return MapsKt.mapOf(TuplesKt.a("Access-Control-Allow-Origin", "*"));
    }

    private final WebResourceResponse errorResponse(int i3, String str, String str2) {
        Map<String, String> mapCorsHeaders = corsHeaders();
        byte[] bytes = str2.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new WebResourceResponse("text/plain", Utf8Charset.NAME, i3, str, mapCorsHeaders, new ByteArrayInputStream(bytes));
    }

    private final WebResourceResponse handleUri(String str, Uri uri) {
        String strResolveMimeType = resolveMimeType(uri);
        InputStream inputStreamOpenStreamOrError = openStreamOrError(str, uri);
        if (inputStreamOpenStreamOrError != null) {
            return successResponse(strResolveMimeType, inputStreamOpenStreamOrError);
        }
        return errorResponse(500, "Internal Error", "Failed to read resource: " + str);
    }

    private final String mimeTypeFromExtension(String str) {
        String mimeTypeFromExtension;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return (fileExtensionFromUrl == null || fileExtensionFromUrl.length() == 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl)) == null) ? DEFAULT_MIME_TYPE : mimeTypeFromExtension;
    }

    private final InputStream openStreamOrError(String str, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                return inputStreamOpenInputStream;
            }
            throw new IllegalStateException("ContentResolver returned null InputStream");
        } catch (Exception e3) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Failed to open local resource '" + str + "' at " + uri, (Map) null, e3, 8, (Object) null);
            return null;
        }
    }

    private final String resolveMimeType(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        if (type != null) {
            return type;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return mimeTypeFromExtension(string);
    }

    private final String resolveResourceMimeType(int i3, Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        if (type != null) {
            return type;
        }
        try {
            String resourceEntryName = this.context.getResources().getResourceEntryName(i3);
            Intrinsics.checkNotNull(resourceEntryName);
            return StringsKt.g1(resourceEntryName, '.', "").length() > 0 ? mimeTypeFromExtension(resourceEntryName) : DEFAULT_MIME_TYPE;
        } catch (Exception unused) {
            return DEFAULT_MIME_TYPE;
        }
    }

    private final WebResourceResponse successResponse(String str, InputStream inputStream) {
        return new WebResourceResponse(str, null, 200, "OK", corsHeaders(), inputStream);
    }

    public final WebResourceResponse handleRequest(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String host = url.getHost();
        if (host == null || host.length() == 0) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "swlocal:// URL has no resource ID: " + url, (Map) null, (Throwable) null, 24, (Object) null);
            return errorResponse(RCHTTPStatusCodes.BAD_REQUEST, "Bad Request", "Missing resource ID in swlocal:// URL");
        }
        PaywallResource paywallResource = (PaywallResource) ((Map) this.localResources.invoke()).get(host);
        if (paywallResource != null) {
            if (paywallResource instanceof PaywallResource.FromUri) {
                return handleUri(host, ((PaywallResource.FromUri) paywallResource).getUri());
            }
            if (paywallResource instanceof PaywallResource.FromResources) {
                return handleAndroidResource(host, ((PaywallResource.FromResources) paywallResource).getResId());
            }
            throw new NoWhenBranchMatchedException();
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "No local resource found for ID: " + host, (Map) null, (Throwable) null, 24, (Object) null);
        return errorResponse(404, "Not Found", "No local resource mapped for ID: " + host);
    }

    public final boolean isLocalResourceUrl(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return Intrinsics.areEqual(url.getScheme(), SCHEME);
    }

    private final WebResourceResponse handleAndroidResource(String str, int i3) {
        Uri uri = Uri.parse("android.resource://" + this.context.getPackageName() + "/" + i3);
        Intrinsics.checkNotNull(uri);
        String strResolveResourceMimeType = resolveResourceMimeType(i3, uri);
        try {
            InputStream inputStreamOpenRawResource = this.context.getResources().openRawResource(i3);
            Intrinsics.checkNotNull(inputStreamOpenRawResource);
            return successResponse(strResolveResourceMimeType, inputStreamOpenRawResource);
        } catch (Exception e3) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Failed to open Android resource '" + str + muQRKXGtpOhe.jWwagi + i3 + ")", (Map) null, e3, 8, (Object) null);
            return errorResponse(500, "Internal Error", "Failed to read resource: " + e3.getMessage());
        }
    }
}
