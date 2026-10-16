package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DOMStorage implements ChromeDevtoolsDomain {
    private final Context mContext;
    private final DOMStoragePeerManager mDOMStoragePeerManager;
    private final ObjectMapper mObjectMapper = new ObjectMapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DOMStorageAssignmentException extends Exception {
        public DOMStorageAssignmentException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DomStorageItemAddedParams {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String key;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String newValue;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public StorageId storageId;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DomStorageItemRemovedParams {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String key;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public StorageId storageId;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DomStorageItemUpdatedParams {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String key;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String newValue;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String oldValue;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public StorageId storageId;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DomStorageItemsClearedParams {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public StorageId storageId;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetDOMStorageItemsResult implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public List<List<String>> entries;

        private GetDOMStorageItemsResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StorageId {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public boolean isLocalStorage;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String securityOrigin;
    }

    public DOMStorage(Context context) {
        this.mContext = context;
        this.mDOMStoragePeerManager = new DOMStoragePeerManager(context);
    }

    private static void assignByType(SharedPreferences.Editor editor, String str, Object obj) throws IllegalArgumentException {
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else {
            if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
                return;
            }
            throw new IllegalArgumentException("Unsupported type=" + obj.getClass().getName());
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMStoragePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMStoragePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDOMStorageItems(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JSONException {
        StorageId storageId = (StorageId) this.mObjectMapper.convertValue(jSONObject.getJSONObject("storageId"), StorageId.class);
        ArrayList arrayList = new ArrayList();
        String str = storageId.securityOrigin;
        if (storageId.isLocalStorage) {
            for (Map.Entry<String, ?> entry : SharedPreferencesHelper.getSharedPreferenceEntriesSorted(this.mContext.getSharedPreferences(str, 0))) {
                ArrayList arrayList2 = new ArrayList(2);
                arrayList2.add(entry.getKey());
                arrayList2.add(SharedPreferencesHelper.valueToString(entry.getValue()));
                arrayList.add(arrayList2);
            }
        }
        GetDOMStorageItemsResult getDOMStorageItemsResult = new GetDOMStorageItemsResult();
        getDOMStorageItemsResult.entries = arrayList;
        return getDOMStorageItemsResult;
    }

    @ChromeDevtoolsMethod
    public void removeDOMStorageItem(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JSONException {
        StorageId storageId = (StorageId) this.mObjectMapper.convertValue(jSONObject.getJSONObject("storageId"), StorageId.class);
        String string = jSONObject.getString("key");
        if (storageId.isLocalStorage) {
            this.mContext.getSharedPreferences(storageId.securityOrigin, 0).edit().remove(string).apply();
        }
    }

    @ChromeDevtoolsMethod
    public void setDOMStorageItem(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JSONException, JsonRpcException {
        StorageId storageId = (StorageId) this.mObjectMapper.convertValue(jSONObject.getJSONObject("storageId"), StorageId.class);
        String string = jSONObject.getString("key");
        String string2 = jSONObject.getString("value");
        if (storageId.isLocalStorage) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(storageId.securityOrigin, 0);
            Object obj = sharedPreferences.getAll().get(string);
            try {
                if (obj != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    try {
                        assignByType(editorEdit, string, SharedPreferencesHelper.valueFromString(string2, obj));
                        editorEdit.apply();
                        return;
                    } catch (IllegalArgumentException unused) {
                        throw new DOMStorageAssignmentException(String.format(Locale.US, "Type mismatch setting %s to %s (expected %s)", string, string2, obj.getClass().getSimpleName()));
                    }
                }
                throw new DOMStorageAssignmentException("Unsupported: cannot add new key " + string + " due to lack of type inference");
            } catch (DOMStorageAssignmentException e3) {
                CLog.writeToConsole(this.mDOMStoragePeerManager, Console.MessageLevel.ERROR, Console.MessageSource.STORAGE, e3.getMessage());
                if (sharedPreferences.contains(string)) {
                    this.mDOMStoragePeerManager.signalItemUpdated(storageId, string, string2, SharedPreferencesHelper.valueToString(obj));
                } else {
                    this.mDOMStoragePeerManager.signalItemRemoved(storageId, string);
                }
            }
        }
    }
}
