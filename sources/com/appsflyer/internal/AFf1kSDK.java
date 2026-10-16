package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1kSDK extends AFf1pSDK {
    private final AFc1ySDK AFKeystoreWrapper;

    public AFf1kSDK(Runnable runnable, AFc1ySDK aFc1ySDK) {
        super(ProductResponseJsonKeys.STORE, "samsung", runnable);
        this.AFKeystoreWrapper = aFc1ySDK;
    }

    @Override // com.appsflyer.internal.AFf1jSDK
    public final void valueOf(Context context) {
        valueOf(this.AFKeystoreWrapper.AFKeystoreWrapper(), new AFb1kSDK<Map<String, Object>>(context, this.AFKeystoreWrapper, "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") { // from class: com.appsflyer.internal.AFf1kSDK.1
            private static void AFInAppEventType(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1 || (string = cursor.getString(columnIndex)) == null) {
                    return;
                }
                map.put(str, string);
            }

            private static void valueOf(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return;
                }
                long j3 = cursor.getLong(columnIndex);
                if (j3 == 0) {
                    return;
                }
                map.put(str, Long.valueOf(j3));
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.appsflyer.internal.AFb1kSDK
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> AFKeystoreWrapper() {
                String string;
                Cursor cursorQuery = null;
                try {
                    try {
                        ContentResolver contentResolver = this.valueOf.getContentResolver();
                        StringBuilder sb = new StringBuilder("content://");
                        sb.append(this.AFKeystoreWrapper);
                        cursorQuery = contentResolver.query(Uri.parse(sb.toString()), null, null, null, null);
                        if (cursorQuery == null) {
                            AFf1kSDK.this.valueOf.put("response", "SERVICE_UNAVAILABLE");
                        } else if (cursorQuery.moveToFirst()) {
                            AFf1kSDK.this.valueOf.put("response", "OK");
                            AFInAppEventType("referrer", AFf1kSDK.this.valueOf, cursorQuery);
                            valueOf("click_ts", AFf1kSDK.this.valueOf, cursorQuery);
                            valueOf(jlWo.OnBu, AFf1kSDK.this.valueOf, cursorQuery);
                            valueOf("install_end_ts", AFf1kSDK.this.valueOf, cursorQuery);
                            AFInAppEventType("organic_keywords", AFf1kSDK.this.valueOf, cursorQuery);
                            AFInAppEventType("attr_type", AFf1kSDK.this.valueOf, cursorQuery);
                            HashMap map = new HashMap();
                            int columnIndex = cursorQuery.getColumnIndex("instant");
                            if (columnIndex != -1 && (string = cursorQuery.getString(columnIndex)) != null) {
                                map.put("instant", Boolean.valueOf(Boolean.parseBoolean(string)));
                            }
                            valueOf("click_server_ts", map, cursorQuery);
                            valueOf("install_begin_server_ts", map, cursorQuery);
                            AFInAppEventType("install_version", map, cursorQuery);
                            if (!map.isEmpty()) {
                                AFf1kSDK.this.valueOf.put("custom", map);
                            }
                        } else {
                            AFf1kSDK.this.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
                        }
                    } catch (Exception e3) {
                        AFf1kSDK.this.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
                        AFLogger.afErrorLog(e3.getMessage(), e3);
                        if (0 != 0) {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    String str = ((PackageItemInfo) this.valueOf.getPackageManager().resolveContentProvider(this.AFKeystoreWrapper, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).packageName;
                    AFf1kSDK.this.valueOf.put("api_ver", Long.valueOf(AFa1fSDK.AFInAppEventParameterName(this.valueOf, str)));
                    AFf1kSDK.this.valueOf.put("api_ver_name", AFa1fSDK.AFKeystoreWrapper(this.valueOf, str));
                    AFf1kSDK.this.AFKeystoreWrapper();
                    return AFf1kSDK.this.valueOf;
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
