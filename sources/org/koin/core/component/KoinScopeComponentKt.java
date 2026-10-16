package org.koin.core.component;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

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
public final class KoinScopeComponentKt {
    public static final Scope a(KoinScopeComponent koinScopeComponent, Object obj) {
        Intrinsics.checkNotNullParameter(koinScopeComponent, "<this>");
        return koinScopeComponent.r0().b(c(koinScopeComponent), d(koinScopeComponent), obj);
    }

    public static /* synthetic */ Scope b(KoinScopeComponent koinScopeComponent, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        return a(koinScopeComponent, obj);
    }

    public static final String c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return KClassExtKt.a(Reflection.b(obj.getClass())) + '@' + obj.hashCode();
    }

    public static final TypeQualifier d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return new TypeQualifier(Reflection.b(obj.getClass()));
    }

    public static final Scope e(KoinScopeComponent koinScopeComponent) {
        Intrinsics.checkNotNullParameter(koinScopeComponent, "<this>");
        return koinScopeComponent.r0().i(c(koinScopeComponent));
    }
}
