package com.superwall.sdk.debug;

import android.net.Uri;
import com.facebook.AccessToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SWDebugManagerLogic {
    public static final SWDebugManagerLogic INSTANCE = new SWDebugManagerLogic();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Parameter {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Parameter[] $VALUES;
        private final String value;
        public static final Parameter TOKEN = new Parameter("TOKEN", 0, AccessToken.TOKEN_KEY);
        public static final Parameter PAYWALL_ID = new Parameter("PAYWALL_ID", 1, "paywall_id");
        public static final Parameter SUPERWALL_DEBUG = new Parameter("SUPERWALL_DEBUG", 2, "superwall_debug");

        private static final /* synthetic */ Parameter[] $values() {
            return new Parameter[]{TOKEN, PAYWALL_ID, SUPERWALL_DEBUG};
        }

        static {
            Parameter[] parameterArr$values = $values();
            $VALUES = parameterArr$values;
            $ENTRIES = EnumEntriesKt.a(parameterArr$values);
        }

        private Parameter(String str, int i3, String str2) {
            this.value = str2;
        }

        public static EnumEntries<Parameter> getEntries() {
            return $ENTRIES;
        }

        public static Parameter valueOf(String str) {
            return (Parameter) Enum.valueOf(Parameter.class, str);
        }

        public static Parameter[] values() {
            return (Parameter[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private SWDebugManagerLogic() {
    }

    public final String getQueryItemValue(Uri uri, Parameter name) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        String query = uri.getQuery();
        if (query == null) {
            return null;
        }
        List listV0 = StringsKt.V0(query, new String[]{"&"}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listV0, 10));
        Iterator it = listV0.iterator();
        while (it.hasNext()) {
            List listV02 = StringsKt.V0((String) it.next(), new String[]{"="}, false, 0, 6, null);
            arrayList.add(new Pair(listV02.get(0), 1 < listV02.size() ? listV02.get(1) : ""));
        }
        return (String) MapsKt.toMap(arrayList).get(name.getValue());
    }
}
