package com.appsflyer.internal;

import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1gSDK extends AFd1lSDK<Map<String, String>> {
    public AFa1vSDK AFLogger;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private final AFc1oSDK afErrorLogForExcManagerOnly;
    private final boolean afWarnLog;
    private String getLevel;
    private final UUID onInstallConversionDataLoadedNative;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AFa1vSDK {
        void AFInAppEventType(Map<String, String> map);

        void valueOf(String str);
    }

    public AFd1gSDK(AFc1ySDK aFc1ySDK, UUID uuid, Uri uri) throws Throwable {
        super(AFd1tSDK.ONELINK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, uuid.toString());
        this.afErrorLogForExcManagerOnly = aFc1ySDK.valueOf();
        this.onInstallConversionDataLoadedNative = uuid;
        boolean zBooleanValue = false;
        try {
            if (!AFb1tSDK.AFKeystoreWrapper(uri.getHost()) && !AFb1tSDK.AFKeystoreWrapper(uri.getPath())) {
                try {
                    try {
                        Object objInvoke = ((Class) AFb1mSDK.values(KeyEvent.getDeadChar(0, 0) + 37, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (-1) - TextUtils.lastIndexOf("", '0', 0, 0))).getMethod("AFInAppEventType", null).invoke(((Class) AFb1mSDK.values(37 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16), View.resolveSizeAndState(0, 0, 0))).getDeclaredConstructor(Uri.class, AFb1sSDK.class).newInstance(uri, aFc1ySDK.onInstallConversionDataLoadedNative()), null);
                        try {
                            boolean zBooleanValue2 = ((Boolean) ((Class) AFb1mSDK.values(53 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 37 - Drawable.resolveOpacity(0, 0))).getMethod("valueOf", null).invoke(objInvoke, null)).booleanValue();
                            try {
                                zBooleanValue = ((Boolean) ((Class) AFb1mSDK.values(AndroidCharacter.getMirror('0') + 4, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 37)).getMethod("AFInAppEventParameterName", null).invoke(objInvoke, null)).booleanValue();
                                String[] strArrSplit = uri.getPath().split("/");
                                if (zBooleanValue2 && strArrSplit.length == 3) {
                                    this.AFLogger$LogLevel = strArrSplit[1];
                                    this.AFVersionDeclaration = strArrSplit[2];
                                    this.getLevel = uri.toString();
                                }
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("OneLinkValidator: reflection init failed", e3);
        }
        this.afWarnLog = zBooleanValue;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final boolean AFLogger$LogLevel() {
        return (TextUtils.isEmpty(this.AFLogger$LogLevel) || TextUtils.isEmpty(this.AFVersionDeclaration) || this.AFLogger$LogLevel.equals("app")) ? false : true;
    }

    public final boolean AFVersionDeclaration() {
        return this.afWarnLog;
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
    public final boolean valueOf() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        ResponseNetwork responseNetwork;
        super.values();
        AFa1vSDK aFa1vSDK = this.AFLogger;
        if (aFa1vSDK != null) {
            if (this.AFKeystoreWrapper == AFc1bSDK.SUCCESS && (responseNetwork = ((AFd1lSDK) this).afDebugLog) != null) {
                aFa1vSDK.AFInAppEventType((Map) responseNetwork.getBody());
                return;
            }
            Throwable thAfInfoLog = afInfoLog();
            if (!(thAfInfoLog instanceof ParsingException)) {
                String str = this.getLevel;
                aFa1vSDK.valueOf(str != null ? str : "Can't get OneLink data");
            } else if (((ParsingException) thAfInfoLog).getRawResponse().isSuccessful()) {
                aFa1vSDK.valueOf("Can't parse one link data");
            } else {
                String str2 = this.getLevel;
                aFa1vSDK.valueOf(str2 != null ? str2 : "Can't get OneLink data");
            }
        }
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<Map<String, String>> AFInAppEventType(String str) {
        return this.afErrorLogForExcManagerOnly.AFInAppEventType(this.AFLogger$LogLevel, this.AFVersionDeclaration, this.onInstallConversionDataLoadedNative, str);
    }
}
