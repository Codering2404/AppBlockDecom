package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1oSDK extends AFf1pSDK {
    private final AFc1ySDK AFInAppEventType;

    public AFf1oSDK(Runnable runnable, AFc1ySDK aFc1ySDK) {
        super(ProductResponseJsonKeys.STORE, "huawei", runnable);
        this.AFInAppEventType = aFc1ySDK;
    }

    @Override // com.appsflyer.internal.AFf1jSDK
    public final void valueOf(Context context) {
        valueOf(this.AFInAppEventType.AFKeystoreWrapper(), new AFb1kSDK<Map<String, Object>>(context, this.AFInAppEventType, "com.huawei.appmarket.commondata", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F") { // from class: com.appsflyer.internal.AFf1oSDK.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.appsflyer.internal.AFb1kSDK
            /* JADX INFO: renamed from: AFInAppEventType, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> AFKeystoreWrapper() {
                String str = ((PackageItemInfo) this.valueOf.getPackageManager().resolveContentProvider(this.AFKeystoreWrapper, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).packageName;
                AFf1oSDK.this.valueOf.put("api_ver", Long.valueOf(AFa1fSDK.AFInAppEventParameterName(this.valueOf, str)));
                AFf1oSDK.this.valueOf.put("api_ver_name", AFa1fSDK.AFKeystoreWrapper(this.valueOf, str));
                Cursor cursorQuery = null;
                try {
                    try {
                        ContentResolver contentResolver = this.valueOf.getContentResolver();
                        StringBuilder sb = new StringBuilder("content://");
                        sb.append(this.AFKeystoreWrapper);
                        sb.append("/item/5");
                        cursorQuery = contentResolver.query(Uri.parse(sb.toString()), null, null, new String[]{this.valueOf.getPackageName()}, null);
                        if (cursorQuery == null) {
                            AFf1oSDK.this.valueOf.put("response", "SERVICE_UNAVAILABLE");
                        } else if (cursorQuery.moveToFirst()) {
                            AFf1oSDK.this.valueOf.put("response", "OK");
                            AFf1oSDK.this.valueOf.put("referrer", cursorQuery.getString(0));
                            AFf1oSDK.this.valueOf.put("click_ts", Long.valueOf(cursorQuery.getLong(1)));
                            AFf1oSDK.this.valueOf.put("install_end_ts", Long.valueOf(cursorQuery.getLong(2)));
                            if (cursorQuery.getColumnCount() > 3) {
                                AFf1oSDK.this.valueOf.put("install_begin_ts", Long.valueOf(cursorQuery.getLong(3)));
                                HashMap map = new HashMap();
                                String string = cursorQuery.getString(4);
                                if (string != null) {
                                    map.put("track_id", string);
                                }
                                map.put("referrer_ex", cursorQuery.getString(5));
                                AFf1oSDK.this.valueOf.put("huawei_custom", map);
                            }
                        } else {
                            AFf1oSDK.this.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
                        }
                    } catch (Exception e3) {
                        AFf1oSDK.this.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
                        AFLogger.afErrorLog(e3.getMessage(), e3);
                        if (0 != 0) {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    AFf1oSDK.this.AFKeystoreWrapper();
                    return AFf1oSDK.this.valueOf;
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
        });
    }
}
