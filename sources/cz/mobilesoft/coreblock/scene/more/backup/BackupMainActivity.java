package cz.mobilesoft.coreblock.scene.more.backup;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import cz.mobilesoft.coreblock.base.activity.BaseFragmentActivityToolbarSurface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BackupMainActivity extends BaseFragmentActivityToolbarSurface {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Companion f106365v = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f106366w = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f106367t = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.backup.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BackupMainActivity.C0();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f106368u = "";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) BackupMainActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupMainFragment C0() {
        return BackupMainFragment.f106369f.a();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        return (Fragment) this.f106367t.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface
    protected String v0() {
        return this.f106368u;
    }
}
