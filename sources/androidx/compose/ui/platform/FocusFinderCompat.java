package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import java.util.Comparator;
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
public final class FocusFinderCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f28050d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f28051e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 f28052f = new ThreadLocal<FocusFinderCompat>() { // from class: androidx.compose.ui.platform.FocusFinderCompat$Companion$FocusFinderThreadLocal$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FocusFinderCompat initialValue() {
            return new FocusFinderCompat();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f28053a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UserSpecifiedFocusComparator f28054b = new UserSpecifiedFocusComparator(new UserSpecifiedFocusComparator.NextFocusGetter() { // from class: androidx.compose.ui.platform.t
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableObjectList f28055c = new MutableObjectList(0, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class UserSpecifiedFocusComparator implements Comparator<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NextFocusGetter f28056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MutableScatterMap f28057b = ScatterMapKt.c();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MutableScatterSet f28058c = ScatterSetKt.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MutableScatterMap f28059d = ScatterMapKt.c();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MutableObjectIntMap f28060f = ObjectIntMapKt.b();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public interface NextFocusGetter {
        }

        public UserSpecifiedFocusComparator(NextFocusGetter nextFocusGetter) {
            this.f28056a = nextFocusGetter;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            if (view == view2) {
                return 0;
            }
            if (view == null) {
                return -1;
            }
            if (view2 == null) {
                return 1;
            }
            View view3 = (View) this.f28059d.e(view);
            View view4 = (View) this.f28059d.e(view2);
            if (view3 == view4 && view3 != null) {
                if (view == view3) {
                    return -1;
                }
                return (view2 == view3 || this.f28057b.e(view) == null) ? 1 : -1;
            }
            if (view3 != null) {
                view = view3;
            }
            if (view4 != null) {
                view2 = view4;
            }
            if (view3 == null && view4 == null) {
                return 0;
            }
            return this.f28060f.c(view) < this.f28060f.c(view2) ? -1 : 1;
        }
    }
}
