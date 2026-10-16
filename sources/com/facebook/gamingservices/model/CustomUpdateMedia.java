package com.facebook.gamingservices.model;

import com.facebook.internal.AnalyticsEvents;
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
public final class CustomUpdateMedia {
    private final CustomUpdateMediaInfo gif;
    private final CustomUpdateMediaInfo video;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomUpdateMedia() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia, CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customUpdateMediaInfo = customUpdateMedia.gif;
        }
        if ((i3 & 2) != 0) {
            customUpdateMediaInfo2 = customUpdateMedia.video;
        }
        return customUpdateMedia.copy(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    public final CustomUpdateMedia copy(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        return new CustomUpdateMedia(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateMedia)) {
            return false;
        }
        CustomUpdateMedia customUpdateMedia = (CustomUpdateMedia) obj;
        return Intrinsics.areEqual(this.gif, customUpdateMedia.gif) && Intrinsics.areEqual(this.video, customUpdateMedia.video);
    }

    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    public int hashCode() {
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        int iHashCode = (customUpdateMediaInfo == null ? 0 : customUpdateMediaInfo.hashCode()) * 31;
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        return iHashCode + (customUpdateMediaInfo2 != null ? customUpdateMediaInfo2.hashCode() : 0);
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        if (customUpdateMediaInfo != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", customUpdateMediaInfo.getUrl());
            jSONObject.put("gif", jSONObject2);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", customUpdateMediaInfo2.getUrl());
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, jSONObject3);
        }
        return jSONObject;
    }

    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + ')';
    }

    public CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        this.gif = customUpdateMediaInfo;
        this.video = customUpdateMediaInfo2;
    }

    public /* synthetic */ CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : customUpdateMediaInfo, (i3 & 2) != 0 ? null : customUpdateMediaInfo2);
    }
}
