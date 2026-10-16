package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable(with = CELResultDeserializer.class)
public abstract class CELResult {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CELResult> serializer() {
            return CELResultDeserializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Err extends CELResult {
        public static final Companion Companion = new Companion(null);
        private final String message;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Err> serializer() {
                return CELResult$Err$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Err(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELResult$Err$$serializer.INSTANCE.getDescriptor());
            }
            this.message = str;
        }

        public static /* synthetic */ Err copy$default(Err err, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = err.message;
            }
            return err.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Err copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Err(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Err) && Intrinsics.areEqual(this.message, ((Err) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Err(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Err(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Ok extends CELResult {
        private final PassableValue value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(PassableValue.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Ok> serializer() {
                return CELResult$Ok$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(int i3, PassableValue passableValue, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELResult$Ok$$serializer.INSTANCE.getDescriptor());
            }
            this.value = passableValue;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, PassableValue passableValue, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                passableValue = ok.value;
            }
            return ok.copy(passableValue);
        }

        public final PassableValue component1() {
            return this.value;
        }

        public final Ok copy(PassableValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Ok(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ok) && Intrinsics.areEqual(this.value, ((Ok) obj).value);
        }

        public final PassableValue getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Ok(value=" + this.value + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ok(PassableValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    public /* synthetic */ CELResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CELResult() {
    }
}
