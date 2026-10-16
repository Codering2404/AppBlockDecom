package org.koin.androidx.viewmodel.parameter;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class AndroidParametersHolder extends ParametersHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CreationExtras f145880c;

    /* JADX WARN: Illegal instructions before constructor call */
    public AndroidParametersHolder(Function0 function0, CreationExtras extras) {
        ParametersHolder parametersHolder;
        List listD;
        List mutableList;
        Intrinsics.checkNotNullParameter(extras, "extras");
        super((function0 == null || (parametersHolder = (ParametersHolder) function0.invoke()) == null || (listD = parametersHolder.d()) == null || (mutableList = CollectionsKt.toMutableList((Collection) listD)) == null) ? new ArrayList() : mutableList);
        this.f145880c = extras;
    }

    private final Object g(KClass kClass, Function0 function0) {
        return Intrinsics.areEqual(kClass, Reflection.b(SavedStateHandle.class)) ? SavedStateHandleSupport.a(this.f145880c) : function0.invoke();
    }

    @Override // org.koin.core.parameter.ParametersHolder
    public Object b(final int i3, final KClass clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return g(clazz, new Function0<Object>() { // from class: org.koin.androidx.viewmodel.parameter.AndroidParametersHolder$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return super/*org.koin.core.parameter.ParametersHolder*/.b(i3, clazz);
            }
        });
    }

    @Override // org.koin.core.parameter.ParametersHolder
    public Object c(final KClass clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return g(clazz, new Function0<Object>() { // from class: org.koin.androidx.viewmodel.parameter.AndroidParametersHolder$getOrNull$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return super/*org.koin.core.parameter.ParametersHolder*/.c(clazz);
            }
        });
    }
}
