package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1qSDK extends AFd1lSDK<String> {
    private final AFb1gSDK AFLogger;
    private final String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration;
    private final LinkGenerator.ResponseListener afErrorLogForExcManagerOnly;
    private final String afWarnLog;
    private final UUID getLevel;

    public AFd1qSDK(AFc1ySDK aFc1ySDK, UUID uuid, String str, Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener) {
        super(AFd1tSDK.ONELINK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, uuid.toString());
        this.AFLogger = aFc1ySDK.AFInAppEventParameterName();
        this.getLevel = uuid;
        this.afWarnLog = str;
        this.AFVersionDeclaration = new HashMap(map);
        this.afErrorLogForExcManagerOnly = responseListener;
        this.AFLogger$LogLevel = str2;
    }

    private String AFVersionDeclaration() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN);
        String packageName = this.AFLogger.values.values.getPackageName();
        LinkGenerator linkGeneratorAddParameters = new LinkGenerator("af_app_invites").setBaseURL(this.afWarnLog, string, packageName).addParameter("af_siteid", packageName).addParameters(this.AFVersionDeclaration);
        AFa1bSDK.values();
        String strAFInAppEventType = AFa1bSDK.AFInAppEventType();
        if (strAFInAppEventType != null) {
            linkGeneratorAddParameters.setReferrerCustomerId(strAFInAppEventType);
        }
        return linkGeneratorAddParameters.generateLink();
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afWarnLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        ResponseNetwork responseNetwork;
        super.values();
        LinkGenerator.ResponseListener responseListener = this.afErrorLogForExcManagerOnly;
        if (responseListener != null) {
            if (this.AFKeystoreWrapper == AFc1bSDK.SUCCESS && (responseNetwork = ((AFd1lSDK) this).afDebugLog) != null) {
                responseListener.onResponse((String) responseNetwork.getBody());
                return;
            }
            Throwable thAfInfoLog = afInfoLog();
            if (!(thAfInfoLog instanceof ParsingException)) {
                responseListener.onResponse(AFVersionDeclaration());
            } else if (((ParsingException) thAfInfoLog).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(AFVersionDeclaration());
            }
        }
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) {
        return ((AFd1lSDK) this).afErrorLog.AFInAppEventType(this.afWarnLog, this.AFVersionDeclaration, this.AFLogger$LogLevel, this.getLevel, str);
    }
}
