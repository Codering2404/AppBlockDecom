package androidx.glance.appwidget.proto;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.appwidget.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LayoutProtoSerializer implements Serializer<LayoutProto.LayoutConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LayoutProtoSerializer f38769a = new LayoutProtoSerializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LayoutProto.LayoutConfig f38770b;

    static {
        LayoutProto.LayoutConfig layoutConfigA0 = LayoutProto.LayoutConfig.a0();
        Intrinsics.checkNotNullExpressionValue(layoutConfigA0, "getDefaultInstance()");
        f38770b = layoutConfigA0;
    }

    private LayoutProtoSerializer() {
    }

    @Override // androidx.datastore.core.Serializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutProto.LayoutConfig getDefaultValue() {
        return f38770b;
    }

    @Override // androidx.datastore.core.Serializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object writeTo(LayoutProto.LayoutConfig layoutConfig, OutputStream outputStream, Continuation continuation) {
        layoutConfig.p(outputStream);
        return Unit.f139807a;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, Continuation continuation) throws CorruptionException {
        try {
            LayoutProto.LayoutConfig layoutConfigD0 = LayoutProto.LayoutConfig.d0(inputStream);
            Intrinsics.checkNotNullExpressionValue(layoutConfigD0, "parseFrom(input)");
            return layoutConfigD0;
        } catch (InvalidProtocolBufferException e3) {
            throw new CorruptionException("Cannot read proto.", e3);
        }
    }
}
