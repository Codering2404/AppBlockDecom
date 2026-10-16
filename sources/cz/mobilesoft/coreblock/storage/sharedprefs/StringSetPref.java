package cz.mobilesoft.coreblock.storage.sharedprefs;

import android.content.SharedPreferences;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StringSetPref extends PrefDelegate<Set<? extends String>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringSetPref(Function0 function0, String key, boolean z2, Function0 defaultValue) {
        super(function0, key, z2, defaultValue, null, 16, null);
        Intrinsics.checkNotNullParameter(function0, YgVrd.XPfeA);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
    }

    public Set g(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return ((PreferencesHolder) b().invoke()).f(c(), (Set) a().invoke());
    }

    public void h(Object obj, KProperty property, Set set) {
        Intrinsics.checkNotNullParameter(property, "property");
        super.f(obj, property, set);
        SharedPreferences.Editor editorK = ((PreferencesHolder) b().invoke()).k(c(), set);
        Intrinsics.checkNotNullExpressionValue(editorK, "putStringSet(...)");
        e(editorK);
    }

    public /* synthetic */ StringSetPref(Function0 function0, String str, boolean z2, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? new Function0() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.StringSetPref.1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke() {
                return null;
            }
        } : function02);
    }
}
