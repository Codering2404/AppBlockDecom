package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.SharedPreferences;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class PrefDelegate<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f126830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f126832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f126833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function2 f126834e;

    public PrefDelegate(Function0 holder, String key, boolean z2, Function0 defaultValue, Function2 function2) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.f126830a = holder;
        this.f126831b = key;
        this.f126832c = z2;
        this.f126833d = defaultValue;
        this.f126834e = function2;
    }

    public final Function0 a() {
        return this.f126833d;
    }

    public final Function0 b() {
        return this.f126830a;
    }

    public final String c() {
        return this.f126831b;
    }

    public final Function2 d() {
        return this.f126834e;
    }

    public final void e(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "<this>");
        if (this.f126832c) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public void f(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        CoroutinesHelperExtKt.d(new PrefDelegate$setValue$1(this, obj2, null));
    }

    public /* synthetic */ PrefDelegate(Function0 function0, String str, boolean z2, Function0 function02, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, z2, function02, (i3 & 16) != 0 ? null : function2);
    }
}
