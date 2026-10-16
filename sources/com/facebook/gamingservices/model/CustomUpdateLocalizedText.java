package com.facebook.gamingservices.model;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomUpdateLocalizedText {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final String f0default;
    private final HashMap<String, String> localizations;

    public CustomUpdateLocalizedText(String str, HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "default");
        this.f0default = str;
        this.localizations = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = customUpdateLocalizedText.f0default;
        }
        if ((i3 & 2) != 0) {
            map = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, map);
    }

    public final String component1() {
        return this.f0default;
    }

    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    public final CustomUpdateLocalizedText copy(String str, HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "default");
        return new CustomUpdateLocalizedText(str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) obj;
        return Intrinsics.areEqual(this.f0default, customUpdateLocalizedText.f0default) && Intrinsics.areEqual(this.localizations, customUpdateLocalizedText.localizations);
    }

    public final String getDefault() {
        return this.f0default;
    }

    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public int hashCode() {
        int iHashCode = this.f0default.hashCode() * 31;
        HashMap<String, String> map = this.localizations;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("default", this.f0default);
        HashMap<String, String> map = this.localizations;
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("localizations", jSONObject2);
        }
        return jSONObject;
    }

    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.f0default + ", localizations=" + this.localizations + ')';
    }

    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : map);
    }
}
