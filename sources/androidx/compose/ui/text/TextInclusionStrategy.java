package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextInclusionStrategy;
import kotlin.Metadata;

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
public interface TextInclusionStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f28883a = Companion.f28884a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f28884a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final TextInclusionStrategy f28885b = new TextInclusionStrategy() { // from class: androidx.compose.ui.text.a
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean a(Rect rect, Rect rect2) {
                return TextInclusionStrategy.Companion.d(rect, rect2);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final TextInclusionStrategy f28886c = new TextInclusionStrategy() { // from class: androidx.compose.ui.text.b
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean a(Rect rect, Rect rect2) {
                return TextInclusionStrategy.Companion.e(rect, rect2);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final TextInclusionStrategy f28887d = new TextInclusionStrategy() { // from class: androidx.compose.ui.text.c
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean a(Rect rect, Rect rect2) {
                return TextInclusionStrategy.Companion.f(rect, rect2);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(Rect rect, Rect rect2) {
            return rect.z(rect2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean e(Rect rect, Rect rect2) {
            return !rect2.y() && rect.o() >= rect2.o() && rect.p() <= rect2.p() && rect.r() >= rect2.r() && rect.i() <= rect2.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(Rect rect, Rect rect2) {
            return rect2.f(rect.m());
        }

        public final TextInclusionStrategy g() {
            return f28885b;
        }

        public final TextInclusionStrategy h() {
            return f28887d;
        }
    }

    boolean a(Rect rect, Rect rect2);
}
