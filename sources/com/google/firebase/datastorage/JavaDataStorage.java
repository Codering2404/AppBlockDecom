package com.google.firebase.datastorage;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class JavaDataStorage {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f89099f = {Reflection.j(new PropertyReference2Impl(JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadLocal f89102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadOnlyProperty f89103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataStore f89104e;

    public JavaDataStorage(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f89100a = context;
        this.f89101b = name;
        this.f89102c = new ThreadLocal();
        this.f89103d = PreferenceDataStoreDelegateKt.b(name, new ReplaceFileCorruptionHandler(new Function1() { // from class: com.google.firebase.datastorage.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JavaDataStorage.e(this.f89128a, (CorruptionException) obj);
            }
        }), new Function1() { // from class: com.google.firebase.datastorage.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JavaDataStorage.f(this.f89129a, (Context) obj);
            }
        }, null, 8, null);
        this.f89104e = i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences e(JavaDataStorage javaDataStorage, CorruptionException ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        Log.w(Reflection.b(JavaDataStorage.class).m(), "CorruptionException in " + javaDataStorage.f89101b + " DataStore running in process " + Process.myPid(), ex);
        return PreferencesFactory.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(JavaDataStorage javaDataStorage, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(SharedPreferencesMigrationKt.b(it, javaDataStorage.f89101b, null, 4, null));
    }

    private final DataStore i(Context context) {
        return (DataStore) this.f89103d.a(context, f89099f[0]);
    }

    public final Preferences g(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return (Preferences) BuildersKt__BuildersKt.b(null, new JavaDataStorage$editSync$1(this, transform, null), 1, null);
    }

    public final Map h() {
        return (Map) BuildersKt__BuildersKt.b(null, new JavaDataStorage$getAllSync$1(this, null), 1, null);
    }

    public final Object j(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        return BuildersKt__BuildersKt.b(null, new JavaDataStorage$getSync$1(this, key, obj, null), 1, null);
    }

    public final Preferences k(Preferences.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (Preferences) BuildersKt__BuildersKt.b(null, new JavaDataStorage$putSync$1(this, key, obj, null), 1, null);
    }
}
