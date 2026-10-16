package org.koin.core.definition;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.qualifier.Qualifier;

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
public final class BeanDefinition<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Qualifier f145910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KClass f145911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Qualifier f145912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f145913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Kind f145914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f145915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Callbacks f145916g;

    public BeanDefinition(Qualifier scopeQualifier, KClass primaryType, Qualifier qualifier, Function2 definition, Kind kind, List secondaryTypes) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(primaryType, "primaryType");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        this.f145910a = scopeQualifier;
        this.f145911b = primaryType;
        this.f145912c = qualifier;
        this.f145913d = definition;
        this.f145914e = kind;
        this.f145915f = secondaryTypes;
        this.f145916g = new Callbacks(null, 1, null);
    }

    public final Callbacks a() {
        return this.f145916g;
    }

    public final Function2 b() {
        return this.f145913d;
    }

    public final KClass c() {
        return this.f145911b;
    }

    public final Qualifier d() {
        return this.f145912c;
    }

    public final Qualifier e() {
        return this.f145910a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        BeanDefinition beanDefinition = (BeanDefinition) obj;
        return Intrinsics.areEqual(this.f145911b, beanDefinition.f145911b) && Intrinsics.areEqual(this.f145912c, beanDefinition.f145912c) && Intrinsics.areEqual(this.f145910a, beanDefinition.f145910a);
    }

    public final List f() {
        return this.f145915f;
    }

    public final void g(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f145915f = list;
    }

    public int hashCode() {
        Qualifier qualifier = this.f145912c;
        return ((((qualifier != null ? qualifier.hashCode() : 0) * 31) + this.f145911b.hashCode()) * 31) + this.f145910a.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r14 = this;
            org.koin.core.definition.Kind r0 = r14.f145914e
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 39
            r1.append(r2)
            kotlin.reflect.KClass r3 = r14.f145911b
            java.lang.String r3 = org.koin.ext.KClassExtKt.a(r3)
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            org.koin.core.qualifier.Qualifier r2 = r14.f145912c
            java.lang.String r3 = ""
            if (r2 == 0) goto L3b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = ",qualifier:"
            r2.append(r4)
            org.koin.core.qualifier.Qualifier r4 = r14.f145912c
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L3c
        L3b:
            r2 = r3
        L3c:
            org.koin.core.qualifier.Qualifier r4 = r14.f145910a
            org.koin.core.registry.ScopeRegistry$Companion r5 = org.koin.core.registry.ScopeRegistry.f146057e
            org.koin.core.qualifier.StringQualifier r5 = r5.a()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L4c
            r4 = r3
            goto L5f
        L4c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ",scope:"
            r4.append(r5)
            org.koin.core.qualifier.Qualifier r5 = r14.f145910a
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L5f:
            java.util.List r5 = r14.f145915f
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L8f
            java.util.List r3 = r14.f145915f
            r5 = r3
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r11 = new kotlin.jvm.functions.Function1<kotlin.reflect.KClass<?>, java.lang.CharSequence>() { // from class: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                static {
                    /*
                        org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r0 = new org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1) org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.a org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final java.lang.CharSequence invoke(kotlin.reflect.KClass r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        java.lang.String r2 = org.koin.ext.KClassExtKt.a(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(kotlin.reflect.KClass):java.lang.CharSequence");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        kotlin.reflect.KClass r1 = (kotlin.reflect.KClass) r1
                        java.lang.CharSequence r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r12 = 30
            r13 = 0
            r6 = 0
            java.lang.String r6 = androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN.pnUyBAwHKVU
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r3 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ",binds:"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
        L8f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 91
            r5.append(r6)
            r5.append(r0)
            r0 = 58
            r5.append(r0)
            r5.append(r1)
            r5.append(r2)
            r5.append(r4)
            r5.append(r3)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.toString():java.lang.String");
    }
}
