package androidx.compose.material;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BottomSheetScaffoldState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BottomSheetState f12309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SnackbarHostState f12310b;

    public BottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState) {
        this.f12309a = bottomSheetState;
        this.f12310b = snackbarHostState;
    }

    public final BottomSheetState a() {
        return this.f12309a;
    }

    public final SnackbarHostState b() {
        return this.f12310b;
    }
}
