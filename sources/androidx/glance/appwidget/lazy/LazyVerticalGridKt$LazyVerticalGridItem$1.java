package androidx.glance.appwidget.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

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
/* synthetic */ class LazyVerticalGridKt$LazyVerticalGridItem$1 extends FunctionReferenceImpl implements Function0<EmittableLazyVerticalGridListItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LazyVerticalGridKt$LazyVerticalGridItem$1 f38663a = new LazyVerticalGridKt$LazyVerticalGridItem$1();

    LazyVerticalGridKt$LazyVerticalGridItem$1() {
        super(0, EmittableLazyVerticalGridListItem.class, "<init>", "<init>()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final EmittableLazyVerticalGridListItem invoke() {
        return new EmittableLazyVerticalGridListItem();
    }
}
