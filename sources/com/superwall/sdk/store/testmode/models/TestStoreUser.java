package com.superwall.sdk.store.testmode.models;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
@Serializable
public final class TestStoreUser {
    private final TestStoreUserType type;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {TestStoreUserType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TestStoreUser> serializer() {
            return TestStoreUser$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TestStoreUser(int i3, TestStoreUserType testStoreUserType, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, TestStoreUser$$serializer.INSTANCE.getDescriptor());
        }
        this.type = testStoreUserType;
        this.value = str;
    }

    public static /* synthetic */ TestStoreUser copy$default(TestStoreUser testStoreUser, TestStoreUserType testStoreUserType, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            testStoreUserType = testStoreUser.type;
        }
        if ((i3 & 2) != 0) {
            str = testStoreUser.value;
        }
        return testStoreUser.copy(testStoreUserType, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(TestStoreUser testStoreUser, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], testStoreUser.type);
        compositeEncoder.y(serialDescriptor, 1, testStoreUser.value);
    }

    public final TestStoreUserType component1() {
        return this.type;
    }

    public final String component2() {
        return this.value;
    }

    public final TestStoreUser copy(TestStoreUserType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new TestStoreUser(type, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestStoreUser)) {
            return false;
        }
        TestStoreUser testStoreUser = (TestStoreUser) obj;
        return this.type == testStoreUser.type && Intrinsics.areEqual(this.value, testStoreUser.value);
    }

    public final TestStoreUserType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "TestStoreUser(type=" + this.type + ", value=" + this.value + ")";
    }

    public TestStoreUser(TestStoreUserType type, String value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = type;
        this.value = value;
    }
}
