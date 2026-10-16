package androidx.glance.appwidget;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStoreFactory;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.appwidget.proto.LayoutProtoSerializer;
import androidx.glance.state.GlanceStateDefinition;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

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
final class LayoutStateDefinition implements GlanceStateDefinition<LayoutProto.LayoutConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LayoutStateDefinition f38125a = new LayoutStateDefinition();

    private LayoutStateDefinition() {
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public Object a(final Context context, final String str, Continuation continuation) {
        return DataStoreFactory.c(DataStoreFactory.f35538a, LayoutProtoSerializer.f38769a, null, null, null, new Function0<File>() { // from class: androidx.glance.appwidget.LayoutStateDefinition$getDataStore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return DataStoreFile.a(context, str);
            }
        }, 14, null);
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public File b(Context context, String str) {
        return DataStoreFile.a(context, str);
    }
}
