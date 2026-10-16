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
public final class BooleanPref extends PrefDelegate<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BooleanPref(Function0 holder, String key, boolean z2, Function0 defaultValue, Function2 function2) {
        super(holder, key, z2, defaultValue, function2);
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h() {
        return false;
    }

    public Boolean i(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return Boolean.valueOf(((PreferencesHolder) b().invoke()).a(c(), ((Boolean) a().invoke()).booleanValue()));
    }

    public void j(Object obj, KProperty property, boolean z2) {
        Intrinsics.checkNotNullParameter(property, "property");
        super.f(obj, property, Boolean.valueOf(z2));
        SharedPreferences.Editor editorG = ((PreferencesHolder) b().invoke()).g(c(), z2);
        Intrinsics.checkNotNullExpressionValue(editorG, "putBoolean(...)");
        e(editorG);
    }

    public /* synthetic */ BooleanPref(Function0 function0, String str, boolean z2, Function0 function02, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(BooleanPref.h());
            }
        } : function02, (i3 & 16) != 0 ? null : function2);
    }
}
