package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ClearKeyUtil {
    public static byte[] a(byte[] bArr) {
        return Util.f41609a >= 27 ? bArr : Util.t0(c(Util.K(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (Util.f41609a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(Util.K(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (i3 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return Util.t0(sb.toString());
        } catch (JSONException e3) {
            Log.e("ClearKeyUtil", "Failed to adjust response data: " + Util.K(bArr), e3);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
