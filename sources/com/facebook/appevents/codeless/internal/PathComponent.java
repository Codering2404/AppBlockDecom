package com.facebook.appevents.codeless.internal;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PathComponent {
    public static final Companion Companion = new Companion(null);
    private static final String PATH_CLASS_NAME_KEY = "class_name";
    private static final String PATH_DESCRIPTION_KEY = "description";
    private static final String PATH_HINT_KEY = "hint";
    private static final String PATH_ID_KEY = "id";
    private static final String PATH_INDEX_KEY = "index";
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    private static final String PATH_TAG_KEY = "tag";
    private static final String PATH_TEXT_KEY = "text";
    private final String className;
    private final String description;
    private final String hint;
    private final int id;
    private final int index;
    private final int matchBitmask;
    private final String tag;
    private final String text;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int value;

        MatchBitmaskType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PathComponent(JSONObject component) throws JSONException {
        Intrinsics.checkNotNullParameter(component, "component");
        String string = component.getString(PATH_CLASS_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = component.optInt(PATH_INDEX_KEY, -1);
        this.id = component.optInt("id");
        String strOptString = component.optString("text");
        Intrinsics.checkNotNullExpressionValue(strOptString, "component.optString(PATH_TEXT_KEY)");
        this.text = strOptString;
        String strOptString2 = component.optString("tag");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "component.optString(PATH_TAG_KEY)");
        this.tag = strOptString2;
        String strOptString3 = component.optString("description");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = strOptString3;
        String strOptString4 = component.optString("hint");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "component.optString(PATH_HINT_KEY)");
        this.hint = strOptString4;
        this.matchBitmask = component.optInt(PATH_MATCH_BITMASK_KEY);
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getText() {
        return this.text;
    }
}
