package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

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
public abstract class ContextualProvider {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Argless extends ContextualProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KSerializer f143186a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Argless(KSerializer serializer) {
            super(null);
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            this.f143186a = serializer;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer a(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f143186a;
        }

        public final KSerializer b() {
            return this.f143186a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Argless) && Intrinsics.areEqual(((Argless) obj).f143186a, this.f143186a);
        }

        public int hashCode() {
            return this.f143186a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WithTypeArguments extends ContextualProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f143187a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithTypeArguments(Function1 provider) {
            super(null);
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.f143187a = provider;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer a(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (KSerializer) this.f143187a.invoke(typeArgumentsSerializers);
        }

        public final Function1 b() {
            return this.f143187a;
        }
    }

    public /* synthetic */ ContextualProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract KSerializer a(List list);

    private ContextualProvider() {
    }
}
