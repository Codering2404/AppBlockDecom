package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

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
public final class PolymorphicModuleBuilder<Base> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f143188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f143189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f143190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f143191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f143192e;

    public PolymorphicModuleBuilder(KClass baseClass, KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.f143188a = baseClass;
        this.f143189b = kSerializer;
        this.f143190c = new ArrayList();
    }

    public final void a(SerializersModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        KSerializer kSerializer = this.f143189b;
        if (kSerializer != null) {
            KClass kClass = this.f143188a;
            SerializersModuleBuilder.k(builder, kClass, kClass, kSerializer, false, 8, null);
        }
        for (Pair pair : this.f143190c) {
            KClass kClass2 = (KClass) pair.a();
            KSerializer kSerializer2 = (KSerializer) pair.b();
            KClass kClass3 = this.f143188a;
            Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            Intrinsics.checkNotNull(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.k(builder, kClass3, kClass2, kSerializer2, false, 8, null);
        }
        Function1 function1 = this.f143191d;
        if (function1 != null) {
            builder.i(this.f143188a, function1, false);
        }
        Function1 function12 = this.f143192e;
        if (function12 != null) {
            builder.h(this.f143188a, function12, false);
        }
    }

    public final void b(KClass subclass, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(subclass, "subclass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f143190c.add(TuplesKt.a(subclass, serializer));
    }
}
