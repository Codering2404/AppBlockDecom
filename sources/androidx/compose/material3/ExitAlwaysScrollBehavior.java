package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ExitAlwaysScrollBehavior implements BottomAppBarScrollBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BottomAppBarState f17530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimationSpec f17531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DecayAnimationSpec f17532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f17533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f17534e;

    /* JADX INFO: renamed from: androidx.compose.material3.ExitAlwaysScrollBehavior$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f17535a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    @Override // androidx.compose.material3.BottomAppBarScrollBehavior
    public boolean a() {
        return this.f17534e;
    }

    @Override // androidx.compose.material3.BottomAppBarScrollBehavior
    public DecayAnimationSpec b() {
        return this.f17532c;
    }

    @Override // androidx.compose.material3.BottomAppBarScrollBehavior
    public AnimationSpec c() {
        return this.f17531b;
    }

    public final Function0 d() {
        return this.f17533d;
    }

    @Override // androidx.compose.material3.BottomAppBarScrollBehavior
    public BottomAppBarState getState() {
        return this.f17530a;
    }
}
