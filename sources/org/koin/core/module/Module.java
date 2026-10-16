package org.koin.core.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
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
@KoinDslMarker
@Metadata
public final class Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f145948b = KoinPlatformTools.f146106a.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet f145949c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap f145950d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet f145951e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f145952f = new ArrayList();

    public Module(boolean z2) {
        this.f145947a = z2;
    }

    public final HashSet a() {
        return this.f145949c;
    }

    public final List b() {
        return this.f145952f;
    }

    public final HashMap c() {
        return this.f145950d;
    }

    public final HashSet d() {
        return this.f145951e;
    }

    public final boolean e() {
        return this.f145947a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Module.class == obj.getClass() && Intrinsics.areEqual(this.f145948b, ((Module) obj).f145948b);
    }

    public final void f(InstanceFactory instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        BeanDefinition beanDefinitionC = instanceFactory.c();
        h(BeanDefinitionKt.a(beanDefinitionC.c(), beanDefinitionC.d(), beanDefinitionC.e()), instanceFactory);
    }

    public final void g(SingleInstanceFactory instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        this.f145949c.add(instanceFactory);
    }

    public final void h(String mapping, InstanceFactory factory) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f145950d.put(mapping, factory);
    }

    public int hashCode() {
        return this.f145948b.hashCode();
    }
}
