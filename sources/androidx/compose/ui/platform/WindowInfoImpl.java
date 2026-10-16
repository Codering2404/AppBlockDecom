package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class WindowInfoImpl implements WindowInfo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f28271c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final MutableState f28272d = SnapshotStateKt__SnapshotStateKt.e(PointerKeyboardModifiers.a(PointerEvent_androidKt.a()), null, 2, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f28273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f28274b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MutableState a() {
            return WindowInfoImpl.f28272d;
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public long a() {
        return ((IntSize) this.f28273a.getValue()).j();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean b() {
        return ((Boolean) this.f28274b.getValue()).booleanValue();
    }
}
