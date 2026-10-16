package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
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
public final class InstanceContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f145928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Scope f145929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParametersHolder f145930c;

    public InstanceContext(Logger logger, Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f145928a = logger;
        this.f145929b = scope;
        this.f145930c = parametersHolder;
    }

    public final Logger a() {
        return this.f145928a;
    }

    public final ParametersHolder b() {
        return this.f145930c;
    }

    public final Scope c() {
        return this.f145929b;
    }

    public /* synthetic */ InstanceContext(Logger logger, Scope scope, ParametersHolder parametersHolder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger, scope, (i3 & 4) != 0 ? null : parametersHolder);
    }
}
