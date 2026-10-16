package androidx.lifecycle.serialization;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;

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
final class SavedStateHandleDelegate<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateHandle f40221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f40222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SavedStateConfiguration f40224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function0 f40225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f40226f;

    private final String d(Object obj, KProperty kProperty) {
        String str;
        if (obj != null) {
            str = Reflection.b(obj.getClass()).h() + '.';
        } else {
            str = "";
        }
        return str + kProperty.getName();
    }

    private final Object e(String str) {
        Bundle bundle = (Bundle) this.f40221a.c(str);
        if (bundle != null) {
            return SavedStateDecoderKt.a(this.f40222b, bundle, this.f40224d);
        }
        return null;
    }

    private final void f(String str) {
        this.f40221a.f(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.serialization.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return SavedStateHandleDelegate.g(this.f40227a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle g(SavedStateHandleDelegate savedStateHandleDelegate) {
        KSerializer kSerializer = savedStateHandleDelegate.f40222b;
        Object obj = savedStateHandleDelegate.f40226f;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            obj = Unit.f139807a;
        }
        return SavedStateEncoderKt.a(kSerializer, obj, savedStateHandleDelegate.f40224d);
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.f40226f == null) {
            String strD = this.f40223c;
            if (strD == null) {
                strD = d(obj, property);
            }
            f(strD);
            Object objE = e(strD);
            if (objE == null) {
                objE = this.f40225e.invoke();
            }
            this.f40226f = objE;
        }
        Object obj2 = this.f40226f;
        if (obj2 != null) {
            return obj2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return Unit.f139807a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void b(Object obj, KProperty property, Object value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.f40226f == null) {
            String strD = this.f40223c;
            if (strD == null) {
                strD = d(obj, property);
            }
            f(strD);
        }
        this.f40226f = value;
    }
}
