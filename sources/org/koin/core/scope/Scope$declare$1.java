package org.koin.core.scope;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;

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
public final class Scope$declare$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Scope f146073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f146074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Qualifier f146075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f146076d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f146077f;

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() throws DefinitionOverrideException {
        m2208invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2208invoke() throws DefinitionOverrideException {
        InstanceRegistry instanceRegistryE = this.f146073a.l().e();
        final Object obj = this.f146074b;
        Qualifier qualifier = this.f146075c;
        List list = this.f146076d;
        boolean z2 = this.f146077f;
        Qualifier qualifierK = this.f146073a.k();
        String strG = this.f146073a.g();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Function2<Scope, ParametersHolder, Object> function2 = new Function2<Scope, ParametersHolder, Object>() { // from class: org.koin.core.scope.Scope$declare$1$invoke$$inlined$declareScopedInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Scope _createDefinition, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(_createDefinition, "$this$_createDefinition");
                Intrinsics.checkNotNullParameter(it, "it");
                return obj;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(qualifierK, Reflection.b(Object.class), qualifier, function2, kind, list);
        String strA = BeanDefinitionKt.a(beanDefinition.c(), beanDefinition.d(), beanDefinition.e());
        Object obj2 = instanceRegistryE.e().get(strA);
        ScopedInstanceFactory scopedInstanceFactory = obj2 instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) obj2 : null;
        if (scopedInstanceFactory != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            scopedInstanceFactory.g(strG, obj);
            return;
        }
        ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition);
        InstanceRegistry.k(instanceRegistryE, z2, strA, scopedInstanceFactory2, false, 8, null);
        Iterator it = beanDefinition.f().iterator();
        while (it.hasNext()) {
            InstanceRegistry.k(instanceRegistryE, z2, BeanDefinitionKt.a((KClass) it.next(), beanDefinition.d(), beanDefinition.e()), scopedInstanceFactory2, false, 8, null);
        }
    }
}
