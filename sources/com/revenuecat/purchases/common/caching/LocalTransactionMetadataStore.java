package com.revenuecat.purchases.common.caching;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class LocalTransactionMetadataStore {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String KEY_PREFIX = "local_transaction_metadata_";
    private final String apiKey;
    private final Json json;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SharedPreferences initializeSharedPreferences(Context context, String apiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.revenuecat.purchases.transaction_metadata." + apiKey, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }

        private Companion() {
        }
    }

    public LocalTransactionMetadataStore(Context context, String apiKey, SharedPreferences sharedPreferences, Json json) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(json, "json");
        this.apiKey = apiKey;
        this.sharedPreferences = sharedPreferences;
        this.json = json;
    }

    private final String getTokenHash(String str) {
        return UtilsKt.sha1(str);
    }

    private final boolean hasCachedData(String str) {
        return this.sharedPreferences.contains(KEY_PREFIX + str);
    }

    public final synchronized void cacheLocalTransactionMetadata(String purchaseToken, LocalTransactionMetadata data) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(data, "data");
        String tokenHash = getTokenHash(purchaseToken);
        if (hasCachedData(tokenHash)) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), YvFRmou.xVMyPmtKK + purchaseToken + ". Skipping cache.");
            }
            return;
        }
        try {
            String str = KEY_PREFIX + tokenHash;
            String strB = this.json.b(LocalTransactionMetadata.Companion.serializer(), data);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            editor.putString(str, strB);
            editor.apply();
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Local transaction metadata cache updated");
            }
        } catch (SerializationException e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to serialize local transaction metadata", e3);
        }
    }

    public final synchronized void clearLocalTransactionMetadata(Set<String> purchaseTokens) {
        try {
            Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
            if (purchaseTokens.isEmpty()) {
                return;
            }
            Set<String> set = purchaseTokens;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(getTokenHash((String) it.next()));
            }
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                String str = KEY_PREFIX + ((String) obj);
                if (this.sharedPreferences.contains(str)) {
                    editor.remove(str);
                    i3++;
                }
            }
            editor.apply();
            if (i3 > 0) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Cleared local transaction metadata for " + i3 + " token(s)");
                }
            } else {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "No transaction metadata found to clear from local cache.");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final List<LocalTransactionMetadata> getAllLocalTransactionMetadata() {
        int i3;
        Set<String> setKeySet = this.sharedPreferences.getAll().keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String it2 = (String) next;
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (StringsKt.U(it2, KEY_PREFIX, false, 2, null)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            String string = this.sharedPreferences.getString(str, null);
            if (string != null) {
                try {
                    arrayList2.add((LocalTransactionMetadata) this.json.d(LocalTransactionMetadata.Companion.serializer(), string));
                } catch (SerializationException e3) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to deserialize transaction metadata for key: " + str, e3);
                    SharedPreferences.Editor editor = this.sharedPreferences.edit();
                    Intrinsics.checkNotNullExpressionValue(editor, "editor");
                    editor.remove(str);
                    editor.apply();
                }
            }
        }
        return arrayList2;
    }

    public final LocalTransactionMetadata getLocalTransactionMetadata(String purchaseToken) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        String str = KEY_PREFIX + getTokenHash(purchaseToken);
        String string = this.sharedPreferences.getString(str, null);
        if (string == null) {
            return null;
        }
        try {
            return (LocalTransactionMetadata) this.json.d(LocalTransactionMetadata.Companion.serializer(), string);
        } catch (SerializationException e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to deserialize local transaction metadata. Clearing cache.", e3);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            editor.remove(str);
            editor.apply();
            return null;
        }
    }

    public /* synthetic */ LocalTransactionMetadataStore(Context context, String str, SharedPreferences sharedPreferences, Json json, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i3 & 4) != 0 ? Companion.initializeSharedPreferences(context, str) : sharedPreferences, (i3 & 8) != 0 ? JsonTools.INSTANCE.getJson() : json);
    }
}
