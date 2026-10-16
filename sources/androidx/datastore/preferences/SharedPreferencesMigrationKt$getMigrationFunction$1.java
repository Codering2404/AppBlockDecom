package androidx.datastore.preferences;

import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends SuspendLambda implements Function3<SharedPreferencesView, Preferences, Continuation<? super Preferences>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f35932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f35933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f35934c;

    SharedPreferencesMigrationKt$getMigrationFunction$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SharedPreferencesView sharedPreferencesView, Preferences preferences, Continuation continuation) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(continuation);
        sharedPreferencesMigrationKt$getMigrationFunction$1.f35933b = sharedPreferencesView;
        sharedPreferencesMigrationKt$getMigrationFunction$1.f35934c = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f35932a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.f35933b;
        Preferences preferences = (Preferences) this.f35934c;
        Set setKeySet = preferences.a().keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Preferences.Key) it.next()).a());
        }
        Map mapA = sharedPreferencesView.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapA.entrySet()) {
            if (!arrayList.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        MutablePreferences mutablePreferencesD = preferences.d();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Boolean) {
                mutablePreferencesD.k(PreferencesKeys.a(str), value);
            } else if (value instanceof Float) {
                mutablePreferencesD.k(PreferencesKeys.d(str), value);
            } else if (value instanceof Integer) {
                mutablePreferencesD.k(PreferencesKeys.e(str), value);
            } else if (value instanceof Long) {
                mutablePreferencesD.k(PreferencesKeys.f(str), value);
            } else if (value instanceof String) {
                mutablePreferencesD.k(PreferencesKeys.g(str), value);
            } else if (value instanceof Set) {
                Preferences.Key keyH = PreferencesKeys.h(str);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                mutablePreferencesD.k(keyH, (Set) value);
            }
        }
        return mutablePreferencesD.e();
    }
}
