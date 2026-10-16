package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.internal.AttributionIdentifiers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AFa1dSDK extends AFb1kSDK<String> {
    AFa1dSDK(Context context, AFc1ySDK aFc1ySDK) {
        super(context, aFc1ySDK, AttributionIdentifiers.ATTRIBUTION_ID_CONTENT_PROVIDER, "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFb1kSDK
    /* JADX INFO: renamed from: AFInAppEventType, reason: merged with bridge method [inline-methods] */
    public String AFKeystoreWrapper() throws Throwable {
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = this.valueOf.getContentResolver();
            StringBuilder sb = new StringBuilder("content://");
            sb.append(this.AFKeystoreWrapper);
            Cursor cursorQuery = contentResolver.query(Uri.parse(sb.toString()), new String[]{"aid"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("aid"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.appsflyer.internal.AFb1kSDK
    public final /* synthetic */ String AFInAppEventParameterName() {
        this.values.AFInAppEventType().execute(this.AFInAppEventType);
        return (String) super.AFInAppEventParameterName();
    }

    public final String values() {
        this.values.AFInAppEventType().execute(this.AFInAppEventType);
        return (String) super.AFInAppEventParameterName();
    }
}
