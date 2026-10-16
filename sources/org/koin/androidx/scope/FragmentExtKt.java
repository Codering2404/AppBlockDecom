package org.koin.androidx.scope;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

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
public final class FragmentExtKt {
    public static final Scope a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (!(fragment instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Fragment should implement AndroidScopeComponent");
        }
        Scope scopeI = ComponentCallbackExtKt.a(fragment).i(KoinScopeComponentKt.c(fragment));
        if (scopeI == null) {
            scopeI = ComponentActivityExtKt.c(fragment, fragment);
        }
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Scope scopeD = ComponentActivityExtKt.d(fragmentActivityRequireActivity);
        if (scopeD != null) {
            scopeI.o(scopeD);
            return scopeI;
        }
        Logger loggerH = scopeI.h();
        String str = "Fragment '" + fragment + "' can't be linked to parent activity scope";
        Level level = Level.DEBUG;
        if (loggerH.c(level)) {
            loggerH.a(level, str);
        }
        return scopeI;
    }

    public static final Lazy b(final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return LazyKt.b(new Function0<Scope>() { // from class: org.koin.androidx.scope.FragmentExtKt$fragmentScope$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Scope invoke() {
                return FragmentExtKt.a(fragment);
            }
        });
    }
}
