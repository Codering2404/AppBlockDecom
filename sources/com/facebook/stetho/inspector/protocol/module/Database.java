package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Database implements ChromeDevtoolsDomain {
    private static final int MAX_BLOB_LENGTH = 512;
    private static final int MAX_EXECUTE_RESULTS = 250;
    private static final String UNKNOWN_BLOB_LABEL = "{blob}";
    private final ChromePeerManager mChromePeerManager;
    private List<DatabaseDriver2> mDatabaseDrivers = new ArrayList();
    private final ObjectMapper mObjectMapper;
    private final DatabasePeerRegistrationListener mPeerListener;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class AddDatabaseEvent {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public DatabaseObject database;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DatabaseDescriptorHolder {
        public final DatabaseDescriptor descriptor;
        public final DatabaseDriver2 driver;

        public DatabaseDescriptorHolder(DatabaseDriver2 databaseDriver2, DatabaseDescriptor databaseDescriptor) {
            this.driver = databaseDriver2;
            this.descriptor = databaseDescriptor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static abstract class DatabaseDriver extends BaseDatabaseDriver<String> {
        public DatabaseDriver(Context context) {
            super(context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DatabaseObject {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String domain;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String id;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String name;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String version;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DatabasePeerRegistrationListener extends PeersRegisteredListener {
        private final List<DatabaseDriver2> mDatabaseDrivers;
        private final SparseArray<DatabaseDescriptorHolder> mDatabaseHolders;
        private final ObjectIdMapper mDatabaseIdMapper;

        public DatabaseDescriptorHolder getDatabaseDescriptorHolder(String str) {
            return this.mDatabaseHolders.get(Integer.parseInt(str));
        }

        @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
        protected synchronized void onFirstPeerRegistered() {
            for (DatabaseDriver2 databaseDriver2 : this.mDatabaseDrivers) {
                for (DESC desc : databaseDriver2.getDatabaseNames()) {
                    if (this.mDatabaseIdMapper.getIdForObject(desc) == null) {
                        this.mDatabaseHolders.put(this.mDatabaseIdMapper.putObject(desc), new DatabaseDescriptorHolder(databaseDriver2, desc));
                    }
                }
            }
        }

        @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
        protected synchronized void onLastPeerUnregistered() {
            this.mDatabaseIdMapper.clear();
            this.mDatabaseHolders.clear();
        }

        @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
        protected synchronized void onPeerAdded(JsonRpcPeer jsonRpcPeer) {
            int size = this.mDatabaseHolders.size();
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = this.mDatabaseHolders.keyAt(i3);
                DatabaseDescriptorHolder databaseDescriptorHolderValueAt = this.mDatabaseHolders.valueAt(i3);
                DatabaseObject databaseObject = new DatabaseObject();
                databaseObject.id = String.valueOf(iKeyAt);
                databaseObject.name = databaseDescriptorHolderValueAt.descriptor.name();
                databaseObject.domain = databaseDescriptorHolderValueAt.driver.getContext().getPackageName();
                databaseObject.version = "N/A";
                AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
                addDatabaseEvent.database = databaseObject;
                jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, null);
            }
        }

        @Override // com.facebook.stetho.inspector.helper.PeersRegisteredListener
        protected synchronized void onPeerRemoved(JsonRpcPeer jsonRpcPeer) {
        }

        private DatabasePeerRegistrationListener(List<DatabaseDriver2> list) {
            this.mDatabaseHolders = new SparseArray<>();
            this.mDatabaseIdMapper = new ObjectIdMapper();
            this.mDatabaseDrivers = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Error {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public int code;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String message;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ExecuteSQLRequest {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String databaseId;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String query;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ExecuteSQLResponse implements JsonRpcResult {

        @JsonProperty
        public List<String> columnNames;

        @JsonProperty
        public Error sqlError;

        @JsonProperty
        public List<String> values;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetDatabaseTableNamesRequest {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    public Database() {
        ChromePeerManager chromePeerManager = new ChromePeerManager();
        this.mChromePeerManager = chromePeerManager;
        DatabasePeerRegistrationListener databasePeerRegistrationListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers);
        this.mPeerListener = databasePeerRegistrationListener;
        chromePeerManager.setListener(databasePeerRegistrationListener);
        this.mObjectMapper = new ObjectMapper();
    }

    private static String blobToString(byte[] bArr) {
        if (bArr.length > MAX_BLOB_LENGTH || !fastIsAscii(bArr)) {
            return UNKNOWN_BLOB_LABEL;
        }
        try {
            return new String(bArr, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return UNKNOWN_BLOB_LABEL;
        }
    }

    private static boolean fastIsAscii(byte[] bArr) {
        for (byte b3 : bArr) {
            if ((b3 & (-128)) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<String> flattenRows(Cursor cursor, int i3) {
        Util.throwIfNot(i3 >= 0);
        ArrayList<String> arrayList = new ArrayList<>();
        int columnCount = cursor.getColumnCount();
        for (int i4 = 0; i4 < i3 && cursor.moveToNext(); i4++) {
            for (int i5 = 0; i5 < columnCount; i5++) {
                int type = cursor.getType(i5);
                if (type == 0) {
                    arrayList.add(null);
                } else if (type == 1) {
                    arrayList.add(String.valueOf(cursor.getLong(i5)));
                } else if (type == 2) {
                    arrayList.add(String.valueOf(cursor.getDouble(i5)));
                } else if (type != 4) {
                    arrayList.add(cursor.getString(i5));
                } else {
                    arrayList.add(blobToString(cursor.getBlob(i5)));
                }
            }
        }
        if (!cursor.isAfterLast()) {
            for (int i6 = 0; i6 < columnCount; i6++) {
                arrayList.add("{truncated}");
            }
        }
        return arrayList;
    }

    public void add(DatabaseDriver2 databaseDriver2) {
        this.mDatabaseDrivers.add(databaseDriver2);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.mObjectMapper.convertValue(jSONObject, ExecuteSQLRequest.class);
        DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(executeSQLRequest.databaseId);
        try {
            return databaseDescriptorHolder.driver.executeSQL(databaseDescriptorHolder.descriptor, executeSQLRequest.query, new BaseDatabaseDriver.ExecuteResultHandler<ExecuteSQLResponse>() { // from class: com.facebook.stetho.inspector.protocol.module.Database.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler
                public ExecuteSQLResponse handleInsert(long j3) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
                    executeSQLResponse.values = Collections.singletonList(String.valueOf(j3));
                    return executeSQLResponse;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler
                public ExecuteSQLResponse handleRawQuery() throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList(GraphResponse.SUCCESS_KEY);
                    executeSQLResponse.values = Collections.singletonList(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    return executeSQLResponse;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler
                public ExecuteSQLResponse handleSelect(Cursor cursor) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Arrays.asList(cursor.getColumnNames());
                    executeSQLResponse.values = Database.flattenRows(cursor, Database.MAX_EXECUTE_RESULTS);
                    return executeSQLResponse;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler
                public ExecuteSQLResponse handleUpdateDelete(int i3) throws SQLiteException {
                    ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
                    executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
                    executeSQLResponse.values = Collections.singletonList(String.valueOf(i3));
                    return executeSQLResponse;
                }
            });
        } catch (RuntimeException e3) {
            LogUtil.e(e3, "Exception executing: %s", executeSQLRequest.query);
            Error error = new Error();
            error.code = 0;
            error.message = e3.getMessage();
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.sqlError = error;
            return executeSQLResponse;
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        DatabaseDescriptorHolder databaseDescriptorHolder = this.mPeerListener.getDatabaseDescriptorHolder(((GetDatabaseTableNamesRequest) this.mObjectMapper.convertValue(jSONObject, GetDatabaseTableNamesRequest.class)).databaseId);
        try {
            GetDatabaseTableNamesResponse getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
            getDatabaseTableNamesResponse.tableNames = databaseDescriptorHolder.driver.getTableNames(databaseDescriptorHolder.descriptor);
            return getDatabaseTableNamesResponse;
        } catch (SQLiteException e3) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_REQUEST, e3.toString(), null));
        }
    }
}
