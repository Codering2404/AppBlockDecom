package com.facebook.appevents.aam;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
public final class MetadataRule {
    private static final String FIELD_K = "k";
    private static final String FIELD_K_DELIMITER = ",";
    private static final String FIELD_V = "v";
    private final List<String> keyRules;
    private final String name;
    private final String valRule;
    public static final Companion Companion = new Companion(null);
    private static final Set<MetadataRule> rules = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void constructRules(JSONObject jSONObject) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(key);
                if (jSONObjectOptJSONObject != null) {
                    String k3 = jSONObjectOptJSONObject.optString(MetadataRule.FIELD_K);
                    String v2 = jSONObjectOptJSONObject.optString(MetadataRule.FIELD_V);
                    Intrinsics.checkNotNullExpressionValue(k3, "k");
                    if (k3.length() != 0) {
                        Set setAccess$getRules$cp = MetadataRule.access$getRules$cp();
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        List listV0 = StringsKt.V0(k3, new String[]{MetadataRule.FIELD_K_DELIMITER}, false, 0, 6, null);
                        Intrinsics.checkNotNullExpressionValue(v2, "v");
                        setAccess$getRules$cp.add(new MetadataRule(key, listV0, v2, null));
                    }
                }
            }
        }

        @JvmStatic
        public final Set<String> getEnabledRuleNames() {
            HashSet hashSet = new HashSet();
            Iterator it = MetadataRule.access$getRules$cp().iterator();
            while (it.hasNext()) {
                hashSet.add(((MetadataRule) it.next()).getName());
            }
            return hashSet;
        }

        @JvmStatic
        public final Set<MetadataRule> getRules() {
            return new HashSet(MetadataRule.access$getRules$cp());
        }

        @JvmStatic
        public final void updateRules(String rulesFromServer) {
            Intrinsics.checkNotNullParameter(rulesFromServer, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                constructRules(new JSONObject(rulesFromServer));
            } catch (JSONException unused) {
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ MetadataRule(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    public static final /* synthetic */ Set access$getRules$cp() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @JvmStatic
    public static final Set<String> getEnabledRuleNames() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return Companion.getEnabledRuleNames();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @JvmStatic
    public static final Set<MetadataRule> getRules() {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return null;
        }
        try {
            return Companion.getRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
            return null;
        }
    }

    @JvmStatic
    public static final void updateRules(String str) {
        if (CrashShieldHandler.isObjectCrashing(MetadataRule.class)) {
            return;
        }
        try {
            Companion.updateRules(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataRule.class);
        }
    }

    public final List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }
}
