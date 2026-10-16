package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import cz.mobilesoft.coreblock.base.activity.BaseFragmentActivityToolbarSurface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class AcademyAnotherCurrentLessonActivity extends BaseFragmentActivityToolbarSurface {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f106191u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f106192v = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f106193t = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, long j3, long j4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AcademyAnotherCurrentLessonActivity.class);
            intent.putExtra("LESSON_ID", TuplesKt.a(Long.valueOf(j3), Long.valueOf(j4)));
            return intent;
        }

        private Companion() {
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        Serializable serializableExtra = getIntent().getSerializableExtra("LESSON_ID");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type kotlin.Pair<kotlin.Long, kotlin.Long>");
        Pair pair = (Pair) serializableExtra;
        return AcademyAnotherCurrentLessonFragment.f106194c.a(((Number) pair.a()).longValue(), ((Number) pair.b()).longValue());
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface
    protected String v0() {
        return "";
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected boolean z0() {
        return this.f106193t;
    }
}
