package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptExposedFunction;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import com.superwall.supercel.HostContext;
import com.superwall.supercel.ResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SuperscriptHostContext implements HostContext {
    public static final ComputedProperties ComputedProperties = new ComputedProperties(null);
    private static final List<String> availableComputedProperties;
    private static final List<String> availableDeviceProperties;
    private final Json json;
    private final CoreDataManager storage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ComputedProperties {
        public /* synthetic */ ComputedProperties(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getAvailableComputedProperties() {
            return SuperscriptHostContext.availableComputedProperties;
        }

        public final List<String> getAvailableDeviceProperties() {
            return SuperscriptHostContext.availableDeviceProperties;
        }

        private ComputedProperties() {
        }
    }

    static {
        EnumEntries<SuperscriptExposedFunction.Names> entries = SuperscriptExposedFunction.Names.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<SuperscriptExposedFunction.Names> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getRawName());
        }
        availableComputedProperties = arrayList;
        availableDeviceProperties = arrayList;
    }

    public SuperscriptHostContext(Json json, CoreDataManager storage) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.json = json;
        this.storage = storage;
    }

    @Override // com.superwall.supercel.HostContext
    public void computedProperty(String name, String args, ResultCallback callback) {
        Object passableValue;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Json json = this.json;
        json.a();
        PassableValue.Companion companion = PassableValue.Companion;
        List list = (List) json.d(new ArrayListSerializer(companion.serializer()), args);
        if (!availableComputedProperties.contains(name)) {
            Json json2 = this.json;
            PassableValue.BoolValue boolValue = new PassableValue.BoolValue(false);
            json2.a();
            callback.onResult(json2.b(companion.serializer(), boolValue));
            return;
        }
        Object objB = BuildersKt__BuildersKt.b(null, new SuperscriptHostContext$computedProperty$res$1(name, list, this, null), 1, null);
        Json json3 = this.json;
        if (objB == null || (passableValue = SuperscriptEvaluatorKt.toPassableValue(objB)) == null) {
            passableValue = PassableValue.NullValue.INSTANCE;
        }
        json3.a();
        callback.onResult(json3.b(companion.serializer(), passableValue));
    }

    @Override // com.superwall.supercel.HostContext
    public void deviceProperty(String name, String args, ResultCallback callback) {
        Object passableValue;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Json json = this.json;
        json.a();
        PassableValue.Companion companion = PassableValue.Companion;
        List list = (List) json.d(new ArrayListSerializer(companion.serializer()), args);
        if (!availableDeviceProperties.contains(name)) {
            Json json2 = this.json;
            PassableValue.BoolValue boolValue = new PassableValue.BoolValue(false);
            json2.a();
            callback.onResult(json2.b(companion.serializer(), boolValue));
            return;
        }
        Object objB = BuildersKt__BuildersKt.b(null, new SuperscriptHostContext$deviceProperty$res$1(name, list, this, null), 1, null);
        Json json3 = this.json;
        if (objB == null || (passableValue = SuperscriptEvaluatorKt.toPassableValue(objB)) == null) {
            passableValue = PassableValue.NullValue.INSTANCE;
        }
        json3.a();
        callback.onResult(json3.b(companion.serializer(), passableValue));
    }
}
