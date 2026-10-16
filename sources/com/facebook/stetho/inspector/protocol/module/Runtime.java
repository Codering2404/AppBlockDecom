package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.LegacyTokenHelper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Runtime implements ChromeDevtoolsDomain {
    private static final Map<JsonRpcPeer, Session> sSessions = Collections.synchronizedMap(new HashMap());
    private final ObjectMapper mObjectMapper;
    private final RuntimeReplFactory mReplFactory;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CallArgument {

        @JsonProperty(required = false)
        public String objectId;

        @JsonProperty(required = false)
        public ObjectType type;

        @JsonProperty(required = false)
        public Object value;

        private CallArgument() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CallFunctionOnRequest {

        @JsonProperty
        public List<CallArgument> arguments;

        @JsonProperty(required = false)
        public Boolean doNotPauseOnExceptionsAndMuteConsole;

        @JsonProperty
        public String functionDeclaration;

        @JsonProperty(required = false)
        public Boolean generatePreview;

        @JsonProperty
        public String objectId;

        @JsonProperty(required = false)
        public Boolean returnByValue;

        private CallFunctionOnRequest() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CallFunctionOnResponse implements JsonRpcResult {

        @JsonProperty
        public RemoteObject result;

        @JsonProperty(required = false)
        public Boolean wasThrown;

        private CallFunctionOnResponse() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EvaluateRequest implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String expression;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String objectGroup;

        private EvaluateRequest() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EvaluateResponse implements JsonRpcResult {

        @JsonProperty
        public ExceptionDetails exceptionDetails;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public RemoteObject result;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public boolean wasThrown;

        private EvaluateResponse() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExceptionDetails {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String text;

        private ExceptionDetails() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetPropertiesRequest implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String objectId;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public boolean ownProperties;

        private GetPropertiesRequest() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GetPropertiesResponse implements JsonRpcResult {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public List<PropertyDescriptor> result;

        private GetPropertiesResponse() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ObjectProtoContainer {
        public final Object object;

        public ObjectProtoContainer(Object obj) {
            this.object = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ObjectSubType {
        ARRAY("array"),
        NULL("null"),
        NODE("node"),
        REGEXP("regexp"),
        DATE("date"),
        MAP("map"),
        SET("set"),
        ITERATOR("iterator"),
        GENERATOR("generator"),
        ERROR("error");

        private final String mProtocolValue;

        ObjectSubType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ObjectType {
        OBJECT("object"),
        FUNCTION("function"),
        UNDEFINED("undefined"),
        STRING(LegacyTokenHelper.TYPE_STRING),
        NUMBER("number"),
        BOOLEAN("boolean"),
        SYMBOL("symbol");

        private final String mProtocolValue;

        ObjectType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PropertyDescriptor {

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public final boolean configurable;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public final boolean enumerable;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public final boolean isOwn;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public String name;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public RemoteObject value;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public final boolean writable;

        private PropertyDescriptor() {
            this.isOwn = true;
            this.configurable = false;
            this.enumerable = true;
            this.writable = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RemoteObject {

        @JsonProperty
        public String className;

        @JsonProperty
        public String description;

        @JsonProperty
        public String objectId;

        @JsonProperty
        public ObjectSubType subtype;

        @JsonProperty(required = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
        public ObjectType type;

        @JsonProperty
        public Object value;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Session {
        private final ObjectMapper mObjectMapper;
        private final ObjectIdMapper mObjects;

        @Nullable
        private RuntimeRepl mRepl;

        private Session() {
            this.mObjects = new ObjectIdMapper();
            this.mObjectMapper = new ObjectMapper();
        }

        private List<?> arrayToList(Object obj) {
            Class<?> cls = obj.getClass();
            if (!cls.isArray()) {
                throw new IllegalArgumentException("Argument must be an array.  Was " + cls);
            }
            if (!cls.getComponentType().isPrimitive()) {
                return Arrays.asList((Object[]) obj);
            }
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(Array.get(obj, i3));
            }
            return arrayList;
        }

        private EvaluateResponse buildExceptionResponse(Object obj) {
            EvaluateResponse evaluateResponse = new EvaluateResponse();
            evaluateResponse.wasThrown = true;
            evaluateResponse.result = objectForRemote(obj);
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            evaluateResponse.exceptionDetails = exceptionDetails;
            exceptionDetails.text = obj.toString();
            return evaluateResponse;
        }

        private EvaluateResponse buildNormalResponse(Object obj) {
            EvaluateResponse evaluateResponse = new EvaluateResponse();
            evaluateResponse.wasThrown = false;
            evaluateResponse.result = objectForRemote(obj);
            return evaluateResponse;
        }

        private GetPropertiesResponse getPropertiesForIterable(Iterable<?> iterable, boolean z2) {
            int i3;
            String strValueOf;
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            for (Object obj : iterable) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                if (z2) {
                    i3 = i4 + 1;
                    strValueOf = String.valueOf(i4);
                } else {
                    i3 = i4;
                    strValueOf = null;
                }
                propertyDescriptor.name = strValueOf;
                propertyDescriptor.value = objectForRemote(obj);
                arrayList.add(propertyDescriptor);
                i4 = i3;
            }
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForMap(Object obj) {
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                propertyDescriptor.name = String.valueOf(entry.getKey());
                propertyDescriptor.value = objectForRemote(entry.getValue());
                arrayList.add(propertyDescriptor);
            }
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForObject(Object obj) {
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                ArrayList arrayList2 = new ArrayList(Arrays.asList(superclass.getDeclaredFields()));
                Collections.reverse(arrayList2);
                String str = superclass == obj.getClass() ? "" : superclass.getSimpleName() + ".";
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    Field field = (Field) obj2;
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        try {
                            Object obj3 = field.get(obj);
                            PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                            propertyDescriptor.name = str + field.getName();
                            propertyDescriptor.value = objectForRemote(obj3);
                            arrayList.add(propertyDescriptor);
                        } catch (IllegalAccessException e3) {
                            throw new RuntimeException(e3);
                        }
                    }
                }
            }
            Collections.reverse(arrayList);
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForProtoContainer(ObjectProtoContainer objectProtoContainer) {
            Object obj = objectProtoContainer.object;
            RemoteObject remoteObject = new RemoteObject();
            remoteObject.type = ObjectType.OBJECT;
            remoteObject.subtype = ObjectSubType.NODE;
            remoteObject.className = obj.getClass().getName();
            remoteObject.description = Runtime.getPropertyClassName(obj);
            remoteObject.objectId = String.valueOf(this.mObjects.putObject(obj));
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
            propertyDescriptor.name = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            propertyDescriptor.value = remoteObject;
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            ArrayList arrayList = new ArrayList(1);
            getPropertiesResponse.result = arrayList;
            arrayList.add(propertyDescriptor);
            return getPropertiesResponse;
        }

        @Nonnull
        private synchronized RuntimeRepl getRepl(RuntimeReplFactory runtimeReplFactory) {
            try {
                if (this.mRepl == null) {
                    this.mRepl = runtimeReplFactory.newInstance();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.mRepl;
        }

        public EvaluateResponse evaluate(RuntimeReplFactory runtimeReplFactory, JSONObject jSONObject) {
            EvaluateRequest evaluateRequest = (EvaluateRequest) this.mObjectMapper.convertValue(jSONObject, EvaluateRequest.class);
            try {
                return !evaluateRequest.objectGroup.equals("console") ? buildExceptionResponse("Not supported by FAB") : buildNormalResponse(getRepl(runtimeReplFactory).evaluate(evaluateRequest.expression));
            } catch (Throwable th) {
                return buildExceptionResponse(th);
            }
        }

        public Object getObjectOrThrow(String str) throws JsonRpcException {
            Object objectForId = getObjects().getObjectForId(Integer.parseInt(str));
            if (objectForId != null) {
                return objectForId;
            }
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_REQUEST, "No object found for " + str, null));
        }

        public ObjectIdMapper getObjects() {
            return this.mObjects;
        }

        public GetPropertiesResponse getProperties(JSONObject jSONObject) throws JsonRpcException {
            GetPropertiesRequest getPropertiesRequest = (GetPropertiesRequest) this.mObjectMapper.convertValue(jSONObject, GetPropertiesRequest.class);
            if (!getPropertiesRequest.ownProperties) {
                GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
                getPropertiesResponse.result = new ArrayList();
                return getPropertiesResponse;
            }
            Object objectOrThrow = getObjectOrThrow(getPropertiesRequest.objectId);
            if (objectOrThrow.getClass().isArray()) {
                objectOrThrow = arrayToList(objectOrThrow);
            }
            return objectOrThrow instanceof ObjectProtoContainer ? getPropertiesForProtoContainer((ObjectProtoContainer) objectOrThrow) : objectOrThrow instanceof List ? getPropertiesForIterable((List) objectOrThrow, true) : objectOrThrow instanceof Set ? getPropertiesForIterable((Set) objectOrThrow, false) : objectOrThrow instanceof Map ? getPropertiesForMap(objectOrThrow) : getPropertiesForObject(objectOrThrow);
        }

        public RemoteObject objectForRemote(Object obj) {
            RemoteObject remoteObject = new RemoteObject();
            if (obj == null) {
                remoteObject.type = ObjectType.OBJECT;
                remoteObject.subtype = ObjectSubType.NULL;
                remoteObject.value = JSONObject.NULL;
                return remoteObject;
            }
            if (obj instanceof Boolean) {
                remoteObject.type = ObjectType.BOOLEAN;
                remoteObject.value = obj;
                return remoteObject;
            }
            if (obj instanceof Number) {
                remoteObject.type = ObjectType.NUMBER;
                remoteObject.value = obj;
                return remoteObject;
            }
            if (obj instanceof Character) {
                remoteObject.type = ObjectType.NUMBER;
                remoteObject.value = Integer.valueOf(((Character) obj).charValue());
                return remoteObject;
            }
            if (obj instanceof String) {
                remoteObject.type = ObjectType.STRING;
                remoteObject.value = String.valueOf(obj);
                return remoteObject;
            }
            remoteObject.type = ObjectType.OBJECT;
            remoteObject.className = "What??";
            remoteObject.objectId = String.valueOf(this.mObjects.putObject(obj));
            if (obj.getClass().isArray()) {
                remoteObject.description = "array";
                return remoteObject;
            }
            if (obj instanceof List) {
                remoteObject.description = "List";
                return remoteObject;
            }
            if (obj instanceof Set) {
                remoteObject.description = "Set";
                return remoteObject;
            }
            if (obj instanceof Map) {
                remoteObject.description = "Map";
                return remoteObject;
            }
            remoteObject.description = Runtime.getPropertyClassName(obj);
            return remoteObject;
        }
    }

    @Deprecated
    public Runtime() {
        this(new RuntimeReplFactory() { // from class: com.facebook.stetho.inspector.protocol.module.Runtime.1
            @Override // com.facebook.stetho.inspector.console.RuntimeReplFactory
            public RuntimeRepl newInstance() {
                return new RuntimeRepl() { // from class: com.facebook.stetho.inspector.protocol.module.Runtime.1.1
                    @Override // com.facebook.stetho.inspector.console.RuntimeRepl
                    public Object evaluate(String str) throws Throwable {
                        return "Not supported with legacy Runtime module";
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPropertyClassName(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return simpleName.length() == 0 ? obj.getClass().getName() : simpleName;
    }

    @Nonnull
    private static synchronized Session getSession(final JsonRpcPeer jsonRpcPeer) {
        Session session;
        Map<JsonRpcPeer, Session> map = sSessions;
        session = map.get(jsonRpcPeer);
        if (session == null) {
            session = new Session();
            map.put(jsonRpcPeer, session);
            jsonRpcPeer.registerDisconnectReceiver(new DisconnectReceiver() { // from class: com.facebook.stetho.inspector.protocol.module.Runtime.2
                @Override // com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver
                public void onDisconnect() {
                    Runtime.sSessions.remove(jsonRpcPeer);
                }
            });
        }
        return session;
    }

    public static int mapObject(JsonRpcPeer jsonRpcPeer, Object obj) {
        return getSession(jsonRpcPeer).getObjects().putObject(obj);
    }

    public static void releaseObject(JsonRpcPeer jsonRpcPeer, Integer num) throws JSONException {
        getSession(jsonRpcPeer).getObjects().removeObjectById(num.intValue());
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult callFunctionOn(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        CallFunctionOnRequest callFunctionOnRequest = (CallFunctionOnRequest) this.mObjectMapper.convertValue(jSONObject, CallFunctionOnRequest.class);
        Session session = getSession(jsonRpcPeer);
        Object objectOrThrow = session.getObjectOrThrow(callFunctionOnRequest.objectId);
        if (!callFunctionOnRequest.functionDeclaration.startsWith("function protoList(")) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, "Expected protoList, got: " + callFunctionOnRequest.functionDeclaration, null));
        }
        ObjectProtoContainer objectProtoContainer = new ObjectProtoContainer(objectOrThrow);
        RemoteObject remoteObject = new RemoteObject();
        remoteObject.type = ObjectType.OBJECT;
        remoteObject.subtype = ObjectSubType.NODE;
        remoteObject.className = objectOrThrow.getClass().getName();
        remoteObject.description = getPropertyClassName(objectOrThrow);
        remoteObject.objectId = String.valueOf(session.getObjects().putObject(objectProtoContainer));
        CallFunctionOnResponse callFunctionOnResponse = new CallFunctionOnResponse();
        callFunctionOnResponse.result = remoteObject;
        callFunctionOnResponse.wasThrown = Boolean.FALSE;
        return callFunctionOnResponse;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult evaluate(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return getSession(jsonRpcPeer).evaluate(this.mReplFactory, jSONObject);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getProperties(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        return getSession(jsonRpcPeer).getProperties(jSONObject);
    }

    @ChromeDevtoolsMethod
    public void releaseObjectGroup(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        LogUtil.w("Ignoring request to releaseObjectGroup: " + jSONObject);
    }

    public Runtime(Context context) {
        this(new RhinoDetectingRuntimeReplFactory(context));
    }

    @ChromeDevtoolsMethod
    public void releaseObject(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JSONException {
        getSession(jsonRpcPeer).getObjects().removeObjectById(Integer.parseInt(jSONObject.getString("objectId")));
    }

    public Runtime(RuntimeReplFactory runtimeReplFactory) {
        this.mObjectMapper = new ObjectMapper();
        this.mReplFactory = runtimeReplFactory;
    }
}
