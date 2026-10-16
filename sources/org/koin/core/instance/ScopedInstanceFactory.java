package org.koin.core.instance;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

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
public final class ScopedInstanceFactory<T> extends InstanceFactory<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f145933c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopedInstanceFactory(BeanDefinition beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.f145933c = new HashMap();
    }

    @Override // org.koin.core.instance.InstanceFactory
    public Object a(InstanceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f145933c.get(context.c().g()) == null) {
            return super.a(context);
        }
        Object obj = this.f145933c.get(context.c().g());
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Scoped instance not found for " + context.c().g() + " in " + c()).toString());
    }

    @Override // org.koin.core.instance.InstanceFactory
    public Object b(final InstanceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Intrinsics.areEqual(context.c().k(), c().e())) {
            throw new IllegalStateException(("Wrong Scope: trying to open instance for " + context.c().g() + " in " + c()).toString());
        }
        KoinPlatformTools.f146106a.h(this, new Function0<Unit>() { // from class: org.koin.core.instance.ScopedInstanceFactory$get$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2205invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2205invoke() {
                if (this.f145934a.f(context)) {
                    return;
                }
                this.f145934a.f145933c.put(context.c().g(), this.f145934a.a(context));
            }
        });
        Object obj = this.f145933c.get(context.c().g());
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Scoped instance not found for " + context.c().g() + " in " + c()).toString());
    }

    public void e(Scope scope) {
        if (scope != null) {
            Function1 function1A = c().a().a();
            if (function1A != null) {
                function1A.invoke(this.f145933c.get(scope.g()));
            }
            this.f145933c.remove(scope.g());
        }
    }

    public boolean f(InstanceContext instanceContext) {
        Scope scopeC;
        return this.f145933c.get((instanceContext == null || (scopeC = instanceContext.c()) == null) ? null : scopeC.g()) != null;
    }

    public final void g(String scopeID, Object instance) {
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.f145933c.put(scopeID, instance);
    }
}
