package org.koin.androidx.fragment.android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
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
public final class KoinFragmentFactory extends FragmentFactory implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Scope f145663b;

    public KoinFragmentFactory(Scope scope) {
        this.f145663b = scope;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment a(ClassLoader classLoader, String className) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        Class<?> cls = Class.forName(className);
        Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
        KClass kClassC = JvmClassMappingKt.c(cls);
        Scope scope = this.f145663b;
        Fragment fragment = scope != null ? (Fragment) Scope.j(scope, kClassC, null, null, 6, null) : (Fragment) Koin.h(r0(), kClassC, null, null, 6, null);
        if (fragment != null) {
            return fragment;
        }
        Fragment fragmentA = super.a(classLoader, className);
        Intrinsics.checkNotNullExpressionValue(fragmentA, "super.instantiate(classLoader, className)");
        return fragmentA;
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public /* synthetic */ KoinFragmentFactory(Scope scope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : scope);
    }
}
