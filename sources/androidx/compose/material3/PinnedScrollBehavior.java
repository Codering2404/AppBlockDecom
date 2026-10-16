package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
final class PinnedScrollBehavior implements TopAppBarScrollBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TopAppBarState f19131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f19132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimationSpec f19134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DecayAnimationSpec f19135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NestedScrollConnection f19136f;

    /* JADX INFO: renamed from: androidx.compose.material3.PinnedScrollBehavior$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f19137a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public boolean a() {
        return this.f19133c;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public DecayAnimationSpec b() {
        return this.f19135e;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public AnimationSpec c() {
        return this.f19134d;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public NestedScrollConnection d() {
        return this.f19136f;
    }

    public final Function0 e() {
        return this.f19132b;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public TopAppBarState getState() {
        return this.f19131a;
    }
}
