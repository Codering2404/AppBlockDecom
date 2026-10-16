package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

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
@InternalSerializationApi
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f142845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f142846b;

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor getDescriptor();

    public final KSerializer m() {
        return this.f142845a;
    }

    public final KSerializer n() {
        return this.f142846b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(CompositeDecoder decoder, Map builder, int i3, int i4) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (i4 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, i4 * 2), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL <= 0 || iG > iH) && (iL >= 0 || iH > iG)) {
            return;
        }
        while (true) {
            h(decoder, i3 + iG, builder, false);
            if (iG == iH) {
                return;
            } else {
                iG += iL;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(CompositeDecoder decoder, int i3, Map builder, boolean z2) {
        int iO;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object objC = CompositeDecoder.DefaultImpls.c(decoder, getDescriptor(), i3, this.f142845a, null, 8, null);
        if (z2) {
            iO = decoder.o(getDescriptor());
            if (iO != i3 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i3 + ", returned index for value: " + iO).toString());
            }
        } else {
            iO = i3 + 1;
        }
        int i4 = iO;
        builder.put(objC, (!builder.containsKey(objC) || (this.f142846b.getDescriptor().d() instanceof PrimitiveKind)) ? CompositeDecoder.DefaultImpls.c(decoder, getDescriptor(), i4, this.f142846b, null, 8, null) : decoder.y(getDescriptor(), i4, this.f142846b, MapsKt.getValue(builder, objC)));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderJ = encoder.j(descriptor, iE);
        Iterator itD = d(obj);
        int i3 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i4 = i3 + 1;
            compositeEncoderJ.C(getDescriptor(), i3, m(), key);
            i3 += 2;
            compositeEncoderJ.C(getDescriptor(), i4, n(), value);
        }
        compositeEncoderJ.c(descriptor);
    }

    private MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        super(null);
        this.f142845a = kSerializer;
        this.f142846b = kSerializer2;
    }
}
