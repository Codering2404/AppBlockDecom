package com.revenuecat.purchases.common;

import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public abstract class JsonProvider {
    public static final Companion Companion = new Companion(null);
    private static final Json defaultJson = JsonKt.b(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.JsonProvider$Companion$defaultJson$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JsonBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
            PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.b(BackendEvent.class), null);
            polymorphicModuleBuilder.b(Reflection.b(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.Companion.serializer());
            polymorphicModuleBuilder.b(Reflection.b(BackendEvent.Paywalls.class), BackendEvent.Paywalls.Companion.serializer());
            polymorphicModuleBuilder.a(serializersModuleBuilder);
            Json.k(serializersModuleBuilder.f());
            Json.c("discriminator");
            Json.f(false);
            Json.h(true);
        }
    }, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Json getDefaultJson() {
            return JsonProvider.defaultJson;
        }

        private Companion() {
        }
    }

    public /* synthetic */ JsonProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JsonProvider() {
    }
}
