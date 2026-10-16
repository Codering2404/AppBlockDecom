package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SavedStateRegistryOwnerDelegate<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistry f53065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f53066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f53067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SavedStateConfiguration f53068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function0 f53069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f53070f;

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
        Bundle bundleA = this.f53065a.a(str);
        if (bundleA != null) {
            return SavedStateDecoderKt.a(this.f53066b, bundleA, this.f53068d);
        }
        return null;
    }

    private final void f(String str) {
        this.f53065a.c(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.savedstate.serialization.b
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return SavedStateRegistryOwnerDelegate.g(this.f53071a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle g(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        KSerializer kSerializer = savedStateRegistryOwnerDelegate.f53066b;
        Object obj = savedStateRegistryOwnerDelegate.f53070f;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            obj = Unit.f139807a;
        }
        return SavedStateEncoderKt.a(kSerializer, obj, savedStateRegistryOwnerDelegate.f53068d);
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void b(Object obj, KProperty property, Object value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.f53070f == null) {
            String strD = this.f53067c;
            if (strD == null) {
                strD = d(obj, property);
            }
            f(strD);
        }
        this.f53070f = value;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object a(Object obj, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, SbbqvQlxi.QJWDSweAos);
        if (this.f53070f == null) {
            String strD = this.f53067c;
            if (strD == null) {
                strD = d(obj, kProperty);
            }
            f(strD);
            Object objE = e(strD);
            if (objE == null) {
                objE = this.f53069e.invoke();
            }
            this.f53070f = objE;
        }
        Object obj2 = this.f53070f;
        if (obj2 != null) {
            return obj2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return Unit.f139807a;
    }
}
