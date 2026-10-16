package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.SharedPreferences;
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
public final class ConvertedIntPref<T> extends PrefDelegate<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PrefConverter f126829f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConvertedIntPref(Function0 holder, PrefConverter converter, String key, boolean z2, Function0 defaultValue, Function2 function2) {
        super(holder, key, z2, defaultValue, function2);
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.f126829f = converter;
    }

    @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefDelegate
    public void f(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        super.f(obj, property, obj2);
        SharedPreferences.Editor editorH = ((PreferencesHolder) b().invoke()).h(c(), ((Number) this.f126829f.getId(obj2)).intValue());
        Intrinsics.checkNotNullExpressionValue(editorH, "putInt(...)");
        e(editorH);
    }

    public /* synthetic */ ConvertedIntPref(Function0 function0, PrefConverter prefConverter, String str, boolean z2, Function0 function02, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, prefConverter, str, (i3 & 8) != 0 ? false : z2, function02, (i3 & 32) != 0 ? null : function2);
    }
}
