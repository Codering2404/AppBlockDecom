package org.koin.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.KoinApplicationDslMarker;
import org.koin.mp.KoinPlatformTimeTools;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@KoinApplicationDslMarker
public final class KoinApplication {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f145899c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Koin f145900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f145901b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KoinApplication a() {
            return new KoinApplication(null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ KoinApplication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c(List list) {
        this.f145900a.k(list, this.f145901b);
    }

    public final void a() {
        this.f145900a.a();
    }

    public final Koin b() {
        return this.f145900a;
    }

    public final KoinApplication d(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f145900a.m(logger);
        return this;
    }

    public final KoinApplication e(List modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Logger loggerF = this.f145900a.f();
        Level level = Level.INFO;
        if (!loggerF.c(level)) {
            c(modules);
            return this;
        }
        long jA = KoinPlatformTimeTools.f146105a.a();
        c(modules);
        double dDoubleValue = ((Number) new Pair(Unit.f139807a, Double.valueOf((r0.a() - jA) / 1000000.0d)).f()).doubleValue();
        int iL = this.f145900a.e().l();
        this.f145900a.f().a(level, "loaded " + iL + " definitions in " + dDoubleValue + " ms");
        return this;
    }

    private KoinApplication() {
        this.f145900a = new Koin();
        this.f145901b = true;
    }
}
