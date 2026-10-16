package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.mp.KoinPlatformTools;

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
public abstract class InstanceFactory<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f145931b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BeanDefinition f145932a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public InstanceFactory(BeanDefinition beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.f145932a = beanDefinition;
    }

    public Object a(InstanceContext context) throws InstanceCreationException {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger loggerA = context.a();
        String str = "| (+) '" + this.f145932a + '\'';
        Level level = Level.DEBUG;
        if (loggerA.c(level)) {
            loggerA.a(level, str);
        }
        try {
            ParametersHolder parametersHolderB = context.b();
            if (parametersHolderB == null) {
                parametersHolderB = ParametersHolderKt.a();
            }
            return this.f145932a.b().invoke(context.c(), parametersHolderB);
        } catch (Exception e3) {
            String strF = KoinPlatformTools.f146106a.f(e3);
            Logger loggerA2 = context.a();
            String str2 = "* Instance creation error : could not create instance for '" + this.f145932a + "': " + strF;
            Level level2 = Level.f145942d;
            if (loggerA2.c(level2)) {
                loggerA2.a(level2, str2);
            }
            throw new InstanceCreationException("Could not create instance for '" + this.f145932a + '\'', e3);
        }
    }

    public abstract Object b(InstanceContext instanceContext);

    public final BeanDefinition c() {
        return this.f145932a;
    }

    public boolean equals(Object obj) {
        InstanceFactory instanceFactory = obj instanceof InstanceFactory ? (InstanceFactory) obj : null;
        return Intrinsics.areEqual(this.f145932a, instanceFactory != null ? instanceFactory.f145932a : null);
    }

    public int hashCode() {
        return this.f145932a.hashCode();
    }
}
