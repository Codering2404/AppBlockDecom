package com.facebook.share.internal;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.share.model.CameraEffectArguments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CameraEffectJSONUtility {
    public static final CameraEffectJSONUtility INSTANCE = new CameraEffectJSONUtility();
    private static final HashMap<Class<?>, Setter> SETTERS = MapsKt.hashMapOf(TuplesKt.a(String.class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$1
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            builder.putArgument(key, (String) obj);
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject json, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            json.put(key, obj);
        }
    }), TuplesKt.a(String[].class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$2
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(key, "key");
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject json, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            JSONArray jSONArray = new JSONArray();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
            for (String str : (String[]) obj) {
                jSONArray.put(str);
            }
            json.put(key, jSONArray);
        }
    }), TuplesKt.a(JSONArray.class, new Setter() { // from class: com.facebook.share.internal.CameraEffectJSONUtility$SETTERS$3
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject json, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String key, Object obj) throws JSONException {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj2 = jSONArray.get(i3);
                if (!(obj2 instanceof String)) {
                    throw new IllegalArgumentException(SbbqvQlxi.CEdjn + obj2.getClass());
                }
                arrayList.add(obj2);
            }
            builder.putArgument(key, (String[]) arrayList.toArray(new String[0]));
        }
    }));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    private CameraEffectJSONUtility() {
    }

    @JvmStatic
    public static final CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Object obj = jSONObject.get(key);
            if (obj != JSONObject.NULL) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter == null) {
                    throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                }
                Intrinsics.checkNotNullExpressionValue(key, "key");
                setter.setOnArgumentsBuilder(builder, key, obj);
            }
        }
        return builder.build();
    }

    @JvmStatic
    public static final JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter == null) {
                    throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                }
                setter.setOnJSON(jSONObject, str, obj);
            }
        }
        return jSONObject;
    }
}
