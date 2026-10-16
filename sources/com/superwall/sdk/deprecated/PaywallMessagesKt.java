package com.superwall.sdk.deprecated;

import android.net.Uri;
import com.applovin.sdk.AppLovinEventTypes;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.deprecated.PaywallMessage;
import com.superwall.sdk.deprecated.PaywallMessagesKt;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallMessagesKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final PaywallMessage parsePaywallMessage(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("event_name");
        if (string != null) {
            switch (string.hashCode()) {
                case -1349088399:
                    if (string.equals("custom")) {
                        String string2 = jSONObject.getString("data");
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        return new PaywallMessage.Custom(string2);
                    }
                    break;
                case -504306182:
                    if (string.equals("open_url")) {
                        return new PaywallMessage.OpenUrl(new URI(jSONObject.getString("url")));
                    }
                    break;
                case 3441010:
                    if (string.equals("ping")) {
                        String string3 = jSONObject.getString("version");
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        return new PaywallMessage.OnReady(string3);
                    }
                    break;
                case 94756344:
                    if (string.equals("close")) {
                        return PaywallMessage.Close.INSTANCE;
                    }
                    break;
                case 651675760:
                    if (string.equals("open_url_external")) {
                        return new PaywallMessage.OpenUrlInBrowser(new URI(jSONObject.getString("url")));
                    }
                    break;
                case 1097519758:
                    if (string.equals("restore")) {
                        return PaywallMessage.Restore.INSTANCE;
                    }
                    break;
                case 1743324417:
                    if (string.equals("purchase")) {
                        String string4 = jSONObject.getString(AppLovinEventTypes.USER_VIEWED_PRODUCT);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        return new PaywallMessage.Purchase(string4);
                    }
                    break;
                case 2097998776:
                    if (string.equals("open_deep_link")) {
                        Uri uri = Uri.parse(jSONObject.getString("link"));
                        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                        return new PaywallMessage.OpenDeepLink(uri);
                    }
                    break;
            }
        }
        throw new IllegalArgumentException("Unknown event name: " + string);
    }

    public static final WrappedPaywallMessages parseWrappedPaywallMessages(String jsonString) throws JSONException {
        Either failure;
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "SWWebViewInterface:" + jsonString, (Map) null, (Throwable) null, 24, (Object) null);
        JSONObject jSONObject = new JSONObject(jsonString);
        int iOptInt = jSONObject.optInt("version", 1);
        JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("events");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            try {
                Intrinsics.checkNotNull(jSONObject2);
                failure = new Either.Success(Boolean.valueOf(arrayList.add(parsePaywallMessage(jSONObject2))));
            } catch (Throwable th) {
                if (ErrorTrackingKt.shouldLog(th)) {
                    Superwall.Companion companion = Superwall.Companion;
                    if (companion.getInitialized()) {
                        ErrorTrackingKt.trackError(companion.getInstance(), th);
                    }
                }
                failure = new Either.Failure(th);
            }
            EitherKt.onError(failure, new Function1() { // from class: c0.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PaywallMessagesKt.parseWrappedPaywallMessages$lambda$1((Throwable) obj);
                }
            });
        }
        return new WrappedPaywallMessages(iOptInt, new PayloadMessages(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseWrappedPaywallMessages$lambda$1(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.printStackTrace();
        return Unit.f139807a;
    }
}
